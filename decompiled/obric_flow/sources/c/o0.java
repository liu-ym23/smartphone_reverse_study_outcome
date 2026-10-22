package c;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1071a;

    public o0(String r5, long r10, String r11, String r12) {
        if (r10 > 0) goto L6;
        System.currentTimeMillis();
    L6:
        TextUtils.isEmpty(r5);
        TextUtils.isEmpty(r11);
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r12 = "";
    L10:
        this.f1071a = r12;
    }
}
