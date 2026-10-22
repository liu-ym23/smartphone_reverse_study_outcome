package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.bumptech.glide.util.LruCache;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1", f = "FlowYunPanFileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FlowYunPanCoverType $coverType;
    final /* synthetic */ boolean $onlyCache;
    final /* synthetic */ String $token;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowYunPanCoverType.values().length];
            r0[FlowYunPanCoverType.Thumbnail.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FlowYunPanCoverType.Middle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1(String r1, FlowYunPanCoverType r2, boolean r3, Context r4, Continuation<? super FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1> r5) {
        this.$token = r1;
        this.$coverType = r2;
        this.$onlyCache = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1(this.$token, this.$coverType, this.$onlyCache, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r7);
        FlowYunPanFileUtils r8 = FlowYunPanFileUtils.a;     // Catch: Throwable -> L35
        PolarisFileWrapper r9 = FlowYunPanFileUtils.c(this.$token, this.$coverType);     // Catch: Throwable -> L35
        if (this.$onlyCache == false) goto L8;
        return r9;
    L8:
        if (r9 == null) goto L10;
        return r9;
    L10:
        com.bytedance.ee.bear.list.cover.a r10 = ((ik5.a) k.a(LarkContext.getApplication(), ik5.a.class)).F9();     // Catch: Throwable -> L35
        FlowYunPanCoverType r0 = this.$coverType;     // Catch: Throwable -> L35
        int[] r1 = a.a;     // Catch: Throwable -> L35
        int r2 = r1[r0.ordinal()];     // Catch: Throwable -> L35
        int r3 = 150;
        boolean r4 = true;
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L15;
        int r5 = 720;
    L17:
        int r6 = r1[this.$coverType.ordinal()];     // Catch: Throwable -> L35
        if (r6 == 1) goto L23;
        if (r6 != 2) goto L22;
        r3 = 1280;
        goto L23
    L22:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L35
    L23:
        File r11 = ImageLoader.with(this.$context).load(new BearGlideUrl(r10.a(this.$token, r5, r3, "near"))).diskCacheStrategy(DiskCacheStrategy.ALL).downloadOnly(r5, r3);     // Catch: Throwable -> L35
        if (r11 != null) goto L26;
    L28:
        r4 = false;
    L29:
        if (r4 == false) goto L37;
        LruCache r12 = (LruCache) FlowYunPanFileUtils.c.getValue();     // Catch: Throwable -> L35
        String r13 = this.$token + '_' + this.$coverType.getType();     // Catch: Throwable -> L35
        String r14 = r11.getAbsolutePath();     // Catch: Throwable -> L35
        if (r14 != null) goto L33;
        r14 = "";
    L33:
        r12.put(r13, r14);     // Catch: Throwable -> L35
        return r11;
    L37:
        return null;
    L26:
        if (r11.exists() != true) goto L28;
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L35
    L16:
        r5 = 150;
    L35:
        th = move-exception;
        Log.e("FlowYunPanFileUtils", "downloadYunPanPictureCoverFile error, " + th.getMessage());
        goto L37
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
