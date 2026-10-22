package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.bumptech.glide.util.LruCache;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1", f = "FlowYunPanFileUtils.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
public final class FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $onlyCache;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $token;
    int label;

    public FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1(String r1, boolean r2, long r3, Context r5, Continuation<? super FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1> r6) {
        this.$token = r1;
        this.$onlyCache = r2;
        this.$startTime = r3;
        this.$context = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1(this.$token, this.$onlyCache, this.$startTime, this.$context, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r6 = false;
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L55
    L37:
        String r12 = (String) r11;     // Catch: Throwable -> L55
        if (r12.length() != 0) goto L40;
        boolean r4 = true;
    L41:
        if (r4 == false) goto L44;
        Log.e("FlowYunPanFileUtils", "fetchDriveImagePreview error, token: " + this.$token.hashCode() + ", response is null");     // Catch: Throwable -> L55
        return null;
    L44:
        Log.i("FlowYunPanFileUtils", "downloadYunPanPictureWithFile, token: " + this.$token.hashCode() + ", url: " + r12 + ", fetchDriveImagePreview cost: " + (System.currentTimeMillis() - this.$startTime));     // Catch: Throwable -> L55
        File r13 = ImageLoader.with(this.$context).load(new BearGlideUrl(r12)).diskCacheStrategy(DiskCacheStrategy.ALL).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);     // Catch: Throwable -> L55
        if (r13 != null) goto L47;
    L49:
        if (r6 == false) goto L59;
        FlowYunPanFileUtils r0 = FlowYunPanFileUtils.a;     // Catch: Throwable -> L55
        LruCache r1 = (LruCache) FlowYunPanFileUtils.b.getValue();     // Catch: Throwable -> L55
        String r5 = this.$token;     // Catch: Throwable -> L55
        String r7 = r13.getAbsolutePath();     // Catch: Throwable -> L55
        if (r7 != null) goto L53;
        r7 = "";
    L53:
        r1.put(r5, r7);     // Catch: Throwable -> L55
        return r13;
    L59:
        return null;
    L47:
        if (r13.exists() != true) goto L49;
        r6 = true;
        goto L49
    L40:
        r4 = false;
        goto L41
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        FlowYunPanFileUtils r14 = FlowYunPanFileUtils.a;     // Catch: Throwable -> L55
        String r15 = this.$token;     // Catch: Throwable -> L55
        if (r15.length() != 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L28;
        String r16 = (String) ((LruCache) FlowYunPanFileUtils.b.getValue()).get(r15);     // Catch: Throwable -> L55
        if (r16 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L28;
        PolarisFileWrapper r10 = new PolarisFileWrapper(r16);     // Catch: Throwable -> L55
        if (r10.exists() == false) goto L28;
    L30:
        if (this.$onlyCache == false) goto L32;
        return r10;
    L32:
        if (r10 == null) goto L34;
        return r10;
    L34:
        String r17 = this.$token;     // Catch: Throwable -> L55
        this.label = 1;     // Catch: Throwable -> L55
        r11 = FlowYunPanFileUtils.b(r17, this);     // Catch: Throwable -> L55
        if (r11 != r2) goto L37;
        return r2;
    L19:
        if (r16.length() == 0) goto L22;
        r9 = false;
    L28:
        r10 = null;
        goto L30
    L13:
        r8 = false;
    L55:
        th = move-exception;
        Log.e("FlowYunPanFileUtils", "downloadYunPanPictureWithFile error, " + th.getMessage());
        return null;
    }
}
