package f92;

import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lf92/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lf92/h;", "micConfig", "Ljava/util/List;", "getMicConfig", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class f {

    @SerializedName("mic_config")
    private List<h> micConfig;

    public void e() {
    }

    public f() {
        this.micConfig = new ArrayList();
        e();
    }

    public final h a(int r3) {
        int r0 = 4;
        if (r3 > 4) goto L7;
        r0 = r3;
    L7:
        if (r3 >= 1) goto L9;
        r0 = 1;
    L9:
        List<h> r4 = this.micConfig;
        if (r4 == null) goto L14;
        h r5 = (h) CollectionsKt.getOrNull(r4, r0 - 1);
        if (r5 == null) goto L14;
        return r5;
    L14:
        return new h();
    }

    public final h b(WindowsPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "windowsPosition");
        h r0 = null;
        switch(e.b[r2.ordinal()]) {
            case 1: goto L14;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            default: goto L17;
        };
    L5:
        List<h> r3 = this.micConfig;
        if (r3 == null) goto L17;
        r0 = (h) CollectionsKt.getOrNull(r3, 3);
        goto L17
    L8:
        List<h> r4 = this.micConfig;
        if (r4 == null) goto L17;
        r0 = (h) CollectionsKt.getOrNull(r4, 2);
        goto L17
    L11:
        List<h> r5 = this.micConfig;
        if (r5 == null) goto L17;
        r0 = (h) CollectionsKt.getOrNull(r5, 1);
        goto L17
    L14:
        List<h> r6 = this.micConfig;
        if (r6 == null) goto L17;
        r0 = (h) CollectionsKt.getOrNull(r6, 0);
    L17:
        if (r0 == null) goto L19;
        return r0;
    L19:
        return new h();
    }

    public final i c(WindowsPosition r6) {
        Intrinsics.checkNotNullParameter(r6, "position");
        i r4 = null;
        switch(e.a[r6.ordinal()]) {
            case 1: goto L68;
            case 2: goto L61;
            case 3: goto L54;
            case 4: goto L47;
            case 5: goto L40;
            case 6: goto L33;
            case 7: goto L26;
            case 8: goto L19;
            case 9: goto L12;
            case 10: goto L5;
            default: goto L75;
        };
    L5:
        List<h> r7 = this.micConfig;
        if (r7 == null) goto L75;
        h r8 = (h) CollectionsKt.getOrNull(r7, 3);
        if (r8 == null) goto L75;
        List<i> r9 = r8.a();
        if (r9 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r9, 3);
        goto L75
    L12:
        List<h> r10 = this.micConfig;
        if (r10 == null) goto L75;
        h r11 = (h) CollectionsKt.getOrNull(r10, 3);
        if (r11 == null) goto L75;
        List<i> r13 = r11.a();
        if (r13 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r13, 2);
        goto L75
    L19:
        List<h> r14 = this.micConfig;
        if (r14 == null) goto L75;
        h r15 = (h) CollectionsKt.getOrNull(r14, 3);
        if (r15 == null) goto L75;
        List<i> r16 = r15.a();
        if (r16 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r16, 1);
        goto L75
    L26:
        List<h> r17 = this.micConfig;
        if (r17 == null) goto L75;
        h r18 = (h) CollectionsKt.getOrNull(r17, 3);
        if (r18 == null) goto L75;
        List<i> r19 = r18.a();
        if (r19 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r19, 0);
        goto L75
    L33:
        List<h> r20 = this.micConfig;
        if (r20 == null) goto L75;
        h r21 = (h) CollectionsKt.getOrNull(r20, 2);
        if (r21 == null) goto L75;
        List<i> r23 = r21.a();
        if (r23 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r23, 2);
        goto L75
    L40:
        List<h> r24 = this.micConfig;
        if (r24 == null) goto L75;
        h r25 = (h) CollectionsKt.getOrNull(r24, 2);
        if (r25 == null) goto L75;
        List<i> r26 = r25.a();
        if (r26 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r26, 1);
        goto L75
    L47:
        List<h> r27 = this.micConfig;
        if (r27 == null) goto L75;
        h r28 = (h) CollectionsKt.getOrNull(r27, 2);
        if (r28 == null) goto L75;
        List<i> r29 = r28.a();
        if (r29 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r29, 0);
        goto L75
    L54:
        List<h> r30 = this.micConfig;
        if (r30 == null) goto L75;
        h r31 = (h) CollectionsKt.getOrNull(r30, 1);
        if (r31 == null) goto L75;
        List<i> r33 = r31.a();
        if (r33 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r33, 1);
        goto L75
    L61:
        List<h> r34 = this.micConfig;
        if (r34 == null) goto L75;
        h r35 = (h) CollectionsKt.getOrNull(r34, 1);
        if (r35 == null) goto L75;
        List<i> r36 = r35.a();
        if (r36 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r36, 0);
        goto L75
    L68:
        List<h> r37 = this.micConfig;
        if (r37 == null) goto L75;
        h r38 = (h) CollectionsKt.getOrNull(r37, 0);
        if (r38 == null) goto L75;
        List<i> r39 = r38.a();
        if (r39 == null) goto L75;
        r4 = (i) CollectionsKt.getOrNull(r39, 0);
    L75:
        if (r4 == null) goto L77;
        return r4;
    L77:
        return new i();
    }

    public final double d(int r3) {
        return Double.valueOf(a(RangesKt.coerceAtLeast(r3, 2)).b()).doubleValue();
    }

    public final void f(List<h> r1) {
        this.micConfig = r1;
    }
}
