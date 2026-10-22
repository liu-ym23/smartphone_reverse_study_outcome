package com.bytedance.android.live.revlink.impl.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ExtraResponse r12) {
        Intrinsics.checkNotNullParameter(r12, "latestBanRecord");
        Intrinsics.checkNotNullParameter("pk", "banType");
        Activity r3 = vh6.c.b(wh6.a.class).getCurrentActivity();
        int r4 = q.a;
        Intrinsics.checkNotNullParameter(r12, "latestBanRecord");
        Intrinsics.checkNotNullParameter("pk", "banType");
        jy0.b.d("ttlive_anchor_link", "handleBan: " + r12.logId + ' ' + ef2.a.c((vh7.c) r12.data));
        if (r3 == null) goto L83;
        Resources r0 = r3.getResources();
        if (r0 == null) goto L84;
        boolean r5 = true;
        if (((bf2.a) r12.data).isBannedForever() == false) goto L10;
        String r1 = r0.getString(2131918885);
    L18:
        o5 r2 = new o5(r3);
        TextView r6 = r2.b;
        String r7 = null;
        if (r6 == null) goto L25;
        Resources r8 = r3.getResources();
        if (r8 == null) goto L23;
        String r9 = r8.getString(2131921449);
    L24:
        r6.setText(r9);
        goto L25
    L23:
        r9 = null;
    L25:
        TextView r10 = r2.c;
        if (r10 == null) goto L28;
        r10.setText(r1);
    L28:
        TextView r13 = r2.d;
        if (r13 == null) goto L35;
        Resources r14 = r3.getResources();
        if (r14 == null) goto L33;
        String r15 = r14.getString(2131915262);
    L34:
        r13.setText(r15);
        goto L35
    L33:
        r15 = null;
    L35:
        View r16 = r2.a;
        if (r16 == null) goto L38;
        r16.setOnClickListener(new RevLinkBannedUtil$handleBannedSaas$$inlined$apply$lambda$1(r2, r3, r12));
    L38:
        Button r17 = r2.f;
        if (r17 == null) goto L45;
        Resources r18 = r3.getResources();
        if (r18 == null) goto L43;
        String r19 = r18.getString(2131917832);
    L44:
        r17.setText(r19);
        goto L45
    L43:
        r19 = null;
    L45:
        Button r20 = r2.f;
        if (r20 == null) goto L48;
        r20.setOnClickListener(new n(r2));
    L48:
        String r22 = ((bf2.a) r12.data).getAppealUrl();
        if (TextUtils.isEmpty(r22) == false) goto L56;
        Button r23 = r2.g;
        if (r23 == null) goto L53;
        r23.setVisibility(8);
    L53:
        TextView r24 = r2.h;
        if (r24 == null) goto L65;
        r24.setVisibility(8);
    L65:
        String r110 = ((bf2.a) r12.data).getPopupWindowUrl();
        if (r110 != null) goto L68;
    L71:
        if (r5 == true) goto L74;
        vh6.c.b(pq2.a.class).handleSchema(r3, r110);
    L78:
        HashMap r111 = new HashMap();
        r111.put("ban_type", "pk");
        mz0.n r25 = new mz0.n();
        Map<String, String> r26 = r25.a;
        Intrinsics.checkNotNullParameter(r26, "map");
        Intrinsics.checkNotNullParameter(r111, "map");
        r26.putAll(r111);
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((mz0.i) ((f80.a) r113)).w3("audience_ban_feature_disable_popup_show", r25.a, r25.b);
        return;
    L74:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L81;
        DialogLancet.handleBlockedDialogShow(r2);
        goto L78
    L81:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L80
    L77:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L78
    L68:
        if (r110.length() == 0) goto L71;
        r5 = false;
        goto L71
    L56:
        Button r27 = r2.g;
        if (r27 == null) goto L62;
        Resources r28 = r3.getResources();
        if (r28 == null) goto L61;
        r7 = r28.getString(2131917831);
    L61:
        r27.setText(r7);
    L62:
        Button r29 = r2.g;
        if (r29 == null) goto L65;
        r29.setOnClickListener(new o(r2, r22));
        goto L65
    L10:
        StringBuilder r30 = new StringBuilder();
        int r32 = (int) (((((bf2.a) r12.data).getBanTime() - (r12.extra.now / ((long) WebcastRedirectException.UNKNOWN))) + ((bf2.a) r12.data).getBanDuration()) / ((long) 60));
        if (r32 >= 60) goto L14;
        r30.append(r32);
        r30.append(r0.getQuantityString(2131755240, r32));
    L17:
        r1 = r0.getString(2131917791, new Object[]{r30.toString()});
        goto L18
    L14:
        if (r32 >= 1440) goto L16;
        int r33 = r32 / 60;
        r30.append(r33);
        r30.append(r0.getQuantityString(2131755239, r32));
        r30.append(r32 - (r33 * 60));
        r30.append(r0.getQuantityString(2131755240, r32));
        goto L17
    L16:
        r30.append(r32 / 1440);
        r30.append(r0.getQuantityString(2131755238, r32));
        r30.append((r32 % 1440) / 60);
        r30.append(r0.getQuantityString(2131755239, r32));
        goto L17
    L84:
        return;
    }
}
