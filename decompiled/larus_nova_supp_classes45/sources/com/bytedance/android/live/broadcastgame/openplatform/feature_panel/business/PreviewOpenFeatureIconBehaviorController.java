package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import a20.m;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.j0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.PreviewOpenFeaturePanelViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PreviewOpenFeatureIconBehaviorController extends a<PreviewOpenFeaturePanelViewModel> {
    public final Lazy b;
    public final PreviewOpenFeaturePanelViewModel c;

    public PreviewOpenFeatureIconBehaviorController(PreviewOpenFeaturePanelViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.c = r2;
        this.b = InfraKotlinExtsKt.mainThreadLazy(PreviewOpenFeatureIconBehaviorController$previewToolbarBehaviorProvider$2.INSTANCE);
    }

    @Override // a20.e
    public final void b(View r5, f10.f r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "icon");
        String r8 = r6.D.extra;
        if (r8 != null) goto L5;
    L11:
        String r9 = "";
    L12:
        int r0 = n.a;
        InteractEntranceCell r1 = r6.D;
        n.g(r9, n.l(r1.groupType, r1.d, false), false, r6.D.g(), Integer.valueOf(r7));
        return;
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L11;
        r9 = new JSONObject(r8).optString(OpenPlatformBaseDebugger.APP_ID);
        if (r9 != null) goto L12;
        goto L11
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a
    public final f10.f f(InteractEntranceCell r15, boolean r16, int r17) {
        Intrinsics.checkNotNullParameter(r15, "data");
        String r11 = r15.h();
        ImageModel r0 = r15.icon;
        j0 r1 = null;
        if (r0 == null) goto L5;
        List<String> r2 = r0.getUrls();
    L6:
        List<String> r3 = r2;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L20;
        ImageModel r5 = r15.icon;
        if (r5 == null) goto L20;
        List<String> r6 = r5.getUrls();
        if (r6 == null) goto L20;
    L21:
        List<String> r7 = r6;
        String r8 = r15.title;
        r r9 = r15.e();
        if (r9 == null) goto L24;
        r1 = r9.B();
    L24:
        if (r1 == null) goto L49;
        r r12 = r15.e();
        if (r12 == null) goto L30;
        j0 r13 = r12.B();
        if (r13 == null) goto L30;
        boolean r14 = r13.c();
    L31:
        if (r14 == false) goto L49;
        long r18 = a.d();
        r r19 = r15.e();
        if (r19 == null) goto L37;
        j0 r21 = r19.B();
        if (r21 == null) goto L37;
        long r22 = r21.b();
    L39:
        if (r18 <= r22) goto L49;
        long r23 = a.d();
        r r24 = r15.e();
        if (r24 == null) goto L45;
        j0 r25 = r24.B();
        if (r25 == null) goto L45;
        long r26 = r25.a();
    L47:
        if (r23 >= r26) goto L49;
        boolean r27 = true;
    L50:
        String r28 = r15.desc;
        if (r28 != null) goto L53;
        String r29 = "";
    L54:
        f10.f r110 = new f10.f(r7, r8, r27, r11, r29, r15, new ArrayList(), null);
        r110.t = r16;
        ((ExtendedToolbarButton.c) r110).j = r15.groupType;
        ((ExtendedToolbarButton) r110).a = 0;
        ((ExtendedToolbarButton.c) r110).k = r15.interactType;
        r110.u = this.c.getFeatureIconRunningStateManager().a(r11, false);
        r110.v = r15.f();
        r110.x = r17;
        return r110;
    L53:
        r29 = r28;
    L45:
        r26 = -1;
    L37:
        r22 = Long.MAX_VALUE;
    L30:
        r14 = false;
    L49:
        r27 = false;
    L20:
        r6 = CollectionsKt.listOf("");
        goto L21
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a
    public final void e(View r3, f10.f r4, int r5, m r6) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "icon");
        f10.e r7 = (f10.e) ((k) this.b.getValue()).a(r4.D, null);
        if (r7 == null) goto L5;
        r7.a(r3, r4, r5);
    L7:
        if (r4.x != 2) goto L10;
        j r8 = this.c.getOpenFeatureSearchPageCacheHelper();
        InteractEntranceCell r9 = r4.D;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "cell");
        ((ArrayList) r8.a).add(r9);
        return;
    L10:
        return;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("behavior 为null，无法点击");
        goto L7
    }
}
