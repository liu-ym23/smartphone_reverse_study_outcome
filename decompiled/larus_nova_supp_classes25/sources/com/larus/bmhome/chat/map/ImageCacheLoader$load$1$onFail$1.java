package com.larus.bmhome.chat.map;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.cache.DiskCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1", f = "ImageExpireNewLoader.kt", i = {0, 1, 2, 2}, l = {56, 59, 60}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "newUrl"}, s = {"L$0", "L$0", "L$0", "L$1"})
final class ImageCacheLoader$load$1$onFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $requestUrlCallback;
    final /* synthetic */ String $tos;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$1", f = "ImageExpireNewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newUrl;
        final /* synthetic */ Function1<String, Unit> $requestUrlCallback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super String, Unit> r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$requestUrlCallback = r1;
            this.$newUrl = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$requestUrlCallback, this.$newUrl, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$requestUrlCallback.invoke(this.$newUrl);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$2", f = "ImageExpireNewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $requestUrlCallback;
        final /* synthetic */ String $returnData;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super String, Unit> r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.$requestUrlCallback = r1;
            this.$returnData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$requestUrlCallback, this.$returnData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$requestUrlCallback.invoke(this.$returnData);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.map.ImageCacheLoader$load$1$onFail$1$3", f = "ImageExpireNewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $requestUrlCallback;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super String, Unit> r1, String r2, Continuation<? super AnonymousClass3> r3) {
            this.$requestUrlCallback = r1;
            this.$url = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$requestUrlCallback, this.$url, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$requestUrlCallback.invoke(this.$url);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageCacheLoader$load$1$onFail$1(String r1, String r2, Function1<? super String, Unit> r3, Continuation<? super ImageCacheLoader$load$1$onFail$1> r4) {
        this.$tos = r1;
        this.$url = r2;
        this.$requestUrlCallback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ImageCacheLoader$load$1$onFail$1 r0 = new ImageCacheLoader$load$1$onFail$1(this.$tos, this.$url, this.$requestUrlCallback, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L10;
        String r2 = (String) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L45:
        BuildersKt.launch$default(r3, Dispatchers.getMain(), null, new AnonymousClass1(this.$requestUrlCallback, r2, null), 2, null);
    L48:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L41:
        String r16 = (String) r15;
        DiskCache r5 = b.b;
        String r6 = this.$tos;
        this.L$0 = r3;
        this.L$1 = r16;
        this.label = 3;
        if (r5.d(r6, r16, this) != r0) goto L44;
        return r0;
    L44:
        r2 = r16;
        goto L45
    L12:
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
        CoroutineScope r8 = r7;
    L18:
        String r17 = (String) r15;
        if (TextUtils.isEmpty(r17) == true) goto L37;
        b r9 = b.a;
        Regex r10 = new Regex("x-expires=(\\d+)&");
        if (r17 == null) goto L23;
        MatchResult r11 = Regex.find$default(r10, r17, 0, 2, null);
    L24:
        if (r11 == null) goto L28;
        List r12 = r11.getGroupValues();
        if (r12 == null) goto L28;
        String r13 = (String) CollectionsKt.getOrNull(r12, 1);
    L29:
        if (r13 != null) goto L31;
    L33:
        r4 = false;
    L34:
        if (r4 == true) goto L37;
        BuildersKt.launch$default(r8, Dispatchers.getMain(), null, new AnonymousClass2(this.$requestUrlCallback, r17, null), 2, null);
        goto L48
    L31:
        if (CastLongProtector.parseLong(r13) >= (AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000))) goto L33;
    L28:
        r13 = null;
        goto L29
    L23:
        r11 = null;
    L37:
        b r18 = b.a;
        String r14 = this.$tos;
        String r19 = this.$url;
        this.L$0 = r8;
        this.label = 2;
        r15 = r18.a(r14, r19, this);
        if (r15 != r0) goto L40;
        return r0;
    L40:
        r3 = r8;
        goto L41
    L13:
        ResultKt.throwOnFailure(r15);
        r8 = (CoroutineScope) this.L$0;
        String r110 = this.$tos;
        if (r110 == null) goto L46;
        DiskCache r20 = b.b;
        this.L$0 = r8;
        this.label = 1;
        r15 = r20.c(r110, this);
        if (r15 != r0) goto L18;
        return r0;
    L46:
        BuildersKt.launch$default(r8, Dispatchers.getMain(), null, new AnonymousClass3(this.$requestUrlCallback, this.$url, null), 2, null);
        goto L48
    }
}
