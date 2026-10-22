package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceAdapterUpdatePlanner;", "", "<init>", "()V", "changedPositions", "", "", "previousPage", "Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "previousState", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "page", "state", "focusOptionId", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6768a = null;

    static {
        f6768a = new d();
    }

    private d() {
    }

    public final List<Integer> a(o r9, j r10, o r11, j r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "page");
        Intrinsics.checkNotNullParameter(r12, "state");
        if (r9 == null) goto L34;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r9, r11) == false) goto L36;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r11.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
        int r2 = 0;
    L10:
        if (r16.hasNext() == false) goto L30;
        Object r3 = r16.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        m r5 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        if (r10.c(r5.a()) == r12.c(r5.a())) goto L17;
        boolean r6 = true;
    L18:
        boolean r8 = Intrinsics.areEqual(r5.a(), r13);
        Integer r17 = Integer.valueOf(r2);
        ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6 == true) goto L23;
        if (r8 == true) goto L23;
        r7 = false;
    L23:
        if (r7 == true) goto L26;
        r17 = null;
    L26:
        if (r17 == null) goto L28;
        r15.add(r17);
    L28:
        r2 = r4;
        goto L10
    L17:
        r6 = false;
        goto L18
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    L36:
        return null;
    L34:
        return null;
    }
}
