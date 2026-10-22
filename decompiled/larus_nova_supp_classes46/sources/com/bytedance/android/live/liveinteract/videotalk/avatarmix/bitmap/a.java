package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.MicseatType;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final ConcurrentHashMap<String, Pair<String, Bitmap>> a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a$a, reason: collision with other inner class name */
    public static final class C0097a {
        public static String a(d r5) {
            Intrinsics.checkNotNullParameter(r5, "struct");
            if (r5.getType() != MicseatType.Empty) goto L6;
            return "e_" + r5.d.f + '_' + r5.d.g;
        L6:
            return r5.a + '_' + r5.d.f + '_' + r5.d.g;
        }
    }

    static {
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }
}
