package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends BaseDispatchAction {
    private static final String j = "i";
    private boolean k;

    static {
    }

    public i() {
        this.k = false;
    }

    public abstract BaseDispatchAction.DispatchResultEnum a(k r1, String r2, List<String> r3);

    public BaseDispatchAction.DispatchResultEnum a(k r6, String r7, List<String> r8, List<c> r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (a(r6) == true) goto L5;
    L15:
        r10.set(0, r7);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        BaseDispatchAction.DispatchResultEnum r12 = a(r6, r7, r10);
        c r0 = new c();
        if (r12 == BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) goto L13;
        r0.d = true;
        r0.f2515b = b();
        r0.c = a();
        r0.e = e();
        r0.f2514a = c();
        if (r12 != BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) goto L12;
        r0.g = (String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin");
        r0.f = g();
    L12:
        r6.a(this.i);
    L13:
        r11.add(r0);
        return r12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean a(JSONObject r9, String r10, long r11) {
        ArrayList r6 = new ArrayList();
        r6.add(0, false);
        boolean r12 = a(r9, r6, r10, r11);
        this.k = ((Boolean) ZeusTransformUtils.preCheckCast(r6.get(0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return r12;
    }

    public abstract boolean a(JSONObject r1, List<Boolean> r2, String r3, long r4);

    public abstract int e();

    public int f() {
        return -555;
    }

    public boolean g() {
        return this.k;
    }
}
