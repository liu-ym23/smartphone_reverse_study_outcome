package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.utils.icon.BaseAppIconCache$setAppIconImage$loadIcon$job$1", f = "BaseAppIconCache.kt", i = {0, 1, 2}, l = {676, 335, 347, 373, 383, 386}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
final class BaseAppIconCache$setAppIconImage$loadIcon$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $cacheKeyOverride;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<String, Drawable> $customIconLoader;
    final /* synthetic */ Integer $customIconRes;
    final /* synthetic */ boolean $decorateIcon;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $requestKey;
    final /* synthetic */ Function1<Drawable, Drawable> $styleProcessor;
    final /* synthetic */ Drawable $targetDefaultIcon;
    final /* synthetic */ int $targetSize;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.utils.icon.BaseAppIconCache$setAppIconImage$loadIcon$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.utils.icon.BaseAppIconCache$setAppIconImage$loadIcon$job$1$1", f = "BaseAppIconCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Drawable $finalDrawable;
        final /* synthetic */ ImageView $imageView;
        final /* synthetic */ String $requestKey;
        int label;

        AnonymousClass1(ImageView r3, String r4, Drawable r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$imageView = r3;
            this.$requestKey = r4;
            this.$finalDrawable = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$imageView, this.$requestKey, this.$finalDrawable, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            if (Intrinsics.areEqual(this.$imageView.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package")), this.$requestKey) == false) goto L7;
            this.$imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.$imageView.setImageDrawable(this.$finalDrawable);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    BaseAppIconCache$setAppIconImage$loadIcon$job$1(ImageView r3, String r4, Function1<? super Drawable, ? extends Drawable> r5, String r6, boolean r7, Drawable r8, Context r9, String r10, Function1<? super String, ? extends Drawable> r11, String r12, Integer r13, int r14, Continuation<? super BaseAppIconCache$setAppIconImage$loadIcon$job$1> r15) {
        Function1<Drawable, Drawable> r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Context r17 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Function1<String, Drawable> r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation r19 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        this.$imageView = r3;
        this.$requestKey = r4;
        this.$styleProcessor = r16;
        this.$cacheKey = r6;
        this.$decorateIcon = r7;
        this.$targetDefaultIcon = r8;
        this.$context = ZeusTransformUtils.wrapperContext(r17, "com.obric.memorydata.plugin");
        this.$packageName = r10;
        this.$customIconLoader = r18;
        this.$cacheKeyOverride = r12;
        this.$customIconRes = r13;
        this.$targetSize = r14;
        super(2, r19);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1(this.$imageView, this.$requestKey, this.$styleProcessor, this.$cacheKey, this.$decorateIcon, this.$targetDefaultIcon, this.$context, this.$packageName, this.$customIconLoader, this.$cacheKeyOverride, this.$customIconRes, this.$targetSize, r16), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BaseAppIconCache$setAppIconImage$loadIcon$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseAppIconCache$setAppIconImage$loadIcon$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x02ac: MOVE (r13 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:66:0x02ac */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L14;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r24);
    L80:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r24);
        Object r2 = r24;
    L75:
        Drawable r7 = (Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin");
    L76:
        CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$imageView, this.$requestKey, r7, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.L$7 = null;
        this.label = 6;
        if (i.a(r3, r5, r4) != r1) goto L80;
        return r1;
    L8:
        ResultKt.throwOnFailure(r24);
        Object r6 = r24;
    L72:
        Drawable r8 = (Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$2(this.$styleProcessor, r8, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 5;
        r2 = i.a(r9, r10, r11);
        if (r2 != r1) goto L75;
        return r1;
    L9:
        Drawable r12 = (Drawable) ZeusTransformUtils.preCheckCast(this.L$2, Drawable.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L12
        Drawable r15 = r12;
        Object r16 = r24;
    L52:
        r7 = (Drawable) ZeusTransformUtils.preCheckCast(r16, Drawable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L54:
        if (r7 == null) goto L56;
        b.b(b.f13229a).put(r13, r7);     // Catch: Throwable -> L12
        RunLog.INSTANCE.debug("BaseAppIconCache", "Cache PUT: " + r13 + ". Total icons: " + b.b(b.f13229a).snapshot().size() + ", Memory: " + b.b(b.f13229a).size() + " KB / " + b.b(b.f13229a).maxSize() + " KB");     // Catch: Throwable -> L12
    L56:
        if (r7 != null) goto L58;
        r7 = r15;
    L58:
        b.f().remove(r13);     // Catch: Throwable -> L65
        kotlinx.coroutines.sync.a r17 = r14;
    L60:
        r17.b(null);
    L12:
        th = th;
    L63:
        b.f().remove(r13);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L14:
        int r18 = this.I$0;
        boolean r19 = this.Z$0;
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(this.L$3, Context.class, "com.obric.memorydata.plugin");
        Drawable r21 = (Drawable) ZeusTransformUtils.preCheckCast(this.L$2, Drawable.class, "com.obric.memorydata.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r23 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L17
        r15 = r21;
        Object r25 = r24;
    L46:
        r7 = (Drawable) ZeusTransformUtils.preCheckCast(r25, Drawable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r19 == false) goto L53;
        CoroutineContext r26 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Function2 r27 = (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$processed$1(r20, r7, r18, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        this.L$0 = r23;     // Catch: Throwable -> L17
        this.L$1 = r22;     // Catch: Throwable -> L17
        this.L$2 = r15;     // Catch: Throwable -> L17
        this.L$3 = null;     // Catch: Throwable -> L17
        this.label = 3;     // Catch: Throwable -> L17
        r16 = i.a(r26, r27, this);     // Catch: Throwable -> L17
        if (r16 != r1) goto L51;
        return r1;
    L51:
        r13 = r22;
        r14 = r23;
        goto L52
    L53:
        r13 = r22;
        r14 = r23;
    L17:
        th = th;
        r13 = r22;
        goto L63
    L19:
        r18 = this.I$0;
        boolean r28 = this.Z$0;
        Integer r29 = (Integer) ZeusTransformUtils.preCheckCast(this.L$7, Integer.class, "com.obric.memorydata.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(this.L$6, String.class, "com.obric.memorydata.plugin");
        Function1<String, Drawable> r31 = (Function1) ZeusTransformUtils.preCheckCast(this.L$5, Function1.class, "com.obric.memorydata.plugin");
        String r32 = (String) ZeusTransformUtils.preCheckCast(this.L$4, String.class, "com.obric.memorydata.plugin");
        Context r110 = (Context) ZeusTransformUtils.preCheckCast(this.L$3, Context.class, "com.obric.memorydata.plugin");
        r15 = (Drawable) ZeusTransformUtils.preCheckCast(this.L$2, Drawable.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        r17 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r24);
        Integer r112 = r29;
        String r113 = r30;
        Function1<String, Drawable> r114 = r31;
        String r115 = r32;
        Context r33 = r110;
        boolean r34 = r28;
        r13 = r111;
    L81:
        r7 = (Drawable) ZeusTransformUtils.preCheckCast(b.b(b.f13229a).get(r13), Drawable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        if (r7 != null) goto L86;
        CoroutineContext r35 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        Function2 r36 = (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$1$appIcon$1(r33, r115, r114, r113, r112, r15, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        this.L$0 = r17;     // Catch: Throwable -> L61
        this.L$1 = r13;     // Catch: Throwable -> L61
        this.L$2 = r15;     // Catch: Throwable -> L61
        this.L$3 = r33;     // Catch: Throwable -> L61
        this.L$4 = null;     // Catch: Throwable -> L61
        this.L$5 = null;     // Catch: Throwable -> L61
        this.L$6 = null;     // Catch: Throwable -> L61
        this.L$7 = null;     // Catch: Throwable -> L61
        this.Z$0 = r34;     // Catch: Throwable -> L61
        this.I$0 = r18;     // Catch: Throwable -> L61
        this.label = 2;     // Catch: Throwable -> L61
        r25 = i.a(r35, r36, this);     // Catch: Throwable -> L61
        if (r25 != r1) goto L45;
        return r1;
    L45:
        r23 = r17;
        Context r210 = r33;
        r22 = r13;
        r19 = r34;
        r20 = r210;
        goto L46
    L86:
        b.f().remove(r13);     // Catch: Throwable -> L40
    L40:
        th = th;
    L67:
        r17.b(null);
        throw th;
    L61:
        th = th;
        goto L63
    L20:
        ResultKt.throwOnFailure(r24);
        if (Intrinsics.areEqual(this.$imageView.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package")), this.$requestKey) == true) goto L25;
        return Unit.INSTANCE;
    L25:
        if (this.$styleProcessor != null) goto L69;
        ConcurrentMap r37 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(b.f(), ConcurrentMap.class, "com.obric.memorydata.plugin");
        String r38 = this.$cacheKey;
        Object r39 = r37.get(r38);
        if (r39 != null) goto L32;
        r39 = kotlinx.coroutines.sync.c.a(false, 1, null);
        Object r40 = r37.putIfAbsent(r38, r39);
        if (r40 == null) goto L32;
        r39 = r40;
    L32:
        kotlinx.coroutines.sync.a r41 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r39, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r41);
        r13 = this.$cacheKey;
        r34 = this.$decorateIcon;
        r15 = this.$targetDefaultIcon;
        r33 = this.$context;
        String r42 = this.$packageName;
        Function1<String, Drawable> r116 = this.$customIconLoader;
        String r117 = this.$cacheKeyOverride;
        Integer r118 = this.$customIconRes;
        int r119 = this.$targetSize;
        Continuation<? super Unit> r120 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r41;
        this.L$1 = r13;
        this.L$2 = r15;
        this.L$3 = r33;
        this.L$4 = r42;
        this.L$5 = r116;
        this.L$6 = r117;
        this.L$7 = r118;
        this.Z$0 = r34;
        this.I$0 = r119;
        this.label = 1;
        if (r41.a(null, r120) != r1) goto L35;
        return r1;
    L35:
        r115 = r42;
        r114 = r116;
        r113 = r117;
        r112 = r118;
        r17 = r41;
        r18 = r119;
        goto L81
    L69:
        CoroutineContext r43 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r44 = (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1$finalDrawable$appIcon$1(this.$context, this.$packageName, this.$customIconLoader, this.$cacheKeyOverride, this.$customIconRes, this.$targetDefaultIcon, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r45 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 4;
        r6 = i.a(r43, r44, r45);
        if (r6 != r1) goto L72;
        return r1;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L65:
        th = th;
        r17 = r6;
        goto L67
    }
}
