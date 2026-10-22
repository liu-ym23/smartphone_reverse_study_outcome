package com.larus.bmhome.video.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusCreationDetailPromptVideoLayoutBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.c4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ$\u0010\n\u001a\f0\u000bR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/video/fragment/CreationDetailPromptVideoFragment;", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment;", "Lcom/larus/bmhome/databinding/LarusCreationDetailPromptVideoLayoutBinding;", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "<init>", "(Lcom/larus/platform/model/video/VideoPlayData;Lcom/larus/bmhome/utils/VideoDetailEventParams;)V", "()V", "initViews", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment$InitViewsResult;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "tag", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "isVideoMute", "", "autoLogEnterPage", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptVideoFragment extends BaseVideoDetailFragment<LarusCreationDetailPromptVideoLayoutBinding> {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final boolean Z90() {
        return false;
    }

    public CreationDetailPromptVideoFragment() {
        this(new nr9.g(null, null, null, null, null, null, null, null, null, null, 1023), new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383));
        DialogFragment r0 = getParentFragment();     // Catch: Throwable -> L17
        if ((r0 instanceof DialogFragment) == false) goto L7;
        DialogFragment r1 = r0;     // Catch: Throwable -> L17
    L8:
        if (r1 == null) goto L23;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L11 Throwable -> L17
    L25:
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r2 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r2 == null) goto L24;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r1 = null;
    L17:
        FLogger.a.e("CreationDetailPromptVideoFragment", "fallback by dismiss failed");
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final String k() {
        String r0 = this.f.n;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final String tag() {
        StringBuilder r0 = new StringBuilder("CreationDetailPromptVideoFragment");
        nr9.g r1 = this.e;
        if (r1 == null) goto L7;
        String r2 = r1.b;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.hashCode());
    L8:
        r0.append(r3);
        return r0.toString();
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final ShareScene da0() {
        return ShareScene.VIDEO_VIEWER;
    }

    public CreationDetailPromptVideoFragment(nr9.g r8, c4 r9) {
        Intrinsics.checkNotNullParameter(r8, "videoPlayData");
        Intrinsics.checkNotNullParameter(r9, "eventParam");
        super(r8, r9, false, false, 12);
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final BaseVideoDetailFragment<LarusCreationDetailPromptVideoLayoutBinding>.b Y90(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r5 = r3.inflate(2131562001, r4, false);
        int r6 = 2131392620;
        VideoPlayView r0 = ViewBindings.findChildViewById(r5, 2131392620);
        if (r0 == null) goto L9;
        r6 = 2131392621;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131392621);
        if (r1 == null) goto L9;
        return new BaseVideoDetailFragment.b(new LarusCreationDetailPromptVideoLayoutBinding((FrameLayout) r5, r0, r1), r0, null, null);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        LarusCreationDetailPromptVideoLayoutBinding r7 = (LarusCreationDetailPromptVideoLayoutBinding) this.p;
        if (r7 == null) goto L7;
        VideoPlayView r8 = r7.b;
        if (r8 == null) goto L7;
        r8.setClipToOutline(true);
        r8.setOutlineProvider(new x());
    L7:
        LarusCreationDetailPromptVideoLayoutBinding r9 = (LarusCreationDetailPromptVideoLayoutBinding) this.p;
        if (r9 == null) goto L16;
        FrameLayout r10 = r9.c;
        if (r10 == null) goto L17;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L15;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        r12.topMargin = AppHost.a.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971490, null, 2131167350));
        int r0 = m0.a;
        int r1 = m0.b(getContext());
        int r2 = m0.a(getContext());
        float r3 = r1 / 0.75f;
        r12.width = m0.b(getContext());
        r12.height = (int) RangesKt.coerceAtMost(RangesKt.coerceAtMost(c7.b(600), RangesKt.coerceAtMost(r2 * 0.7f, r3)), r3 * 1.0f);
        r10.setLayoutParams(r12);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L17:
        return;
    }
}
