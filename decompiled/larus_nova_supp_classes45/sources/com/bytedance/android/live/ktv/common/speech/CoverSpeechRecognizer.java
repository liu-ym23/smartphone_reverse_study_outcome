package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CoverSpeechRecognizer extends SpeechRecognizer {
    public final Lazy t;
    public final Lazy u;
    public Disposable v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CoverSpeechRecognizer a;

        public b(CoverSpeechRecognizer r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            CoverSpeechRecognizer r11 = this.a;
            r11.getClass();
            StringBuilder r0 = new StringBuilder("doCheckTask，isSpeechRecognizing: ");
            r0.append(r11.q);
            r0.append(", similarity: ");
            k r1 = r11.n;
            if (r1 == null) goto L5;
            Integer r2 = Integer.valueOf(r1.f);
        L6:
            r0.append(r2);
            ALogger.i("CoverSpeechRecognizer", r0.toString());
            if (r11.q == true) goto L9;
            return;
        L9:
            if (r11.d != null) goto L11;
            return;
        L11:
            if (r11.c != null) goto L13;
            return;
        L13:
            if (KtvSettingHelper.A().k() == false) goto L23;
            k r3 = r11.n;
            if (r3 != null) goto L17;
        L18:
            r11.j(r11.d, r11.c, new kd2.a(true, false, null, 24));
            return;
        L17:
            if (r3.f < KtvSettingHelper.A().n()) goto L18;
            return;
        L23:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("CoverSpeechRecognizer", "onStart, interval exception: " + ((Throwable) r3).getMessage());
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.speech.SpeechRecognizer
    public final void d() {
        ALogger.i("CoverSpeechRecognizer", "onStart");
        k();
        this.v = Observable.interval(KtvSettingHelper.A().o(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
    }

    @Override // com.bytedance.android.live.ktv.common.speech.SpeechRecognizer
    public final void e() {
        ALogger.i("CoverSpeechRecognizer", "onStop");
        k();
        this.n = null;
    }

    public final void k() {
        Disposable r0 = this.v;
        if (r0 != null) goto L5;
    L9:
        this.v = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r1 = this.v;
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    }

    public CoverSpeechRecognizer() {
        this.t = LazyKt.lazy(new CoverSpeechRecognizer$halfMaxBufferSize$2(this));
        this.u = LazyKt.lazy(CoverSpeechRecognizer$enableResultCheck$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.ktv.common.speech.SpeechRecognizer
    public final int a() {
        return (KtvSettingHelper.A().e() * 102400) / 5000;
    }

    @Override // com.bytedance.android.live.ktv.common.speech.SpeechRecognizer
    public final void destroyEngine() {
        super.destroyEngine();
        k();
    }
}
