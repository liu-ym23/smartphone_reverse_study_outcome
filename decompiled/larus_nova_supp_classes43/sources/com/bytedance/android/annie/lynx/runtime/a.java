package com.bytedance.android.annie.lynx.runtime;

import android.net.Uri;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import d8.c;
import e8.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, LynxGroup> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static final LynxGroup a(String r1, boolean r10, boolean r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "bizKey");
        c r14 = d.a(r13).c;
        if (r14 == null) goto L7;
        LynxGroup r15 = r14.a(r1, r10, r11, r12);
        if (r15 == null) goto L7;
        return r15;
    L7:
        return LynxGroup.Create(r1, null);
    }

    public static void b(final LynxViewBuilder r15, String r16, String r17, String r18, boolean r19, boolean r20, int r21) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r18, "containerId");
        Intrinsics.checkNotNullParameter("host", "bizKey");
        Function1<LynxGroup, Unit> r12 = new LynxRuntimeConfiguratorKt$setupLynxGroup$1(r15);
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r18, "containerId");
        Intrinsics.checkNotNullParameter("host", "bizKey");
        Intrinsics.checkNotNullParameter(r12, "callback");
        boolean r10 = false;
        if (r17.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L19;
        Uri r1 = UriProtector.parse(r17);
        if (r1 == null) goto L11;
        String r11 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_BUSINESS_TYPE);
    L12:
        if (r11 == null) goto L19;
        Uri r13 = UriProtector.parse(r17);
        if (r13 == null) goto L17;
        String r14 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_BUSINESS_TYPE);
        if (r14 == null) goto L17;
    L33:
        String r22 = r14;
        r10 = true;
    L35:
        Uri r23 = UriProtector.parse(r16);
        if (r23 == null) goto L39;
        String r24 = UriProtector.getQueryParameter(r23, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r24 == null) goto L39;
    L40:
        HybridLogger r25 = HybridLogger.a;
        StringBuilder r26 = new StringBuilder("switch is: ");
        i<Boolean> r27 = AnnieConfigSettingKeys.BUGFIX_WEBCAST_LYNX_GROUP;
        r26.append(r27.a());
        r26.append(" , businessType is ");
        r26.append(r22);
        r26.append(",  inputUrl is ");
        r26.append(r17);
        r26.append(" , urlFromSchema is ");
        r26.append(r24);
        HybridLogger.m("AnnieX_Webcast_LynxGroup", r26.toString(), null, null, 12);
        if (r27.a().booleanValue() == true) goto L43;
        if (r10 == false) goto L54;
        LinkedHashMap r28 = (LinkedHashMap) a;
        Object r29 = r28.get(r22);
        if (r29 != null) goto L53;
        r29 = a(r22, r19, r20, r21, "host");
        r28.put(r22, r29);
    L53:
        r12.invoke((LynxGroup) r29);
        return;
    L54:
        r12.invoke(a(r22, r19, r20, r21, "host"));
        return;
    L43:
        if (r21 == 0) goto L47;
        if (r21 == 1) goto L46;
        LynxGroup r30 = LynxGroup.Create(r22, r22, null, false, r19, r20);
    L48:
        r12.invoke(r30);
        return;
    L46:
        r30 = LynxGroup.Create(r22, r22, null, false, r19, r20, true);
        goto L48
    L47:
        r30 = LynxGroup.Create(r22, r22, null, false, r19, r20, false);
    L39:
        r24 = "unknown";
    L17:
        r14 = "unspecified-" + r18;
        goto L33
    L11:
        r11 = null;
    L19:
        if (r16.length() <= 0) goto L21;
        boolean r31 = true;
    L22:
        if (r31 == false) goto L34;
        Uri r32 = UriProtector.parse(r16);
        if (r32 == null) goto L26;
        String r33 = UriProtector.getQueryParameter(r32, com.bytedance.android.ec.core.event.a.KEY_BUSINESS_TYPE);
    L27:
        if (r33 == null) goto L34;
        Uri r34 = UriProtector.parse(r16);
        if (r34 == null) goto L32;
        r14 = UriProtector.getQueryParameter(r34, com.bytedance.android.ec.core.event.a.KEY_BUSINESS_TYPE);
        if (r14 != null) goto L33;
    L32:
        r14 = "unspecified-" + r18;
        goto L33
    L26:
        r33 = null;
    L34:
        r22 = "unspecified-" + r18;
        goto L35
    L21:
        r31 = false;
        goto L22
    L5:
        r0 = false;
        goto L7
    }
}
