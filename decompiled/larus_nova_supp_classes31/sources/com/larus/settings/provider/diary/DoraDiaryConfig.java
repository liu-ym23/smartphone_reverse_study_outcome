package com.larus.settings.provider.diary;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/settings/provider/diary/DoraDiaryConfig;", "", "topbarShowEnvAuth", "", "doraDiaryWidgetUpdateInterval", "", "<init>", "(ZI)V", "getTopbarShowEnvAuth", "()Z", "getDoraDiaryWidgetUpdateInterval", "()I", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DoraDiaryConfig {

    @SerializedName("dora_diary_widget_update_interval")
    private final int doraDiaryWidgetUpdateInterval;

    @SerializedName("topbar_show_env_auth")
    private final boolean topbarShowEnvAuth;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraDiaryConfig() {
        boolean r2 = false;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public final int getDoraDiaryWidgetUpdateInterval() {
        return this.doraDiaryWidgetUpdateInterval;
    }

    public final boolean getTopbarShowEnvAuth() {
        return this.topbarShowEnvAuth;
    }

    public DoraDiaryConfig(boolean r1, int r2) {
        this.topbarShowEnvAuth = r1;
        this.doraDiaryWidgetUpdateInterval = r2;
    }

    public /* synthetic */ DoraDiaryConfig(boolean r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 1800;
    L8:
        this(r1, r2);
    }
}
