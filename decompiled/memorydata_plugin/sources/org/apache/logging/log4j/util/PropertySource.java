package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.spi.DefaultThreadContextMap;

/* JADX INFO: loaded from: classes6.dex */
public interface PropertySource {

    public static class Comparator implements Serializable, java.util.Comparator<PropertySource> {
        private static final long serialVersionUID = 1;

        public Comparator() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(PropertySource r3, PropertySource r4) {
            return compare2((PropertySource) ZeusTransformUtils.preCheckCast(r3, PropertySource.class, "com.obric.memorydata.plugin"), (PropertySource) ZeusTransformUtils.preCheckCast(r4, PropertySource.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(PropertySource r2, PropertySource r3) {
            PropertySource r1 = (PropertySource) ZeusTransformUtils.wrapperContextForParams(r2, PropertySource.class, "com.obric.memorydata.plugin");
            PropertySource r4 = (PropertySource) ZeusTransformUtils.wrapperContextForParams(r3, PropertySource.class, "com.obric.memorydata.plugin");
            return Integer.compare(((PropertySource) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r1), PropertySource.class, "com.obric.memorydata.plugin")).a(), ((PropertySource) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), PropertySource.class, "com.obric.memorydata.plugin")).a());
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Pattern f17915a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Pattern f17916b = null;
        private static final Map<CharSequence, List<CharSequence>> c = null;

        static {
            f17915a = Pattern.compile("(^log4j2?[-._/]?|^org\\.apache\\.logging\\.log4j\\.)|(?=AsyncLogger(Config)?\\.)", 2);
            f17916b = Pattern.compile("([A-Z]*[a-z0-9]+|[A-Z0-9]+)[-._/]?");
            ConcurrentHashMap r0 = new ConcurrentHashMap();
            c = r0;
            r0.put("disableThreadContext", Arrays.asList(new CharSequence[]{"disable", "thread", "context"}));
            r0.put("disableThreadContextStack", Arrays.asList(new CharSequence[]{"disable", "thread", "context", "stack"}));
            r0.put("disableThreadContextMap", Arrays.asList(new CharSequence[]{"disable", "thread", "context", "map"}));
            r0.put(DefaultThreadContextMap.INHERITABLE_MAP, Arrays.asList(new CharSequence[]{"is", "thread", "context", "map", "inheritable"}));
        }

        public static CharSequence a(Iterable<? extends CharSequence> r7) {
            Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder();
            Iterator r9 = r8.iterator();
            boolean r4 = true;
        L4:
            if (r9.hasNext() == false) goto L13;
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.next(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 == false) goto L8;
            r0.append(r5);
        L11:
            r4 = false;
            goto L4
        L8:
            r0.append(Character.toUpperCase(r5.charAt(0)));
            if (r5.length() <= 1) goto L11;
            r0.append(r5.subSequence(1, r5.length()));
            goto L11
        L13:
            return r0.toString();
        }

        public static List<CharSequence> a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Map<CharSequence, List<CharSequence>> r0 = c;
            if (r0.containsKey(r4) == true) goto L5;
            ArrayList r1 = new ArrayList();
            Matcher r2 = f17915a.matcher(r4);
            if (r2.find(0) == false) goto L12;
            int r5 = r2.end();
            Matcher r6 = f17916b.matcher(r4);
        L10:
            if (r6.find(r5) == false) goto L12;
            r1.add(r6.group(1).toLowerCase());
            r5 = r6.end();
        L12:
            c.put(r4, r1);
            return r1;
        L5:
            return (List) ZeusTransformUtils.preCheckCast(r0.get(r4), List.class, "com.obric.memorydata.plugin");
        }
    }

    int a();

    default CharSequence a(Iterable<? extends CharSequence> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return null;
    }

    default String a(String r1) {
        return null;
    }

    default Collection<String> b() {
        return Collections.emptySet();
    }

    default boolean b(String r1) {
        return false;
    }
}
