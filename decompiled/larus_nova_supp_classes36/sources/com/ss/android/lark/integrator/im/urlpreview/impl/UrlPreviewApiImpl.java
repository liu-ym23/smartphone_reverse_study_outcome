package com.ss.android.lark.integrator.im.urlpreview.impl;

import android.view.View;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.c;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.tangram.base.props.Props;
import gnb.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import zcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(UrlPreviewApi.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J2\u0010\u0010\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0013\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00150\u0012\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J2\u0010\u0018\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0013\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00150\u0012\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J2\u0010\u001c\u001a$\u0012\u001e\b\u0001\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0013\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00150\u0012\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/ss/android/lark/integrator/im/urlpreview/impl/UrlPreviewApiImpl;", "Lcom/ss/android/lark/export/api/UrlPreviewApi;", "<init>", "()V", "extensionList", "", "Lcom/ss/android/lark/export/extension/UrlPreviewExtension;", "urlPreviewContext", "Lcom/ss/android/lark/integrator/im/urlpreview/extension/UrlPreviewContextImpl;", "getUrlPreviewContext", "()Lcom/ss/android/lark/integrator/im/urlpreview/extension/UrlPreviewContextImpl;", "urlPreviewContext$delegate", "Lkotlin/Lazy;", "injectUrlPreviewExtensions", "", "urlPreviewContextImpl", "getUrlComponentFactory", "Lcom/ss/android/lark/export/UrlComponentFactory;", "Lcom/ss/android/lark/tangram/base/component/RenderComponent;", "Lcom/ss/android/lark/tangram/base/props/Props;", "Landroid/view/View;", "Lcom/ss/android/lark/tangram/base/dependency/Dependency;", "type", "Lcom/ss/android/lark/export/entity/preview/Type;", "getEngineComponentFactory", "Lcom/ss/android/lark/export/UrlEngineFactory;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "getCardEngineComponentFactory", "Lcom/ss/android/lark/export/CardEngineFactory;", "Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;", "clearAllUrlCache", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UrlPreviewApiImpl implements UrlPreviewApi {
    private final List<b> extensionList;
    private final Lazy urlPreviewContext$delegate;

    private final a getUrlPreviewContext() {
        return (a) this.urlPreviewContext$delegate.getValue();
    }

    public UrlPreviewApiImpl() {
        this.extensionList = new ArrayList();
        this.urlPreviewContext$delegate = LazyKt.lazy(new UrlPreviewApiImpl$urlPreviewContext$2(this));
    }

    public void clearAllUrlCache() {
        Iterator<Map.Entry<String, com.ss.android.lark.export.b>> r0 = getUrlPreviewContext().d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().clear();
        goto L4
    }

    private final void injectUrlPreviewExtensions(a r4) {
        Iterator r0 = PluginServiceLoader.loadAll(b.class);
    L4:
        if (r0.hasNext() == false) goto L8;
        b r1 = (b) r0.next();
        if (this.extensionList.contains(r1) == true) goto L4;
        r1.a(r4);
        this.extensionList.add(r1);
        goto L4
    }

    public com.ss.android.lark.export.a<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getCardEngineComponentFactory(ModelParserRenderRouterEntity.CardEngineType r2) {
        Intrinsics.checkNotNullParameter(r2, "engineType");
        return getUrlPreviewContext().c.get(r2);
    }

    public d<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getEngineComponentFactory(EngineProperty.EngineType r2) {
        Intrinsics.checkNotNullParameter(r2, "engineType");
        return getUrlPreviewContext().b.get(r2);
    }

    public c<? extends e<? extends Props, ? extends View, ? extends r6c.a>> getUrlComponentFactory(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return getUrlPreviewContext().a.get(r2);
    }

    public static final /* synthetic */ void access$injectUrlPreviewExtensions(UrlPreviewApiImpl r0, a r1) {
        r0.injectUrlPreviewExtensions(r1);
    }
}
