package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements ReadableArray {
    public final MapBuffer a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MapBuffer.DataType.values().length];
            a = r0;
            r0[MapBuffer.DataType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[MapBuffer.DataType.DOUBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[MapBuffer.DataType.ARRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[MapBuffer.DataType.NULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[MapBuffer.DataType.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[MapBuffer.DataType.INT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[MapBuffer.DataType.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList<Object> asArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte[] getByteArray(int r1) {
        return new byte[0];
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final char getChar(int r1) {
        return 0;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableMap getMap(int r1) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final PiperData getPiperData(int r1) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean isNull(int r1) {
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList<Object> toArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.count();
    }

    public e(MapBuffer r1) {
        this.a = r1;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableArray getArray(int r3) {
        return new e(this.a.b(r3));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean getBoolean(int r2) {
        return this.a.getBoolean(r2);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte getByte(int r1) {
        return (byte) getInt(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final double getDouble(int r3) {
        return this.a.getDouble(r3);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final f6a.a getDynamic(int r2) {
        return new g6a.a(this, r2);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final int getInt(int r2) {
        return this.a.getInt(r2);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final long getLong(int r3) {
        return this.a.getLong(r3);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final short getShort(int r1) {
        return (short) getInt(r1);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final String getString(int r2) {
        return this.a.getString(r2);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableType getType(int r2) {
        MapBuffer.DataType r3 = this.a.getType(r2);
        switch(a.a[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return ReadableType.Null;
    L14:
        return ReadableType.Boolean;
    L15:
        return ReadableType.Int;
    L16:
        return ReadableType.Long;
    L17:
        return ReadableType.Null;
    L18:
        return ReadableType.Array;
    L19:
        return ReadableType.Number;
    L12:
        return ReadableType.String;
    }
}
