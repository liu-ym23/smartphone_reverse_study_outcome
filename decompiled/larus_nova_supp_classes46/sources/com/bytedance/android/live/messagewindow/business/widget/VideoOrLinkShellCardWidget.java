package com.bytedance.android.live.messagewindow.business.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/widget/VideoOrLinkShellCardWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoOrLinkShellCardWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public v61.a a;
    public v61.a b;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        v61.a r0 = this.a;
        if (r0 == null) goto L5;
        wq(r0);
    L5:
        v61.a r1 = this.b;
        if (r1 == null) goto L8;
        wq(r1);
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L12;
        r2.removeObserver(this);
        return;
    }

    public VideoOrLinkShellCardWidget() {
    }

    public static void wq(v61.a r1) {
        if (r1.isShowing() == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.dismiss();
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        v61.a r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        if (r1 == null) goto L73;
        int r2 = r1.hashCode();
        if (r2 == (-1130046128)) goto L40;
        if (r2 == (-261927283)) goto L14;
        return;
    L14:
        if (r1.equals("cmd_video_talkroom_state_change") == false) goto L60;
        if (r7 == null) goto L36;
        Object r8 = r7.getData();
        if ((r8 instanceof l3) == true) goto L19;
        r8 = null;
    L19:
        l3 r9 = (l3) r8;
        if (r9 == null) goto L36;
        if (r9.a != 0) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == true) goto L28;
        r9 = null;
    L28:
        if (r9 == null) goto L36;
        v61.a r10 = this.a;
        if (r10 != null) goto L32;
        return;
    L32:
        if ((!r10.isShowing()) == false) goto L34;
        r0 = r10;
    L34:
        if (r0 == null) goto L62;
        r0.show();
        return;
    L62:
        return;
    L24:
        r3 = false;
    L36:
        v61.a r11 = this.a;
        if (r11 == null) goto L64;
        wq(r11);
        Unit r12 = Unit.INSTANCE;
        return;
    L64:
        return;
    L60:
        return;
    L40:
        if (r1.equals("cmd_interact_player_view_change") == false) goto L66;
        if (r7 == null) goto L67;
        Object r13 = r7.getData();
        if ((r13 instanceof kd0.a) == true) goto L45;
        r13 = null;
    L45:
        kd0.a r14 = (kd0.a) r13;
        if (r14 != null) goto L48;
        return;
    L48:
        if (r14.a == false) goto L56;
        v61.a r15 = this.b;
        if (r15 != null) goto L52;
        return;
    L52:
        if ((!r15.isShowing()) == false) goto L54;
        r0 = r15;
    L54:
        if (r0 == null) goto L70;
        r0.show();
        return;
    L70:
        return;
    L56:
        v61.a r16 = this.b;
        if (r16 == null) goto L72;
        wq(r16);
        return;
    L72:
        return;
    L67:
        return;
    L66:
        return;
    L73:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onLoad(Object[] r3) {
        if (v71.a.c() == true) goto L5;
        return;
    L5:
        IMsgWindowService r4 = k.f(IMsgWindowService.class);
        dm0.a r0 = null;
        if (r4 == null) goto L12;
        u61.a r5 = r4.cardBuilder();
        if (r5 == null) goto L12;
        cm0.a r6 = r5.a(new AnonymousClass1(this));
        if (r6 == null) goto L12;
        dm0.a r7 = r6.b();
    L13:
        this.a = r7;
        IMsgWindowService r8 = k.f(IMsgWindowService.class);
        if (r8 == null) goto L20;
        u61.a r9 = r8.cardBuilder();
        if (r9 == null) goto L20;
        cm0.a r10 = r9.a(new AnonymousClass2(this));
        if (r10 == null) goto L20;
        r0 = r10.b();
    L20:
        this.b = r0;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L26;
        DataCenter r12 = r11.observe("cmd_interact_player_view_change", this);
        if (r12 == null) goto L27;
        r12.observe("cmd_video_talkroom_state_change", this);
        return;
    L27:
        return;
    L26:
        return;
    L12:
        r7 = null;
        goto L13
    }
}
