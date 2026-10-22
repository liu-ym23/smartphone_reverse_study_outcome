package com.larus.bmhome.view.actionbar.edit.component;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownListSelectorWidgetV2$observeDataChange$2", f = "DropdownListSelectorWidgetV2.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
final class DropdownListSelectorWidgetV2$observeDataChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownListSelectorWidgetV2 this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownListSelectorWidgetV2 a;

        public a(DropdownListSelectorWidgetV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r19, Continuation r20) {
            bq8.a r1 = (bq8.a) r19;
            if (this.a.isAttachedToWindow() == false) goto L114;
            final ArrayList r2 = new ArrayList();
            com.larus.bmhome.actionbar.model.i r3 = DropdownListSelectorWidgetV2.k6(this.a);
            final com.larus.bmhome.actionbar.model.i r4 = null;
            if (r3 == null) goto L97;
            List r5 = r3.a;
            if (r5 == null) goto L97;
            DropdownListSelectorWidgetV2 r12 = this.a;
            Iterator<T> r6 = r5.iterator();
            int r14 = 0;
        L11:
            if (r6.hasNext() == false) goto L97;
            T r7 = r6.next();
            int r15 = r14 + 1;
            if (r14 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            com.larus.bmhome.actionbar.model.h r11 = (com.larus.bmhome.actionbar.model.h) r7;
            Integer r8 = r11.b;
            bq8.e r9 = r1.b().b;
            if (r9 == null) goto L18;
            Integer r10 = Boxing.boxInt(r9.d);
        L20:
            if (Intrinsics.areEqual(r8, r10) == false) goto L42;
            r2.add(Boxing.boxInt(r14));
            List r13 = r11.e;
            if (r13 == null) goto L42;
            Iterator<T> r16 = r13.iterator();
            int r17 = 0;
        L25:
            if (r16.hasNext() == false) goto L42;
            T r18 = r16.next();
            int r110 = r17 + 1;
            if (r17 >= 0) goto L29;
            CollectionsKt.throwIndexOverflow();
        L29:
            com.larus.bmhome.actionbar.model.w r21 = (com.larus.bmhome.actionbar.model.w) r18;
            Long r22 = r21.a;
            bq8.e r23 = r1.b().b;
            if (r23 == null) goto L32;
            Long r24 = Boxing.boxLong(r23.a);
        L34:
            if (Intrinsics.areEqual(r22, r24) == false) goto L40;
            bq8.e r25 = r1.b().b;
            if (r25 == null) goto L38;
            Integer r26 = Boxing.boxInt(r25.d);
        L39:
            DropdownListSelectorWidgetV2.o6(r12, r26, r21, r11, r17, r14, "use_template");
        L41:
            r11 = r11;
            r17 = r110;
            r14 = r14;
            goto L25
        L38:
            r26 = null;
            goto L39
        L40:
            r21.s = Boxing.boxInt(0);
            goto L41
        L32:
            r24 = null;
        L42:
            int r27 = r14;
            com.larus.bmhome.actionbar.model.h r111 = r11;
            Integer r28 = r111.b;
            bq8.e r29 = r1.b().a;
            if (r29 == null) goto L45;
            Integer r30 = Boxing.boxInt(r29.d);
        L47:
            if (Intrinsics.areEqual(r28, r30) == false) goto L69;
            r2.add(Boxing.boxInt(r27));
            List r31 = r111.e;
            if (r31 == null) goto L69;
            Iterator<T> r112 = r31.iterator();
            int r32 = 0;
        L52:
            if (r112.hasNext() == false) goto L69;
            T r33 = r112.next();
            int r113 = r32 + 1;
            if (r32 >= 0) goto L56;
            CollectionsKt.throwIndexOverflow();
        L56:
            com.larus.bmhome.actionbar.model.w r34 = (com.larus.bmhome.actionbar.model.w) r33;
            Long r35 = r34.a;
            bq8.e r36 = r1.b().a;
            if (r36 == null) goto L59;
            Long r37 = Boxing.boxLong(r36.a);
        L61:
            if (Intrinsics.areEqual(r35, r37) == false) goto L67;
            bq8.e r38 = r1.b().b;
            if (r38 == null) goto L65;
            Integer r39 = Boxing.boxInt(r38.d);
        L66:
            DropdownListSelectorWidgetV2.o6(r12, r39, r34, r111, r32, r27, "use_template");
        L68:
            r32 = r113;
            goto L52
        L65:
            r39 = null;
            goto L66
        L67:
            r34.s = Boxing.boxInt(0);
            goto L68
        L59:
            r37 = null;
        L69:
            Integer r40 = r111.b;
            bq8.e r41 = r1.b().c;
            if (r41 == null) goto L72;
            Integer r42 = Boxing.boxInt(r41.d);
        L74:
            if (Intrinsics.areEqual(r40, r42) == false) goto L96;
            r2.add(Boxing.boxInt(r27));
            List r43 = r111.e;
            if (r43 == null) goto L96;
            Iterator<T> r114 = r43.iterator();
            int r44 = 0;
        L79:
            if (r114.hasNext() == false) goto L96;
            T r45 = r114.next();
            int r115 = r44 + 1;
            if (r44 >= 0) goto L83;
            CollectionsKt.throwIndexOverflow();
        L83:
            com.larus.bmhome.actionbar.model.w r46 = (com.larus.bmhome.actionbar.model.w) r45;
            Long r47 = r46.a;
            bq8.e r48 = r1.b().c;
            if (r48 == null) goto L86;
            Long r49 = Boxing.boxLong(r48.a);
        L88:
            if (Intrinsics.areEqual(r47, r49) == false) goto L94;
            bq8.e r50 = r1.b().b;
            if (r50 == null) goto L92;
            Integer r51 = Boxing.boxInt(r50.d);
        L93:
            DropdownListSelectorWidgetV2.o6(r12, r51, r46, r111, r44, r27, "use_template");
        L95:
            r44 = r115;
            goto L79
        L92:
            r51 = null;
            goto L93
        L94:
            r46.s = Boxing.boxInt(0);
            goto L95
        L86:
            r49 = null;
        L96:
            r14 = r15;
            goto L11
        L72:
            r42 = null;
            goto L74
        L45:
            r30 = null;
            goto L47
        L18:
            r10 = null;
        L97:
            com.larus.bmhome.actionbar.model.i r52 = DropdownListSelectorWidgetV2.k6(this.a);
            if (r52 == null) goto L100;
            r4 = new com.larus.bmhome.actionbar.model.i(r52.a);
        L100:
            RecyclerView r53 = this.a.getBinding().c;
            final DropdownListSelectorWidgetV2 r54 = this.a;
            r53.post(new a1(r54, r4, r2));
            return Unit.INSTANCE;
        L114:
            return Unit.INSTANCE;
        }
    }

    public DropdownListSelectorWidgetV2$observeDataChange$2(DropdownListSelectorWidgetV2 r1, Continuation<? super DropdownListSelectorWidgetV2$observeDataChange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownListSelectorWidgetV2$observeDataChange$2(this.this$0, r3);
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
        DropdownListSelectorWidgetV2 r6 = this.this$0;
        int r2 = DropdownListSelectorWidgetV2.j;
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
