package k8;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.g;
import j9.b;
import k9.e;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o8.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b7.a {
    public c7.a a;

    /* JADX INFO: renamed from: k8.a$a, reason: collision with other inner class name */
    public static final class C0173a {
    }

    static {
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        a("begin");
    }

    public a() {
    }

    public final void a(String r12) {
        b r1 = ((e) Annie.getService$default(e.class, null, 2, null)).H0();
        c7.a r0 = this.a;
        if (r0 == null) goto L6;
        String r10 = r0.getUrl();
        if (r10 == null) goto L6;
    L7:
        JSONObject r11 = new JSONObject();
        r11.put("stage", r12);
        Unit r13 = Unit.INSTANCE;
        JSONObject r14 = new JSONObject();
        com.bytedance.android.annie.ng.a r15 = g.c.get("host");
        if (r15 == null) goto L13;
        f r16 = r15.b;
        if (r16 == null) goto L13;
        String r17 = r16.a;
        if (r17 == null) goto L13;
    L14:
        r14.put("virtual_aid", r17);
        c7.a r18 = this.a;
        if (r18 == null) goto L20;
        String r19 = r18.getMonitorID();
        if (r19 == null) goto L20;
        String r110 = r19;
    L21:
        r1.b(null, "annie_container_load_url", r10, r11, null, null, r14, 2, r110);
        return;
    L20:
        r110 = "";
    L13:
        r17 = "88888";
    L6:
        r10 = "";
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        this.a = r10;
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r1, boolean r10) {
        a("page_start");
    }
}
