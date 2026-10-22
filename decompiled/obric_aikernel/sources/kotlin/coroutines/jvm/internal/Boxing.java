package kotlin.coroutines.jvm.internal;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "Boxing")
public final class Boxing {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Boolean boxBoolean(boolean r10) {
        return Boolean.valueOf(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Byte boxByte(byte r10) {
        return Byte.valueOf(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Character boxChar(char r10) {
        return new Character(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Double boxDouble(double r10) {
        return new Double(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Float boxFloat(float r10) {
        return new Float(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Integer boxInt(int r10) {
        return new Integer(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Long boxLong(long r10) {
        return new Long(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Short boxShort(short r10) {
        return new Short(r10);
    }
}
