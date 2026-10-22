package x72;

import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements b {
    public final DataCenter a;

    public static final class a {
    }

    static {
    }

    public e(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    @Override // x72.b
    public final boolean a(x72.a r5, k32.a r6) {
        if ((r6 instanceof k32.d) == false) goto L37;
        h3 r7 = ((k32.d) r6).t;
        Integer r8 = null;
        if (r7 == null) goto L9;
        pg.c r9 = r7.M();
        if (r9 == null) goto L9;
        String r10 = r9.getScene();
    L11:
        if (Intrinsics.areEqual(r10, "featured_public_screen") == true) goto L13;
        return false;
    L13:
        if (((Boolean) this.a.get("cmd_selected_message_change_visible_state", Boolean.FALSE)).booleanValue() == true) goto L35;
        Integer r11 = (Integer) this.a.get("data_link_state", 0);
        IInteractivityInjectService r2 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r2 == null) goto L17;
        r8 = r2.getVideoTalkRoomSubScene(null);
    L17:
        if (r11 == null) goto L22;
        if (r11.intValue() != 0) goto L22;
    L23:
        if (r8 != null) goto L26;
    L27:
        if (r8 != null) goto L30;
    L32:
        boolean r13 = false;
    L34:
        if (r13 == false) goto L35;
        return false;
    L30:
        if (r8.intValue() != 8) goto L32;
    L33:
        r13 = true;
        goto L34
    L26:
        if (r8.intValue() == 0) goto L33;
    L22:
        if (v.a(r11.intValue(), 32) == false) goto L32;
    L35:
        return true;
    L9:
        r10 = null;
        goto L11
    L37:
        return false;
    }
}
