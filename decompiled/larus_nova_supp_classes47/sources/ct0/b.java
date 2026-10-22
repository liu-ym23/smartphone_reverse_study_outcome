package ct0;

import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.common.LiveViewStub;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zs0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class b implements bt0.b {
    public h a;
    public LinearLayout b;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // bt0.b
    public final void f() {
    }

    @Override // bt0.b
    public final void g() {
    }

    @Override // bt0.b
    public final void onViewShow() {
    }

    @Override // bt0.b
    public final void p(LiveViewStub r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        LinearLayout r0 = new LinearLayout(r3.getContext());
        r3.a(r0);
        Unit r4 = Unit.INSTANCE;
        this.b = r0;
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public final void setProfileContext(h r1) {
        this.a = r1;
    }

    @Override // bt0.b
    public void h(ProfileText r2, HonorWallElement r3, NewProfileUser r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "profileUser");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        LinearLayout r6 = this.b;
        if (r6 != null) goto L5;
        return;
    L5:
        zs0.a r7 = c.a;
        c.a(r6, r2, null, c.a);
    }

    @Override // bt0.b
    public void update(ProfileText r2, HonorWallElement r3, NewProfileUser r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "profileUser");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        LinearLayout r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        h(r2, r3, r4, r5);
    }
}
