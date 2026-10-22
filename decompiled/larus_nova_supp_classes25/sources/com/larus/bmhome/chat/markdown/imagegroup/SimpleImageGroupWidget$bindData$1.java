package com.larus.bmhome.chat.markdown.imagegroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusMdSimpleImageGroupMoreBinding;
import com.larus.mainbot.impl.databinding.LarusMdSimpleImageGroupSingleBinding;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.imagegroup.SimpleImageGroupWidget$bindData$1", f = "SimpleImageGroupWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SimpleImageGroupWidget$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $data;
    int label;
    final /* synthetic */ SimpleImageGroupWidget this$0;

    public SimpleImageGroupWidget$bindData$1(d r1, SimpleImageGroupWidget r2, Continuation<? super SimpleImageGroupWidget$bindData$1> r3) {
        this.$data = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SimpleImageGroupWidget$bindData$1(this.$data, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L58;
        ResultKt.throwOnFailure(r23);
        if (this.$data.a() == null) goto L18;
        if (this.$data.a().size() != 1) goto L18;
        SimpleImageGroupWidget r7 = this.this$0;
        List<e> r12 = this.$data.a();
        int r1 = SimpleImageGroupWidget.i;
        r7.removeAllViews();
        ConstraintLayout r2 = LayoutInflater.from(r7.getContext()).inflate(2131562955, r7, false);
        r7.addView(r2);
        ConstraintLayout r3 = r2;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r2, 2131386517);
        if (r8 == null) goto L16;
        final LarusMdSimpleImageGroupSingleBinding r4 = new LarusMdSimpleImageGroupSingleBinding(r3, r8);
        Intrinsics.checkNotNull(r4);
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 == null) goto L14;
        r5.width = -1;
        r5.height = -1;
        r3.setLayoutParams(r5);
        r7.g(r4.b, new f(r4), r7.b.getWidth(), r7.b.getHeight(), r12, 0);
    L56:
        return Unit.INSTANCE;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131386517)));
    L18:
        if (this.$data.a() == null) goto L56;
        if (this.$data.a().size() <= 1) goto L56;
        SimpleImageGroupWidget r6 = this.this$0;
        List<e> r14 = this.$data.a();
        int r9 = SimpleImageGroupWidget.i;
        r6.removeAllViews();
        View r10 = LayoutInflater.from(r6.getContext()).inflate(2131562954, r6, false);
        r6.addView(r10);
        LinearLayout r11 = (LinearLayout) r10;
        int r13 = 2131380290;
        View r17 = ViewBindings.findChildViewById(r10, 2131380290);
        if (r17 == null) goto L54;
        r13 = 2131380291;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r10, 2131380291);
        if (r18 == null) goto L54;
        r13 = 2131386518;
        SimpleDraweeView r15 = ViewBindings.findChildViewById(r10, 2131386518);
        if (r15 == null) goto L54;
        r13 = 2131386519;
        SimpleDraweeView r16 = ViewBindings.findChildViewById(r10, 2131386519);
        if (r16 == null) goto L54;
        r13 = 2131386520;
        SimpleDraweeView r19 = ViewBindings.findChildViewById(r10, 2131386520);
        if (r19 == null) goto L54;
        LarusMdSimpleImageGroupMoreBinding r20 = new LarusMdSimpleImageGroupMoreBinding(r11, r17, r18, r15, r16, r19);
        Intrinsics.checkNotNull(r20);
        ViewGroup.LayoutParams r21 = r11.getLayoutParams();
        if (r21 == null) goto L52;
        r21.width = -1;
        r21.height = -1;
        r11.setLayoutParams(r21);
        final List r22 = CollectionsKt.take(CollectionsKt.listOf(new SimpleDraweeView[]{r15, r16, r19}), r14.size());
        Function0<? extends List<? extends Pair<Integer, ? extends View>>> r110 = new g(r22);
        Iterator r111 = r22.iterator();
        int r112 = 0;
    L35:
        if (r111.hasNext() == false) goto L48;
        Object r24 = r111.next();
        int r113 = r112 + 1;
        if (r112 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        SimpleDraweeView r25 = (SimpleDraweeView) r24;
        GenericDraweeHierarchy r26 = new GenericDraweeHierarchyBuilder(r6.getResources()).build();
        if (r112 != 0) goto L43;
        RoundingParams r27 = new RoundingParams();
        r27.setCornersRadii(i5.r0(), 0.0f, 0.0f, i5.r0());
        r26.setRoundingParams(r27);
    L46:
        r25.setHierarchy(r26);
        Intrinsics.checkNotNull(r25);
        e1.x(r25);
        r6.g(r25, r110, r6.b.getWidth(), r6.b.getHeight(), r14, r112);
        r112 = r113;
        goto L35
    L43:
        if (r112 != (r22.size() - 1)) goto L45;
        RoundingParams r28 = new RoundingParams();
        r28.setCornersRadii(0.0f, i5.r0(), i5.r0(), 0.0f);
        r26.setRoundingParams(r28);
        goto L46
    L45:
        RoundingParams r29 = new RoundingParams();
        r29.setCornersRadii(0.0f, 0.0f, 0.0f, 0.0f);
        r26.setRoundingParams(r29);
        goto L46
    L48:
        if (r14.size() <= 3) goto L50;
        e1.x(r20.b);
        e1.x(r20.c);
        r20.c.setText("+" + (r14.size() - 3));
        goto L56
    L50:
        e1.o(r20.b);
        e1.o(r20.c);
        goto L56
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L54:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r13)));
    L58:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
