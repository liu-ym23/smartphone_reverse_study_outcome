package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f4401c;
    public final PreloadType d;
    public final Map e;

    public r(u r5, PreloadType r10, Map r11) {
        this.f4401c = r5;
        this.d = r10;
        this.e = r11;
    }

    public r(PreloadType r5, Map r10) {
        NetWorker r11 = NetWorker.f4465a;
        this(null, r5, r10);
    }
}
