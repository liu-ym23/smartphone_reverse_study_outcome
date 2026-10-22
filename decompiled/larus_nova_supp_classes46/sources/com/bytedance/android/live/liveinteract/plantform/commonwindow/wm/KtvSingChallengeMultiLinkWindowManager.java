package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/KtvSingChallengeMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSingChallengeMultiLinkWindowManager extends CommonMultiLinkWindowManager {
    public static final /* synthetic */ int X = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ KtvSingChallengeMultiLinkWindowManager a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public a(KtvSingChallengeMultiLinkWindowManager r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            KtvSingChallengeMultiLinkWindowManager r0 = this.a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = this.b;
            int r2 = this.c;
            int r3 = this.d;
            int r4 = KtvSingChallengeMultiLinkWindowManager.X;
            r0.getClass();
            float r5 = r1.s(r2, r3);
            int r6 = r1.q(r3);
            int r7 = com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a;
            int r8 = com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a(r1.getUiLayout()) * 2;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r9 = r0.d;
            if (r9 == null) goto L8;
            ug0.a r10 = r9.getRvLayoutManager();
            if (r10 == null) goto L8;
            Pair<Integer, Integer> r11 = r10.a(1);
            if (r11 == null) goto L8;
        L12:
            if (r11 == null) goto L16;
            NextLiveData<ConstraintLayout.LayoutParams> r12 = ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().E().a;
            int r13 = ((Number) r11.getFirst()).intValue() + r8;
            int r14 = (int) r5;
            ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(r13, r14);
            ((ViewGroup.MarginLayoutParams) r15).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) r15).bottomMargin = (r3 - r14) - r6;
            Unit r16 = Unit.INSTANCE;
            r12.setValue(r15);
            ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().E().b.setValue(Boolean.TRUE);
            ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().E().c.setValue(Float.valueOf(0.7375f));
            ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().E().d.setValue(Float.valueOf(0.7815f));
            return;
        L16:
            return;
        L8:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r17 = r0.d;
            if (r17 == null) goto L11;
            r11 = com.bytedance.android.live.liveinteract.plantform.commonwindow.l.a.a(r17);
            goto L12
        L11:
            r11 = null;
            goto L12
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

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void Z0(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "config");
        super.Z0(r3, r4, r5);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L8;
        ViewGroup r1 = r0.td();
        if (r1 == null) goto L9;
        r1.post(new a(this, r3, r4, r5));
        return;
    L9:
        return;
    }

    public KtvSingChallengeMultiLinkWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, tf0.o.a r8, PlatformMultiLinkWidget r9, View r10, GLSurfaceView r11, com.bytedance.android.live.pushstream.d r12, PlatformMultiLinkWidget r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r11, "renderContainer");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }
}
