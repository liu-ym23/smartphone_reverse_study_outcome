package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements com.ss.ugc.live.sdk.msg.network.h {
    public final /* synthetic */ g a;
    public final /* synthetic */ long b;

    @Override // com.ss.ugc.live.sdk.msg.network.h
    public final void a(com.ss.ugc.live.sdk.msg.network.g r13) {
        Intrinsics.checkNotNullParameter(r13, "httpResponse");
        if (r13.a() == false) goto L37;
        SdkResponse r0 = (SdkResponse) SdkResponse.ADAPTER.decode(r13.d);
        long r1 = System.currentTimeMillis();
        ArrayList r3 = new ArrayList();
        List<SdkMessage> r4 = r0.messages;
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L29;
        long r6 = System.currentTimeMillis();
        Iterator<T> r7 = r0.messages.iterator();
    L14:
        if (r7.hasNext() == false) goto L25;
        SdkMessage r8 = (SdkMessage) r7.next();
        Long r9 = r0.now;
        if (r9 == null) goto L18;
        long r10 = r9.longValue();
    L19:
        Long r11 = com.ss.ugc.live.sdk.msg.utils.c.e(r13.c);
        if (r11 == null) goto L22;
        r10 = r11.longValue();
    L22:
        r8.timestamp = r10;
        r8.fromHttp = true;
        tlc.d r12 = this.a.d.a(r8);
        if (r12 == null) goto L14;
        r12.setMessageMethod(r8.method);
        r12.setHttpSendTime(this.b);
        r12.setReceiveTime(r1);
        r3.add(r12);
        goto L14
    L18:
        r10 = System.currentTimeMillis();
        goto L19
    L25:
        long r2 = System.currentTimeMillis();
        Iterator r14 = r3.iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        tlc.d r15 = (tlc.d) r14.next();
        r15.setDecodeStartTime(r6);
        r15.setDecodeEndTime(r2);
    L29:
        r13.e = new com.ss.ugc.live.sdk.msg.data.b(r0, r3, this.a.e);
        return;
    L7:
        if (r4.isEmpty() == true) goto L10;
        r5 = false;
        goto L11
    }

    public e(g r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
