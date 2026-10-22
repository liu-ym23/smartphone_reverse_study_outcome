package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.JsonException;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.StatusCodeException;
import com.ss.ugc.effectplatform.extension.c;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.e;
import dlc.a;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class BaseNetworkTask<T, R extends e<T>> extends BaseTask {
    public String g;
    public final INetworkClient h;
    public final a i;
    public final hlc.a j;
    public final String k;
    public final boolean l;
    public final EffectConfig m;

    public abstract NetRequest f();

    public String g(String r1) {
        return r1;
    }

    public int h() {
        return 10002;
    }

    public int i() {
        return 1;
    }

    public R o(a r1, ByteReadStream r2) {
        return null;
    }

    public abstract R p(a r1, String r2);

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public void a() {
        int r0 = b0.a.a;
        long r12 = System.currentTimeMillis();
        int r1 = i();
        NetRequest r14 = f();
        String r9 = null;
    L3:
        int r16 = r1 - 1;
        if (r1 == 0) goto L93;
    L65:
        th = th;
        String r22 = r9;
    L58:
        int r15 = -2;
    L67:
        if (r16 == 0) goto L73;
        if ((th instanceof StatusCodeException) == true) goto L73;
        r9 = r22;
    L72:
        r1 = r16;
    L73:
        String r2 = r14.getUrl();
        String r3 = bytekn.foundation.utils.e.a(r2);     // Catch: Exception -> L76
    L78:
        if ((th instanceof Exception) == false) goto L80;
        ExceptionResult r4 = new ExceptionResult(th);
    L82:
        if (Intrinsics.areEqual(th.getMessage(), "java.io.IOException: Underlying input stream returned zero bytes") == false) goto L85;
        r4.setErrorCode(r15);
    L85:
        if ((!StringsKt.isBlank(this.g)) == false) goto L91;
        String r5 = r4.getMsg();
        if (r5 != null) goto L89;
    L90:
        r4.setMsg("[LogId:" + this.g + "], " + r4.getMsg());
        goto L91
    L89:
        if (StringsKt.contains$default(r5, "logId", false, 2, null) != true) goto L90;
    L91:
        r4.setLogId(this.g);
        k(r2, r3, r4);
        Logger.INSTANCE.e("BaseNetworkTask", "fetch from network failed", th);
        return;
    L80:
        r4 = new ExceptionResult(10025);
        r4.setMsg(th.getMessage());
    L76:
        r3 = null;
        goto L78
    L7:
        if (this.b == true) goto L8;
        INetworkClient r6 = this.h;     // Catch: Throwable -> L65
        if (r6 == null) goto L62;
        NetResponse r7 = r6.fetchFromNetwork(r14);     // Catch: Throwable -> L65
        if (r7 == null) goto L62;
        String r8 = r7.getLogId();     // Catch: Throwable -> L65
        String r10 = "";
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        this.g = r8;     // Catch: Throwable -> L65
        int r11 = b0.a.a;     // Catch: Throwable -> L65
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L65
        a r13 = this.i;     // Catch: Throwable -> L65
        if (r13 == null) goto L60;
        EffectConfig r18 = this.m;     // Catch: Throwable -> L65
        if (r18 != null) goto L105;
    L34:
        String r21 = r9;
        Pair<R, String> r19 = n(r7, r13);     // Catch: Throwable -> L56
        String r20 = (String) r19.getSecond();     // Catch: Throwable -> L56
        e r23 = (e) r19.getFirst();     // Catch: Throwable -> L56
        String r24 = r20;
    L35:
        if (r23 == null) goto L55;
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L56
        if (r23.getStatusCode() != 0) goto L53;
        if (r23.checkValue() == false) goto L100;
    L56:
        th = th;
    L57:
        r22 = r21;
        goto L58
    L41:
        if (this.l == true) goto L46;
        m(r12, r17, r110, r24, r23);     // Catch: Throwable -> L63
        j(r12, r17, r110);     // Catch: Throwable -> L63
        return;
    L46:
        if (r23.verifySign() == false) goto L50;
        m(r12, r17, r110, r24, r23);     // Catch: Throwable -> L63
        j(r12, r17, r110);     // Catch: Throwable -> L63
        return;
    L50:
        throw new IllegalArgumentException('[' + getTag() + "][verify failed][LogId:" + this.g + ']');     // Catch: Throwable -> L63
    L100:
        r22 = r21;
        r15 = -2;
        r9 = "logId: " + this.g + ", " + r23.getResponseMessage();     // Catch: Throwable -> L63
    L63:
        th = th;
        goto L67
    L53:
        throw new StatusCodeException(r23.getStatusCode(), '[' + getTag() + "][LogId:" + this.g + "], " + r23.getResponseMessage());     // Catch: Throwable -> L63
    L55:
        throw new JsonException('[' + getTag() + "][json parser returned null!][LogId:" + this.g + ']');     // Catch: Throwable -> L63
    L105:
    L32:
        th = th;
        r21 = r9;
        goto L57
    L23:
        if (r18.W != 1) goto L34;
        e r25 = o(r13, r7.getBodyStream());     // Catch: Throwable -> L65
        if (r25 == null) goto L30;
        Logger r26 = Logger.INSTANCE;     // Catch: Throwable -> L65
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L65
        r27.append("[FetchList][ID: ");     // Catch: Throwable -> L65
        r27.append(this.k);     // Catch: Throwable -> L65
        r27.append("][");     // Catch: Throwable -> L65
        r27.append(getTag());     // Catch: Throwable -> L65
        r27.append("][Json-2][");     // Catch: Throwable -> L65
        r21 = r9;
        r27.append(System.currentTimeMillis() - r17);     // Catch: Throwable -> L56
        r27.append(']');     // Catch: Throwable -> L56
        r26.d("JKL", r27.toString());     // Catch: Throwable -> L56
    L31:
        r23 = r25;
        r24 = r10;
        goto L35
    L30:
        r21 = r9;
        Pair<R, String> r28 = n(r7, this.i);     // Catch: Throwable -> L56
        r10 = (String) r28.getSecond();     // Catch: Throwable -> L56
        r25 = (e) r28.getFirst();     // Catch: Throwable -> L56
        goto L31
    L60:
        throw new RuntimeException('[' + getTag() + "][json converter is null][LogId:" + this.g + ']');     // Catch: Throwable -> L63
    L62:
        throw new NetException(-2, '[' + getTag() + "][Net response returned null!]");     // Catch: Throwable -> L63
    L8:
        return;
    L93:
        String r29 = r9;
        ExceptionResult r30 = new ExceptionResult(h());
        if (r29 == null) goto L96;
        r30.setMsg(r29);
    L96:
        r30.setLogId(this.g);
        k(null, null, r30);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new onCancel.1(this));
    }

    public final Pair<R, String> n(NetResponse r9, a r10) {
        int r0 = b0.a.a;
        long r1 = System.currentTimeMillis();
        String r2 = c.a(r9.getBodyStream());
        long r3 = System.currentTimeMillis() - r1;
        if (r2.length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L11;
        String r11 = g(r2);
        long r5 = System.currentTimeMillis();
        e r12 = p(r10, r11);
        Logger.INSTANCE.d("JKL", "[FetchList][ID: " + this.k + "][" + getTag() + "][String - " + r3 + "][Json - " + (System.currentTimeMillis() - r5) + ']');
        return new Pair(r12, r11);
    L11:
        throw new NetException(-2, "[LogId:" + this.g + "][net response returned empty response!][LogId:" + this.g + "][errorMsg: " + r9.getErrorMsg() + ']');
    L5:
        r4 = false;
        goto L7
    }

    public final void j(long r5, long r7, long r9) {
        Logger r0 = Logger.INSTANCE;
        StringBuilder r1 = new StringBuilder("[FetchList][ID: ");
        r1.append(this.k);
        r1.append("][");
        r1.append(getTag());
        r1.append("][Net - ");
        r1.append(r7 - r5);
        r1.append("][Json - ");
        r1.append(r9 - r7);
        r1.append("][Disk - ");
        int r8 = b0.a.a;
        r1.append(System.currentTimeMillis() - r9);
        r1.append("][Total - ");
        r1.append(System.currentTimeMillis() - r5);
        r1.append(']');
        r0.w("JKL", r1.toString());
    }

    public void k(String r1, String r2, final ExceptionResult r3) {
        if (this.k == null) goto L6;
        e(new BaseNetworkTask$onFailure$$inlined$apply$lambda$1(this, r3));
        return;
    }

    public void l(long r1, long r3, long r5, R r7) {
        Object r2 = r7.getResponseData();
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.k == null) goto L9;
        e(new BaseNetworkTask$onSuccess$.inlined.apply.lambda.1(this, r2));
        return;
    }

    public /* synthetic */ BaseNetworkTask(INetworkClient r8, a r9, hlc.a r10, String r11, boolean r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public void m(long r9, long r11, long r13, String r15, R r16) {
        l(r9, r11, r13, r16);
    }

    public BaseNetworkTask(INetworkClient r1, a r2, hlc.a r3, String r4, boolean r5, EffectConfig r6) {
        super(r4, r3);
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.g = "";
    }
}
