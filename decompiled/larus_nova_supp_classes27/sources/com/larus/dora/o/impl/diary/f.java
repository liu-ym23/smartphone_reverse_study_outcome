package com.larus.dora.o.impl.diary;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final /* synthetic */ int j = 0;
    public final Fragment a;
    public final String b;
    public final c c;
    public final d d;
    public AbsWebFragment e;
    public boolean f;
    public String g;
    public final ODiaryBetaH5Controller$reportReceiver$1 h;
    public final ODiaryBetaH5Controller$feedbackReceiver$1 i;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final boolean g;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (((r7 + r9) * 31) + this.e) * 31;
            String r11 = this.f;
            if (r11 == null) goto L18;
            r2 = r11.hashCode();
        L18:
            int r12 = (r10 + r2) * 31;
            if (this.g == false) goto L21;
            int r13 = 1231;
        L23:
            return r12 + r13;
        L21:
            r13 = 1237;
            goto L23
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "H5DiaryState(date=" + this.a + ", diaryId=" + this.b + ", lastUpdateTime=" + this.c + ", earliestDate=" + this.d + ", recordDays=" + this.e + ", reason=" + this.f + ", fromDiaryPage=" + this.g + ')';
        }

        public b(String r2, String r3, String r4, String r5, int r6, String r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r2, "date");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public interface c {
        void a(String r1, int r2, l0 r3);

        void b(b r1);
    }

    public interface d {
        boolean a();

        boolean b();
    }

    static {
    }

    public final void a(String r12, int r13, l0 r14) {
        if (r14 == null) goto L5;
        int r1 = r14.a;
    L7:
        if (r14 == null) goto L15;
        String r15 = r14.b;
        if (r15 == null) goto L15;
        if ((!StringsKt.isBlank(r15)) == true) goto L14;
        r15 = null;
    L14:
        if (r15 == null) goto L15;
    L16:
        FLogger.a.i("ODiaryBetaH5", "notify h5 feedback submitted diary=" + r12 + " action=" + r13 + " target=" + r1 + '/' + r15);
        AbsWebFragment r3 = this.e;
        if (r3 == null) goto L19;
        JSONObject r9 = new JSONObject();
        r9.put("diary_id", r12);
        r9.put("action_type", r13);
        r9.put("target_type", r1);
        r9.put("target_id", r15);
        Unit r10 = Unit.INSTANCE;
        r3.T90("dora.diary.feedbackSubmitted", r9);
    L19:
        IXBridgeApi.a.b("dora.diary.feedbackSubmitted", MapsKt.mapOf(new Pair[]{TuplesKt.to("diary_id", r12), TuplesKt.to("action_type", Integer.valueOf(r13)), TuplesKt.to("target_type", Integer.valueOf(r1)), TuplesKt.to("target_id", r15)}), null);
        return;
    L15:
        r15 = r12;
        goto L16
    L5:
        r1 = 1;
        goto L7
    }

    public f(Fragment r2, String r3, ODiaryContentFragment.b r4, ODiaryContentFragment.c r5) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "eventListener");
        Intrinsics.checkNotNullParameter(r5, "hostState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.h = new ODiaryBetaH5Controller$reportReceiver$1(this);
        this.i = new ODiaryBetaH5Controller$feedbackReceiver$1(this);
    }
}
