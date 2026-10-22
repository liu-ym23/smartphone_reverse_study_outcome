package com.obric.memorydata.personalcontext.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\n2\u0006\u0010\u0015\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm;", "", "<init>", "()V", TypedValues.AttributesType.S_TARGET, "", "", "root", "Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm$Node;", "result", "Ljava/util/HashMap;", "", "isDirty", "", "build", "", "insert", "str", "buildTrieTree", "buildAcFromTrie", "find", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "addMatchToResult", "index", "Companion", "Node", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0662a f12357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f12358b;
    private final b c;
    private final HashMap<String, List<Integer>> d;
    private boolean e;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.util.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0662a {
        private C0662a() {
        }

        public /* synthetic */ C0662a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm$Node;", "", "<init>", "()V", "str", "", "getStr", "()Ljava/lang/String;", "setStr", "(Ljava/lang/String;)V", "children", "", "", "getChildren", "()Ljava/util/Map;", "fail", "getFail", "()Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm$Node;", "setFail", "(Lcom/obric/memorydata/personalcontext/util/AhoCorasickAlgorithm$Node;)V", "isWord", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<Integer, b> f12360b;
        private b c;

        public b() {
            this.f12360b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        public final String a() {
            return this.f12359a;
        }

        public final void a(b r1) {
            this.c = r1;
        }

        public final void a(String r1) {
            this.f12359a = r1;
        }

        public final Map<Integer, b> b() {
            return this.f12360b;
        }

        public final b c() {
            return this.c;
        }

        public final boolean d() {
            if (this.f12359a == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f12357a = new C0662a(null);
    }

    public a() {
        this.f12358b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = new b();
        this.d = new HashMap();
    }

    private final void a(String r5, int r6) {
        if (this.d.get(r5) != null) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r5, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
    L5:
        List r4 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r5), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r4.add(Integer.valueOf(r6));
        return;
    }

    private final void b() {
        Iterator<String> r0 = this.f12358b.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        b r2 = this.c;
        int r4 = 0;
        int r5 = ((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length();
    L6:
        if (r4 >= r5) goto L11;
        char r6 = r1.charAt(r4);
        if (r2.b().get(Integer.valueOf(r6)) != null) goto L10;
        r2.b().put(Integer.valueOf(r6), new b());
    L10:
        b r3 = r2.b().get(Integer.valueOf(r6));
        Intrinsics.checkNotNull(r3);
        r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        r4 = r4 + 1;
        goto L6
    L11:
        r2.a(r1);
        goto L4
    }

    private final void c() {
        Queue r0 = (Queue) ZeusTransformUtils.preCheckCast(new LinkedList(), Queue.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Integer, b>> r1 = this.c.b().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((b) ZeusTransformUtils.preCheckCast(r3.getValue(), b.class, "com.obric.memorydata.plugin")).a(this.c);
        r0.add(r3.getValue());
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.poll(), b.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        Iterator<Integer> r4 = r2.b().keySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L7;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2.b().get(Integer.valueOf(r5)) == null) goto L12;
        r0.add(r2.b().get(Integer.valueOf(r5)));
        b r6 = r2.c();
    L16:
        if (r6 == null) goto L17;
        if (r6.b().get(Integer.valueOf(r5)) != null) goto L20;
        r6 = r6.c();
        goto L16
    L20:
        b r7 = r2.b().get(Integer.valueOf(r5));
        Intrinsics.checkNotNull(r7);
        ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).a((b) ZeusTransformUtils.preCheckCast(r6.b().get(Integer.valueOf(r5)), b.class, "com.obric.memorydata.plugin"));
        goto L12
    L17:
        b r8 = r2.b().get(Integer.valueOf(r5));
        Intrinsics.checkNotNull(r8);
        ((b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.memorydata.plugin")).a(this.c);
        goto L12
    }

    public final HashMap<String, List<Integer>> a(String r6) {
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        a();
        this.d.clear();
        b r0 = this.c;
        int r1 = 0;
    L4:
        if (r1 >= r6.length()) goto L21;
        char r2 = r6.charAt(r1);
        if (r0.b().get(Integer.valueOf(r2)) != null) goto L7;
        if (r0.c() == null) goto L17;
        r0 = r0.c();
        Intrinsics.checkNotNull(r0);
        goto L4
    L17:
        r0 = this.c;
    L18:
        r1 = r1 + 1;
        goto L4
    L7:
        b r3 = r0.b().get(Integer.valueOf(r2));
        Intrinsics.checkNotNull(r3);
        r0 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        if (r0.d() == false) goto L11;
        String r4 = r0.a();
        Intrinsics.checkNotNull(r4);
        String r5 = r0.a();
        Intrinsics.checkNotNull(r5);
        a(r4, (r1 - r5.length()) + 1);
    L11:
        if (r0.c() == null) goto L18;
        b r7 = r0.c();
        Intrinsics.checkNotNull(r7);
        if (r7.d() == false) goto L18;
        b r8 = r0.c();
        Intrinsics.checkNotNull(r8);
        String r9 = r8.a();
        Intrinsics.checkNotNull(r9);
        b r10 = r0.c();
        Intrinsics.checkNotNull(r10);
        String r11 = r10.a();
        Intrinsics.checkNotNull(r11);
        a(r9, (r1 - r11.length()) + 1);
        goto L18
    L21:
        return this.d;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.e == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        b();     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
        this.e = false;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final void insert(String r4) {
        Intrinsics.checkNotNullParameter(r4, "str");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        RunLog.INSTANCE.debug("AhoCorasickAutomation", r4);
        this.f12358b.add(r4);
        this.e = true;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
