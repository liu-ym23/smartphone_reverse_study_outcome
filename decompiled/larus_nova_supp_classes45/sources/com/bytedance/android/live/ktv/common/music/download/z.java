package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends v {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return "vocal";
    }

    public z() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r11) {
        Intrinsics.checkNotNullParameter(r11, "music");
        String r12 = r11.getVocalUrl();     // Catch: Exception -> L15
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        int r7 = StringsKt.lastIndexOf$default(r12, '/', 0, false, 6, null);     // Catch: Exception -> L15
        if (r7 != (-1)) goto L9;
        return "";
    L9:
        int r1 = StringsKt.lastIndexOf$default(r12, '/', r7 - 1, false, 4, null);     // Catch: Exception -> L15
        if (r1 == (-1)) goto L18;
        if (r1 >= r7) goto L19;
        return r12.substring(r1 + 1, r7);
    L19:
        return "";
    L18:
        return "";
    L20:
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
        r0.append("vocal");
        r0.append(r1);
        return r0.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        String r3 = r2.getVocalUrl();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }
}
