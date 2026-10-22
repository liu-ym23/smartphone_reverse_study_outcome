package com.ss.android.lark.chameleon.pluginapi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/WebviewStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Attached", "Visible", "Hidden", "Detached", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebviewStatus extends Enum<WebviewStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WebviewStatus[] $VALUES = null;
    public static final WebviewStatus Attached = null;
    public static final WebviewStatus Detached = null;
    public static final WebviewStatus Hidden = null;
    public static final WebviewStatus Visible = null;

    private static final /* synthetic */ WebviewStatus[] $values() {
        return new WebviewStatus[]{Attached, Visible, Hidden, Detached};
    }

    public static EnumEntries<WebviewStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Attached = new WebviewStatus("Attached", 0);
        Visible = new WebviewStatus("Visible", 1);
        Hidden = new WebviewStatus("Hidden", 2);
        Detached = new WebviewStatus("Detached", 3);
        WebviewStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static WebviewStatus[] values() {
        return (WebviewStatus[]) $VALUES.clone();
    }

    public static WebviewStatus valueOf(String r1) {
        return (WebviewStatus) a.a(WebviewStatus.class, r1);
    }

    private WebviewStatus(String r1, int r2) {
        super(r1, r2);
    }
}
