package com.larus.profile.impl.creation;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility$downloadByUrl$2$1", f = "CreationImageEditAbility.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
final class CreationImageEditAbility$downloadByUrl$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ kotlinx.coroutines.i<File> $continuation;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ CreationImageEditAbility this$0;

    public static final class a implements Function1<Bitmap, Unit> {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ kotlinx.coroutines.i<File> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CoroutineScope r1, Context r2, kotlinx.coroutines.i<? super File> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r8) {
            Bitmap r9 = (Bitmap) r8;
            Intrinsics.checkNotNullParameter(r9, "bitmap");
            BuildersKt.launch$default(this.a, null, null, new CreationImageEditAbility$downloadByUrl$2$1$1$1(this.b, r9, this.c, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<String, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<File> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(kotlinx.coroutines.i<? super File> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "error");
            FLogger.a.e("creationImageEditAbility", "downloadByUrl error = " + r5);
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(null));
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationImageEditAbility$downloadByUrl$2$1(CreationImageEditAbility r1, String r2, CoroutineScope r3, Context r4, kotlinx.coroutines.i<? super File> r5, Continuation<? super CreationImageEditAbility$downloadByUrl$2$1> r6) {
        this.this$0 = r1;
        this.$url = r2;
        this.$scope = r3;
        this.$context = r4;
        this.$continuation = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationImageEditAbility$downloadByUrl$2$1(this.this$0, this.$url, this.$scope, this.$context, this.$continuation, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CreationImageEditAbility r9 = this.this$0;
        String r2 = this.$url;
        CoroutineScope r4 = this.$scope;
        Context r5 = this.$context;
        kotlinx.coroutines.i<File> r6 = this.$continuation;
        a r3 = new a(r4, r5, r6);
        b r7 = new b(r6);
        this.label = 1;
        int r10 = CreationImageEditAbility.d;
        if (r9.d(r2, r3, r7, this) != r0) goto L12;
        return r0;
    }
}
