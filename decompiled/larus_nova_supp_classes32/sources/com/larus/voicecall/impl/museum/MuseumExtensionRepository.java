package com.larus.voicecall.impl.museum;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MuseumExtensionRepository {
    public static final MuseumExtensionRepository a = null;

    static {
        a = new MuseumExtensionRepository();
    }

    public MuseumExtensionRepository() {
    }

    public final Object a(String r18, String r19, Continuation<? super j> r20) {
        if ((r20 instanceof MuseumExtensionRepository$pickExtension$1) == false) goto L7;
        MuseumExtensionRepository$pickExtension$1 r1 = (MuseumExtensionRepository$pickExtension$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MuseumExtensionRepository$pickExtension$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        JSONObject r5 = (JSONObject) r13.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        com.larus.network.http.f r6 = (com.larus.network.http.a) r0;
        boolean r7 = false;
        String r8 = null;
        if ((r6 instanceof com.larus.network.http.f) == false) goto L22;
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("[shortLink][response][fail] path=/alice/call/pick_extension body=");
        r10.append(r5);
        r10.append(" code=");
        com.larus.network.http.f r11 = r6;
        r10.append(r11.d.getCode());
        r10.append(", msg=");
        r10.append(r11.d.getMessage());
        r9.e("MuseumExtensionDebug", r10.toString());
        return new j(false, null, null, "network_error");
    L22:
        i r12 = (i) ((com.larus.network.http.a) r6).b;
        boolean r14 = r6 instanceof y;
        if (r14 == false) goto L53;
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[shortLink][response][success] path=/alice/call/pick_extension httpCode=");
        y r17 = (y) r6;
        r16.append(r17.g);
        r16.append(", httpMsg=");
        r16.append(r17.f);
        r16.append(", bizCode=");
        if (r12 == null) goto L27;
        Integer r110 = r12.a();
    L28:
        r16.append(r110);
        r16.append(", bizSuccess=");
        if (r12 == null) goto L31;
        Boolean r111 = r12.e();
    L32:
        r16.append(r111);
        r16.append(", bizMsg=");
        if (r12 == null) goto L35;
        String r112 = r12.d();
    L36:
        r16.append(r112);
        r16.append(", message=");
        if (r12 == null) goto L39;
        String r113 = r12.c();
    L40:
        r16.append(r113);
        r16.append(", grantDuration=");
        if (r12 == null) goto L45;
        h r114 = r12.b();
        if (r114 == null) goto L45;
        Long r115 = r114.b();
    L46:
        r16.append(r115);
        r16.append(", failReason=");
        if (r12 == null) goto L51;
        h r116 = r12.b();
        if (r116 == null) goto L51;
        String r117 = r116.a();
    L52:
        r16.append(r117);
        r16.append(", raw=");
        r16.append(((com.larus.network.http.a) r17).c);
        r15.i(r14, r16.toString());
    L54:
        if (r14 == false) goto L62;
        if (r12 != null) goto L62;
        Long r21 = ((y) r6).g;
        if (r21 == null) goto L62;
        if (r21.longValue() != 0) goto L62;
        boolean r22 = true;
    L63:
        if (r12 == null) goto L65;
        boolean r23 = Intrinsics.areEqual(r12.e(), Boxing.boxBoolean(true));
    L66:
        if (r23 == true) goto L77;
        if (r12 == null) goto L74;
        Integer r24 = r12.a();
        if (r24 == null) goto L74;
        if (r24.intValue() != 0) goto L74;
        boolean r25 = true;
    L75:
        if (r25 == true) goto L77;
        if (r22 == true) goto L77;
    L78:
        FLogger r26 = FLogger.a;
        StringBuilder r118 = new StringBuilder("[shortLink][response][parsed] path=/alice/call/pick_extension success=");
        r118.append(r7);
        r118.append(", emptyBodyAsSuccess=");
        r118.append(r22);
        r118.append(", httpCode=");
        if (r14 == false) goto L81;
        y r27 = (y) r6;
    L82:
        if (r27 == null) goto L84;
        Long r28 = r27.g;
    L85:
        r118.append(r28);
        r118.append(", bizCode=");
        if (r12 == null) goto L88;
        Integer r29 = r12.a();
    L89:
        r118.append(r29);
        r118.append(", bizSuccess=");
        if (r12 == null) goto L92;
        Boolean r30 = r12.e();
    L93:
        r118.append(r30);
        r26.i(r14, r118.toString());
        if (r12 == null) goto L97;
        String r31 = r12.d();
        if (r31 == null) goto L97;
    L100:
        if (r12 == null) goto L104;
        h r32 = r12.b();
        if (r32 == null) goto L104;
        Long r33 = r32.b();
    L105:
        if (r7 == true) goto L143;
        if (r12 == null) goto L141;
        h r34 = r12.b();
        if (r34 == null) goto L112;
        String r35 = r34.a();
    L114:
        if (Intrinsics.areEqual(r35, "already_claimed") == false) goto L117;
    L124:
        r8 = "already_claimed";
    L140:
        if (r8 != null) goto L143;
    L117:
        if (Intrinsics.areEqual(r35, "expired") == true) goto L130;
        Integer r36 = r12.a();
        if (r36 != null) goto L123;
    L125:
        Integer r37 = r12.a();
        if (r37 == null) goto L132;
        if (r37.intValue() == 410) goto L130;
    L132:
        if (Intrinsics.areEqual(r12.e(), Boolean.TRUE) == true) goto L140;
        Integer r38 = r12.a();
        if (r38 != null) goto L137;
    L139:
        r8 = "server_error";
        goto L140
    L137:
        if (r38.intValue() != 0) goto L139;
    L123:
        if (r36.intValue() != 409) goto L125;
    L130:
        r8 = "expired";
        goto L140
    L112:
        r35 = null;
    L141:
        r8 = "server_error";
    L143:
        return new j(r7, r31, r33, r8);
    L104:
        r33 = null;
    L97:
        if (r12 == null) goto L99;
        r31 = r12.c();
        goto L100
    L99:
        r31 = null;
        goto L100
    L92:
        r30 = null;
        goto L93
    L88:
        r29 = null;
        goto L89
    L84:
        r28 = null;
        goto L85
    L81:
        r27 = null;
    L74:
        r25 = false;
    L77:
        r7 = true;
        goto L78
    L65:
        r23 = false;
    L62:
        r22 = false;
    L51:
        r117 = null;
    L45:
        r115 = null;
        goto L46
    L39:
        r113 = null;
        goto L40
    L35:
        r112 = null;
        goto L36
    L31:
        r111 = null;
        goto L32
    L27:
        r110 = null;
        goto L28
    L53:
        FLogger.a.i(r14, "[shortLink][response] path=/alice/call/pick_extension result=" + r6.getClass().getSimpleName() + ", response=" + r12);
        goto L54
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        JSONObject r39 = new JSONObject();
        r39.put("museum_name", r18);
        r39.put("stage", r19);
        FLogger.a.i("MuseumExtensionDebug", "[shortLink][request] path=/alice/call/pick_extension body=" + r39 + ", requestFields=museum_name|stage");
        r13.L$0 = r39;
        r13.label = 1;
        Object r40 = HttpExtKt.k("Audio", i.class, "/alice/call/pick_extension", r39, null, null, false, null, null, null, r13, 1008);
        if (r40 != r3) goto L17;
        return r3;
    L17:
        r5 = r39;
        r0 = r40;
    L7:
        r1 = new MuseumExtensionRepository$pickExtension$1(this, r20);
        goto L8
    }
}
