package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.bmhome.taskskill.service.i;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController$loadProjects$1", f = "ProjectPanelController.kt", i = {0, 0}, l = {DoraCallStateCode.DOUBAO_RAPID_FLASHING_END}, m = "invokeSuspend", n = {"snapshot", "rounds"}, s = {"L$0", "I$0"})
public final class ProjectPanelController$loadProjects$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IProjectListDataSource $dataSource;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ ProjectPanelController this$0;

    public ProjectPanelController$loadProjects$1(IProjectListDataSource r1, ProjectPanelController r2, Continuation<? super ProjectPanelController$loadProjects$1> r3) {
        this.$dataSource = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProjectPanelController$loadProjects$1(this.$dataSource, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004b -> B:17:0x0050). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        i r4 = (i) this.L$0;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
        i r5 = r4;
        ProjectPanelController$loadProjects$1 r6 = this;
    L18:
        if (Result.isFailure-impl(r12) == false) goto L20;
        Object r7 = null;
    L21:
        i r8 = (i) r7;
        if (r8 != null) goto L24;
        FLogger.a.e("ProjectPanelController", "load projects failed", Result.exceptionOrNull-impl(r12));
        ProjectPanelController$loadProjects$1 r3 = r6;
        i r9 = r5;
    L31:
        ProjectPanelController r13 = r3.this$0;
        List r10 = r9.a;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r10.iterator();
    L33:
        if (r15.hasNext() == false) goto L37;
        ProjectPanelController.b r16 = ProjectPanelController.a(r13, ((com.larus.bmhome.taskskill.service.h) r15.next()).a);
        if (r16 == null) goto L33;
        r14.add(r16);
        goto L33
    L37:
        r13.k = r14;
        ProjectPanelController r17 = r3.this$0;
        r17.m = r9.b;
        r17.l = false;
        r17.e();
        return Unit.INSTANCE;
    L24:
        ProjectPanelController r18 = r6.this$0;
        List r19 = r8.a;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L26:
        if (r21.hasNext() == false) goto L30;
        ProjectPanelController.b r22 = ProjectPanelController.a(r18, ((com.larus.bmhome.taskskill.service.h) r21.next()).a);
        if (r22 == null) goto L26;
        r20.add(r22);
        goto L26
    L30:
        r18.k = r20;
        ProjectPanelController r110 = r6.this$0;
        r110.m = r8.b;
        r110.e();
        int r111 = r2;
        r3 = r6;
        r9 = r8;
    L10:
        if (r9.b == false) goto L31;
        if (r111 >= 20) goto L31;
        int r112 = r111 + 1;
        IProjectListDataSource r23 = r3.$dataSource;
        r3.L$0 = r9;
        r3.I$0 = r112;
        r3.label = 1;
        Object r24 = r23.d(r3);
        if (r24 != r0) goto L16;
        return r0;
    L16:
        ProjectPanelController$loadProjects$1 r25 = r3;
        r2 = r112;
        r12 = r24;
        r5 = r9;
        r6 = r25;
        goto L18
    L20:
        r7 = r12;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r3 = this;
        r9 = this.$dataSource.getList();
        r111 = 0;
        goto L10
    }
}
