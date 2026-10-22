package com.larus.camera.impl.edulibs.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.larus.camera.impl.edulibs.camera.internal.EduClipImageView;
import com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.camera.internal.idl.Orientation;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipImageRect;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipRectAnimateView;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import mx8.e;
import nx8.f;
import nx8.g;
import nx8.i;
import nx8.j;
import nx8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements m {
    public final Map<String, Object> a;
    public final com.larus.camera.impl.edulibs.camera.a.b b;
    public final CoroutineScope c;
    public final EduQuestionSearchLogic d;
    public final FrameLayout e;
    public final EduClipImageView f;
    public final EduClipRectAnimateView g;
    public final StateFlowImpl h;
    public int i;
    public int j;
    public Long k;
    public IdentifyDetectionResult l;
    public String m;
    public Bitmap n;
    public boolean o;
    public int p;
    public int q;

    public static final class a {
    }

    static {
    }

    @Override // nx8.m
    public final Bitmap b() {
        Bitmap r0 = this.f.getOriginBitmap();
        if (r0 != null) goto L5;
        return null;
    L5:
        float[] r3 = new float[8];
        int r4 = 0;
    L6:
        if (r4 >= 8) goto L19;
        int r5 = r4 % 4;
        if (r5 != 0) goto L10;
    L16:
        float r6 = 0.0f;
    L17:
        r3[r4] = r6;
        r4 = r4 + 1;
        goto L6
    L10:
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L14;
        int r7 = r0.getHeight();
    L15:
        r6 = r7;
        goto L17
    L14:
        r7 = r0.getWidth();
        goto L15
    L19:
        if (this.d.a.a == false) goto L21;
        int r2 = this.f.getRotateDegrees() + this.j;
    L36:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        Object r1 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r0, r3, r2));     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r1);
        if (r9 == null) goto L30;
        this.b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r9);
    L30:
        if (Result.isFailure-impl(r1) == false) goto L32;
        r1 = null;
    L32:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a r10 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a) r1;
        if (r10 != null) goto L35;
        return null;
    L35:
        return r10.a;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L21:
        r2 = this.f.getRotateDegrees();
        goto L36
    }

    @Override // nx8.m
    public final boolean d() {
        return this.f.f.h;
    }

    @Override // nx8.m
    public final void destroy() {
        com.larus.camera.impl.edulibs.camera.a r0 = com.larus.camera.impl.edulibs.camera.a.a;
        com.larus.camera.impl.edulibs.camera.a.e.remove(this.m);
        CoroutineScopeKt.cancel$default(this.d.d, null, 1, null);
        CoroutineScopeKt.cancel$default(this.c, "EduImageViewHolder destroy", null, 2, null);
    }

    @Override // nx8.m
    public final Bitmap h() {
        EduClipImageView r0 = this.f;
        int r9 = 0;
        if (r0.f.h == true) goto L75;
        kx8.c r1 = this.d.h;
        Integer r2 = Integer.valueOf(r0.getSelectIndex());
        if (r2.intValue() < 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r2 = null;
    L11:
        if (r2 != null) goto L17;
        if (r1 == null) goto L15;
        r2 = r1.c;
    L16:
        if (r2 != null) goto L17;
        int r3 = 0;
    L19:
        if (r1 == null) goto L25;
        List<kx8.b> r4 = r1.b;
        if (r4 == null) goto L25;
        kx8.b r5 = (kx8.b) CollectionsKt.getOrNull(r4, r3);
        if (r5 == null) goto L25;
        Bitmap r6 = (Bitmap) r5.d.getValue();
    L26:
        Boolean r7 = (Boolean) CollectionsKt.firstOrNull(this.f.getClipModifyList());
        if (r7 == null) goto L29;
        boolean r8 = r7.booleanValue();
    L30:
        i r11 = this.d.a;
        if (r11.b != 1) goto L33;
        boolean r12 = true;
    L34:
        if (r12 == false) goto L39;
        if (r8 == true) goto L39;
        if (r6 == null) goto L39;
        this.b.i("EduImageViewHolder", "getClipBitmap: return cloud result: " + r6.getWidth() + ", " + r6.getHeight() + ", initDegree=" + this.i);
    L113:
        return r6;
    L39:
        r6 = this.f.getOriginBitmap();
        if (r6 != null) goto L42;
        this.b.e("EduImageViewHolder", "getClipBitmap: imageView.originBitmap is null", null);
        return null;
    L42:
        if (r12 == false) goto L44;
        RectF r13 = this.f.getClipRect();
    L45:
        if (r13 != null) goto L47;
        this.b.e("EduImageViewHolder", "getClipBitmap: imageView.rectF is null", null);
        goto L113
    L47:
        float[] r14 = new float[8];
    L48:
        if (r9 >= 8) goto L59;
        int r15 = r9 % 4;
        if (r15 == 0) goto L56;
        if (r15 == 1) goto L55;
        if (r15 == 2) goto L54;
        float r16 = r13.bottom;
    L57:
        r14[r9] = r16;
        r9 = r9 + 1;
        goto L48
    L54:
        r16 = r13.right;
        goto L57
    L55:
        r16 = r13.top;
        goto L57
    L56:
        r16 = r13.left;
        goto L57
    L59:
        if (r11.a == false) goto L61;
        int r17 = this.f.getRotateDegrees() + this.j;
    L102:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L64
        Object r19 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r6, r14, r17));     // Catch: Throwable -> L64
    L66:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L70;
        this.b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r20);
    L70:
        if (Result.isFailure-impl(r19) == false) goto L72;
        r19 = null;
    L72:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a r21 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a) r19;
        if (r21 != null) goto L116;
        return null;
    L116:
        return r21.a;
    L64:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L61:
        r17 = this.f.getRotateDegrees();
        goto L102
    L44:
        r13 = new RectF(0.0f, 0.0f, r6.getWidth(), r6.getHeight());
        goto L45
    L33:
        r12 = false;
        goto L34
    L29:
        r8 = false;
    L25:
        r6 = null;
        goto L26
    L15:
        r2 = null;
    L17:
        r3 = r2.intValue();
        goto L19
    L7:
        r10 = false;
        goto L8
    L75:
        Bitmap r23 = r0.m();
        if (r23 == null) goto L117;
        float[] r24 = new float[8];
    L78:
        if (r9 >= 8) goto L104;
        int r110 = r9 % 4;
        if (r110 == 0) goto L86;
        if (r110 == 1) goto L86;
        if (r110 == 2) goto L84;
        int r111 = r23.getHeight();
    L85:
        float r112 = r111;
    L87:
        r24[r9] = r112;
        r9 = r9 + 1;
        goto L78
    L84:
        r111 = r23.getWidth();
    L86:
        r112 = 0.0f;
        goto L87
    L104:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L90
        int r26 = com.larus.camera.impl.edulibs.camera.internal.util.a.a;     // Catch: Throwable -> L90
        Object r27 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.a.b(r23, r24, -this.i));     // Catch: Throwable -> L90
    L92:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L96;
        this.b.e("EduImageViewHolder", "getClipBitmap: clip bitmap error", r28);
    L96:
        if (Result.isFailure-impl(r27) == false) goto L98;
        r27 = null;
    L98:
        com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a r29 = (com.larus.camera.impl.edulibs.camera.internal.util.a.C0076a) r27;
        if (r29 != null) goto L101;
        return null;
    L101:
        return r29.a;
    L90:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L117:
        return null;
    }

    @Override // nx8.m
    public final boolean k() {
        kx8.c r0 = this.d.c();
        if (r0 == null) goto L7;
        List<kx8.b> r1 = r0.b;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L9:
        if (r2 <= 1) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = 0;
        goto L9
    }

    @Override // nx8.m
    public final int l() {
        kx8.c r0 = this.d.c();
        if (r0 == null) goto L7;
        List<kx8.b> r1 = r0.b;
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    @Override // nx8.m
    public final boolean p() {
        kx8.c r0 = this.d.c();
        if (r0 == null) goto L11;
        Bitmap r1 = r0.h;
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1 != this.f.getOriginBitmap()) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // nx8.m
    public final boolean q() {
        kx8.c r0 = this.d.c();
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0.g, Boolean.TRUE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.ImageView, com.larus.camera.impl.edulibs.camera.internal.EduClipImageView, java.lang.Object] */
    public final void s() {
        this.f.p(1.0f, 1.0f);
        kx8.c r0 = this.d.c();
        if (r0 == null) goto L44;
        List<kx8.b> r1 = r0.b;
        if (r1 == null) goto L10;
        List<kx8.b> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r3.add(((kx8.b) r4.next()).a);
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.size() <= 1) goto L46;
        ?? r5 = this.f;
        Integer r6 = r0.c;
        int r7 = 0;
        if (r6 == null) goto L17;
        int r8 = r6.intValue();
    L18:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "rect");
        EduClipImageRect r9 = r5.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "rectList");
        ((ArrayList) r9.g).clear();
        Iterator r10 = r3.iterator();
    L20:
        if (r10.hasNext() == false) goto L25;
        RectF r11 = (RectF) r10.next();
        EduClipImageRect.b r12 = r9.b;
        EduClipImageRect.a r13 = new EduClipImageRect.a(r12.e, r12.f, r12.g);
        r13.d.set(r11);
        r13.b(r9.a.d);
        RectF r14 = EduClipImageRect.b(r9, r13.e, true);
        if (Intrinsics.areEqual(r14, r13.e) == true) goto L24;
        r13.e.set(r14);
        Matrix r15 = r9.a.e;
        Intrinsics.checkNotNullParameter(r15, "invertMatrix");
        r15.mapRect(r13.d, r13.e);
    L24:
        ((ArrayList) r9.g).add(r13);
        goto L20
    L25:
        EduClipImageRect.a r16 = (EduClipImageRect.a) CollectionsKt.getOrNull(r9.g, r8);
        if (r16 != null) goto L28;
        r16 = (EduClipImageRect.a) CollectionsKt.firstOrNull(r9.g);
    L28:
        r9.f = r16;
        ((ArrayList) r5.h).clear();
        Iterator r17 = r3.iterator();
    L30:
        if (r17.hasNext() == false) goto L35;
        Object r18 = r17.next();
        int r19 = r7 + 1;
        if (r7 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        RectF r20 = (RectF) r18;
        List<e> r21 = r5.h;
        ArrayList r22 = (ArrayList) r21;
        r22.add(new e(r5.getContext(), String.valueOf(r19)));
        r7 = r19;
        goto L30
    L35:
        r5.f.c(true);
        r5.invalidate();
        return;
    L17:
        r8 = 0;
        goto L18
    L46:
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void t() {
        this.k = 200L;
    }

    @Override // nx8.m
    public final Bitmap e() {
        return this.n;
    }

    @Override // nx8.m
    public final View getView() {
        return this.e;
    }

    @Override // nx8.m
    public final StateFlowImpl i() {
        return this.h;
    }

    @Override // nx8.m
    public final g j(i r24) {
        EduQuestionSearchLogic r1 = this.d;
        List<Boolean> r2 = this.f.getClipModifyList();
        List<RectF> r3 = this.f.getAllClipRect();
        int r4 = this.f.getSelectIndex();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "userChangeBoxes");
        if (r24 != null) goto L5;
        i r5 = r1.a;
    L6:
        Integer r6 = Integer.valueOf(r4);
        if (r6.intValue() < 0) goto L9;
        boolean r7 = true;
    L10:
        String r10 = null;
        if (r7 == true) goto L14;
        r6 = null;
    L14:
        if (r6 != null) goto L21;
        kx8.c r8 = r1.h;
        if (r8 == null) goto L19;
        r6 = r8.c;
    L20:
        if (r6 != null) goto L21;
        int r9 = 0;
    L23:
        i.f r11 = i.f.d;
        if (Intrinsics.areEqual(r5, r11) == true) goto L26;
    L32:
        List<Boolean> r15 = r2;
        i.e r12 = i.e.d;
        if (Intrinsics.areEqual(r5, r12) == false) goto L36;
        List<j> r13 = r1.b(r3, null);
    L38:
        List<j> r17 = r13;
    L40:
        DetectionType r14 = r1.e(r5);
        if (r14 != DetectionType.MultiQuestion) goto L50;
        if (r17 != null) goto L44;
    L47:
        boolean r16 = true;
    L48:
        if (r16 == false) goto L50;
        Integer r18 = Integer.valueOf(DetectionType.SingleQuestion.getValue());
    L52:
        Integer r19 = r18;
    L54:
        kx8.c r20 = r1.h;
        if (r20 == null) goto L59;
        Long r21 = r20.a;
        if (r21 == null) goto L59;
        long r22 = r21.longValue();
    L60:
        Long r110 = Long.valueOf(r22);
        if (Intrinsics.areEqual(r1.a, i.b.d) == false) goto L63;
        Integer r111 = 1;
    L65:
        if (Intrinsics.areEqual(r5, r12) == true) goto L68;
        r4 = 0;
    L68:
        Integer r112 = Integer.valueOf(r4);
        SceneType r23 = r1.e;
        if (r23 == null) goto L71;
        Integer r113 = Integer.valueOf(r23.getValue());
    L72:
        String r25 = r1.f;
        if (r25 != null) goto L78;
        kx8.c r26 = r1.h;
        if (r26 == null) goto L77;
        r25 = r26.e;
        goto L78
    L77:
        String r27 = null;
    L79:
        kx8.c r28 = r1.h;
        if (r28 == null) goto L83;
        r10 = r28.f;
    L83:
        return new g("10400", r19, r110, r15, r111, r17, r112, r113, r27, r10, 5);
    L78:
        r27 = r25;
        goto L79
    L71:
        r113 = null;
        goto L72
    L63:
        r111 = null;
    L59:
        r22 = 0;
        goto L60
    L44:
        if (r17.isEmpty() == true) goto L47;
        r16 = false;
    L50:
        if (r14 == null) goto L53;
        r18 = Integer.valueOf(r14.getValue());
        goto L52
    L53:
        r19 = null;
        goto L54
    L36:
        if (Intrinsics.areEqual(r5, r11) == false) goto L39;
        r13 = r1.b(r3, Integer.valueOf(r9));
        goto L38
    L39:
        r17 = null;
        goto L40
    L26:
        if (Intrinsics.areEqual(r1.a, i.e.d) == false) goto L32;
        Boolean r29 = (Boolean) CollectionsKt.getOrNull(r2, r9);
        if (r29 == null) goto L30;
        boolean r30 = r29.booleanValue();
    L31:
        r2 = CollectionsKt.listOf(Boolean.valueOf(r30));
        goto L32
    L30:
        r30 = false;
        goto L31
    L19:
        r6 = null;
    L21:
        r9 = r6.intValue();
        goto L23
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = r24;
        goto L6
    }

    @Override // nx8.m
    public final void m(m.a r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.f.setClipRectChangeListener(r2);
    }

    @Override // nx8.m
    public final void n(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        this.d.e = r2;
    }

    public final void u(boolean r4) {
        FLogger.a.i("EduImageViewHolder", "updateDisplayedBitmap shouldShowCaptureOriginalImage=" + this.o);
        if (this.o == false) goto L5;
        Bitmap r0 = this.n;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0 == this.f.getOriginBitmap()) goto L18;
        if (r4 == false) goto L14;
        this.f.setImageBitmapAndReprepare$impl_mainlandRelease(r0);
    L15:
        this.f.invalidate();
        return;
    L14:
        this.f.setImageBitmap(r0);
        goto L15
    L18:
        return;
    L5:
        kx8.c r1 = this.d.c();
        if (r1 == null) goto L8;
        r0 = r1.h;
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    @Override // nx8.m
    public final void a(nx8.c r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "mode");
        i r0 = this.d.a;
        if (Intrinsics.areEqual(r6, nx8.c.b.a) == false) goto L6;
        i r8 = i.e.d;
    L11:
        EduQuestionSearchLogic r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.a = r8;
        this.o = r7;
        boolean r9 = false;
        u(false);
        EduClipImageView r2 = this.f;
        if (r8.b == 0) goto L14;
        boolean r3 = true;
    L15:
        r2.setEnableClipRect(r3);
        EduClipImageView r4 = this.f;
        if (r8.b != 2) goto L18;
        r9 = true;
    L18:
        r4.setMultiMode(r9);
        int r10 = this.j;
        if (r10 == 0) goto L29;
        boolean r11 = r8.a;
        if (r11 == r0.a) goto L30;
        if (r11 == false) goto L24;
        int r12 = r10 + this.i;
    L25:
        this.f.j(r12);
        return;
    L24:
        r12 = this.i;
        goto L25
    L30:
        return;
    L29:
        return;
    L14:
        r3 = false;
        goto L15
    L6:
        if (Intrinsics.areEqual(r6, nx8.c.a.a) == false) goto L9;
        r8 = i.g.d;
        goto L11
    L9:
        if (Intrinsics.areEqual(r6, nx8.c.C0123c.a) == false) goto L28;
        r8 = i.f.d;
        goto L11
    L28:
        throw new NoWhenBranchMatchedException();
    }

    @Override // nx8.m
    public final void c(int r4, boolean r5) {
        EduClipImageView r0 = this.f;
        int r6 = r4 + this.j;
        r0.getClass();
        int r7 = r6 % 360;
        if (r7 >= 0) goto L5;
        r7 = r7 + 360;
    L5:
        mx8.a r1 = r0.c;
        int r2 = ((int) r1.c) % 360;
        if (r2 >= 0) goto L8;
        r2 = r2 + 360;
    L8:
        int r8 = r7 - r2;
        if (r8 <= 180) goto L12;
        r8 = r8 - 360;
    L14:
        if (r8 == 0) goto L24;
        r0.o = true;
        if (r0.d == false) goto L19;
        return;
    L19:
        if (r1.a == true) goto L22;
        if (r5 == true) goto L25;
        int r9 = r0.j + r8;
        r0.j = r9;
        r1.c = r9 + r0.k;
        return;
    L25:
        return;
    L22:
        r0.j += r8;
        r0.o(r5, false);
        return;
    L24:
        return;
    L12:
        if (r8 >= (-180)) goto L14;
        r8 = r8 + 360;
        goto L14
    }

    @Override // nx8.m
    public final void f(int r4, int r5) {
        if (r4 <= 0) goto L4;
        this.p = r4;
    L4:
        if (r5 <= 0) goto L6;
        this.q = r5;
    L6:
        EduClipRectAnimateView r6 = this.g;
        if (r6 == null) goto L10;
        int r7 = this.p;
        int r0 = this.q;
        float r1 = r6.getResources().getDimension(2131167534);
        EduClipRectAnimateView.a r8 = r6.d;
        RectF r2 = r8.a;
        r2.right = r7;
        r2.bottom = r0;
        r8.b = r1;
        r8.c = r1;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.view.View, com.larus.camera.impl.edulibs.camera.internal.EduClipImageView] */
    public c(Context r10, i r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "eduImageScene");
        this.a = r12;
        this.b = com.larus.camera.impl.edulibs.camera.a.c;
        boolean r2 = true;
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = r3;
        if (r12 == null) goto L5;
        Object r4 = r12.get("need_question_detection");
    L7:
        if ((r4 instanceof Boolean) == false) goto L9;
        Boolean r5 = (Boolean) r4;
    L10:
        Boolean r6 = Boolean.TRUE;
        boolean r7 = Intrinsics.areEqual(r5, r6);
        if (r12 == null) goto L13;
        Object r13 = r12.get("need_dewarp");
    L15:
        if ((r13 instanceof Boolean) == false) goto L17;
        Boolean r14 = (Boolean) r13;
    L18:
        EduQuestionSearchLogic r0 = new EduQuestionSearchLogic(r11, r7, Intrinsics.areEqual(r14, r6));
        this.d = r0;
        FrameLayout r15 = new FrameLayout(r10);
        this.e = r15;
        ?? r16 = new EduClipImageView(r10, null, 2);
        this.f = r16;
        this.h = j1.a(f.c.b);
        this.m = "";
        this.p = r10.getResources().getDimensionPixelSize(2131167532);
        this.q = r10.getResources().getDimensionPixelSize(2131167531);
        r15.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        if (r0.a.b != 0) goto L22;
        r2 = false;
    L22:
        r16.setEnableClipRect(r2);
        EduClipRectAnimateView r17 = new EduClipRectAnimateView(r10, null);
        r17.a.setStrokeWidth(r17.getResources().getDimensionPixelSize(2131167535));
        r17.a.setColor(-1);
        this.g = r17;
        r15.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        r17.setVisibility(8);
        BuildersKt.launch$default(r3, null, null, new EduImageViewHolder$init$1(this, null), 3, null);
        return;
    L17:
        r14 = null;
        goto L18
    L13:
        r13 = null;
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    public static final Object r(final c r16, kx8.c r17, Continuation r18) {
        kx8.c r1 = r17;
        r16.getClass();
        if ((r18 instanceof EduImageViewHolder$onDetectComplete$1) == false) goto L7;
        EduImageViewHolder$onDetectComplete$1 r3 = (EduImageViewHolder$onDetectComplete$1) r18;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r8 = true;
        Long r9 = null;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L19;
        if (r6 == 4) goto L18;
        if (r6 == 5) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
    L121:
        return Unit.INSTANCE;
    L19:
        r1 = (kx8.c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L79:
        if (r1 == null) goto L87;
        List<kx8.b> r7 = r1.b;
        if (r7 == null) goto L87;
        Integer r10 = r1.c;
        if (r10 == null) goto L85;
        int r11 = r10.intValue();
    L86:
        kx8.b r12 = (kx8.b) CollectionsKt.getOrNull(r7, r11);
    L88:
        if (r12 == null) goto L90;
        RectF r13 = r12.a;
    L91:
        final EduClipRectAnimateView r14 = r16.g;
        if (r14 == null) goto L121;
        r14.setVisibility(0);
        r16.f.p(0.0f, 0.0f);
        if (r13 == null) goto L97;
        EduClipImageView r15 = r16.f;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r13, "originRect");
        RectF r19 = new RectF();
        r15.c.d.mapRect(r19, r13);
        r19.set(EduClipImageRect.b(r15.f, r19, true));
        RectF r20 = r19;
    L102:
        r16.b.d("EduImageViewHolder", "startClipRectAnimation: dstRect=" + r20);
        Long r21 = r16.k;
        if (r21 != null) goto L105;
    L112:
        long r22 = 300;
    L113:
        r14.setAnimateDuration(r22);
        Function2<? super Float, ? super EduClipRectAnimateView.a, Unit> r23 = new b(r16, r14);
        Intrinsics.checkNotNullParameter(r23, "block");
        r14.c = r23;
        float r0 = r14.getResources().getDimension(2131167533);
        EduClipRectAnimateView.a r24 = new EduClipRectAnimateView.a(r20, r0, r0);
        Intrinsics.checkNotNullParameter(r24, "dst");
        r14.e = r24;
        r14.b();
        goto L121
    L105:
        if (r21.longValue() > 0) goto L108;
        r8 = false;
    L108:
        if (r8 == false) goto L110;
        r9 = r21;
    L110:
        if (r9 == null) goto L112;
        r22 = r9.longValue();
        goto L113
    L97:
        if ((r16.i % 180) == 0) goto L99;
        boolean r25 = true;
    L100:
        r20 = r16.f.l(r16.p, r16.q, r25);
        goto L102
    L99:
        r25 = false;
        goto L100
    L90:
        r13 = null;
        goto L91
    L85:
        r11 = 0;
    L87:
        r12 = null;
        goto L88
    L20:
        r1 = (kx8.c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L69:
        i r26 = r16.d.a;
        if (r26.b == 0) goto L72;
        boolean r27 = true;
    L73:
        if (r27 == true) goto L75;
        r16.s();
        StateFlowImpl r28 = r16.h;
        f.a r29 = f.a.b;
        r3.L$0 = null;
        r3.label = 5;
        r28.setValue(r29);
        if (Unit.INSTANCE != r5) goto L121;
        return r5;
    L75:
        if (r26.c == false) goto L114;
        StateFlowImpl r30 = r16.h;
        f.b r31 = f.b.b;
        r3.L$0 = r1;
        r3.label = 3;
        r30.setValue(r31);
        if (Unit.INSTANCE != r5) goto L79;
        return r5;
    L114:
        r16.s();
        r16.f.setMultiMode(true);
        StateFlowImpl r32 = r16.h;
        f.a r33 = f.a.b;
        r3.L$0 = null;
        r3.label = 4;
        r32.setValue(r33);
        if (Unit.INSTANCE != r5) goto L121;
        return r5;
    L72:
        r27 = false;
        goto L73
    L21:
        r1 = (kx8.c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L57:
        EduClipImageView r34 = r16.f;
        r3.L$0 = r1;
        r3.label = 2;
        if (r34.c.a == true) goto L66;
        kotlinx.coroutines.j r35 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r3), 1);
        r35.C();
        r34.m = r35;
        Object r36 = r35.B();
        if (r36 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L63:
        if (r36 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r36 = Unit.INSTANCE;
    L67:
        if (r36 != r5) goto L69;
        return r5;
    L66:
        r36 = Unit.INSTANCE;
        goto L67
    L22:
        ResultKt.throwOnFailure(r2);
        if (r1 == null) goto L27;
        Bitmap r37 = r1.h;
        if (r37 == null) goto L27;
        FLogger.a.i("EduImageViewHolder", "clipQuestion dewarpBitmap width=" + r37.getWidth() + " height=" + r37.getHeight());
        r16.u(true);
    L27:
        com.larus.camera.impl.edulibs.camera.internal.b r38 = com.larus.camera.impl.edulibs.camera.internal.b.a;
        if (r1 == null) goto L30;
        Integer r39 = r1.d;
    L31:
        r38.getClass();
        int r40 = Orientation.Angle_180.getValue();
        if (r39 != null) goto L35;
    L37:
        int r41 = Orientation.Angle_90.getValue();
        if (r39 != null) goto L41;
    L43:
        int r42 = Orientation.Angle_270.getValue();
        if (r39 != null) goto L47;
    L49:
        int r43 = 0;
    L50:
        r16.j = r43;
        if (r43 == 0) goto L57;
        if (r16.d.a.a == false) goto L57;
        r16.f.j(r43 + r16.i);
        r3.L$0 = r1;
        r3.label = 1;
        if (DelayKt.delay(200, r3) != r5) goto L57;
        return r5;
    L47:
        if (r39.intValue() != r42) goto L49;
        r43 = 270;
        goto L50
    L41:
        if (r39.intValue() != r41) goto L43;
        r43 = 90;
        goto L50
    L35:
        if (r39.intValue() != r40) goto L37;
        r43 = 180;
        goto L50
    L30:
        r39 = null;
    L7:
        r3 = new EduImageViewHolder$onDetectComplete$1(r16, r18);
        goto L8
    }

    @Override // nx8.m
    public final void o(Bitmap r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "imageId");
        this.i = r12;
        this.m = r11;
        this.l = (IdentifyDetectionResult) ((LinkedHashMap) com.larus.camera.impl.edulibs.camera.a.e).get(r11);
        this.f.setScreenOrientationDegrees(r12);
        this.f.j(r12);
        this.b.i("EduImageViewHolder", "Bitmap: view rotate=" + r12);
        Matrix r6 = new Matrix();
        this.b.d("EduImageViewHolder", "rotateAndCompressBitmap: w=" + r10.getWidth() + ",h=" + r10.getHeight() + ",r=0.0");
        int r14 = Math.min(r10.getWidth(), r10.getHeight());
        float r15 = (float) r14;
        boolean r8 = false;
        if (r15 <= 720.0f) goto L5;
        float r1 = 720.0f / r15;
        this.b.d("EduImageViewHolder", "resizeBitmap scaleFactor " + r1 + " shortSide " + r14);
        r6.postScale(r1, r1);
        boolean r16 = true;
    L6:
        Boolean r17 = null;
        if (r16 == true) goto L39;
    L22:
        this.n = r10;
        this.f.setImageBitmap(r10);
        if (r13 == false) goto L34;
        EduQuestionSearchLogic r18 = this.d;
        IdentifyDetectionResult r19 = this.l;
        Map<String, Object> r0 = this.a;
        if (r0 == null) goto L27;
        Object r2 = r0.get("is_from_live_tutor");
    L29:
        if ((r2 instanceof Boolean) == false) goto L31;
        r17 = (Boolean) r2;
    L31:
        if (r17 == null) goto L33;
        r8 = r17.booleanValue();
    L33:
        r18.d(r10, r19, r8);
    L35:
        EduClipRectAnimateView r110 = this.g;
        if (r110 == null) goto L41;
        int r111 = this.p;
        int r112 = this.q;
        float r113 = r110.getResources().getDimension(2131167534);
        EduClipRectAnimateView.a r114 = r110.d;
        RectF r3 = r114.a;
        r3.right = r111;
        r3.bottom = r112;
        r114.b = r113;
        r114.c = r113;
        return;
    L41:
        return;
    L27:
        r2 = null;
        goto L29
    L34:
        this.h.setValue(f.a.b);
        goto L35
    L39:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L10
        Object r116 = Result.constructor-impl(Bitmap.createBitmap(r10, 0, 0, r10.getWidth(), r10.getHeight(), r6, true));     // Catch: Throwable -> L10
    L12:
        Throwable r4 = Result.exceptionOrNull-impl(r116);
        if (r4 == null) goto L16;
        this.b.e("EduImageViewHolder", "rotateAndCompressBitmap error", r4);
    L16:
        if (Result.isFailure-impl(r116) == false) goto L18;
        r116 = null;
    L18:
        Bitmap r117 = (Bitmap) r116;
        if (r117 == null) goto L22;
        r10 = r117;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r16 = false;
        goto L6
    }

    @Override // nx8.m
    public final nx8.b g(String r17, int r18, int r19, boolean r20, SceneType r21, String r22, String r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "sceneType");
        Bitmap r4 = null;
        Object r5 = null;
        r4 = null;
        r4 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        com.larus.camera.impl.edulibs.camera.internal.util.c.a.getClass();     // Catch: Throwable -> L9
        ox8.a r1 = (ox8.a) ((Gson) com.larus.camera.impl.edulibs.camera.internal.util.c.c.getValue()).fromJson(r17, ox8.a.class);     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        ox8.e r2 = ox8.b.a(r1);     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L15;
        this.b.e("EduImageViewHolder", "setServerClipResponse error", r6);
    L15:
        if (Result.isFailure-impl(r3) == false) goto L17;
        r3 = null;
    L17:
        ox8.e r7 = (ox8.e) r3;
        if (r7 == null) goto L20;
        kx8.c r8 = new kx8.c(null);
        boolean r13 = true;
        if (r24 == false) goto L45;
        String r9 = r7.e();
        if (r9 == null) goto L45;
        if (r9.length() <= 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == true) goto L32;
        r9 = null;
    L32:
        if (r9 == null) goto L45;
        Object r11 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.a.a(r9));     // Catch: Throwable -> L35
    L37:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L41;
        this.b.e("EduImageViewHolder", "setServerClipResponse decode dewarp image error", r12);
    L41:
        if (Result.isFailure-impl(r11) == true) goto L44;
        r5 = r11;
    L44:
        r4 = (Bitmap) r5;
    L35:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L28:
        r10 = false;
    L45:
        r8.h = r4;
        Bitmap r15 = this.f.getOriginBitmap();
        if (r4 == null) goto L49;
        FLogger.a.i("EduImageViewHolder", "setServerClipResponse dewarpBitmap width=" + r4.getWidth() + " height=" + r4.getHeight());
        com.larus.camera.impl.edulibs.camera.internal.b r16 = com.larus.camera.impl.edulibs.camera.internal.b.a;
        ox8.e r25 = ox8.e.a(r7, 0, null, null, null, 16319);
        int r26 = r4.getWidth();
        int r27 = r4.getHeight();
        r16.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r8, r25, 1.0f, r26, r27);
    L54:
        r8.f = r23;
        List<kx8.b> r28 = r8.b;
        if (r28 == null) goto L57;
        int r29 = r28.size();
    L58:
        if (r29 > 1) goto L62;
        r13 = false;
    L62:
        if (r20 == false) goto L65;
        if (r13 == false) goto L65;
        EduQuestionSearchLogic r30 = this.d;
        i.e r31 = i.e.d;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r30.a = r31;
    L66:
        EduQuestionSearchLogic r32 = this.d;
        r32.e = r21;
        r32.f = r22;
        Intrinsics.checkNotNullParameter(r8, "resp");
        r32.h = r8;
        r32.g.setValue(new com.larus.camera.impl.edulibs.camera.internal.e.a(r8));
        if (r13 == false) goto L70;
        return nx8.b.a.a;
    L70:
        return nx8.b.C0122b.a;
    L65:
        EduQuestionSearchLogic r33 = this.d;
        i.f r34 = i.f.d;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r33.a = r34;
        goto L66
    L57:
        r29 = 0;
        goto L58
    L49:
        if (r15 != null) goto L51;
    L53:
        com.larus.camera.impl.edulibs.camera.internal.b.a.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r8, r7, 1.0f, r18, r19);
        goto L54
    L51:
        if (r15.getWidth() <= 0) goto L53;
        float r35 = r18 / r15.getWidth();
        com.larus.camera.impl.edulibs.camera.internal.b r36 = com.larus.camera.impl.edulibs.camera.internal.b.a;
        int r37 = r15.getWidth();
        int r38 = r15.getHeight();
        r36.getClass();
        com.larus.camera.impl.edulibs.camera.internal.b.b(r8, r7, r35, r37, r38);
        goto L54
    L20:
        return nx8.b.c.a;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
