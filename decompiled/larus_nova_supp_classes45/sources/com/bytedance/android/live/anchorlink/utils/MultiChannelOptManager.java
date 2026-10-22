package com.bytedance.android.live.anchorlink.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.anchorlink.network.model.MultiChannelData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.n8;
import com.bytedance.android.livesdk.o8;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import ey.g;
import gy.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MultiChannelOptManager {
    public final Integer a;
    public final int b;
    public final int c;
    public final CompositeDisposable d;
    public Disposable e;
    public final MutableLiveData<MultiChannelInfo> f;
    public final MutableLiveData g;
    public final a h;
    public final f i;

    public MultiChannelOptManager(f r2) {
        this.i = r2;
        this.a = (Integer) o8.a.getValue();
        this.b = 1;
        this.c = 2;
        this.d = new CompositeDisposable();
        MutableLiveData<MultiChannelInfo> r0 = new MutableLiveData();
        this.f = r0;
        this.g = r0;
        a r1 = new a(this);
        this.h = r1;
        if (r2 == null) goto L6;
        r2.m(r1);
        return;
    }

    public static void c(MultiChannelOptManager r3) {
        Integer r0 = r3.a;
        if (r0 != null) goto L6;
    L8:
        Disposable r1 = r3.e;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        Disposable r2 = Observable.timer(((Number) n8.a.getValue()).intValue(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r3, null));
        RxUtilKt.c(r2, r3.d);
        r3.e = r2;
        return;
    L6:
        if (r0.intValue() != 0) goto L8;
    }

    public static final void a(MultiChannelOptManager r6, String r7) {
        f r0 = r6.i;
        boolean r2 = false;
        if (r0 == null) goto L14;
        List<ui6.a> r1 = r0.L0();
        if (r1 == null) goto L14;
        Iterator<ui6.a> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        ui6.a r4 = r3.next();
        if (r7 == null) goto L8;
        if (StringsKt.contains$default(r7, r4.a, false, 2, null) != true) goto L8;
        r2 = true;
    L14:
        if (r2 == true) goto L33;
        Integer r8 = r6.a;
        if (r8 != null) goto L19;
    L20:
        Integer r9 = r6.a;
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.intValue() != 3) goto L34;
    L25:
        r6.b(r6.b, "firstFrameRender");
        return;
    L34:
        return;
    L19:
        if (r8.intValue() == 1) goto L25;
    }

    public final void b(int r9, String r11) {
        Integer r0 = this.a;
        if (r0 != null) goto L6;
    L8:
        ALogger.e("ttlive_anchor_link_MultiChannelOpt", "fetchMultiChannelInfo " + r9 + ' ' + r11);
        g.a.getClass();
        nc0.b r1 = g.a.a();
        if (r1 == null) goto L12;
        Function1<MultiChannelData, Unit> r2 = new MultiChannelOptManager$fetchMultiChannelInfo$1(this);
        MultiChannelOptManager$fetchMultiChannelInfo$2 r7 = MultiChannelOptManager$fetchMultiChannelInfo$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onError");
        r1.d.fetchMultiChannelInfo(r9, true, r11, "unknown", new nc0.a(r2), r7);
        return;
    L12:
        return;
    L6:
        if (r0.intValue() != 0) goto L8;
    }
}
