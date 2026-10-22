package com.bytedance.ai.debugscene;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DebugSceneLynxConsoleStore {
    public static final DebugSceneLynxConsoleStore a = null;
    public static final Object b = null;
    public static final Handler c = null;
    public static final AtomicLong d = null;
    public static final WeakHashMap<View, d> e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/debugscene/DebugSceneLynxConsoleStore$ConsoleLevel;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARN", "ERROR", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ConsoleLevel extends Enum<ConsoleLevel> {
        public static final ConsoleLevel DEBUG = null;
        public static final ConsoleLevel ERROR = null;
        public static final ConsoleLevel INFO = null;
        public static final ConsoleLevel WARN = null;
        public static final /* synthetic */ ConsoleLevel[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ConsoleLevel> getEntries() {
            return b;
        }

        static {
            ConsoleLevel r0 = new ConsoleLevel("DEBUG", 0);
            DEBUG = r0;
            ConsoleLevel r1 = new ConsoleLevel("INFO", 1);
            INFO = r1;
            ConsoleLevel r10 = new ConsoleLevel("WARN", 2);
            WARN = r10;
            ConsoleLevel r11 = new ConsoleLevel("ERROR", 3);
            ERROR = r11;
            ConsoleLevel[] r12 = {r0, r1, r10, r11};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static ConsoleLevel[] values() {
            return (ConsoleLevel[]) a.clone();
        }

        public static ConsoleLevel valueOf(String r1) {
            return (ConsoleLevel) r27.a.a(ConsoleLevel.class, r1);
        }

        public ConsoleLevel(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public final long a;
        public final ConsoleLevel b;
        public final String c;
        public final boolean d;
        public final List<c> e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r10 = 1231;
        L7:
            return ((r1 + r10) * 31) + this.e.hashCode();
        L5:
            r10 = 1237;
            goto L7
        }

        public final String toString() {
            return "ConsoleEntry(id=" + this.a + ", level=" + this.b + ", text=" + this.c + ", expandable=" + this.d + ", objectRefs=" + this.e + ')';
        }

        public /* synthetic */ a(long r10, ConsoleLevel r11, String r12) {
            this(r10, r11, r12, false, CollectionsKt.emptyList());
        }

        public a(long r10, ConsoleLevel r11, String r12, boolean r13, List<c> r14) {
            Intrinsics.checkNotNullParameter(r11, "level");
            Intrinsics.checkNotNullParameter(r12, "text");
            Intrinsics.checkNotNullParameter(r14, "objectRefs");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.c;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ConsoleObjectNode(label=" + this.a + ", preview=" + this.b + ", objectId=" + this.c + ')';
        }

        public b(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "label");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class c {
        public final String a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ConsoleObjectRef(objectId=" + this.a + ", description=" + this.b + ')';
        }

        public c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "objectId");
            Intrinsics.checkNotNullParameter(r11, "description");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class d {
        public boolean a;
        public boolean b;
        public WeakReference<LynxBaseInspectorOwner> c;
        public final List<a> d;
        public final LinkedHashSet<Function1<List<a>, Unit>> e;

        public d() {
            this.d = new ArrayList();
            this.e = new LinkedHashSet();
        }
    }

    public static final class e {
        public final String a;
        public final c b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            c r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedArg(text=" + this.a + ", objectRef=" + this.b + ')';
        }

        public e(String r10, c r11) {
            Intrinsics.checkNotNullParameter(r10, "text");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class f implements Callback {
        public final /* synthetic */ List<List<b>> a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ Function1<List<b>, Unit> d;

        public final void invoke(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "callbackArgs");
            List<List<b>> r0 = this.a;
            int r1 = this.b;
            DebugSceneLynxConsoleStore r10 = DebugSceneLynxConsoleStore.a;
            Object r12 = ArraysKt.firstOrNull(r11);
            r10.getClass();
            final Object r13 = DebugSceneLynxConsoleStore.g(r12);
            if (r13 != null) goto L5;
        L61:
            List r14 = CollectionsKt.emptyList();
        L62:
            ListProtector.set(r0, r1, r14);
            if (this.c.decrementAndGet() != 0) goto L81;
            this.d.invoke(CollectionsKt.flatten(CollectionsKt.filterNotNull(this.a)));
            return;
        L81:
            return;
        L5:
            if (Intrinsics.areEqual(r13, JSONObject.NULL) == true) goto L61;
            JSONArray r15 = null;
            if ((r13 instanceof JSONObject) == false) goto L23;
            JSONObject r16 = (JSONObject) r13;
            Iterator r17 = CollectionsKt.listOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_RESULT, "properties", "children"}).iterator();
        L11:
            if (r17.hasNext() == false) goto L20;
            JSONArray r18 = r16.optJSONArray((String) r17.next());
            if (r18 == null) goto L11;
            DebugSceneLynxConsoleStore.a.getClass();
            if (DebugSceneLynxConsoleStore.f(r18) == true) goto L18;
            r18 = null;
        L18:
            if (r18 == null) goto L11;
            r15 = r18;
        L20:
            if (r15 == null) goto L22;
            DebugSceneLynxConsoleStore.a.getClass();
            r14 = DebugSceneLynxConsoleStore.d(r15);
            goto L62
        L22:
            r14 = SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(SequencesKt.asSequence(r16.keys()), new l2()), new m2(r13)));
            goto L62
        L23:
            int r19 = 0;
            if ((r13 instanceof JSONArray) == false) goto L34;
            JSONArray r110 = (JSONArray) r13;
            if (DebugSceneLynxConsoleStore.f(r110) == false) goto L28;
            r14 = DebugSceneLynxConsoleStore.d(r110);
            goto L62
        L28:
            IntRange r20 = RangesKt.until(0, r110.length());
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
            IntIterator r22 = r20.iterator();
        L30:
            if (r22.hasNext() == false) goto L32;
            int r23 = r22.nextInt();
            DebugSceneLynxConsoleStore r24 = DebugSceneLynxConsoleStore.a;
            String r25 = "[" + r23 + ']';
            Object r26 = r110.opt(r23);
            r24.getClass();
            r21.add(DebugSceneLynxConsoleStore.e(r25, r26));
            goto L30
        L32:
            r14 = r21;
            goto L62
        L34:
            if ((r13 instanceof Map) == false) goto L52;
            Set r111 = ((Map) r13).entrySet();
            ArrayList r27 = new ArrayList();
            Iterator r112 = r111.iterator();
        L37:
            if (r112.hasNext() == false) goto L50;
            Map.Entry r28 = (Map.Entry) r112.next();
            Object r29 = r28.getKey();
            Object r30 = r28.getValue();
            if (r29 == null) goto L47;
            String r31 = r29.toString();
            if (r31 == null) goto L47;
            if (Intrinsics.areEqual(r31, "objectId") == true) goto L47;
            DebugSceneLynxConsoleStore.a.getClass();
            b r32 = DebugSceneLynxConsoleStore.e(r31, r30);
        L48:
            if (r32 == null) goto L37;
            r27.add(r32);
        L47:
            r32 = null;
        L50:
            r14 = r27;
            goto L62
        L52:
            if ((r13 instanceof List) == false) goto L60;
            Iterable r113 = (Iterable) r13;
            r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator r114 = r113.iterator();
        L55:
            if (r114.hasNext() == false) goto L50;
            Object r33 = r114.next();
            int r34 = r19 + 1;
            if (r19 >= 0) goto L59;
            CollectionsKt.throwIndexOverflow();
        L59:
            DebugSceneLynxConsoleStore.a.getClass();
            r27.add(DebugSceneLynxConsoleStore.e("[" + r19 + ']', r33));
            r19 = r34;
            goto L55
        L60:
            r14 = CollectionsKt.emptyList();
            goto L62
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(List<List<b>> r1, int r10, AtomicInteger r11, Function1<? super List<b>, Unit> r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public DebugSceneLynxConsoleStore() {
    }

    static {
        a = new DebugSceneLynxConsoleStore();
        b = new Object();
        c = new Handler(Looper.getMainLooper());
        d = new AtomicLong(1);
        e = new WeakHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.lynx.devtool.LynxInspectorConsoleDelegate");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxInspectorConsoleDelegate");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.lynx.devtool.LynxInspectorConsoleDelegate");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.lynx.devtool.LynxInspectorConsoleDelegate");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.lynx.devtool.LynxInspectorConsoleDelegate");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.lynx.devtool.LynxInspectorConsoleDelegate");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.lynx.devtool.LynxInspectorConsoleDelegate");
    }

    public static List d(JSONArray r15) {
        ArrayList r0 = new ArrayList();
        int r1 = r15.length();
        int r10 = 0;
    L3:
        if (r10 >= r1) goto L96;
        Object r11 = r15.opt(r10);
        String r12 = null;
        if ((r11 instanceof JSONObject) == false) goto L8;
        JSONObject r13 = (JSONObject) r11;
    L18:
        if (r13 == null) goto L95;
        String r14 = r13.optString(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        boolean r16 = true;
        if (r14.length() != 0) goto L23;
        boolean r17 = true;
    L24:
        if (r17 == false) goto L27;
        r14 = r13.optString("key");
    L27:
        if (r14.length() != 0) goto L29;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L33;
        r14 = "[" + r10 + ']';
    L33:
        Object r19 = g(r13.opt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE));
        if ((r19 instanceof JSONObject) == false) goto L39;
        String r110 = ((JSONObject) r19).optString("objectId");
        Intrinsics.checkNotNull(r110);
        if ((!StringsKt.isBlank(r110)) == true) goto L48;
    L47:
        r110 = null;
    L48:
        String r111 = r13.optString("objectId");
        Intrinsics.checkNotNull(r111);
        if ((!StringsKt.isBlank(r111)) == true) goto L52;
        r111 = null;
    L52:
        if (r111 == null) goto L55;
        r110 = r111;
    L55:
        if (r110 == null) goto L58;
    L94:
        Intrinsics.checkNotNull(r14);
        r0.add(new b(r14, r12, r110));
        goto L95
    L58:
        if (r13.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == false) goto L82;
        if (r19 != null) goto L61;
    L80:
        String r20 = "null";
    L81:
        r12 = r20;
        goto L94
    L61:
        if (Intrinsics.areEqual(r19, JSONObject.NULL) == true) goto L80;
        if ((r19 instanceof JSONObject) == false) goto L69;
        r20 = i((JSONObject) r19);
        if (r20 != null) goto L81;
        r20 = m(r19);
        goto L81
    L69:
        if ((r19 instanceof Map) == false) goto L74;
        r20 = h((Map) r19);
        if (r20 != null) goto L81;
        r20 = m(r19);
        goto L81
    L74:
        if ((r19 instanceof JSONArray) == false) goto L77;
        r20 = "[" + ((JSONArray) r19).length() + ']';
        goto L81
    L77:
        if ((r19 instanceof List) == false) goto L79;
        r20 = "[" + ((List) r19).size() + ']';
        goto L81
    L79:
        r20 = l(r19);
        goto L81
    L82:
        r12 = r13.optString("description");
        if (r12.length() != 0) goto L85;
        boolean r21 = true;
    L86:
        if (r21 == false) goto L89;
        r12 = r13.optString("type");
    L89:
        if (r12.length() == 0) goto L92;
        r16 = false;
    L92:
        if (r16 == false) goto L94;
        r20 = "{}";
        goto L81
    L85:
        r21 = false;
        goto L86
    L39:
        if ((r19 instanceof Map) == false) goto L47;
        Object r112 = ((Map) r19).get("objectId");
        if (r112 == null) goto L47;
        r110 = r112.toString();
        if (r110 == null) goto L47;
        if ((!StringsKt.isBlank(r110)) == false) goto L47;
    L29:
        r18 = false;
        goto L31
    L23:
        r17 = false;
    L95:
        r10 = r10 + 1;
        goto L3
    L8:
        if ((r11 instanceof String) == true) goto L97;
        r13 = null;
        goto L18
    L97:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L11
        Object r23 = Result.constructor-impl(new JSONObject((String) r11));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r23) == false) goto L16;
        r23 = null;
    L16:
        r13 = (JSONObject) r23;
    L11:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L96:
        return r0;
    }

    public static boolean f(JSONArray r10) {
        if (r10.length() != 0) goto L5;
        return false;
    L5:
        JSONObject r11 = r10.optJSONObject(0);
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.has(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME) == false) goto L11;
    L14:
        return true;
    L11:
        if (r11.has("description") == true) goto L14;
        if (r11.has("objectId") == true) goto L14;
        return false;
    }

    public static Object g(Object r10) {
        Object r0 = null;
        if (r10 != null) goto L6;
    L37:
        return r0;
    L6:
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L9;
        return JSONObject.NULL;
    L9:
        if ((r10 instanceof String) == false) goto L39;
        String r1 = StringsKt.trim((String) r10).toString();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        Object r12 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = null;
    L18:
        JSONObject r13 = (JSONObject) r12;
        if (r13 != null) goto L32;
        Object r14 = Result.constructor-impl(new JSONArray(r1));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r14) == true) goto L28;
        r0 = r14;
    L28:
        r0 = (JSONArray) r0;
        if (r0 != null) goto L37;
        return r10;
    L22:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L32:
        return r13;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L39:
        return r10;
    }

    public static String h(Map r10) {
        Object r0 = r10.get("objectId");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        String r11 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if ((!StringsKt.isBlank(r1)) == false) goto L12;
        return null;
    L12:
        Object r12 = r10.get("type");
        if (r12 == null) goto L15;
        String r13 = r12.toString();
    L16:
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        Object r14 = r10.get("subtype");
        if (r14 == null) goto L21;
        String r15 = r14.toString();
    L22:
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        Object r16 = r10.get(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        String r17 = "null";
        if (Intrinsics.areEqual(r15, "null") == false) goto L28;
    L82:
        if (r17 != null) goto L84;
        return null;
    L84:
        if (StringsKt.isBlank(r17) == false) goto L87;
        return null;
    L87:
        return r17;
    L28:
        if (Intrinsics.areEqual(r13, "string") == false) goto L32;
        if (r16 == null) goto L32;
        r17 = "\"" + r16 + '\"';
    L32:
        if (Intrinsics.areEqual(r13, "number") == false) goto L34;
    L35:
        if (r16 == null) goto L38;
        r17 = r16.toString();
    L38:
        if (Intrinsics.areEqual(r13, "bigint") == false) goto L56;
        Object r18 = r10.get("description");
        if (r18 == null) goto L42;
        String r19 = r18.toString();
    L43:
        if (r19 != null) goto L45;
        r17 = "";
    L47:
        if (StringsKt.isBlank(r17) == false) goto L82;
        if (r16 == null) goto L50;
        String r20 = r16.toString();
    L51:
        if (r20 == null) goto L54;
        r11 = r20;
    L54:
        r17 = r11;
        goto L82
    L50:
        r20 = null;
        goto L51
    L45:
        r17 = r19;
        goto L47
    L42:
        r19 = null;
        goto L43
    L56:
        if (Intrinsics.areEqual(r13, "undefined") == false) goto L59;
        r17 = "undefined";
        goto L82
    L59:
        if (Intrinsics.areEqual(r13, "symbol") == false) goto L61;
    L70:
        Object r21 = r10.get("description");
        if (r21 == null) goto L73;
        String r22 = r21.toString();
    L74:
        if (r22 == null) goto L78;
        r11 = r22;
    L78:
        if (StringsKt.isBlank(r11) == true) goto L81;
        r13 = r11;
    L81:
        r17 = r13;
        goto L82
    L73:
        r22 = null;
        goto L74
    L61:
        if (Intrinsics.areEqual(r13, "function") == true) goto L70;
        if ((!StringsKt.isBlank(r13)) == true) goto L66;
    L69:
        r17 = null;
        goto L82
    L66:
        if (Intrinsics.areEqual(r13, "object") == true) goto L69;
        if (r16 == null) goto L69;
        r17 = l(r16);
        goto L82
    L34:
        if (Intrinsics.areEqual(r13, "boolean") == false) goto L38;
    L21:
        r15 = null;
        goto L22
    L15:
        r13 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public static String i(JSONObject r10) {
        if ((!StringsKt.isBlank(r10.optString("objectId"))) == false) goto L5;
        return null;
    L5:
        String r0 = r10.optString("type");
        String r11 = "null";
        if (Intrinsics.areEqual(r10.optString("subtype"), "null") == false) goto L9;
    L57:
        if (r11 != null) goto L59;
        return null;
    L59:
        if (StringsKt.isBlank(r11) == false) goto L62;
        return null;
    L62:
        return r11;
    L9:
        if (Intrinsics.areEqual(r0, "string") == false) goto L14;
        if (r10.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == false) goto L14;
        r11 = "\"" + r10.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) + '\"';
    L14:
        if (Intrinsics.areEqual(r0, "number") == true) goto L18;
        if (Intrinsics.areEqual(r0, "boolean") == true) goto L18;
    L26:
        if (Intrinsics.areEqual(r0, "bigint") == false) goto L37;
        r0 = r10.optString("description");
        if (StringsKt.isBlank(r0) == false) goto L56;
        Object r12 = r10.opt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r12 == null) goto L32;
        String r13 = r12.toString();
    L33:
        if (r13 != null) goto L35;
    L34:
        r13 = "";
    L35:
        r11 = r13;
        goto L57
    L32:
        r13 = null;
    L56:
        r11 = r0;
        goto L57
    L37:
        if (Intrinsics.areEqual(r0, "undefined") == false) goto L40;
        r11 = "undefined";
        goto L57
    L40:
        if (Intrinsics.areEqual(r0, "symbol") == false) goto L42;
    L52:
        String r14 = r10.optString("description");
        if (StringsKt.isBlank(r14) == true) goto L56;
        r0 = r14;
        goto L56
    L42:
        if (Intrinsics.areEqual(r0, "function") == true) goto L52;
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L47;
    L51:
        r11 = null;
        goto L57
    L47:
        if (Intrinsics.areEqual(r0, "object") == true) goto L51;
        if (r10.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == false) goto L51;
        r11 = l(r10.opt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE));
    L18:
        if (r10.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == false) goto L26;
        Object r15 = r10.opt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r15 == null) goto L22;
        r11 = r15.toString();
    L23:
        if (r11 != null) goto L57;
    L22:
        r11 = null;
        goto L23
    }

    public static String k(JSONObject r10) {
        String r0 = r10.optString("subtype");
        if (Intrinsics.areEqual(r0, "null") == false) goto L6;
        return "null";
    L6:
        if (r10.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == true) goto L8;
        String r11 = r10.optString("description");
        Intrinsics.checkNotNull(r11);
        boolean r12 = false;
        if (r11.length() != 0) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        r11 = r10.optString("className");
    L15:
        Intrinsics.checkNotNull(r11);
        if (r11.length() != 0) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L25;
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == false) goto L25;
        if (Intrinsics.areEqual(r0, "null") == true) goto L25;
    L26:
        Intrinsics.checkNotNull(r0);
        if (r0.length() != 0) goto L29;
        boolean r1 = true;
    L30:
        if (r1 == false) goto L32;
        r0 = r10.optString("type");
    L32:
        Intrinsics.checkNotNull(r0);
        if (r0.length() != 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 == true) goto L38;
    L40:
        Intrinsics.checkNotNull(r0);
        if (r0.length() != 0) goto L43;
        r12 = true;
    L43:
        if (r12 == false) goto L45;
        r0 = r10.toString();
    L45:
        Intrinsics.checkNotNull(r0);
        return r0;
    L38:
        if ((!StringsKt.isBlank(r10.optString("objectId"))) == false) goto L40;
        r0 = "Object";
        goto L40
    L35:
        r15 = false;
        goto L36
    L29:
        r1 = false;
    L25:
        r0 = r11;
        goto L26
    L18:
        r14 = false;
        goto L19
    L12:
        r13 = false;
        goto L13
    L8:
        return l(r10.opt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE));
    }

    public static String l(Object r1) {
        if (r1 != null) goto L4;
    L10:
        return "null";
    L4:
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == true) goto L10;
        if ((r1 instanceof String) == false) goto L13;
        return (String) r1;
    L13:
        return r1.toString();
    }

    public static String m(Object r10) {
        String r1 = "{}";
        boolean r11 = true;
        if ((r10 instanceof JSONObject) == false) goto L24;
        JSONObject r12 = (JSONObject) r10;
        String r0 = i(r12);
        if (r0 != null) goto L22;
        r0 = r12.optString("description");
        if (r0.length() != 0) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L13;
        r0 = r12.optString("className");
    L13:
        if (r0.length() == 0) goto L16;
        r11 = false;
    L16:
        if (r11 == false) goto L22;
        if (SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r12.keys()), new n2())).isEmpty() == true) goto L21;
        r1 = "{...}";
    L21:
        r0 = r1;
        goto L22
    L9:
        r13 = false;
    L22:
        Intrinsics.checkNotNull(r0);
        return r0;
    L24:
        if ((r10 instanceof Map) == false) goto L57;
        Map r14 = (Map) r10;
        String r15 = h(r14);
        if (r15 != null) goto L69;
        Object r16 = r14.get("description");
        if (r16 == null) goto L30;
        String r17 = r16.toString();
    L31:
        if (r17 != null) goto L34;
        r17 = "";
    L34:
        if ((true ^ StringsKt.isBlank(r17)) == false) goto L36;
        r1 = r17;
    L70:
        return r1;
    L36:
        Set r18 = r14.keySet();
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L38:
        if (r20.hasNext() == false) goto L45;
        Object r21 = r20.next();
        if (r21 == null) goto L42;
        String r22 = r21.toString();
    L43:
        if (r22 == null) goto L38;
        r19.add(r22);
        goto L38
    L42:
        r22 = null;
        goto L43
    L45:
        ArrayList r23 = new ArrayList();
        Iterator r24 = r19.iterator();
    L47:
        if (r24.hasNext() == false) goto L52;
        Object r25 = r24.next();
        if (Intrinsics.areEqual((String) r25, "objectId") == true) goto L47;
        r23.add(r25);
        goto L47
    L52:
        if (r23.isEmpty() == true) goto L70;
        r1 = "{...}";
        goto L70
    L30:
        r17 = null;
        goto L31
    L69:
        return r15;
    L57:
        return l(r10);
    }

    public static void b(View r10, a r11) {
        Object r0 = b;
        monitor-enter(r0);
        WeakHashMap<View, d> r1 = e;     // Catch: Throwable -> L23
        d r12 = r1.get(r10);     // Catch: Throwable -> L23
        if (r12 != null) goto L7;
        r12 = new d();     // Catch: Throwable -> L23
        r1.put(r10, r12);     // Catch: Throwable -> L23
    L7:
        d r13 = r12;     // Catch: Throwable -> L23
        if (r13.a == false) goto L10;
    L13:
        ((ArrayList) r13.d).add(r11);     // Catch: Throwable -> L23
        if (((ArrayList) r13.d).size() <= 300) goto L16;
        ((ArrayList) r13.d).remove(0);     // Catch: Throwable -> L23
    L16:
        List r14 = CollectionsKt.toList(r13.e);     // Catch: Throwable -> L23
        List r15 = CollectionsKt.toList(r13.d);     // Catch: Throwable -> L23
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r0);
        Iterator r17 = r14.iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        ((Function1) r17.next()).invoke(r15);
        goto L20
    L22:
        return;
    L10:
        if (r13.e.isEmpty() == false) goto L13;
        monitor-exit(r0);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void c(View r10, boolean r11) {
        Object r1 = null;
        if ((r10 instanceof LynxView) == false) goto L5;
        LynxView r12 = (LynxView) r10;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        LynxBaseInspectorOwner r0 = r12.getBaseInspectorOwner();
        if (r0 != null) goto L11;
        return;
    L11:
        Object r13 = b;
        monitor-enter(r13);
        WeakHashMap<View, d> r14 = e;     // Catch: Throwable -> L49
        d r15 = r14.get(r12);     // Catch: Throwable -> L49
        if (r15 != null) goto L16;
        r15 = new d();     // Catch: Throwable -> L49
        r14.put(r12, r15);     // Catch: Throwable -> L49
    L16:
        d r16 = r15;     // Catch: Throwable -> L49
        if (r16.a == true) goto L21;
        if (r11 == true) goto L21;
        boolean r17 = false;
    L22:
        r16.a = r17;     // Catch: Throwable -> L49
        r16.c = new WeakReference(r0);     // Catch: Throwable -> L49
        boolean r18 = !r16.b;     // Catch: Throwable -> L49
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r13);
        if (r18 == true) goto L52;
        return;
    L52:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L27
        Object r21 = Result.constructor-impl(a());     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r21) == false) goto L32;
        r21 = null;
    L32:
        Class r22 = (Class) r21;
        if (r22 == null) goto L36;
        final WeakReference r23 = new WeakReference(r12);
        r1 = Proxy.newProxyInstance(r22.getClassLoader(), new Class[]{r22}, new e2(r23));
    L36:
        if (r1 == null) goto L58;
        r0.setLynxInspectorConsoleDelegate(r1);
        Object r24 = b;
        monitor-enter(r24);
        d r25 = e.get(r12);     // Catch: Throwable -> L45
        if (r25 == null) goto L42;
        r25.b = true;     // Catch: Throwable -> L45
    L42:
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r24);
        return;
    L45:
        th = move-exception;
        throw th;
    L58:
        return;
    L27:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        r17 = true;
    L49:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }

    public static b e(String r10, Object r11) {
        Object r12 = g(r11);
        String r0 = null;
        if (r12 == null) goto L35;
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == true) goto L35;
        if ((r12 instanceof JSONObject) == false) goto L17;
        JSONObject r1 = (JSONObject) r12;
        String r13 = r1.optString("objectId");
        Intrinsics.checkNotNull(r13);
        if ((!StringsKt.isBlank(r13)) == false) goto L12;
        r0 = r13;
    L12:
        String r14 = i(r1);
        if (r14 != null) goto L36;
        r14 = m(r12);
    L36:
        return new b(r10, r14, r0);
    L17:
        if ((r12 instanceof JSONArray) == false) goto L21;
        b r15 = new b(r10, "[" + ((JSONArray) r12).length() + ']', null);
    L37:
        return r15;
    L21:
        if ((r12 instanceof Map) == false) goto L31;
        Object r16 = ((Map) r12).get("objectId");
        if (r16 == null) goto L38;
        String r17 = r16.toString();
        if (r17 == null) goto L38;
        if ((!StringsKt.isBlank(r17)) == false) goto L38;
        r0 = r17;
    L38:
        return new b(r10, m(r12), r0);
    L31:
        if ((r12 instanceof List) == false) goto L33;
        r15 = new b(r10, "[" + ((List) r12).size() + ']', null);
        goto L37
    L33:
        r15 = new b(r10, l(r12), null);
    L35:
        return new b(r10, "null", null);
    }

    public static void j(View r10, long r11, String r13, final Function1 r14) {
        Intrinsics.checkNotNullParameter(r14, "onResolved");
        if ((r10 instanceof LynxView) == false) goto L5;
        LynxView r12 = (LynxView) r10;
    L6:
        if (r12 != null) goto L9;
        r14.invoke(CollectionsKt.emptyList());
        return;
    L9:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r16 = b;
        monitor-enter(r16);
        d r17 = e.get(r12);     // Catch: Throwable -> L62
        if (r17 == null) goto L59;
        WeakReference<LynxBaseInspectorOwner> r18 = r17.c;     // Catch: Throwable -> L62
        if (r18 == null) goto L59;
        LynxBaseInspectorOwner r19 = r18.get();     // Catch: Throwable -> L62
        if (r19 == null) goto L59;
        r15.element = r19;     // Catch: Throwable -> L62
        if (r13 == null) goto L21;
        List r110 = CollectionsKt.listOf(r13);     // Catch: Throwable -> L62
    L42:
        r0.element = r110;     // Catch: Throwable -> L62
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(r16);
        if (r110.isEmpty() == false) goto L48;
        r14.invoke(CollectionsKt.emptyList());
        return;
    L48:
        int r112 = ((List) r0.element).size();
        final ArrayList r113 = new ArrayList(r112);
        int r114 = 0;
    L49:
        if (r114 >= r112) goto L51;
        r113.add(null);
        r114 = r114 + 1;
        goto L49
    L51:
        final AtomicInteger r115 = new AtomicInteger(((List) r0.element).size());
        Iterator r116 = ((Iterable) r0.element).iterator();
        final int r20 = 0;
    L53:
        if (r116.hasNext() == false) goto L58;
        Object r117 = r116.next();
        int r21 = r20 + 1;
        if (r20 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        final String r22 = (String) r117;
        c.post(new k2(r15, r22, r113, r20, r115, r14));
        r20 = r21;
        goto L53
    L58:
        return;
    L21:
        Iterator r118 = ((ArrayList) r17.d).iterator();     // Catch: Throwable -> L62
    L23:
        if (r118.hasNext() == false) goto L30;
        Object r119 = r118.next();     // Catch: Throwable -> L62
        if (((a) r119).a != r11) goto L27;
        boolean r23 = true;
    L28:
        if (r23 == false) goto L23;
    L31:
        a r120 = (a) r119;     // Catch: Throwable -> L62
        if (r120 == null) goto L34;
        List<c> r121 = r120.e;     // Catch: Throwable -> L62
    L35:
        if (r121 != null) goto L37;
        r121 = CollectionsKt.emptyList();     // Catch: Throwable -> L62
    L37:
        List<c> r122 = r121;     // Catch: Throwable -> L62
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));     // Catch: Throwable -> L62
        Iterator<T> r124 = r122.iterator();     // Catch: Throwable -> L62
    L39:
        if (r124.hasNext() == false) goto L41;
        r123.add(((c) r124.next()).a);     // Catch: Throwable -> L62
        goto L39
    L41:
        r110 = r123;
        goto L42
    L34:
        r121 = null;
        goto L35
    L27:
        r23 = false;
        goto L28
    L30:
        r119 = null;
    L59:
        r14.invoke(CollectionsKt.emptyList());     // Catch: Throwable -> L62
        monitor-exit(r16);
        return;
    L62:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }
}
