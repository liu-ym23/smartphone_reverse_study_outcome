package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/VideoPlaybackSamplingPolicy;", "", "<init>", "()V", "startDisallowReason", "", "event", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleEvent;", "foregroundPackageMatches", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12582a = null;

    static {
        f12582a = new l();
    }

    private l() {
    }

    public static /* synthetic */ String a(l r0, a r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    public final String a(a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if (Intrinsics.areEqual(r1.b(), "media_codec_resume") == true) goto L8;
        if (Intrinsics.areEqual(r1.b(), "media_codec_start") == true) goto L8;
        return "not_resume";
    L8:
        if (r1.g() == false) goto L11;
        return "encoder";
    L11:
        if (r1.h() == true) goto L13;
        return "not_use_surface";
    L13:
        return null;
    }
}
