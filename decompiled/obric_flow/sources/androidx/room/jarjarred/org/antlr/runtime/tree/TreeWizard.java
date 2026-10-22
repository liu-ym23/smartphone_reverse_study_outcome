package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TreeWizard {
    protected TreeAdaptor adaptor;
    protected Map<String, Integer> tokenNameToTypeMap;

    public interface ContextVisitor {
        void visit(Object r5, Object r10, int r11, Map<String, Object> r12);
    }

    public static class TreePattern extends CommonTree {
        public boolean hasTextArg;
        public String label;

        public TreePattern(Token r5) {
            super(r5);
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public String toString() {
            if (this.label == null) goto L7;
            return "%" + this.label + ":" + super.toString();
        L7:
            return super.toString();
        }
    }

    public static class TreePatternTreeAdaptor extends CommonTreeAdaptor {
        public TreePatternTreeAdaptor() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
        public Object create(Token r5) {
            return new TreePattern(r5);
        }
    }

    public static abstract class Visitor implements ContextVisitor {
        public Visitor() {
        }

        public abstract void visit(Object r5);

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeWizard.ContextVisitor
        public void visit(Object r5, Object r10, int r11, Map<String, Object> r12) {
            visit(r5);
        }
    }

    public static class WildcardTreePattern extends TreePattern {
        public WildcardTreePattern(Token r5) {
            super(r5);
        }
    }

    public TreeWizard(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    public static boolean _equals(Object r5, Object r10, TreeAdaptor r11) {
        if (r5 == null) goto L23;
        if (r10 == null) goto L23;
        if (r11.getType(r5) == r11.getType(r10)) goto L10;
        return false;
    L10:
        if (r11.getText(r5).equals(r11.getText(r10)) == true) goto L12;
        return false;
    L12:
        int r12 = r11.getChildCount(r5);
        if (r12 == r11.getChildCount(r10)) goto L15;
        return false;
    L15:
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L21;
        if (_equals(r11.getChild(r5, r13), r11.getChild(r10, r13), r11) == false) goto L19;
        r13 = r13 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L23:
        return false;
    }

    public static boolean equals(Object r5, Object r10, TreeAdaptor r11) {
        return _equals(r5, r10, r11);
    }

    public void _index(Object r5, Map<Integer, List<Object>> r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r11 = this.adaptor.getType(r5);
        List<Object> r12 = r10.get(Integer.valueOf(r11));
        if (r12 != null) goto L7;
        r12 = new ArrayList();
        r10.put(Integer.valueOf(r11), r12);
    L7:
        r12.add(r5);
        int r13 = this.adaptor.getChildCount(r5);
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L10;
        _index(this.adaptor.getChild(r5, r14), r10);
        r14 = r14 + 1;
        goto L8
    }

    public boolean _parse(Object r10, TreePattern r11, Map<String, Object> r12) {
        if (r10 == null) goto L31;
        if (r11 == null) goto L31;
        if (r11.getClass() != WildcardTreePattern.class) goto L9;
    L16:
        String r5 = r11.label;
        if (r5 == null) goto L20;
        if (r12 == null) goto L20;
        r12.put(r5, r10);
    L20:
        int r13 = this.adaptor.getChildCount(r10);
        if (r13 == r11.getChildCount()) goto L23;
        return false;
    L23:
        int r14 = 0;
    L24:
        if (r14 >= r13) goto L29;
        if (_parse(this.adaptor.getChild(r10, r14), (TreePattern) r11.getChild(r14), r12) == false) goto L27;
        r14 = r14 + 1;
        goto L24
    L27:
        return false;
    L29:
        return true;
    L9:
        if (this.adaptor.getType(r10) == r11.getType()) goto L12;
        return false;
    L12:
        if (r11.hasTextArg == false) goto L16;
        if (this.adaptor.getText(r10).equals(r11.getText()) == true) goto L16;
        return false;
    L31:
        return false;
    }

    public void _visit(Object r10, Object r11, int r12, int r13, ContextVisitor r14) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.adaptor.getType(r10) != r13) goto L7;
        r14.visit(r10, r11, r12, null);
    L7:
        int r15 = this.adaptor.getChildCount(r10);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L10;
        _visit(this.adaptor.getChild(r10, r16), r10, r16, r13, r14);
        r16 = r16 + 1;
        goto L8
    }

    public Map<String, Integer> computeTokenTypes(String[] r5) {
        HashMap r10 = new HashMap();
        if (r5 != null) goto L5;
        return r10;
    L5:
        int r11 = 4;
    L7:
        if (r11 >= r5.length) goto L9;
        r10.put(r5[r11], Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public Object create(String r5) {
        return new TreePatternParser(new TreePatternLexer(r5), this, this.adaptor).pattern();
    }

    public List<? extends Object> find(Object r5, int r10) {
        final ArrayList r11 = new ArrayList();
        visit(r5, r10, new AnonymousClass1(this, r11));
        return r11;
    }

    public Object findFirst(Object r5, int r10) {
        return null;
    }

    public int getTokenType(String r5) {
        Map<String, Integer> r10 = this.tokenNameToTypeMap;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Integer r11 = r10.get(r5);
        if (r11 != null) goto L8;
        return 0;
    L8:
        return r11.intValue();
    }

    public Map<Integer, List<Object>> index(Object r5) {
        HashMap r10 = new HashMap();
        _index(r5, r10);
        return r10;
    }

    public boolean parse(Object r5, String r10, Map<String, Object> r11) {
        return _parse(r5, (TreePattern) new TreePatternParser(new TreePatternLexer(r10), this, new TreePatternTreeAdaptor()).pattern(), r11);
    }

    public void visit(Object r10, int r11, ContextVisitor r12) {
        _visit(r10, null, 0, r11, r12);
    }

    public boolean equals(Object r5, Object r10) {
        return _equals(r5, r10, this.adaptor);
    }

    public Object findFirst(Object r5, String r10) {
        return null;
    }

    public void visit(Object r5, String r10, final ContextVisitor r11) {
        final TreePattern r12 = (TreePattern) new TreePatternParser(new TreePatternLexer(r10), this, new TreePatternTreeAdaptor()).pattern();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isNil() == false) goto L7;
        return;
    L7:
        if (r12.getClass() == WildcardTreePattern.class) goto L13;
        final HashMap r13 = new HashMap();
        visit(r5, r12.getType(), new AnonymousClass3(this, r13, r12, r11));
        return;
    }

    public TreeWizard(TreeAdaptor r5, Map<String, Integer> r10) {
        this.adaptor = r5;
        this.tokenNameToTypeMap = r10;
    }

    public List<? extends Object> find(Object r5, String r10) {
        final ArrayList r11 = new ArrayList();
        final TreePattern r12 = (TreePattern) new TreePatternParser(new TreePatternLexer(r10), this, new TreePatternTreeAdaptor()).pattern();
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.isNil() == false) goto L7;
        return null;
    L7:
        if (r12.getClass() == WildcardTreePattern.class) goto L14;
        visit(r5, r12.getType(), new AnonymousClass2(this, r12, r11));
        return r11;
    L14:
        return null;
    }

    public boolean parse(Object r5, String r10) {
        return parse(r5, r10, null);
    }

    public TreeWizard(TreeAdaptor r5, String[] r10) {
        this.adaptor = r5;
        this.tokenNameToTypeMap = computeTokenTypes(r10);
    }

    public TreeWizard(String[] r5) {
        this(new CommonTreeAdaptor(), r5);
    }
}
