package ep1;

import android.view.ViewGroup;
import android.widget.GridLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class e extends c {
    @Override // ep1.c
    public final boolean c(List<ToolbarButton> r2, ViewGroup r3, Function2<? super ToolbarButton, ? super GridLayout, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "buttons");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "loader");
        return false;
    }

    @Override // ep1.c
    public String b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        return s1.B(2131915344);
    L10:
        return null;
    }

    public e() {
    }

    @Override // ep1.c
    public final int a(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (z.k(r3) == false) goto L5;
    L19:
        boolean r4 = z.e(r3, false);
        int r0 = t.a;
        if ((!r4) == false) goto L22;
        return 2131565410;
    L22:
        return 2131565411;
    L5:
        if (z.g(r3) == true) goto L19;
        if (z.i(r3) == true) goto L19;
        if (z.j(r3) == true) goto L19;
        if (z.h(r3) == true) goto L19;
        if (z.e(r3, false) == false) goto L19;
        if (PadConfigUtils.c() == false) goto L18;
        return 2131565424;
    L18:
        return 2131565423;
    }
}
