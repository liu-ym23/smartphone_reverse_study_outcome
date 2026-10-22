package com.ss.android.lark.officesdk.integrator.im;

import android.view.View;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public f() {
    }

    public final com.ss.android.lark.export.d<? extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> a(EngineProperty.EngineType r2) {
        Intrinsics.checkNotNullParameter(r2, "engineType");
        UrlPreviewApi r0 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEngineComponentFactory(r2);
    }

    public final com.ss.android.lark.export.c<? extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> b(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        UrlPreviewApi r0 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUrlComponentFactory(r2);
    }
}
