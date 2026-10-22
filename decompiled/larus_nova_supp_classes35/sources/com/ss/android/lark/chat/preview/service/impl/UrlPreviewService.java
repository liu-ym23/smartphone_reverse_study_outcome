package com.ss.android.lark.chat.preview.service.impl;

import b38.b;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.url.v1.AppScene;
import com.bytedance.lark.pb.url.v1.DeletePreviewsByIdsRequest;
import com.bytedance.lark.pb.url.v1.GetPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetTempPreviewRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.log.Log;
import h6b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class UrlPreviewService {

    public static final class a {
    }

    static {
    }

    @Inject
    public UrlPreviewService() {
    }

    public static void a(List r4) {
        Intrinsics.checkNotNullParameter(r4, "previewIds");
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if ((true ^ StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r6 = CollectionsKt.distinct(r0);
        if (r6.isEmpty() == false) goto L11;
        return;
    L11:
        DeletePreviewsByIdsRequest r2 = new DeletePreviewsByIdsRequest.Builder().preview_ids(r6).build();
        com.ss.android.lark.chat.preview.service.impl.a r3 = (com.ss.android.lark.chat.preview.service.impl.a) b.a.create(com.ss.android.lark.chat.preview.service.impl.a.class);
        Intrinsics.checkNotNull(r2);
        RucketJob.error$default(RucketJob.then$default(r3.deletePreviewsByIds(r2), null, new UrlPreviewService$deletePreviewsByIds$1(r6, null), 1, null), null, new UrlPreviewService$deletePreviewsByIds$2(null), 1, null);
    }

    public final Object b(List<PreviewHangPoint> r4, Continuation<? super Map<String, UrlCardPreviewEntity>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UrlPreviewService$getPreviewByHangPoints$2(r4, this, null), r5);
    }

    public static void c(List r3, SyncDataStrategy r4, IGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "previewIds");
        Intrinsics.checkNotNullParameter(r4, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("start,");
        g r1 = g.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "stringList");
        r1.a.getClass();
        r0.append(k6b.a.d(r3));
        Log.i("[URLPreview] GetMessagePreviewsRequest", r0.toString());
        GetPreviewRequest.Builder r6 = new GetPreviewRequest.Builder().preview_ids(r3).sync_data_strategy(SyncDataStrategy.fromValue(r4.getValue()));
        RucketJob.then$default(((com.ss.android.lark.chat.preview.service.impl.a) b.a.create(com.ss.android.lark.chat.preview.service.impl.a.class)).getPreviewEntity(r6.build()), null, new UrlPreviewService$getPreviewEntity$1(r5, null), 1, null).error(Dispatchers.getMain(), new UrlPreviewService$getPreviewEntity$2(r5, null));
    }

    public static void d(String r2, long r3, long r5, IGetDataCallback r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Log.i("[URLPreview] GetTempPreviewRequest", "start, url.length:" + r2.length());
        ((com.ss.android.lark.chat.preview.service.impl.a) b.a.create(com.ss.android.lark.chat.preview.service.impl.a.class)).getTempPreview(new GetTempPreviewRequest.Builder().app_id(Long.valueOf(r3)).url(r2).app_scene(new AppScene.Builder().type(Long.valueOf(r5)).base_ctx(null).build()).build()).then(Dispatchers.getMain(), new UrlPreviewService$getTempPreview$1(r7, null)).error(Dispatchers.getMain(), new UrlPreviewService$getTempPreview$2(r7, null));
    }
}
