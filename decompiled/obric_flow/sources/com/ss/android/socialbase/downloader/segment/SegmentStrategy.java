package com.ss.android.socialbase.downloader.segment;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SegmentStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f16086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16087b;

    public SegmentStrategy(JSONObject r5) {
        this.f16086a = r5;
    }

    public final void a(int r10) {
        int r5 = this.f16086a.optInt("thread_count", 4);
        if (r5 <= 16) goto L6;
        r5 = 16;
    L6:
        if (r5 > 0) goto L12;
        if (this.f16086a.optInt("url_balance", 2) > 0) goto L15;
        r10 = 1;
    L15:
        this.f16087b = r10;
        return;
    L12:
        if (this.f16086a.optInt("url_balance", 2) != 1) goto L14;
        r10 = Math.min(r5, r10);
        goto L15
    L14:
        r10 = r5;
        goto L15
    }
}
