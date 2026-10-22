package com.obric.memorydata.memory.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006*\u0001\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager;", "", "<init>", "()V", "TAG", "", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Callback;", "receiverRegistered", "", "lastLocaleTag", "lastCountry", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "register", "key", "callback", "unregister", "refresh", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Reason;", "updateSnapshot", "currentLocale", "Ljava/util/Locale;", "localeReceiver", "com/obric/memorydata/memory/utils/LocaleRegionRefreshManager$localeReceiver$1", "Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$localeReceiver$1;", "Reason", "Event", "Callback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocaleRegionRefreshManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocaleRegionRefreshManager f11524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f11525b = null;
    private static boolean c;
    private static String d;
    private static String e;
    private static final c f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "LOCALE_CHANGED", "MANUAL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason LOCALE_CHANGED = null;
        public static final Reason MANUAL = null;

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{LOCALE_CHANGED, MANUAL};
        }

        static {
            LOCALE_CHANGED = new Reason("LOCALE_CHANGED", 0);
            MANUAL = new Reason("MANUAL", 1);
            Reason[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Reason(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Reason> getEntries() {
            return $ENTRIES;
        }

        public static Reason valueOf(String r2) {
            return (Reason) ZeusTransformUtils.preCheckCast(Enum.valueOf(Reason.class, r2), Reason.class, "com.obric.memorydata.plugin");
        }

        public static Reason[] values() {
            return (Reason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Reason[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Callback;", "", "onRefresh", "", "event", "Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Event;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void onRefresh(b r1);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Event;", "", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Reason;", "localeTag", "", "country", "oldLocaleTag", "oldCountry", "<init>", "(Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Reason;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReason", "()Lcom/obric/memorydata/memory/utils/LocaleRegionRefreshManager$Reason;", "getLocaleTag", "()Ljava/lang/String;", "getCountry", "getOldLocaleTag", "getOldCountry", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reason f11526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11527b;
        private final String c;
        private final String d;
        private final String e;

        public b(Reason r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
            Intrinsics.checkNotNullParameter(r3, "localeTag");
            Intrinsics.checkNotNullParameter(r4, "country");
            this.f11526a = r2;
            this.f11527b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final String a() {
            return this.f11527b;
        }

        public final String b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11526a == r6.f11526a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11527b, r6.f11527b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f11526a.hashCode() * 31) + this.f11527b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Event(reason=" + this.f11526a + ", localeTag=" + this.f11527b + ", country=" + this.c + ", oldLocaleTag=" + this.d + ", oldCountry=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/utils/LocaleRegionRefreshManager$localeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {
        c() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (Intrinsics.areEqual(r4, "android.intent.action.LOCALE_CHANGED") == false) goto L10;
            LocaleRegionRefreshManager.f11524a.a(Reason.LOCALE_CHANGED);
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
        f11524a = new LocaleRegionRefreshManager();
        f11525b = new ConcurrentHashMap();
        f = new c();
    }

    private LocaleRegionRefreshManager() {
    }

    private final void a() {
        Locale r1 = b();
        d = r1.toLanguageTag();
        e = r1.getCountry();
    }

    public static /* synthetic */ void a(LocaleRegionRefreshManager r0, Reason r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Reason.MANUAL;
    L5:
        r0.a(r1);
    }

    private final Locale b() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Locale r1 = LocaleList.getDefault().get(0);
        if (r1 == null) goto L6;
    L7:
        Intrinsics.checkNotNull(r1);
        return r1;
    L6:
        r1 = Locale.getDefault();
        goto L7
    }

    public final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (c == false) goto L5;
        return;
    L5:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        a();
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.LOCALE_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L8;
        ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r3, 4, "com.obric.memorydata.plugin");
    L9:
        c = true;
        return;
    L8:
        ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r3, "com.obric.memorydata.plugin");
        goto L9
    }

    public final void a(Reason r10) {
        Intrinsics.checkNotNullParameter(r10, InfoRequestQPSOptTraceLogger.REASON);
        String r5 = d;
        String r6 = e;
        a();
        String r0 = d;
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = e;
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        b r9 = new b(r10, r3, r4, r5, r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocaleRegionRefreshManager", "refresh reason=" + r10 + " locale=" + r9.a() + " country=" + r9.b(), false, 4, null);
        Set<Map.Entry<String, a>> r11 = f11525b.entrySet();
        Intrinsics.checkNotNullExpressionValue(r11, "<get-entries>(...)");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin")).onRefresh(r9);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        RunLog.INSTANCE.error("LocaleRegionRefreshManager", "refresh callback failed: " + ((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L12
    L18:
        return;
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public final void a(String r3, a r4) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((Map) ZeusTransformUtils.preCheckCast(f11525b, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }
}
