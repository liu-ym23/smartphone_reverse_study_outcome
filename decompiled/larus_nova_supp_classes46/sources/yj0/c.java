package yj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.link.model.bridge.k;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public c(a r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        r1 r0 = (r1) r7.data;
        if (r0 == null) goto L7;
        a.InterfaceC0294a r1 = (a.InterfaceC0294a) ((q46.b) this.a).a;
        if (r1 == null) goto L7;
        r1.Z(this.b, r0.getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_API);
    L7:
        InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.c, r7.logId);
        r1 r8 = (r1) r7.data;
        if (r8 == null) goto L27;
        List r9 = r8.getLinkedUsers();
        if (r9 == null) goto L27;
        Iterator<T> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L21;
        T r2 = r10.next();
        IBaseUser r3 = ((k) r2).getUser();
        if (r3 == null) goto L17;
        String r4 = r3.getIdString();
    L19:
        if (Intrinsics.areEqual(r4, je0.d.b0()) == false) goto L13;
    L22:
        k r5 = (k) r2;
        if (r5 == null) goto L27;
        if (r5.getSilenceStatus() != 0) goto L27;
        x.c0(this.b, null, true);
        ALogger.i("video_talk", "video ktv resetSilenceStatus success but unSilence");
        return;
    L17:
        r4 = null;
        goto L19
    L21:
        r2 = null;
    L27:
        x.c0(this.b, null, false);
        a.InterfaceC0294a r11 = (a.InterfaceC0294a) ((q46.b) this.a).a;
        if (r11 == null) goto L30;
        r11.D(this.b);
    L30:
        ALogger.i("video_talk", "video ktv resetSilenceStatus success");
        f2.b(2131919327, 0);
    }
}
