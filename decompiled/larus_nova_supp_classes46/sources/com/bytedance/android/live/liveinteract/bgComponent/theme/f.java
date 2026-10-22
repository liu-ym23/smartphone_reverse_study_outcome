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
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends AbsDownloadListener {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Ref.ObjectRef b;

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
        if (Intrinsics.areEqual(r1.getKey(), (String) this.b.element) == false) goto L8;
        r0.put(r1.getKey(), r1.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.b.remove((String) this.b.element);
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

    public f(Ref.ObjectRef r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r5, BaseException r6) {
        super.onFailed(r5, r6);
        ALogger.e("VoiceLiveTheme", "download theme video error:" + ((String) this.a.element));
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getUrl() == null) goto L35;
        HashMap<String, VideoThemeDownloadManager.a> r7 = VideoThemeDownloadManager.b;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<String, VideoThemeDownloadManager.a> r1 = r8.next();
        if (Intrinsics.areEqual(r1.getKey(), (String) this.b.element) == false) goto L8;
        r0.put(r1.getKey(), r1.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.b.remove((String) this.b.element);
        Iterator r9 = r0.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L36;
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r2 = ((VideoThemeDownloadManager.a) ((Map.Entry) r9.next()).getValue()).b.iterator();
    L17:
        if (r2.hasNext() == false) goto L14;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r3 = r2.next().get();
        if (r3 == null) goto L17;
        if (r6 == null) goto L22;
        r6.getErrorMessage();
    L22:
        r3.b();
        goto L17
    L36:
        return;
    }
}
