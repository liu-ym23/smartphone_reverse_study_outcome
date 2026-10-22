package com.bytedance.ai.uiu;

import android.webkit.WebView;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.p;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.f;
import com.bytedance.ai.widget.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.e2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2827a = 0;

    public static final ConversionScene a() {
        LinkedHashMap r5 = p.f2293b;
        com.bytedance.ai.model.widgets.a r10 = p.b();
        o r11 = o.f3079j.a();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        HashMap r12 = r11.e;
        if (r10 == null) goto L7;
        PageInfo r13 = r10.f2330b;
        if (r13 == null) goto L7;
        PageType r14 = r13.getPageType();
    L9:
        if (r14 != PageType.FLOATING_VIEW) goto L11;
        boolean r15 = true;
    L13:
        if (r5.isEmpty() == true) goto L15;
        if (r15 == false) goto L26;
        if (r12.isEmpty() == true) goto L26;
        return ConversionScene.SCENE_WIDGETS;
    L26:
        if (r15 == false) goto L46;
        Map.Entry r16 = (Map.Entry) CollectionsKt.k(r5.entrySet(), r5.size() - 2);
        if (r16 == null) goto L45;
        com.bytedance.ai.model.widgets.a r17 = (com.bytedance.ai.model.widgets.a) r16.getValue();
        if (r17 == null) goto L45;
        PageInfo r18 = r17.f2330b;
        if (r18 == null) goto L45;
        PageType r19 = r18.getPageType();
        if (r19 == null) goto L45;
        int r20 = e.f2830a[r19.ordinal()];
        if (r20 == 1) goto L40;
        if (r20 == 2) goto L39;
        ConversionScene r21 = ConversionScene.SCENE_UNKNOWN;
    L41:
        if (r21 == null) goto L45;
        return r21;
    L39:
        r21 = ConversionScene.SCENE_POPUP;
        goto L41
    L40:
        r21 = ConversionScene.SCENE_FULL_PAGE;
    L45:
        return ConversionScene.SCENE_UNKNOWN;
    L46:
        if (r10 == null) goto L61;
        PageInfo r22 = r10.f2330b;
        if (r22 == null) goto L61;
        PageType r23 = r22.getPageType();
        if (r23 == null) goto L61;
        int r24 = e.f2830a[r23.ordinal()];
        if (r24 == 1) goto L56;
        if (r24 == 2) goto L55;
        ConversionScene r25 = ConversionScene.SCENE_UNKNOWN;
    L57:
        if (r25 == null) goto L61;
        return r25;
    L55:
        r25 = ConversionScene.SCENE_POPUP;
        goto L57
    L56:
        r25 = ConversionScene.SCENE_FULL_PAGE;
    L61:
        return ConversionScene.SCENE_UNKNOWN;
    L15:
        if (r12.isEmpty() == true) goto L19;
        return ConversionScene.SCENE_WIDGETS;
    L19:
        return ConversionScene.SCENE_UNKNOWN;
    L11:
        r15 = false;
    L7:
        r14 = null;
        goto L9
    }

    public static final Object b(WebView r5, List r10, ContinuationImpl r11) {
        if ((r11 instanceof UIUContextManager$performUIOperations$3) == false) goto L7;
        UIUContextManager$performUIOperations$3 r12 = (UIUContextManager$performUIOperations$3) r11;
        int r13 = r12.f2817b;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f2817b = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2816a;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.f2817b;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        Boolean r17 = (Boolean) r14;
        if (r17 == null) goto L20;
        boolean r18 = r17.booleanValue();
    L22:
        return Boxing.boxBoolean(r18);
    L20:
        r18 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        UIUContextManager$performUIOperations$4 r19 = new UIUContextManager$performUIOperations$4(r5, r10, null);
        r12.f2817b = 1;
        r14 = e2.b(1000, r19, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new UIUContextManager$performUIOperations$3(r11);
        goto L8
    }

    public static final Object c(w0.e r5, ContinuationImpl r10) {
        if ((r10 instanceof UIUContextManager$getPageUIContext$1) == false) goto L7;
        UIUContextManager$getPageUIContext$1 r11 = (UIUContextManager$getPageUIContext$1) r10;
        int r12 = r11.f2795b;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f2795b = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f2794a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f2795b;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        String r16 = (String) r13;
        if (r16 != null) goto L21;
        return "";
    L21:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        UIUContextManager$getPageUIContext$2 r17 = new UIUContextManager$getPageUIContext$2(r5, null);
        r11.f2795b = 1;
        r13 = e2.b(1000, r17, r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new UIUContextManager$getPageUIContext$1(r10);
        goto L8
    }

    public static final String d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonString");
        return StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(r5, "\\", "\\\\"), "\"", "\\\""), "\n", "\\n"), "\r", "\\r"), Profiler.DATA_SEP, "\\t");
    }

    public static final Set e(ConversionScene r10, PageSetting r11) {
        if (r11 != PageSetting.LAST_PAGE) goto L5;
        com.bytedance.ai.model.widgets.a r5 = p.b();
    L7:
        if (r11 != PageSetting.ALL_PAGE) goto L9;
        boolean r12 = true;
    L10:
        int r13 = a.f2824a[r10.ordinal()];
        if (r13 != 1) goto L13;
        Set r14 = SetsKt.setOf(new PageType[]{PageType.FULL_PAGE, PageType.FLOATING_VIEW});
    L24:
        LinkedHashMap r15 = p.f2293b;
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r15.entrySet().iterator();
    L26:
        if (r17.hasNext() == false) goto L39;
        Map.Entry r18 = (Map.Entry) r17.next();
        com.bytedance.ai.model.widgets.a r19 = (com.bytedance.ai.model.widgets.a) r18.getValue();
        if (r14.contains(r19.f2330b.getPageType()) == false) goto L26;
        if (r12 == true) goto L38;
        String r20 = r19.f2330b.getPageId();
        if (r5 == null) goto L35;
        PageInfo r21 = r5.f2330b;
        if (r21 == null) goto L35;
        String r22 = r21.getPageId();
    L37:
        if (Intrinsics.areEqual(r20, r22) == false) goto L26;
    L35:
        r22 = null;
    L38:
        r16.put(r18.getKey(), r18.getValue());
        goto L26
    L39:
        o r23 = o.f3079j.a();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        HashMap r24 = r23.e;
        if (r11 != PageSetting.LAST_PAGE) goto L42;
        f r25 = (f) CollectionsKt.firstOrNull(r24.keySet());
    L43:
        LinkedHashMap r26 = new LinkedHashMap();
        Iterator r27 = r24.entrySet().iterator();
    L45:
        if (r27.hasNext() == false) goto L57;
        Map.Entry r28 = (Map.Entry) r27.next();
        f r29 = (f) r28.getKey();
        if (r14.contains(PageType.WIDGET_PAGE) == false) goto L45;
        if (r12 == true) goto L55;
        String r30 = ((WidgetContainer) r29).e;
        if (r25 == null) goto L52;
        String r31 = ((WidgetContainer) r25).e;
    L54:
        if (Intrinsics.areEqual(r30, r31) == false) goto L45;
    L52:
        r31 = null;
    L55:
        r26.put(r28.getKey(), r28.getValue());
        goto L45
    L57:
        return CollectionsKt.union(r16.values(), r26.keySet());
    L42:
        r25 = null;
        goto L43
    L13:
        if (r13 != 2) goto L15;
        r14 = SetsKt.setOf(new PageType[]{PageType.WIDGET_PAGE, PageType.FLOATING_VIEW});
        goto L24
    L15:
        if (r13 == 3) goto L21;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r32 = com.bytedance.ai.utils.c.f2846a;
        if (r32 == null) goto L20;
        r32.d("com.bytedance.ai.uiu.c", "Get none pages for current conversation scene");
    L20:
        return SetsKt.emptySet();
    L21:
        r14 = SetsKt.setOf(new PageType[]{PageType.POPUP_PAGE, PageType.FLOATING_VIEW});
        goto L24
    L9:
        r12 = false;
        goto L10
    L5:
        r5 = null;
        goto L7
    }
}
