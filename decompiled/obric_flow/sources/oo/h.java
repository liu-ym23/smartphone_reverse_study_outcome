package oo;

import android.text.TextUtils;
import com.lynx.tasm.behavior.LynxContext;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import ko.m;
import ko.n;
import ko.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxContext f20807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f20808c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;
    public final /* synthetic */ long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f20809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f20810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ JSONObject f20811j;

    public h(LynxContext r5, String r10, int r11, long r12, long r13, long r14, long r15, boolean r16, JSONObject r17) {
        this.f20806a = 0;
        this.f20807b = r5;
        this.f20808c = r10;
        this.f20810i = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f20809h = r15;
        this.d = r16;
        this.f20811j = r17;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f20806a) {
            case 0: goto L14;
            default: goto L4;
        };
    L4:
        JSONObject r14 = this.f20811j;
        JSONObject r15 = td.c.a(this.f20807b, this.f20808c, this.d, false, this.e, this.f, this.g, this.f20809h, this.f20810i, r14);
        if (r15 == null) goto L13;
        Iterator r5 = ((CopyOnWriteArrayList) mm.h.f20114a.f17073b).iterator();
        if (r5.hasNext() == true) goto L12;
        ko.d r10 = (ko.d) r.g().e(ko.d.class);
        if (r10 == null) goto L36;
        r10.reportImageStatus("lynx_image_status", r15);
        return;
    L36:
        return;
    L12:
        throw mn.h.c(r5);
    L13:
        return;
    L14:
        LynxContext r11 = this.f20807b;
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.k() == null) goto L39;
        ko.c r12 = (ko.c) r.g().e(ko.c.class);
        if (r12 == null) goto L40;
        m r13 = new m();
        r13.e = "";
        r13.f = "";
        r13.g = "";
        r13.f18704j = -1;
        r13.f18705k = -1;
        r13.f18706l = -1;
        r13.f18707m = -1;
        r13.f18708n = "";
        r13.f18711q = 0;
        r13.f18702h = "image";
        r13.f18709o = this.f20808c;
        r13.f18703i = this.f20810i;
        r13.f18700b = this.e;
        r13.f18699a = this.f;
        r13.f18701c = this.g;
        r13.d = this.f20809h;
        r13.f18710p = this.d ? 1 : 0;
        if (r11.k() == null) goto L31;
        String r16 = r11.B;
        if (r16 != null) goto L27;
        r16 = "";
    L27:
        r13.e = r16;
        r13.f = r11.k().getRenderPhase();
        String r17 = r11.f10149q;
        if (TextUtils.isEmpty(r17) == false) goto L30;
        r13.g = "";
        goto L31
    L30:
        r13.g = r17;
    L31:
        JSONObject r18 = this.f20811j;
        if (r18 == null) goto L34;
        long r19 = r18.optLong("viewWidth");
        long r20 = r18.optLong("viewHeight");
        long r21 = r18.optLong("width");
        long r22 = r18.optLong("height");
        String r23 = r18.optString("config");
        int r110 = r18.optInt("isFlattenAnim");
        r13.f18705k = r20;
        r13.f18704j = r19;
        r13.f18706l = r21;
        r13.f18707m = r22;
        r13.f18708n = r23;
        r13.f18711q = r110;
    L34:
        r12.reportMemoryUsage(new n(r13));
        return;
    L40:
        return;
    }

    public h(LynxContext r5, String r10, boolean r11, long r12, long r13, long r14, long r15, int r16, JSONObject r17) {
        this.f20806a = 1;
        this.f20807b = r5;
        this.f20808c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f20809h = r15;
        this.f20810i = r16;
        this.f20811j = r17;
    }
}
