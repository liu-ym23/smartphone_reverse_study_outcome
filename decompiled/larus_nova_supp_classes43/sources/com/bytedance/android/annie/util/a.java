package com.bytedance.android.annie.util;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.annie.Annie;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r10, String r11, String r12, String r13, int r14, String r15) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r11, "level");
        Intrinsics.checkNotNullParameter(r12, "file");
        Intrinsics.checkNotNullParameter(r13, "function");
        Intrinsics.checkNotNullParameter(r15, "bizKey");
        StringBuilder r16 = new StringBuilder(r1.length() + 100);
        r16.append("[");
        r16.append(r12);
        r16.append(", ");
        r16.append(r13);
        r16.append(", ");
        r16.append(r14);
        r16.append("]");
        r16.append(r1);
        String r17 = r16.toString();
        String r18 = "web_" + r10;
        switch(r11.hashCode()) {
            case 3237038: goto L18;
            case 3641990: goto L15;
            case 95458899: goto L12;
            case 96784904: goto L9;
            case 351107458: goto L6;
            default: goto L22;
        };
    L6:
        if (r11.equals("verbose") == false) goto L22;
    L19:
        ((x8.d) Annie.getService$default(x8.d.class, null, 2, null)).i(r18, r17);
        return;
    L9:
        if (r11.equals(IHostStyleUIDepend.TOAST_TYPE_ERROR) == false) goto L22;
        ((x8.d) Annie.getService$default(x8.d.class, null, 2, null)).e(r18, r17);
        return;
    L12:
        if (r11.equals("debug") == false) goto L22;
    L15:
        if (r11.equals(IHostStyleUIDepend.TOAST_TYPE_WARN) == false) goto L22;
    L18:
        if (r11.equals("info") == true) goto L19;
    L22:
        throw new IllegalArgumentException("Illegal level!");
    }
}
