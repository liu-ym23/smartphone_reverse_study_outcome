package m8;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.monitor.lynx.AnnieLynxMonitorCallback;
import com.bytedance.android.annie.ng.j;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.web.jsbridge2.u;
import com.lynx.tasm.LynxView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements j {
    public final /* synthetic */ com.bytedance.android.annie.monitor.lynx.b a;
    public final /* synthetic */ String b;

    public static final class a implements l9.b {
        public final /* synthetic */ String a;

        @Override // l9.b
        public final List<com.bytedance.android.annie.card.base.b> a() {
            String r1 = this.a;
            if (r1 != null) goto L6;
            r1 = "host";
        L6:
            return CollectionsKt.listOf(new AnnieLynxMonitorCallback(r1));
        }

        public a(String r1) {
            this.a = r1;
        }

        @Override // l9.b
        public final List<u> b(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            if ((r10 instanceof LynxView) == false) goto L5;
            LynxView r11 = (LynxView) r10;
        L6:
            if (r11 == null) goto L10;
            List<u> r12 = CollectionsKt.listOf(new com.bytedance.android.annie.monitor.lynx.a(r11));
            if (r12 == null) goto L10;
            return r12;
        L10:
            return CollectionsKt.emptyList();
        L5:
            r11 = null;
            goto L6
        }

        @Override // l9.b
        public final void g(View r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, int r16) {
            if ((r10 instanceof LynxView) == false) goto L6;
            LynxViewMonitor.b.getClass();
            LynxViewMonitor.j((LynxView) r10, r11, r12, r13, r14, null, r15, r16);
            return;
        }
    }

    @Override // com.bytedance.android.annie.ng.j
    public final void onCallback() {
        com.bytedance.android.annie.monitor.lynx.b r0 = this.a;
        if (r0 == null) goto L5;
        c.a.put("host", r0);
    L5:
        Annie.registerService$default(l9.b.class, new a(this.b), null, 4, null);
    }

    public b(com.bytedance.android.annie.monitor.lynx.b r1, String r10) {
        this.a = r1;
        this.b = r10;
    }
}
