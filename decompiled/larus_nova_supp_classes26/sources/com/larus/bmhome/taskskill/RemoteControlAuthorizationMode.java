package com.larus.bmhome.taskskill;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/RemoteControlAuthorizationMode;", "", "rawValue", "", "titleRes", "descriptionRes", "iconRes", "trackingResult", "", "<init>", "(Ljava/lang/String;IIIIILjava/lang/String;)V", "getRawValue", "()I", "getTitleRes", "getDescriptionRes", "getIconRes", "getTrackingResult", "()Ljava/lang/String;", "ALWAYS_ASK", "ASK_ON_RISK", "FULL_ACCESS", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RemoteControlAuthorizationMode extends Enum<RemoteControlAuthorizationMode> {
    public static final RemoteControlAuthorizationMode ALWAYS_ASK = null;
    public static final RemoteControlAuthorizationMode ASK_ON_RISK = null;
    public static final a Companion = null;
    public static final RemoteControlAuthorizationMode FULL_ACCESS = null;
    public static final /* synthetic */ RemoteControlAuthorizationMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int descriptionRes;
    private final int iconRes;
    private final int rawValue;
    private final int titleRes;
    private final String trackingResult;

    public static final class a {
        public a() {
        }

        public static RemoteControlAuthorizationMode a(int r3) {
            Iterator r0 = RemoteControlAuthorizationMode.getEntries().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            Object r1 = r0.next();
            if (((RemoteControlAuthorizationMode) r1).getRawValue() != r3) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L13:
            return (RemoteControlAuthorizationMode) r1;
        L8:
            r2 = false;
            goto L9
        L11:
            r1 = null;
            goto L13
        }
    }

    public static EnumEntries<RemoteControlAuthorizationMode> getEntries() {
        return b;
    }

    static {
        RemoteControlAuthorizationMode r8 = new RemoteControlAuthorizationMode("ALWAYS_ASK", 0, 0, 2131908300, 2131908301, 2131240271, "always_ask");
        ALWAYS_ASK = r8;
        RemoteControlAuthorizationMode r0 = new RemoteControlAuthorizationMode("ASK_ON_RISK", 1, 1, 2131908302, 2131908303, 2131240266, "auto_process");
        ASK_ON_RISK = r0;
        RemoteControlAuthorizationMode r1 = new RemoteControlAuthorizationMode("FULL_ACCESS", 2, 2, 2131908297, 2131908308, 2131240270, "always_permit");
        FULL_ACCESS = r1;
        RemoteControlAuthorizationMode[] r2 = {r8, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static RemoteControlAuthorizationMode[] values() {
        return (RemoteControlAuthorizationMode[]) a.clone();
    }

    public final int getDescriptionRes() {
        return this.descriptionRes;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getTrackingResult() {
        return this.trackingResult;
    }

    public static RemoteControlAuthorizationMode valueOf(String r1) {
        return (RemoteControlAuthorizationMode) r27.a.a(RemoteControlAuthorizationMode.class, r1);
    }

    public RemoteControlAuthorizationMode(String r1, int r2, int r3, int r4, int r5, int r6, String r7) {
        super(r1, r2);
        this.rawValue = r3;
        this.titleRes = r4;
        this.descriptionRes = r5;
        this.iconRes = r6;
        this.trackingResult = r7;
    }
}
