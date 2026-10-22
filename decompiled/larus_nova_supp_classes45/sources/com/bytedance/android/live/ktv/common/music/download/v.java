package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a() {
            return KtvCommonConfigParams.a() + File.separator + "musicPack";
        }
    }

    static {
    }

    public v() {
    }

    public abstract String a(KtvMusic r1);

    public abstract String b(KtvMusic r1);

    public abstract String c(KtvMusic r1);

    public abstract String getType();
}
