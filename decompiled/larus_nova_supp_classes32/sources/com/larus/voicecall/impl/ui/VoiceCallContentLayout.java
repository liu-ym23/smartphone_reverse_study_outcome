package com.larus.voicecall.impl.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.view.SceneModeButton;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CallImgConfig;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.larus.voicecall.impl.databinding.LarusLayoutRealtimeCallContentBinding;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.t0;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 |2\u00020\u0001:\u0002{|B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u00109\u001a\u00020:2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010;\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010>\u001a\u00020:2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010A\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020CJ\u0010\u0010D\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020CJ\u000e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0011J\"\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020C2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020@H\u0002J\b\u0010L\u001a\u00020:H\u0002J=\u0010M\u001a\u00020:2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020C2\b\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010O\u001a\u0004\u0018\u00010C¢\u0006\u0002\u0010PJ\u0012\u0010Q\u001a\u00020\u00112\b\u0010O\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010R\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010=J\u0010\u0010S\u001a\u00020:2\u0006\u0010T\u001a\u00020CH\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\u0012\u0010W\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u000e\u0010X\u001a\u00020:2\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020:H\u0002J\b\u0010\\\u001a\u00020:H\u0002J\u000e\u0010]\u001a\u00020:2\u0006\u0010^\u001a\u00020\u0011J\b\u0010_\u001a\u00020:H\u0002J\b\u0010`\u001a\u00020:H\u0002J\b\u0010a\u001a\u00020:H\u0002J\b\u0010b\u001a\u00020:H\u0002J\b\u0010c\u001a\u00020:H\u0002J\u0006\u0010d\u001a\u00020:J\u0006\u0010e\u001a\u00020:J\u0006\u0010f\u001a\u00020:J\u0006\u0010g\u001a\u00020:J\u0006\u0010h\u001a\u00020:J\u0006\u0010i\u001a\u00020:J\u0006\u0010j\u001a\u00020:J\u0006\u0010k\u001a\u00020:J\u0018\u0010l\u001a\u00020:2\u0006\u0010m\u001a\u00020\u00112\b\b\u0002\u0010n\u001a\u00020\u0011J\u000e\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020qJ\u0006\u0010r\u001a\u00020:J\u0010\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020uH\u0014J\b\u0010v\u001a\u00020:H\u0002J\u0016\u0010w\u001a\u00020:*\u0002002\b\b\u0002\u0010x\u001a\u00020\u0018H\u0002J\u0016\u0010y\u001a\u00020:*\u0002002\b\b\u0002\u0010x\u001a\u00020\u0018H\u0002J\b\u0010z\u001a\u00020:H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b,\u0010\"R\u0011\u0010-\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b.\u0010\"R\u0011\u0010/\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020\u001104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006}"}, d2 = {"Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentBinding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutRealtimeCallContentBinding;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "thinkingBubbleShow", NameKeys.UnloadStrategy_No_Strategy, "speakingBubbleShow", "subtitleUseCC", "enableAudioBgSimpleColor", "isBubbleAvatarShow", "enableSubtitle", "imageStartTime", NameKeys.UnloadStrategy_No_Strategy, "micAccessAvatarVisibilityState", "Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout$MicAccessAvatarVisibilityState;", "realtimeCallSceneButton", "Lcom/larus/av_call/view/SceneModeButton;", "getRealtimeCallSceneButton", "()Lcom/larus/av_call/view/SceneModeButton;", "realtimeCallActionContainer", "Landroid/widget/LinearLayout;", "getRealtimeCallActionContainer", "()Landroid/widget/LinearLayout;", "realtimeCallAvatar", "Lcom/larus/common_ui/widget/CircleSimpleDraweeView;", "getRealtimeCallAvatar", "()Lcom/larus/common_ui/widget/CircleSimpleDraweeView;", "realtimeCallAvatarVideo", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView;", "getRealtimeCallAvatarVideo", "()Lcom/larus/voicecall/impl/ui/VoiceCallVideoView;", "micAccessButton", "getMicAccessButton", "doubleLineMicAccessButton", "getDoubleLineMicAccessButton", "hotArea", "Landroid/view/View;", "getHotArea", "()Landroid/view/View;", "clickSwitchAvatarInterceptor", "Lkotlin/Function0;", "getClickSwitchAvatarInterceptor", "()Lkotlin/jvm/functions/Function0;", "setClickSwitchAvatarInterceptor", "(Lkotlin/jvm/functions/Function0;)V", "initView", NameKeys.UnloadStrategy_No_Strategy, "bindListener", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "showBubbleInMainBot", "ballVideo", "Lcom/larus/voicecall/impl/util/RealtimeDiskExt$VoiceVideo;", "tryShowBubbleAvatar", "caller", NameKeys.UnloadStrategy_No_Strategy, "tryHideBubbleAvatar", "switchAudioVisualizerSelfDraw", "enable", "showAvatar", "botType", "botAvatar", "setupVideoPlaybackWithSurfaceCallback", "networkVideo", "hideOldAvatar", "bindAvatar", "simpleMode", "forceAvatarUrl", "(ILjava/lang/String;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/Boolean;Ljava/lang/String;)V", "avatarUrlHostCheck", "switchAvatar", "mobRealtimeCallChangeAvatar", "toAvatar", "animHideOldAvatar", "switchToBubble", "switchToNormalAvatar", "onUpdateMajorState", "state", "Lcom/larus/audio/call/mgr/MajorState;", "adjustAvatarSize", "adjustAvatarPosition", "updateMicAccessArea", "hasPermission", "hideBallVideoForMicAccess", "restoreBallVideoAfterMicAccess", "cacheMicAccessAvatarVisibilityStateIfNeeded", "restoreMicAccessAvatarVisibilityState", "updateMicAccessContainerConstraint", "changeResume", "onSceneModeChange", "invisibleBubble", "hideBubble", "onThinking", "resetBubble", "onPause", "onSpeaking", "showCover", "isShow", "force", "setPlayData", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "cancelThinkingAnim", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adaptForPad", "fromViewAnim", "duration", "targetViewAnim", "onDetachedFromWindow", "MicAccessAvatarVisibilityState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallContentLayout extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final LarusLayoutRealtimeCallContentBinding a;
    public e3a.b b;
    public ThemeType c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public long i;
    public b j;
    public Function0<Boolean> k;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "MicAccessAvatarVisibilityState(realtimeBallVideoVisibility=" + this.a + ", realtimeCallAvatarBgVisibility=" + this.b + ", realtimeCallAvatarVisibility=" + this.c + ", realtimeCallAvatarVideoVisibility=" + this.d + ", realtimeCallAvatarFirstFrameVisibility=" + this.e + ", voiceCallAvatarCoverVisibility=" + this.f + ')';
        }

        public b(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThemeType.values().length];
            r0[ThemeType.MAIN_BOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ThemeType.UGC_BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements VoiceCallVideoView.c {
        public final /* synthetic */ VoiceCallContentLayout a;
        public final /* synthetic */ t0.b b;

        @Override // com.larus.voicecall.impl.ui.VoiceCallVideoView.c
        public final void onSurfaceDestroyed() {
            FLogger.a.d("VoiceCallContentLayout", "Surface destroyed in callback");
        }

        @Override // com.larus.voicecall.impl.ui.VoiceCallVideoView.c
        public final void onSurfaceReady() {
            FLogger.a.d("VoiceCallContentLayout", "Surface ready, starting video playback");
            this.a.getRealtimeCallAvatarVideo().e(this.b, true, new d0());
            this.a.getRealtimeCallAvatarVideo().setSurfaceReadyCallback(null);
        }

        public d(VoiceCallContentLayout r1, t0.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public VoiceCallContentLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceCallContentLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void U5() {
        this.d = false;
        this.e = false;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.utils.c.a(this.a.q);
        com.larus.voicecall.impl.utils.c.a(this.a.s);
    }

    public final void R5() {
        ThemeType r0 = this.c;
        int r1 = c.a[r0.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L5;
    L7:
        View r3 = this.a.m;
        RealtimeCallUtil r4 = RealtimeCallUtil.a;
        e3a.b r5 = this.b;
        if (r5 != null) goto L10;
    L12:
        r2 = false;
    L13:
        r4.getClass();
        if (RealtimeCallUtil.e(r2) == false) goto L16;
        int r6 = 0;
    L17:
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
    L21:
        if (r8 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = 0;
    L23:
        if (r8 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r8).bottomMargin = r6;
    L25:
        if (r8 == null) goto L27;
        r8.bottomToBottom = 0;
    L27:
        r3.setLayoutParams(r8);
        return;
    L20:
        r8 = null;
        goto L21
    L16:
        r6 = i5.O();
        goto L17
    L10:
        if (((h88.b) r5).d != true) goto L12;
    L5:
        if (r1 == 2) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        int r0 = m0.a;
        int r1 = m0.a(getContext());
        ConstraintLayout.LayoutParams r2 = null;
        if (r1 > ((Number) i5.X1.getValue()).intValue()) goto L23;
        int r3 = (int) (((double) r1) * 0.22d);
        ConstraintLayout.LayoutParams r4 = this.a.l.getLayoutParams();
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r5 = r4;
    L8:
        if (r5 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r5).height = r3;
        ((ViewGroup.MarginLayoutParams) r5).width = r3;
    L10:
        this.a.l.setLayoutParams(r5);
        ConstraintLayout.LayoutParams r6 = this.a.m.getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L13;
        ConstraintLayout.LayoutParams r7 = r6;
    L14:
        if (r7 == null) goto L16;
        ((ViewGroup.MarginLayoutParams) r7).height = i5.A() + r3;
        ((ViewGroup.MarginLayoutParams) r7).width = i5.A() + r3;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = i5.E();
    L16:
        this.a.m.setLayoutParams(r7);
        ConstraintLayout.LayoutParams r8 = this.a.n.getLayoutParams();
        if ((r8 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        ConstraintLayout.LayoutParams r9 = r8;
    L20:
        if (r9 == null) goto L22;
        ((ViewGroup.MarginLayoutParams) r9).height = r3;
        ((ViewGroup.MarginLayoutParams) r9).width = r3;
    L22:
        this.a.n.setLayoutParams(r9);
    L48:
        ConstraintLayout.LayoutParams r10 = this.a.q.getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L51;
        ConstraintLayout.LayoutParams r11 = r10;
    L53:
        if (r11 == null) goto L55;
        double r12 = r3;
        r11.setMarginStart((int) (r12 * 0.6d));
        ((ViewGroup.MarginLayoutParams) r11).bottomMargin = ((int) (r12 * 1.2d)) - ((Number) i5.A0.getValue()).intValue();
    L55:
        this.a.q.setLayoutParams(r11);
        ConstraintLayout.LayoutParams r13 = this.a.s.getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L58;
        r2 = r13;
    L58:
        if (r2 == null) goto L60;
        double r14 = r3;
        r2.setMarginStart((int) (0.6d * r14));
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = ((int) (r14 * 1.2d)) - ((Number) i5.A0.getValue()).intValue();
    L60:
        this.a.s.setLayoutParams(r2);
        return;
    L51:
        r11 = null;
        goto L53
    L19:
        r9 = null;
        goto L20
    L13:
        r7 = null;
        goto L14
    L7:
        r5 = null;
        goto L8
    L23:
        int r15 = (int) (((double) r1) * 0.1d);
        int r16 = i5.D();
        ConstraintLayout.LayoutParams r17 = this.a.m.getLayoutParams();
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r18 = r17;
    L27:
        if (r18 == null) goto L29;
        ((ViewGroup.MarginLayoutParams) r18).height = i5.A() + r16;
        ((ViewGroup.MarginLayoutParams) r18).width = i5.A() + r16;
        ((ViewGroup.MarginLayoutParams) r18).topMargin = r15;
    L29:
        this.a.m.setLayoutParams(r18);
        ConstraintLayout.LayoutParams r19 = this.a.l.getLayoutParams();
        if ((r19 instanceof ConstraintLayout.LayoutParams) == false) goto L32;
        ConstraintLayout.LayoutParams r20 = r19;
    L33:
        if (r20 == null) goto L35;
        ((ViewGroup.MarginLayoutParams) r20).height = r16;
        ((ViewGroup.MarginLayoutParams) r20).width = r16;
    L35:
        this.a.l.setLayoutParams(r20);
        ConstraintLayout.LayoutParams r21 = this.a.o.getLayoutParams();
        if ((r21 instanceof ConstraintLayout.LayoutParams) == false) goto L38;
        ConstraintLayout.LayoutParams r22 = r21;
    L39:
        if (r22 == null) goto L41;
        ((ViewGroup.MarginLayoutParams) r22).height = r16;
        ((ViewGroup.MarginLayoutParams) r22).width = r16;
    L41:
        this.a.o.setLayoutParams(r22);
        ConstraintLayout.LayoutParams r23 = this.a.n.getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == false) goto L44;
        ConstraintLayout.LayoutParams r24 = r23;
    L45:
        if (r24 == null) goto L47;
        ((ViewGroup.MarginLayoutParams) r24).height = r16;
        ((ViewGroup.MarginLayoutParams) r24).width = r16;
    L47:
        this.a.n.setLayoutParams(r24);
        r3 = r16;
        goto L48
    L44:
        r24 = null;
        goto L45
    L38:
        r22 = null;
        goto L39
    L32:
        r20 = null;
        goto L33
    L26:
        r18 = null;
        goto L27
    }

    public final void V5() {
        e1.q(this.a.m);
        e1.q(this.a.l);
        e1.q(this.a.n);
        e1.q(this.a.w);
    }

    public final LinearLayout getDoubleLineMicAccessButton() {
        return this.a.b;
    }

    public final View getHotArea() {
        return this.a.u;
    }

    public final LinearLayout getMicAccessButton() {
        return this.a.d;
    }

    public final LinearLayout getRealtimeCallActionContainer() {
        return this.a.k;
    }

    public final CircleSimpleDraweeView getRealtimeCallAvatar() {
        return this.a.l;
    }

    public final VoiceCallVideoView getRealtimeCallAvatarVideo() {
        return this.a.o;
    }

    public final SceneModeButton getRealtimeCallSceneButton() {
        return this.a.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        int r0 = c4a.g.a;
        c4a.g.c(this.a.i);
        c4a.g.c(this.a.m);
    }

    public final Function0<Boolean> getClickSwitchAvatarInterceptor() {
        return this.k;
    }

    private final void setupVideoPlaybackWithSurfaceCallback(t0.b r5) {
        FLogger r0 = FLogger.a;
        r0.d("VoiceCallContentLayout", "setupVideoPlaybackWithSurfaceCallback called");
        getRealtimeCallAvatarVideo().setSurfaceReadyCallback(new d(this, r5));
        if (getRealtimeCallAvatarVideo().h == false) goto L6;
        r0.d("VoiceCallContentLayout", "Surface already ready, playing immediately");
        getRealtimeCallAvatarVideo().e(r5, true, new x());
        getRealtimeCallAvatarVideo().setSurfaceReadyCallback(null);
        return;
    }

    public final void Y5(String r9) {
        e3a.b r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        RealtimeCallParam r2 = r0.a();
    L6:
        if (r2 == null) goto L10;
        RealtimeCallParam.k r3 = r2.p;
        if (r3 == null) goto L10;
        String r4 = r3.g;
    L11:
        if (r2 == null) goto L15;
        RealtimeCallParam.p r5 = r2.o;
        if (r5 == null) goto L15;
        String r6 = r5.h;
    L16:
        if (r2 == null) goto L20;
        RealtimeCallParam.p r7 = r2.o;
        if (r7 == null) goto L20;
        String r8 = r7.c;
    L21:
        if (r2 == null) goto L23;
        String r10 = r2.e;
    L24:
        JSONObject r11 = new JSONObject();
        if (r2 == null) goto L27;
        r1 = r2.d;
    L27:
        r11.put("room_id", r1);
        Unit r12 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        r11.put("enter_method", "click_avatar");     // Catch: JSONException -> L40
        if (r4 == null) goto L31;
        r11.put("chat_type", r4);     // Catch: JSONException -> L40
    L31:
        r11.put("current_page", "call");     // Catch: JSONException -> L40
        if (r6 == null) goto L34;
        r11.put("bot_id", r6);     // Catch: JSONException -> L40
    L34:
        if (r8 == null) goto L36;
        r11.put("conversation_id", r8);     // Catch: JSONException -> L40
    L36:
        if (r10 == null) goto L38;
        r11.put("call_id", r10);     // Catch: JSONException -> L40
    L38:
        r11.put("to_avatar", r9);     // Catch: JSONException -> L40
    L42:
        TrackParams r13 = new TrackParams().merge(r11);
        by7.a r14 = new by7.a("realtime_call_change_avatar");
        r14.a.merge(r13);
        r14.b();
        return;
    L40:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobRealtimeCallChangeAvatar " + e.getLocalizedMessage());
        goto L42
    L23:
        r10 = null;
    L20:
        r8 = null;
    L15:
        r6 = null;
    L10:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void b6(final t0.b r3) {
        V5();
        R5();
        com.larus.utils.t0.c(new b0(this, r3));
        boolean r4 = v19.h.a;
        if (v19.h.a(null) == false) goto L5;
        e1.x(this.a.j);
    L5:
        VoiceCallVideoView r5 = this.a.i;
        Application r0 = c4a.f.a;
        ThemeType r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "themeType");
        if (i88.e.o(r1) == false) goto L8;
        VoiceCallVideoView.b r2 = c4a.f.e;
    L9:
        VoiceCallVideoView.h(r5, r2);
        e1.x(this.a.i);
        this.g = true;
        return;
    L8:
        r2 = c4a.f.d;
        goto L9
    }

    public final void i6(BotModel r23) {
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L6;
        return;
    L6:
        if (((Boolean) NewThemeSwitchAvatar.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (r23 == null) goto L12;
        CallImgConfig r2 = r23.getCallImgConfig();
        if (r2 == null) goto L12;
        String r3 = r2.getDynamicAudioImgUrl();
    L14:
        if (o0.d(r3) == true) goto L22;
        if (r23 == null) goto L19;
        CallImgConfig r4 = r23.getCallImgConfig();
        if (r4 == null) goto L19;
        String r5 = r4.getStaticAudioImgUrl();
    L21:
        if (o0.d(r5) == true) goto L22;
        return;
    L19:
        r5 = null;
    L22:
        NewThemeSwitchAvatar.AvatarType r6 = NewThemeSwitchAvatar.b;
        NewThemeSwitchAvatar.AvatarType r7 = NewThemeSwitchAvatar.AvatarType.NORMAL_AVATAR;
        boolean r8 = true;
        if (r6 != r7) goto L40;
        t0.a.getClass();
        t0.b r9 = t0.d();
        if (r9 != null) goto L27;
    L29:
        r8 = false;
    L30:
        if (r8 == false) goto L39;
        T5(this, this.a.m);
        T5(this, this.a.l);
        T5(this, this.a.o);
        T5(this, this.a.n);
        T5(this, this.a.w);
        R5();
        this.a.i.setVisibility(0);
        VoiceCallVideoView.f(this.a.i, r9);
        boolean r10 = v19.h.a;
        if (v19.h.a(null) == false) goto L34;
        k6(this, this.a.j);
    L34:
        VoiceCallVideoView r1 = this.a.i;
        Application r11 = c4a.f.a;
        ThemeType r12 = this.c;
        Intrinsics.checkNotNullParameter(r12, "themeType");
        if (i88.e.o(r12) == false) goto L37;
        VoiceCallVideoView.b r13 = c4a.f.e;
    L38:
        VoiceCallVideoView.h(r1, r13);
        k6(this, this.a.i);
        goto L39
    L37:
        r13 = c4a.f.d;
    L39:
        NewThemeSwitchAvatar.AvatarType r14 = NewThemeSwitchAvatar.AvatarType.BUBBLE;
        Intrinsics.checkNotNullParameter(r14, "value");
        NewThemeSwitchAvatar.b = r14;
        ((Keva) m78.c.a.getValue()).storeInt("keva_key_avatar_type", r14.getValue());
        Y5("bubble");
        this.a.q.setVisibility(4);
        this.a.s.setVisibility(4);
        return;
    L27:
        if (r9.a() != true) goto L29;
    L40:
        if (r23 == null) goto L44;
        CallImgConfig r15 = r23.getCallImgConfig();
        if (r15 == null) goto L44;
        String r16 = r15.getDynamicAudioImgUrl();
    L45:
        if (r23 == null) goto L49;
        CallImgConfig r17 = r23.getCallImgConfig();
        if (r17 == null) goto L49;
        String r18 = r17.getStaticAudioImgUrl();
    L51:
        if (o0.d(r16) == false) goto L61;
        if (r16 == null) goto L58;
        String r19 = r16.toLowerCase(Locale.ROOT);
        if (r19 == null) goto L58;
        if (StringsKt.contains$default(r19, ".mp4", false, 2, null) != true) goto L58;
        boolean r20 = true;
    L59:
        if (r20 == false) goto L61;
    L63:
        if (o0.d(r16) == false) goto L65;
    L66:
        R5();
        if (r8 == false) goto L69;
        FLogger.a.d("VoiceCallContentLayout", "showAvatar from MP4, dynamicAudioImgUrl=" + r16 + ", staticAudioImgUrl=" + r18);
        this.a.o.setVisibility(0);
        setupVideoPlaybackWithSurfaceCallback(new t0.b(NameKeys.UnloadStrategy_No_Strategy, 2131239456, 220, 220, r16, r18));
    L74:
        if (r8 == false) goto L76;
        k6(this, this.a.o);
        k6(this, this.a.m);
        e1.o(this.a.l);
    L77:
        T5(this, this.a.j);
        T5(this, this.a.i);
        Intrinsics.checkNotNullParameter(r7, "value");
        NewThemeSwitchAvatar.b = r7;
        ((Keva) m78.c.a.getValue()).storeInt("keva_key_avatar_type", r7.getValue());
        Y5("double");
        return;
    L76:
        k6(this, this.a.m);
        k6(this, this.a.l);
        e1.o(this.a.o);
        goto L77
    L69:
        getRealtimeCallAvatar().getHierarchy().setPlaceholderImage(null);
        CircleSimpleDraweeView r110 = getRealtimeCallAvatar();
        if (o0.d(r16) == true) goto L73;
        r16 = r18;
    L73:
        CircleSimpleDraweeView.f(r110, com.larus.image.loader.b0.a(r16, "realtime_call_bot_avatar_new", false, false, 6), com.larus.image.loader.b0.a(r18, "realtime_call_bot_avatar_new", false, false, 6), null, i5.D(), i5.D(), 12);
        goto L74
    L65:
        if (o0.d(r18) == false) goto L74;
    L58:
        r20 = false;
    L61:
        r8 = false;
    L49:
        r18 = null;
    L44:
        r16 = null;
    L12:
        r3 = null;
        goto L14
    }

    public final void n6(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        if (this.g == true) goto L6;
        return;
    L6:
        if (this.c == ThemeType.MAIN_BOT) goto L8;
        return;
    L8:
        if (NewThemeSwitchAvatar.a() == false) goto L19;
        t0.a.getClass();
        t0.b r4 = t0.d();
        if (r4 == null) goto L14;
        boolean r1 = true;
        if (r4.a() != true) goto L14;
    L15:
        if (r1 == false) goto L20;
        b6(r4);
        return;
    L20:
        return;
    L14:
        r1 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*android.view.ViewGroup*/.onConfigurationChanged(r4);
        e2 r0 = e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == true) goto L9;
        return;
    L9:
        if (r0.isPad() == false) goto L13;
        S5();
        R5();
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void setClickSwitchAvatarInterceptor(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setPlayData(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L5;
        return;
    L5:
        this.a.p.setAudioData(r2);
    }

    public static void T5(VoiceCallContentLayout r2, final View r3) {
        r2.getClass();
        r3.animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setDuration(300).withEndAction(new z(r3)).start();
    }

    public static void k6(VoiceCallContentLayout r2, View r3) {
        r2.getClass();
        r3.setVisibility(0);
        r3.setScaleX(0.8f);
        r3.setScaleY(0.8f);
        r3.setAlpha(0.0f);
        r3.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(300).start();
    }

    public final void c6(boolean r2, boolean r3) {
        boolean r0 = true;
        if (r2 == true) goto L5;
        if (r3 == false) goto L10;
        e1.o(this.a.w);
        return;
    L10:
        if (this.a.w.getVisibility() == 0) goto L13;
        r0 = false;
    L13:
        if (r0 == false) goto L19;
        com.larus.voicecall.impl.utils.c.d(this.a.w, false);
        return;
    L19:
        return;
    L5:
        if (this.c != ThemeType.DEFAULT) goto L16;
        com.larus.voicecall.impl.utils.c.d(this.a.w, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceCallContentLayout(Context r27, AttributeSet r28, int r29) {
        Intrinsics.checkNotNullParameter(r27, "context");
        super(r27, r28, r29);
        LayoutInflater.from(r27).inflate(2131562870, this);
        int r0 = 2131370116;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(this, 2131370116);
        if (r2 == null) goto L57;
        r0 = 2131370117;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131370117)) == null) goto L57;
        r0 = 2131370118;
        if (((TextView) ViewBindings.findChildViewById(this, 2131370118)) == null) goto L57;
        r0 = 2131370119;
        if (((TextView) ViewBindings.findChildViewById(this, 2131370119)) == null) goto L57;
        r0 = 2131370120;
        if (ViewBindings.findChildViewById(this, 2131370120) == null) goto L57;
        r0 = 2131370121;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131370121);
        if (r3 == null) goto L57;
        r0 = 2131380045;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(this, 2131380045);
        if (r4 == null) goto L57;
        r0 = 2131380046;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(this, 2131380046);
        if (r5 == null) goto L57;
        r0 = 2131380047;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131380047);
        if (r6 == null) goto L57;
        r0 = 2131380048;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131380048);
        if (r7 == null) goto L57;
        r0 = 2131380049;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131380049);
        if (r8 == null) goto L57;
        r0 = 2131383785;
        VoiceCallVideoView r9 = (VoiceCallVideoView) ViewBindings.findChildViewById(this, 2131383785);
        if (r9 == null) goto L57;
        r0 = 2131383786;
        AppCompatImageView r10 = ViewBindings.findChildViewById(this, 2131383786);
        if (r10 == null) goto L57;
        r0 = 2131383792;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(this, 2131383792);
        if (r11 == null) goto L57;
        r0 = 2131383793;
        CircleSimpleDraweeView r12 = ViewBindings.findChildViewById(this, 2131383793);
        if (r12 == null) goto L57;
        r0 = 2131383794;
        View r13 = ViewBindings.findChildViewById(this, 2131383794);
        if (r13 == null) goto L57;
        r0 = 2131383795;
        CircleSimpleDraweeView r14 = ViewBindings.findChildViewById(this, 2131383795);
        if (r14 == null) goto L57;
        r0 = 2131383796;
        VoiceCallVideoView r16 = (VoiceCallVideoView) ViewBindings.findChildViewById(this, 2131383796);
        if (r16 == null) goto L57;
        r0 = 2131383798;
        CustomBarCountAudioVisualizer r17 = ViewBindings.findChildViewById(this, 2131383798);
        if (r17 == null) goto L57;
        r0 = 2131383799;
        RelativeLayout r18 = (RelativeLayout) ViewBindings.findChildViewById(this, 2131383799);
        if (r18 == null) goto L57;
        r0 = 2131383800;
        LottieAdapterView r19 = ViewBindings.findChildViewById(this, 2131383800);
        if (r19 == null) goto L57;
        r0 = 2131383801;
        FrameLayout r20 = (FrameLayout) ViewBindings.findChildViewById(this, 2131383801);
        if (r20 == null) goto L57;
        r0 = 2131383802;
        LottieAdapterView r21 = ViewBindings.findChildViewById(this, 2131383802);
        if (r21 == null) goto L57;
        r0 = 2131383806;
        View r22 = ViewBindings.findChildViewById(this, 2131383806);
        if (r22 == null) goto L57;
        r0 = 2131383821;
        SceneModeButton r23 = ViewBindings.findChildViewById(this, 2131383821);
        if (r23 == null) goto L57;
        r0 = 2131392655;
        View r24 = ViewBindings.findChildViewById(this, 2131392655);
        if (r24 == null) goto L57;
        this.a = new LarusLayoutRealtimeCallContentBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        this.c = ThemeType.DEFAULT;
        RealtimeCallUtil.a.getClass();
        this.h = RealtimeCallUtil.k();
        this.k = new y();
        return;
    L57:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public final void Z5(int r23, String r24, BotModel r25) {
        LarusLayoutRealtimeCallContentBinding r1 = this.a;
        boolean r4 = false;
        if (r23 != 1) goto L48;
        if (r25 == null) goto L6;
        String r6 = r25.getDynamicImgUrl();
    L7:
        if (r25 == null) goto L11;
        CallImgConfig r7 = r25.getCallImgConfig();
        if (r7 == null) goto L11;
        String r13 = r7.getDynamicAudioImgUrl();
    L12:
        if (r25 == null) goto L16;
        CallImgConfig r8 = r25.getCallImgConfig();
        if (r8 == null) goto L16;
        String r14 = r8.getStaticAudioImgUrl();
    L18:
        if (o0.d(r13) == false) goto L28;
        if (r13 == null) goto L25;
        String r9 = r13.toLowerCase(Locale.ROOT);
        if (r9 == null) goto L25;
        if (StringsKt.contains$default(r9, ".mp4", false, 2, null) != true) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        boolean r11 = true;
    L30:
        if (this.c != ThemeType.MAIN_BOT) goto L44;
        if (o0.d(r13) == false) goto L34;
    L35:
        R5();
        Uri r5 = com.larus.image.loader.b0.a(r14, "realtime_call_bot_avatar_new", false, false, 6);
        FLogger r12 = FLogger.a;
        r12.d("NewThemeSwitchAvatar", "isCached: " + Fresco.getImagePipeline().isInBitmapMemoryCache(r5));
        if (r11 == false) goto L38;
        r12.d("VoiceCallContentLayout", "showAvatar from MP4, dynamicAudioImgUrl=" + r13 + ", staticAudioImgUrl=" + r14);
        r1.o.setVisibility(0);
        r1.l.setVisibility(8);
        setupVideoPlaybackWithSurfaceCallback(new t0.b(NameKeys.UnloadStrategy_No_Strategy, 2131239456, 220, 220, r13, r14));
        return;
    L38:
        r12.d("VoiceCallContentLayout", "showAvatar from WebP, dynamicAudioImgUrl=" + r13 + ", staticAudioImgUrl=" + r14);
        r1.l.setVisibility(0);
        r1.o.setVisibility(8);
        r1.l.getHierarchy().setPlaceholderImage(null);
        CircleSimpleDraweeView r15 = r1.l;
        if (o0.d(r13) == true) goto L42;
        r13 = r14;
    L42:
        CircleSimpleDraweeView.f(r15, com.larus.image.loader.b0.a(r13, "realtime_call_bot_avatar_new", false, false, 6), r5, null, i5.D(), i5.D(), 12);
        return;
    L34:
        if (o0.d(r14) == true) goto L35;
    L44:
        if (o0.d(r6) == false) goto L46;
        CircleSimpleDraweeView.f(r1.l, com.larus.image.loader.b0.a(r6, "realtime_call_bot_avatar", false, false, 6), null, null, 0, 0, 62);
        return;
    L46:
        int r2 = com.larus.voicecall.impl.utils.j.a;
        com.larus.voicecall.impl.utils.j.a(r1.l, r1.n, false);
        e1.x(r1.n);
        CircleSimpleDraweeView r3 = r1.n;
        com.larus.voicecall.impl.utils.j.a(r3, r3, true);
        return;
    L25:
        r10 = false;
    L28:
        r11 = false;
    L16:
        r14 = null;
    L11:
        r13 = null;
        goto L12
    L6:
        r6 = null;
        goto L7
    L48:
        if (r24.length() != 0) goto L50;
        r4 = true;
    L50:
        if (r4 == false) goto L52;
        ImageLoaderKt.u(r1.l, "res://" + AppHost.a.getApplication().getPackageName() + "/2131240119", null);
        return;
    L52:
        ImageLoaderKt.u(r1.l, r24, "realtime_call_bot_avatar");
    }

    public /* synthetic */ VoiceCallContentLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
