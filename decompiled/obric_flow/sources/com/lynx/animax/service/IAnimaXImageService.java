package com.lynx.animax.service;

import androidx.annotation.Keep;
import com.lynx.animax.loader.IAnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.IAnimaXLoaderRequest;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IAnimaXImageService extends IAnimaXService {
    boolean loadImage(IAnimaXLoaderRequest r5, IAnimaXLoaderCompletionHandler r10);
}
