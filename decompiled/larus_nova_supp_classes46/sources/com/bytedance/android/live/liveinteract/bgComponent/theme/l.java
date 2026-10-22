package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveThemeListResponse;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public l(j r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        VoiceLiveThemeListResponse r0 = (VoiceLiveThemeListResponse) r8.data;
        if (r0 == null) goto L5;
        List r1 = r0.themeList;
    L6:
        List r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        ALogger.e("VoiceLiveTheme", "theme list is empty");
        int r9 = com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a;
        com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, new Exception("theme list is empty"));
        return;
    L15:
        VoiceLiveThemeListResponse r4 = (VoiceLiveThemeListResponse) r8.data;
        if (r4 == null) goto L18;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.success.bgType:" + this.b + ",roomId:" + this.c + ",preChoice:" + r4.lastThemeKey + ",ugc:" + r4.ugcAvailable + ",imgType:" + String.valueOf(r4.imageType) + ",animType:" + String.valueOf(r4.animatedType) + ",list:" + r4.themeList);
    L18:
        j.t(this.a, (VoiceLiveThemeListResponse) r8.data, this.b);
        com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(true, null);
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
