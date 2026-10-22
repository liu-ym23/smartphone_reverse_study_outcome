package com.ss.android.lark.framework.assembly.imageloader;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.resource.service.ResourceRecordManager;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photopicker.f;
import com.suite.lark.platform.component.storage.file.dirs.k;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.util.HashMap;
import java.util.Random;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import qpc.e;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(com.ss.android.lark.image.a.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002JD\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016JL\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\rH\u0016¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/framework/assembly/imageloader/LarkImageDependency;", "Lcom/ss/android/lark/image/ILarkImageDependency;", "<init>", "()V", "isReportImageLoad", "", "fromType", "", "loadType", "percentage", "getEncryptImage", "Lcom/suite/lark/platform/service/resourcerepository/api/Resource;", "imageCachePath", "", "encryptKey", "fsUnit", "crypto", "Lokio/ByteString;", "contextId", "needCollectTrace", "draftResourceSource", "findResource", TabAppInfo.IMAGE_JSON_KEY, "getAvatarDir", "getPassPortDependency", "Lcom/ss/android/lark/image/ILarkImageDependency$IPassPortDependency;", "getWatermarkResource", "scene", "path", "imageloader-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkImageDependency implements com.ss.android.lark.image.a {

    public static final class a implements com.ss.android.lark.image.a.InterfaceC0090a {
        public a() {
        }

        @Override // com.ss.android.lark.image.a.InterfaceC0090a
        public final String getDeviceId() {
            return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceIdFromLocal();
        }

        @Override // com.ss.android.lark.image.a.InterfaceC0090a
        public final String getUserId() {
            return ((b) LarkContext.spiByDwarf(b.class)).d();
        }
    }

    public LarkImageDependency() {
    }

    @Override // com.ss.android.lark.image.a
    public String getAvatarDir() {
        return k.a.a(LarkContext.getApplication(), "lark-image");
    }

    @Override // com.ss.android.lark.image.a
    public com.ss.android.lark.image.a.InterfaceC0090a getPassPortDependency() {
        return new a();
    }

    private final boolean isReportImageLoad(int r4) {
        if (r4 < 100) goto L5;
        return true;
    L5:
        if (new Random().nextInt(100) < r4) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.android.lark.image.a
    public String findResource(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return ResourceRecordManager.a(r2);
    }

    public String getWatermarkResource(@Nonnull String r2, @Nonnull String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "path");
        return f.a().B();
    }

    @Override // com.ss.android.lark.image.a
    public boolean isReportImageLoad(int r2, int r3) {
        HashMap<Integer, Integer> r4 = ChatImageSettings.getImageLoadDownSampleDictionary().get(Integer.valueOf(r2));
        if (r4 == null) goto L7;
        Integer r5 = r4.get(Integer.valueOf(r3));
        if (r5 == null) goto L7;
        return isReportImageLoad(r5.intValue());
    L7:
        return true;
    }

    public Resource getEncryptImage(String r8, String r9, String r10, ByteString r11, String r12, boolean r13) {
        e r0 = (e) ApiUtils.getApi(e.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getImageService().getEncryptImage(r8, r9, r10, r11, r12, r13);
    }

    @Override // com.ss.android.lark.image.a
    public Resource getEncryptImage(String r9, String r10, String r11, ByteString r12, String r13, boolean r14, int r15) {
        e r0 = (e) ApiUtils.getApi(e.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getImageService().getEncryptImage(r9, r10, r11, r12, r13, r14, r15);
    }
}
