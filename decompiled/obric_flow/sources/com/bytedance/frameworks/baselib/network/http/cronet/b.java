package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.xbridge.event.d;
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
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.ImageResizeMethod;
import com.lynx.tasm.ui.image.UIImage;
import com.lynx.tasm.ui.image.b1;
import com.lynx.tasm.ui.image.e0;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.ui.image.i0;
import com.lynx.tasm.ui.image.l0;
import com.lynx.tasm.ui.image.n0;
import com.lynx.tasm.ui.image.o0;
import com.lynx.tasm.ui.image.v0;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.j;
import oo.k;
import org.json.JSONObject;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;
import pt.p;
import t0.c;
import ug.e;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements y, d, com.lynx.tasm.a, p, j, de.b, i, c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f4672b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4673a;

    public /* synthetic */ b(int r5) {
        this.f4673a = r5;
    }

    public static b e() {
        if (f4672b != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f4672b != null) goto L11;
        f4672b = new b(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f4672b;
    }

    @Override // com.bytedance.ies.xbridge.event.d
    public void a(com.bytedance.ies.xbridge.event.c r10) {
        Intrinsics.checkNotNullParameter(r10, "jsEvent");
        e r11 = r10.f6330b;
        if (r11 == null) goto L5;
        Object r12 = com.lynx.tasm.utils.e.d((JSONObject) r11.f22361b).get("data");
    L7:
        if ((r12 instanceof Map) == false) goto L9;
        Map r13 = (Map) r12;
    L11:
        if (r13 != null) goto L13;
    L39:
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.f("ForestAIEventSubscriber", "data from " + r10 + " is empty or null!");
        return;
    L13:
        if (r13.isEmpty() == true) goto L39;
        String r5 = (String) r13.get("main_url");
        if (r5 != null) goto L18;
    L37:
        int r15 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.f("ForestAIEventSubscriber", "mainUrl from " + r13 + " is empty!");
        return;
    L18:
        if (r5.length() == 0) goto L37;
        String r16 = (String) r13.get("engine_type");
        if (Intrinsics.areEqual(r16, "lynx") == false) goto L25;
        PreloadType r17 = PreloadType.f4333a;
    L23:
        PreloadType r18 = r17;
        String r19 = (String) r13.get("bid");
        if (r19 != null) goto L30;
        r19 = "default_bid";
    L30:
        zm.c r20 = f.f5397a;
        g r21 = new g("");
        r21.f22850t = 300;
        com.bytedance.android.anniex.worker.b r22 = com.bytedance.android.anniex.worker.b.f3505a;
        Intrinsics.checkNotNullParameter(r19, "bid");
        Intrinsics.checkNotNullParameter(r19, STGroup.DICT_KEY);
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieXJSWorkerManager", "storage is null", null, 12);
        if (Intrinsics.areEqual("", "") == false) goto L33;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieXJSWorkerManager", "ua is null", null, 12);
    L33:
        r21.f22849r = "";
        Unit r23 = Unit.INSTANCE;
        f.f(r5, true, "", r18, true, "client_ai", r21);
        return;
    L25:
        if (Intrinsics.areEqual(r16, "web") == false) goto L35;
        r17 = PreloadType.f4334b;
        goto L23
    L35:
        int r24 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.f("ForestAIEventSubscriber", "engine_type:" + r16 + " from " + r13 + " can not be identified!");
        return;
    L9:
        r13 = null;
        goto L11
    L5:
        r12 = null;
        goto L7
    }

    public void b() {
        Class.forName(FlattenUIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(v0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(UIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(f0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(oo.j.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(AutoSizeImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(e0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(l0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(i0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(o0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(n0.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(FrescoImageView.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(com.lynx.tasm.ui.image.i.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(no.a.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(b1.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageResizeMethod.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(k.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(AbstractDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(PipelineDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BaseControllerListener.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(GenericDraweeHierarchyBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(RoundingParams.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(GenericDraweeHierarchy.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ForwardingDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DrawableProperties.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DrawableUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(WrappingUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ScaleTypeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ArrayDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(FadeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(RoundedColorDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.y
    public void c(MediaMetadataRetriever r10, Object r11) {
        AssetFileDescriptor r12 = (AssetFileDescriptor) r11;
        r10.setDataSource(r12.getFileDescriptor(), r12.getStartOffset(), r12.getLength());
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f4673a) {
            case 14: goto L12;
            default: goto L4;
        };
    L4:
        ZoneId r10 = (ZoneId) r5.query(h.f21286a);
        if (r10 != null) goto L7;
    L9:
        return null;
    L7:
        if ((r10 instanceof ZoneOffset) == true) goto L9;
        return r10;
    L12:
        return Instant.from(r5);
    }

    @Override // pt.p
    public boolean test(Object r5) {
        return false;
    }

    public /* synthetic */ b(boolean r5) {
        this.f4673a = 10;
    }
}
