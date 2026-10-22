package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingsSubPageType;", "", "path", "", "allowNonDefaultAssistantEntry", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getPath", "()Ljava/lang/String;", "getAllowNonDefaultAssistantEntry", "()Z", "MEMORY_SETTINGS", "ACCESSARY_SETTINGS", "PRIVACY_MODEL_TRAINING", "VOICE_PRINT_MANAGEMENT", "OBRIC_ABOUT_APP", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSettingsSubPageType extends Enum<ObricSettingsSubPageType> {
    public static final ObricSettingsSubPageType ACCESSARY_SETTINGS = null;
    public static final a Companion = null;
    public static final ObricSettingsSubPageType MEMORY_SETTINGS = null;
    public static final ObricSettingsSubPageType OBRIC_ABOUT_APP = null;
    public static final ObricSettingsSubPageType PRIVACY_MODEL_TRAINING = null;
    public static final ObricSettingsSubPageType VOICE_PRINT_MANAGEMENT = null;
    public static final /* synthetic */ ObricSettingsSubPageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean allowNonDefaultAssistantEntry;
    private final String path;

    public static EnumEntries<ObricSettingsSubPageType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.settings.ObricSettingsSubPageType$a] */
    static {
        ObricSettingsSubPageType r7 = new ObricSettingsSubPageType("MEMORY_SETTINGS", 0, "memory_settings", false, 2, null);
        MEMORY_SETTINGS = r7;
        ObricSettingsSubPageType r0 = new ObricSettingsSubPageType("ACCESSARY_SETTINGS", 1, "accessary_settings", true);
        ACCESSARY_SETTINGS = r0;
        ObricSettingsSubPageType r1 = new ObricSettingsSubPageType("PRIVACY_MODEL_TRAINING", 2, "privacy_model_training", false, 2, null);
        PRIVACY_MODEL_TRAINING = r1;
        ObricSettingsSubPageType r3 = new ObricSettingsSubPageType("VOICE_PRINT_MANAGEMENT", 3, "voice_print_management", false, 2, null);
        VOICE_PRINT_MANAGEMENT = r3;
        ObricSettingsSubPageType r4 = new ObricSettingsSubPageType("OBRIC_ABOUT_APP", 4, "obric_about_app", false, 2, null);
        OBRIC_ABOUT_APP = r4;
        ObricSettingsSubPageType[] r5 = {r7, r0, r1, r3, r4};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ObricSettingsSubPageType[] values() {
        return (ObricSettingsSubPageType[]) a.clone();
    }

    public final boolean getAllowNonDefaultAssistantEntry() {
        return this.allowNonDefaultAssistantEntry;
    }

    public final String getPath() {
        return this.path;
    }

    public static ObricSettingsSubPageType valueOf(String r1) {
        return (ObricSettingsSubPageType) r27.a.a(ObricSettingsSubPageType.class, r1);
    }

    public ObricSettingsSubPageType(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.path = r3;
        this.allowNonDefaultAssistantEntry = r4;
    }

    public /* synthetic */ ObricSettingsSubPageType(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }
}
