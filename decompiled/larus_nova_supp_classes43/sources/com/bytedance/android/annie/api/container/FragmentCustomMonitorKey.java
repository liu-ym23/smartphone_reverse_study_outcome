package com.bytedance.android.annie.api.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/api/container/FragmentCustomMonitorKey;", "", "IsPrerender", "IsContainerPreload", "IsUserOpen", "RealOpenTime", "HasReload", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum FragmentCustomMonitorKey extends Enum<FragmentCustomMonitorKey> {
    public static final FragmentCustomMonitorKey HasReload = null;
    public static final FragmentCustomMonitorKey IsContainerPreload = null;
    public static final FragmentCustomMonitorKey IsPrerender = null;
    public static final FragmentCustomMonitorKey IsUserOpen = null;
    public static final FragmentCustomMonitorKey RealOpenTime = null;
    public static final /* synthetic */ FragmentCustomMonitorKey[] a = null;

    public static FragmentCustomMonitorKey valueOf(String r1) {
        return (FragmentCustomMonitorKey) a.a(FragmentCustomMonitorKey.class, r1);
    }

    public static FragmentCustomMonitorKey[] values() {
        return (FragmentCustomMonitorKey[]) a.clone();
    }

    static {
        FragmentCustomMonitorKey r0 = new FragmentCustomMonitorKey("IsPrerender", 0);
        IsPrerender = r0;
        FragmentCustomMonitorKey r1 = new FragmentCustomMonitorKey("IsContainerPreload", 1);
        IsContainerPreload = r1;
        FragmentCustomMonitorKey r10 = new FragmentCustomMonitorKey("IsUserOpen", 2);
        IsUserOpen = r10;
        FragmentCustomMonitorKey r11 = new FragmentCustomMonitorKey("RealOpenTime", 3);
        RealOpenTime = r11;
        FragmentCustomMonitorKey r12 = new FragmentCustomMonitorKey("HasReload", 4);
        HasReload = r12;
        a = new FragmentCustomMonitorKey[]{r0, r1, r10, r11, r12};
    }

    public FragmentCustomMonitorKey(String r1, int r10) {
        super(r1, r10);
    }
}
