package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationSettings;", "", "<init>", "()V", "KEY", "", "LAST_NOTIFY_AT", "DEBUG_OVERRIDE", "current", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationConfig;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final au f11210a = null;

    static {
        f11210a = new au();
    }

    private au() {
    }

    public final as a() {
        JSONObject r0 = SettingsManager.INSTANCE.getJson("obric_memory_personal_info_confidence_settings");
        Long r3 = null;
        String r4 = "";
        if (AppContext.INSTANCE.isDebug() == false) goto L11;
        IStore r2 = StoreManager.INSTANCE.getPersonalStore();
        if (r2 == null) goto L7;
        String r5 = r2.getString("personal_info_confidence_debug_settings", "");
    L8:
        if (r5 == null) goto L11;
        r4 = r5;
        goto L11
    L7:
        r5 = null;
    L11:
        boolean r6 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        r0 = new JSONObject(r4);
    L14:
        if (r0 == null) goto L19;
        JSONObject r1 = r0.optJSONObject("obric_memory_personal_info_confidence_settings");
        if (r1 == null) goto L19;
        r0 = r1;
    L21:
        int r7 = r0.optInt("notification_start_hour", 10);
        int r8 = r0.optInt("notification_end_hour", 22);
        if (r7 >= 0) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L29;
    L36:
        boolean r10 = false;
    L37:
        boolean r12 = r0.optBoolean("notification_enabled", false);
        Integer r11 = Integer.valueOf(r0.optInt("notification_min_pending_count", 5));
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == true) goto L44;
        r11 = null;
    L44:
        if (r11 == null) goto L46;
        int r14 = r11.intValue();
    L47:
        long r15 = 432000;
        Long r16 = Long.valueOf(r0.optLong("notification_min_interval_seconds", 432000));
        long r17 = ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (1 <= r17) goto L50;
    L52:
        r6 = false;
    L53:
        if (r6 == false) goto L55;
        r3 = r16;
    L55:
        if (r3 == null) goto L57;
        r15 = r3.longValue();
    L57:
        if (r10 == false) goto L59;
        int r18 = r7;
    L60:
        if (r10 == false) goto L62;
        int r19 = r8;
    L64:
        return new as(r12, r14, r15, r18, r19);
    L62:
        r19 = 22;
        goto L64
    L59:
        r18 = 10;
        goto L60
    L50:
        if (r17 >= 31536001) goto L52;
    L46:
        r14 = 5;
        goto L47
    L40:
        r13 = false;
        goto L41
    L29:
        if ((r7 + 1) <= r8) goto L31;
    L33:
        boolean r20 = false;
    L34:
        if (r20 == false) goto L36;
        r10 = true;
        goto L37
    L31:
        if (r8 >= 25) goto L33;
        r20 = true;
        goto L34
    L24:
        if (r7 >= 24) goto L26;
        r9 = true;
    L19:
        if (r0 != null) goto L21;
        r0 = new JSONObject();
        goto L21
    }
}
