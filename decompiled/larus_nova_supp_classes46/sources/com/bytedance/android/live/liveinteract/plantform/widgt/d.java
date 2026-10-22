package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public d(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r9;
        Intrinsics.checkNotNullParameter(r10, "event");
        ALogger.i("AudioSceneBasicBusinessContentWidget", "onSceneEvent.curScene:" + this.a.j + ",eventScene:" + r10.a + ",uiLayout:" + r10.b);
        if (((Widget) this.a).dataCenter.get("cmd_stop_live_broadcast") != null) goto L64;
        AudioSceneBasicBusinessContentWidget r0 = this.a;
        if (r0.j == r10.a) goto L54;
        IRoom r1 = r0.e;
        Integer r2 = null;
        if (r1 == null) goto L10;
        py.k r3 = r1.getBackground();
    L11:
        if (r3 == null) goto L14;
    L53:
        this.a.j = r10.a;
        goto L54
    L14:
        if (r0.j != (-1)) goto L38;
        int r4 = r10.a;
        if (r4 == 0) goto L25;
        if (r4 == 5) goto L24;
        if (r4 == 9) goto L21;
        int r5 = 0;
    L26:
        x00.c r6 = r0.d;
        if (r6 == null) goto L29;
        r2 = Integer.valueOf(r6.e());
    L29:
        if (r2 != null) goto L32;
    L33:
        if (r2 == null) goto L53;
        if (r2.intValue() == r5) goto L38;
    L32:
        if (r2.intValue() == 0) goto L38;
    L21:
        if (r0.zq() == false) goto L23;
        r5 = 100;
        goto L26
    L23:
        r5 = 1;
        goto L26
    L24:
        r5 = 2;
        goto L26
    L25:
        r5 = 5;
    L38:
        x00.b r7 = r0.b;
        if (r7 == null) goto L46;
        if (r7.isShowing() != true) goto L46;
        x00.b r8 = r0.b;
        if (r8 == null) goto L46;
        r8.dismiss();
    L46:
        if (r10.a == 9) goto L53;
        if (r0.Bq() == false) goto L53;
        x00.c r11 = r0.d;
        if (r11 == null) goto L53;
        r11.h(2);
        goto L53
    L10:
        r3 = null;
    L54:
        AudioSceneBasicBusinessContentWidget r12 = this.a;
        if (r12.k != r10.b) goto L57;
        return;
    L57:
        if (r12.j != 5) goto L61;
        View r13 = ((Widget) r12).contentView;
        if (r13 == null) goto L61;
        r13.post(new n(r12));
    L61:
        this.a.k = r10.b;
        return;
    }
}
