package mh;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.bytedance.pia.core.plugins.StreamingPlugin;
import com.bytedance.pia.core.utils.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StreamingPlugin f20106b;

    public /* synthetic */ i(StreamingPlugin r5, int r10) {
        this.f20105a = r10;
        this.f20106b = r5;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        switch(this.f20105a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        String r10 = (String) r5;
        StreamingPlugin r11 = this.f20106b;
        WebMessagePort r12 = (WebMessagePort) r11.f7050h.get();
        if (r12 == null) goto L7;
        Intrinsics.checkNotNullParameter("[Streaming] appendChunkByBridge by port.", "message");
        com.bytedance.pia.core.utils.j.y("[Streaming] appendChunkByBridge by port.", null);
        r12.postMessage(new WebMessage(r10));
        return;
    L7:
        m.a(new kh.b(5, r11, r10));
        return;
    L9:
        String r13 = (String) r5;
        StreamingPlugin r14 = this.f20106b;
        r14.getClass();
        r14.f7051i.b(new i(r14, 2));
        return;
    L11:
        StreamingPlugin r15 = this.f20106b;
        r15.getClass();
        com.bytedance.pia.core.utils.j.s("[Streaming] js error: " + ((String) r5));
        monitor-enter(r15);
        r15.g = true;     // Catch: Throwable -> L17
        monitor-exit(r15);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
