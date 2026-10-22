package hd0;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends ge1.a<Integer> {
    public static c i;
    public long d;
    public long e;
    public long f;
    public int g;
    public final MutableLiveData<Boolean> h;

    public final void l() {
        ((ge1.a) this).b = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.h.setValue(Boolean.FALSE);
    }

    public static c f() {
        if (i != null) goto L9;
        i = new c();
        if (MainThreadPostUtils.a() == false) goto L7;
        i.h.setValue(Boolean.FALSE);
        goto L9
    L7:
        i.h.postValue(Boolean.FALSE);
    L9:
        return i;
    }

    public final boolean g() {
        if (((Integer) ((ge1.a) this).b).intValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean h() {
        if (((Integer) ((ge1.a) this).b).intValue() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        Boolean r0 = (Boolean) this.h.getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.booleanValue();
    }

    public final boolean j() {
        if (((Integer) ((ge1.a) this).b).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public c() {
        this.h = new MutableLiveData();
        ((ge1.a) this).b = 0;
    }

    public static String m(StackTraceElement[] r5) {
        if (r5 != null) goto L4;
        return "";
    L4:
        if (r5.length == 0) goto L14;
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        StackTraceElement r3 = r5[r2];
        r0.append(" at ");
        r0.append(r3);
        r0.append("\n");
        r2 = r2 + 1;
        goto L7
    L10:
        return r0.toString();
    L14:
        return "";
    }

    public final void e(Observer<Integer> r3) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        x.a0("removeObserver", m(ThreadMethodProxy.currentThread().getStackTrace()));
        return;
    L6:
        super.e(r3);
    }

    public final void k(Integer r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.intValue() >= 0) goto L6;
        return;
    L6:
        if (r3.intValue() <= 2) goto L9;
        return;
    L9:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L12;
        x.a0("postValue", m(ThreadMethodProxy.currentThread().getStackTrace()));
        return;
    L12:
        d(r3);
    }
}
