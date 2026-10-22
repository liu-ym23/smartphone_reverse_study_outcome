package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarAnchorMiniAppBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarAnchorMiniAppBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData> {
    public View a;
    public final Context b;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            jc1.k.n(IOpenPlatformAnchorService.class).recordSnowFlakeShown();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ToolbarAnchorMiniAppBehavior a;

        public b(ToolbarAnchorMiniAppBehavior r1) {
            this.a = r1;
        }

        public final void a() {
            ToolbarAnchorMiniAppBehavior r0 = this.a;
            String r1 = r0.getContext().getString(2131920398);
            Intrinsics.checkNotNullParameter(r1, "text");
            Context r3 = r0.b;
            if (r3 == null) goto L18;
            c90.a.a r2 = new c90.a.a((Activity) r3);
            r2.a(r1);
            r2.e = 5000;
            c90.a r4 = new c90.a(r2);
            ((LivePopupWindow) r4).b = 1;
            r4.i(r0.a, 48, true);
            IOpenPlatformAnchorService r5 = jc1.k.n(IOpenPlatformAnchorService.class);
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r6 = AnchorMiniAppDataContext.a.a();
            if (r6 == null) goto L14;
            com.bytedance.live.datacontext.n r7 = r6.getShelfInfo();
            if (r7 == null) goto L14;
            ShelfInfo r8 = (ShelfInfo) r7.getValue();
            if (r8 == null) goto L14;
            ShelfMicroAppInfo r9 = r8.appInfo;
            if (r9 == null) goto L14;
            String r10 = r9.appId;
            if (r10 == null) goto L14;
        L15:
            r5.reportBubbleShow(r10, "entrance_change");
            return;
        L14:
            r10 = "";
            goto L15
        L18:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
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

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.b;
    }

    public ToolbarAnchorMiniAppBehavior(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r6) {
        View r7 = this.a;
        if (r7 == null) goto L6;
        r7.post(a.a);
    L6:
        if (ud0.a.getValue().booleanValue() == false) goto L19;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.M3;
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L19;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.n r2 = r1.getShelfInfo();
        if (r2 == null) goto L14;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L15:
        if (r3 != null) goto L19;
        com.bytedance.android.livesdk.sharedpref.f.d(r8, Boolean.FALSE);
        View r9 = this.a;
        if (r9 == null) goto L19;
        r9.post(new b(this));
    L14:
        r3 = null;
    L19:
        HashMap r10 = new HashMap();
        r10.put("_param_for_special", "micro_app");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L27;
        com.bytedance.live.datacontext.m r4 = r0.getRoom();
        if (r4 == null) goto L27;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L27;
        String r11 = String.valueOf(r5.getRoomId());
        if (r11 == null) goto L27;
    L28:
        r10.put("room_id", r11);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tool_bar_mp_icon_show", r10, new Object[0]);
        return;
    L27:
        r11 = "";
        goto L28
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 651156927) goto L12;
        return;
    L12:
        if (r0.equals("open_platform_toolbar_show_tips") == false) goto L21;
        ko0.f r6 = (ko0.f) r5.getData();
        if (r6 == null) goto L25;
        Context r1 = this.b;
        if (r1 == null) goto L20;
        c90.a.a r2 = new c90.a.a((Activity) r1);
        r2.a(r6.a);
        r2.e = r6.b;
        c90.a r3 = new c90.a(r2);
        ((LivePopupWindow) r3).b = r6.c;
        r3.i(this.a, 48, true);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L25:
        return;
    L21:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        jc1.k.n(IOpenPlatformAnchorService.class).clickAnchorToolbarMiniApp();
        HashMap r7 = new HashMap();
        r7.put("_param_for_special", "micro_app");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = String.valueOf(r2.getRoomId());
        if (r3 == null) goto L10;
    L11:
        r7.put("room_id", r3);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tool_bar_mp_icon_click", r7, new Object[0]);
        return;
    L10:
        r3 = "";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.removeObserver(this);
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        HSImageView r4 = r2.findViewById(2131381528);
        if (r4 == null) goto L5;
        r4.setActualImageResource(2131251236);
    L5:
        r3.observe("open_platform_toolbar_show_tips", this);
    }
}
