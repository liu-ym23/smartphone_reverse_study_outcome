package com.larus.bmhome.chat.markdown.ugc;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdUgcRecycleviewBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.ugc.MarkdownUgcWidget$bindData$2", f = "MarkdownUgcWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownUgcWidget$bindData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fh8.f $markdownCommonInputData;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ MarkdownUgcWidget this$0;

    public MarkdownUgcWidget$bindData$2(MarkdownUgcWidget r1, fh8.f r2, TextView r3, Continuation<? super MarkdownUgcWidget$bindData$2> r4) {
        this.this$0 = r1;
        this.$markdownCommonInputData = r2;
        this.$textView = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownUgcWidget$bindData$2(this.this$0, this.$markdownCommonInputData, this.$textView, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L78;
        ResultKt.throwOnFailure(r8);
        if (this.this$0.getContext() == null) goto L7;
        this.this$0.getClass();
        final MarkdownUgcWidget r9 = this.this$0;
        fh8.f r0 = this.$markdownCommonInputData;
        String r1 = null;
        if (r0 == null) goto L11;
        Message r2 = r0.b;
    L12:
        r9.f = r2;
        if (r0 == null) goto L15;
        LruSet<String> r3 = r0.g;
    L16:
        r9.k = r3;
        if (r0 == null) goto L19;
        String r4 = r0.c;
    L20:
        r9.g = r4;
        if (r0 == null) goto L23;
        String r5 = r0.e;
    L24:
        r9.i = r5;
        if (r0 == null) goto L27;
        String r6 = r0.f;
    L28:
        r9.j = r6;
        if (r0 == null) goto L31;
        String r7 = r0.d;
    L32:
        r9.h = r7;
        View r10 = LayoutInflater.from(r9.getContext()).inflate(2131562957, r9, false);
        r9.addView(r10);
        LinearLayout r11 = (LinearLayout) r10;
        int r12 = 2131379733;
        RecyclerView r13 = ViewBindings.findChildViewById(r10, 2131379733);
        if (r13 == null) goto L76;
        r12 = 2131391830;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r10, 2131391830);
        if (r14 == null) goto L76;
        r9.r = new LarusMdUgcRecycleviewBinding(r11, r13, r14);
        r13.setLayoutManager(new LinearLayoutManager(r13.getContext(), 0, false));
        ip8.g r15 = r9.o;
        if ((r15 instanceof ip8.g) == false) goto L39;
        ip8.g r16 = r15;
    L40:
        if (r16 == null) goto L42;
        r16.W1(new h(r13, r9));
    L42:
        r13.addItemDecoration(new MarkdownUgcWidget$initView$1$1$2(r9));
        r13.setAdapter(r9.o);
        Intrinsics.checkNotNull(r13);
        ExposureTrackerExtKt.b(r13);
        r9.removeAllViews();
        r9.addView(r11, new FrameLayout.LayoutParams(-1, -1));
        MarkdownUgcWidget r17 = this.this$0;
        List<Content> r18 = r17.p;
        if (r18 == null) goto L54;
        Iterator<T> r19 = r18.iterator();
    L46:
        if (r19.hasNext() == false) goto L48;
        ((Content) r19.next()).setRatioStrategy(CardRatioStrategy.FixRatio);
        goto L46
    L48:
        ip8.g r20 = r17.o;
        if ((r20 instanceof ip8.g) == false) goto L51;
        ip8.g r21 = r20;
    L52:
        if (r21 == null) goto L54;
        r21.N0(r18);
        goto L54
    L51:
        r21 = null;
    L54:
        MarkdownUgcExtraData r22 = this.this$0.q;
        if (r22 == null) goto L57;
        String r23 = r22.getRecommendTitle();
    L59:
        if (o0.d(r23) == false) goto L68;
        MarkdownUgcWidget r24 = this.this$0;
        LarusMdUgcRecycleviewBinding r25 = r24.r;
        if (r25 == null) goto L74;
        TextView r26 = r25.c;
        if (r26 == null) goto L74;
        TextView r27 = this.$textView;
        e1.x(r26);
        MarkdownUgcExtraData r28 = r24.q;
        if (r28 == null) goto L67;
        r1 = r28.getRecommendTitle();
    L67:
        r26.setText(r1);
        r26.setPaddingRelative(r27.getPaddingStart(), r26.getPaddingTop(), r26.getPaddingEnd(), r26.getPaddingBottom());
    L74:
        return Unit.INSTANCE;
    L68:
        LarusMdUgcRecycleviewBinding r29 = this.this$0.r;
        if (r29 == null) goto L74;
        TextView r30 = r29.c;
        if (r30 == null) goto L74;
        e1.o(r30);
        goto L74
    L57:
        r23 = null;
        goto L59
    L39:
        r16 = null;
    L76:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    L31:
        r7 = null;
        goto L32
    L27:
        r6 = null;
        goto L28
    L23:
        r5 = null;
        goto L24
    L19:
        r4 = null;
        goto L20
    L15:
        r3 = null;
        goto L16
    L11:
        r2 = null;
        goto L12
    L7:
        return Unit.INSTANCE;
    L78:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
