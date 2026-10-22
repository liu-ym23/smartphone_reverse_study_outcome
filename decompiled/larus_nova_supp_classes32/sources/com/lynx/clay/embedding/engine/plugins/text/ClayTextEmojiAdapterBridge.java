package com.lynx.clay.embedding.engine.plugins.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ClayTextEmojiAdapterBridge {
    private static final String TAG = "ClayTextEmojiAdapter";
    private static final WeakHashMap<Context, WeakReference<Object>> sAdapters = null;
    private static final Map<Long, WeakReference<Context>> sContexts = null;
    private static EmojiAdapterProvider sEmojiAdapterProvider;
    private static EmojiAdapterProviderLoader sEmojiAdapterProviderLoader;
    private static boolean sNativeClassRegistered;

    public interface EmojiAdapterProvider {
        Object createAdapter(Context r1);

        Drawable getRealDrawable(Object r1, Context r2, String r3);

        boolean isValidEmojiText(Object r1, String r2);
    }

    public interface EmojiAdapterProviderLoader {
        EmojiAdapterProvider createProvider();
    }

    public static final class ResolvedEmoji {
        public final int height;
        public final float layoutHeight;
        public final float layoutWidth;
        public final byte[] pixels;
        public final int rowBytes;
        public final int width;

        public ResolvedEmoji(int r1, int r2, int r3, float r4, float r5, byte[] r6) {
            this.width = r1;
            this.height = r2;
            this.rowBytes = r3;
            this.layoutWidth = r4;
            this.layoutHeight = r5;
            this.pixels = r6;
        }
    }

    private ClayTextEmojiAdapterBridge() {
    }

    private static native void nativeRegisterBridgeClass(Class<?> r0);

    static {
        sContexts = new HashMap();
        sAdapters = new WeakHashMap();
        sNativeClassRegistered = false;
        sEmojiAdapterProvider = null;
        sEmojiAdapterProviderLoader = null;
    }

    public static synchronized void ensureNativeRegistered() {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sNativeClassRegistered == false) goto L16;
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L16:
        nativeRegisterBridgeClass(ClayTextEmojiAdapterBridge.class);     // Catch: Throwable -> L10
        sNativeClassRegistered = true;     // Catch: Throwable -> L10
    L11:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L10:
        goto L11
    }

    private static synchronized EmojiAdapterProvider getEmojiAdapterProvider() {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sEmojiAdapterProvider != null) goto L11;
        EmojiAdapterProviderLoader r1 = sEmojiAdapterProviderLoader;     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        sEmojiAdapterProvider = r1.createProvider();     // Catch: Throwable -> L10
    L10:
        sEmojiAdapterProviderLoader = null;     // Catch: Throwable -> L14
    L11:
        EmojiAdapterProvider r2 = sEmojiAdapterProvider;     // Catch: Throwable -> L14
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r2;
    }

    private static synchronized Context getContext(long r3) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        Map<Long, WeakReference<Context>> r1 = sContexts;     // Catch: Throwable -> L12
        WeakReference<Context> r2 = r1.get(Long.valueOf(r3));     // Catch: Throwable -> L12
        if (r2 == null) goto L7;
        Context r4 = r2.get();     // Catch: Throwable -> L12
    L8:
        if (r4 != null) goto L10;
        r1.remove(Long.valueOf(r3));     // Catch: Throwable -> L12
    L10:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r4;
    L7:
        r4 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void unregister(long r2) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        WeakReference<Context> r3 = sContexts.remove(Long.valueOf(r2));     // Catch: Throwable -> L12
        if (r3 == null) goto L7;
        Context r4 = r3.get();     // Catch: Throwable -> L12
    L8:
        if (r4 == null) goto L10;
        sAdapters.remove(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L7:
        r4 = null;
    L12:
        th = move-exception;
        throw th;
    }

    private static synchronized Object getAdapter(Context r4, EmojiAdapterProvider r5) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        WeakHashMap<Context, WeakReference<Object>> r1 = sAdapters;     // Catch: Throwable -> L20
        WeakReference<Object> r2 = r1.get(r4);     // Catch: Throwable -> L20
        if (r2 == null) goto L8;
        Object r3 = r2.get();     // Catch: Throwable -> L20
    L9:
        if (r3 == null) goto L24;
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r3;
    L24:
        Object r6 = r5.createAdapter(r4);     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        r1.put(r4, new WeakReference(r6));     // Catch: Throwable -> L20
    L15:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r6;
    L17:
        sAdapters.remove(r4);     // Catch: Throwable -> L20
        return null;
    L8:
        r3 = null;
    L20:
        th = move-exception;
        throw th;
    }

    private static int premultiply(int r0, int r1) {
        return ((r0 * r1) + 127) / 255;
    }

    private static ResolvedEmoji rasterize(Drawable r19, float r20) {
        int r1 = r19.getIntrinsicWidth();
        int r2 = r19.getIntrinsicHeight();
        if (r20 <= 0.0f) goto L5;
        float r9 = r20;
    L6:
        if (r1 <= 0) goto L9;
        if (r2 <= 0) goto L9;
        float r8 = (r1 * r9) / r2;
    L10:
        int r5 = Math.max(1, Math.round(r8));
        int r6 = Math.max(1, Math.round(r9));
        Rect r3 = r19.copyBounds();
        Bitmap r4 = Bitmap.createBitmap(r5, r6, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L19
        Canvas r7 = new Canvas(r4);     // Catch: Throwable -> L18
        int r10 = 0;
        r19.setBounds(0, 0, r5, r6);     // Catch: Throwable -> L18
        r19.draw(r7);     // Catch: Throwable -> L18
        int r11 = r5 * r6;     // Catch: Throwable -> L18
        int[] r15 = new int[r11];     // Catch: Throwable -> L18
        r4.getPixels(r15, 0, r5, 0, 0, r5, r6);     // Catch: Throwable -> L18
        byte[] r12 = new byte[r11 * 4];     // Catch: Throwable -> L18
    L13:
        if (r10 >= r11) goto L15;
        int r13 = r15[r10];     // Catch: Throwable -> L18
        int r14 = (r13 >>> 24) & 255;     // Catch: Throwable -> L18
        int r16 = r10 * 4;     // Catch: Throwable -> L18
        r12[r16] = (byte) premultiply((r13 >>> 16) & 255, r14);     // Catch: Throwable -> L18
        r12[r16 + 1] = (byte) premultiply((r13 >>> 8) & 255, r14);     // Catch: Throwable -> L18
        r12[r16 + 2] = (byte) premultiply(r13 & 255, r14);     // Catch: Throwable -> L18
        r12[r16 + 3] = (byte) r14;     // Catch: Throwable -> L18
        r10 = r10 + 1;     // Catch: Throwable -> L18
        goto L13
    L15:
        ResolvedEmoji r17 = new ResolvedEmoji(r5, r6, r5 * 4, r8, r9, r12);     // Catch: Throwable -> L18
        r19.setBounds(r3);
        r4.recycle();
        return r17;
    L20:
        r19.setBounds(r3);
        if (r4 == null) goto L23;
        r4.recycle();
    L23:
        return null;
    L19:
        r4 = null;
    L9:
        r8 = r9;
        goto L10
    L5:
        r9 = 14.0f;
        goto L6
    }

    public static synchronized void register(long r4, Context r6, EmojiAdapterProviderLoader r7) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        if (r4 == 0) goto L17;
        if (r6 == null) goto L17;
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sEmojiAdapterProviderLoader == r7) goto L11;
        sEmojiAdapterProviderLoader = r7;     // Catch: Throwable -> L14
        sEmojiAdapterProvider = null;     // Catch: Throwable -> L14
        sAdapters.clear();     // Catch: Throwable -> L14
    L11:
        sContexts.put(Long.valueOf(r4), new WeakReference(r6));     // Catch: Throwable -> L14
        sAdapters.remove(r6);     // Catch: Throwable -> L14
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L17:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
    }

    public static ResolvedEmoji resolve(long r3, String r5, float r6) {
        Context r4 = getContext(r3);
        if (r4 == null) goto L40;
        if (r5 == null) goto L40;
        if (r5.length() == 0) goto L40;
        EmojiAdapterProvider r0 = getEmojiAdapterProvider();
        if (r0 != null) goto L11;
        return null;
    L11:
        Object r1 = getAdapter(r4, r0);
        if (r1 != null) goto L41;
        return null;
    L41:
        if (r0.isValidEmojiText(r1, r5) == true) goto L43;
        return null;
    L43:
        Drawable r7 = r0.getRealDrawable(r1, r4, r5);     // Catch: Throwable -> L22
        if (r7 != null) goto L21;
        return null;
    L21:
        return rasterize(r7, r6);
    L23:
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        sAdapters.remove(r4);     // Catch: Throwable -> L28
        return null;
    L28:
        th = move-exception;
        throw th;
    L32:
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        sAdapters.remove(r4);     // Catch: Throwable -> L37
        return null;
    L37:
        th = move-exception;
        throw th;
    L40:
        return null;
    }
}
