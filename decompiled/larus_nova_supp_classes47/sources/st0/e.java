package st0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class e extends com.bytedance.android.live.profile.ui.component.base.b {
    public final String b;
    public final boolean c;

    public e(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        super(r2);
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ e(int r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        this(r1, r2, false);
    }
}
