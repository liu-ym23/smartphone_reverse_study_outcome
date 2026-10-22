package com.larus.doc.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.doc.api.IDocService;
import com.larus.doc.api.IDocService$Companion;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$integrateFloatChatFragment$1$1", f = "DocFragment.kt", i = {}, l = {746}, m = "invokeSuspend", n = {}, s = {})
final class DocFragment$integrateFloatChatFragment$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentManager $frgManager;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$integrateFloatChatFragment$1$1(DocFragment r1, FragmentManager r2, Continuation<? super DocFragment$integrateFloatChatFragment$1$1> r3) {
        this.this$0 = r1;
        this.$frgManager = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragment$integrateFloatChatFragment$1$1(this.this$0, this.$frgManager, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L48:
        Fragment r13 = (Fragment) r12;
        if (r13 == null) goto L88;
        final DocFragment r2 = this.this$0;
        FragmentManager r5 = this.$frgManager;
        if (r2.isAdded() == true) goto L91;
        FLogger.a.i("DocFragment", "[integrateFloatChatFragment]: fragment is not added, will not add ChatInput fragment");
    L90:
        return Unit.INSTANCE;
    L91:
        r2.h = r13;     // Catch: Throwable -> L85
        if (r5 != null) goto L55;
        r5 = r2.getChildFragmentManager();     // Catch: Throwable -> L85
    L55:
        INVOKEVIRTUAL_com_larus_doc_impl_DocFragment$integrateFloatChatFragment$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r5.beginTransaction(), r2.Z90(), r13, "tag_doc_detail_chat_fragment").commitNowAllowingStateLoss();     // Catch: Throwable -> L85
        com.larus.doc.impl.offline.c r14 = r2.X;     // Catch: Throwable -> L85
        if (r14 == null) goto L58;
        r14.g60();     // Catch: Throwable -> L85
    L58:
        Fragment r15 = r2.h;     // Catch: Throwable -> L85
        if (r15 == null) goto L83;
        va8.g0 r6 = s1a.a.g(r15).getAbility(va8.g0.class);     // Catch: Throwable -> L85
        if (r6 == null) goto L63;
        r6.Dj(r2);     // Catch: Throwable -> L85
    L63:
        va8.o r7 = s1a.a.g(r15).getAbility(va8.o.class);     // Catch: Throwable -> L85
        if (r7 == null) goto L66;
        r7.CE(new y0());     // Catch: Throwable -> L85
    L66:
        va8.d0 r8 = s1a.a.g(r15).getAbility(va8.d0.class);     // Catch: Throwable -> L85
        if (r8 == null) goto L69;
        r8.We(r2);     // Catch: Throwable -> L85
    L69:
        va8.o r9 = s1a.a.g(r15).getAbility(va8.o.class);     // Catch: Throwable -> L85
        if (r9 == null) goto L74;
        kotlinx.coroutines.flow.i1 r10 = r9.cv();     // Catch: Throwable -> L85
        if (r10 == null) goto L74;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r10, new DocFragment$integrateFloatChatFragment$1$1$1$1$2(r2, null)), LifecycleOwnerKt.getLifecycleScope(r15));     // Catch: Throwable -> L85
    L74:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = s1a.a.g(r15).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);     // Catch: Throwable -> L85
        if (r4 == null) goto L77;
        r4.e8(r2.x2);     // Catch: Throwable -> L85
    L77:
        va8.o r16 = s1a.a.g(r15).getAbility(va8.o.class);     // Catch: Throwable -> L85
        if (r16 == null) goto L80;
        r16.GM(r2.y2);     // Catch: Throwable -> L85
    L80:
        r2.ka0(true);     // Catch: Throwable -> L85
        com.larus.utils.t0.d(new z0(r2), 100);     // Catch: Throwable -> L85
        r2.ma0();     // Catch: Throwable -> L85
        n39.f r17 = r2.ca0();     // Catch: Throwable -> L85
        if (r17 == null) goto L83;
        r17.getIsAudioRecordDoc(new a1(r2));     // Catch: Throwable -> L85
    L83:
        r2.va0(false);     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        FLogger.a.e("DocFragment", th.getMessage(), th);
        goto L90
    L88:
        FLogger.a.i("DocFragment", "[integrateFloatChatFragment]: fragment is null");
        goto L90
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Bundle r18 = this.this$0.getArguments();
        if (r18 == null) goto L12;
        String r110 = r18.getString("key_action_bar_scene", null);
        if (r110 == null) goto L12;
    L13:
        String r11 = r110;
        Pair[] r111 = new Pair[17];
        r111[0] = TuplesKt.to("key_doc_id", this.this$0.f);
        r111[1] = TuplesKt.to("artifact_meta_id", this.this$0.j);
        r111[2] = TuplesKt.to("resource_type", Boxing.boxInt(this.this$0.m));
        r111[3] = TuplesKt.to("key_artifact_version_id", this.this$0.k);
        r111[4] = TuplesKt.to("key_doc_logic_key", this.this$0.Y90());
        r111[5] = TuplesKt.to("argConversationId", this.this$0.x);
        r111[6] = TuplesKt.to("argPreviousPage", this.this$0.x1);
        Bundle r20 = this.this$0.getArguments();
        if (r20 == null) goto L16;
        String r21 = r20.getString("drive_override_current_page");
    L17:
        r111[7] = TuplesKt.to("drive_override_current_page", r21);
        r111[8] = TuplesKt.to("custom_suffix", "-doc_detail");
        r111[9] = TuplesKt.to("key_action_bar_scene", r11);
        Bundle r3 = this.this$0.getArguments();
        if (r3 == null) goto L20;
        String r22 = r3.getString("key_message_id", null);
    L21:
        r111[10] = TuplesKt.to("key_message_id", r22);
        Bundle r23 = this.this$0.getArguments();
        if (r23 == null) goto L24;
        String r24 = r23.getString("feishu_record_id", null);
    L25:
        r111[11] = TuplesKt.to("feishu_record_id", r24);
        Bundle r25 = this.this$0.getArguments();
        if (r25 == null) goto L28;
        String r26 = r25.getString("feishu_record_generated_type", null);
    L29:
        r111[12] = TuplesKt.to("feishu_record_generated_type", r26);
        Bundle r27 = this.this$0.getArguments();
        if (r27 == null) goto L32;
        String r28 = r27.getString("record_scene", null);
    L33:
        r111[13] = TuplesKt.to("record_scene", r28);
        Bundle r30 = this.this$0.getArguments();
        if (r30 == null) goto L36;
        String r31 = r30.getString("is_general_agent", null);
    L37:
        r111[14] = TuplesKt.to("is_general_agent", r31);
        Bundle r32 = this.this$0.getArguments();
        if (r32 == null) goto L40;
        String r33 = r32.getString("chat_id", null);
    L41:
        r111[15] = TuplesKt.to("chat_id", r33);
        Bundle r34 = this.this$0.getArguments();
        if (r34 == null) goto L44;
        String r35 = r34.getString("key_source_url_for_params");
    L45:
        r111[16] = TuplesKt.to("key_source_url_for_params", r35);
        Bundle r36 = com.larus.utils.f.c(r111);
        IDocService$Companion r37 = IDocService.a;
        DocFragment r38 = this.this$0;
        boolean r40 = !Intrinsics.areEqual(r38.f, "fake_offline_doc_id");
        this.label = 1;
        r12 = r37.T9(r38, r11, r40, r36, this);
        if (r12 != r0) goto L48;
        return r0;
    L44:
        r35 = null;
        goto L45
    L40:
        r33 = null;
        goto L41
    L36:
        r31 = null;
        goto L37
    L32:
        r28 = null;
        goto L33
    L28:
        r26 = null;
        goto L29
    L24:
        r24 = null;
        goto L25
    L20:
        r22 = null;
        goto L21
    L16:
        r21 = null;
    L12:
        r110 = "doc_exist_content";
        goto L13
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_doc_impl_DocFragment$integrateFloatChatFragment$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}
