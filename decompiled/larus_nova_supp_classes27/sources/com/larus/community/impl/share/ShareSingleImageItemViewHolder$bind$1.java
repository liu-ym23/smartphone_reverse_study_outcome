package com.larus.community.impl.share;

import android.R;
import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.ShareSingleImageItemViewHolder$bind$1", f = "ShareSingleImageItemViewHolder.kt", i = {0, 0}, l = {86}, m = "invokeSuspend", n = {"$this$launch", "hasValidDefaultSize"}, s = {"L$0", "I$0"})
final class ShareSingleImageItemViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $closeableHolder;
    final /* synthetic */ int $itemHeight;
    final /* synthetic */ r $shareImageSingleItem;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShareSingleImageItemViewHolder this$0;

    public ShareSingleImageItemViewHolder$bind$1(r r1, ShareSingleImageItemViewHolder r2, int r3, m r4, Continuation<? super ShareSingleImageItemViewHolder$bind$1> r5) {
        this.$shareImageSingleItem = r1;
        this.this$0 = r2;
        this.$itemHeight = r3;
        this.$closeableHolder = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ShareSingleImageItemViewHolder$bind$1 r6 = new ShareSingleImageItemViewHolder$bind$1(this.$shareImageSingleItem, this.this$0, this.$itemHeight, this.$closeableHolder, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = false;
        Bitmap r5 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L38:
        CloseableReference<CloseableImage> r12 = (CloseableReference) r11;
        if (r12 == null) goto L46;
        this.$closeableHolder.a("preview:" + this.$shareImageSingleItem.a, r12);
        Object r13 = r12.get();
        if ((r13 instanceof CloseableStaticBitmap) == false) goto L43;
        CloseableStaticBitmap r14 = (CloseableStaticBitmap) r13;
    L44:
        if (r14 == null) goto L46;
        r5 = r14.getUnderlyingBitmap();
        goto L46
    L43:
        r14 = null;
    L46:
        CoroutineScopeKt.ensureActive(r4);
        e1.o(this.this$0.e);
        this.this$0.f.setShadowColor(ColorProtector.parseColor("#1A000000"));
        r r15 = this.$shareImageSingleItem;
        if (r15.e == true) goto L49;
    L59:
        e1.o(this.this$0.c);
    L60:
        if (r5 == null) goto L71;
        ShareSingleImageItemViewHolder r16 = this.this$0;
        m r6 = this.$closeableHolder;
        int r7 = this.$itemHeight;
        CoroutineScopeKt.ensureActive(r4);
        if (r16.j != r6) goto L64;
        r3 = true;
    L64:
        if (r3 == false) goto L66;
        if (r2 != 0) goto L69;
        ShareSingleImageItemViewHolder.T3(r16, r5.getWidth(), r5.getHeight(), r7);
    L69:
        r16.b.setImageBitmap(r5);
        goto L71
    L66:
        return Unit.INSTANCE;
    L71:
        return Unit.INSTANCE;
    L49:
        if (r15.f <= 0) goto L59;
        e1.x(this.this$0.c);
        int r17 = this.$shareImageSingleItem.f;
        if (r17 <= 60) goto L56;
        int r8 = r17 / 60;
        int r18 = r17 % 60;
        if (r8 >= 10) goto L55;
        this.this$0.d.setText("0" + r8 + ':' + r18);
        goto L60
    L55:
        TextView r9 = this.this$0.d;
        StringBuilder r10 = new StringBuilder();
        r10.append(r8);
        r10.append(':');
        r10.append(r18);
        r9.setText(r10.toString());
        goto L60
    L56:
        if (r17 >= 10) goto L58;
        this.this$0.d.setText("00:0" + r17);
        goto L60
    L58:
        this.this$0.d.setText("00:" + r17);
        goto L60
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r4 = (CoroutineScope) this.L$0;
        Long r110 = this.$shareImageSingleItem.b;
        long r20 = -1;
        if (r110 == null) goto L11;
        long r21 = r110.longValue();
    L12:
        int r111 = (int) r21;
        Long r22 = this.$shareImageSingleItem.c;
        if (r22 == null) goto L15;
        r20 = r22.longValue();
    L15:
        int r23 = (int) r20;
        if (r111 <= 0) goto L19;
        if (r23 <= 0) goto L19;
        int r24 = 1;
    L20:
        ShareSingleImageItemViewHolder r25 = this.this$0;
        Integer r112 = Boxing.boxInt(r111);
        r112.intValue();
        if (r24 != 0) goto L24;
        r112 = null;
    L24:
        if (r112 == null) goto L26;
        int r113 = r112.intValue();
    L27:
        Integer r26 = Boxing.boxInt(r23);
        r26.intValue();
        if (r24 != 0) goto L31;
        r26 = null;
    L31:
        if (r26 == null) goto L33;
        int r27 = r26.intValue();
    L34:
        ShareSingleImageItemViewHolder.T3(r25, r113, r27, this.$itemHeight);
        e1.x(this.this$0.e);
        ShareSingleImageItemViewHolder r114 = this.this$0;
        r114.f.setShadowColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r114).itemView.getContext(), R.color.transparent));
        String r115 = this.$shareImageSingleItem.a;
        this.L$0 = r4;
        this.I$0 = r24;
        this.label = 1;
        r11 = ImageLoaderKt.i(r115, "creation_share", null, this, 60);
        if (r11 != r0) goto L37;
        return r0;
    L37:
        r2 = r24;
        goto L38
    L33:
        r27 = this.$itemHeight;
        goto L34
    L26:
        r113 = this.this$0.g;
    L19:
        r24 = 0;
        goto L20
    L11:
        r21 = -1;
        goto L12
    }
}
