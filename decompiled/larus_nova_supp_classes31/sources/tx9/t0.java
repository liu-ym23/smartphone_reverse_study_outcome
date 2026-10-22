package tx9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(boolean r0, boolean r1, boolean r2, boolean r3) {
        if (r0 == true) goto L5;
        return "normal_create";
    L5:
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        if (r3 == true) goto L9;
        return "compensate_no_real_token_no_user_changes_no_frontend_linked";
    L9:
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        if (r3 == false) goto L13;
        return "compensate_no_real_token_no_user_changes_frontend_linked";
    L13:
        if (r1 == true) goto L17;
        if (r2 == false) goto L17;
        if (r3 == true) goto L17;
        return "compensate_no_real_token_user_changes_no_frontend_linked";
    L17:
        if (r1 == true) goto L21;
        if (r2 == false) goto L21;
        if (r3 == false) goto L21;
        return "compensate_no_real_token_user_changes_frontend_linked";
    L21:
        if (r1 == false) goto L25;
        if (r2 == true) goto L25;
        if (r3 == true) goto L25;
        return "compensate_real_token_no_user_changes_no_frontend_linked";
    L25:
        if (r1 == false) goto L29;
        if (r2 == true) goto L29;
        if (r3 == false) goto L29;
        return "compensate_real_token_no_user_changes_frontend_linked";
    L29:
        if (r1 == false) goto L33;
        if (r2 == false) goto L33;
        if (r3 == true) goto L33;
        return "compensate_real_token_user_changes_no_frontend_linked";
    L33:
        return "compensate_real_token_user_changes_frontend_linked";
    }
}
