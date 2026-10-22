package com.byted.mgl.merge.base.service.protocol.media;

import android.graphics.Bitmap;
import com.byted.cast.sink.api.IAPI;
import com.byted.mgl.merge.base.service.protocol.media.entity.BdpMediaEntity;
import com.byted.mgl.merge.base.service.protocol.media.entity.ImageInfo;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&J8\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000bH&J&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&J2\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH&J\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bH&J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\bH&J?\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020$H&¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\b2\u0006\u0010\n\u001a\u00020$H&¨\u0006+"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/ImageService;", "Lcom/bytedance/bdp/appbase/context/service/ContextService;", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "context", "(Lcom/bytedance/bdp/appbase/context/BdpAppContext;)V", "base64ToTempFilePath", "", "base64Data", "", "fileType", "callback", "Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$ResultCallback;", "chooseImages", "sourceFlag", "", "minSelectCount", "maxSelectCount", "", "Lcom/byted/mgl/merge/base/service/protocol/media/entity/BdpMediaEntity;", "compressImage", "src", "quality", "compressImagePathToBitmap", "Landroid/graphics/Bitmap;", "outWidth", "outHeight", "reqWidth", "reqHeight", "getImageInfo", "Lcom/byted/mgl/merge/base/service/protocol/media/entity/ImageInfo;", "getImageInfoSync", "previewImage", "paramsJson", "images", "primaryIndex", "primaryImage", "Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$ResultLessCallback;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$ResultLessCallback;)V", "saveImageToAlbum", "filePath", "Companion", "ResultCallback", "ResultLessCallback", "bdp-appbase_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public abstract class ImageService extends ContextService<BdpAppContext> {
    public static final int CAUSE_CANCEL = 7;
    public static final int CAUSE_DECODE_FAILED = 4;
    public static final int CAUSE_FILE_PERMISSION_DENIED = 2;
    public static final int CAUSE_FORMAT_NOT_SUPPORT = 6;
    public static final int CAUSE_INTERNAL_ERROR = 3;
    public static final int CAUSE_NO_SUCH_FILE = 1;
    public static final int CAUSE_NO_VALID_IMAGES = 5;
    public static final int CAUSE_SAVE_FILE_FAIL = 8;
    public static final Companion Companion = null;
    public static final int SOURCE_CAMERA = 1;
    public static final int SOURCE_GALLERY = 2;
    public static final int SUCCESS = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$Companion;", "", "()V", "CAUSE_CANCEL", "", "CAUSE_DECODE_FAILED", "CAUSE_FILE_PERMISSION_DENIED", "CAUSE_FORMAT_NOT_SUPPORT", "CAUSE_INTERNAL_ERROR", "CAUSE_NO_SUCH_FILE", "CAUSE_NO_VALID_IMAGES", "CAUSE_SAVE_FILE_FAIL", "SOURCE_CAMERA", "SOURCE_GALLERY", "SUCCESS", "bdp-appbase_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$ResultCallback;", "T", "", "onFailed", "", "cause", "", "extraMsg", "", "onSucceed", a.KEY_RESULT, "(Ljava/lang/Object;)V", "bdp-appbase_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public interface ResultCallback<T> {
        void onFailed(int r1, String r10);

        void onSucceed(T r1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/ImageService$ResultLessCallback;", "", "onFailed", "", "cause", "", "extraMsg", "", "onSucceed", "bdp-appbase_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public interface ResultLessCallback {
        void onFailed(int r1, String r10);

        void onSucceed();
    }

    static {
        Companion = new Companion(null);
    }

    public abstract void base64ToTempFilePath(String r1, String r10, ResultCallback<String> r11);

    public abstract void chooseImages(int r1, int r10, int r11, ResultCallback<List<BdpMediaEntity>> r12);

    public abstract void compressImage(String r1, int r10, ResultCallback<String> r11);

    public abstract Bitmap compressImagePathToBitmap(String r1, int r10, int r11, int r12, int r13);

    public abstract void getImageInfo(String r1, ResultCallback<ImageInfo> r10);

    public abstract ImageInfo getImageInfoSync(String r1);

    public abstract void previewImage(String r1, List<String> r10, Integer r11, String r12, ResultLessCallback r13);

    public abstract void saveImageToAlbum(String r1, ResultLessCallback r10);

    public ImageService(BdpAppContext r1) {
        super(r1);
    }

    public static /* synthetic */ void chooseImages$default(ImageService r0, int r1, int r10, int r11, ResultCallback r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r10 = 1;
    L7:
        if ((r13 & 4) == 0) goto L9;
        r11 = 9;
    L9:
        r0.chooseImages(r1, r10, r11, r12);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chooseImages");
    }
}
