package okhttp3;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.UByte;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.ttnet.TTConfigManager;
import okio.Buffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;

    @Nullable
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    public static final class a {

        @Nullable
        public String a;
        public String b;
        public String c;

        @Nullable
        public String d;
        public int e;
        public final List<String> f;

        @Nullable
        public List<String> g;

        @Nullable
        public String h;

        public final HttpUrl b() {
            if (this.a == null) goto L11;
            if (this.d == null) goto L9;
            return new HttpUrl(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.a;
            if (r1 == null) goto L5;
            r0.append(r1);
            r0.append("://");
        L7:
            if (this.b.isEmpty() == true) goto L9;
        L10:
            r0.append(this.b);
            if (this.c.isEmpty() == true) goto L13;
            r0.append(':');
            r0.append(this.c);
        L13:
            r0.append('@');
        L14:
            String r2 = this.d;
            if (r2 != null) goto L17;
        L20:
            int r3 = this.e;
            if (r3 == (-1)) goto L23;
        L24:
            if (r3 != (-1)) goto L27;
            r3 = HttpUrl.defaultPort(this.a);
        L27:
            String r4 = this.a;
            if (r4 != null) goto L30;
        L31:
            r0.append(':');
            r0.append(r3);
        L32:
            HttpUrl.pathSegmentsToString(r0, this.f);
            if (this.g == null) goto L36;
            r0.append('?');
            HttpUrl.namesAndValuesToQueryString(r0, this.g);
        L36:
            if (this.h == null) goto L39;
            r0.append('#');
            r0.append(this.h);
        L39:
            return r0.toString();
        L30:
            if (r3 == HttpUrl.defaultPort(r4)) goto L32;
        L23:
            if (this.a == null) goto L32;
        L17:
            if (r2.indexOf(58) == (-1)) goto L19;
            r0.append('[');
            r0.append(this.d);
            r0.append(']');
            goto L20
        L19:
            r0.append(this.d);
            goto L20
        L9:
            if (this.c.isEmpty() == true) goto L14;
        L5:
            r0.append("//");
            goto L7
        }

        public a() {
            this.b = HttpUrl.FRAGMENT_ENCODE_SET;
            this.c = HttpUrl.FRAGMENT_ENCODE_SET;
            this.e = -1;
            ArrayList r1 = new ArrayList();
            this.f = r1;
            r1.add(HttpUrl.FRAGMENT_ENCODE_SET);
        }

        public final void c(String r3) {
            if (r3 == null) goto L10;
            String r0 = cvc.c.c(HttpUrl.percentDecode(r3, 0, r3.length(), false));
            if (r0 == null) goto L8;
            this.d = r0;
            return;
        L8:
            throw new IllegalArgumentException("unexpected host: ".concat(r3));
        L10:
            throw new NullPointerException("host == null");
        }

        public final void g(String r3) {
            if (r3 == null) goto L13;
            if (r3.equalsIgnoreCase("http") == false) goto L7;
            this.a = "http";
            return;
        L7:
            if (r3.equalsIgnoreCase("https") == false) goto L11;
            this.a = "https";
            return;
        L11:
            throw new IllegalArgumentException("unexpected scheme: ".concat(r3));
        L13:
            throw new NullPointerException("scheme == null");
        }

        public a query(@Nullable String r7) {
            if (r7 == null) goto L4;
            List<String> r8 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r7, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
        L5:
            this.g = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        public final void a(String r8, @Nullable String r9) {
            if (r8 == null) goto L13;
            if (this.g != null) goto L6;
            this.g = new ArrayList();
        L6:
            this.g.add(HttpUrl.canonicalize(r8, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            List<String> r10 = this.g;
            if (r9 == null) goto L9;
            String r11 = HttpUrl.canonicalize(r9, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
        L10:
            r10.add(r11);
            return;
        L9:
            r11 = null;
            goto L10
        L13:
            throw new NullPointerException("name == null");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void d(@Nullable HttpUrl r26, String r27) {
            int r8 = cvc.c.t(r27, 0, r27.length());
            int r12 = cvc.c.u(r27, r8, r27.length());
            byte r14 = -1;
            if ((r12 - r8) < 2) goto L33;
            char r2 = r27.charAt(r8);
            char r3 = 'Z';
            if (r2 < 'a') goto L8;
            if (r2 > 'z') goto L8;
        L11:
            int r4 = r8;
        L12:
            r4 = r4 + 1;
            if (r4 >= r12) goto L33;
            char r7 = r27.charAt(r4);
            if (r7 < 'a') goto L17;
            if (r7 > 'z') goto L17;
        L32:
            r3 = 'Z';
        L17:
            if (r7 < 'A') goto L20;
            if (r7 <= r3) goto L32;
        L20:
            if (r7 < '0') goto L24;
            if (r7 <= '9') goto L32;
        L24:
            if (r7 == '+') goto L32;
            if (r7 == '-') goto L32;
            if (r7 == '.') goto L32;
            if (r7 != ':') goto L33;
            int r9 = r4;
        L34:
            if (r9 == (-1)) goto L43;
            int r15 = r9;
            if (r27.regionMatches(true, r8, "https:", 0, 6) == false) goto L39;
            this.a = "https";
            r8 = r8 + 6;
        L45:
            int r5 = r8;
            int r6 = 0;
        L46:
            byte r16 = 92;
            byte r10 = 47;
            if (r5 >= r12) goto L52;
            char r11 = r27.charAt(r5);
            if (r11 == '\\') goto L51;
            if (r11 != '/') goto L52;
        L51:
            r6 = r6 + 1;
            r5 = r5 + 1;
        L52:
            if (r6 >= 2) goto L55;
        L64:
            boolean r13 = false;
        L65:
            byte r17 = 63;
            byte r18 = 35;
            if (r13 == true) goto L80;
            if (r26 == null) goto L80;
            if (r26.scheme.equals(this.a) == false) goto L80;
            this.b = r26.encodedUsername();
            this.c = r26.encodedPassword();
            this.d = r26.host;
            this.e = r26.port;
            ((ArrayList) this.f).clear();
            ((ArrayList) this.f).addAll(r26.encodedPathSegments());
            if (r8 != r12) goto L74;
        L75:
            String r19 = r26.encodedQuery();
            if (r19 == null) goto L78;
            List<String> r1 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r19, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
        L79:
            this.g = r1;
        L142:
            int r20 = cvc.c.j(r27, r8, r12, "?#");
            f(r27, r8, r20);
            if (r20 < r12) goto L145;
        L147:
            char r110 = '#';
        L148:
            if (r20 < r12) goto L150;
            return;
        L150:
            if (r27.charAt(r20) != r110) goto L186;
            this.h = HttpUrl.canonicalize(r27, 1 + r20, r12, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false, false, null);
            return;
        L186:
            return;
        L145:
            if (r27.charAt(r20) != '?') goto L147;
            r110 = '#';
            int r111 = cvc.c.i(r27, r20, r12, '#');
            this.g = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r27, r20 + 1, r111, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
            r20 = r111;
            goto L148
        L78:
            r1 = null;
            goto L79
        L74:
            if (r27.charAt(r8) != '#') goto L142;
        L80:
            int r21 = r8 + r6;
            boolean r112 = false;
            boolean r113 = false;
        L81:
            int r22 = cvc.c.j(r27, r21, r12, "@/\\?#");
            if (r22 == r12) goto L84;
            byte r23 = r27.charAt(r22);
        L85:
            if (r23 == r14) goto L105;
            if (r23 == r18) goto L105;
            if (r23 == r10) goto L105;
            if (r23 == r16) goto L105;
            if (r23 == r17) goto L105;
            if (r23 == 64) goto L94;
        L104:
            r18 = 35;
            r10 = 47;
            r17 = 63;
            r14 = -1;
            r16 = 92;
            goto L81
        L94:
            if (r112 == true) goto L102;
            int r24 = cvc.c.i(r27, r21, r22, ':');
            int r114 = r22;
            String r25 = HttpUrl.canonicalize(r27, r21, r24, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            if (r113 == false) goto L98;
            r25 = this.b + "%40" + r25;
        L98:
            this.b = r25;
            if (r24 == r114) goto L101;
            this.c = HttpUrl.canonicalize(r27, r24 + 1, r114, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            r112 = true;
        L101:
            r113 = true;
        L103:
            r21 = r114 + 1;
            goto L104
        L102:
            r114 = r22;
            this.c += "%40" + HttpUrl.canonicalize(r27, r21, r114, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        L105:
            int r28 = r21;
        L106:
            if (r28 >= r22) goto L119;
            char r29 = r27.charAt(r28);
            if (r29 == ':') goto L118;
            if (r29 == '[') goto L112;
            int r30 = 1;
        L117:
            r28 = r28 + r30;
            goto L106
        L112:
            r30 = 1;
        L113:
            r28 = r28 + 1;
            if (r28 >= r22) goto L117;
            if (r27.charAt(r28) != ']') goto L113;
        L118:
            int r115 = r28;
        L120:
            int r116 = r115 + 1;
            if (r116 >= r22) goto L138;
            this.d = cvc.c.c(HttpUrl.percentDecode(r27, r21, r115, false));
            int r210 = r21;
            int r31 = CastIntegerProtector.parseInt(HttpUrl.canonicalize(r27, r116, r22, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, true, null));     // Catch: NumberFormatException -> L157
            if (r31 <= 0) goto L132;
            if (r31 > 65535) goto L132;
        L133:
            this.e = r31;
            if (r31 == (-1)) goto L137;
            r21 = r210;
        L140:
            if (this.d == null) goto L154;
            r8 = r22;
            goto L142
        L154:
            throw new IllegalArgumentException("Invalid URL host: \"" + r27.substring(r21, r115) + '\"');
        L137:
            throw new IllegalArgumentException("Invalid URL port: \"" + r27.substring(r116, r22) + '\"');
        L132:
            r31 = -1;
            goto L133
        L138:
            this.d = cvc.c.c(HttpUrl.percentDecode(r27, r21, r115, false));
            this.e = HttpUrl.defaultPort(this.a);
            goto L140
        L119:
            r115 = r22;
            goto L120
        L84:
            r23 = -1;
            goto L85
        L55:
            if (TTConfigManager.isIgnoreSlashEnabled() == true) goto L58;
        L63:
            r13 = true;
            goto L65
        L58:
            if (TextUtils.isEmpty(r27) == true) goto L64;
            if (r27.startsWith("https://") == true) goto L63;
            if (r27.startsWith("http://") == false) goto L64;
        L39:
            if (r27.regionMatches(true, r8, "http:", 0, 5) == false) goto L42;
            this.a = "http";
            r8 = r8 + 5;
            goto L45
        L42:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r27.substring(0, r15) + "'");
        L43:
            if (r26 == null) goto L156;
            this.a = r26.scheme;
            goto L45
        L156:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L8:
            if (r2 < 'A') goto L33;
            if (r2 <= 'Z') goto L11;
        L33:
            r9 = -1;
            goto L34
        }

        public final void f(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r0 = r11.charAt(r12);
            if (r0 != '/') goto L7;
        L10:
            ((ArrayList) this.f).clear();
            ((ArrayList) this.f).add(HttpUrl.FRAGMENT_ENCODE_SET);
            r12 = r12 + 1;
        L11:
            int r6 = r12;
            if (r6 >= r13) goto L20;
            r12 = cvc.c.j(r11, r6, r13, "/\\");
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            e(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r12 = r12 + 1;
            goto L11
        L16:
            r1 = false;
            goto L17
        L20:
            return;
        L7:
            if (r0 == '\\') goto L10;
            List<String> r2 = this.f;
            ListProtector.set(r2, ((ArrayList) r2).size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
            goto L11
        }

        public final void e(String r10, int r11, int r12, boolean r13, boolean r14) {
            String r15 = HttpUrl.canonicalize(r10, r11, r12, HttpUrl.PATH_SEGMENT_ENCODE_SET, r14, false, false, true, null);
            boolean r16 = false;
            if (r15.equals(".") == false) goto L5;
        L8:
            boolean r17 = true;
        L9:
            if (r17 == false) goto L12;
            return;
        L12:
            if (r15.equals(DownloadConstants.VULNERABILITY_PATH) == false) goto L14;
        L19:
            r16 = true;
        L21:
            if (r16 == false) goto L29;
            List<String> r18 = this.f;
            if (((String) ListProtector.remove(r18, ((ArrayList) r18).size() - 1)).isEmpty() == true) goto L25;
        L27:
            ((ArrayList) this.f).add(HttpUrl.FRAGMENT_ENCODE_SET);
            return;
        L25:
            if (((ArrayList) this.f).isEmpty() == true) goto L27;
            List<String> r19 = this.f;
            ListProtector.set(r19, ((ArrayList) r19).size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
            return;
        L29:
            List<String> r110 = this.f;
            if (((String) ListProtector.get(r110, ((ArrayList) r110).size() - 1)).isEmpty() == false) goto L32;
            List<String> r111 = this.f;
            ListProtector.set(r111, ((ArrayList) r111).size() - 1, r15);
        L33:
            if (r13 == false) goto L37;
            ((ArrayList) this.f).add(HttpUrl.FRAGMENT_ENCODE_SET);
            return;
        L37:
            return;
        L32:
            ((ArrayList) this.f).add(r15);
            goto L33
        L14:
            if (r15.equalsIgnoreCase("%2e.") == true) goto L19;
            if (r15.equalsIgnoreCase(".%2e") == true) goto L19;
            if (r15.equalsIgnoreCase("%2e%2e") == false) goto L21;
        L5:
            if (r15.equalsIgnoreCase("%2e") == true) goto L8;
            r17 = false;
            goto L9
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    @Nullable
    public String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r0 = this.url.indexOf(35) + 1;
        return this.url.substring(r0);
    }

    public String encodedPassword() {
        if (this.password.isEmpty() == false) goto L6;
        return FRAGMENT_ENCODE_SET;
    L6:
        int r0 = this.url.indexOf(58, this.scheme.length() + 3) + 1;
        int r1 = this.url.indexOf(64);
        return this.url.substring(r0, r1);
    }

    public String encodedPath() {
        int r0 = this.url.indexOf(47, this.scheme.length() + 3);
        String r1 = this.url;
        int r2 = cvc.c.j(r1, r0, r1.length(), "?#");
        return this.url.substring(r0, r2);
    }

    public List<String> encodedPathSegments() {
        int r0 = this.url.indexOf(47, this.scheme.length() + 3);
        String r1 = this.url;
        int r2 = cvc.c.j(r1, r0, r1.length(), "?#");
        ArrayList r3 = new ArrayList();
    L3:
        if (r0 >= r2) goto L5;
        int r4 = r0 + 1;
        int r5 = cvc.c.i(this.url, r4, r2, '/');
        r3.add(this.url.substring(r4, r5));
        r0 = r5;
        goto L3
    L5:
        return r3;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r0 = this.url.indexOf(63) + 1;
        String r1 = this.url;
        int r2 = cvc.c.i(r1, r0, r1.length(), '#');
        return this.url.substring(r0, r2);
    }

    public String encodedUsername() {
        if (this.username.isEmpty() == false) goto L6;
        return FRAGMENT_ENCODE_SET;
    L6:
        int r0 = this.scheme.length() + 3;
        String r1 = this.url;
        int r2 = cvc.c.j(r1, r0, r1.length(), ":@");
        return this.url.substring(r0, r2);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public a newBuilder() {
        a r0 = new a();
        r0.a = this.scheme;
        r0.b = encodedUsername();
        r0.c = encodedPassword();
        r0.d = this.host;
        if (this.port == defaultPort(this.scheme)) goto L5;
        int r1 = this.port;
    L6:
        r0.e = r1;
        ((ArrayList) r0.f).clear();
        List<String> r2 = r0.f;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(encodedPathSegments());
        String r4 = encodedQuery();
        if (r4 == null) goto L9;
        List<String> r5 = queryStringToNamesAndValues(canonicalize(r4, QUERY_ENCODE_SET, true, false, true, true));
    L10:
        r0.g = r5;
        r0.h = encodedFragment();
        return r0;
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    @Nullable
    public String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        namesAndValuesToQueryString(r0, this.queryNamesAndValues);
        return r0.toString();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = this.queryNamesAndValues.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        r0.add(ListProtector.get(this.queryNamesAndValues, r2));
        r2 = r2 + 2;
        goto L7
    L10:
        return Collections.unmodifiableSet(r0);
    L5:
        return Collections.emptySet();
    }

    public int querySize() {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size() / 2;
    }

    public String redact() {
        a r0 = newBuilder("/...");
        r0.getClass();
        r0.b = canonicalize(FRAGMENT_ENCODE_SET, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        r0.c = canonicalize(FRAGMENT_ENCODE_SET, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return r0.b().toString();
    }

    @Nullable
    public String topPrivateDomain() {
        if (cvc.c.x(this.host) == false) goto L7;
        return null;
    L7:
        return PublicSuffixDatabase.h.b(this.host);
    }

    public URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public URI uri() {
        a r0 = newBuilder();
        int r1 = ((ArrayList) r0.f).size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String r5 = (String) ListProtector.get(r0.f, r3);
        ListProtector.set(r0.f, r3, canonicalize(r5, PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
        r3 = r3 + 1;
        goto L3
    L5:
        List<String> r4 = r0.g;
        if (r4 == null) goto L13;
        int r6 = r4.size();
    L8:
        if (r2 >= r6) goto L13;
        String r7 = (String) ListProtector.get(r0.g, r2);
        if (r7 == null) goto L12;
        ListProtector.set(r0.g, r2, canonicalize(r7, QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
    L12:
        r2 = r2 + 1;
    L13:
        String r8 = r0.h;
        if (r8 == null) goto L16;
        r0.h = canonicalize(r8, FRAGMENT_ENCODE_SET_URI, true, true, false, false);
    L16:
        String r9 = r0.toString();
        return new URI(r9);
    L19:
        e = move-exception;
        return URI.create(r9.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", FRAGMENT_ENCODE_SET));
    L23:
        throw new RuntimeException(e);
    }

    @Nullable
    public String fragment() {
        return this.fragment;
    }

    public String host() {
        return this.host;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int port() {
        return this.port;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public String username() {
        return this.username;
    }

    public HttpUrl(a r5) {
        this.scheme = r5.a;
        this.username = percentDecode(r5.b, false);
        this.password = percentDecode(r5.c, false);
        this.host = r5.d;
        int r0 = r5.e;
        if (r0 != (-1)) goto L6;
        r0 = defaultPort(r5.a);
    L6:
        this.port = r0;
        this.pathSegments = percentDecode(r5.f, false);
        List<String> r1 = r5.g;
        String r2 = null;
        if (r1 == null) goto L9;
        List<String> r3 = percentDecode(r1, true);
    L10:
        this.queryNamesAndValues = r3;
        String r4 = r5.h;
        if (r4 == null) goto L13;
        r2 = percentDecode(r4, false);
    L13:
        this.fragment = r2;
        this.url = r5.toString();
        return;
    L9:
        r3 = null;
        goto L10
    }

    public static int defaultPort(String r1) {
        if (r1.equals("http") == false) goto L7;
        return 80;
    L7:
        if (r1.equals("https") == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    public static HttpUrl get(String r2) {
        a r0 = new a();
        r0.d(null, r2);
        return r0.b();
    }

    @Nullable
    public static HttpUrl parse(String r0) {
        return get(r0);
    L4:
        return null;
    }

    public static List<String> queryStringToNamesAndValues(String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 > r5.length()) goto L15;
        int r2 = r5.indexOf(38, r1);
        if (r2 != (-1)) goto L8;
        r2 = r5.length();
    L8:
        int r4 = r5.indexOf(61, r1);
        if (r4 == (-1)) goto L13;
        if (r4 > r2) goto L13;
        r0.add(r5.substring(r1, r4));
        r0.add(r5.substring(r4 + 1, r2));
    L14:
        r1 = r2 + 1;
    L13:
        r0.add(r5.substring(r1, r2));
        r0.add(null);
        goto L14
    L15:
        return r0;
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HttpUrl) r2).url.equals(this.url) == false) goto L7;
        return true;
    }

    @Nullable
    public a newBuilder(String r2) {
        a r0 = new a();     // Catch: IllegalArgumentException -> L4
        r0.d(this, r2);     // Catch: IllegalArgumentException -> L4
        return r0;
    L4:
        return null;
    }

    @Nullable
    public String queryParameter(String r5) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r5.equals(ListProtector.get(this.queryNamesAndValues, r2)) == true) goto L10;
        r2 = r2 + 2;
        goto L6
    L10:
        return (String) ListProtector.get(this.queryNamesAndValues, r2 + 1);
    L12:
        return null;
    }

    public String queryParameterName(int r2) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return (String) ListProtector.get(r0, r2 * 2);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public String queryParameterValue(int r2) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return (String) ListProtector.get(r0, (r2 * 2) + 1);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String r6) {
        if (this.queryNamesAndValues == null) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = this.queryNamesAndValues.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r6.equals(ListProtector.get(this.queryNamesAndValues, r2)) == false) goto L11;
        r0.add(ListProtector.get(this.queryNamesAndValues, r2 + 1));
    L11:
        r2 = r2 + 2;
        goto L7
    L13:
        return Collections.unmodifiableList(r0);
    L5:
        return Collections.emptyList();
    }

    @Nullable
    public HttpUrl resolve(String r1) {
        a r2 = newBuilder(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }

    @Nullable
    public static HttpUrl get(URI r0) {
        return parse(r0.toString());
    }

    @Nullable
    public static HttpUrl get(URL r0) {
        return parse(r0.toString());
    }

    public static void namesAndValuesToQueryString(StringBuilder r5, List<String> r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = (String) ListProtector.get(r6, r1);
        String r3 = (String) ListProtector.get(r6, r1 + 1);
        if (r1 <= 0) goto L7;
        r5.append('&');
    L7:
        r5.append(r2);
        if (r3 == null) goto L10;
        r5.append('=');
        r5.append(r3);
    L10:
        r1 = r1 + 2;
        goto L3
    }

    public static void pathSegmentsToString(StringBuilder r3, List<String> r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.append('/');
        r3.append((String) ListProtector.get(r4, r1));
        r1 = r1 + 1;
        goto L3
    }

    private List<String> percentDecode(List<String> r5, boolean r6) {
        int r0 = r5.size();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        String r3 = (String) ListProtector.get(r5, r2);
        if (r3 == null) goto L7;
        String r4 = percentDecode(r3, r6);
    L8:
        r1.add(r4);
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r1);
    }

    public static String percentDecode(String r2, boolean r3) {
        return percentDecode(r2, 0, r2.length(), r3);
    }

    public static boolean percentEncoded(String r2, int r3, int r4) {
        int r0 = r3 + 2;
        if (r0 < r4) goto L5;
    L11:
        return false;
    L5:
        if (r2.charAt(r3) != '%') goto L11;
        if (cvc.c.g(r2.charAt(r3 + 1)) == (-1)) goto L11;
        if (cvc.c.g(r2.charAt(r0)) == (-1)) goto L11;
        return true;
    }

    public static String percentDecode(String r3, int r4, int r5, boolean r6) {
        int r0 = r4;
    L3:
        if (r0 >= r5) goto L14;
        char r1 = r3.charAt(r0);
        if (r1 == '%') goto L11;
        if (r1 != '+') goto L10;
        if (r6 == true) goto L11;
    L10:
        r0 = r0 + 1;
    L11:
        Buffer r2 = new Buffer();
        r2.writeUtf8(r3, r4, r0);
        percentDecode(r2, r3, r0, r5, r6);
        return r2.readUtf8();
    L14:
        return r3.substring(r4, r5);
    }

    public static void percentDecode(Buffer r5, String r6, int r7, int r8, boolean r9) {
    L2:
        if (r7 >= r8) goto L17;
        int r0 = r6.codePointAt(r7);
        if (r0 != 37) goto L12;
        int r1 = r7 + 2;
        if (r1 >= r8) goto L12;
        int r2 = cvc.c.g(r6.charAt(r7 + 1));
        int r3 = cvc.c.g(r6.charAt(r1));
        if (r2 == (-1)) goto L15;
        if (r3 == (-1)) goto L15;
        r5.writeByte((r2 << 4) + r3);
        r7 = r1;
    L16:
        r7 = r7 + Character.charCount(r0);
    L15:
        r5.writeUtf8CodePoint(r0);
    L12:
        if (r0 != 43) goto L15;
        if (r9 == false) goto L15;
        r5.writeByte(32);
        goto L16
    }

    public static String canonicalize(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        return canonicalize(r9, 0, r9.length(), r10, r11, r12, r13, r14, null);
    }

    public static String canonicalize(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        return canonicalize(r9, 0, r9.length(), r10, r11, r12, r13, r14, r15);
    }

    public static String canonicalize(String r11, int r12, int r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, Charset r19) {
        int r2 = r12;
    L3:
        if (r2 >= r13) goto L28;
        int r0 = r11.codePointAt(r2);
        if (r0 < 32) goto L25;
        if (r0 == 127) goto L25;
        if (r0 < 128) goto L12;
        if (r18 == true) goto L25;
    L12:
        if (r14.indexOf(r0) != (-1)) goto L25;
        if (r0 != 37) goto L20;
        if (r15 == false) goto L25;
        if (r16 == false) goto L20;
        if (percentEncoded(r11, r2, r13) == false) goto L25;
    L20:
        if (r0 != 43) goto L23;
        if (r17 == true) goto L25;
    L23:
        r2 = r2 + Character.charCount(r0);
    L25:
        Buffer r10 = new Buffer();
        r10.writeUtf8(r11, r12, r2);
        canonicalize(r10, r11, r2, r13, r14, r15, r16, r17, r18, r19);
        return r10.readUtf8();
    L28:
        return r11.substring(r12, r13);
    }

    public static void canonicalize(Buffer r6, String r7, int r8, int r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        Buffer r0 = null;
    L3:
        if (r8 >= r9) goto L50;
        int r1 = r7.codePointAt(r8);
        if (r11 == false) goto L16;
        if (r1 == 9) goto L49;
        if (r1 == 10) goto L49;
        if (r1 == 12) goto L49;
        if (r1 != 13) goto L16;
    L49:
        r8 = r8 + Character.charCount(r1);
    L16:
        if (r1 != 43) goto L23;
        if (r13 == false) goto L23;
        if (r11 == false) goto L20;
        String r2 = "+";
    L21:
        r6.writeUtf8(r2);
        goto L49
    L20:
        r2 = "%2B";
    L23:
        if (r1 >= 32) goto L25;
    L38:
        if (r0 != null) goto L40;
        r0 = new Buffer();
    L40:
        if (r15 != null) goto L42;
    L45:
        r0.writeUtf8CodePoint(r1);
    L47:
        if (r0.exhausted() == true) goto L49;
        int r3 = r0.readByte() & UByte.MAX_VALUE;
        r6.writeByte(37);
        char[] r4 = HEX_DIGITS;
        r6.writeByte(r4[(r3 >> 4) & 15]);
        r6.writeByte(r4[r3 & 15]);
        goto L47
    L42:
        if (r15.equals(cvc.c.j) == true) goto L45;
        r0.writeString(r7, r8, Character.charCount(r1) + r8, r15);
        goto L47
    L25:
        if (r1 == 127) goto L38;
        if (r1 < 128) goto L30;
        if (r14 == true) goto L38;
    L30:
        if (r10.indexOf(r1) != (-1)) goto L38;
        if (r1 != 37) goto L37;
        if (r11 == false) goto L38;
        if (r12 == false) goto L37;
        if (percentEncoded(r7, r8, r9) == false) goto L38;
    L37:
        r6.writeUtf8CodePoint(r1);
        goto L49
    }
}
