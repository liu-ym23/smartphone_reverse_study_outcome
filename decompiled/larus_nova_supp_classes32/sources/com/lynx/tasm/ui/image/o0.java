package com.lynx.tasm.ui.image;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.WrappingUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.image.AutoSizeImage;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o0 implements com.lynx.tasm.a {
    public o0() {
    }

    @Override // com.lynx.tasm.a
    public final void a() {
        b(FlattenUIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        b(e0.class.getName());     // Catch: ClassNotFoundException -> L4
        b(UIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        b(p.class.getName());     // Catch: ClassNotFoundException -> L4
        b(m8a.f.class.getName());     // Catch: ClassNotFoundException -> L4
        b(AutoSizeImage.class.getName());     // Catch: ClassNotFoundException -> L4
        b(o.class.getName());     // Catch: ClassNotFoundException -> L4
        b(LynxAbstractDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        b(q.class.getName());     // Catch: ClassNotFoundException -> L4
        b(v.class.getName());     // Catch: ClassNotFoundException -> L4
        b(u.class.getName());     // Catch: ClassNotFoundException -> L4
        b(FrescoImageView.class.getName());     // Catch: ClassNotFoundException -> L4
        b(b.class.getName());     // Catch: ClassNotFoundException -> L4
        b(l8a.a.class.getName());     // Catch: ClassNotFoundException -> L4
        b(n0.class.getName());     // Catch: ClassNotFoundException -> L4
        b(ImageResizeMethod.class.getName());     // Catch: ClassNotFoundException -> L4
        b(m8a.g.class.getName());     // Catch: ClassNotFoundException -> L4
        b(AbstractDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        b(PipelineDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        b(BaseControllerListener.class.getName());     // Catch: ClassNotFoundException -> L4
        b(GenericDraweeHierarchyBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        b(RoundingParams.class.getName());     // Catch: ClassNotFoundException -> L4
        b(GenericDraweeHierarchy.class.getName());     // Catch: ClassNotFoundException -> L4
        b(ForwardingDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        b(DrawableProperties.class.getName());     // Catch: ClassNotFoundException -> L4
        b(DrawableUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        b(WrappingUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        b(ScaleTypeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        b(ArrayDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        b(FadeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        b(RoundedColorDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void b(String r3) throws ClassNotFoundException {
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
