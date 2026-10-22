package com.obric.memorydata.datatransport.activity;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.datatransport.manager.c;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$6$1$1", f = "DataExportActivity.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
final class DataExportActivity$onCreate$6$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataExportActivity this$0;

    DataExportActivity$onCreate$6$1$1(DataExportActivity r3, Continuation<? super DataExportActivity$onCreate$6$1$1> r4) {
        DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$6$1$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataExportActivity$onCreate$6$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataExportActivity$onCreate$6$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        OButton r5 = null;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7 Exception -> L9
    L21:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L29;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_operation_busy, TypedValues.Custom.S_STRING, "data_transport_data_export_operation_busy")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();     // Catch: Throwable -> L7 Exception -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
        OButton r9 = DataExportActivity.access$getBtnClean$p(this.this$0);
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
    L27:
        r5.setEnabled(!c.f9761a.b());
        return r11;
    L26:
        r5 = r9;
        goto L27
    L29:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_clean_done, TypedValues.Custom.S_STRING, "data_transport_data_export_clean_done")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();     // Catch: Throwable -> L7 Exception -> L9
        DataExportActivity.access$clearCurrentExportResult(this.this$0);     // Catch: Throwable -> L7 Exception -> L9
        OButton r12 = DataExportActivity.access$getBtnClean$p(this.this$0);
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
    L34:
        r5.setEnabled(!c.f9761a.b());
        return Unit.INSTANCE;
    L33:
        r5 = r12;
        goto L34
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r10);
        OButton r13 = DataExportActivity.access$getBtnClean$p(this.this$0);
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
        r13 = null;
    L16:
        r13.setEnabled(false);
        CoroutineContext r14 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$6$1$1$cleaned$1(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
        r10 = i.a(r14, r2, r8);     // Catch: Throwable -> L7 Exception -> L9
        if (r10 != r0) goto L21;
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        String r15 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_clean_failed, TypedValues.Custom.S_STRING, "data_transport_data_export_clean_failed"), new Object[]{e.getMessage()});     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");     // Catch: Throwable -> L7
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), 1).show();     // Catch: Throwable -> L7
        TextView r3 = DataExportActivity.access$getTvProgress$p(this.this$0);     // Catch: Throwable -> L7
        if (r3 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");     // Catch: Throwable -> L7
        r3 = null;
    L38:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        OButton r16 = DataExportActivity.access$getBtnClean$p(this.this$0);
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
        goto L34
    L42:
        r5 = r16;
    L7:
        th = move-exception;
        OButton r17 = DataExportActivity.access$getBtnClean$p(this.this$0);
        if (r17 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
    L49:
        r5.setEnabled(!c.f9761a.b());
        throw th;
    L48:
        r5 = r17;
        goto L49
    }
}
