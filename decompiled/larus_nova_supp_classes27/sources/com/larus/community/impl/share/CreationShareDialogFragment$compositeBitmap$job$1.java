package com.larus.community.impl.share;

import android.graphics.Bitmap;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.community.impl.databinding.LarusCommunityPictureShareDialogLayoutBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.CreationShareDialogFragment$compositeBitmap$job$1", f = "CreationShareDialogFragment.kt", i = {0, 1}, l = {178, 179, 182}, m = "invokeSuspend", n = {"refBitmapDeferred", "downloadBitmap"}, s = {"L$0", "L$0"})
final class CreationShareDialogFragment$compositeBitmap$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.j $imageShareModel;
    final /* synthetic */ int $resizeThreshold;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationShareDialogFragment this$0;

    public CreationShareDialogFragment$compositeBitmap$job$1(CreationShareDialogFragment r1, sq9.j r2, int r3, Continuation<? super CreationShareDialogFragment$compositeBitmap$job$1> r4) {
        this.this$0 = r1;
        this.$imageShareModel = r2;
        this.$resizeThreshold = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CreationShareDialogFragment$compositeBitmap$job$1 r0 = new CreationShareDialogFragment$compositeBitmap$job$1(this.this$0, this.$imageShareModel, this.$resizeThreshold, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r48) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        String r7 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r48);
        Object r4 = r48;
    L32:
        CreationShareDialogFragment r5 = this.this$0;
        r5.g = (Bitmap) r4;
        LarusCommunityPictureShareDialogLayoutBinding r6 = r5.d;
        if (r6 == null) goto L39;
        ViewPager2 r8 = r6.e;
        if (r8 == null) goto L39;
        if (r8.getCurrentItem() != 1) goto L39;
        boolean r9 = true;
    L40:
        if (r9 == false) goto L54;
        CreationShareDialogFragment r10 = this.this$0;
        com.larus.bmhome.share.panel.a r11 = r10.e;
        if (r11 == null) goto L54;
        Bitmap r12 = r10.g;
        sq9.j r13 = this.$imageShareModel;
        com.larus.bmhome.share.panel.b r14 = new com.larus.bmhome.share.panel.b(null, r12, null, null, null, null, null, null, null, null, null, null, null, null, null, r13.l, true, true, null, null, false, false, r13.o, false, null, null, 62685181);
        com.larus.bmhome.share.panel.h r15 = r13.g;
        if (r15 == null) goto L53;
        Boolean r310 = Boxing.boxBoolean(true);
        sq9.i r16 = this.$imageShareModel.k;
        if (r16 == null) goto L48;
        String r17 = r16.a;
    L50:
        if (Intrinsics.areEqual(r17, "download") == false) goto L52;
        r7 = "click_download";
    L52:
        r7 = com.larus.bmhome.share.panel.h.a(r15, null, r310, r7, null, null, null, null, -1, -13);
        goto L53
    L48:
        r17 = null;
    L53:
        r11.d(r14, r7);
    L54:
        FLogger r18 = FLogger.a;
        StringBuilder r20 = new StringBuilder("compositeBitmap is null ");
        if (this.this$0.g != null) goto L57;
        r3 = true;
    L57:
        r20.append(r3);
        r18.i("ShareDialogFragment", r20.toString());
    L61:
        return Unit.INSTANCE;
    L39:
        r9 = false;
        goto L40
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Bitmap r21 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r48);
        Object r22 = r48;
    L18:
        Bitmap r23 = (Bitmap) r22;
        FLogger r24 = FLogger.a;
        StringBuilder r110 = new StringBuilder("compositeBitmap downloadBitmap is null ? ");
        if (r21 != null) goto L21;
        boolean r111 = true;
    L22:
        r110.append(r111);
        r110.append(" ; refBitmap is null ? ");
        if (r23 != null) goto L25;
        boolean r112 = true;
    L26:
        r110.append(r112);
        r24.i("ShareDialogFragment", r110.toString());
        if (r21 == null) goto L58;
        if (r23 == null) goto L58;
        CoroutineDispatcher r25 = Dispatchers.getIO();
        CreationShareDialogFragment$compositeBitmap$job$1$result$1 r113 = new CreationShareDialogFragment$compositeBitmap$job$1$result$1(r21, r23, null);
        this.L$0 = null;
        this.label = 3;
        r4 = BuildersKt.withContext(r25, r113, this);
        if (r4 != r1) goto L32;
        return r1;
    L58:
        if (r21 == null) goto L61;
        this.this$0.g = r21;
        goto L61
    L25:
        r112 = false;
        goto L26
    L21:
        r111 = false;
        goto L22
    L11:
        Deferred r26 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r48);
        Deferred r27 = r26;
        Object r28 = r48;
    L15:
        r21 = (Bitmap) r28;
        this.L$0 = r21;
        this.label = 2;
        r22 = r27.await(this);
        if (r22 != r1) goto L18;
        return r1;
    L12:
        ResultKt.throwOnFailure(r48);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        Deferred r114 = BuildersKt.async$default(r30, null, null, new CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1(this.$imageShareModel, this.$resizeThreshold, this.this$0, null), 3, null);
        r27 = BuildersKt.async$default(r30, null, null, new CreationShareDialogFragment$compositeBitmap$job$1$refBitmapDeferred$1(this.$imageShareModel, this.$resizeThreshold, this.this$0, null), 3, null);
        this.L$0 = r27;
        this.label = 1;
        r28 = r114.await(this);
        if (r28 != r1) goto L15;
        return r1;
    }
}
