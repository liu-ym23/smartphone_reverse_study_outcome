package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class POIFSDocumentPath {
    private static final c LOGGER = null;
    private final String[] components;
    private int hashcode;

    static {
        LOGGER = b.a(POIFSDocumentPath.class);
    }

    public POIFSDocumentPath() {
        this.components = new String[0];
    }

    public POIFSDocumentPath(POIFSDocumentPath r3, String[] r4) {
        if (r3 != null) goto L5;
        String[] r1 = new String[0];
    L6:
        if (r4 != null) goto L8;
        r4 = new String[0];
    L8:
        if (r3 == null) goto L10;
        Predicate r5 = $$Lambda$POIFSDocumentPath$Z5V9tkDhT_JfDb2WK8Naet8Zk2Y.INSTANCE;
    L12:
        if (Stream.of(r4).anyMatch(r5) == true) goto L16;
        this.components = (String[]) ZeusTransformUtils.preCheckCast(Stream.concat(Stream.of(r1), Stream.of(r4)).toArray($$Lambda$POIFSDocumentPath$bocPEvc07ZujBxs3dS8LdIvAgQ.INSTANCE), String[].class, "com.obric.memorydata.plugin");
        return;
    L16:
        throw new IllegalArgumentException("components cannot contain null or empty strings");
    L10:
        r5 = $$Lambda$POIFSDocumentPath$oNB9raGDPJ9IKUXPUFqEccfZQyQ.INSTANCE;
        goto L12
    L5:
        r1 = r3.components;
        goto L6
    }

    public POIFSDocumentPath(String[] r2) {
        this(null, r2);
    }

    public static /* synthetic */ boolean lambda$Z5V9tkDhT_JfDb2WK8Naet8Zk2Y(Object r0) {
        return Objects.isNull(r0);
    }

    static /* synthetic */ boolean lambda$new$0(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    static /* synthetic */ String[] lambda$new$1(int r0) {
        return new String[r0];
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.getClass() != getClass()) goto L12;
        POIFSDocumentPath r4 = (POIFSDocumentPath) ZeusTransformUtils.preCheckCast(r3, POIFSDocumentPath.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this.components, r4.components);
    L12:
        return false;
    }

    public String getComponent(int r1) {
        return this.components[r1];
    }

    public int hashCode() {
        int r0 = this.hashcode;
        if (r0 != 0) goto L6;
        int r1 = Arrays.hashCode(this.components);
        this.hashcode = r1;
        return r1;
    L6:
        return r0;
    }

    public int length() {
        return this.components.length;
    }

    public String toString() {
        return File.separatorChar + String.join(String.valueOf(File.separatorChar), this.components);
    }
}
