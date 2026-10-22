package com.bytedance.android.livesdk.interactivity.medialink.widget.mixer;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.pd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import ti6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MediaLinkSeiCreator {
    public final a a;
    public long b;
    public List<f> c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegionComparePolicy {
    }

    public interface a {
        boolean a(f r1, f r2);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.MediaLinkSeiCreator.a
        public final boolean a(f r7, f r8) {
            if (r7 == null) goto L24;
            if (r8 != null) goto L7;
            return false;
        L7:
            if (TextUtils.equals(r7.b, r8.b) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(r7.c, r8.c) == true) goto L11;
            return false;
        L11:
            if (r7.d == r8.d) goto L13;
            return false;
        L13:
            if (r7.e == r8.e) goto L15;
            return false;
        L15:
            if (r7.f == r8.f) goto L17;
            return false;
        L17:
            if (r7.g == r8.g) goto L19;
            return false;
        L19:
            if (r7.i == r8.i) goto L21;
            return false;
        L21:
            if (r7.m != r8.m) goto L32;
            return true;
        L32:
            return false;
        L24:
            return false;
        }
    }

    static {
        ((Float) pd1.a.getValue()).floatValue();
    }

    public MediaLinkSeiCreator() {
        this.b = 0;
        this.c = new ArrayList();
        this.a = new b();
    }
}
