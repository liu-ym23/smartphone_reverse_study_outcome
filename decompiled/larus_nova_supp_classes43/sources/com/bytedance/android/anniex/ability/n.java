package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<V> implements Callable {
    public final /* synthetic */ AnnieXWebModel a;
    public final /* synthetic */ AnnieXWebKit b;
    public final /* synthetic */ WebBDXBridge c;

    public static final class a extends com.bytedance.sdk.xbridge.cn.protocol.d<JSONObject> {
        public a(com.bytedance.sdk.xbridge.cn.platform.web.b r1) {
            super(r1);
        }

        public final void b(Object r10) {
            Intrinsics.checkNotNullParameter((JSONObject) r10, "data");
        }
    }

    public n(AnnieXWebModel r1, AnnieXWebKit r10, WebBDXBridge r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        com.bytedance.sdk.xbridge.cn.platform.web.b r0 = new com.bytedance.sdk.xbridge.cn.platform.web.b("anniex.preInit", new JSONObject(), this.a.c.toString());
        AnnieXWebModel r1 = this.a;
        ((le7.a) r0).K = true;
        String r10 = "webcast";
        if (Intrinsics.areEqual(r1.a, "webcast") == true) goto L6;
        r10 = "";
    L6:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        ((le7.a) r0).d = r10;
        int r11 = t.a;
        String r12 = t.a(this.b, this.a.c.toString());
        if (r12 == null) goto L9;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.S = r12;
    L9:
        this.c.p(r0, new a(r0));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
