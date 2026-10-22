package com.bytedance.ies.bullet.service.monitor.standard;

import android.view.View;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.i;
import com.google.common.reflect.w;
import fj.a;
import j5.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tc.c;
import td.d;
import x4.h;
import xc.e;
import xc.f;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J8\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/standard/ContainerStandardMonitor;", "", "()V", "TYPE_LYNX", "", "TYPE_WEB", "moduleName", "schemaLogMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addContext", "", "monitorId", STGroup.DICT_KEY, "value", "attach", "sessionId", "view", "Landroid/view/View;", "type", "batchCollect", "data", "Lorg/json/JSONObject;", "collect", "field", "enableCollect", "", "invalidateID", "reportError", "errCode", "errorMsg", "virtualAid", "biz", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ContainerStandardMonitor {
    public static final ContainerStandardMonitor INSTANCE = null;
    private static final String TYPE_LYNX = "lynx";
    private static final String TYPE_WEB = "web";
    private static final String moduleName = "Monitor-Standard";
    private static final ConcurrentHashMap<String, Integer> schemaLogMap = null;

    static {
        INSTANCE = new ContainerStandardMonitor();
        schemaLogMap = new ConcurrentHashMap(16);
    }

    private ContainerStandardMonitor() {
    }

    private final boolean enableCollect() {
        c r5 = c.f22119c;
        rc.c r10 = (i) a.a(c.f22119c, i.class, i.class);
        if (r10 != null) goto L5;
        Lazy r11 = com.bytedance.ies.bullet.service.monitor.i.d;
        r10 = m.b();
    L5:
        w r12 = ((com.bytedance.ies.bullet.service.monitor.i) r10).f6054b;
        ConcurrentHashMap r13 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r14 = (e) yc.a.a(e.class, "default_bid");
        if (r14 == null) goto L10;
        f r15 = (f) r14.a(f.class);
        return true;
    L10:
        return true;
    }

    public final void addContext(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "value");
        b r12 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.D(r10, STGroup.DICT_KEY, r11, "value", "addContainerContext [monitorId:");
        f8.b.e(r13, r5, "][field:", r10, "][value:");
        r13.append(r11);
        r13.append(']');
        d5.b.f("ContainerStandardApi", r13.toString());
        j5.e.f18241a.getClass();
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "field");
        Intrinsics.checkNotNullParameter(r11, "value");
        qo.a.j(r11, r10, b.f(r5));
    }

    public final void attach(String r5, View r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "type");
        if (enableCollect() == false) goto L16;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("attach_" + r5 + '_' + r11, LogLevel.f5954b, moduleName);
        if (Intrinsics.areEqual(r11, TYPE_LYNX) == false) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        j5.f r14 = new j5.f(r10, r11);
    L12:
        if (r14 == null) goto L15;
        j5.e.b(r5, r14);
        return;
    L15:
        return;
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = Intrinsics.areEqual(r11, TYPE_WEB);
        goto L9
    }

    public final void batchCollect(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "data");
        b r11 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "fields");
        d5.b.f("ContainerStandardApi", "batchCollect [monitorId:" + r5 + ']');
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        b r14 = j5.e.f18241a;
        j5.e.c(r5, r13, r10.get(r13));
        goto L4
    }

    public final void collect(String r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "field");
        Intrinsics.checkNotNullParameter(r12, "data");
        if (enableCollect() == false) goto L31;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("collect_" + r10 + '_' + r11, LogLevel.f5954b, moduleName);
        if (Intrinsics.areEqual(r11, "schema") == false) goto L8;
    L9:
        ConcurrentHashMap<String, Integer> r14 = schemaLogMap;
        if (r14.contains(r10) == true) goto L30;
        r14.put(r10, 1);
    L13:
        if ((r12 instanceof String) == false) goto L17;
        j5.e.d(r10, r11, (String) r12);
        return;
    L17:
        if ((r12 instanceof Boolean) == false) goto L21;
        b r15 = j5.e.f18241a;
        Boolean r16 = (Boolean) r12;
        boolean r17 = r16.booleanValue();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "field");
        StringBuilder r5 = com.lynx.tasm.base.a.e("collectBoolean [monitorId:", r10, "][field:", r11, "][value:");
        r5.append(r17);
        r5.append(']');
        d5.b.f("ContainerStandardApi", r5.toString());
        j5.e.c(r10, r11, r16);
        return;
    L21:
        if ((r12 instanceof Integer) == false) goto L25;
        b r18 = j5.e.f18241a;
        Integer r19 = (Integer) r12;
        int r20 = r19.intValue();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "field");
        StringBuilder r21 = com.lynx.tasm.base.a.e("collectInt [monitorId:", r10, "][field:", r11, "][value:");
        r21.append(r20);
        r21.append(']');
        d5.b.f("ContainerStandardApi", r21.toString());
        j5.e.c(r10, r11, r19);
        return;
    L25:
        if ((r12 instanceof Long) == false) goto L28;
        b r22 = j5.e.f18241a;
        Long r110 = (Long) r12;
        long r23 = r110.longValue();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "field");
        StringBuilder r24 = com.lynx.tasm.base.a.e("collectLong [monitorId:", r10, "][field:", r11, "][value:");
        r24.append(r23);
        r24.append(']');
        d5.b.f("ContainerStandardApi", r24.toString());
        j5.e.c(r10, r11, r110);
        return;
    L28:
        b r25 = j5.e.f18241a;
        j5.e.d(r10, r11, r12.toString());
        return;
    L30:
        return;
    L8:
        if (Intrinsics.areEqual(r11, "open_time") == false) goto L13;
    }

    public final void invalidateID(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        if (enableCollect() == true) goto L5;
        return;
    L5:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(d.b("invalidateID_", r5), LogLevel.f5954b, moduleName);
        b r11 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        j5.e.f18243c.post(new com.bytedance.apm.d(r5, 6));
        schemaLogMap.remove(r5);
    }

    public final void reportError(View r5, String r10, int r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        Intrinsics.checkNotNullParameter(r13, "virtualAid");
        Intrinsics.checkNotNullParameter(r14, "biz");
        if (enableCollect() == true) goto L5;
        return;
    L5:
        boolean r15 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("reportError_" + r10 + '_' + r11 + '_' + r12, LogLevel.f5954b, moduleName);
        j5.c r16 = new j5.c(r11, r12, r13, r14);
        b r17 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r16, "error");
        d5.b.f("ContainerStandardApi", "reportContainerError [monitorId:" + r10 + "][errorCode:" + r11 + "][errorMsg:" + r12 + ']');
        j5.e.f18241a.getClass();
        j5.f r18 = b.i(r10);
        if (r5 == null) goto L8;
        x4.a r19 = b.g(r5);
    L9:
        if (r18 == null) goto L14;
        LinkedHashMap r20 = j5.e.f18242b;
        String r21 = r18.f18244a;
        if (r20.get(r21) == null) goto L14;
        Object r22 = r20.get(r21);
        Intrinsics.checkNotNull(r22);
        ((j5.d) r22).a(r5, r10, r19, r16);
        return;
    L14:
        Intrinsics.checkNotNullParameter("containerError", "eventType");
        com.bytedance.android.monitorV2.event.a r23 = new com.bytedance.android.monitorV2.event.a("containerError");
        r23.e();
        r23.f3550m = new x4.b();
        h r24 = new h();
        r24.f = r13;
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Object r25 = b.h(r10).get("url");
        String r26 = null;
        if ((r25 instanceof String) == false) goto L17;
        String r27 = (String) r25;
    L18:
        if (r27 == null) goto L20;
        r24.f22973a = r27;
    L20:
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Object r28 = b.h(r10).get("native_page");
        if ((r28 instanceof String) == false) goto L23;
        String r29 = (String) r28;
    L24:
        if (r29 == null) goto L26;
        r24.d = r29;
    L26:
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Object r30 = b.h(r10).get("container_type");
        if ((r30 instanceof String) == false) goto L29;
        r26 = (String) r30;
    L29:
        if (r26 == null) goto L31;
        r24.f22975c = r26;
    L31:
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.f = r24;
        r23.f3551n = new x4.a(1, MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(r11)), TuplesKt.to("container_load_error_msg", r12)}));
        r23.f3560h = r19;
        r23.g();
        com.bytedance.android.monitorV2.dataprocessor.b r31 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.b(r23, Boolean.TRUE);
        return;
    L23:
        r29 = null;
        goto L24
    L17:
        r27 = null;
        goto L18
    L8:
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        r19 = new x4.a(0, b.c(r10));
        goto L9
    }
}
