package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$updatePluginAuthStatus$2", f = "PluginManagerDelegate.kt", i = {}, l = {232, 237}, m = "invokeSuspend", n = {}, s = {})
public final class PluginManagerDelegate$updatePluginAuthStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PluginAuthType $authType;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $pluginId;
    final /* synthetic */ Function1<Boolean, Unit> $result;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.auth.PluginManagerDelegate$updatePluginAuthStatus$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$updatePluginAuthStatus$2$1", f = "PluginManagerDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PluginAuthType $authType;
        final /* synthetic */ String $botId;
        final /* synthetic */ String $pluginId;
        final /* synthetic */ boolean $resp;
        final /* synthetic */ Function1<Boolean, Unit> $result;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(boolean r1, String r2, String r3, PluginAuthType r4, Function1<? super Boolean, Unit> r5, Continuation<? super AnonymousClass1> r6) {
            this.$resp = r1;
            this.$botId = r2;
            this.$pluginId = r3;
            this.$authType = r4;
            this.$result = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$resp, this.$botId, this.$pluginId, this.$authType, this.$result, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            if (this.$resp == false) goto L7;
            ConcurrentHashMap<String, PluginManager> r5 = PluginManager.d;
            n0 r6 = PluginManager.a.a(this.$botId).c;
            String r0 = this.$pluginId;
            PluginAuthType r1 = this.$authType;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "pluginId");
            Intrinsics.checkNotNullParameter(r1, "authType");
            r6.a.put(r0, r1);
        L7:
            this.$result.invoke(Boxing.boxBoolean(this.$resp));
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PluginManagerDelegate$updatePluginAuthStatus$2(String r1, String r2, PluginAuthType r3, Function1<? super Boolean, Unit> r4, Continuation<? super PluginManagerDelegate$updatePluginAuthStatus$2> r5) {
        this.$botId = r1;
        this.$pluginId = r2;
        this.$authType = r3;
        this.$result = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PluginManagerDelegate$updatePluginAuthStatus$2(this.$botId, this.$pluginId, this.$authType, this.$result, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L17:
        boolean r4 = ((Boolean) r11).booleanValue();
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.$botId, this.$pluginId, this.$authType, this.$result, null);
        this.label = 2;
        if (BuildersKt.withContext(r12, r2, this) != r0) goto L21;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        ConcurrentHashMap<String, PluginManager> r13 = PluginManager.d;
        PluginAuthRepository r14 = PluginManager.f;
        String r3 = this.$botId;
        String r5 = this.$pluginId;
        if (this.$authType != PluginAuthType.Always) goto L13;
        boolean r6 = true;
    L14:
        this.label = 1;
        r11 = r14.a(r3, r5, r6, this);
        if (r11 != r0) goto L17;
        return r0;
    L13:
        r6 = false;
        goto L14
    }
}
