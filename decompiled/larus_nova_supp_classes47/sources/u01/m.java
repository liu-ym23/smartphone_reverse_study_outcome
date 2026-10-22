package u01;

import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.RevStreamSize;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.StreamSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements pc0.a {
    public final SeiAppData a;

    public final RevStreamSize a() {
        StreamSize r0 = this.a.getStreamSize();
        if (r0 != null) goto L5;
        return null;
    L5:
        RevStreamSize r1 = new RevStreamSize();
        r1.setW(r0.getW());
        r1.setH(r0.getH());
        r1.setX(r0.getX());
        r1.setY(r0.getY());
        r1.setGameRatio(r0.getGameRatio());
        return r1;
    }

    public final int b() {
        return this.a.getGameMixStreamType();
    }

    public final String c() {
        return this.a.getLayoutKey();
    }

    public final int d() {
        return this.a.getGameFullV2();
    }

    public final List<RevSeiRegion> e() {
        List r0 = this.a.getGrids();
        if (r0 == null) goto L10;
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        SeiRegion r4 = (SeiRegion) r3.next();
        Intrinsics.checkNotNullParameter(r4, "region");
        RevSeiRegion r5 = new RevSeiRegion();
        r5.setType(r4.getType());
        r5.setAccount(r4.getAccount().toString());
        r5.setAlpha(r4.getAlpha());
        r5.setWidth(r4.getWidth());
        r5.setHeight(r4.getHeight());
        r5.setX(r4.getX());
        r5.setY(r4.getY());
        r5.setZOrder(r4.getzOrder());
        r5.setStatus(r4.getStatus());
        r5.setUid(r4.getUid());
        r5.setUidStr(r4.uidStr);
        r5.setTalk(r4.talk);
        r5.setMuteAudio(r4.muteAudio);
        r5.setTalkVolume(r4.talkVolume);
        r5.setPosition(r4.position);
        r5.setLocal(r4.isLocal);
        r2.add(r5);
        goto L6
    L8:
        List<RevSeiRegion> r6 = CollectionsKt.toMutableList(r2);
        if (r6 == null) goto L10;
    L16:
        return r6;
    L10:
        r6 = new ArrayList();
        v r7 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r7 == null) goto L16;
        if (r7.e == true) goto L16;
        r7.e = true;
        r7.H("live_rev_miss_sei_grid", new LinkedHashMap());
        goto L16
    }

    public final q0 getCanvas() {
        SeiCanvas r0 = this.a.getCanvas();
        Intrinsics.checkNotNullParameter(r0, "canvas");
        q0 r1 = new q0();
        r1.c(r0.getBackground());
        r1.d(r0.getHeight());
        r1.e(r0.getWidth());
        return r1;
    }

    public final String getChannelId() {
        return this.a.getChannelId();
    }

    public final int getGameType() {
        return this.a.getGameType();
    }

    public final long getTimestamp() {
        return this.a.getTimestamp();
    }

    public final int getVersion() {
        return this.a.getVersion();
    }

    public m(SeiAppData r2) {
        Intrinsics.checkNotNullParameter(r2, "seiAppData");
        this.a = r2;
    }
}
