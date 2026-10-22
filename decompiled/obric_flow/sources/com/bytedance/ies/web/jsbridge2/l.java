package com.bytedance.ies.web.jsbridge2;

import ai.j0;
import android.text.TextUtils;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6291c;
    public final String d;
    public String e;
    public String f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f6292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f6293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f6294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f6295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f6296l;

    public l(String r5, int r10) {
        this.f6289a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        CopyOnWriteArrayList r11 = new CopyOnWriteArrayList();
        this.f6296l = r11;
        this.f6290b = null;
        this.f6291c = null;
        this.d = null;
        this.e = null;
        this.f = r5;
        this.f6292h = null;
        this.g = -5;
        this.f6293i = null;
        this.f6294j = null;
        this.f6295k = Boolean.FALSE;
        t r12 = new t();
        r12.a("callbackId", r5);
        r12.a("code", -5);
        r12.b("label_create_java_call", r11);
        return;
    L6:
        this.d = r5;
    }

    public x4.c a() {
        x4.c r5 = new x4.c();
        new HashMap();
        r5.f22949c = this.d;
        String r10 = this.f6290b;
        String r11 = "";
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        r5.f22947a = r10;
        String r12 = this.f6291c;
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        r5.f22948b = r11;
        JSONObject r13 = (JSONObject) this.f6292h;
        if (r13 != null) goto L13;
        r13 = new JSONObject();
    L13:
        r5.d = r13;
        JSONObject r14 = (JSONObject) this.f6293i;
        if (r14 != null) goto L17;
        r14 = new JSONObject();
    L17:
        r5.e = r14;
        JSONObject r15 = (JSONObject) this.f6294j;
        if (r15 != null) goto L21;
        r15 = new JSONObject();
    L21:
        r5.f = r15;
        r5.f22953k = this.g;
        JSONObject r16 = (JSONObject) this.f6295k;
        if (r16 != null) goto L25;
        r16 = new JSONObject();
    L25:
        this.f6295k = r16;
        r5.g = r16;
        JSONObject r17 = (JSONObject) this.f6296l;
        if (r17 != null) goto L29;
        r17 = new JSONObject();
    L29:
        r5.f22950h = r17;
        r5.f22952j = this.f;
        r5.f22951i = this.e;
        r5.f22954l = (com.bytedance.android.monitorV2.webview.a) com.bytedance.android.monitorV2.h.e().g.f18623a;
        return r5;
    }

    public void b(int r5) {
        if (r5 < 0) goto L5;
        if (r5 > 8) goto L5;
    L6:
        this.g = r5;
        return;
    L5:
        r5 = 8;
        goto L6
    }

    public String toString() {
        switch(this.f6289a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("methodName: ");
        r5.append(this.d);
        r5.append(", params: ");
        r5.append(this.e);
        r5.append(", callbackId: ");
        r5.append(this.f);
        r5.append(", type: ");
        r5.append(this.f6291c);
        r5.append(", iFrameUrl: ");
        String r10 = (String) this.f6293i;
        String r11 = "null";
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r10 = "null";
    L9:
        r5.append(r10);
        r5.append(", safeV1AuthUrl: ");
        String r12 = (String) this.f6294j;
        if (TextUtils.isEmpty(r12) == true) goto L13;
        r11 = r12;
    L13:
        r5.append(r11);
        r5.append(", version: ");
        return j0.q(r5, this.f6290b, ", ");
    L5:
        return super.toString();
    }

    public l(k r10) {
        this.f6289a = 0;
        CopyOnWriteArrayList r5 = new CopyOnWriteArrayList();
        this.f6296l = r5;
        String r11 = (String) r10.f6284a;
        this.f6290b = r11;
        String r12 = (String) r10.f6285b;
        this.f6291c = r12;
        String r13 = (String) r10.f6286c;
        this.d = r13;
        String r14 = (String) r10.d;
        this.e = r14;
        String r15 = (String) r10.e;
        this.f = r15;
        String r16 = (String) r10.f;
        this.f6292h = r16;
        this.g = 1;
        String r17 = (String) r10.g;
        this.f6293i = r17;
        String r18 = (String) r10.f6287h;
        this.f6294j = r18;
        this.f6295k = (Boolean) r10.f6288i;
        t r19 = new t();
        r19.a("version", r11);
        r19.a("type", r12);
        r19.a("methodName", r13);
        r19.a(LynxResourceModule.PARAMS_KEY, r14);
        r19.a("namespace", r16);
        r19.a("callbackId", r15);
        r19.a("namespace", r16);
        r19.a("iFrameUrl", r17);
        r19.a("safeV1AuthUrl", r18);
        r19.b("label_create_java_call", r5);
    }
}
