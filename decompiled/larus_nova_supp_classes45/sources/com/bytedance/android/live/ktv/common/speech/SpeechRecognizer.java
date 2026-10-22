package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.model.q2;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import fd2.t;
import fd2.v;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SpeechRecognizer implements v {
    public SpeechLyricsView a;
    public boolean b;
    public com.bytedance.android.live.pushstream.d c;
    public ei6.a d;
    public b e;
    public SpeechEngine f;
    public long g;
    public SpeechEngine h;
    public long i;
    public final CompositeDisposable j;
    public Disposable k;
    public Disposable l;
    public LyricComponentImplManager m;
    public k n;
    public t o;
    public final Lazy p;
    public boolean q;
    public final Map<String, String> r;
    public AudienceLyricsRecognizer s;

    public static final class a {
    }

    public static final class b implements ri6.c {
        public b() {
        }
    }

    static {
    }

    public int a() {
        return ((Number) this.p.getValue()).intValue();
    }

    public void d() {
    }

    public void e() {
    }

    public final void b() {
        ALogger.i("SpeechRecognitionAnchor", "anchor hideLyrics");
        LyricComponentImplManager r0 = this.m;
        if (r0 == null) goto L7;
        jg4.f r1 = r0.g.d;
        if (r1 == null) goto L7;
        r1.reset();
    L7:
        t r2 = this.o;
        if (r2 == null) goto L10;
        r2.a();
    L10:
        SpeechLyricsView r3 = this.a;
        if (r3 == null) goto L15;
        TextView r4 = r3.getAiTipsTextView();
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        SpeechLyricsView r5 = this.a;
        if (r5 == null) goto L20;
        ImageView r6 = r5.getAiTagView();
        if (r6 == null) goto L20;
        r6.setVisibility(8);
    L20:
        g(null, 0, 0);
    }

    public void destroyEngine() {
        ALogger.i("SpeechRecognitionAnchor", "destroyEngine");
        ((LinkedHashMap) this.r).clear();
        b();
        AudienceLyricsRecognizer r0 = this.s;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.b = false;
        this.a = null;
        SpeechEngine r1 = this.f;
        if (r1 == null) goto L8;
        r1.destroyEngine();
    L8:
        this.g = -1;
        this.f = null;
        SpeechEngine r3 = this.h;
        if (r3 == null) goto L11;
        r3.destroyEngine();
    L11:
        this.i = -1;
        this.h = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.j.clear();
        Disposable r2 = this.k;
        if (r2 != null) goto L14;
    L18:
        Disposable r4 = this.l;
        if (r4 != null) goto L21;
    L25:
        this.o = null;
        return;
    L21:
        if (r4.isDisposed() == true) goto L25;
        Disposable r5 = this.l;
        if (r5 == null) goto L25;
        r5.dispose();
        goto L25
    L14:
        if (r2.isDisposed() == true) goto L18;
        Disposable r6 = this.k;
        if (r6 == null) goto L18;
        r6.dispose();
        goto L18
    }

    public final void i() {
        ALogger.i("SpeechRecognitionAnchor", "stopRecognize");
        this.q = false;
        b();
        Disposable r0 = this.l;
        if (r0 != null) goto L5;
    L9:
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = 10;
        this.l = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r1));
        e();
        ((LinkedHashMap) this.r).clear();
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r2 = this.l;
        if (r2 == null) goto L9;
        r2.dispose();
        goto L9
    }

    public final void initEngine() {
        if (this.b == true) goto L56;
        this.b = true;
        SpeechEngine r0 = SpeechEngineGenerator.getInstance();
        Integer r3 = null;
        if (r0 == null) goto L30;
        this.f = r0;
        this.g = r0.createEngine();
        SpeechEngine r1 = this.f;
        if (r1 == null) goto L10;
        r1.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r2 = this.f;
        if (r2 == null) goto L13;
        r2.setOptionString("debug_path", "");
    L13:
        SpeechEngine r4 = this.f;
        if (r4 == null) goto L16;
        r4.setOptionString("engine_name", "afp");
    L16:
        SpeechEngine r5 = this.f;
        if (r5 == null) goto L19;
        Integer r6 = Integer.valueOf(r5.initEngine());
    L20:
        if (r6 != null) goto L23;
    L24:
        ALogger.i("SpeechRecognitionAnchor", "init fp engine error, ret = " + r6);
        goto L30
    L23:
        if (r6.intValue() != 0) goto L24;
        SpeechEngine r7 = this.f;
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.resetEngine(this.g));
    L29:
        ALogger.i("SpeechRecognitionAnchor", "reset fp engine, ret = " + r8);
        goto L30
    L28:
        r8 = null;
        goto L29
    L19:
        r6 = null;
    L30:
        SpeechEngine r9 = SpeechEngineGenerator.getInstance();
        if (r9 == null) goto L58;
        this.h = r9;
        this.i = r9.createEngine();
        SpeechEngine r11 = this.h;
        if (r11 == null) goto L36;
        r11.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r12 = this.h;
        if (r12 == null) goto L39;
        r12.setOptionString("debug_path", "");
    L39:
        SpeechEngine r13 = this.h;
        if (r13 == null) goto L42;
        r13.setOptionString("engine_name", "coversong");
    L42:
        SpeechEngine r14 = this.h;
        if (r14 == null) goto L45;
        Integer r15 = Integer.valueOf(r14.initEngine());
    L46:
        if (r15 != null) goto L49;
    L50:
        ALogger.i("SpeechRecognitionAnchor", "init cover engine error, ret = " + r15);
        return;
    L49:
        if (r15.intValue() != 0) goto L50;
        SpeechEngine r16 = this.h;
        if (r16 == null) goto L54;
        r3 = Integer.valueOf(r16.resetEngine(this.i));
    L54:
        ALogger.i("SpeechRecognitionAnchor", "reset cover engine, ret = " + r3);
        return;
    L45:
        r15 = null;
        goto L46
    L58:
        return;
    }

    public SpeechRecognizer() {
        this.j = new CompositeDisposable();
        this.p = LazyKt.lazy(SpeechRecognizer$maxBufferSize$2.INSTANCE);
        this.r = new LinkedHashMap();
    }

    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        AudienceLyricsRecognizer r0 = this.s;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.f != true) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public final boolean h() {
        return this.q;
    }

    public final void f(ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ALogger.i("SpeechRecognitionAnchor", "detachLyricsView");
        r3.removeView(this.a);
    }

    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ALogger.i("SpeechRecognitionAnchor", "setRecognizeResultListener");
        this.o = r4;
        AudienceLyricsRecognizer r1 = this.s;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r1.j = r4;
        return;
    }

    public final void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        AudienceLyricsRecognizer r0 = this.s;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void g(k r7, long r8, int r11) {
        JSONObject r2 = new JSONObject();
        r2.put("state", 0);
        com.bytedance.android.live.pushstream.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.c1("music_recognition_result", r2, 1, false, false);
        return;
    }

    public final void j(ei6.a r4, com.bytedance.android.live.pushstream.d r5, kd2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "recognitionParams");
        ALogger.i("SpeechRecognitionAnchor", "startRecognize, maxBufferSize: " + a() + ", isRetry: " + r6.c);
        this.q = true;
        if (r6.c == true) goto L5;
        this.n = null;
    L5:
        this.c = r5;
        this.d = r4;
        ((LinkedHashMap) this.r).clear();
        this.e = new b();
        if (r4 == null) goto L11;
        ri6.b r7 = r4.r();
        if (r7 == null) goto L11;
        r7.i(LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.e);
    L11:
        if (r6.c == true) goto L14;
        d();
        return;
    }

    public final void o(Context r17, ConstraintLayout r18, boolean r19, int r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "parent");
        ALogger.i("SpeechRecognitionAnchor", "attachLyricsView, lyricsContainerView=" + this.a);
        ConstraintLayout r4 = this.a;
        ConstraintLayout.LayoutParams r5 = null;
        if (r4 == null) goto L13;
        ConstraintLayout.LayoutParams r1 = r4.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        r5 = r1;
    L8:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L11;
        r6.removeView(this.a);
    L11:
        r18.addView(this.a);
        return;
    L13:
        this.a = new SpeechLyricsView(r17, null, 6, 0);
        ViewGroup.LayoutParams r7 = new ConstraintLayout.LayoutParams(-1, -1);
        r18.addView(this.a);
        ((ConstraintLayout.LayoutParams) r7).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r7).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r7).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r7).bottomToBottom = 0;
        ConstraintLayout r2 = this.a;
        if (r2 == null) goto L16;
        r2.setLayoutParams(r7);
    L16:
        SpeechLyricsView r3 = this.a;
        if (r3 == null) goto L19;
        ViewPainter r8 = r3.getLyricsView();
    L20:
        if (r8 == null) goto L33;
        boolean r9 = Intrinsics.areEqual(((q2) b6.F.getValue()).e(), Boolean.TRUE);
        r8.setVisibility(0);
        ConstraintLayout.LayoutParams r11 = r8.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        r5 = r11;
    L25:
        ConstraintLayout.LayoutParams r12 = r5;
        if (r9 == true) goto L28;
        if (r19 == true) goto L28;
    L31:
        LyricsDisplayConfig r13 = new LyricsDisplayConfig();
        int r14 = UtilityKotlinExtentionsKt.i(14);
        r13.a();
        r13.j = Float.valueOf(0.0f);
        float r15 = r14;
        r13.l.setTextSize(r15);
        r13.k.setTextSize(r15);
        r13.g = 1;
        r13.e(Paint.Align.LEFT, 1);
        Paint.FontMetrics r16 = r13.l.getFontMetrics();
        float r22 = (UtilityKotlinExtentionsKt.i(18) + r14) / 2.0f;
        r13.q = new LinearGradient(0.0f, r22 + r16.ascent, 0.0f, r22 + r16.descent, ColorProtector.parseColor("#FFFFE267"), ColorProtector.parseColor("#FFFF994F"), Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r8, "painter");
        Intrinsics.checkNotNullParameter(r17, "context");
        this.m = new LyricComponentImplManager(r17, r13, new com.bytedance.component.lyric.a(r17, r8));
    L28:
        if (r12 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = UtilityKotlinExtentionsKt.i(4);
    L30:
        r8.setLayoutParams(r12);
    L33:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L43;
        this.s = new AudienceLyricsRecognizer(this.m, this.o, this.a, r19, false);
        Disposable r23 = this.k;
        if (r23 != null) goto L37;
    L41:
        this.k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this));
        return;
    L37:
        if (r23.isDisposed() == true) goto L41;
        Disposable r24 = this.k;
        if (r24 == null) goto L41;
        r24.dispose();
        goto L41
    L43:
        return;
    L19:
        r8 = null;
        goto L20
    }
}
