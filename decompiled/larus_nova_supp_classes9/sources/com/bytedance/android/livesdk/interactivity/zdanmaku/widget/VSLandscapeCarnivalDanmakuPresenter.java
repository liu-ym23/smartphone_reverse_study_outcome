package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSLandscapeCarnivalDanmakuPresenter extends CarnivalDanmakuPresenter {
    public boolean w;
    public boolean x;
    public final VSLandscapeCarnivalDanmakuPresenter$cacheMessage$1 y;
    public final a z;

    public static final class a extends com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.e {
        public final k f;
        public final /* synthetic */ VSLandscapeCarnivalDanmakuPresenter g;

        @Override // r22.a
        public final r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> g() {
            return this.f;
        }

        public a(VSLandscapeCarnivalDanmakuPresenter r1, b r2, BarrageWidgetContext r3) {
            this.g = r1;
            super(r2, r3);
            this.f = new k(this);
        }
    }

    public static final class b implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            CarnivalDanmakuPresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.f) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public b(VSLandscapeCarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            CarnivalDanmakuPresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, r4.isSelfSendFake());
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter
    public final void q0() {
        boolean r0 = true;
        this.w = true;
        Iterator<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        o0(r1.next());
        goto L4
    L6:
        clear();
        int r2 = a1.a;
        if (a1.a.a().d() == false) goto L22;
        o r3 = m0();
        if (r3 != null) goto L11;
    L16:
        if (r0 == true) goto L23;
        CarnivalDanmakuPresenter.IView r4 = ((q46.b) this).a;
        if (r4 == null) goto L24;
        r4.Q7();
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if (r3.isVSFirstShow() != true) goto L16;
        if (com.bytedance.android.livesdk.interactivity.common.utils.f.c(((n) this).c) == true) goto L16;
        r0 = false;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter
    public final void detachView() {
        super.detachView();
        clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.e k0() {
        return this.z;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.livesdk.interactivity.zdanmaku.widget.VSLandscapeCarnivalDanmakuPresenter$cacheMessage$1] */
    public VSLandscapeCarnivalDanmakuPresenter(BarrageWidgetContext r3) {
        super(r3);
        int r0 = a1.a;
        if (a1.a.a().d() == false) goto L9;
        BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
        if (r1 == null) goto L9;
        if (r1.isCarnivalBarrageOpen() == true) goto L9;
        boolean r2 = true;
    L10:
        this.x = r2;
        final int r4 = 30;
        this.y = new VSLandscapeCarnivalDanmakuPresenter$cacheMessage$1(r4);
        this.z = new a(this, new b(this), r3);
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter
    public final void g0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        Intrinsics.checkNotNullParameter(r3, "chatMessage");
        if (this.e.controlEnable.booleanValue() == false) goto L8;
        if (((LinkedList) this.j).size() < this.e.messageListSizeThreshold) goto L8;
        return;
    L8:
        if (r3.isSelfSendFake() == false) goto L10;
        ListProtector.add(this.j, 0, r3);
        return;
    L10:
        ((LinkedList) this.j).add(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter
    public final void onMessage(tlc.d r3) {
        if (this.x == false) goto L6;
        return;
    L6:
        if ((r3 instanceof t) == true) goto L8;
        r3 = null;
    L8:
        t r4 = (t) r3;
        if (r4 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r4.getMessageMethod(), "WebcastChatMessage") == false) goto L19;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r4);
        if (this.w == false) goto L16;
        o0(r5);
        return;
    L16:
        if (r5 == null) goto L21;
        add(r5);
        return;
    L21:
        return;
    }
}
