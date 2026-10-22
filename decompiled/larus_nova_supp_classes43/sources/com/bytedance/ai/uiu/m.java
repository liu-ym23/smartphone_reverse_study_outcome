package com.bytedance.ai.uiu;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.widget.WidgetManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageType.values().length];
            r0[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final ConversionScene a() {
        AppletRuntimeManager.INSTANCE.getClass();
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r0 = AppletRuntimeManager.b;
        com.bytedance.ai.model.widgets.c r1 = AppletRuntimeManager.c();
        WidgetManager r10 = WidgetManager.h.b();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        HashMap<com.bytedance.ai.widget.contianer.h, WidgetManager.b> r11 = r10.a;
        if (r1 == null) goto L7;
        PageInfo r12 = r1.getPageInfo();
        if (r12 == null) goto L7;
        PageType r13 = r12.getPageType();
    L9:
        if (r13 != PageType.FLOATING_VIEW) goto L11;
        boolean r14 = true;
    L13:
        if (r0.isEmpty() == true) goto L15;
        if (r14 == false) goto L23;
        if ((!r11.isEmpty()) == false) goto L23;
        return ConversionScene.SCENE_WIDGETS;
    L23:
        if (r14 == false) goto L40;
        Map.Entry r15 = (Map.Entry) CollectionsKt.elementAtOrNull(r0.entrySet(), r0.size() - 2);
        if (r15 == null) goto L58;
        com.bytedance.ai.model.widgets.c r16 = (com.bytedance.ai.model.widgets.c) r15.getValue();
        if (r16 == null) goto L58;
        PageInfo r17 = r16.getPageInfo();
        if (r17 == null) goto L58;
        PageType r18 = r17.getPageType();
        if (r18 == null) goto L58;
        int r19 = a.a[r18.ordinal()];
        if (r19 == 1) goto L37;
        if (r19 == 2) goto L36;
        ConversionScene r20 = ConversionScene.SCENE_UNKNOWN;
    L38:
        if (r20 == null) goto L58;
        return r20;
    L36:
        r20 = ConversionScene.SCENE_POPUP;
        goto L38
    L37:
        r20 = ConversionScene.SCENE_FULL_PAGE;
    L58:
        return ConversionScene.SCENE_UNKNOWN;
    L40:
        if (r1 == null) goto L53;
        PageInfo r21 = r1.getPageInfo();
        if (r21 == null) goto L53;
        PageType r22 = r21.getPageType();
        if (r22 == null) goto L53;
        int r23 = a.a[r22.ordinal()];
        if (r23 == 1) goto L50;
        if (r23 == 2) goto L49;
        ConversionScene r24 = ConversionScene.SCENE_UNKNOWN;
    L51:
        if (r24 == null) goto L53;
        return r24;
    L49:
        r24 = ConversionScene.SCENE_POPUP;
        goto L51
    L50:
        r24 = ConversionScene.SCENE_FULL_PAGE;
    L53:
        return ConversionScene.SCENE_UNKNOWN;
    L15:
        if ((!r11.isEmpty()) == false) goto L55;
        return ConversionScene.SCENE_WIDGETS;
    L55:
        return ConversionScene.SCENE_UNKNOWN;
    L11:
        r14 = false;
    L7:
        r13 = null;
        goto L9
    }
}
