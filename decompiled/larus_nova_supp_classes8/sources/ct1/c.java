package ct1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        b r0 = this.a;
        r0.f = r4.booleanValue();
        if (r4.booleanValue() == false) goto L8;
        b.CountDownTimerC0377b r5 = this.a.c;
        if (r5 == null) goto L7;
        r5.cancel();
    L7:
        this.a.d = 2;
        return;
    L8:
        b r6 = this.a;
        r6.a(r6.b);
    }
}
