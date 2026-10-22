package gc;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.a0;
import com.lynx.tasm.utils.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f17077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f17078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wc.e f17079c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public b(a0 r5, g r10, wc.e r11, String r12, long r13) {
        this.f17077a = r5;
        this.f17078b = r10;
        this.f17079c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ArrayList r5 = e.f17086a;
        a0 r10 = this.f17077a;
        g r11 = this.f17078b;
        e.a(r10, r11);
        if (r10.g == false) goto L31;
        wc.e r12 = this.f17079c;
        a r13 = r12.f22834m;
        ug.d r14 = new ug.d("bdx_resourceloader_fetch");
        int r15 = r11.f22839h.length();
        Uri r16 = r10.f5932a;
        String r17 = "";
        if (r15 <= 0) goto L7;
        String r18 = r11.f22839h;
    L11:
        if (r18.length() != 0) goto L13;
        r18 = k.i(r16);
    L13:
        r14.f22358c = r18;
        JSONObject r19 = new JSONObject();
        r19.put("res_url", r18);
        r19.put("res_state", "fail");
        r19.put("res_message", this.d);
        r19.put("preload_fail_message", r10.f5944q);
        r19.put("gecko_fail_message", r10.f5938k);
        r19.put("buildIn_fail_message", r10.f5941n);
        r19.put("cdn_failed_message", r10.f5942o);
        String r20 = r11.f22840i;
        if (Intrinsics.areEqual(r20, "template") == false) goto L17;
        r19.put("res_tag", "template");
    L20:
        r19.put("preload", "0");
        r19.put("preload_high_priority", "0");
        r14.f = r19;
        d.a(r19, r10);
        JSONObject r21 = new JSONObject();
        long r22 = r10.f5937j;
        r21.put("res_duration", this.e - r22);
        r14.d = r21;
        r14.e = Boolean.valueOf(e.b(r16.toString(), r12));
        Unit r110 = Unit.INSTANCE;
        r13.e(r11, r14);
        if (d.e(r11) == false) goto L31;
        com.bytedance.android.monitorV2.webview.k r111 = com.bytedance.android.monitorV2.webview.k.d;
        String r23 = r11.f22853w;
        if (r23 != null) goto L25;
        r23 = "";
    L25:
        String r24 = r11.f22854x;
        if (r24 == null) goto L29;
        r17 = r24;
    L29:
        LinkedHashMap r25 = new LinkedHashMap();
        r25.put("res_format_src", k.i(Uri.parse(r18)));
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.String");
        r25.put("res_full_src", r18);
        r25.put("request_method", "GET");
        r111.o("anniex_ssp_res_loader_info", r23, r17, r25);
        goto L31
    L17:
        if (Intrinsics.areEqual(r20, "web") == false) goto L19;
        r19.put("res_tag", "web");
        goto L20
    L19:
        r19.put("res_tag", "sub_resource");
        goto L20
    L7:
        char[] r26 = i.f5457a;
        r18 = i.c(r16);
        if (r18 != null) goto L11;
        r18 = "";
    L31:
        return Unit.INSTANCE;
    }
}
