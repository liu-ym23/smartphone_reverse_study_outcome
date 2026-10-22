package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livesdk.widget.x0;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ OpenPlatformContext b;

        public a(Function0 r1, OpenPlatformContext r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            this.a.invoke();
            r3.dismiss();
            OpenPlatformContext r5 = this.b;
            if (r5 == null) goto L8;
            AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
            if (r6 == null) goto L9;
            HashMap<String, String> r7 = new HashMap();
            r7.put("screen_split_rate", "0.3");
            r7.put("click_type", "exit");
            Unit r0 = Unit.INSTANCE;
            r6.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_click", r7);
            return;
        L9:
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ OpenPlatformContext a;

        public b(OpenPlatformContext r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            r3.dismiss();
            OpenPlatformContext r5 = this.a;
            if (r5 == null) goto L8;
            AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
            if (r6 == null) goto L9;
            HashMap<String, String> r7 = new HashMap();
            r7.put("screen_split_rate", "0.3");
            r7.put("click_type", "cancel");
            Unit r0 = Unit.INSTANCE;
            r6.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_click", r7);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public static String a(String r2) {
        if (r2 == null) goto L20;
        int r0 = r2.hashCode();
        if (r0 == (-1768820280)) goto L18;
        if (r0 == (-1659249440)) goto L15;
        if (r0 != (-906336856)) goto L20;
        if (r2.equals("search") == false) goto L20;
        return "function_panel_search";
    L15:
        if (r2.equals("use_recently") == false) goto L20;
        return "function_panel_recently";
    L18:
        if (r2.equals("game_tab") == false) goto L20;
        return "function_panel_microgame";
    L20:
        return "";
    }

    public static boolean b(Context r2) {
        if ((r2 instanceof Activity) == false) goto L10;
        Activity r3 = (Activity) r2;
        if (r3.isFinishing() == false) goto L7;
        return false;
    L7:
        if (r3.isDestroyed() == true) goto L20;
        return true;
    L20:
        return false;
    L10:
        if ((r2 instanceof ContextWrapper) == false) goto L21;
        Context r4 = ((ContextWrapper) r2).getBaseContext();
        if ((r4 instanceof Activity) == false) goto L22;
        Activity r5 = (Activity) r4;
        if (r5.isFinishing() == false) goto L16;
        return false;
    L16:
        if (r5.isDestroyed() == true) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public static void c(Context r3, OpenPlatformContext r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "onConfirm");
        x0.b r0 = new x0.b(r3, 4);
        x0.d r6 = r0.a;
        r6.k = false;
        r6.l = false;
        r0.l(2131920986);
        r0.i(0, 2131920984, new a(r5, r4));
        r0.i(1, 2131920982, new b(r4));
        r0.k(0, true);
        r0.n();
        if (r4 == null) goto L8;
        AnchorMiniGameAppLogContextService r7 = (AnchorMiniGameAppLogContextService) r4.getService(AnchorMiniGameAppLogContextService.class);
        if (r7 == null) goto L9;
        HashMap<String, String> r8 = new HashMap();
        r8.put("screen_split_rate", "0.3");
        Unit r9 = Unit.INSTANCE;
        r7.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_show", r8);
        return;
    L9:
        return;
    }
}
