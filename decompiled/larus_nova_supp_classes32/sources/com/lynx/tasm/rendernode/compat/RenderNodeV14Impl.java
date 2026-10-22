package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.DisplayList;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class RenderNodeV14Impl extends RenderNodeCompat {
    private static Method sDrawDisplayListMethod;
    private static Method sEndMethod;
    private static Method sIsValidMethod;
    private static Method sOnPostDrawMethod;
    private static Method sOnPreDrawMethod;
    private static Method sSetViewportMethod;
    private static Method sStartMethod;
    int bottom;
    DisplayList displayList;
    int height;
    int left;
    int right;
    Constructor<?> sGLESConstructor;
    int top;
    int width;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sIsValidMethod != null) goto L5;
        Method r0 = DisplayList.class.getDeclaredMethod("isValid", new Class[0]);     // Catch: Exception -> L7
        sIsValidMethod = r0;     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return ((Boolean) sIsValidMethod.invoke(this.displayList, new Object[0])).booleanValue();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.sGLESConstructor != null) goto L5;
        Constructor<?> r0 = INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV14Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.GLES20DisplayList").getConstructor(new Class[0]);     // Catch: Exception -> L7
        this.sGLESConstructor = r0;     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
    L5:
        this.displayList = (DisplayList) this.sGLESConstructor.newInstance(new Object[0]);     // Catch: Exception -> L7
    }

    public RenderNodeV14Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.displayList;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV14Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r2) {
        drawRenderNode(r2, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r6) {
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sOnPostDrawMethod != null) goto L5;
        Method r0 = Canvas.class.getDeclaredMethod("onPostDraw", new Class[0]);     // Catch: Exception -> L14
        sOnPostDrawMethod = r0;     // Catch: Exception -> L14
        r0.setAccessible(true);     // Catch: Exception -> L14
    L5:
        sOnPostDrawMethod.invoke(r6, new Object[0]);     // Catch: Exception -> L14
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        if (sEndMethod != null) goto L9;
        Method r7 = DisplayList.class.getDeclaredMethod("end", new Class[0]);     // Catch: Exception -> L11
        sEndMethod = r7;     // Catch: Exception -> L11
        r7.setAccessible(true);     // Catch: Exception -> L11
    L9:
        sEndMethod.invoke(this.displayList, new Object[0]);     // Catch: Exception -> L11
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r6, int r7) {
        this.width = r6;
        this.height = r7;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (sStartMethod != null) goto L6;
        Method r0 = DisplayList.class.getDeclaredMethod("start", new Class[0]);     // Catch: Exception -> L16
        sStartMethod = r0;     // Catch: Exception -> L16
        r0.setAccessible(true);     // Catch: Exception -> L16
    L6:
        Canvas r1 = (Canvas) sStartMethod.invoke(this.displayList, new Object[0]);     // Catch: Exception -> L16
        setViewport(r6, r7, r1);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        if (sOnPreDrawMethod != null) goto L11;
        Method r8 = Canvas.class.getDeclaredMethod("onPreDraw", new Class[]{Rect.class});     // Catch: Exception -> L13
        sOnPreDrawMethod = r8;     // Catch: Exception -> L13
        r8.setAccessible(true);     // Catch: Exception -> L13
    L11:
        sOnPreDrawMethod.invoke(r1, new Object[]{null});     // Catch: Exception -> L13
        return r1;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r10, Object r11) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sDrawDisplayListMethod != null) goto L5;
        Class r8 = Integer.TYPE;     // Catch: Exception -> L7
        Method r0 = Canvas.class.getDeclaredMethod("drawDisplayList", new Class[]{DisplayList.class, r8, r8, Rect.class});     // Catch: Exception -> L7
        sDrawDisplayListMethod = r0;     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
    L5:
        sDrawDisplayListMethod.invoke(r10, new Object[]{r11, Integer.valueOf(this.width), Integer.valueOf(this.height), null});     // Catch: Exception -> L7
    }

    public void setViewport(int r8, int r9, Canvas r10) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sSetViewportMethod != null) goto L5;
        Class r6 = Integer.TYPE;     // Catch: Exception -> L7
        Method r0 = Canvas.class.getDeclaredMethod("setViewport", new Class[]{r6, r6});     // Catch: Exception -> L7
        sSetViewportMethod = r0;     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
    L5:
        sSetViewportMethod.invoke(r10, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)});     // Catch: Exception -> L7
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r1, int r2, int r3, int r4) {
        this.left = r1;
        this.top = r2;
        this.right = r3;
        this.bottom = r4;
    }
}
