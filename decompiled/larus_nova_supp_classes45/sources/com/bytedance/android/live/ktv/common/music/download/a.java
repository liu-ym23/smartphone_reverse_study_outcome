package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return "accompaniment_track";
    }

    public a() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r5) {
        Intrinsics.checkNotNullParameter(r5, "music");
        AudioInfo r6 = r5.getMAccompanimentTrack();
        if (r6 == null) goto L5;
        long r0 = r6.getMAudioId();
    L7:
        if (r0 > 0) goto L11;
        return "";
    L11:
        return "accompaniment_" + r0;
    L5:
        r0 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r6) {
        Intrinsics.checkNotNullParameter(r6, "music");
        AudioInfo r0 = r6.getMAccompanimentTrack();
        if (r0 == null) goto L6;
        String r1 = r0.getFileHash();
        if (r1 == null) goto L6;
    L7:
        StringBuilder r2 = new StringBuilder(KtvCommonConfigParams.a());
        String r3 = File.separator;
        r2.append(r3);
        r2.append("musicPack");
        r2.append(r3);
        r2.append(r6.getMId());
        r2.append(r3);
        r2.append("accompaniment");
        r2.append(r3);
        if (r1.length() <= 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L14;
        r2.append(r1);
        r2.append(r3);
    L14:
        return r2.toString();
    L10:
        r7 = false;
    L6:
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        AudioInfo r3 = r2.getMAccompanimentTrack();
        if (r3 == null) goto L6;
        String r4 = r3.getMUrl();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }
}
