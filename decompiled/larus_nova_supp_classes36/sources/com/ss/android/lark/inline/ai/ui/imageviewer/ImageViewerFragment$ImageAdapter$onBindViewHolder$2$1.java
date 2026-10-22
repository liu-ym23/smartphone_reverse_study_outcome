package com.ss.android.lark.inline.ai.ui.imageviewer;

import com.bumptech.glide.RequestManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
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
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.imageviewer.ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1", f = "ImageViewerFragment.kt", i = {0}, l = {374}, m = "invokeSuspend", n = {"urlHash"}, s = {"I$0"})
final class ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageViewerFragment.ImageViewHolder $holder;
    final /* synthetic */ ImageViewerFragment<Object>.ImageAdapter $this_run;
    final /* synthetic */ String $url;
    int I$0;
    int label;
    final /* synthetic */ ImageViewerFragment<Object> this$0;

    public ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1(String r1, ImageViewerFragment.ImageViewHolder r2, ImageViewerFragment<Object>.ImageAdapter r3, ImageViewerFragment<Object> r4, Continuation<? super ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1> r5) {
        this.$url = r1;
        this.$holder = r2;
        this.$this_run = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1(this.$url, this.$holder, this.$this_run, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        int r1 = this.I$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L17:
        Log.i("ImageViewerFragment", "download success, url = " + r1);     // Catch: Throwable -> L8
        VFSPath r9 = VFSFiles.b.t((File) r8);     // Catch: Throwable -> L8
        this.this$0.q.put(this.$url, r9);     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(this.$holder.a.getTag(), this.$url) == false) goto L20;
        LargeImageView r0 = this.$holder.a;     // Catch: Throwable -> L8
        g r4 = new g();     // Catch: Throwable -> L8
        r4.a = r9;     // Catch: Throwable -> L8
        r0.o(r4);     // Catch: Throwable -> L8
    L20:
        this.this$0.V90();     // Catch: Throwable -> L8
    L29:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        th = th;
        int r10 = r1;
    L25:
        if (Intrinsics.areEqual(this.$holder.a.getTag(), this.$url) == false) goto L27;
        this.$holder.a.v();
    L27:
        Log.e("ImageViewerFragment", "download failed, url = " + r10, th);
        goto L29
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        r10 = this.$url.hashCode();
        this.$holder.a.w();     // Catch: Throwable -> L23
        Log.i("ImageViewerFragment", "start downloading, url = " + r10);     // Catch: Throwable -> L23
        int r5 = com.ss.android.lark.inline.ai.utils.d.a;     // Catch: Throwable -> L23
        RequestManager r6 = this.$this_run.a;     // Catch: Throwable -> L23
        String r7 = this.$url;     // Catch: Throwable -> L23
        this.I$0 = r10;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        Object r11 = com.ss.android.lark.inline.ai.utils.d.a(r6, r7, this);     // Catch: Throwable -> L23
        if (r11 != r2) goto L16;
        return r2;
    L16:
        r1 = r10;
        r8 = r11;
    L23:
        th = th;
        goto L25
    }
}
