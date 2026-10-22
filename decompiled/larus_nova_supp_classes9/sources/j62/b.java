package j62;

import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.service.messagelist.c;
import com.bytedance.android.livesdk.interactivity.service.messagelist.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements d {
    public final LimitQueue a;

    public b() {
        this.a = new LimitQueue(512);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.d
    public final boolean a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        long r0 = r5.getId();
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        boolean r6 = this.a.contains(Long.valueOf(r0));
        if (r6 == false) goto L10;
        return true;
    L10:
        this.a.add(Long.valueOf(r0));
        return r6;
    }
}
