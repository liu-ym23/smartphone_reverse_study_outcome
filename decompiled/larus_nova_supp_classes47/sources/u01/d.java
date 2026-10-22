package u01;

import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements ImCacheUnit {
    public final RevImCacheUnit a;

    public final String getMessageMethod() {
        return this.a.getMessageMethod();
    }

    public final String getTag() {
        return this.a.getTag();
    }

    public d(RevImCacheUnit r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void doHandle(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a.doHandle((yh6.c) r2);
    }
}
