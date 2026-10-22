package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.v4.misc.FrequencySet;
import androidx.room.jarjarred.org.antlr.v4.misc.MutableInt;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ElementFrequenciesVisitor extends GrammarTreeVisitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FrequencySet<String> SENTINEL = null;
    final Deque<FrequencySet<String>> frequencies;
    private final Deque<FrequencySet<String>> minFrequencies;

    static {
        SENTINEL = new FrequencySet();
    }

    public ElementFrequenciesVisitor(TreeNodeStream r5) {
        super(r5);
        ArrayDeque r10 = new ArrayDeque();
        this.frequencies = r10;
        r10.push(new FrequencySet());
        ArrayDeque r11 = new ArrayDeque();
        this.minFrequencies = r11;
        r11.push(SENTINEL);
    }

    public static FrequencySet<String> combineAndClip(FrequencySet<String> r5, FrequencySet<String> r10, int r11) {
        FrequencySet<String> r12 = new FrequencySet();
        Iterator<Map.Entry<String, MutableInt>> r13 = r5.entrySet().iterator();
    L3:
        int r14 = 0;
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, MutableInt> r15 = r13.next();
    L7:
        if (r14 >= r15.getValue().f645v) goto L3;
        r12.add(r15.getKey());
        r14 = r14 + 1;
        goto L7
    L9:
        Iterator<Map.Entry<String, MutableInt>> r16 = r10.entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L16;
        Map.Entry<String, MutableInt> r17 = r16.next();
        int r18 = 0;
    L14:
        if (r18 >= r17.getValue().f645v) goto L11;
        r12.add(r17.getKey());
        r18 = r18 + 1;
        goto L14
    L16:
        Iterator r19 = r12.entrySet().iterator();
    L18:
        if (r19.hasNext() == false) goto L20;
        Map.Entry r20 = (Map.Entry) r19.next();
        ((MutableInt) r20.getValue()).f645v = Math.min(((MutableInt) r20.getValue()).f645v, r11);
        goto L18
    L20:
        return r12;
    }

    public static FrequencySet<String> combineMax(FrequencySet<String> r5, FrequencySet<String> r10) {
        FrequencySet<String> r11 = combineAndClip(r5, r10, 1);
        Iterator<Map.Entry<String, MutableInt>> r12 = r5.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, MutableInt> r13 = r12.next();
        MutableInt r14 = r11.get(r13.getKey());
        r14.f645v = r13.getValue().f645v;
        goto L4
    L6:
        Iterator<Map.Entry<String, MutableInt>> r15 = r10.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry<String, MutableInt> r16 = r15.next();
        MutableInt r17 = r11.get(r16.getKey());
        r17.f645v = Math.max(r17.f645v, r16.getValue().f645v);
        goto L8
    L10:
        return r11;
    }

    public static FrequencySet<String> combineMin(FrequencySet<String> r5, FrequencySet<String> r10) {
        if (r10 != SENTINEL) goto L5;
        return r5;
    L5:
        FrequencySet<String> r11 = combineAndClip(r5, r10, Integer.MAX_VALUE);
        Iterator<Map.Entry<String, MutableInt>> r12 = r11.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, MutableInt> r13 = r12.next();
        MutableInt r14 = r13.getValue();
        r14.f645v = Math.min(r5.count(r13.getKey()), r10.count(r13.getKey()));
        goto L7
    L9:
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterAlternative(AltAST r5) {
        this.frequencies.push(new FrequencySet());
        this.minFrequencies.push(new FrequencySet());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterBlockSet(GrammarAST r5) {
        this.frequencies.push(new FrequencySet());
        this.minFrequencies.push(new FrequencySet());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterElement(GrammarAST r5) {
        this.frequencies.push(new FrequencySet());
        this.minFrequencies.push(new FrequencySet());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterLexerAlternative(GrammarAST r5) {
        this.frequencies.push(new FrequencySet());
        this.minFrequencies.push(new FrequencySet());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterLexerElement(GrammarAST r5) {
        this.frequencies.push(new FrequencySet());
        this.minFrequencies.push(new FrequencySet());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitAlternative(AltAST r5) {
        Deque<FrequencySet<String>> r10 = this.frequencies;
        r10.push(combineMax(r10.pop(), this.frequencies.pop()));
        Deque<FrequencySet<String>> r11 = this.minFrequencies;
        r11.push(combineMin(r11.pop(), this.minFrequencies.pop()));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitBlockSet(GrammarAST r5) {
        Iterator<Map.Entry<String, MutableInt>> r10 = this.frequencies.peek().entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r10.next().getValue().f645v = 1;
        goto L4
    L7:
        if (this.minFrequencies.peek().size() <= 1) goto L9;
        this.minFrequencies.peek().clear();
    L9:
        Deque<FrequencySet<String>> r11 = this.frequencies;
        r11.push(combineAndClip(r11.pop(), this.frequencies.pop(), 2));
        Deque<FrequencySet<String>> r12 = this.minFrequencies;
        r12.push(combineAndClip(r12.pop(), this.minFrequencies.pop(), 2));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitElement(GrammarAST r5) {
        Deque<FrequencySet<String>> r10 = this.frequencies;
        r10.push(combineAndClip(r10.pop(), this.frequencies.pop(), 2));
        Deque<FrequencySet<String>> r11 = this.minFrequencies;
        r11.push(combineAndClip(r11.pop(), this.minFrequencies.pop(), 2));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitLexerAlternative(GrammarAST r5) {
        Deque<FrequencySet<String>> r10 = this.frequencies;
        r10.push(combineMax(r10.pop(), this.frequencies.pop()));
        Deque<FrequencySet<String>> r11 = this.minFrequencies;
        r11.push(combineMin(r11.pop(), this.minFrequencies.pop()));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitLexerElement(GrammarAST r5) {
        Deque<FrequencySet<String>> r10 = this.frequencies;
        r10.push(combineAndClip(r10.pop(), this.frequencies.pop(), 2));
        Deque<FrequencySet<String>> r11 = this.minFrequencies;
        r11.push(combineAndClip(r11.pop(), this.minFrequencies.pop(), 2));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitLexerSubrule(GrammarAST r5) {
        if (r5.getType() != 80) goto L5;
    L6:
        Iterator<Map.Entry<String, MutableInt>> r10 = this.frequencies.peek().entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        r10.next().getValue().f645v = 2;
    L11:
        if (r5.getType() != 80) goto L15;
        this.minFrequencies.peek().clear();
        return;
    L15:
        return;
    L5:
        if (r5.getType() != 90) goto L11;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitSubrule(GrammarAST r5) {
        if (r5.getType() != 80) goto L5;
    L6:
        Iterator<Map.Entry<String, MutableInt>> r10 = this.frequencies.peek().entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        r10.next().getValue().f645v = 2;
    L11:
        if (r5.getType() != 80) goto L13;
    L14:
        this.minFrequencies.peek().clear();
        return;
    L13:
        if (r5.getType() == 89) goto L14;
        return;
    L5:
        if (r5.getType() != 90) goto L11;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public ErrorManager getErrorManager() {
        return super.getErrorManager();
    }

    public FrequencySet<String> getMinFrequencies() {
        return this.minFrequencies.peek();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleRef(GrammarAST r5, ActionAST r10) {
        this.frequencies.peek().add(r5.getText());
        this.minFrequencies.peek().add(r5.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void tokenRef(TerminalAST r5) {
        this.frequencies.peek().add(r5.getText());
        this.minFrequencies.peek().add(r5.getText());
    }
}
