package com.ss.android.lark.integrator.todo.dependency;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements g7c.u {
    public t() {
    }

    public final void transformRichTextByPreview(RichText r2, Map<String, PreviewHangPoint> r3) {
        Intrinsics.checkNotNullParameter(r2, "richText");
        Intrinsics.checkNotNullParameter(r3, "previews");
    }

    public final Map a() {
        Intrinsics.checkNotNullParameter("todo_id", "id");
        return MapsKt.emptyMap();
    }

    public final UrlInlinePreviewEntity b(UrlPreviewEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "urlPreviewEntity");
        return new UrlInlinePreviewEntity(new UrlInlinePreviewEntity.Builder());
    }

    public final Map<String, Map<String, UrlCardPreviewEntity>> c(Map<String, ? extends List<UrlPreviewHangPoint>> r2, SyncDataStrategy r3) {
        Intrinsics.checkNotNullParameter(r2, "messagePreviewMap");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        return MapsKt.emptyMap();
    }

    public final void d(String r3, TodoRustCommon.getPreviewEntityByURLNew.2.1 r4) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onError(new ErrorResult(1, "url preview is not supported in OfficeSDK Todo"));
    }
}
