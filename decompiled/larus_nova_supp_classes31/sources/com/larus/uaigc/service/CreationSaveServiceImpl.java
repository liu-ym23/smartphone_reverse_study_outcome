package com.larus.uaigc.service;

import android.content.Context;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil;
import com.larus.uaigc.share.AigcVideoSaveHelper;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J·\u0001\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2(\u0010\"\u001a$\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u001e\u0010&\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130(\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010'H\u0016¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"Lcom/larus/uaigc/service/CreationSaveServiceImpl;", "Lcom/larus/uaigc/service/ICreationSaveService;", "<init>", "()V", "downloadCreation", "", "context", "Landroid/content/Context;", "imageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "reportParams", "Lorg/json/JSONObject;", "creationType", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "rootView", "Landroid/view/View;", "creationId", "", "(Landroid/content/Context;Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;Lorg/json/JSONObject;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineScope;Landroid/view/View;Ljava/lang/String;)V", "saveAigcVideoAndLoading", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "scope", "traceBlk", "Lkotlin/Function0;", "enableUseSRDownLoad", "", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "finishCallback", "Lkotlin/Function4;", "", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationSaveServiceImpl implements ICreationSaveService {
    public CreationSaveServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationSaveService
    public final void w(Context r23, n1 r24, JSONObject r25, Integer r26, CoroutineScope r27, CommonDownLoadLayout r28, String r29) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r25, "reportParams");
        Intrinsics.checkNotNullParameter(r27, "mainScope");
        Intrinsics.checkNotNullParameter(r28, "rootView");
        CreationGalleryUtil r2 = CreationGalleryUtil.a;
        CreationGalleryUtil.c(r23, new sz9.c(r24, y0.j(r24.c), r26, null, null, r25, Boolean.TRUE, null, null, r29, r27, null, null, null, null, false, null, 127384), r28, null);
    }

    @Override // com.larus.uaigc.service.ICreationSaveService
    public final void g(Context r14, String r15, nr9.g r16, CoroutineScope r17, Function0<Unit> r18, boolean r19, UserCreationFromIM r20, UserCreation r21, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r22, Function0<Unit> r23, Function1<? super Continuation<? super String>, ? extends Object> r24) {
        Intrinsics.checkNotNullParameter(r15, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r17, "scope");
        new AigcVideoSaveHelper().a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }
}
