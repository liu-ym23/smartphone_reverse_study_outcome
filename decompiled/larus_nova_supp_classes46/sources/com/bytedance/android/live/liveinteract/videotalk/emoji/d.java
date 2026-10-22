package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
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
        void A2(List<? extends j1> r1);

        void B4();

        void D(String r1);

        void E3(Throwable r1);

        void F(String r1, Throwable r2);

        void G(String r1);

        void G3(Throwable r1);

        void Lu(List<? extends ILinkmicInteractEntrance> r1);

        void ih(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r1);

        void j9(List<? extends ILinkmicInteractEntrance> r1);

        void r(String r1, Throwable r2);

        void ta(ContributeShowResponse.OwnerHonorInfo r1);

        void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r1);

        void w6(Throwable r1);
    }

    public abstract void d0(r1 r1);

    public final void detachView() {
        ((q46.b) this).a = null;
        this.f.clear();
    }

    public abstract void e0(c2 r1);

    public static VoiceChatMuteManager c0() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        com.bytedance.android.live.liveinteract.voicechat.b r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.b r2 = r0.muteManager();
    L7:
        if ((r2 instanceof VoiceChatMuteManager) == false) goto L11;
        r1 = r2;
    L11:
        return (VoiceChatMuteManager) r1;
    L5:
        r2 = null;
        goto L7
    }

    public d(boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.g = r2;
        this.f = new CompositeDisposable();
    }
}
