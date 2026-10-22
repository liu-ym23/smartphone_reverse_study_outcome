package com.obric.aiagent.messenger;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Base64;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentScreenshotCacheUtils {
    public static final AppIntentScreenshotCacheUtils a = null;
    public static final Object b = null;
    public static final CoroutineScope c = null;
    public static final SecureRandom d = null;
    public static final int e = 0;
    public static final long f = 0;
    public static final boolean g = false;
    public static final AppIntentScreenshotCacheUtils$cache$1 h = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$ScreenshotSource;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NONE", "HEIF", "BITMAP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenshotSource extends Enum<ScreenshotSource> {
        public static final ScreenshotSource BITMAP = null;
        public static final ScreenshotSource HEIF = null;
        public static final ScreenshotSource NONE = null;
        public static final /* synthetic */ ScreenshotSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScreenshotSource> getEntries() {
            return b;
        }

        static {
            ScreenshotSource r0 = new ScreenshotSource("NONE", 0);
            NONE = r0;
            ScreenshotSource r1 = new ScreenshotSource("HEIF", 1);
            HEIF = r1;
            ScreenshotSource r3 = new ScreenshotSource("BITMAP", 2);
            BITMAP = r3;
            ScreenshotSource[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ScreenshotSource[] values() {
            return (ScreenshotSource[]) a.clone();
        }

        public static ScreenshotSource valueOf(String r1) {
            return (ScreenshotSource) r27.a.a(ScreenshotSource.class, r1);
        }

        public ScreenshotSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "EncryptResult(data=" + this.a + ", isPrivacy=" + this.b + ')';
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final ScreenshotSource c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return ((r2 + r3) * 31) + this.c.hashCode();
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "EncryptResultWithSource(data=" + this.a + ", isPrivacy=" + this.b + ", source=" + this.c + ')';
        }

        public b(String r2, boolean r3, ScreenshotSource r4) {
            Intrinsics.checkNotNullParameter(r4, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final Bitmap a;
        public final String b;
        public final CompletableDeferred<a> c;
        public final boolean d;
        public long e;

        public c() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Bitmap r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            CompletableDeferred<a> r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (r6 + r1) * 31;
            if (this.d == false) goto L17;
            int r9 = 1231;
        L18:
            int r10 = (r8 + r9) * 31;
            long r11 = this.e;
            return r10 + ((int) (r11 ^ (r11 >>> 32)));
        L17:
            r9 = 1237;
            goto L18
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(bitmap=" + this.a + ", encryptedData=" + this.b + ", pendingEncryptData=" + this.c + ", isPrivacy=" + this.d + ", lastAccessUptimeMs=" + this.e + ')';
        }

        public final boolean a() {
            Bitmap r0 = this.a;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            return true;
        L10:
            if (this.a != null) goto L22;
            String r2 = this.b;
            if (r2 != null) goto L14;
        L17:
            boolean r3 = true;
        L18:
            if (r3 == false) goto L22;
            if (this.c != null) goto L22;
            return true;
        L14:
            if (r2.length() == 0) goto L17;
            r3 = false;
        L22:
            return false;
        L5:
            if (r0.isRecycled() != true) goto L7;
            r1 = true;
            goto L8
        }

        public c(Bitmap r3, String r4, CompletableDeferred r5, boolean r6, long r7, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r9 & 8) == 0) goto L14;
            r6 = false;
        L14:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public AppIntentScreenshotCacheUtils() {
    }

    static {
        a = new AppIntentScreenshotCacheUtils();
        b = new Object();
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        d = new SecureRandom();
        t1 r0 = t1.a;
        int r1 = r0.getObricAppIntentScreenshotCacheConfig().getMaxSize();
        e = r1;
        f = r0.getObricAppIntentScreenshotCacheConfig().getTtlMs();
        g = r0.getObricAppIntentScreenshotCacheConfig().getEnableAppendScreenshotNoise();
        h = new AppIntentScreenshotCacheUtils$cache$1(r1);
    }

    public static int e() {
        IObricPccService r0 = (IObricPccService) ServiceManager.get().getService(IObricPccService.class);
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.c();
    }

    public static void f() {
        long r0 = SystemClock.uptimeMillis();
        Iterator<Map.Entry<String, c>> r2 = h.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        c r3 = r2.next().getValue();
        boolean r8 = false;
        if ((r0 - r3.e) <= f) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        if (r3.a() == false) goto L4;
    L12:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("purgeExpiredLocked, ");
        r6.append(r4);
        r6.append(", ");
        Bitmap r7 = r3.a;
        if (r7 != null) goto L15;
    L17:
        r6.append(r8);
        r5.i("AppIntentScreenshotCacheUtils", r6.toString());
        r2.remove();
        goto L4
    L15:
        if (r7.isRecycled() != true) goto L17;
        r8 = true;
        goto L17
    L8:
        r4 = false;
        goto L9
    }

    public static c d(String r6) {
        Object r1 = b;
        monitor-enter(r1);
        a.getClass();     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        AppIntentScreenshotCacheUtils$cache$1 r2 = h;     // Catch: Throwable -> L14
        c r3 = (c) r2.get(r6);     // Catch: Throwable -> L14
        if (r3 != null) goto L8;
    L10:
        r3 = null;
    L12:
        monitor-exit(r1);
        return r3;
    L8:
        if (r3.a() == false) goto L11;
        r2.remove(r6);     // Catch: Throwable -> L14
        FLogger.a.w("AppIntentScreenshotCacheUtils", "getEntry, entry is invalid, messageId=" + r6);     // Catch: Throwable -> L14
        goto L10
    L11:
        r3.e = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static final byte[] a(AppIntentScreenshotCacheUtils r3, ParcelFileDescriptor r4) {
        r3.getClass();
        ParcelFileDescriptor.AutoCloseInputStream r5 = new ParcelFileDescriptor.AutoCloseInputStream(r4);
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default(r5, r6, 0, 2, null);     // Catch: Throwable -> L9
        byte[] r0 = r6.toByteArray();     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);
        return r0;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static Pair c(String r2, String r3) {
        if (r2 == null) goto L9;
        a.getClass();
        c r1 = d(r2);
        if (r1 == null) goto L7;
        Pair r4 = TuplesKt.to(r2, r1);
    L8:
        if (r4 == null) goto L9;
    L14:
        return r4;
    L7:
        r4 = null;
    L9:
        if (r3 == null) goto L15;
        a.getClass();
        c r5 = d(r3);
        if (r5 == null) goto L16;
        r4 = TuplesKt.to(r3, r5);
        goto L14
    L16:
        return null;
    L15:
        return null;
    }

    public static void g(String r11, Bitmap r12) {
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        Object r2 = b;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r12.isRecycled() == false) goto L9;
        FLogger.a.w("AppIntentScreenshotCacheUtils", "put, bitmap is recycled, messageId=".concat(r11));     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L9:
        a.getClass();     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        FLogger.a.i("AppIntentScreenshotCacheUtils", "put, messageId=".concat(r11));     // Catch: Throwable -> L12
        h.put(r11, new c(r12, null, null, false, SystemClock.uptimeMillis(), 14));     // Catch: Throwable -> L12
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
    }

    public static void h(String r13, ParcelFileDescriptor r14) {
        Intrinsics.checkNotNullParameter(r13, "fdKey");
        Intrinsics.checkNotNullParameter(r14, "fd");
        if (StringsKt.isBlank(r13) == false) goto L10;
        FLogger.a.e("AppIntentScreenshotCacheUtils", "putFile, fdKey is blank");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
        r14.close();     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L10:
        CompletableDeferred r2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Object r11 = b;
        monitor-enter(r11);
        a.getClass();     // Catch: Throwable -> L16
        f();     // Catch: Throwable -> L16
        FLogger.a.i("AppIntentScreenshotCacheUtils", "put pending heif, fdKey=".concat(r13));     // Catch: Throwable -> L16
        h.put(r13, new c(null, null, r2, false, SystemClock.uptimeMillis(), 11));     // Catch: Throwable -> L16
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r11);
        BuildersKt.launch$default(c, null, null, new AppIntentScreenshotCacheUtils$putFile$3(r14, r13, r2, null), 3, null);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final Object b(String r7, byte[] r8, Continuation<? super Pair<String, Boolean>> r9) {
        if ((r9 instanceof AppIntentScreenshotCacheUtils$encryptByteArray$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$encryptByteArray$1 r0 = (AppIntentScreenshotCacheUtils$encryptByteArray$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L31:
        String r11 = (String) r10;
        if (r11 == null) goto L36;
        Pair r12 = TuplesKt.to(r11, Boxing.boxBoolean(true));
        if (r12 == null) goto L36;
        return r12;
    L36:
        return TuplesKt.to(null, Boxing.boxBoolean(false));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (g == false) goto L17;
        byte[] r13 = new byte[LynxTouchEvent.kPseudoStateFocusTransition];
        d.nextBytes(r13);
        r8 = ArraysKt.plus(r8, r13);
    L17:
        IObricDebugService r14 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);
        if (r14 != null) goto L20;
    L22:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L26;
        FLogger.a.i("AppIntentScreenshotCacheUtils", "encryptByteArray, not enable pcc privacy");
        return TuplesKt.to(Base64.encodeToString(r8, 2), Boxing.boxBoolean(false));
    L26:
        FLogger.a.i("AppIntentScreenshotCacheUtils", "encryptByteArray, encrypt");
        IObricPccService r16 = (IObricPccService) ServiceManager.get().getService(IObricPccService.class);
        if (r16 == null) goto L36;
        r0.label = 1;
        r10 = r16.a(r7, r8, r0);
        if (r10 != r2) goto L31;
        return r2;
    L20:
        if (r14.c() == true) goto L22;
        r15 = true;
    L7:
        r0 = new AppIntentScreenshotCacheUtils$encryptByteArray$1(this, r9);
        goto L8
    }

    public final Object i(String r13, String r14, Continuation<? super b> r15) {
        if ((r15 instanceof AppIntentScreenshotCacheUtils$tryGetEncryptData$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$tryGetEncryptData$1 r1 = (AppIntentScreenshotCacheUtils$tryGetEncryptData$1) r15;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r16);
    L96:
        Pair r17 = (Pair) r16;
        return new b((String) r17.component1(), ((Boolean) r17.component2()).booleanValue(), ScreenshotSource.BITMAP);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r13 = (String) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L19
    L75:
        a r18 = (a) r16;     // Catch: Throwable -> L19
        return new b(r18.a, r18.b, ScreenshotSource.HEIF);
    L21:
        String r19 = (String) r1.L$1;
        String r110 = (String) r1.L$0;
        ResultKt.throwOnFailure(r16);
    L51:
        Pair r111 = (Pair) r16;
        String r11 = r110;
        r14 = r19;
        r13 = r11;
    L52:
        if (r111 == null) goto L57;
        String r5 = (String) r111.getFirst();
        if (r5 == null) goto L57;
        r13 = r5;
    L62:
        if (r111 == null) goto L98;
        c r112 = (c) r111.getSecond();
        if (r112 == null) goto L98;
        FLogger r113 = FLogger.a;
        r113.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 1 messageId=".concat(r13));
        String r6 = r112.b;
        if (r6 != null) goto L69;
        CompletableDeferred<a> r7 = r112.c;
        if (r7 == null) goto L79;
        r113.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, wait pending encrypted data, messageId=".concat(r13));     // Catch: Throwable -> L19
        r1.L$0 = r13;     // Catch: Throwable -> L19
        r1.L$1 = null;     // Catch: Throwable -> L19
        r1.label = 2;     // Catch: Throwable -> L19
        r16 = r7.await(r1);     // Catch: Throwable -> L19
        if (r16 != r3) goto L75;
        return r3;
    L79:
        Bitmap r114 = r112.a;
        if (r114 == null) goto L82;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L88
        if (r114.compress(Bitmap.CompressFormat.JPEG, 90, r0) == true) goto L86;
        r113.w("AppIntentScreenshotCacheUtils", "bitmapToByteArray, compress failed");     // Catch: Throwable -> L88
        goto L89
    L86:
        byte[] r115 = r0.toByteArray();     // Catch: Throwable -> L88
    L90:
        if (r115 != null) goto L93;
        f.a(r13, "bitmapToByteArray failed");
        f.b(r13);
        return new b(null, false, ScreenshotSource.NONE);
    L93:
        FLogger.a.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 2 messageId=".concat(r13));
        r1.L$0 = null;
        r1.L$1 = null;
        r1.label = 3;
        r16 = b(r13, r115, r1);
        if (r16 != r3) goto L96;
        return r3;
    L89:
        r115 = null;
        goto L90
    L82:
        return new b(null, false, ScreenshotSource.NONE);
    L69:
        return new b(r6, r112.d, ScreenshotSource.HEIF);
    L98:
        f.a(r13, "get screenshot failed");
        f.b(r13);
        return new b(null, false, ScreenshotSource.NONE);
    L57:
        if (r13 != null) goto L62;
        if (r14 == null) goto L60;
        r13 = r14;
        goto L62
    L60:
        return new b(null, false, ScreenshotSource.NONE);
    L22:
        ResultKt.throwOnFailure(r16);
        if (r13 != null) goto L25;
    L32:
        r13 = null;
    L33:
        if (r14 != null) goto L35;
    L44:
        r14 = null;
    L45:
        FLogger.a.i("AppIntentScreenshotCacheUtils", "tryGetEncryptData, in 0 messageId=" + r13 + ", questionId=" + r14);
        r111 = c(r13, r14);
        if (r111 != null) goto L52;
        r1.L$0 = r13;
        r1.L$1 = r14;
        r1.label = 1;
        r16 = j(r13, r14, r1);
        if (r16 != r3) goto L50;
        return r3;
    L50:
        String r12 = r14;
        r110 = r13;
        r19 = r12;
        goto L51
    L35:
        if ((!StringsKt.isBlank(r14)) == true) goto L37;
    L41:
        boolean r116 = false;
    L42:
        if (r116 == false) goto L44;
    L37:
        if (Intrinsics.areEqual(r14, "-1") == true) goto L41;
        if (Intrinsics.areEqual(r14, r13) == true) goto L41;
        r116 = true;
        goto L42
    L25:
        if ((!StringsKt.isBlank(r13)) == true) goto L27;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == false) goto L32;
    L27:
        if (Intrinsics.areEqual(r13, "-1") == true) goto L29;
        r8 = true;
    L19:
        th = move-exception;
        ConcurrentHashMap<String, String> r117 = f.a;
        f.a(r13, "wait pending encrypted data failed: " + th.getMessage());
        f.b(r13);
        return new b(null, false, ScreenshotSource.NONE);
    L7:
        r1 = new AppIntentScreenshotCacheUtils$tryGetEncryptData$1(this, r15);
        goto L8
    }

    public final Object j(String r12, String r13, Continuation<? super Pair<String, c>> r14) {
        if ((r14 instanceof AppIntentScreenshotCacheUtils$waitForEntry$1) == false) goto L7;
        AppIntentScreenshotCacheUtils$waitForEntry$1 r0 = (AppIntentScreenshotCacheUtils$waitForEntry$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r16 = r0.J$0;
        String r4 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        if (SystemClock.uptimeMillis() >= r16) goto L28;
        Pair r17 = c(r5, r4);
        if (r17 != null) goto L23;
        r0.L$0 = r5;
        r0.L$1 = r4;
        r0.J$0 = r16;
        r0.label = 1;
        if (DelayKt.delay(20, r0) != r2) goto L20;
        return r2;
    L23:
        FLogger.a.i("AppIntentScreenshotCacheUtils", "waitForEntry hit, messageId=" + r5 + ", questionId=" + r4);
        return r17;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L18;
        if (r13 != null) goto L18;
        return null;
    L18:
        r4 = r13;
        r5 = r12;
        r16 = SystemClock.uptimeMillis() + 3000;
    L7:
        r0 = new AppIntentScreenshotCacheUtils$waitForEntry$1(this, r14);
        goto L8
    }
}
