package xe0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ MediaOperation.a d;

    public f(a r1, String r2, long r3, MediaOperation.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        String r0 = this.b;
        this.a.e = false;
        InteractLinkFullLinkMonitor.p0(r0, System.currentTimeMillis() - this.c, r7.logId);
        String r1 = this.b;
        List r2 = ((c2) r7.data).getLinkedUsers();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = je0.d.g0(r2);
    L6:
        Map r8 = ((c2) r7.data).getLinkerContentMap();
        if (r8 == null) goto L9;
        r3 = r8.toString();
    L9:
        x.D0(r1, "", r4, r3);
        a.InterfaceC0292a r9 = this.a.b;
        if (r9 == null) goto L12;
        r9.G(this.b);
    L12:
        MediaOperation.a r10 = this.d;
        if (r10 == null) goto L16;
        r10.onSuccess();
        return;
    L16:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
