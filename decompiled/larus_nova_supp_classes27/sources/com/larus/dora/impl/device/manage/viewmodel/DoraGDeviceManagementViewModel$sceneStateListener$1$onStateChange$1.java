package com.larus.dora.impl.device.manage.viewmodel;

import a49.f;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.impl.device.manage.DiaryDisplayMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$sceneStateListener$1$onStateChange$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {BaiduNaviStatus.WRONG_AK_PARAM, 206}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementViewModel$sceneStateListener$1$onStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $scene;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    public DoraGDeviceManagementViewModel$sceneStateListener$1$onStateChange$1(DoraGDeviceManagementViewModel r1, int r2, int r3, Continuation<? super DoraGDeviceManagementViewModel$sceneStateListener$1$onStateChange$1> r4) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraGDeviceManagementViewModel$sceneStateListener$1$onStateChange$1(this.this$0, this.$scene, this.$state, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L52:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L14:
        if (this.$scene != 2) goto L52;
        int r10 = this.$state;
        if (r10 == 1) goto L18;
        if (r10 != 2) goto L52;
    L18:
        f r11 = ((DoraGDeviceManagementViewModel.c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue()).i;
        String r2 = null;
        if (r11 == null) goto L21;
        String r12 = r11.d;
    L23:
        if (r12 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == false) goto L42;
        f r14 = ((DoraGDeviceManagementViewModel.c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue()).i;
        if (r14 == null) goto L33;
        r2 = r14.e;
    L33:
        if (r2 != null) goto L35;
    L38:
        boolean r15 = true;
    L39:
        if (r15 == false) goto L42;
        boolean r16 = false;
    L43:
        DoraGDeviceManagementViewModel r4 = this.this$0;
        DiaryDisplayMode r5 = DoraGDeviceManagementViewModel.access$getCurrentDiaryDisplayMode$p(r4);
        if (DoraGDeviceManagementViewModel.access$getCurrentDiaryDisplayMode$p(this.this$0) != DiaryDisplayMode.NORMAL) goto L47;
        if (r16 == false) goto L47;
    L48:
        this.label = 2;
        if (DoraGDeviceManagementViewModel.access$updateDiaryAndQuickNoteComponents(r4, false, r5, r3, this) != r0) goto L52;
        return r0;
    L47:
        r3 = false;
        goto L48
    L35:
        if (r2.length() == 0) goto L38;
        r15 = false;
    L42:
        r16 = true;
        goto L43
    L25:
        if (r12.length() == 0) goto L28;
        r13 = false;
        goto L29
    L21:
        r12 = null;
        goto L23
    L10:
        ResultKt.throwOnFailure(r9);
        DoraGDeviceManagementViewModel r17 = this.this$0;
        this.label = 1;
        if (DoraGDeviceManagementViewModel.access$updateOnlyDeviceComponentWithoutSoda(r17, this) != r0) goto L14;
        return r0;
    }
}
