package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.TicketPriceInputDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openTicketPriceInputPanel")
public final class i9 extends w20.u4<w20.tc, w20.uc> implements TicketPriceInputDialogFragment.b {
    public static boolean a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        a = false;
    }

    public final void onTerminate() {
    }

    public i9() {
    }

    public final void f(String r3, boolean r4) {
        ALogger.i("OpenTicketPriceInputPanelMethod", "on input finish: input " + r3 + ", is recommend price " + r4);
        w20.uc r0 = new w20.uc();
        r0.a(1);
        w20.uc.a r1 = new w20.uc.a();
        r1.a(r3);
        r1.b(Boolean.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
    }

    public final void invoke(Object r7, CallContext r8) {
        w20.tc r9 = (w20.tc) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        ALogger.i("OpenTicketPriceInputPanelMethod", "invoke: is input panel already open " + a);
        if (a == true) goto L42;
        TicketPriceInputDialogFragment r0 = new TicketPriceInputDialogFragment();
        String r11 = GsonProtectorUtils.toJson(GsonHelper.get(), r9);
        r0.j = this;
        Gson r2 = GsonHelper.get();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        TicketPriceInputDialogFragment.c r12 = (TicketPriceInputDialogFragment.c) GsonProtectorUtils.fromJson(r2, r11, TicketPriceInputDialogFragment.c.class);
        FragmentActivity r3 = null;
        if (r12 == null) goto L10;
        String r4 = r12.b();
    L12:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        if (r12 == null) goto L15;
        String r5 = r12.b();
    L16:
        r0.h = r5;
        goto L17
    L15:
        r5 = null;
    L17:
        List r6 = CollectionsKt.mutableListOf(new String[]{"recommend_price_tag"});
        r0.i = r6;
        if (r6 == null) goto L25;
        if (r12 == null) goto L23;
        List r13 = r12.a();
        if (r13 == null) goto L23;
    L24:
        r6.addAll(r13);
    L23:
        r13 = CollectionsKt.emptyList();
    L25:
        FragmentActivity r14 = r8.getContext();
        ALogger.i("TicketPriceInputDialogFragment", "show dialog " + r0.hashCode() + ", context " + r14);
        if ((r14 instanceof FragmentActivity) == false) goto L29;
        r3 = r14;
    L29:
        FragmentActivity r15 = r3;
        if (r15 == null) goto L37;
        FragmentManager r16 = r15.getSupportFragmentManager();
        String r17 = r0.getTag();
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r17, r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r0, r18) == false) goto L40;
    L36:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_price_filling_shortcut_panel_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from_merge", "direct_shoot"), TuplesKt.to("live_type", "video_live")}), new Object[]{Room.class});
        goto L37
    L40:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L35:
        r0.show(r16, r17);
    L37:
        ALogger.i("OpenTicketPriceInputPanelMethod", "invoke: show input price dialog fragment " + r0.hashCode());
        a = true;
        return;
    L10:
        r4 = null;
        goto L12
    }
}
