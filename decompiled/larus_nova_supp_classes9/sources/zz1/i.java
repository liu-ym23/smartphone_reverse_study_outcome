package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.ChangeReceiverSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements j12.a, com.bytedance.android.scope.o {
    public final y a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public i(y r2) {
        Intrinsics.checkNotNullParameter(r2, "selectReceiverService");
        this.a = r2;
    }

    @Override // j12.a
    public final void selectReceiver(String r3) {
        Intrinsics.checkNotNullParameter(r3, "receiverId");
        this.a.a(r3, ChangeReceiverSource.Other);
    }
}
