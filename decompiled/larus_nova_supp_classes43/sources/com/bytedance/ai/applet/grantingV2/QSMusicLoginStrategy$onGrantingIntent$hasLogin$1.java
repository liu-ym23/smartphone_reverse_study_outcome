package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.QSMusicLoginStrategy$onGrantingIntent$hasLogin$1", f = "QSMusicLoginStrategy.kt", i = {}, l = {63, 65}, m = "invokeSuspend", n = {}, s = {})
public final class QSMusicLoginStrategy$onGrantingIntent$hasLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ f $context;
    final /* synthetic */ u2.c $meta;
    int label;
    final /* synthetic */ QSMusicLoginStrategy this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.grantingV2.QSMusicLoginStrategy$onGrantingIntent$hasLogin$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.QSMusicLoginStrategy$onGrantingIntent$hasLogin$1$1", f = "QSMusicLoginStrategy.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ u2.c $meta;
        int label;
        final /* synthetic */ QSMusicLoginStrategy this$0;

        public AnonymousClass1(QSMusicLoginStrategy r1, u2.c r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r1;
            this.$meta = r10;
            super(1, r11);
        }

        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, this.$meta, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Boolean> r10) {
            return create(r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            QSMusicLoginStrategy r11 = this.this$0;
            String r12 = this.$meta.a;
            this.label = 1;
            r10 = QSMusicLoginStrategy.j(r11, r12, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public QSMusicLoginStrategy$onGrantingIntent$hasLogin$1(f r1, QSMusicLoginStrategy r10, u2.c r11, Continuation<? super QSMusicLoginStrategy$onGrantingIntent$hasLogin$1> r12) {
        this.$context = r1;
        this.this$0 = r10;
        this.$meta = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new QSMusicLoginStrategy$onGrantingIntent$hasLogin$1(this.$context, this.this$0, this.$meta, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L19:
        boolean r11 = ((Boolean) r10).booleanValue();
    L21:
        return Boxing.boxBoolean(r11);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L15:
        r11 = ((Boolean) r10).booleanValue();
        goto L21
    L10:
        ResultKt.throwOnFailure(r10);
        AppletAuthTaskMonitor.Session r12 = this.$context.i;
        if (r12 == null) goto L16;
        AnonymousClass1 r13 = new AnonymousClass1(this.this$0, this.$meta, null);
        this.label = 1;
        r10 = r12.f(r13, this);
        if (r10 != r0) goto L15;
        return r0;
    L16:
        QSMusicLoginStrategy r14 = this.this$0;
        String r15 = this.$meta.a;
        this.label = 2;
        r10 = QSMusicLoginStrategy.j(r14, r15, this);
        if (r10 != r0) goto L19;
        return r0;
    }
}
