package pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Handler f10092m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f10093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10094b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f10095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GifDrawable f10096b;

        public a(GifDrawable r8, int r10) {
            this.f10096b = r8;
            this.f10095a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler r8 = GifDrawable.f10092m;
            GifDrawable r10 = this.f10096b;
            r10.getClass();
            GifDrawable.a(this.f10095a);
            r10.invalidateSelf();
        }
    }

    static {
        System.loadLibrary("gif");     // Catch: Throwable -> L5
    L3:
        f10092m = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void a(int r8) {
        seekToTime(0, r8, null);
    }

    public static void b(a r8) {
        Looper r10 = Looper.myLooper();
        Handler r11 = f10092m;
        if (r10 != r11.getLooper()) goto L5;
        r8.run();
        return;
    L5:
        r11.post(r8);
    }

    private static native void free(int r8);

    private static native long getAllocationByteCount(int r8);

    private static native String getComment(int r8);

    private static native int getCurrentIndex(int r8);

    private static native int getCurrentPosition(int r8);

    private static native int getDuration(int r8);

    private static native int getLoopCount(int r8);

    private static native int openByteArray(int[] r8, byte[] r10);

    private static native int openDirectByteBuffer(int[] r8, ByteBuffer r10);

    private static native int openFd(int[] r8, FileDescriptor r10, long r11);

    private static native int openFile(int[] r8, String r10);

    private static native int openStream(int[] r8, InputStream r10);

    private static native void renderFrame(int[] r8, int r10, int[] r11);

    private static native void reset(int r8);

    private static native int restoreRemainder(int r8);

    private static native int saveRemainder(int r8);

    private static native int seekToFrame(int r8, int r10, int[] r11);

    private static native int seekToTime(int r8, int r10, int[] r11);

    private static native void setSpeedFactor(int r8, float r10);

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
    L7:
        return;
    L3:
        if (this.f10094b == false) goto L6;
        getBounds();     // Catch: Throwable -> L7
        throw null;     // Catch: Throwable -> L7
    L6:
        throw null;     // Catch: Throwable -> L7
    }

    public final void finalize() {
        this.f10093a = false;     // Catch: Throwable -> L6
        free(0);     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        throw null;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return getCurrentPosition(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return getDuration(0);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.f10093a;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f10093a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        super.onBoundsChange(r8);
        this.f10094b = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int r8) {
        if (r8 < 0) goto L6;
        b(new a(this, r8));
        return;
    L6:
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r8) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r8) {
        throw null;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        this.f10093a = true;
        b(null);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f10093a = false;
        b(null);
    }

    public final String toString() {
        Locale r8 = Locale.US;
        throw null;
    }
}
