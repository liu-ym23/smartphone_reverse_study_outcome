package com.lynx.tasm;

import android.os.SystemClock;
import android.util.Log;
import com.lynx.devtoolwrapper.LynxDevtool;
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
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.JNINamespace;
import com.lynx.tasm.behavior.LayoutContext;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.a1;
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
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.Settable;
import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.ResourceLoader;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        long r5 = SystemClock.uptimeMillis();
        Class.forName(com.lynx.jsbridge.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.jsbridge.n.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.jsbridge.o.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxModule.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxModuleWrapper.class.getName());     // Catch: Throwable -> L5
        Class.forName(MethodDescriptor.class.getName());     // Catch: Throwable -> L5
        Class.forName(Promise.class.getName());     // Catch: Throwable -> L5
        Class.forName(Callback.class.getName());     // Catch: Throwable -> L5
        Class.forName(pm.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(pm.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(pm.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableArray.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableMap.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableMapKeySetIterator.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableType.class.getName());     // Catch: Throwable -> L5
        Class.forName(io.reactivex.internal.observers.h.class.getName());     // Catch: Throwable -> L5
        Class.forName(r.class.getName());     // Catch: Throwable -> L5
        Class.forName(e.class.getName());     // Catch: Throwable -> L5
        Class.forName(h.class.getName());     // Catch: Throwable -> L5
        Class.forName(i.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxEnv.class.getName());     // Catch: Throwable -> L5
        Class.forName(u.class.getName());     // Catch: Throwable -> L5
        Class.forName(l0.class.getName());     // Catch: Throwable -> L5
        Class.forName(t0.class.getName());     // Catch: Throwable -> L5
        Class.forName(TemplateData.class.getName());     // Catch: Throwable -> L5
        Class.forName(ThreadStrategyForRendering.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.base.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(CalledByNative.class.getName());     // Catch: Throwable -> L5
        Class.forName(JNINamespace.class.getName());     // Catch: Throwable -> L5
        Class.forName(d0.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.k.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(LayoutContext.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.animation.keyframe.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.animation.keyframe.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.c0.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.d0.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.e0.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.n0.class.getName());     // Catch: Throwable -> L5
        Class.forName(PaintingContext.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.v0.class.getName());     // Catch: Throwable -> L5
        Class.forName(x0.class.getName());     // Catch: Throwable -> L5
        Class.forName(y0.class.getName());     // Catch: Throwable -> L5
        Class.forName(a1.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.d.class.getName());     // Catch: Throwable -> L5
        Class.forName(CustomLayoutShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(LayoutNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(AutoSizeImage.class.getName());     // Catch: Throwable -> L5
        Class.forName(MeasureMode.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.h.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.j.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.k.class.getName());     // Catch: Throwable -> L5
        Class.forName(NativeLayoutNodeRef.class.getName());     // Catch: Throwable -> L5
        Class.forName(ShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.m.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.n.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.o.class.getName());     // Catch: Throwable -> L5
        Class.forName(ym.p.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(AbsInlineImageShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(AbsoluteSizeSpan.class.getName());     // Catch: Throwable -> L5
        Class.forName(BackgroundColorSpan.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(BaseTextShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.d.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.h.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.j.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.k.class.getName());     // Catch: Throwable -> L5
        Class.forName(InlineTextShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(InlineTruncationShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(InlineTruncationShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxStrikethroughSpan.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.l.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.m.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxUnderlineSpan.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.n.class.getName());     // Catch: Throwable -> L5
        Class.forName(RawTextShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.o.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.p.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.q.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.v.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.x.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.z.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.a0.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.b0.class.getName());     // Catch: Throwable -> L5
        Class.forName(TextShadowNode.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.d0.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.bytedance.ies.bullet.lynx.init.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(zm.g0.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIComponent.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.view.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxBaseUI.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.a0.class.getName());     // Catch: Throwable -> L5
        Class.forName(dn.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(gn.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.text.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(AndroidText.class.getName());     // Catch: Throwable -> L5
        Class.forName(BackgroundDrawable.BorderRadiusLocation.class.getName());     // Catch: Throwable -> L5
        Class.forName(BackgroundDrawable.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.l.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.p.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.utils.l.class.getName());     // Catch: Throwable -> L5
        Class.forName(Settable.class.getName());     // Catch: Throwable -> L5
        Class.forName(kn.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(ResourceLoader.class.getName());     // Catch: Throwable -> L5
        Class.forName(on.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(on.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.base.h.class.getName());     // Catch: Throwable -> L5
        Class.forName(fo.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(fo.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(ColorUtils.class.getName());     // Catch: Throwable -> L5
        Class.forName(DisplayMetricsHolder.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.d.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.j.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.k.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(yn.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(fo.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(fo.j.class.getName());     // Catch: Throwable -> L5
        Class.forName(mo.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(PromiseImpl.class.getName());     // Catch: Throwable -> L5
        Class.forName(pm.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(pm.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(WritableArray.class.getName());     // Catch: Throwable -> L5
        Class.forName(WritableMap.class.getName());     // Catch: Throwable -> L5
        Class.forName(f0.class.getName());     // Catch: Throwable -> L5
        Class.forName(o0.class.getName());     // Catch: Throwable -> L5
        Class.forName(NativeFacade.class.getName());     // Catch: Throwable -> L5
        Class.forName(RenderNodeCompat.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.k.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxContext.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.w0.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxFlattenUI.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxUI.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIBody.UIBodyView.class.getName());     // Catch: Throwable -> L5
        Class.forName(AndroidScrollView.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(BorderStyle.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.utils.n.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.view.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxUISetter.class.getName());     // Catch: Throwable -> L5
        Class.forName(ShadowNodeSetter.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.utils.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(JSProxy.class.getName());     // Catch: Throwable -> L5
        Class.forName(on.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(on.h.class.getName());     // Catch: Throwable -> L5
        Class.forName(JavaOnlyArray.class.getName());     // Catch: Throwable -> L5
        Class.forName(JavaOnlyMap.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableMapBuffer.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableCompactArrayBuffer.class.getName());     // Catch: Throwable -> L5
        Class.forName(qm.d.class.getName());     // Catch: Throwable -> L5
        Class.forName(qm.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(qm.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableMapBuffer.class.getName());     // Catch: Throwable -> L5
        Class.forName(ReadableCompactArrayBuffer.class.getName());     // Catch: Throwable -> L5
        Class.forName(p0.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxView.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.f.class.getName());     // Catch: Throwable -> L5
        Class.forName(um.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(vm.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(tm.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(tm.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIGroup.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.behavior.ui.d0.class.getName());     // Catch: Throwable -> L5
        Class.forName(AbsUIImage.class.getName());     // Catch: Throwable -> L5
        Class.forName(FlattenUIText.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIText.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.d.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.c.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.i.class.getName());     // Catch: Throwable -> L5
        Class.forName(an.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(com.lynx.tasm.fontface.g.class.getName());     // Catch: Throwable -> L5
        Class.forName(on.e.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIBody.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIShadowProxy.class.getName());     // Catch: Throwable -> L5
        Class.forName(UISimpleView.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIScrollView.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIView.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIList.class.getName());     // Catch: Throwable -> L5
        Class.forName(UIListAdapter.class.getName());     // Catch: Throwable -> L5
        Class.forName(mm.b.class.getName());     // Catch: Throwable -> L5
        Class.forName(mm.a.class.getName());     // Catch: Throwable -> L5
        Class.forName(LynxDevtool.class.getName());     // Catch: Throwable -> L5
        com.lynx.tasm.utils.c.e();     // Catch: Throwable -> L5
        Log.i("Lynx_ClassWarmer", "Task2 class warm-up cost:" + (SystemClock.uptimeMillis() - r5));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
