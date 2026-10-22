package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import hvb.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2", f = "MmNetRequestHandler.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {AppbrandHostConstants.Schema_RESERVED_FIELD.PATH}, s = {"L$0"})
public final class MmNetRequestHandler$sendHttpRequest$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends R>>, Object> {
    final /* synthetic */ gvb.a $request;
    final /* synthetic */ Class<R> $respType;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmNetRequestHandler this$0;

    public MmNetRequestHandler$sendHttpRequest$2(gvb.a r1, MmNetRequestHandler r2, Class<R> r3, Continuation<? super MmNetRequestHandler$sendHttpRequest$2> r4) {
        this.$request = r1;
        this.this$0 = r2;
        this.$respType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmNetRequestHandler$sendHttpRequest$2(this.$request, this.this$0, this.$respType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends R>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2$2$callBack$1, java.lang.Object] */
    public final Object invokeSuspend(Object r29) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        MmNetRequestHandler r1 = (MmNetRequestHandler) this.L$3;
        Class r3 = (Class) this.L$2;
        gvb.a r4 = (gvb.a) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r29);
        return r29;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        final String r6 = this.$request.getPath();
        MmNetRequestHandler r7 = this.this$0;
        int r8 = MmNetRequestHandler.c;
        Result<R> r9 = r7.e(r6);
        if (r9 != null) goto L11;
        final gvb.a r10 = this.$request;
        final Class<R> r11 = this.$respType;
        final MmNetRequestHandler r12 = this.this$0;
        this.L$0 = r6;
        this.L$1 = r10;
        this.L$2 = r11;
        this.L$3 = r12;
        this.label = 1;
        final SafeContinuation r13 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        MmHttpMethod r14 = r10.getMethod();
        MmHttpContentType r15 = r10.getContentType();
        Map<String, String> r16 = r10.a();
        Map<String, String> r17 = r10.e();
        Map<String, String> r18 = r10.f();
        String r19 = r10.c();
        ByteString r110 = r10.b();
        if (r18.isEmpty() == false) goto L23;
        if (r19 != null) goto L16;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == false) goto L23;
        if (r110 != null) goto L23;
        boolean r112 = true;
    L24:
        lvb.a.e("MmNetRequestHandler", "sendHttpRequest: path=" + r6 + ", method=" + r14 + ", contentType=" + r15 + ", respType=" + r11 + ", request=" + r10);
        String r20 = r12.b.J().b();
        if (r16.isEmpty() == false) goto L27;
        String r21 = r20 + r6;
    L55:
        MmRecordingSource r22 = r10.getClientSource();
        int r23 = hvb.a.a;
        int r24 = hvb.c.a;
        ArrayList r25 = new ArrayList();
        HttpHeader.Builder r26 = new HttpHeader.Builder().name("app-id");
        LarkAppContext.Companion.getClass();
        r25.add(r26.value(String.valueOf(LarkAppContext.access$getInstance$cp().appIdInfo().a)).build());
        r25.add(new HttpHeader.Builder().name("m-version").value("").build());
        r25.add(new HttpHeader.Builder().name("m-locale").value(com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a()).build());
        HttpHeader.Builder r27 = new HttpHeader.Builder().name("device-id");
        IDeviceInfoProvider r113 = OfficeSDKManager.getDeviceInfoProvider();
        if (r113 == null) goto L59;
        String r114 = r113.getDeviceId();
        if (r114 == null) goto L59;
    L60:
        r25.add(r27.value(r114).build());
        r25.add(new HttpHeader.Builder().name("request-id").value("mm#" + SystemClock.elapsedRealtimeNanos()).build());
        r25.add(new HttpHeader.Builder().name("platform").value("android").build());
        r25.add(new HttpHeader.Builder().name("Referer").value(r12.b.J().b()).build());
        if (r22 != null) goto L63;
    L70:
        if (r112 == true) goto L75;
        if (r15 == MmHttpContentType.CUSTOM) goto L75;
        r25.add(new HttpHeader.Builder().name("Content-Type").value(r15.getValue()).build());
    L75:
        if ((!r17.isEmpty()) == false) goto L80;
        Iterator<T> r28 = r17.keySet().iterator();
    L78:
        if (r28.hasNext() == false) goto L80;
        String r30 = (String) r28.next();
        r25.add(new HttpHeader.Builder().name(r30).value(r17.get(r30)).build());
    L80:
        HttpHeaderMap r31 = new HttpHeaderMap.Builder().headers(r25).build();
        if (r110 != null) goto L108;
        if (r19 == null) goto L86;
        ByteString.Companion.getClass();
        r110 = ByteString.a.b(r19);
        goto L108
    L86:
        if (r18.isEmpty() == false) goto L88;
        ByteString.Companion.getClass();
        r110 = ByteString.a.b("");
        goto L108
    L88:
        int r32 = MmNetRequestHandler.b.b[r15.ordinal()];
        if (r32 != 1) goto L91;
        String r33 = GsonProtectorUtils.toJson(new Gson(), r18);
        if (r33 != null) goto L106;
    L105:
        String r34 = "";
    L107:
        ByteString.Companion.getClass();
        r110 = ByteString.a.b(r34);
        goto L108
    L106:
        r34 = r33;
        goto L107
    L91:
        if (r32 != 2) goto L105;
        if ((!r18.isEmpty()) == false) goto L105;
        Iterator<Map.Entry<String, String>> r35 = r18.entrySet().iterator();
        r34 = "";
    L97:
        if (r35.hasNext() == false) goto L107;
        Map.Entry<String, String> r36 = r35.next();
        StringBuilder r37 = new StringBuilder();
        r37.append(r34);
        if (TextUtils.isEmpty(r34) == true) goto L101;
        String r38 = "&" + r36.getKey() + '=' + r36.getValue();
    L102:
        r37.append(r38);
        r34 = r37.toString();
        goto L97
    L101:
        r38 = r36.getKey() + '=' + r36.getValue();
    L108:
        UserSendHttpRequest.Builder r39 = new UserSendHttpRequest.Builder().url(r21);
        int r40 = MmNetRequestHandler.b.c[r14.ordinal()];
        if (r40 != 1) goto L111;
        HttpMethod r41 = HttpMethod.GET;
    L125:
        UserSendHttpRequest r42 = r39.method(r41).headers(r31).body(r110).disable_cookie(Boxing.boxBoolean(false)).build();
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type com.squareup.wire.Message<*, *>");
        ProtoAdapter r43 = ProtoAdapter.get(UserSendHttpResponse.class);
        Intrinsics.checkNotNull(r43, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r44 = new MmNetRequestHandler$sendHttpRequest$2$2$callBack$1(r12, r6, r13, r11, r10);
        int r45 = g.a;
        l r46 = r12.a;
        Intrinsics.checkNotNullParameter(r46, "rustClient");
        Intrinsics.checkNotNullParameter(r42, "request");
        Intrinsics.checkNotNullParameter(r44, "callBack");
        Intrinsics.checkNotNullParameter(r43, "responseProtoAdapter");
        lvb.a.e("RustSdkBridge", "[sendHttp] request=" + r42);
        Ref.ObjectRef r47 = new Ref.ObjectRef();
        r47.element = r46.h(new com.bytedance.lark.rustclient.api.d(r42.newBuilder(), r43, Command.USER_SEND_HTTP, null, null, null, null, 248)).a().subscribe(new hvb.d(r44, r47));
        Object r48 = r13.getOrThrow();
        if (r48 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L129;
        DebugProbesKt.probeCoroutineSuspended(this);
    L129:
        if (r48 != r2) goto L145;
        return r2;
    L145:
        return r48;
    L111:
        if (r40 != 2) goto L113;
        r41 = HttpMethod.POST;
        goto L125
    L113:
        if (r40 != 3) goto L115;
        r41 = HttpMethod.PUT;
        goto L125
    L115:
        if (r40 != 4) goto L117;
        r41 = HttpMethod.DELETE;
        goto L125
    L117:
        if (r40 != 5) goto L120;
        r41 = HttpMethod.PATCH;
        goto L125
    L120:
        throw new NoWhenBranchMatchedException();
    L63:
        switch(MmNetRequestHandler.b.a[r22.ordinal()]) {
            case 1: goto L68;
            case 2: goto L68;
            case 3: goto L68;
            case 4: goto L68;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L67;
            case 8: goto L67;
            case 9: goto L67;
            case 10: goto L67;
            case 11: goto L67;
            case 12: goto L66;
            default: goto L65;
        };
    L66:
        String r49 = "2";
    L69:
        r25.add(new HttpHeader.Builder().name("x-mm-client-source").value(r49).build());
        goto L70
    L67:
        r49 = "1";
        goto L69
    L68:
        r49 = UserInfo.NONE_NAME_CARD_ID;
        goto L69
    L65:
        throw new NoWhenBranchMatchedException();
    L59:
        r114 = "";
        goto L60
    L27:
        StringBuilder r50 = new StringBuilder();
        r50.append(r20);
        int r51 = hvb.a.a;
        Intrinsics.checkNotNullParameter(r6, "baseUrl");
        Intrinsics.checkNotNullParameter(r16, "params");
        StringBuilder r52 = new StringBuilder();
        r52.append(r6);
        if (StringsKt.endsWith$default(r6, "?", false, 2, null) == true) goto L30;
        r52.append("?");
    L30:
        Iterator<Map.Entry<String, String>> r53 = r16.entrySet().iterator();
        boolean r54 = true;
    L32:
        if (r53.hasNext() == false) goto L54;
        Map.Entry<String, String> r55 = r53.next();
        String r115 = r55.getKey();
        String r116 = r55.getValue();
        int r56 = hvb.b.a;
        r116 = URLEncoder.encode(r116, "UTF-8");     // Catch: Exception -> L36
    L39:
        if (r115.length() <= 0) goto L41;
        boolean r57 = true;
    L42:
        if (r57 == false) goto L32;
        if (r116 != null) goto L45;
    L48:
        boolean r58 = true;
    L49:
        if (r58 == true) goto L32;
        if (r54 == true) goto L52;
        r52.append("&");
    L53:
        r52.append(r115);
        r52.append("=");
        r52.append(r116);
        goto L32
    L52:
        r54 = false;
        goto L53
    L45:
        if (r116.length() == 0) goto L48;
        r58 = false;
        goto L49
    L41:
        r57 = false;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L54:
        r50.append(r52.toString());
        r21 = r50.toString();
        goto L55
    L16:
        if (r19.length() == 0) goto L19;
        r111 = false;
    L23:
        r112 = false;
        goto L24
    L11:
        return Result.box-impl(r9.unbox-impl());
    }
}
