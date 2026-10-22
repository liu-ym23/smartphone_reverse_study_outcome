package com.larus.community.impl.detail.bottomtools;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.j0;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsComponent$initObserver$1", f = "CreationDetailBottomToolsComponent.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailBottomToolsComponent$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationDetailBottomToolsComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationDetailBottomToolsComponent a;

        public a(CreationDetailBottomToolsComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v8, types: [android.view.ViewGroup, com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewV2] */
        public final Object emit(Object r24, Continuation r25) {
            CreationLikeState r1 = (CreationLikeState) r24;
            View r2 = this.a.F2();
            if (r2 == null) goto L7;
            CreationDetailBottomToolsView r3 = (CreationDetailBottomToolsView) r2.findViewById(2131364545);
            if (r3 == null) goto L7;
            r3.S5(r1);
        L7:
            View r4 = this.a.F2();
            if (r4 == null) goto L34;
            ?? r5 = (CreationDetailBottomToolsViewV2) r4.findViewById(2131364546);
            if (r5 == 0) goto L34;
            Intrinsics.checkNotNullParameter(r1, "likeState");
            Animation r6 = r5.a.d.getAnimation();
            if (r6 == null) goto L14;
            r6.cancel();
        L14:
            r5.a.d.setAnimation(null);
            TextView r7 = r5.a.j;
            if (((int) r1.getLikeCount()) != 0) goto L17;
            String r8 = r5.getContext().getString(2131901208);
        L18:
            r7.setText(r8);
            ConstraintLayout r9 = r5.a.g;
            if (((int) r1.getLikeCount()) != 0) goto L22;
            int r10 = j0.a;
            String r11 = j0.d(2131898793);
        L25:
            r9.setContentDescription(r11);
            AppCompatImageView r12 = r5.a.d;
            if (r1.getLiked() == false) goto L28;
            int r13 = 2131240151;
        L29:
            r12.setImageResource(r13);
            if (r1.getLiked() == false) goto L34;
            if (Intrinsics.areEqual(r1.getShowAnimation(), Boolean.TRUE) == false) goto L34;
            AppCompatImageView r14 = r5.a.d;
            AnimationSet r15 = new AnimationSet(false);
            ScaleAnimation r16 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            r16.setDuration(250);
            r16.setStartOffset(0);
            r16.setInterpolator(new DecelerateInterpolator());
            r16.setFillAfter(true);
            ScaleAnimation r17 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
            r17.setDuration(100);
            r17.setStartOffset(250);
            r17.setInterpolator(new DecelerateInterpolator());
            r17.setFillAfter(true);
            r15.setFillAfter(true);
            r15.addAnimation(r16);
            r15.addAnimation(r17);
            r15.setAnimationListener(new a0());
            r14.startAnimation(r15);
            goto L34
        L28:
            r13 = 2131241490;
            goto L29
        L22:
            if (r1.getLiked() == false) goto L24;
            StringCompanionObject r18 = StringCompanionObject.INSTANCE;
            int r20 = j0.a;
            r11 = String.format(j0.d(2131898795), Arrays.copyOf(new Object[]{Long.valueOf(r1.getLikeCount())}, 1));
            goto L25
        L24:
            StringCompanionObject r21 = StringCompanionObject.INSTANCE;
            int r22 = j0.a;
            r11 = String.format(j0.d(2131898794), Arrays.copyOf(new Object[]{Long.valueOf(r1.getLikeCount())}, 1));
            goto L25
        L17:
            int r23 = r5.a;
            r8 = r5.a(r5.getContext(), r1.getLikeCount());
        L34:
            UserCreation r26 = r1.getCreation();
            if (r26 == null) goto L45;
            CreationDetailBottomToolsComponent r27 = this.a;
            if (r26.a == null) goto L45;
            if (r26.e == null) goto L45;
            UserCreation r28 = r27.m3();
            if (r28 == null) goto L43;
            CreationCommunityInfo r30 = r26.k;
            r26 = UserCreation.c(r28, null, r26.e, r26.f, null, r30, null, 129999);
        L43:
            Intrinsics.checkNotNullParameter(r27, "<this>");
            t1a.b r31 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r27, r27));
            j29.c r32 = j29.c.c;
            Intrinsics.checkNotNullParameter(r26, "creation");
            r31.n(new j29.c(r26, r26.a), j29.c.class);
        L45:
            return Unit.INSTANCE;
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
        i1<CreationLikeState> r6 = this.this$0.qd();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
