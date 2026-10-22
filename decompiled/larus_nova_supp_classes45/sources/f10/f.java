package f10;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonDot;
import com.bytedance.android.livesdkapi.depend.model.broadcast.InteractionItemDotInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemDotInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends ExtendedToolbarButton.c {
    public boolean A;
    public int B;
    public CharSequence C;
    public InteractEntranceCell D;
    public final List<v> E;
    public k0 F;
    public boolean t;
    public boolean u;
    public boolean v;
    public final String w;
    public int x;
    public final int y;
    public final ItemDotInfo z;

    public final String h() {
        ItemDotInfo r0 = this.z;
        if (r0 == null) goto L7;
        CommonDot r1 = r0.getDot();
        if (r1 == null) goto L7;
        return String.valueOf(r1.getId());
    L7:
        return null;
    }

    public final boolean k() {
        boolean r1 = true;
        if (((ExtendedToolbarButton.c) this).r == true) goto L25;
        g3 r2 = null;
        if (this.z == null) goto L11;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        ItemDotInfo r0 = this.z;
        if (r0 == null) goto L24;
        r0.getDot();
        throw null;
    L24:
        throw null;
    L11:
        g3 r3 = y3.e();
        if ((r3 instanceof x3) == false) goto L15;
        r2 = r3;
    L15:
        if (r2 == null) goto L21;
        c0.b r4 = r2.s(this);
        if (r4 == null) goto L21;
        if (r4.showRedDot() != true) goto L21;
    L23:
        return r1;
    L21:
        r1 = false;
        goto L23
    L25:
        return !h3.a(((ExtendedToolbarButton.c) this).q);
    }

    public final boolean j() {
        x3 r0 = y3.e();
        if ((r0 instanceof x3) == true) goto L5;
        r0 = null;
    L5:
        if (r0 != null) goto L9;
        return false;
    L9:
        return r0.x(this);
    }

    public final String i(boolean r4) {
        String r0 = ((ExtendedToolbarButton.c) this).q;
        if (r4 == true) goto L5;
        return r0;
    L5:
        if (r0.length() >= (this.y + 1)) goto L7;
        return r0;
    L7:
        return r0.substring(0, this.y) + "...";
    }

    public f(List r2, String r3, boolean r4, String r5, CharSequence r6, InteractEntranceCell r7, List r8, k0 r9) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "summary");
        Intrinsics.checkNotNullParameter(r7, "targetEntranceCell");
        super(r2, r3, r4, r5);
        this.C = r6;
        this.D = r7;
        this.E = r8;
        this.F = r9;
        this.t = true;
        this.w = "";
        this.x = 1;
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L5;
        int r11 = 5;
    L6:
        this.y = r11;
        this.A = true;
        this.B = -1;
        ((ExtendedToolbarButton.c) this).i = 2131252504;
        String r12 = this.D.extra;     // Catch: Exception -> L20
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.length() <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r13 != true) goto L24;
        InteractionItemDotInfo r14 = (InteractionItemDotInfo) GsonHelper.get().fromJson(this.D.extra, InteractionItemDotInfo.class);     // Catch: Exception -> L20
        if (r14 == null) goto L17;
        ItemDotInfo r15 = r14.getItemDot();     // Catch: Exception -> L20
    L18:
        this.z = r15;     // Catch: Exception -> L20
        return;
    L17:
        r15 = null;
        goto L18
    L24:
        return;
    L12:
        r13 = false;
    L25:
        return;
    L5:
        r11 = 4;
        goto L6
    }
}
