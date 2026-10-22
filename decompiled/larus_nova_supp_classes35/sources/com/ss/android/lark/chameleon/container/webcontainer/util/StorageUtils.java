package com.ss.android.lark.chameleon.container.webcontainer.util;

import android.content.Context;
import android.text.TextUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/util/StorageUtils;", BuildConfig.FLAVOR, "()V", "composeStoragePath", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "bizRootDictionary", "bizChildPath", IPortraitService.TYPE, "Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;", "args", BuildConfig.FLAVOR, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;[Ljava/lang/Object;)Ljava/lang/String;", "getFilePath", "getInnerCachePath", "getInnerFilePath", "getOuterCachePath", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StorageUtils {
    public static final StorageUtils INSTANCE = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Storage.Type.values().length];
            r0[Storage.Type.INNER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Storage.Type.INNER_FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Storage.Type.FILES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new StorageUtils();
    }

    private StorageUtils() {
    }

    public final String getFilePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        File r0 = r2.getExternalFilesDir(null);
        if (r0 != null) goto L5;
        r0 = r2.getFilesDir();
    L5:
        if (r0 != null) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        return r0.getPath();
    }

    public final String getInnerCachePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        File r3 = r2.getCacheDir();
        if (r3 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r3.getPath();
    }

    public final String getInnerFilePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        File r3 = r2.getFilesDir();
        if (r3 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r3.getPath();
    }

    public final String getOuterCachePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        File r3 = r2.getExternalCacheDir();
        if (r3 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r3.getPath();
    }

    @JvmStatic
    public static final String composeStoragePath(Context r2, String r3, String r4, Storage.Type r5, Object[] r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bizRootDictionary");
        Intrinsics.checkNotNullParameter(r4, "bizChildPath");
        Intrinsics.checkNotNullParameter(r5, IPortraitService.TYPE);
        int r7 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        boolean r0 = true;
        if (r7 != 1) goto L5;
        String r8 = INSTANCE.getInnerCachePath(r2) + File.separator;
    L12:
        String r9 = r8 + r3;
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r9 = r9 + File.separator + r4;
    L16:
        if (r6 != null) goto L18;
    L24:
        r0 = false;
    L25:
        if (r0 == false) goto L30;
        Iterator r10 = ArrayIteratorKt.iterator(r6);
    L28:
        if (r10.hasNext() == false) goto L30;
        r9 = r9 + File.separator + r10.next();
    L30:
        return r9;
    L18:
        if (r6.length != 0) goto L20;
        boolean r11 = true;
    L22:
        if ((!r11) != true) goto L24;
    L20:
        r11 = false;
        goto L22
    L5:
        if (r7 != 2) goto L7;
        r8 = INSTANCE.getInnerFilePath(r2) + File.separator;
        goto L12
    L7:
        if (r7 == 3) goto L9;
        r8 = INSTANCE.getOuterCachePath(r2) + File.separator;
        goto L12
    L9:
        r8 = INSTANCE.getFilePath(r2) + File.separator;
        goto L12
    }
}
