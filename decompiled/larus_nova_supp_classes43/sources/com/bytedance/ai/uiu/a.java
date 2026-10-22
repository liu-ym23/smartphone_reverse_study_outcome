package com.bytedance.ai.uiu;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final String b = null;

    /* JADX INFO: renamed from: com.bytedance.ai.uiu.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0049a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ConversionScene.values().length];
            r0[ConversionScene.SCENE_FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ConversionScene.SCENE_WIDGETS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ConversionScene.SCENE_POPUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a r0 = new a();
        a = r0;
        b = r0.getClass().getName();
    }

    public static final WebView c(k2.i r10) {
        if ((r10 instanceof WidgetContainer) == false) goto L8;
        View r11 = ((WidgetContainer) r10).engineView();
        if ((r11 instanceof WebView) == true) goto L14;
        return null;
    L14:
        return (WebView) r11;
    L8:
        if ((r10 instanceof k2.j) == false) goto L15;
        View r12 = r10.engineView();
        if ((r12 instanceof WebView) == true) goto L12;
        return null;
    L12:
        return (WebView) r12;
    L15:
        return null;
    }

    public static final Set b(ConversionScene r10, PageSetting r11) {
        if (r11 != PageSetting.LAST_PAGE) goto L5;
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r0 = AppletRuntimeManager.c();
    L7:
        if (r11 != PageSetting.ALL_PAGE) goto L9;
        boolean r12 = true;
    L10:
        int r13 = C0049a.a[r10.ordinal()];
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L14;
        Set r14 = SetsKt.setOf(new PageType[]{PageType.WIDGET_PAGE, PageType.FLOATING_VIEW});
    L19:
        AppletRuntimeManager.INSTANCE.getClass();
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r15 = AppletRuntimeManager.b;
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator<Map.Entry<String, com.bytedance.ai.model.widgets.c>> r17 = r15.entrySet().iterator();
    L21:
        if (r17.hasNext() == false) goto L37;
        Map.Entry<String, com.bytedance.ai.model.widgets.c> r18 = r17.next();
        com.bytedance.ai.model.widgets.c r19 = r18.getValue();
        if (r14.contains(r19.getPageInfo().getPageType()) == false) goto L34;
        if (r12 == true) goto L33;
        String r20 = r19.getPageInfo().getPageId();
        if (r0 == null) goto L30;
        PageInfo r21 = r0.getPageInfo();
        if (r21 == null) goto L30;
        String r22 = r21.getPageId();
    L32:
        if (Intrinsics.areEqual(r20, r22) == false) goto L34;
    L30:
        r22 = null;
    L33:
        boolean r23 = true;
    L35:
        if (r23 == false) goto L21;
        r16.put(r18.getKey(), r18.getValue());
    L34:
        r23 = false;
        goto L35
    L37:
        WidgetManager r1 = WidgetManager.h.b();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        HashMap<com.bytedance.ai.widget.contianer.h, WidgetManager.b> r24 = r1.a;
        if (r11 != PageSetting.LAST_PAGE) goto L40;
        com.bytedance.ai.widget.contianer.h r110 = (com.bytedance.ai.widget.contianer.h) CollectionsKt.firstOrNull(r24.keySet());
    L41:
        LinkedHashMap r25 = new LinkedHashMap();
        Iterator<Map.Entry<com.bytedance.ai.widget.contianer.h, WidgetManager.b>> r26 = r24.entrySet().iterator();
    L43:
        if (r26.hasNext() == false) goto L58;
        Map.Entry<com.bytedance.ai.widget.contianer.h, WidgetManager.b> r27 = r26.next();
        com.bytedance.ai.widget.contianer.h r28 = r27.getKey();
        if (r14.contains(PageType.WIDGET_PAGE) == false) goto L54;
        if (r12 == true) goto L53;
        String r29 = r28.j();
        if (r110 == null) goto L50;
        String r30 = r110.j();
    L52:
        if (Intrinsics.areEqual(r29, r30) == false) goto L54;
    L50:
        r30 = null;
    L53:
        boolean r31 = true;
    L55:
        if (r31 == false) goto L43;
        r25.put(r27.getKey(), r27.getValue());
    L54:
        r31 = false;
        goto L55
    L58:
        return CollectionsKt.union(r16.values(), r25.keySet());
    L40:
        r110 = null;
        goto L41
    L14:
        if (r13 == 3) goto L16;
        com.bytedance.ai.utils.g.a.d(b, "Get none pages for current conversation scene");
        return SetsKt.emptySet();
    L16:
        r14 = SetsKt.setOf(new PageType[]{PageType.POPUP_PAGE, PageType.FLOATING_VIEW});
        goto L19
    L18:
        r14 = SetsKt.setOf(new PageType[]{PageType.FULL_PAGE, PageType.FLOATING_VIEW});
        goto L19
    L9:
        r12 = false;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    public static void f(String r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "cardId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$2(r11, r10, null), 3, null);
    }

    public static final Object a(a r10, k2.i r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof UIUContextManager$getPageUIContext$1) == false) goto L7;
        UIUContextManager$getPageUIContext$1 r0 = (UIUContextManager$getPageUIContext$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        String r16 = (String) r13;
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        UIUContextManager$getPageUIContext$2 r17 = new UIUContextManager$getPageUIContext$2(r11, null);
        r0.label = 1;
        r13 = TimeoutKt.c(1000, r17, r0);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r0 = new UIUContextManager$getPageUIContext$1(r10, r12);
        goto L8
    }

    public static void e(ConversionScene r10, PageSetting r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "csvScene");
        Intrinsics.checkNotNullParameter(r11, "pageSetting");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$1(r10, r11, r12, null), 3, null);
    }

    public static void g(String r10, List r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "cardId");
        Intrinsics.checkNotNullParameter(r11, "uiOperations");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$performUIOperations$2(r12, r10, r11, null), 3, null);
    }

    public static final Object d(a r10, WebView r11, List r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof UIUContextManager$performUIOperations$3) == false) goto L7;
        UIUContextManager$performUIOperations$3 r0 = (UIUContextManager$performUIOperations$3) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
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
        UIUContextManager$performUIOperations$4 r19 = new UIUContextManager$performUIOperations$4(r11, r12, null);
        r0.label = 1;
        r14 = TimeoutKt.c(1000, r19, r0);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r0 = new UIUContextManager$performUIOperations$3(r10, r13);
        goto L8
    }
}
