package com.bytedance.android.annie.xbridge.mix;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "Lcom/bytedance/ies/bullet/core/kit/bridge/j;", "Landroidx/lifecycle/LifecycleObserver;", "a", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseA2BBridgeMethod extends com.bytedance.ies.bullet.core.kit.bridge.j implements LifecycleObserver {

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0087a implements a {
            public AbstractC0087a() {
            }
        }

        void a(JSONObject r1);

        void onFailed(Throwable r1);

        void onSucceed(Object r1);
    }

    public static final class b extends a.AbstractC0087a {
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.bridge.b.a a;

        public b(com.bytedance.ies.bullet.service.base.bridge.b.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void a(JSONObject r10) {
            com.bytedance.ies.bullet.service.base.bridge.b.a r0 = this.a;
            if (r10 != null) goto L5;
            r10 = null;
        L8:
            r0.a(r10);
            return;
        L5:
            if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L8;
            r10.put("ignoreJSB2Error", 1);
            goto L8
        }

        public final void b(Object r10) {
            if (r10 != null) goto L4;
        L8:
            JSONObject r0 = null;
        L9:
            if (r0 == null) goto L11;
            this.a.a(r0);
            return;
        L11:
            this.a.a(c.c(r10));
            return;
        L4:
            if ((r10 instanceof JSONObject) == false) goto L8;
            ((JSONObject) r10).put("code", 1);     // Catch: JSONException -> L13
            r0 = (JSONObject) r10;     // Catch: JSONException -> L13
            goto L9
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void onFailed(Throwable r10) {
            com.bytedance.ies.bullet.service.base.bridge.b.a r0 = this.a;
            JSONObject r11 = new JSONObject();
            r11.put("code", 0);     // Catch: JSONException -> L9
            if (r10 == null) goto L12;
            if (TextUtils.isEmpty(r10.getMessage()) == true) goto L12;
            r11.put(MessageIndication.MESSAGE_TYPE_MSG, r10.getMessage());     // Catch: JSONException -> L9
        L12:
            if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L14;
            r11.put("ignoreJSB2Error", 1);
        L14:
            r0.a(r11);
            return;
        L9:
            e = move-exception;
            r11.put(MessageIndication.MESSAGE_TYPE_MSG, "ignored error:" + e.getMessage());
            goto L12
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void onSucceed(Object r10) {
            if (r10 != null) goto L4;
        L8:
            JSONObject r0 = null;
        L9:
            if (r0 == null) goto L11;
            this.a.a(r0);
            return;
        L11:
            this.a.a(c.c(r10));
            return;
        L4:
            if ((r10 instanceof JSONObject) == false) goto L8;
            ((JSONObject) r10).put("code", 1);     // Catch: JSONException -> L13
            r0 = (JSONObject) r10;     // Catch: JSONException -> L13
            goto L9
        }
    }

    public void a(JSONObject r10, b r11) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
    }

    public boolean i90() {
        return false;
    }

    public BaseA2BBridgeMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        super(r10);
    }

    public final void C50(JSONObject r10, com.bytedance.ies.bullet.service.base.bridge.b.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        a(r10, new b(r11));
    }
}
