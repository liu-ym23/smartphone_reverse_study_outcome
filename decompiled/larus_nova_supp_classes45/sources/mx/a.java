package mx;

import com.bytedance.android.live.ui.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a extends s {
    public final String e;
    public String f;
    public final boolean g;
    public boolean h;
    public final boolean i;
    public final String j;
    public final Long k;

    /* JADX INFO: renamed from: mx.a$a, reason: collision with other inner class name */
    public static final class C0248a {
    }

    static {
    }

    public a(String r4, String r5, boolean r6, boolean r7, boolean r8, String r9, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r5 = "";
    L6:
        if ((r11 & 4) == 0) goto L9;
        r6 = false;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r7 = false;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r8 = true;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r9 = "";
    L18:
        if ((r11 & 128) == 0) goto L20;
        Long r12 = 0L;
    L21:
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r9, "disableToast");
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r12;
        return;
    L20:
        r12 = null;
        goto L21
    }
}
