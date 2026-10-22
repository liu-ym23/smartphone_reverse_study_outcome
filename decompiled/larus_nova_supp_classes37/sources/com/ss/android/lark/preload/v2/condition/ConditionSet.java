package com.ss.android.lark.preload.v2.condition;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.view.ItemViewType;
import g1c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ConditionSet {
    public final List<b<?>> a;
    public final List<Operator> b;
    public final Stack<Boolean> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/ConditionSet$Operator;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "AND", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum Operator extends Enum<Operator> {
        public static final Operator AND = null;
        public static final Operator OR = null;
        public static final /* synthetic */ Operator[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Operator> getEntries() {
            return b;
        }

        static {
            Operator r0 = new Operator("OR", 0);
            OR = r0;
            Operator r1 = new Operator("AND", 1);
            AND = r1;
            Operator[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Operator[] values() {
            return (Operator[]) a.clone();
        }

        public static Operator valueOf(String r1) {
            return (Operator) a.a(Operator.class, r1);
        }

        public Operator(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean b() {
        this.c.clear();
        boolean r1 = false;
        if (((ArrayList) this.a).size() > 0) goto L5;
        return false;
    L5:
        this.c.add(Boolean.valueOf(((b) ListProtector.get(this.a, 0)).isValid()));
        int r0 = 1;
    L7:
        if (r0 >= ((ArrayList) this.a).size()) goto L14;
        b r2 = (b) ListProtector.get(this.a, r0);
        if (ListProtector.get(this.b, r0 - 1) != Operator.OR) goto L11;
        this.c.add(Boolean.valueOf(r2.isValid()));
    L12:
        r0 = r0 + 1;
        goto L7
    L11:
        Boolean r3 = this.c.pop();
        this.c.add(Boolean.valueOf(r2.isValid() & r3.booleanValue()));
    L14:
        if (this.c.empty() == true) goto L16;
        r1 = r1 | this.c.pop().booleanValue();
        goto L14
    L16:
        return r1;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        b r2 = (b) r1.next();
        r0.append(r2.getClass().getSimpleName());
        r0.append(":");
        r0.append(r2.isValid());
        r0.append(", ");
        goto L4
    L6:
        r0.append("primary:");
        r0.append(null);
        return r0.toString();
    }

    public ConditionSet() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new Stack();
    }

    public final void a(g1c.a r3) {
        Intrinsics.checkNotNullParameter(r3, "condition");
        if ((!((ArrayList) this.a).isEmpty()) == false) goto L5;
        ((ArrayList) this.b).add(Operator.AND);
    L5:
        ((ArrayList) this.a).add(r3);
    }
}
