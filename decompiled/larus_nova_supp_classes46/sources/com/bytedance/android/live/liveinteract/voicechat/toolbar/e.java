package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.util.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements c0.b {
    public View a;
    public boolean b;
    public IRoom c;
    public final CompositeDisposable d;
    public final String e;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void a() {
            i0 r0 = TalkRoomLogUtils.a;
            TalkRoomLogUtils.o1(this.a.e);
            li0.b r1 = li0.b.b;
            String r2 = this.a.e;
            Intrinsics.checkNotNullParameter("grouppk_icon", "requestPage");
            Intrinsics.checkNotNullParameter(r2, "source");
            LinkedHashMap r3 = new LinkedHashMap();
            TalkRoomLogUtils.B0(r3, null, null, 6);
            r3.put("request_page", "grouppk_icon");
            TalkRoomLogUtils.i1(r3);
            r3.put("source", r2);
            j0.l().sendLog("livesdk_grouppk_icon_show", r3, new Object[]{IRoom.class});
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public e() {
        this.d = new CompositeDisposable();
        this.e = OpenPanelSource.PK_ICON.getValue();
    }

    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        com.bytedance.android.live.liveinteract.revenue.fight.b r6 = ((IInteractService) k.n(IInteractService.class)).teamFightService();
        if (r6 == null) goto L6;
        r6.d0(mi0.g.b, new mi0.b("grouppk_icon", this.e));
        return;
    }

    public final void setAlpha(float r2) {
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d.clear();
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        r2.getContext();
        this.b = a0.m(r3).c;
        this.c = a0.n(r3);
        if (this.b == true) goto L5;
        return;
    L5:
        View r4 = this.a;
        if (r4 == null) goto L9;
        r4.post(new a(this));
        return;
    }
}
