package com.larus.bmhome.video.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.bmhome.video.view.UserVideoPlayControlView;
import com.larus.common_res.common_ui.databinding.LarusVideoDetailLayoutBinding;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\f0!R\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/bmhome/video/fragment/UserVideoDetailFragment;", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment;", "Lcom/larus/common_res/common_ui/databinding/LarusVideoDetailLayoutBinding;", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "<init>", "(Lcom/larus/platform/model/video/VideoPlayData;Lcom/larus/bmhome/utils/VideoDetailEventParams;)V", "()V", "delayShowLoadingJob", "Lkotlinx/coroutines/Job;", "disableShare", "", "getDisableShare", "()Z", "setDisableShare", "(Z)V", "tag", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "getMetaDataMap", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "autoLogEnterPage", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment$InitViewsResult;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateView", "download", "videoContent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserVideoDetailFragment extends BaseVideoDetailFragment<LarusVideoDetailLayoutBinding> {
    public static final /* synthetic */ int z = 0;
    public Job x;
    public boolean y;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final Object X90(Continuation<? super Map<String, String>> r1) {
        return null;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final String tag() {
        return "UserVideoDetailFragment";
    }

    public UserVideoDetailFragment() {
        this(new nr9.g(null, null, null, null, null, null, null, null, null, null, 1023), new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383));
        VideoDetailPagerFragment r0 = getParentFragment();     // Catch: IllegalStateException -> L17
        if ((r0 instanceof VideoDetailPagerFragment) == false) goto L7;
        VideoDetailPagerFragment r1 = r0;     // Catch: IllegalStateException -> L17
    L8:
        if (r1 == null) goto L23;
        r1.dismiss();     // Catch: Exception -> L11
    L25:
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L17
        Throwable r2 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L17
        if (r2 == null) goto L24;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L17
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r1 = null;
    L17:
        FLogger.a.e("UserVideoDetailFragment", "fallback by dismiss failed");
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final ShareScene da0() {
        return ShareScene.VIDEO_COMPREHEND;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void W90(nr9.g r22) {
        this.x = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new UserVideoDetailFragment$download$1(this, null), 3, null);
        VideoGenerateSaver r2 = VideoGenerateSaver.a;
        Context r3 = getContext();
        c4 r4 = this.f;
        com.larus.bmhome.video.save_share.a.C0044a.a(r2, r3, r22, new c4(r4.a, r4.b, r4.c, null, null, null, r4.g, null, null, null, null, null, null, null, 16312), "detail_click", LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), false, false, null, null, null, false, new z(this), 2016);
    }

    public UserVideoDetailFragment(nr9.g r8, c4 r9) {
        Intrinsics.checkNotNullParameter(r8, "videoPlayData");
        Intrinsics.checkNotNullParameter(r9, "eventParam");
        super(r8, r9, false, false, 28);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.larus.bmhome.video.fragment.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [qs8.a] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View, com.larus.bmhome.video.view.UserVideoPlayControlView] */
    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final BaseVideoDetailFragment<LarusVideoDetailLayoutBinding>.b Y90(LayoutInflater r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r12 = r10.inflate(2131563198, r11, false);
        int r13 = 2131364161;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131364161)) == null) goto L22;
        r13 = 2131364437;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131364437);
        if (r0 == null) goto L22;
        r13 = 2131373418;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131373418)) == null) goto L22;
        r13 = 2131384472;
        RelativeLayout r2 = (RelativeLayout) ViewBindings.findChildViewById(r12, 2131384472);
        if (r2 == null) goto L22;
        r13 = 2131392404;
        VideoPlayView r3 = ViewBindings.findChildViewById(r12, 2131392404);
        if (r3 == null) goto L22;
        LarusVideoDetailLayoutBinding r14 = new LarusVideoDetailLayoutBinding(r12, r0, r2, r3);
        r3.setForceUpdateProgress(true);
        Unit r1 = Unit.INSTANCE;
        Context r4 = getContext();
        ?? r5 = 0;
        if (r4 == null) goto L20;
        ?? r6 = new UserVideoPlayControlView(r4, null, 6, 0);
        if (this.y == false) goto L17;
        r6.setShareIconVisibility(false);
    L18:
        i0.a.getClass();
        int r15 = i0.e() + i5.h();
        int r7 = r6.getPaddingStart();
        int r8 = r6.getPaddingTop();
        int r9 = r6.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:UserVideoPlayControlView,source:,start:" + r7 + ",top:" + r8 + ",end:" + r9 + ",bottom:" + r15);
        r6.setPaddingRelative(r7, r8, r9, r15);
        r5 = r6;
        goto L20
    L17:
        r6.setShareIconVisibility(true);
        final ?? r16 = new y(this);
        Intrinsics.checkNotNullParameter(r16, "onClick");
        e1.d(r6.a.f, new qs8.b(r16));
    L20:
        return new BaseVideoDetailFragment.b(r14, r3, r2, r5);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        VideoDetailPagerFragment r4 = getParentFragment();
        if ((r4 instanceof VideoDetailPagerFragment) == false) goto L5;
        VideoDetailPagerFragment r5 = r4;
    L6:
        if (r5 == null) goto L9;
        r5.X90();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r8 = super.onCreateView(r5, r6, r7);
        qs8.a r9 = this.s;
        if (r9 == null) goto L11;
        View r10 = r9.asView();
        if (r10 == null) goto L11;
        LarusVideoDetailLayoutBinding r11 = this.p;
        if (r11 == null) goto L11;
        FrameLayout r12 = r11.b;
        if (r12 == null) goto L11;
        r12.addView(r10, new FrameLayout.LayoutParams(-1, -2, 80));
    L11:
        return r8;
    }
}
