package com.ss.android.lark.keyboard.biz.plus.inject;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.j;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.plus.inject.PlusInnerEndPlugin$bindPanelEvent$1", f = "PlusInnerEndPlugin.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
final class PlusInnerEndPlugin$bindPanelEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PlusInnerEndPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ PlusInnerEndPlugin a;

        public a(PlusInnerEndPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            ImeStateDetail r6 = (ImeStateDetail) r4;
            m r7 = this.a.g().H().k();
            if (r7 == null) goto L5;
            KeyboardMenuItemKey r8 = r7.g();
        L7:
            if (r8 == KeyboardMenuItemKey.Plus) goto L9;
            PlusInnerEndPlugin r9 = this.a;
            Log.i("PlusInnerEndPlugin", r9.k("FLOW_PLUS_PANEL_STATE_IGNORED", Boxing.boxBoolean(r6.isEnterOrShow()), "panel_state_" + r6, r9.f));
            return Unit.INSTANCE;
        L9:
            PlusInnerEndPlugin.f(this.a, r6.isEnterOrShow(), "panel_state_" + r6);
            return Unit.INSTANCE;
        L5:
            r8 = null;
            goto L7
        }
    }

    public PlusInnerEndPlugin$bindPanelEvent$1(PlusInnerEndPlugin r1, Continuation<? super PlusInnerEndPlugin$bindPanelEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PlusInnerEndPlugin$bindPanelEvent$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        j r6 = this.this$0.g().z().getPanelState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
