package com.larus.bmhome.monitor;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_ui.video.j;
import com.larus.image.loader.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jt\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2,\u0010\u000e\u001a(\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\b\u0015H'¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "", "loadImageByImageLoader", "", "messageId", "", "type", "Lcom/larus/bmhome/monitor/CommonUIMessageImageType;", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", ShareType.URL, "bizTag", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommonUIMessageImageLoaderService {
    void a(String r1, CommonUIMessageImageType r2, SimpleDraweeView r3, String r4, String r5, g r6, j r7);
}
