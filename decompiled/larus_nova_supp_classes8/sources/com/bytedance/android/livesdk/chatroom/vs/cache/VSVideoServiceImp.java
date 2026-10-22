package com.bytedance.android.livesdk.chatroom.vs.cache;

import com.bytedance.android.livesdk.config.ey0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.android.livesdkapi.service.vs.IVSVideoService;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lm1.a;
import nm1.e;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/cache/VSVideoServiceImp;", "Lcom/bytedance/android/livesdkapi/service/vs/IVSVideoService;", "()V", "deleteCache", "", "videoId", "", "enablePreviewPortraitFullScreen", "", "()Ljava/lang/Boolean;", "getCachedVideoId", "episodeId", "", "getLocalVideoPath", "", "Lkotlin/Pair;", "isLocalVideoVertical", "(Ljava/lang/String;)Ljava/lang/Boolean;", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSVideoServiceImp implements IVSVideoService {
    public VSVideoServiceImp() {
        k.l(IVSVideoService.class, this);
        k.l(IVSHistoryProgressService.class, new VSHistoryProgressServiceImp());
    }

    public Boolean enablePreviewPortraitFullScreen() {
        if (PadConfigUtils.c() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        return Boolean.valueOf(r0);
    L5:
        if (ey0.a.getValue().booleanValue() == false) goto L7;
        r0 = true;
        goto L9
    }

    public void deleteCache(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoId");
        e r0 = f.c();
        if (r0 == null) goto L8;
        a r1 = r0.c();
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    public String getCachedVideoId(long r2) {
        e r0 = f.c();
        if (r0 == null) goto L7;
        a r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.getCachedVideoId(r2);
    L7:
        return null;
    }

    public Map<String, Pair<String, String>> getLocalVideoPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoId");
        e r0 = f.c();
        if (r0 == null) goto L7;
        a r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.getLocalVideoPath(r2);
    L7:
        return null;
    }

    public Boolean isLocalVideoVertical(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoId");
        e r0 = f.c();
        if (r0 == null) goto L7;
        a r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.b(r2);
    L7:
        return null;
    }
}
