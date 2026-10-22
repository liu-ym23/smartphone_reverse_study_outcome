package z92;

import am2.x;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.hover.HoverMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import u42.e;
import u42.h;
import u42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements u42.b {
    public final PublicScreenPinType a;
    public final int b;
    public Long c;
    public f<?> d;
    public boolean e;
    public final boolean f;
    public final a g;

    @Override // u42.b
    public final void b() {
        this.e = true;
    }

    @Override // u42.b
    public final long h() {
        Long r0 = this.c;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (((((long) u42.d.d) * 1000) - (SystemClock.elapsedRealtime() - r0.longValue())) >= 3000) goto L7;
        return -1;
    L7:
        return ((long) u42.d.c) * 1000;
    }

    @Override // u42.b
    public final boolean a() {
        return this.e;
    }

    @Override // u42.b
    public final boolean e() {
        return this.f;
    }

    @Override // u42.b
    public final f<?> getMessage() {
        return this.d;
    }

    @Override // u42.b
    public final int getPriority() {
        return this.b;
    }

    @Override // u42.b
    public final Long getShowTimestamp() {
        return this.c;
    }

    @Override // u42.b
    public PublicScreenPinType getType() {
        return this.a;
    }

    public b(a r3) {
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        this.g = r3;
        this.a = PublicScreenPinType.HOVER_MESSAGE;
        this.b = r3.k.K0();
        int r1 = com.bytedance.android.livesdk.interactivity.publicscreen.framework.b.a;
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        this.d = new z(new com.bytedance.android.livesdk.interactivity.publicscreen.framework.a(), r3);
        this.f = true;
    }

    @Override // u42.b
    public final void c(e r7) {
        Intrinsics.checkNotNullParameter(r7, "pinContext");
        u42.f.a("ConsumptionProposePinHandler onPin");
        View r0 = r7.b;
        TextView r1 = (TextView) r0.findViewById(2131388772);
        if (r1 != null) goto L5;
        return;
    L5:
        TextView r2 = (TextView) r0.findViewById(2131387553);
        if (r2 != null) goto L8;
        return;
    L8:
        HSImageView r3 = r0.findViewById(2131376297);
        if (r3 != null) goto L11;
        return;
    L11:
        HoverMessageViewHolder.a r4 = HoverMessageViewHolder.e;
        a r5 = this.g;
        r4.getClass();
        HoverMessageViewHolder.a.a(r0, r1, r2, r3, r5);
        DataCenter r8 = r7.c;
        if (Intrinsics.areEqual(this.g.k.getScene(), "consumption_manager_hover") == false) goto L15;
        HashMap r6 = new HashMap();
        r6.put("anchor_id", a0.n(r8).getOwnerUserIdString());
        r6.put("channel_type", "common_screen");
        j0.l().sendLog("livesdk_consumer_assistant_animation_show", r6, new Object[]{IRoom.class, x.class});
        return;
    }

    @Override // u42.b
    public final void d(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // u42.b
    public final void f(h r2) {
        Intrinsics.checkNotNullParameter(r2, "unpinContext");
        u42.f.a("ConsumptionProposePinHandler onUnpin");
    }

    @Override // u42.b
    public final void g(Long r1) {
        this.c = r1;
    }

    @Override // u42.b
    public final View i(com.bytedance.android.livesdk.interactivity.publicscreen.pin.c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r5 = r4.a(2131566775);
        f<?> r0 = this.d;
        e52.a r1 = null;
        j<l> r2 = m.a(null);
        if (r2 == null) goto L7;
        l r3 = (l) r2.getValue();
        if (r3 == null) goto L7;
        r1 = r3.getTextConfig();
    L7:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(r5, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(false, r0, r1));
        return r5;
    }

    @Override // u42.b
    public final long j(i r3) {
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        return 0;
    }
}
