package com.bytedance.android.live.profile.standard.tag;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platform.ILiveProfilePlatformService;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.y;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileStandardTagListComponent extends DataAssembler<f> {
    public final Lazy g;
    public final Lazy h;
    public final Map<Long, b> i;
    public final Lazy j;
    public final l k;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final jt0.b b;
        public final View c;
        public final ProfileTagContent d;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L14;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            jt0.b r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            View r6 = this.c;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            ProfileTagContent r9 = this.d;
            if (r9 == null) goto L14;
            r3 = r9.hashCode();
        L14:
            return r8 + r3;
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "TagCache(type=" + this.a + ", item=" + this.b + ", view=" + this.c + ", elementInfo=" + this.d + ")";
        }

        public final long getType() {
            return this.a;
        }

        public b(long r2, jt0.b r4, View r5, ProfileTagContent r6) {
            Intrinsics.checkNotNullParameter(r4, "item");
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "elementInfo");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class c extends vt0.b {
        public final /* synthetic */ ProfileTagContent d;
        public final /* synthetic */ jt0.b e;
        public final /* synthetic */ ProfileStandardTagListComponent f;
        public final /* synthetic */ NewProfileUser g;

        @Override // vt0.b
        public final void a(View r5) {
            ProfileStandardTagListComponent.o(this.f, r5, this.d, this.e, this.g);
        }

        public c(ProfileTagContent r1, jt0.b r2, ProfileStandardTagListComponent r3, NewProfileUser r4) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
        }
    }

    public static final class d extends vt0.b {
        public final /* synthetic */ mt0.a d;
        public final /* synthetic */ jt0.b e;
        public final /* synthetic */ ProfileStandardTagListComponent f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ NewProfileUser h;
        public final /* synthetic */ h i;

        @Override // vt0.b
        public final void a(View r5) {
            ProfileStandardTagListComponent.o(this.f, r5, (ProfileTagContent) this.d.b, this.e, this.h);
        }

        public d(mt0.a r1, jt0.b r2, ProfileStandardTagListComponent r3, Map r4, NewProfileUser r5, h r6) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
        }
    }

    public static final class e extends vt0.b {
        public final /* synthetic */ mt0.a d;
        public final /* synthetic */ b e;
        public final /* synthetic */ ProfileStandardTagListComponent f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ NewProfileUser h;
        public final /* synthetic */ h i;

        @Override // vt0.b
        public final void a(View r5) {
            ProfileStandardTagListComponent.o(this.f, r5, (ProfileTagContent) this.d.b, this.e.b, this.h);
        }

        public e(mt0.a r1, b r2, ProfileStandardTagListComponent r3, Map r4, NewProfileUser r5, h r6) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.StandardTagList.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r8, "user");
        Map<Long, b> r0 = this.i;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((b) ((Map.Entry) r2.next()).getValue()).d);
        goto L4
    L6:
        this.e.a().getLogUseCaseForUi().l(r1);
        Iterator r3 = ((LinkedHashMap) this.i).entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L56;
        b r4 = (b) ((Map.Entry) r3.next()).getValue();
        r4.b.h(r4.d, r8, this.e.b());
        ProfileTagContent r5 = r4.d;
        jt0.b r6 = r4.b;
        com.bytedance.android.live.profile.profilecontext.a r7 = this.e.b();
        LinkedHashMap r9 = null;
        if (r7 != null) goto L57;
    L16:
        String r10 = r4.d.tagName;
        if (r10 == null) goto L20;
        this.e.b().recordBusinessShow(TrackArea.TagArea, r10);
    L20:
        if (((ss0.c) y.a.getValue()).i() == false) goto L8;
        Map r12 = r4.d.showBuriedPointParams;
        boolean r13 = true;
        if (r12 == null) goto L46;
        r9 = new LinkedHashMap();
        Iterator r14 = r12.entrySet().iterator();
    L25:
        if (r14.hasNext() == false) goto L46;
        Map.Entry r15 = (Map.Entry) r14.next();
        CharSequence r16 = (CharSequence) r15.getKey();
        if (r16 != null) goto L29;
    L32:
        boolean r17 = true;
    L33:
        if (r17 == true) goto L43;
        CharSequence r18 = (CharSequence) r15.getValue();
        if (r18 != null) goto L37;
    L40:
        boolean r19 = true;
    L41:
        if (r19 == true) goto L43;
        boolean r20 = true;
    L44:
        if (r20 == false) goto L25;
        r9.put(r15.getKey(), r15.getValue());
        goto L25
    L37:
        if (r18.length() == 0) goto L40;
        r19 = false;
    L43:
        r20 = false;
        goto L44
    L29:
        if (r16.length() == 0) goto L32;
        r17 = false;
    L46:
        if (r9 != null) goto L48;
    L51:
        if (r13 == true) goto L8;
        LinkedHashMap r22 = new LinkedHashMap();
        if (r9 == null) goto L55;
        r22.putAll(r9);
    L55:
        this.e.b().recordShowMap(r22);
        goto L8
    L48:
        if (r9.isEmpty() == true) goto L51;
        r13 = false;
        goto L51
    L57:
        r6.f(r8, r7);     // Catch: Exception -> L14
        this.e.a().getLogUseCaseForUi().f(r5, null);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ALogger.e("ProfileStandardTag", "log show error: " + e.getMessage());
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r14) {
        Intrinsics.checkNotNullParameter(r14, "user");
        ALogger.i("ProfileStandardTag", "ProfileStandardTagListComponent bindUserData");
        List<ProfileTagContent> r0 = q(r14.profileTagContents, r14);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L27;
        ProfileTagContent r2 = (ProfileTagContent) r1.next();
        if (r2 == null) goto L7;
        jt0.b r8 = p(r2.tagType);
        View r9 = r8.d(this.f.getContext());
        if (r9 == 0) goto L7;
        this.i.put(Long.valueOf(r2.tagType), new b(r2.tagType, r8, r9, r2));
        ViewGroup.LayoutParams r3 = r8.a();
        if (r3 != null) goto L17;
        this.f.addView(r9);
    L19:
        if ((r9 instanceof jt0.c) == false) goto L24;
        com.bytedance.android.live.profile.profilecontext.a r4 = this.e.b();
        if (r4 == null) goto L24;
        ((jt0.c) r9).b(r2, r14, r4, r8);
    L24:
        if (r8.e(r2, r14, this.e.b()) == true) goto L25;
        this.f.getContext();
        r(r9);
        goto L7
    L25:
        r9.setOnClickListener(new c(r2, r8, this, r14));
        goto L7
    L17:
        this.f.addView(r9, r3);
        goto L19
    }

    public final jt0.b p(long r3) {
        jt0.b r0 = k.n(ILiveProfilePlatformService.class).createTagItem(this.k, r3);
        if (r0 != null) goto L5;
        r0 = (jt0.b) ((Map) this.g.getValue()).get(Long.valueOf(r3));
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return new lt0.d();
    }

    public final void r(View r2) {
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L6;
        r2.setOnHoverListener(com.bytedance.android.live.profile.standard.tag.b.a);
        r2.setFocusable(true);
        r2.setImportantForAccessibility(1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r20) {
        Intrinsics.checkNotNullParameter(r20, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileStandardTagListComponent update");
        List<ProfileTagContent> r1 = q(r20.profileTagContents, r20);
        if (r1 == null) goto L6;
        List r2 = CollectionsKt.filterNotNull(r1);
        if (r2 == null) goto L6;
    L7:
        int r3 = mt0.c.a;
        mt0.b r4 = mt0.c.a(r2, this.i, AnonymousClass1.INSTANCE);
        Collection r9 = r4.a;
        Object r5 = r4.b;
        com.bytedance.android.live.profile.profilecontext.a r10 = this.e.b();
        if (r10 != null) goto L10;
        return;
    L10:
        StringBuilder r6 = new StringBuilder("TagList preload: ");
        Map<Long, b> r7 = this.i;
        ArrayList r8 = new ArrayList(r7.size());
        Iterator r12 = ((LinkedHashMap) r7).entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        r8.add(TuplesKt.to(String.valueOf(((Number) r13.getKey()).longValue()), ((b) r13.getValue()).b.getClass().getSimpleName()));
        goto L12
    L14:
        r6.append(r8);
        ALogger.e("NewUserProfile_ProfilePre", r6.toString());
        StringBuilder r14 = new StringBuilder("TagList update: willLoad=");
        Collection r15 = r9;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L16:
        if (r17.hasNext() == false) goto L18;
        mt0.a r18 = (mt0.a) r17.next();
        r16.add(TuplesKt.to(r18.getType(), r18.c.getDesc()));
        goto L16
    L18:
        r14.append(r16);
        ALogger.e("NewUserProfile_ProfilePre", r14.toString());
        ALogger.e("NewUserProfile_ProfilePre", "TagList update: remove=" + r5);
        LinkedHashMap r19 = new LinkedHashMap();
        this.f.removeAllViews();
        Iterator r110 = r15.iterator();
    L20:
        if (r110.hasNext() == false) goto L53;
        mt0.a r22 = (mt0.a) r110.next();
        int r0 = com.bytedance.android.live.profile.standard.tag.a.a[r22.c.ordinal()];
        if (r0 != 1) goto L24;
        jt0.b r23 = p(((Number) r22.getType()).longValue());
        View r24 = r23.d(this.f.getContext());
        if (r24 == 0) goto L20;
        r19.put(r22.getType(), new b(((Number) r22.getType()).longValue(), r23, r24, (ProfileTagContent) r22.b));
        ViewGroup.LayoutParams r25 = r23.a();
        if (r25 != null) goto L45;
        this.f.addView(r24);
    L47:
        if ((r24 instanceof jt0.c) == false) goto L50;
        ((jt0.c) r24).b((ProfileTagContent) r22.b, r20, r10, r23);
    L50:
        if (r23.e((ProfileTagContent) r22.b, r20, this.e.b()) == true) goto L51;
        this.f.getContext();
        r(r24);
        goto L20
    L51:
        r24.setOnClickListener(new d(r22, r23, this, r19, r20, r10));
        goto L20
    L45:
        this.f.addView(r24, r25);
        goto L47
    L24:
        if (r0 != 2) goto L20;
        b r26 = (b) ((LinkedHashMap) this.i).get(r22.getType());
        if (r26 == null) goto L20;
        r19.put(r22.getType(), r26);
        this.f.addView(r26.c);
        KeyEvent.Callback r27 = r26.c;
        if ((r27 instanceof jt0.c) == true) goto L32;
        r27 = null;
    L32:
        jt0.c r28 = (jt0.c) r27;
        if (r28 == null) goto L36;
        r28.update((ProfileTagContent) r22.b, r20, r10, r26.b);
    L36:
        if (r26.b.e((ProfileTagContent) r22.b, r20, this.e.b()) == true) goto L37;
        r26.c.setOnClickListener(null);
        View r29 = r26.c;
        this.f.getContext();
        r(r29);
        goto L20
    L37:
        r26.c.setOnClickListener(new e(r22, r26, this, r19, r20, r10));
        goto L20
    L53:
        ((LinkedHashMap) this.i).clear();
        this.i.putAll(r19);
        ViewGroup r30 = this.f;
        if ((true ^ r9.isEmpty()) == false) goto L56;
        int r32 = 0;
    L57:
        r30.setVisibility(r32);
        return;
    L56:
        r32 = 8;
    L6:
        r2 = CollectionsKt.emptyList();
        goto L7
    }

    public ProfileStandardTagListComponent(l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r2, r3);
        this.k = r2;
        this.g = LazyKt.lazy(ProfileStandardTagListComponent$customTagItem$2.INSTANCE);
        this.h = LazyKt.lazy(ProfileStandardTagListComponent$preProcessorList$2.INSTANCE);
        this.i = new LinkedHashMap();
        this.j = LazyKt.lazy(new ProfileStandardTagListComponent$isA11yEnable$2(this));
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter((f) r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    public final List<ProfileTagContent> q(List<? extends ProfileTagContent> r3, NewProfileUser r4) {
        Iterator r0 = ((List) this.h.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        jt0.a r1 = (jt0.a) r0.next();
        r3 = r1.b(r3, r4);
        r1.a();
        goto L4
    L6:
        return r3;
    }

    public static final void o(ProfileStandardTagListComponent r7, View r8, ProfileTagContent r9, jt0.b r10, NewProfileUser r12) {
        com.bytedance.android.live.profile.profilecontext.a r0 = r7.e.b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10.e(r9, r12, r0) == false) goto L36;
        r10.c(r7.e.getHostFragment(), r8, r9, r0, r12);
        r10.g(r9, r12, r0);
        LinkedHashMap r13 = null;
        r7.e.a().getLogUseCaseForUi().b(r9, null);     // Catch: Exception -> L10
    L12:
        String r14 = r9.tagName;
        if (r14 == null) goto L29;
        if (((ss0.c) y.a.getValue()).h() == false) goto L27;
        Map<? extends Object, ? extends String> r15 = r9.clickBuriedPointParams;
        if (r15 != null) goto L19;
    L22:
        boolean r1 = true;
    L23:
        if (r1 == true) goto L27;
        r13 = new LinkedHashMap();
        if (r15 == null) goto L27;
        r13.putAll(r15);
        goto L27
    L19:
        if (r15.isEmpty() == true) goto L22;
        r1 = false;
    L27:
        r0.recordBusinessClick(r14, r13);
    L29:
        if (r10.b(r9, r0) == true) goto L31;
        return;
    L31:
        if (CollectionsKt.listOf(Long.valueOf(ProfileTagContent.TAG_TYPE_POI)).contains(Long.valueOf(r10.getType())) == false) goto L38;
        r0.dismiss();
        return;
    L38:
        return;
    L10:
        e = move-exception;
        ALogger.e("ProfileStandardTag", "log click error: " + e.getMessage());
        goto L12
    }
}
