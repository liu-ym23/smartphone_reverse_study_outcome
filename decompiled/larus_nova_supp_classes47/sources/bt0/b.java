package bt0;

import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.common.LiveViewStub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends com.bytedance.android.live.profile.profilecontext.c {
    void f();

    void g();

    void h(ProfileText r1, HonorWallElement r2, NewProfileUser r3, h r4);

    void onViewShow();

    void p(LiveViewStub r1);

    void update(ProfileText r1, HonorWallElement r2, NewProfileUser r3, h r4);
}
