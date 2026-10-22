package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import fd2.v;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LyricsRecognizer implements v {
    public SpeechEngine a;
    public long b;
    public SpeechEngine c;
    public long d;
    public boolean e;
    public com.bytedance.android.live.pushstream.d f;
    public final Lazy g;
    public final CompositeDisposable h;

    public static final class a {
    }

    static {
    }

    public final boolean c() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    public final void destroyEngine() {
        ALogger.i("LyricsRecognizer", "destroyEngine");
        this.e = false;
        com.bytedance.android.live.pushstream.d r0 = this.f;
        if (r0 == null) goto L7;
        d0 r1 = r0.A();
        if (r1 == null) goto L7;
        r1.h();
    L7:
        SpeechEngine r2 = this.a;
        if (r2 == null) goto L10;
        r2.destroyEngine();
    L10:
        this.b = -1;
        this.a = null;
        SpeechEngine r3 = this.c;
        if (r3 == null) goto L13;
        r3.destroyEngine();
    L13:
        this.d = -1;
        this.c = null;
        this.f = null;
        this.h.clear();
    }

    public final void i() {
        ALogger.i("LyricsRecognizer", "stopRecognize");
        com.bytedance.android.live.pushstream.d r0 = this.f;
        if (r0 == null) goto L8;
        d0 r1 = r0.A();
        if (r1 == null) goto L9;
        r1.h();
        return;
    L9:
        return;
    }

    public final void initEngine() {
        if (this.e == true) goto L56;
        this.e = true;
        SpeechEngine r0 = SpeechEngineGenerator.getInstance();
        Integer r3 = null;
        if (r0 == null) goto L30;
        this.a = r0;
        this.b = r0.createEngine();
        SpeechEngine r1 = this.a;
        if (r1 == null) goto L10;
        r1.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r2 = this.a;
        if (r2 == null) goto L13;
        r2.setOptionString("debug_path", "");
    L13:
        SpeechEngine r4 = this.a;
        if (r4 == null) goto L16;
        r4.setOptionString("engine_name", "afp");
    L16:
        SpeechEngine r5 = this.a;
        if (r5 == null) goto L19;
        Integer r6 = Integer.valueOf(r5.initEngine());
    L20:
        if (r6 != null) goto L23;
    L24:
        ALogger.i("LyricsRecognizer", "init fp engine error, ret = " + r6);
        goto L30
    L23:
        if (r6.intValue() != 0) goto L24;
        SpeechEngine r7 = this.a;
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.resetEngine(this.b));
    L29:
        ALogger.i("LyricsRecognizer", "reset fp engine, ret = " + r8);
        goto L30
    L28:
        r8 = null;
        goto L29
    L19:
        r6 = null;
    L30:
        SpeechEngine r9 = SpeechEngineGenerator.getInstance();
        if (r9 == null) goto L58;
        this.c = r9;
        this.d = r9.createEngine();
        SpeechEngine r11 = this.c;
        if (r11 == null) goto L36;
        r11.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r12 = this.c;
        if (r12 == null) goto L39;
        r12.setOptionString("debug_path", "");
    L39:
        SpeechEngine r13 = this.c;
        if (r13 == null) goto L42;
        r13.setOptionString("engine_name", "coversong");
    L42:
        SpeechEngine r14 = this.c;
        if (r14 == null) goto L45;
        Integer r15 = Integer.valueOf(r14.initEngine());
    L46:
        if (r15 != null) goto L49;
    L50:
        ALogger.i("LyricsRecognizer", "init cover engine error, ret = " + r15);
        return;
    L49:
        if (r15.intValue() != 0) goto L50;
        SpeechEngine r16 = this.c;
        if (r16 == null) goto L54;
        r3 = Integer.valueOf(r16.resetEngine(this.d));
    L54:
        ALogger.i("LyricsRecognizer", "reset cover engine, ret = " + r3);
        return;
    L45:
        r15 = null;
        goto L46
    L58:
        return;
    }

    public LyricsRecognizer() {
        new kd2.b(0, 0);
        this.g = LazyKt.lazy(LyricsRecognizer$maxBufferSize$2.INSTANCE);
        this.h = new CompositeDisposable();
    }

    public final void f(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r2, "parent");
    }

    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    public final void j(ei6.a r3, com.bytedance.android.live.pushstream.d r4, kd2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "recognitionParams");
        ALogger.i("LyricsRecognizer", "startRecognize, source: " + r5.a + ", appId: " + r5.b);
        this.f = r4;
        new kd2.b(0, 0);
        if (r4 == null) goto L7;
        d0 r6 = r4.A();
        if (r6 == null) goto L7;
        r6.h();
    L7:
        if (r4 == null) goto L12;
        d0 r7 = r4.A();
        if (r7 == null) goto L13;
        r7.h();
        return;
    L13:
        return;
    }

    public final void o(Context r1, ConstraintLayout r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "parent");
    }
}
