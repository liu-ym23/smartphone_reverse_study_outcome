package x4;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class w0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f13578a;

    public w0(v0 r8, Handler r10) {
        this.f13578a = r8;
        super(r10);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r8, Uri r10) {
        onChange(r8);
        v0 r11 = this.f13578a;
        monitor-enter(r11);
        String r12 = r10.getQueryParameter("key");     // Catch: Throwable -> L20
        String r13 = r10.getQueryParameter("value");     // Catch: Throwable -> L20
        String r14 = r10.getQueryParameter(WsConstants.KEY_APP_ID);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r12) == false) goto L7;
    L17:
        int r15 = r.f13543a;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L7:
        if (TextUtils.isEmpty(r13) == true) goto L17;
        v0.f13569c.put(r12, r13);     // Catch: Throwable -> L20
        int r16 = r.f13543a;     // Catch: Throwable -> L20
        List r17 = (List) v0.f13570d.get(r12);     // Catch: Throwable -> L20
        if (r17 == null) goto L18;
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L20
    L13:
        if (r18.hasNext() == false) goto L18;
        v0.c r19 = (v0.c) r18.next();     // Catch: Throwable -> L20
        if (r19 == null) goto L13;
        r19.a(r13, r14);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
