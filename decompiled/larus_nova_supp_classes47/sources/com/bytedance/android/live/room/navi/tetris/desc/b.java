package com.bytedance.android.live.room.navi.tetris.desc;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.tetris.AudienceRoomNavigatorTetris;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.ViewConfig;
import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponentProvider;
import com.bytedance.live.datacontext.n;
import j70.f;
import j70.j;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import l81.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends j<d90.d> {

    public static final class a {
    }

    static {
    }

    public final Tetris<? extends h70.b> b() {
        return new AudienceRoomNavigatorTetris();
    }

    public b() {
    }

    public final boolean B(h70.b r4) {
        d90.d r5 = (d90.d) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        if (d90.e.c(r5) == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        INavigationProxyService r2 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r2 == null) goto L13;
        i r3 = r2.getLiveLayerContextExt();
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        r5.f.getClass();
        r3.a(r5, d90.d.a.z2, r1);
    L13:
        return r1;
    L5:
        if (d90.e.h(r5) == false) goto L7;
        r1 = true;
        goto L8
    }

    public final f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.z2;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(h70.b r7) {
        d90.d r8 = (d90.d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        MiddlewareRoomContext r0 = d90.e.l(r8);
        boolean r1 = false;
        IExternalInjectComponentProvider r3 = null;
        if (r0 == null) goto L30;
        n r2 = r0.getExternalConfigJudger();
        if (r2 == null) goto L30;
        IExternalConfigJudger r4 = (IExternalConfigJudger) r2.getValue();
        if (r4 == null) goto L30;
        if (r4.isInExternalMode() != true) goto L30;
        MiddlewareRoomContext r5 = d90.e.l(r8);
        if (r5 == null) goto L19;
        n r6 = r5.getExternalConfigJudger();
        if (r6 == null) goto L19;
        IExternalConfigJudger r9 = (IExternalConfigJudger) r6.getValue();
        if (r9 == null) goto L19;
        ViewConfig r10 = IExternalConfigJudger.DefaultImpls.getInteractionViewConfig$default(r9, true, null, 2, null);
        if (r10 == null) goto L19;
        int r12 = r10.getMarginTop();
    L20:
        if (r12 <= 0) goto L30;
        MiddlewareRoomContext r13 = d90.e.l(r8);
        if (r13 == null) goto L30;
        n r14 = r13.getExternalConfigJudger();
        if (r14 == null) goto L30;
        IExternalConfigJudger r15 = (IExternalConfigJudger) r14.getValue();
        if (r15 == null) goto L30;
        ViewConfig r16 = IExternalConfigJudger.DefaultImpls.getInteractionViewConfig$default(r15, true, null, 2, null);
        if (r16 == null) goto L30;
        int r17 = (int) UtilityKotlinExtentionsKt.j(r16.getMarginTop());
    L31:
        ALogger.i("RoomContainerPreloadBusiness", "AudiencePortraitRoomNavigatorTetrisDescriptor:::   the topMargin is  " + r17);
        MiddlewareRoomContext r18 = d90.e.l(r8);
        if (r18 == null) goto L40;
        n r19 = r18.getExternalConfigJudger();
        if (r19 == null) goto L40;
        IExternalConfigJudger r20 = (IExternalConfigJudger) r19.getValue();
        if (r20 == null) goto L40;
        Map r22 = IExternalConfigJudger.DefaultImpls.getNormalComponentProviders$default(r20, null, 1, null);
        if (r22 == null) goto L40;
        r3 = (IExternalInjectComponentProvider) r22.get("external_left_back");
    L40:
        if (r3 == null) goto L43;
        r1 = true;
    L43:
        if (r1 == false) goto L45;
        ElementConstraint r23 = new ElementConstraint(0.0f, 52.0f);
        ElementConstraint.Side r24 = ElementConstraint.Side.TOP;
        r23.d(r24, r24, r17);
        ElementConstraint.Side r25 = ElementConstraint.Side.RIGHT;
        r23.d(r25, r25, 0.0f);
        ElementConstraint.Side r26 = ElementConstraint.Side.LEFT;
        r8.f.getClass();
        r23.b(r26, d90.d.a.G3, r25, 0.0f);
        r23.c = s1.f(-12.0f);
        return r23;
    L45:
        ElementConstraint r27 = new ElementConstraint(-1.0f, 52.0f);
        ElementConstraint.Side r28 = ElementConstraint.Side.TOP;
        r27.d(r28, r28, r17);
        return r27;
    L19:
        r12 = 0;
    L30:
        r17 = 0;
        goto L31
    }
}
