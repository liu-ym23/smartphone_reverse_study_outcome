package x7;

import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f13613a;

    public h(m r8) {
        this.f13613a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r8 = this.f13613a;     // Catch: Throwable -> L22
        if (r8.f13657t == null) goto L35;
        Iterator r10 = r8.f13658u.iterator();     // Catch: Throwable -> L22
    L5:
        if (r10.hasNext() == false) goto L36;
        String r11 = (String) r10.next();     // Catch: Throwable -> L22
        StringBuilder r12 = this.f13613a.k(r11);     // Catch: Throwable -> L22
        r12.append("&encrypt=close");     // Catch: Throwable -> L22
        String r13 = r12.toString();     // Catch: Throwable -> L22
        byte[] r14 = null;
        if (this.f13613a.n() == null) goto L11;
        byte[] r15 = this.f13613a.n().doGet(r13, null).f12521b;     // Catch: Throwable -> L19
    L16:
        if (r15 == null) goto L37;
        m.j(this.f13613a, new JSONObject(new String(r15)));     // Catch: Throwable -> L19
    L38:
        return;
    L37:
        return;
    L11:
        boolean r16 = this.f13613a.f13661x;     // Catch: Throwable -> L19
        if (TextUtils.isDigitsOnly(r13) == true) goto L15;
        r14 = e.b(r13, null, null, null, HttpMethodContrants.GET, false, r16).f12521b;     // Catch: Throwable -> L19
    L15:
        r15 = r14;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
        goto L5
    L36:
        return;
    L35:
        return;
    L22:
        th = move-exception;
        if (this.f13613a.f13663z == true) goto L26;
        this.f13613a.f13663z = true;
        m r17 = this.f13613a;
        r17.B.b(r17);
    L26:
        th.printStackTrace();
    }
}
