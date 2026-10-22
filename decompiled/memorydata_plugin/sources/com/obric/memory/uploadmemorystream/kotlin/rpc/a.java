package com.obric.memory.uploadmemorystream.kotlin.rpc;

import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;
import com.obric.memory.uploadmemorystream.kotlin.UploadMemoryDataRequest;
import com.obric.memory.uploadmemorystream.kotlin.UploadMemoryDataResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/rpc/AssistantApiService;", "", "()V", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0412a f8291a = null;

    /* JADX INFO: renamed from: com.obric.memory.uploadmemorystream.kotlin.rpc.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/rpc/AssistantApiService$Companion;", "", "()V", "getApi", "Lcom/obric/memory/uploadmemorystream/kotlin/rpc/AssistantApiService$Companion$AssistantApiServiceApi;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiClass", "Ljava/lang/Class;", "uploadMemoryDataAsync", "", "req", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;", "callback", "Lcom/bytedance/rpc/callback/RpcCallback;", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataResponse;", "(Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;Lcom/bytedance/rpc/callback/RpcCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMemoryDataSync", "(Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantApiServiceApi", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class C0412a {

        /* JADX INFO: renamed from: com.obric.memory.uploadmemorystream.kotlin.rpc.a$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/rpc/AssistantApiService$Companion$AssistantApiServiceApi;", "", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/rpc/serialize/SerializeType;", "getClazz", "()Ljava/lang/Class;", "uploadMemoryDataAsync", "", "req", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;", "callback", "Lcom/bytedance/rpc/callback/RpcCallback;", "Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataResponse;", "(Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;Lcom/bytedance/rpc/callback/RpcCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMemoryDataSync", "(Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
        private interface InterfaceC0413a {
            @RpcOperation("$POST /memory/upload")
            @RpcParams(true)
            @RpcSerializer(SerializeType.JSON)
            Object a(UploadMemoryDataRequest r1, RpcCallback<UploadMemoryDataResponse> r2, Continuation<? super Unit> r3);

            @RpcOperation("$POST /memory/upload")
            @RpcParams(true)
            @RpcSerializer(SerializeType.JSON)
            Object a(UploadMemoryDataRequest r1, Continuation<? super UploadMemoryDataResponse> r2);
        }

        private C0412a() {
        }

        public /* synthetic */ C0412a(DefaultConstructorMarker r1) {
            this();
        }

        public final Object a(UploadMemoryDataRequest r8, RpcCallback<UploadMemoryDataResponse> r9, Continuation<? super Unit> r10) {
            RpcCallback<UploadMemoryDataResponse> r11 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r9, RpcCallback.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, AssistantApiService$Companion$uploadMemoryDataAsync$1.class) == false) goto L7;
            AssistantApiService$Companion$uploadMemoryDataAsync$1 r1 = (AssistantApiService$Companion$uploadMemoryDataAsync$1) ZeusTransformUtils.preCheckCast(r12, AssistantApiService$Companion$uploadMemoryDataAsync$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            RpcCallback r7 = (RpcCallback) ZeusTransformUtils.preCheckCast(r1.L$2, RpcCallback.class, "com.obric.memorydata.plugin");
            UploadMemoryDataRequest r14 = (UploadMemoryDataRequest) ZeusTransformUtils.preCheckCast(r1.L$1, UploadMemoryDataRequest.class, "com.obric.memorydata.plugin");
            C0412a r15 = (C0412a) ZeusTransformUtils.preCheckCast(r1.L$0, C0412a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r11 = (RpcCallback) ZeusTransformUtils.preCheckCast(r1.L$2, RpcCallback.class, "com.obric.memorydata.plugin");
            r8 = (UploadMemoryDataRequest) ZeusTransformUtils.preCheckCast(r1.L$1, UploadMemoryDataRequest.class, "com.obric.memorydata.plugin");
            C0412a this = (C0412a) ZeusTransformUtils.preCheckCast(r1.L$0, C0412a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L19:
            InterfaceC0413a r16 = (InterfaceC0413a) ZeusTransformUtils.preCheckCast(r13, InterfaceC0413a.class, "com.obric.memorydata.plugin");
            r1.L$0 = this;
            r1.L$1 = r8;
            r1.L$2 = r11;
            r1.label = 2;
            if (r16.a(r8, r11, r1) != r3) goto L23;
            return r3;
        L16:
            ResultKt.throwOnFailure(r13);
            C0412a r17 = (C0412a) ZeusTransformUtils.preCheckCast(this, C0412a.class, "com.obric.memorydata.plugin");
            r1.L$0 = this;
            r1.L$1 = r8;
            r1.L$2 = r11;
            r1.label = 1;
            r13 = r17.a(r1);
            if (r13 != r3) goto L19;
            return r3;
        L7:
            r1 = new AssistantApiService$Companion$uploadMemoryDataAsync$1(this, r12);
            goto L8
        }

        public final Object a(UploadMemoryDataRequest r8, Continuation<? super UploadMemoryDataResponse> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, AssistantApiService$Companion$uploadMemoryDataSync$1.class) == false) goto L7;
            AssistantApiService$Companion$uploadMemoryDataSync$1 r1 = (AssistantApiService$Companion$uploadMemoryDataSync$1) ZeusTransformUtils.preCheckCast(r10, AssistantApiService$Companion$uploadMemoryDataSync$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            UploadMemoryDataRequest r7 = (UploadMemoryDataRequest) ZeusTransformUtils.preCheckCast(r1.L$1, UploadMemoryDataRequest.class, "com.obric.memorydata.plugin");
            C0412a r12 = (C0412a) ZeusTransformUtils.preCheckCast(r1.L$0, C0412a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L22:
            return r11;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r8 = (UploadMemoryDataRequest) ZeusTransformUtils.preCheckCast(r1.L$1, UploadMemoryDataRequest.class, "com.obric.memorydata.plugin");
            C0412a this = (C0412a) ZeusTransformUtils.preCheckCast(r1.L$0, C0412a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L19:
            InterfaceC0413a r13 = (InterfaceC0413a) ZeusTransformUtils.preCheckCast(r11, InterfaceC0413a.class, "com.obric.memorydata.plugin");
            r1.L$0 = this;
            r1.L$1 = r8;
            r1.label = 2;
            r11 = r13.a(r8, r1);
            if (r11 != r3) goto L22;
            return r3;
        L16:
            ResultKt.throwOnFailure(r11);
            C0412a r14 = (C0412a) ZeusTransformUtils.preCheckCast(this, C0412a.class, "com.obric.memorydata.plugin");
            r1.L$0 = this;
            r1.L$1 = r8;
            r1.label = 1;
            r11 = r14.a(r1);
            if (r11 != r3) goto L19;
            return r3;
        L7:
            r1 = new AssistantApiService$Companion$uploadMemoryDataSync$1(this, r10);
            goto L8
        }

        final /* synthetic */ Object a(Continuation<? super InterfaceC0413a> r2) {
            Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = RpcService.getProxy(InterfaceC0413a.class);
            Intrinsics.checkExpressionValueIsNotNull(r3, "RpcService.getProxy(Assi…piServiceApi::class.java)");
            return r3;
        }
    }

    static {
        f8291a = new C0412a(null);
    }
}
