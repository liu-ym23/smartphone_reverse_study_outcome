package com.larus.uaigc.music.template;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1", f = "MusicTemplateListSelectorWidgetV2.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
final class MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicTemplateListSelectorWidgetV2 this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1$1", f = "MusicTemplateListSelectorWidgetV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<bq8.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MusicTemplateListSelectorWidgetV2 this$0;

        public AnonymousClass1(MusicTemplateListSelectorWidgetV2 r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(bq8.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((bq8.a) r1, (Continuation) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34, types: [int] */
        /* JADX WARN: Type inference failed for: r1v39 */
        public final Object invokeSuspend(Object r53) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L121;
            ResultKt.throwOnFailure(r53);
            bq8.a r1 = (bq8.a) this.L$0;
            if (this.this$0.isAttachedToWindow() == false) goto L7;
            ArrayList r2 = new ArrayList();
            bq8.e r3 = r1.b().c;
            if (r3 == null) goto L11;
            Long r4 = Boxing.boxLong(r3.a);
        L12:
            Ref.IntRef r5 = new Ref.IntRef();
            Ref.IntRef r6 = new Ref.IntRef();
            d0 r7 = MusicTemplateListSelectorWidgetV2.o6(this.this$0);
            int r8 = 1;
            int r9 = 0;
            if (r7 == null) goto L71;
            List r10 = r7.a;
            if (r10 == null) goto L71;
            MusicTemplateListSelectorWidgetV2 r11 = this.this$0;
            Iterator r12 = r10.iterator();
        L18:
            if (r12.hasNext() == false) goto L71;
            com.larus.bmhome.actionbar.model.w r13 = (com.larus.bmhome.actionbar.model.w) r12.next();
            r13.s = Boxing.boxInt(r9);
            if (Intrinsics.areEqual(r13.a, r4) == false) goto L69;
            r13.s = Boxing.boxInt(1);
            r5.element = r6.element;
            com.larus.bmhome.view.actionbar.edit.c r14 = r11.getViewModel();
            if (r14 == null) goto L26;
            ChatParam r15 = r14.getChatParam();
            if (r15 == null) goto L26;
            String r16 = r15.b;
        L27:
            com.larus.bmhome.view.actionbar.edit.c r17 = r11.getViewModel();
            if (r17 == null) goto L32;
            ChatParam r18 = r17.getChatParam();
            if (r18 == null) goto L32;
            String r19 = r18.e;
        L33:
            com.larus.bmhome.view.actionbar.edit.c r110 = r11.getViewModel();
            if (r110 == null) goto L36;
            String r111 = r110.getTemplateType();
        L37:
            com.larus.bmhome.view.actionbar.edit.c r112 = r11.getViewModel();
            if (r112 == null) goto L40;
            String r113 = r112.getActionBarType();
        L41:
            com.larus.bmhome.view.actionbar.edit.c r114 = r11.getViewModel();
            if (r114 == null) goto L46;
            z0 r115 = r114.getCurrentCustomActionBarItem();
            if (r115 == null) goto L46;
            String r116 = r115.b;
        L47:
            com.larus.bmhome.actionbar.model.u r117 = r11.getInstructionItem();
            if (r117 == null) goto L50;
            String r118 = r117.c;
        L51:
            String r119 = r13.b;
            String r20 = String.valueOf(r13.a);
            d0 r21 = MusicTemplateListSelectorWidgetV2.o6(r11);
            if (r21 == null) goto L59;
            int r22 = r5.element;
            Integer r23 = r21.b;
            if (r23 == null) goto L59;
            if (r22 != r23.intValue()) goto L59;
            int r24 = 1;
        L60:
            d0 r25 = MusicTemplateListSelectorWidgetV2.o6(r11);
            if (r25 == null) goto L63;
            ?? r26 = Intrinsics.areEqual(r25.c, Boxing.boxBoolean(true));
        L64:
            int r27 = r5.element + 1;
            com.larus.bmhome.view.actionbar.edit.c r120 = r11.getViewModel();
            if (r120 == null) goto L67;
            Boolean r36 = r120.isCreationActionBar();
        L68:
            String r34 = r11.u6();
            tx9.b.e(r16, r19, r111, r113, r116, r118, null, r119, r20, Boxing.boxInt(r24), Boxing.boxInt(r26), Boxing.boxInt(r27), "select", null, null, null, r11.s6(), "use_template", null, null, null, null, r34, null, r36, null, null, null, null, null, null, null, null, null, null, null, null, -42278848, 127);
        L70:
            r6.element++;
            r2.add(r13);
            r4 = r4;
            r9 = 0;
            goto L18
        L67:
            r36 = null;
            goto L68
        L63:
            r26 = 0;
        L59:
            r24 = 0;
            goto L60
        L50:
            r118 = null;
        L46:
            r116 = null;
            goto L47
        L40:
            r113 = null;
            goto L41
        L36:
            r111 = null;
        L32:
            r19 = null;
        L26:
            r16 = null;
            goto L27
        L69:
            r4 = r4;
        L71:
            ImageSelectorWidgetAdapter r28 = this.this$0.i;
            if (r28 == null) goto L74;
            r28.submitList(r2);
        L74:
            d0 r29 = MusicTemplateListSelectorWidgetV2.o6(this.this$0);
            if (r29 == null) goto L92;
            List r30 = r29.a;
            if (r30 == null) goto L92;
            Iterator r31 = r30.iterator();
        L80:
            if (r31.hasNext() == false) goto L90;
            Object r32 = r31.next();
            Integer r33 = ((com.larus.bmhome.actionbar.model.w) r32).s;
            if (r33 != null) goto L85;
        L87:
            boolean r35 = false;
        L88:
            if (r35 == false) goto L80;
            Object r37 = r32;
        L91:
            com.larus.bmhome.actionbar.model.w r38 = (com.larus.bmhome.actionbar.model.w) r37;
        L93:
            com.larus.bmhome.actionbar.model.u r39 = this.this$0.getInstructionItem();
            if (r39 == null) goto L101;
            Integer r40 = r39.a;
            if (r40 == null) goto L101;
            if (r40.intValue() != 1) goto L101;
            boolean r41 = true;
        L102:
            if (r41 == false) goto L109;
            com.larus.bmhome.view.actionbar.edit.c r42 = this.this$0.getViewModel();
            if (r42 == null) goto L109;
            if (r38 == null) goto L107;
            boolean r43 = true;
        L108:
            r42.setImageStyleRadioSelected(r43);
            goto L109
        L107:
            r43 = false;
        L109:
            RecyclerView.LayoutManager r44 = this.this$0.getBinding().c.getLayoutManager();
            if (r44 == null) goto L119;
            int r45 = r5.element;
            wz9.a r46 = MusicTemplateListSelectorWidgetV2.n6(this.this$0);
            if (r46 != null) goto L114;
        L116:
            r8 = 0;
        L117:
            r44.scrollToPosition(r45 + r8);
            goto L119
        L114:
            if (r46.n != true) goto L116;
        L119:
            return Unit.INSTANCE;
        L101:
            r41 = false;
            goto L102
        L85:
            if (r33.intValue() != 1) goto L87;
            r35 = true;
            goto L88
        L90:
            r37 = null;
        L92:
            r38 = null;
            goto L93
        L11:
            r4 = null;
            goto L12
        L7:
            return Unit.INSTANCE;
        L121:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1(MusicTemplateListSelectorWidgetV2 r1, Continuation<? super MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MusicTemplateListSelectorWidgetV2 r7 = this.this$0;
        int r2 = MusicTemplateListSelectorWidgetV2.n;
        com.larus.bmhome.view.actionbar.edit.c r8 = r7.getViewModel();
        if (r8 == null) goto L16;
        d1 r9 = r8.getInstructionMusicTemplatePrompt();
        if (r9 == null) goto L16;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L16;
        return r0;
    }
}
