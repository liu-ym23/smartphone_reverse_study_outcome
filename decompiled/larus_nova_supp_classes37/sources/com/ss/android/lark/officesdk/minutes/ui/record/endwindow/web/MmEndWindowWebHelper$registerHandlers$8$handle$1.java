package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$registerHandlers$8$handle$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowWebHelper$registerHandlers$8$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xwb.j $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ String $extraStr;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$registerHandlers$8$handle$1(MmEndWindowWebHelper r1, String r2, String r3, xwb.j r4, Continuation<? super MmEndWindowWebHelper$registerHandlers$8$handle$1> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.$extraStr = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmEndWindowWebHelper$registerHandlers$8$handle$1(this.this$0, this.$data, this.$extraStr, this.$callback, r8);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L14:
        this.$callback.a(Status.SUCCESS, (JSONObject) r7);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MmEndWindowWebHelper r8 = this.this$0;
        if (r8.i == false) goto L11;
        r8.e.n();
    L11:
        MmEndWindowWebHelper r9 = this.this$0;
        r9.i = true;
        boolean r10 = r9.e.isDarkMode();
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "getBackground", "isDarkMode=" + r10 + ", data=" + this.$data + ", extraStr=" + this.$extraStr, this.this$0.f());
        MmRecordingMapReadHelper r3 = (MmRecordingMapReadHelper) this.this$0.l.getValue();
        this.label = 1;
        r7 = r3.b(r10, this);
        if (r7 != r0) goto L14;
        return r0;
    }
}
