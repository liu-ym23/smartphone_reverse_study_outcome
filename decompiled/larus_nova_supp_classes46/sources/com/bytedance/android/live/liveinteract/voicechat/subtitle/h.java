package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public h(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        pv0.c r6 = (pv0.c) r5;
        if (vm2.c.b().getGuestSubtitleFromRtc() == true) goto L30;
        String r7 = r6.a;
        if (((LinkmicSubtitleStatus) this.a.Aq().getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L25;
        if (r7 != null) goto L9;
        return;
    L9:
        if (StringsKt.contains$default(r7, "audio_subtitle", false, 2, null) != true) goto L27;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r7) == true) goto L13;
    L23:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r7);
        return;
    L13:
        if (vm2.d.u() == true) goto L15;
    L17:
        String r8 = JSONObjectProtectorUtils.getString(new JSONObject(JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r7), "audio_subtitle")), "subtitles");
        if (r8 != null) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a.h).get("subtitleEmpty"), Boolean.TRUE) == false) goto L22;
        this.a.h.put("subtitleEmpty", Boolean.FALSE);
        this.a.Eq();
    L22:
        List<nj0.g> r9 = g0.e(r8, this.a.Bq());
        this.a.er(r9);
        return;
    L15:
        if (g0.d(r7) == true) goto L17;
    L27:
        return;
    L25:
        return;
    }
}
