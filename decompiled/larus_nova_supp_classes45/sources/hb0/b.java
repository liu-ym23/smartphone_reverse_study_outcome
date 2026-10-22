package hb0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static String a(String r2, int r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append(" failed: ");
        switch(r3) {
            case 12288: goto L19;
            case 12289: goto L18;
            case 12290: goto L17;
            case 12291: goto L16;
            case 12292: goto L15;
            case 12293: goto L14;
            case 12294: goto L13;
            case 12295: goto L12;
            case 12296: goto L11;
            case 12297: goto L10;
            case 12298: goto L9;
            case 12299: goto L8;
            case 12300: goto L7;
            case 12301: goto L6;
            case 12302: goto L5;
            default: goto L20;
        };
    L5:
        String r4 = "EGL_CONTEXT_LOST";
    L21:
        r0.append(r4);
        return r0.toString();
    L6:
        r4 = "EGL_BAD_SURFACE";
        goto L21
    L7:
        r4 = "EGL_BAD_PARAMETER";
        goto L21
    L8:
        r4 = "EGL_BAD_NATIVE_WINDOW";
        goto L21
    L9:
        r4 = "EGL_BAD_NATIVE_PIXMAP";
        goto L21
    L10:
        r4 = "EGL_BAD_MATCH";
        goto L21
    L11:
        r4 = "EGL_BAD_DISPLAY";
        goto L21
    L12:
        r4 = "EGL_BAD_CURRENT_SURFACE";
        goto L21
    L13:
        r4 = "EGL_BAD_CONTEXT";
        goto L21
    L14:
        r4 = "EGL_BAD_CONFIG";
        goto L21
    L15:
        r4 = "EGL_BAD_ATTRIBUTE";
        goto L21
    L16:
        r4 = "EGL_BAD_ALLOC";
        goto L21
    L17:
        r4 = "EGL_BAD_ACCESS";
        goto L21
    L18:
        r4 = "EGL_NOT_INITIALIZED";
        goto L21
    L19:
        r4 = "EGL_SUCCESS";
        goto L21
    L20:
        r4 = "0x" + Integer.toHexString(r3);
        goto L21
    }
}
