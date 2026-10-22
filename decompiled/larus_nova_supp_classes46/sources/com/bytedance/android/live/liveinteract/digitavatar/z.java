package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements com.bytedance.android.live.effect.api.q {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ EffectManager c;
    public final /* synthetic */ y.a d;

    public static final class a implements IFetchEffectListener {
        public final /* synthetic */ z a;

        public final void onStart(Effect r1) {
        }

        public a(z r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r4) {
            Effect r5 = (Effect) r4;
            if (r5 == null) goto L7;
            Sticker r6 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r5);
            y.a r0 = this.a.d;
            if (r0 == null) goto L9;
            r0.a(r6);
            return;
        L9:
            return;
        L7:
            this.a.c(new Exception("贴纸下载失败。[panel=" + this.a.b + ", stickId=" + this.a.a + ']'));
        }

        public final void onFail(Effect r3, ExceptionResult r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            z r5 = this.a;
            Exception r6 = r4.getException();
            if (r6 != null) goto L5;
            r6 = new Exception("贴纸下载失败。[panel=" + this.a.b + ", stickId=" + this.a.a + ']');
        L5:
            r5.c(r6);
        }
    }

    public final void b() {
        c(new Exception("贴纸sync失败。[panel=" + this.b + ", stickId=" + this.a + ']'));
    }

    public final void a(EffectChannelResponse r5) {
        Effect r0 = null;
        Object r1 = null;
        r0 = null;
        if (r5 == null) goto L13;
        List r6 = r5.getAllCategoryEffects();
        if (r6 == null) goto L13;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r2 = r7.next();
        if (Intrinsics.areEqual(((Effect) r2).getEffectId(), this.a) == false) goto L8;
        r1 = r2;
    L12:
        r0 = (Effect) r1;
    L13:
        if (r0 != null) goto L16;
        c(new Exception("在{" + this.b + "}中没有找到相应贴纸stickId=" + this.a));
        return;
    L16:
        if (DownloadableModelSupport.isInitialized() == false) goto L23;
        if (DownloadableModelSupport.getInstance().isEffectReady(this.c, r0) == false) goto L23;
        ALogger.i("KtvDigitAvatar", "DownloadableModelSupport isEffectReady=true. stickerId=" + this.a);
        Sticker r8 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r0);
        y.a r3 = this.d;
        if (r3 == null) goto L35;
        r3.a(r8);
        return;
    L35:
        return;
    L23:
        if (DownloadableModelSupport.isInitialized() == false) goto L25;
    L29:
        this.c.fetchEffect(r0, new a(this));
        return;
    L25:
        if (this.c.isEffectDownloaded(r0) == false) goto L29;
        Sticker r9 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r0);
        y.a r4 = this.d;
        if (r4 == null) goto L37;
        r4.a(r9);
        return;
    }

    public final void c(Exception r14) {
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "stickerId");
        Intrinsics.checkNotNullParameter(r14, "e");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("sticker_id", r1);
        r3.put("exception", r14.toString());
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("digit_avatar_sticker_download_fail", r3);
        TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
        String r4 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "stickerId");
        Intrinsics.checkNotNullParameter(r14, "e");
        JSONObject r8 = new JSONObject();
        r8.put("sticker_id", r4);
        r8.put("exception", r14.toString());
        nd0.c.o(nd0.c.a, LinkMonitorData.AvatarStickerDownloaderFailMonitorData, r8, 0, null, false, 28);
        y.a r5 = this.d;
        if (r5 == null) goto L6;
        r5.onError(r14);
        return;
    }

    public z(String r1, EffectManager r2, y.a r3) {
        this.a = r1;
        this.b = "livedigitavatar";
        this.c = r2;
        this.d = r3;
    }
}
