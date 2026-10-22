package com.bytedance.android.live.rts.client_utils;

import com.bytedance.android.live.core.setting.SettingUtil;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class IESLiveRTSSettingUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(a r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "completion");
        String r0 = r13.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        String r3 = r13.c;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        r14.invoke(new LinkedHashMap());
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L20:
        IESLiveRTSSettingUtils$getClientSetting$1 r5 = IESLiveRTSSettingUtils$getClientSetting$1.INSTANCE;
        IESLiveRTSSettingUtils$getClientSetting$2 r6 = IESLiveRTSSettingUtils$getClientSetting$2.INSTANCE;
        String r7 = r13.a;
        String r15 = r13.c;
        Object r12 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r7);
        if (r15 != null) goto L23;
    L26:
        boolean r8 = true;
    L28:
        if (r8 == true) goto L30;
        r12 = r5.invoke(r12, CollectionsKt.toList(StringsKt.split$default(r15, new char[]{'.'}, false, 0, 6, null)), 0);
    L30:
        if (r15 != null) goto L32;
    L35:
        if (r1 == false) goto L38;
        if (r7 != null) goto L39;
        r7 = "";
    L39:
        r14.invoke(MapsKt.toMutableMap(r6.invoke(r7, r12)));
        return;
    L38:
        r7 = r7 + '.' + r15;
        goto L39
    L32:
        if (r15.length() == 0) goto L35;
        r1 = false;
        goto L35
    L23:
        if (r15.length() == 0) goto L26;
        r8 = false;
        goto L28
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
