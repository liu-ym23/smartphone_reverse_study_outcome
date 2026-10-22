package com.ss.android.lark.chameleon.pluginapi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginId;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TitleBarPlugin", "LoadingPlugin", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChameleonPluginId extends Enum<ChameleonPluginId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ChameleonPluginId[] $VALUES = null;
    public static final ChameleonPluginId LoadingPlugin = null;
    public static final ChameleonPluginId TitleBarPlugin = null;
    private final String value;

    private static final /* synthetic */ ChameleonPluginId[] $values() {
        return new ChameleonPluginId[]{TitleBarPlugin, LoadingPlugin};
    }

    public static EnumEntries<ChameleonPluginId> getEntries() {
        return $ENTRIES;
    }

    static {
        TitleBarPlugin = new ChameleonPluginId("TitleBarPlugin", 0, "biz.titlebar.plugin");
        LoadingPlugin = new ChameleonPluginId("LoadingPlugin", 1, "biz.loading.plugin");
        ChameleonPluginId[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ChameleonPluginId[] values() {
        return (ChameleonPluginId[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ChameleonPluginId valueOf(String r1) {
        return (ChameleonPluginId) a.a(ChameleonPluginId.class, r1);
    }

    private ChameleonPluginId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
