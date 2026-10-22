package com.ss.android.lark.image;

import android.app.Application;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.album.AlbumSerialImageLoader;
import com.ss.android.lark.image.impl.avatar.AvatarImageLoader;
import com.ss.android.lark.image.impl.encrtypt.EncryptImageLoader;
import com.ss.android.lark.image.impl.passthrough.PassThroughImageLoader;
import com.ss.android.lark.image.impl.reaction.ReactionImageLoader;
import com.ss.android.lark.image.impl.video.VideoImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.utils.LarkContext;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static boolean a;

    public class a implements MemoryCallbackManager.MemoryCallback {
        public a() {
        }

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onTrimMemory(int r1, int r2, int r3, int r4) {
        }

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onJavaMemoryReachTop() {
            final Application r0 = LarkContext.getApplication();
            com.ss.android.lark.image.a r1 = ImageModule.a;
            UICallbackExecutor.execute(new b(r0));
        }
    }

    public static void a() {
        Log.i("ImageModuleProvider", "initIfNeed, hasInit:" + a);
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        Application r0 = LarkContext.getApplication();
        com.ss.android.lark.image.a r1 = ImageModule.a;
        ImageLoader.registerLoadModelHook(r0, AvatarImage.class, InputStream.class, new AvatarImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r0, ReactionImage.class, InputStream.class, new ReactionImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r0, EncryptImage.class, InputStream.class, new EncryptImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r0, VideoImage.class, InputStream.class, new VideoImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r0, AlbumSerialImage.class, InputStream.class, new AlbumSerialImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r0, PassThroughImage.class, InputStream.class, new PassThroughImageLoader.Factory());
        Iterator r2 = PluginServiceLoader.loadAll(vkb.a.class);
    L7:
        if (r2.hasNext() == false) goto L9;
        vkb.a r3 = (vkb.a) r2.next();
        Log.i("ImageModule", "ImageModule registerExtraLoadModelHook <" + r3.getModelClass() + ">, " + r3.a());
        ImageLoader.registerLoadModelHook(r0, r3.getModelClass(), r3.getResourceClass(), r3.a());
        goto L7
    L9:
        boolean r4 = idb.f.a().isEnable("lark.feature.write.glide.log.to.file");
        Log.i("ImageModule", "initImageLoaderLog, isEnable:" + r4);
        GlideLogUtil.enableGlideWriter(r4);
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L12;
        GlideLogUtil.incrementErrorCount();
    L12:
        clb.a r5 = ykb.b.a;
        f r6 = new f();
        Intrinsics.checkNotNullParameter(r6, "dependency");
        ykb.b.a = r6;
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a());
    }
}
