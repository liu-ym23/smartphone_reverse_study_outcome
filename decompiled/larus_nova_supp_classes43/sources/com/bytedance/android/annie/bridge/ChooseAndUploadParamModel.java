package com.bytedance.android.annie.bridge;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0004D\rEFB\u0007¢\u0006\u0004\bB\u0010CR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R0\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R$\u0010?\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010*\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.¨\u0006G"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel;", "", "", "", "mediaType", "Ljava/util/List;", "getMediaType", "()Ljava/util/List;", "setMediaType", "(Ljava/util/List;)V", "", "maxCount", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "sourceType", "Ljava/lang/String;", "getSourceType", "()Ljava/lang/String;", "setSourceType", "(Ljava/lang/String;)V", "cameraType", "getCameraType", "setCameraType", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$a;", "imageParams", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$a;", "getImageParams", "()Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$a;", "setImageParams", "(Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$a;)V", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$b;", "videoParams", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$b;", "getVideoParams", "()Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$b;", "setVideoParams", "(Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$b;)V", "", "needBase64Data", "Ljava/lang/Boolean;", "getNeedBase64Data", "()Ljava/lang/Boolean;", "setNeedBase64Data", "(Ljava/lang/Boolean;)V", "saveToPhotoAlbum", "getSaveToPhotoAlbum", "setSaveToPhotoAlbum", com.bytedance.android.ec.core.event.a.KEY_URL, "getUrl", "setUrl", "", "header", "Ljava/util/Map;", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "params", "getParams", "setParams", "needCommonParams", "getNeedCommonParams", "setNeedCommonParams", "<init>", "()V", "CameraType", "b", "SourceType", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ChooseAndUploadParamModel {

    @SerializedName("cameraType")
    private String cameraType;

    @SerializedName("header")
    private Map<String, ? extends Object> header;

    @SerializedName("imageParams")
    private a imageParams;

    @SerializedName("maxCount")
    private Integer maxCount;

    @SerializedName("mediaType")
    private List<String> mediaType;

    @SerializedName("needBase64Data")
    private Boolean needBase64Data;

    @SerializedName("needCommonParams")
    private Boolean needCommonParams;

    @SerializedName("params")
    private Map<String, ? extends Object> params;

    @SerializedName("saveToPhotoAlbum")
    private Boolean saveToPhotoAlbum;

    @SerializedName("sourceType")
    private String sourceType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    @SerializedName("videoParams")
    private b videoParams;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$CameraType;", "", "", "cameraType", com.bytedance.android.ec.core.event.a.KEY_FROM, "toString", "Front", "Back", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CameraType extends Enum<CameraType> {
        public static final CameraType Back = null;
        public static final CameraType Front = null;
        public static final /* synthetic */ CameraType[] a = null;

        public static CameraType valueOf(String r1) {
            return (CameraType) r27.a.a(CameraType.class, r1);
        }

        public static CameraType[] values() {
            return (CameraType[]) a.clone();
        }

        static {
            CameraType r0 = new CameraType("Front", 0);
            Front = r0;
            CameraType r1 = new CameraType("Back", 1);
            Back = r1;
            a = new CameraType[]{r0, r1};
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Front) goto L6;
            return "front";
        L6:
            if (this != Back) goto L8;
            return "back";
        L8:
            return "";
        }

        public CameraType from(String r10) {
            Intrinsics.checkNotNullParameter(r10, "cameraType");
            String r11 = r10.toLowerCase();
            if (TextUtils.equals("front", r11) == false) goto L7;
            return Front;
        L7:
            if (TextUtils.equals("denied", r11) == true) goto L9;
            return null;
        L9:
            return Back;
        }

        public CameraType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$SourceType;", "", "", "sourceType", com.bytedance.android.ec.core.event.a.KEY_FROM, "toString", "Album", "Camera", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType Album = null;
        public static final SourceType Camera = null;
        public static final /* synthetic */ SourceType[] a = null;

        public static SourceType valueOf(String r1) {
            return (SourceType) r27.a.a(SourceType.class, r1);
        }

        public static SourceType[] values() {
            return (SourceType[]) a.clone();
        }

        static {
            SourceType r0 = new SourceType("Album", 0);
            Album = r0;
            SourceType r1 = new SourceType("Camera", 1);
            Camera = r1;
            a = new SourceType[]{r0, r1};
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Album) goto L6;
            return "album";
        L6:
            if (this != Camera) goto L8;
            return "camera";
        L8:
            return "";
        }

        public SourceType from(String r10) {
            Intrinsics.checkNotNullParameter(r10, "sourceType");
            String r11 = r10.toLowerCase();
            if (TextUtils.equals("album", r11) == false) goto L7;
            return Album;
        L7:
            if (TextUtils.equals("denied", r11) == true) goto L9;
            return null;
        L9:
            return Camera;
        }

        public SourceType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$a;", "", "", "cropWidth", "Ljava/lang/String;", "getCropWidth", "()Ljava/lang/String;", "setCropWidth", "(Ljava/lang/String;)V", "cropHeight", "getCropHeight", "setCropHeight", "", "compressMaxSize", "Ljava/lang/Integer;", "getCompressMaxSize", "()Ljava/lang/Integer;", "setCompressMaxSize", "(Ljava/lang/Integer;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("compressMaxSize")
        private Integer compressMaxSize;

        @SerializedName("cropHeight")
        private String cropHeight;

        @SerializedName("cropWidth")
        private String cropWidth;

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadParamModel$b;", "", "", "durationLimit", "Ljava/lang/Integer;", "getDurationLimit", "()Ljava/lang/Integer;", "setDurationLimit", "(Ljava/lang/Integer;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("durationLimit")
        private Integer durationLimit;

        public b() {
        }
    }

    public ChooseAndUploadParamModel() {
        this.url = "";
    }

    public final Integer a() {
        return this.maxCount;
    }
}
