package okhttp3;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f12025k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f12026l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f12032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f12033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f12034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f12035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12036j;

    @SourceDebugExtension({"SMAP\nHttpUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1914:1\n1#2:1915\n1549#3:1916\n1620#3,3:1917\n1549#3:1920\n1620#3,3:1921\n*S KotlinDebug\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n*L\n1201#1:1916\n1201#1:1917,3\n1202#1:1920\n1202#1:1921,3\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final C0271a f12037i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f12040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f12041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f12042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<String> f12043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<String> f12044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f12045h;

        /* JADX INFO: renamed from: okhttp3.s$a$a, reason: collision with other inner class name */
        public static final class C0271a {
            private C0271a() {
            }

            public /* synthetic */ C0271a(DefaultConstructorMarker r10) {
                this();
            }

            public static final /* synthetic */ int a(C0271a r10, String r11, int r12, int r13) {
                return r10.e(r11, r12, r13);
            }

            public static final /* synthetic */ int b(C0271a r10, String r11, int r12, int r13) {
                return r10.f(r11, r12, r13);
            }

            public static final /* synthetic */ int c(C0271a r10, String r11, int r12, int r13) {
                return r10.g(r11, r12, r13);
            }

            public static final /* synthetic */ int d(C0271a r10, String r11, int r12, int r13) {
                return r10.h(r11, r12, r13);
            }

            private final int e(String r13, int r14, int r15) {
                int r16 = Integer.parseInt(b.b(s.f12025k, r13, r14, r15, "", false, false, false, false, null, 248, null));     // Catch: NumberFormatException -> L12
                boolean r17 = false;
                if (1 <= r16) goto L7;
            L9:
                if (r17 == true) goto L11;
                return -1;
            L11:
                return r16;
            L7:
                if (r16 >= 65536) goto L9;
                r17 = true;
            L16:
                return -1;
            }

            private final int f(String r10, int r11, int r12) {
            L2:
                if (r11 >= r12) goto L14;
                char r13 = r10.charAt(r11);
                if (r13 != '[') goto L11;
            L5:
                r11 = r11 + 1;
                if (r11 >= r12) goto L13;
                if (r10.charAt(r11) != ']') goto L5;
            L13:
                r11 = r11 + 1;
                goto L2
            L11:
                if (r13 != ':') goto L13;
                return r11;
            L14:
                return r12;
            }

            private final int g(String r10, int r11, int r12) {
                if ((r12 - r11) >= 2) goto L5;
                return -1;
            L5:
                char r13 = r10.charAt(r11);
                if (Intrinsics.compare(r13, 97) < 0) goto L10;
                if (Intrinsics.compare(r13, 122) > 0) goto L10;
            L14:
                int r14 = r11 + 1;
            L15:
                if (r14 >= r12) goto L59;
                char r15 = r10.charAt(r14);
                boolean r16 = false;
                if ('a' <= r15) goto L19;
            L21:
                boolean r17 = false;
            L22:
                if (r17 == false) goto L24;
            L23:
                boolean r18 = true;
            L30:
                if (r18 == false) goto L33;
            L31:
                boolean r19 = true;
            L37:
                if (r19 == false) goto L40;
            L38:
                boolean r20 = true;
            L43:
                if (r20 == false) goto L46;
            L44:
                boolean r21 = true;
            L49:
                if (r21 == false) goto L52;
            L50:
                r16 = true;
            L54:
                if (r16 == false) goto L55;
                r14 = r14 + 1;
                goto L15
            L55:
                if (r15 == ':') goto L57;
                return -1;
            L57:
                return r14;
            L52:
                if (r15 != '.') goto L54;
            L46:
                if (r15 == '-') goto L44;
                r21 = false;
                goto L49
            L40:
                if (r15 == '+') goto L38;
                r20 = false;
                goto L43
            L33:
                if ('0' > r15) goto L36;
                if (r15 < ':') goto L31;
            L36:
                r19 = false;
                goto L37
            L24:
                if ('A' <= r15) goto L26;
            L28:
                r18 = false;
                goto L30
            L26:
                if (r15 >= '[') goto L28;
            L19:
                if (r15 >= '{') goto L21;
                r17 = true;
            L59:
                return -1;
            L10:
                if (Intrinsics.compare(r13, 65) < 0) goto L59;
                if (Intrinsics.compare(r13, 90) <= 0) goto L14;
                goto L14
            }

            private final int h(String r10, int r11, int r12) {
                int r13 = 0;
            L3:
                if (r11 >= r12) goto L9;
                char r14 = r10.charAt(r11);
                if (r14 == '\\') goto L8;
                if (r14 != '/') goto L9;
            L8:
                r13 = r13 + 1;
                r11 = r11 + 1;
            L9:
                return r13;
            }
        }

        static {
            f12037i = new C0271a(null);
        }

        public a() {
            this.f12039b = "";
            this.f12040c = "";
            this.f12042e = -1;
            ArrayList r10 = new ArrayList();
            this.f12043f = r10;
            r10.add("");
        }

        private final int c() {
            int r10 = this.f12042e;
            if (r10 != (-1)) goto L7;
            b r11 = s.f12025k;
            String r12 = this.f12038a;
            Intrinsics.checkNotNull(r12);
            return r11.c(r12);
        L7:
            return r10;
        }

        private final boolean g(String r10) {
            if (Intrinsics.areEqual(r10, ".") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r10, "%2e", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        private final boolean h(String r10) {
            if (Intrinsics.areEqual(r10, "..") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r10, "%2e.", true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(r10, ".%2e", true) == false) goto L9;
            return true;
        L9:
            if (StringsKt.equals(r10, "%2e%2e", true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private final void k() {
            List<String> r10 = this.f12043f;
            if (r10.remove(r10.size() - 1).length() != 0) goto L5;
            boolean r11 = true;
        L7:
            if (r11 == true) goto L9;
        L11:
            this.f12043f.add("");
            return;
        L9:
            if ((!this.f12043f.isEmpty()) == false) goto L11;
            List<String> r12 = this.f12043f;
            r12.set(r12.size() - 1, "");
            return;
        L5:
            r11 = false;
            goto L7
        }

        private final void m(String r14, int r15, int r16, boolean r17, boolean r18) {
            String r10 = b.b(s.f12025k, r14, r15, r16, " \"<>^`{}|/\\?#", r18, false, false, false, null, 240, null);
            if (g(r10) == false) goto L6;
            return;
        L6:
            if (h(r10) == false) goto L9;
            k();
            return;
        L9:
            List<String> r11 = this.f12043f;
            if (r11.get(r11.size() - 1).length() != 0) goto L12;
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            List<String> r13 = this.f12043f;
            r13.set(r13.size() - 1, r10);
        L16:
            if (r17 == false) goto L19;
            this.f12043f.add("");
            return;
        L19:
            return;
        L15:
            this.f12043f.add(r10);
            goto L16
        L12:
            r12 = false;
            goto L13
        }

        private final void o(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r10 = r11.charAt(r12);
            if (r10 != '/') goto L7;
        L10:
            this.f12043f.clear();
            this.f12043f.add("");
            r12 = r12 + 1;
        L11:
            int r14 = r12;
        L12:
            if (r14 >= r13) goto L20;
            r12 = hc.e.q(r11, "/\\", r14, r13);
            if (r12 >= r13) goto L16;
            boolean r15 = true;
        L17:
            m(r11, r14, r12, r15, true);
            if (r15 == false) goto L11;
            r14 = r12 + 1;
            goto L12
        L16:
            r15 = false;
            goto L17
        L20:
            return;
        L7:
            if (r10 == '\\') goto L10;
            List<String> r16 = this.f12043f;
            r16.set(r16.size() - 1, "");
            goto L11
        }

        private final boolean w(int r10, String r11, boolean r12) {
            if (r10 >= 2) goto L6;
            return false;
        L6:
            if (r12 == false) goto L8;
        L18:
            return true;
        L8:
            if (sc.a.e() == false) goto L18;
            if (TextUtils.isEmpty(r11) == false) goto L13;
        L17:
            return false;
        L13:
            if (StringsKt.startsWith$default(r11, ReportConsts.HTTPS, false, 2, null) == false) goto L15;
        L16:
            return true;
        L15:
            if (StringsKt.startsWith$default(r11, "http://", false, 2, null) == false) goto L17;
            goto L16
        }

        public final a a(String r16, String r17) {
            Intrinsics.checkNotNullParameter(r16, ActivityLifecycle.NAME);
            if (this.f12044g != null) goto L5;
            this.f12044g = new ArrayList();
        L5:
            List<String> r10 = this.f12044g;
            Intrinsics.checkNotNull(r10);
            b r14 = s.f12025k;
            r10.add(b.b(r14, r16, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> r11 = this.f12044g;
            Intrinsics.checkNotNull(r11);
            if (r17 == null) goto L8;
            String r12 = b.b(r14, r17, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
        L9:
            r11.add(r12);
            return this;
        L8:
            r12 = null;
            goto L9
        }

        public final s b() {
            String r10 = this.f12038a;
            if (r10 == null) goto L30;
            b r11 = s.f12025k;
            String r12 = b.h(r11, this.f12039b, 0, 0, false, 7, null);
            String r13 = b.h(r11, this.f12040c, 0, 0, false, 7, null);
            String r14 = this.f12041d;
            if (r14 == null) goto L28;
            int r15 = c();
            List<String> r16 = this.f12043f;
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r18 = r16.iterator();
        L8:
            if (r18.hasNext() == false) goto L10;
            r17.add(b.h(s.f12025k, (String) r18.next(), 0, 0, false, 7, null));
            goto L8
        L10:
            List<String> r19 = this.f12044g;
            String r20 = null;
            if (r19 == null) goto L21;
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r22 = r19.iterator();
        L14:
            if (r22.hasNext() == false) goto L20;
            String r110 = (String) r22.next();
            if (r110 == null) goto L18;
            String r23 = b.h(s.f12025k, r110, 0, 0, true, 3, null);
        L19:
            r21.add(r23);
            goto L14
        L18:
            r23 = null;
            goto L19
        L20:
            ArrayList r24 = r21;
        L22:
            String r111 = this.f12045h;
            if (r111 == null) goto L26;
            r20 = b.h(s.f12025k, r111, 0, 0, false, 7, null);
        L26:
            return new s(r10, r12, r13, r14, r15, r17, r24, r20, toString());
        L21:
            r24 = null;
            goto L22
        L28:
            throw new IllegalStateException("host == null");
        L30:
            throw new IllegalStateException("scheme == null");
        }

        public final a d(String r14) {
            if (r14 == null) goto L6;
            b r12 = s.f12025k;
            String r15 = b.b(r12, r14, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
            if (r15 == null) goto L6;
            List<String> r16 = r12.j(r15);
        L7:
            this.f12044g = r16;
            return this;
        L6:
            r16 = null;
            goto L7
        }

        public final List<String> e() {
            return this.f12043f;
        }

        public final a f(String r10) {
            Intrinsics.checkNotNullParameter(r10, "host");
            String r11 = hc.a.e(b.h(s.f12025k, r10, 0, 0, false, 7, null));
            if (r11 == null) goto L7;
            this.f12041d = r11;
            return this;
        L7:
            throw new IllegalArgumentException("unexpected host: " + r10);
        }

        public final a i(s r31, String r32, boolean r33) {
            String r13 = r32;
            Intrinsics.checkNotNullParameter(r13, "input");
            int r10 = hc.e.A(r13, 0, 0, 3, null);
            int r15 = hc.e.C(r13, r10, 0, 2, null);
            C0271a r11 = f12037i;
            int r12 = C0271a.c(r11, r13, r10, r15);
            String r14 = "this as java.lang.String…ing(startIndex, endIndex)";
            byte r16 = -1;
            boolean r17 = true;
            if (r12 != (-1)) goto L5;
            if (r31 == null) goto L83;
            this.f12038a = r31.s();
        L14:
            int r18 = C0271a.d(r11, r13, r10, r15);
            byte r19 = 63;
            byte r20 = 35;
            if (w(r18, r13, r33) == true) goto L26;
            if (r31 == null) goto L26;
            if (Intrinsics.areEqual(r31.s(), this.f12038a) == false) goto L26;
            this.f12039b = r31.g();
            this.f12040c = r31.c();
            this.f12041d = r31.h();
            this.f12042e = r31.n();
            this.f12043f.clear();
            this.f12043f.addAll(r31.e());
            if (r10 != r15) goto L23;
        L24:
            d(r31.f());
        L25:
            int r21 = r15;
        L70:
            int r110 = r21;
            int r22 = hc.e.q(r13, "?#", r10, r110);
            o(r13, r10, r22);
            if (r22 < r110) goto L73;
        L75:
            if (r22 < r110) goto L77;
        L79:
            return this;
        L77:
            if (r13.charAt(r22) != '#') goto L79;
            this.f12045h = b.b(s.f12025k, r32, r22 + 1, r110, "", true, false, false, true, null, 176, null);
            goto L79
        L73:
            if (r13.charAt(r22) != '?') goto L75;
            int r111 = hc.e.p(r13, '#', r22, r110);
            b r112 = s.f12025k;
            this.f12044g = r112.j(b.b(r112, r32, r22 + 1, r111, " \"'<>#", true, false, true, false, null, 208, null));
            r22 = r111;
            goto L75
        L23:
            if (r13.charAt(r10) != '#') goto L25;
        L26:
            int r23 = r10 + r18;
            boolean r113 = false;
            boolean r114 = false;
        L27:
            int r24 = hc.e.q(r13, "@/\\?#", r23, r15);
            if (r24 == r15) goto L30;
            byte r25 = r13.charAt(r24);
        L31:
            if (r25 == r16) goto L53;
            if (r25 == r20) goto L53;
            if (r25 == 47) goto L53;
            if (r25 == 92) goto L53;
            if (r25 == r19) goto L53;
            if (r25 != 64) goto L27;
            if (r113 == true) goto L51;
            int r26 = hc.e.p(r13, ':', r23, r24);
            b r115 = s.f12025k;
            boolean r116 = r17;
            String r117 = r14;
            String r27 = b.b(r115, r32, r23, r26, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            if (r114 == false) goto L46;
            r27 = this.f12039b + "%40" + r27;
        L46:
            this.f12039b = r27;
            if (r26 == r24) goto L49;
            this.f12040c = b.b(r115, r32, r26 + 1, r24, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            boolean r118 = r116;
        L50:
            r113 = r118;
            String r119 = r117;
            r114 = r116;
            int r120 = r24;
        L52:
            r23 = r120 + 1;
            r14 = r119;
            r17 = r116;
            r15 = r15;
            r20 = 35;
            r19 = 63;
            r16 = -1;
            goto L27
        L49:
            r118 = r113;
            goto L50
        L51:
            r116 = r17;
            StringBuilder r121 = new StringBuilder();
            r121.append(this.f12040c);
            r121.append("%40");
            r119 = r14;
            r120 = r24;
            r121.append(b.b(s.f12025k, r32, r23, r24, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
            this.f12040c = r121.toString();
        L53:
            boolean r122 = r17;
            String r123 = r14;
            r21 = r15;
            C0271a r28 = f12037i;
            int r29 = C0271a.b(r28, r13, r23, r24);
            int r124 = r29 + 1;
            if (r124 >= r24) goto L63;
            int r125 = r23;
            this.f12041d = hc.a.e(b.h(s.f12025k, r32, r23, r29, false, 4, null));
            int r30 = C0271a.a(r28, r13, r124, r24);
            this.f12042e = r30;
            if (r30 == (-1)) goto L58;
            boolean r34 = r122;
        L59:
            if (r34 == true) goto L65;
            StringBuilder r35 = new StringBuilder();
            r35.append("Invalid URL port: \"");
            String r36 = r13.substring(r124, r24);
            Intrinsics.checkNotNullExpressionValue(r36, r123);
            r35.append(r36);
            r35.append(Typography.quote);
            throw new IllegalArgumentException(r35.toString().toString());
        L65:
            if (this.f12041d == null) goto L67;
            boolean r210 = r122;
        L68:
            if (r210 == false) goto L80;
            r10 = r24;
            goto L70
        L80:
            StringBuilder r37 = new StringBuilder();
            r37.append("Invalid URL host: \"");
            String r38 = r13.substring(r125, r29);
            Intrinsics.checkNotNullExpressionValue(r38, r123);
            r37.append(r38);
            r37.append(Typography.quote);
            throw new IllegalArgumentException(r37.toString().toString());
        L67:
            r210 = false;
            goto L68
        L58:
            r34 = false;
            goto L59
        L63:
            r125 = r23;
            b r126 = s.f12025k;
            this.f12041d = hc.a.e(b.h(r126, r32, r125, r29, false, 4, null));
            String r39 = this.f12038a;
            Intrinsics.checkNotNull(r39);
            this.f12042e = r126.c(r39);
            goto L65
        L30:
            r25 = r16;
            goto L31
        L83:
            if (r32.length() <= 6) goto L86;
            r13 = StringsKt.take(r13, 6) + "...";
        L86:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + r13);
        L5:
            if (StringsKt.startsWith(r13, "https:", r10, true) == false) goto L8;
            this.f12038a = "https";
            r10 = r10 + 6;
            goto L14
        L8:
            if (StringsKt.startsWith(r13, "http:", r10, true) == false) goto L10;
            this.f12038a = "http";
            r10 = r10 + 5;
            goto L14
        L10:
            StringBuilder r40 = new StringBuilder();
            r40.append("Expected URL scheme 'http' or 'https' but was '");
            String r41 = r13.substring(0, r12);
            Intrinsics.checkNotNullExpressionValue(r41, "this as java.lang.String…ing(startIndex, endIndex)");
            r40.append(r41);
            r40.append('\'');
            throw new IllegalArgumentException(r40.toString());
        }

        public final a j(String r14) {
            Intrinsics.checkNotNullParameter(r14, "password");
            this.f12040c = b.b(s.f12025k, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a l(int r10) {
            boolean r11 = false;
            if (1 <= r10) goto L5;
        L7:
            if (r11 == false) goto L11;
            this.f12042e = r10;
            return this;
        L11:
            throw new IllegalArgumentException(("unexpected port: " + r10).toString());
        L5:
            if (r10 >= 65536) goto L7;
            r11 = true;
            goto L7
        }

        public final a n() {
            String r10 = this.f12041d;
            String r11 = null;
            if (r10 == null) goto L5;
            String r12 = new Regex("[\"<>^`{|}]").replace(r10, "");
        L6:
            this.f12041d = r12;
            int r13 = this.f12043f.size();
            int r14 = 0;
            int r15 = 0;
        L7:
            if (r15 >= r13) goto L9;
            List<String> r16 = this.f12043f;
            r16.set(r15, b.b(s.f12025k, r16.get(r15), 0, 0, "[]", true, true, false, false, null, 227, null));
            r15 = r15 + 1;
            goto L7
        L9:
            List<String> r17 = this.f12044g;
            if (r17 == null) goto L18;
            int r18 = r17.size();
        L12:
            if (r14 >= r18) goto L18;
            String r19 = r17.get(r14);
            if (r19 == null) goto L16;
            String r20 = b.b(s.f12025k, r19, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
        L17:
            r17.set(r14, r20);
            r14 = r14 + 1;
            goto L12
        L16:
            r20 = null;
        L18:
            String r21 = this.f12045h;
            if (r21 == null) goto L21;
            r11 = b.b(s.f12025k, r21, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
        L21:
            this.f12045h = r11;
            return this;
        L5:
            r12 = null;
            goto L6
        }

        public final a p(String r10) {
            Intrinsics.checkNotNullParameter(r10, "scheme");
            String r11 = "http";
            if (StringsKt.equals(r10, "http", true) == false) goto L5;
        L4:
            this.f12038a = r11;
            return this;
        L5:
            r11 = "https";
            if (StringsKt.equals(r10, "https", true) == true) goto L4;
            throw new IllegalArgumentException("unexpected scheme: " + r10);
        }

        public final void q(String r10) {
            this.f12045h = r10;
        }

        public final void r(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f12040c = r10;
        }

        public final void s(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f12039b = r10;
        }

        public final void t(String r10) {
            this.f12041d = r10;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            String r11 = this.f12038a;
            if (r11 == null) goto L5;
            r10.append(r11);
            String r12 = "://";
        L6:
            r10.append(r12);
            boolean r13 = true;
            if (this.f12039b.length() <= 0) goto L9;
            boolean r14 = true;
        L11:
            if (r14 == false) goto L13;
        L17:
            r10.append(this.f12039b);
            if (this.f12040c.length() > 0) goto L21;
            r13 = false;
        L21:
            if (r13 == false) goto L23;
            r10.append(':');
            r10.append(this.f12040c);
        L23:
            r10.append('@');
        L24:
            String r15 = this.f12041d;
            if (r15 == null) goto L31;
            Intrinsics.checkNotNull(r15);
            if (StringsKt.contains$default(r15, ':', false, 2, null) == false) goto L29;
            r10.append('[');
            r10.append(this.f12041d);
            r10.append(']');
            goto L31
        L29:
            r10.append(this.f12041d);
        L31:
            if (this.f12042e == (-1)) goto L33;
        L34:
            int r16 = c();
            String r17 = this.f12038a;
            if (r17 == null) goto L38;
            b r18 = s.f12025k;
            Intrinsics.checkNotNull(r17);
            if (r16 != r18.c(r17)) goto L38;
        L39:
            b r19 = s.f12025k;
            r19.i(this.f12043f, r10);
            if (this.f12044g == null) goto L43;
            r10.append('?');
            List<String> r20 = this.f12044g;
            Intrinsics.checkNotNull(r20);
            r19.k(r20, r10);
        L43:
            if (this.f12045h == null) goto L45;
            r10.append('#');
            r10.append(this.f12045h);
        L45:
            String r21 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r21, "StringBuilder().apply(builderAction).toString()");
            return r21;
        L38:
            r10.append(':');
            r10.append(r16);
            goto L39
        L33:
            if (this.f12038a == null) goto L39;
        L13:
            if (this.f12040c.length() <= 0) goto L15;
            boolean r22 = true;
        L16:
            if (r22 == false) goto L24;
        L15:
            r22 = false;
            goto L16
        L9:
            r14 = false;
            goto L11
        L5:
            r12 = "//";
            goto L6
        }

        public final void u(int r10) {
            this.f12042e = r10;
        }

        public final void v(String r10) {
            this.f12038a = r10;
        }

        public final a x(String r14) {
            Intrinsics.checkNotNullParameter(r14, "username");
            this.f12039b = b.b(s.f12025k, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ String b(b r13, String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22, int r23, Object r24) {
            if ((r23 & 1) == 0) goto L5;
            int r10 = 0;
        L7:
            if ((r23 & 2) == 0) goto L9;
            int r11 = r14.length();
        L11:
            if ((r23 & 8) == 0) goto L13;
            boolean r12 = false;
        L15:
            if ((r23 & 16) == 0) goto L17;
            boolean r25 = false;
        L19:
            if ((r23 & 32) == 0) goto L21;
            boolean r110 = false;
        L23:
            if ((r23 & 64) == 0) goto L25;
            boolean r111 = false;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Charset r112 = null;
        L31:
            return r13.a(r14, r10, r11, r17, r12, r25, r110, r111, r112);
        L29:
            r112 = r22;
            goto L31
        L25:
            r111 = r21;
            goto L27
        L21:
            r110 = r20;
            goto L23
        L17:
            r25 = r19;
            goto L19
        L13:
            r12 = r18;
            goto L15
        L9:
            r11 = r16;
            goto L11
        L5:
            r10 = r15;
            goto L7
        }

        private final boolean e(String r10, int r11, int r12) {
            int r13 = r11 + 2;
            if (r13 < r12) goto L5;
        L11:
            return false;
        L5:
            if (r10.charAt(r11) != '%') goto L11;
            if (hc.e.H(r10.charAt(r11 + 1)) == (-1)) goto L11;
            if (hc.e.H(r10.charAt(r13)) == (-1)) goto L11;
            return true;
        }

        public static /* synthetic */ String h(b r10, String r11, int r12, int r13, boolean r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r12 = 0;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r13 = r11.length();
        L9:
            if ((r15 & 4) == 0) goto L12;
            r14 = false;
        L12:
            return r10.g(r11, r12, r13, r14);
        }

        private final void l(okio.d r15, String r16, int r17, int r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, Charset r24) {
            int r10 = r17;
            okio.d r11 = null;
        L3:
            if (r10 >= r18) goto L53;
            int r12 = r16.codePointAt(r10);
            if (r20 == false) goto L16;
            if (r12 == 9) goto L52;
            if (r12 == 10) goto L52;
            if (r12 == 12) goto L52;
            if (r12 != 13) goto L16;
        L52:
            r10 = r10 + Character.charCount(r12);
        L16:
            if (r12 != 43) goto L23;
            if (r22 == false) goto L23;
            if (r20 == false) goto L20;
            String r13 = "+";
        L21:
            r15.l0(r13);
            goto L52
        L20:
            r13 = "%2B";
        L23:
            if (r12 < 32) goto L41;
            if (r12 == 127) goto L41;
            if (r12 < 128) goto L30;
            if (r23 == false) goto L41;
        L30:
            if (StringsKt.contains$default(r19, (char) r12, false, 2, null) == true) goto L41;
            if (r12 != 37) goto L38;
            if (r20 == false) goto L41;
            if (r21 == false) goto L38;
            if (e(r16, r10, r18) == false) goto L41;
        L38:
            r15.n0(r12);
        L41:
            if (r11 != null) goto L43;
            r11 = new okio.d();
        L43:
            if (r24 != null) goto L45;
        L48:
            r11.n0(r12);
        L50:
            if (r11.n() == true) goto L52;
            int r14 = r11.readByte() & 255;
            r15.c0(37);
            r15.c0(s.a()[(r14 >> 4) & 15]);
            r15.c0(s.a()[r14 & 15]);
            goto L50
        L45:
            if (Intrinsics.areEqual(r24, StandardCharsets.UTF_8) == true) goto L48;
            r11.k0(r16, r10, Character.charCount(r12) + r10, r24);
            goto L50
        }

        private final void m(okio.d r10, String r11, int r12, int r13, boolean r14) {
        L2:
            if (r12 >= r13) goto L16;
            int r15 = r11.codePointAt(r12);
            if (r15 != 37) goto L12;
            int r16 = r12 + 2;
            if (r16 >= r13) goto L12;
            int r17 = hc.e.H(r11.charAt(r12 + 1));
            int r18 = hc.e.H(r11.charAt(r16));
            if (r17 == (-1)) goto L15;
            if (r18 == (-1)) goto L15;
            r10.c0((r17 << 4) + r18);
            r12 = r16 + Character.charCount(r15);
        L15:
            r10.n0(r15);
            r12 = r12 + Character.charCount(r15);
        L12:
            if (r15 != 43) goto L15;
            if (r14 == false) goto L15;
            r10.c0(32);
            r12 = r12 + 1;
            goto L2
        }

        public final String a(String r13, int r14, int r15, String r16, boolean r17, boolean r18, boolean r19, boolean r20, Charset r21) {
            Intrinsics.checkNotNullParameter(r13, "<this>");
            Intrinsics.checkNotNullParameter(r16, "encodeSet");
            int r10 = r14;
        L3:
            if (r10 >= r15) goto L29;
            int r11 = r13.codePointAt(r10);
            if (r11 < 32) goto L27;
            if (r11 == 127) goto L27;
            if (r11 < 128) goto L12;
            if (r20 == false) goto L27;
        L12:
            if (StringsKt.contains$default(r16, (char) r11, false, 2, null) == true) goto L27;
            if (r11 != 37) goto L22;
            if (r17 == false) goto L27;
            if (r18 == false) goto L22;
            if (e(r13, r10, r15) == false) goto L27;
        L22:
            if (r11 != 43) goto L25;
            if (r19 == true) goto L27;
        L25:
            r10 = r10 + Character.charCount(r11);
        L27:
            okio.d r12 = new okio.d();
            r12.m0(r13, r14, r10);
            l(r12, r13, r10, r15, r16, r17, r18, r19, r20, r21);
            return r12.J();
        L29:
            String r22 = r13.substring(r14, r15);
            Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String…ing(startIndex, endIndex)");
            return r22;
        }

        @JvmStatic
        public final int c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "scheme");
            if (Intrinsics.areEqual(r10, "http") == false) goto L6;
            return 80;
        L6:
            if (Intrinsics.areEqual(r10, "https") == false) goto L8;
            return 443;
        L8:
            return -1;
        }

        @JvmStatic
        @JvmName(name = "get")
        public final s d(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return new a().i(null, r10, false).b();
        }

        @JvmStatic
        @JvmName(name = "parse")
        public final s f(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return d(r10);
        L5:
            return null;
        }

        public final String g(String r10, int r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            int r14 = r11;
        L3:
            if (r14 >= r12) goto L13;
            char r15 = r10.charAt(r14);
            if (r15 == '%') goto L11;
            if (r15 != '+') goto L10;
            if (r13 == true) goto L11;
        L10:
            r14 = r14 + 1;
        L11:
            okio.d r16 = new okio.d();
            r16.m0(r10, r11, r14);
            m(r16, r10, r14, r12, r13);
            return r16.J();
        L13:
            String r17 = r10.substring(r11, r12);
            Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String…ing(startIndex, endIndex)");
            return r17;
        }

        public final void i(List<String> r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "out");
            int r12 = r10.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11.append('/');
            r11.append(r10.get(r13));
            r13 = r13 + 1;
            goto L3
        }

        public final List<String> j(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            ArrayList r11 = new ArrayList();
            int r12 = 0;
        L4:
            if (r12 > r10.length()) goto L15;
            int r13 = StringsKt.indexOf$default(r10, Typography.amp, r12, false, 4, null);
            if (r13 != (-1)) goto L8;
            r13 = r10.length();
        L8:
            int r14 = r13;
            int r15 = StringsKt.indexOf$default(r10, '=', r12, false, 4, null);
            if (r15 == (-1)) goto L13;
            if (r15 > r14) goto L13;
            String r16 = r10.substring(r12, r15);
            Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String…ing(startIndex, endIndex)");
            r11.add(r16);
            String r17 = r10.substring(r15 + 1, r14);
            Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String…ing(startIndex, endIndex)");
        L14:
            r11.add(r17);
            r12 = r14 + 1;
        L13:
            String r18 = r10.substring(r12, r14);
            Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
            r11.add(r18);
            r17 = null;
            goto L14
        L15:
            return r11;
        }

        public final void k(List<String> r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "out");
            IntProgression r12 = RangesKt.step(RangesKt.until(0, r10.size()), 2);
            int r13 = r12.getFirst();
            int r14 = r12.getLast();
            int r15 = r12.getStep();
            if (r15 <= 0) goto L5;
            if (r13 > r14) goto L5;
        L7:
            String r16 = r10.get(r13);
            String r17 = r10.get(r13 + 1);
            if (r13 <= 0) goto L10;
            r11.append(Typography.amp);
        L10:
            r11.append(r16);
            if (r17 == null) goto L13;
            r11.append('=');
            r11.append(r17);
        L13:
            if (r13 == r14) goto L19;
            r13 = r13 + r15;
            goto L7
        L19:
            return;
        L5:
            if (r15 >= 0) goto L15;
            if (r14 <= r13) goto L7;
            return;
        }
    }

    static {
        f12025k = new b(null);
        f12026l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public s(String r10, String r11, String r12, String r13, int r14, List<String> r15, List<String> r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "scheme");
        Intrinsics.checkNotNullParameter(r11, "username");
        Intrinsics.checkNotNullParameter(r12, "password");
        Intrinsics.checkNotNullParameter(r13, "host");
        Intrinsics.checkNotNullParameter(r15, "pathSegments");
        Intrinsics.checkNotNullParameter(r18, "url");
        this.f12027a = r10;
        this.f12028b = r11;
        this.f12029c = r12;
        this.f12030d = r13;
        this.f12031e = r14;
        this.f12032f = r15;
        this.f12033g = r16;
        this.f12034h = r17;
        this.f12035i = r18;
        this.f12036j = Intrinsics.areEqual(r10, "https");
    }

    public static final /* synthetic */ char[] a() {
        return f12026l;
    }

    @JvmStatic
    @JvmName(name = "parse")
    public static final s m(String r10) {
        return f12025k.f(r10);
    }

    @JvmName(name = "encodedFragment")
    public final String b() {
        if (this.f12034h != null) goto L6;
        return null;
    L6:
        int r10 = StringsKt.indexOf$default(this.f12035i, '#', 0, false, 6, null) + 1;
        String r11 = this.f12035i.substring(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).substring(startIndex)");
        return r11;
    }

    @JvmName(name = "encodedPassword")
    public final String c() {
        if (this.f12029c.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        return "";
    L9:
        String r11 = this.f12035i.substring(StringsKt.indexOf$default(this.f12035i, ':', this.f12027a.length() + 3, false, 4, null) + 1, StringsKt.indexOf$default(this.f12035i, '@', 0, false, 6, null));
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L5:
        r10 = false;
        goto L6
    }

    @JvmName(name = "encodedPath")
    public final String d() {
        int r10 = StringsKt.indexOf$default(this.f12035i, '/', this.f12027a.length() + 3, false, 4, null);
        String r11 = this.f12035i;
        int r12 = hc.e.q(r11, "?#", r10, r11.length());
        String r13 = this.f12035i.substring(r10, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    }

    @JvmName(name = "encodedPathSegments")
    public final List<String> e() {
        int r10 = StringsKt.indexOf$default(this.f12035i, '/', this.f12027a.length() + 3, false, 4, null);
        String r11 = this.f12035i;
        int r12 = hc.e.q(r11, "?#", r10, r11.length());
        ArrayList r13 = new ArrayList();
    L3:
        if (r10 >= r12) goto L5;
        int r14 = r10 + 1;
        int r15 = hc.e.p(this.f12035i, '/', r14, r12);
        String r16 = this.f12035i.substring(r14, r15);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String…ing(startIndex, endIndex)");
        r13.add(r16);
        r10 = r15;
        goto L3
    L5:
        return r13;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof s) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((s) r10).f12035i, this.f12035i) == false) goto L7;
        return true;
    }

    @JvmName(name = "encodedQuery")
    public final String f() {
        if (this.f12033g != null) goto L6;
        return null;
    L6:
        int r10 = StringsKt.indexOf$default(this.f12035i, '?', 0, false, 6, null) + 1;
        String r11 = this.f12035i;
        int r12 = hc.e.p(r11, '#', r10, r11.length());
        String r13 = this.f12035i.substring(r10, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    }

    @JvmName(name = "encodedUsername")
    public final String g() {
        if (this.f12028b.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        return "";
    L9:
        int r11 = this.f12027a.length() + 3;
        String r12 = this.f12035i;
        int r13 = hc.e.q(r12, ":@", r11, r12.length());
        String r14 = this.f12035i.substring(r11, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L5:
        r10 = false;
        goto L6
    }

    @JvmName(name = "host")
    public final String h() {
        return this.f12030d;
    }

    public int hashCode() {
        return this.f12035i.hashCode();
    }

    public final boolean i() {
        return this.f12036j;
    }

    public final a j() {
        a r10 = new a();
        r10.v(this.f12027a);
        r10.s(g());
        r10.r(c());
        r10.t(this.f12030d);
        if (this.f12031e == f12025k.c(this.f12027a)) goto L5;
        int r11 = this.f12031e;
    L6:
        r10.u(r11);
        r10.e().clear();
        r10.e().addAll(e());
        r10.d(f());
        r10.q(b());
        return r10;
    L5:
        r11 = -1;
        goto L6
    }

    public final a k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "link");
        return new a().i(this, r10, false);
    L5:
        return null;
    }

    public final a l(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "link");
        return new a().i(this, r10, r11);
    L5:
        return null;
    }

    @JvmName(name = "port")
    public final int n() {
        return this.f12031e;
    }

    @JvmName(name = "query")
    public final String o() {
        if (this.f12033g != null) goto L6;
        return null;
    L6:
        StringBuilder r10 = new StringBuilder();
        f12025k.k(this.f12033g, r10);
        return r10.toString();
    }

    public final String p() {
        a r10 = k("/...");
        Intrinsics.checkNotNull(r10);
        return r10.x("").j("").b().toString();
    }

    public final s q(String r10) {
        Intrinsics.checkNotNullParameter(r10, "link");
        a r11 = k(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.b();
    }

    public final s r(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "link");
        a r12 = l(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.b();
    }

    @JvmName(name = "scheme")
    public final String s() {
        return this.f12027a;
    }

    @JvmName(name = "uri")
    public final URI t() {
        String r10 = j().n().toString();
        return new URI(r10);
    L5:
        e = move-exception;
        URI r11 = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(r10, ""));     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r11, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
        return r11;
    L10:
        throw new RuntimeException(e);
    }

    public String toString() {
        return this.f12035i;
    }

    @JvmName(name = "url")
    public final URL u() {
        return new URL(this.f12035i);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
