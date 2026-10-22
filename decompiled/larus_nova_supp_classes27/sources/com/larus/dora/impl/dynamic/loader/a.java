package com.larus.dora.impl.dynamic.loader;

import android.app.Application;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.dynamic.a2;
import com.larus.dora.impl.dynamic.v1;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel;
import com.larus.dora.impl.dynamic.y1;
import com.larus.dora.impl.dynamic.z1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final g59.d a;
    public final Gson b;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.loader.a$a, reason: collision with other inner class name */
    public static final class C0064a {
    }

    public interface b {
        void a();

        void b(List<com.larus.dora.impl.dynamic.d> r1, com.larus.dora.impl.dynamic.e r2, Map<String, String> r3);

        void onFail(String r1);
    }

    static {
    }

    public a() {
        this.a = new g59.d();
        this.b = new Gson();
    }

    public static void c(a2 r7, b r8) {
        if (r7.a() == null) goto L46;
        boolean r1 = true;
        if ((!r7.a().isEmpty()) == false) goto L46;
        List r0 = CollectionsKt.filterNotNull(r7.a());
        Map<String, String> r2 = null;
        if (r0 == null) goto L14;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        com.larus.dora.impl.dynamic.d r5 = ((v1) r4.next()).a();
        if (r5 == null) goto L10;
        r3.add(r5);
    L15:
        FLogger r6 = FLogger.a;
        StringBuilder r9 = new StringBuilder("cardList size: ");
        if (r3 == null) goto L18;
        int r10 = r3.size();
    L19:
        r9.append(r10);
        r6.e("DoraDynamicDataLoader", r9.toString());
        Map<String, String> r11 = r7.c();
        if (r11 == null) goto L38;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L23:
        if (r13.hasNext() == false) goto L30;
        Map.Entry<String, String> r14 = r13.next();
        if (r14.getValue() == null) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == false) goto L23;
        r12.put(r14.getKey(), r14.getValue());
        goto L23
    L27:
        r15 = false;
        goto L28
    L30:
        LinkedHashMap r16 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator r17 = r12.entrySet().iterator();
    L32:
        if (r17.hasNext() == false) goto L37;
        Map.Entry r18 = (Map.Entry) r17.next();
        Object r20 = r18.getKey();
        String r21 = (String) r18.getValue();
        if (r21 != null) goto L36;
        r21 = "";
    L36:
        r16.put(r20, r21);
        goto L32
    L37:
        r2 = r16;
    L38:
        if (r3 != null) goto L40;
    L42:
        r1 = false;
    L43:
        if (r1 == false) goto L45;
        r8.b(r3, r7.b(), r2);
        return;
    L45:
        r8.a();
        return;
    L40:
        if ((!r3.isEmpty()) != true) goto L42;
    L18:
        r10 = 0;
        goto L19
    L14:
        r3 = null;
    L46:
        r8.a();
    }

    public final void b(CoroutineScope r20, Integer r21, String r22, String r23, DoraDynamicViewModel.g r24) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r24, "callback");
        FLogger.a.i("DoraDynamicDataLoader", "fetchData productId :" + r21 + ",model:" + r22 + ",pageKey:" + r23 + ' ');
        ProductNameType r1 = ProductNameType.DORA_E;
        int r2 = r1.id;
        if (r21 == null) goto L9;
        if (r2 != r21.intValue()) goto L9;
        String r3 = r1.name;
    L12:
        boolean r8 = false;
        String r10 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r3, r23}), "_", null, null, 0, null, null, 62, null).toLowerCase(Locale.US);
        Keva r11 = g49.c.a;     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r10, "key");     // Catch: Exception -> L32
        String r12 = g49.c.a.getString("key_http_response" + r10, "");     // Catch: Exception -> L32
        g59.f.a(r10);     // Catch: Exception -> L32
        if (r12.length() <= 0) goto L16;
        r8 = true;
    L16:
        if (r8 == true) goto L39;
        g59.d r4 = this.a;     // Catch: Exception -> L32
        Application r5 = AppHost.a.getApplication();     // Catch: Exception -> L32
        if (r23 == null) goto L25;
        r0 = r23;
    L25:
        if (r21 == null) goto L27;
        int r9 = r21.intValue();     // Catch: Exception -> L32
    L28:
        a2 r6 = r4.a(r5, r0, r9);     // Catch: Exception -> L32
        if (r6 == null) goto L34;
        c(r6, r24);     // Catch: Exception -> L32
    L34:
        if (r20 == null) goto L36;
        BuildersKt.launch$default(r20, Dispatchers.getIO(), null, new DoraDynamicDataLoader$fetchData$1$1(this, r21, r22, r23, r10, r24, null), 2, null);
    L36:
        Unit r7 = Unit.INSTANCE;
        return;
    L27:
        r9 = Integer.MAX_VALUE;
        goto L28
    L39:
        c((a2) this.b.fromJson(r12, a2.class), r24);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.a.e("DoraDynamicDataLoader", "JSON parsing error: " + e.getMessage());     // Catch: Exception -> L32
    L32:
        e = move-exception;
        FLogger.a.e("DoraDynamicDataLoader", "local fetchData error: " + e.getMessage());
        r24.onFail("local fetchData error: " + e.getMessage());
    L9:
        if (o59.a.o(r21) == false) goto L11;
        r3 = ProductNameType.DORA_G.name;
        goto L12
    L11:
        r3 = ProductNameType.DORA_LITE.name;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.dynamic.loader.a$b] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.dora.impl.dynamic.loader.a$b] */
    public static final Object a(a r16, Integer r17, String r18, String r110, String r20, b r21, Continuation r22) {
        r16.getClass();
        ?? r2 = "Requesting data - productId:";
        if ((r22 instanceof DoraDynamicDataLoader$requestAndProcessData$1) == false) goto L7;
        DoraDynamicDataLoader$requestAndProcessData$1 r3 = (DoraDynamicDataLoader$requestAndProcessData$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraDynamicDataLoader$requestAndProcessData$1 r8 = r3;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        boolean r10 = true;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        b r6 = (b) r8.L$1;
        String r7 = (String) r8.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L14
        Object r11 = r1;
        String r12 = r7;
        r2 = r6;
    L24:
        z1 r13 = (z1) r11;     // Catch: Exception -> L14
        if (r13 == null) goto L48;
        y1 r14 = r13.b();     // Catch: Exception -> L14
        Map<String, String> r15 = null;
        if (r14 == null) goto L29;
        String r23 = r14.a();     // Catch: Exception -> L14
    L30:
        if (r23 != null) goto L32;
        r23 = "";
    L32:
        com.larus.dora.impl.dynamic.c r24 = r13.a();     // Catch: Exception -> L14
        if (r24 == null) goto L35;
        r15 = r24.a();     // Catch: Exception -> L14
    L35:
        g49.d.d("DoraDynamicDataLoader", "starlingMap: " + r15);     // Catch: Exception -> L14
        int r25 = 0;
    L37:
        if (r25 >= r23.length()) goto L57;
        int r26 = RangesKt.coerceAtMost(r25 + 2000, r23.length());     // Catch: Exception -> L14
        if (r10 == false) goto L41;
        String r27 = "**##" + r23.substring(r25, r26);     // Catch: Exception -> L14
    L42:
        g49.d.d("DoraDynamicDataLoader", r27);     // Catch: Exception -> L14
        r25 = r26;
        r10 = false;
        goto L37
    L41:
        r27 = r23.substring(r25, r26);     // Catch: Exception -> L14
        goto L42
    L57:
        a2 r28 = (a2) r16.b.fromJson(r23, a2.class);     // Catch: Exception -> L46
        g49.c.a(r12, r23);     // Catch: Exception -> L46
        String r0 = r16.b.toJson(r15);     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r12, "key");     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r0, "value");     // Catch: Exception -> L46
        g49.c.a.storeString("dora_key_http_response_starling" + r12, r0);     // Catch: Exception -> L46
        c(r28, r2);     // Catch: Exception -> L46
    L54:
        return Unit.INSTANCE;
    L46:
        e = move-exception;
        FLogger.a.e("DoraDynamicDataLoader", "JSON parsing error: " + e.getMessage());     // Catch: Exception -> L14
        goto L54
    L29:
        r23 = null;
        goto L30
    L48:
        r2.onFail("Network request failed");     // Catch: Exception -> L14
        goto L54
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        FLogger.a.e("DoraDynamicDataLoader", "Requesting data - productId:" + r17 + ", model:" + r18 + ", pageKey:" + r110);     // Catch: Exception -> L50
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Exception -> L50
        DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1 r112 = new DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1(r16, r17, r18, r110, null);     // Catch: Exception -> L50
        r12 = r20;
        r8.L$0 = r12;     // Catch: Exception -> L50
        b r30 = r21;
        r8.L$1 = r30;     // Catch: Exception -> L14
        r8.label = 1;     // Catch: Exception -> L14
        r11 = BuildersKt.withContext(r111, r112, r8);     // Catch: Exception -> L14
        r2 = r30;
        if (r11 != r9) goto L24;
        return r9;
    L50:
        e = e;
        r2 = r21;
    L52:
        FLogger.a.e("DoraDynamicDataLoader", "fetchData error: " + e.getMessage());
        r2.onFail(e.getMessage());
    L14:
        e = e;
    L7:
        r3 = new DoraDynamicDataLoader$requestAndProcessData$1(r16, r22);
        goto L8
    }
}
