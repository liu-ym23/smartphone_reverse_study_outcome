package com.lynx.tasm;

import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.jsbridge.Promise;
import com.lynx.jsbridge.PromiseImpl;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.JNINamespace;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.LayoutContext;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.LynxPropsHolder;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsoluteSizeSpan;
import com.lynx.tasm.behavior.shadow.text.BackgroundColorSpan;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.shadow.text.LynxStrikethroughSpan;
import com.lynx.tasm.behavior.shadow.text.LynxUnderlineSpan;
import com.lynx.tasm.behavior.shadow.text.RawTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.image.AbsUIImage;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.utils.Settable;
import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.ResourceLoader;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public d() {
    }

    public static void b() {
        SystemClock.uptimeMillis();
        a(Arguments.class.getName());     // Catch: Throwable -> L5
        a(LynxMethod.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.jsbridge.e.class.getName());     // Catch: Throwable -> L5
        a(LynxModule.class.getName());     // Catch: Throwable -> L5
        a(LynxModuleWrapper.class.getName());     // Catch: Throwable -> L5
        a(MethodDescriptor.class.getName());     // Catch: Throwable -> L5
        a(Promise.class.getName());     // Catch: Throwable -> L5
        a(Callback.class.getName());     // Catch: Throwable -> L5
        a(f6a.a.class.getName());     // Catch: Throwable -> L5
        a(f6a.e.class.getName());     // Catch: Throwable -> L5
        a(f6a.d.class.getName());     // Catch: Throwable -> L5
        a(ReadableArray.class.getName());     // Catch: Throwable -> L5
        a(ReadableMap.class.getName());     // Catch: Throwable -> L5
        a(ReadableMapKeySetIterator.class.getName());     // Catch: Throwable -> L5
        a(ReadableType.class.getName());     // Catch: Throwable -> L5
        a(e.class.getName());     // Catch: Throwable -> L5
        a(EventEmitter.class.getName());     // Catch: Throwable -> L5
        a(f.class.getName());     // Catch: Throwable -> L5
        a(INativeLibraryLoader.class.getName());     // Catch: Throwable -> L5
        a(l.class.getName());     // Catch: Throwable -> L5
        a(LynxEnv.class.getName());     // Catch: Throwable -> L5
        a(LynxGroup.class.getName());     // Catch: Throwable -> L5
        a(LynxViewBuilder.class.getName());     // Catch: Throwable -> L5
        a(NativeFacade.c.class.getName());     // Catch: Throwable -> L5
        a(TemplateData.class.getName());     // Catch: Throwable -> L5
        a(ThreadStrategyForRendering.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.base.a.class.getName());     // Catch: Throwable -> L5
        a(CalledByNative.class.getName());     // Catch: Throwable -> L5
        a(JNINamespace.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.base.f.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.b.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.c.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.i.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.m.class.getName());     // Catch: Throwable -> L5
        a(t6a.a.class.getName());     // Catch: Throwable -> L5
        a(t6a.c.class.getName());     // Catch: Throwable -> L5
        a(LayoutContext.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.animation.keyframe.a.class.getName());     // Catch: Throwable -> L5
        a(LynxKeyframeAnimator.class.getName());     // Catch: Throwable -> L5
        a(LynxProp.class.getName());     // Catch: Throwable -> L5
        a(LynxPropGroup.class.getName());     // Catch: Throwable -> L5
        a(LynxPropsHolder.class.getName());     // Catch: Throwable -> L5
        a(LynxUIOwner.class.getName());     // Catch: Throwable -> L5
        a(PaintingContext.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.t0.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.w0.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.x0.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.b1.class.getName());     // Catch: Throwable -> L5
        a(y6a.a.class.getName());     // Catch: Throwable -> L5
        a(y6a.b.class.getName());     // Catch: Throwable -> L5
        a(y6a.d.class.getName());     // Catch: Throwable -> L5
        a(CustomLayoutShadowNode.class.getName());     // Catch: Throwable -> L5
        a(y6a.e.class.getName());     // Catch: Throwable -> L5
        a(LayoutNode.class.getName());     // Catch: Throwable -> L5
        a(y6a.f.class.getName());     // Catch: Throwable -> L5
        a(y6a.g.class.getName());     // Catch: Throwable -> L5
        a(y6a.h.class.getName());     // Catch: Throwable -> L5
        a(MeasureMode.class.getName());     // Catch: Throwable -> L5
        a(y6a.i.class.getName());     // Catch: Throwable -> L5
        a(y6a.j.class.getName());     // Catch: Throwable -> L5
        a(y6a.k.class.getName());     // Catch: Throwable -> L5
        a(y6a.l.class.getName());     // Catch: Throwable -> L5
        a(NativeLayoutNodeRef.class.getName());     // Catch: Throwable -> L5
        a(ShadowNode.class.getName());     // Catch: Throwable -> L5
        a(y6a.m.class.getName());     // Catch: Throwable -> L5
        a(y6a.n.class.getName());     // Catch: Throwable -> L5
        a(y6a.o.class.getName());     // Catch: Throwable -> L5
        a(y6a.r.class.getName());     // Catch: Throwable -> L5
        a(z6a.a.class.getName());     // Catch: Throwable -> L5
        a(AbsInlineImageShadowNode.class.getName());     // Catch: Throwable -> L5
        a(AbsoluteSizeSpan.class.getName());     // Catch: Throwable -> L5
        a(BackgroundColorSpan.class.getName());     // Catch: Throwable -> L5
        a(z6a.c.class.getName());     // Catch: Throwable -> L5
        a(BaseTextShadowNode.class.getName());     // Catch: Throwable -> L5
        a(z6a.d.class.getName());     // Catch: Throwable -> L5
        a(z6a.e.class.getName());     // Catch: Throwable -> L5
        a(z6a.f.class.getName());     // Catch: Throwable -> L5
        a(z6a.h.class.getName());     // Catch: Throwable -> L5
        a(z6a.i.class.getName());     // Catch: Throwable -> L5
        a(z6a.j.class.getName());     // Catch: Throwable -> L5
        a(z6a.k.class.getName());     // Catch: Throwable -> L5
        a(InlineTextShadowNode.class.getName());     // Catch: Throwable -> L5
        a(InlineTruncationShadowNode.class.getName());     // Catch: Throwable -> L5
        a(InlineTruncationShadowNode.class.getName());     // Catch: Throwable -> L5
        a(LynxStrikethroughSpan.class.getName());     // Catch: Throwable -> L5
        a(z6a.l.class.getName());     // Catch: Throwable -> L5
        a(z6a.m.class.getName());     // Catch: Throwable -> L5
        a(LynxUnderlineSpan.class.getName());     // Catch: Throwable -> L5
        a(z6a.n.class.getName());     // Catch: Throwable -> L5
        a(RawTextShadowNode.class.getName());     // Catch: Throwable -> L5
        a(z6a.o.class.getName());     // Catch: Throwable -> L5
        a(z6a.p.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.a.class.getName());     // Catch: Throwable -> L5
        a(z6a.u.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.e.class.getName());     // Catch: Throwable -> L5
        a(z6a.v.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.f.a.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.f.class.getName());     // Catch: Throwable -> L5
        a(TextShadowNode.class.getName());     // Catch: Throwable -> L5
        a(z6a.w.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.g.b.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.shadow.text.g.class.getName());     // Catch: Throwable -> L5
        a(UIComponent.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.view.b.class.getName());     // Catch: Throwable -> L5
        a(IDrawChildHook.IDrawChildHookBinding.class.getName());     // Catch: Throwable -> L5
        a(IDrawChildHook.class.getName());     // Catch: Throwable -> L5
        a(LynxBaseUI.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.k.class.getName());     // Catch: Throwable -> L5
        a(d7a.a.class.getName());     // Catch: Throwable -> L5
        a(AndroidScrollView.b.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.text.a.class.getName());     // Catch: Throwable -> L5
        a(AndroidText.class.getName());     // Catch: Throwable -> L5
        a(BackgroundDrawable.BorderRadiusLocation.class.getName());     // Catch: Throwable -> L5
        a(BackgroundDrawable.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.c.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.e.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.k.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.o.class.getName());     // Catch: Throwable -> L5
        a(PropsUpdater.class.getName());     // Catch: Throwable -> L5
        a(Settable.class.getName());     // Catch: Throwable -> L5
        a(j7a.b.class.getName());     // Catch: Throwable -> L5
        a(ResourceLoader.class.getName());     // Catch: Throwable -> L5
        a(EventsListener.class.getName());     // Catch: Throwable -> L5
        a(LynxEvent.class.getName());     // Catch: Throwable -> L5
        a(PageReloadHelper.class.getName());     // Catch: Throwable -> L5
        a(d8a.a.class.getName());     // Catch: Throwable -> L5
        a(d8a.b.a.class.getName());     // Catch: Throwable -> L5
        a(ColorUtils.class.getName());     // Catch: Throwable -> L5
        a(DisplayMetricsHolder.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.b.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.e.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.f.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.i.class.getName());     // Catch: Throwable -> L5
        a(UIThreadUtils.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.n.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.g.class.getName());     // Catch: Throwable -> L5
        a(w7a.a.class.getName());     // Catch: Throwable -> L5
        a(d8a.l.class.getName());     // Catch: Throwable -> L5
        a(d8a.m.class.getName());     // Catch: Throwable -> L5
        a(k8a.a.class.getName());     // Catch: Throwable -> L5
        a(PromiseImpl.class.getName());     // Catch: Throwable -> L5
        a(f6a.b.class.getName());     // Catch: Throwable -> L5
        a(f6a.c.class.getName());     // Catch: Throwable -> L5
        a(WritableArray.class.getName());     // Catch: Throwable -> L5
        a(WritableMap.class.getName());     // Catch: Throwable -> L5
        a(LynxTemplateRender.t.class.getName());     // Catch: Throwable -> L5
        a(q1.class.getName());     // Catch: Throwable -> L5
        a(NativeFacade.class.getName());     // Catch: Throwable -> L5
        a(RenderNodeCompat.class.getName());     // Catch: Throwable -> L5
        a(t6a.b.class.getName());     // Catch: Throwable -> L5
        a(t6a.g.class.getName());     // Catch: Throwable -> L5
        a(t6a.i.class.getName());     // Catch: Throwable -> L5
        a(LynxContext.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.v0.class.getName());     // Catch: Throwable -> L5
        a(LynxFlattenUI.class.getName());     // Catch: Throwable -> L5
        a(LynxUI.class.getName());     // Catch: Throwable -> L5
        a(UIBody.UIBodyView.class.getName());     // Catch: Throwable -> L5
        a(AndroidScrollView.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.a.class.getName());     // Catch: Throwable -> L5
        a(BorderStyle.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.utils.m.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.behavior.ui.view.a.class.getName());     // Catch: Throwable -> L5
        a(LynxUISetter.class.getName());     // Catch: Throwable -> L5
        a(ShadowNodeSetter.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.utils.h.class.getName());     // Catch: Throwable -> L5
        a(JSProxy.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.tasm.event.a.class.getName());     // Catch: Throwable -> L5
        a(LynxTouchEvent.class.getName());     // Catch: Throwable -> L5
        a(JavaOnlyArray.class.getName());     // Catch: Throwable -> L5
        a(JavaOnlyMap.class.getName());     // Catch: Throwable -> L5
        a(ReadableMapBuffer.class.getName());     // Catch: Throwable -> L5
        a(ReadableCompactArrayBuffer.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.react.bridge.mapbuffer.d.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.react.bridge.mapbuffer.e.class.getName());     // Catch: Throwable -> L5
        a(g6a.a.class.getName());     // Catch: Throwable -> L5
        a(MapBuffer.class.getName());     // Catch: Throwable -> L5
        a(com.lynx.react.bridge.mapbuffer.a.class.getName());     // Catch: Throwable -> L5
        a(r1.class.getName());     // Catch: Throwable -> L5
        a(LynxView.class.getName());     // Catch: Throwable -> L5
        a(t6a.d.class.getName());     // Catch: Throwable -> L5
        a(t6a.e.class.getName());     // Catch: Throwable -> L5
        a(u6a.a.class.getName());     // Catch: Throwable -> L5
        a(s6a.a.class.getName());     // Catch: Throwable -> L5
        a(s6a.b.class.getName());     // Catch: Throwable -> L5
        a(UIGroup.class.getName());     // Catch: Throwable -> L5
        a(UIShadowProxy.d.class.getName());     // Catch: Throwable -> L5
        a(AbsUIImage.class.getName());     // Catch: Throwable -> L5
        a(FlattenUIText.class.getName());     // Catch: Throwable -> L5
        a(UIText.class.getName());     // Catch: Throwable -> L5
        a(a7a.e.class.getName());     // Catch: Throwable -> L5
        a(a7a.d.class.getName());     // Catch: Throwable -> L5
        a(a7a.b.class.getName());     // Catch: Throwable -> L5
        a(a7a.f.class.getName());     // Catch: Throwable -> L5
        a(a7a.j.class.getName());     // Catch: Throwable -> L5
        a(a7a.h.class.getName());     // Catch: Throwable -> L5
        a(FontFaceManager.class.getName());     // Catch: Throwable -> L5
        a(m7a.b.class.getName());     // Catch: Throwable -> L5
        a(UIBody.class.getName());     // Catch: Throwable -> L5
        a(UIShadowProxy.class.getName());     // Catch: Throwable -> L5
        a(UISimpleView.class.getName());     // Catch: Throwable -> L5
        a(UIScrollView.class.getName());     // Catch: Throwable -> L5
        a(UIView.class.getName());     // Catch: Throwable -> L5
        a(UIList.class.getName());     // Catch: Throwable -> L5
        a(UIListAdapter.class.getName());     // Catch: Throwable -> L5
        a(LynxBaseInspectorOwner.class.getName());     // Catch: Throwable -> L5
        a(ILynxLogBox.class.getName());     // Catch: Throwable -> L5
        a(LynxDevtool.class.getName());     // Catch: Throwable -> L5
        com.lynx.tasm.utils.e.a();     // Catch: Throwable -> L5
        new BorderRadius.a();     // Catch: Throwable -> L5
        SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r3);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
