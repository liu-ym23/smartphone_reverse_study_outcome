package u92;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.GiftMessageDecoupleUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements j {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessage");
        tlc.d r3 = r2.b;
        if (((Boolean) PublicScreenABHelper.B.getValue()).booleanValue() == false) goto L6;
        return GiftMessageDecoupleUtil.c(r3);
    L6:
        return GiftMessageDecoupleUtil.a(r3);
    }
}
