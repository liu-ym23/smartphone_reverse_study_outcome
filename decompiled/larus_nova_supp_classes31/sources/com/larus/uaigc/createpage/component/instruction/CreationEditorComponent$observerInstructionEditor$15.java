package com.larus.uaigc.createpage.component.instruction;

import android.app.Application;
import androidx.collection.LruCache;
import androidx.lifecycle.LiveData;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$15", f = "CreationEditorComponent.kt", i = {}, l = {3018}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r27, Continuation r28) {
            com.larus.bmhome.actionbar.model.p1 r0 = (com.larus.bmhome.actionbar.model.p1) r27;
            if (r0 == null) goto L154;
            CreationEditorComponent r2 = this.a;
            FLogger.a.d("CreationEditorComponent", "clicked msgInstruction");
            int r3 = CreationEditorComponent.g2;
            String r6 = "";
            if (r2.T4() == false) goto L78;
            uz9.a r4 = r2.r;
            if (r4 == null) goto L9;
            LiveData<Map<String, ry9.k>> r5 = r4.o();
        L10:
            if (r5 == null) goto L159;
            Map<String, ry9.k> r7 = (Map) r5.getValue();
            if (r7 == null) goto L160;
            Iterator<ry9.k> r10 = r7.values().iterator();
            int r8 = 0;
            int r9 = 0;
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
            int r16 = 0;
        L17:
            if (r10.hasNext() == false) goto L48;
            ry9.k r17 = r10.next();
            ry9.j r1 = r17.b;
            String r18 = r6;
            if ((r1 instanceof ry9.j.b) == false) goto L22;
            Unit r19 = Unit.INSTANCE;
        L43:
            if (r17.d == false) goto L45;
            r9 = r9 + 1;
        L45:
            r6 = r18;
            goto L17
        L22:
            if ((r1 instanceof ry9.j.c) == false) goto L25;
            Boxing.boxInt(r8);
            r8 = r8 + 1;
            goto L43
        L25:
            if ((r1 instanceof ry9.j.f) == false) goto L28;
            Boxing.boxInt(r13);
            r13 = r13 + 1;
            goto L43
        L28:
            if ((r1 instanceof ry9.j.h) == false) goto L31;
            Boxing.boxInt(r16);
            r16 = r16 + 1;
            goto L43
        L31:
            if ((r1 instanceof ry9.j.d) == false) goto L34;
            Boxing.boxInt(r14);
            r14 = r14 + 1;
            goto L43
        L34:
            if ((r1 instanceof ry9.j.e) == false) goto L37;
            Boxing.boxInt(r12);
            r12 = r12 + 1;
            goto L43
        L37:
            if ((r1 instanceof ry9.j.g) == false) goto L40;
            Boxing.boxInt(r15);
            r15 = r15 + 1;
            goto L43
        L40:
            if ((r1 instanceof ry9.j.a) == false) goto L47;
            Boxing.boxInt(r11);
            r11 = r11 + 1;
            goto L43
        L47:
            throw new NoWhenBranchMatchedException();
        L48:
            String r110 = r6;
            FLogger.a.i("CreationEditorComponent", "parseFailCount = " + r12 + ", uploadFailCount = " + r13 + ", inspectFail = " + r14 + ", uploadSuccessCount = " + r15 + ", uploadingCount = " + r16 + ", successCount = " + r8 + ", compressingCount = " + r11 + ", privateCount = " + r9);
            if (r11 <= 0) goto L57;
            int r20 = com.larus.uaigc.createpage.component.input.a.a;
            com.larus.uaigc.helper.f.a.getClass();
            boolean r21 = com.larus.uaigc.helper.f.a();
            boolean r22 = r2.V5();
            if (r21 == false) goto L54;
            if (r22 == false) goto L54;
            boolean r23 = true;
        L55:
            if (r23 == true) goto L57;
            t19.s r24 = t19.s.a;
            Application r25 = AppHost.a.getApplication();
            String r26 = r2.getContext().getString(2131899641);
            r24.getClass();
            t19.s.t(r25, r26);
        L112:
            ny9.u r29 = r2.d4();
            if (r29 == null) goto L115;
            String r30 = r29.b();
        L117:
            if (com.larus.utils.o0.d(r30) == false) goto L122;
            ny9.u r31 = r2.d4();
            if (r31 == null) goto L121;
            String r32 = r31.b();
        L123:
            String r111 = r32;
        L124:
            hy9.d r33 = ICreationReportService.a.j();
            String r34 = r0.b;
            Integer r35 = r0.a;
            if (r35 == null) goto L127;
            String r36 = r35.toString();
        L128:
            ny9.u r37 = r2.d4();
            if (r37 == null) goto L131;
            String r38 = r37.r();
        L132:
            ny9.u r39 = r2.d4();
            if (r39 == null) goto L135;
            String r40 = r39.getBotId();
        L136:
            ny9.u r41 = r2.d4();
            if (r41 == null) goto L139;
            String r112 = r41.getEnterMethod();
        L140:
            ny9.u r42 = r2.d4();
            if (r42 == null) goto L143;
            String r113 = r42.m();
        L144:
            ny9.u r43 = r2.d4();
            if (r43 == null) goto L147;
            String r114 = r43.i();
        L148:
            String r210 = r2.p4();
            uy9.a r44 = r2.q4();
            if (r44 == null) goto L151;
            String r211 = r44.PG();
        L152:
            hy9.d.a.a(r33, r34, null, r36, r38, "single_function", r40, r112, r113, r114, r111, null, null, null, null, null, null, r210, null, r2.k(), r211, null, 3341314);
            goto L154
        L151:
            r211 = null;
            goto L152
        L147:
            r114 = null;
            goto L148
        L143:
            r113 = null;
            goto L144
        L139:
            r112 = null;
            goto L140
        L135:
            r40 = null;
            goto L136
        L131:
            r38 = null;
            goto L132
        L127:
            r36 = null;
            goto L128
        L121:
            r111 = null;
            goto L124
        L122:
            LruCache r45 = ko8.a.a;
            r32 = ko8.a.h(ko8.a.e);
            goto L123
        L115:
            r30 = null;
        L54:
            r23 = false;
        L57:
            if (r12 > 0) goto L77;
            if (r13 > 0) goto L77;
            if (r14 > 0) goto L77;
            if (r8 != 0) goto L73;
            if (r16 != 0) goto L73;
            if (r15 != 0) goto L73;
            if (r11 != 0) goto L73;
            r2.g1 = r0;
            if (com.larus.utils.o0.d(r0.g) == false) goto L72;
            String r46 = r0.g;
            if (r46 != null) goto L70;
            String r47 = r110;
        L71:
            r2.v4(r47, r7);
            goto L112
        L70:
            r47 = r46;
            goto L71
        L72:
            r2.q5(false);
        L73:
            if (r9 > 0) goto L75;
            boolean r48 = true;
        L76:
            r2.F4(r0, r48, r7);
            goto L112
        L75:
            r48 = false;
        L77:
            r2.W5();
            Boxing.boxBoolean(true);
            goto L112
        L160:
            return Unit.INSTANCE;
        L159:
            return Unit.INSTANCE;
        L9:
            r5 = null;
            goto L10
        L78:
            ry9.g r49 = r2.k4();
            if (r49 == null) goto L83;
            kotlinx.coroutines.flow.i1<ry9.j> r50 = r49.D20();
            if (r50 == null) goto L83;
            ry9.j r51 = (ry9.j) r50.getValue();
        L85:
            if ((r51 instanceof ry9.j.c) == false) goto L88;
            r2.F4(r0, true, MapsKt.emptyMap());
            goto L112
        L88:
            if ((r51 instanceof ry9.j.f) == false) goto L91;
            t19.s r52 = t19.s.a;
            Application r53 = AppHost.a.getApplication();
            String r54 = r2.getContext().getString(2131899639);
            r52.getClass();
            t19.s.t(r53, r54);
            goto L112
        L91:
            if ((r51 instanceof ry9.j.h) == false) goto L103;
            String r55 = r0.g;
            if (r55 != null) goto L95;
        L98:
            boolean r56 = true;
        L99:
            if (r56 == false) goto L101;
            r2.F4(r0, true, MapsKt.emptyMap());
            goto L112
        L101:
            t19.s r57 = t19.s.a;
            Application r58 = AppHost.a.getApplication();
            String r59 = r2.getContext().getString(2131899641);
            r57.getClass();
            t19.s.t(r58, r59);
            goto L112
        L95:
            if (r55.length() == 0) goto L98;
            r56 = false;
            goto L99
        L103:
            if ((r51 instanceof ry9.j.b) == false) goto L112;
            Map<String, ry9.k> r60 = MapsKt.emptyMap();
            r2.g1 = r0;
            if (com.larus.utils.o0.d(r0.g) == false) goto L111;
            String r61 = r0.g;
            if (r61 != null) goto L109;
            String r62 = "";
        L110:
            r2.v4(r62, r60);
            goto L112
        L109:
            r62 = r61;
            goto L110
        L111:
            r2.q5(false);
        L83:
            r51 = null;
        L154:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$15(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$15> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$15(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getChosenMsgInstructionFlow();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
