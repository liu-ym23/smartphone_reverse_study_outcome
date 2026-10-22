package com.ss.ugc.live.sdk.msg.unify.business;

import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import imc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements e {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void b(Object r8) {
        if ((r8 instanceof d) == true) goto L5;
        return;
    L5:
        d r9 = (d) r8;
        com.ss.ugc.live.sdk.msg.data.c r0 = r9.c;
        SdkResponse r1 = r9.d;
        UMGWEventData r10 = r9.a;
        this.a.a = r0;
        String r2 = com.ss.ugc.live.sdk.msg.utils.c.b(r10.params);
        if (r2 != null) goto L9;
        r2 = r1.internal_ext;
    L9:
        if (r2 == null) goto L11;
        this.a.b = r2;
    L11:
        List<UMGWCustomData> r3 = r10.params;
        String r4 = null;
        if (r3 == null) goto L23;
        Iterator<T> r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (StringsKt.equals("im-cursor", ((UMGWCustomData) r6).key, true) == false) goto L15;
    L20:
        UMGWCustomData r7 = (UMGWCustomData) r6;
        if (r7 == null) goto L23;
        String r11 = r7.value;
    L24:
        if (r11 != null) goto L27;
        r11 = r1.cursor;
    L27:
        if (r11 == null) goto L29;
        this.a.c = r11;
    L29:
        List<UMGWCustomData> r12 = r10.params;
        if (r12 == null) goto L41;
        Iterator<T> r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L37;
        Object r14 = r13.next();
        if (StringsKt.equals("im-live_cursor", ((UMGWCustomData) r14).key, true) == false) goto L33;
    L38:
        UMGWCustomData r15 = (UMGWCustomData) r14;
        if (r15 == null) goto L41;
        String r16 = r15.value;
    L42:
        if (r16 != null) goto L45;
        r16 = r1.live_cursor;
    L45:
        if (r16 == null) goto L47;
        a.k = r16;
    L47:
        List<UMGWCustomData> r17 = r10.params;
        if (r17 == null) goto L59;
        Iterator<T> r18 = r17.iterator();
    L51:
        if (r18.hasNext() == false) goto L55;
        Object r19 = r18.next();
        if (StringsKt.equals("im-wrds_preload_ext", ((UMGWCustomData) r19).key, true) == false) goto L51;
    L56:
        UMGWCustomData r20 = (UMGWCustomData) r19;
        if (r20 == null) goto L59;
        r4 = r20.value;
        goto L59
    L55:
        r19 = null;
    L59:
        if (r4 == null) goto L71;
        a.l = r4;
        return;
    L71:
        return;
    L37:
        r14 = null;
    L41:
        r16 = null;
        goto L42
    L19:
        r6 = null;
    L23:
        r11 = null;
        goto L24
    }

    @Override // imc.e
    public final d a(UMGWEventData r23, boolean r24, long r25) {
        long r4 = System.currentTimeMillis();
        if (r24 == false) goto L15;
        a r6 = this.a;
        if (r6.j == null) goto L15;
        int r9 = r6.f;
        int r10 = r6.g;
        String r11 = PayloadItemType.PAYLOAD_TYPE_UMGW.getType();
        byte[] r13 = r23.payload.toByteArray();
        List<UMGWCustomData> r7 = r23.params;
        if (r7 == null) goto L13;
        List<UMGWCustomData> r8 = r7;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r14 = r8.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        UMGWCustomData r15 = (UMGWCustomData) r14.next();
        r12.add(new com.ss.ugc.live.sdk.msg.network.d(r15.key, r15.value));
        goto L10
    L12:
        List r16 = r12;
    L14:
        SdkResponse r17 = (SdkResponse) SdkResponse.ADAPTER.decode(this.a.j.b(new f(r9, r10, r11, "pb", r13, r16, 0, 0)));
    L16:
        ArrayList r18 = new ArrayList();
        com.ss.ugc.live.sdk.msg.data.c r19 = new com.ss.ugc.live.sdk.msg.data.c();
        List<SdkMessage> r20 = r17.messages;
        if (r20 != null) goto L19;
    L22:
        boolean r21 = true;
    L23:
        if (r21 == true) goto L66;
        long r110 = System.currentTimeMillis();
        r19.e = r17.messages.size();
        Iterator r22 = r17.messages.iterator();
    L26:
        if (r22.hasNext() == false) goto L62;
        SdkMessage r111 = (SdkMessage) r22.next();
        Long r112 = r17.now;
        if (r112 == null) goto L30;
        long r113 = r112.longValue();
    L31:
        List<UMGWCustomData> r114 = r23.params;
        int r115 = com.ss.ugc.live.sdk.msg.utils.c.a;
        Long r116 = null;
        if (r114 == null) goto L46;
        Iterator r117 = r114.iterator();
    L35:
        if (r117.hasNext() == false) goto L40;
        Object r118 = r117.next();
        Iterator r119 = r22;
        Iterator r120 = r117;
        long r26 = r113;
        if (StringsKt.equals("im-now", ((UMGWCustomData) r118).key, true) == true) goto L41;
        r22 = r119;
        r117 = r120;
        r113 = r26;
    L41:
        UMGWCustomData r27 = (UMGWCustomData) r118;
        if (r27 == null) goto L47;
        String r28 = r27.value;
        if (r28 == null) goto L47;
        r116 = StringsKt.toLongOrNull(r28);
    L47:
        if (r116 == null) goto L49;
        long r29 = r116.longValue();
    L50:
        r111.timestamp = r29;
        tlc.d r30 = this.a.i.a(r111);
        if (r30 == null) goto L56;
        r30.setMessageMethod(r111.method);
        r30.setReceiveTime(r25);
        if ((r30 instanceof xlc.b) == false) goto L55;
        xlc.b r121 = (xlc.b) r30;
        r121.setWRDSMessage(r111.need_wrds_store.booleanValue());
        r121.setWRDSVersion(r111.wrds_version.longValue());
        r121.setWRDSSubKey(r111.wrds_sub_key);
    L55:
        r18.add(r30);
    L61:
        r22 = r119;
        goto L26
    L56:
        Long r31 = r111.msg_id;
        LinkedHashSet<Long> r122 = r19.f;
        if (r31 == null) goto L59;
        long r123 = r31.longValue();
    L60:
        r122.add(Long.valueOf(r123));
        goto L61
    L59:
        r123 = -1;
        goto L60
    L49:
        r29 = r26;
        goto L50
    L40:
        r119 = r22;
        r26 = r113;
        r118 = null;
        goto L41
    L46:
        r119 = r22;
        r26 = r113;
        goto L47
    L30:
        r113 = System.currentTimeMillis();
        goto L31
    L62:
        long r32 = System.currentTimeMillis();
        Iterator r124 = r18.iterator();
    L64:
        if (r124.hasNext() == false) goto L66;
        tlc.d r125 = (tlc.d) r124.next();
        r125.setDecodeStartTime(r110);
        r125.setDecodeEndTime(r32);
    L66:
        r19.a = r25;
        r19.b = r4;
        r19.c = System.currentTimeMillis();
        return new d(r23, r18, r19, r17);
    L19:
        if (r20.isEmpty() == true) goto L22;
        r21 = false;
        goto L23
    L13:
        r16 = CollectionsKt.emptyList();
    L15:
        r17 = (SdkResponse) SdkResponse.ADAPTER.decode(r23.payload);
        goto L16
    }
}
