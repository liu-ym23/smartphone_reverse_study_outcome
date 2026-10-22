package zka;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o extends ContentObserver {
    public final /* synthetic */ n a;

    public o(n r1, Handler r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r3, Uri r4) {
        this.a.a.set(-1);
    }
}
