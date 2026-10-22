package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveThemeListResponse;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;
    public final /* synthetic */ Function2 f;

    public n(j r1, long r2, int r4, long r5, Function2 r7) {
        this.a = r1;
        this.b = 5;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }

    public final void accept(Object r10) {
        Response r11 = (Response) r10;
        VoiceLiveThemeListResponse r0 = (VoiceLiveThemeListResponse) r11.data;
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
        int r12 = com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a;
        com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, new Exception("theme list is empty"));
        return;
    L15:
        VoiceLiveThemeListResponse r4 = (VoiceLiveThemeListResponse) r11.data;
        if (r4 == null) goto L29;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.success;; imageType == " + this.b + " ;; playMode == " + this.c + " ;; bgType:" + this.d + ",roomId:" + this.e + ",preChoice:" + r4.lastThemeKey + ",ugc:" + r4.ugcAvailable + ",imgType:" + String.valueOf(r4.imageType) + ",animType:" + String.valueOf(r4.animatedType) + ",list:" + r4.themeList);
        if (this.d != 100) goto L29;
        if (this.c != 36) goto L29;
        if (this.b != 5) goto L29;
        List r5 = r4.themeList;
        if (r5 == null) goto L29;
        Iterator<T> r6 = r5.iterator();
    L27:
        if (r6.hasNext() == false) goto L29;
        ((IVoiceLiveTheme) r6.next()).setBgType(100);
    L29:
        j.t(this.a, (VoiceLiveThemeListResponse) r11.data, this.d);
        Function2 r7 = this.f;
        if (r7 == null) goto L32;
        Unit r13 = (Unit) r7.invoke(((VoiceLiveThemeListResponse) r11.data).themeList, Boolean.TRUE);
    L32:
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
