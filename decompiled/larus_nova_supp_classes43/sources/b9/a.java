package b9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import h8.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // b9.b
    public final HybridFragment B1(Context r1, Uri r10, b7.b r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "rawUri");
        return null;
    }

    @Override // b9.b
    public final HybridCard J0(Context r1, Uri r10, b7.b r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "rawUri");
        return null;
    }

    @Override // b9.b
    public final void f0(KitType r1, Uri r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r1, "kitType");
        Intrinsics.checkNotNullParameter(r10, "rawUri");
    }

    @Override // b9.b
    public final void init() {
    }

    @Override // b9.b
    public final HybridDialog o1(Context r1, Uri r10, b7.b r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "rawUri");
        return null;
    }

    @Override // b9.b
    public final boolean p1(Context r1, Uri r10, c r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "rawUri");
        return false;
    }
}
