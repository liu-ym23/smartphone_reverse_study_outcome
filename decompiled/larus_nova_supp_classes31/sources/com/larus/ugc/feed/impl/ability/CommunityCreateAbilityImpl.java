package com.larus.ugc.feed.impl.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CommunityCreateAbilityImpl implements g0a.f {
    public final CoroutineScope a;
    public final a1a.a b;
    public final buc.e<b> c;
    public final buc.d d;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final m0a.e b;
        public final m0a.d c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
            m0a.d r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(initialized=" + this.a + ", params=" + this.b + ", dependency=" + this.c + ')';
        }

        public b(boolean r2, m0a.e r3, m0a.d r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final TabItemInfoKmp a;
        public final String b;
        public final TabItemInfoKmp c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            TabItemInfoKmp r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingTabReport(newItem=" + this.a + ", enterMethod=" + this.b + ", prevItem=" + this.c + ", currentPage=" + this.d + ')';
        }

        public c(TabItemInfoKmp r2, String r3, TabItemInfoKmp r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "newItem");
            Intrinsics.checkNotNullParameter(r3, "enterMethod");
            Intrinsics.checkNotNullParameter(r5, "currentPage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommunityCreateLaunchModeKmp.values().length];
            r0[CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CommunityCreateLaunchModeKmp.STANDALONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CommunityCreateLaunchModeKmp.SIDE_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // g0a.f
    public final void Oc() {
        m0a.f r0 = (m0a.f) this.b.a.getValue();
        m0a.d r1 = ((b) this.c.c()).c;
        if (r1 == null) goto L8;
        g0a.e r2 = r1.b;
        if (r2 == null) goto L9;
        r2.JA(new g0a.h(r0.c));
        return;
    L9:
        return;
    }

    @Override // g0a.f
    public final void dy() {
        this.b.update(new f());
    }

    @Override // g0a.f
    public final void ev() {
        m0a.f r0 = (m0a.f) this.b.a.getValue();
        if (r0.k == false) goto L6;
        long r1 = fuc.a.a().a();
        this.d.e(r1);
        return;
    L6:
        this.b.update(new com.larus.ugc.feed.impl.ability.d());
        long r2 = fuc.a.a().a();
        this.d.e(r2);
        if (r0.a != CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB) goto L9;
        return;
    L9:
        TabItemInfoKmp r3 = (TabItemInfoKmp) CollectionsKt.getOrNull(r0.e, r0.f);
        if (r3 != null) goto L12;
        return;
    L12:
        String r4 = r0.l;
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        d(r3, r4, null, r0.c);
    }

    @Override // g0a.f
    public final i1<m0a.f> getUiState() {
        return this.b.a;
    }

    public final Object c(Continuation<? super Unit> r14) {
        if ((r14 instanceof CommunityCreateAbilityImpl$fetchTabList$1) == false) goto L7;
        CommunityCreateAbilityImpl$fetchTabList$1 r0 = (CommunityCreateAbilityImpl$fetchTabList$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        m0a.e r4 = (m0a.e) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L35:
        Object r16 = Result.constructor-impl((List) r15);     // Catch: Throwable -> L14
    L40:
        Throwable r5 = Result.exceptionOrNull-impl(r16);
        if (r5 == null) goto L44;
        c0.b.e("CommunityCreateAbilityImpl", "fetchTabList failed: " + r5);
        r16 = CollectionsKt.emptyList();
    L44:
        final List r17 = (List) r16;
        if (r4.c == false) goto L47;
        r17 = CollectionsKt.plus(CollectionsKt.listOf(new TabItemInfoKmp("0", "creation_actionTab_discover", yg9.a.a(new yg9.b(2131901179)), Boxing.boxBoolean(false), null, 16, null)), r17);
    L47:
        c0.b.d("CommunityCreateAbilityImpl", "fetchTabList done: size=" + r17.size());
        this.b.update(new com.larus.ugc.feed.impl.ability.b(r17));
        return Unit.INSTANCE;
    L14:
        th = th;
        m0a.e r6 = r4;
    L39:
        Result.Companion r7 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r6;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        b r18 = (b) this.c.c();
        if (r18.a == true) goto L22;
        c0.b.d("CommunityCreateAbilityImpl", "fetchTabList skip: not initialized");
        return Unit.INSTANCE;
    L22:
        r6 = r18.b;
        if (r6.a != CommunityCreateLaunchModeKmp.SIDE_BAR) goto L25;
        String r8 = "enter_page";
    L26:
        c0 r9 = c0.b;
        r9.d("CommunityCreateAbilityImpl", "fetchTabList: recommendType=" + r6.b + " downgrade=" + r8);
        m0a.d r19 = r18.c;
        if (r19 == null) goto L49;
        m0a.m r110 = r19.d;
        if (r110 == null) goto L49;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L38
        int r11 = r6.b;     // Catch: Throwable -> L38
        boolean r12 = r6.c;     // Catch: Throwable -> L38
        r0.L$0 = r6;     // Catch: Throwable -> L38
        r0.label = 1;     // Catch: Throwable -> L38
        r15 = r110.a(r11, r12);     // Catch: Throwable -> L38
        if (r15 != r2) goto L34;
        return r2;
    L34:
        r4 = r6;
    L38:
        th = th;
    L49:
        r9.d("CommunityCreateAbilityImpl", "fetchTabList skip: dependency missing (programmer error)");
        return Unit.INSTANCE;
    L25:
        r8 = "enter_conversation_list";
    L7:
        r0 = new CommunityCreateAbilityImpl$fetchTabList$1(this, r14);
        goto L8
    }

    @Override // g0a.f
    public final void da(String r15) {
        Intrinsics.checkNotNullParameter(r15, "leaveMethod");
        m0a.f r0 = (m0a.f) this.b.a.getValue();
        if (r0.a != CommunityCreateLaunchModeKmp.CHAT_MULTI_TAB) goto L5;
        return;
    L5:
        long r1 = this.d.c();
        if (r1 > 0) goto L8;
        return;
    L8:
        this.d.e(0);
        long r12 = fuc.a.a().a() - r1;
        TabItemInfoKmp r2 = (TabItemInfoKmp) CollectionsKt.getOrNull(r0.e, r0.f);
        if (r2 != null) goto L11;
        return;
    L11:
        c0.b.d("CommunityCreateAbilityImpl", "onTabLeave: method=" + r15 + " duration=" + r12 + " tabId=" + r2.getId());
        m0a.d r3 = ((b) this.c.c()).c;
        if (r3 == null) goto L20;
        g0a.e r4 = r3.b;
        if (r4 == null) goto L21;
        String r5 = r0.l;
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r4.wF(new g0a.j(r5, r15, String.valueOf(r0.d), r2.getName(), r2.getId(), r0.c, r12));
        return;
    L21:
        return;
    }

    @Override // g0a.f
    public final void gk(final UserCreationKmp r3) {
        Intrinsics.checkNotNullParameter(r3, "creation");
        this.b.update(new com.larus.ugc.feed.impl.ability.c(r3));
    }

    @Override // g0a.f
    public final void vi(boolean r5) {
        final FabVisibilityStateKmp r0 = b(((m0a.f) this.b.a.getValue()).a, r5);
        c0.b.d("CommunityCreateAbilityImpl", "updateFabDowngrade: " + r5 + " -> " + r0);
        this.b.update(new g(r0));
    }

    public CommunityCreateAbilityImpl(CoroutineScope r14, a1a.a r15) {
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "stateHolder");
        this.a = r14;
        this.b = r15;
        this.c = buc.b.d(new b(false, new m0a.e(null, 0, false, null, null, null, null, null, null, 0, null, 32767), null));
        this.d = buc.b.c(0);
    }

    public static FabVisibilityStateKmp b(CommunityCreateLaunchModeKmp r0, boolean r1) {
        if (r1 == true) goto L4;
        int r2 = d.a[r0.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L18;
        if (r2 != 3) goto L13;
        return FabVisibilityStateKmp.HIDDEN_LAUNCH_MODE;
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return FabVisibilityStateKmp.VISIBLE;
    L16:
        return FabVisibilityStateKmp.HIDDEN_LAUNCH_MODE;
    L4:
        return FabVisibilityStateKmp.HIDDEN_DOWNGRADE;
    }

    @Override // g0a.f
    public final void Ow(final int r5, final String r6) {
        Intrinsics.checkNotNullParameter(r6, "enterMethod");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        this.b.update(new com.larus.ugc.feed.impl.ability.a(r0, r1, r5, r6));
        Integer r7 = (Integer) r1.element;
        if (r7 == null) goto L5;
        int r8 = r7.intValue();
        c0.b.d("CommunityCreateAbilityImpl", "selectTab invalid index=" + r5 + " size=" + r8);
    L5:
        c r9 = (c) r0.element;
        if (r9 == null) goto L9;
        d(r9.a, r9.b, r9.c, r9.d);
        return;
    }

    @Override // g0a.f
    public final void yG(final m0a.e r9, m0a.d r10) {
        Intrinsics.checkNotNullParameter(r9, "initParams");
        Intrinsics.checkNotNullParameter(r10, "initDependency");
        b r0 = (b) this.c.c();
        if (r0.a == false) goto L7;
        c0.b.d("CommunityCreateAbilityImpl", "initialize already done, skip");
        return;
    L7:
        if (this.c.a(r0, new b(true, r9, r10)) == true) goto L10;
        c0.b.d("CommunityCreateAbilityImpl", "initialize lost CAS race, skip");
        return;
    L10:
        c0.b.d("CommunityCreateAbilityImpl", "initialize: launchMode=" + r9.a + " recommendType=" + r9.b + " isMultiTab=" + r9.c);
        final FabVisibilityStateKmp r11 = b(r9.a, r10.c.zF());
        this.b.update(new e(r9, this, r11));
        BuildersKt.launch$default(this.a, Dispatchers.getDefault(), null, new CommunityCreateAbilityImpl$initialize$2(this, null), 2, null);
    }

    public final void d(TabItemInfoKmp r11, String r12, TabItemInfoKmp r13, String r14) {
        String r0 = r11.getId();
        if (r0 != null) goto L5;
        String r4 = "";
    L7:
        if (r4.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        c0.b.d("CommunityCreateAbilityImpl", "reportEnterTab skip: empty tabId");
        return;
    L13:
        m0a.d r2 = ((b) this.c.c()).c;
        if (r2 == null) goto L26;
        g0a.e r3 = r2.b;
        if (r3 == null) goto L27;
        String r5 = r11.getStarlingKey();
        if (r5 != null) goto L20;
        String r6 = "";
    L21:
        if (r13 == null) goto L23;
        String r15 = r13.getId();
    L24:
        r3.zh(new g0a.i(r14, r4, r6, r15, r11.getTrackerTabType(), r12));
        return;
    L23:
        r15 = null;
        goto L24
    L20:
        r6 = r5;
        goto L21
    L27:
        return;
    L26:
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r4 = r0;
        goto L7
    }
}
