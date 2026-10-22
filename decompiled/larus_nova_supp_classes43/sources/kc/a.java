package kc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public List<C0174a> a;

    /* JADX INFO: renamed from: kc.a$a, reason: collision with other inner class name */
    public static class C0174a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public C0175a g;

        /* JADX INFO: renamed from: kc.a$a$a, reason: collision with other inner class name */
        public static final class C0175a {
            public BcmParams a;
            public BcmParams b;

            public C0175a() {
            }
        }

        public C0174a() {
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, this.b);     // Catch: Throwable -> L19
            r0.put("btm", this.c);     // Catch: Throwable -> L19
            r0.put("btm_show_id", this.e);     // Catch: Throwable -> L19
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L19
            C0175a r11 = this.g;     // Catch: Throwable -> L18
            JSONObject r12 = null;
            if (r11 == null) goto L9;
            BcmParams r13 = r11.a;     // Catch: Throwable -> L18
            if (r13 == null) goto L9;
            JSONObject r14 = r13.toJSONObject();     // Catch: Throwable -> L18
        L10:
            r10.put(AIStateLogRequest.SOURCE_PAGE, r14);     // Catch: Throwable -> L18
            C0175a r15 = this.g;     // Catch: Throwable -> L18
            if (r15 == null) goto L15;
            BcmParams r16 = r15.b;     // Catch: Throwable -> L18
            if (r16 == null) goto L15;
            r12 = r16.toJSONObject();     // Catch: Throwable -> L18
        L15:
            r10.put("unit", r12);     // Catch: Throwable -> L18
        L9:
            r14 = null;
        L16:
            r0.put("content", r10);     // Catch: Throwable -> L19
            r0.put("jump_with_token", this.f);     // Catch: Throwable -> L19
        L17:
            return r0;
        }
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L12
        Iterator<T> r11 = this.a.iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L9;
        r10.put(((C0174a) r11.next()).a());     // Catch: Throwable -> L11
    L9:
        r0.put("chain", r10);     // Catch: Throwable -> L12
        r0.put("bcm_chain_id", UUID.randomUUID().toString());     // Catch: Throwable -> L12
    L10:
        return r0;
    }

    public a() {
        this.a = new ArrayList();
    }
}
