package qr1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements Observer<Boolean> {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r0 = Boolean.TRUE;
        if (r0.equals((Boolean) r3) == false) goto L6;
        this.a.d("point_start_request_time", String.valueOf(System.currentTimeMillis()));
        return;
    }
}
