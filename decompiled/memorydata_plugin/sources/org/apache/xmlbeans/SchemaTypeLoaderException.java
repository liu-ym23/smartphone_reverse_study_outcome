package org.apache.xmlbeans;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaTypeLoaderException extends XmlRuntimeException {
    public static final int BAD_HANDLE = 13;
    public static final int BAD_PARTICLE_TYPE = 11;
    public static final int INT_TOO_LARGE = 10;
    public static final int IO_EXCEPTION = 9;
    public static final int MALFORMED_CONTENT_MODEL = 7;
    public static final int NESTED_EXCEPTION = 14;
    public static final int NOT_WRITEABLE = 12;
    public static final int NO_RESOURCE = 0;
    public static final int UNRECOGNIZED_INDEX_ENTRY = 5;
    public static final int WRONG_FILE_TYPE = 4;
    public static final int WRONG_MAGIC_COOKIE = 1;
    public static final int WRONG_MAJOR_VERSION = 2;
    public static final int WRONG_MINOR_VERSION = 3;
    public static final int WRONG_PROPERTY_TYPE = 6;
    public static final int WRONG_SIMPLE_VARIETY = 8;
    private int _code;

    public SchemaTypeLoaderException(String r2, String r3, String r4, int r5) {
        super(r2 + " (" + r3 + "." + r4 + ") - code " + r5);
        this._code = r5;
    }

    public SchemaTypeLoaderException(String r2, String r3, String r4, int r5, Exception r6) {
        super(r2 + " (" + r3 + "." + r4 + ") - code " + r5);
        this._code = r5;
        initCause(r6);
    }

    public int getCode() {
        return this._code;
    }
}
