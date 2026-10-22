package com.larus.doc.sdk.impl.generalbiz.state.media;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaProcessor$addMediaSelectCallbackV1$1$onSelectMediaV1$1", f = "SelectMediaProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SelectMediaProcessor$addMediaSelectCallbackV1$1$onSelectMediaV1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<SelectedMediaItemV1>, Unit> $insertAndSwitchToReadOnlyMode;
    final /* synthetic */ List<SelectedMediaItemV1> $media;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectMediaProcessor$addMediaSelectCallbackV1$1$onSelectMediaV1$1(List<SelectedMediaItemV1> r1, Function1<? super List<SelectedMediaItemV1>, Unit> r2, Continuation<? super SelectMediaProcessor$addMediaSelectCallbackV1$1$onSelectMediaV1$1> r3) {
        this.$media = r1;
        this.$insertAndSwitchToReadOnlyMode = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SelectMediaProcessor$addMediaSelectCallbackV1$1$onSelectMediaV1$1(this.$media, this.$insertAndSwitchToReadOnlyMode, r4);
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
        PolarisFileWrapper r1 = new PolarisFileWrapper(ChameleonResUtils.INSTANCE.getWebcontainerRootDir(), "pic_cache");
        if (r1.exists() == true) goto L31;
        boolean r10 = r1.mkdirs();
        FLogger.a.i(SelectMediaProcessor.PLUGIN_TAG, "Make dir " + r1.getCanonicalPath() + " result: result");
        if (r10 == true) goto L31;
        return Unit.INSTANCE;
    L31:
        Iterator<T> r11 = this.$media.iterator();     // Catch: Exception -> L25
    L11:
        if (r11.hasNext() == false) goto L27;
        SelectedMediaItemV1 r3 = (SelectedMediaItemV1) r11.next();     // Catch: Exception -> L25
        if (StringsKt.startsWith$default(r3.getMediaFile(), FileConst.DOC_PREFIX_URL, false, 2, null) == false) goto L16;
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3.getMediaFile().substring(12));     // Catch: Exception -> L25
    L18:
        if (r4.exists() == false) goto L23;
        if (r4.isFile() == false) goto L23;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r1, r3.getFileName());     // Catch: Exception -> L25
        r.c(r4, r5);     // Catch: Exception -> L25
        r3.setMediaFile(FileConst.DOC_PREFIX_URL + r5.getCanonicalPath());     // Catch: Exception -> L25
    L23:
        FLogger.a.w(SelectMediaProcessor.PLUGIN_TAG, "onSelectMediaV1 skip missing source: " + r4.getAbsolutePath());     // Catch: Exception -> L25
        goto L11
    L16:
        r4 = new PolarisFileWrapper(r3.getMediaFile());     // Catch: Exception -> L25
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
