package com.larus.dora.impl.ota.g;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/impl/ota/g/CheckRemoteResponse;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin$checkPeripheralInner$2", f = "DoraGOTAPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGOTAPlugin$checkPeripheralInner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends CheckRemoteResponse>>, Object> {
    final /* synthetic */ long $buildTime;
    final /* synthetic */ long $id;
    final /* synthetic */ String $ip;
    final /* synthetic */ String $md5;
    final /* synthetic */ String $model;
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $onlyCheck;
    final /* synthetic */ long $size;
    final /* synthetic */ int $type;
    final /* synthetic */ String $url;
    final /* synthetic */ String $version;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkPeripheralInner$2(long r4, long r6, int r8, String r9, boolean r10, String r11, String r12, String r13, String r14, String r15, long r16, DoraGOTAPlugin r18, Continuation<? super DoraGOTAPlugin$checkPeripheralInner$2> r110) {
        this.$id = r4;
        this.$size = r6;
        this.$type = r8;
        this.$url = r9;
        this.$onlyCheck = r10;
        this.$model = r11;
        this.$ip = r12;
        this.$md5 = r13;
        this.$name = r14;
        this.$version = r15;
        this.$buildTime = r16;
        this.this$0 = r18;
        super(2, r110);
    }

    public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
        DoraGOTAPlugin$checkPeripheralInner$2 r14 = new DoraGOTAPlugin$checkPeripheralInner$2(this.$id, this.$size, this.$type, this.$url, this.$onlyCheck, this.$model, this.$ip, this.$md5, this.$name, this.$version, this.$buildTime, this.this$0, r21);
        r14.L$0 = r20;
        return r14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<CheckRemoteResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r24);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        long r9 = this.$id;
        long r10 = this.$size;
        int r12 = this.$type;
        String r13 = this.$url;
        boolean r14 = this.$onlyCheck;
        String r15 = this.$model;
        String r0 = this.$ip;
        String r4 = this.$md5;
        String r3 = this.$name;
        String r5 = this.$version;
        long r6 = this.$buildTime;
        DoraGOTAPlugin r1 = this.this$0;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L55
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L55
        r2.put("id", r9);     // Catch: Throwable -> L55
        r2.put("md5", r4);     // Catch: Throwable -> L55
        r2.put("name", r3);     // Catch: Throwable -> L55
        r2.put("size", r10);     // Catch: Throwable -> L55
        r2.put("type", r12);     // Catch: Throwable -> L55
        r2.put("url", r13);     // Catch: Throwable -> L55
        r2.put("version", r5);     // Catch: Throwable -> L55
        r2.put("buildtime", r6);     // Catch: Throwable -> L55
        boolean r7 = true;
        if (r14 == false) goto L8;
        int r11 = 1;
    L9:
        r2.put("only_checked", r11);     // Catch: Throwable -> L55
        if (r15.length() <= 0) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L15;
        r2.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r15);     // Catch: Throwable -> L55
    L15:
        StringBuilder r17 = new StringBuilder("checkPeripheralInner: id=");     // Catch: Throwable -> L55
        r17.append(r9);     // Catch: Throwable -> L55
        r17.append(" size=");     // Catch: Throwable -> L55
        r17.append(r10);     // Catch: Throwable -> L55
        r17.append(" type=");     // Catch: Throwable -> L55
        r17.append(r12);     // Catch: Throwable -> L55
        r17.append(" hasUrl=");     // Catch: Throwable -> L55
        if (StringsKt.isBlank(r13) == true) goto L18;
        boolean r18 = true;
    L19:
        r17.append(r18);     // Catch: Throwable -> L55
        r17.append(" onlyCheck=");     // Catch: Throwable -> L55
        if (r14 == false) goto L22;
        boolean r20 = true;
    L23:
        r17.append(r20);     // Catch: Throwable -> L55
        r17.append(" model=");     // Catch: Throwable -> L55
        r17.append(r15);     // Catch: Throwable -> L55
        g49.d.d("DoraGOTAPlugin", r17.toString());     // Catch: Throwable -> L55
        Response r21 = yk4.b.a(new Request.Builder().url("http://" + r0 + "/otaprepare").post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r2.toString())).build());     // Catch: Throwable -> L55
        g49.d.d("DoraGOTAPlugin", "checkPeripheralInner: response=" + r21);     // Catch: Throwable -> L48
        if (r21.isSuccessful() == false) goto L46;
        ResponseBody r23 = r21.body();     // Catch: Throwable -> L48
        if (r23 == null) goto L29;
        String r25 = r23.string();     // Catch: Throwable -> L48
    L30:
        g49.d.d("DoraGOTAPlugin", "checkPeripheralInner: responseBody=" + r25);     // Catch: Throwable -> L48
        if (r25 != null) goto L33;
    L36:
        if (r7 == true) goto L44;
        JSONObject r26 = new JSONObject(r25).optJSONObject("data");     // Catch: Throwable -> L48
        if (r26 == null) goto L42;
        CheckRemoteResponse r27 = (CheckRemoteResponse) r1.b.fromJson(r26.toString(), CheckRemoteResponse.class);     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r21, null);     // Catch: Throwable -> L55
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L55
    L57:
        Throwable r30 = Result.exceptionOrNull-impl(r28);
        if (r30 == null) goto L61;
        g49.d.c("DoraGOTAPlugin", "checkPeripheralInner: tr=" + r30.getMessage(), r30);
    L61:
        return Result.box-impl(r28);
    L42:
        g49.d.b("DoraGOTAPlugin", "checkPeripheralInner: data object is null");     // Catch: Throwable -> L48
        throw new Exception("data object is null");     // Catch: Throwable -> L48
    L44:
        g49.d.b("DoraGOTAPlugin", "checkPeripheralInner: response body is null or empty");     // Catch: Throwable -> L48
        throw new Exception("response body is null or empty");     // Catch: Throwable -> L48
    L33:
        if (r25.length() == 0) goto L36;
        r7 = false;
        goto L36
    L29:
        r25 = null;
        goto L30
    L46:
        g49.d.b("DoraGOTAPlugin", "checkPeripheralInner: call failed with code " + r21.code());     // Catch: Throwable -> L48
        throw new Exception("call failed with code " + r21.code());     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L22:
        r20 = false;
        goto L23
    L18:
        r18 = false;
        goto L19
    L12:
        r16 = false;
        goto L13
    L8:
        r11 = 0;
    L55:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
