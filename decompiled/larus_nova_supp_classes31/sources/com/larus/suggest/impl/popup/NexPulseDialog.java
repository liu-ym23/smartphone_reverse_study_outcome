package com.larus.suggest.impl.popup;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.bean.PopWindowButton;
import com.larus.bmhome.chat.bean.PopWindowCandidateConf;
import com.larus.bmhome.chat.bean.PopWindowColor;
import com.larus.bmhome.chat.bean.PopWindowMedia;
import com.larus.bmhome.chat.bean.PopWindowText;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IVideoController;
import com.larus.platform.model.chat.j0;
import com.larus.platform.service.z2;
import com.larus.suggest.impl.databinding.LarusNexPulseDialogBinding;
import com.larus.suggest.impl.popup.model.PopWindowCommonBizData;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.p0;
import com.larus.utils.w0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.x1;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001&\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0002J\u001a\u00108\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u00010-2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u00020)2\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010@\u001a\u00020\u00162\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020:H\u0016J\u0010\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020)H\u0016J\b\u0010L\u001a\u00020)H\u0016J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020)H\u0016J\b\u0010O\u001a\u00020)H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006Q"}, d2 = {"Lcom/larus/suggest/impl/popup/NexPulseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/suggest/impl/databinding/LarusNexPulseDialogBinding;", "windowConfig", "Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "groupId", "", "activityId", "expireTime", "", "Ljava/lang/Long;", "currentPage", "campaignTag", "pcGuideSource", "eventHelper", "Lcom/larus/suggest/impl/popup/NexPulseDialogEventHelper;", "dialogConfig", "Lcom/larus/platform/model/chat/NexPulseDialogConfig;", "hasVideoPaused", "", "hasDragVideoPaused", "isMute", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "Lkotlin/Lazy;", "videoStartTs", "firstFrameTime", "hitMDLCache", "Ljava/lang/Boolean;", "reachBlockerId", "isCommonRequesting", "appBackGroundListener", "com/larus/suggest/impl/popup/NexPulseDialog$appBackGroundListener$1", "Lcom/larus/suggest/impl/popup/NexPulseDialog$appBackGroundListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "checkDialog", "pauseVideoWhenDragging", "resumeVideoAfterDragging", "checkWidth", "setClipViewTopCornerRadius", "radius", "", "initView", "openButtonSchema", "buttonConfig", "Lcom/larus/bmhome/chat/bean/PopWindowButton;", "sendCommonRequest", "handleCommonRequestResult", "result", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/suggest/impl/popup/model/PopWindowCommonBizData;", "setVideoEngineListeners", "videoView", "Lcom/larus/common_ui/video/VideoPlayView;", "getTheme", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "onStart", "onStop", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class NexPulseDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int x = 0;
    public LarusNexPulseDialogBinding d;
    public PopWindowCandidateConf e;
    public String f;
    public String g;
    public Long h;
    public String i;
    public String j;
    public String k;
    public p l;
    public final j0 m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final Lazy q;
    public long r;
    public long s;
    public Boolean t;
    public final String u;
    public boolean v;
    public final b w;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ NexPulseDialog a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            if (this.a.m.c() == false) goto L14;
            FLogger.a.i("NexPulseDialog", "dismiss dialog when background");
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L15;
            d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }

        public b(NexPulseDialog r1) {
            this.a = r1;
        }
    }

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ NexPulseDialog a;
        public final /* synthetic */ BottomSheetBehavior<ViewGroup> b;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public c(NexPulseDialog r1, BottomSheetBehavior<ViewGroup> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onStateChanged(View r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "bottomSheet");
            if (r8 != 1) goto L5;
            NexPulseDialog r9 = this.a;
            if (r9.m.f() == false) goto L45;
            LarusNexPulseDialogBinding r4 = r9.d;
            if (r4 == null) goto L45;
            VideoPlayView r5 = r4.k;
            if (r5 == null) goto L45;
            if (r5.r() == false) goto L45;
            VideoPlayView.z(r5, 0, 2);
            r9.o = true;
            FLogger.a.i("NexPulseDialog", "pause video when dragging");
        L45:
            if (this.a.m.d() == true) goto L58;
            this.b.setState(4);
            return;
        L58:
            return;
        L5:
            if (r8 == 3) goto L22;
            if (r8 == 4) goto L22;
            if (r8 == 5) goto L11;
            return;
        L11:
            if (this.a.m.d() == false) goto L50;
            p r10 = this.a.l;
            if (r10 == null) goto L48;
            r10.b("slide_close");
        L48:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L18
            return;
        L18:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L51;
            d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L51:
            return;
        L50:
            return;
        L22:
            NexPulseDialog r12 = this.a;
            if (r12.m.f() == false) goto L61;
            LarusNexPulseDialogBinding r2 = r12.d;
            if (r2 == null) goto L53;
            VideoPlayView r3 = r2.k;
            if (r3 != null) goto L30;
            return;
        L30:
            if (r12.o == true) goto L32;
            return;
        L32:
            if (r3.q() == false) goto L56;
            VideoPlayView.H(r3, 0, 2);
            r12.o = false;
            FLogger.a.i("NexPulseDialog", "resume video after dragging");
            return;
        L56:
            return;
        L53:
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onDestroy() {
        n19.a.a.e(UiPresentationChannel.REACH, this.u);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        LarusNexPulseDialogBinding r0 = this.d;
        if (r0 == null) goto L7;
        VideoPlayView r1 = r0.k;
        if (r1 == null) goto L7;
        r1.D();
    L7:
        AppHost.a.a().c(this.w);
    }

    public final void onStop() {
        n19.a.a.e(UiPresentationChannel.REACH, this.u);
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public NexPulseDialog() {
        this.m = z2.a.A();
        this.p = true;
        this.q = LazyKt.lazy(new l());
        this.u = "NexPulseDialog:" + UUID.randomUUID();
        this.w = new b(this);
    }

    public final void U90() {
        BottomSheetDialog r0 = getDialog();
        ViewGroup r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = (ViewGroup) r1.findViewById(2131368870);
    L8:
        int r3 = m0.a;
        int r4 = m0.a(getContext());
        i0.a.getClass();
        int r5 = (r4 - i0.g()) - i0.e();
        if (r2 == null) goto L12;
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        r6.height = r5;
        r2.setLayoutParams(r6);
        BottomSheetBehavior r7 = BottomSheetBehavior.from(r2);
        r2.setBackgroundResource(R.color.transparent);
        r7.setState(3);
        r7.setPeekHeight(r5);
        r7.setSkipCollapsed(this.m.d());
        r7.setHideable(this.m.d());
        r7.setBottomSheetCallback(new c(this, r7));
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void V90() {
        Context r0 = getContext();
        if (r0 == null) goto L79;
        float r1 = c7.d(Integer.valueOf(com.larus.utils.i.d(r0)));
        FLogger.a.i("NexPulseDialog", "screenWidth dp: " + r1);
        ConstraintLayout r3 = null;
        if (r1 > 480.0f) goto L7;
        LarusNexPulseDialogBinding r2 = this.d;
        if (r2 == null) goto L55;
        ConstraintLayout r4 = r2.d;
        if (r4 == null) goto L55;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof LinearLayout.LayoutParams) == false) goto L50;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
    L51:
        if (r6 == null) goto L53;
        r6.width = -1;
        r6.gravity = 80;
    L54:
        r4.setLayoutParams(r6);
        goto L55
    L53:
        r6 = null;
        goto L54
    L50:
        r6 = null;
    L55:
        LarusNexPulseDialogBinding r7 = this.d;
        if (r7 == null) goto L67;
        VideoPlayView r8 = r7.k;
        if (r8 == null) goto L67;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L62;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
    L63:
        if (r10 == null) goto L65;
        int r11 = m0.a;
        AppHost.Companion r12 = AppHost.a;
        ((ViewGroup.MarginLayoutParams) r10).width = m0.c(r12.getApplication());
        ((ViewGroup.MarginLayoutParams) r10).height = (int) (m0.c(r12.getApplication()) / 1.21875f);
    L66:
        r8.setLayoutParams(r10);
        goto L67
    L65:
        r10 = null;
        goto L66
    L62:
        r10 = null;
    L67:
        LarusNexPulseDialogBinding r13 = this.d;
        if (r13 == null) goto L72;
        SimpleDraweeView r14 = r13.f;
        if (r14 == null) goto L72;
        r14.setAspectRatio(1.21875f);
    L72:
        LarusNexPulseDialogBinding r15 = this.d;
        if (r15 == null) goto L75;
        r3 = r15.d;
    L75:
        int r16 = i5.q();
        if (r3 == null) goto L81;
        r3.setOutlineProvider(new m(r16));
        r3.setClipToOutline(true);
        return;
    L81:
        return;
    L7:
        if (r1 <= c7.d(Integer.valueOf(com.larus.utils.i.c(r0)))) goto L9;
        float r17 = 0.8f;
    L10:
        LarusNexPulseDialogBinding r18 = this.d;
        if (r18 == null) goto L22;
        ConstraintLayout r19 = r18.d;
        if (r19 == null) goto L22;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if ((r20 instanceof LinearLayout.LayoutParams) == false) goto L17;
        LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) r20;
    L18:
        if (r21 == null) goto L20;
        int r22 = CircleProgressBarView.k;
        r21.width = (int) CircleProgressBarView.a.a(r0, r17 * 480.0f);
        r21.gravity = 17;
    L21:
        r19.setLayoutParams(r21);
        goto L22
    L20:
        r21 = null;
        goto L21
    L17:
        r21 = null;
    L22:
        LarusNexPulseDialogBinding r23 = this.d;
        if (r23 == null) goto L34;
        VideoPlayView r24 = r23.k;
        if (r24 == null) goto L34;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if ((r25 instanceof ConstraintLayout.LayoutParams) == false) goto L29;
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
    L30:
        if (r26 == null) goto L32;
        int r27 = CircleProgressBarView.k;
        float r28 = r17 * 480.0f;
        ((ViewGroup.MarginLayoutParams) r26).width = (int) CircleProgressBarView.a.a(r0, r28);
        ((ViewGroup.MarginLayoutParams) r26).height = (int) (CircleProgressBarView.a.a(r0, r28) / 1.21875f);
    L33:
        r24.setLayoutParams(r26);
        goto L34
    L32:
        r26 = null;
        goto L33
    L29:
        r26 = null;
    L34:
        LarusNexPulseDialogBinding r29 = this.d;
        if (r29 == null) goto L39;
        SimpleDraweeView r30 = r29.f;
        if (r30 == null) goto L39;
        r30.setAspectRatio(1.21875f);
    L39:
        LarusNexPulseDialogBinding r31 = this.d;
        if (r31 == null) goto L42;
        r3 = r31.d;
    L42:
        w0.e(r3, i5.q());
        return;
    L9:
        r17 = 1.0f;
        goto L10
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FLogger r0 = FLogger.a;
        r0.i("NexPulseDialog", "onPause");
        LarusNexPulseDialogBinding r2 = this.d;
        if (r2 == null) goto L10;
        VideoPlayView r3 = r2.k;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.r() == false) goto L12;
        VideoPlayView.z(r3, 0, 2);
        this.n = true;
        r0.i("NexPulseDialog", "pause video");
        return;
    L12:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FLogger r0 = FLogger.a;
        r0.i("NexPulseDialog", "onResume hasVideoPaused=" + this.n);
        LarusNexPulseDialogBinding r1 = this.d;
        if (r1 == null) goto L12;
        VideoPlayView r2 = r1.k;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.n == true) goto L9;
        return;
    L9:
        if (r2.q() == false) goto L15;
        VideoPlayView.H(r2, 0, 2);
        this.n = false;
        r0.i("NexPulseDialog", "resume video");
        return;
    L15:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        n19.a.a.a(UiPresentationChannel.REACH, this.u);
    }

    public static void S90(NexPulseDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        LarusNexPulseDialogBinding r3 = this.d;
        if (r3 == null) goto L8;
        LinearLayout r4 = r3.i;
        if (r4 == null) goto L9;
        r4.post(new f(this));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r9) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r9);
        Bundle r10 = getArguments();
        String r0 = null;
        if (r10 == null) goto L5;
        PopWindowCandidateConf r11 = (PopWindowCandidateConf) r10.getParcelable("key_nex_pulse_dialog_data");
    L6:
        this.e = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L9;
        String r13 = r12.getString("key_nex_pulse_dialog_gid");
    L10:
        this.f = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L13;
        String r15 = r14.getString("key_nex_pulse_dialog_activity_id");
    L14:
        this.g = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L17;
        Long r17 = Long.valueOf(r16.getLong("key_nex_pulse_dialog_expire_time"));
    L18:
        this.h = r17;
        Bundle r18 = getArguments();
        if (r18 == null) goto L21;
        String r19 = r18.getString("key_nex_pulse_dialog_current_page");
    L22:
        this.i = r19;
        Bundle r20 = getArguments();
        if (r20 == null) goto L25;
        String r21 = r20.getString("key_nex_pulse_dialog_campaign_tag");
    L26:
        this.j = r21;
        Bundle r22 = getArguments();
        if (r22 == null) goto L29;
        r0 = r22.getString("key_nex_pulse_dialog_pc_guide_source");
    L29:
        this.k = r0;
        PopWindowCandidateConf r2 = this.e;
        if (r2 == null) goto L32;
        this.l = new p(r2, this.i, this.f, this.g, this.j, this.k);
    L32:
        AppHost.a.a().j(this.w);
        return;
    L25:
        r21 = null;
        goto L26
    L21:
        r19 = null;
        goto L22
    L17:
        r17 = null;
        goto L18
    L13:
        r15 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final boolean T90(NexPulseDialog r3, dm9.a r4) {
        r3.getClass();
        if ((r4 instanceof dm9.a.b) == false) goto L18;
        PopWindowCommonBizData r5 = (PopWindowCommonBizData) ((dm9.a.b) r4).a.getData();
        if (r5 != null) goto L7;
        t19.s r6 = t19.s.a;
        Context r7 = r3.getContext();
        r6.getClass();
        t19.s.s(r7, 2131907052);
    L20:
        return false;
    L7:
        boolean r0 = Intrinsics.areEqual(r5.isSuccess(), Boolean.TRUE);
        String r8 = r5.getShowMessage();
        if (r8 != null) goto L10;
        return true;
    L10:
        if ((!StringsKt.isBlank(r8)) == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L25;
        if (r0 == false) goto L16;
        t19.s r1 = t19.s.a;
        Context r9 = r3.getContext();
        r1.getClass();
        t19.s.p(r9, r8);
        return true;
    L16:
        t19.s r2 = t19.s.a;
        Context r10 = r3.getContext();
        r2.getClass();
        t19.s.t(r10, r8);
        return true;
    L25:
        return true;
    L18:
        if ((r4 instanceof dm9.a.a) == false) goto L23;
        t19.s r11 = t19.s.a;
        Context r12 = r3.getContext();
        r11.getClass();
        t19.s.s(r12, 2131907052);
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.widget.TextView, com.larus.bmhome.view.textview.impl.CustomMarkdownTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v21, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    public final void onViewCreated(View r54, Bundle r55) {
        Intrinsics.checkNotNullParameter(r54, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r54, r55);
        U90();
        V90();
        PopWindowCandidateConf r2 = this.e;
        if (r2 == null) goto L315;
        LarusNexPulseDialogBinding r0 = this.d;
        if (r0 == null) goto L9;
        View r1 = r0.h;
        if (r1 == null) goto L9;
        e1.d(r1, new g(this));
    L9:
        LarusNexPulseDialogBinding r3 = this.d;
        if (r3 == null) goto L14;
        AppCompatImageView r4 = r3.c;
        if (r4 == null) goto L14;
        e1.d(r4, new h(this));
    L14:
        boolean r5 = v19.h.a;
        if (v19.h.a(null) == false) goto L19;
        PopWindowColor r6 = r2.getBackgroundColor();
        if (r6 == null) goto L22;
        String r7 = r6.getColorDark();
    L23:
        if (r7 == null) goto L27;
        String r8 = p0.a(r7);
        if (r8 == null) goto L27;
        int r9 = ColorProtector.parseColor(r8);
    L28:
        LarusNexPulseDialogBinding r10 = this.d;
        if (r10 == null) goto L33;
        ConstraintLayout r11 = r10.d;
        if (r11 == null) goto L33;
        r11.setBackgroundColor(r9);
    L33:
        List r12 = r2.getMediaList();
        if (r12 == null) goto L296;
        PopWindowMedia r13 = (PopWindowMedia) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L296;
        Integer r14 = r13.getMediaType();
        boolean r15 = false;
        if (r14 != null) goto L42;
    L59:
        Integer r16 = r13.getMediaType();
        if (r16 != null) goto L63;
    L116:
        PopWindowText r17 = r2.getText();
        LarusNexPulseDialogBinding r18 = this.d;
        if (r18 == null) goto L157;
        TextView r19 = r18.j;
        if (r19 == null) goto L157;
        if (r17 == null) goto L122;
        String r110 = r17.getTitle();
    L123:
        r19.setText(r110);
        if (r17 == null) goto L136;
        Integer r111 = r17.getTextAlignment();
        if (r111 == null) goto L136;
        int r112 = r111.intValue();
        if (r112 == 1) goto L134;
        if (r112 == 2) goto L133;
        if (r112 == 3) goto L132;
        r19.setGravity(17);
        goto L136
    L132:
        r19.setGravity(8388613);
        goto L136
    L133:
        r19.setGravity(17);
        goto L136
    L134:
        r19.setGravity(8388611);
    L136:
        if (v19.h.a(null) == false) goto L146;
        if (r17 == null) goto L142;
        PopWindowColor r113 = r17.getTextColor();
        if (r113 == null) goto L142;
        String r114 = r113.getColorDark();
        if (r114 == null) goto L142;
    L151:
        if (r114 == null) goto L155;
        String r115 = p0.a(r114);
        if (r115 == null) goto L155;
        int r116 = ColorProtector.parseColor(r115);
    L156:
        r19.setTextColor(r116);
    L155:
        r116 = ContextCompat.getColor(AppHost.a.getApplication(), v19.c.b(2130972079, getContext(), 2131103136));
    L142:
        if (r17 == null) goto L150;
        PopWindowColor r117 = r17.getTextColor();
        if (r117 == null) goto L150;
        r114 = r117.getColorLight();
    L150:
        r114 = null;
        goto L151
    L146:
        if (r17 == null) goto L150;
        PopWindowColor r118 = r17.getTextColor();
        if (r118 == null) goto L150;
        r114 = r118.getColorLight();
        goto L151
    L122:
        r110 = null;
    L157:
        LarusNexPulseDialogBinding r20 = this.d;
        if (r20 == null) goto L242;
        ?? r119 = r20.e;
        if (r119 == 0) goto L242;
        if (r17 == null) goto L163;
        String r21 = r17.getDescription();
    L164:
        if (r21 != null) goto L166;
        r21 = "";
    L166:
        ?? r120 = r21;
        w.a.getClass();
        Intrinsics.checkNotNullParameter(r119, "textView");
        Intrinsics.checkNotNullParameter(r120, "description");
        List r22 = SequencesKt.toList(Regex.findAll$default(w.b, r120, 0, 2, null));
        if (r22.isEmpty() == true) goto L171;
        gw8.c.a.getClass();
        gw8.c r121 = gw8.c.a.b();
        if (r121 == null) goto L171;
        SpannableStringBuilder r122 = new SpannableStringBuilder();
        Iterator r24 = r22.iterator();
        int r23 = 0;
        ?? r123 = r122;
    L174:
        if (r24.hasNext() == false) goto L197;
        MatchResult r25 = (MatchResult) r24.next();
        r123.append(r120, r23, r25.getRange().getFirst());
        String r124 = r25.getValue();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L182
        Context r125 = r119.getContext();     // Catch: Throwable -> L182
        Resources r27 = r119.getResources();     // Catch: Throwable -> L182
        ?? r28 = r123;
        Object r29 = Result.constructor-impl(gw8.c.b.a(r121, r125, WindowDisplayMetricsOverride.apply(r27, r27.getDisplayMetrics()).widthPixels, r124, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, 31), null, null, 224).e());     // Catch: Throwable -> L180
        ?? r30 = r28;
    L186:
        if (Result.isFailure-impl(r29) == false) goto L188;
        r29 = null;
    L188:
        SpannableStringBuilder r31 = (SpannableStringBuilder) r29;
        if (r31 == null) goto L190;
        int r126 = r31.length();
    L192:
        if (r126 <= 0) goto L196;
        int r32 = r126 - 1;
        if (r31.charAt(r32) != '\n') goto L196;
        r126 = r32;
    L196:
        r30.append(r31.subSequence(0, r126));
        r23 = r25.getRange().getLast() + 1;
        r123 = r30;
        goto L174
    L190:
        ?? r127 = 0;
    L198:
        if (r127 == 0) goto L201;
        r120 = r127;
    L201:
        r119.setText(r120);
        if (r127 == 0) goto L204;
        r15 = true;
    L204:
        r119.setLinksClickable(r15);
        if (r127 == 0) goto L207;
        MovementMethod r33 = LinkMovementMethod.getInstance();
    L208:
        r119.setMovementMethod(r33);
        if (r17 == null) goto L220;
        Integer r34 = r17.getDescriptionAlignment();
        if (r34 == null) goto L220;
        int r35 = r34.intValue();
        if (r35 == 1) goto L219;
        if (r35 == 2) goto L218;
        if (r35 == 3) goto L217;
        r119.setGravity(17);
        goto L220
    L217:
        r119.setGravity(8388613);
        goto L220
    L218:
        r119.setGravity(17);
        goto L220
    L219:
        r119.setGravity(8388611);
    L220:
        boolean r36 = v19.h.a;
        if (v19.h.a(null) == false) goto L231;
        if (r17 == null) goto L227;
        PopWindowColor r37 = r17.getDescriptionColor();
        if (r37 == null) goto L227;
        String r38 = r37.getColorDark();
        if (r38 == null) goto L227;
    L236:
        if (r38 == null) goto L240;
        String r39 = p0.a(r38);
        if (r39 == null) goto L240;
        int r40 = ColorProtector.parseColor(r39);
    L241:
        r119.setTextColor(r40);
    L240:
        r40 = ContextCompat.getColor(AppHost.a.getApplication(), v19.c.b(2130972082, getContext(), 2131103146));
    L227:
        if (r17 == null) goto L235;
        PopWindowColor r41 = r17.getDescriptionColor();
        if (r41 == null) goto L235;
        r38 = r41.getColorLight();
    L235:
        r38 = null;
        goto L236
    L231:
        if (r17 == null) goto L235;
        PopWindowColor r42 = r17.getDescriptionColor();
        if (r42 == null) goto L235;
        r38 = r42.getColorLight();
        goto L236
    L207:
        r33 = null;
    L180:
        th = th;
    L184:
        Result.Companion r128 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        r30 = r28;
    L182:
        th = th;
        r28 = r123;
        goto L184
    L197:
        r123.append(r120, r23, r120.length());
        r127 = r123;
    L171:
        r127 = 0;
        goto L198
    L163:
        r21 = null;
    L242:
        LarusNexPulseDialogBinding r43 = this.d;
        if (r43 == null) goto L296;
        TextView r44 = r43.b;
        if (r44 == null) goto L296;
        List r45 = r2.getButtonList();
        if (r45 == null) goto L249;
        final PopWindowButton r46 = (PopWindowButton) CollectionsKt.firstOrNull(r45);
    L250:
        if (r46 == null) goto L252;
        String r47 = r46.getText();
    L253:
        r44.setText(r47);
        boolean r48 = v19.h.a;
        if (v19.h.a(null) == false) goto L264;
        if (r46 == null) goto L260;
        PopWindowColor r49 = r46.getTextColor();
        if (r49 == null) goto L260;
        String r50 = r49.getColorDark();
        if (r50 == null) goto L260;
    L269:
        if (r50 == null) goto L273;
        String r51 = p0.a(r50);
        if (r51 == null) goto L273;
        int r52 = ColorProtector.parseColor(r51);
    L274:
        r44.setTextColor(r52);
        if (v19.h.a(null) == false) goto L285;
        if (r46 == null) goto L281;
        PopWindowColor r53 = r46.getBackgroundColor();
        if (r53 == null) goto L281;
        String r56 = r53.getColorDark();
        if (r56 == null) goto L281;
    L290:
        if (r56 == null) goto L294;
        String r57 = p0.a(r56);
        if (r57 == null) goto L294;
        int r58 = ColorProtector.parseColor(r57);
    L295:
        int r59 = w0.a;
        r44.setBackground(w0.b(Integer.valueOf(r58), Float.valueOf(i5.q()), 0.0f, null, 12));
        e1.d(r44, new k(this, r46));
    L294:
        r58 = ContextCompat.getColor(AppHost.a.getApplication(), v19.c.b(2130972123, getContext(), 2131103203));
    L281:
        if (r46 == null) goto L289;
        PopWindowColor r60 = r46.getBackgroundColor();
        if (r60 == null) goto L289;
        r56 = r60.getColorLight();
    L289:
        r56 = null;
        goto L290
    L285:
        if (r46 == null) goto L289;
        PopWindowColor r61 = r46.getBackgroundColor();
        if (r61 == null) goto L289;
        r56 = r61.getColorLight();
    L273:
        r52 = ContextCompat.getColor(AppHost.a.getApplication(), 2131103298);
    L260:
        if (r46 == null) goto L268;
        PopWindowColor r62 = r46.getTextColor();
        if (r62 == null) goto L268;
        r50 = r62.getColorLight();
    L268:
        r50 = null;
        goto L269
    L264:
        if (r46 == null) goto L268;
        PopWindowColor r63 = r46.getTextColor();
        if (r63 == null) goto L268;
        r50 = r63.getColorLight();
        goto L269
    L252:
        r47 = null;
        goto L253
    L249:
        r46 = null;
        goto L250
    L63:
        if (r16.intValue() != 2) goto L116;
        LarusNexPulseDialogBinding r64 = this.d;
        if (r64 == null) goto L94;
        VideoPlayView r65 = r64.k;
        if (r65 == null) goto L94;
        r65.K();
        r65.setIsMuted(true);
        r65.setBackgroundColor(r9);
        r65.setEnabled(false);
        r65.setBanInnerDismiss(true);
        if (v19.h.a(null) == false) goto L73;
        String r66 = r13.getMediaDarkUrl();
        if (r66 != null) goto L74;
        r66 = r13.getMediaUrl();
    L74:
        VideoPlayView.e(r65, (IVideoController) this.q.getValue(), r66, null, null, null, null, 60);
        Unit r67 = Unit.INSTANCE;
        r65.setVideoEngineCallback(new n(this));
        IVideoController r68 = (IVideoController) this.q.getValue();
        if (r68 == null) goto L77;
        r68.s(new o(this));
    L77:
        String r129 = r13.getVideoCoverUrl();
        LarusNexPulseDialogBinding r69 = this.d;
        if (r69 == null) goto L84;
        VideoPlayView r70 = r69.k;
        if (r70 == null) goto L84;
        ViewGroup.LayoutParams r71 = r70.getLayoutParams();
        if (r71 == null) goto L84;
        Integer r130 = Integer.valueOf(r71.width);
    L85:
        LarusNexPulseDialogBinding r72 = this.d;
        if (r72 == null) goto L92;
        VideoPlayView r73 = r72.k;
        if (r73 == null) goto L92;
        ViewGroup.LayoutParams r74 = r73.getLayoutParams();
        if (r74 == null) goto L92;
        Integer r131 = Integer.valueOf(r74.height);
    L93:
        VideoPlayView.p(r65, null, r129, null, r131, r130, null, null, null, 229);
        r65.setIsMuted(this.p);
        r65.M();
        this.r = System.currentTimeMillis();
        FLogger.a.i("NexPulseDialog", "videoView start play");
    L92:
        r131 = null;
    L84:
        r130 = null;
        goto L85
    L73:
        r66 = r13.getMediaUrl();
    L94:
        LarusNexPulseDialogBinding r75 = this.d;
        if (r75 == null) goto L100;
        SimpleDraweeView r76 = r75.f;
        if (r76 == null) goto L100;
        e1.o(r76);
    L100:
        if (Intrinsics.areEqual(r2.getShowMute(), Boolean.TRUE) == false) goto L111;
        LarusNexPulseDialogBinding r77 = this.d;
        if (r77 == null) goto L106;
        ImageView r78 = r77.g;
        if (r78 == null) goto L106;
        e1.x(r78);
    L106:
        LarusNexPulseDialogBinding r79 = this.d;
        if (r79 == null) goto L116;
        ImageView r80 = r79.g;
        if (r80 == null) goto L116;
        e1.d(r80, new j(this));
        goto L116
    L111:
        LarusNexPulseDialogBinding r81 = this.d;
        if (r81 == null) goto L116;
        ImageView r82 = r81.g;
        if (r82 == null) goto L116;
        e1.o(r82);
        goto L116
    L42:
        if (r14.intValue() != 1) goto L59;
        LarusNexPulseDialogBinding r83 = this.d;
        if (r83 == null) goto L54;
        SimpleDraweeView r84 = r83.f;
        if (r84 == null) goto L54;
        if (v19.h.a(null) == false) goto L52;
        String r85 = r13.getMediaDarkUrl();
        if (r85 != null) goto L53;
        r85 = r13.getMediaUrl();
    L53:
        ImageLoaderKt.y(r84, r85, "NexPulseDialog", new i(), 4);
        goto L54
    L52:
        r85 = r13.getMediaUrl();
    L54:
        LarusNexPulseDialogBinding r86 = this.d;
        if (r86 == null) goto L116;
        VideoPlayView r87 = r86.k;
        if (r87 == null) goto L116;
        e1.o(r87);
    L296:
        q r88 = q.a;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NexPulseDialogManager$reportPopWindowShow$1(this.g, this.f, this.h, null), 3, null);
        p r89 = this.l;
        if (r89 == null) goto L316;
        JSONObject r90 = new JSONObject();
        r90.put("current_page", r89.b);
        r90.put("media_type", r89.a());
        r90.put("group_id", r89.c);
        r90.put("activity_id", r89.d);
        r90.put("name", r89.a.getName());
        com.larus.platform.service.o.a.reportEvent("pop_show", r90);
        String r91 = r89.e;
        if (r91 != null) goto L301;
        return;
    L301:
        if (Intrinsics.areEqual(r91, "ug_free_subs_download_pc") == false) goto L303;
        String r92 = r91;
    L304:
        if (r92 == null) goto L318;
        x1.f(r92, "popup_window", null, null, r89.f, null, 108);
        return;
    L318:
        return;
    L303:
        r92 = null;
        goto L304
    L316:
        return;
    L27:
        r9 = ContextCompat.getColor(AppHost.a.getApplication(), v19.c.b(2130970532, getContext(), 2131102539));
    L22:
        r7 = null;
        goto L23
    L19:
        PopWindowColor r93 = r2.getBackgroundColor();
        if (r93 == null) goto L22;
        r7 = r93.getColorLight();
        goto L23
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131562983, r14, false);
        int r17 = 2131365061;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r16, 2131365061);
        if (r2 == null) goto L24;
        r17 = 2131366984;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r16, 2131366984);
        if (r3 == null) goto L24;
        r17 = 2131367754;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r16, 2131367754);
        if (r4 == null) goto L24;
        r17 = 2131367862;
        CustomMarkdownTextView r5 = ViewBindings.findChildViewById(r16, 2131367862);
        if (r5 == null) goto L24;
        r17 = 2131375091;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r16, 2131375091);
        if (r6 == null) goto L24;
        r17 = 2131380532;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r16, 2131380532);
        if (r7 == null) goto L24;
        r17 = 2131381745;
        View r8 = ViewBindings.findChildViewById(r16, 2131381745);
        if (r8 == null) goto L24;
        LinearLayout r18 = (LinearLayout) r16;
        int r19 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r16, 2131385238)) == null) goto L26;
        r19 = 2131388924;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131388924);
        if (r10 == null) goto L26;
        r19 = 2131392404;
        VideoPlayView r11 = ViewBindings.findChildViewById(r16, 2131392404);
        if (r11 == null) goto L26;
        this.d = new LarusNexPulseDialogBinding(r18, r2, r3, r4, r5, r6, r7, r8, r18, r10, r11);
        return r18;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r19)));
    L24:
        r19 = r17;
        goto L26
    }
}
