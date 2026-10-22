package com.larus.settings.provider.applet;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/settings/provider/applet/FirstPartyApplicationConfig;", "Ljava/io/Serializable;", "musicApplicationPluginId", "", "<init>", "(Ljava/lang/String;)V", "getMusicApplicationPluginId", "()Ljava/lang/String;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FirstPartyApplicationConfig implements Serializable {

    @SerializedName("music")
    private final String musicApplicationPluginId;

    public FirstPartyApplicationConfig() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public final String getMusicApplicationPluginId() {
        return this.musicApplicationPluginId;
    }

    public FirstPartyApplicationConfig(String r1) {
        this.musicApplicationPluginId = r1;
    }

    public /* synthetic */ FirstPartyApplicationConfig(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "7331662806040789032";
    L5:
        this(r1);
    }
}
