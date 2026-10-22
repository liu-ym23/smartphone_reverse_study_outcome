package com.larus.camera.api.params;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.model.camera.ICameraEventExt;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\bP\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 ¡\u00012\u00020\u0001:\u0006 \u0001¡\u0001¢\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u009a\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0096\u0002J\t\u0010\u009d\u0001\u001a\u000208H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0005H\u0016J\u0007\u0010\u009f\u0001\u001a\u00020\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001a\u0010.\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001e\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0011\"\u0004\b@\u0010\u0013R\u001a\u0010A\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0019\"\u0004\bC\u0010\u001bR\u001a\u0010D\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010\u001bR\u001a\u0010G\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0019\"\u0004\bI\u0010\u001bR\u001a\u0010J\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0019\"\u0004\bL\u0010\u001bR\u001c\u0010M\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\tR\u001c\u0010P\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR\u001a\u0010S\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bR\u001a\u0010U\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0019\"\u0004\bV\u0010\u001bR\u001a\u0010W\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0019\"\u0004\bY\u0010\u001bR\u001c\u0010Z\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0007\"\u0004\b\\\u0010\tR\u001c\u0010]\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0007\"\u0004\b_\u0010\tR\u001a\u0010`\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0019\"\u0004\bg\u0010\u001bR\u001e\u0010h\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\bi\u0010:\"\u0004\bj\u0010<R\u001e\u0010k\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\bl\u0010:\"\u0004\bm\u0010<R\u001a\u0010n\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0019\"\u0004\bp\u0010\u001bR\u001a\u0010q\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010b\"\u0004\bs\u0010dR\u001a\u0010t\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0019\"\u0004\bv\u0010\u001bR\u001a\u0010w\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0019\"\u0004\by\u0010\u001bR\u001a\u0010z\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0019\"\u0004\b|\u0010\u001bR\u001a\u0010}\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0007\"\u0004\b\u007f\u0010\tR#\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0011\"\u0005\b\u0082\u0001\u0010\u0013R\u001d\u0010\u0083\u0001\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0019\"\u0005\b\u0085\u0001\u0010\u001bR\u001d\u0010\u0086\u0001\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0019\"\u0005\b\u0087\u0001\u0010\u001bR\"\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001¨\u0006£\u0001"}, d2 = {"Lcom/larus/camera/api/params/InputParam;", "Ljava/io/Serializable;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "captureMode", "getCaptureMode", "setCaptureMode", "captureModeList", "", "Lcom/larus/camera/api/params/CaptureMode;", "getCaptureModeList", "()Ljava/util/List;", "setCaptureModeList", "(Ljava/util/List;)V", "flashMode", "getFlashMode", "setFlashMode", "isFrontCamera", "", "()Z", "setFrontCamera", "(Z)V", "target", "getTarget", "setTarget", "eventExt", "Lcom/larus/platform/model/camera/ICameraEventExt;", "getEventExt", "()Lcom/larus/platform/model/camera/ICameraEventExt;", "setEventExt", "(Lcom/larus/platform/model/camera/ICameraEventExt;)V", "extra", "Lcom/larus/camera/api/params/InputParamExtra;", "getExtra", "()Lcom/larus/camera/api/params/InputParamExtra;", "setExtra", "(Lcom/larus/camera/api/params/InputParamExtra;)V", "enableCaptureDetectModeList", "getEnableCaptureDetectModeList", "setEnableCaptureDetectModeList", "disableCaptureDetect", "getDisableCaptureDetect", "setDisableCaptureDetect", "cameraNameUrl", "getCameraNameUrl", "setCameraNameUrl", "cameraName", "getCameraName", "setCameraName", "tipsShowOrder", "", "getTipsShowOrder", "()Ljava/lang/Integer;", "setTipsShowOrder", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tips", "getTips", "setTips", "enableFocusFrame", "getEnableFocusFrame", "setEnableFocusFrame", "supportMark", "getSupportMark", "setSupportMark", "supportCrop", "getSupportCrop", "setSupportCrop", "supportMultiImages", "getSupportMultiImages", "setSupportMultiImages", "botId", "getBotId", "setBotId", "showFrom", "getShowFrom", "setShowFrom", "isFromChatAttachment", "setFromChatAttachment", "isInjectInputMode", "setInjectInputMode", "shouldNotify", "getShouldNotify", "setShouldNotify", "enterMethod", "getEnterMethod", "setEnterMethod", "enterChatMethod", "getEnterChatMethod", "setEnterChatMethod", "inputStyle", "getInputStyle", "()I", "setInputStyle", "(I)V", "supportRecord", "getSupportRecord", "setSupportRecord", "albumLandingTabIndex", "getAlbumLandingTabIndex", "setAlbumLandingTabIndex", "addedAttachmentCount", "getAddedAttachmentCount", "setAddedAttachmentCount", "supportAlbumMultiTake", "getSupportAlbumMultiTake", "setSupportAlbumMultiTake", "albumMultiTakeMaxCount", "getAlbumMultiTakeMaxCount", "setAlbumMultiTakeMaxCount", "albumSupportOriginalImage", "getAlbumSupportOriginalImage", "setAlbumSupportOriginalImage", "enableCaptureAlbum", "getEnableCaptureAlbum", "setEnableCaptureAlbum", "enableOriginalImageDeferredEdit", "getEnableOriginalImageDeferredEdit", "setEnableOriginalImageDeferredEdit", "albumInputText", "getAlbumInputText", "setAlbumInputText", "albumAttachmentUris", "getAlbumAttachmentUris", "setAlbumAttachmentUris", "larkScanScene", "getLarkScanScene", "setLarkScanScene", "isFromMarkPage", "setFromMarkPage", "initialImageEditMode", "Lcom/larus/camera/api/params/InputParam$InitialImageEditMode;", "getInitialImageEditMode", "()Lcom/larus/camera/api/params/InputParam$InitialImageEditMode;", "setInitialImageEditMode", "(Lcom/larus/camera/api/params/InputParam$InitialImageEditMode;)V", "resultRoute", "Lcom/larus/camera/api/params/CameraResultRoute;", "getResultRoute", "()Lcom/larus/camera/api/params/CameraResultRoute;", "setResultRoute", "(Lcom/larus/camera/api/params/CameraResultRoute;)V", "initialOutputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "getInitialOutputContext", "()Lcom/larus/camera/api/params/CameraOutputContext;", "setInitialOutputContext", "(Lcom/larus/camera/api/params/CameraOutputContext;)V", "equals", "other", "", "hashCode", "toString", "deepCopy", "InitialImageEditMode", "Companion", "Builder", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputParam implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private Integer addedAttachmentCount;
    private List<String> albumAttachmentUris;
    private String albumInputText;
    private Integer albumLandingTabIndex;
    private int albumMultiTakeMaxCount;
    private boolean albumSupportOriginalImage;
    private String botId;
    private String cameraName;
    private String cameraNameUrl;
    private String captureMode;
    private List<CaptureMode> captureModeList;
    private boolean disableCaptureDetect;
    private boolean enableCaptureAlbum;
    private List<String> enableCaptureDetectModeList;
    private boolean enableFocusFrame;
    private boolean enableOriginalImageDeferredEdit;
    private String enterChatMethod;
    private String enterMethod;
    private ICameraEventExt eventExt;
    private InputParamExtra extra;
    private String flashMode;
    private InitialImageEditMode initialImageEditMode;
    private CameraOutputContext initialOutputContext;
    private int inputStyle;
    private boolean isFromChatAttachment;
    private boolean isFromMarkPage;
    private boolean isFrontCamera;
    private boolean isInjectInputMode;
    private boolean larkScanScene;
    private CameraResultRoute resultRoute;
    private String scene;
    private boolean shouldNotify;
    private String showFrom;
    private boolean supportAlbumMultiTake;
    private boolean supportCrop;
    private boolean supportMark;
    private boolean supportMultiImages;
    private boolean supportRecord;
    private String target;
    private List<String> tips;
    private Integer tipsShowOrder;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/camera/api/params/InputParam$InitialImageEditMode;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MARK", "CROP", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InitialImageEditMode extends Enum<InitialImageEditMode> implements Serializable {
        public static final InitialImageEditMode CROP = null;
        public static final InitialImageEditMode MARK = null;
        public static final InitialImageEditMode NONE = null;
        public static final /* synthetic */ InitialImageEditMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InitialImageEditMode> getEntries() {
            return b;
        }

        static {
            InitialImageEditMode r0 = new InitialImageEditMode("NONE", 0);
            NONE = r0;
            InitialImageEditMode r1 = new InitialImageEditMode("MARK", 1);
            MARK = r1;
            InitialImageEditMode r3 = new InitialImageEditMode("CROP", 2);
            CROP = r3;
            InitialImageEditMode[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static InitialImageEditMode[] values() {
            return (InitialImageEditMode[]) a.clone();
        }

        public static InitialImageEditMode valueOf(String r1) {
            return (InitialImageEditMode) r27.a.a(InitialImageEditMode.class, r1);
        }

        public InitialImageEditMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* synthetic */ InputParam(DefaultConstructorMarker r1) {
        this();
    }

    public final InputParam deepCopy() {
        String r0 = this.scene;
        Intrinsics.checkNotNullParameter(r0, "scene");
        InputParam r1 = new InputParam(null);
        r1.setScene(r0);
        List<CaptureMode> r2 = this.captureModeList;
        String r3 = this.captureMode;
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        r1.setCaptureModeList(r2);
        r1.setCaptureMode(r3);
        String r4 = this.flashMode;
        Intrinsics.checkNotNullParameter(r4, "flashMode");
        r1.setFlashMode(r4);
        r1.setFrontCamera(this.isFrontCamera);
        String r5 = this.target;
        Intrinsics.checkNotNullParameter(r5, "target");
        r1.setTarget(r5);
        r1.setEventExt(this.eventExt);
        r1.setEnableCaptureDetectModeList(this.enableCaptureDetectModeList);
        r1.setCameraNameUrl(this.cameraNameUrl);
        r1.setCameraName(this.cameraName);
        r1.setTipsShowOrder(this.tipsShowOrder);
        r1.setTips(this.tips);
        r1.setEnableFocusFrame(this.enableFocusFrame);
        r1.setSupportMark(this.supportMark);
        r1.setSupportCrop(this.supportCrop);
        r1.setSupportMultiImages(this.supportMultiImages);
        r1.setBotId(this.botId);
        r1.setShowFrom(this.showFrom);
        r1.setFromChatAttachment(this.isFromChatAttachment);
        r1.setInjectInputMode(this.isInjectInputMode);
        r1.setShouldNotify(this.shouldNotify);
        r1.setEnterMethod(this.enterMethod);
        r1.setInputStyle(this.inputStyle);
        r1.setSupportRecord(this.supportRecord);
        r1.setAlbumLandingTabIndex(this.albumLandingTabIndex);
        r1.setAddedAttachmentCount(this.addedAttachmentCount);
        r1.setSupportAlbumMultiTake(this.supportAlbumMultiTake);
        r1.setAlbumMultiTakeMaxCount(this.albumMultiTakeMaxCount);
        r1.setEnableCaptureAlbum(this.enableCaptureAlbum);
        String r6 = this.albumInputText;
        List<String> r7 = this.albumAttachmentUris;
        Intrinsics.checkNotNullParameter(r6, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r7, "attachmentUris");
        r1.setAlbumInputText(r6);
        r1.setAlbumAttachmentUris(r7);
        r1.setLarkScanScene(this.larkScanScene);
        r1.setFromMarkPage(this.isFromMarkPage);
        r1.setResultRoute(this.resultRoute);
        r1.setInitialOutputContext(this.initialOutputContext);
        r1.extra = this.extra;
        r1.disableCaptureDetect = this.disableCaptureDetect;
        r1.initialImageEditMode = this.initialImageEditMode;
        return r1;
    }

    public String toString() {
        return "scene=" + this.scene + ",captureMode=" + this.captureMode + ",flashMode=" + this.flashMode + ",isFrontCamera=" + this.isFrontCamera + ",target=" + this.target + ",captureModeList=" + this.captureModeList + ",isFromMarkPage=" + this.isFromMarkPage + ",initialImageEditMode=" + this.initialImageEditMode;
    }

    private InputParam() {
        this.scene = "default";
        this.captureMode = "CAPTURE_MODE_PHOTO";
        this.captureModeList = CollectionsKt.emptyList();
        this.flashMode = "FLASH_MODE_AUTO";
        this.target = "TARGET_SHOW_GET";
        this.albumLandingTabIndex = 0;
        this.addedAttachmentCount = 0;
        this.enableCaptureAlbum = true;
        this.albumInputText = "";
        this.albumAttachmentUris = CollectionsKt.emptyList();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final Integer getAddedAttachmentCount() {
        return this.addedAttachmentCount;
    }

    public final List<String> getAlbumAttachmentUris() {
        return this.albumAttachmentUris;
    }

    public final String getAlbumInputText() {
        return this.albumInputText;
    }

    public final Integer getAlbumLandingTabIndex() {
        return this.albumLandingTabIndex;
    }

    public final int getAlbumMultiTakeMaxCount() {
        return this.albumMultiTakeMaxCount;
    }

    public final boolean getAlbumSupportOriginalImage() {
        return this.albumSupportOriginalImage;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getCameraName() {
        return this.cameraName;
    }

    public final String getCameraNameUrl() {
        return this.cameraNameUrl;
    }

    public final String getCaptureMode() {
        return this.captureMode;
    }

    public final List<CaptureMode> getCaptureModeList() {
        return this.captureModeList;
    }

    public final boolean getDisableCaptureDetect() {
        return this.disableCaptureDetect;
    }

    public final boolean getEnableCaptureAlbum() {
        return this.enableCaptureAlbum;
    }

    public final List<String> getEnableCaptureDetectModeList() {
        return this.enableCaptureDetectModeList;
    }

    public final boolean getEnableFocusFrame() {
        return this.enableFocusFrame;
    }

    public final boolean getEnableOriginalImageDeferredEdit() {
        return this.enableOriginalImageDeferredEdit;
    }

    public final String getEnterChatMethod() {
        return this.enterChatMethod;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final ICameraEventExt getEventExt() {
        return this.eventExt;
    }

    public final InputParamExtra getExtra() {
        return this.extra;
    }

    public final String getFlashMode() {
        return this.flashMode;
    }

    public final InitialImageEditMode getInitialImageEditMode() {
        return this.initialImageEditMode;
    }

    public final CameraOutputContext getInitialOutputContext() {
        return this.initialOutputContext;
    }

    public final int getInputStyle() {
        return this.inputStyle;
    }

    public final boolean getLarkScanScene() {
        return this.larkScanScene;
    }

    public final CameraResultRoute getResultRoute() {
        return this.resultRoute;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final String getShowFrom() {
        return this.showFrom;
    }

    public final boolean getSupportAlbumMultiTake() {
        return this.supportAlbumMultiTake;
    }

    public final boolean getSupportCrop() {
        return this.supportCrop;
    }

    public final boolean getSupportMark() {
        return this.supportMark;
    }

    public final boolean getSupportMultiImages() {
        return this.supportMultiImages;
    }

    public final boolean getSupportRecord() {
        return this.supportRecord;
    }

    public final String getTarget() {
        return this.target;
    }

    public final List<String> getTips() {
        return this.tips;
    }

    public final Integer getTipsShowOrder() {
        return this.tipsShowOrder;
    }

    public final boolean isFromChatAttachment() {
        return this.isFromChatAttachment;
    }

    public final boolean isFromMarkPage() {
        return this.isFromMarkPage;
    }

    public final boolean isFrontCamera() {
        return this.isFrontCamera;
    }

    public final boolean isInjectInputMode() {
        return this.isInjectInputMode;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof InputParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((InputParam) r2).toString());
    }

    public final void setAddedAttachmentCount(Integer r1) {
        this.addedAttachmentCount = r1;
    }

    public final void setAlbumAttachmentUris(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.albumAttachmentUris = r2;
    }

    public final void setAlbumInputText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.albumInputText = r2;
    }

    public final void setAlbumLandingTabIndex(Integer r1) {
        this.albumLandingTabIndex = r1;
    }

    public final void setAlbumMultiTakeMaxCount(int r1) {
        this.albumMultiTakeMaxCount = r1;
    }

    public final void setAlbumSupportOriginalImage(boolean r1) {
        this.albumSupportOriginalImage = r1;
    }

    public final void setBotId(String r1) {
        this.botId = r1;
    }

    public final void setCameraName(String r1) {
        this.cameraName = r1;
    }

    public final void setCameraNameUrl(String r1) {
        this.cameraNameUrl = r1;
    }

    public final void setCaptureMode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.captureMode = r2;
    }

    public final void setCaptureModeList(List<CaptureMode> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.captureModeList = r2;
    }

    public final void setDisableCaptureDetect(boolean r1) {
        this.disableCaptureDetect = r1;
    }

    public final void setEnableCaptureAlbum(boolean r1) {
        this.enableCaptureAlbum = r1;
    }

    public final void setEnableCaptureDetectModeList(List<String> r1) {
        this.enableCaptureDetectModeList = r1;
    }

    public final void setEnableFocusFrame(boolean r1) {
        this.enableFocusFrame = r1;
    }

    public final void setEnableOriginalImageDeferredEdit(boolean r1) {
        this.enableOriginalImageDeferredEdit = r1;
    }

    public final void setEnterChatMethod(String r1) {
        this.enterChatMethod = r1;
    }

    public final void setEnterMethod(String r1) {
        this.enterMethod = r1;
    }

    public final void setEventExt(ICameraEventExt r1) {
        this.eventExt = r1;
    }

    public final void setExtra(InputParamExtra r1) {
        this.extra = r1;
    }

    public final void setFlashMode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.flashMode = r2;
    }

    public final void setFromChatAttachment(boolean r1) {
        this.isFromChatAttachment = r1;
    }

    public final void setFromMarkPage(boolean r1) {
        this.isFromMarkPage = r1;
    }

    public final void setFrontCamera(boolean r1) {
        this.isFrontCamera = r1;
    }

    public final void setInitialImageEditMode(InitialImageEditMode r1) {
        this.initialImageEditMode = r1;
    }

    public final void setInitialOutputContext(CameraOutputContext r1) {
        this.initialOutputContext = r1;
    }

    public final void setInjectInputMode(boolean r1) {
        this.isInjectInputMode = r1;
    }

    public final void setInputStyle(int r1) {
        this.inputStyle = r1;
    }

    public final void setLarkScanScene(boolean r1) {
        this.larkScanScene = r1;
    }

    public final void setResultRoute(CameraResultRoute r1) {
        this.resultRoute = r1;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public final void setShouldNotify(boolean r1) {
        this.shouldNotify = r1;
    }

    public final void setShowFrom(String r1) {
        this.showFrom = r1;
    }

    public final void setSupportAlbumMultiTake(boolean r1) {
        this.supportAlbumMultiTake = r1;
    }

    public final void setSupportCrop(boolean r1) {
        this.supportCrop = r1;
    }

    public final void setSupportMark(boolean r1) {
        this.supportMark = r1;
    }

    public final void setSupportMultiImages(boolean r1) {
        this.supportMultiImages = r1;
    }

    public final void setSupportRecord(boolean r1) {
        this.supportRecord = r1;
    }

    public final void setTarget(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.target = r2;
    }

    public final void setTips(List<String> r1) {
        this.tips = r1;
    }

    public final void setTipsShowOrder(Integer r1) {
        this.tipsShowOrder = r1;
    }
}
