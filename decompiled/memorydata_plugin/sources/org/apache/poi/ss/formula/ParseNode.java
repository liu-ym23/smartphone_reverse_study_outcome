package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
final class ParseNode {
    public static final ParseNode[] EMPTY_ARRAY = null;
    private final ParseNode[] _children;
    private final boolean _isIf;
    private final Ptg _token;
    private final int _tokenCount;

    private static final class TokenCollector {
        private int _offset;
        private final Ptg[] _ptgs;

        public TokenCollector(int r1) {
            this._ptgs = new Ptg[r1];
            this._offset = 0;
        }

        public void add(Ptg r3) {
            if (r3 == null) goto L6;
            Ptg[] r0 = this._ptgs;
            int r1 = this._offset;
            r0[r1] = r3;
            this._offset = r1 + 1;
            return;
        L6:
            throw new IllegalArgumentException("token must not be null");
        }

        public int createPlaceholder() {
            int r0 = this._offset;
            this._offset = r0 + 1;
            return r0;
        }

        public Ptg[] getResult() {
            return this._ptgs;
        }

        public void setPlaceholder(int r2, Ptg r3) {
            Ptg[] r1 = this._ptgs;
            if (r1[r2] != null) goto L7;
            r1[r2] = r3;
            return;
        L7:
            throw new IllegalStateException("Invalid placeholder index (" + r2 + ")");
        }

        public int sumTokenSizes(int r3, int r4) {
            int r0 = 0;
        L3:
            if (r3 >= r4) goto L5;
            r0 = r0 + this._ptgs[r3].getSize();
            r3 = r3 + 1;
            goto L3
        L5:
            return r0;
        }
    }

    static {
        EMPTY_ARRAY = new ParseNode[0];
    }

    public ParseNode(Ptg r2) {
        this(r2, EMPTY_ARRAY);
    }

    public ParseNode(Ptg r3, ParseNode r4) {
        this(r3, new ParseNode[]{r4});
    }

    public ParseNode(Ptg r3, ParseNode r4, ParseNode r5) {
        this(r3, new ParseNode[]{r4, r5});
    }

    public ParseNode(Ptg r4, ParseNode[] r5) {
        if (r4 == null) goto L13;
        this._token = r4;
        this._children = (ParseNode[]) ZeusTransformUtils.preCheckCast(r5.clone(), ParseNode[].class, "com.obric.memorydata.plugin");
        this._isIf = isIf(r4);
        int r6 = r5.length;
        int r0 = 0;
        int r1 = 1;
    L5:
        if (r0 >= r6) goto L8;
        r1 = r1 + r5[r0].getTokenCount();
        r0 = r0 + 1;
        goto L5
    L8:
        if (this._isIf == false) goto L10;
        r1 = r1 + r5.length;
    L10:
        this._tokenCount = r1;
        return;
    L13:
        throw new IllegalArgumentException("token must not be null");
    }

    private void collectIfPtgs(TokenCollector r8) {
        getChildren()[0].collectPtgs(r8);
        int r0 = r8.createPlaceholder();
        getChildren()[1].collectPtgs(r8);
        int r1 = r8.createPlaceholder();
        AttrPtg r3 = AttrPtg.createIf(r8.sumTokenSizes(r0 + 1, r1) + 4);
        if (getChildren().length <= 2) goto L5;
        getChildren()[2].collectPtgs(r8);
        int r4 = r8.createPlaceholder();
        AttrPtg r2 = AttrPtg.createSkip(((r8.sumTokenSizes(r1 + 1, r4) + 4) + 4) - 1);
        AttrPtg r5 = AttrPtg.createSkip(3);
        r8.setPlaceholder(r0, r3);
        r8.setPlaceholder(r1, r2);
        r8.setPlaceholder(r4, r5);
    L6:
        r8.add(this._token);
        return;
    L5:
        AttrPtg r6 = AttrPtg.createSkip(3);
        r8.setPlaceholder(r0, r3);
        r8.setPlaceholder(r1, r6);
        goto L6
    }

    private void collectPtgs(TokenCollector r4) {
        if (isIf(this._token) == false) goto L6;
        collectIfPtgs(r4);
        return;
    L6:
        int r1 = 0;
        if (ZeusTransformUtils.instanceOf(this._token, MemFuncPtg.class) == false) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L16;
        r4.add(this._token);
    L16:
        if (r1 >= getChildren().length) goto L18;
        getChildren()[r1].collectPtgs(r4);
        r1 = r1 + 1;
        goto L16
    L18:
        if (r0 == true) goto L23;
        r4.add(this._token);
        return;
    L23:
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this._token, MemAreaPtg.class) == true) goto L12;
        r0 = false;
        goto L13
    }

    private int getTokenCount() {
        return this._tokenCount;
    }

    private static boolean isIf(Ptg r2) {
        if (ZeusTransformUtils.instanceOf(r2, FuncVarPtg.class) == true) goto L5;
        return false;
    L5:
        return "IF".equals(((FuncVarPtg) ZeusTransformUtils.preCheckCast(r2, FuncVarPtg.class, "com.obric.memorydata.plugin")).getName());
    }

    public static Ptg[] toTokenArray(ParseNode r2) {
        TokenCollector r0 = new TokenCollector(r2.getTokenCount());
        r2.collectPtgs(r0);
        return r0.getResult();
    }

    public ParseNode[] getChildren() {
        return this._children;
    }

    public int getEncodedSize() {
        if (ZeusTransformUtils.instanceOf(this._token, ArrayPtg.class) == false) goto L5;
        int r0 = 8;
    L6:
        ParseNode[] r4 = this._children;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0 = r0 + r4[r2].getEncodedSize();
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    L5:
        r0 = this._token.getSize();
        goto L6
    }

    public Ptg getToken() {
        return this._token;
    }
}
