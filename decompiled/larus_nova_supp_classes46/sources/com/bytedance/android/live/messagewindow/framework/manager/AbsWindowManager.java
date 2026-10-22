package com.bytedance.android.live.messagewindow.framework.manager;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/manager/AbsWindowManager;", "Lcom/bytedance/live/datacontext/DataContext;", "Le71/a;", "Lv61/c;", "msgWindow", "", "show", "", "interceptShow", "hide", "interceptHide", "dismiss", "interceptDismiss", "Ly61/b;", "getMsgWindowCtx", "()Ly61/b;", "msgWindowCtx", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsWindowManager extends DataContext implements e71.a {
    public abstract y61.b getMsgWindowCtx();

    public AbsWindowManager() {
    }

    public void dismiss(final v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if (interceptDismiss(r3) == false) goto L5;
        return;
    L5:
        i71.a r0 = getMsgWindowCtx().scheduler();
        if (r0 == null) goto L9;
        r0.execute(new AnonymousClass1(r3));
        return;
    }

    public void hide(final v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if (interceptHide(r3) == false) goto L5;
        return;
    L5:
        i71.a r0 = getMsgWindowCtx().scheduler();
        if (r0 == null) goto L9;
        r0.execute(new C03111(r3));
        return;
    }

    public boolean interceptDismiss(v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        d71.d r0 = getMsgWindowCtx().recordManager(r3.getPosition());
        if (r0 == null) goto L11;
        if (r0.g(r3) == true) goto L8;
        return true;
    L8:
        return false;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    public boolean interceptHide(v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        d71.d r0 = getMsgWindowCtx().recordManager(r3.getPosition());
        if (r0 == null) goto L14;
        if (r0.c(r3) == false) goto L7;
        return false;
    L7:
        if (r3.isShowing() == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    public boolean interceptShow(v61.c r4) {
        Intrinsics.checkNotNullParameter(r4, "msgWindow");
        d71.d r0 = getMsgWindowCtx().recordManager(r4.getPosition());
        if (r0 == null) goto L15;
        if (r0.c(r4) == true) goto L7;
        return false;
    L7:
        if (r4.isShowing() == true) goto L11;
        w61.a r1 = getMsgWindowCtx().windowContainer(r4.getPosition());
        if (r1 == null) goto L11;
        r1.yc((v61.a) r4, true, C03121.INSTANCE);
    L11:
        return true;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    public void show(final v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if (interceptShow(r3) == false) goto L5;
        return;
    L5:
        i71.a r0 = getMsgWindowCtx().scheduler();
        if (r0 == null) goto L9;
        r0.execute(new C03131(r3));
        return;
    }
}
