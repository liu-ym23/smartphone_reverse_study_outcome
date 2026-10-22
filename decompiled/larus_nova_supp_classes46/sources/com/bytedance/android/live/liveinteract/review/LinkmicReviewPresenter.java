package com.bytedance.android.live.liveinteract.review;

import android.content.Context;
import com.bytedance.android.live.base.model.message.a3;
import com.bytedance.android.live.base.model.message.j2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.Metadata;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkmicReviewPresenter extends n<IView> implements l {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IView extends IWidget {
        /* synthetic */ Context getContext();
    }

    public final void detachView() {
        super.detachView();
        d r0 = ((n) this).d;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public LinkmicReviewPresenter() {
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r2) {
        super.c0(r2);
        d r3 = ((n) this).d;
        if (r3 == null) goto L6;
        r3.addMessageListener(MessageType.LINK_MIC_REVIEW.getKey(), this);
        return;
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof j2) == false) goto L10;
        j2 r7 = (j2) r6;
        long r0 = r7.getMsgType();
        j2.Companion.getClass();
        if (r0 != 1) goto L11;
        a3 r8 = r7.getNormalPaidDescContent();
        if (r8 == null) goto L12;
        f2.c(r8.getToast(), 0);
        return;
    L12:
        return;
    L11:
        return;
    }
}
