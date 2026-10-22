package com.larus.community.impl.share;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder$bind$1", f = "SharePuzzleImageItemViewHolder.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {121, 124, 132}, m = "invokeSuspend", n = {"$this$launch", "refBitmapDeferred", "$this$launch", "rawBitmap", "$this$launch", "rawBitmap", "refBitmap"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
final class SharePuzzleImageItemViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $closeableHolder;
    final /* synthetic */ q $shareImagePuzzleItem;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SharePuzzleImageItemViewHolder this$0;

    public SharePuzzleImageItemViewHolder$bind$1(q r1, SharePuzzleImageItemViewHolder r2, m r3, Continuation<? super SharePuzzleImageItemViewHolder$bind$1> r4) {
        this.$shareImagePuzzleItem = r1;
        this.this$0 = r2;
        this.$closeableHolder = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SharePuzzleImageItemViewHolder$bind$1 r0 = new SharePuzzleImageItemViewHolder$bind$1(this.$shareImagePuzzleItem, this.this$0, this.$closeableHolder, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r8 = true;
        Bitmap r9 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        Bitmap r1 = (Bitmap) this.L$2;
        Bitmap r3 = (Bitmap) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r21);
        Bitmap r5 = r3;
        CoroutineScope r7 = r4;
        Object r6 = r21;
        Bitmap r10 = r1;
    L67:
        Bitmap r11 = (Bitmap) r6;
        CoroutineScopeKt.ensureActive(r7);     // Catch: CancellationException -> L105
        SharePuzzleImageItemViewHolder r12 = this.this$0;
        if (r12.d != this.$closeableHolder) goto L72;
        boolean r13 = true;
    L73:
        if (r13 == true) goto L87;
        if (r11 == null) goto L84;
        r12.getClass();
        if (r11 == r5) goto L79;
        if (r11 == r10) goto L79;
        boolean r14 = true;
    L80:
        if (r14 == false) goto L86;
        if (r11.isRecycled() == true) goto L86;
        r11.recycle();
    L86:
        return Unit.INSTANCE;
    L79:
        r14 = false;
        goto L80
    L84:
        r12.getClass();
        goto L86
    L87:
        if (r11 == null) goto L95;
        r12.getClass();
        if (r11 == r5) goto L92;
        if (r11 == r10) goto L92;
        boolean r15 = true;
    L93:
        if (r15 == false) goto L95;
        r9 = r11;
    L92:
        r15 = false;
    L95:
        r12.e = r9;
        if (r11 == null) goto L99;
        this.this$0.b.setImageBitmap(r11);
    L99:
        if (this.this$0.e != null) goto L128;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("currentResultBitmap is null? ");
        if (this.this$0.e != null) goto L103;
        boolean r18 = true;
    L104:
        r17.append(r18);
        r16.i("SharePuzzleImageItemViewHolder", r17.toString());
        goto L128
    L103:
        r18 = false;
    L128:
        e1.o(this.this$0.g);
        this.this$0.c.setShadowColor(ColorProtector.parseColor("#1A000000"));
        return Unit.INSTANCE;
    L72:
        r13 = false;
    L105:
        e = move-exception;
        SharePuzzleImageItemViewHolder r20 = this.this$0;
        int r22 = SharePuzzleImageItemViewHolder.j;
        if (r11 == null) goto L117;
        r20.getClass();
        if (r11 == r5) goto L112;
        if (r11 == r10) goto L112;
        boolean r23 = true;
    L113:
        if (r23 == true) goto L115;
        throw e;
    L115:
        if (r11.isRecycled() == true) goto L133;
        r11.recycle();
        throw e;
    L133:
        throw e;
    L112:
        r23 = false;
        goto L113
    L117:
        r20.getClass();
        throw e;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Bitmap r24 = (Bitmap) this.L$1;
        r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r21);
        r5 = r24;
        Object r25 = r21;
    L47:
        r10 = (Bitmap) r25;
        CoroutineScopeKt.ensureActive(r7);
        FLogger r110 = FLogger.a;
        StringBuilder r111 = new StringBuilder("refBitmap  width: ");
        if (r10 == null) goto L50;
        Integer r112 = Boxing.boxInt(r10.getWidth());
    L51:
        r111.append(r112);
        r111.append(" height: ");
        if (r10 == null) goto L54;
        Integer r26 = Boxing.boxInt(r10.getHeight());
    L55:
        r111.append(r26);
        r110.i("SharePuzzleImageItemViewHolder", r111.toString());
        SharePuzzleImageItemViewHolder r27 = this.this$0;
        if (r27.d != this.$closeableHolder) goto L58;
        boolean r28 = true;
    L59:
        if (r28 == false) goto L61;
        if (r5 == null) goto L119;
        if (r10 == null) goto L119;
        CoroutineDispatcher r30 = Dispatchers.getIO();
        SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1 r113 = new SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1(r5, r10, null);
        this.L$0 = r7;
        this.L$1 = r5;
        this.L$2 = r10;
        this.label = 3;
        r6 = BuildersKt.withContext(r30, r113, this);
        if (r6 != r0) goto L67;
        return r0;
    L119:
        StringBuilder r31 = new StringBuilder("rawBitmap is null? ");
        if (r5 != null) goto L122;
        boolean r32 = true;
    L123:
        r31.append(r32);
        r31.append(" refBitmap is null? ");
        if (r10 == null) goto L127;
        r8 = false;
    L127:
        r31.append(r8);
        r110.i("SharePuzzleImageItemViewHolder", r31.toString());
        t19.s r33 = t19.s.a;
        Context r34 = ((RecyclerView.ViewHolder) this.this$0).itemView.getContext();
        r33.getClass();
        t19.s.b(r34, 2131906049, false);
        goto L128
    L122:
        r32 = false;
        goto L123
    L61:
        return Unit.INSTANCE;
    L58:
        r28 = false;
        goto L59
    L54:
        r26 = null;
        goto L55
    L50:
        r112 = null;
        goto L51
    L11:
        Deferred r35 = (Deferred) this.L$1;
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r36 = r21;
    L35:
        r5 = (Bitmap) r36;
        CoroutineScopeKt.ensureActive(r114);
        FLogger r115 = FLogger.a;
        StringBuilder r116 = new StringBuilder("rawBitmap  width: ");
        if (r5 == null) goto L38;
        Integer r117 = Boxing.boxInt(r5.getWidth());
    L39:
        r116.append(r117);
        r116.append(" height: ");
        if (r5 == null) goto L42;
        Integer r118 = Boxing.boxInt(r5.getHeight());
    L43:
        r116.append(r118);
        r115.i("SharePuzzleImageItemViewHolder", r116.toString());
        this.L$0 = r114;
        this.L$1 = r5;
        this.label = 2;
        r25 = r35.await(this);
        if (r25 != r0) goto L46;
        return r0;
    L46:
        r7 = r114;
        goto L47
    L42:
        r118 = null;
        goto L43
    L38:
        r117 = null;
        goto L39
    L12:
        ResultKt.throwOnFailure(r21);
        CoroutineScope r37 = (CoroutineScope) this.L$0;
        Long r119 = this.$shareImagePuzzleItem.c;
        long r120 = -1;
        if (r119 == null) goto L15;
        long r121 = r119.longValue();
    L16:
        int r122 = (int) r121;
        Long r123 = this.$shareImagePuzzleItem.d;
        if (r123 == null) goto L19;
        r120 = r123.longValue();
    L19:
        int r124 = (int) r120;
        if (r122 <= 0) goto L31;
        if (r124 <= 0) goto L31;
        SharePuzzleImageItemViewHolder r125 = this.this$0;
        float r126 = r125.h / r125.i;
        if (r122 < r124) goto L25;
        float r127 = r122 / (r124 * 2);
    L26:
        ViewGroup.LayoutParams r128 = r125.b.getLayoutParams();
        if (r126 >= r127) goto L29;
        int r129 = this.this$0.h;
        r128.width = r129;
        r128.height = MathKt.roundToInt(r129 / r127);
    L30:
        this.this$0.b.setLayoutParams(r128);
        ViewGroup.LayoutParams r130 = this.this$0.c.getLayoutParams();
        r130.width = r128.width + i5.l0();
        r130.height = r128.height + i5.l0();
        this.this$0.c.setLayoutParams(r130);
        this.this$0.b.setImageResource(2131102535);
        goto L31
    L29:
        r128.width = MathKt.roundToInt(this.this$0.i * r127);
        r128.height = this.this$0.i;
        goto L30
    L25:
        r127 = (2 * r122) / r124;
    L31:
        e1.x(this.this$0.g);
        SharePuzzleImageItemViewHolder r131 = this.this$0;
        r131.c.setShadowColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r131).itemView.getContext(), R.color.transparent));
        Deferred r132 = BuildersKt.async$default(r37, null, null, new SharePuzzleImageItemViewHolder$bind$1$rawBitmapDeferred$1(this.this$0, this.$shareImagePuzzleItem, this.$closeableHolder, null), 3, null);
        Deferred r133 = BuildersKt.async$default(r37, null, null, new SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1(this.this$0, this.$shareImagePuzzleItem, this.$closeableHolder, null), 3, null);
        this.L$0 = r37;
        this.L$1 = r133;
        this.label = 1;
        r36 = r132.await(this);
        if (r36 != r0) goto L34;
        return r0;
    L34:
        r114 = r37;
        r35 = r133;
        goto L35
    L15:
        r121 = -1;
        goto L16
    }
}
