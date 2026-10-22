package jlb;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.UploadImageOCRRequest;
import com.bytedance.lark.pb.media.v1.UploadImageOCRResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.imageocr_export.OCRScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {

    /* JADX INFO: renamed from: jlb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0285a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OCRScene.values().length];
            r0[OCRScene.OCR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OCRScene.SCRATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r2) {
            UploadImageOCRResponse r3 = (UploadImageOCRResponse) UploadImageOCRResponse.ADAPTER.decode(r2);
            return (ImageOCRResponse) ImageOCRResponse.ADAPTER.decode(r3.data);
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(OCRParams r5, IGetDataCallback<ImageOCRResponse> r6) {
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Log.i("ImageOCRService", "uploadImageOCR:" + r5);
        UploadImageOCRRequest.Builder r0 = new UploadImageOCRRequest.Builder();
        String r2 = r5.getRemoteImageKey();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r0.file_key(r5.getRemoteImageKey());
    L16:
        String r1 = r5.getMsgID();
        if (r1 != null) goto L19;
    L20:
        r3 = true;
    L21:
        if (r3 == true) goto L24;
        r0.message_id = r5.getMsgID();
    L24:
        if (r5.getScene() == null) goto L27;
        r0.scene = r5.getScene();
    L27:
        if (r5.isPreLoad() == false) goto L29;
        r0.is_preload(Boolean.TRUE);
    L29:
        int r7 = C0285a.a[r5.getOcrScene().ordinal()];
        if (r7 != 1) goto L32;
        r0.ocr_scene(UploadImageOCRRequest.OCRScene.OCR);
    L37:
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_IMAGE_OCR, r0, r6, b.a);
        return;
    L32:
        if (r7 != 2) goto L35;
        r0.ocr_scene(UploadImageOCRRequest.OCRScene.SCRATCH);
        goto L37
    L35:
        throw new NoWhenBranchMatchedException();
    L19:
        if (r1.length() != 0) goto L21;
    L11:
        if (FileUtils.r(r5.getLocalImagePath()) == true) goto L14;
        Log.e("ImageOCRService", "image ocr need remoteImageKey has value or local image file exists");
        r6.onError(new ErrorResult("image ocr need remoteImageKey has value or local image file exists"));
        return;
    L14:
        r0.path(r5.getLocalImagePath());
        goto L16
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
