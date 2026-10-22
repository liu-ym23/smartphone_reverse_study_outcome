package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.p;
import com.ss.android.ainote.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements v0 {
    public final /* synthetic */ MmRecordingAINoteRepo a;
    public final /* synthetic */ Function1<List<e>, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(MmRecordingAINoteRepo r1, Function1<? super List<e>, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(com.ss.android.ainote.d r6, AINoteScene r7, List<p> r8) {
        Intrinsics.checkNotNullParameter(r6, "bizIds");
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r8, "notes");
        MmRecordingAINoteRepo r9 = this.a;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L39;
        p r0 = (p) r11.next();
        AINoteType r2 = r0.e;
        r9.getClass();
        if (r2 != AINoteType.FISH_BONE_TEXT) goto L8;
    L11:
        boolean r3 = true;
    L12:
        e r4 = null;
        if (r3 == false) goto L36;
        String r5 = r0.j;
        if (r5 == null) goto L36;
        if ((true ^ StringsKt.isBlank(r5)) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L36;
        if (r0.i == false) goto L26;
        r9.u.remove(r5);
    L28:
        if (r0.i == false) goto L30;
        String r1 = "delete";
    L32:
        if (r0.e != AINoteType.FISH_BONE_CHART) goto L34;
        String r12 = "chart";
    L35:
        r4 = new e(r1, r12, r5);
        goto L36
    L34:
        r12 = "text";
        goto L35
    L30:
        r1 = "mark";
        goto L32
    L26:
        r9.u.put(r5, r0.e);
    L36:
        if (r4 == null) goto L4;
        r10.add(r4);
        goto L4
    L8:
        if (r2 == AINoteType.FISH_BONE_CHART) goto L11;
        r3 = false;
        goto L12
    L39:
        if ((!r10.isEmpty()) == false) goto L47;
        lvb.a.e(this.a.w, "[onSubtitleFishBoneNotesChanged] syncPayloads=" + r10);
        this.b.invoke(r10);
        return;
    }
}
