package com.obric.memorydata.datatransport.activity;

import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$1$1", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DataExportActivity$onCreate$5$1$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $percent;
    final /* synthetic */ long $processed;
    final /* synthetic */ long $total;
    int label;
    final /* synthetic */ DataExportActivity this$0;

    DataExportActivity$onCreate$5$1$1$1$1(DataExportActivity r3, int r4, long r5, long r7, Continuation<? super DataExportActivity$onCreate$5$1$1$1$1> r9) {
        DataExportActivity r6 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r6;
        this.$percent = r4;
        this.$processed = r5;
        this.$total = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$5$1$1$1$1(this.this$0, this.$percent, this.$processed, this.$total, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataExportActivity$onCreate$5$1$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataExportActivity$onCreate$5$1$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        TextView r8 = DataExportActivity.access$getTvProgress$p(this.this$0);
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r8 = null;
    L7:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zip_test_progress, TypedValues.Custom.S_STRING, "data_transport_data_export_zip_test_progress"), new Object[]{Boxing.boxInt(this.$percent), Boxing.boxLong(this.$processed), Boxing.boxLong(this.$total)}), CharSequence.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
