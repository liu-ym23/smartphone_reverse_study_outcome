package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$loadCover$2", f = "FlowImageLoaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowImageLoaderUtils$loadCover$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhotoItem $photoItem;
    int label;

    public FlowImageLoaderUtils$loadCover$2(PhotoItem r1, Context r2, Continuation<? super FlowImageLoaderUtils$loadCover$2> r3) {
        this.$photoItem = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowImageLoaderUtils$loadCover$2(this.$photoItem, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r7);
        PhotoItem r8 = this.$photoItem;
        if (r8 != null) goto L7;
        return null;
    L7:
        Pair r9 = f.b(r8);
        if (r9 != null) goto L10;
    L12:
        List r2 = this.$photoItem.getPaths();
        boolean r3 = true;
        if (r2 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L32;
        List r5 = this.$photoItem.getPaths();
        if (r5 == null) goto L26;
        String r6 = (String) ListProtector.get(r5, 0);
        if (r6 == null) goto L26;
        if (r.a(r6) != true) goto L26;
    L27:
        if (r3 == false) goto L32;
        List r10 = this.$photoItem.getPaths();
        if (r10 == null) goto L31;
        Object r11 = (String) ListProtector.get(r10, 0);
    L33:
        if (r9 != null) goto L48;
    L37:
        int r12 = this.$photoItem.getWidth();     // Catch: Throwable -> L47
    L38:
        if (r9 == null) goto L42;
        Pair r13 = (Pair) r9.getSecond();     // Catch: Throwable -> L47
        if (r13 == null) goto L42;
        int r14 = ((Number) r13.getSecond()).intValue();     // Catch: Throwable -> L47
    L43:
        Log.d("FlowImageLoaderUtils", "loadModel: " + r11 + ", width: " + r12 + ", height: " + r14);     // Catch: Throwable -> L47
        return ImageLoader.with(this.$context).load(r11).getBitmap(r12, r14);
    L50:
        return null;
    L42:
        r14 = this.$photoItem.getHeight();     // Catch: Throwable -> L47
        goto L43
    L48:
        Pair r15 = (Pair) r9.getSecond();     // Catch: Throwable -> L47
        if (r15 == null) goto L37;
        r12 = ((Number) r15.getFirst()).intValue();     // Catch: Throwable -> L47
        goto L38
    L31:
        r11 = null;
    L26:
        r3 = false;
    L32:
        r11 = "";
        goto L33
    L15:
        if ((!r2.isEmpty()) != true) goto L17;
        r4 = true;
        goto L18
    L10:
        if (r.a((String) r9.getFirst()) == false) goto L12;
        r11 = new EncryptImage((String) r9.getFirst());
        goto L33
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
