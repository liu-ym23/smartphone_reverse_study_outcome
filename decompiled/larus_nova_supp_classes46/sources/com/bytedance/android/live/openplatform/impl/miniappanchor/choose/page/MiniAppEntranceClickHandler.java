package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppEntranceClickHandler {
    public so0.a a;

    public static final class CheckToolbarConflictNode extends com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a {
        public final lp0.a a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a
        public final void a(final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r3) {
            Intrinsics.checkNotNullParameter(r3, "chains");
            lp0.a r0 = this.a;
            if (r0 == null) goto L11;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r1 = r0.getRoot();
            if (r1 == null) goto L11;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r2 = r1.dE();
            if (r2 == null) goto L11;
            final p r4 = r2.d;
            if (r4 == null) goto L11;
            r4.a(new MiniAppEntranceClickHandler$CheckToolbarConflictNode$process$$inlined$let$lambda$1(r4, r3), MiniAppEntranceClickHandler$CheckToolbarConflictNode$process$1$2.INSTANCE);
            return;
        L11:
            r3.a();
        }

        public CheckToolbarConflictNode(lp0.a r2, MiniAppEntranceCell r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.a = r2;
        }
    }

    public static final class a extends com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a {
        public final lp0.a a;
        public final MiniAppEntranceCell b;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a
        public final void a(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r21) {
            Intrinsics.checkNotNullParameter(r21, "chain");
            lp0.a r1 = this.a;
            if (r1 == null) goto L9;
            so0.a r2 = r1.w();
            if (r2 == null) goto L9;
            OpenPlatformContext r3 = r2.a();
            if (r3 == null) goto L9;
            DataCenter r4 = r3.getDataCenter();
        L10:
            if (r4 == null) goto L12;
            r4.put("cmd_live_toolbarmore_dialog_dismiss", 0);
        L12:
            MiniAppEntranceCell r5 = this.b;
            String r10 = mp0.b.a(r5.groupId);
            if (lp0.b.d(this.a) == false) goto L24;
            so0.a r6 = f.a.a;
            if (r6 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L17:
            String r7 = r5.schema;
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            String r8 = LaunchParamConstant$Scene.a;
            List r9 = r5.serverScenes;
            if (r9 != null) goto L23;
            r9 = new ArrayList();
        L23:
            r6.openMiniApp(r7, new ko0.b(r8, "live", PbRequest.SwitchType.PREVIEW, "solid_entrance", "live_take_page", r10, null, null, null, false, false, r9, 8128));
            return;
        L24:
            so0.a r11 = f.a.a;
            if (r11 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L27:
            String r12 = r5.schema;
            if (r12 != null) goto L30;
            r12 = "";
        L30:
            String r13 = LaunchParamConstant$Scene.a;
            List r14 = r5.serverScenes;
            if (r14 != null) goto L33;
            r14 = new ArrayList();
        L33:
            r11.i(r12, new ko0.b(r13, "live", PbRequest.SwitchType.PREVIEW, "solid_entrance", "live_take_page", r10, null, null, null, false, false, r14, 8128));
            return;
        L9:
            r4 = null;
            goto L10
        }

        public a(lp0.a r2, MiniAppEntranceCell r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.a = r2;
            this.b = r3;
        }
    }

    public MiniAppEntranceClickHandler() {
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
    }

    public static void a(lp0.a r6, MiniAppEntranceCell r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (lp0.b.d(r6) == false) goto L13;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L13;
        m<Boolean> r1 = r0.getMicroAppMountPunishing();
        if (r1 == null) goto L13;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L13;
        f2.b(2131920399, 0);
        return;
    L13:
        if (lp0.b.a(r6) == null) goto L18;
        String r2 = r7.appId;
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        String r3 = mp0.b.a(r7.groupId);
        boolean r4 = lp0.b.d(r6);
        String r5 = r7.a();
        Integer r9 = Integer.valueOf(r8);
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "enterPosition");
        u.l().e("mp_click", mp0.a.a(r2, r3, r4, r5, r9), new Object[0]);
    L18:
        ArrayList r10 = new ArrayList();
        if (lp0.b.d(r6) == false) goto L21;
        CheckToolbarConflictNode r11 = new CheckToolbarConflictNode(r6, r7);
        Intrinsics.checkNotNullParameter(r11, "node");
        r10.add(r11);
    L21:
        a r12 = new a(r6, r7);
        Intrinsics.checkNotNullParameter(r12, "node");
        r10.add(r12);
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r13 = new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a();
        Iterator r14 = r10.iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a r15 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC0141a) r14.next();
        ((ArrayList) r13.a).add(r15);
        goto L23
    L25:
        r13.b = 0;
        r13.a();
    }
}
