package h8;

import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements u {
    public final b a;

    /* JADX INFO: renamed from: h8.a$a, reason: collision with other inner class name */
    public static final class C0164a {
    }

    static {
    }

    public final /* synthetic */ void b(c0 r1, int r10) {
    }

    public a(b r10) {
        Intrinsics.checkNotNullParameter(r10, "mLogProvider");
        this.a = r10;
    }

    public final void a(String r10, String r11, o0 r12) {
        d(r10, r11, r12, false);
    }

    public final void d(String r12, String r13, o0 r14, boolean r15) {
        if (r13 != null) goto L4;
        return;
    L4:
        if (g.g == true) goto L7;
        return;
    L7:
        if (AnnieConfigSettingKeys.ALLOW_REPORT_JSB_LIST.a().contains(r13) == true) goto L9;
        return;
    L9:
        List r0 = r14.c;
        if (r0 != null) goto L12;
        return;
    L12:
        TimeLineEvent r1 = (TimeLineEvent) ListProtector.get(r0, 0);
        if (r1 == null) goto L20;
        HashMap r10 = r1.getExtra();
        if (r10 == null) goto L20;
        Object r11 = r10.get("params");
        if (r11 == null) goto L20;
        String r16 = r11.toString();
        if (r16 == null) goto L20;
    L22:
        if (r15 == false) goto L41;
        List r17 = r14.c;
        if (r17 == null) goto L28;
        TimeLineEvent r18 = (TimeLineEvent) CollectionsKt.last(r17);
        if (r18 == null) goto L28;
        String r19 = r18.getLabel();
    L29:
        if (r19 != null) goto L32;
        r19 = "";
    L32:
        if (Intrinsics.areEqual(r19, "unknown_namespace") == false) goto L35;
        int r110 = -4;
    L42:
        Pair[] r111 = new Pair[4];
        if (r12 != null) goto L45;
        String r20 = "";
    L46:
        r111[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, ListProtector.get(StringsKt.split$default(r20, new String[]{"?"}, false, 0, 6, null), 0));
        r111[1] = TuplesKt.to("method", r13);
        r111[2] = TuplesKt.to("code", String.valueOf(r110));
        r111[3] = TuplesKt.to("params", r16);
        Map r112 = MapsKt.mutableMapOf(r111);
        this.a.f(r112);
        return;
    L45:
        r20 = r12;
        goto L46
    L35:
        if (Intrinsics.areEqual(r19, "not_registered_1") == false) goto L38;
        r110 = -2;
        goto L42
    L38:
        if (Intrinsics.areEqual(r19, "label_call_handler_reject") == false) goto L40;
        r110 = -1;
        goto L42
    L40:
        r110 = AIPackageNetworkResponse.CODE_UNKNOWN;
    L28:
        r19 = null;
        goto L29
    L41:
        r110 = 1;
    L20:
        r16 = "";
        goto L22
    }

    public final void c(String r1, String r10, int r11, String r12, o0 r13) {
        d(r1, r10, r13, true);
    }
}
