package com.larus.dora.obric.device_management.setting.g.env_observe;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/env_observe/DoraObricGEnvObserveLightTitle;", "", "<init>", "(Ljava/lang/String;I)V", "WHITE", "YELLOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGEnvObserveLightTitle extends Enum<DoraObricGEnvObserveLightTitle> {
    public static final DoraObricGEnvObserveLightTitle WHITE = null;
    public static final DoraObricGEnvObserveLightTitle YELLOW = null;
    public static final /* synthetic */ DoraObricGEnvObserveLightTitle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGEnvObserveLightTitle> getEntries() {
        return b;
    }

    static {
        DoraObricGEnvObserveLightTitle r0 = new DoraObricGEnvObserveLightTitle("WHITE", 0);
        WHITE = r0;
        DoraObricGEnvObserveLightTitle r1 = new DoraObricGEnvObserveLightTitle("YELLOW", 1);
        YELLOW = r1;
        DoraObricGEnvObserveLightTitle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricGEnvObserveLightTitle[] values() {
        return (DoraObricGEnvObserveLightTitle[]) a.clone();
    }

    public static DoraObricGEnvObserveLightTitle valueOf(String r1) {
        return (DoraObricGEnvObserveLightTitle) r27.a.a(DoraObricGEnvObserveLightTitle.class, r1);
    }

    public DoraObricGEnvObserveLightTitle(String r1, int r2) {
        super(r1, r2);
    }
}
