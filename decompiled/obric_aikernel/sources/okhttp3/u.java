package okhttp3;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12046d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f12047e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f12048f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f12051c;

    @SourceDebugExtension({"SMAP\nMediaType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,181:1\n1#2:182\n37#3,2:183\n*S KotlinDebug\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n*L\n148#1:183,2\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        @JvmName(name = "get")
        public final u a(String r13) {
            Intrinsics.checkNotNullParameter(r13, "<this>");
            Matcher r12 = u.b().matcher(r13);
            if (r12.lookingAt() == false) goto L28;
            String r10 = r12.group(1);
            Intrinsics.checkNotNullExpressionValue(r10, "typeSubtype.group(1)");
            Locale r11 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r11, "US");
            String r14 = r10.toLowerCase(r11);
            Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");
            String r15 = r12.group(2);
            Intrinsics.checkNotNullExpressionValue(r15, "typeSubtype.group(2)");
            Intrinsics.checkNotNullExpressionValue(r11, "US");
            String r16 = r15.toLowerCase(r11);
            Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).toLowerCase(locale)");
            ArrayList r17 = new ArrayList();
            Matcher r18 = u.a().matcher(r13);
            int r19 = r12.end();
        L6:
            if (r19 >= r13.length()) goto L26;
            r18.region(r19, r13.length());
            if (r18.lookingAt() == false) goto L23;
            String r110 = r18.group(1);
            if (r110 == null) goto L11;
            String r20 = r18.group(2);
            if (r20 != null) goto L16;
            r20 = r18.group(3);
        L22:
            r17.add(r110);
            r17.add(r20);
            goto L11
        L16:
            if (StringsKt.startsWith$default(r20, "'", false, 2, null) == false) goto L22;
            if (StringsKt.endsWith$default(r20, "'", false, 2, null) == false) goto L22;
            if (r20.length() <= 2) goto L22;
            r20 = r20.substring(1, r20.length() - 1);
            Intrinsics.checkNotNullExpressionValue(r20, "this as java.lang.String…ing(startIndex, endIndex)");
        L11:
            r19 = r18.end();
            goto L6
        L23:
            StringBuilder r21 = new StringBuilder();
            r21.append("Parameter is not formatted correctly: \"");
            String r111 = r13.substring(r19);
            Intrinsics.checkNotNullExpressionValue(r111, "this as java.lang.String).substring(startIndex)");
            r21.append(r111);
            r21.append("\" for: \"");
            r21.append(r13);
            r21.append(Typography.quote);
            throw new IllegalArgumentException(r21.toString().toString());
        L26:
            return new u(r13, r14, r16, (String[]) r17.toArray(new String[0]), null);
        L28:
            throw new IllegalArgumentException(("No subtype found for: \"" + r13 + Typography.quote).toString());
        }

        @JvmStatic
        @JvmName(name = "parse")
        public final u b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return a(r10);
        L5:
            return null;
        }
    }

    static {
        f12046d = new a(null);
        f12047e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f12048f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private u(String r10, String r11, String r12, String[] r13) {
        this.f12049a = r10;
        this.f12050b = r11;
        this.f12051c = r13;
    }

    public /* synthetic */ u(String r10, String r11, String r12, String[] r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ Pattern a() {
        return f12048f;
    }

    public static final /* synthetic */ Pattern b() {
        return f12047e;
    }

    public static /* synthetic */ Charset d(u r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return r10.c(r11);
    }

    @JvmStatic
    @JvmName(name = "get")
    public static final u e(String r10) {
        return f12046d.a(r10);
    }

    @JvmStatic
    @JvmName(name = "parse")
    public static final u g(String r10) {
        return f12046d.b(r10);
    }

    @JvmOverloads
    public final Charset c(Charset r10) {
        String r11 = f("charset");
        if (r11 != null) goto L8;
        return r10;
    L8:
        return Charset.forName(r11);
    L10:
        return r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof u) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((u) r10).f12049a, this.f12049a) == false) goto L7;
        return true;
    }

    public final String f(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        int r11 = 0;
        int r12 = ProgressionUtilKt.getProgressionLastElement(0, this.f12051c.length - 1, 2);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        if (StringsKt.equals(this.f12051c[r11], r10, true) == true) goto L7;
        if (r11 == r12) goto L14;
        r11 = r11 + 2;
        goto L5
    L14:
        return null;
    L7:
        return this.f12051c[r11 + 1];
    }

    @JvmName(name = WsConstants.KEY_CONNECTION_TYPE)
    public final String h() {
        return this.f12050b;
    }

    public int hashCode() {
        return this.f12049a.hashCode();
    }

    public String toString() {
        return this.f12049a;
    }
}
