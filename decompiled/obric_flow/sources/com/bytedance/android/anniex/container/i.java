package com.bytedance.android.anniex.container;

import android.content.Context;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.ies.xelement.banner.Banner;
import com.lynx.tasm.behavior.t;
import com.lynx.tasm.behavior.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import l9.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3150c;

    public /* synthetic */ i(int r5, int r10, Object r11) {
        this.f3148a = r10;
        this.f3150c = r11;
        this.f3149b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3148a) {
            case 0: goto L107;
            case 1: goto L105;
            case 2: goto L23;
            case 3: goto L20;
            case 4: goto L9;
            default: goto L4;
        };
    L4:
        Banner r5 = (Banner) this.f3150c;
        if (r5.f6381o == false) goto L7;
        int r10 = r5.A.getCurrentItem();
        r5.A.setCurrentItem((this.f3149b + r10) - r5.e(r10), r5.s);
        return;
    L7:
        r5.f6388w = Math.max(Math.min(r5.f6388w, r5.F.size()), 0);
        r5.A.setCurrentItem(r5.f6388w, r5.s);
        return;
    L9:
        w r11 = (w) this.f3150c;
        Iterator r12 = r11.f10805v.iterator();
    L11:
        if (r12.hasNext() == false) goto L140;
        t r13 = (t) r12.next();
        if (r13.f10364a != this.f3149b) goto L11;
        r11.f10805v.remove(r13);
        if (r11.f10808y == true) goto L17;
        return;
    L17:
        if (r11.f10805v.isEmpty() == false) goto L139;
        r11.d();
        return;
    L139:
        return;
    L140:
        return;
    L20:
        com.bytedance.gkfs.d.c((com.bytedance.gkfs.d) this.f3150c, "GkFSExecutor", "parallel core thread " + (this.f3149b + 1) + " warmup", 0, 12);
        return;
    L105:
        AnnieXLiteContainer.access$changeState((AnnieXLiteContainer) this.f3150c, this.f3149b);
        return;
    L107:
        AnnieXContainer.access$changeState((AnnieXContainer) this.f3150c, this.f3149b);
        return;
    L23:
        if (v8.a.d().f22550a != null) goto L25;
        boolean r14 = false;
    L26:
        if (r14 == false) goto L101;
        com.bytedance.crash.upload.g r15 = (com.bytedance.crash.upload.g) this.f3150c;
        if (com.bytedance.ies.bullet.base.utils.b.n(r15.f4124a) == false) goto L101;
        Iterator r16 = r15.e.values().iterator();
    L32:
        if (r16.hasNext() == false) goto L100;
        com.bytedance.crash.upload.f r17 = (com.bytedance.crash.upload.f) r16.next();
        r17.f4118n = true;
        if (r17.f4115k != null) goto L96;
        if (r17.f4113i == (-1)) goto L96;
        if (r17.f4117m == true) goto L96;
        if (r17.s == true) goto L96;
        ArrayList r18 = r17.f4110b;
        boolean r19 = r18.isEmpty();
        ArrayList r20 = r17.f4111c;
        if (r19 == false) goto L47;
        if (r20.isEmpty() == true) goto L96;
    L47:
        if (r17.f4119o == true) goto L96;
        r17.f4115k = new ArrayList();
        Iterator r21 = r18.iterator();
        String r22 = "null";
    L51:
        if (r21.hasNext() == false) goto L63;
        com.bytedance.crash.upload.e r23 = (com.bytedance.crash.upload.e) r21.next();
        if (r23.d == true) goto L51;
        if (r23.f == true) goto L51;
        ArrayList r24 = v8.a.d().c(r23.f4106b, r17.f4116l);
        if (r24 == null) goto L61;
        r17.f4115k.addAll(r24);
    L61:
        if (CrashType.LAUNCH.getName().equals(r22) == true) goto L51;
        r22 = r23.g.getName();
        goto L51
    L63:
        Iterator r25 = r20.iterator();
        String r26 = r22;
    L65:
        if (r25.hasNext() == false) goto L78;
        com.bytedance.crash.upload.e r27 = (com.bytedance.crash.upload.e) r25.next();
        if (r27.d == true) goto L65;
        if (r27.f == true) goto L65;
        ArrayList r28 = v8.a.d().c(r27.f4106b, r17.f4116l);
        if (r28 == null) goto L75;
        r17.f4115k.addAll(r28);
    L75:
        if (CrashType.LAUNCH.getName().equals(r26) == true) goto L65;
        r26 = r27.g.getName();
        goto L65
    L78:
        if (r17.f4119o == true) goto L96;
        if (r17.f4115k.isEmpty() == true) goto L96;
        if (r17.f4118n == false) goto L96;
        String r29 = v8.a.a(r17.f4116l, r17.f4115k);
        int r30 = r17.f4112h;
        if (r30 != 0) goto L87;
        String r31 = "uncertain";
    L91:
        JSONObject r32 = new JSONObject();
        JSONObject r33 = new JSONObject();
        mh.e.k(r32, new String[]{"check_result", r29, "crash_type", r26, "alog_inited", r31});
        if (n.f4057a == null) goto L96;
        io.reactivex.exceptions.a.i("upload alog_check " + r33 + " " + r32);
        l9.n.b("alog_check", r32, r33);
        goto L96
    L87:
        if (r30 != 1) goto L89;
        boolean r34 = true;
    L90:
        r31 = String.valueOf(r34);
        goto L91
    L89:
        r34 = false;
    L96:
        if (r17.f4117m == true) goto L32;
        if (r17.s == true) goto L32;
        Context r35 = r15.f4124a;
        String r36 = r17.f4109a;
        cl.a.C(com.bytedance.crash.util.g.c(r35, r36));
        cl.a.C(new File(com.bytedance.crash.util.g.b(n.f4057a), r36));
        goto L32
    L100:
        r15.e = null;
        return;
    L101:
        int r37 = this.f3149b - 1;
        this.f3149b = r37;
        if (r37 <= 0) goto L142;
        o.e().c(this, 1000);
        return;
    L142:
        return;
    L25:
        r14 = true;
        goto L26
    }

    public i(com.bytedance.crash.upload.g r5) {
        this.f3148a = 2;
        this.f3150c = r5;
        this.f3149b = 100;
    }
}
