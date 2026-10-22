package bw1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ d a;

    public c(cw1.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Long r7 = (Long) r6;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.longValue() < 0) goto L9;
        this.a.a();
        this.a.b(r7.longValue());
        return;
    }
}
