package com.lynx.react.bridge.mapbuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface MapBuffer extends Iterable<a> {

    public static final enum DataType extends Enum<DataType> {
        public static final DataType ARRAY = null;
        public static final DataType BOOL = null;
        public static final DataType DOUBLE = null;
        public static final DataType INT = null;
        public static final DataType LONG = null;
        public static final DataType NULL = null;
        public static final DataType STRING = null;
        public static final /* synthetic */ DataType[] a = null;

        static {
            DataType r0 = new DataType("NULL", 0);
            NULL = r0;
            DataType r1 = new DataType("BOOL", 1);
            BOOL = r1;
            DataType r3 = new DataType("INT", 2);
            INT = r3;
            DataType r5 = new DataType("LONG", 3);
            LONG = r5;
            DataType r7 = new DataType("DOUBLE", 4);
            DOUBLE = r7;
            DataType r9 = new DataType("STRING", 5);
            STRING = r9;
            DataType r11 = new DataType("ARRAY", 6);
            ARRAY = r11;
            a = new DataType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static DataType[] values() {
            return (DataType[]) a.clone();
        }

        public static DataType valueOf(String r1) {
            return (DataType) r27.a.a(DataType.class, r1);
        }

        public DataType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a extends com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a {
        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        double b();

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        long c();

        boolean e();

        ReadableMapBuffer f();

        int getKey();

        DataType getType();
    }

    ReadableMapBuffer b(int r1);

    boolean contains(int r1);

    int count();

    boolean getBoolean(int r1);

    double getDouble(int r1);

    int getInt(int r1);

    long getLong(int r1);

    String getString(int r1);

    DataType getType(int r1);
}
