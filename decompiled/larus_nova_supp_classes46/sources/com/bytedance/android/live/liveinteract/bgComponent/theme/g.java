package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends AbsDownloadListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public final void onSuccessed(DownloadInfo r5) {
        super.onSuccessed(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getUrl() == null) goto L33;
        HashMap<String, VideoThemeDownloadManager.a> r6 = VideoThemeDownloadManager.b;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Map.Entry<String, VideoThemeDownloadManager.a> r1 = r7.next();
        if (Intrinsics.areEqual(r1.getKey(), this.b) == false) goto L8;
        r0.put(r1.getKey(), r1.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.b.remove(this.b);
        Iterator r8 = r0.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L34;
        Map.Entry r2 = (Map.Entry) r8.next();
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r3 = ((VideoThemeDownloadManager.a) r2.getValue()).b.iterator();
    L17:
        if (r3.hasNext() == false) goto L14;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r4 = r3.next().get();
        if (r4 == null) goto L17;
        Lazy r9 = VideoThemeDownloadManager.a;
        r4.a(VideoThemeDownloadManager.d(((VideoThemeDownloadManager.a) r2.getValue()).a));
        goto L17
    L34:
        return;
    }

    public g(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r5, BaseException r6) {
        super.onFailed(r5, r6);
        StringBuilder r0 = new StringBuilder("download theme video error:");
        r0.append(this.a);
        r0.append("  ");
        if (r6 == null) goto L5;
        String r1 = r6.getMessage();
    L6:
        r0.append(r1);
        ALogger.e("VoiceLiveTheme", r0.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.getUrl() == null) goto L39;
        HashMap<String, VideoThemeDownloadManager.a> r7 = VideoThemeDownloadManager.b;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r8 = r7.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Map.Entry<String, VideoThemeDownloadManager.a> r3 = r8.next();
        if (Intrinsics.areEqual(r3.getKey(), this.b) == false) goto L12;
        r2.put(r3.getKey(), r3.getValue());
        goto L12
    L16:
        VideoThemeDownloadManager.b.remove(this.b);
        Iterator r9 = r2.entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L40;
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r4 = ((VideoThemeDownloadManager.a) ((Map.Entry) r9.next()).getValue()).b.iterator();
    L21:
        if (r4.hasNext() == false) goto L18;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r10 = r4.next().get();
        if (r10 == null) goto L21;
        if (r6 == null) goto L26;
        r6.getErrorMessage();
    L26:
        r10.b();
        goto L21
    L40:
        return;
    L39:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
