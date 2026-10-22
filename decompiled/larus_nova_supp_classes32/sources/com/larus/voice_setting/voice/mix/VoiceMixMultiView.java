package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.bmhome.utils.a4;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceMixMultiBinding;
import com.larus.voice_setting.voice.utils.g;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p68.e;
import v19.c7;
import v19.i5;
import v2a.d;
import v2a.w;
import v2a.x;
import v2a.y;
import v2a.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0&H\u0002J\n\u0010'\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixMultiView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoiceMixItem;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusItemVoiceMixMultiBinding;", LynxResourceModule.DATA_KEY, "Lcom/larus/im/bean/bot/MixVoice;", "listener", "Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "getListener", "()Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "setListener", "(Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;)V", "audioObserverExtraParamsGetter", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "getAudioObserverExtraParamsGetter", "()Lkotlin/jvm/functions/Function0;", "setAudioObserverExtraParamsGetter", "(Lkotlin/jvm/functions/Function0;)V", "init", NameKeys.UnloadStrategy_No_Strategy, "bindData", "item", "playing", NameKeys.UnloadStrategy_No_Strategy, "getGlobalAudioObserverExtraParams", NameKeys.UnloadStrategy_No_Strategy, "getData", "updateVoice", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "resumePlayLottie", "cancelPlayLottie", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixMultiView extends ConstraintLayout implements v2a.c {
    public static final /* synthetic */ int e = 0;
    public LarusItemVoiceMixMultiBinding a;
    public MixVoice b;
    public d c;
    public Function0<? extends Map<String, String>> d;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ SpeakerVoice a;
        public final /* synthetic */ VoiceMixMultiView b;
        public final /* synthetic */ LarusItemVoiceMixMultiBinding c;
        public final /* synthetic */ MixVoice d;

        public final void onBegin() {
            GlobalAudioObserver r0 = GlobalAudioObserver.a;
            String r1 = this.a.getStyleId();
            if (r1 != null) goto L5;
            r1 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            r0.e("trail_listening", r1, VoiceMixMultiView.R5(this.b));
            r0.c("trail_listening", GlobalAudioStateEnum.PLAYING, VoiceMixMultiView.R5(this.b));
        }

        public final void onEnd() {
            GlobalAudioObserver.a.c("trail_listening", GlobalAudioStateEnum.STOPPED, VoiceMixMultiView.R5(this.b));
            AudioServiceDelegate.a.O().c(SoundsSource.VOICE_TEST);
            e1.x(this.c.c);
            this.c.b.setVisibility(8);
            this.c.b.cancelAnimation();
            d r0 = this.b.getListener();
            if (r0 == null) goto L6;
            r0.c(this.d.getVoiceItem());
            return;
        }

        public final void onError() {
            final LarusItemVoiceMixMultiBinding r0 = this.c;
            final VoiceMixMultiView r1 = this.b;
            final MixVoice r2 = this.d;
            t0.e(new z(r0, r1, r2));
        }

        public b(SpeakerVoice r1, VoiceMixMultiView r2, LarusItemVoiceMixMultiBinding r3, MixVoice r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ VoiceMixMultiView a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r1) {
        }

        public c(VoiceMixMultiView r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r3) {
            d r0 = this.a.getListener();
            if (r0 == null) goto L13;
            MixVoice r1 = this.a.b;
            if (r1 == null) goto L7;
            SpeakerVoice r2 = r1.getVoiceItem();
        L8:
            if (r3 == null) goto L10;
            int r4 = r3.getProgress();
        L11:
            r0.b(r2, Integer.valueOf(r4 + 1));
            return;
        L10:
            r4 = 99;
            goto L11
        L7:
            r2 = null;
            goto L8
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            a4.a.getClass();
            a4.a(5);
        }
    }

    static {
    }

    private final Map<String, String> getGlobalAudioObserverExtraParams() {
        Map<String, String> r0 = (Map) this.d.invoke();
        r0.put("current_page", "bot_voice_change");
        return r0;
    }

    @Override // v2a.c
    public final void V2() {
        LarusItemVoiceMixMultiBinding r0 = this.a;
        if (r0 == null) goto L7;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L7;
        e1.x(r1);
    L7:
        LarusItemVoiceMixMultiBinding r2 = this.a;
        if (r2 == null) goto L12;
        LottieAdapterView r3 = r2.b;
        if (r3 == null) goto L12;
        e1.o(r3);
    L12:
        LarusItemVoiceMixMultiBinding r4 = this.a;
        if (r4 == null) goto L18;
        LottieAdapterView r5 = r4.b;
        if (r5 == null) goto L19;
        r5.cancelAnimation();
        return;
    L19:
        return;
    }

    @Override // v2a.c
    public final void X0() {
        LarusItemVoiceMixMultiBinding r0 = this.a;
        if (r0 == null) goto L6;
        e1.q(r0.c);
        e1.x(r0.b);
        r0.b.playAnimation();
        return;
    }

    @Override // v2a.c
    public MixVoice getData() {
        MixVoice r0 = this.b;
        if (r0 == null) goto L12;
        LarusItemVoiceMixMultiBinding r1 = this.a;
        if (r1 == null) goto L9;
        SeekBar r2 = r1.e;
        if (r2 == null) goto L9;
        int r3 = r2.getProgress();
    L10:
        r0.setPercentage(r3 + 1);
    L9:
        r3 = 99;
    L12:
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        LayoutInflater.from(getContext()).inflate(2131562700, this);
        int r0 = 2131382437;
        LottieAdapterView r4 = ViewBindings.findChildViewById(this, 2131382437);
        if (r4 == null) goto L30;
        r0 = 2131387061;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131387061);
        if (r5 == null) goto L30;
        r0 = 2131392732;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131392732);
        if (r6 == null) goto L30;
        r0 = 2131392744;
        SeekBar r7 = (SeekBar) ViewBindings.findChildViewById(this, 2131392744);
        if (r7 == null) goto L30;
        r0 = 2131392746;
        if (ViewBindings.findChildViewById(this, 2131392746) == null) goto L30;
        r0 = 2131392752;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131392752);
        if (r8 == null) goto L30;
        this.a = new LarusItemVoiceMixMultiBinding(this, r4, r5, r6, r7, r8);
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        r1.bottomMargin = c7.b(6);
        LarusItemVoiceMixMultiBinding r2 = this.a;
        if (r2 == null) goto L20;
        View r3 = r2.a;
        if (r3 == null) goto L20;
        r3.setLayoutParams(r1);
    L20:
        if (z2.a.enableVoiceSettingTalkback() == false) goto L33;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        setImportantForAccessibility(2);     // Catch: Throwable -> L23
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L34;
        FLogger.a.e("VoiceMixMultiView", "set importantForAccessibility failed", r11);
        return;
    L34:
        return;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L33:
        return;
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public final Function0<Map<String, String>> getAudioObserverExtraParamsGetter() {
        return this.d;
    }

    public final d getListener() {
        return this.c;
    }

    public VoiceMixMultiView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = new w();
        S5();
    }

    public static final /* synthetic */ Map R5(VoiceMixMultiView r0) {
        return r0.getGlobalAudioObserverExtraParams();
    }

    @Override // v2a.c
    public final void m2(SpeakerVoice r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        MixVoice r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVoiceItem(r3);
    L7:
        LarusItemVoiceMixMultiBinding r1 = this.a;
        if (r1 == null) goto L12;
        AppCompatTextView r2 = r1.d;
        if (r2 == null) goto L12;
        r2.setText(r3.getName());
    L12:
        IconItem r4 = r3.getIcon();
        if (r4 == null) goto L16;
        r4.getUrl();
        return;
    }

    public final void setAudioObserverExtraParamsGetter(Function0<? extends Map<String, String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setListener(d r1) {
        this.c = r1;
    }

    public VoiceMixMultiView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = new w();
        S5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v2a.c
    public final void p1(final MixVoice r9, boolean r10) {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        Intrinsics.checkNotNullParameter(r9, "item");
        final SpeakerVoice r1 = r9.getVoiceItem();
        if (r1 != null) goto L5;
        return;
    L5:
        this.b = r9;
        final LarusItemVoiceMixMultiBinding r2 = this.a;
        if (r2 == null) goto L41;
        IconItem r3 = r1.getIcon();
        if (r3 == null) goto L10;
        r3.getUrl();
    L10:
        r2.d.setText(r1.getName());
        e1.d(r2.a, new x(r2, r1, this, r9));
        SeekBar r4 = r2.e;
        boolean r5 = true;
        if ((r9.getPercentage() - 1) >= 0) goto L13;
        int r6 = 0;
    L14:
        r4.setProgress(r6);
        r2.e.setOnSeekBarChangeListener(new c(this));
        z2 r7 = z2.a;
        if (r7.enableVoiceSettingTalkback() == false) goto L17;
        AccessibilityDelegateCompat r8 = new VoiceMixMultiView$bindData$1$accessibilityDelegate$1(this, r2, r1);
        ViewCompat.setAccessibilityDelegate(r2.e, r8);
    L17:
        int r11 = g.a;
        g.a(r2.f, i5.h());
        g.a(r2.c, i5.h());
        e1.d(r2.f, new y(this, r9));
        Context r12 = getContext();
        if (r12 == null) goto L41;
        if (r7.enableVoiceSettingTalkback() == false) goto L41;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L26
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L26
        String r15 = r12.getString(2131898890);     // Catch: Throwable -> L26
        Object[] r16 = new Object[1];     // Catch: Throwable -> L26
        String r17 = r1.getName();     // Catch: Throwable -> L26
        if (r17 != null) goto L24;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r16[0] = r17;     // Catch: Throwable -> L26
        Object r18 = Result.constructor-impl(String.format(r15, Arrays.copyOf(r16, 1)));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r18) == false) goto L31;
        r18 = null;
    L31:
        String r19 = (String) r18;
        if (r19 == null) goto L36;
        r0 = r19;
    L36:
        if (r0.length() > 0) goto L39;
        r5 = false;
    L39:
        if (r5 == false) goto L41;
        r2.f.setContentDescription(r0);
    L26:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L13:
        r6 = r9.getPercentage() - 1;
    L41:
        if (r10 == false) goto L46;
        X0();
        return;
    }

    public VoiceMixMultiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new w();
        S5();
    }
}
