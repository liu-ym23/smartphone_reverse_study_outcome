package com.obric.memorydata.memory.ui.detail;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerDoubleTapZoomPolicy;", "", "<init>", "()V", "ORIGINAL_SCALE_TOLERANCE", "", "targetScale", "currentScale", "originalScale", "zoomedScale", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10858a = null;

    static {
        f10858a = new i();
    }

    private i() {
    }

    public final float a(float r1, float r2, float r3) {
        if (r1 <= (1.01f * r2)) goto L5;
        return r2;
    L5:
        return r3;
    }
}
