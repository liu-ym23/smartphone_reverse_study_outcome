package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.y;
import java.util.HashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public static final /* synthetic */ int c = 0;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;
    public final HashSet<String> b;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0051a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MmMarkedSpeakerType.values().length];
                r0[MmMarkedSpeakerType.LARK_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[MmMarkedSpeakerType.CLUSTER_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[MmMarkedSpeakerType.TEMPORARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static Pair a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r2) {
            int r0 = C0051a.a[r2.f.ordinal()];
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L10;
            return TuplesKt.to("context_uid", r2.a);
        L10:
            throw new NoWhenBranchMatchedException();
        L15:
            return TuplesKt.to("nullx", "null" + r2.a);
        L13:
            return TuplesKt.to("profile_uid", y.b(r2.a));
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmSubtitleSpeakerType.values().length];
            r0[MmSubtitleSpeakerType.SCD_SPEAKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public r(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
        this.b = new HashSet();
    }

    public final void a(String r10, String r11, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "clusterId");
        Intrinsics.checkNotNullParameter(r12, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r13, "newSpeaker");
        Intrinsics.checkNotNullParameter(r14, "scene");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "businessTracker");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "clusterId");
        Intrinsics.checkNotNullParameter(r12, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r13, "newSpeaker");
        Intrinsics.checkNotNullParameter(r14, "scene");
        boolean r1 = false;
        String r3 = null;
        if (StringsKt.startsWith$default(r11, "-", false, 2, null) == false) goto L5;
        lvb.a.e("MmVoicePrintTracker", "[trackVoicePrintChange] clusterId starts with '-', skip tracking");
        return;
    L5:
        MmRecordingCommonParam r0 = r5.b(r10);
        if (r0 != null) goto L8;
    L10:
        if (r1 == true) goto L12;
        lvb.a.b("MmVoicePrintTracker", "[trackVoicePrintChange] commonParam invalid");
        return;
    L12:
        lvb.a.e("MmVoicePrintTracker", "[trackVoicePrintChange] scene=" + r14 + ", clusterId=" + r11 + ", oldSpeaker=" + r12.a + ", newSpeaker=" + r13.a);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r2 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        String r4 = r0.getEncryptedUserId();
        Pair r15 = a.a(r12);
        String r6 = (String) r15.component1();
        String r16 = (String) r15.component2();
        Pair r17 = a.a(r13);
        String r7 = (String) r17.component1();
        String r18 = (String) r17.component2();
        r2.e(PickerReporterConstants.KEY.CLICK, "voiceprint_change");
        r2.e("scene", r14);
        r2.e("change_method", "user_mark");
        if (r11.length() >= 3) goto L15;
        r11 = "null".concat(r11);
    L15:
        r2.e("user_id", r11);
        r2.e("before_user_id", r16);
        r2.e("before_user_type", r6);
        r2.e("after_user_id", r18);
        r2.e("after_user_type", r7);
        IDeviceInfoProvider r19 = OfficeSDKManager.getDeviceInfoProvider();
        if (r19 == null) goto L18;
        r3 = r19.getDeviceId();
    L18:
        r2.e("speak_device_id", r3);
        r2.e("speak_user_id", r4);
        r2.e("speak_user_type", "users");
        r2.e("source", "native");
        r5.g(r10, "vc_voiceprint_change_status", r2.a());
        return;
    L8:
        if (r0.isValid() != true) goto L10;
        r1 = true;
        goto L10
    }
}
