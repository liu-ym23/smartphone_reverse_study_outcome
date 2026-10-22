package com.bytedance.android.annie.container.dialog;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    static {
    }

    @JvmStatic
    public static final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        List<String> r0 = AnnieConfigSettingKeys.LIVE_NEW_PANEL_ALLOW_LIST.a();
        if ((!r0.isEmpty()) == false) goto L25;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L25;
        String r11 = r1.next();
        if (StringsKt.startsWith$default(r11, "http", false, 2, null) == true) goto L10;
        r11 = "http://" + r11;
    L10:
        Uri r12 = UriProtector.parse(r11);
        if (r12 == null) goto L6;
        if (r12.getPath() == null) goto L6;
        if (r12.getHost() == null) goto L6;
        if (TextUtils.isEmpty(r12.getPath()) == true) goto L21;
        String r13 = r12.getPath();
        Intrinsics.checkNotNull(r13);
        if (StringsKt.contains$default(r10, r13, false, 2, null) == false) goto L6;
    L21:
        if (TextUtils.isEmpty(r12.getHost()) == true) goto L41;
        String r14 = r12.getHost();
        Intrinsics.checkNotNull(r14);
        if (StringsKt.contains$default(r10, r14, false, 2, null) == false) goto L6;
        return true;
    L41:
        return true;
    L25:
        return false;
    }
}
