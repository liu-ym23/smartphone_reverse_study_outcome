package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import ny9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.videogenerate.VideoGenerateComponent$bindObservers$1", f = "VideoGenerateComponent.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
final class VideoGenerateComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoGenerateComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ VideoGenerateComponent b;
        public final /* synthetic */ Ref.ObjectRef<sy9.b> c;

        public a(Ref.BooleanRef r1, VideoGenerateComponent r2, Ref.ObjectRef<sy9.b> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r4, Continuation r5) {
            sy9.b r6 = (sy9.b) r4;
            boolean r0 = false;
            boolean r1 = true;
            if ((r6 instanceof sy9.b.c) == false) goto L20;
            if (this.a.element == false) goto L13;
            s r7 = (s) this.b.n.getValue();
            if (r7 != null) goto L9;
        L11:
            r1 = false;
        L12:
            if (r1 == false) goto L13;
        L18:
            this.a.element = false;
        L29:
            if (r0 == true) goto L32;
            this.c.element = r6;
        L32:
            return Unit.INSTANCE;
        L9:
            if (r7.D() != true) goto L11;
        L13:
            Object r8 = this.c.element;
            if ((r8 instanceof sy9.b.a) == false) goto L16;
        L17:
            VideoGenerateComponent.F2(this.b, ((sy9.b.c) r6).a);
            goto L18
        L16:
            if ((r8 instanceof sy9.b.d) == false) goto L18;
        L20:
            if ((r6 instanceof sy9.b.e) == false) goto L29;
            Object r9 = this.c.element;
            if ((r9 instanceof sy9.b.a) == false) goto L24;
        L25:
            Bitmap r10 = ((sy9.b.e) r6).a;
            if (r10 != null) goto L28;
            r0 = true;
            goto L29
        L28:
            VideoGenerateComponent.F2(this.b, r10);
            goto L29
        L24:
            if ((r9 instanceof sy9.b.c) == false) goto L29;
            goto L25
        }
    }

    public VideoGenerateComponent$bindObservers$1(VideoGenerateComponent r1, Continuation<? super VideoGenerateComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoGenerateComponent$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = sy9.b.d.a;
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = true;
        sy9.a r3 = this.this$0.N2();
        if (r3 == null) goto L18;
        i1<sy9.b> r4 = r3.getUiState();
        if (r4 == null) goto L18;
        a r5 = new a(r2, this.this$0, r8);
        this.label = 1;
        if (r4.collect(r5, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
