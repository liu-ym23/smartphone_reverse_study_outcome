package com.bytedance.android.live.profile;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.model.LifecycleStateType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.ui.util.n;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "invoke"}, k = 3, mv = {1, 4, 3})
final class NewLiveProfileDialogFragment$onDataLoadSuccess$1 extends Lambda implements Function1<NewProfileUser, Unit> {
    final /* synthetic */ NewLiveProfileDialogFragment this$0;

    public NewLiveProfileDialogFragment$onDataLoadSuccess$1(NewLiveProfileDialogFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        ALogger.i("NewUserProfile_ProfilePre", "DialogFragment runWithFinalUserAvailable");
        NewLiveProfileDialogFragment r0 = this.this$0;
        NewLiveProfileDialogFragment.a r1 = NewLiveProfileDialogFragment.A;
        NewProfileInfoViewModel r2 = r0.T90();
        LifecycleStateType r3 = LifecycleStateType.COMPONENT_SHOW_FINISHED;
        Function1<com.bytedance.android.live.profile.model.b, Unit> r4 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r2, "$this$runOnceAtLeastLifecycleState");
        Intrinsics.checkNotNullParameter(r3, "wannaRunState");
        Intrinsics.checkNotNullParameter(r4, "action");
        com.bytedance.android.live.profile.model.b r5 = (com.bytedance.android.live.profile.model.b) r2.mo6getLifecycleState().getValue();
        Disposable r6 = null;
        if (r5.a.ordinal() < r3.ordinal()) goto L5;
        r4.invoke(r5);
    L6:
        if (r6 == null) goto L8;
        RxUtilKt.c(r6, this.this$0.m);
    L8:
        this.this$0.T90().reportProfileProfitCheck(r8);
        int r9 = n.a;
        NewProfileInfoViewModel r10 = this.this$0.T90();
        Intrinsics.checkNotNullParameter(r10, "vm");
        ProfileSkin r7 = r10.getTargetUser().mProfileSkin;
        if (r7 == null) goto L14;
        ProfileCustomSkin r12 = r7.skin;
        if (r12 == null) goto L14;
        String r13 = r12.dressId;
        if (r13 == null) goto L14;
    L15:
        k.n(IPerformanceManager.class).onModuleStart("dress_usercard", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("dress_id", r13), TuplesKt.to("panel_enter_webp", n.c(r10, DressType.PanelEnterWebp)), TuplesKt.to("border_9_png", n.c(r10, DressType.Border9Png)), TuplesKt.to("border_enter_webp", n.c(r10, DressType.BorderEnterWebp)), TuplesKt.to("border_loop_webp", n.c(r10, DressType.BorderLoopWebp)), TuplesKt.to("panel_exit_webp", n.c(r10, DressType.PanelExitWebp)), TuplesKt.to("main_button_webp", n.c(r10, DressType.MainButtonWebp)), TuplesKt.to("parallax_asset", r10.getParallaxAsset())}));
        return;
    L14:
        r13 = DataType.FALSE;
        goto L15
    L5:
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        r6 = r2.mo6getLifecycleState().subscribe(new com.bytedance.android.live.profile.ui.base.j(r3, r4, r14));
        r14.element = r6;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((NewProfileUser) r1);
        return Unit.INSTANCE;
    }
}
