package com.bytedance.android.live.ktv.common.tuningpanel.ability;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.e;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.tuningpanel.ability.a$a, reason: collision with other inner class name */
    public static final class C0218a {
        public static /* synthetic */ void a(a r1, boolean r2, String r3) {
            r1.H(r2, r3, ITuningCore$updateRealRtcCellular$1.INSTANCE);
        }

        public static /* synthetic */ void b(a r3, float r4, int r5) {
            boolean r1 = true;
            if ((r5 & 2) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r5 & 4) != 0) goto L10;
            r1 = false;
        L10:
            r3.m(r4, r0, r1);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    float A();

    void B(boolean r1);

    void C();

    int D();

    void E();

    MutableLiveData<Boolean> F();

    void G(float r1);

    void H(boolean r1, String r2, Function1<? super Boolean, Unit> r3);

    Boolean I();

    void K(boolean r1);

    void L();

    int M();

    int N();

    boolean O();

    void P();

    void Q(h r1, boolean r2);

    boolean R();

    void S(boolean r1);

    int U();

    float V();

    float X();

    void Y(boolean r1);

    boolean Z();

    boolean a();

    void a0(LifecycleOwner r1, Observer<Boolean> r2);

    void b();

    void b0();

    void c();

    void c0(double r1);

    void clearData();

    boolean d(TuningVolumeType r1);

    float e();

    void e0(float r1);

    float f();

    void f0();

    void g(float r1);

    void g0(double r1);

    boolean h();

    void i();

    boolean isInRealTimeChorus();

    void j(float r1);

    void k(boolean r1);

    void m(float r1, boolean r2, boolean r3);

    boolean n();

    void o();

    void onPageCreate();

    void onPageResume();

    void onPageStop();

    boolean p();

    void q(boolean r1, boolean r2);

    boolean r();

    void s();

    void setTuningEffect(String r1);

    void t(LifecycleOwner r1, Observer<Boolean> r2);

    int u();

    boolean v();

    int w();

    void x(LifecycleOwner r1, e r2);

    void y();
}
