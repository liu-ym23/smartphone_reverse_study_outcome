package com.bytedance.android.live.liveinteract.interact.audience.context;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.DataContext;
import hd0.c;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/context/LinkApplyExpiredContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvlc/l;", "Ltlc/d;", MultiLinkOpenSource.MESSAGE, "", "onMessage", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "Lvlc/d;", "messageManager", "Lvlc/d;", "getMessageManager", "()Lvlc/d;", "setMessageManager", "(Lvlc/d;)V", "<init>", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkApplyExpiredContext extends DataContext implements l {
    private final CompositeDisposable cd;
    private d messageManager;

    public static final class a implements Action {
        public final /* synthetic */ LinkApplyExpiredContext a;

        public a(LinkApplyExpiredContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.getMessageManager().removeMessageListener(this.a);
        }
    }

    public final CompositeDisposable getCd() {
        return this.cd;
    }

    public final d getMessageManager() {
        return this.messageManager;
    }

    public LinkApplyExpiredContext(d r3) {
        Intrinsics.checkNotNullParameter(r3, "messageManager");
        this.messageManager = r3;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        this.messageManager.addMessageListener(MessageType.LINKER.getKey(), this);
        r4.add(getOnCleared().subscribe(new a(this)));
    }

    public void onMessage(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof h1) == true) goto L7;
        return;
    L7:
        if (((h1) r2).getMType() != 22) goto L18;
        Integer r3 = (Integer) ((ge1.a) c.f()).b;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.intValue() != 1) goto L17;
        c.f().k(0);
        return;
    L17:
        return;
    }

    public final void setMessageManager(d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageManager = r2;
    }
}
