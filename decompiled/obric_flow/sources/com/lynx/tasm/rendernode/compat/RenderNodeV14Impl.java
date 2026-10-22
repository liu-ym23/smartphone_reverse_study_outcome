package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.DisplayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
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

    public RenderNodeV14Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r5, int r10) {
        this.width = r5;
        this.height = r10;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (sStartMethod != null) goto L8;
        Method r11 = DisplayList.class.getDeclaredMethod("start", null);     // Catch: Exception -> L6
        sStartMethod = r11;     // Catch: Exception -> L6
        r11.setAccessible(true);     // Catch: Exception -> L6
    L8:
        Canvas r12 = (Canvas) sStartMethod.invoke(this.displayList, null);     // Catch: Exception -> L6
        setViewport(r5, r10, r12);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L11:
        if (sOnPreDrawMethod != null) goto L15;
        Method r13 = Canvas.class.getDeclaredMethod("onPreDraw", new Class[]{Rect.class});     // Catch: Exception -> L13
        sOnPreDrawMethod = r13;     // Catch: Exception -> L13
        r13.setAccessible(true);     // Catch: Exception -> L13
    L15:
        sOnPreDrawMethod.invoke(r12, new Object[]{null});     // Catch: Exception -> L13
        return r12;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5) {
        drawRenderNode(r5, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sOnPostDrawMethod != null) goto L7;
        Method r10 = Canvas.class.getDeclaredMethod("onPostDraw", null);     // Catch: Exception -> L5
        sOnPostDrawMethod = r10;     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
    L7:
        sOnPostDrawMethod.invoke(r5, null);     // Catch: Exception -> L5
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        if (sEndMethod != null) goto L13;
        Method r11 = DisplayList.class.getDeclaredMethod("end", null);     // Catch: Exception -> L11
        sEndMethod = r11;     // Catch: Exception -> L11
        r11.setAccessible(true);     // Catch: Exception -> L11
    L13:
        sEndMethod.invoke(this.displayList, null);     // Catch: Exception -> L11
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.displayList;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sIsValidMethod != null) goto L7;
        Method r5 = DisplayList.class.getDeclaredMethod("isValid", null);     // Catch: Exception -> L5
        sIsValidMethod = r5;     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
    L7:
        return ((Boolean) sIsValidMethod.invoke(this.displayList, null)).booleanValue();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.sGLESConstructor != null) goto L7;
        Constructor<?> r5 = Class.forName("android.view.GLES20DisplayList").getConstructor(null);     // Catch: Exception -> L5
        this.sGLESConstructor = r5;     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
    L7:
        this.displayList = (DisplayList) this.sGLESConstructor.newInstance(null);     // Catch: Exception -> L5
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r5, int r10, int r11, int r12) {
        this.left = r5;
        this.top = r10;
        this.right = r11;
        this.bottom = r12;
    }

    public void setViewport(int r5, int r10, Canvas r11) {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sSetViewportMethod != null) goto L7;
        Class r12 = Integer.TYPE;     // Catch: Exception -> L5
        Method r13 = Canvas.class.getDeclaredMethod("setViewport", new Class[]{r12, r12});     // Catch: Exception -> L5
        sSetViewportMethod = r13;     // Catch: Exception -> L5
        r13.setAccessible(true);     // Catch: Exception -> L5
    L7:
        sSetViewportMethod.invoke(r11, new Object[]{Integer.valueOf(r5), Integer.valueOf(r10)});     // Catch: Exception -> L5
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r10, Object r11) {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sDrawDisplayListMethod != null) goto L7;
        Class r5 = Integer.TYPE;     // Catch: Exception -> L5
        Method r12 = Canvas.class.getDeclaredMethod("drawDisplayList", new Class[]{DisplayList.class, r5, r5, Rect.class});     // Catch: Exception -> L5
        sDrawDisplayListMethod = r12;     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
    L7:
        sDrawDisplayListMethod.invoke(r10, new Object[]{r11, Integer.valueOf(this.width), Integer.valueOf(this.height), null});     // Catch: Exception -> L5
    }
}
