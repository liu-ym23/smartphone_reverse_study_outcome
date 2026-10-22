package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.EditText;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;
import com.ss.android.lark.log.Log;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[AudioPluginEnums$DisplayMode.values().length];
            r0[AudioPluginEnums$DisplayMode.COMPLETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[AudioPluginEnums$DisplayMode.SIMPLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[AudioPluginFeature.values().length];
            r1[AudioPluginFeature.WITH_TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[AudioPluginFeature.RECOGNIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[AudioPluginFeature.RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public h() {
        throw null;
    }

    public final boolean g() {
        Object r0 = null;
        if ((r0 instanceof AbsAudioPopupViewWithEditText) == false) goto L7;
        AbsAudioPopupViewWithEditText r1 = (AbsAudioPopupViewWithEditText) null;
        return false;
    L7:
        return false;
    }

    public final void j(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final String f() {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioMessageDelegate");
        throw null;
    }

    public final boolean h() {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioRecorderDelegate");
        throw null;
    }

    public final void i() {
        Log.i("AudioPluginController", "onDestroy");
        if (h() == false) goto L5;
        throw null;
    L5:
        e(null);
        throw null;
    }

    public final boolean n() {
        if (h() == false) goto L6;
        Log.e("AudioPluginController", "startRecord / Is recording now");
    L6:
        throw null;
    }

    public final EditText b() {
        throw null;
    }

    public final Activity c() {
        throw null;
    }

    public final com.ss.android.lark.keyboard.ime.a d() {
        throw null;
    }

    public static void k(final h r4) {
        r4.getClass();
        final boolean r1 = false;
        final long r2 = 0;
        new AudioPluginController$showCursor$runnable$1(r4, r1, r2).invoke();
    }

    public final int a(AudioPluginFeature r2) {
        r2.getClass();
        int r3 = b.b[r2.ordinal()];
        if (r3 != 1) goto L5;
        int r4 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (KeyboardVoiceModule.a().isZh() == false) goto L15;
        return 2131256162;
    L15:
        return 2131256163;
    L5:
        if (r3 != 2) goto L7;
        return 2131256165;
    L7:
        if (r3 != 3) goto L10;
        return 2131255118;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b e(AbsAudioPopupView r1) {
        throw null;
    }

    public final void l(int r1) {
        throw null;
    }

    public final void m(String r1) {
        throw null;
    }

    public final void p(boolean r1, boolean r2) {
        throw null;
    }

    public static void o(h r0, AudioPluginEnums$DisplayMode r1, MotionEvent r2, int r3, int r4, int r5) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "mode");
        Intrinsics.checkNotNullParameter(r2, "event");
        Log.i("AudioPluginController", "startRecordByLongPressed / displayMode: " + r1);
        r0.getClass();
        int r6 = b.a[r1.ordinal()];
        if (r6 != 1) goto L5;
        throw null;
    L5:
        if (r6 != 2) goto L8;
        throw null;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
