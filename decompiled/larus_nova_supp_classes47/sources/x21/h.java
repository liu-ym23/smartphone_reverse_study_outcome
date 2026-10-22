package x21;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public boolean a;
    public final long b;
    public final long c;
    public final int d;
    public final IBaseBattleSetting e;

    public h(long r2, long r4, int r6, IBaseBattleSetting r7) {
        Intrinsics.checkNotNullParameter(r7, "setting");
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.a = true;
    }
}
