package com.larus.ugc.feed.impl.detail.bottomtools;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.j0;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.detail.bottomtools.CreationDetailBottomToolsComponent$initObserver$1", f = "CreationDetailBottomToolsComponent.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailBottomToolsComponent$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationDetailBottomToolsComponent this$0;

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.detail.bottomtools.CreationDetailBottomToolsComponent$initObserver$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/ugc/feed/api/detail/state/CreationDetailBottomToolsUiState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.detail.bottomtools.CreationDetailBottomToolsComponent$initObserver$1$1", f = "CreationDetailBottomToolsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0a.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationDetailBottomToolsComponent this$0;

        public AnonymousClass1(CreationDetailBottomToolsComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((k0a.a) r1, (Continuation) r2);
        }

        public final Object invoke(k0a.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [android.view.ViewGroup, com.larus.ugc.feed.impl.detail.bottomtools.CreationDetailBottomToolsView] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.view.ViewGroup, com.larus.ugc.feed.impl.detail.bottomtools.CreationDetailBottomToolsViewV2] */
        public final Object invokeSuspend(Object r33) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L57;
            ResultKt.throwOnFailure(r33);
            k0a.a r1 = (k0a.a) this.L$0;
            CreationDetailBottomToolsComponent r2 = this.this$0;
            int r3 = CreationDetailBottomToolsComponent.q;
            View r4 = r2.F2();
            if (r4 == null) goto L7;
            ?? r5 = (CreationDetailBottomToolsView) r4.findViewById(2131364545);
        L9:
            if (r5 == 0) goto L26;
            Intrinsics.checkNotNullParameter(r1, "state");
            Animation r6 = r5.a.d.getAnimation();
            if (r6 == null) goto L13;
            r6.cancel();
        L13:
            r5.a.d.setAnimation(null);
            TextView r7 = r5.a.f;
            if (((int) r1.c) != 0) goto L16;
            String r8 = r5.getContext().getString(2131901208);
        L17:
            r7.setText(r8);
            AppCompatImageView r9 = r5.a.d;
            if (r1.b == false) goto L20;
            int r10 = 2131241494;
        L21:
            r9.setImageResource(r10);
            if (r1.b == false) goto L26;
            if (r1.f == false) goto L26;
            AppCompatImageView r11 = r5.a.d;
            AnimationSet r12 = new AnimationSet(false);
            ScaleAnimation r13 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            r13.setDuration(250);
            r13.setStartOffset(0);
            r13.setInterpolator(new DecelerateInterpolator());
            r13.setFillAfter(true);
            ScaleAnimation r14 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
            r14.setDuration(100);
            r14.setStartOffset(250);
            r14.setInterpolator(new DecelerateInterpolator());
            r14.setFillAfter(true);
            r12.setFillAfter(true);
            r12.addAnimation(r13);
            r12.addAnimation(r14);
            r12.setAnimationListener(new j());
            r11.startAnimation(r12);
            goto L26
        L20:
            r10 = 2131241490;
            goto L21
        L16:
            int r15 = r5.a;
            r8 = r5.a(r5.getContext(), r1.c);
        L26:
            View r16 = this.this$0.F2();
            if (r16 == null) goto L29;
            ?? r17 = (CreationDetailBottomToolsViewV2) r16.findViewById(2131364546);
        L30:
            if (r17 == 0) goto L55;
            Intrinsics.checkNotNullParameter(r1, "state");
            Animation r18 = r17.a.d.getAnimation();
            if (r18 == null) goto L34;
            r18.cancel();
        L34:
            r17.a.d.setAnimation(null);
            TextView r19 = r17.a.g;
            if (((int) r1.c) != 0) goto L37;
            String r20 = r17.getContext().getString(2131901208);
        L38:
            r19.setText(r20);
            ConstraintLayout r21 = r17.a.f;
            if (((int) r1.c) != 0) goto L42;
            int r22 = j0.a;
            String r23 = j0.d(2131898793);
        L45:
            r21.setContentDescription(r23);
            AppCompatImageView r24 = r17.a.d;
            if (r1.b == false) goto L48;
            int r25 = 2131241494;
        L49:
            r24.setImageResource(r25);
            if (r1.b == false) goto L55;
            if (r1.f == false) goto L55;
            AppCompatImageView r26 = r17.a.d;
            AnimationSet r27 = new AnimationSet(false);
            ScaleAnimation r28 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            r28.setDuration(250);
            r28.setStartOffset(0);
            r28.setInterpolator(new DecelerateInterpolator());
            r28.setFillAfter(true);
            ScaleAnimation r29 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
            r29.setDuration(100);
            r29.setStartOffset(250);
            r29.setInterpolator(new DecelerateInterpolator());
            r29.setFillAfter(true);
            r27.setFillAfter(true);
            r27.addAnimation(r28);
            r27.addAnimation(r29);
            r27.setAnimationListener(new n());
            r26.startAnimation(r27);
            goto L55
        L48:
            r25 = 2131241490;
            goto L49
        L42:
            if (r1.b == false) goto L44;
            StringCompanionObject r30 = StringCompanionObject.INSTANCE;
            int r31 = j0.a;
            r23 = String.format(j0.d(2131898795), Arrays.copyOf(new Object[]{Long.valueOf(r1.c)}, 1));
            goto L45
        L44:
            StringCompanionObject r32 = StringCompanionObject.INSTANCE;
            int r34 = j0.a;
            r23 = String.format(j0.d(2131898794), Arrays.copyOf(new Object[]{Long.valueOf(r1.c)}, 1));
            goto L45
        L37:
            int r35 = r5.a;
            r20 = r5.a(r17.getContext(), r1.c);
        L55:
            return Unit.INSTANCE;
        L29:
            r17 = 0;
            goto L30
        L7:
            r5 = 0;
            goto L9
        L57:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationDetailBottomToolsComponent$initObserver$1(CreationDetailBottomToolsComponent r1, Continuation<? super CreationDetailBottomToolsComponent$initObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDetailBottomToolsComponent$initObserver$1(this.this$0, r3);
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
        CreationDetailBottomToolsComponent r7 = this.this$0;
        int r2 = CreationDetailBottomToolsComponent.q;
        StateFlowImpl r8 = r7.Y2().b.a;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
