package com.bytedance.android.live.broadcastgame.channel;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ContinuousTimeTicker {
    public Function1<? super Long, Unit> a;
    public Disposable b;
    public long c;
    public boolean d;
    public long e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public ContinuousTimeTicker() {
        Intrinsics.checkNotNullParameter("heart-beat", "key");
        this.f = "heart-beat";
        this.c = System.currentTimeMillis();
        this.d = true;
        this.e = 1000;
    }

    public final void b() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L7;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f + "]@{" + hashCode() + "} stop, isStop: " + this.d);
        this.d = true;
        this.a = null;
        Disposable r0 = this.b;
        if (r0 == null) goto L9;
        r0.dispose();
        return;
    L9:
        return;
    L7:
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.f + "] only invoke by main thread");
        UtilityKotlinExtentionsKt.s(0, false, false, new ContinuousTimeTicker$stop$1(this), 7);
    }

    public final void a(long r16, final Function1<? super Long, Unit> r18) {
        final long r1 = r16;
        Intrinsics.checkNotNullParameter(r18, "action");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L25;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f + "]@{" + hashCode() + "} continuous with: " + r1 + " | " + this.e);
        if (r1 != 0) goto L8;
        r1 = 1000;
    L8:
        if (this.d == false) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
    L17:
        this.e = r1;
        this.a = r18;
        if (this.d == false) goto L20;
    L22:
        boolean r11 = false;
    L23:
        if (r11 == true) goto L27;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f + "]@{" + hashCode() + "} start");
        this.d = false;
        j.a r2 = j.a;
        this.b = j.a(0, this.e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcastgame.channel.a(this), new b(this));
        return;
    L27:
        return;
    L20:
        if ((System.currentTimeMillis() - this.c) >= (((long) 2) * this.e)) goto L22;
        r11 = true;
        goto L23
    L15:
        if (r1 == this.e) goto L17;
        b();
        goto L17
    L10:
        if ((System.currentTimeMillis() - this.c) >= (((long) 2) * this.e)) goto L12;
        r4 = true;
        goto L13
    L25:
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.f + "] only invoke by main thread");
        UtilityKotlinExtentionsKt.s(0, false, false, new ContinuousTimeTicker$changeMessage$1(this, r1, r18), 7);
    }
}
