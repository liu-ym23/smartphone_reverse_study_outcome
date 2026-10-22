package com.larus.bmhome.view.actionbar.edit.component;

import android.text.TextUtils;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.TabSelectorWidget$onBindView$3", f = "TabSelectorWidget.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class TabSelectorWidget$onBindView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TabSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ TabSelectorWidget a;

        public a(TabSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            bq8.a r6 = (bq8.a) r4;
            if (this.a.isAttachedToWindow() == false) goto L27;
            TabLayout.Tab r0 = null;
            if (TextUtils.isEmpty(r6.d) == true) goto L16;
            Iterator<TabLayout.Tab> r7 = this.a.g.iterator();
        L8:
            if (r7.hasNext() == false) goto L12;
            TabLayout.Tab r8 = r7.next();
            if (Intrinsics.areEqual(r8.getTag(), Boxing.boxInt(1)) == false) goto L8;
            r0 = r8;
        L12:
            TabLayout.Tab r1 = r0;
            if (r1 == null) goto L27;
            r1.select();
            goto L27
        L16:
            if (TextUtils.isEmpty(r6.getLyrics()) == true) goto L27;
            Iterator<TabLayout.Tab> r9 = this.a.g.iterator();
        L19:
            if (r9.hasNext() == false) goto L23;
            TabLayout.Tab r10 = r9.next();
            if (Intrinsics.areEqual(r10.getTag(), Boxing.boxInt(2)) == false) goto L19;
            r0 = r10;
        L23:
            TabLayout.Tab r2 = r0;
            if (r2 == null) goto L27;
            r2.select();
        L27:
            return Unit.INSTANCE;
        }
    }

    public TabSelectorWidget$onBindView$3(TabSelectorWidget r1, Continuation<? super TabSelectorWidget$onBindView$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TabSelectorWidget$onBindView$3(this.this$0, r3);
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
        TabSelectorWidget r6 = this.this$0;
        int r2 = TabSelectorWidget.i;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<bq8.a> r8 = r7.getInstructionMusicTemplatePrompt();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
