package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "SMS", "PHONE", "RECORDER", "CALENDAR", "ALARM", "GALLERY", "NOTE", "FILE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessSystemApp extends Enum<ContextAwarenessSystemApp> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessSystemApp[] $VALUES = null;
    public static final ContextAwarenessSystemApp ALARM = null;
    public static final ContextAwarenessSystemApp CALENDAR = null;
    public static final ContextAwarenessSystemApp FILE = null;
    public static final ContextAwarenessSystemApp GALLERY = null;
    public static final ContextAwarenessSystemApp NOTE = null;
    public static final ContextAwarenessSystemApp PHONE = null;
    public static final ContextAwarenessSystemApp RECORDER = null;
    public static final ContextAwarenessSystemApp SMS = null;
    private final String packageName;

    private static final /* synthetic */ ContextAwarenessSystemApp[] $values() {
        return new ContextAwarenessSystemApp[]{SMS, PHONE, RECORDER, CALENDAR, ALARM, GALLERY, NOTE, FILE};
    }

    static {
        SMS = new ContextAwarenessSystemApp("SMS", 0, "com.android.mms");
        PHONE = new ContextAwarenessSystemApp("PHONE", 1, "com.android.contacts");
        RECORDER = new ContextAwarenessSystemApp("RECORDER", 2, "com.obric.recorder");
        CALENDAR = new ContextAwarenessSystemApp("CALENDAR", 3, "com.obric.calendar");
        ALARM = new ContextAwarenessSystemApp("ALARM", 4, "com.obric.clock");
        GALLERY = new ContextAwarenessSystemApp("GALLERY", 5, "com.android.gallery3d");
        NOTE = new ContextAwarenessSystemApp("NOTE", 6, "com.obric.notes");
        FILE = new ContextAwarenessSystemApp("FILE", 7, "com.obric.filemanager");
        ContextAwarenessSystemApp[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessSystemApp(String r1, int r2, String r3) {
        super(r1, r2);
        this.packageName = r3;
    }

    public static EnumEntries<ContextAwarenessSystemApp> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessSystemApp valueOf(String r2) {
        return (ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessSystemApp.class, r2), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessSystemApp[] values() {
        return (ContextAwarenessSystemApp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessSystemApp[].class, "com.obric.memorydata.plugin");
    }

    public final String getPackageName() {
        return this.packageName;
    }
}
