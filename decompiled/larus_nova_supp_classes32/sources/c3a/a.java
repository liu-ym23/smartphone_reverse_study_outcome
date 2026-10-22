package c3a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final void a(boolean r3, boolean r4) {
        by7.a r0 = new by7.a("face_memory_pop_up_confirm");
        r0.d("pop_up_type", "first_time_auth");
        if (r3 == false) goto L5;
        String r1 = "confirm";
    L6:
        r0.d("confirm_choice", r1);
        if (r3 == false) goto L11;
        if (r4 == true) goto L11;
        String r5 = "fail";
    L12:
        r0.d("result", r5);
        r0.b();
        return;
    L11:
        r5 = "success";
        goto L12
    L5:
        r1 = "cancel";
        goto L6
    }
}
