package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161219;
    private final transient ZipArchiveEntry entry;
    private final Feature reason;

    public static class Feature implements Serializable {
        public static final Feature DATA_DESCRIPTOR = null;
        public static final Feature ENCRYPTION = null;
        public static final Feature METHOD = null;
        public static final Feature SPLITTING = null;
        public static final Feature UNKNOWN_COMPRESSED_SIZE = null;
        private static final long serialVersionUID = 4112582948775420359L;
        private final String name;

        static {
            ENCRYPTION = new Feature("encryption");
            METHOD = new Feature("compression method");
            DATA_DESCRIPTOR = new Feature("data descriptor");
            SPLITTING = new Feature("splitting");
            UNKNOWN_COMPRESSED_SIZE = new Feature("unknown compressed size");
        }

        private Feature(String r1) {
            this.name = r1;
        }

        public String toString() {
            return this.name;
        }
    }

    public UnsupportedZipFeatureException(Feature r3) {
        super("Unsupported feature " + r3 + " used in archive.");
        this.reason = r3;
        this.entry = null;
    }

    public UnsupportedZipFeatureException(Feature r3, ZipArchiveEntry r4) {
        super("Unsupported feature " + r3 + " used in entry " + r4.getName());
        this.reason = r3;
        this.entry = r4;
    }

    public UnsupportedZipFeatureException(ZipMethod r3, ZipArchiveEntry r4) {
        super("Unsupported compression method " + r4.getMethod() + " (" + r3.name() + ") used in entry " + r4.getName());
        this.reason = Feature.METHOD;
        this.entry = r4;
    }

    public ZipArchiveEntry getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }
}
