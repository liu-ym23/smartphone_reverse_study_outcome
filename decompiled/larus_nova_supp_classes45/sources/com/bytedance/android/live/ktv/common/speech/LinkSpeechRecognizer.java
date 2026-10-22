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
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
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
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LinkSpeechRecognizer implements v {
    public static final /* synthetic */ int A = 0;
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
    public t n;
    public final Lazy o;
    public final ArrayBlockingQueue<byte[]> p;
    public final AtomicInteger q;
    public final AtomicBoolean r;
    public final AtomicBoolean s;
    public boolean t;
    public final Map<String, String> u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public Disposable y;
    public AudienceLyricsRecognizer z;

    public static final class a {
    }

    public static final class b implements ri6.c {
        public b() {
        }
    }

    static {
    }

    public final void a() {
        ALogger.i("LinkSpeechRecognizer", "anchor hideLyrics");
        LyricComponentImplManager r0 = this.m;
        if (r0 == null) goto L7;
        jg4.f r1 = r0.g.d;
        if (r1 == null) goto L7;
        r1.reset();
    L7:
        t r2 = this.n;
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
        b(null, 0, 0);
    }

    public final void d() {
        Disposable r0 = this.y;
        if (r0 != null) goto L5;
    L9:
        this.y = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r1 = this.y;
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    }

    public final void destroyEngine() {
        ALogger.i("LinkSpeechRecognizer", "destroyEngine");
        ((LinkedHashMap) this.u).clear();
        a();
        AudienceLyricsRecognizer r0 = this.z;
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
        this.n = null;
        d();
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
        ALogger.i("LinkSpeechRecognizer", "stopRecognize");
        int r1 = mb0.h.a;
        boolean r3 = true;
        if (this.t == true) goto L6;
        r3 = false;
    L6:
        mb0.h.b(r3, "", "", 0);
        this.t = false;
        a();
        Disposable r2 = this.l;
        if (r2 != null) goto L9;
    L13:
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = 10;
        this.l = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r4));
        ALogger.i("LinkSpeechRecognizer", "onStop");
        d();
        ((LinkedHashMap) this.u).clear();
        return;
    L9:
        if (r2.isDisposed() == true) goto L13;
        Disposable r5 = this.l;
        if (r5 == null) goto L13;
        r5.dispose();
        goto L13
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
        ALogger.i("LinkSpeechRecognizer", "init fp engine error, ret = " + r6);
        goto L30
    L23:
        if (r6.intValue() != 0) goto L24;
        SpeechEngine r7 = this.f;
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.resetEngine(this.g));
    L29:
        ALogger.i("LinkSpeechRecognizer", "reset fp engine, ret = " + r8);
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
        ALogger.i("LinkSpeechRecognizer", "init cover engine error, ret = " + r15);
        return;
    L49:
        if (r15.intValue() != 0) goto L50;
        SpeechEngine r16 = this.h;
        if (r16 == null) goto L54;
        r3 = Integer.valueOf(r16.resetEngine(this.i));
    L54:
        ALogger.i("LinkSpeechRecognizer", "reset cover engine, ret = " + r3);
        return;
    L45:
        r15 = null;
        goto L46
    L58:
        return;
    }

    public LinkSpeechRecognizer() {
        this.j = new CompositeDisposable();
        this.o = LazyKt.lazy(LinkSpeechRecognizer$maxBufferSize$2.INSTANCE);
        this.p = new ArrayBlockingQueue(3072);
        this.q = new AtomicInteger(0);
        this.r = new AtomicBoolean(true);
        this.s = new AtomicBoolean(true);
        this.u = new LinkedHashMap();
        this.v = LazyKt.lazy(LinkSpeechRecognizer$enableGuestStream$2.INSTANCE);
        this.w = LazyKt.lazy(new LinkSpeechRecognizer$halfMaxBufferSize$2(this));
        this.x = LazyKt.lazy(LinkSpeechRecognizer$enableResultCheck$2.INSTANCE);
    }

    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        AudienceLyricsRecognizer r0 = this.z;
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
        return this.t;
    }

    public final void f(ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ALogger.i("LinkSpeechRecognizer", "detachLyricsView");
        r3.removeView(this.a);
    }

    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ALogger.i("LinkSpeechRecognizer", "setRecognizeResultListener");
        this.n = r4;
        AudienceLyricsRecognizer r1 = this.z;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r1.j = r4;
        return;
    }

    public final void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        AudienceLyricsRecognizer r0 = this.z;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void b(k r7, long r8, int r11) {
        JSONObject r2 = new JSONObject();
        r2.put("state", 0);
        com.bytedance.android.live.pushstream.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.c1("music_recognition_result", r2, 1, false, false);
        return;
    }

    public final void j(ei6.a r6, com.bytedance.android.live.pushstream.d r7, kd2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "recognitionParams");
        ALogger.i("LinkSpeechRecognizer", "startRecognize, maxBufferSize: " + ((Number) this.o.getValue()).intValue() + ", isRetry: " + r8.c + ", interactId: " + r8.e);
        int r0 = mb0.h.a;
        mb0.h.a(((Number) this.o.getValue()).intValue(), r8.c, r8.e, r8.d);
        this.t = true;
        this.r.set(true);
        this.s.set(true);
        this.q.set(0);
        this.p.clear();
        this.c = r7;
        this.d = r6;
        ((LinkedHashMap) this.u).clear();
        this.e = new b();
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L8;
        if (r8.d == false) goto L8;
        LiveWrappedAudioFrameCallbackMethod r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_RECORD;
    L11:
        if (r6 == null) goto L16;
        ri6.b r11 = r6.r();
        if (r11 == null) goto L16;
        r11.i(r9, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.e);
    L16:
        if (r8.c == true) goto L19;
        ALogger.i("LinkSpeechRecognizer", "onStart");
        d();
        this.y = Observable.interval(KtvSettingHelper.A().o(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.b(this, r8), c.a);
        return;
    L19:
        return;
    L8:
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L10;
        r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER;
        goto L11
    L10:
        r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED;
        goto L11
    }

    public final void o(Context r17, ConstraintLayout r18, boolean r19, int r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "parent");
        ALogger.i("LinkSpeechRecognizer", "attachLyricsView, lyricsContainerView=" + this.a);
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
        this.z = new AudienceLyricsRecognizer(this.m, this.n, this.a, r19, false);
        Disposable r23 = this.k;
        if (r23 != null) goto L37;
    L41:
        this.k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.a(this));
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
