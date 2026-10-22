package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\bq\b\u0003\u0018\u00002\u00020\u0001BÓ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020!\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020!\u0012\b\b\u0002\u0010,\u001a\u00020!\u0012\b\b\u0002\u0010-\u001a\u00020!\u0012\b\b\u0002\u0010.\u001a\u00020!\u0012\b\b\u0002\u0010/\u001a\u00020!\u0012\b\b\u0002\u00100\u001a\u00020!\u0012\b\b\u0002\u00101\u001a\u00020!\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\b\b\u0002\u00103\u001a\u00020!¢\u0006\u0004\b4\u00105R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010?\"\u0004\bK\u0010AR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00107\"\u0004\bO\u00109R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00107\"\u0004\bQ\u00109R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010?\"\u0004\bU\u0010AR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00107\"\u0004\bW\u00109R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R\u001a\u0010\u0016\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\u001a\u0010\u0017\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010Y\"\u0004\be\u0010[R\u001a\u0010\u001a\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010Y\"\u0004\bi\u0010[R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[R\u001a\u0010\u001d\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Y\"\u0004\bm\u0010[R\u001a\u0010\u001e\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010Y\"\u0004\bo\u0010[R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010Y\"\u0004\bq\u0010[R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010r\"\u0004\bs\u0010tR\u001a\u0010\"\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010r\"\u0004\bu\u0010tR\u001a\u0010#\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u001a\u0010$\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010r\"\u0004\by\u0010tR\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010?\"\u0004\b{\u0010AR\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010?\"\u0004\b}\u0010AR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010?\"\u0004\b\u007f\u0010AR\u001c\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010?\"\u0005\b\u0081\u0001\u0010AR\u001c\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010r\"\u0005\b\u0083\u0001\u0010tR\u001c\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010?\"\u0005\b\u0085\u0001\u0010AR\u001c\u0010+\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010r\"\u0005\b\u0087\u0001\u0010tR\u001b\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b,\u0010r\"\u0005\b\u0088\u0001\u0010tR\u001b\u0010-\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b-\u0010r\"\u0005\b\u0089\u0001\u0010tR\u001b\u0010.\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b.\u0010r\"\u0005\b\u008a\u0001\u0010tR\u001b\u0010/\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b/\u0010r\"\u0005\b\u008b\u0001\u0010tR\u001b\u00100\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b0\u0010r\"\u0005\b\u008c\u0001\u0010tR\u001b\u00101\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b1\u0010r\"\u0005\b\u008d\u0001\u0010tR\u001c\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010?\"\u0005\b\u008f\u0001\u0010AR\u001c\u00103\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010r\"\u0005\b\u0091\u0001\u0010t¨\u0006\u0092\u0001"}, d2 = {"Lcom/ss/android/lark/chat/service/impl/MediaMessageReport;", BuildConfig.FLAVOR, "originFPS", BuildConfig.FLAVOR, "originFileSize", "originBitrate", "originVideoSize", BuildConfig.FLAVOR, "originVideoFormat", "originEncodeFormat", "originLastModifyDiff", "videoDuration", "videoSource", "resultFPS", "resultFileSize", "resultBitrate", "resultVideoSize", "resultEncodeFormat", "compressCoverFileSize", "pickStart", BuildConfig.FLAVOR, "sendStart", "preStart", "preMerged", "compressStart", "totalDuration", "pickDuration", "preDuration", "compressDuration", "uploadDuration", "compressUploadDuration", "sendDuration", "isRemux", BuildConfig.FLAVOR, "isHDR", "unenabledEemuxCode", "useWeakNetSetting", "compileScene", "compileQuality", ChameleonOpenTracker.ParamKey.RESULT, "errorType", "errorCode", ChameleonOpenTracker.ParamKey.ERRORMSG, "errorStatus", "isRaw", "isOriginal", "isUseCache", "isMergePreCompress", "isCompressUpload", "isCompressUploadSuccess", "compressUploadFailedMsg", "sendNetStatus", "<init>", "(FFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FJJJJJJJJJJJJIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIILjava/lang/String;I)V", "getOriginFPS", "()F", "setOriginFPS", "(F)V", "getOriginFileSize", "setOriginFileSize", "getOriginBitrate", "setOriginBitrate", "getOriginVideoSize", "()Ljava/lang/String;", "setOriginVideoSize", "(Ljava/lang/String;)V", "getOriginVideoFormat", "setOriginVideoFormat", "getOriginEncodeFormat", "setOriginEncodeFormat", "getOriginLastModifyDiff", "setOriginLastModifyDiff", "getVideoDuration", "setVideoDuration", "getVideoSource", "setVideoSource", "getResultFPS", "setResultFPS", "getResultFileSize", "setResultFileSize", "getResultBitrate", "setResultBitrate", "getResultVideoSize", "setResultVideoSize", "getResultEncodeFormat", "setResultEncodeFormat", "getCompressCoverFileSize", "setCompressCoverFileSize", "getPickStart", "()J", "setPickStart", "(J)V", "getSendStart", "setSendStart", "getPreStart", "setPreStart", "getPreMerged", "setPreMerged", "getCompressStart", "setCompressStart", "getTotalDuration", "setTotalDuration", "getPickDuration", "setPickDuration", "getPreDuration", "setPreDuration", "getCompressDuration", "setCompressDuration", "getUploadDuration", "setUploadDuration", "getCompressUploadDuration", "setCompressUploadDuration", "getSendDuration", "setSendDuration", "()I", "setRemux", "(I)V", "setHDR", "getUnenabledEemuxCode", "setUnenabledEemuxCode", "getUseWeakNetSetting", "setUseWeakNetSetting", "getCompileScene", "setCompileScene", "getCompileQuality", "setCompileQuality", "getResult", "setResult", "getErrorType", "setErrorType", "getErrorCode", "setErrorCode", "getErrorMsg", "setErrorMsg", "getErrorStatus", "setErrorStatus", "setRaw", "setOriginal", "setUseCache", "setMergePreCompress", "setCompressUpload", "setCompressUploadSuccess", "getCompressUploadFailedMsg", "setCompressUploadFailedMsg", "getSendNetStatus", "setSendNetStatus", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MediaMessageReport {
    private String compileQuality;
    private String compileScene;
    private float compressCoverFileSize;
    private long compressDuration;
    private long compressStart;
    private long compressUploadDuration;
    private String compressUploadFailedMsg;
    private int errorCode;
    private String errorMsg;
    private int errorStatus;
    private String errorType;
    private int isCompressUpload;
    private int isCompressUploadSuccess;
    private int isHDR;
    private int isMergePreCompress;
    private int isOriginal;
    private int isRaw;
    private int isRemux;
    private int isUseCache;
    private float originBitrate;
    private String originEncodeFormat;
    private float originFPS;
    private float originFileSize;
    private float originLastModifyDiff;
    private String originVideoFormat;
    private String originVideoSize;
    private long pickDuration;
    private long pickStart;
    private long preDuration;
    private long preMerged;
    private long preStart;
    private String result;
    private float resultBitrate;
    private String resultEncodeFormat;
    private float resultFPS;
    private float resultFileSize;
    private String resultVideoSize;
    private long sendDuration;
    private int sendNetStatus;
    private long sendStart;
    private long totalDuration;
    private int unenabledEemuxCode;
    private long uploadDuration;
    private int useWeakNetSetting;
    private float videoDuration;
    private String videoSource;

    public MediaMessageReport() {
        this(0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, 0, -1, 16383, null);
    }

    public final String getCompileQuality() {
        return this.compileQuality;
    }

    public final String getCompileScene() {
        return this.compileScene;
    }

    public final float getCompressCoverFileSize() {
        return this.compressCoverFileSize;
    }

    public final long getCompressDuration() {
        return this.compressDuration;
    }

    public final long getCompressStart() {
        return this.compressStart;
    }

    public final long getCompressUploadDuration() {
        return this.compressUploadDuration;
    }

    public final String getCompressUploadFailedMsg() {
        return this.compressUploadFailedMsg;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getErrorStatus() {
        return this.errorStatus;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final float getOriginBitrate() {
        return this.originBitrate;
    }

    public final String getOriginEncodeFormat() {
        return this.originEncodeFormat;
    }

    public final float getOriginFPS() {
        return this.originFPS;
    }

    public final float getOriginFileSize() {
        return this.originFileSize;
    }

    public final float getOriginLastModifyDiff() {
        return this.originLastModifyDiff;
    }

    public final String getOriginVideoFormat() {
        return this.originVideoFormat;
    }

    public final String getOriginVideoSize() {
        return this.originVideoSize;
    }

    public final long getPickDuration() {
        return this.pickDuration;
    }

    public final long getPickStart() {
        return this.pickStart;
    }

    public final long getPreDuration() {
        return this.preDuration;
    }

    public final long getPreMerged() {
        return this.preMerged;
    }

    public final long getPreStart() {
        return this.preStart;
    }

    public final String getResult() {
        return this.result;
    }

    public final float getResultBitrate() {
        return this.resultBitrate;
    }

    public final String getResultEncodeFormat() {
        return this.resultEncodeFormat;
    }

    public final float getResultFPS() {
        return this.resultFPS;
    }

    public final float getResultFileSize() {
        return this.resultFileSize;
    }

    public final String getResultVideoSize() {
        return this.resultVideoSize;
    }

    public final long getSendDuration() {
        return this.sendDuration;
    }

    public final int getSendNetStatus() {
        return this.sendNetStatus;
    }

    public final long getSendStart() {
        return this.sendStart;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final int getUnenabledEemuxCode() {
        return this.unenabledEemuxCode;
    }

    public final long getUploadDuration() {
        return this.uploadDuration;
    }

    public final int getUseWeakNetSetting() {
        return this.useWeakNetSetting;
    }

    public final float getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoSource() {
        return this.videoSource;
    }

    public final int isCompressUpload() {
        return this.isCompressUpload;
    }

    public final int isCompressUploadSuccess() {
        return this.isCompressUploadSuccess;
    }

    public final int isHDR() {
        return this.isHDR;
    }

    public final int isMergePreCompress() {
        return this.isMergePreCompress;
    }

    public final int isOriginal() {
        return this.isOriginal;
    }

    public final int isRaw() {
        return this.isRaw;
    }

    public final int isRemux() {
        return this.isRemux;
    }

    public final int isUseCache() {
        return this.isUseCache;
    }

    public final void setCompileQuality(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.compileQuality = r2;
    }

    public final void setCompileScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.compileScene = r2;
    }

    public final void setCompressCoverFileSize(float r1) {
        this.compressCoverFileSize = r1;
    }

    public final void setCompressDuration(long r1) {
        this.compressDuration = r1;
    }

    public final void setCompressStart(long r1) {
        this.compressStart = r1;
    }

    public final void setCompressUpload(int r1) {
        this.isCompressUpload = r1;
    }

    public final void setCompressUploadDuration(long r1) {
        this.compressUploadDuration = r1;
    }

    public final void setCompressUploadFailedMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.compressUploadFailedMsg = r2;
    }

    public final void setCompressUploadSuccess(int r1) {
        this.isCompressUploadSuccess = r1;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final void setErrorMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.errorMsg = r2;
    }

    public final void setErrorStatus(int r1) {
        this.errorStatus = r1;
    }

    public final void setErrorType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.errorType = r2;
    }

    public final void setHDR(int r1) {
        this.isHDR = r1;
    }

    public final void setMergePreCompress(int r1) {
        this.isMergePreCompress = r1;
    }

    public final void setOriginBitrate(float r1) {
        this.originBitrate = r1;
    }

    public final void setOriginEncodeFormat(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originEncodeFormat = r2;
    }

    public final void setOriginFPS(float r1) {
        this.originFPS = r1;
    }

    public final void setOriginFileSize(float r1) {
        this.originFileSize = r1;
    }

    public final void setOriginLastModifyDiff(float r1) {
        this.originLastModifyDiff = r1;
    }

    public final void setOriginVideoFormat(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originVideoFormat = r2;
    }

    public final void setOriginVideoSize(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originVideoSize = r2;
    }

    public final void setOriginal(int r1) {
        this.isOriginal = r1;
    }

    public final void setPickDuration(long r1) {
        this.pickDuration = r1;
    }

    public final void setPickStart(long r1) {
        this.pickStart = r1;
    }

    public final void setPreDuration(long r1) {
        this.preDuration = r1;
    }

    public final void setPreMerged(long r1) {
        this.preMerged = r1;
    }

    public final void setPreStart(long r1) {
        this.preStart = r1;
    }

    public final void setRaw(int r1) {
        this.isRaw = r1;
    }

    public final void setRemux(int r1) {
        this.isRemux = r1;
    }

    public final void setResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.result = r2;
    }

    public final void setResultBitrate(float r1) {
        this.resultBitrate = r1;
    }

    public final void setResultEncodeFormat(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultEncodeFormat = r2;
    }

    public final void setResultFPS(float r1) {
        this.resultFPS = r1;
    }

    public final void setResultFileSize(float r1) {
        this.resultFileSize = r1;
    }

    public final void setResultVideoSize(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultVideoSize = r2;
    }

    public final void setSendDuration(long r1) {
        this.sendDuration = r1;
    }

    public final void setSendNetStatus(int r1) {
        this.sendNetStatus = r1;
    }

    public final void setSendStart(long r1) {
        this.sendStart = r1;
    }

    public final void setTotalDuration(long r1) {
        this.totalDuration = r1;
    }

    public final void setUnenabledEemuxCode(int r1) {
        this.unenabledEemuxCode = r1;
    }

    public final void setUploadDuration(long r1) {
        this.uploadDuration = r1;
    }

    public final void setUseCache(int r1) {
        this.isUseCache = r1;
    }

    public final void setUseWeakNetSetting(int r1) {
        this.useWeakNetSetting = r1;
    }

    public final void setVideoDuration(float r1) {
        this.videoDuration = r1;
    }

    public final void setVideoSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.videoSource = r2;
    }

    public MediaMessageReport(float r15, float r16, float r17, String r18, String r19, String r20, float r21, float r22, String r23, float r24, float r25, float r26, String r27, String r28, float r29, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, int r54, int r55, int r56, int r57, String r58, String r59, String r60, String r61, int r62, String r63, int r64, int r65, int r66, int r67, int r68, int r69, int r70, String r71, int r72) {
        Intrinsics.checkNotNullParameter(r18, "originVideoSize");
        Intrinsics.checkNotNullParameter(r19, "originVideoFormat");
        Intrinsics.checkNotNullParameter(r20, "originEncodeFormat");
        Intrinsics.checkNotNullParameter(r23, "videoSource");
        Intrinsics.checkNotNullParameter(r27, "resultVideoSize");
        Intrinsics.checkNotNullParameter(r28, "resultEncodeFormat");
        Intrinsics.checkNotNullParameter(r58, "compileScene");
        Intrinsics.checkNotNullParameter(r59, "compileQuality");
        Intrinsics.checkNotNullParameter(r60, ChameleonOpenTracker.ParamKey.RESULT);
        Intrinsics.checkNotNullParameter(r61, "errorType");
        Intrinsics.checkNotNullParameter(r63, ChameleonOpenTracker.ParamKey.ERRORMSG);
        Intrinsics.checkNotNullParameter(r71, "compressUploadFailedMsg");
        this.originFPS = r15;
        this.originFileSize = r16;
        this.originBitrate = r17;
        this.originVideoSize = r18;
        this.originVideoFormat = r19;
        this.originEncodeFormat = r20;
        this.originLastModifyDiff = r21;
        this.videoDuration = r22;
        this.videoSource = r23;
        this.resultFPS = r24;
        this.resultFileSize = r25;
        this.resultBitrate = r26;
        this.resultVideoSize = r27;
        this.resultEncodeFormat = r28;
        this.compressCoverFileSize = r29;
        this.pickStart = r30;
        this.sendStart = r32;
        this.preStart = r34;
        this.preMerged = r36;
        this.compressStart = r38;
        this.totalDuration = r40;
        this.pickDuration = r42;
        this.preDuration = r44;
        this.compressDuration = r46;
        this.uploadDuration = r48;
        this.compressUploadDuration = r50;
        this.sendDuration = r52;
        this.isRemux = r54;
        this.isHDR = r55;
        this.unenabledEemuxCode = r56;
        this.useWeakNetSetting = r57;
        this.compileScene = r58;
        this.compileQuality = r59;
        this.result = r60;
        this.errorType = r61;
        this.errorCode = r62;
        this.errorMsg = r63;
        this.errorStatus = r64;
        this.isRaw = r65;
        this.isOriginal = r66;
        this.isUseCache = r67;
        this.isMergePreCompress = r68;
        this.isCompressUpload = r69;
        this.isCompressUploadSuccess = r70;
        this.compressUploadFailedMsg = r71;
        this.sendNetStatus = r72;
    }

    public /* synthetic */ MediaMessageReport(float r58, float r59, float r60, String r61, String r62, String r63, float r64, float r65, String r66, float r67, float r68, float r69, String r70, String r71, float r72, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, int r97, int r98, int r99, int r100, String r101, String r102, String r103, String r104, int r105, String r106, int r107, int r108, int r109, int r110, int r111, int r112, int r113, String r114, int r115, int r116, int r117, DefaultConstructorMarker r118) {
        if ((r116 & 1) == 0) goto L5;
        float r2 = 0.0f;
    L7:
        if ((r116 & 2) == 0) goto L9;
        float r4 = 0.0f;
    L11:
        if ((r116 & 4) == 0) goto L13;
        float r5 = 0.0f;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r6 = BuildConfig.FLAVOR;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r8 = BuildConfig.FLAVOR;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r9 = BuildConfig.FLAVOR;
    L27:
        if ((r116 & 64) == 0) goto L29;
        float r10 = 0.0f;
    L31:
        if ((r116 & 128) == 0) goto L33;
        float r11 = 0.0f;
    L35:
        if ((r116 & 256) == 0) goto L37;
        String r12 = BuildConfig.FLAVOR;
    L39:
        if ((r116 & 512) == 0) goto L41;
        float r13 = 0.0f;
    L43:
        if ((r116 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        float r14 = 0.0f;
    L47:
        if ((r116 & 2048) == 0) goto L49;
        float r15 = 0.0f;
    L51:
        if ((r116 & 4096) == 0) goto L53;
        String r3 = BuildConfig.FLAVOR;
    L55:
        if ((r116 & 8192) == 0) goto L57;
        String r7 = BuildConfig.FLAVOR;
    L58:
        String r16 = r7;
        if ((r116 & 16384) == 0) goto L61;
        float r17 = 0.0f;
    L62:
        long r18 = 0;
        if ((r116 & 32768) == 0) goto L65;
        long r20 = 0;
    L67:
        if ((r116 & 65536) == 0) goto L69;
        long r22 = 0;
    L71:
        if ((r116 & 131072) == 0) goto L73;
        long r24 = 0;
    L75:
        if ((r116 & 262144) == 0) goto L77;
        long r26 = 0;
    L79:
        if ((r116 & 524288) == 0) goto L81;
        long r28 = 0;
    L83:
        if ((r116 & 1048576) == 0) goto L85;
        long r30 = 0;
    L87:
        if ((r116 & Bridge.TRANSFER_MAX_SIZE) == 0) goto L89;
        long r32 = 0;
    L91:
        if ((r116 & 4194304) == 0) goto L93;
        long r34 = 0;
    L95:
        if ((r116 & 8388608) == 0) goto L97;
        long r36 = 0;
    L99:
        if ((r116 & 16777216) == 0) goto L101;
        long r38 = 0;
    L103:
        if ((r116 & 33554432) == 0) goto L105;
        long r40 = 0;
    L107:
        if ((r116 & 67108864) != 0) goto L110;
        r18 = r95;
    L110:
        int r42 = 0;
        if ((r116 & 134217728) == 0) goto L113;
        int r19 = 0;
    L115:
        if ((r116 & 268435456) == 0) goto L117;
        int r43 = 0;
    L119:
        if ((r116 & 536870912) == 0) goto L121;
        int r44 = 0;
    L123:
        if ((r116 & 1073741824) == 0) goto L125;
        int r45 = 0;
    L127:
        if ((r116 & PluginList.LEVEL_NOT_SET) == 0) goto L129;
        String r0 = BuildConfig.FLAVOR;
    L131:
        if ((r117 & 1) == 0) goto L133;
        String r46 = BuildConfig.FLAVOR;
    L135:
        if ((r117 & 2) == 0) goto L137;
        String r47 = BuildConfig.FLAVOR;
    L139:
        if ((r117 & 4) == 0) goto L141;
        String r48 = BuildConfig.FLAVOR;
    L143:
        if ((r117 & 8) == 0) goto L145;
        int r49 = 0;
    L147:
        if ((r117 & 16) == 0) goto L149;
        String r50 = BuildConfig.FLAVOR;
    L151:
        if ((r117 & 32) == 0) goto L153;
        int r51 = 0;
    L155:
        if ((r117 & 64) == 0) goto L157;
        int r52 = 0;
    L158:
        String r119 = r0;
        if ((r117 & 128) == 0) goto L161;
        int r1 = 0;
    L162:
        int r1110 = r1;
        if ((r117 & 256) == 0) goto L165;
        int r21 = 0;
    L166:
        int r53 = r21;
        if ((r117 & 512) == 0) goto L169;
        int r23 = 0;
    L170:
        int r54 = r23;
        if ((r117 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L173;
        int r25 = 0;
    L174:
        int r55 = r25;
        if ((r117 & 2048) == 0) goto L177;
        int r27 = 0;
    L178:
        int r56 = r27;
        if ((r117 & 4096) == 0) goto L181;
        String r29 = BuildConfig.FLAVOR;
    L183:
        if ((r117 & 8192) != 0) goto L186;
        r42 = r115;
    L186:
        this(r2, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r3, r16, r17, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r18, r19, r43, r44, r45, r119, r46, r47, r48, r49, r50, r51, r52, r1110, r53, r54, r55, r56, r29, r42);
        return;
    L181:
        r29 = r114;
        goto L183
    L177:
        r27 = r113;
        goto L178
    L173:
        r25 = r112;
        goto L174
    L169:
        r23 = r111;
        goto L170
    L165:
        r21 = r110;
        goto L166
    L161:
        r1 = r109;
        goto L162
    L157:
        r52 = r108;
        goto L158
    L153:
        r51 = r107;
        goto L155
    L149:
        r50 = r106;
        goto L151
    L145:
        r49 = r105;
        goto L147
    L141:
        r48 = r104;
        goto L143
    L137:
        r47 = r103;
        goto L139
    L133:
        r46 = r102;
        goto L135
    L129:
        r0 = r101;
        goto L131
    L125:
        r45 = r100;
        goto L127
    L121:
        r44 = r99;
        goto L123
    L117:
        r43 = r98;
        goto L119
    L113:
        r19 = r97;
        goto L115
    L105:
        r40 = r93;
        goto L107
    L101:
        r38 = r91;
        goto L103
    L97:
        r36 = r89;
        goto L99
    L93:
        r34 = r87;
        goto L95
    L89:
        r32 = r85;
        goto L91
    L85:
        r30 = r83;
        goto L87
    L81:
        r28 = r81;
        goto L83
    L77:
        r26 = r79;
        goto L79
    L73:
        r24 = r77;
        goto L75
    L69:
        r22 = r75;
        goto L71
    L65:
        r20 = r73;
        goto L67
    L61:
        r17 = r72;
        goto L62
    L57:
        r7 = r71;
        goto L58
    L53:
        r3 = r70;
        goto L55
    L49:
        r15 = r69;
        goto L51
    L45:
        r14 = r68;
        goto L47
    L41:
        r13 = r67;
        goto L43
    L37:
        r12 = r66;
        goto L39
    L33:
        r11 = r65;
        goto L35
    L29:
        r10 = r64;
        goto L31
    L25:
        r9 = r63;
        goto L27
    L21:
        r8 = r62;
        goto L23
    L17:
        r6 = r61;
        goto L19
    L13:
        r5 = r60;
        goto L15
    L9:
        r4 = r59;
        goto L11
    L5:
        r2 = r58;
        goto L7
    }
}
