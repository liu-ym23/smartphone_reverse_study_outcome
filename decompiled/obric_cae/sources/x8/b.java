package x8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b extends s5.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d9.d.b f13675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f13676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c f13677q;

    public b(c r8, d9.d.b r10, boolean r11) {
        this.f13677q = r8;
        this.f13675o = r10;
        this.f13676p = r11;
        super(0);
    }

    @Override // s5.c, java.lang.Runnable
    public final void run() {
        c r8 = this.f13677q;
        r8.getClass();
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "doRefresh, actual request");
    L5:
        Context r10 = r8.f13682o;
        if (r5.e.e(r10) == false) goto L59;
        r8.r();
        boolean r11 = r8.c();
        AtomicBoolean r12 = r8.f13680m;
        if (r11 == true) goto L42;
        boolean r13 = this.f13676p;
        WeakHandler r14 = r8.I;
        if (r13 == false) goto L44;
        c.j();
        if (c.j().length < 1) goto L39;
        String r15 = c.j()[0];
        if (TextUtils.isEmpty(r15) == true) goto L39;
        String r16 = defpackage.b.d("https://", r15, "/get_domains/v5/");
        w6.e.a r17 = w6.e.f13022c;
        if (r17 == null) goto L22;
        String r18 = r17.addCommonParams(r16, true);
    L24:
        if (r16.equals(r18) == true) goto L39;
        LinkedHashMap r19 = new LinkedHashMap();
        l7.g.d(r18, r19);     // Catch: Exception -> L52
        if (r19.containsKey("device_id") == false) goto L39;
        List r20 = (List) r19.get("device_id");     // Catch: Exception -> L52
        if (r20 == null) goto L39;
        Iterator r21 = r20.iterator();     // Catch: Exception -> L52
    L35:
        if (r21.hasNext() == false) goto L39;
        if (((String) r21.next()).equals("0") == true) goto L35;
        boolean r22 = false;
    L40:
        if (r22 == false) goto L44;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
        r14.sendEmptyMessageDelayed(104, 5000);
        goto L42
    L22:
        r18 = r16;
    L39:
        r22 = true;
    L44:
        if (d9.d.b(r10, true, this.f13675o) == true) goto L48;
        Logger.d("AppConfig", "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (d9.d.b(r10, false, d9.d.b.f7000s) == true) goto L48;
        int r110 = 102;
    L50:
        r14.sendEmptyMessage(r110);
        r14.removeMessages(103);
        r14.sendEmptyMessageDelayed(103, r8.G.get() * 1000);
        return;
    L48:
        r110 = 101;
    L42:
        r12.set(false);
        return;
    }
}
