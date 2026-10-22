package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u extends v {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.MIDI;
    }

    public u() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r8) {
        Intrinsics.checkNotNullParameter(r8, "music");
        String r9 = r8.getMidiUrl();
        if (r9 == null) goto L17;
        Integer r0 = Integer.valueOf(StringsKt.lastIndexOf$default(r9, "/", 0, false, 6, null));
        int r1 = r0.intValue();
        if (r1 > (-1)) goto L7;
    L9:
        boolean r2 = false;
    L10:
        String r3 = null;
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L16;
        r3 = r9.substring(r0.intValue() + 1);
    L16:
        if (r3 == null) goto L17;
        return r3;
    L7:
        if (r1 >= r9.length()) goto L9;
        r2 = true;
    L17:
        return "";
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
        r0.append(KtvSubElement.MIDI);
        r0.append(r1);
        return r0.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        String r3 = r2.getMidiUrl();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }
}
