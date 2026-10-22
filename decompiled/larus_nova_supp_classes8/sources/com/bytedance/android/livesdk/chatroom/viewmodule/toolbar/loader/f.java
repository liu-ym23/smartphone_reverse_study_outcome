package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.app.Application;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.permission.mapping.ToolbarButtonAuthKeyMapping;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.config.cd0;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.h<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> {
    public final ArrayList<a> a;
    public final DataCenter b;
    public final boolean c;

    public interface a {
        boolean a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1, DataCenter r2);

        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1, DataCenter r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e a(a2 r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        int r2 = -1;
        ExtendedToolbarButton r4 = null;
        if ((r9 instanceof ToolbarButton) == false) goto L6;
        ExtendedToolbarButton.h.getClass();
        ExtendedToolbarButton.b r0 = ExtendedToolbarButton.a.a((ToolbarButton) r9);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r5 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r0);
        b(r5, r0);
    L21:
        if (r5 == null) goto L117;
    L26:
        if (r5 == null) goto L28;
        ExtendedToolbarButton r10 = r5.m;
    L30:
        if ((r10 instanceof ExtendedToolbarButton.b) == false) goto L40;
        ExtendedToolbarButton r11 = r5.m;
        if ((r11 instanceof ExtendedToolbarButton.b) == true) goto L34;
        r11 = null;
    L34:
        ExtendedToolbarButton.b r12 = (ExtendedToolbarButton.b) r11;
        if (r12 == null) goto L39;
        ToolbarButton r13 = r12.i;
        if (r13 == null) goto L39;
        r2 = (int) r13.getId();
    L39:
        r5.g = r2;
    L40:
        boolean r3 = false;
        if (cd0.a.getValue().booleanValue() == false) goto L66;
        Map r14 = (Map) ToolbarButtonAuthKeyMapping.a.getValue();
        if (r5 == null) goto L45;
        ToolbarButton r6 = r5.e();
    L46:
        String r15 = (String) r14.get(r6);
        if (r15 != null) goto L49;
    L60:
        if (r5 == null) goto L66;
        int r1 = fp1.a.a;
        lk1.c.a r7 = lk1.c.i2;
        DataCenter r8 = this.b;
        r7.getClass();
        lk1.c r16 = lk1.c.a.a(r8);
        if (r15 != null) goto L64;
        r15 = "";
    L64:
        r5.j = fp1.a.a(r16.getComponentStatus(r15));
        goto L66
    L49:
        if (r15.length() != 0) goto L51;
        boolean r17 = true;
    L52:
        if (r17 != true) goto L60;
        StringBuilder r18 = new StringBuilder();
        if (r5 == null) goto L58;
        ToolbarButton r19 = r5.e();
        if (r19 == null) goto L58;
        String r20 = r19.name();
    L59:
        r18.append(r20);
        r18.append(" is null authKey");
        ALogger.i("MorePanelDataManager", r18.toString());
    L58:
        r20 = null;
        goto L59
    L51:
        r17 = false;
        goto L52
    L45:
        r6 = null;
    L66:
        if (t.a() == false) goto L94;
        if (r5 == null) goto L94;
        if (r5.i != 2) goto L94;
        MorePanelDynamicControllerViewModel.Companion r21 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r22 = this.b;
        r21.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c r23 = MorePanelDynamicControllerViewModel.Companion.a(r22);
        if (r23 == null) goto L94;
        if (r23.needDynamicStatus() != true) goto L94;
        int r24 = fp1.a.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r25 = fp1.a.a(r23.getDynamicStatus(r5));
        if (r25 == null) goto L77;
        r5.j = r25;
    L77:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.f r26 = r23.getServerConfigStyleInfo(r5);
        if (r26 == null) goto L94;
        String r27 = r26.a;
        if (r27 != null) goto L82;
    L87:
        String r28 = r26.b;
        if (r28 == null) goto L94;
        if (r28.length() <= 0) goto L92;
        r3 = true;
    L92:
        if (r3 != true) goto L94;
        r5.f(TTLiveSDK.hostService().hostApp().replaceBrand(r26.b));
        goto L94
    L82:
        if (r27.length() <= 0) goto L84;
        boolean r29 = true;
    L85:
        if (r29 != true) goto L87;
        r5.a = true;
        r5.c = CollectionsKt.arrayListOf(new String[]{r26.a});
        goto L87
    L84:
        r29 = false;
    L94:
        if (r5 == null) goto L109;
        Iterator<a> r30 = this.a.iterator();
    L98:
        if (r30.hasNext() == false) goto L102;
        a r31 = r30.next();
        if (r31.a(r5, this.b) == false) goto L98;
    L103:
        a r32 = r31;
        if (r32 == null) goto L109;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r33 = r32.b(r5, this.b);
        if (r33 == null) goto L109;
        r5 = r33;
        goto L109
    L102:
        r31 = null;
    L109:
        MorePanelButtonLogNameHelper r34 = MorePanelButtonLogNameHelper.b;
        DataCenter r35 = this.b;
        if (r5 == null) goto L112;
        r4 = r5.m;
    L112:
        r34.getClass();
        String r36 = MorePanelButtonLogNameHelper.a(r35, r4);
        if (r36 == null) goto L116;
        if (r5 == null) goto L116;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r5.l = r36;
    L116:
        return r5;
    L28:
        r10 = null;
        goto L30
    L117:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L24
        ALogger.e("MorePanelDataManager", r9 + " convert result is null");     // Catch: Throwable -> L24
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L6:
        if ((r9 instanceof ExtendedToolbarButton.d) == false) goto L9;
        r5 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e((ExtendedToolbarButton) r9);
        ExtendedToolbarButton.d r39 = (ExtendedToolbarButton.d) r9;
        r5.b = r39.i;
        r5.f(r39.q);
        r5.a = true;
        r5.d = true;
        r5.e = r39.t;
        r5.c = r39.p;
        goto L21
    L9:
        if ((r9 instanceof ExtendedToolbarButton.c) == false) goto L12;
        r5 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e((ExtendedToolbarButton) r9);
        ExtendedToolbarButton.c r40 = (ExtendedToolbarButton.c) r9;
        r5.b = r40.i;
        r5.f(r40.q);
        r5.a = true;
        r5.c = r40.p;
        String r41 = r40.l;
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r5.h = r41;
        r5.i = 1;
        goto L21
    L12:
        if ((r9 instanceof ExtendedToolbarButton.b) == false) goto L17;
        r5 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e((ExtendedToolbarButton) r9);
        ExtendedToolbarButton.b r42 = (ExtendedToolbarButton.b) r9;
        b(r5, r42);
        int r43 = r42.d;
        if (r43 == (-1)) goto L21;
        r5.i = r43;
        goto L21
    L17:
        if ((r9 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == false) goto L19;
        r5 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r9;
        goto L21
    L19:
        r5 = null;
        goto L21
    }

    public f(DataCenter r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.c = r3;
        ArrayList<a> r4 = new ArrayList();
        this.a = r4;
        r4.add(new fp1.b(r3));
    }

    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r2, ExtendedToolbarButton.b r3) {
        if (this.c == false) goto L10;
        r2.b = r3.i.getBroadcastDrawableFolded();
        Application r0 = jc1.a.b();
        if (r0 == null) goto L8;
        String r4 = r0.getString(r3.i.getBroadcastTitleId());
        if (r4 == null) goto L8;
    L9:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.f = r4;
        return;
    L8:
        r4 = "";
        goto L9
    L10:
        r2.b = r3.i.getDrawableFolded();
        r2.f(r3.g());
    }
}
