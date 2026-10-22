package com.bytedance.android.live.profile.standard.honour;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileStandardHonourWallComponent extends DataAssembler<st0.e> {
    public static final a u = null;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final int k;
    public final int l;
    public final Lazy m;
    public final Lazy n;
    public final Map<Integer, b> o;
    public int p;
    public int q;
    public int r;
    public Disposable s;
    public final l t;

    public static final class a {
        public a() {
        }

        public static int a(List r3, boolean r4) {
            int r0 = 0;
            if (r3 == null) goto L21;
            List r5 = CollectionsKt.filterNotNull(r3);
            if (r5 == null) goto L25;
            int r6 = r5.size();
            if (r4 == false) goto L15;
            switch(r6) {
                case 0: goto L22;
                case 1: goto L14;
                case 2: goto L14;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L13;
                case 6: goto L13;
                default: goto L10;
            };
        L10:
            int r7 = r6 / 3;
            if ((r6 % 3) == 0) goto L20;
        L18:
            r0 = 1;
        L20:
            return r0 + r7;
        L13:
            return 2;
        L14:
            return 1;
        L22:
            return 0;
        L15:
            r7 = r6 / 2;
            if ((r6 % 2) != 0) goto L18;
        L25:
            return 0;
        L21:
            return 0;
        }
    }

    public static final class b {
        public final int a;
        public final bt0.a b;
        public final bt0.c c;
        public final HonorWallElement d;
        public final c e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            bt0.a r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            bt0.c r5 = this.c;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            HonorWallElement r8 = this.d;
            if (r8 == null) goto L13;
            int r9 = r8.hashCode();
        L14:
            int r10 = (r7 + r9) * 31;
            c r12 = this.e;
            if (r12 == null) goto L18;
            r2 = r12.hashCode();
        L18:
            return r10 + r2;
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "HonourCardCache(id=" + this.a + ", item=" + this.b + ", cardView=" + this.c + ", elementInfo=" + this.d + ", spreadInfo=" + this.e + ")";
        }

        public b(int r2, bt0.a r3, bt0.c r4, HonorWallElement r5, c r6) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "cardView");
            Intrinsics.checkNotNullParameter(r5, "elementInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class c {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return r3 + r1;
        }

        public final String toString() {
            return "SpreadInfo(canSpread=" + this.a + ", spread=" + this.b + ")";
        }

        public c(boolean r1) {
            this.a = r1;
            this.b = false;
        }
    }

    public static final class d extends vt0.b {
        public final /* synthetic */ bt0.a d;
        public final /* synthetic */ HonorWallElement e;
        public final /* synthetic */ ProfileStandardHonourWallComponent f;
        public final /* synthetic */ h g;
        public final /* synthetic */ NewProfileUser h;

        @Override // vt0.b
        public final void a(View r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            ProfileStandardHonourWallComponent.o(this.f, r7, this.d, this.e, this.h, this.g);
        }

        public d(bt0.a r1, HonorWallElement r2, ProfileStandardHonourWallComponent r3, h r4, NewProfileUser r5) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
        }
    }

    public static final class e extends vt0.b {
        public final /* synthetic */ bt0.a d;
        public final /* synthetic */ mt0.a e;
        public final /* synthetic */ ProfileStandardHonourWallComponent f;
        public final /* synthetic */ h g;
        public final /* synthetic */ Map h;
        public final /* synthetic */ NewProfileUser i;

        @Override // vt0.b
        public final void a(View r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            ProfileStandardHonourWallComponent.o(this.f, r7, this.d, (HonorWallElement) this.e.b, this.i, this.g);
        }

        public e(bt0.a r1, mt0.a r2, ProfileStandardHonourWallComponent r3, h r4, Map r5, NewProfileUser r6) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
        }
    }

    public static final class f extends vt0.b {
        public final /* synthetic */ b d;
        public final /* synthetic */ mt0.a e;
        public final /* synthetic */ ProfileStandardHonourWallComponent f;
        public final /* synthetic */ h g;
        public final /* synthetic */ Map h;
        public final /* synthetic */ NewProfileUser i;

        @Override // vt0.b
        public final void a(View r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            ProfileStandardHonourWallComponent.o(this.f, r7, this.d.b, (HonorWallElement) this.e.b, this.i, this.g);
        }

        public f(b r1, mt0.a r2, ProfileStandardHonourWallComponent r3, h r4, Map r5, NewProfileUser r6) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
        }
    }

    public final h q() {
        return (h) this.g.getValue();
    }

    static {
        u = new a();
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Iterator r0 = ((LinkedHashMap) this.o).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ((Map.Entry) r0.next()).getValue()).c.f();
        goto L4
    L6:
        ((LinkedHashMap) this.o).clear();
        UtilityKotlinExtentionsKt.q(this.f);
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.StandardHonourWall.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r10) {
        Intrinsics.checkNotNullParameter(r10, "user");
        Intrinsics.checkNotNullParameter(r10, "user");
        Intrinsics.checkNotNullParameter(r10, "user");
        Iterator r12 = ((LinkedHashMap) this.o).entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L60;
        Map.Entry r0 = (Map.Entry) r12.next();
        bt0.a r1 = ((b) r0.getValue()).b;
        boolean r3 = false;
        LinkedHashMap r4 = null;
        if ((r1 instanceof ct0.a) == false) goto L18;
        ct0.a r2 = (ct0.a) r1;
        HonorWallElement r5 = ((b) r0.getValue()).d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "elementInfo");
        ExtraInfo r6 = r5.getExtraInfo();
        if (r6 == null) goto L10;
        Map r7 = r6.getGlobalShowEventParams();
    L11:
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L14;
        r8.putAll(r7);
    L14:
        r8.put("id", String.valueOf(r5.getId()));
        h r9 = r2.a;
        if (r9 == null) goto L17;
        r9.sendLog("livesdk_usercard_honor_wall_show", r8, new Object[0]);
    L17:
        r2.j(r5);
    L19:
        ((b) r0.getValue()).c.onViewShow();
        String r13 = ((b) r0.getValue()).d.getName();
        if (r13 == null) goto L22;
        this.t.b().recordBusinessShow(TrackArea.BottomOperatingArea, r13);
    L22:
        ((b) r0.getValue()).b.b(((b) r0.getValue()).d);
        if (((ss0.c) y.a.getValue()).g() == false) goto L51;
        ExtraInfo r14 = ((b) r0.getValue()).d.getExtraInfo();
        if (r14 == null) goto L51;
        Map r15 = r14.getShowEventParams();
        if (r15 == null) goto L51;
        r4 = new LinkedHashMap();
        Iterator r16 = r15.entrySet().iterator();
    L30:
        if (r16.hasNext() == false) goto L51;
        Map.Entry r17 = (Map.Entry) r16.next();
        CharSequence r18 = (CharSequence) r17.getKey();
        if (r18 != null) goto L34;
    L37:
        boolean r19 = true;
    L38:
        if (r19 == true) goto L48;
        CharSequence r20 = (CharSequence) r17.getValue();
        if (r20 != null) goto L42;
    L45:
        boolean r22 = true;
    L46:
        if (r22 == true) goto L48;
        boolean r23 = true;
    L49:
        if (r23 == false) goto L30;
        r4.put(r17.getKey(), r17.getValue());
        goto L30
    L42:
        if (r20.length() == 0) goto L45;
        r22 = false;
    L48:
        r23 = false;
        goto L49
    L34:
        if (r18.length() == 0) goto L37;
        r19 = false;
    L51:
        if (r4 != null) goto L53;
    L54:
        r3 = true;
    L55:
        if (r3 == true) goto L4;
        LinkedHashMap r24 = new LinkedHashMap();
        if (r4 == null) goto L59;
        r24.putAll(r4);
    L59:
        this.t.b().recordShowMap(r24);
        goto L4
    L53:
        if (r4.isEmpty() == false) goto L55;
    L10:
        r7 = null;
        goto L11
    L18:
        r1.j(((b) r0.getValue()).d);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r22) {
        Intrinsics.checkNotNullParameter(r22, "user");
        com.bytedance.android.live.profile.profilecontext.a r8 = this.t.b();
        if (r8 != null) goto L5;
        return;
    L5:
        s(r22);
        if (q().isMyLive() == false) goto L18;
        this.p = i.d(q());
        a r0 = u;
        ProfileOpenArea r1 = q().getTargetUser().openArea;
        if (r1 == null) goto L12;
        ProfileBusinessArea r2 = r1.businessAreaV3;
        if (r2 == null) goto L12;
        List r3 = r2.bottomElementList;
    L13:
        boolean r4 = q().isVertical();
        r0.getClass();
        this.q = a.a(r3, r4);
        int r5 = this.p;
        if (r5 >= 2) goto L16;
        int r6 = 2 - r5;
    L17:
        this.r = r6;
        goto L18
    L16:
        r6 = 0;
    L12:
        r3 = null;
    L18:
        List<HonorWallElement> r7 = r(r22.getHonourWallData(), r22, r8);
        if (r7 == null) goto L134;
        List r9 = CollectionsKt.filterNotNull(r7);
        if (r9 == null) goto L136;
        int r12 = r9.size();
        Iterator r13 = r9.iterator();
        int r10 = 0;
    L25:
        if (r13.hasNext() == false) goto L116;
        Object r14 = r13.next();
        int r15 = r10 + 1;
        if (r10 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        HonorWallElement r16 = (HonorWallElement) r14;
        bt0.a r17 = (bt0.a) ((Map) this.m.getValue()).get(Integer.valueOf(r16.getId()));
        if (r17 != null) goto L32;
        r17 = new ct0.a();
    L32:
        com.bytedance.android.live.profile.profilecontext.d.a(r17, r8);
        View r18 = r17.e(r8, this.f.getContext());
        com.bytedance.android.live.profile.profilecontext.d.a(r18, r8);
        this.f.addView(r18, p(r10, r8, r12));
        boolean r19 = r18 instanceof bt0.c;
        if (r19 == true) goto L35;
        Object r110 = null;
    L36:
        bt0.c r111 = (bt0.c) r110;
        if (r111 == null) goto L103;
        Map<Integer, b> r112 = this.o;
        Integer r113 = Integer.valueOf(r16.getId());
        int r114 = r16.getId();
        if (q().isMyLive() == true) goto L42;
    L96:
        c r20 = null;
    L102:
        r112.put(r113, new b(r114, r17, r111, r16, r20));
        goto L103
    L42:
        if (q().isVertical() == true) goto L44;
        int r23 = r15 / 2;
        if ((r15 % 2) != 0) goto L92;
    L91:
        int r24 = 0;
    L93:
        int r25 = r23 + r24;
    L95:
        if (r25 == (-1)) goto L96;
        if (r25 > this.r) goto L100;
        c r26 = new c(false);
    L101:
        r20 = r26;
        goto L102
    L100:
        r26 = new c(true);
    L92:
        r24 = 1;
        goto L93
    L44:
        if (r12 < 0) goto L49;
        if (3 < r12) goto L49;
    L74:
        r25 = 1;
    L49:
        if (4 > r12) goto L86;
        if (6 < r12) goto L86;
        if (r12 != 4) goto L58;
        if (r10 < 0) goto L58;
        if (1 >= r10) goto L74;
    L58:
        if (r12 != 4) goto L66;
        if (2 > r10) goto L66;
        if (3 < r10) goto L66;
    L84:
        r25 = 2;
    L66:
        if (5 > r12) goto L76;
        if (6 < r12) goto L76;
        if (r10 < 0) goto L76;
        if (2 >= r10) goto L74;
    L76:
        if (5 <= r12) goto L79;
    L85:
        r25 = -1;
        goto L95
    L79:
        if (6 < r12) goto L85;
        if (3 > r10) goto L85;
        if (5 < r10) goto L85;
    L86:
        r23 = r15 / 3;
        if ((r15 % 3) != 0) goto L92;
    L103:
        if (r19 == false) goto L114;
        if ((r18 instanceof bt0.e) == true) goto L107;
        Object r27 = null;
    L108:
        bt0.e r28 = (bt0.e) r27;
        if (r28 == null) goto L112;
        r17.m();
        com.bytedance.android.live.profile.profilecontext.d.a(null, r8);
        bt0.b r29 = r17.i();
        com.bytedance.android.live.profile.profilecontext.d.a(r29, r8);
        r28.q(null, r29);
    L112:
        bt0.c r30 = (bt0.c) r18;
        r30.c();
        r30.l(r17, r16, r22, r8);
        r30.g();
        goto L114
    L107:
        r27 = r18;
    L114:
        r18.setOnClickListener(new d(r17, r16, this, r8, r22));
        r10 = r15;
        goto L25
    L35:
        r110 = r18;
        goto L36
    L116:
        if (this.q > this.r) goto L118;
    L124:
        com.bytedance.android.live.profile.profilecontext.a r32 = this.t.b();
        if (r32.isMyLive() == false) goto L135;
        Disposable r33 = this.s;
        if (r33 == null) goto L129;
        r33.dispose();
    L129:
        this.s = r32.getEventHub().b.subscribe(new com.bytedance.android.live.profile.standard.honour.c(this));
        return;
    L135:
        return;
    L118:
        if (q().isMyLive() == false) goto L124;
        int r34 = this.r;
        if (r34 > 0) goto L123;
        a1.k(this.f, 0);
        goto L124
    L123:
        a1.k(this.f, (this.l * r34) + ((r34 - 1) * UtilityKotlinExtentionsKt.i(6)));
        goto L124
    L136:
        return;
    }

    public final void s(NewProfileUser r3) {
        ViewGroup r0 = this.f;
        if ((r0 instanceof FlowLayout) == true) goto L5;
        r0 = null;
    L5:
        FlowLayout r1 = (FlowLayout) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r3.useStandardHonorWallV3() == false) goto L10;
        r1.setItemSpacing(UtilityKotlinExtentionsKt.i(6));
        r1.setLineSpacing(UtilityKotlinExtentionsKt.i(6));
        return;
    L10:
        r1.setItemSpacing(UtilityKotlinExtentionsKt.i(8));
        r1.setLineSpacing(UtilityKotlinExtentionsKt.i(8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r26) {
        Intrinsics.checkNotNullParameter(r26, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileStandardHonourWallComponent update");
        com.bytedance.android.live.profile.profilecontext.a r9 = this.t.b();
        if (r9 != null) goto L6;
        return;
    L6:
        if (i.f(r9) == true) goto L8;
    L23:
        ALogger.i("NewUserProfile_ProfilePre", "honour wall update normal");
        List<HonorWallElement> r1 = r(r26.getHonourWallData(), r26, r9);
        if (r1 == null) goto L27;
        List r2 = CollectionsKt.filterNotNull(r1);
        if (r2 == null) goto L27;
    L28:
        int r3 = mt0.c.a;
        mt0.b r4 = mt0.c.a(r2, this.o, AnonymousClass1.INSTANCE);
        List<mt0.a<TYPE, BEAN>> r5 = r4.a;
        Iterable r10 = r4.b;
        StringBuilder r6 = new StringBuilder("HonourWall preload: ");
        Map<Integer, b> r7 = this.o;
        ArrayList r8 = new ArrayList(r7.size());
        Iterator r12 = ((LinkedHashMap) r7).entrySet().iterator();
    L30:
        if (r12.hasNext() == false) goto L32;
        Map.Entry r13 = (Map.Entry) r12.next();
        r8.add(TuplesKt.to(String.valueOf(((Number) r13.getKey()).intValue()), ((b) r13.getValue()).b.getClass().getSimpleName()));
        goto L30
    L32:
        r6.append(r8);
        ALogger.e("NewUserProfile_ProfilePre", r6.toString());
        StringBuilder r14 = new StringBuilder("HonourWall update: willLoad=");
        List<mt0.a<TYPE, BEAN>> r15 = r5;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L34:
        if (r17.hasNext() == false) goto L36;
        mt0.a r18 = (mt0.a) r17.next();
        r16.add(TuplesKt.to(r18.getType(), r18.c.getDesc()));
        goto L34
    L36:
        r14.append(r16);
        ALogger.e("NewUserProfile_ProfilePre", r14.toString());
        ALogger.e("NewUserProfile_ProfilePre", "HonourWall update: remove=" + r10);
        LinkedHashMap r19 = new LinkedHashMap();
        this.f.removeAllViews();
        s(r26);
        int r110 = r5.size();
        Iterator r111 = r5.iterator();
        int r0 = 0;
    L38:
        if (r111.hasNext() == false) goto L81;
        Object r20 = r111.next();
        int r112 = r0 + 1;
        if (r0 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        mt0.a r113 = (mt0.a) r20;
        int r22 = com.bytedance.android.live.profile.standard.honour.b.a[r113.c.ordinal()];
        bt0.c r23 = null;
        if (r22 != 1) goto L45;
        r10 = r10;
        r111 = r111;
        r112 = r112;
        bt0.a r24 = (bt0.a) ((Map) this.m.getValue()).get(Integer.valueOf(((Number) r113.getType()).intValue()));
        if (r24 != null) goto L62;
        r24 = new ct0.a();
    L62:
        com.bytedance.android.live.profile.profilecontext.d.a(r24, r9);
        View r114 = r24.e(r9, this.f.getContext());
        com.bytedance.android.live.profile.profilecontext.d.a(r114, r9);
        boolean r25 = r114 instanceof bt0.c;
        if (r25 == true) goto L65;
        Object r27 = null;
    L66:
        bt0.c r28 = (bt0.c) r27;
        if (r28 == null) goto L69;
        r19.put(r113.getType(), new b(((Number) r113.getType()).intValue(), r24, r28, (HonorWallElement) r113.b, null));
    L69:
        this.f.addView(r114, p(r0, r9, r110));
        if (r25 == true) goto L72;
    L79:
        r114.setOnClickListener(new e(r24, r113, this, r9, r19, r26));
    L80:
        r111 = r111;
        r0 = r112;
        r10 = r10;
        goto L38
    L72:
        if ((r114 instanceof bt0.e) == true) goto L74;
        Object r29 = null;
    L75:
        bt0.e r30 = (bt0.e) r29;
        if (r30 == null) goto L78;
        r24.m();
        com.bytedance.android.live.profile.profilecontext.d.a(null, r9);
        bt0.b r32 = r24.i();
        com.bytedance.android.live.profile.profilecontext.d.a(r32, r9);
        r30.q(null, r32);
    L78:
        bt0.c r33 = (bt0.c) r114;
        r33.c();
        r33.l(r24, (HonorWallElement) r113.b, r26, r9);
        r33.g();
        goto L79
    L74:
        r29 = r114;
        goto L75
    L65:
        r27 = r114;
        goto L66
    L45:
        if (r22 != 2) goto L49;
        b r34 = (b) ((LinkedHashMap) this.o).get(r113.getType());
        if (r34 == null) goto L49;
        r19.put(r113.getType(), r34);
        bt0.c r35 = r34.c;
        if ((r35 instanceof View) == false) goto L54;
        r23 = r35;
    L54:
        View r36 = (View) r23;
        if (r36 == null) goto L58;
        this.f.addView(r36, p(r0, r9, r110));
        r36.setOnClickListener(new f(r34, r113, this, r9, r19, r26));
    L58:
        r34.c.update(r34.b, (HonorWallElement) r113.b, r26, r9);
    L49:
        r10 = r10;
        r111 = r111;
        r112 = r112;
        goto L80
    L81:
        Iterator r37 = r10.iterator();
    L83:
        if (r37.hasNext() == false) goto L88;
        int r38 = ((Number) r37.next()).intValue();
        b r39 = (b) ((LinkedHashMap) this.o).get(Integer.valueOf(r38));
        if (r39 == null) goto L83;
        r39.c.f();
        goto L83
    L88:
        ((LinkedHashMap) this.o).clear();
        this.o.putAll(r19);
        return;
    L27:
        r2 = CollectionsKt.emptyList();
        goto L28
    L8:
        if (((ss0.c) y.a.getValue()).e() == false) goto L23;
        ALogger.i("NewUserProfile_ProfilePre", "honour wall version change");
        StringBuilder r40 = new StringBuilder("honour wall preload: ");
        Map<Integer, b> r42 = this.o;
        ArrayList r43 = new ArrayList(r42.size());
        Iterator r44 = ((LinkedHashMap) r42).entrySet().iterator();
    L11:
        if (r44.hasNext() == false) goto L13;
        Map.Entry r45 = (Map.Entry) r44.next();
        r43.add(TuplesKt.to(String.valueOf(((Number) r45.getKey()).intValue()), ((b) r45.getValue()).b.getClass().getSimpleName()));
        goto L11
    L13:
        r40.append(r43);
        ALogger.i("NewUserProfile_ProfilePre", r40.toString());
        Iterator r46 = ((LinkedHashMap) this.o).entrySet().iterator();
    L15:
        if (r46.hasNext() == false) goto L17;
        ((b) ((Map.Entry) r46.next()).getValue()).c.f();
        goto L15
    L17:
        ((LinkedHashMap) this.o).clear();
        this.f.removeAllViews();
        g(r26);
        StringBuilder r47 = new StringBuilder("honour wall loaded: ");
        Map<Integer, b> r48 = this.o;
        ArrayList r49 = new ArrayList(r48.size());
        Iterator r50 = ((LinkedHashMap) r48).entrySet().iterator();
    L19:
        if (r50.hasNext() == false) goto L21;
        Map.Entry r52 = (Map.Entry) r50.next();
        r49.add(TuplesKt.to(String.valueOf(((Number) r52.getKey()).intValue()), ((b) r52.getValue()).b.getClass().getSimpleName()));
        goto L19
    L21:
        r47.append(r49);
        ALogger.i("NewUserProfile_ProfilePre", r47.toString());
    }

    public ProfileStandardHonourWallComponent(l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r2, r3);
        this.t = r2;
        this.g = LazyKt.lazy(new ProfileStandardHonourWallComponent$profileContext$2(this));
        this.h = LazyKt.lazy(new ProfileStandardHonourWallComponent$default2CardWidthV3$2(this));
        this.i = LazyKt.lazy(new ProfileStandardHonourWallComponent$default3CardWidthV3$2(this));
        this.j = LazyKt.lazy(ProfileStandardHonourWallComponent$defaultVerticalCardWidth$2.INSTANCE);
        this.k = UtilityKotlinExtentionsKt.i(109);
        this.l = UtilityKotlinExtentionsKt.i(48);
        this.m = LazyKt.lazy(ProfileStandardHonourWallComponent$customHonourCardItems$2.INSTANCE);
        this.n = LazyKt.lazy(ProfileStandardHonourWallComponent$preProcessorList$2.INSTANCE);
        this.o = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter((st0.e) r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    public final ViewGroup.LayoutParams p(int r2, h r3, int r4) {
        if (r3.getTargetUser().useStandardHonorWallV3() == false) goto L17;
        if (r3.isVertical() == true) goto L7;
        int r5 = ((Number) this.h.getValue()).intValue();
    L25:
        return new ViewGroup.LayoutParams(r5, this.l);
    L7:
        if (r4 != 1) goto L9;
    L13:
        r5 = ((Number) this.h.getValue()).intValue();
        goto L25
    L9:
        if (r4 == 2) goto L13;
        if (r4 == 4) goto L13;
        r5 = ((Number) this.i.getValue()).intValue();
        goto L25
    L17:
        if (r3.isVertical() == true) goto L26;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(this.k, this.l);
        if (r2 != 0) goto L22;
        int r7 = 0;
    L23:
        r6.leftMargin = r7;
        return r6;
    L22:
        r7 = UtilityKotlinExtentionsKt.i(8);
        goto L23
    L26:
        return new ViewGroup.LayoutParams(((Number) this.j.getValue()).intValue(), this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<HonorWallElement> r(List<? extends HonorWallElement> r2, NewProfileUser r3, h r4) {
        Iterator r5 = ((List) this.n.getValue()).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        com.bytedance.android.live.profile.profilecontext.d.a(r6, r4);
        bt0.d r7 = (bt0.d) r6;
        List<? extends HonorWallElement> r0 = r7.process();
        if (r7.a() == true) goto L9;
        r2 = r0;
        goto L4
    L9:
        return r0;
    L12:
        return r2;
    }

    public static final void o(ProfileStandardHonourWallComponent r9, View r10, bt0.a r12, HonorWallElement r13, NewProfileUser r14, h r15) {
        r9.getClass();
        if (r12.n(r13, r14, r15) == false) goto L67;
        String r0 = r13.getName();
        Map r2 = null;
        if (r0 == null) goto L48;
        r12.k(r13);
        boolean r4 = true;
        if (((ss0.c) y.a.getValue()).f() == false) goto L35;
        ExtraInfo r3 = r13.getExtraInfo();
        if (r3 == null) goto L35;
        Map r5 = r3.getClickEventParams();
        if (r5 == null) goto L35;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = r5.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L36;
        Map.Entry r8 = (Map.Entry) r7.next();
        CharSequence r16 = (CharSequence) r8.getKey();
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == true) goto L32;
        CharSequence r18 = (CharSequence) r8.getValue();
        if (r18 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == true) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == false) goto L14;
        r6.put(r8.getKey(), r8.getValue());
        goto L14
    L26:
        if (r18.length() == 0) goto L29;
        r19 = false;
    L32:
        r20 = false;
        goto L33
    L18:
        if (r16.length() == 0) goto L21;
        r17 = false;
    L36:
        if (r6 != null) goto L38;
    L41:
        if (r4 == true) goto L45;
        LinkedHashMap r22 = new LinkedHashMap();
        if (r6 == null) goto L46;
        r22.putAll(r6);
    L46:
        r15.recordBusinessClick(r0, r22);
        goto L48
    L45:
        r22 = null;
        goto L46
    L38:
        if (r6.isEmpty() == true) goto L41;
        r4 = false;
    L35:
        r6 = null;
    L48:
        if ((r12 instanceof ct0.a) == false) goto L59;
        ct0.a r23 = (ct0.a) r12;
        Fragment r24 = r9.e.getHostFragment();
        Intrinsics.checkNotNullParameter(r24, "fragment");
        Intrinsics.checkNotNullParameter(r10, "honourCardView");
        Intrinsics.checkNotNullParameter(r13, "elementInfo");
        Intrinsics.checkNotNullParameter(r14, "user");
        Intrinsics.checkNotNullParameter(r15, "profileContext");
        Intrinsics.checkNotNullParameter(r13, "elementInfo");
        Intrinsics.checkNotNullParameter(r13, "elementInfo");
        ExtraInfo r25 = r13.getExtraInfo();
        if (r25 == null) goto L52;
        r2 = r25.getGlobalClickEventParams();
    L52:
        LinkedHashMap r26 = new LinkedHashMap();
        if (r2 == null) goto L55;
        r26.putAll(r2);
    L55:
        r26.put("id", String.valueOf(r13.getId()));
        h r1 = r23.a;
        if (r1 == null) goto L58;
        r1.sendLog("livesdk_usercard_honor_wall_click", r26, new Object[0]);
    L58:
        r23.d(r24, r10, r13, r14, r15);
    L60:
        r12.o(r13, r15);
        return;
    L59:
        r12.d(r9.e.getHostFragment(), r10, r13, r14, r15);
        goto L60
    }
}
