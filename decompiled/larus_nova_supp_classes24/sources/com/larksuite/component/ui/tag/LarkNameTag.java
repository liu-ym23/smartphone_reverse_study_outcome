package com.larksuite.component.ui.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sz7.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkNameTag {
    public static final /* synthetic */ int d = 0;
    public final HashMap<DrawableStateSet, UDTagsDrawable.a> a;
    public final float b;
    public final float c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larksuite/component/ui/tag/LarkNameTag$BlockLabelType;", "", "<init>", "(Ljava/lang/String;I)V", "TOTAL_BLOCKED", "STRANGER", "BLOCK", "NONE", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum BlockLabelType extends Enum<BlockLabelType> {
        public static final BlockLabelType BLOCK = null;
        public static final a Companion = null;
        public static final BlockLabelType NONE = null;
        public static final BlockLabelType STRANGER = null;
        public static final BlockLabelType TOTAL_BLOCKED = null;
        public static final /* synthetic */ BlockLabelType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BlockLabelType> getEntries() {
            return b;
        }

        static {
            BlockLabelType r0 = new BlockLabelType("TOTAL_BLOCKED", 0);
            TOTAL_BLOCKED = r0;
            BlockLabelType r1 = new BlockLabelType("STRANGER", 1);
            STRANGER = r1;
            BlockLabelType r3 = new BlockLabelType("BLOCK", 2);
            BLOCK = r3;
            BlockLabelType r5 = new BlockLabelType("NONE", 3);
            NONE = r5;
            BlockLabelType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static BlockLabelType[] values() {
            return (BlockLabelType[]) a.clone();
        }

        public static BlockLabelType valueOf(String r1) {
            return (BlockLabelType) r27.a.a(BlockLabelType.class, r1);
        }

        public BlockLabelType(String r1, int r2) {
            super(r1, r2);
        }

        @JvmStatic
        public static final BlockLabelType judge(boolean r1, boolean r2) {
            Companion.getClass();
            if (r1 == true) goto L9;
            if (r2 == false) goto L8;
            return STRANGER;
        L8:
            return NONE;
        L9:
            return TOTAL_BLOCKED;
        }
    }

    public static final class a extends b {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    public static class b extends c {
        public g08.a l;

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        public void g(List r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            if (r2.isEmpty() == false) goto L5;
            g08.a r3 = null;
        L6:
            this.l = r3;
            return;
        L5:
            r3 = (g08.a) ListProtector.get(r2, 0);
            goto L6
        }

        public final void h(com.larksuite.component.ui.tag.a r5, g08.a r6) {
            Intrinsics.checkNotNullParameter(r5, "tagProvider");
            if (r6 == null) goto L5;
            Integer r0 = Integer.valueOf(r6.b);
        L6:
            if (r0 == null) goto L11;
            if (r0.intValue() != 0) goto L11;
            return;
        L11:
            if (r0 != null) goto L14;
        L16:
            if (r0 != null) goto L19;
        L21:
            if (r0 != null) goto L24;
            return;
        L24:
            if (r0.intValue() != 3) goto L30;
            e(r5.a(r6.a), true);
            return;
        L30:
            return;
        L19:
            if (r0.intValue() != 2) goto L21;
            e(r5.a(r6.a), true);
            return;
        L14:
            if (r0.intValue() != 1) goto L16;
            e(r5.l, true);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static class c {
        public final Context a;
        public final com.larksuite.component.ui.tag.a b;
        public final DrawableStateSet[] c;
        public final LinkedHashMap<DrawableStateSet, UDTagsDrawable.a> d;
        public boolean e;
        public boolean f;
        public float g;
        public float h;
        public final ArrayList<HashSet<Integer>> i;
        public final ArrayList<Integer> j;
        public final HashMap<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> k;

        public LarkNameTag f() {
            Iterator<Map.Entry<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>>> r0 = this.k.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L38;
            Map.Entry<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> r1 = r0.next();
            DrawableStateSet r2 = r1.getKey();
            List<Pair<Integer, UDTagsDrawable.d>> r3 = r1.getValue();
            LinkedHashMap<DrawableStateSet, UDTagsDrawable.a> r4 = this.d;
            UDTagsDrawable.a r5 = r4.get(r2);
            if (r5 != null) goto L8;
            r5 = new UDTagsDrawable.a(this.a);
            r4.put(r2, r5);
        L8:
            UDTagsDrawable.a r6 = r5;
            if (r3.size() <= 1) goto L12;
            CollectionsKt.sortWith(r3, new com.larksuite.component.ui.tag.c());
        L12:
            if ((!r3.isEmpty()) == false) goto L18;
            if ((!this.j.isEmpty()) == false) goto L18;
            Pair r7 = (Pair) CollectionsKt.first(r3);
            if (this.j.contains(r7.getFirst()) == false) goto L18;
            r6.a((UDTagsDrawable.d) r7.getSecond());
        L18:
            HashSet r8 = new HashSet();
            int r9 = this.i.size();
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r3.iterator();
        L20:
            if (r11.hasNext() == false) goto L33;
            Object r12 = r11.next();
            Pair r13 = (Pair) r12;
            boolean r14 = r8.contains(r13.getFirst());
            if (r14 == true) goto L31;
            if (r9 <= 0) goto L31;
            Iterator<HashSet<Integer>> r15 = this.i.iterator();
        L26:
            if (r15.hasNext() == false) goto L31;
            HashSet<Integer> r16 = r15.next();
            if (r16.contains(r13.getFirst()) == false) goto L26;
            r8.addAll(r16);
            r9 = r9 - 1;
        L31:
            if ((!r14) == false) goto L20;
            r10.add(r12);
            goto L20
        L33:
            Iterator r17 = r10.iterator();
        L35:
            if (r17.hasNext() == false) goto L4;
            r6.a((UDTagsDrawable.d) ((Pair) r17.next()).getSecond());
            goto L35
        L38:
            return new LarkNameTag(this.d, this.g, this.h);
        }

        public final Context getContext() {
            return this.a;
        }

        public c(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r3;
            this.b = new com.larksuite.component.ui.tag.a();
            this.c = new DrawableStateSet[]{DrawableStateSet.EMPTY};
            this.d = new LinkedHashMap(2);
            this.i = new ArrayList();
            this.j = new ArrayList();
            new HashSet();
            this.k = new HashMap();
        }

        public final /* bridge */ /* synthetic */ c b(com.larksuite.component.ui.tag.b r1, boolean r2) {
            c(r1, r2);
            return this;
        }

        public final void c(com.larksuite.component.ui.tag.b r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "iconTag");
            if (r9 == false) goto L18;
            DrawableStateSet[] r10 = this.c;
            if (r10 == null) goto L22;
            int r1 = r10.length;
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L23;
            DrawableStateSet r3 = r10[r2];
            Intrinsics.checkNotNullParameter(r3, "stateSet");
            Intrinsics.checkNotNullParameter(r8, "iconTag");
            UDTagsDrawable.d.a r4 = new UDTagsDrawable.d.a(this.a);
            r4.b = r8.c;
            Context r5 = this.a;
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r3, "state");
            r4.e = (Drawable) r8.d.invoke(r5, r3);
            com.larksuite.component.ui.tag.b.a r6 = r8.a;
            String r7 = r6.e;
            if (r7 == null) goto L11;
            r4.c = r7;
        L11:
            UDTagsDrawable.TagColorSet r11 = r6.d;
            if (r11 == null) goto L14;
            r4.c(r11);
        L14:
            r8.a.getClass();
            Function2<? super Context, ? super DrawableStateSet, ? extends Drawable> r12 = r8.a.f;
            if (r12 == null) goto L17;
            Drawable r13 = (Drawable) r12.invoke(this.a, r3);
            Intrinsics.checkNotNullParameter(r13, "backgroundDrawable");
            r4.g = r13;
        L17:
            a(r3, r8.b, r4.b());
            r2 = r2 + 1;
            goto L7
        L23:
            return;
        L22:
            return;
        }

        public final /* bridge */ /* synthetic */ c d(com.larksuite.component.ui.tag.f r1, boolean r2) {
            e(r1, r2);
            return this;
        }

        public final void e(com.larksuite.component.ui.tag.f r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "textTag");
            if (r12 == false) goto L9;
            DrawableStateSet[] r13 = this.c;
            if (r13 == null) goto L11;
            int r1 = r13.length;
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L12;
            DrawableStateSet r3 = r13[r2];
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r11, "textTag");
            int r5 = r11.b;
            UDTagsDrawable.d.a r6 = new UDTagsDrawable.d.a(this.a);
            r6.b = r11.c;
            Context r7 = this.a;
            Intrinsics.checkNotNullParameter(r7, "context");
            r6.c = (String) r11.d.invoke(r7);
            Context r8 = this.a;
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r3, "state");
            r6.d = ((Number) r11.e.invoke(r8, r3)).intValue();
            Context r9 = this.a;
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r3, "state");
            r6.a(((Number) r11.f.invoke(r9, r3)).intValue());
            a(r3, r5, r6.b());
            r2 = r2 + 1;
            goto L7
        L12:
            return;
        L11:
            return;
        }

        public final void a(DrawableStateSet r3, int r4, UDTagsDrawable.d r5) {
            HashMap<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> r0 = this.k;
            List<Pair<Integer, UDTagsDrawable.d>> r1 = r0.get(r3);
            if (r1 != null) goto L5;
            r1 = new ArrayList();
            r0.put(r3, r1);
        L5:
            r1.add(TuplesKt.to(Integer.valueOf(r4), r5));
        }
    }

    public static final class d extends b {
        public static final List<HashSet<Integer>> D = null;
        public static final List<Integer> E = null;
        public boolean A;
        public List<g08.a> B;
        public BlockLabelType C;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        public static final class a {
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BlockLabelType.values().length];
                r0[BlockLabelType.TOTAL_BLOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[BlockLabelType.BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
            com.larksuite.component.ui.tag.f r3 = TagProviderKt.b;
            D = CollectionsKt.listOf(new HashSet[]{SetsKt.hashSetOf(new Integer[]{Integer.valueOf(r3.b), Integer.valueOf(TagProviderKt.c.b), Integer.valueOf(TagProviderKt.d.b), Integer.valueOf(TagProviderKt.e.b), Integer.valueOf(TagProviderKt.f.b), 65573}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(r3.b), Integer.valueOf(TagProviderKt.n.b), Integer.valueOf(TagProviderKt.m.b)}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.g.b), Integer.valueOf(TagProviderKt.h.b)})});
            E = CollectionsKt.listOf(Integer.valueOf(TagProviderKt.a.b));
        }

        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            Iterator<T> r0 = D.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            HashSet<Integer> r1 = (HashSet) r0.next();
            Intrinsics.checkNotNullParameter(r1, "constraint");
            this.i.add(r1);
            goto L4
        L6:
            List<Integer> r2 = E;
            Intrinsics.checkNotNullParameter(r2, "constraint");
            this.j.addAll(r2);
            e(this.b.h, this.y);
            e(this.b.i, this.A);
            if (this.n == true) goto L9;
        L12:
            c(this.b.c, this.q);
            com.larksuite.component.ui.tag.f r3 = this.b.d;
            if (this.p == false) goto L17;
            boolean r4 = v.a;
            if (v.a.a() == false) goto L17;
            boolean r5 = true;
        L18:
            e(r3, r5);
            com.larksuite.component.ui.tag.f r6 = this.b.e;
            if (this.m == false) goto L23;
            boolean r7 = v.a;
            if (v.a.a() == false) goto L23;
            boolean r8 = true;
        L24:
            e(r6, r8);
            e(this.b.a, this.r);
            e(this.b.b, this.s);
            e(this.b.l, this.e);
            e(this.b.t, this.f);
            e(this.b.q, this.v);
            e(this.b.n, this.t);
            e(this.b.r, this.w);
            c(this.b.j, this.x);
            e(this.b.u, this.z);
            e(this.b.o, this.u);
            e(this.b.k, false);
            h(this.b, this.l);
            BlockLabelType r9 = this.C;
            int r10 = b.a[r9.ordinal()];
            if (r10 != 1) goto L27;
            e(this.b.w, true);
        L31:
            Iterator r11 = ((ArrayList) this.B).iterator();
        L33:
            if (r11.hasNext() == false) goto L38;
            String r12 = ((g08.a) r11.next()).a;
            if (r12 == null) goto L33;
            this.b.getClass();
            Intrinsics.checkNotNullParameter(r12, "text");
            com.larksuite.component.ui.tag.f r13 = TagProviderKt.a;
            Intrinsics.checkNotNullParameter(r12, "labelText");
            int r14 = com.larksuite.component.ui.tag.f.g;
            com.larksuite.component.ui.tag.f.a r15 = new com.larksuite.component.ui.tag.f.a();
            r15.a = 65574;
            r15.b = 101;
            r15.d = r12;
            r15.e = 2131109120;
            r15.g = 2131109089;
            d(new com.larksuite.component.ui.tag.f(r15), true);
            goto L33
        L38:
            return super.f();
        L27:
            if (r10 == 2) goto L29;
            Unit r16 = Unit.INSTANCE;
            goto L31
        L29:
            e(this.b.w, true);
        L23:
            r8 = false;
        L17:
            r5 = false;
            goto L18
        L9:
            if (this.o == false) goto L11;
            b(this.b.g, true);
            goto L12
        L11:
            b(this.b.f, true);
            goto L12
        }

        public d(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.B = new ArrayList();
            this.C = BlockLabelType.NONE;
        }

        @Override // com.larksuite.component.ui.tag.LarkNameTag.b
        public final void g(List r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            List r6 = r5;
            ArrayList r0 = new ArrayList();
            Iterator r1 = r6.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Object r2 = r1.next();
            if (g08.b.a(((g08.a) r2).b) == false) goto L4;
            r0.add(r2);
            goto L4
        L8:
            super.g(r0);
            ArrayList r3 = new ArrayList();
            Iterator r7 = r6.iterator();
        L10:
            if (r7.hasNext() == false) goto L17;
            Object r4 = r7.next();
            if (((g08.a) r4).b != 4) goto L14;
            boolean r8 = true;
        L15:
            if (r8 == false) goto L10;
            r3.add(r4);
            goto L10
        L14:
            r8 = false;
            goto L15
        L17:
            this.B = r3;
        }
    }

    public static final class e extends b {
        public final List<HashSet<Integer>> m;

        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            Iterator<T> r0 = this.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            HashSet<Integer> r1 = (HashSet) r0.next();
            Intrinsics.checkNotNullParameter(r1, "constraint");
            this.i.add(r1);
            goto L4
        L7:
            if (this.f == false) goto L10;
            e(this.b.m, true);
        L12:
            h(this.b, this.l);
            return super.f();
        L10:
            if (this.e == false) goto L12;
            e(this.b.l, true);
            goto L12
        }

        public e(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            super(r7);
            this.m = CollectionsKt.listOf(new HashSet[]{SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.e.b), Integer.valueOf(TagProviderKt.d.b), 65573}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.s.b), Integer.valueOf(TagProviderKt.p.b), Integer.valueOf(TagProviderKt.q.b), Integer.valueOf(TagProviderKt.o.b)})});
        }
    }

    public static final class f {
        @JvmStatic
        public static d a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return new d(r1);
        }
    }

    public static final class g extends b {
        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            if (this.e == false) goto L5;
            d(this.b.l, true);
        L5:
            h(this.b, this.l);
            return super.f();
        }

        public g(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    static {
    }

    public LarkNameTag() {
        throw null;
    }

    public final com.larksuite.component.ui.tag.d b() {
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r0 = this.a.entrySet().iterator();
        com.larksuite.component.ui.tag.d r1 = null;
    L4:
        if (r0.hasNext() == false) goto L22;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r2 = r0.next();
        DrawableStateSet r3 = r2.getKey();
        UDTagsDrawable.a r4 = r2.getValue();
        float r5 = this.b;
        boolean r6 = true;
        if (r5 != 0.0f) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        r4.b = r5;
    L11:
        float r7 = this.c;
        if (r7 == 0.0f) goto L15;
        r6 = false;
    L15:
        if (r6 == true) goto L17;
        r4.h = r7;
    L17:
        UDTagsDrawable r9 = r4.b();
        if (r9 == null) goto L4;
        if (r1 != null) goto L21;
        r1 = new com.larksuite.component.ui.tag.d();
    L21:
        Intrinsics.checkNotNull(r1);
        r1.setBounds(r9.getBounds());
        r1.addState(r3.getStateSet(), r9);
        goto L4
    L8:
        r8 = false;
        goto L9
    L22:
        return r1;
    }

    public final int hashCode() {
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r0 = this.a.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r2 = r0.next();
        DrawableStateSet r3 = r2.getKey();
        r1 = r1 + (r2.getValue().hashCode() << r3.ordinal());
        goto L4
    L7:
        return r1 + (Float.floatToIntBits(this.b) + Float.floatToIntBits(this.c));
    }

    public final void c(TextView r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Drawable[] r0 = r6.getCompoundDrawables();
        if (a(r0[2], this.a) == true) goto L6;
        r6.setCompoundDrawablePadding(15);
        r6.setCompoundDrawables(r0[0], r0[1], b(), r0[3]);
        return;
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 == null) goto L8;
        Class<?> r2 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(LarkNameTag.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larksuite.component.ui.tag.LarkNameTag");
        LarkNameTag r8 = (LarkNameTag) r7;
        if (this.b != r8.b) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (this.c != r8.c) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L25;
        return false;
    L25:
        if (r8.a.size() != this.a.size()) goto L32;
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r4 = this.a.entrySet().iterator();
    L28:
        if (r4.hasNext() == false) goto L32;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r5 = r4.next();
        DrawableStateSet r6 = r5.getKey();
        UDTagsDrawable.a r9 = r5.getValue();
        if (Intrinsics.areEqual(r8.a.get(r6), r9) == true) goto L28;
        return false;
    L32:
        return true;
    L21:
        r3 = false;
        goto L22
    L15:
        r1 = false;
        goto L16
    L8:
        r2 = null;
        goto L10
    }

    public static boolean a(Drawable r4, HashMap r5) {
        if ((r4 instanceof com.larksuite.component.ui.tag.d) == false) goto L22;
        com.larksuite.component.ui.tag.d r6 = (com.larksuite.component.ui.tag.d) r4;
        if (r6.a.size() != r5.size()) goto L22;
        Iterator r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L20;
        Map.Entry r0 = (Map.Entry) r7.next();
        DrawableStateSet r2 = (DrawableStateSet) r0.getKey();
        UDTagsDrawable.a r1 = (UDTagsDrawable.a) r0.getValue();
        int[] r3 = r2.getStateSet();
        if (r3 == null) goto L12;
        Drawable r8 = r6.a.get(r3);
    L13:
        boolean r9 = r8 instanceof UDTagsDrawable;
        if (r9 == false) goto L15;
        if (r9 == false) goto L19;
        if (((UDTagsDrawable) r8).hashCode() == r1.hashCode()) goto L8;
    L19:
        return false;
    L15:
        return false;
    L12:
        r8 = null;
        goto L13
    L20:
        return true;
    L22:
        return false;
    }

    public LarkNameTag(HashMap r1, float r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
