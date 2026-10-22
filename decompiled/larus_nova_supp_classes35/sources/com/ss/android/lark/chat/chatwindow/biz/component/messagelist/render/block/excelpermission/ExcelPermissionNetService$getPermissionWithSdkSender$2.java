package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission.ExcelPermissionNetService$getPermissionWithSdkSender$2", f = "ExcelPermissionNetService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExcelPermissionNetService$getPermissionWithSdkSender$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetFilePermission $callback;
    final /* synthetic */ String $fileId;
    int label;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return (SendHttpResponse) SendHttpResponse.ADAPTER.decode(r2);
        }
    }

    public ExcelPermissionNetService$getPermissionWithSdkSender$2(String r1, IGetFilePermission r2, Continuation<? super ExcelPermissionNetService$getPermissionWithSdkSender$2> r3) {
        this.$fileId = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ExcelPermissionNetService$getPermissionWithSdkSender$2(this.$fileId, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        Lazy r5 = ExcelPermissionNetService.a;
        SendHttpRequest.Builder r6 = new SendHttpRequest.Builder().url(ExcelPermissionNetService.b(this.$fileId)).method(SendHttpRequest.Method.GET).headers(MapsKt.mapOf(new Pair[]{TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to("Cookie", "session=" + ChatCoreModule.a().getPassportDependency().Fc())}));
        Command r0 = Command.SEND_HTTP;
        final IGetFilePermission r2 = this.$callback;
        SdkSender.asynSendRequestNonWrap(r0, r6, new AnonymousClass1(r2), a.a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
