package qm;

import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.MapBuffer$DataType;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ReadableArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMapBuffer f21532a;

    public f(ReadableMapBuffer r5) {
        this.f21532a = r5;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList asArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableArray getArray(int r10) {
        MapBuffer$DataType r5 = MapBuffer$DataType.f;
        ReadableMapBuffer r11 = this.f21532a;
        int r12 = r11.d(r10, r5);
        ByteBuffer r13 = r11.f21527a;
        int r14 = r13.getInt(r12) + r11.d;
        int r15 = r13.getInt(r14);
        byte[] r16 = new byte[r15];
        r13.position(r14 + 4);
        r13.get(r16, 0, r15);
        return new f(new ReadableMapBuffer(ByteBuffer.wrap(r16), -1, 4));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean getBoolean(int r5) {
        MapBuffer$DataType r10 = MapBuffer$DataType.f9948a;
        ReadableMapBuffer r11 = this.f21532a;
        int r12 = r11.d(r5, r10);
        if (r11.f21527a.getInt(r12) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte getByte(int r5) {
        return (byte) getInt(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte[] getByteArray(int r5) {
        return new byte[0];
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final char getChar(int r5) {
        return 0;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final double getDouble(int r5) {
        MapBuffer$DataType r10 = MapBuffer$DataType.d;
        ReadableMapBuffer r11 = this.f21532a;
        int r12 = r11.d(r5, r10);
        return r11.f21527a.getDouble(r12);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final pm.a getDynamic(int r5) {
        return new a(this, r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final int getInt(int r5) {
        MapBuffer$DataType r10 = MapBuffer$DataType.f9949b;
        ReadableMapBuffer r11 = this.f21532a;
        int r12 = r11.d(r5, r10);
        return r11.f21527a.getInt(r12);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final long getLong(int r5) {
        MapBuffer$DataType r10 = MapBuffer$DataType.f9950c;
        ReadableMapBuffer r11 = this.f21532a;
        int r12 = r11.d(r5, r10);
        return r11.f21527a.getLong(r12);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableMap getMap(int r5) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final PiperData getPiperData(int r5) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final short getShort(int r5) {
        return (short) getInt(r5);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final String getString(int r5) {
        MapBuffer$DataType r10 = MapBuffer$DataType.e;
        ReadableMapBuffer r11 = this.f21532a;
        return r11.c(r11.d(r5, r10));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableType getType(int r5) {
        ReadableMapBuffer r10 = this.f21532a;
        int r11 = (r10.e(r5) * 12) + 10;
        short r12 = r10.f21527a.getShort(r11);
        switch(MapBuffer$DataType.values()[r12].ordinal()) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return ReadableType.Null;
    L7:
        return ReadableType.Array;
    L9:
        return ReadableType.String;
    L11:
        return ReadableType.Number;
    L13:
        return ReadableType.Long;
    L15:
        return ReadableType.Int;
    L17:
        return ReadableType.Boolean;
    L19:
        return ReadableType.Null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean isNull(int r5) {
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableArray, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f21532a.f21528b;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList toArrayList() {
        return null;
    }
}
