package zp9;

import com.larus.platform.api.creation.UserCreation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final boolean a;
    public final UserCreation b;
    public final String c;
    public final String d;

    public a(boolean r3, UserCreation r4, String r5, String r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
