package com.bytedance.android.live.openplatform.impl.base.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource", "", "Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource;", "", "value", "J", "getValue", "()J", "Panel", "Scan", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenPlatformConstants$LaunchSource extends Enum<OpenPlatformConstants$LaunchSource> {
    public static final OpenPlatformConstants$LaunchSource Panel = null;
    public static final OpenPlatformConstants$LaunchSource Scan = null;
    public static final /* synthetic */ OpenPlatformConstants$LaunchSource[] a = null;
    private final long value;

    static {
        OpenPlatformConstants$LaunchSource r1 = new OpenPlatformConstants$LaunchSource("Panel", 0, 1);
        Panel = r1;
        OpenPlatformConstants$LaunchSource r2 = new OpenPlatformConstants$LaunchSource("Scan", 1, 2);
        Scan = r2;
        a = new OpenPlatformConstants$LaunchSource[]{r1, r2};
    }

    public static OpenPlatformConstants$LaunchSource valueOf(String r1) {
        return (OpenPlatformConstants$LaunchSource) a.a(OpenPlatformConstants$LaunchSource.class, r1);
    }

    public static OpenPlatformConstants$LaunchSource[] values() {
        return (OpenPlatformConstants$LaunchSource[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public OpenPlatformConstants$LaunchSource(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
