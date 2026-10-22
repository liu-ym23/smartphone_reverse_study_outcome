package com.bytedance.android.livesdk.interactivity.medialink.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.config.ra0;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e92.b {
    public final e92.c a;
    public final int b;
    public final HashMap<Integer, Integer> c;
    public final CompositeDisposable d;
    public long e;
    public final Room f;
    public final MediaLinkControlPresenter g;

    @Override // e92.b
    public final void a() {
    }

    @Override // e92.b
    public final void onSeiUpdated(SeiAppData r18) {
        Integer r1 = this.c.get(Integer.valueOf(r18.getVersion()));
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L7:
        if (r2 <= this.b) goto L9;
        return;
    L9:
        this.c.put(Integer.valueOf(r18.getVersion()), Integer.valueOf(r2 + 1));
        if (r18.getVersion() == 19) goto L12;
    L26:
        HashMap r3 = new HashMap();
        r3.put("error_code", Integer.valueOf(r18.getVersion()));
        com.bytedance.android.live.liveinteract.api.utils.g.s("link_check_load", r3);
        return;
    L12:
        if (((Boolean) ra0.a.getValue()).booleanValue() == false) goto L26;
        if (r18.getChannelId() == null) goto L26;
        MediaLinkControlPresenter r4 = this.g;
        long r5 = CastLongProtector.parseLong(r18.getChannelId());
        if (((q46.b) r4).a == null) goto L25;
        long r6 = 0;
        if (r5 == 0) goto L25;
        Room r7 = r4.e;
        if (r7 == null) goto L24;
        r6 = r7.id;
    L24:
        ((SingleSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).getLinkAnchorList(r5, 2, 0, -1, 17, !r4.f, "multi_anchor_sei_back_up", r6).as(r4.e0())).subscribe(new b(r4), new c(r4));
    L25:
        ALogger.e("ttlive_link", "multiAnchorSeiBackup roomId:" + this.f.id + " channelId:" + r18.getChannelId());
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public a(Room r2, MediaLinkControlPresenter r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "presenter");
        this.f = r2;
        this.g = r3;
        this.a = new e92.c(this);
        this.b = 5;
        this.c = new HashMap();
        this.d = new CompositeDisposable();
    }
}
