package com.ss.android.socialbase.downloader.core.module;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.view.PointerIconCompat;
import com.lynx.tasm.utils.e;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadPrepareModule extends AbsDownloadModule {
    public DownloadPrepareModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L6;
        Logger.a("DownloadPrepareModule", this.f15290c, "proceed", "Run");
    L6:
        if (b() == true) goto L28;
        r5.d = true;
        this.e.b();     // Catch: Throwable -> L12 BaseException -> L14
        r5.c();     // Catch: Throwable -> L12 BaseException -> L14
        b(null);
        return;
    L18:
        th = move-exception;
        b(null);
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        b(e);
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        b(new BaseException(1000, DownloadUtils.a(th)));
        return;
    }

    public final void b(BaseException r5) {
        if (Logger.a(this.f15290c) == false) goto L16;
        Logger.a("DownloadPrepareModule", this.f15290c, "onDownloadTaskEnd", "RunStatus: " + this.f.f);
    L16:
        this.f.f15309b.s.f15908k = System.currentTimeMillis();     // Catch: Throwable -> L8 BaseException -> L10
        DownloadComponentManager.a(this.f.f15309b, false);     // Catch: Throwable -> L8 BaseException -> L10
        a(r5);     // Catch: Throwable -> L8 BaseException -> L10
    L14:
        this.f.g = false;
        return;
    L10:
        e = move-exception;
        this.e.a(e);
    L8:
        th = move-exception;
        this.e.a(new BaseException(1046, DownloadUtils.a(th)));
        goto L14
    }

    public final void a(BaseException r15) {
        switch(this.f.f.ordinal()) {
            case 1: goto L74;
            case 2: goto L72;
            case 3: goto L4;
            case 4: goto L63;
            case 5: goto L81;
            case 6: goto L34;
            case 7: goto L28;
            case 8: goto L8;
            default: goto L4;
        };
    L4:
        if (r15 != null) goto L6;
        r15 = new BaseException(1092, "Unknown runStatus:" + this.f.f);
    L6:
        this.e.a(r15);
        return;
    L8:
        DownloadStatusHandler r14 = this.e;
        r14.getClass();
    L13:
        th = move-exception;
        r14.a(new BaseException(PointerIconCompat.TYPE_TEXT, DownloadUtils.a(th, "onCompleted")));
    L27:
        RetryScheduler.c().f15771a.b();
        return;
    L10:
        if (Logger.a(r14.f15551c) == false) goto L76;
        Logger.a("DownloadStatusHandler", r14.f15551c, "onSaveTempFileSuccess", "Success");     // Catch: Throwable -> L13
    L76:
        r14.a();     // Catch: Throwable -> L13 BaseException -> L23
        DownloadInfo r16 = r14.f15551c;     // Catch: Throwable -> L13
        if (r16 != null) goto L19;
        r14.a(new BaseException(1087, "onSaveTempFileSuccess DownloadInfo is null"));     // Catch: Throwable -> L13
        goto L27
    L19:
        r16.l0 = false;     // Catch: Throwable -> L13
        r16.U = false;     // Catch: Throwable -> L13
        if (r16.Y > 0) goto L22;
        r16.Y = System.currentTimeMillis();     // Catch: Throwable -> L13
    L22:
        r14.a(-3, null);     // Catch: Throwable -> L13
        r14.d.d(r14.f15551c.l(), r14.f15551c.f15817h0);     // Catch: Throwable -> L13
        r14.d.q(r14.f15551c.l());     // Catch: Throwable -> L13
        goto L27
    L23:
        e = move-exception;
        r14.a(e);     // Catch: Throwable -> L13
        goto L27
    L28:
        DownloadStatusHandler r17 = this.e;
        r17.f15551c.a(-7);
        r17.d.j(r17.f15551c.l());     // Catch: SQLiteException -> L31
    L33:
        r17.a(-7, null);
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L34:
        DownloadStatusHandler r18 = this.e;
        DownloadCommonParams r19 = this.f;
        String r5 = r19.f15314k;
        String r110 = r19.f15315l;
        if (Logger.a(r18.f15551c) == false) goto L37;
        DownloadInfo r10 = r18.f15551c;
        StringBuilder r11 = e.b("ExistTargetFileName:", r110, " but curName is ");
        r11.append(r18.f15551c.f15808b);
        Logger.a("DownloadStatusHandler", r10, "onCompleteForFileExist", r11.toString());
    L37:
        DownloadInfo r12 = r18.f15551c;
        SparseArray r13 = DownloadHelper.f16133a;
        if (r12 != null) goto L40;
    L61:
        r18.a();
        r18.f15551c.U = true;
        r18.a(-3, null);
        r18.d.a(r18.f15551c);
        return;
    L40:
        if (TextUtils.isEmpty(r110) == true) goto L61;
        if (TextUtils.isEmpty(r5) == true) goto L61;
        if (r110.equals(r12.f15808b) == true) goto L61;
        DownloadFile r20 = new DownloadFile(r12.e, r110, true);
        DownloadFile r21 = new DownloadFile(r12.e, r12.f15808b, true);
        if (Logger.a(r12) == false) goto L50;
        Logger.a("DownloadHelper", r12.l(), r12.P, "copyFileFromExistFileWithSameName", "ExistFile:" + r20.h() + " targetFile:" + r21.h(), false);
    L50:
        if (r21.f() == false) goto L57;
        if (r21.b() == true) goto L57;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L57:
        if (DownloadHelper.a(r20, r21) == true) goto L61;
        String r22 = r12.e;
        throw new BaseException(1001, a.u(a.y("Can't copy the exist file(", r22, "/", r110, ") to the target file("), r22, "/", r12.f15808b, ")"));
    L63:
        DownloadStatusHandler r111 = this.e;
        if (r111.f15551c == null) goto L71;
        r111.a();
        if (Logger.a(r111.f15551c) == false) goto L68;
        Logger.a("DownloadStatusHandler", r111.f15551c, "onCompleteForFileExist", "Success");
    L68:
        r111.f15551c.U = true;
        r111.a(-3, null);
        r111.d.d(r111.f15551c.l(), r111.f15551c.f15817h0);
        r111.d.a(r111.f15551c);
        r111.d.q(r111.f15551c.l());
        return;
    L71:
        throw new BaseException(1087, "onCompleteForFileExist DownloadInfo is null");
    L72:
        this.e.a(-4, null);
        return;
    L74:
        this.e.c();
        return;
    }
}
