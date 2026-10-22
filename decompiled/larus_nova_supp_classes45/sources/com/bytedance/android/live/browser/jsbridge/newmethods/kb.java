package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.view.View;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveSaveHighlightVideo")
public final class kb extends k<w6, LiveSaveHighlightVideoResultModel> {
    public static final /* synthetic */ int b = 0;
    public final TokenCert a;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ kb a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public b(kb r1, Ref.BooleanRef r2, Context r3, int r4, String r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            if (this.b.element == true) goto L6;
            Downloader.getInstance(this.c).cancel(this.d, true);
            kb r2 = this.a;
            int r11 = kb.b;
            kb.m(r2, null, "CancelDownload", null, "user cancel download, with url " + this.e, 4);
            kb r12 = this.a;
            String r0 = this.f;
            String r1 = this.g;
            r12.getClass();
            kb.l(r0, r1, "fail", 2);
            return;
        }
    }

    public static final class c extends AbsDownloadListener {
        public final /* synthetic */ kb a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ km3.g e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ String b;
            public final /* synthetic */ ParcelFileDescriptor c;
            public final /* synthetic */ DownloadInfo d;
            public final /* synthetic */ Uri e;

            public a(c r1, String r2, ParcelFileDescriptor r3, DownloadInfo r4, Uri r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void a() {
                PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(this.b);     // Catch: Throwable -> L5
                PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(this.c.getFileDescriptor());     // Catch: Throwable -> L5
                int r4 = kb.b;     // Catch: Throwable -> L5
                ALogger.i("JSB_SaveHighlightVideo", "copy from " + r2 + " to " + r3);     // Catch: Throwable -> L5
                FileUtils.fileChannelCopy(r2, r3);     // Catch: Throwable -> L5
                new PolarisFileWrapper(this.d.getTargetFilePath()).delete();     // Catch: Throwable -> L5
                c r1 = this.a;     // Catch: Throwable -> L5
                kb r5 = r1.a;     // Catch: Throwable -> L5
                km3.g r6 = r1.e;     // Catch: Throwable -> L5
                r5.getClass();     // Catch: Throwable -> L5
                MainThreadPostUtils.e(new lb(r6));     // Catch: Throwable -> L5
                kb r7 = this.a.a;     // Catch: Throwable -> L5
                Uri r8 = this.e;     // Catch: Throwable -> L5
                r7.getClass();     // Catch: Throwable -> L5
                kb.m(r7, kb.n(r8), "Success", null, "copy complete, with url " + this.a.f, 4);     // Catch: Throwable -> L5
                c r0 = this.a;     // Catch: Throwable -> L5
                kb r9 = r0.a;     // Catch: Throwable -> L5
                String r11 = r0.g;     // Catch: Throwable -> L5
                String r12 = r0.h;     // Catch: Throwable -> L5
                r9.getClass();     // Catch: Throwable -> L5
                kb.l(r11, r12, "success", null);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                c r13 = this.a;
                kb r14 = r13.a;
                km3.g r15 = r13.e;
                int r16 = kb.b;
                r14.getClass();
                MainThreadPostUtils.e(new lb(r15));
                kb.m(this.a.a, null, "DownLoadFail", "inner catch, copy fail, exception:" + th.getMessage(), null, 8);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onProgress(DownloadInfo r6) {
            super.onProgress(r6);
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.getTotalBytes() > 0) goto L8;
            int r7 = 0;
        L9:
            this.e.setProgress(r7);
            return;
        L8:
            r7 = (int) ((r6.getCurBytes() / r6.getTotalBytes()) * 100);
            goto L9
        }

        public final void onSuccessed(DownloadInfo r15) {
            Intrinsics.checkNotNullParameter(r15, "entity");
            super.onSuccessed(r15);
            this.b.element = true;
            String r4 = r15.getTargetFilePath();
            kb r0 = this.a;     // Catch: Throwable -> L13
            String r1 = this.c;     // Catch: Throwable -> L13
            r0.getClass();     // Catch: Throwable -> L13
            Uri r7 = BdMediaFileSystem.createVideoUri(com.bytedance.android.live.core.utils.s1.getContext(), r1);     // Catch: Throwable -> L13
            if (r7 != null) goto L7;
            kb.m(this.a, null, "OtherError", "download fail, createMediaUri get null", null, 8);     // Catch: Throwable -> L13
            return;
        L7:
            ParcelFileDescriptor r5 = a(this.d.getContentResolver(), r7);     // Catch: Throwable -> L13
            if (r5 != null) goto L11;
            kb.m(this.a, null, "OtherError", "download fail, file descriptor is null", null, 8);     // Catch: Throwable -> L13
            return;
        L11:
            TTExecutors.getNormalExecutor().submit(new a(this, r4, r5, r15, r7));     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            kb r2 = this.a;
            km3.g r3 = this.e;
            r2.getClass();
            MainThreadPostUtils.e(new lb(r3));
            kb.m(this.a, null, "DownLoadFail", "outer catch, copy fail, exception:" + th.getMessage(), null, 8);
        }

        public static ParcelFileDescriptor a(ContentResolver r21, Uri r22) {
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

        public final void onFailed(DownloadInfo r7, BaseException r8) {
            Intrinsics.checkNotNullParameter(r7, "entity");
            Intrinsics.checkNotNullParameter(r8, "e");
            super.onFailed(r7, r8);
            kb r9 = this.a;
            km3.g r11 = this.e;
            r9.getClass();
            MainThreadPostUtils.e(new lb(r11));
            kb.m(this.a, null, "DownLoadFail", "download failed, with url " + this.f, null, 8);
            kb r12 = this.a;
            String r13 = this.g;
            String r0 = this.h;
            r12.getClass();
            kb.l(r13, r0, "fail", 1);
        }

        public c(kb r1, Ref.BooleanRef r2, String r3, Context r4, km3.g r5, String r6, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public kb() {
        this.a = TokenCert.Companion.with("bpea-live_saveHighlightVideoMethod_jsb_storage_permission");
    }

    public static String n(Uri r6) {
        String r7 = r6.toString();
        int r0 = StringsKt.lastIndexOf$default(r7, '/', 0, false, 6, null) + 1;
        if (r7 == null) goto L7;
        return r7.substring(r0);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void invoke(Object r23, final CallContext r24) {
        w6 r0 = (w6) r23;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r24, "context");
        String r1 = r0.c();
        if (r1 != null) goto L5;
        final String r6 = "";
    L6:
        final String r2 = r0.d();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r3 = r0.b();
        if (r3 != null) goto L12;
        final String r11 = "";
    L13:
        Integer r4 = r0.a();
        boolean r5 = false;
        if (r4 != null) goto L17;
    L18:
        final boolean r7 = true;
    L21:
        if (Intrinsics.areEqual(r6, "") == false) goto L24;
        m(this, null, "OtherError", "check params fail, with url " + r6 + ", with vid " + r2, null, 8);
    L56:
        return;
    L24:
        if (Intrinsics.areEqual(r2, "") == false) goto L30;
        StringBuilder r8 = new StringBuilder();
        String r9 = "highlight".concat(r6);
        Charset r12 = Charsets.UTF_8;
        if (r9 == null) goto L29;
        r8.append(DigestUtil.md5Hex(r9.getBytes(r12)));
        r8.append(".mp4");
        String r13 = r8.toString();
        ALogger.w("JSB_SaveHighlightVideo", "vid is null, use url as filename");
    L31:
        int r14 = Build.VERSION.SDK_INT;
        if (r14 >= 23) goto L34;
    L36:
        if (r5 == false) goto L51;
        Context r15 = r24.getContext();
        if ((r15 instanceof Activity) == true) goto L40;
        r15 = null;
    L40:
        final Activity r16 = (Activity) r15;
        if (r16 != null) goto L44;
        m(this, null, "OtherError", "check permission fail, activity is null", null, 8);
        goto L56
    L44:
        final List r17 = CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if (m60.c.c(r16, r17) == true) goto L51;
        final String r18 = r13;
        final String r19 = r11;
        final String r21 = r2;
        final Function1<List<? extends String>, Unit> r110 = new SaveHighlightVideoMethod$invoke$1(this, r18, r24, r6, r7, r19, r21);
        final Function1<List<? extends String>, Unit> r22 = new SaveHighlightVideoMethod$invoke$2(this, r11, r2);
        ALogger.i("JSB_SaveHighlightVideo", "show permission dialog");
        z20.c r25 = new z20.c(r16, new SaveHighlightVideoMethod$showPermissionDialog$1(this, r16, r110, r22, r17), new SaveHighlightVideoMethod$showPermissionDialog$2(r22));
        if (DialogLancet.shouldBlockDialogShow(r25) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r25);
        return;
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L50:
        DialogLancet.beforeDialogShow(r25);
        r25.show();
        DialogLancet.afterDialogShow(r25);
        return;
    L51:
        j(r13, r24.getContext(), r6, r7, r11, r2);
        ALogger.i("JSB_SaveHighlightVideo", "no need to request permission");
        return;
    L34:
        if (r14 > 28) goto L36;
        r5 = true;
        goto L36
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L30:
        r13 = DigestUtil.md5Hex(r2.getBytes(Charsets.UTF_8)) + ".mp4";
        goto L31
    L17:
        if (r4.intValue() != 0) goto L18;
        r7 = false;
        goto L21
    L12:
        r11 = r3;
        goto L13
    L5:
        r6 = r1;
        goto L6
    }

    public static void l(String r2, String r3, String r4, Integer r5) {
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", r2), TuplesKt.to("item_id", r3), TuplesKt.to("download_status", r4)});
        if (r5 == null) goto L5;
        r6.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, String.valueOf(r5.intValue()));
    L5:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_material_download_status", r6, new Object[0]);
    }

    public final void k(Context r16, String r17, String r18, String r19, String r21) {
        km3.g r0 = km3.g.c(r16, "导入中");
        r0.b();
        File r1 = com.bytedance.android.live.core.utils.s1.getContext().getExternalCacheDir();
        if (r1 != null) goto L6;
        m(this, null, "OtherError", "download fail, savePath is null", null, 8);
        return;
    L6:
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.element = false;
        r0.g = new b(this, r11, r16, Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r18).monitorScene("live_jsb_save_highlight_video").name(r17).savePath(r1.getAbsolutePath()).retryCount(3).mainThreadListener(new c(this, r11, r17, r16, r0, r18, r19, r21)).download(), r18, r19, r21);
    }

    public static void m(kb r3, String r4, String r5, String r6, String r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 8) == 0) goto L8;
        r7 = null;
    L8:
        r3.getClass();
        LiveSaveHighlightVideoResultModel r9 = new LiveSaveHighlightVideoResultModel();
        boolean r0 = false;
        if (r4 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        LiveSaveHighlightVideoResultModel.Code r11 = LiveSaveHighlightVideoResultModel.Code.Success;
    L18:
        r9.a(r11);
        r9.c(r5);
        LiveSaveHighlightVideoResultModel.a r12 = new LiveSaveHighlightVideoResultModel.a();
        if (r4 != null) goto L21;
    L22:
        r0 = true;
    L23:
        r12.b(Boolean.valueOf(!r0));
        r12.a(r4);
        Unit r13 = Unit.INSTANCE;
        r9.b(r12);
        r3.finishWithResult(r9);
        if (r6 == null) goto L26;
        ALogger.w("JSB_SaveHighlightVideo", r6);
    L26:
        if (r7 == null) goto L29;
        ALogger.i("JSB_SaveHighlightVideo", r7);
        return;
    L29:
        return;
    L21:
        if (StringsKt.isBlank(r4) == false) goto L23;
    L17:
        r11 = LiveSaveHighlightVideoResultModel.Code.Failed;
        goto L18
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r2 = false;
        goto L15
    }

    public final void j(String r7, Context r8, String r9, boolean r11, String r12, String r13) {
        if (r11 == false) goto L7;
        Uri r14 = BdMediaFileSystem.getVideoContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r7);
        if (r14 == null) goto L6;
        m(this, n(r14), "Success", null, "file already downloaded(at " + r7 + "), callback success", 4);
        l(r12, r13, "success", null);
        return;
    L6:
        k(r8, r7, r9, r12, r13);
        return;
    L7:
        k(r8, r7, r9, r12, r13);
    }
}
