package com.bytedance.ai.applet.render.core.lynx;

import android.net.Uri;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(LynxView r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter("1.15.0-rc.7", "sdkVersion");
            Uri r1 = UriProtector.parse(r11);     // Catch: Exception -> L31
            if (r12 != null) goto L10;
            r12 = UriProtector.getQueryParameter(r1, "channel");     // Catch: Exception -> L31
            if (r12 != null) goto L10;
            r12 = UriProtector.getQueryParameter(r1, "gecko_channel");     // Catch: Exception -> L31
            if (r12 != null) goto L10;
            r12 = UriProtector.getQueryParameter(r1, "packageName");     // Catch: Exception -> L31
        L10:
            if (r13 != null) goto L16;
            r13 = UriProtector.getQueryParameter(r1, "bundle");     // Catch: Exception -> L31
            if (r13 != null) goto L16;
            r13 = UriProtector.getQueryParameter(r1, "gecko_bundle");     // Catch: Exception -> L31
            if (r13 != null) goto L16;
            r13 = UriProtector.getQueryParameter(r1, BdpAwemeConstant.KEY_APP_ID);     // Catch: Exception -> L31
        L16:
            if (r12 == null) goto L19;
            if (r13 == null) goto L19;
            String r14 = r12 + '/' + r13;     // Catch: Exception -> L31
        L20:
            Map r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r14), TuplesKt.to("container_name", "AISDK"), TuplesKt.to("container_sdk_version", "1.15.0-rc.7"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r11)});     // Catch: Exception -> L31
            LinkedHashMap r16 = new LinkedHashMap();     // Catch: Exception -> L31
            Iterator r17 = r15.entrySet().iterator();     // Catch: Exception -> L31
        L22:
            if (r17.hasNext() == false) goto L29;
            Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Exception -> L31
            if (((String) r18.getValue()) == null) goto L26;
            boolean r0 = true;
        L27:
            if (r0 == false) goto L22;
            r16.put(r18.getKey(), r18.getValue());     // Catch: Exception -> L31
            goto L22
        L26:
            r0 = false;
            goto L27
        L29:
            r10.putParamsForReportingEvents(r16);     // Catch: Exception -> L31
            return;
        L19:
            r14 = r1.buildUpon().clearQuery().build().toString();     // Catch: Exception -> L31
        }
    }

    static {
    }
}
