package bk;

import ai.p;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import dk.d;
import dk.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements dk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f954b;

    public a() {
        this.f954b = new ArrayList();
    }

    @Override // dk.b
    public final boolean a(com.lynx.animax.player.b r5, d r10, e r11) {
        String r12 = r10.f16661c.getPath();
    L6:
        e = move-exception;
        r11.f16662c = 500;
        r11.d = "Internal server error";
        r11.e = p.d(e.toString() + "\n", "text/plain");
        return true;
    L4:
        if ("/json/version".equals(r12) == false) goto L9;
        c(r11);     // Catch: JSONException -> L6
    L19:
        return true;
    L9:
        if ("/json".equals(r12) == false) goto L12;
        b(r11);     // Catch: JSONException -> L6
        goto L19
    L12:
        if ("/json/list".equals(r12) == false) goto L14;
        b(r11);     // Catch: JSONException -> L6
        goto L19
    L14:
        r11.f16662c = LynxErrorCode.LYNX_ERROR_CODE_CANVAS;     // Catch: JSONException -> L6
        r11.d = "Not implemented";     // Catch: JSONException -> L6
        r11.e = p.d("No support for " + r12 + "\n", "text/plain");     // Catch: JSONException -> L6
        goto L19
    }

    public final void b(e r10) {
        JSONArray r5 = new JSONArray();
        ArrayList r11 = this.f954b;
        monitor-enter(r11);
        int r12 = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (r12 >= this.f954b.size()) goto L10;
        c r13 = (c) this.f954b.get(r12);     // Catch: Throwable -> L8
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L8
        r14.put("type", "page");     // Catch: Throwable -> L8
        r14.put(Constant.TITLE, r13.f957b);     // Catch: Throwable -> L8
        r14.put("id", "" + r12);     // Catch: Throwable -> L8
        r14.put(Constant.DESCRIPTION, "");     // Catch: Throwable -> L8
        r14.put("webSocketDebuggerUrl", "ws://" + r13.d);     // Catch: Throwable -> L8
        r14.put("devtoolsFrontendUrl", "/devtools/inspector.html?ws=" + r13.d);     // Catch: Throwable -> L8
        r5.put(r14);     // Catch: Throwable -> L8
        r12 = r12 + 1;     // Catch: Throwable -> L8
        goto L15
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L8
        p r15 = p.d(r5.toString(), "application/json");
        r10.f16662c = 200;
        r10.d = "OK";
        r10.e = r15;
    }

    public final void c(e r5) {
        if (this.f953a != null) goto L5;
        JSONObject r10 = new JSONObject();
        r10.put("Browser", "VMSDK-Debugger");
        r10.put("Protocol-Version", "1.3");
        r10.put("Android-Package", kk.a.e());
        r10.put("V8-Version", "7.2.1");
        this.f953a = p.d(r10.toString(), "application/json");
    L5:
        p r11 = this.f953a;
        r5.f16662c = 200;
        r5.d = "OK";
        r5.e = r11;
    }
}
