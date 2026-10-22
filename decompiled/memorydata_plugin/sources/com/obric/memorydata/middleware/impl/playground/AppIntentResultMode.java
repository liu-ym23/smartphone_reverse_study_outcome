package com.obric.memorydata.middleware.impl.playground;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "", "<init>", "(Ljava/lang/String;I)V", "JOB_RESULT", "ASYNC_APP_INTENT", "MOBILE_USE_CALLBACK", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppIntentResultMode extends Enum<AppIntentResultMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppIntentResultMode[] $VALUES = null;
    public static final AppIntentResultMode ASYNC_APP_INTENT = null;
    public static final AppIntentResultMode JOB_RESULT = null;
    public static final AppIntentResultMode MOBILE_USE_CALLBACK = null;

    private static final /* synthetic */ AppIntentResultMode[] $values() {
        return new AppIntentResultMode[]{JOB_RESULT, ASYNC_APP_INTENT, MOBILE_USE_CALLBACK};
    }

    static {
        JOB_RESULT = new AppIntentResultMode("JOB_RESULT", 0);
        ASYNC_APP_INTENT = new AppIntentResultMode("ASYNC_APP_INTENT", 1);
        MOBILE_USE_CALLBACK = new AppIntentResultMode("MOBILE_USE_CALLBACK", 2);
        AppIntentResultMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AppIntentResultMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AppIntentResultMode> getEntries() {
        return $ENTRIES;
    }

    public static AppIntentResultMode valueOf(String r2) {
        return (AppIntentResultMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppIntentResultMode.class, r2), AppIntentResultMode.class, "com.obric.memorydata.plugin");
    }

    public static AppIntentResultMode[] values() {
        return (AppIntentResultMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppIntentResultMode[].class, "com.obric.memorydata.plugin");
    }
}
