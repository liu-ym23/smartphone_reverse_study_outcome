package org.bouncycastle.jcajce.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class AnnotatedPrivateKey implements PrivateKey {
    public static final String LABEL = "label";
    private final Map<String, Object> annotations;
    private final PrivateKey key;

    AnnotatedPrivateKey(PrivateKey r3, String r4) {
        this.key = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin");
        this.annotations = Collections.singletonMap(LABEL, r4);
    }

    AnnotatedPrivateKey(PrivateKey r3, Map<String, Object> r4) {
        PrivateKey r5 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin");
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.key = r5;
        this.annotations = r6;
    }

    public AnnotatedPrivateKey addAnnotation(String r3, Object r4) {
        HashMap r0 = new HashMap(this.annotations);
        r0.put(r3, r4);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(r0));
    }

    public boolean equals(Object r3) {
        boolean r1 = ZeusTransformUtils.instanceOf(r3, AnnotatedPrivateKey.class);
        PrivateKey r2 = this.key;
        if (r1 == false) goto L7;
        return r2.equals(((AnnotatedPrivateKey) ZeusTransformUtils.preCheckCast(r3, AnnotatedPrivateKey.class, "com.obric.memorydata.plugin")).key);
    L7:
        return r2.equals(r3);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    public Object getAnnotation(String r1) {
        return this.annotations.get(r1);
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.key.getFormat();
    }

    public PrivateKey getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public AnnotatedPrivateKey removeAnnotation(String r3) {
        HashMap r0 = new HashMap(this.annotations);
        r0.remove(r3);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(r0));
    }

    public String toString() {
        if (this.annotations.containsKey(LABEL) == false) goto L7;
        Object r2 = this.annotations.get(LABEL);
    L6:
        return r2.toString();
    L7:
        r2 = this.key;
        goto L6
    }
}
