package com.bytedance.android.live.liveinteract.api;

import com.bytedance.android.livesdkapi.model.SeiRegion;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/PkLayoutData;", "", "marginTop", "", "width", "height", "(III)V", "getHeight", "()I", "getMarginTop", "region", "Lcom/bytedance/android/livesdkapi/model/SeiRegion;", "getRegion", "()Lcom/bytedance/android/livesdkapi/model/SeiRegion;", "setRegion", "(Lcom/bytedance/android/livesdkapi/model/SeiRegion;)V", "getWidth", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkLayoutData {
    private final int height;
    private final int marginTop;
    private SeiRegion region;
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final SeiRegion getRegion() {
        return this.region;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setRegion(SeiRegion r1) {
        this.region = r1;
    }

    public PkLayoutData(int r1, int r2, int r3) {
        this.marginTop = r1;
        this.width = r2;
        this.height = r3;
    }
}
