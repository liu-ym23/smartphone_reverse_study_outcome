package com.bytedance.android.live.pushstream;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.li;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveReuseStreamAdaptLandScapeConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public final d0 a;
    public final CopyOnWriteArrayList<Object> b;
    public final Lazy c;
    public final u d;
    public d0 e;
    public final d0.a f;

    public final double a() {
        d0 r0 = this.e;
        if (r0 == null) goto L7;
        r0.p();
        return -1.0d;
    L7:
        return -1.0d;
    }

    public final void b(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (((LiveReuseStreamAdaptLandScapeConfig) li.a.getValue()).isEnable() == false) goto L27;
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r4), "PushBase");     // Catch: Exception -> L19
        if (r5.isNull("width") == false) goto L16;
        return;
    L16:
        if (r5.isNull("height") == true) goto L26;
        this.d.g = JSONObjectProtectorUtils.getInt(r5, "width");     // Catch: Exception -> L19
        this.d.h = JSONObjectProtectorUtils.getInt(r5, "height");     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "error: " + e.toString());
        return;
    L27:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void c(String r1, h0.d r2) {
        b(r1);
        d0 r3 = this.a;
        if (r3 == null) goto L6;
        r3.A();
        return;
    }

    public y(u r2, Handler r3, LiveStream4.g r4, d0 r5, d0.a r6) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "glHandler");
        Intrinsics.checkNotNullParameter(r4, "videoCaptureObserver");
        this.d = r2;
        this.e = r5;
        this.f = r6;
        this.a = r5;
        this.b = new CopyOnWriteArrayList();
        Lazy r7 = LazyKt.lazy(VideoCaptureWrapper$composeDisposable$2.INSTANCE);
        this.c = r7;
        r2.getClass();
        d0 r8 = this.e;
        if (r8 == null) goto L5;
        r8.d0();
    L5:
        Disposable r9 = xs2.b.a().b(pv0.i.class).subscribe(new w(this), x.a);
        ((CompositeDisposable) r7.getValue()).add(r9);
    }
}
