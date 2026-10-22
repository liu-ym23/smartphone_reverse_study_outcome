package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes6.dex */
public final class PropertiesUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PropertiesUtil f17911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f17912b;

    /* JADX INFO: renamed from: org.apache.logging.log4j.util.PropertiesUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final enum TimeUnit extends Enum<TimeUnit> {
        private static final /* synthetic */ TimeUnit[] $VALUES = null;
        public static final TimeUnit DAYS = null;
        public static final TimeUnit HOURS = null;
        public static final TimeUnit MICROS = null;
        public static final TimeUnit MILLIS = null;
        public static final TimeUnit MINUTES = null;
        public static final TimeUnit NANOS = null;
        public static final TimeUnit SECONDS = null;
        private final String[] descriptions;
        private final ChronoUnit timeUnit;

        static {
            TimeUnit r0 = new TimeUnit("NANOS", 0, "ns,nano,nanos,nanosecond,nanoseconds", ChronoUnit.NANOS);
            NANOS = r0;
            TimeUnit r1 = new TimeUnit("MICROS", 1, "us,micro,micros,microsecond,microseconds", ChronoUnit.MICROS);
            MICROS = r1;
            TimeUnit r2 = new TimeUnit("MILLIS", 2, "ms,milli,millis,millsecond,milliseconds", ChronoUnit.MILLIS);
            MILLIS = r2;
            TimeUnit r4 = new TimeUnit("SECONDS", 3, "s,second,seconds", ChronoUnit.SECONDS);
            SECONDS = r4;
            TimeUnit r6 = new TimeUnit("MINUTES", 4, "m,minute,minutes", ChronoUnit.MINUTES);
            MINUTES = r6;
            TimeUnit r8 = new TimeUnit("HOURS", 5, "h,hour,hours", ChronoUnit.HOURS);
            HOURS = r8;
            TimeUnit r10 = new TimeUnit("DAYS", 6, "d,day,days", ChronoUnit.DAYS);
            DAYS = r10;
            $VALUES = new TimeUnit[]{r0, r1, r2, r4, r6, r8, r10};
        }

        private TimeUnit(String r1, int r2, String r3, ChronoUnit r4) {
            super(r1, r2);
            this.descriptions = r3.split(",");
            this.timeUnit = r4;
        }

        static Duration getDuration(String r13) {
            String r14 = r13.trim();
            ChronoUnit r0 = ChronoUnit.MILLIS;
            TimeUnit[] r1 = values();
            int r2 = r1.length;
            long r4 = 0;
            int r6 = 0;
        L3:
            if (r6 >= r2) goto L12;
            TimeUnit r7 = r1[r6];
            String[] r8 = r7.descriptions;
            int r9 = r8.length;
            int r10 = 0;
        L5:
            if (r10 >= r9) goto L10;
            String r11 = r8[r10];
            if (r14.endsWith(r11) == false) goto L9;
            r0 = r7.timeUnit;
            r4 = Long.parseLong(r14.substring(0, r14.length() - r11.length()));
        L9:
            r10 = r10 + 1;
            goto L5
        L10:
            r6 = r6 + 1;
            goto L3
        L12:
            return Duration.of(r4, r0);
        }

        public static TimeUnit valueOf(String r2) {
            return (TimeUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeUnit.class, r2), TimeUnit.class, "com.obric.memorydata.plugin");
        }

        public static TimeUnit[] values() {
            return (TimeUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeUnit[].class, "com.obric.memorydata.plugin");
        }

        ChronoUnit getTimeUnit() {
            return this.timeUnit;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<PropertySource> f17913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f17914b;
        private final Map<String, String> c;
        private final Map<List<CharSequence>, String> d;

        private a(PropertySource r4) {
            PropertySource r5 = (PropertySource) ZeusTransformUtils.wrapperContextForParams(r4, PropertySource.class, "com.obric.memorydata.plugin");
            this.f17913a = new TreeSet(new PropertySource.Comparator());
            this.f17914b = new ConcurrentHashMap();
            this.c = new ConcurrentHashMap();
            this.d = new ConcurrentHashMap();
            l r0 = new l("log4j2.system.properties", false);
            r0.a($$Lambda$PropertiesUtil$a$i81aDZcF8hnYBB37PCnarVvH1Yc.INSTANCE);     // Catch: SecurityException -> L6
        L4:
            this.f17913a.add(r5);
            Stream r6 = n.a(PropertySource.class, MethodHandles.lookup(), false, false);
            final Set<PropertySource> r1 = this.f17913a;
            r1.getClass();
            r6.forEach(new $$Lambda$DGBrN_eEu4qTbs1nFVOyMQnfNU(r1));
            a();
        }

        /* synthetic */ a(PropertySource r2, AnonymousClass1 r3) {
            this((PropertySource) ZeusTransformUtils.wrapperContextForParams(r2, PropertySource.class, "com.obric.memorydata.plugin"));
        }

        private String a(String r7) {
            if (this.c.containsKey(r7) == false) goto L9;
            Map<String, String> r6 = this.c;
        L5:
            String r8 = r6.get(r7);
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        L9:
            if (this.f17914b.containsKey(r7) == false) goto L11;
            r6 = this.f17914b;
            goto L5
        L11:
            List<CharSequence> r0 = PropertySource.a.a(r7);
            Iterator<PropertySource> r2 = this.f17913a.iterator();
        L13:
            if (r2.hasNext() == false) goto L24;
            PropertySource r3 = (PropertySource) ZeusTransformUtils.preCheckCast(r2.next(), PropertySource.class, "com.obric.memorydata.plugin");
            String r4 = Objects.toString(r3.a(r0), null);
            if (r4 == null) goto L21;
            if (r3.b(r4) == false) goto L21;
            return r3.a(r4);
        L21:
            if (r3.b(r7) == false) goto L13;
            return r3.a(r7);
        L24:
            r8 = this.d.get(r0);
            goto L7
        }

        static /* synthetic */ String a(a r0, String r1) {
            return r0.a(r1);
        }

        private static /* synthetic */ Collection a(Collection r2, Collection r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            r4.addAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
            return r4;
        }

        private synchronized void a() {
            monitor-enter(this);
            this.f17914b.clear();     // Catch: Throwable -> L6
            this.c.clear();     // Catch: Throwable -> L6
            this.d.clear();     // Catch: Throwable -> L6
            HashSet r0 = new HashSet();     // Catch: Throwable -> L6
            this.f17913a.stream().map($$Lambda$cjFd8ys5J3dIkk7KFmynxfz9Tc.INSTANCE).reduce(r0, $$Lambda$PropertiesUtil$a$gGKvxCFr9g3R58O_vDga_oaaWec.INSTANCE);     // Catch: Throwable -> L6
            r0.stream().filter($$Lambda$PropertiesUtil$a$RUgTMKBFSM5JmQYescT_4CThWo.INSTANCE).forEach(new $$Lambda$PropertiesUtil$a$RVnc5Dj1Mn1lBvvm8QOqKx6UHK8(this));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void a(String r1, String r2) {
            if (System.getProperty(r1) != null) goto L6;
            System.setProperty(r1, r2);
            return;
        }

        private /* synthetic */ void a(String r3, List r4, PropertySource r5) {
            List<CharSequence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            PropertySource r7 = (PropertySource) ZeusTransformUtils.wrapperContextForParams(r5, PropertySource.class, "com.obric.memorydata.plugin");
            String r0 = r7.a(r3);
            if (r0 == null) goto L7;
            this.f17914b.putIfAbsent(r3, r0);
            if (r6.isEmpty() == true) goto L7;
            this.d.putIfAbsent(r6, r0);
        L7:
            CharSequence r8 = r7.a(r6);
            if (r8 == null) goto L13;
            String r9 = r7.a(r8.toString());
            if (r9 == null) goto L14;
            this.c.putIfAbsent(r3, r9);
            return;
        L14:
            return;
        }

        private /* synthetic */ void b(final String r4) {
            final List<CharSequence> r0 = PropertySource.a.a(r4);
            this.f17913a.forEach(new $$Lambda$PropertiesUtil$a$BDhTmAldH62PRRvOILfHFw5u10(this, r4, r0));
        }

        /* JADX INFO: renamed from: lambda$BDhTmAldH62PRRvOILfHFw5u1-0, reason: not valid java name */
        public static /* synthetic */ void m3153lambda$BDhTmAldH62PRRvOILfHFw5u10(a r0, String r1, List r2, PropertySource r3) {
            r0.a(r1, r2, r3);
        }

        /* JADX INFO: renamed from: lambda$RUgTMKBFSM5JmQYe-scT_4CThWo, reason: not valid java name */
        public static /* synthetic */ boolean m3154lambda$RUgTMKBFSM5JmQYescT_4CThWo(Object r0) {
            return Objects.nonNull(r0);
        }

        public static /* synthetic */ void lambda$RVnc5Dj1Mn1lBvvm8QOqKx6UHK8(a r0, String r1) {
            r0.b(r1);
        }

        public static /* synthetic */ Collection lambda$gGKvxCFr9g3R58O_vDga_oaaWec(Collection r0, Collection r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ void lambda$i81aDZcF8hnYBB37PCnarVvH1Yc(String r0, String r1) {
            a(r0, r1);
        }
    }

    static {
        f17911a = new PropertiesUtil("log4j2.component.properties", false);
    }

    public PropertiesUtil(String r2) {
        this(r2, true);
    }

    private PropertiesUtil(String r2, boolean r3) {
        this(new l(r2, r3));
    }

    PropertiesUtil(PropertySource r3) {
        this.f17912b = new a((PropertySource) ZeusTransformUtils.wrapperContextForParams(r3, PropertySource.class, "com.obric.memorydata.plugin"), null);
    }

    static Properties a(InputStream r5, Object r6) {
        Properties r1 = new Properties();
        if (r5 != null) goto L24;
    L23:
        return r1;
    L24:
        r1.load(r5);     // Catch: Throwable -> L10 IOException -> L12
    L29:
        r5.close();     // Catch: IOException -> L7
    L7:
        e = e;
        StringBuilder r2 = new StringBuilder();
    L9:
        h.a(r2.append("Unable to close ").append(r6).toString(), e);
    L12:
        e = move-exception;
        h.a("Unable to read " + r6, e);     // Catch: Throwable -> L10
        r5.close();     // Catch: IOException -> L16
    L16:
        e = e;
        r2 = new StringBuilder();
    L10:
        th = move-exception;
        r5.close();     // Catch: IOException -> L20
    L22:
        throw th;
    L20:
        e = move-exception;
        h.a("Unable to close " + r6, e);
        goto L22
    }

    public static PropertiesUtil a() {
        return f17911a;
    }

    public int a(String r1, int r2) {
        String r0 = b(r1);
        if (r0 != null) goto L8;
    L6:
        return r2;
    L8:
        return Integer.parseInt(r0.trim());
    }

    public String a(String r1, String r2) {
        String r0 = b(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0;
    }

    public boolean a(String r2) {
        return a(r2, false);
    }

    public boolean a(String r1, boolean r2) {
        String r0 = b(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return "true".equalsIgnoreCase(r0);
    }

    public boolean a(String r1, boolean r2, boolean r3) {
        String r0 = b(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        if (r0.isEmpty() == false) goto L9;
        return r3;
    L9:
        return "true".equalsIgnoreCase(r0);
    }

    public String b(String r1) {
        return a.a(this.f17912b, r1);
    }
}
