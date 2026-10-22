package com.larus.camera.impl.utils;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001B\u0097\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\n\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010*\u001a\u00020\n\u0012\b\b\u0002\u0010+\u001a\u00020\n\u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n¢\u0006\u0004\b/\u00100J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\nHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010AJ\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010l\u001a\u00020\nHÆ\u0003J\t\u0010m\u001a\u00020\u0013HÆ\u0003J\t\u0010n\u001a\u00020\u0013HÆ\u0003J\t\u0010o\u001a\u00020\u0013HÆ\u0003J\t\u0010p\u001a\u00020\nHÆ\u0003J\t\u0010q\u001a\u00020\u0013HÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u000f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010y\u001a\u00020\nHÆ\u0003J\t\u0010z\u001a\u00020\nHÆ\u0003J\t\u0010{\u001a\u00020\nHÆ\u0003J\t\u0010|\u001a\u00020\nHÆ\u0003J\t\u0010}\u001a\u00020\nHÆ\u0003J\t\u0010~\u001a\u00020\nHÆ\u0003J\t\u0010\u007f\u001a\u00020\nHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\nHÆ\u0003J²\u0003\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\nHÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0016\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001HÖ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0013HÖ\u0001J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bD\u00108R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010FR\u0011\u0010\u0018\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bH\u0010FR\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bI\u00108R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u00108R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u00105R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u00102R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00102R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010#\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bS\u00108R\u0011\u0010$\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bT\u00108R\u0011\u0010%\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bU\u00108R\u0011\u0010&\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bV\u00108R\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bW\u00108R\u0011\u0010(\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bX\u00108R\u0011\u0010)\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bY\u00108R\u0011\u0010*\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bZ\u00108R\u0011\u0010+\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b[\u00108R\u0011\u0010,\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\\\u00108R\u0011\u0010-\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b]\u00108R\u0011\u0010.\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b^\u00108¨\u0006\u008e\u0001"}, d2 = {"Lcom/larus/camera/impl/utils/CameraData;", "Ljava/io/Serializable;", "scene", "", "captureMode", "captureModeList", "", "Lcom/larus/camera/api/params/CaptureMode;", "flashMode", "useFontCamera", "", "target", "switchTab", "eventExt", "Lcom/larus/platform/model/camera/ICameraEventExt;", "enableCaptureDetectModeList", "cameraNameUrl", "cameraName", "tipsShowOrder", "", "tips", "enableFocusFrame", "inputStyle", "albumLandingTabIndex", "addedAttachmentCount", "botSupportAlbumMultiTake", "albumMultiTakeMaxCount", "albumSupportOriginalImage", "albumInputText", "albumAttachmentUris", "albumInputSnapshotId", "albumInputSourceNodeId", "returnAlbumNodeId", "resultRoute", "Lcom/larus/camera/api/params/CameraResultRoute;", "larkScanScene", "enableCaptureTitle", "enableCaptureTips", "enableCaptureAlbum", "enableResultSuggestedAction", "enableResultMarkedTips", "mobilePreviewHostEnabled", "enableCameraAlbumQuickInput", "enableCameraAlbumUnifiedPreview", "enableCameraResultUnifiedVisual", "useUnifiedMediaCanvas", "disableCaptureDetect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/larus/platform/model/camera/ICameraEventExt;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZIIIZIZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/camera/api/params/CameraResultRoute;ZZZZZZZZZZZZ)V", "getScene", "()Ljava/lang/String;", "getCaptureMode", "getCaptureModeList", "()Ljava/util/List;", "getFlashMode", "getUseFontCamera", "()Z", "getTarget", "getSwitchTab", "getEventExt", "()Lcom/larus/platform/model/camera/ICameraEventExt;", "getEnableCaptureDetectModeList", "getCameraNameUrl", "getCameraName", "getTipsShowOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTips", "getEnableFocusFrame", "getInputStyle", "()I", "getAlbumLandingTabIndex", "getAddedAttachmentCount", "getBotSupportAlbumMultiTake", "getAlbumMultiTakeMaxCount", "getAlbumSupportOriginalImage", "getAlbumInputText", "getAlbumAttachmentUris", "getAlbumInputSnapshotId", "getAlbumInputSourceNodeId", "getReturnAlbumNodeId", "getResultRoute", "()Lcom/larus/camera/api/params/CameraResultRoute;", "getLarkScanScene", "getEnableCaptureTitle", "getEnableCaptureTips", "getEnableCaptureAlbum", "getEnableResultSuggestedAction", "getEnableResultMarkedTips", "getMobilePreviewHostEnabled", "getEnableCameraAlbumQuickInput", "getEnableCameraAlbumUnifiedPreview", "getEnableCameraResultUnifiedVisual", "getUseUnifiedMediaCanvas", "getDisableCaptureDetect", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/larus/platform/model/camera/ICameraEventExt;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZIIIZIZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/camera/api/params/CameraResultRoute;ZZZZZZZZZZZZ)Lcom/larus/camera/impl/utils/CameraData;", "equals", "other", "", "hashCode", "toString", "Companion", "Manager", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraData implements Serializable {
    public static final a Companion = null;
    public static final String PARAM_CAMERA_DATA = "param_camera_data";
    public static final CameraData a = null;
    private final int addedAttachmentCount;
    private final List<String> albumAttachmentUris;
    private final String albumInputSnapshotId;
    private final String albumInputSourceNodeId;
    private final String albumInputText;
    private final int albumLandingTabIndex;
    private final int albumMultiTakeMaxCount;
    private final boolean albumSupportOriginalImage;
    private final boolean botSupportAlbumMultiTake;
    private final String cameraName;
    private final String cameraNameUrl;
    private final String captureMode;
    private final List<CaptureMode> captureModeList;
    private final boolean disableCaptureDetect;
    private final boolean enableCameraAlbumQuickInput;
    private final boolean enableCameraAlbumUnifiedPreview;
    private final boolean enableCameraResultUnifiedVisual;
    private final boolean enableCaptureAlbum;
    private final List<String> enableCaptureDetectModeList;
    private final boolean enableCaptureTips;
    private final boolean enableCaptureTitle;
    private final boolean enableFocusFrame;
    private final boolean enableResultMarkedTips;
    private final boolean enableResultSuggestedAction;
    private final ICameraEventExt eventExt;
    private final String flashMode;
    private final int inputStyle;
    private final boolean larkScanScene;
    private final boolean mobilePreviewHostEnabled;
    private final CameraResultRoute resultRoute;
    private final String returnAlbumNodeId;
    private final String scene;
    private final boolean switchTab;
    private final String target;
    private final List<String> tips;
    private final Integer tipsShowOrder;
    private final boolean useFontCamera;
    private final boolean useUnifiedMediaCanvas;

    public static final class Manager {
        public final CoroutineScope a;
        public final StateFlowImpl b;

        public final CameraData a() {
            return (CameraData) this.b.getValue();
        }

        public Manager(LifecycleCoroutineScope r2) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            this.a = r2;
            this.b = j1.a(CameraData.access$getDEFAULT$cp());
        }

        public final void b(Bundle r50) {
            if (r50 != null) goto L5;
            return;
        L5:
            Serializable r2 = r50.getSerializable(CameraData.PARAM_CAMERA_DATA);
            if ((r2 instanceof CameraData) == false) goto L8;
            CameraData r3 = (CameraData) r2;
        L10:
            if (r3 == null) goto L13;
            FLogger.a.i("CameraData", "[init] from PARAM_CAMERA_DATA: scene=" + r3.getScene() + ", enableResultSuggestedAction=" + r3.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r3.getEnableCaptureDetectModeList() + ", captureMode=" + r3.getCaptureMode());
            c(r3);
            return;
        L13:
            Serializable r1 = r50.getSerializable("CAMERA_INPUT_PARAM");
            if ((r1 instanceof InputParam) == false) goto L16;
            InputParam r4 = (InputParam) r1;
        L17:
            if (r4 != null) goto L19;
            return;
        L19:
            InputParamExtra r5 = r4.getExtra();
            if (r5 == null) goto L24;
            String r9 = (String) r5.get("ENABLE_CAPTURE_TITLE");
            if (r9 == null) goto L24;
            boolean r38 = Boolean.parseBoolean(r9);
        L25:
            if (r5 == null) goto L29;
            String r10 = (String) r5.get("ENABLE_CAPTURE_TIPS");
            if (r10 == null) goto L29;
            boolean r39 = Boolean.parseBoolean(r10);
        L30:
            if (r5 == null) goto L34;
            String r11 = (String) r5.get("ENABLE_RESULT_SUGGESTED_ACTION");
            if (r11 == null) goto L34;
            boolean r41 = Boolean.parseBoolean(r11);
        L35:
            if (r5 == null) goto L39;
            String r12 = (String) r5.get("ENABLE_RESULT_MARKED_TIPS");
            if (r12 == null) goto L39;
            boolean r42 = Boolean.parseBoolean(r12);
        L40:
            if (r5 == null) goto L46;
            String r13 = (String) r5.get("ENABLE_CAMERA_ALBUM_QUICK_INPUT");
            if (r13 == null) goto L46;
            if (Boolean.parseBoolean(r13) != true) goto L46;
            boolean r44 = true;
        L47:
            if (r5 == null) goto L53;
            String r14 = (String) r5.get("ENABLE_CAMERA_ALBUM_UNIFIED_PREVIEW");
            if (r14 == null) goto L53;
            if (Boolean.parseBoolean(r14) != true) goto L53;
            boolean r45 = true;
        L54:
            if (r5 == null) goto L60;
            String r15 = (String) r5.get("ENABLE_CAMERA_RESULT_UNIFIED_VISUAL");
            if (r15 == null) goto L60;
            if (Boolean.parseBoolean(r15) != true) goto L60;
            boolean r46 = true;
        L61:
            String r16 = r4.getScene();
            String r17 = r4.getCaptureMode();
            List<CaptureMode> r18 = r4.getCaptureModeList();
            String r19 = r4.getFlashMode();
            boolean r110 = r4.isFrontCamera();
            String r111 = r4.getTarget();
            ICameraEventExt r112 = r4.getEventExt();
            List<String> r113 = r4.getEnableCaptureDetectModeList();
            if (r113 != null) goto L64;
            r113 = CollectionsKt.emptyList();
        L64:
            List<String> r20 = r113;
            String r21 = r4.getCameraNameUrl();
            String r22 = r4.getCameraName();
            Integer r23 = r4.getTipsShowOrder();
            List<String> r24 = r4.getTips();
            boolean r25 = r4.getEnableFocusFrame();
            int r26 = r4.getInputStyle();
            Integer r114 = r4.getAlbumLandingTabIndex();
            if (r114 == null) goto L67;
            int r27 = r114.intValue();
        L68:
            Integer r115 = r4.getAddedAttachmentCount();
            if (r115 == null) goto L71;
            int r28 = r115.intValue();
        L72:
            boolean r29 = r4.getSupportAlbumMultiTake();
            int r30 = r4.getAlbumMultiTakeMaxCount();
            boolean r31 = r4.getAlbumSupportOriginalImage();
            String r32 = r4.getAlbumInputText();
            List<String> r33 = r4.getAlbumAttachmentUris();
            InputParamExtra r116 = r4.getExtra();
            if (r116 == null) goto L75;
            String r6 = (String) r116.get("ALBUM_INPUT_SNAPSHOT_ID");
        L76:
            InputParamExtra r117 = r4.getExtra();
            if (r117 == null) goto L79;
            String r34 = (String) r117.get("ALBUM_INPUT_SOURCE_NODE_ID");
        L81:
            if (r34 != null) goto L83;
            String r35 = "";
        L84:
            InputParamExtra r36 = r4.getExtra();
            if (r36 == null) goto L87;
            String r118 = (String) r36.get("CAMERA_RETURN_ALBUM_NODE_ID");
        L88:
            if (r118 != null) goto L90;
            String r8 = "";
        L91:
            CameraResultRoute r37 = r4.getResultRoute();
            boolean r310 = r4.getLarkScanScene();
            boolean r40 = r4.getEnableCaptureAlbum();
            if (r5 == null) goto L98;
            String r43 = (String) r5.get("MOBILE_PREVIEW_HOST_ENABLED");
            if (r43 == null) goto L98;
            if (Boolean.parseBoolean(r43) != true) goto L98;
            boolean r47 = true;
        L99:
            if (r5 == null) goto L105;
            String r7 = (String) r5.get("USE_UNIFIED_MEDIA_CANVAS");
            if (r7 == null) goto L105;
            Boolean r48 = StringsKt.toBooleanStrictOrNull(r7);
            if (r48 == null) goto L105;
            boolean r49 = r48.booleanValue();
        L106:
            CameraData r119 = new CameraData(r16, r17, r18, r19, r110, r111, false, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r6, r35, r8, r37, r310, r38, r39, r40, r41, r42, r47, r44, r45, r46, r49, r4.getDisableCaptureDetect());
            FLogger.a.i("CameraData", "[init] from InputParam: scene=" + r119.getScene() + ", enableResultSuggestedAction=" + r119.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r119.getEnableCaptureDetectModeList() + ", captureMode=" + r119.getCaptureMode());
            c(r119);
            return;
        L105:
            r49 = z2.a.getNewPreviewConfig().c.a;
        L98:
            r47 = false;
            goto L99
        L90:
            r8 = r118;
            goto L91
        L87:
            r118 = null;
            goto L88
        L83:
            r35 = r34;
            goto L84
        L79:
            r34 = null;
            goto L81
        L75:
            r6 = null;
            goto L76
        L71:
            r28 = 0;
            goto L72
        L67:
            r27 = 0;
        L60:
            r46 = false;
        L53:
            r45 = false;
        L46:
            r44 = false;
        L39:
            r42 = true;
        L34:
            r41 = true;
        L29:
            r39 = true;
        L24:
            r38 = true;
            goto L25
        L16:
            r4 = null;
            goto L17
        L8:
            r3 = null;
            goto L10
        }

        public final Job c(CameraData r7) {
            return BuildersKt.launch$default(this.a, null, null, new CameraData$Manager$innerUpdate$1(this, r7, null), 3, null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraData copy$default(CameraData r17, String r18, String r19, List r20, String r21, boolean r22, String r23, boolean r24, ICameraEventExt r25, List r26, String r27, String r28, Integer r29, List r30, boolean r31, int r32, int r33, int r34, boolean r35, int r36, boolean r37, String r38, List r39, String r40, String r41, String r42, CameraResultRoute r43, boolean r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, boolean r55, int r56, int r57, Object r58) {
        if ((r56 & 1) == 0) goto L5;
        String r2 = r17.scene;
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r3 = r17.captureMode;
    L11:
        if ((r56 & 4) == 0) goto L13;
        List r4 = r17.captureModeList;
    L15:
        if ((r56 & 8) == 0) goto L17;
        String r5 = r17.flashMode;
    L19:
        if ((r56 & 16) == 0) goto L21;
        boolean r6 = r17.useFontCamera;
    L23:
        if ((r56 & 32) == 0) goto L25;
        String r7 = r17.target;
    L27:
        if ((r56 & 64) == 0) goto L29;
        boolean r8 = r17.switchTab;
    L31:
        if ((r56 & 128) == 0) goto L33;
        ICameraEventExt r9 = r17.eventExt;
    L35:
        if ((r56 & 256) == 0) goto L37;
        List r10 = r17.enableCaptureDetectModeList;
    L39:
        if ((r56 & 512) == 0) goto L41;
        String r11 = r17.cameraNameUrl;
    L43:
        if ((r56 & 1024) == 0) goto L45;
        String r12 = r17.cameraName;
    L47:
        if ((r56 & 2048) == 0) goto L49;
        Integer r13 = r17.tipsShowOrder;
    L51:
        if ((r56 & 4096) == 0) goto L53;
        List r14 = r17.tips;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        boolean r15 = r17.enableFocusFrame;
    L58:
        boolean r310 = r15;
        if ((r56 & 16384) == 0) goto L61;
        int r16 = r17.inputStyle;
    L62:
        int r311 = r16;
        if ((r56 & 32768) == 0) goto L65;
        int r110 = r17.albumLandingTabIndex;
    L66:
        int r312 = r110;
        if ((r56 & 65536) == 0) goto L69;
        int r111 = r17.addedAttachmentCount;
    L70:
        int r313 = r111;
        if ((r56 & 131072) == 0) goto L73;
        boolean r112 = r17.botSupportAlbumMultiTake;
    L74:
        boolean r314 = r112;
        if ((r56 & 262144) == 0) goto L77;
        int r113 = r17.albumMultiTakeMaxCount;
    L78:
        int r315 = r113;
        if ((r56 & 524288) == 0) goto L81;
        boolean r114 = r17.albumSupportOriginalImage;
    L82:
        boolean r316 = r114;
        if ((r56 & 1048576) == 0) goto L85;
        String r115 = r17.albumInputText;
    L86:
        String r317 = r115;
        if ((r56 & 2097152) == 0) goto L89;
        List r116 = r17.albumAttachmentUris;
    L90:
        List r318 = r116;
        if ((r56 & 4194304) == 0) goto L93;
        String r117 = r17.albumInputSnapshotId;
    L94:
        String r410 = r117;
        if ((r56 & 8388608) == 0) goto L97;
        String r118 = r17.albumInputSourceNodeId;
    L98:
        String r411 = r118;
        if ((r56 & 16777216) == 0) goto L101;
        String r119 = r17.returnAlbumNodeId;
    L102:
        String r412 = r119;
        if ((r56 & 33554432) == 0) goto L105;
        CameraResultRoute r120 = r17.resultRoute;
    L106:
        CameraResultRoute r413 = r120;
        if ((r56 & 67108864) == 0) goto L109;
        boolean r121 = r17.larkScanScene;
    L110:
        boolean r414 = r121;
        if ((r56 & 134217728) == 0) goto L113;
        boolean r122 = r17.enableCaptureTitle;
    L114:
        boolean r415 = r122;
        if ((r56 & 268435456) == 0) goto L117;
        boolean r123 = r17.enableCaptureTips;
    L118:
        boolean r416 = r123;
        if ((r56 & 536870912) == 0) goto L121;
        boolean r124 = r17.enableCaptureAlbum;
    L122:
        boolean r417 = r124;
        if ((r56 & 1073741824) == 0) goto L125;
        boolean r125 = r17.enableResultSuggestedAction;
    L127:
        if ((r56 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r1 = r17.enableResultMarkedTips;
    L130:
        boolean r418 = r1;
        if ((r57 & 1) == 0) goto L133;
        boolean r59 = r17.mobilePreviewHostEnabled;
    L134:
        boolean r510 = r59;
        if ((r57 & 2) == 0) goto L137;
        boolean r60 = r17.enableCameraAlbumQuickInput;
    L138:
        boolean r511 = r60;
        if ((r57 & 4) == 0) goto L141;
        boolean r61 = r17.enableCameraAlbumUnifiedPreview;
    L142:
        boolean r512 = r61;
        if ((r57 & 8) == 0) goto L145;
        boolean r62 = r17.enableCameraResultUnifiedVisual;
    L146:
        boolean r513 = r62;
        if ((r57 & 16) == 0) goto L149;
        boolean r63 = r17.useUnifiedMediaCanvas;
    L150:
        boolean r514 = r63;
        if ((r57 & 32) == 0) goto L153;
        boolean r64 = r17.disableCaptureDetect;
    L155:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r125, r418, r510, r511, r512, r513, r514, r64);
    L153:
        r64 = r55;
        goto L155
    L149:
        r63 = r54;
        goto L150
    L145:
        r62 = r53;
        goto L146
    L141:
        r61 = r52;
        goto L142
    L137:
        r60 = r51;
        goto L138
    L133:
        r59 = r50;
        goto L134
    L129:
        r1 = r49;
        goto L130
    L125:
        r125 = r48;
        goto L127
    L121:
        r124 = r47;
        goto L122
    L117:
        r123 = r46;
        goto L118
    L113:
        r122 = r45;
        goto L114
    L109:
        r121 = r44;
        goto L110
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.scene;
    }

    public final String component10() {
        return this.cameraNameUrl;
    }

    public final String component11() {
        return this.cameraName;
    }

    public final Integer component12() {
        return this.tipsShowOrder;
    }

    public final List<String> component13() {
        return this.tips;
    }

    public final boolean component14() {
        return this.enableFocusFrame;
    }

    public final int component15() {
        return this.inputStyle;
    }

    public final int component16() {
        return this.albumLandingTabIndex;
    }

    public final int component17() {
        return this.addedAttachmentCount;
    }

    public final boolean component18() {
        return this.botSupportAlbumMultiTake;
    }

    public final int component19() {
        return this.albumMultiTakeMaxCount;
    }

    public final String component2() {
        return this.captureMode;
    }

    public final boolean component20() {
        return this.albumSupportOriginalImage;
    }

    public final String component21() {
        return this.albumInputText;
    }

    public final List<String> component22() {
        return this.albumAttachmentUris;
    }

    public final String component23() {
        return this.albumInputSnapshotId;
    }

    public final String component24() {
        return this.albumInputSourceNodeId;
    }

    public final String component25() {
        return this.returnAlbumNodeId;
    }

    public final CameraResultRoute component26() {
        return this.resultRoute;
    }

    public final boolean component27() {
        return this.larkScanScene;
    }

    public final boolean component28() {
        return this.enableCaptureTitle;
    }

    public final boolean component29() {
        return this.enableCaptureTips;
    }

    public final List<CaptureMode> component3() {
        return this.captureModeList;
    }

    public final boolean component30() {
        return this.enableCaptureAlbum;
    }

    public final boolean component31() {
        return this.enableResultSuggestedAction;
    }

    public final boolean component32() {
        return this.enableResultMarkedTips;
    }

    public final boolean component33() {
        return this.mobilePreviewHostEnabled;
    }

    public final boolean component34() {
        return this.enableCameraAlbumQuickInput;
    }

    public final boolean component35() {
        return this.enableCameraAlbumUnifiedPreview;
    }

    public final boolean component36() {
        return this.enableCameraResultUnifiedVisual;
    }

    public final boolean component37() {
        return this.useUnifiedMediaCanvas;
    }

    public final boolean component38() {
        return this.disableCaptureDetect;
    }

    public final String component4() {
        return this.flashMode;
    }

    public final boolean component5() {
        return this.useFontCamera;
    }

    public final String component6() {
        return this.target;
    }

    public final boolean component7() {
        return this.switchTab;
    }

    public final ICameraEventExt component8() {
        return this.eventExt;
    }

    public final List<String> component9() {
        return this.enableCaptureDetectModeList;
    }

    public final CameraData copy(String r42, String r43, List<CaptureMode> r44, String r45, boolean r46, String r47, boolean r48, ICameraEventExt r49, List<String> r50, String r51, String r52, Integer r53, List<String> r54, boolean r55, int r56, int r57, int r58, boolean r59, int r60, boolean r61, String r62, List<String> r63, String r64, String r65, String r66, CameraResultRoute r67, boolean r68, boolean r69, boolean r70, boolean r71, boolean r72, boolean r73, boolean r74, boolean r75, boolean r76, boolean r77, boolean r78, boolean r79) {
        Intrinsics.checkNotNullParameter(r42, "scene");
        Intrinsics.checkNotNullParameter(r43, "captureMode");
        Intrinsics.checkNotNullParameter(r44, "captureModeList");
        Intrinsics.checkNotNullParameter(r45, "flashMode");
        Intrinsics.checkNotNullParameter(r47, "target");
        Intrinsics.checkNotNullParameter(r50, "enableCaptureDetectModeList");
        Intrinsics.checkNotNullParameter(r62, "albumInputText");
        Intrinsics.checkNotNullParameter(r63, "albumAttachmentUris");
        Intrinsics.checkNotNullParameter(r65, "albumInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r66, "returnAlbumNodeId");
        return new CameraData(r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraData) == true) goto L8;
        return false;
    L8:
        CameraData r6 = (CameraData) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.captureMode, r6.captureMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.captureModeList, r6.captureModeList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flashMode, r6.flashMode) == true) goto L21;
        return false;
    L21:
        if (this.useFontCamera == r6.useFontCamera) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L27;
        return false;
    L27:
        if (this.switchTab == r6.switchTab) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.eventExt, r6.eventExt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enableCaptureDetectModeList, r6.enableCaptureDetectModeList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cameraNameUrl, r6.cameraNameUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cameraName, r6.cameraName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tipsShowOrder, r6.tipsShowOrder) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tips, r6.tips) == true) goto L48;
        return false;
    L48:
        if (this.enableFocusFrame == r6.enableFocusFrame) goto L51;
        return false;
    L51:
        if (this.inputStyle == r6.inputStyle) goto L54;
        return false;
    L54:
        if (this.albumLandingTabIndex == r6.albumLandingTabIndex) goto L57;
        return false;
    L57:
        if (this.addedAttachmentCount == r6.addedAttachmentCount) goto L60;
        return false;
    L60:
        if (this.botSupportAlbumMultiTake == r6.botSupportAlbumMultiTake) goto L63;
        return false;
    L63:
        if (this.albumMultiTakeMaxCount == r6.albumMultiTakeMaxCount) goto L66;
        return false;
    L66:
        if (this.albumSupportOriginalImage == r6.albumSupportOriginalImage) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.albumInputText, r6.albumInputText) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.albumAttachmentUris, r6.albumAttachmentUris) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.albumInputSnapshotId, r6.albumInputSnapshotId) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.albumInputSourceNodeId, r6.albumInputSourceNodeId) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.returnAlbumNodeId, r6.returnAlbumNodeId) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.resultRoute, r6.resultRoute) == true) goto L87;
        return false;
    L87:
        if (this.larkScanScene == r6.larkScanScene) goto L90;
        return false;
    L90:
        if (this.enableCaptureTitle == r6.enableCaptureTitle) goto L93;
        return false;
    L93:
        if (this.enableCaptureTips == r6.enableCaptureTips) goto L96;
        return false;
    L96:
        if (this.enableCaptureAlbum == r6.enableCaptureAlbum) goto L99;
        return false;
    L99:
        if (this.enableResultSuggestedAction == r6.enableResultSuggestedAction) goto L102;
        return false;
    L102:
        if (this.enableResultMarkedTips == r6.enableResultMarkedTips) goto L105;
        return false;
    L105:
        if (this.mobilePreviewHostEnabled == r6.mobilePreviewHostEnabled) goto L108;
        return false;
    L108:
        if (this.enableCameraAlbumQuickInput == r6.enableCameraAlbumQuickInput) goto L111;
        return false;
    L111:
        if (this.enableCameraAlbumUnifiedPreview == r6.enableCameraAlbumUnifiedPreview) goto L114;
        return false;
    L114:
        if (this.enableCameraResultUnifiedVisual == r6.enableCameraResultUnifiedVisual) goto L117;
        return false;
    L117:
        if (this.useUnifiedMediaCanvas == r6.useUnifiedMediaCanvas) goto L120;
        return false;
    L120:
        if (this.disableCaptureDetect == r6.disableCaptureDetect) goto L122;
        return false;
    L122:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.scene.hashCode() * 31) + this.captureMode.hashCode()) * 31) + this.captureModeList.hashCode()) * 31) + this.flashMode.hashCode()) * 31;
        int r2 = 1231;
        if (this.useFontCamera == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.target.hashCode()) * 31;
        if (this.switchTab == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        ICameraEventExt r6 = this.eventExt;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r5 + r8) * 31) + this.enableCaptureDetectModeList.hashCode()) * 31;
        String r10 = this.cameraNameUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.cameraName;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.tipsShowOrder;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.tips;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        if (this.enableFocusFrame == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (((((((r21 + r22) * 31) + this.inputStyle) * 31) + this.albumLandingTabIndex) * 31) + this.addedAttachmentCount) * 31;
        if (this.botSupportAlbumMultiTake == false) goto L37;
        int r24 = 1231;
    L38:
        int r25 = (((r23 + r24) * 31) + this.albumMultiTakeMaxCount) * 31;
        if (this.albumSupportOriginalImage == false) goto L41;
        int r26 = 1231;
    L42:
        int r27 = (((((r25 + r26) * 31) + this.albumInputText.hashCode()) * 31) + this.albumAttachmentUris.hashCode()) * 31;
        String r28 = this.albumInputSnapshotId;
        if (r28 != null) goto L45;
        int r29 = 0;
    L46:
        int r30 = (((((r27 + r29) * 31) + this.albumInputSourceNodeId.hashCode()) * 31) + this.returnAlbumNodeId.hashCode()) * 31;
        CameraResultRoute r31 = this.resultRoute;
        if (r31 == null) goto L50;
        r7 = r31.hashCode();
    L50:
        int r32 = (r30 + r7) * 31;
        if (this.larkScanScene == false) goto L53;
        int r33 = 1231;
    L54:
        int r34 = (r32 + r33) * 31;
        if (this.enableCaptureTitle == false) goto L57;
        int r35 = 1231;
    L58:
        int r36 = (r34 + r35) * 31;
        if (this.enableCaptureTips == false) goto L61;
        int r37 = 1231;
    L62:
        int r38 = (r36 + r37) * 31;
        if (this.enableCaptureAlbum == false) goto L65;
        int r39 = 1231;
    L66:
        int r40 = (r38 + r39) * 31;
        if (this.enableResultSuggestedAction == false) goto L69;
        int r41 = 1231;
    L70:
        int r42 = (r40 + r41) * 31;
        if (this.enableResultMarkedTips == false) goto L73;
        int r43 = 1231;
    L74:
        int r44 = (r42 + r43) * 31;
        if (this.mobilePreviewHostEnabled == false) goto L77;
        int r45 = 1231;
    L78:
        int r46 = (r44 + r45) * 31;
        if (this.enableCameraAlbumQuickInput == false) goto L81;
        int r47 = 1231;
    L82:
        int r48 = (r46 + r47) * 31;
        if (this.enableCameraAlbumUnifiedPreview == false) goto L85;
        int r49 = 1231;
    L86:
        int r50 = (r48 + r49) * 31;
        if (this.enableCameraResultUnifiedVisual == false) goto L89;
        int r51 = 1231;
    L90:
        int r52 = (r50 + r51) * 31;
        if (this.useUnifiedMediaCanvas == false) goto L93;
        int r53 = 1231;
    L94:
        int r54 = (r52 + r53) * 31;
        if (this.disableCaptureDetect == true) goto L99;
        r2 = 1237;
    L99:
        return r54 + r2;
    L93:
        r53 = 1237;
        goto L94
    L89:
        r51 = 1237;
        goto L90
    L85:
        r49 = 1237;
        goto L86
    L81:
        r47 = 1237;
        goto L82
    L77:
        r45 = 1237;
        goto L78
    L73:
        r43 = 1237;
        goto L74
    L69:
        r41 = 1237;
        goto L70
    L65:
        r39 = 1237;
        goto L66
    L61:
        r37 = 1237;
        goto L62
    L57:
        r35 = 1237;
        goto L58
    L53:
        r33 = 1237;
        goto L54
    L45:
        r29 = r28.hashCode();
        goto L46
    L41:
        r26 = 1237;
        goto L42
    L37:
        r24 = 1237;
        goto L38
    L33:
        r22 = 1237;
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "CameraData(scene=" + this.scene + ", captureMode=" + this.captureMode + ", captureModeList=" + this.captureModeList + ", flashMode=" + this.flashMode + ", useFontCamera=" + this.useFontCamera + ", target=" + this.target + ", switchTab=" + this.switchTab + ", eventExt=" + this.eventExt + ", enableCaptureDetectModeList=" + this.enableCaptureDetectModeList + ", cameraNameUrl=" + this.cameraNameUrl + ", cameraName=" + this.cameraName + ", tipsShowOrder=" + this.tipsShowOrder + ", tips=" + this.tips + ", enableFocusFrame=" + this.enableFocusFrame + ", inputStyle=" + this.inputStyle + ", albumLandingTabIndex=" + this.albumLandingTabIndex + ", addedAttachmentCount=" + this.addedAttachmentCount + ", botSupportAlbumMultiTake=" + this.botSupportAlbumMultiTake + ", albumMultiTakeMaxCount=" + this.albumMultiTakeMaxCount + ", albumSupportOriginalImage=" + this.albumSupportOriginalImage + ", albumInputText=" + this.albumInputText + ", albumAttachmentUris=" + this.albumAttachmentUris + ", albumInputSnapshotId=" + this.albumInputSnapshotId + ", albumInputSourceNodeId=" + this.albumInputSourceNodeId + ", returnAlbumNodeId=" + this.returnAlbumNodeId + ", resultRoute=" + this.resultRoute + ", larkScanScene=" + this.larkScanScene + ", enableCaptureTitle=" + this.enableCaptureTitle + ", enableCaptureTips=" + this.enableCaptureTips + ", enableCaptureAlbum=" + this.enableCaptureAlbum + ", enableResultSuggestedAction=" + this.enableResultSuggestedAction + ", enableResultMarkedTips=" + this.enableResultMarkedTips + ", mobilePreviewHostEnabled=" + this.mobilePreviewHostEnabled + ", enableCameraAlbumQuickInput=" + this.enableCameraAlbumQuickInput + ", enableCameraAlbumUnifiedPreview=" + this.enableCameraAlbumUnifiedPreview + ", enableCameraResultUnifiedVisual=" + this.enableCameraResultUnifiedVisual + ", useUnifiedMediaCanvas=" + this.useUnifiedMediaCanvas + ", disableCaptureDetect=" + this.disableCaptureDetect + ')';
    }

    static {
        Companion = new a();
        a = new CameraData("default", "", CollectionsKt.emptyList(), "", false, "", false, null, CollectionsKt.emptyList(), null, null, null, null, false, 0, 0, 0, false, 0, false, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, -512, 63, null);
    }

    public static final /* synthetic */ CameraData access$getDEFAULT$cp() {
        return a;
    }

    public final int getAddedAttachmentCount() {
        return this.addedAttachmentCount;
    }

    public final List<String> getAlbumAttachmentUris() {
        return this.albumAttachmentUris;
    }

    public final String getAlbumInputSnapshotId() {
        return this.albumInputSnapshotId;
    }

    public final String getAlbumInputSourceNodeId() {
        return this.albumInputSourceNodeId;
    }

    public final String getAlbumInputText() {
        return this.albumInputText;
    }

    public final int getAlbumLandingTabIndex() {
        return this.albumLandingTabIndex;
    }

    public final int getAlbumMultiTakeMaxCount() {
        return this.albumMultiTakeMaxCount;
    }

    public final boolean getAlbumSupportOriginalImage() {
        return this.albumSupportOriginalImage;
    }

    public final boolean getBotSupportAlbumMultiTake() {
        return this.botSupportAlbumMultiTake;
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

    public final boolean getEnableCameraAlbumQuickInput() {
        return this.enableCameraAlbumQuickInput;
    }

    public final boolean getEnableCameraAlbumUnifiedPreview() {
        return this.enableCameraAlbumUnifiedPreview;
    }

    public final boolean getEnableCameraResultUnifiedVisual() {
        return this.enableCameraResultUnifiedVisual;
    }

    public final boolean getEnableCaptureAlbum() {
        return this.enableCaptureAlbum;
    }

    public final List<String> getEnableCaptureDetectModeList() {
        return this.enableCaptureDetectModeList;
    }

    public final boolean getEnableCaptureTips() {
        return this.enableCaptureTips;
    }

    public final boolean getEnableCaptureTitle() {
        return this.enableCaptureTitle;
    }

    public final boolean getEnableFocusFrame() {
        return this.enableFocusFrame;
    }

    public final boolean getEnableResultMarkedTips() {
        return this.enableResultMarkedTips;
    }

    public final boolean getEnableResultSuggestedAction() {
        return this.enableResultSuggestedAction;
    }

    public final ICameraEventExt getEventExt() {
        return this.eventExt;
    }

    public final String getFlashMode() {
        return this.flashMode;
    }

    public final int getInputStyle() {
        return this.inputStyle;
    }

    public final boolean getLarkScanScene() {
        return this.larkScanScene;
    }

    public final boolean getMobilePreviewHostEnabled() {
        return this.mobilePreviewHostEnabled;
    }

    public final CameraResultRoute getResultRoute() {
        return this.resultRoute;
    }

    public final String getReturnAlbumNodeId() {
        return this.returnAlbumNodeId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getSwitchTab() {
        return this.switchTab;
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

    public final boolean getUseFontCamera() {
        return this.useFontCamera;
    }

    public final boolean getUseUnifiedMediaCanvas() {
        return this.useUnifiedMediaCanvas;
    }

    public CameraData(String r13, String r14, List<CaptureMode> r15, String r16, boolean r17, String r18, boolean r19, ICameraEventExt r20, List<String> r21, String r22, String r23, Integer r24, List<String> r25, boolean r26, int r27, int r28, int r29, boolean r30, int r31, boolean r32, String r33, List<String> r34, String r35, String r36, String r37, CameraResultRoute r38, boolean r39, boolean r40, boolean r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "captureMode");
        Intrinsics.checkNotNullParameter(r15, "captureModeList");
        Intrinsics.checkNotNullParameter(r16, "flashMode");
        Intrinsics.checkNotNullParameter(r18, "target");
        Intrinsics.checkNotNullParameter(r21, "enableCaptureDetectModeList");
        Intrinsics.checkNotNullParameter(r33, "albumInputText");
        Intrinsics.checkNotNullParameter(r34, "albumAttachmentUris");
        Intrinsics.checkNotNullParameter(r36, "albumInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r37, "returnAlbumNodeId");
        this.scene = r13;
        this.captureMode = r14;
        this.captureModeList = r15;
        this.flashMode = r16;
        this.useFontCamera = r17;
        this.target = r18;
        this.switchTab = r19;
        this.eventExt = r20;
        this.enableCaptureDetectModeList = r21;
        this.cameraNameUrl = r22;
        this.cameraName = r23;
        this.tipsShowOrder = r24;
        this.tips = r25;
        this.enableFocusFrame = r26;
        this.inputStyle = r27;
        this.albumLandingTabIndex = r28;
        this.addedAttachmentCount = r29;
        this.botSupportAlbumMultiTake = r30;
        this.albumMultiTakeMaxCount = r31;
        this.albumSupportOriginalImage = r32;
        this.albumInputText = r33;
        this.albumAttachmentUris = r34;
        this.albumInputSnapshotId = r35;
        this.albumInputSourceNodeId = r36;
        this.returnAlbumNodeId = r37;
        this.resultRoute = r38;
        this.larkScanScene = r39;
        this.enableCaptureTitle = r40;
        this.enableCaptureTips = r41;
        this.enableCaptureAlbum = r42;
        this.enableResultSuggestedAction = r43;
        this.enableResultMarkedTips = r44;
        this.mobilePreviewHostEnabled = r45;
        this.enableCameraAlbumQuickInput = r46;
        this.enableCameraAlbumUnifiedPreview = r47;
        this.enableCameraResultUnifiedVisual = r48;
        this.useUnifiedMediaCanvas = r49;
        this.disableCaptureDetect = r50;
    }

    public /* synthetic */ CameraData(String r43, String r44, List r45, String r46, boolean r47, String r48, boolean r49, ICameraEventExt r50, List r51, String r52, String r53, Integer r54, List r55, boolean r56, int r57, int r58, int r59, boolean r60, int r61, boolean r62, String r63, List r64, String r65, String r66, String r67, CameraResultRoute r68, boolean r69, boolean r70, boolean r71, boolean r72, boolean r73, boolean r74, boolean r75, boolean r76, boolean r77, boolean r78, boolean r79, boolean r80, int r81, int r82, DefaultConstructorMarker r83) {
        if ((r81 & 512) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r81 & 1024) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r81 & 2048) == 0) goto L13;
        Integer r15 = null;
    L15:
        if ((r81 & 4096) == 0) goto L17;
        List r16 = null;
    L19:
        if ((r81 & 8192) == 0) goto L21;
        boolean r17 = false;
    L23:
        if ((r81 & 16384) == 0) goto L25;
        int r18 = 0;
    L27:
        if ((32768 & r81) == 0) goto L29;
        int r19 = 0;
    L31:
        if ((65536 & r81) == 0) goto L33;
        int r20 = 0;
    L35:
        if ((131072 & r81) == 0) goto L37;
        boolean r21 = false;
    L39:
        if ((262144 & r81) == 0) goto L41;
        int r22 = 0;
    L43:
        if ((524288 & r81) == 0) goto L45;
        boolean r23 = false;
    L47:
        if ((1048576 & r81) == 0) goto L49;
        String r24 = "";
    L51:
        if ((2097152 & r81) == 0) goto L53;
        List r25 = CollectionsKt.emptyList();
    L55:
        if ((4194304 & r81) == 0) goto L57;
        String r26 = null;
    L59:
        if ((8388608 & r81) == 0) goto L61;
        String r27 = "";
    L63:
        if ((16777216 & r81) == 0) goto L65;
        String r28 = "";
    L67:
        if ((33554432 & r81) == 0) goto L69;
        CameraResultRoute r29 = null;
    L71:
        if ((67108864 & r81) == 0) goto L73;
        boolean r30 = false;
    L75:
        if ((134217728 & r81) == 0) goto L77;
        boolean r31 = true;
    L79:
        if ((268435456 & r81) == 0) goto L81;
        boolean r32 = true;
    L83:
        if ((536870912 & r81) == 0) goto L85;
        boolean r33 = true;
    L87:
        if ((1073741824 & r81) == 0) goto L89;
        boolean r34 = true;
    L91:
        if ((r81 & Integer.MIN_VALUE) == 0) goto L93;
        boolean r35 = true;
    L95:
        if ((r82 & 1) == 0) goto L97;
        boolean r36 = false;
    L99:
        if ((r82 & 2) == 0) goto L101;
        boolean r37 = false;
    L103:
        if ((r82 & 4) == 0) goto L105;
        boolean r38 = false;
    L107:
        if ((r82 & 8) == 0) goto L109;
        boolean r39 = false;
    L111:
        if ((r82 & 16) == 0) goto L113;
        boolean r40 = false;
    L115:
        if ((r82 & 32) == 0) goto L117;
        boolean r41 = false;
    L118:
        this(r43, r44, r45, r46, r47, r48, r49, r50, r51, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41);
        return;
    L117:
        r41 = r80;
        goto L118
    L113:
        r40 = r79;
        goto L115
    L109:
        r39 = r78;
        goto L111
    L105:
        r38 = r77;
        goto L107
    L101:
        r37 = r76;
        goto L103
    L97:
        r36 = r75;
        goto L99
    L93:
        r35 = r74;
        goto L95
    L89:
        r34 = r73;
        goto L91
    L85:
        r33 = r72;
        goto L87
    L81:
        r32 = r71;
        goto L83
    L77:
        r31 = r70;
        goto L79
    L73:
        r30 = r69;
        goto L75
    L69:
        r29 = r68;
        goto L71
    L65:
        r28 = r67;
        goto L67
    L61:
        r27 = r66;
        goto L63
    L57:
        r26 = r65;
        goto L59
    L53:
        r25 = r64;
        goto L55
    L49:
        r24 = r63;
        goto L51
    L45:
        r23 = r62;
        goto L47
    L41:
        r22 = r61;
        goto L43
    L37:
        r21 = r60;
        goto L39
    L33:
        r20 = r59;
        goto L35
    L29:
        r19 = r58;
        goto L31
    L25:
        r18 = r57;
        goto L27
    L21:
        r17 = r56;
        goto L23
    L17:
        r16 = r55;
        goto L19
    L13:
        r15 = r54;
        goto L15
    L9:
        r14 = r53;
        goto L11
    L5:
        r13 = r52;
        goto L7
    }
}
