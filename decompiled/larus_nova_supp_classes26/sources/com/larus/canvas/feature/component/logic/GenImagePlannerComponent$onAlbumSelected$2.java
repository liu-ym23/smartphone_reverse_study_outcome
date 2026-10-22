package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$onAlbumSelected$2", f = "GenImagePlannerComponent.kt", i = {}, l = {441, 448, 453, 485, 490, 493}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$onAlbumSelected$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAiCreation;
    final /* synthetic */ boolean $isHeifOrHeic;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$onAlbumSelected$2(boolean r1, GenImagePlannerComponent r2, Uri r3, boolean r4, Continuation<? super GenImagePlannerComponent$onAlbumSelected$2> r5) {
        this.$isHeifOrHeic = r1;
        this.this$0 = r2;
        this.$uri = r3;
        this.$isAiCreation = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GenImagePlannerComponent$onAlbumSelected$2(this.$isHeifOrHeic, this.this$0, this.$uri, this.$isAiCreation, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r2 = "";
        boolean r3 = true;
        String r4 = null;
        switch(this.label) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r13);
    L74:
        ic8.n0 r14 = (ic8.n0) r13;
        this.this$0.Q = false;
        if (r14 == null) goto L81;
        ProcessFileResultCode r1 = r14.b;
        if (r1 == null) goto L81;
        if (r1.isSuccess() != true) goto L81;
    L82:
        if (r3 == false) goto L99;
        ic8.m0 r5 = r14.a;
        if (r5 == null) goto L86;
        String r6 = r5.e;
    L88:
        if (com.larus.utils.o0.d(r6) == false) goto L99;
        GenImagePlannerComponent r7 = this.this$0;
        ic8.m0 r15 = r14.a;
        if (r15 == null) goto L92;
        String r16 = r15.e;
    L93:
        if (r16 == null) goto L96;
        r2 = r16;
    L96:
        this.label = 6;
        if (r7.B4(r2, null, this) != r0) goto L101;
        return r0;
    L101:
        return Unit.INSTANCE;
    L92:
        r16 = null;
        goto L93
    L86:
        r6 = null;
    L99:
        GenImagePlannerComponent.m3(this.this$0, r14);
    L81:
        r3 = false;
        goto L82
    L7:
        ResultKt.throwOnFailure(r13);
        goto L101
    L8:
        ResultKt.throwOnFailure(r13);
    L53:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r13);
    L22:
        ic8.n0 r17 = (ic8.n0) r13;
        this.this$0.Q = false;
        if (r17 == null) goto L29;
        ProcessFileResultCode r8 = r17.b;
        if (r8 == null) goto L29;
        if (r8.isSuccess() != true) goto L29;
    L30:
        if (r3 == false) goto L51;
        ic8.m0 r9 = r17.a;
        if (r9 == null) goto L34;
        String r10 = r9.e;
    L36:
        if (com.larus.utils.o0.d(r10) == false) goto L51;
        GenImagePlannerComponent r11 = this.this$0;
        ic8.m0 r18 = r17.a;
        if (r18 == null) goto L40;
        String r12 = r18.e;
    L41:
        if (r12 != null) goto L43;
        r12 = "";
    L43:
        if (r18 == null) goto L45;
        r4 = r18.e;
    L45:
        if (r4 == null) goto L48;
        r2 = r4;
    L48:
        this.label = 3;
        if (r11.B4(r12, r2, this) != r0) goto L53;
        return r0;
    L40:
        r12 = null;
        goto L41
    L34:
        r10 = null;
    L51:
        GenImagePlannerComponent.m3(this.this$0, r17);
    L29:
        r3 = false;
        goto L30
    L10:
        ResultKt.throwOnFailure(r13);
    L16:
        boolean r19 = ((Boolean) r13).booleanValue();
    L18:
        if (r19 == false) goto L54;
        GenImagePlannerComponent r110 = this.this$0;
        Uri r20 = this.$uri;
        this.label = 2;
        int r21 = GenImagePlannerComponent.W;
        r110.getClass();
        r13 = BuildersKt.withContext(Dispatchers.getIO(), new GenImagePlannerComponent$preprocessAlbumImg$2(r20, null), this);
        if (r13 != r0) goto L22;
        return r0;
    L54:
        final Pair<Integer, Integer> r111 = com.larus.canvas.feature.component.logic.helper.g.c(this.$uri);
        final String r22 = vqc.d.d(AppHost.a.getApplication(), this.$uri);
        if (r22 != null) goto L57;
        r22 = "";
    L57:
        Uri r23 = this.$uri;
        if (r22.length() != 0) goto L60;
        boolean r24 = true;
    L61:
        if (r24 == false) goto L63;
        r22 = r23.toString();
    L63:
        StateFlowImpl r25 = this.this$0.m;
        final boolean r26 = this.$isAiCreation;
        com.larus.canvas.feature.component.logic.helper.f.a(r25, new m1(r111, r22, r26));
        if (z2.a.enableCreationResourceAccessPipeline() == false) goto L71;
        GenImagePlannerComponent r27 = this.this$0;
        r27.Q = false;
        String r28 = this.$uri.toString();
        com.larus.bmhome.resource.access.j0.a r29 = new com.larus.bmhome.resource.access.j0.a(this.$uri.toString());
        this.label = 4;
        Object r112 = r27.V4(r28, r29, null, true, this);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        r112 = Unit.INSTANCE;
    L69:
        if (r112 != r0) goto L101;
        return r0;
    L71:
        GenImagePlannerComponent r113 = this.this$0;
        Uri r30 = this.$uri;
        this.label = 5;
        r113.getClass();
        r13 = BuildersKt.withContext(Dispatchers.getIO(), new GenImagePlannerComponent$preprocessAlbumImg$2(r30, null), this);
        if (r13 != r0) goto L74;
        return r0;
    L60:
        r24 = false;
        goto L61
    L11:
        ResultKt.throwOnFailure(r13);
        if (this.$isHeifOrHeic == false) goto L17;
        CoroutineDispatcher r114 = Dispatchers.getIO();
        GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1 r31 = new GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1(this.$uri, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r114, r31, this);
        if (r13 != r0) goto L16;
        return r0;
    L17:
        r19 = false;
        goto L18
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
