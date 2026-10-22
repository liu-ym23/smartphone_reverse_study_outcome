package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;

/* JADX INFO: loaded from: classes.dex */
public class TreePatternParser {
    protected TreeAdaptor adaptor;
    protected TreePatternLexer tokenizer;
    protected int ttype;
    protected TreeWizard wizard;

    public TreePatternParser(TreePatternLexer r5, TreeWizard r10, TreeAdaptor r11) {
        this.tokenizer = r5;
        this.wizard = r10;
        this.adaptor = r11;
        this.ttype = r5.nextToken();
    }

    public Object parseNode() {
        if (this.ttype != 5) goto L11;
        int r5 = this.tokenizer.nextToken();
        this.ttype = r5;
        if (r5 == 3) goto L7;
        return null;
    L7:
        String r10 = this.tokenizer.sval.toString();
        int r11 = this.tokenizer.nextToken();
        this.ttype = r11;
        if (r11 == 6) goto L10;
        return null;
    L10:
        this.ttype = this.tokenizer.nextToken();
    L12:
        int r12 = this.ttype;
        if (r12 != 7) goto L18;
        this.ttype = this.tokenizer.nextToken();
        TreeWizard.WildcardTreePattern r13 = new TreeWizard.WildcardTreePattern(new CommonToken(0, "."));
        if (r10 == null) goto L17;
        r13.label = r10;
    L17:
        return r13;
    L18:
        if (r12 == 3) goto L20;
        return null;
    L20:
        String r14 = this.tokenizer.sval.toString();
        this.ttype = this.tokenizer.nextToken();
        if (r14.equals("nil") == false) goto L25;
        return this.adaptor.nil();
    L25:
        if (this.ttype != 4) goto L27;
        String r15 = this.tokenizer.sval.toString();
        this.ttype = this.tokenizer.nextToken();
        String r16 = r15;
    L28:
        int r17 = this.wizard.getTokenType(r14);
        if (r17 != 0) goto L31;
        return null;
    L31:
        Object r18 = this.adaptor.create(r17, r15);
        if (r10 != null) goto L34;
    L36:
        if (r16 != null) goto L38;
    L40:
        return r18;
    L38:
        if (r18.getClass() != TreeWizard.TreePattern.class) goto L40;
        ((TreeWizard.TreePattern) r18).hasTextArg = true;
        goto L40
    L34:
        if (r18.getClass() != TreeWizard.TreePattern.class) goto L36;
        ((TreeWizard.TreePattern) r18).label = r10;
        goto L36
    L27:
        r15 = r14;
        r16 = null;
        goto L28
    L11:
        r10 = null;
        goto L12
    }

    public Object parseTree() {
        if (this.ttype != 1) goto L29;
        this.ttype = this.tokenizer.nextToken();
        Object r5 = parseNode();
        if (r5 != null) goto L7;
        return null;
    L7:
        int r10 = this.ttype;
        if (r10 != 1) goto L10;
    L22:
        if (r10 == 1) goto L23;
        Object r11 = parseNode();
        if (r11 == null) goto L26;
        this.adaptor.addChild(r5, r11);
        goto L7
    L26:
        return null;
    L23:
        Object r12 = parseTree();
        this.adaptor.addChild(r5, r12);
        goto L7
    L10:
        if (r10 == 3) goto L22;
        if (r10 == 5) goto L22;
        if (r10 == 7) goto L22;
        if (r10 != 2) goto L21;
        this.ttype = this.tokenizer.nextToken();
        return r5;
    L21:
        throw new RuntimeException("no END");
    L29:
        throw new RuntimeException("no BEGIN");
    }

    public Object pattern() {
        int r5 = this.ttype;
        if (r5 != 1) goto L7;
        return parseTree();
    L7:
        if (r5 != 3) goto L11;
        Object r10 = parseNode();
        if (this.ttype != (-1)) goto L11;
        return r10;
    L11:
        return null;
    }
}
