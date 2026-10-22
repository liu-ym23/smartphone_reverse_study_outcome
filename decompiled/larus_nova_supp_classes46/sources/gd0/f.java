package gd0;

import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface f extends IAbility {
    com.bytedance.android.live.ui.c Y0();

    View c();

    boolean isPickingImage();

    void onActivityResult(int r1, int r2, Intent r3);
}
