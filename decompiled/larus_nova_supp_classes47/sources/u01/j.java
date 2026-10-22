package u01;

import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements IPkExposeData {
    public final pc0.d a;

    public final int getIconId() {
        return this.a.d;
    }

    public final int getLeftTime() {
        return this.a.a;
    }

    public final int getLoadStatus() {
        return this.a.e;
    }

    public final int getPkState() {
        Integer r0 = this.a.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getPlayMode() {
        Integer r0 = this.a.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public j(pc0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }
}
