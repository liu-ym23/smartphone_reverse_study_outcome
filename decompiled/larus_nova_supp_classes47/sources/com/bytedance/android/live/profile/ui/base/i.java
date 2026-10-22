package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBanner;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.ui.util.DressType;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ EnterExitStateType a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ Ref.ObjectRef c;

        public a(EnterExitStateType r1, Function1 r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.profile.model.a r4 = (com.bytedance.android.live.profile.model.a) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.a.ordinal() < this.a.ordinal()) goto L11;
            this.b.invoke(r4);
            Disposable r5 = (Disposable) this.c.element;
            if (r5 == null) goto L12;
            r5.dispose();
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            if (r3 == null) goto L9;
            NewProfileUser r4 = (NewProfileUser) sh6.c.b(r3);
            if (r4 == null) goto L10;
            this.a.invoke(r4);
            return;
        L10:
            return;
        }
    }

    public static final int a(h r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$calculateMyLiveWhitePanelHeight");
        if (r4.isVertical() == true) goto L5;
        int r5 = com.bytedance.android.live.profile.j.a;
        return RangesKt.coerceAtMost(s1.y(), s1.w()) - UtilityKotlinExtentionsKt.i(12);
    L5:
        if (c(r4) > 2) goto L7;
        int r6 = com.bytedance.android.live.profile.j.a;
        double r0 = RangesKt.coerceAtLeast(s1.w(), s1.y());
        double r2 = 0.62d;
    L11:
        return (int) (r0 * r2);
    L7:
        int r7 = com.bytedance.android.live.profile.j.a;
        r0 = RangesKt.coerceAtLeast(s1.w(), s1.y());
        r2 = 0.65d;
        goto L11
    }

    public static final int c(h r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$honourWallLines");
        int r0 = d(r3);
        ProfileStandardHonourWallComponent.a r1 = ProfileStandardHonourWallComponent.u;
        ProfileOpenArea r2 = r3.getTargetUser().openArea;
        if (r2 == null) goto L7;
        ProfileBusinessArea r4 = r2.businessAreaV3;
        if (r4 == null) goto L7;
        List r5 = r4.bottomElementList;
    L8:
        boolean r6 = r3.isVertical();
        r1.getClass();
        return r0 + ProfileStandardHonourWallComponent.a.a(r5, r6);
    L7:
        r5 = null;
        goto L8
    }

    public static final int d(h r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$honourWallLinesExcludeHonorCardLines");
        ProfileOpenArea r4 = r3.getTargetUser().openArea;
        ProfileGiftExhibitionBanner r0 = null;
        if (r4 == null) goto L5;
        ProfileBusinessArea r5 = r4.businessAreaV3;
    L6:
        if (r5 == null) goto L8;
        List r1 = r5.topElementList;
    L9:
        List r2 = r1;
        if (r2 != null) goto L12;
    L15:
        int r6 = 1;
    L16:
        int r7 = r6 ^ 1;
        if (r5 == null) goto L19;
        r0 = r5.exhibitionBanner;
    L19:
        if (r0 != null) goto L21;
        return r7;
    L21:
        return r7 + 1;
    L12:
        if (r2.isEmpty() == true) goto L15;
        r6 = 0;
        goto L16
    L8:
        r1 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public static final boolean e(h r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$hasDressBorder");
        if (r5.getDressImageModelWithFallback(DressType.BorderPng) == null) goto L5;
        boolean r0 = true;
    L7:
        if (r5.getDressImageModelWithFallback(DressType.Border9Png) == null) goto L9;
        boolean r3 = true;
    L11:
        if (r5.getDressImageModelWithFallback(DressType.BorderEnterWebp) == null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        boolean r6 = com.bytedance.android.live.profile.ui.util.n.b(r5);
        if (r0 == true) goto L22;
        if (r3 == true) goto L22;
        if (r4 == true) goto L22;
        if (r6 == true) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r5.getDressImageModelWithFallback(DressType.BorderLoopWebp) != null) goto L16;
        r4 = false;
        goto L17
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean f(h r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isHonourWallVersionChange");
        NewProfileUser r0 = r6.getPreTargetUser();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getBusinessAreaVersion() == r6.getTargetUser().getBusinessAreaVersion()) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean g(h r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isPreDressChange");
        NewProfileUser r0 = r2.getPreTargetUser();
        if (r0 != null) goto L5;
        return false;
    L5:
        ProfileSkin r1 = r0.mProfileSkin;
        String r3 = null;
        if (r1 == null) goto L10;
        ProfileCustomSkin r4 = r1.skin;
        if (r4 == null) goto L10;
        String r5 = r4.dressId;
    L11:
        ProfileSkin r6 = r2.getTargetUser().mProfileSkin;
        if (r6 == null) goto L17;
        ProfileCustomSkin r7 = r6.skin;
        if (r7 == null) goto L17;
        r3 = r7.dressId;
    L17:
        return !Intrinsics.areEqual(r5, r3);
    L10:
        r5 = null;
        goto L11
    }

    public static final boolean h(h r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isProfileSpecialMode");
        if (r1.getProfileMode() == ProfileMode.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean k(h r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$selfIsAnchor");
        return r1.getPageTypeUseCase().c;
    }

    public static final boolean l(h r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$targetIsAnchor");
        return r1.getPageTypeUseCase().b;
    }

    public static final boolean m(h r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$targetIsSelf");
        return r1.getPageTypeUseCase().a;
    }

    public static final m n(h r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toViewProfileContext");
        if ((r1 instanceof m) == true) goto L6;
        r1 = null;
    L6:
        return (m) r1;
    }

    public static final void b(h r2, Observable<Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$enterWaitForOrRunImmediately");
        Intrinsics.checkNotNullParameter(r3, "wait");
        if (((com.bytedance.android.live.profile.model.a) r2.getEnterExitState().getValue()).a != EnterExitStateType.INIT) goto L5;
        r2.enterWaitFor(r3);
        return;
    L5:
        r3.subscribe();
    }

    public static final Disposable j(h r1, Function1<? super NewProfileUser, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithFinalUserAvailable");
        Intrinsics.checkNotNullParameter(r2, "action");
        NewProfileUser r0 = (NewProfileUser) com.bytedance.android.live.core.arch.mvvm.f.a(r1.mo5getFinalProfileUser());
        if (r0 == null) goto L6;
        r2.invoke(r0);
        return null;
    L6:
        return r1.mo5getFinalProfileUser().subscribe(new b(r2));
    }

    public static final Disposable i(h r4, EnterExitStateType r5, Function1<? super com.bytedance.android.live.profile.model.a, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$runOnceAtLeastEnterExitState");
        Intrinsics.checkNotNullParameter(r5, "wannaRunState");
        Intrinsics.checkNotNullParameter(r6, "action");
        com.bytedance.android.live.profile.model.a r0 = (com.bytedance.android.live.profile.model.a) r4.getEnterExitState().getValue();
        if (r0.a.ordinal() < r5.ordinal()) goto L5;
        r6.invoke(r0);
        return null;
    L5:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        Disposable r3 = r4.getEnterExitState().subscribe(new a(r5, r6, r1));
        r1.element = r3;
        return r3;
    }
}
