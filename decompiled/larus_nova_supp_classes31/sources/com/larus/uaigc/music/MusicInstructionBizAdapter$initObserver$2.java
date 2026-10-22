package com.larus.uaigc.music;

import android.text.TextUtils;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.music.instructions.g;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.music.applet.f;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import org.json.JSONObject;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.MusicInstructionBizAdapter$initObserver$2", f = "MusicInstructionBizAdapter.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
final class MusicInstructionBizAdapter$initObserver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $instructionEditorViewModel;
    int label;
    final /* synthetic */ b this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ c a;
        public final /* synthetic */ b b;

        public a(c r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object emit(Object r20, Continuation r21) {
            bq8.a r1 = (bq8.a) r20;
            FLogger.a.d("MusicInstructionBizAdapter", "instruction music template prompt = " + r1.d + " lyrics = " + r1.getLyrics());
            ChatParam r2 = this.a.getChatParam();
            Object r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.a;
        L6:
            String r5 = "";
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            if (d.a(this.b.h).getAbility(f.class) == null) goto L34;
            g r6 = this.b.j;
            if (r6 == null) goto L89;
            Intrinsics.checkNotNullParameter(r1, "template");
            Intrinsics.checkNotNullParameter(r4, "cvsId");
            if (TextUtils.isEmpty(r1.d) == true) goto L19;
            r3 = r1.d;
            if (r3 == null) goto L22;
        L23:
            String r12 = r3;
            if (r12 == 0) goto L28;
            IAIChatRenderTraceService.a.g(r4, r12);
            ICoreInputAbility r11 = r6.d();
            if (r11 == null) goto L28;
            ICoreInputAbility.b.d(r11, r12, false, true, null, null, false, 58);
        L28:
            c r7 = r6.l;
            if (r7 == null) goto L31;
            JSONObject r8 = new JSONObject();
            r8.put("id", String.valueOf(r1.a));
            Unit r9 = Unit.INSTANCE;
            r7.setMsgExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r8.toString())), "MusicCreateManager");
        L31:
            ICoreInputAbility r10 = r6.d();
            if (r10 == null) goto L89;
            r10.g2(3, true);
        L22:
            r3 = "";
            goto L23
        L19:
            if (TextUtils.isEmpty(r1.getLyrics()) == true) goto L23;
            r3 = r1.getLyrics();
            if (r3 != null) goto L23;
        L89:
            return Unit.INSTANCE;
        L34:
            g r13 = this.b.j;
            if (r13 == null) goto L89;
            Intrinsics.checkNotNullParameter(r1, "template");
            Intrinsics.checkNotNullParameter(r4, "cvsId");
            if (TextUtils.isEmpty(r1.d) == true) goto L60;
            IAIChatRenderTraceService.Companion r14 = IAIChatRenderTraceService.a;
            String r15 = r1.d;
            if (r15 != null) goto L41;
            r15 = "";
        L41:
            r14.g(r4, r15);
            com.larus.bmhome.instruction.g r16 = (com.larus.bmhome.instruction.g) r13.f.getValue();
            if (r16 == null) goto L44;
            boolean r17 = r16.z0();
        L47:
            r3 = Boolean.valueOf(r17);
        L49:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L54;
            String r18 = r1.d;
            if (r18 == null) goto L55;
            String r19 = r18;
        L56:
            ICoreInputAbility r110 = r13.d();
            if (r110 == null) goto L82;
            ICoreInputAbility.b.d(r110, r19, false, true, null, null, false, 58);
        L82:
            c r22 = r13.l;
            if (r22 == null) goto L85;
            JSONObject r23 = new JSONObject();
            r23.put("id", String.valueOf(r1.a));
            Unit r24 = Unit.INSTANCE;
            r22.setMsgExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r23.toString())), "MusicCreateManager");
        L85:
            ICoreInputAbility r25 = r13.d();
            if (r25 == null) goto L89;
            r25.g2(3, true);
        L55:
            r19 = r5;
            goto L56
        L54:
            r5 = g.e(r1, true);
            goto L55
        L44:
            ys8.a r26 = (ys8.a) r13.g.getValue();
            if (r26 == null) goto L49;
            r17 = r26.z0();
            goto L47
        L60:
            if (TextUtils.isEmpty(r1.getLyrics()) == true) goto L82;
            IAIChatRenderTraceService.Companion r111 = IAIChatRenderTraceService.a;
            String r112 = r1.getLyrics();
            if (r112 != null) goto L64;
            r112 = "";
        L64:
            r111.g(r4, r112);
            com.larus.bmhome.instruction.g r27 = (com.larus.bmhome.instruction.g) r13.f.getValue();
            if (r27 == null) goto L67;
            boolean r28 = r27.z0();
        L70:
            r3 = Boolean.valueOf(r28);
        L72:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L77;
            String r29 = r1.getLyrics();
            if (r29 == null) goto L78;
            String r113 = r29;
        L79:
            ICoreInputAbility r114 = r13.d();
            if (r114 == null) goto L82;
            ICoreInputAbility.b.d(r114, r113, false, true, null, null, false, 58);
        L78:
            r113 = r5;
            goto L79
        L77:
            r5 = g.e(r1, false);
            goto L78
        L67:
            ys8.a r30 = (ys8.a) r13.g.getValue();
            if (r30 == null) goto L72;
            r28 = r30.z0();
            goto L70
        L5:
            r4 = null;
            goto L6
        }
    }

    public MusicInstructionBizAdapter$initObserver$2(c r1, b r2, Continuation<? super MusicInstructionBizAdapter$initObserver$2> r3) {
        this.$instructionEditorViewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicInstructionBizAdapter$initObserver$2(this.$instructionEditorViewModel, this.this$0, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        d1 r7 = this.$instructionEditorViewModel.getInstructionMusicTemplatePrompt();
        a r2 = new a(this.$instructionEditorViewModel, this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
