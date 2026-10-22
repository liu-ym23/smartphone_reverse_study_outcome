package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveSetEffectAudioProcessResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.fb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p1 extends w20.k3<fb, LiveSetEffectAudioProcessResultModel> {
    public CompositeDisposable a;
    public boolean b;

    public p1() {
    }

    public final void invoke(Object r7, CallContext r8) {
        fb r9 = (fb) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (this.b == true) goto L17;
        this.b = true;
        rj0.l.n2.getClass();
        rj0.l r10 = rj0.l.a.a();
        if (r10 == null) goto L9;
        com.bytedance.android.live.pushstream.d r11 = r10.getLiveStream();
        if (r11 == null) goto L9;
    L15:
        if (r11 == null) goto L17;
        r11.u();
    L9:
        IInteractService r13 = jc1.k.f(IInteractService.class);
        if (r13 == null) goto L14;
        qd0.a r14 = r13.getAudioTalkService();
        if (r14 == null) goto L14;
        r11 = r14.getLiveStream();
    L14:
        r11 = null;
    L17:
        CompositeDisposable r15 = this.a;
        if (r15 == null) goto L20;
        r15.clear();
    L20:
        this.a = new CompositeDisposable();
        Integer r16 = r9.b();
        if (r16 == null) goto L23;
        int r17 = r16.intValue();
    L24:
        if (r17 != 1) goto L26;
        boolean r18 = true;
    L27:
        String r2 = r9.c();
        if (r2 != null) goto L30;
        r2 = BuildConfig.FLAVOR;
    L30:
        Integer r19 = r9.a();
        if (r19 == null) goto L33;
        int r20 = r19.intValue();
    L34:
        if (r20 != 1) goto L36;
        boolean r21 = true;
    L37:
        if (r18 == true) goto L39;
    L44:
        CompositeDisposable r3 = this.a;
        Intrinsics.checkNotNullParameter(r2, "stickerId");
        if (r18 == false) goto L47;
        RxUtilKt.c(Single.create(new o1(this, r2, true, r21)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new m1(this)), r3);
        return;
    L47:
        RxUtilKt.c(Single.create(new o1(this, String.valueOf(((Long) m90.b.y.c(LiveEffectContextFactoryDelegate.Type.DEFAULT)).longValue()), false, r21)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new n1(this)), r3);
        return;
    L39:
        if (r2.length() != 0) goto L41;
        boolean r4 = true;
    L42:
        if (r4 == false) goto L44;
        j(4, "stickerId is empty");
        return;
    L41:
        r4 = false;
        goto L42
    L36:
        r21 = false;
        goto L37
    L33:
        r20 = 0;
        goto L34
    L26:
        r18 = false;
        goto L27
    L23:
        r17 = 0;
        goto L24
    }

    public final void j(int r3, String r4) {
        LiveSetEffectAudioProcessResultModel r0 = new LiveSetEffectAudioProcessResultModel();
        r0.a(LiveSetEffectAudioProcessResultModel.Code.Failed);
        r0.c(r4);
        LiveSetEffectAudioProcessResultModel.a r5 = new LiveSetEffectAudioProcessResultModel.a();
        r5.a(Integer.valueOf(r3));
        Unit r6 = Unit.INSTANCE;
        r0.b(r5);
        finishWithResult(r0);
    }
}
