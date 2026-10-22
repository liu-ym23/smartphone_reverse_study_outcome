package com.bytedance.ai.debugscene;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.NativeDebugPanelType;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DebugSceneInstancePanelController {
    public static final DebugSceneInstancePanelController a = null;
    public static final Object b = null;
    public static final WeakHashMap<View, InstancePanelSession> c = null;

    public static final class InstancePanelSession implements com.bytedance.ai.debug.h {
        public final Handler a;
        public final WeakReference<LynxView> b;
        public String c;
        public LogFilter d;
        public String e;
        public List<DebugSceneLynxConsoleStore.a> f;
        public final LinkedHashSet<Long> g;
        public final LinkedHashSet<Long> h;
        public final LinkedHashMap<Long, List<DebugSceneLynxConsoleStore.b>> i;
        public final LinkedHashSet<String> j;
        public final LinkedHashSet<String> k;
        public final LinkedHashMap<String, List<DebugSceneLynxConsoleStore.b>> l;
        public final LinkedHashMap<String, String> m;
        public Function0<Unit> n;
        public boolean o;
        public int p;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/debugscene/DebugSceneInstancePanelController$InstancePanelSession$LogFilter;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "ALL", "INFO", "DEBUG", "WARN", "ERROR", "matches", "", "level", "Lcom/bytedance/ai/debugscene/DebugSceneLynxConsoleStore$ConsoleLevel;", "Companion", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum LogFilter extends Enum<LogFilter> {
            public static final LogFilter ALL = null;
            public static final a Companion = null;
            public static final LogFilter DEBUG = null;
            public static final LogFilter ERROR = null;
            public static final LogFilter INFO = null;
            public static final LogFilter WARN = null;
            public static final /* synthetic */ LogFilter[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final String label;

            public static final class a {
                public a() {
                }
            }

            public static EnumEntries<LogFilter> getEntries() {
                return b;
            }

            static {
                LogFilter r0 = new LogFilter("ALL", 0, "All levels");
                ALL = r0;
                LogFilter r1 = new LogFilter("INFO", 1, "Info");
                INFO = r1;
                LogFilter r10 = new LogFilter("DEBUG", 2, "Debug");
                DEBUG = r10;
                LogFilter r11 = new LogFilter("WARN", 3, "Warn");
                WARN = r11;
                LogFilter r12 = new LogFilter("ERROR", 4, "Error");
                ERROR = r12;
                LogFilter[] r13 = {r0, r1, r10, r11, r12};
                a = r13;
                b = EnumEntriesKt.enumEntries(r13);
                Companion = new a();
            }

            public static LogFilter[] values() {
                return (LogFilter[]) a.clone();
            }

            public final String getLabel() {
                return this.label;
            }

            public static LogFilter valueOf(String r1) {
                return (LogFilter) r27.a.a(LogFilter.class, r1);
            }

            public final boolean matches(DebugSceneLynxConsoleStore.ConsoleLevel r10) {
                Intrinsics.checkNotNullParameter(r10, "level");
                if (this != ALL) goto L5;
            L8:
                return true;
            L5:
                if (Intrinsics.areEqual(name(), r10.name()) == true) goto L8;
                return false;
            }

            public LogFilter(String r1, int r10, String r11) {
                super(r1, r10);
                this.label = r11;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/debugscene/DebugSceneInstancePanelController$InstancePanelSession$MessageResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "INVALID_PARAM", "NOT_REGISTERED", "TARGET_UNAVAILABLE", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum MessageResult extends Enum<MessageResult> {
            public static final MessageResult INVALID_PARAM = null;
            public static final MessageResult NOT_REGISTERED = null;
            public static final MessageResult SUCCESS = null;
            public static final MessageResult TARGET_UNAVAILABLE = null;
            public static final /* synthetic */ MessageResult[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<MessageResult> getEntries() {
                return b;
            }

            static {
                MessageResult r0 = new MessageResult("SUCCESS", 0);
                SUCCESS = r0;
                MessageResult r1 = new MessageResult("INVALID_PARAM", 1);
                INVALID_PARAM = r1;
                MessageResult r10 = new MessageResult("NOT_REGISTERED", 2);
                NOT_REGISTERED = r10;
                MessageResult r11 = new MessageResult("TARGET_UNAVAILABLE", 3);
                TARGET_UNAVAILABLE = r11;
                MessageResult[] r12 = {r0, r1, r10, r11};
                a = r12;
                b = EnumEntriesKt.enumEntries(r12);
            }

            public static MessageResult[] values() {
                return (MessageResult[]) a.clone();
            }

            public static MessageResult valueOf(String r1) {
                return (MessageResult) r27.a.a(MessageResult.class, r1);
            }

            public MessageResult(String r1, int r10) {
                super(r1, r10);
            }
        }

        public static final class a {
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MessageResult.values().length];
                r0[MessageResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[MessageResult.INVALID_PARAM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[MessageResult.NOT_REGISTERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[MessageResult.TARGET_UNAVAILABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        static {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ai.debugscene.y1, java.lang.Object] */
        @Override // com.bytedance.ai.debug.h
        public final void a() {
            this.o = true;
            this.p++;
            Function0<Unit> r0 = this.n;
            if (r0 == null) goto L5;
            r0.invoke();
        L5:
            DebugSceneLynxConsoleStore r1 = DebugSceneLynxConsoleStore.a;
            final View r10 = this.b.get();
            final ?? r11 = new y1(this);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r11, "listener");
            if (r10 != null) goto L8;
            r11.invoke(CollectionsKt.emptyList());
            Function0<Unit> r12 = new i2();
        L16:
            this.n = r12;
            return;
        L8:
            Object r13 = DebugSceneLynxConsoleStore.b;
            monitor-enter(r13);
            WeakHashMap<View, DebugSceneLynxConsoleStore.d> r14 = DebugSceneLynxConsoleStore.e;     // Catch: Throwable -> L18
            DebugSceneLynxConsoleStore.d r15 = r14.get(r10);     // Catch: Throwable -> L18
            if (r15 != null) goto L13;
            r15 = new DebugSceneLynxConsoleStore.d();     // Catch: Throwable -> L18
            r14.put(r10, r15);     // Catch: Throwable -> L18
        L13:
            DebugSceneLynxConsoleStore.d r16 = r15;     // Catch: Throwable -> L18
            r16.e.add((Function1<List<DebugSceneLynxConsoleStore.a>, Unit>) r11);     // Catch: Throwable -> L18
            r11.invoke(CollectionsKt.toList(r16.d));     // Catch: Throwable -> L18
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r13);
            r12 = new j2(r10, r11);
        L18:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.ai.debug.h
        public final void onClosed() {
            this.o = false;
            this.p++;
            Function0<Unit> r0 = this.n;
            if (r0 == null) goto L5;
            r0.invoke();
        L5:
            this.n = null;
            this.d = LogFilter.ALL;
            this.e = "";
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.k.clear();
            this.l.clear();
            this.m.clear();
        }

        public final String d() {
            this.m.clear();
            LynxView r0 = this.b.get();
            if (r0 == null) goto L5;
            Context r1 = r0.getContext();
        L6:
            JSONObject r10 = new JSONObject();
            if (r1 == null) goto L10;
            Object r11 = r1.getString(2131896076);
            if (r11 == null) goto L10;
        L11:
            r10.put("title", r11);
            r10.put("subtitle", this.c);
            r10.put("selectedLevelKey", this.d.name());
            r10.put("keyword", this.e);
            if (r1 == null) goto L15;
            Object r12 = r1.getString(2131896074);
            if (r12 == null) goto L15;
        L16:
            r10.put("emptyText", r12);
            r10.put(MessageIndication.MESSAGE_TYPE_LOADING, false);
            JSONArray r13 = new JSONArray();
            Iterator r14 = LogFilter.getEntries().iterator();
        L18:
            if (r14.hasNext() == false) goto L20;
            LogFilter r15 = (LogFilter) r14.next();
            r13.put(new JSONObject().put("key", r15.name()).put("label", r15.getLabel()));
            goto L18
        L20:
            Unit r16 = Unit.INSTANCE;
            r10.put("levels", r13);
            JSONArray r17 = new JSONArray();
            List<DebugSceneLynxConsoleStore.a> r18 = this.f;
            ArrayList r19 = new ArrayList();
            Iterator<T> r20 = r18.iterator();
        L22:
            if (r20.hasNext() == false) goto L33;
            Object r21 = r20.next();
            DebugSceneLynxConsoleStore.a r22 = (DebugSceneLynxConsoleStore.a) r21;
            if (this.d.matches(r22.b) == false) goto L30;
            boolean r23 = true;
            if (StringsKt.isBlank(this.e) == false) goto L28;
        L31:
            if (r23 == false) goto L22;
            r19.add(r21);
            goto L22
        L28:
            if (StringsKt.contains(r22.c, this.e, true) == true) goto L31;
        L30:
            r23 = false;
            goto L31
        L33:
            Iterator r24 = r19.iterator();
        L35:
            if (r24.hasNext() == false) goto L43;
            DebugSceneLynxConsoleStore.a r25 = (DebugSceneLynxConsoleStore.a) r24.next();
            boolean r26 = this.g.contains(Long.valueOf(r25.a));
            JSONObject r27 = new JSONObject();
            r27.put("id", String.valueOf(r25.a));
            r27.put("level", r25.b.name());
            r27.put("text", r25.c);
            r27.put("expandable", r25.d);
            r27.put("expanded", r26);
            r27.put(MessageIndication.MESSAGE_TYPE_LOADING, this.h.contains(Long.valueOf(r25.a)));
            if (r26 == false) goto L42;
            String r28 = "entry_" + r25.a;
            List<DebugSceneLynxConsoleStore.b> r29 = this.i.get(Long.valueOf(r25.a));
            if (r29 != null) goto L41;
            r29 = CollectionsKt.emptyList();
        L41:
            r27.put("children", c(r28, r29));
        L42:
            r17.put(r27);
            goto L35
        L43:
            Unit r30 = Unit.INSTANCE;
            r10.put("entries", r17);
            return r10.toString();
        L15:
            r12 = "No console output";
        L10:
            r11 = "Instance Panel";
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        public final void e() {
            if (this.o == true) goto L6;
            return;
        L6:
            if (IAISDKDebugService.a.j("DebugPanel.console", new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_MSG, d()).toString()) == true) goto L9;
            com.bytedance.ai.utils.g.a.w("DebugSceneInstancePanel", "drop console state because panel is unavailable, entries:" + this.f.size());
            return;
        }

        public final boolean g() {
            DebugSceneLynxConsoleStore r0 = DebugSceneLynxConsoleStore.a;
            View r1 = this.b.get();
            r0.getClass();
            boolean r10 = false;
            if (r1 == null) goto L17;
            Object r11 = DebugSceneLynxConsoleStore.b;
            monitor-enter(r11);
            DebugSceneLynxConsoleStore.d r12 = DebugSceneLynxConsoleStore.e.get(r1);     // Catch: Throwable -> L18
            if (r12 == null) goto L13;
            WeakReference<LynxBaseInspectorOwner> r13 = r12.c;     // Catch: Throwable -> L18
            if (r13 == null) goto L13;
            LynxBaseInspectorOwner r14 = r13.get();     // Catch: Throwable -> L18
        L14:
            if (r14 == null) goto L16;
            r10 = true;
        L16:
            monitor-exit(r11);
        L13:
            r14 = null;
        L18:
            th = move-exception;
            throw th;
        L17:
            return r10;
        }

        public InstancePanelSession(LynxView r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.a = new Handler(Looper.getMainLooper());
            this.b = new WeakReference(r10);
            this.c = "";
            this.d = LogFilter.ALL;
            this.e = "";
            this.f = CollectionsKt.emptyList();
            this.g = new LinkedHashSet();
            this.h = new LinkedHashSet();
            this.i = new LinkedHashMap();
            this.j = new LinkedHashSet();
            this.k = new LinkedHashSet();
            this.l = new LinkedHashMap();
            this.m = new LinkedHashMap();
        }

        public final String f(String r10) {
            Intrinsics.checkNotNullParameter(r10, "subtitle");
            this.c = r10;
            if (this.o == true) goto L23;
            DebugSceneLynxConsoleStore r11 = DebugSceneLynxConsoleStore.a;
            View r0 = this.b.get();
            r11.getClass();
            if (r0 != null) goto L7;
            List<DebugSceneLynxConsoleStore.a> r12 = CollectionsKt.emptyList();
        L18:
            this.f = r12;
            goto L23
        L7:
            Object r13 = DebugSceneLynxConsoleStore.b;
            monitor-enter(r13);
            DebugSceneLynxConsoleStore.d r1 = DebugSceneLynxConsoleStore.e.get(r0);     // Catch: Throwable -> L19
            if (r1 == null) goto L15;
            List<DebugSceneLynxConsoleStore.a> r14 = r1.d;     // Catch: Throwable -> L19
            if (r14 == null) goto L15;
            List<DebugSceneLynxConsoleStore.a> r15 = CollectionsKt.toList(r14);     // Catch: Throwable -> L19
            if (r15 == null) goto L15;
        L16:
            monitor-exit(r13);
            r12 = r15;
        L15:
            r15 = CollectionsKt.emptyList();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L23:
            return d();
        }

        public final JSONArray c(String r10, List<DebugSceneLynxConsoleStore.b> r11) {
            JSONArray r0 = new JSONArray();
            Iterator<T> r12 = r11.iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L27;
            Object r14 = r12.next();
            int r15 = r13 + 1;
            if (r13 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            DebugSceneLynxConsoleStore.b r16 = (DebugSceneLynxConsoleStore.b) r14;
            String r17 = r10 + '/' + r13 + '/' + r16.a;
            String r18 = r16.c;
            if (r18 == null) goto L11;
            this.m.put(r17, r18);
        L11:
            boolean r19 = this.j.contains(r17);
            JSONObject r20 = new JSONObject();
            r20.put("id", r17);
            r20.put("label", r16.a);
            String r21 = r16.b;
            if (r21 == null) goto L14;
            r20.put("preview", r21);
        L14:
            String r22 = r16.c;
            if (r22 == null) goto L19;
            boolean r23 = true;
            if ((!StringsKt.isBlank(r22)) != true) goto L19;
        L20:
            r20.put("expandable", r23);
            r20.put("expanded", r19);
            r20.put(MessageIndication.MESSAGE_TYPE_LOADING, this.k.contains(r17));
            if (r19 == false) goto L26;
            List<DebugSceneLynxConsoleStore.b> r24 = this.l.get(r17);
            if (r24 != null) goto L25;
            r24 = CollectionsKt.emptyList();
        L25:
            r20.put("children", c(r17, r24));
        L26:
            r0.put(r20);
            r13 = r15;
        L19:
            r23 = false;
            goto L20
        L27:
            return r0;
        }

        @Override // com.bytedance.ai.debug.h
        public final void b(String r16, String r17, h0 r18) {
            Intrinsics.checkNotNullParameter(r16, "type");
            Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r18, "reply");
            if (Intrinsics.areEqual(r16, "DebugPanel.console") == true) goto L135;
            r18.a(-2, "MESSAGE_TYPE_NOT_REGISTERED", null);
            return;
        L135:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            Object r1 = Result.constructor-impl(new JSONObject(r17));     // Catch: Throwable -> L8
        L11:
            if (Result.isFailure-impl(r1) == false) goto L13;
            r1 = null;
        L13:
            JSONObject r10 = (JSONObject) r1;
            if (r10 == null) goto L16;
            String r11 = r10.optString("type");
        L17:
            if (r11 != null) goto L19;
            r11 = "";
        L19:
            if (r10 == null) goto L22;
            JSONObject r12 = r10.optJSONObject("payload");
            if (r12 == null) goto L22;
        L24:
            switch(r11.hashCode()) {
                case 825830086: goto L116;
                case 979215409: goto L83;
                case 1111010241: goto L41;
                case 1416911383: goto L27;
                default: goto L119;
            };
        L119:
            MessageResult r13 = MessageResult.NOT_REGISTERED;
        L120:
            int r14 = b.a[r13.ordinal()];
            if (r14 != 1) goto L123;
            r18.a(1, "SUCCESS", null);
            return;
        L123:
            if (r14 != 2) goto L125;
            r18.a(-3, "INVALID_PARAM", null);
            return;
        L125:
            if (r14 != 3) goto L127;
            r18.a(-2, "MESSAGE_TYPE_NOT_REGISTERED", null);
            return;
        L127:
            if (r14 != 4) goto L130;
            r18.a(0, "TARGET_UNAVAILABLE", null);
            return;
        L130:
            throw new NoWhenBranchMatchedException();
        L27:
            if (r11.equals("level_select") == false) goto L119;
            LogFilter.a r15 = LogFilter.Companion;
            String r19 = r12.optString("key");
            r15.getClass();
            Iterator r20 = LogFilter.getEntries().iterator();
        L31:
            if (r20.hasNext() == false) goto L35;
            Object r21 = r20.next();
            if (Intrinsics.areEqual(((LogFilter) r21).name(), r19) == false) goto L31;
        L36:
            LogFilter r22 = (LogFilter) r21;
            if (r22 != null) goto L39;
            r22 = LogFilter.ALL;
        L39:
            this.d = r22;
            e();
            r13 = MessageResult.SUCCESS;
            goto L120
        L35:
            r21 = null;
            goto L36
        L41:
            if (r11.equals("entry_toggle") == false) goto L119;
            Object r23 = r12.opt("entryId");
            if (r23 == null) goto L80;
            String r24 = r23.toString();
            if (r24 == null) goto L80;
            Long r25 = StringsKt.toLongOrNull(r24);
            if (r25 == null) goto L80;
            final long r110 = r25.longValue();
            Iterator<T> r26 = this.f.iterator();
        L51:
            if (r26.hasNext() == false) goto L58;
            Object r27 = r26.next();
            if (((DebugSceneLynxConsoleStore.a) r27).a != r110) goto L55;
            boolean r28 = true;
        L56:
            if (r28 == false) goto L51;
        L59:
            DebugSceneLynxConsoleStore.a r29 = (DebugSceneLynxConsoleStore.a) r27;
            if (r29 != null) goto L63;
            r13 = MessageResult.INVALID_PARAM;
            goto L120
        L63:
            if (this.g.remove(Long.valueOf(r110)) == false) goto L66;
            e();
            r13 = MessageResult.SUCCESS;
            goto L120
        L66:
            if (r29.d == true) goto L69;
            r13 = MessageResult.INVALID_PARAM;
            goto L120
        L69:
            if (this.i.containsKey(Long.valueOf(r110)) == false) goto L71;
        L73:
            this.g.add(Long.valueOf(r110));
            if (this.i.containsKey(Long.valueOf(r110)) == false) goto L76;
        L79:
            e();
            r13 = MessageResult.SUCCESS;
            goto L120
        L76:
            if (this.h.contains(Long.valueOf(r110)) == true) goto L79;
            this.h.add(Long.valueOf(r110));
            e();
            final int r30 = this.p;
            DebugSceneLynxConsoleStore r31 = DebugSceneLynxConsoleStore.a;
            View r32 = this.b.get();
            Function1 r33 = new a2(this, r30, r110);
            r31.getClass();
            DebugSceneLynxConsoleStore.j(r32, r110, null, r33);
            r13 = MessageResult.SUCCESS;
            goto L120
        L71:
            if (g() == true) goto L73;
            r13 = MessageResult.TARGET_UNAVAILABLE;
            goto L120
        L55:
            r28 = false;
            goto L56
        L58:
            r27 = null;
        L80:
            r18.a(-3, "INVALID_PARAM", null);
            return;
        L83:
            if (r11.equals("node_toggle") == false) goto L119;
            Object r34 = r12.opt("entryId");
            if (r34 == null) goto L113;
            String r35 = r34.toString();
            if (r35 == null) goto L113;
            Long r36 = StringsKt.toLongOrNull(r35);
            if (r36 == null) goto L113;
            long r37 = r36.longValue();
            final String r38 = r12.optString("nodeId");
            Intrinsics.checkNotNull(r38);
            if (StringsKt.isBlank(r38) == false) goto L96;
            r18.a(-3, "INVALID_PARAM", null);
            return;
        L96:
            if (this.j.remove(r38) == false) goto L98;
            e();
            r13 = MessageResult.SUCCESS;
            goto L120
        L98:
            String r39 = this.m.get(r38);
            if (r39 != null) goto L102;
            r13 = MessageResult.INVALID_PARAM;
            goto L120
        L102:
            if (this.l.containsKey(r38) == false) goto L104;
        L106:
            this.j.add(r38);
            if (this.l.containsKey(r38) == false) goto L109;
        L112:
            e();
            r13 = MessageResult.SUCCESS;
            goto L120
        L109:
            if (this.k.contains(r38) == true) goto L112;
            this.k.add(r38);
            e();
            final int r40 = this.p;
            DebugSceneLynxConsoleStore r111 = DebugSceneLynxConsoleStore.a;
            View r112 = this.b.get();
            Function1 r113 = new z1(this, r40, r38);
            r111.getClass();
            DebugSceneLynxConsoleStore.j(r112, r37, r39, r113);
            r13 = MessageResult.SUCCESS;
            goto L120
        L104:
            if (g() == true) goto L106;
            r13 = MessageResult.TARGET_UNAVAILABLE;
        L113:
            r18.a(-3, "INVALID_PARAM", null);
            return;
        L116:
            if (r11.equals("keyword_change") == false) goto L119;
            this.e = StringsKt.trim(r12.optString("keyword")).toString();
            e();
            r13 = MessageResult.SUCCESS;
        L22:
            r12 = new JSONObject();
            goto L24
        L16:
            r11 = null;
        L8:
            th = move-exception;
            Result.Companion r41 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    public DebugSceneInstancePanelController() {
    }

    static {
        a = new DebugSceneInstancePanelController();
        b = new Object();
        c = new WeakHashMap();
    }

    public static boolean a(String r10, View r11, View r12, boolean r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "subtitle");
        String r1 = null;
        if ((r11 instanceof LynxView) == false) goto L5;
        LynxView r0 = (LynxView) r11;
    L6:
        if (r0 != null) goto L12;
        com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
        StringBuilder r16 = new StringBuilder("show instance panel rejected, targetType:");
        if (r11 == null) goto L10;
        r1 = r11.getClass().getName();
    L10:
        r16.append(r1);
        r15.w("DebugSceneInstancePanel", r16.toString());
        return false;
    L12:
        DebugSceneLynxConsoleStore.a.getClass();
        DebugSceneLynxConsoleStore.c(r0, r13);
        Object r17 = b;
        monitor-enter(r17);
        WeakHashMap<View, InstancePanelSession> r18 = c;     // Catch: Throwable -> L24
        InstancePanelSession r19 = r18.get(r0);     // Catch: Throwable -> L24
        if (r19 != null) goto L17;
        r19 = new InstancePanelSession(r0);     // Catch: Throwable -> L24
        r18.put(r0, r19);     // Catch: Throwable -> L24
    L17:
        InstancePanelSession r20 = r19;     // Catch: Throwable -> L24
        monitor-exit(r17);
        if (StringsKt.isBlank(r10) == false) goto L23;
        r10 = r0.getContext().getString(r14);
    L23:
        return IAISDKDebugService.a.t(NativeDebugPanelType.DEBUG_PANEL, r20.f(r10), r20, r12);
    L24:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }
}
