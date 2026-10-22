package com.ss.android.lark.chat.service.impl;

import android.os.Build;
import android.os.SystemClock;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.videosend.tools.VideoCodecSettings;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import com.ss.android.lark.videosend.tools.VideoQPSettings;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z0 {
    public static final HashMap<String, MediaMessageReport> a = null;

    static {
        a = new HashMap();
    }

    public static JSONObject a(MediaMessageReport r9) {
        JSONObject r0 = new JSONObject();
        r0.put("origin_fps", Float.valueOf(r9.getOriginFPS()));
        r0.put("origin_file_size", Float.valueOf(r9.getOriginFileSize()));
        r0.put("origin_bitrate", Float.valueOf(r9.getOriginBitrate()));
        r0.put("origin_video_size", r9.getOriginVideoSize());
        r0.put("origin_video_format", r9.getOriginVideoFormat());
        r0.put("origin_encode_format", r9.getOriginEncodeFormat());
        r0.put("origin_last_modify_diff", Float.valueOf(r9.getOriginLastModifyDiff()));
        r0.put("video_duration", Float.valueOf(r9.getVideoDuration()));
        r0.put("video_source", r9.getVideoSource());
        r0.put("result_fps", Float.valueOf(r9.getResultFPS()));
        r0.put("result_file_size", Float.valueOf(r9.getResultFileSize()));
        r0.put("result_bitrate", Float.valueOf(r9.getResultBitrate()));
        r0.put("result_video_size", r9.getResultVideoSize());
        r0.put("result_encode_format", r9.getResultEncodeFormat());
        r0.put("compress_cover_file_size", Float.valueOf(r9.getCompressCoverFileSize()));
        r0.put("total_duration", r9.getTotalDuration());
        r0.put("pick_duration", r9.getPickDuration());
        r0.put("pre_duration", r9.getPreDuration());
        r0.put("compress_duration", r9.getCompressDuration());
        r0.put("compress_upload_duration", r9.getCompressUploadDuration());
        r0.put("upload_duration", r9.getUploadDuration());
        r0.put("send_duration", r9.getSendDuration());
        r0.put("compress_is_remux", r9.isRemux());
        r0.put("compress_is_HDR", r9.isHDR());
        r0.put("unenabled_remux_code", r9.getUnenabledEemuxCode());
        r0.put("use_weak_net_setting", r9.getUseWeakNetSetting());
        r0.put("compile_scene", r9.getCompileScene());
        r0.put("compile_quality", r9.getCompileQuality());
        r0.put("send_net_status", r9.getSendNetStatus());
        boolean r2 = true;
        r0.put("finish_is_in_background", !ImSdkProxy.b().b() ? 1 : 0);
        r0.put("device_model", Build.MODEL.toLowerCase(Locale.ROOT));
        r0.put("chip_brand", ((VideoQPSettings.VideoQPConfig) VideoQPSettings.c.getValue()).getChipBrand());
        if (r9.getCompressDuration() == 0) goto L6;
        r0.put("compress_speed", Float.valueOf(VideoCompressTools.a((r9.getOriginFileSize() / r9.getCompressDuration()) * 1000)));
    L6:
        if (r9.getUploadDuration() == 0) goto L9;
        r0.put("upload_speed", Float.valueOf(VideoCompressTools.a((r9.getOriginFileSize() / r9.getUploadDuration()) * 1000)));
    L9:
        if (r9.getResultFileSize() != 0.0f) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        r0.put("compress_ratio_file_size", Float.valueOf(VideoCompressTools.a(r9.getOriginFileSize() / r9.getResultFileSize())));
    L15:
        if (r9.getResultBitrate() == 0.0f) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L20;
        r0.put("compress_ratio_bitrate", Float.valueOf(VideoCompressTools.a(r9.getOriginBitrate() / r9.getResultBitrate())));
    L20:
        r0.put("decode_is_use_hw_264", ((Boolean) VideoCodecSettings.d.getValue()).booleanValue() ? 1 : 0);
        r0.put("decode_is_use_hw_265", ((Boolean) VideoCodecSettings.e.getValue()).booleanValue() ? 1 : 0);
        r0.put("encode_is_use_hw_264", ((Boolean) VideoCodecSettings.f.getValue()).booleanValue() ? 1 : 0);
        r0.put("encode_use_dynamic_qp", ((Boolean) VideoQPSettings.d.getValue()).booleanValue() ? 1 : 0);
        r0.put(ChameleonOpenTracker.ParamKey.RESULT, r9.getResult());
        r0.put("errorType", r9.getErrorType());
        r0.put("errorCode", r9.getErrorCode());
        r0.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r9.getErrorMsg());
        r0.put("errorStatus", r9.getErrorStatus());
        r0.put("is_raw", r9.isRaw());
        r0.put("is_original", r9.isOriginal());
        r0.put("is_use_cache", r9.isUseCache());
        r0.put("is_merge_pre_compress", r9.isMergePreCompress());
        r0.put("is_compress_upload", r9.isCompressUpload());
        r0.put("is_compress_upload_success", r9.isCompressUploadSuccess());
        r0.put("compress_upload_failed_msg", r9.getCompressUploadFailedMsg());
        return r0;
    L11:
        r1 = false;
        goto L12
    }

    @JvmStatic
    public static final synchronized void c(String r3) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r3, "mgsId");     // Catch: Throwable -> L9
        MediaMessageReport r4 = a.get(r3);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.setCompressStart(SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
    L7:
        monitor-exit(z0.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void g(String r66) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r66, "compressPath");     // Catch: Throwable -> L14
        HashMap<String, MediaMessageReport> r2 = a;     // Catch: Throwable -> L14
        MediaMessageReport r3 = r2.get(r66);     // Catch: Throwable -> L14
        if (r3 != null) goto L7;
    L9:
        if (r3 != null) goto L11;
        r3 = new MediaMessageReport(0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, 0, -1, 16383, null);     // Catch: Throwable -> L14
        r2.put(r66, r3);     // Catch: Throwable -> L14
    L11:
        r3.setPreStart(SystemClock.elapsedRealtime());     // Catch: Throwable -> L14
        monitor-exit(z0.class);
        return;
    L7:
        if (r3.getPreStart() == 0) goto L9;
        r3 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void i(String r66) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r66, "compressPath");     // Catch: Throwable -> L18
        HashMap<String, MediaMessageReport> r2 = a;     // Catch: Throwable -> L18
        MediaMessageReport r3 = r2.get(r66);     // Catch: Throwable -> L18
        if (r3 != null) goto L7;
    L9:
        if (r3 != null) goto L11;
        r3 = new MediaMessageReport(0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, 0, -1, 16383, null);     // Catch: Throwable -> L18
        r2.put(r66, r3);     // Catch: Throwable -> L18
    L11:
        boolean r0 = CompressPathManager.isOriginMode(r66);     // Catch: Throwable -> L18
        r3.setPickStart(SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
        if (r0 == false) goto L14;
        int r1 = 1;
    L15:
        r3.setOriginal(r1);     // Catch: Throwable -> L18
        Statistics.sendEvent("send_video_start_dev");     // Catch: Throwable -> L18
        ResourcePerfMonitor.VIDEO_SEND.onStart();     // Catch: Throwable -> L18
        monitor-exit(z0.class);
        return;
    L14:
        r1 = 0;
        goto L15
    L7:
        if (r3.getPickStart() == 0) goto L9;
        r3 = null;
    L18:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void j(String r3) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r3, "mgsId");     // Catch: Throwable -> L9
        MediaMessageReport r4 = a.get(r3);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.setSendStart(SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
        r4.setSendNetStatus(ImSdkProxy.b().getCurNetWorkLevel());     // Catch: Throwable -> L9
    L7:
        monitor-exit(z0.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void b(String r5, VideoCompressResult r6) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r5, "mgsId");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r6, ChameleonOpenTracker.ParamKey.RESULT);     // Catch: Throwable -> L34
        MediaMessageReport r7 = a.get(r5);     // Catch: Throwable -> L34
        if (r7 == null) goto L32;
        r7.setCompressDuration(SystemClock.elapsedRealtime() - r7.getCompressStart());     // Catch: Throwable -> L34
        int r3 = 0;
        if (r6.a != VideoCompressResult.ResultType.RAW) goto L9;
        int r1 = 1;
    L10:
        r7.setRaw(r1);     // Catch: Throwable -> L34
        if (r6.a != VideoCompressResult.ResultType.REUSE) goto L13;
        r3 = 1;
    L13:
        r7.setUseCache(r3);     // Catch: Throwable -> L34
        r7.setVideoDuration(r6.a().u);     // Catch: Throwable -> L34
        String r2 = r6.a().i;     // Catch: Throwable -> L34
        if (r2 != null) goto L16;
        r2 = "album";
    L16:
        r7.setVideoSource(r2);     // Catch: Throwable -> L34
        r7.setOriginFPS(r6.a().a);     // Catch: Throwable -> L34
        r7.setOriginBitrate(r6.a().b);     // Catch: Throwable -> L34
        String r4 = r6.a().e;     // Catch: Throwable -> L34
        if (r4 != null) goto L19;
        r4 = DocTabPayload.DocType.UNKNOWN;
    L19:
        r7.setOriginVideoSize(r4);     // Catch: Throwable -> L34
        r7.setOriginFileSize(r6.a().f);     // Catch: Throwable -> L34
        String r8 = r6.a().c;     // Catch: Throwable -> L34
        if (r8 != null) goto L22;
        r8 = BuildConfig.FLAVOR;
    L22:
        r7.setOriginVideoFormat(r8);     // Catch: Throwable -> L34
        String r9 = r6.a().d;     // Catch: Throwable -> L34
        if (r9 != null) goto L25;
        r9 = BuildConfig.FLAVOR;
    L25:
        r7.setOriginEncodeFormat(r9);     // Catch: Throwable -> L34
        r7.setOriginLastModifyDiff(r6.a().g);     // Catch: Throwable -> L34
        r7.setCompressCoverFileSize(r6.a().h);     // Catch: Throwable -> L34
        r7.setResultFPS(r6.a().j);     // Catch: Throwable -> L34
        r7.setResultBitrate(r6.a().k);     // Catch: Throwable -> L34
        String r10 = r6.a().l;     // Catch: Throwable -> L34
        if (r10 != null) goto L28;
        r10 = DocTabPayload.DocType.UNKNOWN;
    L28:
        r7.setResultVideoSize(r10);     // Catch: Throwable -> L34
        r7.setResultFileSize(r6.a().m);     // Catch: Throwable -> L34
        String r11 = r6.a().n;     // Catch: Throwable -> L34
        if (r11 != null) goto L31;
        r11 = BuildConfig.FLAVOR;
    L31:
        r7.setResultEncodeFormat(r11);     // Catch: Throwable -> L34
        r7.setRemux(r6.a().o);     // Catch: Throwable -> L34
        r7.setHDR(r6.a().p);     // Catch: Throwable -> L34
        r7.setUnenabledEemuxCode(r6.a().q);     // Catch: Throwable -> L34
        r7.setUseWeakNetSetting(r6.a().r);     // Catch: Throwable -> L34
        r7.setCompileScene(r6.a().s);     // Catch: Throwable -> L34
        r7.setCompileQuality(r6.a().t);     // Catch: Throwable -> L34
        goto L32
    L9:
        r1 = 0;
    L32:
        monitor-exit(z0.class);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void d(String r2, ErrorResult r3) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r2, "mgsId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);     // Catch: Throwable -> L9
        MediaMessageReport r4 = a.get(r2);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.setCompressUpload(1);     // Catch: Throwable -> L9
        r4.setCompressUploadSuccess(0);     // Catch: Throwable -> L9
        r4.setCompressUploadFailedMsg(r3.toString());     // Catch: Throwable -> L9
    L7:
        monitor-exit(z0.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void e(String r2, long r3) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r2, "mgsId");     // Catch: Throwable -> L9
        MediaMessageReport r4 = a.get(r2);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.setCompressUpload(1);     // Catch: Throwable -> L9
        r4.setCompressUploadSuccess(1);     // Catch: Throwable -> L9
        r4.setCompressUploadDuration(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(z0.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void f(String r3, String r4) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r3, "mgsId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "compressPath");     // Catch: Throwable -> L12
        HashMap<String, MediaMessageReport> r1 = a;     // Catch: Throwable -> L12
        MediaMessageReport r5 = r1.remove(r4);     // Catch: Throwable -> L12
        if (r5 == null) goto L7;
        r1.put(r3, r5);     // Catch: Throwable -> L12
    L7:
        MediaMessageReport r6 = r1.get(r3);     // Catch: Throwable -> L12
        if (r6 == null) goto L10;
        r6.setPreMerged(SystemClock.elapsedRealtime());     // Catch: Throwable -> L12
        r6.setMergePreCompress(1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(z0.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void h(String r5, String r6) {
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r5, "mgsId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r6, "compressPath");     // Catch: Throwable -> L12
        HashMap<String, MediaMessageReport> r1 = a;     // Catch: Throwable -> L12
        MediaMessageReport r7 = r1.remove(r6);     // Catch: Throwable -> L12
        if (r7 == null) goto L7;
        r1.put(r5, r7);     // Catch: Throwable -> L12
    L7:
        MediaMessageReport r8 = r1.get(r5);     // Catch: Throwable -> L12
        if (r8 == null) goto L10;
        r8.setPickDuration(SystemClock.elapsedRealtime() - r8.getPickStart());     // Catch: Throwable -> L12
    L10:
        monitor-exit(z0.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
