package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsKeys;", "", "<init>", "()V", "SYSTEM_APP_SMS_ENABLED", "", "SYSTEM_APP_PHONE_ENABLED", "SYSTEM_APP_RECORDER_ENABLED", "SYSTEM_APP_CALENDAR_ENABLED", "SYSTEM_APP_ALARM_ENABLED", "SYSTEM_APP_GALLERY_ENABLED", "SYSTEM_APP_NOTE_ENABLED", "SYSTEM_APP_FILE_ENABLED", "MOTION_STATE_ENABLED", "LOCATION_ENABLED", "NOTIFICATION_CONTENT_ENABLED", "DEVICE_STATE_ENABLED", "ENHANCED_TIMELINESS_ENABLED", "ENHANCED_TIMELINESS_EFFECTIVE", "keyFor", "app", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11453a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11455b = null;

        static {
            int[] r0 = new int[ContextAwarenessSystemApp.values().length];
            r0[ContextAwarenessSystemApp.SMS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[ContextAwarenessSystemApp.PHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L55:
            r0[ContextAwarenessSystemApp.RECORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[ContextAwarenessSystemApp.CALENDAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[ContextAwarenessSystemApp.ALARM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L33:
            r0[ContextAwarenessSystemApp.GALLERY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[ContextAwarenessSystemApp.NOTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[ContextAwarenessSystemApp.FILE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L14:
            f11454a = r0;
            int[] r1 = new int[ContextAwarenessGlobalSource.values().length];
            r1[ContextAwarenessGlobalSource.MOTION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L37:
            r1[ContextAwarenessGlobalSource.LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L51:
            r1[ContextAwarenessGlobalSource.NOTIFICATION_CONTENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L35:
            r1[ContextAwarenessGlobalSource.DEVICE_STATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L19:
            f11455b = r1;
        }
    }

    static {
        f11453a = new h();
    }

    private h() {
    }

    public final String a(ContextAwarenessGlobalSource r1) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        int r0 = a.f11455b[r1.ordinal()];
        if (r0 != 1) goto L5;
        return "context_awareness_motion_state_enabled";
    L5:
        if (r0 != 2) goto L7;
        return "context_awareness_location_enabled";
    L7:
        if (r0 != 3) goto L9;
        return "context_awareness_notification_content_enabled";
    L9:
        if (r0 != 4) goto L12;
        return "context_awareness_device_state_enabled";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final String a(ContextAwarenessSystemApp r1) {
        Intrinsics.checkNotNullParameter(r1, "app");
        switch(a.f11454a[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return "context_awareness_system_app_file_enabled";
    L7:
        return "context_awareness_system_app_note_enabled";
    L8:
        return "context_awareness_system_app_gallery_enabled";
    L9:
        return "context_awareness_system_app_alarm_enabled";
    L10:
        return "context_awareness_system_app_calendar_enabled";
    L11:
        return "context_awareness_system_app_recorder_enabled";
    L12:
        return "context_awareness_system_app_phone_enabled";
    L13:
        return "context_awareness_system_app_sms_enabled";
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
