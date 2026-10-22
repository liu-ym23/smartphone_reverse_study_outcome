package com.larus.bmhome.chat.trace.container;

import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import com.larus.bmhome.chat.trace.l0;
import com.larus.bmhome.chat.trace.s;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.utils.logger.FLogger;
import hq9.d3;
import hq9.s3;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lw8.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RenderExceptionTrace {
    public static final RenderExceptionTrace a = null;
    public static final ConcurrentHashMap<String, a> b = null;
    public static final ConcurrentHashMap<String, c> c = null;
    public static long d;
    public static long e;
    public static final Lazy f = null;

    public static final class a {
        public boolean a;
        public long b;
        public long c;
        public long d;
        public long e;
        public Map<String, b> f;
        public String g;
        public String h;
        public String i;
        public JSONObject j;
        public Map<ContainerExceptionType, d> k;

        public a() {
        }
    }

    public static final class b {
        public long a;
        public long b;
        public String c;
        public String d;
        public String e;

        public b() {
        }
    }

    public static final class c {
        public static final Lazy<List<s3>> f = null;
        public static final Lazy<Regex> g = null;
        public static final Lazy<Regex> h = null;
        public static final Lazy<Regex> i = null;
        public final CopyOnWriteArrayList<WeakReference<rt8.a>> a;
        public String b;
        public String c;
        public String d;
        public JSONObject e;

        public static final class a {
            public a() {
            }
        }

        public c() {
            this(0);
        }

        static {
            new a();
            f = LazyKt.lazy(new g());
            g = LazyKt.lazy(new h());
            h = LazyKt.lazy(new i());
            i = LazyKt.lazy(new j());
        }

        public final void a() {
            Iterator<T> r1 = this.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L140;
            rt8.a r2 = (rt8.a) ((WeakReference) r1.next()).get();
            if (r2 == null) goto L4;
            r2.h();
            RenderExceptionTrace r10 = RenderExceptionTrace.a;
            MessageMonitorItemType r3 = MessageMonitorItemType.LINK;
            int r11 = 2;
            if (RenderExceptionTrace.g(r3) == true) goto L21;
            String r4 = this.c;
            if (r4 != null) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == false) goto L19;
            this.b = RenderExceptionTrace.d(this.b, r3.getValue());
            goto L21
        L19:
            if (r2.g() == false) goto L21;
            this.b = RenderExceptionTrace.d(this.b, r3.getValue());
            goto L21
        L13:
            if (StringsKt.contains$default(r4, r3.getValue(), false, 2, null) != true) goto L15;
            r5 = true;
        L21:
            MessageMonitorItemType r6 = MessageMonitorItemType.POTENTIAL_FORMULA;
            if (RenderExceptionTrace.g(r6) == true) goto L36;
            String r7 = RenderExceptionTrace.a(r2);
            if (r7 == null) goto L36;
            MatchResult r8 = Regex.find$default((Regex) g.getValue(), r7, 0, 2, null);
            if (r8 == null) goto L34;
            this.b = RenderExceptionTrace.d(this.b, r6.getValue());
            this.c = RenderExceptionTrace.d(this.c, r6.getValue());
            String r9 = this.d;
            ContainerExceptionType r12 = ContainerExceptionType.UNRECOGNIZED_POTENTIAL_FORMULA;
            this.d = RenderExceptionTrace.d(r9, r12.getValue());
            if (this.e != null) goto L32;
            this.e = new JSONObject();
        L32:
            int r13 = RangesKt.coerceAtLeast(0, r8.getRange().getFirst() - RenderExceptionTrace.e().f());
            int r14 = RangesKt.coerceAtMost(r7.length(), (r8.getRange().getLast() + 1) + RenderExceptionTrace.e().f());
            JSONObject r15 = this.e;
            JSONObject r16 = new JSONObject();
            r16.put("content", r7.substring(r13, r14));
            Unit r17 = Unit.INSTANCE;
            RenderExceptionTrace.b(r10, r12, null, r15, r16, "", 2);
            goto L36
        L34:
            if (r2.e() == false) goto L36;
            this.b = RenderExceptionTrace.d(this.b, r6.getValue());
        L36:
            MessageMonitorItemType r18 = MessageMonitorItemType.POTENTIAL_TABLE;
            if (RenderExceptionTrace.g(r18) == true) goto L59;
            String r19 = this.c;
            if (r19 != null) goto L42;
        L44:
            boolean r20 = false;
        L45:
            if (r20 == false) goto L47;
            this.b = RenderExceptionTrace.d(this.b, r18.getValue());
            goto L59
        L47:
            String r21 = RenderExceptionTrace.a(r2);
            if (r21 == null) goto L59;
            MatchResult r22 = Regex.find$default((Regex) h.getValue(), r21, 0, 2, null);
            if (r22 == null) goto L57;
            this.b = RenderExceptionTrace.d(this.b, r18.getValue());
            this.c = RenderExceptionTrace.d(this.c, r18.getValue());
            String r23 = this.d;
            ContainerExceptionType r24 = ContainerExceptionType.UNRECOGNIZED_POTENTIAL_TABLE;
            this.d = RenderExceptionTrace.d(r23, r24.getValue());
            if (this.e != null) goto L55;
            this.e = new JSONObject();
        L55:
            int r25 = RangesKt.coerceAtLeast(0, r22.getRange().getFirst() - RenderExceptionTrace.e().f());
            int r26 = RangesKt.coerceAtMost(r21.length(), (r22.getRange().getLast() + 1) + RenderExceptionTrace.e().f());
            JSONObject r27 = this.e;
            JSONObject r28 = new JSONObject();
            r28.put("content", r21.substring(r25, r26));
            Unit r29 = Unit.INSTANCE;
            RenderExceptionTrace.b(r10, r24, null, r27, r28, "", 2);
            goto L59
        L57:
            if (r2.d() == false) goto L59;
            this.b = RenderExceptionTrace.d(this.b, r18.getValue());
            goto L59
        L42:
            if (StringsKt.contains$default(r19, r18.getValue(), false, 2, null) != true) goto L44;
            r20 = true;
        L59:
            MessageMonitorItemType r30 = MessageMonitorItemType.POTENTIAL_BOLD;
            if (RenderExceptionTrace.g(r30) == true) goto L82;
            String r31 = this.c;
            if (r31 != null) goto L65;
        L67:
            boolean r32 = false;
        L68:
            if (r32 == false) goto L70;
            this.b = RenderExceptionTrace.d(this.b, r30.getValue());
            goto L82
        L70:
            String r33 = RenderExceptionTrace.a(r2);
            if (r33 == null) goto L82;
            MatchResult r34 = Regex.find$default((Regex) i.getValue(), r33, 0, 2, null);
            if (r34 == null) goto L80;
            this.b = RenderExceptionTrace.d(this.b, r30.getValue());
            this.c = RenderExceptionTrace.d(this.c, r30.getValue());
            String r35 = this.d;
            ContainerExceptionType r36 = ContainerExceptionType.UNRECOGNIZED_POTENTIAL_BOLD;
            this.d = RenderExceptionTrace.d(r35, r36.getValue());
            if (this.e != null) goto L78;
            this.e = new JSONObject();
        L78:
            int r37 = RangesKt.coerceAtLeast(0, r34.getRange().getFirst() - RenderExceptionTrace.e().f());
            int r38 = RangesKt.coerceAtMost(r33.length(), (r34.getRange().getLast() + 1) + RenderExceptionTrace.e().f());
            JSONObject r39 = this.e;
            JSONObject r40 = new JSONObject();
            r40.put("content", r33.substring(r37, r38));
            Unit r41 = Unit.INSTANCE;
            RenderExceptionTrace.b(r10, r36, null, r39, r40, "", 2);
            goto L82
        L80:
            if (r2.m() == false) goto L82;
            this.b = RenderExceptionTrace.d(this.b, r30.getValue());
            goto L82
        L65:
            if (StringsKt.contains$default(r31, r30.getValue(), false, 2, null) != true) goto L67;
            r32 = true;
        L82:
            String r42 = r2.getOriginText();
            if (r42 == null) goto L139;
            Lazy<List<s3>> r43 = f;
            if (((List) r43.getValue()).isEmpty() == true) goto L139;
            Iterator r44 = ((List) r43.getValue()).iterator();
        L89:
            boolean r45 = false;
        L91:
            if (r44.hasNext() == false) goto L139;
            s3 r46 = (s3) r44.next();
            if (r45 == true) goto L138;
            if (r46 == null) goto L133;
            Regex r47 = r46.d();
            if (r47 == null) goto L129;
            Regex r48 = r46.f();
            Regex r49 = r46.e();
            if (r46.c() == false) goto L123;
            Iterator r50 = SequencesKt.toList(Regex.findAll$default(r47, r42, 0, r11, null)).iterator();
        L102:
            if (r50.hasNext() == false) goto L121;
            Object r51 = r50.next();
            MatchResult r110 = (MatchResult) r51;
            if (r48 != null) goto L106;
        L108:
            boolean r111 = false;
        L109:
            if (r111 == true) goto L117;
            if (r49 != null) goto L112;
        L114:
            boolean r112 = false;
        L115:
            if (r112 == true) goto L117;
            boolean r113 = true;
        L118:
            if (r113 == false) goto L102;
        L122:
            MatchResult r52 = (MatchResult) r51;
        L124:
            if (r52 == null) goto L129;
            RenderExceptionTrace r114 = RenderExceptionTrace.a;
            this.b = RenderExceptionTrace.d(this.b, r46.b());
            this.c = RenderExceptionTrace.d(this.c, r46.b());
            this.d = RenderExceptionTrace.d(this.d, r46.a());
            if (this.e != null) goto L128;
            this.e = new JSONObject();
        L128:
            int r53 = RangesKt.coerceAtLeast(0, r52.getRange().getFirst() - RenderExceptionTrace.e().f());
            int r54 = RangesKt.coerceAtMost(r42.length(), (r52.getRange().getLast() + 1) + RenderExceptionTrace.e().f());
            String r115 = r46.a();
            JSONObject r55 = this.e;
            JSONObject r56 = new JSONObject();
            r56.put("content", r42.substring(r53, r54));
            Unit r57 = Unit.INSTANCE;
            RenderExceptionTrace.b(r114, null, r115, r55, r56, "", 1);
            boolean r58 = true;
        L130:
            if (r58 != true) goto L133;
            boolean r59 = true;
        L134:
            if (r59 == true) goto L138;
            r11 = 2;
            goto L89
        L112:
            if (r49.containsMatchIn(r110.getValue()) != true) goto L114;
            r112 = true;
        L117:
            r113 = false;
            goto L118
        L106:
            if (r48.containsMatchIn(r110.getValue()) == true) goto L108;
            r111 = true;
            goto L109
        L121:
            r51 = null;
            goto L122
        L123:
            r52 = Regex.find$default(r47, r42, 0, 2, null);
        L129:
            r58 = false;
        L133:
            r59 = false;
        L138:
            r45 = true;
            r11 = 2;
        L139:
            r2.setMarkdownTextMonitorCache(null);
            goto L4
        }

        public c(CopyOnWriteArrayList<WeakReference<rt8.a>> r2) {
            Intrinsics.checkNotNullParameter(r2, "customMarkdownViewList");
            this.a = r2;
        }

        public /* synthetic */ c(int r1) {
            this(new CopyOnWriteArrayList());
        }

        public static boolean b(uvc.b r2, String r3) {
        L2:
            if (r2 == null) goto L19;
            if ((r2 instanceof LatexMathBlock) == false) goto L7;
            String r0 = ((LatexMathBlock) r2).h;
        L11:
            if (Intrinsics.areEqual(r3, r0) == true) goto L12;
            uvc.b r1 = r2.b;
            if (r1 == null) goto L18;
            if (b(r1, r3) == false) goto L18;
            return true;
        L18:
            r2 = r2.e;
            goto L2
        L12:
            return true;
        L7:
            if ((r2 instanceof LatexMathNode) == false) goto L9;
            r0 = ((LatexMathNode) r2).h;
            goto L11
        L9:
            r0 = null;
            goto L11
        L19:
            return false;
        }
    }

    public static final class d {
        public final long a;
        public final String b;
        public final String c;
        public final JSONObject d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L8;
            return false;
        L8:
            d r9 = (d) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "TimeoutExceptionWaitForCheckInfo(loadDuration=" + this.a + ", exceptionItems=" + this.b + ", exceptions=" + this.c + ", exceptionExtraParams=" + this.d + ')';
        }

        public d(long r2, String r4, String r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r4, "exceptionItems");
            Intrinsics.checkNotNullParameter(r5, "exceptions");
            Intrinsics.checkNotNullParameter(r6, "exceptionExtraParams");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageMonitorItemType.values().length];
            r0[MessageMonitorItemType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MessageMonitorItemType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MessageMonitorItemType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public RenderExceptionTrace() {
    }

    static {
        a = new RenderExceptionTrace();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        com.larus.business.markdown.api.extplugin.latex.a r0 = ILatexPluginKt.b();
        if (r0 == null) goto L5;
        r0.addOnParseErrorListener(new AnonymousClass1());
    L5:
        f = LazyKt.lazy(new com.larus.bmhome.chat.trace.container.e());
    }

    public static d3 e() {
        return (d3) f.getValue();
    }

    public static final String a(rt8.a r2) {
        l r0 = r2.getMarkdownContent();
        if (r0 == null) goto L7;
        SpannableStringBuilder r1 = r0.e();
        if (r1 == null) goto L7;
        String r3 = r1.toString();
    L8:
        if (r3 != null) goto L10;
        return r3;
    L10:
        if (StringsKt.isBlank(r3) == false) goto L17;
        String r4 = r2.getMarkdownTextMonitorCache();
        if (r4 != null) goto L15;
        return r3;
    L15:
        return r4;
    L17:
        return r3;
    L7:
        r3 = null;
        goto L8
    }

    public static long f(MessageMonitorItemType r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorItemType");
        int r3 = e.a[r2.ordinal()];
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L14;
        return 0;
    L14:
        return e().i();
    L15:
        return e().a();
    L12:
        return e().b();
    }

    public static boolean g(MessageMonitorItemType r1) {
        Intrinsics.checkNotNullParameter(r1, "monitorItemType");
        List r0 = e().c();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1.getValue()) != true) goto L7;
        return true;
    }

    public static JSONObject c(JSONObject r3, JSONObject r4) {
        if (r4 != null) goto L4;
        return r3;
    L4:
        if (r4.length() == 0) goto L18;
        if (r3 == null) goto L15;
        if (r3.length() == 0) goto L15;
        Iterator<String> r0 = r4.keys();
    L12:
        if (r0.hasNext() == false) goto L19;
        String r1 = r0.next();
        r3.put(r1, r4.opt(r1));
        goto L12
    L19:
        return r3;
    L15:
        return r4;
    L18:
        return r3;
    }

    public static String d(String r4, String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L26;
        if (r4 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L26;
        if (r4 != null) goto L19;
    L22:
        if (r0 == false) goto L25;
        return r5;
    L25:
        return r4 + ',' + r5;
    L19:
        if (r4.length() == 0) goto L22;
        r0 = false;
        goto L22
    L12:
        if (StringsKt.contains$default(r4, r5, false, 2, null) != true) goto L14;
        r3 = true;
    L26:
        return r4;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void i(String r4, MessageMonitorItemType r5) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
        Intrinsics.checkNotNullParameter(r5, "monitorItem");
        if (g(r5) == false) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, a> r0 = b;
        if (r0.containsKey(r4) == true) goto L10;
        l0.a.getClass();
        if (l0.a.b.containsKey(r4) == false) goto L10;
        a r1 = new a();
        r1.a = true;
        r0.put(r4, r1);
    L10:
        a r2 = r0.get(r4);
        if (r2 == null) goto L14;
        FLogger.a.d("RenderExceptionTrace", "onMonitorItem, messageId: " + r4 + ", monitorItem: " + r5);
        r2.g = d(r2.g, r5.getValue());
        return;
    }

    public final void h(String r17, ContainerExceptionType r18, String r19, JSONObject r20, Long r21) {
        Intrinsics.checkNotNullParameter(r17, "msgId");
        Intrinsics.checkNotNullParameter(r18, "exceptionType");
        Intrinsics.checkNotNullParameter(r19, "tag");
        Intrinsics.checkNotNullParameter(r20, "exceptionParams");
        if (g(r18.getType()) == false) goto L5;
        return;
    L5:
        if (r21 == null) goto L11;
        long r2 = r21.longValue();
        l0.a.getClass();
        s r6 = l0.a.b.get(r17);
        if (r6 == null) goto L11;
        if ((System.currentTimeMillis() - r6.b) >= r2) goto L11;
        return;
    L11:
        Lazy<List<s3>> r3 = c.f;
        Intrinsics.checkNotNullParameter(r18, "exceptionType");
        boolean r4 = false;
        if (CollectionsKt.listOf(new MessageMonitorItemType[]{MessageMonitorItemType.LINK, MessageMonitorItemType.POTENTIAL_FORMULA, MessageMonitorItemType.POTENTIAL_TABLE, MessageMonitorItemType.POTENTIAL_BOLD}).contains(r18.getType()) == false) goto L21;
        c r1 = c.get(r17);
        if (r1 != null) goto L16;
        return;
    L16:
        FLogger.a.d("RenderExceptionTrace", "onException(), messageId: " + r17 + ", exceptionType: " + r18 + ", tag: " + r19);
        r1.d = d(r1.d, r18.getValue());
        r1.c = d(r1.c, r18.getType().getValue());
        if (r1.e != null) goto L19;
        r1.e = new JSONObject();
    L19:
        b(this, r18, null, r1.e, r20, r19, 2);
        return;
    L21:
        a r5 = b.get(r17);
        if (r5 == null) goto L53;
        FLogger.a.d("RenderExceptionTrace", "onException(), messageId: " + r17 + ", exceptionType: " + r18 + ", tag: " + r19);
        boolean r0 = CollectionsKt.listOf(new ContainerExceptionType[]{ContainerExceptionType.TIMEOUT_IMAGE, ContainerExceptionType.TIMEOUT_VIDEO}).contains(r18);
        RenderExceptionTrace r7 = a;
        if (r0 == false) goto L34;
        if (r21 == null) goto L54;
        Map r8 = r5.k;
        if (r8 != null) goto L29;
        r8 = new LinkedHashMap();
        r5.k = r8;
    L29:
        Map r9 = r8;
        JSONObject r15 = b(r7, r18, null, new JSONObject(), r20, r19, 2);
        if (r15 == null) goto L56;
        r9.put(r18, new d(r21.longValue(), r18.getType().getValue(), r18.getValue(), r15));
        return;
    L56:
        return;
    L54:
        return;
    L34:
        if (ContainerExceptionType.FAILED_LYNX != r18) goto L40;
        Map<String, b> r10 = r5.f;
        if (r10 == null) goto L40;
        b r11 = r10.get(r19);
        if (r11 == null) goto L40;
        r11.b = SystemClock.elapsedRealtime();
    L40:
        String r12 = r5.i;
        if (r12 != null) goto L44;
        r5.i = r18.getValue();
    L48:
        r5.h = d(r5.h, r18.getType().getValue());
        if (r5.j != null) goto L51;
        r5.j = new JSONObject();
    L51:
        b(r7, r18, null, r5.j, r20, r19, 2);
        return;
    L44:
        if (StringsKt.contains$default(r12, r18.getValue(), false, 2, null) != true) goto L46;
        r4 = true;
    L46:
        if (r4 == true) goto L48;
        r5.i += ',' + r18.getValue();
        goto L48
    }

    public static JSONObject b(RenderExceptionTrace r2, ContainerExceptionType r3, String r4, JSONObject r5, JSONObject r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = null;
    L8:
        r2.getClass();
        if (r5 == null) goto L27;
        if (r3 != null) goto L15;
        if (r4 == null) goto L27;
    L15:
        if (StringsKt.isBlank(r7) == false) goto L17;
        String r9 = "";
    L18:
        if (r3 == null) goto L23;
        String r10 = r3.getValue();
        if (r10 == null) goto L23;
        r4 = r10;
    L23:
        Iterator<String> r11 = r6.keys();
    L25:
        if (r11.hasNext() == false) goto L29;
        String r12 = r11.next();
        r5.put(r4 + r9 + '_' + r12, r6.get(r12));
        goto L25
    L29:
        return r5;
    L17:
        r9 = "_" + r7;
    L27:
        return null;
    }
}
