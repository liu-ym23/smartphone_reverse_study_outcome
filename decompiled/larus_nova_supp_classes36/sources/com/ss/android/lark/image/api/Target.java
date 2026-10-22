package com.ss.android.lark.image.api;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import rkb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface Target<R> {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getOriginRequest();

    f getRequest();

    void getSize(SizeReadyCallback r1);

    void onLoadCleared(Drawable r1);

    void onLoadFailed(Drawable r1);

    void onLoadStarted(Drawable r1);

    void onResourceReady(R r1);

    void removeCallback(SizeReadyCallback r1);

    void setOriginRequest(Request r1);

    void setRequest(f r1);
}
