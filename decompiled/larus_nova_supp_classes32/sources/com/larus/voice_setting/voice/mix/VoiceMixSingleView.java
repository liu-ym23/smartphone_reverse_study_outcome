package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceMixSingleBinding;
import com.larus.voice_setting.voice.utils.g;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;
import v2a.a0;
import v2a.b0;
import v2a.c0;
import v2a.d;
import v2a.d0;
import v2a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixSingleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoiceMixSingleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusItemVoiceMixSingleBinding;", LynxResourceModule.DATA_KEY, "Lcom/larus/im/bean/bot/MixVoice;", "listener", "Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "getListener", "()Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "setListener", "(Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;)V", "mixVoicePlayDelegate", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getMixVoicePlayDelegate", "()Lkotlin/jvm/functions/Function0;", "setMixVoicePlayDelegate", "(Lkotlin/jvm/functions/Function0;)V", "init", "bindData", "item", "playing", NameKeys.UnloadStrategy_No_Strategy, "getData", "updateVoice", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "resumePlayLottie", "cancelPlayLottie", "getExpandIconView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixSingleView extends ConstraintLayout implements e {
    public static final /* synthetic */ int e = 0;
    public LarusItemVoiceMixSingleBinding a;
    public MixVoice b;
    public d c;
    public Function0<Unit> d;

    @Override // v2a.c
    public final void m2(SpeakerVoice r1) {
    }

    @Override // v2a.c
    public final void V2() {
        LarusItemVoiceMixSingleBinding r0 = this.a;
        if (r0 == null) goto L7;
        LottieAdapterView r1 = r0.e;
        if (r1 == null) goto L7;
        e1.o(r1);
    L7:
        LarusItemVoiceMixSingleBinding r2 = this.a;
        if (r2 == null) goto L12;
        AppCompatImageView r3 = r2.d;
        if (r3 == null) goto L12;
        e1.x(r3);
    L12:
        LarusItemVoiceMixSingleBinding r4 = this.a;
        if (r4 == null) goto L18;
        LottieAdapterView r5 = r4.e;
        if (r5 == null) goto L19;
        r5.cancelAnimation();
        return;
    L19:
        return;
    }

    @Override // v2a.c
    public final void X0() {
        LarusItemVoiceMixSingleBinding r0 = this.a;
        if (r0 == null) goto L6;
        e1.o(r0.d);
        e1.x(r0.e);
        r0.e.playAnimation();
        return;
    }

    @Override // v2a.e
    public View getExpandIconView() {
        LarusItemVoiceMixSingleBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        LayoutInflater.from(getContext()).inflate(2131562701, this);
        int r0 = 2131369197;
        View r3 = ViewBindings.findChildViewById(this, 2131369197);
        if (r3 == null) goto L26;
        r0 = 2131371905;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131371905);
        if (r4 == null) goto L26;
        r0 = 2131382433;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131382433);
        if (r5 == null) goto L26;
        r0 = 2131382437;
        LottieAdapterView r6 = ViewBindings.findChildViewById(this, 2131382437);
        if (r6 == null) goto L26;
        r0 = 2131392713;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(this, 2131392713);
        if (r7 == null) goto L26;
        r0 = 2131392725;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131392725)) == null) goto L26;
        r0 = 2131392752;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131392752);
        if (r8 == null) goto L26;
        r0 = 2131392768;
        AppCompatTextView r9 = ViewBindings.findChildViewById(this, 2131392768);
        if (r9 == null) goto L26;
        this.a = new LarusItemVoiceMixSingleBinding(this, r3, r4, r5, r6, r7, r8, r9);
        if (getId() != (-1)) goto L21;
        setId(2131392730);
    L21:
        LarusItemVoiceMixSingleBinding r1 = this.a;
        if (r1 == null) goto L27;
        e1.o(r1.b);
        e1.o(r1.f);
        e1.x(r1.c);
        int r2 = g.a;
        g.a(r1.d, i5.h());
        g.a(r1.c, i5.h());
        g.a(r1.g, i5.h());
        e1.d(r1.c, new b0(this));
        return;
    L27:
        return;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    @Override // v2a.c
    public MixVoice getData() {
        return this.b;
    }

    public d getListener() {
        return this.c;
    }

    public final Function0<Unit> getMixVoicePlayDelegate() {
        return this.d;
    }

    public VoiceMixSingleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = new a0();
        R5();
    }

    public void setListener(d r1) {
        this.c = r1;
    }

    public final void setMixVoicePlayDelegate(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public VoiceMixSingleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = new a0();
        R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v2a.c
    public final void p1(final MixVoice r7, boolean r8) {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        Intrinsics.checkNotNullParameter(r7, "item");
        SpeakerVoice r1 = r7.getVoiceItem();
        if (r1 != null) goto L5;
        return;
    L5:
        this.b = r7;
        final LarusItemVoiceMixSingleBinding r2 = this.a;
        if (r2 == null) goto L31;
        r2.h.setText(r1.getName());
        e1.d(r2.a, new c0(r2, this));
        e1.d(r2.g, new d0(this, r7));
        Context r9 = getContext();
        if (r9 == null) goto L31;
        if (z2.a.enableVoiceSettingTalkback() == false) goto L31;
        boolean r3 = false;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L17
        String r10 = r9.getString(2131898890);     // Catch: Throwable -> L17
        Object[] r11 = new Object[1];     // Catch: Throwable -> L17
        String r4 = r1.getName();     // Catch: Throwable -> L17
        if (r4 != null) goto L15;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        r11[0] = r4;     // Catch: Throwable -> L17
        Object r12 = Result.constructor-impl(String.format(r10, Arrays.copyOf(r11, 1)));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r12) == false) goto L22;
        r12 = null;
    L22:
        String r13 = (String) r12;
        if (r13 == null) goto L27;
        r0 = r13;
    L27:
        if (r0.length() <= 0) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L31;
        r2.g.setContentDescription(r0);
    L17:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        if (r8 == false) goto L33;
        X0();
        return;
    L33:
        V2();
    }

    public VoiceMixSingleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new a0();
        R5();
    }
}
