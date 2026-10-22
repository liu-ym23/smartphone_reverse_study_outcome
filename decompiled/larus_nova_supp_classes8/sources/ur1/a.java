package ur1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.utils.w1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_impl.widget.BusinessScreenBarWidget;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import h70.b;
import j70.f;
import j70.g;
import j70.n;
import kotlin.jvm.internal.Intrinsics;
import xs1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends n<d> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return BusinessScreenBarWidget.class;
    }

    public final boolean B(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (w1.d(r3) == true) goto L5;
    L9:
        return false;
    L5:
        if (jr1.a.c(r3) == true) goto L9;
        if (((e) VSSettingKeys.LIVE_BUSINESS_INFORMATION_CONFIG.getValue()).c() == false) goto L9;
        return true;
    }

    public final f C(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.Y0;
    }

    public final LayerIndex E(b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        return LayerIndex.INDEX_0;
    }

    public final ElementConstraint J(b r6) {
        d r7 = (d) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        if (w1.c(r7) == false) goto L6;
        ElementConstraint r0 = new ElementConstraint(-1.0f, 0.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.TOP;
        r7.f.getClass();
        g r3 = d.a.f1;
        r0.b(r1, r3, r1, 0.0f);
        ElementConstraint.Side r2 = ElementConstraint.Side.BOTTOM;
        r7.f.getClass();
        r0.b(r2, r3, r2, 0.0f);
        return r0;
    L6:
        if (PadConfigUtils.c() == false) goto L8;
        ElementConstraint r4 = new ElementConstraint(0.0f, -1.0f);
        ElementConstraint.Side r5 = ElementConstraint.Side.LEFT;
        r7.f.getClass();
        g r8 = d.a.f1;
        r4.b(r5, r8, r5, 0.0f);
        ElementConstraint.Side r9 = ElementConstraint.Side.RIGHT;
        r7.f.getClass();
        r4.b(r9, r8, r9, 0.0f);
        ElementConstraint.Side r10 = ElementConstraint.Side.TOP;
        r7.f.getClass();
        r4.b(r10, r8, r10, 0.0f);
        ElementConstraint.Side r11 = ElementConstraint.Side.BOTTOM;
        r7.f.getClass();
        r4.b(r11, r8, r11, 0.0f);
        return r4;
    L8:
        ElementConstraint r12 = new ElementConstraint(0.0f, -1.0f);
        ElementConstraint.Side r13 = ElementConstraint.Side.LEFT;
        r7.f.getClass();
        g r14 = d.a.f1;
        r12.b(r13, r14, r13, 0.0f);
        ElementConstraint.Side r15 = ElementConstraint.Side.RIGHT;
        r7.f.getClass();
        r12.b(r15, r14, r15, 0.0f);
        return r12;
    }
}
