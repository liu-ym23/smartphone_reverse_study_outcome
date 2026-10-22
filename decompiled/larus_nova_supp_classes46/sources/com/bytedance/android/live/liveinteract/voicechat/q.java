package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ MediaOperation.a e;

    public q(VoiceChatMuteManager r1, String r2, String r3, boolean r4, MediaOperation.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        je0.d.Q(this.a.c, r7);
        String r0 = this.b;
        long r1 = this.a.h;
        InteractLinkFullLinkMonitor.o0(r0, System.currentTimeMillis() - r1, r7);
        x.E0(this.b, r7, this.c);
        VoiceChatMuteManager r2 = this.a;
        r2.b = false;
        if (this.d == true) goto L15;
        Iterator<VoiceChatMuteManager.a> r3 = r2.d.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().Q(this.b, r7);
        goto L7
    L9:
        MediaOperation.a r4 = this.e;
        if (r4 == null) goto L14;
        r4.onError(r7);
        return;
    L14:
        return;
    }
}
