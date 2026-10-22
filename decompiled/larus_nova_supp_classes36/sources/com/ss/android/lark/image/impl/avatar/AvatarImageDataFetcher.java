package com.ss.android.lark.image.impl.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.DataSource;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.ImageFormat;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.a;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import qkb.b;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AvatarImageDataFetcher extends ResourceImageDataFetcher<AvatarImage> {

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.avatar.AvatarImageDataFetcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType = null;

        static {
            int[] r0 = new int[ImageUtils.ImageType.values().length];
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType = r0;
            r0[ImageUtils.ImageType.TYPE_WEBP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_JPG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_PNG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_HEIF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_HEIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "AvatarImageDataFetcher";
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher, rkb.a
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public AvatarImageDataFetcher(AvatarImage r1) {
        super(r1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageDataFetcher_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private float getDeviceDensity(Context r1) {
        return INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageDataFetcher_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(UIHelper.getResources()).density;
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(AvatarImage r10) throws FileNotFoundException {
        long r0 = r10.getCreateTime();
        if (r0 == 0) goto L5;
        r10.setWaitTime(System.currentTimeMillis() - r0);
    L5:
        String r1 = r10.getKey();
        if (r1.startsWith("lark.avatar/") == false) goto L8;
        r1 = r1.substring(12);
    L8:
        int r2 = b.a;
        boolean r3 = false;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L11;
        Log.d("HeifAvatarExperimentConfig", "debug mode no support heif avatar");
    L29:
        if (r3 == false) goto L36;
        int r4 = r10.getWidth();
        int r5 = b.a;
        if (r4 < r5) goto L36;
        if (r10.getHeight() < r5) goto L36;
        r10.setImageFormat(ImageFormat.HEIC);
    L36:
        if (r10.isOnlyLocal() == false) goto L43;
        String r6 = ImageModule.a.getAvatarDir() + File.separator + AvatarImageNameManager.inst().generateFileName(LarkContext.getApplication(), r10);
        boolean r7 = new PolarisFileWrapper(r6).exists();
        Log.i("AvatarImageDataFetcher", "try to load local file, path is:" + r6 + ", isExist:" + r7);
        if (r7 == false) goto L41;
        Log.i("AvatarImageDataFetcher", "file path " + r6 + " exists, avatarKey is " + r10.getKey() + ", entityId is " + r10.getEntityId());
        return new PolarisFileInputStreamWrapper(r6);
    L41:
        Log.i("AvatarImageDataFetcher", "file path " + r6 + " does not exist, avatarKey is " + r10.getKey() + ", entityId is " + r10.getEntityId());
        return null;
    L43:
        String r8 = a.a();
        Resource r9 = getAvatarImageResource(r10, r8);
        r10.setDecodeStartTime(System.currentTimeMillis());
        if (r9 == null) goto L59;
        r10.setErrorResult(r9.e);
        String r11 = r9.b;
        if (r11 != null) goto L52;
        ErrorResult r12 = r9.e;
        if (r12 != null) goto L50;
    L51:
        r10.setErrorResult(new ErrorResult(701002));
        goto L52
    L50:
        if (r12.getCode() == 0) goto L51;
    L52:
        Log.i("AvatarImageDataFetcher", "load avatar image, key is: " + r1 + ", path is:" + r11 + ", contextId:" + r8);
        if (r11 != null) goto L55;
    L58:
        return null;
    L55:
        if (new PolarisFileWrapper(r11).exists() == false) goto L58;
        setImageFormat(r10, r11);
        r10.setResourceSize(new PolarisFileWrapper(r11).length());
        return new PolarisFileInputStreamWrapper(r11);
    L59:
        Log.e("AvatarImageDataFetcher", "load avatar image failed resource is empty, key is: " + r1);
        r10.setErrorResult(new ErrorResult(701005));
        return null;
    L11:
        Boolean r13 = b.b;
        if (r13 != null) goto L27;
        boolean r14 = FeatureGatingModule.getFeatureGatingService().isEnable("messenger.avatar.download.heic");
        Boolean r15 = (Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(qkb.a.class, true);
        if (r15 == null) goto L16;
        boolean r16 = r15.booleanValue();
    L18:
        if (Build.VERSION.SDK_INT < 27) goto L20;
        boolean r17 = true;
    L21:
        Log.i("HeifAvatarExperimentConfig", "isEnableSupportHeif:fg:" + r14 + " experiment:" + r16 + " hasO1:" + r17);
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        if (r17 == false) goto L26;
        r3 = true;
    L26:
        Boolean r18 = Boolean.valueOf(r3);
        b.b = r18;
        boolean r19 = Intrinsics.areEqual(r18, Boolean.TRUE);
    L28:
        r3 = r19;
        goto L29
    L20:
        r17 = false;
        goto L21
    L16:
        r16 = false;
        goto L18
    L27:
        r19 = Intrinsics.areEqual(r13, Boolean.TRUE);
        goto L28
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(AvatarImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }

    private Resource getAvatarImageResource(AvatarImage r11, String r12) {
        e r0 = (e) ApiUtils.getApi(e.class);
        return r0.getImageService().getAvatarImageResource(r11.getEntityId(), r11.getKey(), UIHelper.px2dp(Math.max(r11.getWidth(), r11.getHeight())), getDeviceDensity(LarkContext.getApplication()), r11.getImageType(), r12);
    }

    private void setImageFormat(AvatarImage r4, String r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (FileUtils.r(r5) == false) goto L24;
        int r0 = AnonymousClass1.$SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.c(VFSFiles.b.i(r5)).ordinal()];
        if (r0 != 1) goto L9;
        ImageFormat r1 = ImageFormat.WEBP;
    L21:
        Log.i("AvatarImageDataFetcher", "setImageFormat, path:" + r5 + ", format:" + r1);
        r4.setImageFormat(r1);
        return;
    L9:
        if (r0 != 2) goto L11;
        r1 = ImageFormat.JPEG;
        goto L21
    L11:
        if (r0 != 3) goto L13;
        r1 = ImageFormat.PNG;
        goto L21
    L13:
        if (r0 != 4) goto L15;
    L17:
        r1 = ImageFormat.HEIC;
        goto L21
    L15:
        if (r0 == 5) goto L17;
        r1 = null;
        goto L21
    }
}
