package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 implements InputPanelSectionContainer.c {
    public final /* synthetic */ d1.c a;

    public e1(d1.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer.c
    public final void a(InputSectionType r6, InputSectionType r7) {
        Intrinsics.checkNotNullParameter(r6, "previousType");
        Intrinsics.checkNotNullParameter(r7, "currentSectionType");
        d1.c r8 = this.a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r0 = r8.h;
        if (r0 == null) goto L22;
        Intrinsics.checkNotNullParameter(r7, "sectionType");
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r1 = r0.a.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r2 = r1.next();
        if (r2.getValue().l() != r7) goto L6;
        InputFunctionEnum r9 = r2.getKey();
    L23:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r3 = r8.h;
        if (r3 == null) goto L44;
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r4 = r3.a.entrySet().iterator();
    L27:
        if (r4.hasNext() == false) goto L31;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r5 = r4.next();
        if (r5.getKey() != r9) goto L27;
        r5.getValue().j();
        goto L27
    L31:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r10 = r3.b.entrySet().iterator();
    L33:
        if (r10.hasNext() == false) goto L37;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r11 = r10.next();
        if (r11.getKey() != r9) goto L33;
        r11.getValue().j();
        goto L33
    L37:
        Iterator r13 = ((LinkedHashMap) r3.c).entrySet().iterator();
    L39:
        if (r13.hasNext() == false) goto L43;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (((InputFunctionEnum) r14.getKey()) != r9) goto L39;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r14.getValue()).j();
        goto L39
    L43:
        r3.a();
    L44:
        int r15 = r8.f.getChildCount();
        int r16 = 0;
    L45:
        if (r16 >= r15) goto L54;
        View r17 = r8.f.getChildAt(r16);
        if (r17 == null) goto L53;
        if (r9 != r17.getTag()) goto L51;
        boolean r18 = true;
    L52:
        r17.setSelected(r18);
        goto L53
    L51:
        r18 = false;
    L53:
        r16 = r16 + 1;
        goto L45
    L54:
        return;
    L10:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r19 = r0.b.entrySet().iterator();
    L12:
        if (r19.hasNext() == false) goto L16;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r20 = r19.next();
        if (r20.getValue().l() != r7) goto L12;
        r9 = r20.getKey();
        goto L23
    L16:
        Iterator r21 = ((LinkedHashMap) r0.c).entrySet().iterator();
    L18:
        if (r21.hasNext() == false) goto L22;
        Map.Entry r23 = (Map.Entry) r21.next();
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r23.getValue()).l() != r7) goto L18;
        r9 = (InputFunctionEnum) r23.getKey();
    L22:
        r9 = null;
        goto L23
    }
}
