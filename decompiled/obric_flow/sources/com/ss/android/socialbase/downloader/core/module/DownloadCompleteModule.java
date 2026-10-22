package com.ss.android.socialbase.downloader.core.module;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCompleteModule extends AbsDownloadModule {
    public BaseException g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15318h;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule$1, reason: invalid class name */
    class AnonymousClass1 implements ITempFileSaveCompleteCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadCompleteModule f15319a;

        public AnonymousClass1(DownloadCompleteModule r5) {
            this.f15319a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public final void a(BaseException r5) {
            this.f15319a.g = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public final void onSuccess() {
            DownloadCompleteModule r5 = this.f15319a;
            r5.f.f = RunStatus.f15286h;
            if (Logger.a(r5.f15290c) == false) goto L6;
            Logger.a("DownloadCompleteModule", this.f15319a.f15290c, "onSuccess", "Save file success");
        L6:
            if (TextUtils.isEmpty(this.f15319a.f15318h) == true) goto L11;
            DownloadCompleteModule r10 = this.f15319a;
            DownloadInfo r11 = r10.f15290c;
            r11.C = r10.f15318h;
            if (Logger.a(r11) == false) goto L12;
            Logger.a("DownloadCompleteModule", this.f15319a.f15290c, "onSuccess", "Save file md5:" + this.f15319a.f15318h);
            return;
        L12:
            return;
        }
    }

    public DownloadCompleteModule() {
        this.f15318h = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r28) {
        if (Logger.a(this.f15290c) == false) goto L6;
        Logger.a("DownloadCompleteModule", this.f15290c, "proceed", "Run");
    L6:
        if (b() == true) goto L173;
        RunStatus r5 = this.f.f;
        if (r5 != RunStatus.g) goto L10;
        return;
    L10:
        if (r5 != RunStatus.e) goto L12;
        return;
    L12:
        if (r5 != RunStatus.d) goto L14;
        return;
    L14:
        if (r5 != RunStatus.f) goto L17;
        return;
    L17:
        if (Logger.a(this.f15290c) == false) goto L19;
        Logger.a("DownloadCompleteModule", this.f15290c, "checkCompleted", "Run");
    L19:
        String r10 = null;
        this.g = null;
        DownloadInfo r11 = this.f15290c;
        long r12 = r11.f15817h0;
        char[] r13 = DownloadUtils.f16142a;
        if (r12 != (-1)) goto L22;
        r11.f15817h0 = r11.i();
    L22:
        DownloadInfo r14 = this.f15290c;
        r14.f15822k0 = false;
        if (r14.I == true) goto L31;
        long r15 = r14.i();
        DownloadInfo r16 = this.f15290c;
        if (r15 == r16.f15817h0) goto L31;
        if (Logger.a(r16) == false) goto L29;
        Logger.a("DownloadCompleteModule", this.f15290c, "checkCompleted", "Error curBytes != totalBytes");
    L29:
        this.g = new BaseException(1027, "current bytes is not equals to total bytes, curBytes:" + this.f15290c.i() + " totalBytes:" + this.f15290c.f15817h0);
    L166:
        if (this.g != null) goto L169;
        return;
    L169:
        if (Logger.a(this.f15290c) == false) goto L171;
        Logger.a("DownloadCompleteModule", this.f15290c, "checkCompleted", "Download fail and reset" + this.g);
    L171:
        this.f15290c.z();
        this.f15288a.a(this.f15290c);
        this.f15288a.q(this.f15290c.l());
        DownloadUtils.b(this.f15290c, true);
        throw this.g;
    L31:
        if (this.f15290c.i() <= 0) goto L33;
        DownloadInfo r17 = this.f15290c;
        if (r17.I == false) goto L39;
    L44:
        this.f15318h = null;
        if (this.d.a("enable_replace_external_path", 0) > 0) goto L47;
    L49:
        DownloadInfo r18 = this.f15290c;
        IDownloadMonitorDepend r19 = this.f15289b.f15883j;
        AnonymousClass1 r20 = new AnonymousClass1(this);
        SparseArray r21 = DownloadHelper.f16133a;
        if (Logger.a(r18) == false) goto L182;
        StringBuilder r110 = new StringBuilder("TargetName: ");
        String r22 = r18.e;
        String r23 = r18.f15808b;
        if (TextUtils.isEmpty(r22) == false) goto L54;
    L60:
        String r24 = null;
    L61:
        r110.append(r24);
        String r111 = r110.toString();
        int r112 = r18.l();
        String r25 = r18.P;
        Logger.a("DownloadHelper", r112, r25, "saveFileAsTargetName", r111, false);
        r10 = r25;
        goto L182
    L54:
        if (TextUtils.isEmpty(r23) == true) goto L60;
        if (DownloadFileUtils.e(r22) == true) goto L178;
    L59:
        r24 = new DownloadFile(r22, r23, true).h();
        goto L61
    L178:
        DownloadFileUtils.a(Uri.parse(r22), DownloadFileUtils.b(r22));     // Catch: Throwable -> L174
    L182:
        SparseArray r26 = DownloadHelper.f16133a;     // Catch: Throwable -> L127
        monitor-enter(r26);     // Catch: Throwable -> L127
        Object r27 = DownloadHelper.f16133a.get(r18.l());     // Catch: Throwable -> L69
        Boolean r29 = Boolean.TRUE;     // Catch: Throwable -> L69
        if (r27 != r29) goto L80;
        if (Logger.a(r18) == false) goto L71;
        Logger.a("DownloadHelper", r18.l(), r18.P, "saveFileAsTargetName", "Has another same task is saving temp file", false);     // Catch: Throwable -> L69
    L71:
        List r30 = (List) DownloadHelper.f16134b.get(r18.l());     // Catch: Throwable -> L69
        if (r30 != null) goto L74;
        r30 = new ArrayList();     // Catch: Throwable -> L69
        DownloadHelper.f16134b.put(r18.l(), r30);     // Catch: Throwable -> L69
    L74:
        r30.add(r20);     // Catch: Throwable -> L69
        DownloadCompleteModule r31 = r20.f15319a;     // Catch: Throwable -> L69
        r31.f.f = RunStatus.e;     // Catch: Throwable -> L69
        if (Logger.a(r31.f15290c) == false) goto L77;
        Logger.a("DownloadCompleteModule", r20.f15319a.f15290c, "onSameTaskSave", "Same task save");     // Catch: Throwable -> L69
    L77:
        monitor-exit(r26);     // Catch: Throwable -> L69
        goto L166
    L80:
        if (Logger.a(r18) == false) goto L82;
        Logger.a("DownloadHelper", r18.l(), r18.P, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r18.l(), false);     // Catch: Throwable -> L69
    L82:
        DownloadHelper.f16133a.put(r18.l(), r29);     // Catch: Throwable -> L69
        monitor-exit(r26);     // Catch: Throwable -> L69
        DownloadFile r32 = new DownloadFile(r18.q(), r18.p(), true);     // Catch: Throwable -> L127
        DownloadFile r33 = new DownloadFile(r18.e, r18.f15808b, true);     // Catch: Throwable -> L127
        if (r18.f15828o == true) goto L126;
        if (DownloadFileUtils.a(r33) == false) goto L126;
    L94:
        th = th;
        AnonymousClass1 r34 = r20;
    L161:
        BaseException r35 = new BaseException(1038, DownloadUtils.a(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (Logger.a(r18) == false) goto L164;
        Logger.a("DownloadHelper", r18, "saveFileAsTargetName", "Error: " + r35);
    L164:
        r34.f15319a.g = r35;
        DownloadHelper.a(r18.l(), false, r35);
        goto L166
    L90:
        if (r18.f15817h0 <= 0) goto L97;
        if (r33.length() >= r18.f15817h0) goto L97;
        AnonymousClass1 r36 = r20;
    L130:
        if (r32.f() == true) goto L133;
        BaseException r37 = new BaseException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "Can't save the temp downloaded file(" + r18.q() + "/" + r18.p() + ") to the target file(" + r18.e + "/" + r18.f15808b + ") because tempFile is not exist");     // Catch: Throwable -> L110
        r36.f15319a.g = r37;     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), false, r37);     // Catch: Throwable -> L110
    L121:
        boolean r38 = false;
    L134:
        if (r38 == false) goto L166;
        int r39 = DownloadSetting.a(r18.l(), null).a("download_finish_check_ttmd5", 2);     // Catch: Throwable -> L110 BaseException -> L146
        if (r39 <= 0) goto L149;
        long r40 = SystemClock.uptimeMillis();     // Catch: Throwable -> L110 BaseException -> L146
        int r113 = DownloadUtils.a(r32, r18.C);     // Catch: Throwable -> L110 BaseException -> L146
        r18.K0 = SystemClock.uptimeMillis() - r40;     // Catch: Throwable -> L110 BaseException -> L146
        r18.a("ttmd5_check_status", Integer.valueOf(r113));     // Catch: Throwable -> L110 BaseException -> L146
        if (r39 < 2) goto L149;
        if (r113 == 0) goto L143;
        if (r113 == 2) goto L143;
        boolean r41 = false;
    L144:
        if (r41 == true) goto L149;
        BaseException r42 = new BaseException(1034, DownloadUtils.a(r113));     // Catch: Throwable -> L110 BaseException -> L146
        r36.f15319a.g = r42;     // Catch: Throwable -> L110 BaseException -> L146
        DownloadHelper.a(r18.l(), false, r42);     // Catch: Throwable -> L110 BaseException -> L146
        DownloadUtils.b(r18, DownloadDirUtils.a(r18.e));     // Catch: Throwable -> L110 BaseException -> L146
    L143:
        r41 = true;
    L149:
        boolean r43 = !DownloadHelper.c(r32, r33);
        BaseException r44 = null;
    L151:
        if (r43 == false) goto L155;
        if (r44 != null) goto L154;
        r44 = new BaseException(1038, "Can't save the temp downloaded file(" + r18.q() + "/" + r18.p() + ") to the target file(" + r18.e + "/" + r18.f15808b + ")");     // Catch: Throwable -> L110
    L154:
        r36.f15319a.g = r44;     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), false, r44);     // Catch: Throwable -> L110
        goto L166
    L155:
        r36.onSuccess();     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), true, null);     // Catch: Throwable -> L110
    L146:
        e = move-exception;
        r44 = e;
        r43 = true;
        goto L151
    L133:
        r38 = true;
    L97:
        if (Logger.a(r18) == false) goto L99;
        Logger.a("DownloadHelper", r18.l(), r18.P, "saveFileAsTargetName", "TargetFile exist", false);     // Catch: Throwable -> L94
    L99:
        long r45 = SystemClock.uptimeMillis();     // Catch: Throwable -> L94
        int r46 = DownloadUtils.a(r33, r18.C);     // Catch: Throwable -> L94
        r18.K0 = SystemClock.uptimeMillis() - r45;     // Catch: Throwable -> L94
        if (r46 == 0) goto L102;
        if (r46 == 2) goto L102;
        if (r32.f() == true) goto L114;
        BaseException r47 = new BaseException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "Can't save the temp downloaded file(" + r18.q() + "/" + r18.p() + ") to the target file(" + r18.e + "/" + r18.f15808b + ") because tempFile is not exist and target file is exist but md5 verify invalid :" + DownloadUtils.a(r46));     // Catch: Throwable -> L112
        r36 = r20;
        r36.f15319a.g = r47;     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), false, r47);     // Catch: Throwable -> L110
        r38 = false;
    L116:
        if (r33.m() == true) goto L134;
        if (r38 == true) goto L120;
        if (r19 == null) goto L134;
        DownloadMonitorHelper.a(r19, r18, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r18.o());     // Catch: Throwable -> L110
        goto L134
    L120:
        BaseException r48 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + DownloadUtils.a(r46));     // Catch: Throwable -> L110
        r36.f15319a.g = r48;     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), false, r48);     // Catch: Throwable -> L110
    L112:
        th = th;
        r34 = r20;
        goto L161
    L114:
        r36 = r20;
        r38 = true;
    L102:
        r36 = r20;
        if (Logger.a(r18) == false) goto L125;
        Logger.a("DownloadHelper", r18.l(), r18.P, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid", false);     // Catch: Throwable -> L110
    L125:
        r18.a("ttmd5_check_status", Integer.valueOf(r46));     // Catch: Throwable -> L110
        r36.onSuccess();     // Catch: Throwable -> L110
        DownloadHelper.a(r18.l(), true, null);     // Catch: Throwable -> L110
    L126:
        r36 = r20;
    L110:
        th = th;
        r34 = r10;
    L69:
        th = th;
    L180:
        throw th;     // Catch: Throwable -> L110
    L159:
        th = th;
    L127:
        th = th;
        r34 = r20;
        goto L161
    L47:
        if (TextUtils.isEmpty(this.f15290c.C) == false) goto L49;
        this.f15318h = TTMd5.a(new File(this.f15290c.q(), this.f15290c.p()));
        goto L49
    L39:
        if (r17.f15817h0 > 0) goto L44;
        if (Logger.a(r17) == false) goto L43;
        Logger.a("DownloadCompleteModule", this.f15290c, "checkCompleted", "Error totalBytes <=0");
    L43:
        this.g = new BaseException(1044, "TotalBytes <= 0");
        goto L166
    L33:
        if (Logger.a(this.f15290c) == false) goto L35;
        Logger.a("DownloadCompleteModule", this.f15290c, "checkCompleted", "Error curBytes <=0");
    L35:
        this.g = new BaseException(1026, "curBytes <= 0");
        goto L166
    }
}
