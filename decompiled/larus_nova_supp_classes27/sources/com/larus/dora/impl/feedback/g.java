package com.larus.dora.impl.feedback;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import com.larus.platform.model.upload.UploadDataType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public final Uri a;
    public int b;
    public final h c;
    public final StateFlowImpl d;
    public final b1 e;
    public final boolean f;
    public String g;
    public Job h;
    public String i;
    public boolean j;

    private final Context getContext() {
        return this.c.a.getContext();
    }

    public static final /* synthetic */ Context a(g r0) {
        return r0.getContext();
    }

    public static final Object b(g r26, Continuation r27) {
        r26.getClass();
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r27), 1);
        r1.C();
        r0 r2 = r26.c.a.getImageXUploadCredentials();
        String r5 = r26.i;
        Intrinsics.checkNotNull(r5);
        Context r13 = r26.getContext();
        boolean r4 = r26.f;
        if (r4 == false) goto L5;
        UploadDataType r6 = UploadDataType.VIDEO;
    L6:
        UploadDataType r7 = r6;
        if (r4 == true) goto L9;
    L11:
        boolean r11 = false;
    L12:
        Intrinsics.checkNotNull(r2);
        mr9.m r3 = new mr9.m(r2.e(), "imagex.bytedanceapi.com", new mr9.b(r2.a(), r2.d(), r2.f(), r2.c(), r2.b()), 2);
        p0 r8 = new p0(new mr9.j(r5, "DoraG Feedback", r7, d.a, e.a, f.a, r11, r3, r13, null, null, false, null, null, null, null, null, null, null, null, 2096384));
        b r9 = new b(r26, r1);
        Intrinsics.checkNotNullParameter(r9, "listener");
        r8.c = r9;
        r1.i(new c(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFeedbackImage$uploadImage$2$uploadJob$1(r8, r1, null), 3, null), r8));
        Object r0 = r1.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r27);
    L16:
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r0;
    L19:
        return Unit.INSTANCE;
    L9:
        if (r26.j == false) goto L11;
        r11 = true;
        goto L12
    L5:
        r6 = UploadDataType.IMAGE;
        goto L6
    }

    public static Object c(g r8, Continuation r9) {
        r8.getClass();
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        r0.i(new a(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFeedbackImage$compressImage$2$compressionJob$1(r8, r0, null), 3, null)));
        Object r10 = r0.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r10;
    }

    public g(Uri r4, int r5, h r6) {
        Intrinsics.checkNotNullParameter(r4, "_uri");
        Intrinsics.checkNotNullParameter(r6, "imageGroup");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        StateFlowImpl r7 = j1.a(ImageState.IDLE);
        this.d = r7;
        this.e = kotlinx.coroutines.flow.e.b(r7);
        this.g = "";
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r7, new DoraFeedbackImage$setupStateLogging$1(this, null)), ViewModelKt.getViewModelScope(r6.a));
        String r8 = getContext().getContentResolver().getType(r4);
        boolean r9 = false;
        if (r8 != null) goto L5;
    L7:
        if (r9 == false) goto L10;
        this.f = true;
        return;
    L10:
        return;
    L5:
        if (StringsKt.startsWith$default(r8, "video/", false, 2, null) != true) goto L7;
        r9 = true;
        goto L7
    }
}
