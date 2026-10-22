package com.larus.bmhome.chat.component.ext;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.h1;
import com.larus.bmhome.chat.immerse.ChatImmersActivity;
import com.larus.platform.service.m3;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.ext.ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1", f = "ChatFragmentDelegateImmerseExt.kt", i = {}, l = {MessageCellStateTransformerType.DEEP_SEARCH_TEXT}, m = "invokeSuspend", n = {}, s = {})
final class ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ h1 $chatImmerseDecorateWrap;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Ref.ObjectRef<Job> $delayRestartJob;
    final /* synthetic */ WeakReference<ChatFragment> $fragmentRef;
    final /* synthetic */ boolean $isImmerseStyle;
    final /* synthetic */ String $tag;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WeakReference<ChatFragment> c;
        public final /* synthetic */ Ref.ObjectRef<Job> d;
        public final /* synthetic */ CoroutineScope e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ h1 g;
        public final /* synthetic */ String h;

        public a(String r1, String r2, WeakReference<ChatFragment> r3, Ref.ObjectRef<Job> r4, CoroutineScope r5, boolean r6, h1 r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final Object emit(Object r10, Continuation r11) {
            nq9.b r4 = (nq9.b) r10;
            if (Intrinsics.areEqual(this.a, r4.a) == false) goto L115;
            FLogger r12 = FLogger.a;
            r12.d(this.b, "receive BgUpdateFlow");
            ChatFragment r13 = this.c.get();
            if (r13 == null) goto L110;
            FragmentActivity r14 = r13.getActivity();
            if (r14 == null) goto L110;
            boolean r1 = true;
            Object r2 = null;
            if ((r14 instanceof ChatActivity) == true) goto L13;
            int r0 = 0;
            if ((r14 instanceof ChatImmersActivity) == false) goto L70;
            String r15 = r4.b;
            if (r15 != null) goto L34;
        L58:
            Ref.ObjectRef<Job> r16 = this.d;
            WeakReference<ChatFragment> r17 = this.c;
            String r3 = this.b;
            String r5 = this.h;
            Job r6 = (Job) r16.element;
            if (r6 == null) goto L61;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L61:
            ChatFragment r7 = r17.get();
            if (r7 == null) goto L68;
            LifecycleOwner r8 = r7.getViewLifecycleOwner();
            if (r8 == null) goto L68;
            LifecycleCoroutineScope r9 = LifecycleOwnerKt.getLifecycleScope(r8);
            if (r9 == null) goto L68;
            r2 = r9.launchWhenStarted(new ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$5$1(r3, r17, r5, r4, null));
        L68:
            r16.element = r2;
        L118:
            return Unit.INSTANCE;
        L34:
            if ((!StringsKt.isBlank(r15)) == true) goto L37;
            r15 = null;
        L37:
            if (r15 == null) goto L58;
            if (o0.d(r4.c) == true) goto L42;
            r15 = null;
        L42:
            if (r15 == null) goto L58;
            String r18 = this.b;
            h1 r19 = this.g;
            r12.i(r18, "ChatImmerseActivity updateBgImg");
            if (r19 != null) goto L113;
            Unit r110 = null;
        L57:
            if (r110 != null) goto L118;
        L113:
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L47
            Object r112 = Result.constructor-impl(Boxing.boxInt(Color.parseColor(r4.c)));     // Catch: Throwable -> L47
        L50:
            if (Result.isFailure-impl(r112) == false) goto L52;
            r112 = null;
        L52:
            Integer r113 = (Integer) r112;
            if (r113 == null) goto L55;
            r0 = r113.intValue();
        L55:
            r19.f(r15, r0);
            r110 = Unit.INSTANCE;
        L47:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r112 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L50
        L70:
            if (o0.d(r4.b) == false) goto L104;
            if (o0.d(r4.c) == false) goto L104;
            if (this.f == false) goto L96;
            r12.i(this.b, "updateBgImg");
            h1 r114 = this.g;
            if (r114 == null) goto L118;
            String r115 = r4.b;
            String r21 = "";
            if (r115 != null) goto L111;
            r115 = "";
        L111:
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L86
            String r23 = r4.c;     // Catch: Throwable -> L86
            if (r23 == null) goto L84;
            r21 = r23;
        L84:
            Object r24 = Result.constructor-impl(Boxing.boxInt(Color.parseColor(r21)));     // Catch: Throwable -> L86
        L89:
            if (Result.isFailure-impl(r24) == true) goto L92;
            r2 = r24;
        L92:
            Integer r25 = (Integer) r2;
            if (r25 == null) goto L95;
            r0 = r25.intValue();
        L95:
            r114.f(r115, r0);
        L86:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r24 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L89
        L96:
            r12.i(this.b, "switch immerse mode, restart fragment");
            ChatFragment r116 = this.c.get();
            if (r116 == null) goto L118;
            String r117 = this.h;
            Function1<? super Bundle, Unit> r118 = r116.p;
            Pair[] r27 = new Pair[5];
            r27[0] = TuplesKt.to("argConversationId", r117);
            r27[1] = TuplesKt.to("argBotId", r4.a);
            r27[2] = TuplesKt.to("argCvsBgImgUrl", r4.b);
            r27[3] = TuplesKt.to("argCvsBgImgColor", r4.c);
            if (r4.b != null) goto L102;
            r1 = false;
        L102:
            r27[4] = TuplesKt.to("argCvsBgImgOpen", Boxing.boxBoolean(r1));
            r118.invoke(f.c(r27));
        L104:
            if (this.f == false) goto L118;
            r12.i(this.b, "switch immerse mode, restart fragment");
            ChatFragment r119 = this.c.get();
            if (r119 == null) goto L118;
            r119.p.invoke(f.c(new Pair[]{TuplesKt.to("argConversationId", this.h), TuplesKt.to("argBotId", r4.a)}));
            goto L118
        L13:
            if (r4.b != null) goto L16;
            return Unit.INSTANCE;
        L16:
            if (r4.c == null) goto L117;
            Job r120 = (Job) this.d.element;
            if (r120 == null) goto L21;
            Job.DefaultImpls.cancel$default(r120, null, 1, null);
        L21:
            Ref.ObjectRef<Job> r121 = this.d;
            ChatFragment r122 = this.c.get();
            if (r122 == null) goto L28;
            LifecycleOwner r123 = r122.getViewLifecycleOwner();
            if (r123 == null) goto L28;
            LifecycleCoroutineScope r124 = LifecycleOwnerKt.getLifecycleScope(r123);
            if (r124 == null) goto L28;
            r2 = r124.launchWhenStarted(new ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1(this.b, this.c, this.h, r4, null));
        L28:
            r121.element = r2;
            goto L118
        L117:
            return Unit.INSTANCE;
        L110:
            return Unit.INSTANCE;
        L115:
            return Unit.INSTANCE;
        }
    }

    public ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1(String r1, String r2, WeakReference<ChatFragment> r3, Ref.ObjectRef<Job> r4, boolean r5, h1 r6, String r7, Continuation<? super ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1> r8) {
        this.$botId = r1;
        this.$tag = r2;
        this.$fragmentRef = r3;
        this.$delayRestartJob = r4;
        this.$isImmerseStyle = r5;
        this.$chatImmerseDecorateWrap = r6;
        this.$conversationId = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1 r9 = new ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1(this.$botId, this.$tag, this.$fragmentRef, this.$delayRestartJob, this.$isImmerseStyle, this.$chatImmerseDecorateWrap, this.$conversationId, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r13);
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        d1 r14 = m3.a.c();
        if (r14 == null) goto L16;
        a r2 = new a(this.$botId, this.$tag, this.$fragmentRef, this.$delayRestartJob, r8, this.$isImmerseStyle, this.$chatImmerseDecorateWrap, this.$conversationId);
        this.label = 1;
        if (r14.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
