package qr1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements Observer<Boolean> {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r0 = Boolean.TRUE;
        if (r0.equals((Boolean) r2) == false) goto L6;
        this.a.p.removeMessages(2);
        return;
    }
}
