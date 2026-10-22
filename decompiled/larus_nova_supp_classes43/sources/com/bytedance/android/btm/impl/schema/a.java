package com.bytedance.android.btm.impl.schema;

import android.os.Handler;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.h;
import com.bytedance.android.btm.impl.setting.u;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ h c;

    /* JADX INFO: renamed from: com.bytedance.android.btm.impl.schema.a$a, reason: collision with other inner class name */
    public static final class RunnableC0110a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public RunnableC0110a(a r1, String r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.call(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(String r1, String r10, h r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        Object r0 = SchemaUtils.a;
        final String r1 = this.a;
        if (Intrinsics.areEqual(r1, "") == false) goto L89;
    L20:
        SchemaUtils r10 = SchemaUtils.j;
        String r11 = this.b;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = r11;
        if (SchemaUtils.b == true) goto L49;
        monitor-enter(r10);
    L46:
        th = move-exception;
        throw th;
    L24:
        if (SchemaUtils.b == false) goto L27;
        monitor-exit(r10);
        goto L49
    L27:
        BtmHostDependManager r13 = BtmHostDependManager.F;     // Catch: Throwable -> L46
        r13.getClass();     // Catch: Throwable -> L46
        if (((zc.h) BtmHostDependManager.h.getValue(r13, BtmHostDependManager.a[6])) != null) goto L32;
        ALogger.m(ALogger.d, "SchemaUtils_init", SchemaUtils$init$1.INSTANCE);     // Catch: Throwable -> L46
        monitor-exit(r10);
        goto L49
    L32:
        ALogger r14 = ALogger.d;     // Catch: Throwable -> L46
        ALogger.m(r14, "SchemaUtils_init", SchemaUtils$init$2.INSTANCE);     // Catch: Throwable -> L46
        SchemaUtils.g.clear();     // Catch: Throwable -> L46
        SchemaUtils.h.clear();     // Catch: Throwable -> L46
        SchemaUtils.f.clear();     // Catch: Throwable -> L46
        SchemaUtils.d.clear();     // Catch: Throwable -> L46
        SchemaSetting.g.getClass();     // Catch: Throwable -> L46
        if (SchemaSetting.b == false) goto L39;
        if (SchemaUtils.c <= 0) goto L37;
        SchemaSetting.a();     // Catch: Throwable -> L46
        SchemaUtils.c--;     // Catch: Throwable -> L46
        goto L39
    L37:
        ALogger.m(r14, "SchemaUtils_init", SchemaUtils$init$3.INSTANCE);     // Catch: Throwable -> L46
    L39:
        if (SchemaSetting.b == true) goto L43;
        SchemaUtils.b = true;     // Catch: Throwable -> L46
        final u r15 = SchemaSetting.c;     // Catch: Throwable -> L46
        SchemaUtils.b(r15);     // Catch: Throwable -> L46
        ALogger.m(r14, "SchemaUtils_init", new SchemaUtils$init$4(r15));     // Catch: Throwable -> L46
        monitor-exit(r10);
        goto L49
    L43:
        ALogger.m(r14, "SchemaUtils_init", SchemaUtils$init$5.INSTANCE);     // Catch: Throwable -> L46
        monitor-exit(r10);
    L49:
        ConcurrentHashMap<String, List<String>> r16 = SchemaUtils.d;
        if (r16.size() != 0) goto L53;
        String r17 = (String) r12.element;
    L87:
        ((Handler) SchemaUtils.e.getValue()).post(new RunnableC0110a(this, r17, UriProtector.getQueryParameter(UriProtector.parse(this.a), "source_btm_token")));
        return;
    L53:
        if (SchemaUtils.h.containsKey(r1) == false) goto L55;
        r17 = (String) r12.element;
        goto L87
    L55:
        Map<String, String> r18 = SchemaUtils.g;
        if (r18.containsKey(r1) == false) goto L61;
        r17 = r18.get(r1);
        if (r17 != null) goto L87;
        r17 = "";
        goto L87
    L61:
        final Ref.IntRef r19 = new Ref.IntRef();
        r19.element = 0;
        Iterator<Map.Entry<String, List<String>>> r20 = r16.entrySet().iterator();
    L63:
        if (r20.hasNext() == false) goto L80;
        Map.Entry<String, List<String>> r21 = r20.next();
        Iterator<T> r22 = r21.getValue().iterator();
    L66:
        if (r22.hasNext() == false) goto L76;
        String r23 = (String) r22.next();
        Map<String, Regex> r110 = SchemaUtils.f;
        Regex r111 = r110.get(r23);
        if (r111 == null) goto L91;
    L72:
        if (r111 == null) goto L66;
        if (r111.matches(r1) == false) goto L66;
        boolean r24 = true;
    L77:
        if (r24 == false) goto L63;
        r12.element = r21.getKey();
        r19.element++;
        if (BtmHostDependManager.F.c() == true) goto L63;
    L91:
        Regex r112 = new Regex(r23);     // Catch: Throwable -> L71
        r110.put(r23, r112);     // Catch: Throwable -> L71
        r111 = r112;
        goto L72
    L76:
        r24 = false;
    L80:
        int r25 = r19.element;
        if (r25 == 0) goto L85;
        if (r25 == 1) goto L84;
        ALogger.m(ALogger.d, "SchemaUtils_getPageBtmWithSchema", new SchemaUtils$getPageBtmWithSchema$1(r1, r19, r12));
    L86:
        r17 = (String) r12.element;
        goto L87
    L84:
        SchemaUtils.g.put(r1, (String) r12.element);
        goto L86
    L85:
        SchemaUtils.h.put(r1, SchemaUtils.a);
        goto L86
    L89:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L17
        String r27 = URLDecoder.decode(r1, "utf-8");     // Catch: Throwable -> L17
        int r28 = 1;
    L8:
        if ((!Intrinsics.areEqual(r1, r27)) == false) goto L15;
        if (r28 >= 5) goto L15;
        r28 = r28 + 1;
        String r113 = r27;
        r27 = URLDecoder.decode(r27, "utf-8");     // Catch: Throwable -> L13
        r1 = r113;
    L13:
        Throwable th2 = th;
        String r29 = r27;
    L19:
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th2));
        r1 = r29;
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r29 = r1;
        th2 = th;
        goto L19
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
