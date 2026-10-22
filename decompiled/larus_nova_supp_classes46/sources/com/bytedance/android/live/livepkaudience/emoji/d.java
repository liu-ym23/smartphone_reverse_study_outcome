package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d extends q46.b<a> {
    public boolean b;
    public boolean c;
    public boolean d;
    public long e;
    public final CompositeDisposable f;
    public final boolean g;

    public interface a extends q46.a {
        void D(String r1);

        void E3(Throwable r1);

        void F(String r1, Throwable r2);

        void G(String r1);

        void r(String r1, Throwable r2);

        void vM(TalkRoomEmojiListResponse r1);

        void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r1);

        void w6(Throwable r1);
    }

    public abstract void c0(SilenceResponse r1);

    public abstract void d0(UnSilenceResponse r1);

    public final void detachView() {
        ((q46.b) this).a = null;
        this.f.clear();
    }

    public d(boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.g = r2;
        this.f = new CompositeDisposable();
    }
}
