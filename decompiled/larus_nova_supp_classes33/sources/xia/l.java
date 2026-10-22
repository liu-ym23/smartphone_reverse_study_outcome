package xia;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l implements c {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // xia.c
    public final int a(AppEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        if ((r5 instanceof AlarmEntity) == false) goto L30;
        AlarmEntity r6 = (AlarmEntity) r5;
        int r0 = (((r6.getName().hashCode() + 0) * 31) + r6.getStartTime().hashCode()) * 31;
        int r2 = 1231;
        if (r6.isEnabled() == false) goto L7;
        int r1 = 1231;
    L8:
        int r3 = r0 + r1;
        List r4 = r6.getRepeatDayOfWeek();
        if (r4 == null) goto L11;
        r3 = (r3 * 31) + r4.hashCode();
    L11:
        int r7 = r3 * 31;
        if (r6.getCloseInHoliday() == false) goto L14;
        int r8 = 1231;
    L15:
        int r9 = r7 + r8;
        String r10 = r6.getDate();
        if (r10 == null) goto L18;
        r9 = (r9 * 31) + r10.hashCode();
    L18:
        Boolean r11 = r6.isRinging();
        if (r11 == null) goto L25;
        int r12 = r9 * 31;
        if (r11.booleanValue() == true) goto L24;
        r2 = 1237;
    L24:
        r9 = r12 + r2;
    L25:
        Integer r13 = r6.getRepeatType();
        if (r13 == null) goto L31;
        int r14 = r9 * 31;
        return r14 + r13.intValue();
    L31:
        return r9;
    L14:
        r8 = 1237;
        goto L15
    L7:
        r1 = 1237;
        goto L8
    L30:
        throw new IllegalStateException("Check failed.".toString());
    }
}
