package com.bytedance.android.annie.bridge.method;

import android.util.Pair;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v1<T, R> implements Function {
    public final /* synthetic */ u1.b a;

    public v1(u1.b r1) {
        this.a = r1;
    }

    public final Object apply(Object r13) {
        String r14 = (String) r13;
        Intrinsics.checkNotNullParameter(r14, "it");
        if (r14.hashCode() == 102230) goto L6;
    L8:
        u1.b r15 = this.a;
        e7.s0 r0 = r15.b;
        List<String> r1 = s1.a;
        String r10 = s1.a.a(r0.b());
        byte[] r11 = null;
        if (StringsKt.contains$default(r10, "charset", false, 2, null) == true) goto L12;
        r10 = r10.concat("; charset=UTF-8");
    L12:
        String r12 = r10;
        IAnnieNetworkService r16 = (IAnnieNetworkService) Annie.getService(IAnnieNetworkService.class, r15.d.a());
        String r17 = r0.g();
        Intrinsics.checkNotNull(r17);
        List<Pair<String, String>> r18 = u1.b.c(r0.b());
        JsonObject r19 = r0.a();
        if (r19 != null) goto L16;
    L14:
        byte[] r110 = r11;
        Boolean r111 = r0.d();
        Intrinsics.checkNotNull(r111);
        com.bytedance.android.annie.service.network.d r20 = r16.post(r17, r18, r12, r110, r111).execute();
        u1 r21 = new u1();
        r20.getClass();
        r21.a = r20.a;
        r21.b = r20.b;
        r21.c = r20.c;
        return r15.a(r21);
    L16:
        if (StringsKt.contains$default(r12, "application/json", false, 2, null) == false) goto L18;
    L28:
        String r22 = u1.b.b(r19);
        Charset r23 = Charsets.UTF_8;
        if (r22 == null) goto L35;
        byte[] r24 = r22.getBytes(r23);
    L31:
        r11 = r24;
        goto L14
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        if ((r19 instanceof JsonArray) == true) goto L28;
        ByteArrayOutputStream r25 = new ByteArrayOutputStream();
        Iterator r26 = r19.entrySet().iterator();
    L22:
        if (r26.hasNext() == false) goto L27;
        Map.Entry r27 = (Map.Entry) r26.next();
        if (r25.size() <= 0) goto L26;
        r25.write(38);
    L26:
        String r28 = URLEncoder.encode((String) r27.getKey(), "UTF-8");
        String r29 = URLEncoder.encode(u1.b.b((JsonElement) r27.getValue()), "UTF-8");
        r25.write(r28.getBytes(Charset.forName("UTF-8")));
        r25.write(61);
        r25.write(r29.getBytes(Charset.forName("UTF-8")));
        goto L22
    L27:
        r24 = r25.toByteArray();
        goto L31
    L6:
        if (r14.equals("get") == false) goto L8;
        u1.b r112 = this.a;
        e7.s0 r30 = r112.b;
        IAnnieNetworkService r31 = (IAnnieNetworkService) Annie.getService(IAnnieNetworkService.class, r112.d.a());
        String r32 = r30.g();
        Intrinsics.checkNotNull(r32);
        List<Pair<String, String>> r33 = u1.b.c(r30.b());
        Boolean r34 = r30.d();
        Intrinsics.checkNotNull(r34);
        com.bytedance.android.annie.service.network.d r35 = r31.get(r32, r33, r34).execute();
        u1 r36 = new u1();
        r35.getClass();
        r36.a = r35.a;
        r36.b = r35.b;
        r36.c = r35.c;
        return r112.a(r36);
    }
}
