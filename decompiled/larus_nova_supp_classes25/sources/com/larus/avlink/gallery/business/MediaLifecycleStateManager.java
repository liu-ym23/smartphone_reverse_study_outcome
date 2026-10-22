package com.larus.avlink.gallery.business;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaLifecycleStateManager {
    public static final a b = null;
    public static volatile MediaLifecycleStateManager c;
    public final List<r98.b> a;

    public static final class a {
        public final MediaLifecycleStateManager a() {
            MediaLifecycleStateManager r0 = MediaLifecycleStateManager.c;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = MediaLifecycleStateManager.c;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new MediaLifecycleStateManager();     // Catch: Throwable -> L10
            MediaLifecycleStateManager.c = r0;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
        b = new a();
    }

    public MediaLifecycleStateManager() {
        this.a = new ArrayList();
    }

    public final void e(r98.b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        List<r98.b> r1 = this.a;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.a).contains(r6) == true) goto L7;
        ((ArrayList) this.a).add(r6);     // Catch: Throwable -> L10
        FLogger.a.d("MediaLifecycleStateManager", "Registered listener: ".concat(r6.getClass().getSimpleName()));     // Catch: Throwable -> L10
    L7:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r1);
    }

    public final void h(r98.b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        List<r98.b> r1 = this.a;
        monitor-enter(r1);
        ((ArrayList) this.a).remove(r6);     // Catch: Throwable -> L7
        FLogger.a.d("MediaLifecycleStateManager", "Unregistered listener: ".concat(r6.getClass().getSimpleName()));     // Catch: Throwable -> L7
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Object d(MediaLifecycleState r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$queryByState$2(r3, null), r4);
    }

    public final Object b(String r4, String r5, Continuation<? super Unit> r6) {
        Object r7 = BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$markFailed$2(r4, r5, this, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public final void c(String r8, MediaLifecycleState r9, MediaLifecycleState r10, MediaMetadata r11) {
        List<r98.b> r0 = this.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.a);     // Catch: Throwable -> L15
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        r98.b r3 = (r98.b) r2.next();
        r3.b(r8, r9, r10, r11);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.a.e("MediaLifecycleStateManager", "Error notifying listener " + r3.getClass().getSimpleName() + ": " + e.getMessage(), e);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static final void a(MediaLifecycleStateManager r6, String r7, MediaLifecycleState r8, String r9, MediaMetadata r10) {
        List<r98.b> r0 = r6.a;
        monitor-enter(r0);
        List r11 = CollectionsKt.toList(r6.a);     // Catch: Throwable -> L15
        monitor-exit(r0);
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        r98.b r1 = (r98.b) r12.next();
        r1.a(r7, r8, r9, r10);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.a.e("MediaLifecycleStateManager", "Error notifying listener " + r1.getClass().getSimpleName() + ": " + e.getMessage(), e);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final Object f(String r49, MediaLifecycleState r50, Function1<? super MediaMetadata, MediaMetadata> r51, boolean r52, Continuation<? super Unit> r53) {
        if ((r53 instanceof MediaLifecycleStateManager$transitionTo$1) == false) goto L7;
        MediaLifecycleStateManager$transitionTo$1 r6 = (MediaLifecycleStateManager$transitionTo$1) r53;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r0 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L30;
        if (r9 == 1) goto L25;
        if (r9 == 2) goto L20;
        if (r9 != 3) goto L19;
        boolean r2 = r6.Z$0;
        MediaMetadata r3 = (MediaMetadata) r6.L$3;
        MediaLifecycleState r5 = (MediaLifecycleState) r6.L$2;
        MediaLifecycleState r10 = (MediaLifecycleState) r6.L$1;
        String r11 = (String) r6.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L16
    L78:
        String r12 = r11;
        MediaLifecycleState r13 = r10;
    L79:
        c(r12, r5, r13, r3);     // Catch: Exception -> L28
        FLogger r1 = FLogger.a;     // Catch: Exception -> L28
        StringBuilder r4 = new StringBuilder("State transition: ");     // Catch: Exception -> L28
        r4.append(r12);     // Catch: Exception -> L28
        r4.append(": ");     // Catch: Exception -> L28
        r4.append(r5);     // Catch: Exception -> L28
        r4.append(" -> ");     // Catch: Exception -> L28
        r4.append(r13);     // Catch: Exception -> L28
        r4.append(" (cleanup: ");     // Catch: Exception -> L28
        if (r2 == false) goto L82;
        boolean r14 = true;
    L83:
        r4.append(r14);     // Catch: Exception -> L28
        r4.append(')');     // Catch: Exception -> L28
        r1.i("MediaLifecycleStateManager", r4.toString());     // Catch: Exception -> L28
    L90:
        return Unit.INSTANCE;
    L82:
        r14 = false;
    L16:
        e = e;
        r12 = r11;
    L88:
        FLogger.a.e("MediaLifecycleStateManager", "Error during state transition for " + r12 + ": " + e.getMessage(), e);
        goto L90
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r2 = r6.Z$0;
        r3 = (MediaMetadata) r6.L$3;
        r5 = (MediaLifecycleState) r6.L$2;
        r13 = (MediaLifecycleState) r6.L$1;
        String r15 = (String) r6.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L23
        r12 = r15;
    L70:
        if (r2 == false) goto L79;
        r6.L$0 = r12;     // Catch: Exception -> L28
        r6.L$1 = r13;     // Catch: Exception -> L28
        r6.L$2 = r5;     // Catch: Exception -> L28
        r6.L$3 = r3;     // Catch: Exception -> L28
        r6.Z$0 = r2;     // Catch: Exception -> L28
        r6.label = 3;     // Catch: Exception -> L28
        Object r16 = BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$cleanupObsoleteFiles$2(r3, null), r6);     // Catch: Exception -> L28
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L75;
        r16 = Unit.INSTANCE;     // Catch: Exception -> L28
    L75:
        if (r16 != r8) goto L77;
        return r8;
    L77:
        r10 = r13;
        r11 = r12;
    L23:
        e = e;
        r12 = r15;
        goto L88
    L25:
        r2 = r6.Z$0;
        Function1<? super MediaMetadata, MediaMetadata> r17 = (Function1) r6.L$2;
        MediaLifecycleState r18 = (MediaLifecycleState) r6.L$1;
        r12 = (String) r6.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L28
        Function1<? super MediaMetadata, MediaMetadata> r19 = r17;
        r13 = r18;
    L35:
        MediaMetadata r20 = (MediaMetadata) r0;     // Catch: Exception -> L28
        if (r20 != null) goto L39;
        FLogger.a.e("MediaLifecycleStateManager", "Cannot transition: metadata not found for " + r12);     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L39:
        r5 = r20.getLifecycleState();     // Catch: Exception -> L28
        if (r13 != MediaLifecycleState.FAILED) goto L43;
    L59:
        boolean r110 = true;
    L61:
        if (r110 == true) goto L64;
        FLogger.a.w("MediaLifecycleStateManager", "Invalid state transition: " + r5 + " -> " + r13 + " for " + r12);     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L64:
        if (r19 == null) goto L66;
        r20 = (MediaMetadata) r19.invoke(r20);     // Catch: Exception -> L28
    L66:
        MediaMetadata r21 = MediaMetadata.copy$default(r20, null, 0, null, null, null, null, 0, 0, 0, 0, 0, 0.0d, 0, null, null, r13, null, null, null, null, null, null, null, 0, 16744447, null);     // Catch: Exception -> L28
        AlbumDataBaseHelper r22 = AlbumDataBaseHelper.a;     // Catch: Exception -> L28
        r6.L$0 = r12;     // Catch: Exception -> L28
        r6.L$1 = r13;     // Catch: Exception -> L28
        r6.L$2 = r5;     // Catch: Exception -> L28
        r6.L$3 = r21;     // Catch: Exception -> L28
        r6.Z$0 = r2;     // Catch: Exception -> L28
        r6.label = 2;     // Catch: Exception -> L28
        if (r22.y(r21, r6) != r8) goto L69;
        return r8;
    L69:
        r3 = r21;
        goto L70
    L43:
        switch(b.a[r5.ordinal()]) {
            case 1: goto L58;
            case 2: goto L55;
            case 3: goto L52;
            case 4: goto L49;
            case 5: goto L46;
            case 6: goto L60;
            case 7: goto L60;
            default: goto L85;
        };     // Catch: Exception -> L28
    L60:
        r110 = false;
        goto L61
    L85:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L28
    L46:
        if (r13 != MediaLifecycleState.COMPLETED) goto L60;
    L49:
        if (r13 != MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM) goto L60;
    L52:
        if (r13 != MediaLifecycleState.PROCESSED) goto L60;
    L55:
        if (r13 != MediaLifecycleState.PROCESSING) goto L60;
    L58:
        if (r13 != MediaLifecycleState.DOWNLOADED_TEMP) goto L60;
    L28:
        e = e;
        goto L88
    L30:
        ResultKt.throwOnFailure(r0);
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;     // Catch: Exception -> L86
        r6.L$0 = r49;     // Catch: Exception -> L86
        r13 = r50;
        r6.L$1 = r13;     // Catch: Exception -> L86
        r19 = r51;
        r6.L$2 = r19;     // Catch: Exception -> L86
        r6.Z$0 = r52;     // Catch: Exception -> L86
        r6.label = 1;     // Catch: Exception -> L86
        r0 = r23.o(r49, r6);     // Catch: Exception -> L86
        if (r0 != r8) goto L34;
        return r8;
    L34:
        r12 = r49;
        r2 = r52;
    L86:
        e = e;
        r12 = r49;
    L7:
        r6 = new MediaLifecycleStateManager$transitionTo$1(this, r53);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object g(MediaLifecycleStateManager r6, String r7, MediaLifecycleState r8, Function1 r9, Continuation r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r9 = null;
    L5:
        Function1 r3 = r9;
        if ((r11 & 8) == 0) goto L8;
        boolean r4 = true;
    L10:
        return r6.f(r7, r8, r3, r4, r10);
    L8:
        r4 = false;
        goto L10
    }
}
