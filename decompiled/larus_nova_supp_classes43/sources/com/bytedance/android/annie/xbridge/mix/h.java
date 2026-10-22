package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements z<Object> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ BaseA2BBridgeMethod.a b;
    public final /* synthetic */ l c;
    public final /* synthetic */ com.bytedance.ies.web.jsbridge2.f<Object, Object> d;

    public static final class a implements z.a {
        public final /* synthetic */ BaseA2BBridgeMethod.a a;
        public final /* synthetic */ l b;
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.f<Object, Object> c;

        public final void a(JSONObject r10) {
            this.a.a(r10);
            this.b.a(this.c);
        }

        public final void onFailed(Throwable r10) {
            this.a.onFailed(r10);
            this.b.a(this.c);
        }

        public final void onSucceed(Object r10) {
            this.a.onSucceed(r10);
            this.b.a(this.c);
        }

        public a(BaseA2BBridgeMethod.a r1, l r10, com.bytedance.ies.web.jsbridge2.f<Object, Object> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public final z.a getCallBack() {
        return new a(this.b, this.c, this.d);
    }

    public final CallContext a() {
        return this.a;
    }

    public h(CallContext r1, BaseA2BBridgeMethod.b r10, g r11, com.bytedance.ies.web.jsbridge2.f r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
