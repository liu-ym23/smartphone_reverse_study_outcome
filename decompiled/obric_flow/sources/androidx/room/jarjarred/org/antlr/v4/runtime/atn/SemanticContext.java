package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticContext {
    public static final SemanticContext NONE = null;

    public static class AND extends Operator {
        public final SemanticContext[] opnds;

        public AND(SemanticContext r5, SemanticContext r10) {
            HashSet r11 = new HashSet();
            if ((r5 instanceof AND) == false) goto L5;
            r11.addAll(Arrays.asList(((AND) r5).opnds));
        L7:
            if ((r10 instanceof AND) == false) goto L9;
            r11.addAll(Arrays.asList(((AND) r10).opnds));
        L10:
            List r12 = SemanticContext.access$000(r11);
            if (r12.isEmpty() == true) goto L13;
            r11.add((PrecedencePredicate) Collections.min(r12));
        L13:
            this.opnds = (SemanticContext[]) r11.toArray(new SemanticContext[r11.size()]);
            return;
        L9:
            r11.add(r10);
            goto L10
        L5:
            r11.add(r5);
            goto L7
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AND) == true) goto L10;
            return false;
        L10:
            return Arrays.equals(this.opnds, ((AND) r5).opnds);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public boolean eval(Recognizer<?, ?> r5, RuleContext r10) {
            SemanticContext[] r11 = this.opnds;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            if (r11[r13].eval(r5, r10) == false) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public SemanticContext evalPrecedence(Recognizer<?, ?> r10, RuleContext r11) {
            ArrayList r5 = new ArrayList();
            SemanticContext[] r12 = this.opnds;
            int r13 = r12.length;
            int r14 = 0;
            int r15 = 0;
        L3:
            int r16 = 1;
            if (r14 >= r13) goto L17;
            SemanticContext r17 = r12[r14];
            SemanticContext r18 = r17.evalPrecedence(r10, r11);
            if (r18 != r17) goto L9;
            r16 = 0;
        L9:
            r15 = r15 | r16;
            if (r18 == null) goto L11;
            if (r18 == SemanticContext.NONE) goto L16;
            r5.add(r18);
        L16:
            r14 = r14 + 1;
            goto L3
        L11:
            return null;
        L17:
            if (r15 != 0) goto L20;
            return this;
        L20:
            if (r5.isEmpty() == true) goto L22;
            SemanticContext r19 = (SemanticContext) r5.get(0);
        L25:
            if (r16 >= r5.size()) goto L27;
            r19 = SemanticContext.and(r19, (SemanticContext) r5.get(r16));
            r16 = r16 + 1;
            goto L25
        L27:
            return r19;
        L22:
            return SemanticContext.NONE;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext.Operator
        public Collection<SemanticContext> getOperands() {
            return Arrays.asList(this.opnds);
        }

        public int hashCode() {
            return MurmurHash.hashCode(this.opnds, AND.class.hashCode());
        }

        public String toString() {
            return Utils.join(Arrays.asList(this.opnds).iterator(), "&&");
        }
    }

    public static class OR extends Operator {
        public final SemanticContext[] opnds;

        public OR(SemanticContext r5, SemanticContext r10) {
            HashSet r11 = new HashSet();
            if ((r5 instanceof OR) == false) goto L5;
            r11.addAll(Arrays.asList(((OR) r5).opnds));
        L7:
            if ((r10 instanceof OR) == false) goto L9;
            r11.addAll(Arrays.asList(((OR) r10).opnds));
        L10:
            List r12 = SemanticContext.access$000(r11);
            if (r12.isEmpty() == true) goto L13;
            r11.add((PrecedencePredicate) Collections.max(r12));
        L13:
            this.opnds = (SemanticContext[]) r11.toArray(new SemanticContext[r11.size()]);
            return;
        L9:
            r11.add(r10);
            goto L10
        L5:
            r11.add(r5);
            goto L7
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OR) == true) goto L10;
            return false;
        L10:
            return Arrays.equals(this.opnds, ((OR) r5).opnds);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public boolean eval(Recognizer<?, ?> r5, RuleContext r10) {
            SemanticContext[] r11 = this.opnds;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            if (r11[r13].eval(r5, r10) == true) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public SemanticContext evalPrecedence(Recognizer<?, ?> r10, RuleContext r11) {
            ArrayList r5 = new ArrayList();
            SemanticContext[] r12 = this.opnds;
            int r13 = r12.length;
            int r14 = 0;
            int r15 = 0;
        L3:
            int r16 = 1;
            if (r14 >= r13) goto L15;
            SemanticContext r17 = r12[r14];
            SemanticContext r18 = r17.evalPrecedence(r10, r11);
            if (r18 != r17) goto L9;
            r16 = 0;
        L9:
            r15 = r15 | r16;
            SemanticContext r19 = SemanticContext.NONE;
            if (r18 == r19) goto L11;
            if (r18 == null) goto L14;
            r5.add(r18);
        L14:
            r14 = r14 + 1;
            goto L3
        L11:
            return r19;
        L15:
            if (r15 != 0) goto L18;
            return this;
        L18:
            if (r5.isEmpty() == false) goto L21;
            return null;
        L21:
            SemanticContext r20 = (SemanticContext) r5.get(0);
        L23:
            if (r16 >= r5.size()) goto L25;
            r20 = SemanticContext.or(r20, (SemanticContext) r5.get(r16));
            r16 = r16 + 1;
            goto L23
        L25:
            return r20;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext.Operator
        public Collection<SemanticContext> getOperands() {
            return Arrays.asList(this.opnds);
        }

        public int hashCode() {
            return MurmurHash.hashCode(this.opnds, OR.class.hashCode());
        }

        public String toString() {
            return Utils.join(Arrays.asList(this.opnds).iterator(), "||");
        }
    }

    public static abstract class Operator extends SemanticContext {
        public Operator() {
        }

        public abstract Collection<SemanticContext> getOperands();
    }

    public static class PrecedencePredicate extends SemanticContext implements Comparable<PrecedencePredicate> {
        public final int precedence;

        public PrecedencePredicate() {
            this.precedence = 0;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PrecedencePredicate r5) {
            return compareTo2(r5);
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof PrecedencePredicate) == true) goto L6;
            return false;
        L6:
            if (this != r5) goto L9;
            return true;
        L9:
            if (this.precedence == ((PrecedencePredicate) r5).precedence) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public boolean eval(Recognizer<?, ?> r5, RuleContext r10) {
            return r5.precpred(r10, this.precedence);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public SemanticContext evalPrecedence(Recognizer<?, ?> r5, RuleContext r10) {
            if (r5.precpred(r10, this.precedence) == true) goto L5;
            return null;
        L5:
            return SemanticContext.NONE;
        }

        public int hashCode() {
            return 31 + this.precedence;
        }

        public String toString() {
            return a.s(new StringBuilder("{"), this.precedence, ">=prec}?");
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(PrecedencePredicate r5) {
            return this.precedence - r5.precedence;
        }

        public PrecedencePredicate(int r5) {
            this.precedence = r5;
        }
    }

    public static class Predicate extends SemanticContext {
        public final boolean isCtxDependent;
        public final int predIndex;
        public final int ruleIndex;

        public Predicate() {
            this.ruleIndex = -1;
            this.predIndex = -1;
            this.isCtxDependent = false;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof Predicate) == true) goto L6;
            return false;
        L6:
            if (this != r5) goto L8;
            return true;
        L8:
            Predicate r10 = (Predicate) r5;
            if (this.ruleIndex == r10.ruleIndex) goto L11;
            return false;
        L11:
            if (this.predIndex == r10.predIndex) goto L13;
            return false;
        L13:
            if (this.isCtxDependent == r10.isCtxDependent) goto L15;
            return false;
        L15:
            return true;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext
        public boolean eval(Recognizer<?, ?> r5, RuleContext r10) {
            if (this.isCtxDependent == true) goto L7;
            r10 = null;
        L7:
            return r5.sempred(r10, this.ruleIndex, this.predIndex);
        }

        public int hashCode() {
            return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), this.ruleIndex), this.predIndex), this.isCtxDependent ? 1 : 0), 3);
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("{");
            r5.append(this.ruleIndex);
            r5.append(":");
            return a.s(r5, this.predIndex, "}?");
        }

        public Predicate(int r5, int r10, boolean r11) {
            this.ruleIndex = r5;
            this.predIndex = r10;
            this.isCtxDependent = r11;
        }
    }

    static {
        NONE = new Predicate();
    }

    public SemanticContext() {
    }

    public static /* synthetic */ List access$000(Collection r5) {
        return filterPrecedencePredicates(r5);
    }

    public static SemanticContext and(SemanticContext r5, SemanticContext r10) {
        if (r5 == null) goto L15;
        SemanticContext r11 = NONE;
        if (r5 == r11) goto L15;
        if (r10 == null) goto L14;
        if (r10 == r11) goto L14;
        AND r12 = new AND(r5, r10);
        SemanticContext[] r13 = r12.opnds;
        if (r13.length == 1) goto L12;
        return r12;
    L12:
        return r13[0];
    L14:
        return r5;
    L15:
        return r10;
    }

    private static List<PrecedencePredicate> filterPrecedencePredicates(Collection<? extends SemanticContext> r5) {
        Iterator<? extends SemanticContext> r10 = r5.iterator();
        ArrayList r11 = null;
    L4:
        if (r10.hasNext() == false) goto L10;
        SemanticContext r12 = r10.next();
        if ((r12 instanceof PrecedencePredicate) == false) goto L4;
        if (r11 != null) goto L9;
        r11 = new ArrayList();
    L9:
        r11.add((PrecedencePredicate) r12);
        r10.remove();
        goto L4
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        return Collections.emptyList();
    }

    public static SemanticContext or(SemanticContext r5, SemanticContext r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r10 != null) goto L6;
        return r5;
    L6:
        SemanticContext r11 = NONE;
        SemanticContext r12 = r11;
        r12 = r11;
        if (r5 == r11) goto L14;
        if (r10 == r11) goto L14;
        OR r13 = new OR(r5, r10);
        SemanticContext[] r14 = r13.opnds;
        r12 = r13;
        if (r14.length != 1) goto L14;
        return r14[0];
    L14:
        return r12;
    }

    public abstract boolean eval(Recognizer<?, ?> r5, RuleContext r10);

    public SemanticContext evalPrecedence(Recognizer<?, ?> r5, RuleContext r10) {
        return this;
    }
}
