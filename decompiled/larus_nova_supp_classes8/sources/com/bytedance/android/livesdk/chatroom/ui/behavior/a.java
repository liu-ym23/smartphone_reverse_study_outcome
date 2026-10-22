package com.bytedance.android.livesdk.chatroom.ui.behavior;

import am2.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends e5 {
    public final Lazy D;
    public final Room E;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.behavior.a$a, reason: collision with other inner class name */
    public static final class C0014a<T> implements Consumer {
        public final /* synthetic */ View a;

        public C0014a(View r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            View r0 = this.a.findViewById(2131374718);
            if (r0 == null) goto L6;
            r0.setBackground(new BitmapDrawable(this.a.getResources(), r5));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            x8.a.b("ToolbarLandscapeShareBehavior", "load remote img error", false);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.u;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5, android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (((ToolbarComponentData) this.D.getValue()) == null) goto L5;
    L20:
        super.onClick(r7);
        return;
    L5:
        if (this.f.isVSRoom() == true) goto L20;
        if (m50.a.getValue().o() == true) goto L20;
        DataCenter r8 = this.i;
        if (r8 == null) goto L19;
        IAbilityCenter r9 = a0.a(r8);
        if (r9 == null) goto L19;
        IRoomRecordService r10 = r9.getAbility(IRoomRecordService.class);
        if (r10 == null) goto L19;
        if (r10.isRecording() != true) goto L19;
        f2.b(2131921971, 0);
        return;
    L19:
        g r11 = u.l();
        Map r2 = MapsKt.emptyMap();
        x r4 = new x();
        r4.a = "live";
        r4.e = "click";
        r4.b = "live_detail";
        r11.sendLog("livesdk_live_click_share_button", r2, new Object[]{r4, Room.class});
        u.h = "0";
        j0.d = "0";
        HorizontalPlayEvent r12 = new HorizontalPlayEvent(1, "source_for_share_request_landscape");
        r12.rotationType = 1;
        xs2.b.a().post(r12);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.i = r6;
        this.f = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (((ToolbarComponentData) this.D.getValue()) == null) goto L12;
        ToolbarComponentData r7 = (ToolbarComponentData) this.D.getValue();
        if (r7 == null) goto L20;
        r5.setBackground(null);
        View r1 = r5.findViewById(2131374718);
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131251128);
    L9:
        ImageModel r8 = r7.getIcon();
        if (r8 == null) goto L21;
        a1.k(r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0014a(r5), b.a);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        RoomContext r9 = this.f;
        if (r9 != null) goto L15;
        return;
    L15:
        if (r9.isVSRoom() != true) goto L24;
        r5.setBackground(null);
        View r10 = r5.findViewById(2131374718);
        if (r10 == null) goto L25;
        r10.setBackgroundResource(2131251128);
        return;
    L25:
        return;
    }

    public a(Context r7, Room r8, FragmentActivity r9, f r10, DataCenter r11, RoomContext r12) {
        Intrinsics.checkNotNullParameter(r10, "userCenter");
        super(r7, r9, r10, r12, r11);
        this.E = r8;
        this.D = LazyKt.lazy(new ToolbarLandscapeShareBehavior$mShareData$2(this));
    }
}
