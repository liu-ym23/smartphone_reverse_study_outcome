package st0;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.live.profile.ui.component.base.b {
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;

    public b(int r3, String r4, int r5, int r6, int r7, boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r9 & 4) == 0) goto L9;
        r5 = UtilityKotlinExtentionsKt.i(36);
    L9:
        if ((r9 & 8) == 0) goto L12;
        r6 = -1;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r7 = -1;
    L15:
        if ((r9 & 32) == 0) goto L17;
        r8 = false;
    L17:
        Intrinsics.checkNotNullParameter(r4, "text");
        super(r3);
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
