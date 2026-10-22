package com.larus.dora.impl.device.settings.gesture.wakeup;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "", "titleResId", "", "subtitleResId", "<init>", "(Ljava/lang/String;III)V", "getTitleResId", "()I", "getSubtitleResId", "RADIO", "RADIO_CONTINUOUS_DIALOGUE", "RADIO_RECORD", "CLOSE", "isAvailable", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GestureWakeupType extends Enum<GestureWakeupType> {
    public static final GestureWakeupType CLOSE = null;
    public static final GestureWakeupType RADIO = null;
    public static final GestureWakeupType RADIO_CONTINUOUS_DIALOGUE = null;
    public static final GestureWakeupType RADIO_RECORD = null;
    public static final /* synthetic */ GestureWakeupType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int subtitleResId;
    private final int titleResId;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureWakeupType.values().length];
            r0[GestureWakeupType.RADIO_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static EnumEntries<GestureWakeupType> getEntries() {
        return b;
    }

    static {
        GestureWakeupType r0 = new GestureWakeupType("RADIO", 0, 2131904054, 2131904053);
        RADIO = r0;
        GestureWakeupType r1 = new GestureWakeupType("RADIO_CONTINUOUS_DIALOGUE", 1, 2131904051, 2131904050);
        RADIO_CONTINUOUS_DIALOGUE = r1;
        GestureWakeupType r2 = new GestureWakeupType("RADIO_RECORD", 2, 2131903943, 2131902062);
        RADIO_RECORD = r2;
        GestureWakeupType r3 = new GestureWakeupType("CLOSE", 3, 2131904052, 0);
        CLOSE = r3;
        GestureWakeupType[] r5 = {r0, r1, r2, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static GestureWakeupType[] values() {
        return (GestureWakeupType[]) a.clone();
    }

    public final boolean isAvailable() {
        if (a.a[ordinal()] != 1) goto L13;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L11;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L11;
        if (r1.q0(null) != true) goto L11;
        return true;
    L11:
        return false;
    L13:
        return true;
    }

    public final int getSubtitleResId() {
        return this.subtitleResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public static GestureWakeupType valueOf(String r1) {
        return (GestureWakeupType) r27.a.a(GestureWakeupType.class, r1);
    }

    public GestureWakeupType(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.titleResId = r3;
        this.subtitleResId = r4;
    }
}
