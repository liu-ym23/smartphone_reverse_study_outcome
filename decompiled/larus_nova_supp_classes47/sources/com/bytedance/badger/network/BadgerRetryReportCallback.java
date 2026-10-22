package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.e;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u008a\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0001j\u0002`\u0011B¯\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0095\u0001\b\u0002\u0010\"\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0001j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b&\u0010'J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R¤\u0001\u0010\"\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0001j\u0004\u0018\u0001`\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/badger/network/BadgerRetryReportCallback;", "Lkotlin/Function6;", "", "Lkotlin/ParameterName;", "name", "success", "", "logid", "Lcom/bytedance/badger/network/a0;", "requestBundle", "Lcom/bytedance/badger/network/b0;", "responseBundle", "Lcom/bytedance/badger/network/l0;", "retryInfo", "Lcom/bytedance/badger/C/a;", "compensateType", "", "Lcom/bytedance/badger/network/BadgerNetworkRetryCallback;", "Lkotlin/Pair;", "", "parseResponse", "(Lcom/bytedance/badger/network/b0;)Lkotlin/Pair;", "invoke", "(ZLjava/lang/String;Lcom/bytedance/badger/network/a0;Lcom/bytedance/badger/network/b0;Lcom/bytedance/badger/network/l0;Lcom/bytedance/badger/C/a;)V", "Lz64/b;", "report", "Lz64/b;", "getReport", "()Lz64/b;", "Lcom/bytedance/badger/network/n0;", "reportContext", "Lcom/bytedance/badger/network/n0;", "getReportContext", "()Lcom/bytedance/badger/network/n0;", "extraCallback", "Lkotlin/jvm/functions/Function6;", "getExtraCallback", "()Lkotlin/jvm/functions/Function6;", "<init>", "(Lz64/b;Lcom/bytedance/badger/network/n0;Lkotlin/jvm/functions/Function6;)V", "badger-core_release"}, k = 1, mv = {1, 4, 0})
public final class BadgerRetryReportCallback implements Function6 {
    private final Function6 extraCallback;
    private final z64.b report;
    private final n0 reportContext;

    public BadgerRetryReportCallback(z64.b r1, n0 r2, Function6 r3) {
        this.report = r1;
        this.reportContext = r2;
        this.extraCallback = r3;
    }

    public /* synthetic */ BadgerRetryReportCallback(z64.b r1, n0 r2, Function6 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final Function6 getExtraCallback() {
        return this.extraCallback;
    }

    public final z64.b getReport() {
        return this.report;
    }

    public final n0 getReportContext() {
        return this.reportContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r8, Object r9, Object r10, Object r12, Object r13, Object r14) {
        invoke(((Boolean) r8).booleanValue(), (String) r9, (a0) r10, (b0) r12, (l0) r13, (com.bytedance.badger.C.a) r14);
        return Unit.INSTANCE;
    }

    private final Pair parseResponse(b0 r7) {
        int r3 = 0;
        if (r7.d.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        int r4 = -1;
        if (r2 == true) goto L9;
        JSONObject r8 = new JSONObject(r7.d).optJSONObject(Constants.Keys.DATA);     // Catch: JSONException -> L24
        if (r8 == null) goto L13;
        r3 = r8.optInt("error_code");     // Catch: JSONException -> L24
    L13:
        if (r8 != null) goto L33;
    L19:
        String r9 = "";
    L29:
        e.b("BadgerNetwork", "response code=" + r3 + ", message=" + r9);     // Catch: JSONException -> L22
    L28:
        return new Pair(Integer.valueOf(r3), r9);
    L22:
        JSONException e = e;
    L26:
        e.c("BadgerNetwork", "parse response body failed", e);
        goto L28
    L33:
        r9 = r8.optString("description");     // Catch: JSONException -> L17
        if (r9 == null) goto L19;
    L17:
        e = e;
        r4 = r3;
    L25:
        r3 = r4;
        e = e;
        r9 = "Invalid response";
    L24:
        e = e;
        goto L25
    L9:
        return new Pair(-1, "Empty response body");
    L5:
        r2 = false;
        goto L6
    }

    public void invoke(boolean r28, String r29, a0 r30, b0 r32, l0 r33, com.bytedance.badger.C.a r34) {
        e.f("BadgerNetwork", "report retry success: " + r28 + ", logid: " + r29 + ", requestBundle: " + r30 + ", responseBundle: " + r32 + ", retryInfo: " + r33 + ", compensateType " + r34);
        n0 r2 = this.reportContext;
        long r6 = r2.g;
        long r8 = r2.f;
        TriggerStage r10 = r2.d;
        z64.c r13 = r2.a;
        boolean r3 = r2.e;
        Pair r12 = parseResponse(r32);
        int r16 = ((Number) r12.component1()).intValue();
        String r14 = (String) r12.component2();
        if (r28 == false) goto L7;
        if (r16 != 0) goto L7;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.c, r10, CollectStage.report_finished, r13, this.report, 0, SystemClock.elapsedRealtime() - r8, SystemClock.uptimeMillis() - r6, r29, r33, r3, this.reportContext.h.get(), r34, 0, null, 12304);
    L11:
        Function6 r4 = this.extraCallback;
        if (r4 == null) goto L15;
        Unit r1 = (Unit) r4.invoke(Boolean.valueOf(r28), r29, r30, r32, r33, r34);
        return;
    L15:
        return;
    L7:
        if (r33.a() == false) goto L9;
        com.bytedance.badger.monitor.c r15 = com.bytedance.badger.monitor.c.c;
        Throwable r17 = new com.bytedance.badger.utils.c("network failure,retry limit", -1201, CollectStage.report_finished, null, 8);
        long r18 = SystemClock.elapsedRealtime() - r8;
        long r25 = SystemClock.uptimeMillis() - r6;
        long r20 = this.reportContext.h.get();
        int r19 = 0;
        z64.h r23 = null;
        int r24 = 4112;
        com.bytedance.badger.monitor.c r7 = r15;
        Throwable r9 = r17;
    L10:
        com.bytedance.badger.monitor.c.b(r7, r10, r9, r16, r14, r19, r18, r25, r13, r33, r3, r20, r34, r23, r24);
        goto L11
    L9:
        com.bytedance.badger.monitor.c r110 = com.bytedance.badger.monitor.c.c;
        Throwable r111 = new com.bytedance.badger.utils.c("network failure", -1202, CollectStage.report_finished, null, 8);
        r18 = SystemClock.elapsedRealtime() - r8;
        r25 = SystemClock.uptimeMillis() - r6;
        r20 = this.reportContext.h.get();
        r19 = 0;
        r23 = null;
        r24 = 4112;
        r7 = r110;
        r9 = r111;
        goto L10
    }
}
