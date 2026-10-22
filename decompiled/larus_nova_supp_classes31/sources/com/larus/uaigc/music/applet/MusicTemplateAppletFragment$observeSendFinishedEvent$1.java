package com.larus.uaigc.music.applet;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.applet.MusicTemplateAppletFragment$observeSendFinishedEvent$1", f = "MusicTemplateAppletFragment.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
final class MusicTemplateAppletFragment$observeSendFinishedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicTemplateAppletFragment this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.music.applet.MusicTemplateAppletFragment$observeSendFinishedEvent$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larus/uaigc/music/applet/SendFinishedEvent;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.music.applet.MusicTemplateAppletFragment$observeSendFinishedEvent$1$1", f = "MusicTemplateAppletFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<v1, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MusicTemplateAppletFragment this$0;

        public AnonymousClass1(MusicTemplateAppletFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(v1 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((v1) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L55;
            ResultKt.throwOnFailure(r8);
            v1 r9 = (v1) this.L$0;
            FLogger.a.i("MusicTemplateAppletFragment", "music applet send finished, cvsId=" + r9.a);
            MusicTemplateAppletFragment r0 = this.this$0;
            String r10 = r9.a;
            int r1 = MusicTemplateAppletFragment.m;
            Bundle r2 = r0.getArguments();
            String r3 = null;
            if (r2 == null) goto L7;
            String r4 = r2.getString("source");
        L8:
            boolean r5 = false;
            if (Intrinsics.areEqual(r4, "profile_creation_detail") == true) goto L12;
        L50:
            if (r5 == true) goto L53;
            this.this$0.U90();
        L53:
            return Unit.INSTANCE;
        L12:
            if (r10 != null) goto L14;
        L18:
            Bundle r11 = r0.getArguments();
            if (r11 == null) goto L25;
            String r12 = r11.getString("argConversationId");
            if (r12 == null) goto L25;
            if ((!StringsKt.isBlank(r12)) == false) goto L25;
            r3 = r12;
        L25:
            if (r3 == null) goto L50;
            r10 = r3;
        L28:
            FragmentActivity r6 = r0.getActivity();
            if (r6 == null) goto L50;
            String r13 = UriProtector.parse("sslocal://flow/chat").buildUpon().appendQueryParameter("conversation_id", r10).appendQueryParameter("bot_id", r0.X90()).appendQueryParameter("previous_page", r0.ca0()).build().toString();
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L41
            com.bytedance.router.i r14 = SmartRouter.buildRoute(r6, r13);     // Catch: Throwable -> L41
            Bundle r15 = r0.getArguments();     // Catch: Throwable -> L41
            if (r15 != null) goto L35;
        L37:
            if (r5 == true) goto L39;
            r0.U90();     // Catch: Throwable -> L41
        L39:
            r14.d();     // Catch: Throwable -> L41
            Object r16 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L41
        L43:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L46;
            FLogger.a.e("MusicTemplateAppletFragment", "open profile source chat after music send failed", r17);
        L46:
            Boolean r18 = Boolean.FALSE;
            if (Result.isFailure-impl(r16) == false) goto L49;
            r16 = r18;
        L49:
            r5 = ((Boolean) r16).booleanValue();
            goto L50
        L35:
            if (r15.getBoolean("keep_foreground_after_send") != true) goto L37;
            r5 = true;
        L41:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L43
        L14:
            if ((!StringsKt.isBlank(r10)) == true) goto L17;
            r10 = null;
        L17:
            if (r10 != null) goto L28;
        L7:
            r4 = null;
            goto L8
        L55:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicTemplateAppletFragment$observeSendFinishedEvent$1(MusicTemplateAppletFragment r1, Continuation<? super MusicTemplateAppletFragment$observeSendFinishedEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicTemplateAppletFragment$observeSendFinishedEvent$1(this.this$0, r3);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.a1 r7 = b0.d;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
