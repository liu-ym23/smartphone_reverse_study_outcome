package k2;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.widgets.LynxEngineAssem;
import com.bytedance.ai.model.widgets.LynxViewFloatingPage;
import com.bytedance.ai.model.widgets.WebEngineAssem;
import com.bytedance.ai.model.widgets.WebViewFloatingPageV2;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static final void c(com.bytedance.ai.model.widgets.c r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof com.bytedance.ai.model.widgets.f) == false) goto L5;
        com.bytedance.ai.model.widgets.f r0 = (com.bytedance.ai.model.widgets.f) r10;
    L6:
        if (r0 == null) goto L16;
        String r1 = r10.getRenderType();
        if (Intrinsics.areEqual(r1, RenderType.WEBVIEW.getTypeName()) == false) goto L11;
        KClass<?> r11 = Reflection.getOrCreateKotlinClass(WebEngineAssem.class);
    L13:
        r0.setRenderClass(r11);
        return;
    L11:
        if (Intrinsics.areEqual(r1, RenderType.LYNX.getTypeName()) == false) goto L15;
        r11 = Reflection.getOrCreateKotlinClass(LynxEngineAssem.class);
        goto L13
    L15:
        throw new IllegalStateException("Don't support this renderType " + r10.getRenderType() + " yet");
    L16:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final com.bytedance.ai.model.widgets.c a(AppletRuntime r10, PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        if (r11.getPageType() != PageType.FLOATING_VIEW) goto L12;
        String r12 = b(r10.h, r11);
        i2.j r13 = i2.i.a;
        i2.i.a.a().getClass();
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        Intrinsics.checkNotNullParameter(r12, "renderType");
        if (Intrinsics.areEqual(r12, RenderType.LYNX.getTypeName()) == false) goto L8;
        return new LynxViewFloatingPage(r10, r11);
    L8:
        if (Intrinsics.areEqual(r12, RenderType.WEBVIEW.getTypeName()) == true) goto L14;
        return null;
    L14:
        return new WebViewFloatingPageV2(r10, r11);
    L12:
        return new com.bytedance.ai.model.widgets.f(r10, r11);
    }

    public static final String b(Applet r10, PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "applet");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        List<Page> r0 = r10.L;
        Page r1 = null;
        Object r12 = null;
        if (r0 == null) goto L11;
        Iterator<T> r13 = r0.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((Page) r14).pageId(), r11.getPageName()) == false) goto L6;
        r12 = r14;
    L10:
        r1 = (Page) r12;
    L11:
        if (r1 == null) goto L15;
        String r15 = r1.getRenderType();
        if (r15 == null) goto L15;
        return r15;
    L15:
        return r10.o;
    }
}
