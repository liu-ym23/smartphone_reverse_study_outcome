package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.e;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import rj0.h;
import rj0.k;
import rj0.l;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/PaidLinkMicVideoWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/BasePaidLinkMicWidget;", "Lrj0/h$a;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicVideoWidget extends BasePaidLinkMicWidget implements h.a {
    public static final /* synthetic */ int i = 0;
    public final h h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.paid.widget.PaidLinkMicVideoWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<j, Unit> {
        public AnonymousClass1(PaidLinkMicVideoWidget r8) {
            super(1, r8, PaidLinkMicVideoWidget.class, "uiLayoutChanged", "uiLayoutChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneWithPlayModeEvent;)V", 0);
        }

        public final void invoke(j r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            PaidLinkMicVideoWidget r0 = (PaidLinkMicVideoWidget) ((CallableReference) this).receiver;
            int r1 = PaidLinkMicVideoWidget.i;
            r0.getClass();
            r0.xq(r3.a, r3.c);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((j) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // rj0.h.a
    public final void B0(long r1) {
    }

    public final o yq() {
        l.n2.getClass();
        l r0 = l.a.a();
        if (r0 == null) goto L6;
        o r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        k.m2.getClass();
        k r2 = k.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    public PaidLinkMicVideoWidget() {
        int r0 = e.h;
        this.h = e.a.a();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget, com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        h r0 = this.h;
        if (r0 == null) goto L5;
        r0.e(this);
    L5:
        com.bytedance.live.datacontext.j r1 = m.e(this).getVideoTalkRoomSubScene();
        if (r1 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L16;
        BehaviorSubject r3 = r2.a();
        if (r3 == null) goto L17;
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        Disposable r5 = r3.subscribe(new a(r4));
        if (r5 == null) goto L18;
        this.c.add(r5);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget, com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        h r0 = this.h;
        if (r0 == null) goto L6;
        r0.f(this);
        return;
    }

    @Override // rj0.h.a
    public final void v3(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "guestTimeRemaining");
        o r0 = yq();
        if (r0 == null) goto L6;
        r0.v3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget
    public final void wq(cj0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        super.wq(r2);
        if (r2.a == false) goto L7;
        o r3 = yq();
        if (r3 == null) goto L11;
        r3.s();
        return;
    L11:
        return;
    L7:
        o r4 = yq();
        if (r4 == null) goto L13;
        r4.R();
        return;
    }
}
