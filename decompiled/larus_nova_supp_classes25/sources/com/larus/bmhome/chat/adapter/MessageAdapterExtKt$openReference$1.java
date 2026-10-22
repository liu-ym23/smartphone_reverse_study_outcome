package com.larus.bmhome.chat.adapter;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.z2;
import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.adapter.MessageAdapterExtKt$openReference$1", f = "MessageAdapterExt.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class MessageAdapterExtKt$openReference$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatType;
    final /* synthetic */ Context $context;
    final /* synthetic */ Map<String, String> $hashMap;
    final /* synthetic */ e3 $officeService;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.adapter.MessageAdapterExtKt$openReference$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.adapter.MessageAdapterExtKt$openReference$1$1", f = "MessageAdapterExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $chatType;
        final /* synthetic */ Context $context;
        final /* synthetic */ Map<String, String> $hashMap;
        final /* synthetic */ e3 $officeService;
        final /* synthetic */ String $url;
        int label;

        public AnonymousClass1(String r1, Context r2, String r3, Map<String, String> r4, e3 r5, Continuation<? super AnonymousClass1> r6) {
            this.$url = r1;
            this.$context = r2;
            this.$chatType = r3;
            this.$hashMap = r4;
            this.$officeService = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$url, this.$context, this.$chatType, this.$hashMap, this.$officeService, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            Keva r9 = z2.a;
            final String r10 = this.$url;
            final Context r1 = this.$context;
            final String r2 = this.$chatType;
            final Map<String, String> r3 = this.$hashMap;
            final e3 r5 = this.$officeService;
            z2.b(r10, new e0(r1, r2, r3, r10, r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MessageAdapterExtKt$openReference$1(String r1, Context r2, String r3, Map<String, String> r4, e3 r5, Continuation<? super MessageAdapterExtKt$openReference$1> r6) {
        this.$url = r1;
        this.$context = r2;
        this.$chatType = r3;
        this.$hashMap = r4;
        this.$officeService = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageAdapterExtKt$openReference$1(this.$url, this.$context, this.$chatType, this.$hashMap, this.$officeService, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (com.larus.platform.service.z2.a.enableStandardLinkNavigation() == false) goto L20;
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L15;
        r12.D();
        if (x1.a.d0(this.$url) != true) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L20;
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L20;
        r14.D();
        x1.a.p();
    L15:
        r13 = false;
    L20:
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$url, this.$context, this.$chatType, this.$hashMap, this.$officeService, null);
        this.label = 1;
        if (BuildersKt.withContext(r15, r2, this) != r0) goto L24;
        return r0;
    }
}
