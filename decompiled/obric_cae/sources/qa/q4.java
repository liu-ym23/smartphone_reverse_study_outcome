package qa;

/* JADX INFO: loaded from: classes.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p4.d f10954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10955b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10956a = null;

        static {
            int[] r8 = new int[p4.d.values().length];
            f10956a = r8;
            p4.d r10 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L13
            r8[1] = 1;     // Catch: NoSuchFieldError -> L13
        L32:
            int[] r11 = f10956a;     // Catch: NoSuchFieldError -> L14
            p4.d r12 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L14
            r11[2] = 2;     // Catch: NoSuchFieldError -> L14
        L22:
            int[] r13 = f10956a;     // Catch: NoSuchFieldError -> L15
            p4.d r14 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L15
            r13[3] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            int[] r15 = f10956a;     // Catch: NoSuchFieldError -> L16
            p4.d r16 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L16
            r15[4] = 4;     // Catch: NoSuchFieldError -> L16
        L30:
            int[] r17 = f10956a;     // Catch: NoSuchFieldError -> L17
            p4.d r18 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L17
            r17[5] = 5;     // Catch: NoSuchFieldError -> L17
        L36:
            int[] r19 = f10956a;     // Catch: NoSuchFieldError -> L18
            p4.d r20 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L18
            r19[6] = 6;     // Catch: NoSuchFieldError -> L18
        L26:
            int[] r21 = f10956a;     // Catch: NoSuchFieldError -> L19
            p4.d r22 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L19
            r21[7] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            int[] r23 = f10956a;     // Catch: NoSuchFieldError -> L20
            p4.d r24 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L20
            r23[8] = 8;     // Catch: NoSuchFieldError -> L20
        L28:
            int[] r25 = f10956a;     // Catch: NoSuchFieldError -> L21
            p4.d r26 = p4.d.f10930b;     // Catch: NoSuchFieldError -> L21
            r25[0] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public q4(p4.d r8, s4 r10) {
        this.f10954a = r8;
        switch(a.f10956a[r8.ordinal()]) {
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
        String r11 = "";
    L14:
        this.f10955b = r11;
        return;
    L5:
        r11 = String.format("设置隐私政策成功", new Object[0]);
        goto L14
    L6:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
        goto L14
    L7:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", new Object[]{r10.a()});
        goto L14
    L8:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", new Object[]{r10.a()});
        goto L14
    L9:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", new Object[]{r10.a()});
        goto L14
    L10:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", new Object[]{r10.a()});
        goto L14
    L11:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", new Object[]{r10.a()});
        goto L14
    L12:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", new Object[]{r10.a()});
        goto L14
    L13:
        r11 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", new Object[]{r10.a()});
        goto L14
    }
}
