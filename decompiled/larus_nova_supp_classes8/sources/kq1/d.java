package kq1;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.replay.paid.ReplayUpdatePaidData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public final MutableLiveData<Boolean> a;
    public final NextLiveData<Boolean> b;
    public final MutableLiveData<Boolean> c;
    public final MutableLiveData<Boolean> d;
    public final MutableLiveData<Boolean> e;
    public final MutableLiveData<ReplayUpdatePaidData> f;

    public d() {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        Unit r2 = Unit.INSTANCE;
        this.a = r0;
        NextLiveData<Boolean> r3 = new NextLiveData();
        r3.setValue(r1);
        this.b = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        r4.setValue(r1);
        this.c = r4;
        MutableLiveData<Boolean> r5 = new MutableLiveData();
        r5.setValue(r1);
        this.d = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData();
        r6.setValue(Boolean.TRUE);
        this.e = r6;
        MutableLiveData<ReplayUpdatePaidData> r7 = new MutableLiveData();
        r7.setValue(null);
        this.f = r7;
    }
}
