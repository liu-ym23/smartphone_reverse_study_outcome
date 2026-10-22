package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class IntervalSet implements IntSet {
    public static final IntervalSet COMPLETE_CHAR_SET = null;
    public static final IntervalSet EMPTY_SET = null;
    protected List<Interval> intervals;
    protected boolean readonly;

    static {
        IntervalSet r5 = of(0, Lexer.MAX_CHAR_VALUE);
        COMPLETE_CHAR_SET = r5;
        r5.setReadonly(true);
        IntervalSet r10 = new IntervalSet(new int[0]);
        EMPTY_SET = r10;
        r10.setReadonly(true);
    }

    public IntervalSet(List<Interval> r5) {
        this.intervals = r5;
    }

    public static IntervalSet of(int r5) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        r10.add(r5);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public void add(int r5) {
        if (this.readonly == true) goto L7;
        add(r5, r5);
        return;
    L7:
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public /* bridge */ /* synthetic */ IntSet addAll(IntSet r5) {
        return addAll(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public /* bridge */ /* synthetic */ IntSet and(IntSet r5) {
        return and(r5);
    }

    public void clear() {
        if (this.readonly == true) goto L7;
        this.intervals.clear();
        return;
    L7:
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public /* bridge */ /* synthetic */ IntSet complement(IntSet r5) {
        return complement(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public boolean contains(int r10) {
        int r5 = this.intervals.size() - 1;
        int r11 = 0;
    L3:
        if (r11 > r5) goto L10;
        int r12 = (r11 + r5) / 2;
        Interval r13 = this.intervals.get(r12);
        int r14 = r13.f665a;
        if (r13.f666b < r10) goto L6;
        if (r14 <= r10) goto L9;
        r5 = r12 - 1;
        goto L3
    L9:
        return true;
    L6:
        r11 = r12 + 1;
        goto L3
    L10:
        return false;
    }

    @Deprecated
    public String elementName(String[] r5, int r10) {
        return elementName(VocabularyImpl.fromTokenNames(r5), r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public boolean equals(Object r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if ((r5 instanceof IntervalSet) == true) goto L7;
        return false;
    L7:
        return this.intervals.equals(((IntervalSet) r5).intervals);
    }

    public int get(int r10) {
        int r5 = this.intervals.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L10;
        Interval r13 = this.intervals.get(r11);
        int r14 = r13.f665a;
        int r15 = r13.f666b;
    L5:
        if (r14 > r15) goto L9;
        if (r12 == r10) goto L7;
        r12 = r12 + 1;
        r14 = r14 + 1;
        goto L5
    L7:
        return r14;
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return -1;
    }

    public List<Interval> getIntervals() {
        return this.intervals;
    }

    public int getMaxElement() {
        if (isNil() == true) goto L7;
        return ((Interval) j0.e(this.intervals, 1)).f666b;
    L7:
        throw new RuntimeException("set is empty");
    }

    public int getMinElement() {
        if (isNil() == true) goto L7;
        return this.intervals.get(0).f665a;
    L7:
        throw new RuntimeException("set is empty");
    }

    public int hashCode() {
        int r5 = MurmurHash.initialize();
        Iterator<Interval> r10 = this.intervals.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Interval r11 = r10.next();
        r5 = MurmurHash.update(MurmurHash.update(r5, r11.f665a), r11.f666b);
        goto L4
    L7:
        return MurmurHash.finish(r5, this.intervals.size() * 2);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public boolean isNil() {
        List<Interval> r5 = this.intervals;
        if (r5 != null) goto L5;
    L8:
        return true;
    L5:
        if (r5.isEmpty() == true) goto L8;
        return false;
    }

    public boolean isReadonly() {
        return this.readonly;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public /* bridge */ /* synthetic */ IntSet or(IntSet r5) {
        return or(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public void remove(int r10) {
        if (this.readonly == true) goto L22;
        int r5 = this.intervals.size();
        int r11 = 0;
    L5:
        if (r11 >= r5) goto L33;
        Interval r12 = this.intervals.get(r11);
        int r13 = r12.f665a;
        int r14 = r12.f666b;
        if (r10 < r13) goto L34;
        if (r10 != r13) goto L12;
        if (r10 != r14) goto L12;
        this.intervals.remove(r11);
        return;
    L12:
        if (r10 == r13) goto L13;
        if (r10 == r14) goto L15;
        if (r10 <= r13) goto L19;
        if (r10 >= r14) goto L19;
        r12.f666b = r10 - 1;
        add(r10 + 1, r14);
    L19:
        r11 = r11 + 1;
        goto L5
    L15:
        r12.f666b = r14 - 1;
        return;
    L13:
        r12.f665a = r13 + 1;
        return;
    L34:
        return;
    L33:
        return;
    L22:
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public void setReadonly(boolean r5) {
        if (this.readonly == false) goto L8;
        if (r5 == true) goto L8;
        throw new IllegalStateException("can't alter readonly IntervalSet");
    L8:
        this.readonly = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public int size() {
        int r5 = this.intervals.size();
        int r10 = 0;
        if (r5 != 1) goto L6;
        Interval r11 = this.intervals.get(0);
        return (r11.f666b - r11.f665a) + 1;
    L6:
        int r12 = 0;
    L7:
        if (r10 >= r5) goto L9;
        Interval r13 = this.intervals.get(r10);
        r12 = r12 + ((r13.f666b - r13.f665a) + 1);
        r10 = r10 + 1;
        goto L7
    L9:
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public /* bridge */ /* synthetic */ IntSet subtract(IntSet r5) {
        return subtract(r5);
    }

    public int[] toArray() {
        return toIntegerList().toArray();
    }

    public IntegerList toIntegerList() {
        IntegerList r5 = new IntegerList(size());
        int r10 = this.intervals.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        Interval r12 = this.intervals.get(r11);
        int r13 = r12.f665a;
        int r14 = r12.f666b;
    L5:
        if (r13 > r14) goto L7;
        r5.add(r13);
        r13 = r13 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public List<Integer> toList() {
        ArrayList r5 = new ArrayList();
        int r10 = this.intervals.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        Interval r12 = this.intervals.get(r11);
        int r13 = r12.f665a;
        int r14 = r12.f666b;
    L5:
        if (r13 > r14) goto L7;
        r13 = j0.d(r13, r5, r13, 1);
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        return r5;
    }

    public Set<Integer> toSet() {
        HashSet r5 = new HashSet();
        Iterator<Interval> r10 = this.intervals.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Interval r11 = r10.next();
        int r12 = r11.f665a;
        int r13 = r11.f666b;
    L6:
        if (r12 > r13) goto L4;
        r5.add(Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L6
    L8:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public String toString() {
        return toString(false);
    }

    public static IntervalSet or(IntervalSet[] r5) {
        int r10 = 0;
        IntervalSet r11 = new IntervalSet(new int[0]);
        int r12 = r5.length;
    L3:
        if (r10 >= r12) goto L5;
        r11.addAll(r5[r10]);
        r10 = r10 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public IntervalSet addAll(IntSet r5) {
        if (r5 != null) goto L5;
        return this;
    L5:
        if ((r5 instanceof IntervalSet) == false) goto L9;
        IntervalSet r10 = (IntervalSet) r5;
        int r11 = r10.intervals.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L13;
        Interval r13 = r10.intervals.get(r12);
        add(r13.f665a, r13.f666b);
        r12 = r12 + 1;
    L13:
        return this;
    L9:
        Iterator<Integer> r14 = r5.toList().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        add(r14.next().intValue());
        goto L11
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public IntervalSet and(IntSet r10) {
        IntervalSet r5 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        List<Interval> r11 = this.intervals;
        List<Interval> r12 = ((IntervalSet) r10).intervals;
        int r13 = r11.size();
        int r14 = r12.size();
        int r15 = 0;
        int r16 = 0;
    L6:
        if (r15 >= r13) goto L34;
        if (r16 >= r14) goto L34;
        Interval r17 = r11.get(r15);
        Interval r18 = r12.get(r16);
        if (r17.startsBeforeDisjoint(r18) == true) goto L10;
        if (r18.startsBeforeDisjoint(r17) == true) goto L13;
        if (r17.properlyContains(r18) == true) goto L16;
        if (r18.properlyContains(r17) == true) goto L21;
        if (r17.disjoint(r18) == true) goto L6;
        if (r5 != null) goto L28;
        r5 = new IntervalSet(new int[0]);
    L28:
        r5.add(r17.intersection(r18));
        if (r17.startsAfterNonDisjoint(r18) == true) goto L13;
        if (r18.startsAfterNonDisjoint(r17) == false) goto L6;
    L21:
        if (r5 != null) goto L23;
        r5 = new IntervalSet(new int[0]);
    L23:
        r5.add(r17.intersection(r18));
        goto L10
    L16:
        if (r5 != null) goto L18;
        r5 = new IntervalSet(new int[0]);
    L18:
        r5.add(r17.intersection(r18));
    L13:
        r16 = r16 + 1;
    L10:
        r15 = r15 + 1;
    L34:
        if (r5 == null) goto L36;
        return r5;
    L36:
        return new IntervalSet(new int[0]);
    }

    public IntervalSet complement(int r5, int r10) {
        return complement(of(r5, r10));
    }

    public String elementName(Vocabulary r5, int r10) {
        if (r10 != (-1)) goto L7;
        return "<EOF>";
    L7:
        if (r10 != (-2)) goto L11;
        return "<EPSILON>";
    L11:
        return r5.getDisplayName(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public IntervalSet subtract(IntSet r5) {
        if (r5 == null) goto L13;
        if (r5.isNil() == true) goto L13;
        if ((r5 instanceof IntervalSet) == true) goto L9;
        IntervalSet r10 = new IntervalSet(new int[0]);
        r10.addAll(r5);
        return subtract(this, r10);
    L9:
        return subtract(this, (IntervalSet) r5);
    L13:
        return new IntervalSet(this);
    }

    public String toString(boolean r10) {
        StringBuilder r5 = new StringBuilder();
        List<Interval> r11 = this.intervals;
        if (r11 != null) goto L5;
        return "{}";
    L5:
        if (r11.isEmpty() == false) goto L8;
        return "{}";
    L8:
        if (size() <= 1) goto L10;
        r5.append("{");
    L10:
        Iterator<Interval> r12 = this.intervals.iterator();
    L12:
        if (r12.hasNext() == false) goto L28;
        Interval r13 = r12.next();
        int r14 = r13.f665a;
        int r15 = r13.f666b;
        if (r14 == r15) goto L16;
        if (r10 == false) goto L23;
        r5.append("'");
        StringBuilder r16 = r5.appendCodePoint(r14);
        r16.append("'..'");
        r16.appendCodePoint(r15).append("'");
    L25:
        if (r12.hasNext() == false) goto L12;
        r5.append(", ");
        goto L12
    L23:
        r5.append(r14);
        r5.append("..");
        r5.append(r15);
        goto L25
    L16:
        if (r14 != (-1)) goto L18;
        r5.append("<EOF>");
        goto L25
    L18:
        if (r10 == false) goto L20;
        r5.append("'");
        r5.appendCodePoint(r14).append("'");
        goto L25
    L20:
        r5.append(r14);
        goto L25
    L28:
        if (size() <= 1) goto L31;
        r5.append("}");
    L31:
        return r5.toString();
    }

    public IntervalSet(IntervalSet r5) {
        this(new int[0]);
        addAll(r5);
    }

    public static IntervalSet of(int r5, int r10) {
        IntervalSet r11 = new IntervalSet(new int[0]);
        r11.add(r5, r10);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public IntervalSet complement(IntSet r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isNil() == false) goto L7;
        return null;
    L7:
        if ((r5 instanceof IntervalSet) == false) goto L9;
        IntervalSet r10 = (IntervalSet) r5;
    L11:
        return r10.subtract(this);
    L9:
        IntervalSet r11 = new IntervalSet(new int[0]);
        r11.addAll(r5);
        r10 = r11;
        goto L11
    }

    public void add(int r5, int r10) {
        add(Interval.of(r5, r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet
    public IntervalSet or(IntSet r5) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        r10.addAll(this);
        r10.addAll(r5);
        return r10;
    }

    public IntervalSet(int... r5) {
        if (r5 != null) goto L5;
        this.intervals = new ArrayList(2);
        return;
    L5:
        this.intervals = new ArrayList(r5.length);
        int r10 = r5.length;
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L10;
        add(r5[r11]);
        r11 = r11 + 1;
        goto L6
    }

    public void add(Interval r5) {
        if (this.readonly == true) goto L35;
        if (r5.f666b >= r5.f665a) goto L7;
        return;
    L7:
        ListIterator<Interval> r10 = this.intervals.listIterator();
    L9:
        if (r10.hasNext() == false) goto L32;
        Interval r11 = r10.next();
        if (r5.equals(r11) == true) goto L12;
        if (r5.adjacent(r11) == true) goto L22;
        if (r5.disjoint(r11) == false) goto L22;
        if (r5.startsBeforeDisjoint(r11) == false) goto L9;
        r10.previous();
        r10.add(r5);
        return;
    L22:
        Interval r12 = r5.union(r11);
        r10.set(r12);
    L24:
        if (r10.hasNext() == false) goto L31;
        Interval r13 = r10.next();
        if (r12.adjacent(r13) == true) goto L30;
        if (r12.disjoint(r13) == false) goto L30;
        return;
    L30:
        r10.remove();
        r10.previous();
        r10.set(r12.union(r13));
        r10.next();
        goto L24
    L31:
        return;
    L12:
        return;
    L32:
        this.intervals.add(r5);
        return;
    L35:
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public static IntervalSet subtract(IntervalSet r10, IntervalSet r11) {
        int r5 = 0;
        if (r10 == null) goto L39;
        if (r10.isNil() == true) goto L39;
        IntervalSet r12 = new IntervalSet(r10);
        if (r11 != null) goto L10;
    L37:
        return r12;
    L10:
        if (r11.isNil() == true) goto L37;
        int r13 = 0;
    L14:
        if (r5 >= r12.intervals.size()) goto L37;
        if (r13 >= r11.intervals.size()) goto L37;
        Interval r14 = r12.intervals.get(r5);
        Interval r15 = r11.intervals.get(r13);
        int r16 = r15.f666b;
        int r17 = r14.f665a;
        if (r16 < r17) goto L19;
        int r18 = r15.f665a;
        if (r18 > r14.f666b) goto L22;
        Interval r19 = null;
        if (r18 <= r17) goto L26;
        Interval r20 = new Interval(r14.f665a, r15.f665a - 1);
    L28:
        if (r15.f666b >= r14.f666b) goto L30;
        r19 = new Interval(r15.f666b + 1, r14.f666b);
    L30:
        if (r20 != null) goto L31;
        if (r19 != null) goto L35;
        r12.intervals.remove(r5);
        goto L14
    L35:
        r12.intervals.set(r5, r19);
        goto L19
    L31:
        if (r19 != null) goto L32;
        r12.intervals.set(r5, r20);
        goto L22
    L32:
        r12.intervals.set(r5, r20);
        r5 = r5 + 1;
        r12.intervals.add(r5, r19);
        goto L19
    L26:
        r20 = null;
    L22:
        r5 = r5 + 1;
    L19:
        r13 = r13 + 1;
    L39:
        return new IntervalSet(new int[0]);
    }

    @Deprecated
    public String toString(String[] r5) {
        return toString(VocabularyImpl.fromTokenNames(r5));
    }

    public String toString(Vocabulary r10) {
        StringBuilder r5 = new StringBuilder();
        List<Interval> r11 = this.intervals;
        if (r11 != null) goto L5;
        return "{}";
    L5:
        if (r11.isEmpty() == false) goto L8;
        return "{}";
    L8:
        if (size() <= 1) goto L10;
        r5.append("{");
    L10:
        Iterator<Interval> r12 = this.intervals.iterator();
    L12:
        if (r12.hasNext() == false) goto L25;
        Interval r13 = r12.next();
        int r14 = r13.f665a;
        int r15 = r13.f666b;
        if (r14 != r15) goto L16;
        r5.append(elementName(r10, r14));
    L22:
        if (r12.hasNext() == false) goto L12;
        r5.append(", ");
        goto L12
    L16:
        int r16 = r14;
    L17:
        if (r16 > r15) goto L22;
        if (r16 <= r14) goto L20;
        r5.append(", ");
    L20:
        r5.append(elementName(r10, r16));
        r16 = r16 + 1;
        goto L17
    L25:
        if (size() <= 1) goto L28;
        r5.append("}");
    L28:
        return r5.toString();
    }
}
