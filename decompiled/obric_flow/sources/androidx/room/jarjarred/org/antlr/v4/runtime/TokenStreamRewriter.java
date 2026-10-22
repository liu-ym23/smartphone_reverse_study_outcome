package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TokenStreamRewriter {
    public static final String DEFAULT_PROGRAM_NAME = "default";
    public static final int MIN_TOKEN_INDEX = 0;
    public static final int PROGRAM_INIT_SIZE = 100;
    protected final Map<String, Integer> lastRewriteTokenIndexes;
    protected final Map<String, List<RewriteOperation>> programs;
    protected final TokenStream tokens;

    public class InsertAfterOp extends InsertBeforeOp {
        final /* synthetic */ TokenStreamRewriter this$0;

        public InsertAfterOp(TokenStreamRewriter r5, int r10, Object r11) {
            this.this$0 = r5;
            super(r5, r10 + 1, r11);
        }
    }

    public class InsertBeforeOp extends RewriteOperation {
        final /* synthetic */ TokenStreamRewriter this$0;

        public InsertBeforeOp(TokenStreamRewriter r5, int r10, Object r11) {
            this.this$0 = r5;
            super(r5, r10, r11);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStreamRewriter.RewriteOperation
        public int execute(StringBuilder r5) {
            r5.append(this.text);
            if (this.this$0.tokens.get(this.index).getType() == (-1)) goto L6;
            r5.append(this.this$0.tokens.get(this.index).getText());
        L6:
            return this.index + 1;
        }
    }

    public class ReplaceOp extends RewriteOperation {
        protected int lastIndex;
        final /* synthetic */ TokenStreamRewriter this$0;

        public ReplaceOp(TokenStreamRewriter r5, int r10, int r11, Object r12) {
            this.this$0 = r5;
            super(r5, r10, r12);
            this.lastIndex = r11;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStreamRewriter.RewriteOperation
        public int execute(StringBuilder r5) {
            Object r10 = this.text;
            if (r10 == null) goto L6;
            r5.append(r10);
        L6:
            return this.lastIndex + 1;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStreamRewriter.RewriteOperation
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
        final /* synthetic */ TokenStreamRewriter this$0;

        public RewriteOperation(TokenStreamRewriter r5, int r10) {
            this.this$0 = r5;
            this.index = r10;
        }

        public int execute(StringBuilder r5) {
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

        public RewriteOperation(TokenStreamRewriter r5, int r10, Object r11) {
            this.this$0 = r5;
            this.index = r10;
            this.text = r11;
        }
    }

    public TokenStreamRewriter(TokenStream r5) {
        this.tokens = r5;
        HashMap r10 = new HashMap();
        this.programs = r10;
        r10.put("default", new ArrayList(100));
        this.lastRewriteTokenIndexes = new HashMap();
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

    public String getText() {
        return getText("default", Interval.of(0, this.tokens.size() - 1));
    }

    public final TokenStream getTokenStream() {
        return this.tokens;
    }

    public void insertAfter(Token r5, Object r10) {
        insertAfter("default", r5, r10);
    }

    public void insertBefore(Token r5, Object r10) {
        insertBefore("default", r5, r10);
    }

    public Map<Integer, RewriteOperation> reduceToSingleOperationPerIndex(List<RewriteOperation> r11) {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= r11.size()) goto L51;
        RewriteOperation r12 = r11.get(r10);
        if (r12 == null) goto L50;
        if ((r12 instanceof ReplaceOp) == false) goto L50;
        ReplaceOp r13 = (ReplaceOp) r11.get(r10);
        Iterator r14 = getKindOfOps(r11, InsertBeforeOp.class, r10).iterator();
    L13:
        if (r14.hasNext() == false) goto L25;
        InsertBeforeOp r15 = (InsertBeforeOp) r14.next();
        int r16 = r15.index;
        int r17 = r13.index;
        if (r16 == r17) goto L16;
        if (r16 <= r17) goto L13;
        if (r16 > r13.lastIndex) goto L13;
        r11.set(r15.instructionIndex, null);
        goto L13
    L16:
        r11.set(r15.instructionIndex, null);
        StringBuilder r18 = new StringBuilder();
        r18.append(r15.text.toString());
        Object r19 = r13.text;
        if (r19 == null) goto L19;
        String r20 = r19.toString();
    L20:
        r18.append(r20);
        r13.text = r18.toString();
        goto L13
    L19:
        r20 = "";
        goto L20
    L25:
        Iterator r21 = getKindOfOps(r11, ReplaceOp.class, r10).iterator();
    L27:
        if (r21.hasNext() == false) goto L50;
        ReplaceOp r22 = (ReplaceOp) r21.next();
        int r23 = r22.index;
        int r24 = r13.index;
        if (r23 < r24) goto L34;
        if (r22.lastIndex > r13.lastIndex) goto L34;
        r11.set(r22.instructionIndex, null);
    L34:
        if (r22.lastIndex >= r24) goto L36;
    L39:
        boolean r25 = true;
    L41:
        if (r22.text != null) goto L46;
        if (r13.text != null) goto L46;
        if (r25 == true) goto L46;
        r11.set(r22.instructionIndex, null);
        r13.index = Math.min(r22.index, r13.index);
        r13.lastIndex = Math.max(r22.lastIndex, r13.lastIndex);
        System.out.println("new rop " + r13);
    L46:
        if (r25 == true) goto L27;
        throw new IllegalArgumentException("replace op boundaries of " + r13 + " overlap with previous " + r22);
    L36:
        if (r23 > r13.lastIndex) goto L39;
        r25 = false;
    L50:
        r10 = r10 + 1;
        goto L4
    L51:
        int r26 = 0;
    L53:
        if (r26 >= r11.size()) goto L84;
        RewriteOperation r27 = r11.get(r26);
        if (r27 == null) goto L83;
        if ((r27 instanceof InsertBeforeOp) == false) goto L83;
        InsertBeforeOp r28 = (InsertBeforeOp) r11.get(r26);
        Iterator r29 = getKindOfOps(r11, InsertBeforeOp.class, r26).iterator();
    L62:
        if (r29.hasNext() == false) goto L71;
        InsertBeforeOp r30 = (InsertBeforeOp) r29.next();
        if (r30.index != r28.index) goto L62;
        if (InsertAfterOp.class.isInstance(r30) == true) goto L67;
        if (InsertBeforeOp.class.isInstance(r30) == false) goto L62;
        r28.text = catOpText(r28.text, r30.text);
        r11.set(r30.instructionIndex, null);
        goto L62
    L67:
        r28.text = catOpText(r30.text, r28.text);
        r11.set(r30.instructionIndex, null);
        goto L62
    L71:
        Iterator r31 = getKindOfOps(r11, ReplaceOp.class, r26).iterator();
    L73:
        if (r31.hasNext() == false) goto L83;
        ReplaceOp r32 = (ReplaceOp) r31.next();
        int r33 = r28.index;
        int r34 = r32.index;
        if (r33 == r34) goto L76;
        if (r33 < r34) goto L73;
        if (r33 > r32.lastIndex) goto L73;
        throw new IllegalArgumentException("insert op " + r28 + " within boundaries of previous " + r32);
    L76:
        r32.text = catOpText(r28.text, r32.text);
        r11.set(r26, null);
    L83:
        r26 = r26 + 1;
        goto L53
    L84:
        HashMap r110 = new HashMap();
    L86:
        if (r5 >= r11.size()) goto L96;
        RewriteOperation r35 = r11.get(r5);
        if (r35 == null) goto L93;
        if (r110.get(Integer.valueOf(r35.index)) != null) goto L95;
        r110.put(Integer.valueOf(r35.index), r35);
        goto L93
    L95:
        throw new Error("should only be one op per index");
    L93:
        r5 = r5 + 1;
        goto L86
    L96:
        return r110;
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

    public void delete(int r5, int r10) {
        delete("default", r5, r10);
    }

    public void deleteProgram(String r5) {
        rollback(r5, 0);
    }

    public int getLastRewriteTokenIndex(String r5) {
        Integer r10 = this.lastRewriteTokenIndexes.get(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.intValue();
    }

    public String getText(String r5) {
        return getText(r5, Interval.of(0, this.tokens.size() - 1));
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

    public void delete(Token r5) {
        delete("default", r5, r5);
    }

    public String getText(Interval r5) {
        return getText("default", r5);
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

    public void delete(Token r5, Token r10) {
        delete("default", r5, r10);
    }

    public String getText(String r10, Interval r11) {
        List<RewriteOperation> r12 = this.programs.get(r10);
        int r5 = r11.f665a;
        int r13 = r11.f666b;
        if (r13 <= (this.tokens.size() - 1)) goto L5;
        r13 = this.tokens.size() - 1;
    L5:
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        if (r12 == null) goto L33;
        if (r12.isEmpty() == true) goto L33;
        StringBuilder r14 = new StringBuilder();
        Map<Integer, RewriteOperation> r15 = reduceToSingleOperationPerIndex(r12);
    L12:
        if (r5 > r13) goto L23;
        if (r5 >= this.tokens.size()) goto L23;
        RewriteOperation r16 = r15.get(Integer.valueOf(r5));
        r15.remove(Integer.valueOf(r5));
        Token r17 = this.tokens.get(r5);
        if (r16 == null) goto L18;
        r5 = r16.execute(r14);
        goto L12
    L18:
        if (r17.getType() == (-1)) goto L20;
        r14.append(r17.getText());
    L20:
        r5 = r5 + 1;
    L23:
        if (r13 != (this.tokens.size() - 1)) goto L31;
        Iterator<RewriteOperation> r18 = r15.values().iterator();
    L26:
        if (r18.hasNext() == false) goto L31;
        RewriteOperation r19 = r18.next();
        if (r19.index < (this.tokens.size() - 1)) goto L26;
        r14.append(r19.text);
    L31:
        return r14.toString();
    L33:
        return this.tokens.getText(r11);
    }

    public void insertAfter(String r5, int r10, Object r11) {
        InsertAfterOp r12 = new InsertAfterOp(this, r10, r11);
        List<RewriteOperation> r13 = getProgram(r5);
        r12.instructionIndex = r13.size();
        r13.add(r12);
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

    public void delete(String r5, Token r10, Token r11) {
        replace(r5, r10, r11, null);
    }

    public void replace(String r5, Token r10, Token r11, Object r12) {
        replace(r5, r10.getTokenIndex(), r11.getTokenIndex(), r12);
    }
}
