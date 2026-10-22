package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.net.Uri;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSPath;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.imageviewer.ImageViewerFragment$initListeners$2$1$success$1", f = "ImageViewerFragment.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
public final class ImageViewerFragment$initListeners$2$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ImageViewerFragment<Object> this$0;

    public ImageViewerFragment$initListeners$2$1$success$1(ImageViewerFragment<Object> r1, Continuation<? super ImageViewerFragment$initListeners$2$1$success$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageViewerFragment$initListeners$2$1$success$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        return r18;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        ImageViewerFragment<Object> r1 = this.this$0;
        this.label = 1;
        int r4 = ImageViewerFragment.r;
        r1.getClass();
        VFSPath r8 = r1.q.get(r1.d.b.invoke(ListProtector.get(r1.m, r1.o)));     // Catch: Throwable -> L23
        if (r8 != null) goto L12;
        Log.e("ImageViewerFragment", "file is null!");     // Catch: Throwable -> L23
        Boolean r3 = Boxing.boxBoolean(false);     // Catch: Throwable -> L23
    L26:
        if (r3 != r2) goto L30;
        return r2;
    L30:
        return r3;
    L12:
        Log.i("ImageViewerFragment", "do save, path = " + r8.getAbsolutePath());     // Catch: Throwable -> L23
        String r6 = FileUtils.l(r8.getAbsolutePath());     // Catch: Throwable -> L23
        ImageUtils.ImageType r9 = ImageUtils.c(r8.toFile());     // Catch: Throwable -> L23
        if (r9 != ImageUtils.ImageType.TYPE_UNKNOWN) goto L15;
        Log.e("ImageViewerFragment", "file is not a image!");     // Catch: Throwable -> L23
        r3 = Boxing.boxBoolean(false);     // Catch: Throwable -> L23
        goto L26
    L15:
        String r7 = FileUtils.n(r6) + '_' + System.currentTimeMillis() + '.' + r9.getValue();     // Catch: Throwable -> L23
        Log.i("ImageViewerFragment", "newFileName: " + r7);     // Catch: Throwable -> L23
        Uri r5 = MediaStoreUtil.f(r1.getContext(), r7, null, null, new Token("LARK-PSDA-inline_ai_image_create_uri"), 28);     // Catch: Throwable -> L23
        if (r5 != null) goto L18;
    L25:
        r3 = Boxing.boxBoolean(false);
        goto L26
    L18:
        if (BdMediaFileSystem.isUriExists(r1.getContext(), r5) == false) goto L20;
        Log.w("ImageViewerFragment", r7 + " has exist");     // Catch: Throwable -> L23
    L21:
        r3 = Boxing.boxBoolean(true);     // Catch: Throwable -> L23
        goto L26
    L20:
        MediaStoreUtil.c(r8.toFile(), r5, r1.requireContext());     // Catch: Throwable -> L23
        MediaStoreUtil.j(r1.requireContext(), r5.toString(), new Token("LARK-PSDA-inline_ai_image_scan_file"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Log.e("ImageViewerFragment", "doSave error!", th);
        goto L25
    }
}
