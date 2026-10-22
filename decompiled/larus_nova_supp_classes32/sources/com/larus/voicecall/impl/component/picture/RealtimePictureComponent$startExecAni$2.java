package com.larus.voicecall.impl.component.picture;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.camera.api.params.OutputParam;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.utils.e1;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent$startExecAni$2", f = "RealtimePictureComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimePictureComponent$startExecAni$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x3a.a $imageWrapper;
    final /* synthetic */ OutputParam $outputParam;
    int label;
    final /* synthetic */ RealtimePictureComponent this$0;

    public RealtimePictureComponent$startExecAni$2(RealtimePictureComponent r1, x3a.a r2, OutputParam r3, Continuation<? super RealtimePictureComponent$startExecAni$2> r4) {
        this.this$0 = r1;
        this.$imageWrapper = r2;
        this.$outputParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimePictureComponent$startExecAni$2(this.this$0, this.$imageWrapper, this.$outputParam, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L134;
        ResultKt.throwOnFailure(r27);
        RealtimePictureComponent r1 = this.this$0;
        int r2 = RealtimePictureComponent.B;
        g3a.a r3 = r1.p3();
        if (r3 == null) goto L9;
        View r4 = r3.Tt();
        if (r4 == null) goto L9;
        e1.o(r4);
    L9:
        RealtimeCallUtil.a.getClass();
        LinearLayoutManager r8 = null;
        if (RealtimeCallUtil.z == false) goto L104;
        RealtimePictureComponent r5 = this.this$0;
        x3a.a r9 = this.$imageWrapper;
        this.$outputParam.getImageParam().getBitmap();
        g3a.a r10 = r5.p3();
        if (r10 == null) goto L16;
        RealtimeCallSubtitleLayout r11 = r10.ol();
        if (r11 == null) goto L16;
        RecyclerView r12 = r11.getRecycler();
    L17:
        if (r12 == null) goto L19;
        RecyclerView.LayoutManager r13 = r12.getLayoutManager();
    L21:
        if ((r13 instanceof LinearLayoutManager) == false) goto L23;
        r8 = (LinearLayoutManager) r13;
    L23:
        if (r8 == null) goto L97;
        com.larus.voicecall.impl.component.subtitle.a r14 = r5.C3();
        if (r14 == null) goto L29;
        Integer r15 = r14.wi(new e(r9));
        if (r15 == null) goto L29;
        int r16 = r15.intValue();
    L30:
        int r17 = r16 + 1;
        if (1 > r17) goto L38;
        RecyclerView.Adapter r18 = r12.getAdapter();
        if (r18 == null) goto L35;
        int r19 = r18.getItemCount();
    L36:
        if (r17 >= r19) goto L38;
        boolean r110 = true;
    L39:
        if (r110 == true) goto L41;
        r5.E3("bad holder pos 。pos=" + r17, r9);
    L96:
        boolean r6 = true;
    L98:
        if (r6 == true) goto L132;
        g3a.a r7 = this.this$0.p3();
        if (r7 == null) goto L132;
        SimpleDraweeView r20 = r7.kj();
        if (r20 == null) goto L132;
        e1.o(r20);
    L132:
        return Unit.INSTANCE;
    L41:
        int[] r111 = r5.D3();
        if (r111 != null) goto L44;
        r5.E3("do not get takePhotoAniViewCenterPos, it=" + r5.D3(), r9);
        goto L96
    L44:
        View r21 = r8.findViewByPosition(r17);
        if (r21 != null) goto L47;
        r5.E3("dot not find target holder view. pos=" + r17, r9);
        goto L96
    L47:
        g3a.a r112 = r5.p3();
        if (r112 == null) goto L97;
        SimpleDraweeView r113 = r112.kj();
        if (r113 == null) goto L97;
        int[] r22 = new int[2];
        SimpleDraweeView r114 = r21.findViewById(2131376464);
        if (r114 != null) goto L54;
        r5.E3("do not find iv_photo in holder ", r9);
        goto L96
    L54:
        r21.getLocationOnScreen(r22);
        Pair<Integer, Integer> r115 = r9.h;
        if (r115 == null) goto L57;
        int r116 = ((Number) r115.getFirst()).intValue();
    L58:
        Pair<Integer, Integer> r117 = r9.h;
        if (r117 == null) goto L61;
        int r118 = ((Number) r117.getSecond()).intValue();
    L62:
        Intrinsics.checkNotNullParameter(r113, "draweeView");
        Drawable r119 = r113.getDrawable();
        if (r119 != null) goto L65;
        Pair r120 = new Pair(0, 0);
    L91:
        float r23 = r116;
        float r24 = r118;
        ScaleAnimation r25 = new ScaleAnimation(1.0f, (r23 * 1.0f) / ((Number) r120.getFirst()).floatValue(), 1.0f, (1.0f * r24) / ((Number) r120.getSecond()).floatValue(), 1, 0.5f, 1, 0.5f);
        r25.setInterpolator(new AccelerateInterpolator());
        r25.setAnimationListener(new v(r113, r5, r9));
        r25.setDuration(300);
        TranslateAnimation r26 = new TranslateAnimation(0.0f, -(r111[0] - (r21.getPaddingLeft() + (r23 / 2.0f))), 0.0f, -(r111[1] - ((r22[1] + (r24 / 2.0f)) + r21.getPaddingTop())));
        r26.setDuration(300);
        AnimationSet r28 = new AnimationSet(true);
        r28.addAnimation(r25);
        r28.addAnimation(r26);
        g3a.a r29 = r5.p3();
        if (r29 == null) goto L96;
        SimpleDraweeView r30 = r29.kj();
        if (r30 == null) goto L96;
        r30.startAnimation(r28);
        goto L96
    L65:
        float r31 = r113.getWidth();
        float r32 = r113.getHeight();
        float r33 = r119.getIntrinsicWidth();
        float r121 = r119.getIntrinsicHeight();
        ScalingUtils.ScaleType r34 = r113.getHierarchy().getActualImageScaleType();
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.CENTER) == false) goto L69;
    L87:
        float r35 = 1.0f;
        float r36 = 1.0f;
    L90:
        r120 = new Pair(Integer.valueOf((int) (r33 * r35)), Integer.valueOf((int) (r121 * r36)));
        goto L91
    L69:
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.CENTER_CROP) == false) goto L72;
        r35 = Math.max(r31 / r33, r32 / r121);
    L89:
        r36 = r35;
        goto L90
    L72:
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.CENTER_INSIDE) == false) goto L75;
        r35 = Math.min(r31 / r33, r32 / r121);
        goto L89
    L75:
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.FIT_CENTER) == false) goto L77;
    L88:
        r35 = Math.min(r31 / r33, r32 / r121);
        goto L89
    L77:
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.FIT_START) == true) goto L88;
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.FIT_END) == true) goto L88;
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.FIT_XY) == false) goto L85;
        r35 = r31 / r33;
        r36 = r32 / r121;
        goto L90
    L85:
        if (Intrinsics.areEqual(r34, ScalingUtils.ScaleType.FOCUS_CROP) == false) goto L87;
        r35 = Math.max(r31 / r33, r32 / r121);
        goto L89
    L61:
        r118 = r114.getHeight();
        goto L62
    L57:
        r116 = r114.getWidth();
        goto L58
    L35:
        r19 = 0;
    L38:
        r110 = false;
    L29:
        r16 = -1;
    L97:
        r6 = false;
        goto L98
    L19:
        r13 = null;
    L16:
        r12 = null;
        goto L17
    L104:
        RealtimePictureComponent r37 = this.this$0;
        x3a.a r38 = this.$imageWrapper;
        this.$outputParam.getImageParam().getBitmap();
        r37.G3(r38);
        g3a.a r39 = r37.p3();
        if (r39 == null) goto L107;
        SimpleDraweeView r40 = r39.kj();
    L109:
        if (r37.y != null) goto L118;
        int[] r41 = new int[2];
        g3a.a r42 = r37.p3();
        if (r42 == null) goto L115;
        VoiceCallContentLayout r43 = r42.dg();
        if (r43 == null) goto L115;
        r8 = r43.getRealtimeCallAvatar();
    L115:
        if (r8 == null) goto L117;
        r8.getLocationOnScreen(r41);
    L117:
        r37.y = r41;
    L118:
        int[] r44 = r37.y;
        if (r44 == null) goto L132;
        g3a.a r45 = r37.p3();
        if (r45 == null) goto L132;
        VoiceCallContentLayout r46 = r45.dg();
        if (r46 == null) goto L132;
        CircleSimpleDraweeView r47 = r46.getRealtimeCallAvatar();
        if (r47 == null) goto L132;
        ScaleAnimation r48 = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, r44[0] + (r47.getWidth() / 2.0f), r44[1] + (r47.getHeight() / 2.0f));
        r48.setInterpolator(new AccelerateInterpolator());
        r48.setAnimationListener(new u(r40));
        r48.setDuration(300);
        g3a.a r49 = r37.p3();
        if (r49 == null) goto L132;
        SimpleDraweeView r50 = r49.kj();
        if (r50 == null) goto L132;
        r50.startAnimation(r48);
        goto L132
    L107:
        r40 = null;
        goto L109
    L134:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
