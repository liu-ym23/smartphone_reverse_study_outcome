package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.view.ChatConstraintLayout$b;
import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.feature.ability.UpdateProgress;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$handleBottomInsetUpdate$1", f = "GenImageInitComponent.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$handleBottomInsetUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageInitComponent a;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImageInitComponent$handleBottomInsetUpdate$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0092a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UpdateProgress.values().length];
                r0[UpdateProgress.UPDATE_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[UpdateProgress.UPDATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[UpdateProgress.UPDATE_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(GenImageInitComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            fy8.d r5 = (fy8.d) r3;
            if (r5.a != CanvasEditorEventType.EVENT_BOTTOM_INSET_UPDATE) goto L31;
            fy8.a r6 = r5.e;
            if (r6 == null) goto L7;
            UpdateProgress r7 = r6.a;
        L8:
            if (r7 != null) goto L10;
            int r8 = -1;
        L12:
            if (r8 != 1) goto L14;
            Iterator<ChatConstraintLayout$b> r9 = this.a.u.iterator();
        L28:
            if (r9.hasNext() == false) goto L31;
            r9.next().a();
            goto L28
        L14:
            if (r8 != 2) goto L16;
            Iterator<ChatConstraintLayout$b> r10 = this.a.u.iterator();
        L24:
            if (r10.hasNext() == false) goto L31;
            r10.next().onUpdate(r5.e.b);
            goto L24
        L16:
            if (r8 != 3) goto L31;
            Iterator<ChatConstraintLayout$b> r11 = this.a.u.iterator();
        L20:
            if (r11.hasNext() == false) goto L31;
            r11.next().b();
            goto L20
        L10:
            r8 = C0092a.a[r7.ordinal()];
            goto L12
        L7:
            r7 = null;
        L31:
            return Unit.INSTANCE;
        }
    }

    public GenImageInitComponent$handleBottomInsetUpdate$1(GenImageInitComponent r1, Continuation<? super GenImageInitComponent$handleBottomInsetUpdate$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageInitComponent$handleBottomInsetUpdate$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GenImageInitComponent r6 = this.this$0;
        Lazy<hq9.s0> r2 = GenImageInitComponent.w;
        fy8.i r7 = (fy8.i) r6.r.getValue();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.a1 r8 = r7.jY();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
