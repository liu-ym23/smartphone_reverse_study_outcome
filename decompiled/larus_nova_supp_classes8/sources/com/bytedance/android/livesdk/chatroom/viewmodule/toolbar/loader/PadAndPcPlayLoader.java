package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostMultiDeviceResume;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcLogger;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcTrace;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.PadAndPcPlayBehavior;
import com.bytedance.android.livesdk.m6;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/PadAndPcPlayLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAndPcPlayLoader extends AbsDynamicLoader {
    public final PadAndPcPlayBehavior h;
    public com.bytedance.android.livesdk.castscreen.padandpc.vm.a i;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        boolean r2 = true;
        ExtendedToolbarButton.b r3 = null;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(this.f.a) == false) goto L9;
        ExtendedToolbarButton.a r1 = ExtendedToolbarButton.h;
        ToolbarButton r7 = ToolbarButton.PAD_AND_PC_PLAY;
        r1.getClass();
        ExtendedToolbarButton.b r4 = ExtendedToolbarButton.a.a(r7);
        if (this.d == false) goto L7;
        r4.i.setDrawableFolded(2131251288);
    L44:
        if (r4 == null) goto L47;
        r0.add(r4);
    L47:
        if (LivePadAndPcPlayUtil.h() == true) goto L63;
        DataCenter r5 = this.f.a;
        if (com.bytedance.android.livesdk.castscreen.utils.d.c() == true) goto L51;
    L58:
        if (r2 == true) goto L61;
        r5 = null;
    L61:
        if (r5 == null) goto L76;
        LivePadPcTrace.a(new PadAndPcPlayLoader$configPcAndPcPlayButtonLandScape$$inlined$run$lambda$1(this));
    L77:
        if (r3 == null) goto L79;
        r0.add(r3);
    L79:
        return r0;
    L76:
        ExtendedToolbarButton.a r6 = ExtendedToolbarButton.h;
        ToolbarButton r8 = ToolbarButton.PAD_AND_PC_PLAY_LANDSCAPE;
        r6.getClass();
        r3 = ExtendedToolbarButton.a.a(r8);
        goto L77
    L51:
        if (LivePadAndPcPlayUtil.i(this.a) == false) goto L58;
        if (LivePadAndPcPlayUtil.g(this.a) == false) goto L58;
        if (this.d == false) goto L58;
        r2 = false;
        goto L58
    L63:
        DataCenter r9 = this.f.a;
        if (LivePadAndPcPlayUtil.f() == false) goto L68;
        if (LivePadAndPcPlayUtil.g(this.a) == false) goto L68;
    L70:
        r2 = false;
    L71:
        if (r2 == true) goto L74;
        r9 = null;
    L74:
        if (r9 == null) goto L76;
        LivePadPcTrace.a(new PadAndPcPlayLoader$configPcAndPcPlayButtonLandScape$$inlined$run$lambda$2(this));
    L68:
        if (LivePadAndPcPlayUtil.i(this.a) == true) goto L70;
    L7:
        r4.i.setDrawableFolded(2131251289);
        goto L44
    L9:
        if (LivePadAndPcPlayUtil.h() == true) goto L26;
        DataCenter r10 = this.f.a;
        if (com.bytedance.android.livesdk.castscreen.utils.d.c() == true) goto L13;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        r10 = null;
    L24:
        if (r10 == null) goto L40;
        LivePadPcTrace.a(new PadAndPcPlayLoader$configPcAndPcPlayButton$$inlined$run$lambda$1(this));
    L39:
        r4 = null;
    L40:
        ExtendedToolbarButton.a r12 = ExtendedToolbarButton.h;
        ToolbarButton r13 = ToolbarButton.PAD_AND_PC_PLAY;
        r12.getClass();
        r4 = ExtendedToolbarButton.a.a(r13);
        if (this.d == false) goto L43;
        r4.i.setDrawableFolded(2131251288);
        goto L44
    L43:
        r4.i.setDrawableFolded(2131251289);
        goto L44
    L13:
        if (LivePadAndPcPlayUtil.i(this.a) == false) goto L20;
        if (LivePadAndPcPlayUtil.g(this.a) == false) goto L20;
        if (this.d == false) goto L20;
        r11 = false;
        goto L21
    L26:
        DataCenter r14 = this.f.a;
        if (LivePadAndPcPlayUtil.f() == false) goto L31;
        if (LivePadAndPcPlayUtil.g(this.a) == false) goto L31;
    L33:
        boolean r15 = false;
    L34:
        if (r15 == true) goto L37;
        r14 = null;
    L37:
        if (r14 == null) goto L40;
        LivePadPcTrace.a(new PadAndPcPlayLoader$configPcAndPcPlayButton$$inlined$run$lambda$2(this));
    L31:
        if (LivePadAndPcPlayUtil.i(this.a) == true) goto L33;
        r15 = true;
        goto L34
    }

    public final RoomContext f() {
        return RoomContext.a.c(RoomContext.Companion, this.f.a, 0, 2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        if (PadConfigUtils.a() == false) goto L5;
        return false;
    L5:
        if (z.e(this.f.a, false) == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        boolean r2 = true;
        DataCenter r4 = null;
        if (LivePadAndPcPlayUtil.h() == true) goto L16;
        DataCenter r0 = this.f.a;
        if (LivePadAndPcPlayUtil.g(this.a) == true) goto L7;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L14;
        r4 = r0;
    L14:
        if (r4 == null) goto L27;
        LivePadPcLogger.a("livesdk_screen_share_button_show", this.a, PadAndPcPlayLoader$onShowDialog$2$1.INSTANCE);
        LivePadPcLogger.c("continued_broadcast_button_show", this.a, PadAndPcPlayLoader$onShowDialog$2$2.INSTANCE);
        return;
    L27:
        return;
    L7:
        if (LivePadAndPcPlayUtil.i(this.a) == false) goto L11;
        if (this.d == true) goto L11;
    L16:
        DataCenter r1 = this.f.a;
        if (LivePadAndPcPlayUtil.g(this.a) == false) goto L19;
    L22:
        if (r2 == false) goto L24;
        r4 = r1;
    L24:
        if (r4 == null) goto L29;
        LivePadPcLogger.a("livesdk_screen_share_button_show", this.a, PadAndPcPlayLoader$onShowDialog$4$1.INSTANCE);
        LivePadPcLogger.c("continued_broadcast_button_show", this.a, PadAndPcPlayLoader$onShowDialog$4$2.INSTANCE);
        return;
    L29:
        return;
    L19:
        if (LivePadAndPcPlayUtil.i(this.a) == true) goto L22;
        r2 = false;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        RoomContext r0 = f();
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r1 = null;
        Object r2 = null;
        r1 = null;
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.j r3 = r0.getPadAndPcPlayVm();
        if (r3 == null) goto L18;
        if (r3.getValue() != null) goto L13;
        RoomContext r4 = f();
        if (r4 == null) goto L13;
        com.bytedance.live.datacontext.j r5 = r4.getPadAndPcPlayVm();
        if (r5 == null) goto L13;
        r5.e(new PadAndPcPlayLoader$onLoad$$inlined$let$lambda$1(this));
    L13:
        Object r6 = r3.getValue();
        if ((r6 instanceof com.bytedance.android.livesdk.castscreen.padandpc.vm.a) == false) goto L17;
        r2 = r6;
    L17:
        r1 = (com.bytedance.android.livesdk.castscreen.padandpc.vm.a) r2;
    L18:
        this.i = r1;
        IHostMultiDeviceResume r7 = (IHostMultiDeviceResume) this.h.c.getValue();
        if (r7 == null) goto L23;
        boolean r8 = true;
        if (r7.hostIconEnable() != true) goto L23;
    L24:
        if (r8 == true) goto L26;
        return;
    L26:
        g3 r9 = y3.f(this.a);
        ToolbarButton r10 = ToolbarButton.PAD_AND_PC_PLAY;
        r9.k(r10, this.h);
        if (LivePadAndPcPlayUtil.h() == false) goto L30;
        y3.i(this.a).k(r10, this.h);
    L30:
        if (((Boolean) m6.a.getValue()).booleanValue() == false) goto L33;
        y3.i(this.a).k(ToolbarButton.PAD_AND_PC_PLAY_LANDSCAPE, new PadAndPcPlayBehavior(f(), "landscape_control"));
        return;
    L33:
        return;
    L23:
        r8 = false;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r0 = this.i;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public PadAndPcPlayLoader(e r3) {
        Intrinsics.checkNotNullParameter(r3, "env");
        super(r3);
        this.h = new PadAndPcPlayBehavior(f(), null);
    }
}
