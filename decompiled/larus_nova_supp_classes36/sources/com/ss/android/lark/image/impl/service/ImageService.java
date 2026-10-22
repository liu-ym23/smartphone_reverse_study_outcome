package com.ss.android.lark.image.impl.service;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateCustomizedStickersRequest;
import com.bytedance.lark.pb.media.v1.GetImageCompressParametersRequest;
import com.bytedance.lark.pb.media.v1.GetImageCompressParametersResponse;
import com.bytedance.lark.pb.media.v1.UploadAudioResponse;
import com.bytedance.lark.pb.media.v1.UploadAvatarRequest;
import com.bytedance.lark.pb.media.v1.UploadImageV2Request;
import com.bytedance.lark.pb.media.v1.UploadImageV2Response;
import com.bytedance.lark.pb.media.v1.UploadSecureImageRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.p;
import io.reactivex.Observable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ImageService {

    public static final class HOLDER {
        private static final ImageService INSTANCE = null;

        static {
            INSTANCE = new ImageService();
        }

        public static /* synthetic */ ImageService access$000() {
            return INSTANCE;
        }
    }

    public ImageService() {
    }

    public static /* synthetic */ String a(byte[] r0) {
        return lambda$uploadAvatar$3(r0);
    }

    public static /* synthetic */ int[] b(byte[] r0) {
        return lambda$getImageCompressParams$1(r0);
    }

    public static /* synthetic */ String c(byte[] r0) {
        return lambda$uploadProfileCoverFile$2(r0);
    }

    public static /* synthetic */ com.ss.android.lark.image.entity.d d(File r0) {
        return lambda$getImageInfo$0(r0);
    }

    public static ImageService inst() {
        return HOLDER.access$000();
    }

    private static /* synthetic */ int[] lambda$getImageCompressParams$1(byte[] r3) throws IOException {
        GetImageCompressParametersResponse r4 = (GetImageCompressParametersResponse) GetImageCompressParametersResponse.ADAPTER.decode(r3);
        return new int[]{r4.short_side.intValue(), r4.quality.intValue()};
    }

    private static /* synthetic */ com.ss.android.lark.image.entity.d lambda$getImageInfo$0(File r2) throws Exception {
        return new com.ss.android.lark.image.entity.d(r2, p.g(r2.getPath()));
    }

    private static /* synthetic */ String lambda$uploadAvatar$3(byte[] r1) throws IOException {
        return ((UploadAudioResponse) UploadAudioResponse.ADAPTER.decode(r1)).local_key;
    }

    private static /* synthetic */ String lambda$uploadProfileCoverFile$2(byte[] r1) throws IOException {
        return ((UploadImageV2Response) UploadImageV2Response.ADAPTER.decode(r1)).image_key;
    }

    public Observable<com.ss.android.lark.image.entity.d> getImageInfo(final File r2) {
        return Observable.fromCallable(new d(r2));
    }

    public void uploadAvatar(String r3, IGetDataCallback<String> r4) {
        byte[] r5 = FileUtils.j(r3);
        UploadAvatarRequest.Builder r6 = new UploadAvatarRequest.Builder().image(ByteString.of(r5)).need_mosaic(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_AVATAR, r6, r4, new b());
    }

    public void uploadProfileCoverFile(String r3, IGetDataCallback<String> r4) {
        byte[] r5 = FileUtils.j(r3);
        UploadImageV2Request.Builder r6 = new UploadImageV2Request.Builder().image(ByteString.of(r5)).image_type(UploadImageV2Request.ImageType.ProfileTopImage);
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_IMAGE_V2, r6, r4, new c());
    }

    public void uploadSticker(List<String> r3, IGetDataCallback<List<String>> r4) {
        CreateCustomizedStickersRequest.Builder r5 = new CreateCustomizedStickersRequest.Builder().type(CreateCustomizedStickersRequest.Type.IMAGE_PATH).image_paths(r3);
        SdkSender.asynSendRequestNonWrap(Command.CREATE_CUSTOMIZED_STICKERS, r5, r4, new AnonymousClass5(this));
    }

    public Observable<String> uploadEncryptImage(final File r9, final int r10, final int r11, final boolean r12, final boolean r13) {
        return Observable.create(new AnonymousClass4(this, r9, r10, r11, r12, r13));
    }

    public int[] getImageCompressParams(long r2, int r4, int r5, int r6, int r7, int r8) {
        GetImageCompressParametersRequest.Builder r3 = new GetImageCompressParametersRequest.Builder().short_side(Integer.valueOf(r4)).long_side(Integer.valueOf(r5)).quality(Integer.valueOf(r6)).image_size(Long.valueOf(r2));
        if (r7 <= 0) goto L5;
        r3.target_short_side(Integer.valueOf(r7));
    L5:
        if (r8 <= 0) goto L8;
        r3.target_quality(Integer.valueOf(r8));
    L8:
        return (int[]) SdkSender.syncSend(Command.GET_IMAGE_COMPRESS_PARAMETERS, r3, new a());
    }

    public void uploadEncryptImage(File r2, int r3, int r4, boolean r5, boolean r6, IGetDataCallback<String> r7) {
        byte[] r8 = FileUtils.j(r2.getAbsolutePath());
        if (r5 == false) goto L5;
        UploadSecureImageRequest.Type r9 = UploadSecureImageRequest.Type.POST;
    L6:
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_SECURE_IMAGE, new UploadSecureImageRequest.Builder().width(Integer.valueOf(r3)).height(Integer.valueOf(r4)).image(ByteString.of(r8)).is_secret_chat_image(Boolean.valueOf(!r6)).type(r9), new CapacityCallback(r7), new AnonymousClass2(this));
        return;
    L5:
        r9 = UploadSecureImageRequest.Type.NORMAL;
        goto L6
    }

    public Observable<com.ss.android.lark.image.entity.d> compressImage(final Context r11, final File r12, final boolean r13, final int r14, final int r15, final Biz r16, final Scene r17) {
        return Observable.fromCallable(new AnonymousClass1(this, r11, r14, r15, r13, r12, r16, r17));
    }
}
