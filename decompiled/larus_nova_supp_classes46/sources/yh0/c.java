package yh0;

import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends IAbility {
    void F4(boolean r1);

    com.bytedance.android.live.ui.c Y0();

    View c();

    boolean isPickingImage();

    View j();

    void k(String r1, ye1.a r2);

    void onActivityResult(int r1, int r2, Intent r3);

    void onSei(String r1);
}
