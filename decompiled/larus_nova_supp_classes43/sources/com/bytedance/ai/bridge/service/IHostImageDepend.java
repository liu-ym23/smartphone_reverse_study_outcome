package com.bytedance.ai.bridge.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostImageDepend;", "", "chooseImage", "", "request", "Lcom/bytedance/ai/bridge/service/ChooseImageRequest;", "callback", "Lcom/bytedance/ai/bridge/service/ChooseImageCallback;", "previewImage", "Lcom/bytedance/ai/bridge/service/PreviewImageRequest;", "Lcom/bytedance/ai/bridge/service/PreviewImageCallback;", "saveImageToPhotosAlbum", "Lcom/bytedance/ai/bridge/service/SaveImageToPhotosAlbumRequest;", "Lcom/bytedance/ai/bridge/service/SaveImageCallback;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostImageDepend {
    void chooseImage(ChooseImageRequest r1, ChooseImageCallback r10);

    void previewImage(PreviewImageRequest r1, PreviewImageCallback r10);

    void saveImageToPhotosAlbum(SaveImageToPhotosAlbumRequest r1, SaveImageCallback r10);
}
