package b9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import h8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b extends com.bytedance.android.annie.service.a {
    HybridFragment B1(Context r1, Uri r10, b7.b r11, Bundle r12);

    HybridCard J0(Context r1, Uri r10, b7.b r11, Bundle r12);

    void f0(KitType r1, Uri r10, Bundle r11);

    void init();

    HybridDialog o1(Context r1, Uri r10, b7.b r11, Bundle r12);

    boolean p1(Context r1, Uri r10, c r11, Bundle r12);
}
