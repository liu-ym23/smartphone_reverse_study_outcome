package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return "song";
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r9) {
        Intrinsics.checkNotNullParameter(r9, "music");
        String r0 = r9.getMSongUrl();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        int r2 = StringsKt.lastIndexOf$default(r0, ".", 0, false, 6, null);
        if (r2 != (-1)) goto L8;
        return "";
    L8:
        return "" + r9.getMId() + r0.substring(r2);
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r5) {
        Intrinsics.checkNotNullParameter(r5, "music");
        StringBuilder r0 = new StringBuilder(KtvCommonConfigParams.a());
        String r1 = File.separator;
        r0.append(r1);
        r0.append("musicPack");
        r0.append(r1);
        r0.append(r5.getMId());
        r0.append(r1);
        r0.append("song");
        r0.append(r1);
        return r0.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        String r3 = r2.getMSongUrl();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }
}
