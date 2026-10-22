package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$loadCoverUri$2", f = "FlowImageLoaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowImageLoaderUtils$loadCoverUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhotoItem $photoItem;
    int label;

    public FlowImageLoaderUtils$loadCoverUri$2(PhotoItem r1, Context r2, Continuation<? super FlowImageLoaderUtils$loadCoverUri$2> r3) {
        this.$photoItem = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowImageLoaderUtils$loadCoverUri$2(this.$photoItem, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r8);
        PhotoItem r9 = this.$photoItem;
        if (r9 != null) goto L7;
        return null;
    L7:
        Pair r10 = f.b(r9);
        if (r10 != null) goto L10;
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
        List r7 = this.$photoItem.getPaths();
        if (r7 == null) goto L31;
        Object r11 = (String) ListProtector.get(r7, 0);
    L33:
        if (r10 != null) goto L64;
    L37:
        int r12 = this.$photoItem.getWidth();     // Catch: Throwable -> L63
    L38:
        if (r10 == null) goto L42;
        Pair r13 = (Pair) r10.getSecond();     // Catch: Throwable -> L63
        if (r13 == null) goto L42;
        int r14 = ((Number) r13.getSecond()).intValue();     // Catch: Throwable -> L63
    L43:
        StringBuilder r15 = new StringBuilder("loadModel: ");     // Catch: Throwable -> L63
        r15.append(r11);     // Catch: Throwable -> L63
        r15.append(", width: ");     // Catch: Throwable -> L63
        if (r10 == null) goto L48;
        Pair r0 = (Pair) r10.getSecond();     // Catch: Throwable -> L63
        if (r0 == null) goto L48;
        Integer r1 = (Integer) r0.getFirst();     // Catch: Throwable -> L63
    L49:
        r15.append(r1);     // Catch: Throwable -> L63
        r15.append(", height: ");     // Catch: Throwable -> L63
        if (r10 == null) goto L54;
        Pair r16 = (Pair) r10.getSecond();     // Catch: Throwable -> L63
        if (r16 == null) goto L54;
        Integer r17 = (Integer) r16.getSecond();     // Catch: Throwable -> L63
    L55:
        r15.append(r17);     // Catch: Throwable -> L63
        Log.d("FlowImageLoaderUtils", r15.toString());     // Catch: Throwable -> L63
        File r18 = ImageLoader.with(this.$context).load(r11).downloadOnly(r12, r14);     // Catch: Throwable -> L63
        if (r18 != null) goto L58;
        return null;
    L58:
        if (r18.exists() == false) goto L67;
        return Uri.fromFile(r18).toString();
    L68:
        return null;
    L67:
        return null;
    L54:
        r17 = null;
    L48:
        r1 = null;
    L42:
        r14 = this.$photoItem.getHeight();     // Catch: Throwable -> L63
        goto L43
    L64:
        Pair r19 = (Pair) r10.getSecond();     // Catch: Throwable -> L63
        if (r19 == null) goto L37;
        r12 = ((Number) r19.getFirst()).intValue();     // Catch: Throwable -> L63
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
        if (r.a((String) r10.getFirst()) == false) goto L12;
        r11 = new EncryptImage((String) r10.getFirst());
        goto L33
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
