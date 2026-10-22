package com.bytedance.ai.bridge.method.device.calendar;

import android.app.Activity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import d3.a0;
import f2.k;
import f3.h;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final String[] a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RepeatInterval.values().length];
            r0[RepeatInterval.DAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[RepeatInterval.WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[RepeatInterval.MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[RepeatInterval.YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        a = new String[]{"android.permission.WRITE_CALENDAR"};
    }

    public static final RepeatInterval b(String r1) {
        String r10 = StringsKt.trim(r1).toString().toLowerCase(Locale.US);
        switch(r10.hashCode()) {
            case 99228: goto L18;
            case 3645428: goto L14;
            case 3704893: goto L10;
            case 104080000: goto L6;
            default: goto L20;
        };
    L20:
        return null;
    L6:
        if (r10.equals("month") == false) goto L20;
        return RepeatInterval.MONTH;
    L10:
        if (r10.equals("year") == false) goto L20;
        return RepeatInterval.YEAR;
    L14:
        if (r10.equals("week") == false) goto L20;
        return RepeatInterval.WEEK;
    L18:
        if (r10.equals("day") == false) goto L20;
        return RepeatInterval.DAY;
    }

    public static final long d(long r10, boolean r11) {
        if (r11 == true) goto L4;
        return r10;
    L4:
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r10);
        Calendar r13 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        r13.clear();
        r13.set(r12.get(1), r12.get(2), r12.get(5), 0, 0, 0);
        return r13.getTimeInMillis();
    }

    public static final long c(long r10, Long r11, Long r12) {
        if (r10 <= 0) goto L24;
        if (r11 == null) goto L6;
        long r13 = r11.longValue();
    L8:
        if (r13 < r10) goto L22;
        if (r12 == null) goto L11;
        long r14 = r12.longValue();
    L13:
        if (r14 < 0) goto L20;
        if ((r14 % 60) != 0) goto L18;
        return r13;
    L18:
        throw new IllegalArgumentException("The alarmOffset parameter should be a multiple of 60 seconds on Android.");
    L20:
        throw new IllegalArgumentException("The alarmOffset parameter should not be negative.");
    L11:
        r14 = 0;
        goto L13
    L22:
        throw new IllegalArgumentException("The endTime parameter should not be earlier than startTime.");
    L6:
        r13 = r10;
        goto L8
    L24:
        throw new IllegalArgumentException("The startTime parameter should be a valid Unix timestamp.");
    }

    public static final void a(e3.d r14, f r15, boolean r16, String r17, h r18, Function0 r19) {
        Activity r0 = r14.getOwnerActivity();
        if (r0 != null) goto L7;
        r0 = k.b();
        if (r0 != null) goto L7;
        h.a.a(r18, "context is null", null, null, 14);
        return;
    L7:
        Activity r10 = r0;
        a0 r1 = r14.getContainerContext();
        if (r1 == null) goto L24;
        String r11 = r1.getAppletId();
        if (r11 == null) goto L24;
        if (r11.length() <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L17;
        String r13 = r11;
    L18:
        if (r13 == null) goto L24;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r20 = AppletAppManagerService.a(r13);
        if (r20 != null) goto L23;
        h.a.a(r18, "applet is not running", null, null, 14);
        return;
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AddPhoneCalendarMethodKt$handleCalendarEvent$1(r20, r18, r17, r10, r15, r13, r16, r19, null), 3, null);
        return;
    L17:
        r13 = null;
        goto L18
    L14:
        r12 = false;
    L24:
        h.a.a(r18, "appletId is empty", null, null, 14);
    }
}
