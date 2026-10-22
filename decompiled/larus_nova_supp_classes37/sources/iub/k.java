package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public final MmRecordingSource a;
    public final Map<String, Object> b;
    public final MmRecordingUILaunchMode c;
    public final String d;
    public final String e;
    public final MmRecordingCreateMode f;
    public final boolean g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingCreateContext(source=" + this.a + ", extra=" + this.b + ", uiLaunchMode=" + this.c + ", spokenLanguage=" + this.d + ", translationLanguage=" + this.e + ", mode=" + this.f + ", autoOpenRecordingPage=" + this.g + ')';
    }

    public final DoubaoStatisticInfo a() {
        Object r0 = this.b.get("doubao_statistics_params");
        if (r0 == null) goto L25;
        String r1 = r0.toString();
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L27;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r3) == false) goto L19;
        r3 = null;
    L19:
        if (((JSONObject) r3) != null) goto L22;
        return null;
    L22:
        return new DoubaoStatisticInfo(r1);
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L27:
        return null;
    L25:
        return null;
    }

    public /* synthetic */ k(MmRecordingSource r9, Map r10, MmRecordingUILaunchMode r11, String r12, MmRecordingCreateMode r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r10 = MapsKt.emptyMap();
    L5:
        Map r2 = r10;
        if ((r14 & 8) == 0) goto L8;
        String r4 = "";
    L10:
        if ((r14 & 16) == 0) goto L12;
        String r5 = "";
    L14:
        if ((r14 & 32) == 0) goto L16;
        r13 = MmRecordingCreateMode.DEFAULT_RTC;
    L16:
        MmRecordingCreateMode r6 = r13;
        if ((r14 & 64) == 0) goto L19;
        boolean r7 = true;
    L20:
        this(r9, r2, r11, r4, r5, r6, r7);
        return;
    L19:
        r7 = false;
        goto L20
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = null;
        goto L10
    }

    public k(MmRecordingSource r2, Map<String, ? extends Object> r3, MmRecordingUILaunchMode r4, String r5, String r6, MmRecordingCreateMode r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "spokenLanguage");
        Intrinsics.checkNotNullParameter(r6, "translationLanguage");
        Intrinsics.checkNotNullParameter(r7, "mode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
