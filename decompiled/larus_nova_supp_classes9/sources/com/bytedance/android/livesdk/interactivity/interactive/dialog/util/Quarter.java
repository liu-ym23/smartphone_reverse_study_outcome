package com.bytedance.android.livesdk.interactivity.interactive.dialog.util;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/util/Quarter;", BuildConfig.FLAVOR, "LEFT_TOP", "LEFT_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Quarter extends Enum<Quarter> {
    public static final Quarter LEFT_BOTTOM = null;
    public static final Quarter LEFT_TOP = null;
    public static final Quarter RIGHT_BOTTOM = null;
    public static final Quarter RIGHT_TOP = null;
    public static final /* synthetic */ Quarter[] a = null;

    static {
        Quarter r1 = new Quarter("LEFT_TOP", 0);
        LEFT_TOP = r1;
        Quarter r2 = new Quarter("LEFT_BOTTOM", 1);
        LEFT_BOTTOM = r2;
        Quarter r3 = new Quarter("RIGHT_TOP", 2);
        RIGHT_TOP = r3;
        Quarter r4 = new Quarter("RIGHT_BOTTOM", 3);
        RIGHT_BOTTOM = r4;
        a = new Quarter[]{r1, r2, r3, r4};
    }

    public static Quarter valueOf(String r1) {
        return (Quarter) a.a(Quarter.class, r1);
    }

    public static Quarter[] values() {
        return (Quarter[]) a.clone();
    }

    public Quarter(String r1, int r2) {
        super(r1, r2);
    }
}
