package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ MediaOperation.a f;

    public n(VoiceChatMuteManager r1, String r2, long r3, String r5, boolean r6, MediaOperation.a r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        je0.d.Q(this.a.c, r7);
        String r0 = this.b;
        long r1 = this.c;
        InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
        x.x0(this.b, r7, this.d);
        VoiceChatMuteManager r2 = this.a;
        r2.a = false;
        if (this.e == true) goto L15;
        Iterator<VoiceChatMuteManager.a> r3 = r2.d.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().i0(this.b, r7);
        goto L7
    L9:
        MediaOperation.a r4 = this.f;
        if (r4 == null) goto L14;
        r4.onError(r7);
        return;
    L14:
        return;
    }
}
