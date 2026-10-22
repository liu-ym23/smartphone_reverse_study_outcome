package com.larus.security.api;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object b(List r17, int r18, Continuation r19) {
        AzerothUtils r1 = AzerothUtils.a;
        if (z2.a.L1() == true) goto L8;
        if (r18 != 1) goto L6;
    L7:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        Object r0 = Unit.INSTANCE;
    L66:
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        return r0;
    L69:
        return Unit.INSTANCE;
    L11:
        ArrayList r4 = new ArrayList();
        Iterator r3 = r17.iterator();
    L13:
        if (r3.hasNext() == false) goto L60;
        Message r5 = (Message) r3.next();
        String r6 = r5.getMessageId();
        String r7 = r5.getSectionId();
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L13;
        if (r7 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L13;
        Iterator r10 = CollectionsKt.listOf(new String[]{"inner_log_id", "asr_log_id"}).iterator();
    L31:
        if (r10.hasNext() == false) goto L13;
        String r11 = (String) r10.next();
        Map r12 = r5.getExt();
        AzerothUtils.BatchTokenItem r13 = null;
        if (r12 == null) goto L35;
        String r14 = (String) r12.get(r11);
    L36:
        if (r14 != null) goto L38;
    L41:
        boolean r15 = true;
    L42:
        if (r15 == true) goto L31;
        AzerothUtils r16 = AzerothUtils.a;
        String r110 = AzerothUtils.b(r14, r7, r6);
        if (r110 != null) goto L46;
    L49:
        boolean r111 = true;
    L50:
        if (r111 == true) goto L31;
        AzerothUtils.BatchTokenItem r112 = new AzerothUtils.BatchTokenItem(r14, r110);
        if (r112.getToken().length() <= 0) goto L54;
        boolean r20 = true;
    L56:
        if (Boxing.boxBoolean(r20).booleanValue() == false) goto L58;
        r13 = r112;
    L58:
        r4.add(r13);
        goto L31
    L54:
        r20 = false;
        goto L56
    L46:
        if (r110.length() == 0) goto L49;
        r111 = false;
        goto L50
    L38:
        if (r14.length() == 0) goto L41;
        r15 = false;
        goto L42
    L35:
        r14 = null;
        goto L36
    L24:
        if (r7.length() == 0) goto L27;
        r9 = false;
        goto L28
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
        goto L21
    L60:
        if ((!r4.isEmpty()) == false) goto L64;
        int r21 = p0.a;
        r0 = HttpExtKt.k("Basic", AzerothUtils.SaveTokenObject.class, "/alice/debug/save_token", p0.b(GsonProtectorUtils.toJson(new Gson(), new AzerothUtils.SaveTokenObject(null, null, r4, "", Boxing.boxInt(r18), Boxing.boxInt(0), 3, null))), null, null, false, null, null, null, r19, 1008);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
    L64:
        r0 = Unit.INSTANCE;
        goto L66
    L6:
        if (r18 == 3) goto L7;
    L8:
        r2 = false;
        goto L9
    }

    public static Object a(Message r6, int r7, Integer r8, String r9, Continuation r10) {
        Object r11 = AzerothUtils.a.a(r6, r7, r8, r9, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
