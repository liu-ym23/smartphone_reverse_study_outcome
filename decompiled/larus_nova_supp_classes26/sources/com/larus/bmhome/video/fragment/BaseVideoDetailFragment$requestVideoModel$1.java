package com.larus.bmhome.video.fragment;

import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoModelResult;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$requestVideoModel$1", f = "BaseVideoDetailFragment.kt", i = {}, l = {294, 295}, m = "invokeSuspend", n = {}, s = {})
final class BaseVideoDetailFragment$requestVideoModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onNext;
    int label;
    final /* synthetic */ BaseVideoDetailFragment<ViewBinding> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.BaseVideoDetailFragment$requestVideoModel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$requestVideoModel$1$1", f = "BaseVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onNext;
        final /* synthetic */ GetVideoModelResultItem $resultItem;
        int label;
        final /* synthetic */ BaseVideoDetailFragment<ViewBinding> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(GetVideoModelResultItem r1, BaseVideoDetailFragment<ViewBinding> r2, Function1<? super String, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$resultItem = r1;
            this.this$0 = r2;
            this.$onNext = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$resultItem, this.this$0, this.$onNext, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L43;
            ResultKt.throwOnFailure(r5);
            GetVideoModelResultItem r6 = this.$resultItem;
            String r0 = null;
            if (r6 == null) goto L9;
            VideoUrlResult r7 = r6.getVideoUrlResult();
            if (r7 == null) goto L9;
            String r8 = r7.getVideoUrl();
        L11:
            if (o0.d(r8) == false) goto L35;
            nr9.g r9 = this.this$0.e;
            if (r9 == null) goto L21;
            GetVideoModelResultItem r1 = this.$resultItem;
            if (r1 == null) goto L19;
            VideoUrlResult r2 = r1.getVideoUrlResult();
            if (r2 == null) goto L19;
            String r3 = r2.getVideoUrl();
        L20:
            r9.c = r3;
        L19:
            r3 = null;
        L21:
            nr9.g r10 = this.this$0.e;
            if (r10 == null) goto L30;
            GetVideoModelResultItem r4 = this.$resultItem;
            if (r4 == null) goto L28;
            VideoUrlResult r11 = r4.getVideoUrlResult();
            if (r11 == null) goto L28;
            String r12 = r11.getDownloadFilehash();
        L29:
            r10.d = r12;
        L28:
            r12 = null;
        L30:
            FLogger r13 = FLogger.a;
            String r14 = this.this$0.tag();
            StringBuilder r15 = new StringBuilder("[requestVideoModel] update download url: ");
            nr9.g r16 = this.this$0.e;
            if (r16 == null) goto L33;
            String r17 = r16.c;
        L34:
            r15.append(r17);
            r13.i(r14, r15.toString());
            goto L35
        L33:
            r17 = null;
        L35:
            Function1<String, Unit> r18 = this.$onNext;
            GetVideoModelResultItem r19 = this.$resultItem;
            if (r19 == null) goto L40;
            VideoModelResult r20 = r19.getVideoModelResult();
            if (r20 == null) goto L40;
            r0 = r20.getVideoModel();
        L40:
            r18.invoke(r0);
            return Unit.INSTANCE;
        L9:
            r8 = null;
            goto L11
        L43:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseVideoDetailFragment$requestVideoModel$1(BaseVideoDetailFragment<ViewBinding> r1, Function1<? super String, Unit> r2, Continuation<? super BaseVideoDetailFragment$requestVideoModel$1> r3) {
        this.this$0 = r1;
        this.$onNext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaseVideoDetailFragment$requestVideoModel$1(this.this$0, this.$onNext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L20:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1((GetVideoModelResultItem) r12, this.this$0, this.$onNext, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        ResourceCenter r5 = ResourceCenter.a;
        nr9.g r13 = this.this$0.e;
        if (r13 == null) goto L13;
        String r6 = r13.i;
    L14:
        if (r13 == null) goto L16;
        String r7 = r13.a;
    L17:
        this.label = 1;
        r12 = ResourceCenter.i(r5, r6, r7, false, this, 4);
        if (r12 != r0) goto L20;
        return r0;
    L16:
        r7 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    }
}
