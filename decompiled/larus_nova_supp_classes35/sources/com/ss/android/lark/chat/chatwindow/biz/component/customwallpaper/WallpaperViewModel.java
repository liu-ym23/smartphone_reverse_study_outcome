package com.ss.android.lark.chat.chatwindow.biz.component.customwallpaper;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/WallpaperViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "originImageLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/drawable/BitmapDrawable;", "getOriginImageLiveData", "()Landroidx/lifecycle/MutableLiveData;", "downloadWallpaper", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "key", BuildConfig.FLAVOR, "fsUnit", "updateBitmapWallpaper", "bitmapDrawable", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WallpaperViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "WallpaperViewModel";
    private final MutableLiveData<BitmapDrawable> originImageLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ WallpaperViewModel d;

        public b(String r1, String r2, Context r3, WallpaperViewModel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            File r0 = ImageLoader.with(this.c).load(new PassThroughImage(this.a, this.b, null)).downloadOnly(PluginList.LEVEL_NOT_SET, PluginList.LEVEL_NOT_SET);     // Catch: Exception -> L8
            if (r0 != null) goto L6;
            return;
        L6:
            this.d.getOriginImageLiveData().postValue(new BitmapDrawable(r0.getAbsolutePath()));     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Log.e(WallpaperViewModel.TAG, "load wallpaper occur exception " + e.getMessage());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public WallpaperViewModel() {
        this.originImageLiveData = new MutableLiveData();
    }

    public final MutableLiveData<BitmapDrawable> getOriginImageLiveData() {
        return this.originImageLiveData;
    }

    public final void updateBitmapWallpaper(BitmapDrawable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.originImageLiveData.postValue(r2);
    }

    public final void downloadWallpaper(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "fsUnit");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r4, r5, r3, this));
    }
}
