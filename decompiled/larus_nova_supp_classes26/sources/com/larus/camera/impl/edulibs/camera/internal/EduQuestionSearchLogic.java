package com.larus.camera.impl.edulibs.camera.internal;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import nx8.i;
import nx8.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class EduQuestionSearchLogic {
    public i a;
    public final boolean b;
    public final boolean c;
    public final CoroutineScope d;
    public SceneType e;
    public String f;
    public final StateFlowImpl g;
    public kx8.c h;

    public static final class a {
    }

    static {
    }

    public final kx8.c c() {
        Object r0 = this.g.getValue();
        if ((r0 instanceof e.a) == false) goto L5;
        e.a r1 = (e.a) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    public final DetectionType e(i r3) {
        if (Intrinsics.areEqual(r3, i.d.d) == false) goto L6;
        return DetectionType.MetalCalc;
    L6:
        if (Intrinsics.areEqual(r3, i.f.d) == false) goto L9;
        return DetectionType.SingleQuestion;
    L9:
        if (Intrinsics.areEqual(r3, i.e.d) == false) goto L12;
        return DetectionType.MultiQuestion;
    L12:
        if (Intrinsics.areEqual(r3, i.c.d) == true) goto L14;
        Intrinsics.areEqual(r3, i.b.d);
    L18:
        return null;
    L14:
        if (this.b == false) goto L18;
        return DetectionType.MultiQuestion;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.camera.impl.edulibs.camera.internal.d] */
    public final List<j> b(List<? extends RectF> r5, Integer r6) {
        final ArrayList r0 = new ArrayList();
        Object r1 = this.g.getValue();
        final kx8.c r3 = null;
        if ((r1 instanceof e.a) == false) goto L5;
        e.a r2 = (e.a) r1;
    L6:
        if (r2 == null) goto L8;
        r3 = r2.a;
    L8:
        ?? r4 = new d(r3, r0);
        if (r6 == null) goto L14;
        if (r5 == null) goto L22;
        RectF r7 = (RectF) CollectionsKt.getOrNull(r5, r6.intValue());
        if (r7 == null) goto L22;
        ((Boolean) r4.invoke(r6, r7)).booleanValue();
    L22:
        return r0;
    L14:
        if (r5 == null) goto L22;
        Iterator<T> r8 = r5.iterator();
        int r9 = 0;
    L17:
        if (r8.hasNext() == false) goto L22;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r4.invoke(Integer.valueOf(r9), (RectF) r10);
        r9 = r11;
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public EduQuestionSearchLogic(i r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.g = j1.a(e.b.a);
    }

    public final void d(Bitmap r11, IdentifyDetectionResult r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "bitmap");
        BuildersKt.launch$default(this.d, null, null, new EduQuestionSearchLogic$requestServer$1(this, r13, r11, r12, null), 3, null);
    }

    public static final void a(EduQuestionSearchLogic r2, long r3, boolean r5, String r6) {
        r2.getClass();
        nx8.a r4 = com.larus.camera.impl.edulibs.camera.a.d;
        if (r4 == null) goto L7;
        JSONObject r0 = new JSONObject();
        r0.put("cost_time", r3);
        JSONObject r7 = new JSONObject();
        r7.put("success", r5 ? 1 : 0);
        r7.put("error_des", r6);
        r4.a("edu_cropping_question", r7, r0);
        return;
    }
}
