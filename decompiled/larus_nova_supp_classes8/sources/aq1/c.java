package aq1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.VSRoomLandscapeResetPlayerViewWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends n<d> {
    public static final a c = null;

    public static final class a {
        public a() {
        }

        public static boolean a(DataCenter r7) {
            if (PadConfigUtils.c() == true) goto L17;
            IRoom r3 = null;
            u r0 = r.u(r7, null, 2);
            if (r0 == null) goto L8;
            r3 = r0.k2();
        L8:
            if (r3 == null) goto L17;
            if (r3.isVsLive() != true) goto L17;
            IRoomAuthStatus r1 = r3.getRoomAuthStatus();
            if (r1 == null) goto L17;
            if (r1.getVideoAmplificationType() != 1) goto L17;
            boolean r2 = true;
        L18:
            if (r2 == true) goto L21;
            return false;
        L21:
            if (gb2.a.c(r7, true) == true) goto L26;
            if (r7 == null) goto L26;
            if (h.c(r7) != true) goto L26;
            return true;
        L26:
            return false;
        L17:
            r2 = false;
            goto L18
        }
    }

    public final boolean h() {
        return true;
    }

    static {
        c = new a();
    }

    public c() {
    }

    public final Class<? extends Widget> c() {
        return VSRoomLandscapeResetPlayerViewWidget.class;
    }

    public final boolean B(h70.b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        a r0 = c;
        DataCenter r4 = r3.h;
        r0.getClass();
        return a.a(r4);
    }

    public final f C(h70.b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.t2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        return LayerIndex.INDEX_4;
    }

    public final ElementConstraint J(h70.b r8) {
        d r9 = (d) r8;
        Intrinsics.checkNotNullParameter(r9, "layerContext");
        ElementConstraint r0 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.LEFT;
        r9.f.getClass();
        f r2 = d.a.D;
        ElementConstraint.Side r3 = ElementConstraint.Side.RIGHT;
        r0.b(r1, r2, r3, 0.0f);
        ElementConstraint.Side r4 = ElementConstraint.Side.BOTTOM;
        r9.f.getClass();
        r0.b(r4, d.a.f1, r4, 17.0f);
        r9.f.getClass();
        r0.b(r3, d.a.z, r1, 0.0f);
        return r0;
    }
}
