package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaXLog;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BitmapBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f9598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HardwareBuffer f9599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f9600c;

    public static final enum BufferState extends Enum<BufferState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BufferState f9601a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final BufferState f9602b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final BufferState f9603c = null;
        public static final /* synthetic */ BufferState[] d = null;

        static {
            BufferState r5 = new BufferState("NotReady", 0);
            f9601a = r5;
            BufferState r10 = new BufferState("Ready", 1);
            f9602b = r10;
            BufferState r11 = new BufferState("Destroyed", 2);
            f9603c = r11;
            d = new BufferState[]{r5, r10, r11};
        }

        public BufferState(String r5, int r10) {
            super(r5, r10);
        }

        public static BufferState valueOf(String r5) {
            return (BufferState) Enum.valueOf(BufferState.class, r5);
        }

        public static BufferState[] values() {
            return (BufferState[]) d.clone();
        }
    }

    public BitmapBuffer(Bitmap r5, HardwareBuffer r10) {
        this.f9600c = new AtomicReference(BufferState.f9601a);
        this.f9598a = r5;
        this.f9599b = r10;
    }

    public static BitmapBuffer a(int r10, int r11, boolean r12) {
        Bitmap r5 = null;
        if (r10 <= 0) goto L15;
        if (r11 <= 0) goto L15;
        if (r12 == false) goto L9;
        long r13 = 304;
    L25:
        HardwareBuffer r14 = HardwareBuffer.create(r10, r11, 1, 1, r13);     // Catch: Exception -> L13
    L16:
        if (r14 != null) goto L27;
    L21:
        if (r5 != null) goto L24;
        r5 = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
    L24:
        return new BitmapBuffer(r5, r14);
    L27:
        r5 = Bitmap.wrapHardwareBuffer(r14, ColorSpace.get(ColorSpace.Named.SRGB));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "BitmapBuffer", a.o(e, new StringBuilder("Failed to wrap HardwareBuffer: ")));
        r14.close();
        r14 = null;
    L13:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "BitmapBuffer", a.o(e, new StringBuilder("Failed to create HardwareBuffer: ")));
        goto L15
    L9:
        r13 = 768;
    L15:
        r14 = null;
        goto L16
    }

    public final void b() {
        AtomicReference r5 = this.f9600c;
        BufferState r10 = BufferState.f9603c;
        if (r5.getAndSet(r10) == r10) goto L13;
        Bitmap r11 = this.f9598a;
        if (r11.isRecycled() == true) goto L8;
        r11.recycle();
    L8:
        HardwareBuffer r12 = this.f9599b;
        if (r12 == null) goto L12;
        r12.close();
        return;
    L12:
        return;
    }

    @Nullable
    @CalledByNative
    public Bitmap getBitmap() {
        if (this.f9600c.get() != BufferState.f9603c) goto L7;
        return null;
    L7:
        return this.f9598a;
    }

    @Nullable
    @CalledByNative
    public HardwareBuffer getHardwareBuffer() {
        if (this.f9600c.get() != BufferState.f9603c) goto L7;
        return null;
    L7:
        return this.f9599b;
    }

    @CalledByNative
    public void setState(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= BufferState.values().length) goto L9;
        this.f9600c.set(BufferState.values()[r5]);
        return;
    }
}
