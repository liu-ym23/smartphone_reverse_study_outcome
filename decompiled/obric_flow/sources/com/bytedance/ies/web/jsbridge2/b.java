package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimeLineEvent f6267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f6268c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(u r5, Object r10, TimeLineEvent r11, int r12) {
        this.f6266a = r12;
        this.f6268c = r5;
        this.d = r10;
        this.f6267b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6266a) {
            case 0: goto L18;
            default: goto L5;
        };
    L5:
        if (this.f6268c.d == true) goto L41;
        ((CopyOnWriteArrayList) ((l) this.d).f6296l).add(this.f6267b);
        l r5 = (l) this.d;
        if (r5.g == 1) goto L10;
    L15:
        ((l) this.d).toString();
        t r10 = new t();
        r10.a("reason", "call_invalid_2");
        r10.b("label_abstract_bridge_reject", (CopyOnWriteArrayList) ((l) this.d).f6296l);
        u r11 = this.f6268c;
        String r12 = r11.b();
        l r13 = (l) this.d;
        r11.f(r12, r13.d, 3, "call_invalid_2", (CopyOnWriteArrayList) r13.f6296l);
        this.f6268c.e(r.a(new JsBridgeException(((l) this.d).g, "Failed to parse invocation.")), (l) this.d);
        return;
    L10:
        if (TextUtils.isEmpty(r5.d) == true) goto L15;
        if (TextUtils.isEmpty(r5.e) == true) goto L15;
        u.d(this.f6268c, (l) this.d);
        return;
    L41:
        return;
    L18:
        if (this.f6268c.d == true) goto L44;
        l r14 = u.a(this.f6268c, new JSONObject((String) this.d));     // Catch: JSONException -> L22
    L23:
        if (r14 == null) goto L25;
        ((CopyOnWriteArrayList) r14.f6296l).add(this.f6267b);
    L25:
        if (r14 != null) goto L27;
    L34:
        Objects.toString(r14);
        if (r14 == null) goto L43;
        t r15 = new t();
        r15.a("value", (String) this.d);
        r15.a("reason", "call_invalid_1");
        r15.b("label_abstract_bridge_reject", (CopyOnWriteArrayList) r14.f6296l);
        u r16 = this.f6268c;
        r16.f(r16.b(), r14.d, 3, "call_invalid_1", (CopyOnWriteArrayList) r14.f6296l);
        this.f6268c.e(r.a(new JsBridgeException(r14.g, "Failed to parse invocation.")), r14);
        return;
    L43:
        return;
    L27:
        if (r14.g != 1) goto L34;
        if (TextUtils.isEmpty(r14.d) == true) goto L34;
        if (TextUtils.isEmpty(r14.e) == true) goto L34;
        u.d(this.f6268c, r14);
        return;
    L22:
        r14 = null;
        goto L23
    }
}
