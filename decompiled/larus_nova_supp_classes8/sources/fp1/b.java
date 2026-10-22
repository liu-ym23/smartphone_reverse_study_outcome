package fp1;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.PanelButtonStatusSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.f;
import com.bytedance.android.livesdk.config.la0;
import com.bytedance.android.livesdk.config.yr0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hd0.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements f.a {
    public final boolean a;

    public b(boolean r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.f.a
    public final boolean a(e r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        if (la0.a.getValue().booleanValue() == true) goto L6;
        return false;
    L6:
        if (this.a == false) goto L9;
        return false;
    L9:
        if (((Boolean) yr0.a.getValue()).booleanValue() == false) goto L17;
        int r8 = r6.g;
        if (r8 == (-1)) goto L15;
        if (r8 == 0) goto L15;
        if (ToolbarButton.SHARE_TO_DAILY.getId() != (-1)) goto L17;
    L15:
        return false;
    L17:
        if (r6.g != ToolbarButton.SHARE_TO_DAILY.getId()) goto L20;
        return true;
    L20:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.f.a
    public final e b(e r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Room r6 = z.o(r5);
        boolean r0 = false;
        if (r6 == null) goto L5;
        int r1 = r6.getVisibilityRange();
    L7:
        if (r1 != 0) goto L17;
        if (r6 == null) goto L16;
        User r7 = r6.getOwner();
        if (r7 == null) goto L16;
        if (r7.getSecret() == 1) goto L17;
    L16:
        if (c.f().h() == true) goto L17;
        boolean r8 = false;
    L19:
        if (r8 == true) goto L21;
        return r4;
    L21:
        h r9 = r4.j;
        if (r9 == null) goto L31;
        int r10 = r9.a;
        if (r10 != 0) goto L26;
        boolean r2 = true;
    L27:
        if (r2 == true) goto L31;
        if (r10 != 1) goto L30;
        r0 = true;
    L30:
        if (r0 == true) goto L31;
    L32:
        return r4;
    L26:
        r2 = false;
    L31:
        r4.j = new h(3, PanelButtonStatusSource.LOCAL_CONFIG, s1.B(2131922507));
    L17:
        r8 = true;
        goto L19
    L5:
        r1 = 0;
        goto L7
    }
}
