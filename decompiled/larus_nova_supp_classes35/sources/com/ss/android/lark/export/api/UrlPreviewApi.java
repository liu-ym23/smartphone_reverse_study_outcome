package com.ss.android.lark.export.api;

import android.view.View;
import com.ss.android.lark.export.a;
import com.ss.android.lark.export.c;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import q6c.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH&J2\u0010\n\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J2\u0010\u000e\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/export/api/UrlPreviewApi;", BuildConfig.FLAVOR, "getUrlComponentFactory", "Lcom/ss/android/lark/export/UrlComponentFactory;", "Lcom/ss/android/lark/tangram/base/component/RenderComponent;", "Lcom/ss/android/lark/tangram/base/props/Props;", "Landroid/view/View;", "Lcom/ss/android/lark/tangram/base/dependency/Dependency;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Type;", "getEngineComponentFactory", "Lcom/ss/android/lark/export/UrlEngineFactory;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "getCardEngineComponentFactory", "Lcom/ss/android/lark/export/CardEngineFactory;", "Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;", "clearAllUrlCache", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UrlPreviewApi {
    void clearAllUrlCache();

    a<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getCardEngineComponentFactory(ModelParserRenderRouterEntity.CardEngineType r1);

    d<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getEngineComponentFactory(EngineProperty.EngineType r1);

    c<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getUrlComponentFactory(Type r1);
}
