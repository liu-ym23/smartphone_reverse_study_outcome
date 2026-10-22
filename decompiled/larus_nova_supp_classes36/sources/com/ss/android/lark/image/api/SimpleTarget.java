package com.ss.android.lark.image.api;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Util;
import rkb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SimpleTarget<R> implements Target<R> {
    private final int height;
    private Request originRequest;
    private f request;
    private final int width;

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadCleared(Drawable r1) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadFailed(Drawable r1) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onLoadStarted(Drawable r1) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void onResourceReady(R r1) {
    }

    @Override // com.ss.android.lark.image.api.Target
    public void removeCallback(SizeReadyCallback r1) {
    }

    public SimpleTarget() {
        this(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    @Override // com.ss.android.lark.image.api.Target
    public Request getOriginRequest() {
        return this.originRequest;
    }

    @Override // com.ss.android.lark.image.api.Target
    public f getRequest() {
        return this.request;
    }

    @Override // com.ss.android.lark.image.api.Target
    public final void getSize(SizeReadyCallback r3) {
        if (Util.isValidDimensions(this.width, this.height) == false) goto L7;
        r3.onSizeReady(this.width, this.height);
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.ss.android.lark.image.api.Target
    public void setOriginRequest(Request r1) {
        this.originRequest = r1;
    }

    @Override // com.ss.android.lark.image.api.Target
    public void setRequest(f r1) {
        this.request = r1;
    }

    public SimpleTarget(int r1, int r2) {
        this.width = r1;
        this.height = r2;
    }
}
