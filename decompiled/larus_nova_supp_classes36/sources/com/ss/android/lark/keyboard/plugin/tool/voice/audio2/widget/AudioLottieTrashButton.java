package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DeleteBtnAttrs;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0018\u0018\u0000 '2\u00020\u0001:\u0001'B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0016\u0010\"\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton;", "Lcom/larksuite/component/ui/imageview/LKUILottieAnimationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "finalBias", "", "initBias", "maxDeltaY", "", "getMaxDeltaY", "()I", "finalPadding", "initPadding", "mShakyRunnable", "Ljava/lang/Runnable;", "getMShakyRunnable", "()Ljava/lang/Runnable;", "mShakyRunnable$delegate", "Lkotlin/Lazy;", "mShakyListener", "com/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton$mShakyListener$2$1", "getMShakyListener", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton$mShakyListener$2$1;", "mShakyListener$delegate", "reset", "", "onDragging", "offsetY", "playOpenAnim", "playCloseAnim", "playEndAnim", "onAnimEnd", "Lkotlin/Function0;", "playShakyAnim", "cancelShakyAnim", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioLottieTrashButton extends LKUILottieAnimationView {
    public static final /* synthetic */ int h = 0;
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public final int e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    private final AudioLottieTrashButton$mShakyListener$2.a getMShakyListener() {
        return (AudioLottieTrashButton$mShakyListener$2.a) this.g.getValue();
    }

    private final Runnable getMShakyRunnable() {
        return (Runnable) this.f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        removeAnimatorListener(getMShakyListener());
        removeCallbacks(getMShakyRunnable());
    }

    public final int getMaxDeltaY() {
        return this.c;
    }

    public static final /* synthetic */ Runnable j(AudioLottieTrashButton r0) {
        return r0.getMShakyRunnable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(float r4) {
        final float r5 = r4 / this.c;
        int r0 = c.a;
        c.p(this, new AudioLottieTrashButton$onDragging$1(this, r5));
        int r1 = this.e;
        int r6 = (int) (r1 + (r5 * (this.d - r1)));
        setPadding(r6, r6, r6, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioLottieTrashButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        AudioPluginEnums$DeleteBtnAttrs r4 = AudioPluginEnums$DeleteBtnAttrs.FINAL;
        this.a = r4.getBias();
        AudioPluginEnums$DeleteBtnAttrs r5 = AudioPluginEnums$DeleteBtnAttrs.INIT;
        this.b = r5.getBias();
        int r0 = c.a;
        this.c = c.m(this, 60);
        this.d = c.m(this, Integer.valueOf(r4.getPadding()));
        this.e = c.m(this, Integer.valueOf(r5.getPadding()));
        this.f = LazyKt.lazy(new AudioLottieTrashButton$mShakyRunnable$2(this));
        this.g = LazyKt.lazy(new AudioLottieTrashButton$mShakyListener$2(this));
    }
}
