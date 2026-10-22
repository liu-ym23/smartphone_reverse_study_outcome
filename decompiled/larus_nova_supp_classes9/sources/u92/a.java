package u92;

import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements j {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "textMessage");
        n0 r7 = r6.b;
        if ((r7 instanceof n0) == false) goto L13;
        n0 r8 = r7;
        o0.b r0 = r8.getExtraInfo();
        if (r0 == null) goto L13;
        String r1 = r0.getSource();
        if (r1 == null) goto L13;
        if (r8.getAction() != 1) goto L13;
        if (Intrinsics.areEqual("anchor_pause", r1) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
