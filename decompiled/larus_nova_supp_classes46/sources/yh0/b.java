package yh0;

import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import hh1.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b extends w0 {
    void F4(boolean r1);

    com.bytedance.android.live.ui.c Y0();

    View c();

    boolean isPickingImage();

    View j();

    void k(String r1, ye1.a r2);

    void onActivityResult(int r1, int r2, Intent r3);

    void onSei(String r1);

    void p3(IRoom r1);
}
