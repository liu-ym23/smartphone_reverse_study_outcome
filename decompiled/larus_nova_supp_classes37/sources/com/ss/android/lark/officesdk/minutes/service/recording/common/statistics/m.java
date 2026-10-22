package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c a;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "TranslatedSubtitleInfo(originalLanguage=" + this.a + ", translationLanguage=" + this.b + ", paragraphCnt=" + this.c + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "originalLanguage");
            Intrinsics.checkNotNullParameter(r3, "translationLanguage");
            this.a = r2;
            this.b = r3;
            this.c = 1;
        }
    }

    static {
    }

    public m(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2) {
        Intrinsics.checkNotNullParameter(r2, "businessTracker");
        this.a = r2;
    }

    public final void a(String r2, String r3, String r4) {
        MmRecordingCommonParam r0 = this.a.b(r2);
        if (r0 != null) goto L6;
        lvb.a.h("MmRecordingSubtitleTracker", "[trackTranslationOpenStatus] skip: commonParam missing, sessionId=".concat(r2));
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r5 = r0.asTrackerParams();
        r5.e("translation_language", r3);
        r5.e("open_translation_entry", r4);
        JSONObject r6 = r5.a();
        this.a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("vc_subtitle_translation_open_status", r6);
    }
}
