package com.loc;

import com.obric.aivoice.core.data.NameKeys;
import n4a.e5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final u.c a;
    public final String b;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[u.c.values().length];
            a = r0;
            r0[u.c.b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            a[u.c.c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            a[u.c.d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            a[u.c.e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            a[u.c.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            a[u.c.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            a[u.c.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            a[u.c.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            a[u.c.a.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public j(u.c r3, e5 r4) {
        this.a = r3;
        switch(a.a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        this.b = r5;
        return;
    L5:
        r5 = String.format("设置隐私政策成功", new Object[0]);
        goto L14
    L6:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
        goto L14
    L7:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", new Object[]{r4.a()});
        goto L14
    L8:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", new Object[]{r4.a()});
        goto L14
    L9:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", new Object[]{r4.a()});
        goto L14
    L10:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", new Object[]{r4.a()});
        goto L14
    L11:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", new Object[]{r4.a()});
        goto L14
    L12:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", new Object[]{r4.a()});
        goto L14
    L13:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", new Object[]{r4.a()});
        goto L14
    }
}
