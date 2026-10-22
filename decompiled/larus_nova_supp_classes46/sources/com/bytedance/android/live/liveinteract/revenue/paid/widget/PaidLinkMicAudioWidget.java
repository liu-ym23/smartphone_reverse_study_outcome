package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/PaidLinkMicAudioWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/BasePaidLinkMicWidget;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicAudioWidget extends BasePaidLinkMicWidget {
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.paid.widget.PaidLinkMicAudioWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<i, Unit> {
        public AnonymousClass1(PaidLinkMicAudioWidget r8) {
            super(1, r8, PaidLinkMicAudioWidget.class, "uiLayoutChanged", "uiLayoutChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
        }

        public final void invoke(i r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            PaidLinkMicAudioWidget r0 = (PaidLinkMicAudioWidget) ((CallableReference) this).receiver;
            int r1 = PaidLinkMicAudioWidget.h;
            r0.getClass();
            r0.xq(r3.a, r3.b);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget, com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        j r0 = m.e(this).s();
        if (r0 == null) goto L12;
        f r1 = (f) r0.getValue();
        if (r1 == null) goto L13;
        BehaviorSubject r2 = r1.a();
        if (r2 == null) goto L14;
        final AnonymousClass1 r3 = new AnonymousClass1(this);
        Disposable r4 = r2.subscribe(new a(r3));
        if (r4 == null) goto L15;
        this.c.add(r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget, com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        DataContext r0 = getRoomContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCleared() == true) goto L11;
        u r1 = m.e(this);
        Intrinsics.checkNotNull(r1);
        n r2 = r1.t();
        if (r2 == null) goto L12;
        r2.setValue(null);
        return;
    L12:
        return;
    }

    public PaidLinkMicAudioWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget
    public final void wq(k r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        super.wq(r2);
        if (r2.a == false) goto L6;
        e r3 = b6.c0;
        Boolean r0 = Boolean.TRUE;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
        return;
    }
}
