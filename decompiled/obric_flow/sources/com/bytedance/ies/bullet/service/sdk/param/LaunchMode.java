package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum LaunchMode extends Enum<LaunchMode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LaunchMode f6147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LaunchMode f6148c = null;
    public static final LaunchMode d = null;
    public static final LaunchMode e = null;
    public static final /* synthetic */ LaunchMode[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6149a;

    static {
        LaunchMode r5 = new LaunchMode("MODE_UNSPECIFIED", 0, "mode_unspecified");
        f6147b = r5;
        LaunchMode r10 = new LaunchMode("REMOVE_SAME_PAGE", 1, "remove_same_page");
        f6148c = r10;
        LaunchMode r11 = new LaunchMode("CLEAR_TOP", 2, "clear_top");
        d = r11;
        LaunchMode r12 = new LaunchMode("CLEAR_TOP_FLAG", 3, "clear_top_flag");
        e = r12;
        f = new LaunchMode[]{r5, r10, r11, r12};
    }

    public LaunchMode(String r5, int r10, String r11) {
        super(r5, r10);
        this.f6149a = r11;
    }

    public static LaunchMode valueOf(String r5) {
        return (LaunchMode) Enum.valueOf(LaunchMode.class, r5);
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) f.clone();
    }
}
