package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformState;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformWidgetTheme;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001bJ\u0012\u0010'\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002R\u001b\u0010\b\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mWaveformBg", "getMWaveformBg", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mWaveformBg$delegate", "Lkotlin/Lazy;", "mWaveform", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "getMWaveform", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "mWaveform$delegate", "mDurationTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getMDurationTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mDurationTv$delegate", "bgPaddingVertical", "", "bgPaddingHorizontal", "mTheme", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformWidgetTheme;", "onStartRecord", "", "onStopRecord", "theme", "reset", "setVolume", "volume", "setDuration", "duration", "", "setColorTheme", "setBgColor", "colorRes", "toggleDurationVisibility", "visible", "", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioWaveformWidget extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final int d;
    public final int e;
    public AudioPluginEnums$WaveformWidgetTheme f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioPluginEnums$WaveformWidgetTheme.values().length];
            r0[AudioPluginEnums$WaveformWidgetTheme.BLUE_SIMPLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AudioPluginEnums$WaveformWidgetTheme.BLUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AudioPluginEnums$WaveformWidgetTheme.GRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    private final AppCompatTextView getMDurationTv() {
        return (AppCompatTextView) this.c.getValue();
    }

    private final AudioWaveform getMWaveform() {
        return (AudioWaveform) this.b.getValue();
    }

    private final ConstraintLayout getMWaveformBg() {
        return (ConstraintLayout) this.a.getValue();
    }

    public final void R5() {
        AudioWaveform r0 = getMWaveform();
        r0.getClass();
        r0.n = AudioPluginEnums$WaveformState.INIT;
        r0.g.clear();
        r0.getClass();
        PthreadTimer r1 = r0.m;
        if (r1 == null) goto L5;
        r1.cancel();
        r1.purge();
    L5:
        r0.m = null;
        r0.invalidate();
        getMDurationTv().setText("0:00");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(AudioPluginEnums$WaveformWidgetTheme r6) {
        Intrinsics.checkNotNullParameter(r6, "theme");
        this.f = r6;
        AudioWaveform r0 = getMWaveform();
        int r1 = r6.getWaveColorRes();
        int r2 = r6.getFadeColorRes();
        Paint r3 = r0.i;
        int r4 = c.a;
        r3.setColor(c.c(r0, r1));
        r0.k.setColor(c.c(r0, r2));
        r0.invalidate();
        getMDurationTv().setTextColor(c.c(this, r6.getTextColorRes()));
        int r5 = r6.getBgColorRes();
        ConstraintLayout r7 = getMWaveformBg();
        if (r5 != 2131106784) goto L5;
        r7.setBackground(null);
        r7.setPadding(0, 0, 0, 0);
    L6:
        invalidate();
        int r8 = b.a[r6.ordinal()];
        if (r8 != 1) goto L9;
        U5(false);
        return;
    L9:
        if (r8 != 2) goto L11;
        U5(true);
        return;
    L11:
        if (r8 != 3) goto L14;
        U5(true);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        Drawable r9 = c.d(this, 2131231880);
        r9.setTint(c.c(this, r5));
        r7.setBackground(r9);
        int r10 = this.e;
        int r11 = this.d;
        r7.setPadding(r10, r11, r10, r11);
        goto L6
    }

    public final void T5(int r2) {
        getMWaveform().setVolume(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(boolean r2) {
        if (r2 == false) goto L4;
        getMDurationTv().setVisibility(0);
        AppCompatTextView r3 = getMDurationTv();
        int r0 = c.a;
        r3.setTextColor(c.c(this, this.f.getTextColorRes()));
        return;
    L4:
        getMDurationTv().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioWaveformWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new AudioWaveformWidget$mWaveformBg$2(this));
        this.b = LazyKt.lazy(new AudioWaveformWidget$mWaveform$2(this));
        this.c = LazyKt.lazy(new AudioWaveformWidget$mDurationTv$2(this));
        int r4 = c.a;
        this.d = c.m(this, 9);
        this.e = c.m(this, 12);
        this.f = AudioPluginEnums$WaveformWidgetTheme.BLUE_SIMPLE;
        LayoutInflater.from(r2).inflate(2131563280, this);
        S5(this.f);
        R5();
    }
}
