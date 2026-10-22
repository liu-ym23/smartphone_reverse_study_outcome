package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/utils/ExternalRedirectPromptFrequencyConfig;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "FIRST_USE_ONLY", "EACH_DOMAIN", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalRedirectPromptFrequencyConfig extends Enum<ExternalRedirectPromptFrequencyConfig> {
    public static final ExternalRedirectPromptFrequencyConfig EACH_DOMAIN = null;
    public static final ExternalRedirectPromptFrequencyConfig FIRST_USE_ONLY = null;
    public static final ExternalRedirectPromptFrequencyConfig NEVER = null;
    public static final /* synthetic */ ExternalRedirectPromptFrequencyConfig[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalRedirectPromptFrequencyConfig> getEntries() {
        return b;
    }

    static {
        ExternalRedirectPromptFrequencyConfig r0 = new ExternalRedirectPromptFrequencyConfig("NEVER", 0);
        NEVER = r0;
        ExternalRedirectPromptFrequencyConfig r1 = new ExternalRedirectPromptFrequencyConfig("FIRST_USE_ONLY", 1);
        FIRST_USE_ONLY = r1;
        ExternalRedirectPromptFrequencyConfig r3 = new ExternalRedirectPromptFrequencyConfig("EACH_DOMAIN", 2);
        EACH_DOMAIN = r3;
        ExternalRedirectPromptFrequencyConfig[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ExternalRedirectPromptFrequencyConfig[] values() {
        return (ExternalRedirectPromptFrequencyConfig[]) a.clone();
    }

    public static ExternalRedirectPromptFrequencyConfig valueOf(String r1) {
        return (ExternalRedirectPromptFrequencyConfig) r27.a.a(ExternalRedirectPromptFrequencyConfig.class, r1);
    }

    public ExternalRedirectPromptFrequencyConfig(String r1, int r2) {
        super(r1, r2);
    }
}
