package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class e extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f17921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f17922b = null;
    private final Collection<String> c;

    static {
        f17921a = new HashSet(Arrays.asList(new String[]{"java.math.BigDecimal", "java.math.BigInteger", "java.rmi.MarshalledObject", "[B"}));
        f17922b = new HashSet(Arrays.asList(new String[]{"java.lang.", "java.time.", "java.util.", "org.apache.logging.log4j.", "[Lorg.apache.logging.log4j."}));
    }

    public e() {
        this.c = Collections.emptySet();
    }

    public e(InputStream r3, Collection<String> r4) {
        Collection<String> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        super(r3);
        this.c = r5;
    }

    private static boolean a(String r1) {
        if (b(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (f17921a.contains(r1) == true) goto L8;
        return false;
    }

    private static boolean b(String r4) {
        Iterator<String> r0 = f17922b.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r4.startsWith((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public Collection<String> a() {
        return this.c;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass r3) {
        String r0 = r3.getName();
        if (a(r0) == true) goto L10;
        if (this.c.contains(r0) == true) goto L10;
        throw new InvalidObjectException("Class is not allowed for deserialization: " + r0);
    L10:
        return super.resolveClass(r3);
    }
}
