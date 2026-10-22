package com.bytedance.pia.nsr;

import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.web.pia.r;
import com.bytedance.ies.bullet.web.pia.s;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Unit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fh.c f7183c;

    public /* synthetic */ c(Object r5, fh.c r10, int r11) {
        this.f7181a = r11;
        this.f7182b = r5;
        this.f7183c = r10;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        JSONObject r5 = null;
        fh.c r11 = this.f7183c;
        Object r12 = this.f7182b;
        switch(this.f7181a) {
            case 0: goto L33;
            case 1: goto L29;
            default: goto L4;
        };
    L4:
        mh.b r13 = (mh.b) r10;
        Object r14 = ((Object[]) r12)[0];
        if ((r14 instanceof s) == false) goto L7;
        s r15 = (s) r14;
    L9:
        if (r15 != null) goto L13;
        Callback r16 = r13.f20093c;
        if (r16 == null) goto L39;
        JavaOnlyMap r17 = new JavaOnlyMap();
        r17.put("code", -2);
        Unit r18 = Unit.INSTANCE;
        r16.invoke(new Object[]{r17});
        return;
    L39:
        return;
    L13:
        BridgeDowngradePlugin r19 = (BridgeDowngradePlugin) r11;
        r19.f20236b.g.toString();
        String r20 = r13.f20091a;
        ReadableMap r21 = r13.f20092b;
        if ((r21 instanceof JavaOnlyMap) == false) goto L16;
        JavaOnlyMap r22 = (JavaOnlyMap) r21;
    L17:
        if (r22 == null) goto L19;
        r5 = r22.a();
    L19:
        c r23 = new c(r13, r19, 1);
        if (r20 == null) goto L27;
        if (r5 == null) goto L27;
        r15.f6250b.put("__pia_jsb2_glue__" + r5.optString("__callback_id"), r23);     // Catch: JSONException -> L35
        com.bytedance.ies.bullet.core.e r24 = r15.f6249a;     // Catch: JSONException -> L35
        if (r24 == null) goto L36;
        IBridge3Registry r25 = r24.f5302p;     // Catch: JSONException -> L35
        if (r25 == null) goto L36;
        r25.handle(r20, r5, new r());     // Catch: JSONException -> L35
    L36:
        return;
    L27:
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L35
        r26.put("code", -3);     // Catch: JSONException -> L35
        r23.accept(r26);     // Catch: JSONException -> L35
    L41:
        return;
    L16:
        r22 = null;
        goto L17
    L7:
        r15 = null;
        goto L9
    L29:
        JSONObject r27 = (JSONObject) r10;
        Callback r28 = ((mh.b) r12).f20093c;
        if (r28 == null) goto L42;
        ((BridgeDowngradePlugin) r11).getClass();
        r28.invoke(new Object[]{BridgeDowngradePlugin.i(r27)});
        return;
    L42:
        return;
    L33:
        ((f) r12).a((String) r10);
        ((rh.i) r11).b(null);
    }
}
