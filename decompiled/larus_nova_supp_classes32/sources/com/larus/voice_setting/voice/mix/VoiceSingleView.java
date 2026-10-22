package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceMixSingleNewBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v2a.d;
import v2a.e;
import v2a.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u0004\u0018\u00010&J\b\u0010'\u001a\u0004\u0018\u00010(J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoiceMixSingleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusItemVoiceMixSingleNewBinding;", LynxResourceModule.DATA_KEY, "Lcom/larus/im/bean/bot/MixVoice;", "init", NameKeys.UnloadStrategy_No_Strategy, "listener", "Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "getListener", "()Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "setListener", "(Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;)V", "bindData", "item", "playing", NameKeys.UnloadStrategy_No_Strategy, "updatePlayStatus", "isPlaying", "getData", "updateVoice", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "resumePlayLottie", "cancelPlayLottie", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottie", "Lcom/lynx/lottieadapter/LottieAdapterView;", "getExpandIconView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceSingleView extends ConstraintLayout implements e {
    public static final /* synthetic */ int d = 0;
    public LarusItemVoiceMixSingleNewBinding a;
    public MixVoice b;
    public d c;

    @Override // v2a.c
    public final void V2() {
        S5(false);
    }

    @Override // v2a.c
    public final void X0() {
        S5(true);
    }

    @Override // v2a.e
    public View getExpandIconView() {
        LarusItemVoiceMixSingleNewBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final ImageView getPlayIcon() {
        LarusItemVoiceMixSingleNewBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final LottieAdapterView getPlayLottie() {
        LarusItemVoiceMixSingleNewBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        LayoutInflater.from(getContext()).inflate(2131562702, this);
        int r0 = 2131371904;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131371904);
        if (r4 == null) goto L17;
        r0 = 2131382433;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131382433);
        if (r5 == null) goto L17;
        r0 = 2131382437;
        LottieAdapterView r6 = ViewBindings.findChildViewById(this, 2131382437);
        if (r6 == null) goto L17;
        r0 = 2131392725;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131392725)) == null) goto L17;
        r0 = 2131392752;
        AppCompatImageView r7 = ViewBindings.findChildViewById(this, 2131392752);
        if (r7 == null) goto L17;
        r0 = 2131392768;
        AppCompatTextView r8 = ViewBindings.findChildViewById(this, 2131392768);
        if (r8 == null) goto L17;
        this.a = new LarusItemVoiceMixSingleNewBinding(this, r4, r5, r6, r7, r8);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    @Override // v2a.c
    public MixVoice getData() {
        return this.b;
    }

    public d getListener() {
        return this.c;
    }

    public VoiceSingleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5();
    }

    public final void S5(boolean r4) {
        LarusItemVoiceMixSingleNewBinding r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        r0.c.setVisibility(8);
        r0.d.setVisibility(0);
        r0.d.cancelAnimation();
        r0.d.setAnimation("lottie/text_msg_voice_playing.json");
        r0.d.playAnimation();
        return;
    L7:
        r0.c.setVisibility(0);
        r0.d.setVisibility(8);
        r0.d.cancelAnimation();
    }

    @Override // v2a.c
    public final void m2(SpeakerVoice r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        MixVoice r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVoiceItem(r2);
    L7:
        LarusItemVoiceMixSingleNewBinding r1 = this.a;
        if (r1 == null) goto L13;
        AppCompatTextView r3 = r1.f;
        if (r3 == null) goto L14;
        r3.setText(r2.getName());
        return;
    L14:
        return;
    }

    public void setListener(d r1) {
        this.c = r1;
    }

    public VoiceSingleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5();
    }

    @Override // v2a.c
    public final void p1(final MixVoice r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        SpeakerVoice r5 = r3.getVoiceItem();
        if (r5 != null) goto L5;
        return;
    L5:
        this.b = r3;
        LarusItemVoiceMixSingleNewBinding r0 = this.a;
        if (r0 == null) goto L9;
        r0.f.setText(r5.getName());
        e1.d(r0.e, new k0(this, r3));
        return;
    }

    public VoiceSingleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5();
    }
}
