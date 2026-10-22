package com.larus.bmhome.monitor;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_ui.video.j;
import com.larus.image.loader.g;
import hr8.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jp\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142,\u0010\u0015\u001a(\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\u0002\b\u001cH\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/monitor/CommonUIMessageImageLoader;", "Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "<init>", "()V", "service", "getService", "()Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "service$delegate", "Lkotlin/Lazy;", "loadImageByImageLoader", "", "messageId", "", "type", "Lcom/larus/bmhome/monitor/CommonUIMessageImageType;", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", ShareType.URL, "bizTag", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonUIMessageImageLoader implements ICommonUIMessageImageLoaderService {
    public static final CommonUIMessageImageLoader a = null;
    public static final Lazy b = null;

    private CommonUIMessageImageLoader() {
    }

    static {
        a = new CommonUIMessageImageLoader();
        b = LazyKt.lazy(new a());
    }

    @Override // com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService
    public final void a(String r10, CommonUIMessageImageType r11, SimpleDraweeView r12, String r13, String r14, g r15, j r16) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r16, "builder");
        ICommonUIMessageImageLoaderService r1 = (ICommonUIMessageImageLoaderService) b.getValue();
        if (r1 == null) goto L6;
        r1.a(r10, r11, r12, r13, r14, r15, r16);
        return;
    }
}
