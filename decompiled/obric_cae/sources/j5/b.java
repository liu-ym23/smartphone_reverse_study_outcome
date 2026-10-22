package j5;

import android.accounts.Account;
import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Account f8647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8648b;

    public b(c r8, Account r10) {
        this.f8648b = r8;
        this.f8647a = r10;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"MissingPermission"})
    public final void run() {
        c r8 = this.f8648b;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r8.f8652e.size() > 0) goto L6;
        return;
    L6:
        if (r8.f8649b == null) goto L29;
        Iterator<Map.Entry<String, String>> r10 = r8.f8652e.entrySet().iterator();     // Catch: Exception -> L18
    L10:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<String, String> r11 = r10.next();     // Catch: Exception -> L18
        if (r11 == null) goto L10;
        r8.f8649b.setUserData(this.f8647a, r11.getKey(), r11.getValue());     // Catch: Exception -> L18
        goto L10
    L15:
        r8.f8652e.clear();     // Catch: Exception -> L18
        return;
    }
}
