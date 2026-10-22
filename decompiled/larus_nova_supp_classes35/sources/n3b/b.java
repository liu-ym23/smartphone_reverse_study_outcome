package n3b;

import android.content.Context;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements o3b.a {
    public final m2b.a a;

    @Override // o3b.a
    public final int a() {
        return 32;
    }

    @Override // o3b.a
    public final int c() {
        return 56;
    }

    public b(m2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
    }

    @Override // o3b.a
    public final int b(Context r2, Integer r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.a.m() == false) goto L6;
        return j.e(r2, r3, r6, r5);
    L6:
        if (this.a.Y() == false) goto L11;
        if (r4 == false) goto L22;
        return j.i(r2, r5, r3, r6);
    L22:
        return j.j(r2, r5, r3, r6);
    L11:
        if (this.a.q() == false) goto L16;
        if (r4 == false) goto L24;
        return j.k(r2, r3);
    L24:
        return j.l(r2, r3);
    L16:
        if (this.a.r() == false) goto L19;
        return j.b(r2, r3);
    L19:
        return j.d(r2, r3);
    }

    @Override // o3b.a
    public final int d(Context r7, Integer r8, boolean r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (this.a.m() == true) goto L13;
        if (this.a.Y() == true) goto L13;
        if (this.a.q() == true) goto L13;
        if (this.a.r() == true) goto L13;
        return j.a(r7, r8) - UIHelper.dp2px(2.0f);
    L13:
        if (this.a.m() == false) goto L15;
    L19:
        boolean r5 = false;
    L21:
        return b(r7, r8, r9, r10, r5);
    L15:
        if (this.a.Y() == false) goto L18;
        if (r9 == true) goto L19;
    L18:
        r5 = r11;
        goto L21
    }
}
