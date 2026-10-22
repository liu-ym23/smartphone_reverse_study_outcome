package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        return "";
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        return "";
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.MV;
    }

    public y() {
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
        r0.append(FileUtils.VIDEO);
        r0.append(r1);
        return r0.toString();
    }
}
