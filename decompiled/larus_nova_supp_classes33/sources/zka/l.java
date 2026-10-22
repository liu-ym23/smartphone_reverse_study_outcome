package zka;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Messenger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l extends ContentObserver {
    public final /* synthetic */ m a;
    public final /* synthetic */ Context b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r4, Uri r5) {
        m r6 = this.a;
        CopyOnWriteArraySet<Messenger> r7 = r6.b;
        Context r0 = this.b;
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Messenger r1 = (Messenger) r8.next();
        Context r2 = r0.getApplicationContext();
        Intrinsics.checkNotNull(r1);
        r6.a(r2, r1);
        goto L4
    }

    public l(m r1, Context r2, Handler r3) {
        this.a = r1;
        this.b = r2;
        super(r3);
    }
}
