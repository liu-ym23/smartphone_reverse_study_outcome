package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveDownloadMedia")
public final class r2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public r2() {
    }

    public static final void k(r2 r6) {
        r6.getClass();
        LiveTracingMonitor.EventModule r7 = LiveTracingMonitor.EventModule.OPEN_LIVE;
        JSONObject r1 = new JSONObject();
        r1.put("status_code", 0);     // Catch: JSONException -> L8
    L12:
        r1.put("type", "jsb_download");     // Catch: JSONException -> L9
    L6:
        LiveMonitor r0 = new LiveMonitor();
        r0.mCategory = r1;
        r0.mEventModule = r7;
        r0.mServiceName = "ttlive_anchor_high_light_metadata_monitor";
        r0.mExtraLog = null;
        r0.mMetrics = null;
        LiveMonitor.access$002(r0, true);
        LiveMonitor.access$102(r0, true);
        LiveMonitor.access$202(r0, true);
        LiveMonitor.access$302(r0, false);
        LiveMonitor.access$402(r0, false);
        r0.report();
    }

    public static void o(String r4) {
        IBrowserService r0 = (IBrowserService) jc1.k.n(IBrowserService.class);
        JSONObject r1 = new JSONObject();
        if (r4 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r1.put("extra_success", true ^ r3);
        r1.put("extra_file_path", r4);
        Unit r5 = Unit.INSTANCE;
        r0.sendEventToAllJsBridges("download_media_callback", r1);
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r3 = false;
        goto L9
    }

    public static final void j(r2 r0, PolarisFileWrapper r1) {
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        if (r1.exists() == false) goto L6;
        r1.delete();     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static ParcelFileDescriptor l(ContentResolver r21, Uri r22) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r22, "w"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r11 = r4;
        int r9 = r11.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r11[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r11;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r21, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r21, r22, "w");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r11 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static Uri m(String r4, String r5) {
        if (StringsKt.startsWith$default(r4, "image", false, 2, null) == false) goto L6;
        return BdMediaFileSystem.createImageUri(com.bytedance.android.live.core.utils.s1.getContext(), r5);
    L6:
        if (StringsKt.startsWith$default(r4, "audio", false, 2, null) == false) goto L9;
        return BdMediaFileSystem.createMusicUri(com.bytedance.android.live.core.utils.s1.getContext(), r5);
    L9:
        return BdMediaFileSystem.createVideoUri(com.bytedance.android.live.core.utils.s1.getContext(), r5);
    }

    public static JSONObject n(boolean r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("success", r2);
        r0.put("msg", r3);
        return r0;
    }

    public final Object invoke(Object r14, CallContext r15) {
        JSONObject r16 = (JSONObject) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        String r9 = r16.optString(LiveSlardarConstants.EXTRA_KEY_URL, "");
        String r4 = r16.optString("mime", "");
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = MapsKt.emptyMap();
        if (((Boolean) com.bytedance.android.livesdk.config.nb.a.getValue()).booleanValue() == false) goto L10;
        String r0 = r16.optString("meta_data", "");
        if (r0.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r7.element = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("LvMetaInfo", r0)});
        goto L10
    L7:
        r3 = false;
    L10:
        String r8 = r16.optString("success_toast", "");
        File r1 = com.bytedance.android.live.core.utils.s1.getContext().getExternalCacheDir();
        StringBuilder r2 = new StringBuilder();
        Charset r5 = Charsets.UTF_8;
        if (r9 == null) goto L43;
        r2.append(DigestUtil.md5Hex(r9.getBytes(r5)));
        r2.append('.');
        r2.append(StringsKt.substringAfter$default(r4, '/', null, 2, null));
        String r6 = r2.toString();
        if (r1 != null) goto L15;
    L40:
        String r17 = "file name invalid suffix, params mime is: " + r4 + ", tmp path: " + r1;
        ALogger.w("JSB_DownloadMedia", r17);
        return n(false, r17);
    L15:
        if (StringsKt.isBlank(r4) == true) goto L40;
        if (StringsKt.endsWith$default(r6, '.', false, 2, null) == true) goto L40;
        if (StringsKt.startsWith$default(r4, "image", false, 2, null) == false) goto L23;
        Uri r11 = BdMediaFileSystem.getImageContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r6);
    L26:
        if (r11 == null) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L32;
        ALogger.i("JSB_DownloadMedia", "file already downloaded(at " + r6 + "), callback success");
        return n(true, "already downloaded");
    L32:
        if (r16.optBoolean("is_local_file", false) == false) goto L39;
        ALogger.i("JSB_DownloadMedia", "is local file");
        Map r18 = (Map) r7.element;
        Ref.ObjectRef r13 = new Ref.ObjectRef();     // Catch: Throwable -> L36
        r13.element = r9;     // Catch: Throwable -> L36
        TTExecutors.getNormalExecutor().submit(new s2(this, r18, r13, r9, l(r15.getContext().getContentResolver(), m(r4, r6)), r8));     // Catch: Throwable -> L36
    L47:
        return n(true, "begin transform local file");
    L36:
        th = move-exception;
        o(null);
        ALogger.w("JSB_DownloadMedia", th.getMessage());
        goto L47
    L39:
        Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r9).monitorScene("live_jsb_download_media").name(r6).savePath(r1.getAbsolutePath()).retryCount(3).mainThreadListener(new t2(this, r4, r6, r15, r7, r8, r9)).download();
        return n(true, "begin download");
    L28:
        r12 = false;
        goto L29
    L23:
        if (StringsKt.startsWith$default(r4, "audio", false, 2, null) == false) goto L25;
        r11 = BdMediaFileSystem.getMusicContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r6);
        goto L26
    L25:
        r11 = BdMediaFileSystem.getVideoContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r6);
        goto L26
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
