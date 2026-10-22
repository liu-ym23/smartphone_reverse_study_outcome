package bt0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends com.bytedance.android.live.profile.profilecontext.c {
    void b(HonorWallElement r1);

    void d(Fragment r1, View r2, HonorWallElement r3, NewProfileUser r4, h r5);

    View e(h r1, Context r2);

    b i();

    void j(HonorWallElement r1);

    void k(HonorWallElement r1);

    void m();

    boolean n(HonorWallElement r1, NewProfileUser r2, h r3);

    boolean o(HonorWallElement r1, h r2);
}
