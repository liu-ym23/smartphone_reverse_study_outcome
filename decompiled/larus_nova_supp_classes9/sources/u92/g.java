package u92;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import ec2.p1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements j {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessage");
        if (7 != r2.getType()) goto L7;
        o72.d.a.getClass();
        if (((o72.d) p1.a.getValue()).d() == true) goto L7;
        return true;
    L7:
        return false;
    }
}
