package com.obric.flow.cardlistpage.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.WidgetPickerCoordinator$open$1", f = "WidgetPickerCoordinator.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class WidgetPickerCoordinator$open$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ l this$0;

    public WidgetPickerCoordinator$open$1(l r5, Continuation<? super WidgetPickerCoordinator$open$1> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new WidgetPickerCoordinator$open$1(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        Intent r12 = new Intent("android.intent.action.PICK");
        l r13 = this.this$0;
        r12.setPackage("com.android.launcher3");
        r12.putExtra("appWidgetId", r13.f11785h);
        r12.putParcelableArrayListExtra("added_app_widgets", (ArrayList) r10);
        r12.putExtra("callback_receiver", r13.f11786i);
        r12.putExtra("only_system_or_obric_widgets", true);
        ArrayList<? extends Parcelable> r14 = new ArrayList();
        r14.add(new ComponentName("com.android.launcher3", "com.obric.feature.widget.ObricAppTimeWidgetProvider"));
        Unit r15 = Unit.INSTANCE;
        r12.putParcelableArrayListExtra("widget_blacklist", r14);
        ArrayList<String> r16 = new ArrayList();
        r16.add("com.obric.autoaction");
        r12.putStringArrayListExtra("package_blacklist", r16);
        Bundle r17 = new Bundle();
        r17.putBinder("extra_caller_binder", new h());
        r12.putExtras(r17);
        r12.putExtra("screen_off_finish", true);
        ArrayList<Integer> r18 = new ArrayList();
        r18.add(Boxing.boxInt(2));
        r18.add(Boxing.boxInt(2));
        r18.add(Boxing.boxInt(4));
        r18.add(Boxing.boxInt(4));
        r18.add(Boxing.boxInt(4));
        r18.add(Boxing.boxInt(2));
        r12.putIntegerArrayListExtra("accept_widget_size", r18);
        r12.addFlags(268435456);
        this.this$0.f11782a.getApplicationContext().startActivity(r12);     // Catch: Exception -> L14
    L19:
        return Unit.INSTANCE;
    L14:
        e = move-exception;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("open: start pick widget failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L21;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "open: start pick widget failed", e);
        this.this$0.a();
        this.this$0.g.invoke();
        goto L19
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l r20 = this.this$0;
        this.label = 1;
        r20.getClass();
        r10 = BuildersKt.withContext(Dispatchers.getIO(), new WidgetPickerCoordinator$loadAddedWidgets$2(r20, null), this);
        if (r10 != r5) goto L11;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((WidgetPickerCoordinator$open$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
