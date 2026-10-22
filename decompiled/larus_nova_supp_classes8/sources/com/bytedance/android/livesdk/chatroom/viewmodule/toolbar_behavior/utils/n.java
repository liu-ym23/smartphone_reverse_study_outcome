package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.business.stateservice.api.StateServiceApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ long a;
        public final /* synthetic */ ToolbarBroadcastFunction b;
        public final /* synthetic */ ToolbarBroadcastFunction c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Function0 e;

        public a(long r1, ToolbarBroadcastFunction r3, ToolbarBroadcastFunction r4, Function1 r5, Function0 r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r14, int r15) {
            long r6 = this.a;
            ToolbarBroadcastFunction r16 = this.b;
            ToolbarBroadcastFunction r8 = this.c;
            Function1 r9 = this.d;
            Intrinsics.checkNotNullParameter(r16, "from");
            Intrinsics.checkNotNullParameter(r8, "to");
            Intrinsics.checkNotNullParameter(r9, "switchAction");
            com.bytedance.android.livesdk.service.l.d().getClass();
            ((StateServiceApi) com.bytedance.android.live.network.c.b().e(StateServiceApi.class)).switchFunction("", r6, n.b(r16), n.b(r8)).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(r9, r16, r6), new m(r9, r6, r16, r8));
            r14.dismiss();
            this.e.invoke();
            ToolbarBroadcastFunction r17 = this.b;
            Intrinsics.checkNotNullParameter(r17, "$this$isManagerByOpenPlatform");
            if (r17 != ToolbarBroadcastFunction.MIX_MINI_APP) goto L5;
        L8:
            boolean r18 = true;
        L9:
            if (r18 == false) goto L12;
            jc1.k.n(IInteractGameService.class).stopRunningPlugin("user switch");
            return;
        L12:
            return;
        L5:
            if (r17 == ToolbarBroadcastFunction.MINI_GAME) goto L8;
            r18 = false;
            goto L9
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.invoke();
        }
    }

    public static final p2 a(DataCenter r2) {
        p2 r0 = new p2();
        if (r2 == null) goto L9;
        p2 r3 = (p2) r2.get("data_live_mini_app_commerce_status", r0);
        if (r3 != null) goto L8;
        return r0;
    L8:
        return r3;
    L9:
        return r0;
    }

    public static final String b(ToolbarBroadcastFunction r1) {
        Intrinsics.checkNotNullParameter(r1, "function");
        switch(i.b[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "9";
    L6:
        return "8";
    L7:
        return "7";
    L8:
        return "6";
    L9:
        return LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER;
    L10:
        return "4";
    L11:
        return "2";
    L12:
        return "1";
    L14:
        return "3";
    }

    public static final String c(Context r1, ToolbarBroadcastFunction r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "function");
        switch(i.a[r2.ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L7;
            case 10: goto L17;
            default: goto L5;
        };
    L7:
        return "互动玩法";
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return r1.getString(2131916812);
    L19:
        return r1.getString(2131921194);
    L20:
        return r1.getString(2131916951);
    L21:
        return r1.getString(2131920400);
    L22:
        return r1.getString(2131917222);
    L23:
        return r1.getString(2131923444);
    L24:
        return r1.getString(2131920400);
    L25:
        return r1.getString(2131922964);
    L16:
        return r1.getString(2131915468);
    }

    public static /* synthetic */ void e(Context r9, p2 r10, long r11, ToolbarBroadcastFunction r13, ToolbarBroadcastFunction r14, Function0 r15, Function1 r16) {
        d(r9, r10, r11, r13, r14, r15, r16, ReplaceAnchorFunctionUtilsKt$openReplaceDialog$1.INSTANCE);
    }

    public static final void d(Context r13, p2 r14, long r15, ToolbarBroadcastFunction r17, ToolbarBroadcastFunction r18, Function0<Unit> r19, Function1<? super Boolean, Unit> r20, Function0<Unit> r21) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "curStatus");
        Intrinsics.checkNotNullParameter(r17, "from");
        Intrinsics.checkNotNullParameter(r18, "to");
        Intrinsics.checkNotNullParameter(r19, "activeAction");
        Intrinsics.checkNotNullParameter(r20, "switchAction");
        Intrinsics.checkNotNullParameter(r21, "dismissAction");
        int r2 = p2.q;
        String r3 = "openReplaceDialog: from: " + r17.name() + " to: " + r18.name();
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r14, "status");
        ALogger.d("ToolbarBroadcastStatus", "info: " + r3 + " with status: " + r14);
        ToolbarBroadcastFunction r1 = r14.p;
        Intrinsics.checkNotNullParameter(r1, "$this$isManagerByOpenPlatform");
        if (r1 != ToolbarBroadcastFunction.MIX_MINI_APP) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L17;
        InteractGameContext.Companion r5 = InteractGameContext.Companion;
        if (r5.e() == true) goto L17;
        if (r5.j() == true) goto L17;
        if (r5.d() == true) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L21;
        r19.invoke();
        r20.invoke(Boolean.TRUE);
        return;
    L21:
        String r7 = r13.getString(2131922670, new Object[]{c(r13, r18)});
        String r8 = r13.getString(2131914513, new Object[]{c(r13, r18), c(r13, r17)});
        x0.b r10 = new x0.b(r13, 4);
        x0.d r11 = r10.a;
        r11.l = false;
        r11.c = r7;
        r11.d = r8;
        r10.j(0, r13.getString(2131914512), new a(r15, r17, r18, r20, r19));
        r10.i(1, 2131915442, new b(r21));
        r10.n();
        return;
    L17:
        r6 = false;
        goto L18
    L5:
        if (r1 == ToolbarBroadcastFunction.MINI_GAME) goto L8;
        r4 = false;
        goto L9
    }
}
