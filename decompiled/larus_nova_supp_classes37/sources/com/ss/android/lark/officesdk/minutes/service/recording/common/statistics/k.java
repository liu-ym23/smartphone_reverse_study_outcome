package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmFeatureDetail;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRenderType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaScene;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmRecordingQuotaCtaRenderType.values().length];
            r0[MmRecordingQuotaCtaRenderType.WindowLimited7D.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MmRecordingQuotaCtaRenderType.WindowLimited5H.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[MmRecordingQuotaCtaRenderType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[MmRecordingQuotaCtaScene.values().length];
            r1[MmRecordingQuotaCtaScene.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[MmRecordingQuotaCtaScene.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public k(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
    }

    public static JSONObject a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r12) {
        boolean r0 = r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c;
        MmQuotaData r1 = null;
        if (r0 == false) goto L6;
        MmQuotaType r2 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r12).a;
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        if (r0 == false) goto L21;
        r1 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r12).b;
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r3 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        if (r1 == null) goto L33;
        MmFeatureDetail r4 = r1.getFeatureDetail(r2);
        if (r4 == null) goto L33;
        Map<String, String> r5 = r4.getDataTracking();
        if (r5 == null) goto L33;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L31:
        if (r6.hasNext() == false) goto L33;
        Map.Entry<String, String> r7 = r6.next();
        r3.e(r7.getKey(), r7.getValue());
    L33:
        JSONObject r8 = r3.a();
        boolean r9 = false;
        if (r8.optString("function_type").length() != 0) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
        r8.put("function_type", "none");
    L39:
        String r11 = "minutes_recording_notes_page";
        String r13 = "";
        if (r0 == false) goto L49;
        int r14 = a.b[((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r12).c.ordinal()];
        if (r14 == 1) goto L47;
        if (r14 != 2) goto L46;
    L64:
        r8.put("function_scene", r11);
        if (r1 == null) goto L67;
        r9 = r1.isAdmin(r2);
    L67:
        r8.put("admin_flag", r9);
        if (r0 == false) goto L71;
        MmRecordingQuotaCtaRenderType r15 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r12).d;
    L81:
        int r16 = a.a[r15.ordinal()];
        if (r16 == 1) goto L90;
        if (r16 != 2) goto L85;
        r13 = "5h";
    L91:
        r8.put("limit_type", r13);
        return r8;
    L85:
        if (r16 == 3) goto L91;
        throw new NoWhenBranchMatchedException();
    L90:
        r13 = "7d";
        goto L91
    L71:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L74;
        r15 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r12).d;
        goto L81
    L74:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L76;
    L80:
        r15 = MmRecordingQuotaCtaRenderType.Default;
        goto L81
    L76:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L80;
        throw new NoWhenBranchMatchedException();
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        r11 = "minutes_recording_transcript_page";
        goto L64
    L49:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L57;
        int r17 = a.b[((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r12).c.ordinal()];
        if (r17 == 1) goto L47;
        if (r17 == 2) goto L64;
        throw new NoWhenBranchMatchedException();
    L57:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L59;
    L63:
        r11 = "";
        goto L64
    L59:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L63;
        throw new NoWhenBranchMatchedException();
    L36:
        r10 = false;
        goto L37
    L21:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L23;
        r1 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r12).b;
        goto L23
    L6:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L9;
        r2 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r12).a;
        goto L16
    L9:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L11;
    L15:
        r2 = null;
        goto L16
    L11:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }
}
