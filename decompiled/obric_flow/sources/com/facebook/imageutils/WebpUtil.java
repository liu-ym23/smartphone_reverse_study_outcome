package com.facebook.imageutils;

import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebpUtil {
    public static Pair a(InputStream r5) {
        r5.skip(7);
        short r10 = (short) (r5.read() & 255);
        short r11 = (short) (r5.read() & 255);
        short r12 = (short) (r5.read() & 255);
        if (r10 == 157) goto L5;
        return null;
    L5:
        if (r11 == 1) goto L7;
        return null;
    L7:
        if (r12 != 42) goto L14;
        byte r13 = (byte) r5.read();
        int r14 = (((byte) r5.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        Integer r15 = Integer.valueOf((r13 & UByte.MAX_VALUE) | r14);
        byte r16 = (byte) r5.read();
        return new Pair(r15, Integer.valueOf(((((byte) r5.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (r16 & UByte.MAX_VALUE)));
    L14:
        return null;
    }

    public static Pair b(InputStream r5) {
        r5.read();
        r5.read();
        r5.read();
        r5.read();
        if (((byte) (r5.read() & 255)) == 47) goto L6;
        return null;
    L6:
        int r10 = ((byte) r5.read()) & UByte.MAX_VALUE;
        byte r11 = (byte) r5.read();
        int r12 = ((byte) r5.read()) & UByte.MAX_VALUE;
        int r13 = (r10 | ((r11 & 63) << 8)) + 1;
        int r14 = ((((((byte) r5.read()) & 15) << 10) | (r12 << 2)) | ((r11 & 192) >> 6)) + 1;
        return new Pair(Integer.valueOf(r13), Integer.valueOf(r14));
    }

    public static int c(InputStream r5) {
        byte r10 = (byte) (r5.read() & 255);
        byte r11 = (byte) (r5.read() & 255);
        return (((((byte) (r5.read() & 255)) << 16) & 16711680) | ((r11 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (r10 & UByte.MAX_VALUE);
    }
}
