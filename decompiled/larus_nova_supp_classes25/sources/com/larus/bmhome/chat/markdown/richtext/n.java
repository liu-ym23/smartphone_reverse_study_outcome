package com.larus.bmhome.chat.markdown.richtext;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.layout.holder.helper.r0;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final Regex a = null;
    public static final List<String> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Set<String> f = null;
    public static final Set<String> g = null;
    public static final Set<String> h = null;
    public static final Set<String> i = null;
    public static final Set<String> j = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((t) r1).c()), Integer.valueOf(((t) r2).c()));
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((t) r3).b()), Integer.valueOf(((t) r2).b()));
        }
    }

    public n() {
    }

    static {
        a = new Regex("oc_[A-Za-z0-9_-]+");
        b = CollectionsKt.listOf(new String[]{"user_id", "data-user-id", "data_user_id", "open_id", "id"});
        c = LazyKt.lazy(new k());
        d = LazyKt.lazy(new l());
        e = LazyKt.lazy(new m());
        f = SetsKt.setOf(new String[]{"bear-test.bytedance.net", "docs-staging.bytedance.net", "docs.bytedance.net", "doubao.com", "feishu-boe.cn", "feishu-pre.cn", "feishu-staging.cn", "feishu.cn", "feishu.net", "larkoffice-pre.com", "larkoffice.com", "larksuite-pre.com", "larksuite-staging.com", "larksuite.com"});
        g = SetsKt.setOf(new String[]{"base", "bitable", "doc", "docs", "docx", "file", "folder", "isv", "mindnote", "mindnotes", "sheet", "sheets", "slide", "slides", "wiki"});
        h = SetsKt.setOf(new String[]{"drive", "space"});
        i = SetsKt.setOf(new String[]{"app", "record"});
        j = SetsKt.setOf(new String[]{MemoryActionTag.MEMORY_ACTION_TAG_ADD, "record"});
    }

    public static final String a(String r12) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r12, "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null), "\"", "&quot;", false, 4, null), "'", "&#39;", false, 4, null);
    }

    public static String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length()) goto L14;
        int r3 = r5.codePointAt(r1);
        if (r3 > 127) goto L8;
        int r4 = 1;
    L9:
        r2 = r2 + r4;
        if (r2 > 32) goto L12;
        r1 = r1 + Character.charCount(r3);
        goto L4
    L12:
        return r5.substring(0, r1) + "...";
    L8:
        r4 = 2;
        goto L9
    L14:
        return r5;
    }

    public static List c(List r8) {
        List r9 = CollectionsKt.sortedWith(r8, new b(new a()));
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        t r1 = (t) r10.next();
        boolean r3 = true;
        if (r0.isEmpty() == true) goto L19;
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L19;
        t r4 = (t) r2.next();
        if (r1.c() < r4.b()) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L10;
        r3 = false;
        goto L19
    L14:
        if (r4.c() >= r1.b()) goto L16;
        r5 = true;
    L19:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L21:
        return r0;
    }

    public static List d(String r14) {
        ArrayList r0 = new ArrayList();
        Matcher r15 = ((Pattern) c.getValue()).matcher(r14);
    L4:
        if (r15.find() == false) goto L89;
        String r1 = r15.group();
        String r2 = "";
        if (r1 != null) goto L8;
        String r7 = "";
    L9:
        String r3 = r15.group(2);
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        boolean r4 = false;
        if (StringsKt.isBlank(r3) == false) goto L15;
        Map r5 = MapsKt.emptyMap();
    L31:
        String r6 = r15.group(3);
        if (r6 != null) goto L35;
        r6 = "";
    L35:
        if (StringsKt.isBlank(r6) == false) goto L51;
        r6 = (String) r5.get("name");
        if (r6 != null) goto L51;
        r6 = (String) r5.get("data-user-name");
        if (r6 != null) goto L51;
        r6 = (String) r5.get("display_name");
        if (r6 != null) goto L51;
        r6 = (String) r5.get("data_user_name");
        if (r6 != null) goto L51;
        r6 = (String) r5.get("user_name");
        if (r6 != null) goto L51;
        r6 = (String) r5.get(ChatDraftItem.TYPE_TEXT);
        if (r6 != null) goto L51;
        r6 = (String) r5.get("title");
        if (r6 != null) goto L51;
        r6 = "";
    L51:
        String r8 = StringsKt.trim(StringsKt.trimStart(StringsKt.trim(q(r6)).toString(), new char[]{'@'})).toString();
        if (r8.length() != 0) goto L54;
        boolean r9 = true;
    L55:
        if (r9 == true) goto L58;
        r2 = "@".concat(r8);
    L58:
        String r10 = r2;
        if (r10.length() <= 0) goto L61;
        boolean r11 = true;
    L62:
        if (r11 == false) goto L4;
        Pair r12 = j(r5);
        String r13 = (String) r12.component1();
        String r16 = (String) r12.component2();
        if (r13 != null) goto L68;
        if (r16 != null) goto L68;
        boolean r17 = false;
    L69:
        int r18 = r15.start();
        int r19 = r15.end();
        String r20 = (String) r5.get("avatar_key");
        if (r20 == null) goto L78;
        if (r17 == true) goto L73;
    L75:
        boolean r110 = false;
    L76:
        if (r110 == false) goto L78;
        String r111 = r20;
    L79:
        String r21 = (String) r5.get("entity_id");
        if (r21 == null) goto L87;
        if (r17 == true) goto L83;
    L85:
        if (r4 == false) goto L87;
    L88:
        r0.add(new f(r18, r19, r10, r7, r13, r16, r111, r21));
        goto L4
    L83:
        if ((!StringsKt.isBlank(r21)) == false) goto L85;
        r4 = true;
    L87:
        r21 = null;
        goto L88
    L73:
        if ((!StringsKt.isBlank(r20)) == false) goto L75;
        r110 = true;
    L78:
        r111 = null;
    L68:
        r17 = true;
        goto L69
    L61:
        r11 = false;
        goto L62
    L54:
        r9 = false;
        goto L55
    L15:
        LinkedHashMap r22 = new LinkedHashMap();
        Matcher r23 = ((Pattern) e.getValue()).matcher(r3);
    L17:
        if (r23.find() == false) goto L30;
        String r24 = r23.group(1);
        if (r24 != null) goto L21;
        r24 = "";
    L21:
        String r25 = r24.toLowerCase(Locale.ROOT);
        String r26 = r23.group(3);
        if (r26 != null) goto L25;
        r26 = "";
    L25:
        if (r25.length() <= 0) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L17;
        r22.put(r25, q(r26));
        goto L17
    L27:
        r112 = false;
        goto L28
    L30:
        r5 = r22;
        goto L31
    L8:
        r7 = r1;
        goto L9
    L89:
        return r0;
    }

    public static boolean g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "destination");
        return StringsKt.equals(UriProtector.parse(r2).getScheme(), "ailypartner", true);
    }

    public static boolean h(String r8) {
        Intrinsics.checkNotNullParameter(r8, "destination");
        Uri r9 = UriProtector.parse(r(r8));
        if (StringsKt.equals(r9.getScheme(), "https", true) == false) goto L5;
    L7:
        String r0 = r9.getHost();
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        String r1 = r0.toLowerCase(Locale.ROOT);
        Set<String> r3 = f;
        if ((r3 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) r4.next();
        if (Intrinsics.areEqual(r1, r5) == false) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == false) goto L17;
        boolean r2 = false;
    L28:
        if (r2 == false) goto L30;
        return false;
    L30:
        List<String> r10 = r9.getPathSegments();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L34;
        r7.add(((String) r11.next()).toLowerCase(Locale.ROOT));
        goto L32
    L34:
        boolean r12 = CollectionsKt.contains(h, CollectionsKt.firstOrNull(r7));
        if (CollectionsKt.contains(g, CollectionsKt.getOrNull(r7, r12 ? 1 : 0)) == false) goto L40;
        if (r7.size() <= ((r12 ? 1 : 0) + 1)) goto L40;
        return true;
    L40:
        if (r7.size() != 2) goto L45;
        if (i.contains(CollectionsKt.first(r7)) == false) goto L45;
        return true;
    L45:
        if (r7.size() == 4) goto L47;
    L53:
        return false;
    L47:
        if (Intrinsics.areEqual(ListProtector.get(r7, 0), "share") == false) goto L53;
        if (Intrinsics.areEqual(ListProtector.get(r7, 1), "base") == false) goto L53;
        if (j.contains(ListProtector.get(r7, 2)) == false) goto L53;
        return true;
    L21:
        if (StringsKt.endsWith$default(r1, "." + r5, false, 2, null) == true) goto L24;
        r6 = false;
    L27:
        r2 = true;
        goto L28
    L13:
        if (r3.isEmpty() == false) goto L15;
    L5:
        if (StringsKt.equals(r9.getScheme(), "http", true) == true) goto L7;
        return false;
    }

    public static boolean i(char r5) {
        if ('a' <= r5) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == false) goto L28;
        return true;
    L28:
        if (StringsKt.contains$default(".-~!@#$%^&*+?:_/=<>%", r5, false, 2, null) == true) goto L33;
        return false;
    L33:
        return true;
    L10:
        if ('A' <= r5) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L25;
        if ('0' <= r5) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == true) goto L25;
        r1 = false;
        goto L26
    L19:
        if (r5 >= ':') goto L21;
        r3 = true;
        goto L22
    L12:
        if (r5 >= '[') goto L14;
        r2 = true;
        goto L15
    L5:
        if (r5 >= '{') goto L7;
        r0 = true;
        goto L8
    }

    public static Pair j(Map r7) {
        String r0 = (String) r7.get("user_id");
        if (r0 != null) goto L11;
        r0 = (String) r7.get("data-user-id");
        if (r0 != null) goto L11;
        r0 = (String) r7.get("data_user_id");
        if (r0 != null) goto L11;
        r0 = (String) r7.get("open_id");
        if (r0 != null) goto L11;
        r0 = (String) r7.get("id");
    L11:
        boolean r1 = true;
        String r2 = null;
        if (r0 != null) goto L14;
    L16:
        r0 = null;
    L17:
        List<String> r3 = b;
        if ((r3 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L35;
        CharSequence r5 = (CharSequence) r7.get((String) r4.next());
        if (r5 != null) goto L28;
    L31:
        boolean r6 = true;
    L33:
        if ((!r6) == false) goto L24;
        boolean r8 = true;
    L36:
        CharSequence r9 = (CharSequence) r7.get("chat_id");
        if (r9 != null) goto L39;
    L42:
        boolean r10 = true;
    L43:
        boolean r11 = !r10;
        String r12 = (String) r7.get("chat_id");
        if (r12 == null) goto L52;
        if (r8 == false) goto L47;
    L49:
        r1 = false;
    L50:
        if (r1 == false) goto L52;
    L53:
        if (r11 == true) goto L56;
        r2 = r0;
    L56:
        return TuplesKt.to(r2, r12);
    L47:
        if (a.matches(r12) == false) goto L49;
    L52:
        r12 = null;
        goto L53
    L39:
        if (StringsKt.isBlank(r9) == true) goto L42;
        r10 = false;
        goto L43
    L28:
        if (StringsKt.isBlank(r5) == true) goto L31;
        r6 = false;
    L35:
        r8 = false;
        goto L36
    L20:
        if (r3.isEmpty() == false) goto L22;
    L14:
        if ((!StringsKt.isBlank(r0)) == false) goto L16;
        goto L16
    }

    public static String k(String r15) {
        Intrinsics.checkNotNullParameter(r15, "content");
        if (r15.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r15;
    L8:
        ArrayList r1 = (ArrayList) c(d(r15));
        if (r1.isEmpty() == false) goto L11;
        return r15;
    L11:
        StringBuilder r3 = new StringBuilder(r15.length());
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L13:
        if (r2.hasNext() == false) goto L56;
        t r5 = (t) r2.next();
        if (r5.c() < r4) goto L13;
        r3.append(r15, r4, r5.c());
        String r6 = null;
        if ((r5 instanceof f) == false) goto L20;
        f r7 = (f) r5;
    L21:
        if (r7 == null) goto L54;
        String r8 = r7.f;
        if (r8 == null) goto L26;
        Pair r9 = TuplesKt.to("chat_id", r8);
        if (r9 == null) goto L26;
    L29:
        String r10 = r7.g;
        if (r10 != null) goto L32;
    L53:
        if (r6 == null) goto L54;
    L55:
        r3.append(r6);
        r4 = r5.b();
        goto L13
    L32:
        if ((!StringsKt.isBlank(r10)) == true) goto L35;
        r10 = null;
    L35:
        if (r10 == null) goto L53;
        String r11 = r7.h;
        if (r11 == null) goto L53;
        Long r12 = StringsKt.toLongOrNull(r11);
        if (r12 == null) goto L42;
        long r13 = r12.longValue();
    L44:
        if (r13 <= 0) goto L46;
        boolean r14 = true;
    L47:
        if (r14 == true) goto L50;
        r11 = null;
    L50:
        if (r11 == null) goto L53;
        r6 = "<at " + ((String) r9.getFirst()) + "=\"" + a((String) r9.getSecond()) + "\" avatar_key=\"" + a(r10) + "\" entity_id=\"" + a(r11) + "\">" + a(r7.c) + "</at>";
        goto L53
    L46:
        r14 = false;
        goto L47
    L42:
        r13 = 0;
    L26:
        String r16 = r7.e;
        if (r16 == null) goto L53;
        r9 = TuplesKt.to("user_id", r16);
    L54:
        r6 = r5.a();
        goto L55
    L20:
        r7 = null;
        goto L21
    L56:
        r3.append(r15, r4, r15.length());
        return r3.toString();
    L5:
        r0 = false;
        goto L6
    }

    public static String l(String r2) {
        String r3 = StringsKt.trim(r2).toString();
        if (y0.e(r3) == false) goto L6;
        return r3;
    L6:
        return "https://" + r3;
    }

    public static r o(String r10) {
        Intrinsics.checkNotNullParameter(r10, "destination");
        Uri r11 = UriProtector.parse(r10);
        if (r11.isHierarchical() == true) goto L5;
        return null;
    L5:
        if (r11.getFragment() != null) goto L200;
        String r0 = r11.getScheme();
        if (r0 == null) goto L182;
        boolean r4 = false;
        switch(r0.hashCode()) {
            case -1963501277: goto L146;
            case 3143036: goto L104;
            case 109496913: goto L34;
            case 740154499: goto L13;
            default: goto L201;
        };
    L201:
        return null;
    L13:
        if (r0.equals("conversation") == false) goto L202;
        Intrinsics.checkNotNull(r11);
        String r1 = r11.getAuthority();
        if (r1 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r1)) == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L203;
        String r2 = r11.getPath();
        if (r2 != null) goto L26;
    L27:
        r4 = true;
    L28:
        if (r4 == true) goto L30;
        return null;
    L30:
        if (r11.getQuery() == null) goto L185;
        return null;
    L185:
        return new r.b(r1);
    L26:
        if (r2.length() != 0) goto L28;
    L203:
        return null;
    L202:
        return null;
    L34:
        if (r0.equals("skill") == false) goto L205;
        Set<Integer> r3 = s.a;
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (Intrinsics.areEqual(r11.getScheme(), "skill") == false) goto L186;
        String r5 = r11.getAuthority();
        if (r5 != null) goto L41;
    L44:
        boolean r6 = true;
    L45:
        if (r6 == true) goto L187;
        String r7 = r11.getPath();
        if (r7 != null) goto L49;
    L52:
        boolean r8 = true;
    L53:
        if (r8 == false) goto L206;
        String r9 = UriProtector.getQueryParameter(r11, "type");
        if (r9 == null) goto L188;
        Integer r12 = StringsKt.toIntOrNull(r9);
        if (r12 == null) goto L189;
        int r13 = r12.intValue();
        Integer r14 = Integer.valueOf(r13);
        if (r14 == null) goto L66;
        if (r14.intValue() != 4) goto L66;
        String r15 = "path";
    L69:
        if (r15 == null) goto L207;
        Set r16 = ArraysKt.toSet(new String[]{"type", r15});
        if (Intrinsics.areEqual(UriProtector.getQueryParameterNames(r11), r16) == false) goto L90;
        Set r17 = r16;
        if ((r17 instanceof Collection) == true) goto L76;
    L78:
        Iterator r18 = r17.iterator();
    L80:
        if (r18.hasNext() == false) goto L87;
        if (UriProtector.getQueryParameters(r11, (String) r18.next()).size() != 1) goto L84;
        boolean r19 = true;
    L85:
        if (r19 == true) goto L80;
        boolean r20 = false;
    L88:
        if (r20 == false) goto L90;
        r4 = true;
        goto L90
    L84:
        r19 = false;
    L87:
        r20 = true;
        goto L88
    L76:
        if (r17.isEmpty() == false) goto L78;
    L90:
        if (r4 == false) goto L208;
        String r110 = UriProtector.getQueryParameter(r11, r15);
        if (r110 != null) goto L95;
        return null;
    L95:
        if ((!StringsKt.isBlank(r110)) == true) goto L98;
        r110 = null;
    L98:
        if (r110 != null) goto L100;
        return null;
    L100:
        if (Intrinsics.areEqual(r15, "path") == false) goto L102;
        r r21 = new r.d(r13, null, r110, 2);
    L175:
        return r21;
    L102:
        r21 = new r.d(r13, r110, null, 4);
        goto L175
    L208:
        return null;
    L207:
        return null;
    L66:
        if (CollectionsKt.contains(s.a, r14) == false) goto L68;
        r15 = "id";
        goto L69
    L68:
        r15 = null;
        goto L69
    L189:
        return null;
    L188:
        return null;
    L206:
        return null;
    L49:
        if (r7.length() == 0) goto L52;
        r8 = false;
        goto L53
    L187:
        return null;
    L41:
        if (StringsKt.isBlank(r5) == true) goto L44;
        r6 = false;
        goto L45
    L186:
        return null;
    L205:
        return null;
    L104:
        if (r0.equals("file") == false) goto L209;
        Intrinsics.checkNotNull(r11);
        String r22 = r11.getAuthority();
        if (r22 != null) goto L109;
    L112:
        boolean r23 = true;
    L113:
        if (r23 == true) goto L115;
        return null;
    L115:
        if (f(r11, new String[]{"kind"}) == false) goto L210;
        String r24 = r11.getPath();
        if (r24 != null) goto L120;
        return null;
    L120:
        if (StringsKt.startsWith$default(r24, '/', false, 2, null) == true) goto L122;
    L124:
        if (r4 == true) goto L127;
        r24 = null;
    L127:
        if (r24 == null) goto L211;
        String r111 = UriProtector.getQueryParameter(r11, "kind");
        if (r111 == null) goto L194;
        int r25 = r111.hashCode();
        if (r25 == (-962584979)) goto L141;
        if (r25 == 3143036) goto L137;
        return null;
    L137:
        if (r111.equals("file") == false) goto L213;
        MessageFileKind r112 = MessageFileKind.FILE;
    L195:
        return new r.c(r24, r112);
    L213:
        return null;
    L141:
        if (r111.equals("directory") == false) goto L214;
        r112 = MessageFileKind.DIRECTORY;
        goto L195
    L214:
        return null;
    L194:
        return null;
    L211:
        return null;
    L122:
        if (r24.length() <= 1) goto L124;
        r4 = true;
        goto L124
    L210:
        return null;
    L109:
        if (r22.length() == 0) goto L112;
        r23 = false;
        goto L113
    L209:
        return null;
    L146:
        if (r0.equals("attachment") == false) goto L215;
        Intrinsics.checkNotNull(r11);
        String r26 = r11.getAuthority();
        if (r26 != null) goto L151;
        return null;
    L151:
        if ((!StringsKt.isBlank(r26)) == true) goto L154;
        r26 = null;
    L154:
        if (r26 != null) goto L157;
        return null;
    L157:
        if (f(r11, new String[]{"type"}) == false) goto L217;
        String r27 = UriProtector.getQueryParameter(r11, "type");
        if (r27 == null) goto L197;
        Integer r28 = StringsKt.toIntOrNull(r27);
        if (r28 != null) goto L164;
        return null;
    L164:
        if (r28.intValue() <= 0) goto L166;
        r4 = true;
    L166:
        if (r4 == true) goto L169;
        r28 = null;
    L169:
        if (r28 == null) goto L199;
        int r29 = r28.intValue();
        String r113 = r11.getPath();
        if (r113 != null) goto L173;
        r113 = "";
    L173:
        r21 = new r.a(r26.concat(r113), r29);
        goto L175
    L199:
        return null;
    L197:
        return null;
    L217:
        return null;
    L215:
        return null;
    L182:
        return null;
    L200:
        return null;
    }

    public static String q(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "&amp;", "&", false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&apos;", "'", false, 4, null), "&#39;", "'", false, 4, null);
    }

    public static String r(String r5) {
        Intrinsics.checkNotNullParameter(r5, "destination");
        StringBuilder r0 = new StringBuilder(r5.length());
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L14;
        char r2 = r5.charAt(r1);
        if (r2 != '\\') goto L12;
        int r3 = r1 + 1;
        if (r3 >= r5.length()) goto L12;
        if (i(r5.charAt(r3)) == false) goto L12;
        r0.append(r5.charAt(r3));
        r1 = r1 + 2;
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L14:
        return r0.toString();
    }

    public static String s(String r10) {
        Intrinsics.checkNotNullParameter(r10, "label");
        StringBuilder r0 = new StringBuilder(r10.length());
        int r2 = 0;
    L4:
        if (r2 >= r10.length()) goto L13;
        char r3 = r10.charAt(r2);
        int r4 = r2 + 1;
        Character r5 = StringsKt.getOrNull(r10, r4);
        if (r3 != '\\') goto L11;
        if (r5 == null) goto L11;
        if (StringsKt.contains$default("\\[]", r5.charValue(), false, 2, null) == false) goto L11;
        r0.append(r5.charValue());
        r2 = r2 + 2;
    L11:
        r0.append(r3);
        r2 = r4;
        goto L4
    L13:
        return r0.toString();
    }

    public static List e(String r11, List r12) {
        List r0 = r0.a(r11);
        ArrayList r1 = null;
        if (r0 == null) goto L52;
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ArrayList) r0).iterator();
    L6:
        if (r3.hasNext() == false) goto L51;
        Triple r4 = (Triple) r3.next();
        int r5 = ((Number) r4.getFirst()).intValue();
        int r6 = ((Number) r4.getSecond()).intValue();
    L9:
        if (r6 >= r11.length()) goto L21;
        char r7 = r11.charAt(r6);
        if (i(r7) == true) goto L12;
        if (r7 != '\\') goto L20;
        int r8 = r6 + 1;
        if (r8 >= r11.length()) goto L20;
        if (i(r11.charAt(r8)) == false) goto L20;
        r6 = r6 + 2;
    L20:
        int r9 = p(r11, r6);
    L22:
        String r10 = l(r(r11.substring(r5, r9)));
        if (r5 >= 0) goto L25;
    L48:
        g r13 = null;
    L49:
        if (r13 == null) goto L6;
        r2.add(r13);
        goto L6
    L25:
        if (r9 > r11.length()) goto L48;
        if (r5 >= r9) goto L48;
        if (StringsKt.isBlank(r10) == true) goto L48;
        List r14 = r12;
        boolean r15 = false;
        if ((r14 instanceof Collection) == true) goto L32;
    L34:
        Iterator r16 = r14.iterator();
    L36:
        if (r16.hasNext() == false) goto L45;
        g r17 = (g) r16.next();
        if (r5 < r17.b) goto L40;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == false) goto L36;
        r15 = true;
        goto L45
    L40:
        if (r17.a >= r9) goto L42;
        r18 = true;
    L45:
        if (r15 == true) goto L48;
        r13 = new g(r5, r9, r10, MessageMarkdownLinkSource.PLAIN_URL);
        goto L49
    L32:
        if (r14.isEmpty() == false) goto L34;
    L12:
        r6 = r6 + 1;
        goto L9
    L21:
        r9 = p(r11, r6);
        goto L22
    L51:
        r1 = r2;
    L52:
        if (r1 == null) goto L54;
        return r1;
    L54:
        return CollectionsKt.emptyList();
    }

    public static boolean f(Uri r3, String... r4) {
        Set r5 = ArraysKt.toSet(r4);
        if (Intrinsics.areEqual(UriProtector.getQueryParameterNames(r3), r5) == false) goto L27;
        Set r6 = r5;
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        if (UriProtector.getQueryParameters(r3, (String) r7.next()).size() != 1) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == true) goto L11;
        boolean r8 = false;
    L19:
        if (r8 == false) goto L28;
        return true;
    L28:
        return false;
    L15:
        r0 = false;
    L18:
        r8 = true;
        goto L19
    L7:
        if (r6.isEmpty() == false) goto L9;
    L27:
        return false;
    }

    public static int p(String r3, int r4) {
    L2:
        if (r4 <= 0) goto L6;
        int r1 = r4 - 1;
        if (SetsKt.setOf(new Character[]{'.', ',', ';', '!', '?', ':'}).contains(Character.valueOf(r3.charAt(r1))) == false) goto L6;
        r4 = r1;
    L6:
        return r4;
    }

    public static i m(String r2, boolean r3, int r4) {
        boolean r1 = true;
        if ((r4 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r4 & 4) != 0) goto L9;
        r1 = false;
    L9:
        Intrinsics.checkNotNullParameter(r2, "content");
        return n(r2, r3, r1, false);
    }

    public static i n(String r20, boolean r21, boolean r22, boolean r23) {
        int r3 = 0;
        if (r20.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        ArrayList r2 = new ArrayList();
        if (r21 == false) goto L13;
        r2.addAll(d(r20));
    L13:
        ArrayList r5 = new ArrayList();
        Matcher r6 = ((Pattern) d.getValue()).matcher(r20);
    L15:
        if (r6.find() == false) goto L64;
        String r7 = r6.group(1);
        String r8 = "";
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        String r13 = s(r7);
        String r9 = r6.group(2);
        if (r9 == null) goto L23;
        r8 = r9;
    L23:
        String r14 = r(r8);
        if ((!StringsKt.isBlank(r13)) == false) goto L15;
        if ((!StringsKt.isBlank(r14)) == false) goto L15;
        r r15 = o(r14);
        if (r15 != null) goto L29;
        if (g(r14) == true) goto L56;
        String r10 = StringsKt.trim(r8).toString();
        if (StringsKt.startsWith$default(r10, "http://", false, 2, null) == false) goto L35;
    L54:
        boolean r11 = true;
    L55:
        if (r11 == false) goto L15;
    L35:
        if (StringsKt.startsWith$default(r10, "https://", false, 2, null) == true) goto L54;
        List r12 = r0.a(r10);
        if (r12 == null) goto L53;
        ArrayList r16 = (ArrayList) r12;
        if (r16.isEmpty() == true) goto L53;
        Iterator r17 = r16.iterator();
    L44:
        if (r17.hasNext() == false) goto L53;
        Triple r18 = (Triple) r17.next();
        if (((Number) r18.getFirst()).intValue() == 0) goto L48;
    L50:
        boolean r19 = false;
    L51:
        if (r19 == false) goto L44;
    L48:
        if (((Number) r18.getSecond()).intValue() != r10.length()) goto L50;
        r19 = true;
    L53:
        r11 = false;
    L56:
        int r24 = r6.start();
        int r25 = r6.end();
        if (h(r14) == false) goto L60;
        r13 = b(r13);
    L60:
        if (g(r14) == true) goto L63;
        r14 = l(r14);
    L63:
        r5.add(new com.larus.bmhome.chat.markdown.richtext.a(r24, r25, r13, r14));
        goto L15
    L29:
        r5.add(new u(r6.start(), r6.end(), b(r13), r13, r14, r15));
        goto L15
    L64:
        if (r22 == false) goto L66;
        r2.addAll(r5);
    L84:
        ArrayList r4 = (ArrayList) c(r2);
        if (r4.isEmpty() == false) goto L92;
        List r26 = e(r20, CollectionsKt.emptyList());
        List r27 = r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L88:
        if (r29.hasNext() == false) goto L91;
        r28.add(((g) r29.next()).c);
        goto L88
    L91:
        return new i(r20, r26, CollectionsKt.take(CollectionsKt.distinct(r28), 25), 12);
    L92:
        StringBuilder r30 = new StringBuilder(r20.length());
        ArrayList r31 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        Iterator r32 = r4.iterator();
    L94:
        if (r32.hasNext() == false) goto L111;
        t r33 = (t) r32.next();
        if (r33.c() < r3) goto L94;
        r30.append(r20, r3, r33.c());
        int r112 = r30.length();
        r30.append(r33.a());
        int r113 = r30.length();
        if ((r33 instanceof com.larus.bmhome.chat.markdown.richtext.a) == false) goto L102;
        r31.add(new g(r112, r113, ((com.larus.bmhome.chat.markdown.richtext.a) r33).d, MessageMarkdownLinkSource.MARKDOWN_LINK));
    L107:
        r3 = r33.b();
        goto L94
    L102:
        if ((r33 instanceof f) == false) goto L105;
        f r34 = (f) r33;
        r110.add(new h(r112, r113, r34.e, r34.d, r34.f, r34.g, r34.h));
        goto L107
    L105:
        if ((r33 instanceof u) == false) goto L110;
        u r35 = (u) r33;
        r111.add(new j(r112, r113, r35.d, r35.e, r35.f));
        goto L107
    L110:
        throw new NoWhenBranchMatchedException();
    L111:
        r30.append(r20, r3, r20.length());
        String r36 = r30.toString();
        List r37 = CollectionsKt.plus(r31, e(r36, r31));
        ArrayList r38 = new ArrayList();
        Iterator r0 = r37.iterator();
    L113:
        if (r0.hasNext() == false) goto L117;
        Object r39 = r0.next();
        if (o.a((g) r39) == true) goto L113;
        r38.add(r39);
        goto L113
    L117:
        ArrayList r40 = new ArrayList();
        Iterator r41 = r38.iterator();
    L119:
        if (r41.hasNext() == false) goto L123;
        Object r42 = r41.next();
        if (g(((g) r42).c) == true) goto L119;
        r40.add(r42);
        goto L119
    L123:
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator r44 = r40.iterator();
    L125:
        if (r44.hasNext() == false) goto L128;
        r43.add(((g) r44.next()).c);
        goto L125
    L128:
        return new i(r36, r37, r110, r111, CollectionsKt.take(CollectionsKt.distinct(r43), 25));
    L66:
        if (r23 == false) goto L84;
        ArrayList r45 = new ArrayList();
        Iterator r46 = r5.iterator();
    L69:
        if (r46.hasNext() == false) goto L83;
        Object r47 = r46.next();
        t r48 = (t) r47;
        if ((r48 instanceof u) == false) goto L74;
    L79:
        boolean r49 = true;
    L81:
        if (r49 == false) goto L69;
        r45.add(r47);
        goto L69
    L74:
        if ((r48 instanceof com.larus.bmhome.chat.markdown.richtext.a) == false) goto L80;
        com.larus.bmhome.chat.markdown.richtext.a r50 = (com.larus.bmhome.chat.markdown.richtext.a) r48;
        if (h(r50.d) == true) goto L79;
        if (g(r50.d) == true) goto L79;
    L80:
        r49 = false;
        goto L81
    L83:
        r2.addAll(r45);
        goto L84
    L9:
        return new i(r20, null, null, 30);
    L5:
        r1 = false;
        goto L7
    }
}
