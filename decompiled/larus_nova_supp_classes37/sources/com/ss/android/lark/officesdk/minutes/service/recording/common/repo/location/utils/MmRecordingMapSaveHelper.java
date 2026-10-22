package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location.service.f;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.LarkContext;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingMapSaveHelper {
    public static final /* synthetic */ int m = 0;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final Function0<MmRecordingUILaunchMode> b;
    public final String c;
    public final long d;
    public final Lazy e;
    public final Lazy f;
    public volatile IPickLocationMap g;
    public CoroutineScope h;
    public Double i;
    public Double j;
    public WeakReference<ViewGroup> k;
    public b l;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    static {
    }

    public final void c() {
        CoroutineScope r0 = this.h;     // Catch: Exception -> L7
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);     // Catch: Exception -> L7
    L5:
        this.h = null;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        lvb.a.b(this.c, "[cancelScope] e=" + e);
    }

    public final void f() {
        IPickLocationMap r0 = this.g;
        Unit r1 = null;
        this.g = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.onDestroy();     // Catch: Throwable -> L8
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final int b(MmRecordingMapSaveHelper r0) {
        return ((Number) r0.e.getValue()).intValue();
    }

    public final void d(String r6) {
        String r0 = this.c;
        StringBuilder r1 = new StringBuilder("[cleanupAllResources] from=");
        r1.append(r6);
        r1.append(", pickLocationMap is null?=");
        boolean r2 = false;
        if (this.g != null) goto L5;
        boolean r7 = true;
    L6:
        r1.append(r7);
        lvb.a.e(r0, r1.toString());
        c();
        f();
        WeakReference<ViewGroup> r8 = this.k;
        if (r8 == null) goto L9;
        ViewGroup r9 = r8.get();
    L10:
        String r3 = this.c;
        StringBuilder r4 = new StringBuilder("[hideContainer] container is null?=");
        if (r9 != null) goto L13;
        r2 = true;
    L13:
        r4.append(r2);
        lvb.a.e(r3, r4.toString());
        if (r9 == null) goto L16;
        r9.removeAllViews();
    L16:
        if (r9 == null) goto L19;
        r9.setVisibility(8);
        return;
    L19:
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingMapSaveHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, Function0<? extends MmRecordingUILaunchMode> r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchModeProvider");
        this.a = r2;
        this.b = r3;
        this.c = "MmRecordingMapSaveHelper";
        this.d = 1000;
        this.e = LazyKt.lazy(MmRecordingMapSaveHelper$bitmapWidth$2.INSTANCE);
        this.f = LazyKt.lazy(MmRecordingMapSaveHelper$bitmapHeight$2.INSTANCE);
    }

    public static byte[] g(PolarisFileWrapper r4, String r5) {
        File r0 = new PolarisFileWrapper(r4, r5);
        if (r0.exists() == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (r6 == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
        return null;
    L14:
        return FilesKt.readBytes(r0);
    L5:
        if (r0.length() <= 0) goto L7;
        r6 = true;
        goto L9
    }

    public final void i(Double r17, Double r18, String r19) {
        if (r17 == null) goto L28;
        if (r18 == null) goto L28;
        Application r2 = LarkContext.getApplication();
        if (r2 != null) goto L10;
        lvb.a.b(this.c, "[tryLoadMap] application context is null, from=".concat(r19));
        return;
    L10:
        WeakReference<ViewGroup> r0 = this.k;
        if (r0 == null) goto L13;
        ViewGroup r5 = r0.get();
    L14:
        if (r5 != null) goto L18;
        lvb.a.h(this.c, "[tryLoadMap] no available container, skip, from=".concat(r19));
        return;
    L18:
        if (Intrinsics.areEqual(this.i, r17) == true) goto L20;
    L23:
        boolean r8 = true;
    L24:
        this.j = r18;
        this.i = r17;
        lvb.a.e(this.c, "[tryLoadMap] start, from=" + r19 + ", locationChanged=" + r8);
        c();
        f();
        CoroutineScope r10 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.h = r10;
        if (r10 == null) goto L30;
        BuildersKt.launch$default(r10, null, null, new MmRecordingMapSaveHelper$tryLoadMap$1(r8, r2, this, r19, r5, r17, r18, null), 3, null);
        return;
    L30:
        return;
    L20:
        if (Intrinsics.areEqual(this.j, r18) == false) goto L23;
        r8 = false;
        goto L24
    L13:
        r5 = null;
    L28:
        lvb.a.b(this.c, "[tryLoadMap] unexpected, from=".concat(r19));
    }

    public final void j(Context r10, PolarisFileWrapper r11, boolean r12) {
        if (r12 == false) goto L4;
        String r13 = "mm_recording_amap_style_night.zip";
    L5:
        InputStream r14 = r10.getAssets().open(r13);
        final ZipInputStream r0 = new ZipInputStream(r14);     // Catch: Throwable -> L51
        Iterator r1 = SequencesKt.generateSequence(new MmRecordingMapSaveHelper$unzipAmapStyle$1$1$1(r0)).iterator();     // Catch: Throwable -> L46
    L9:
        if (r1.hasNext() == false) goto L42;
        ZipEntry r2 = (ZipEntry) r1.next();     // Catch: Throwable -> L46
        if (r2.isDirectory() == true) goto L41;
        if (Intrinsics.areEqual(r2.getName(), "style.data") == false) goto L15;
    L16:
        File r4 = new PolarisFileWrapper(r11, r2.getName());     // Catch: Throwable -> L46
        PolarisFileWrapper r5 = new PolarisFileWrapper(r11, r2.getName() + ".tmp");     // Catch: Throwable -> L46
        if (r5.exists() == false) goto L19;
        r5.delete();     // Catch: Throwable -> L46
    L19:
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L46
        ByteStreamsKt.copyTo$default(r0, r3, 0, 2, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L46
        if (r5.length() <= 0) goto L24;
        if (r4.exists() == false) goto L31;
        if (r4.delete() == true) goto L31;
        r5.delete();     // Catch: Throwable -> L46
    L31:
        if (r5.renameTo(r4) == true) goto L33;
    L34:
        r5.delete();     // Catch: Throwable -> L46
        r4.delete();     // Catch: Throwable -> L46
        goto L41
    L33:
        if (r4.length() > 0) goto L41;
    L24:
        r5.delete();     // Catch: Throwable -> L46
        goto L9
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L15:
        if (Intrinsics.areEqual(r2.getName(), "style_extra.data") == true) goto L16;
    L41:
        r0.closeEntry();     // Catch: Throwable -> L46
        goto L9
    L42:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L46
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r14, null);
        lvb.a.e(this.c, "[unzipAmapStyle] assetFile=" + r13 + ", dir=" + r11.getAbsolutePath());
        return;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L4:
        r13 = "mm_recording_amap_style.zip";
        goto L5
    }

    public final Object h(IPickLocationMap r17, Context r18, boolean r19, Continuation<? super Unit> r20) {
        if ((r20 instanceof MmRecordingMapSaveHelper$setMapStyle$1) == false) goto L7;
        MmRecordingMapSaveHelper$setMapStyle$1 r1 = (MmRecordingMapSaveHelper$setMapStyle$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$setMapStyle$1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r8.J$0;
        boolean r5 = r8.Z$0;
        MmRecordingUILaunchMode r6 = (MmRecordingUILaunchMode) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L29:
        long r11 = r4;
        MmRecordingUILaunchMode r13 = r6;
    L31:
        lvb.a.e(this.c, "[setMapStyle] mode=" + r13 + ", isDarkMode=" + r5 + ", cost=" + (System.currentTimeMillis() - r11) + "ms");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r11 = System.currentTimeMillis();
        r13 = (MmRecordingUILaunchMode) this.b.invoke();
        r17.d();
        if (r19 == false) goto L17;
        IPickLocationMap.DarkMode r7 = IPickLocationMap.DarkMode.DARK;
    L18:
        r17.j(r7);
        if (r13 != null) goto L21;
    L23:
        boolean r10 = false;
    L24:
        if (r10 == false) goto L30;
        CoroutineDispatcher r14 = Dispatchers.getIO();
        MmRecordingMapSaveHelper$setMapStyle$2 r15 = new MmRecordingMapSaveHelper$setMapStyle$2(this, r17, r18, r19, null);
        r8.L$0 = r13;
        r8.Z$0 = r19;
        r8.J$0 = r11;
        r8.label = 1;
        if (BuildersKt.withContext(r14, r15, r8) != r9) goto L28;
        return r9;
    L28:
        r5 = r19;
        r4 = r11;
        r6 = r13;
        goto L29
    L30:
        r17.g();
        r5 = r19;
        goto L31
    L21:
        if (r13.isFeishuUIStyle() != true) goto L23;
        r10 = true;
        goto L24
    L17:
        r7 = IPickLocationMap.DarkMode.LIGHT;
    L7:
        r1 = new MmRecordingMapSaveHelper$setMapStyle$1(this, r20);
        goto L8
    }

    public static final Object a(MmRecordingMapSaveHelper r18, Context r19, ViewGroup r20, double r21, double r23, boolean r25, Continuation r26) {
        boolean r12 = r25;
        r18.getClass();
        if ((r26 instanceof MmRecordingMapSaveHelper$generateSnapshotForMode$1) == false) goto L7;
        MmRecordingMapSaveHelper$generateSnapshotForMode$1 r1 = (MmRecordingMapSaveHelper$generateSnapshotForMode$1) r26;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$generateSnapshotForMode$1 r10 = r1;
        Object r0 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        boolean r4 = r10.Z$0;
        IPickLocationMap r5 = (IPickLocationMap) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14 Exception -> L16
        r12 = r4;
        IPickLocationMap r15 = null;
    L72:
        boolean r6 = ((Boolean) r0).booleanValue();     // Catch: Throwable -> L38 Exception -> L40
        r18.g = r15;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L35
        r5.onDestroy();     // Catch: Throwable -> L35
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        boolean r16 = r6;
    L64:
        return Boxing.boxBoolean(r16);
    L35:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        e = e;
    L52:
        String r9 = r18.c;     // Catch: Throwable -> L38
        StringBuilder r11 = new StringBuilder("[generateSnapshotForMode] failed, isDarkMode=");     // Catch: Throwable -> L38
        if (r12 == false) goto L55;
        boolean r13 = true;
    L56:
        r11.append(r13);     // Catch: Throwable -> L38
        r11.append(", error=");     // Catch: Throwable -> L38
        r11.append(e.getMessage());     // Catch: Throwable -> L38
        lvb.a.b(r9, r11.toString());     // Catch: Throwable -> L38
        r18.g = r15;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L60
        r5.onDestroy();     // Catch: Throwable -> L60
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        r16 = false;
    L60:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L55:
        r13 = false;
    L38:
        th = move-exception;
        Throwable r24 = th;
    L66:
        r18.g = r15;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L69
        r5.onDestroy();     // Catch: Throwable -> L69
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
        throw r24;
    L69:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        throw r24;
    L16:
        e = e;
        r12 = r4;
        r15 = null;
    L14:
        th = move-exception;
        r24 = th;
        r15 = null;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r0);
        IPickLocationMap r29 = f.a().getPickLocationMap();
        r18.g = r29;
        Intrinsics.checkNotNull(r29);     // Catch: Throwable -> L46 Exception -> L49
        if (r12 == false) goto L24;
        boolean r30 = true;
    L25:
        r10.L$0 = r29;     // Catch: Throwable -> L46 Exception -> L49
        r10.Z$0 = r12;     // Catch: Throwable -> L46 Exception -> L49
        r10.label = 1;     // Catch: Throwable -> L46 Exception -> L49
        IPickLocationMap r110 = r29;
        r15 = null;
        r0 = r18.e(r29, r19, r20, r30, r21, r23, r10);     // Catch: Throwable -> L42 Exception -> L44
        if (r0 == r14) goto L87;
        r5 = r110;
        goto L72
    L87:
        return r14;
    L44:
        e = e;
    L51:
        r5 = r110;
    L42:
        th = th;
    L48:
        r24 = th;
        r5 = r110;
        goto L66
    L24:
        r30 = false;
    L49:
        e = e;
        r110 = r29;
        r15 = null;
    L46:
        th = th;
        r110 = r29;
        r15 = null;
    L7:
        r1 = new MmRecordingMapSaveHelper$generateSnapshotForMode$1(r18, r26);
        goto L8
    }

    public final Object e(IPickLocationMap r20, Context r21, ViewGroup r22, boolean r23, double r24, double r26, Continuation<? super Boolean> r28) {
        boolean r2 = r23;
        if ((r28 instanceof MmRecordingMapSaveHelper$createAndCaptureMap$1) == false) goto L7;
        MmRecordingMapSaveHelper$createAndCaptureMap$1 r4 = (MmRecordingMapSaveHelper$createAndCaptureMap$1) r28;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$createAndCaptureMap$1 r11 = r4;
        Object r3 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r11.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
    L31:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        double r0 = r11.D$1;
        double r7 = r11.D$0;
        r2 = r11.Z$0;
        ViewGroup r8 = (ViewGroup) r11.L$2;
        Context r9 = (Context) r11.L$1;
        IPickLocationMap r10 = (IPickLocationMap) r11.L$0;
        ResultKt.throwOnFailure(r3);
        double r13 = r0;
        ViewGroup r14 = r8;
    L20:
        r14.removeAllViews();
        View r1 = r10.h(r9);
        if (r1 != null) goto L24;
        lvb.a.b(this.c, "[createAndCaptureMap] mapView is null");
        return Boxing.boxBoolean(false);
    L24:
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -1);
        r14.addView(r1, r15);
        View r16 = new View(r9);
        int r17 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a;
        r16.setBackgroundColor(ContextCompat.getColor(r9, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a((MmRecordingUILaunchMode) this.b.invoke())));
        r14.addView(r16, r15);
        if (r2 == false) goto L27;
        String r18 = "mm_map_snapshot_dark.png";
    L28:
        String r19 = r18;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 2;
        r3 = TimeoutKt.b(this.d + 10000, new MmRecordingMapSaveHelper$captureAndSaveSnapshot$2(this, r19, r10, r7, r13, r9, null), r11);
        if (r3 != r12) goto L31;
        return r12;
    L27:
        r18 = "mm_map_snapshot_light.png";
        goto L28
    L16:
        ResultKt.throwOnFailure(r3);
        r11.L$0 = r20;
        r11.L$1 = r21;
        r14 = r22;
        r11.L$2 = r14;
        r11.Z$0 = r2;
        r11.D$0 = r24;
        r13 = r26;
        r11.D$1 = r13;
        r11.label = 1;
        if (h(r20, r21, r2, r11) != r12) goto L19;
        return r12;
    L19:
        r10 = r20;
        r7 = r24;
        r9 = r21;
    L7:
        r4 = new MmRecordingMapSaveHelper$createAndCaptureMap$1(this, r28);
        goto L8
    }
}
