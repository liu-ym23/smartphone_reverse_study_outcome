package com.obric.oui.toast;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.lynx.tasm.utils.j;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14883c;
    public boolean d;
    public Object e;
    public Object f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f14884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f14885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f14886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f14887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f14888l;

    public void a() {
        JSONObject r5 = new JSONObject();
        r5.put("api_version", (String) this.f14884h);
        r5.put("http_status", this.f14881a);
        r5.put("err_msg", (String) this.f);
        r5.put("req_type", ((ReqType) this.e).getType());
        r5.put("is_intercept", this.f14882b);
        r5.put("err_code", this.f14883c);
        r5.put("x_tlb_probe", null);
        String r10 = (String) this.g;
        if (r10 == null) goto L9;
        if (r10.length() == 0) goto L9;
        r5.put("x_tt_logid", (String) this.g);
    L9:
        if (((String) this.f14885i).length() <= 0) goto L12;
        r5.put("access_key", (String) this.f14885i);
    L12:
        if (((String) this.f14886j).length() <= 0) goto L15;
        r5.put("channels", (String) this.f14886j);
    L15:
        if (((String) this.f14887k).length() <= 0) goto L18;
        r5.put("group_name", (String) this.f14887k);
    L18:
        if (this.d == false) goto L20;
        r5.put("is_retry", 1);
    L20:
        n r11 = (n) this.f14888l;
        if (r11 == null) goto L28;
        r5.put("lazy_model", r11.f4762i);
        IESGurdUpdatePriority r12 = IESGurdUpdatePriority.f6591b;
        IESGurdUpdatePriority r13 = r11.f4763j;
        if (r13 == r12) goto L25;
        r5.put("download_priority", r13);
    L25:
        String r14 = r11.f;
        if (r14.length() <= 0) goto L28;
        r5.put("tag", r14);
    L28:
        j.g("geckosdk_query_pkgs", r5);
    }

    public void b() {
        int r5 = c.f14889m;
        Log.v("OToast", "handleHide " + ((View) this.f14884h) + " in " + this);
        View r10 = (View) this.f14884h;
        if (r10 == null) goto L15;
        Intrinsics.checkNotNull(r10);
        Log.v("OToast", Intrinsics.stringPlus("handleHide parent ", r10.getParent()));
        View r11 = (View) this.f14884h;
        Intrinsics.checkNotNull(r11);
        if (r11.getParent() == null) goto L11;
        Log.v("OToast", "REMOVE! " + ((View) this.f14884h) + " in " + this);
        WindowManager r12 = (WindowManager) this.f14888l;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L9
        r12.removeView((View) this.f14884h);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        this.f14884h = null;
        return;
    }

    public void c() {
        int r5 = c.f14889m;
        Log.v("OToast", Intrinsics.stringPlus("SHOW: ", this));
        bb.b r10 = (bb.b) this.g;
        r10.removeMessages(1);
        r10.removeMessages(2);
        r10.sendEmptyMessage(1);
        r10.sendEmptyMessageDelayed(2, this.f14883c);
    }
}
