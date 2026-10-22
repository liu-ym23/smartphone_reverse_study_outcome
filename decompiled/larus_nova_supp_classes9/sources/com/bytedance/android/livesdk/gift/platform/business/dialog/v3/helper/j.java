package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static boolean a(int r7, long r8) {
            if (r7 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumDay.getValue()) goto L6;
            return s0.c(new u0(r8));
        L6:
            if (r7 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumWeek.getValue()) goto L14;
            Intrinsics.checkNotNullParameter(new u0(r8), "$this$isCurWeek");
            Calendar r9 = Calendar.getInstance();
            r9.setFirstDayOfWeek(2);
            r9.set(7, r9.getFirstDayOfWeek());
            s0.e(r9);
            long r5 = r9.getTimeInMillis();
            Calendar r10 = Calendar.getInstance();
            r10.setFirstDayOfWeek(2);
            r10.set(7, r10.getFirstDayOfWeek() + 6);
            s0.d(r10);
            long r2 = r10.getTimeInMillis();
            if (r5 <= r8) goto L11;
        L29:
            return false;
        L11:
            if (r2 <= r8) goto L29;
        L28:
            return true;
        L14:
            if (r7 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumMonth.getValue()) goto L22;
            Intrinsics.checkNotNullParameter(new u0(r8), "$this$isCurMonth");
            Calendar r11 = Calendar.getInstance();
            r11.set(r11.get(1), r11.get(2), 1);
            s0.e(r11);
            long r6 = r11.getTimeInMillis();
            Calendar r13 = Calendar.getInstance();
            r13.set(r13.get(1), r13.get(2), 1);
            r13.roll(5, -1);
            s0.d(r13);
            long r3 = r13.getTimeInMillis();
            if (r6 > r8) goto L29;
            if (r3 <= r8) goto L29;
        L22:
            if (r7 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumYear.getValue()) goto L29;
            Intrinsics.checkNotNullParameter(new u0(r8), "$this$isCurYear");
            Calendar r14 = Calendar.getInstance();
            r14.set(6, 1);
            s0.e(r14);
            long r15 = r14.getTimeInMillis();
            Calendar r16 = Calendar.getInstance();
            r16.set(6, 1);
            r16.roll(6, -1);
            s0.d(r16);
            long r4 = r16.getTimeInMillis();
            if (r15 > r8) goto L29;
            if (r4 <= r8) goto L29;
            goto L28
        }
    }

    static {
        a = new a();
    }
}
