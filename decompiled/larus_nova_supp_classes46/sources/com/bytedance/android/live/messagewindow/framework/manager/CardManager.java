package com.bytedance.android.live.messagewindow.framework.manager;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/manager/CardManager;", "Lcom/bytedance/android/live/messagewindow/framework/manager/AbsWindowManager;", "Lv61/c;", "msgWindow", "", "interceptShow", "interceptDismiss", "Ly61/b;", "msgWindowCtx", "Ly61/b;", "getMsgWindowCtx", "()Ly61/b;", "<init>", "(Ly61/b;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardManager extends AbsWindowManager {
    private final y61.b msgWindowCtx;

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public y61.b getMsgWindowCtx() {
        return this.msgWindowCtx;
    }

    public CardManager(y61.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msgWindowCtx");
        this.msgWindowCtx = r2;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public boolean interceptDismiss(v61.c r5) {
        Intrinsics.checkNotNullParameter(r5, "msgWindow");
        boolean r0 = super.interceptDismiss(r5);
        i r1 = getMsgWindowCtx().monitor();
        if (r0 == false) goto L11;
        String r2 = "card of [" + r5.getIdentity() + "] wanna dismiss but intercepted, it is not in the records";
        if (r1 == null) goto L8;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.c(r2);
        Unit r4 = Unit.INSTANCE;
        r1.d(r3.b());
    L8:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r6 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_intercept_dismiss_card");
        r6.a(r5.getIdentity());
        i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r7 == null) goto L14;
        r7.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r6));
    L14:
        return r0;
    L11:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_request_dismiss_card");
        r8.a(r5.getIdentity());
        i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L14;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
        goto L14
    }

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public boolean interceptShow(v61.c r5) {
        Intrinsics.checkNotNullParameter(r5, "msgWindow");
        boolean r0 = super.interceptShow(r5);
        i r1 = getMsgWindowCtx().monitor();
        if (r0 == false) goto L17;
        String r2 = "card of [" + r5.getIdentity() + "] wanna show but intercepted, it is already showing";
        if (r1 == null) goto L8;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.c(r2);
        Unit r4 = Unit.INSTANCE;
        r1.d(r3.b());
    L8:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r6 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_intercept_show_card");
        r6.a(r5.getIdentity());
        i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r7 == null) goto L12;
        r7.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r6));
    L12:
        if ((r5 instanceof v61.a) == true) goto L14;
        r5 = null;
    L14:
        v61.a r8 = (v61.a) r5;
        if (r8 == null) goto L20;
        r8.H(p71.a.a.c);
    L20:
        return r0;
    L17:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_request_show_card");
        r9.a(r5.getIdentity());
        i r10 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r10 == null) goto L20;
        r10.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r9));
        goto L20
    }
}
