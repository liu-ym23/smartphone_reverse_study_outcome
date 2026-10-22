package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t<T, R> implements Function {
    public final /* synthetic */ s a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JsonObject c;
    public final /* synthetic */ Ref.ObjectRef<JsonObject> d;
    public final /* synthetic */ JsonObject e;

    public t(s r1, String r10, JsonObject r11, Ref.ObjectRef<JsonObject> r12, JsonObject r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final Object apply(Object r12) {
        String r13 = (String) r12;
        Intrinsics.checkNotNullParameter(r13, "it");
        FetchTimingSession r0 = this.a.d;
        if (r0 == null) goto L5;
        r0.recordNetStartTiming();
    L5:
        IAnnieNetworkService r10 = null;
        if (r13.hashCode() == 3446944) goto L9;
    L36:
        s r14 = this.a;
        String r1 = this.b;
        JsonObject r11 = this.c;
        JsonObject r15 = (JsonObject) this.d.element;
        IAnnieNetworkService r16 = r14.c;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("service");
    L40:
        JsonObject r17 = s.k(r10.get(r14.j(r1, r15), r14.l(r11)).execute());
    L41:
        FetchTimingSession r18 = this.a.d;
        if (r18 == null) goto L44;
        r18.recordNetEndTiming();
    L44:
        return r17;
    L39:
        r10 = r16;
        goto L40
    L9:
        if (r13.equals("post") == false) goto L36;
        s r19 = this.a;
        String r20 = this.b;
        JsonObject r21 = this.c;
        JsonObject r22 = (JsonObject) this.d.element;
        JsonObject r23 = this.e;
        r19.getClass();
        JsonElement r24 = r21.get("Content-Type");
        if (r24 == null) goto L13;
        String r25 = r24.getAsString();
    L15:
        if (Intrinsics.areEqual(r25, "application/json") == false) goto L17;
        byte[] r26 = r23.toString().getBytes(Charsets.UTF_8);
        String r27 = "application/json; charset=UTF-8";
    L31:
        IAnnieNetworkService r28 = r19.c;
        if (r28 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("service");
    L35:
        r17 = s.k(r10.post(r19.j(r20, r22), r19.l(r21), r27, r26).execute());
        goto L41
    L34:
        r10 = r28;
        goto L35
    L17:
        ByteArrayOutputStream r29 = new ByteArrayOutputStream();
        Iterator<T> r30 = r23.entrySet().iterator();
    L19:
        if (r30.hasNext() == false) goto L30;
        Map.Entry r31 = (Map.Entry) r30.next();
        if (r29.size() <= 0) goto L23;
        r29.write(38);
    L23:
        String r32 = URLEncoder.encode((String) r31.getKey(), "UTF-8");
        JsonElement r33 = (JsonElement) r31.getValue();
        if (r33 == null) goto L26;
        String r34 = r33.getAsString();
    L27:
        if (r34 != null) goto L29;
        r34 = "";
    L29:
        String r35 = URLEncoder.encode(r34, "UTF-8");
        r29.write(r32.getBytes(Charset.forName("UTF-8")));
        r29.write(61);
        r29.write(r35.getBytes(Charset.forName("UTF-8")));
        goto L19
    L26:
        r34 = null;
        goto L27
    L30:
        r26 = r29.toByteArray();
        r27 = "application/x-www-form-urlencoded; charset=UTF-8";
        goto L31
    L13:
        r25 = null;
        goto L15
    }
}
