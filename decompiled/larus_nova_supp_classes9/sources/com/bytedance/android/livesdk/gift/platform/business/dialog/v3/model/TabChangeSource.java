package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/TabChangeSource;", BuildConfig.FLAVOR, "Default", "Click", "Slide", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabChangeSource extends Enum<TabChangeSource> {
    public static final TabChangeSource Click = null;
    public static final TabChangeSource Default = null;
    public static final TabChangeSource Slide = null;
    public static final /* synthetic */ TabChangeSource[] a = null;

    static {
        TabChangeSource r1 = new TabChangeSource("Default", 0);
        Default = r1;
        TabChangeSource r2 = new TabChangeSource("Click", 1);
        Click = r2;
        TabChangeSource r3 = new TabChangeSource("Slide", 2);
        Slide = r3;
        a = new TabChangeSource[]{r1, r2, r3};
    }

    public static TabChangeSource valueOf(String r1) {
        return (TabChangeSource) a.a(TabChangeSource.class, r1);
    }

    public static TabChangeSource[] values() {
        return (TabChangeSource[]) a.clone();
    }

    public TabChangeSource(String r1, int r2) {
        super(r1, r2);
    }
}
