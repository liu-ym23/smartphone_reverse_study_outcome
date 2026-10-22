package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.q3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public IBattleConfigSetting a;
    public com.bytedance.android.live.revlink.impl.multianchor.network.b b;
    public Disposable c;
    public IRoom d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;
        public final /* synthetic */ PlayMode c;
        public final /* synthetic */ m d;

        public a(g r1, long r2, PlayMode r4, m r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r9) {
            ExtraResponse r10 = (ExtraResponse) r9;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L5;
            LiveFullLinkPKMonitor.s(r0, "linkmic/change_multi_pk_mode_tab", System.currentTimeMillis() - this.b, 0, 0, null, 28);
        L5:
            z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
            if (r1 == null) goto L12;
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = com.bytedance.android.live.revlink.impl.global.b.u();
            if (r2 == null) goto L10;
            long r3 = r2.a();
        L11:
            String r4 = this.c.toString();
            int r5 = z.f;
            r1.m(r3, r4, null);
            goto L12
        L10:
            r3 = 0;
        L12:
            if (r10 == null) goto L34;
            q3 r12 = (q3) r10.data;
            if (r12 == null) goto L34;
            e7 r13 = r12.getMultiPKModeInfo();
            if (r13 == null) goto L34;
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(this.a.a, f7.a(r13)) == false) goto L39;
            MultiAnchorPkLaunchContext r6 = com.bytedance.android.live.revlink.impl.global.b.x();
            if (r6 == null) goto L24;
            MultiAnchorPkLaunchContext.updateMultiPkModeInfo$default(r6, r13, null, "oldPanelSwitcher", null, 8, null);
        L24:
            if (r13.getModeTab() != 1) goto L28;
            com.bytedance.android.live.revlink.impl.multianchor.network.b r7 = this.a.b;
            if (r7 == null) goto L28;
            r7.g(r13.getVersion());
        L28:
            Intrinsics.checkNotNullParameter(r13, "$this$userIdToTeamId");
            Map<String, Long> r8 = r13.getRevUserIdToTeamId();
            if (r13.getModeTab() != 2) goto L34;
            if (r8 == null) goto L34;
            com.bytedance.android.live.revlink.impl.multianchor.network.b r14 = this.a.b;
            if (r14 == null) goto L34;
            r14.d(r13.getVersion(), r8);
            goto L34
        L39:
            return;
        L34:
            m r15 = this.d;
            if (r15 == null) goto L38;
            r15.onSuccess();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PlayMode a;
        public final /* synthetic */ long b;
        public final /* synthetic */ m c;

        public b(PlayMode r1, long r2, m r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r10) {
            Throwable r12 = (Throwable) r10;
            z r0 = com.bytedance.android.live.revlink.impl.global.b.J();
            if (r0 == null) goto L9;
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r1 = com.bytedance.android.live.revlink.impl.global.b.u();
            if (r1 == null) goto L7;
            long r2 = r1.a();
        L8:
            r0.m(r2, this.a.toString(), r12);
            goto L9
        L7:
            r2 = 0;
        L9:
            LiveFullLinkPKMonitor r3 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r3 == null) goto L12;
            LiveFullLinkPKMonitor.r(r3, "linkmic/change_multi_pk_mode_tab", r12, System.currentTimeMillis() - this.b, 0, 0, null, 56);
        L12:
            com.bytedance.android.live.revenue.common.k.a(s1.getContext(), r12);
            m r4 = this.c;
            if (r4 == null) goto L16;
            r4.onFailed(r0.a(r12));
            return;
        }
    }

    public g() {
    }

    public final void a(PlayMode r17, m r18) {
        Intrinsics.checkNotNullParameter(r17, "playMode");
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = null;
        this.c = null;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = com.bytedance.android.live.revlink.impl.global.b.u();
        long r3 = 0;
        if (r2 != null) goto L8;
    L15:
        int r4 = 1;
        if (r17 != PlayMode.TEAM_PK) goto L18;
        int r14 = 2;
    L19:
        IBattleConfigSetting r5 = this.a;
        MultiAnchorPkLaunchContext r6 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r6 == null) goto L28;
        n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r9 = r6.getMultiPkModeInfo();
        if (r9 == null) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r10 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) r9.getValue();
        if (r10 == null) goto L28;
        e7 r12 = r10.a;
        if (r12 == null) goto L28;
        r4 = r12.getModeTab();
    L28:
        if (r6 == null) goto L36;
        n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r7 = r6.getMultiPkModeInfo();
        if (r7 == null) goto L36;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r8 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) r7.getValue();
        if (r8 == null) goto L36;
        e7 r13 = r8.a;
        if (r13 == null) goto L36;
        IBattleConfigSetting r15 = f7.a(r13);
    L37:
        if (r4 == r14) goto L39;
    L42:
        if (r5 == null) goto L44;
        String r16 = com.bytedance.android.live.revlink.impl.utils.e.b(r5);
    L45:
        String r19 = r16;
        long r20 = System.currentTimeMillis();
        r31.a r22 = r31.b.a(r31.a.a);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r23 = com.bytedance.android.live.revlink.impl.global.b.u();
        if (r23 == null) goto L48;
        long r110 = r23.a();
    L49:
        IRoom r24 = this.d;
        if (r24 == null) goto L52;
        r3 = r24.getRoomId();
    L52:
        Observable<ExtraResponse<q3, Extra>> r25 = r22.h(r110, r3, r14, r19);
        if (r25 == null) goto L57;
        Observable r26 = r25.compose(RxUtil.rxSchedulerHelper());
        if (r26 == null) goto L57;
        r1 = r26.subscribe(new a(this, r20, r17, r18), new b(r17, r20, r18));
    L57:
        this.c = r1;
        return;
    L48:
        r110 = 0;
        goto L49
    L44:
        r16 = "";
        goto L45
    L39:
        if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(r15, r5) == false) goto L42;
        if (r18 == null) goto L42;
        r18.onSuccess();
    L36:
        r15 = null;
        goto L37
    L18:
        r14 = 1;
        goto L19
    L8:
        if (r2.a() != 0) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r27 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r27 == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r28 = r27.of();
    L13:
        if (r28 == null) goto L15;
        r28.b("changeMultiPkModeTab");
        goto L15
    L12:
        r28 = null;
        goto L13
    }
}
