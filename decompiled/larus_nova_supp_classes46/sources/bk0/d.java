package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements e {
    public final a a;

    public interface a {
        boolean a();

        boolean b();

        boolean c();

        boolean isFollowed();

        boolean isMute();
    }

    public d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r3 instanceof n0) == true) goto L36;
        if ((r3 instanceof x0) == true) goto L36;
        if ((r3 instanceof b1) == true) goto L34;
        if ((r3 instanceof c1) == true) goto L34;
        if ((r3 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == false) goto L17;
        return !this.a.isFollowed();
    L17:
        if ((r3 instanceof a1) == false) goto L21;
        return this.a.isFollowed();
    L21:
        if ((r3 instanceof o0) == false) goto L25;
        return this.a.a();
    L25:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a) == false) goto L29;
        return this.a.c();
    L29:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r) == true) goto L31;
        return true;
    L31:
        return this.a.b();
    L34:
        return this.a.isMute();
    L36:
        return !this.a.isMute();
    }
}
