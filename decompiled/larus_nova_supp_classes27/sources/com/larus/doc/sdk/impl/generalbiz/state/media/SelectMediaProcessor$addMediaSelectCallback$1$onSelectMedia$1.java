package com.larus.doc.sdk.impl.generalbiz.state.media;

import android.app.Application;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaProcessor$addMediaSelectCallback$1$onSelectMedia$1", f = "SelectMediaProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SelectMediaProcessor$addMediaSelectCallback$1$onSelectMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<? extends SelectedMediaItem>, Unit> $insertAndSwitchToReadOnlyMode;
    final /* synthetic */ List<SelectedMediaItem> $media;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectMediaProcessor$addMediaSelectCallback$1$onSelectMedia$1(List<? extends SelectedMediaItem> r1, Function1<? super List<? extends SelectedMediaItem>, Unit> r2, Continuation<? super SelectMediaProcessor$addMediaSelectCallback$1$onSelectMedia$1> r3) {
        this.$media = r1;
        this.$insertAndSwitchToReadOnlyMode = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SelectMediaProcessor$addMediaSelectCallback$1$onSelectMedia$1(this.$media, this.$insertAndSwitchToReadOnlyMode, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r9);
        PolarisFileWrapper r1 = new PolarisFileWrapper(c.k().getAbsolutePath(), "pic_cache");
        if (r1.exists() == true) goto L31;
        boolean r10 = r1.mkdirs();
        FLogger.a.i(SelectMediaProcessor.PLUGIN_TAG, "Make dir " + r1.getCanonicalPath() + " result: result");
        if (r10 == true) goto L31;
        return Unit.INSTANCE;
    L31:
        Iterator<T> r11 = this.$media.iterator();     // Catch: Exception -> L25
    L12:
        if (r11.hasNext() == false) goto L27;
        SelectedMediaItem r3 = (SelectedMediaItem) r11.next();     // Catch: Exception -> L25
        if (StringsKt.startsWith$default(r3.mediaFile, FileConst.DOC_PREFIX_URL, false, 2, null) == false) goto L16;
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3.mediaFile.substring(12));     // Catch: Exception -> L25
    L17:
        String r5 = FilesKt.getExtension(r4);     // Catch: Exception -> L25
        Locale r6 = Locale.ROOT;     // Catch: Exception -> L25
        if (Intrinsics.areEqual(r5.toLowerCase(r6), "heic") == true) goto L23;
        if (Intrinsics.areEqual(FilesKt.getExtension(r4).toLowerCase(r6), "heif") == true) goto L23;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r1, r3.fileName);     // Catch: Exception -> L25
        r.c(r4, r7);     // Catch: Exception -> L25
        r3.mediaFile = String.valueOf(r7.getCanonicalPath());     // Catch: Exception -> L25
    L23:
        FLogger.a.i(SelectMediaProcessor.PLUGIN_TAG, "HEIC/HEIF file not supported");     // Catch: Exception -> L25
        s r12 = s.a;     // Catch: Exception -> L25
        Application r0 = AppHost.a.getApplication();     // Catch: Exception -> L25
        r12.getClass();     // Catch: Exception -> L25
        s.s(r0, 2131907890);     // Catch: Exception -> L25
        return Unit.INSTANCE;
    L16:
        r4 = new PolarisFileWrapper(r3.mediaFile);     // Catch: Exception -> L25
    L27:
        this.$insertAndSwitchToReadOnlyMode.invoke(this.$media);
        return Unit.INSTANCE;
    L25:
        e = move-exception;
        FLogger.a.e(SelectMediaProcessor.PLUGIN_TAG, e.getMessage(), e);
        goto L27
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
