package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt;
import com.larus.voicecall.impl.databinding.LarusLayoutContinousBottomControllerBinding;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 B2\u00020\u0001:\u0001BB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u0018H\u0002J\u0012\u00101\u001a\u00020\u00182\b\b\u0002\u00102\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u0018H\u0002J\u0012\u00106\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u00020\u0018H\u0002J\b\u00109\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\u0018H\u0002J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020\u0018H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSupportMute", NameKeys.UnloadStrategy_No_Strategy, "()Z", "isSupportMute$delegate", "Lkotlin/Lazy;", "bottomBinding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutContinousBottomControllerBinding;", "delayShowInterruptBtnJob", "Lkotlinx/coroutines/Job;", "getMuteState", "Lkotlin/Function0;", "getCurrentState", "isImmersiveBackground", "resetFiled", NameKeys.UnloadStrategy_No_Strategy, "updateTheme", "onConnecting", "onResume", "onListening", "onThinking", "onSpeaking", "onPause", "onWaiting", "onNetworkError", "onMute", "onUnMute", "onQueryBegin", "onQueryEnd", "isForceResetText", "getRightIcon", "Landroid/view/View;", "getLeftIcon", "getHotArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getIsSupportMute", "onAudioDataReceive", LynxResourceModule.DATA_KEY, "Lcom/larus/audio/audiov3/audio/record/RecordedAudioData;", "refreshConnectionStatusContainer", "refreshSpeakingStatusContainer", "force", "modifyListeningRunnable", "Ljava/lang/Runnable;", "modifyListeningText", "resetModifyListeningText", "refreshListeningStatusContainer", "refreshPausedStatusContainer", "refreshWaitingStatusContainer", "refreshNetworkErrorStatusContainer", "refreshMuteStatusContainer", "refreshUnMuteStatusContainer", "resumeStatusContainerOnUnMute", "delayShowInterrupt", "switchLeftBackground", "isMute", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousTalkLayout extends LinearLayout {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public final LarusLayoutContinousBottomControllerBinding b;
    public Job c;
    public final j1 d;

    public static final class a {
    }

    static {
    }

    public ChatContinuousTalkLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatContinuousTalkLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final ConstraintLayout getHotArea() {
        return this.b.b;
    }

    public final boolean getIsSupportMute() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public final View getLeftIcon() {
        return this.b.d;
    }

    public final View getRightIcon() {
        return this.b.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r0 = this.c;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public final void a(boolean r7) {
        Job r0 = this.c;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isActive() != true) goto L7;
    L8:
        if (r2 == false) goto L11;
        if (r7 == true) goto L11;
        return;
    L11:
        LarusLayoutContinousBottomControllerBinding r8 = this.b;
        TextView r1 = r8.i;
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972079, r1.getContext(), 2131103136)));
        r1.setAlpha(1.0f);
        int r3 = c4a.e.a;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.v == false) goto L14;
        String r4 = AppHost.a.getApplication().getString(2131900486);
        Intrinsics.checkNotNull(r4);
    L15:
        r1.setText(r4);
        r1.setVisibility(0);
        r8.e.k.clear();
        r8.c.setVisibility(0);
        r8.f.setVisibility(8);
        r8.e.setVisibility(8);
        r8.g.setVisibility(8);
        b(false);
        return;
    L14:
        r4 = AppHost.a.getApplication().getString(2131898449);
        Intrinsics.checkNotNull(r4);
    L7:
        r2 = false;
        goto L8
    }

    public final void b(boolean r3) {
        boolean r0 = v19.h.a;
        boolean r1 = !v19.h.b(getContext());
        if (r3 == false) goto L6;
        if (r1 == false) goto L6;
        int r4 = 2131241022;
    L11:
        this.b.d.setBackground(ContextCompat.getDrawable(getContext(), r4));
        return;
    L6:
        if (r3 == false) goto L8;
        r4 = 2131241023;
        goto L11
    L8:
        if (r1 == false) goto L10;
        r4 = 2131241024;
        goto L11
    L10:
        r4 = 2131241025;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r12v15, types: [com.larus.voicecall.impl.continue_talk.j1] */
    public ChatContinuousTalkLayout(final Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = LazyKt.lazy(new i1());
        LayoutInflater.from(r11).inflate(2131562788, this);
        int r14 = 2131367908;
        ConstraintLayout r2 = ViewBindings.findChildViewById(this, 2131367908);
        if (r2 == null) goto L21;
        r14 = 2131367910;
        AppCompatImageView r3 = ViewBindings.findChildViewById(this, 2131367910);
        if (r3 == null) goto L21;
        r14 = 2131367911;
        View r4 = ViewBindings.findChildViewById(this, 2131367911);
        if (r4 == null) goto L21;
        r14 = 2131367912;
        ChatContinuousAudioVisualizerOpt r5 = ViewBindings.findChildViewById(this, 2131367912);
        if (r5 == null) goto L21;
        r14 = 2131367913;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(this, 2131367913);
        if (r6 == null) goto L21;
        r14 = 2131367914;
        AppCompatImageView r7 = ViewBindings.findChildViewById(this, 2131367914);
        if (r7 == null) goto L21;
        r14 = 2131367915;
        View r8 = ViewBindings.findChildViewById(this, 2131367915);
        if (r8 == null) goto L21;
        r14 = 2131367916;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131367916);
        if (r9 == null) goto L21;
        this.b = new LarusLayoutContinousBottomControllerBinding(this, r2, r3, r4, r5, r6, r7, r8, r9);
        this.d = new j1(this, r11);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }

    public /* synthetic */ ChatContinuousTalkLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
