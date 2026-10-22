package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends com.ss.ugc.live.sdk.msg.utils.task.a<tlc.f, com.ss.ugc.live.sdk.msg.data.a> {
    public final com.ss.ugc.live.sdk.msg.dispatch.f c;
    public final amc.d d;

    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(tlc.f r18) {
        tlc.f r1 = r18;
        Intrinsics.checkNotNullParameter(r1, "params");
        long r2 = System.currentTimeMillis();
        SdkResponse r4 = (SdkResponse) SdkResponse.ADAPTER.decode(this.d.b(r1));
        com.ss.ugc.live.sdk.msg.data.c r5 = new com.ss.ugc.live.sdk.msg.data.c();
        ArrayList r6 = new ArrayList();
        List<com.ss.ugc.live.sdk.msg.network.d> r7 = r1.f;
        int r8 = com.ss.ugc.live.sdk.msg.utils.c.a;
        boolean r9 = true;
        String r10 = null;
        if (r7 == null) goto L14;
        Iterator<T> r11 = r7.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (StringsKt.equals("im-first_push_flag", ((com.ss.ugc.live.sdk.msg.network.d) r12).a, true) == false) goto L6;
    L11:
        com.ss.ugc.live.sdk.msg.network.d r13 = (com.ss.ugc.live.sdk.msg.network.d) r12;
        if (r13 == null) goto L14;
        r10 = r13.b;
        goto L14
    L10:
        r12 = null;
    L14:
        boolean r14 = Intrinsics.areEqual(r10, "true");
        List<SdkMessage> r15 = r4.messages;
        boolean r16 = false;
        if (r15 != null) goto L17;
    L20:
        if (r9 == true) goto L48;
        long r17 = System.currentTimeMillis();
        r5.e = r4.messages.size();
        Iterator r19 = r4.messages.iterator();
    L23:
        if (r19.hasNext() == false) goto L44;
        SdkMessage r110 = (SdkMessage) r19.next();
        Long r111 = r4.now;
        if (r111 == null) goto L27;
        long r112 = r111.longValue();
    L28:
        Long r113 = com.ss.ugc.live.sdk.msg.utils.c.e(r1.f);
        if (r113 == null) goto L31;
        r112 = r113.longValue();
    L31:
        r110.timestamp = r112;
        r110.fromHttp = r16;
        tlc.d r114 = this.c.a(r110);
        if (r114 == null) goto L38;
        r114.setMessageMethod(r110.method);
        r114.setReceiveTime(r1.i);
        r114.setIsFromFirstRequest(r14);
        if ((r114 instanceof xlc.b) == false) goto L37;
        xlc.b r115 = (xlc.b) r114;
        r115.setWRDSMessage(r110.need_wrds_store.booleanValue());
        r115.setWRDSVersion(r110.wrds_version.longValue());
        r115.setWRDSSubKey(r110.wrds_sub_key);
    L37:
        r6.add(r114);
    L43:
        r19 = r19;
        r16 = false;
        goto L23
    L38:
        r19 = r19;
        Long r116 = r110.msg_id;
        LinkedHashSet<Long> r117 = r5.f;
        if (r116 == null) goto L41;
        long r118 = r116.longValue();
    L42:
        r117.add(Long.valueOf(r118));
        goto L43
    L41:
        r118 = -1;
        goto L42
    L27:
        r112 = System.currentTimeMillis();
        goto L28
    L44:
        long r119 = System.currentTimeMillis();
        Iterator r120 = r6.iterator();
    L46:
        if (r120.hasNext() == false) goto L48;
        tlc.d r121 = (tlc.d) r120.next();
        r121.setDecodeStartTime(r17);
        r121.setDecodeEndTime(r119);
    L48:
        r5.a = r1.i;
        r5.b = r2;
        r5.c = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.data.a r3 = new com.ss.ugc.live.sdk.msg.data.a(r4, r6, r5);
        r3.b = r1;
        r3.c = r14;
        int r20 = com.ss.ugc.live.sdk.msg.utils.g.a;
        b(new com.ss.ugc.live.sdk.msg.utils.g.c(r3));
        return;
    L17:
        if (r15.isEmpty() == true) goto L20;
        r9 = false;
        goto L20
    }

    public m(bmc.b r2, amc.d r3) {
        Intrinsics.checkNotNullParameter(r2, "messageDecoder");
        Intrinsics.checkNotNullParameter(r3, "wsPayloadCompressStrategy");
        super(l.a);
        this.c = r2;
        this.d = r3;
    }
}
