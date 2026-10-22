package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class c implements e {
    public c() {
    }

    @Override // bk0.e
    public boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r3 instanceof r0) == false) goto L6;
        return true;
    L6:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == false) goto L9;
        return true;
    L9:
        if ((r3 instanceof a1) == false) goto L12;
        return true;
    L12:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r) == false) goto L15;
        return true;
    L15:
        if ((r3 instanceof v0) == false) goto L18;
        return true;
    L18:
        if ((r3 instanceof l0) == true) goto L27;
        return false;
    L27:
        return true;
    }
}
