package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/LiveTypeForMultiLink;", "", "Video", "Audio", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveTypeForMultiLink extends Enum<LiveTypeForMultiLink> {
    public static final LiveTypeForMultiLink Audio = null;
    public static final LiveTypeForMultiLink Video = null;
    public static final /* synthetic */ LiveTypeForMultiLink[] a = null;

    static {
        LiveTypeForMultiLink r1 = new LiveTypeForMultiLink("Video", 0);
        Video = r1;
        LiveTypeForMultiLink r2 = new LiveTypeForMultiLink("Audio", 1);
        Audio = r2;
        a = new LiveTypeForMultiLink[]{r1, r2};
    }

    public static LiveTypeForMultiLink valueOf(String r1) {
        return (LiveTypeForMultiLink) r27.a.a(LiveTypeForMultiLink.class, r1);
    }

    public static LiveTypeForMultiLink[] values() {
        return (LiveTypeForMultiLink[]) a.clone();
    }

    public LiveTypeForMultiLink(String r1, int r2) {
        super(r1, r2);
    }
}
