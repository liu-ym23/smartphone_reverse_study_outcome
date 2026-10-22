package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TokenRewriteStream extends CommonTokenStream {
    public static final String DEFAULT_PROGRAM_NAME = "default";
    public static final int MIN_TOKEN_INDEX = 0;
    public static final int PROGRAM_INIT_SIZE = 100;
    protected Map<String, Integer> lastRewriteTokenIndexes;
    protected Map<String, List<RewriteOperation>> programs;

    public class InsertBeforeOp extends RewriteOperation {
        final /* synthetic */ TokenRewriteStream this$0;

        public InsertBeforeOp(TokenRewriteStream r5, int r10, Object r11) {
            this.this$0 = r5;
            super(r5, r10, r11);
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.TokenRewriteStream.RewriteOperation
        public int execute(StringBuffer r5) {
            r5.append(this.text);
            if (this.this$0.tokens.get(this.index).getType() == (-1)) goto L6;
            r5.append(this.this$0.tokens.get(this.index).getText());
        L6:
            return this.index + 1;
        }
    }

    public class ReplaceOp extends RewriteOperation {
        protected int lastIndex;
        final /* synthetic */ TokenRewriteStream this$0;

        public ReplaceOp(TokenRewriteStream r5, int r10, int r11, Object r12) {
            this.this$0 = r5;
            super(r5, r10, r12);
            this.lastIndex = r11;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.TokenRewriteStream.RewriteOperation
        public int execute(StringBuffer r5) {
            Object r10 = this.text;
            if (r10 == null) goto L6;
            r5.append(r10);
        L6:
            return this.lastIndex + 1;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.TokenRewriteStream.RewriteOperation
        public String toString() {
            if (this.text != null) goto L7;
            return "<DeleteOp@" + this.this$0.tokens.get(this.index) + ".." + this.this$0.tokens.get(this.lastIndex) + ">";
        L7:
            return "<ReplaceOp@" + this.this$0.tokens.get(this.index) + ".." + this.this$0.tokens.get(this.lastIndex) + ":\"" + this.text + "\">";
        }
    }

    public class RewriteOperation {
        protected int index;
        protected int instructionIndex;
        protected Object text;
        final /* synthetic */ TokenRewriteStream this$0;

        public RewriteOperation(TokenRewriteStream r5, int r10) {
            this.this$0 = r5;
            this.index = r10;
        }

        public int execute(StringBuffer r5) {
            return this.index;
        }

        public String toString() {
            String r5 = getClass().getName();
            StringBuilder r10 = j0.x("<", r5.substring(r5.indexOf(36) + 1, r5.length()), "@");
            r10.append(this.this$0.tokens.get(this.index));
            r10.append(":\"");
            r10.append(this.text);
            r10.append("\">");
            return r10.toString();
        }

        public RewriteOperation(TokenRewriteStream r5, int r10, Object r11) {
            this.this$0 = r5;
            this.index = r10;
            this.text = r11;
        }
    }

    public TokenRewriteStream() {
        this.programs = null;
        this.lastRewriteTokenIndexes = null;
        init();
    }

    private List<RewriteOperation> initializeProgram(String r5) {
        ArrayList r10 = new ArrayList(100);
        this.programs.put(r5, r10);
        return r10;
    }

    public String catOpText(Object r5, Object r10) {
        String r11 = "";
        if (r5 == null) goto L5;
        String r12 = r5.toString();
    L6:
        if (r10 == null) goto L9;
        r11 = r10.toString();
    L9:
        return j0.j(r12, r11);
    L5:
        r12 = "";
        goto L6
    }

    public void delete(int r5) {
        delete("default", r5, r5);
    }

    public void deleteProgram() {
        deleteProgram("default");
    }

    public <T extends RewriteOperation> List<? extends T> getKindOfOps(List<? extends RewriteOperation> r5, Class<T> r10) {
        return getKindOfOps(r5, r10, r5.size());
    }

    public int getLastRewriteTokenIndex() {
        return getLastRewriteTokenIndex("default");
    }

    public List<RewriteOperation> getProgram(String r5) {
        List<RewriteOperation> r10 = this.programs.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return initializeProgram(r5);
    }

    public void init() {
        HashMap r5 = new HashMap();
        this.programs = r5;
        r5.put("default", new ArrayList(100));
        this.lastRewriteTokenIndexes = new HashMap();
    }

    public void insertAfter(Token r5, Object r10) {
        insertAfter("default", r5, r10);
    }

    public void insertBefore(Token r5, Object r10) {
        insertBefore("default", r5, r10);
    }

    public Map<Integer, ? extends RewriteOperation> reduceToSingleOperationPerIndex(List<? extends RewriteOperation> r13) {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= r13.size()) goto L59;
        RewriteOperation r11 = r13.get(r10);
        if (r11 == null) goto L58;
        if ((r11 instanceof ReplaceOp) == false) goto L58;
        ReplaceOp r12 = (ReplaceOp) r13.get(r10);
        List r14 = getKindOfOps(r13, InsertBeforeOp.class, r10);
        int r15 = 0;
    L13:
        if (r15 >= r14.size()) goto L26;
        InsertBeforeOp r16 = (InsertBeforeOp) r14.get(r15);
        int r17 = r16.index;
        int r18 = r12.index;
        if (r17 != r18) goto L21;
        r13.set(r16.instructionIndex, null);
        StringBuilder r19 = new StringBuilder();
        r19.append(r16.text.toString());
        Object r20 = r12.text;
        if (r20 == null) goto L19;
        String r21 = r20.toString();
    L20:
        r19.append(r21);
        r12.text = r19.toString();
    L25:
        r15 = r15 + 1;
        goto L13
    L19:
        r21 = "";
        goto L20
    L21:
        if (r17 <= r18) goto L25;
        if (r17 > r12.lastIndex) goto L25;
        r13.set(r16.instructionIndex, null);
        goto L25
    L26:
        List r22 = getKindOfOps(r13, ReplaceOp.class, r10);
        int r23 = 0;
    L28:
        if (r23 >= r22.size()) goto L58;
        ReplaceOp r24 = (ReplaceOp) r22.get(r23);
        int r25 = r24.index;
        int r26 = r12.index;
        if (r25 >= r26) goto L32;
    L34:
        int r27 = r24.lastIndex;
        boolean r110 = true;
        if (r27 >= r26) goto L37;
    L40:
        boolean r111 = true;
    L41:
        if (r25 == r26) goto L43;
    L45:
        r110 = false;
    L47:
        if (r24.text == null) goto L49;
    L52:
        if (r111 == true) goto L57;
        if (r110 == true) goto L57;
        throw new IllegalArgumentException("replace op boundaries of " + r12 + " overlap with previous " + r24);
    L57:
        r23 = r23 + 1;
        goto L28
    L49:
        if (r12.text != null) goto L52;
        if (r111 == true) goto L52;
        r13.set(r24.instructionIndex, null);
        r12.index = Math.min(r24.index, r12.index);
        r12.lastIndex = Math.max(r24.lastIndex, r12.lastIndex);
        System.out.println("new rop " + r12);
        goto L57
    L43:
        if (r27 != r12.lastIndex) goto L45;
    L37:
        if (r25 > r12.lastIndex) goto L40;
        r111 = false;
        goto L41
    L32:
        if (r24.lastIndex > r12.lastIndex) goto L34;
        r13.set(r24.instructionIndex, null);
    L58:
        r10 = r10 + 1;
        goto L4
    L59:
        int r28 = 0;
    L61:
        if (r28 >= r13.size()) goto L89;
        RewriteOperation r29 = r13.get(r28);
        if (r29 == null) goto L88;
        if ((r29 instanceof InsertBeforeOp) == false) goto L88;
        InsertBeforeOp r30 = (InsertBeforeOp) r13.get(r28);
        List r31 = getKindOfOps(r13, InsertBeforeOp.class, r28);
        int r32 = 0;
    L70:
        if (r32 >= r31.size()) goto L75;
        InsertBeforeOp r33 = (InsertBeforeOp) r31.get(r32);
        if (r33.index != r30.index) goto L74;
        r30.text = catOpText(r30.text, r33.text);
        r13.set(r33.instructionIndex, null);
    L74:
        r32 = r32 + 1;
        goto L70
    L75:
        List r34 = getKindOfOps(r13, ReplaceOp.class, r28);
        int r35 = 0;
    L77:
        if (r35 >= r34.size()) goto L88;
        ReplaceOp r36 = (ReplaceOp) r34.get(r35);
        int r37 = r30.index;
        int r112 = r36.index;
        if (r37 != r112) goto L81;
        r36.text = catOpText(r30.text, r36.text);
        r13.set(r28, null);
    L87:
        r35 = r35 + 1;
        goto L77
    L81:
        if (r37 < r112) goto L87;
        if (r37 > r36.lastIndex) goto L87;
        throw new IllegalArgumentException("insert op " + r30 + " within boundaries of previous " + r36);
    L88:
        r28 = r28 + 1;
        goto L61
    L89:
        HashMap r113 = new HashMap();
    L91:
        if (r5 >= r13.size()) goto L101;
        RewriteOperation r38 = r13.get(r5);
        if (r38 == null) goto L98;
        if (r113.get(Integer.valueOf(r38.index)) != null) goto L100;
        r113.put(Integer.valueOf(r38.index), r38);
        goto L98
    L100:
        throw new Error("should only be one op per index");
    L98:
        r5 = r5 + 1;
        goto L91
    L101:
        return r113;
    }

    public void replace(int r5, Object r10) {
        replace("default", r5, r5, r10);
    }

    public void rollback(int r5) {
        rollback("default", r5);
    }

    public void setLastRewriteTokenIndex(String r5, int r10) {
        this.lastRewriteTokenIndexes.put(r5, Integer.valueOf(r10));
    }

    public String toDebugString() {
        return toDebugString(0, size() - 1);
    }

    public String toOriginalString() {
        fill();
        return toOriginalString(0, size() - 1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream
    public String toString() {
        fill();
        return toString(0, size() - 1);
    }

    public void delete(int r5, int r10) {
        delete("default", r5, r10);
    }

    public void deleteProgram(String r5) {
        rollback(r5, 0);
    }

    public <T extends RewriteOperation> List<? extends T> getKindOfOps(List<? extends RewriteOperation> r5, Class<T> r10, int r11) {
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L13;
        if (r13 >= r5.size()) goto L13;
        RewriteOperation r14 = r5.get(r13);
        if (r14 == null) goto L12;
        if (r10.isInstance(r14) == false) goto L12;
        r12.add(r10.cast(r14));
    L12:
        r13 = r13 + 1;
    L13:
        return r12;
    }

    public int getLastRewriteTokenIndex(String r5) {
        Integer r10 = this.lastRewriteTokenIndexes.get(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.intValue();
    }

    public void insertAfter(int r5, Object r10) {
        insertAfter("default", r5, r10);
    }

    public void insertBefore(int r5, Object r10) {
        insertBefore("default", r5, r10);
    }

    public void replace(int r5, int r10, Object r11) {
        replace("default", r5, r10, r11);
    }

    public void rollback(String r5, int r10) {
        List<RewriteOperation> r11 = this.programs.get(r5);
        if (r11 == null) goto L6;
        this.programs.put(r5, r11.subList(0, r10));
        return;
    }

    public String toDebugString(int r5, int r10) {
        StringBuilder r11 = new StringBuilder();
    L3:
        if (r5 < 0) goto L9;
        if (r5 > r10) goto L9;
        if (r5 >= this.tokens.size()) goto L9;
        r11.append(get(r5));
        r5 = r5 + 1;
    L9:
        return r11.toString();
    }

    public void delete(Token r5) {
        delete("default", r5, r5);
    }

    public void insertAfter(String r5, Token r10, Object r11) {
        insertAfter(r5, r10.getTokenIndex(), r11);
    }

    public void insertBefore(String r5, Token r10, Object r11) {
        insertBefore(r5, r10.getTokenIndex(), r11);
    }

    public void replace(Token r5, Object r10) {
        replace("default", r5, r5, r10);
    }

    public String toOriginalString(int r5, int r10) {
        StringBuilder r11 = new StringBuilder();
    L3:
        if (r5 < 0) goto L12;
        if (r5 > r10) goto L12;
        if (r5 >= this.tokens.size()) goto L12;
        if (get(r5).getType() == (-1)) goto L10;
        r11.append(get(r5).getText());
    L10:
        r5 = r5 + 1;
    L12:
        return r11.toString();
    }

    public String toString(String r5) {
        fill();
        return toString(r5, 0, size() - 1);
    }

    public void delete(Token r5, Token r10) {
        delete("default", r5, r10);
    }

    public void insertAfter(String r5, int r10, Object r11) {
        insertBefore(r5, r10 + 1, r11);
    }

    public void insertBefore(String r5, int r10, Object r11) {
        InsertBeforeOp r12 = new InsertBeforeOp(this, r10, r11);
        List<RewriteOperation> r13 = getProgram(r5);
        r12.instructionIndex = r13.size();
        r13.add(r12);
    }

    public void replace(Token r5, Token r10, Object r11) {
        replace("default", r5, r10, r11);
    }

    public TokenRewriteStream(TokenSource r5) {
        super(r5);
        this.programs = null;
        this.lastRewriteTokenIndexes = null;
        init();
    }

    public void delete(String r5, int r10, int r11) {
        replace(r5, r10, r11, null);
    }

    public void replace(String r5, int r10, int r11, Object r12) {
        if (r10 > r11) goto L9;
        if (r10 < 0) goto L9;
        if (r11 < 0) goto L9;
        if (r11 >= this.tokens.size()) goto L9;
        ReplaceOp r13 = new ReplaceOp(this, r10, r11, r12);
        List<RewriteOperation> r14 = getProgram(r5);
        r13.instructionIndex = r14.size();
        r14.add(r13);
        return;
    L9:
        StringBuilder r15 = j0.v("replace: range invalid: ", r10, r11, "..", "(size=");
        r15.append(this.tokens.size());
        r15.append(")");
        throw new IllegalArgumentException(r15.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream, androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(int r5, int r10) {
        return toString("default", r5, r10);
    }

    public void delete(String r5, Token r10, Token r11) {
        replace(r5, r10, r11, null);
    }

    public String toString(String r5, int r10, int r11) {
        List<RewriteOperation> r12 = this.programs.get(r5);
        if (r11 <= (this.tokens.size() - 1)) goto L5;
        r11 = this.tokens.size() - 1;
    L5:
        if (r10 >= 0) goto L7;
        r10 = 0;
    L7:
        if (r12 == null) goto L33;
        if (r12.isEmpty() == true) goto L33;
        StringBuffer r13 = new StringBuffer();
        Map<Integer, ? extends RewriteOperation> r14 = reduceToSingleOperationPerIndex(r12);
    L12:
        if (r10 > r11) goto L23;
        if (r10 >= this.tokens.size()) goto L23;
        RewriteOperation r15 = r14.get(Integer.valueOf(r10));
        r14.remove(Integer.valueOf(r10));
        Token r16 = this.tokens.get(r10);
        if (r15 == null) goto L18;
        r10 = r15.execute(r13);
        goto L12
    L18:
        if (r16.getType() == (-1)) goto L20;
        r13.append(r16.getText());
    L20:
        r10 = r10 + 1;
    L23:
        if (r11 != (this.tokens.size() - 1)) goto L31;
        Iterator<? extends RewriteOperation> r17 = r14.values().iterator();
    L26:
        if (r17.hasNext() == false) goto L31;
        RewriteOperation r18 = r17.next();
        if (r18.index < (this.tokens.size() - 1)) goto L26;
        r13.append(r18.text);
    L31:
        return r13.toString();
    L33:
        return toOriginalString(r10, r11);
    }

    public TokenRewriteStream(TokenSource r5, int r10) {
        super(r5, r10);
        this.programs = null;
        this.lastRewriteTokenIndexes = null;
        init();
    }

    public void replace(String r5, Token r10, Token r11, Object r12) {
        replace(r5, r10.getTokenIndex(), r11.getTokenIndex(), r12);
    }
}
