package com.ss.android.lark.officesdk.di.core.deps.webview;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/webview/PlatformPluginVersion;", "", "versionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersionName", "()Ljava/lang/String;", "OVERLAY", "EMBED", "SANDWICH", "SANDWICH_EMBED", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PlatformPluginVersion extends Enum<PlatformPluginVersion> {
    public static final PlatformPluginVersion EMBED = null;
    public static final PlatformPluginVersion OVERLAY = null;
    public static final PlatformPluginVersion SANDWICH = null;
    public static final PlatformPluginVersion SANDWICH_EMBED = null;
    public static final /* synthetic */ PlatformPluginVersion[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String versionName;

    public static EnumEntries<PlatformPluginVersion> getEntries() {
        return b;
    }

    static {
        PlatformPluginVersion r0 = new PlatformPluginVersion("OVERLAY", 0, "overlay");
        OVERLAY = r0;
        PlatformPluginVersion r1 = new PlatformPluginVersion("EMBED", 1, "embed");
        EMBED = r1;
        PlatformPluginVersion r2 = new PlatformPluginVersion("SANDWICH", 2, "sandwich");
        SANDWICH = r2;
        PlatformPluginVersion r4 = new PlatformPluginVersion("SANDWICH_EMBED", 3, "sandwich_embed");
        SANDWICH_EMBED = r4;
        PlatformPluginVersion[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static PlatformPluginVersion[] values() {
        return (PlatformPluginVersion[]) a.clone();
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public static PlatformPluginVersion valueOf(String r1) {
        return (PlatformPluginVersion) a.a(PlatformPluginVersion.class, r1);
    }

    public PlatformPluginVersion(String r1, int r2, String r3) {
        super(r1, r2);
        this.versionName = r3;
    }
}
