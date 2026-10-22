package com.larus.drive.sdk.impl.service;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.impl.DriveSdkServiceImpl;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.share.service.ShareServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveFileServiceDelegate implements e89.c {
    public static final /* synthetic */ int f = 0;
    public final HashMap<String, MutableLiveData<Boolean>> a;
    public Boolean b;
    public boolean c;
    public final Lazy d;
    public u79.a e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.AI_SLIDES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DriveFileType.AI_DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DriveFileType.AI_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DriveFileType.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements nc5.c<com.bytedance.ee.bear.list.delete.e> {
        public final /* synthetic */ v79.a a;

        public c(v79.a r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.list.delete.e r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            if (r4.a == false) goto L5;
            FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFiles] Delete succeeded");
            this.a.onSuccess();
            return;
        L5:
            FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFiles] Delete failed");
            this.a.a(r4.b);
        }
    }

    public static final class d implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DriveFileServiceDelegate b;
        public final /* synthetic */ com.bytedance.ee.bear.drive.sdk.service.g c;
        public final /* synthetic */ DriveFileItem d;
        public final /* synthetic */ DriveDownloadPriority e;
        public final /* synthetic */ t79.a f;
        public final /* synthetic */ FragmentActivity g;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            Ref.BooleanRef r6 = this.a;
            if (r6.element == false) goto L5;
            return;
        L5:
            r6.element = true;
            if (r2 == false) goto L8;
            this.b.w(this.c, this.d, this.e, this.f);
            return;
        L8:
            this.b.c = false;
            if (r5 == true) goto L11;
            i2.b.l(this.g, "android.permission.WRITE_EXTERNAL_STORAGE", null, null);
        L11:
            t79.a r7 = this.f;
            if (r7 == null) goto L16;
            r7.onFailed(null, -1112);
            return;
        }

        public d(Ref.BooleanRef r1, DriveFileServiceDelegate r2, com.bytedance.ee.bear.drive.sdk.service.g r3, DriveFileItem r4, DriveDownloadPriority r5, t79.a r6, FragmentActivity r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class e implements Function1<Throwable, Unit> {
        public final /* synthetic */ h75.a a;

        public e(h75.a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.cancel();
            return Unit.INSTANCE;
        }
    }

    public static final class f implements h75.b {
        public final /* synthetic */ kotlinx.coroutines.i<DriveFileItem> a;
        public final /* synthetic */ DriveFileServiceDelegate b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "t");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.e("DriveFileServiceDelegate", "[fetchDriveFileInfo] Failed; token=" + this.c + ", error=" + r4.getMessage(), r4);
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(FileInfoV1Puller.Result r20) {
            Intrinsics.checkNotNullParameter(r20, "result");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DriveFileServiceDelegate", "[fetchDriveFileInfo] Success; result=" + r20);
            kotlinx.coroutines.i<DriveFileItem> r2 = this.a;
            Result.Companion r3 = Result.Companion;
            DriveFileServiceDelegate r4 = this.b;
            String r6 = this.c;
            int r8 = this.d;
            r4.getClass();
            String r5 = r20.name;
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            String r7 = r5;
            DriveFileType.Companion.getClass();
            DriveFileType r16 = DriveFileType.a.b(r7);
            JSONObject r9 = new JSONObject();
            r9.put("size", r20.size);
            r2.resumeWith(Result.constructor-impl(new DriveFileItem(r7, r6, "", r8, "", 0, 0, r16.getIconResId(), "", r16, 0, r9.toString())));
        }

        public f(kotlinx.coroutines.j r1, DriveFileServiceDelegate r2, String r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class g implements nd5.b {
        public final /* synthetic */ DriveFileServiceDelegate a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v79.b<Boolean> c;

        public final void a(nd5.c r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            FLogger.a.i("DriveFileServiceDelegate", "[refreshDriveFilePermission-onResult] success");
            boolean r0 = r4.isLinkShareAnyoneRead();
            DriveFileServiceDelegate.r(this.a, this.b, r0);
            DriveFileServiceDelegate r1 = this.a;
            r1.b = r4.hasModifiedLinkShare();
            v79.b<Boolean> r5 = this.c;
            if (r5 == null) goto L6;
            r5.onSuccess(Boolean.valueOf(r0));
            return;
        }

        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            FLogger.a.e("DriveFileServiceDelegate", "[refreshDriveFilePermission-onError] Refresh error; error:" + r4.getMessage());
            v79.b<Boolean> r0 = this.c;
            if (r0 == null) goto L9;
            String r5 = r4.getMessage();
            if (r5 != null) goto L7;
            r5 = "";
        L7:
            r0.onFailure(r5);
            return;
        }

        public g(DriveFileServiceDelegate r1, String r2, v79.b<Boolean> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h implements nd5.b {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public h(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void a(nd5.c r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DriveFileServiceDelegate", "[requestFileInShareControl-onResult] success");
            kotlinx.coroutines.i<Boolean> r0 = this.a;
            Integer r5 = r4.getVisibilityStatus();
            if (r5 != null) goto L9;
        L11:
            boolean r6 = false;
        L12:
            r0.resumeWith(Result.constructor-impl(Boolean.valueOf(r6)));
            return;
        L9:
            if (r5.intValue() != 0) goto L11;
            r6 = true;
            goto L12
        }

        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger.a.e("DriveFileServiceDelegate", "[requestFileInShareControl-onError] Refresh error; error:" + r4.getMessage());
            kotlinx.coroutines.i<Boolean> r5 = this.a;
            Result.Companion r0 = Result.Companion;
            r5.resumeWith(Result.constructor-impl(Boolean.TRUE));
        }
    }

    public static final class i implements com.bytedance.ee.bear.middleground_permission_export.model.j {
        public final /* synthetic */ DriveFileServiceDelegate a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ v79.b<Boolean> d;

        public final void a() {
        }

        public final void b(Throwable r4) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[setDriveFilePermission-onRequestFail] Permission set failed; error=");
            if (r4 == null) goto L5;
            String r2 = r4.getMessage();
        L6:
            r1.append(r2);
            r0.e("DriveFileServiceDelegate", r1.toString());
            v79.b<Boolean> r3 = this.d;
            if (r3 == null) goto L14;
            if (r4 == null) goto L11;
            String r5 = r4.getMessage();
            if (r5 == null) goto L11;
        L12:
            r3.onFailure(r5);
            return;
        L11:
            r5 = "";
            goto L12
        L14:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final void c(int r3) {
            FLogger.a.i("DriveFileServiceDelegate", "[setDriveFilePermission-onRequestSuccess] Success");
            DriveFileServiceDelegate.r(this.a, this.b, this.c);
            DriveFileServiceDelegate r4 = this.a;
            r4.b = Boolean.TRUE;
            v79.b<Boolean> r5 = this.d;
            if (r5 == null) goto L6;
            r5.onSuccess(Boolean.valueOf(this.c));
            return;
        }

        public i(DriveFileServiceDelegate r1, String r2, boolean r3, v79.b<Boolean> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class j implements ut5.a<Boolean> {
        public final /* synthetic */ kotlinx.coroutines.i<Integer> a;

        public j(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onResult(Object r4) {
            Boolean r5 = (Boolean) r4;
            if (this.a.isActive() == false) goto L11;
            FLogger.a.i("DriveFileServiceDelegate", "[validateDriveFileInLarkSecurityControl] Success; result=" + r5);
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L8;
            kotlinx.coroutines.i<Integer> r6 = this.a;
            Result.Companion r0 = Result.Companion;
            r6.resumeWith(Result.constructor-impl(Integer.valueOf(AbsDriveListViewModel.MENU_ID_ASK)));
            return;
        L8:
            kotlinx.coroutines.i<Integer> r7 = this.a;
            Result.Companion r1 = Result.Companion;
            r7.resumeWith(Result.constructor-impl(Integer.valueOf(AbsDriveListViewModel.MENU_ID_SHARE)));
            return;
        }

        public final void onError(int r4, Throwable r5) {
            if (this.a.isActive() == true) goto L5;
            return;
        L5:
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[validateDriveFileInLarkSecurityControl] Failed; code=");
            r1.append(r4);
            r1.append(", error=");
            if (r5 == null) goto L8;
            String r6 = r5.getMessage();
        L9:
            r1.append(r6);
            r0.e("DriveFileServiceDelegate", r1.toString(), r5);
            kotlinx.coroutines.i<Integer> r7 = this.a;
            Result.Companion r8 = Result.Companion;
            r7.resumeWith(Result.constructor-impl(Integer.valueOf(AbsDriveListViewModel.MENU_ID_DOWNLOAD)));
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    static {
    }

    public DriveFileServiceDelegate() {
        this.a = new HashMap();
        this.d = LazyKt.lazy(new com.larus.drive.sdk.impl.service.e());
    }

    public static void u(String r5) {
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5 + ".drivedownload");
        if (r2.exists() == true) goto L13;
        return;
    L13:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        boolean r7 = r2.delete();     // Catch: Throwable -> L7
        FLogger.a.i("DriveFileServiceDelegate", "[deleteFailedDownloadTempFile] deleted=" + r7 + ", path=" + r2.getAbsolutePath());     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L15;
        FLogger.a.e("DriveFileServiceDelegate", "[deleteFailedDownloadTempFile] delete failed; path=" + r2.getAbsolutePath() + ", error=" + r9.getMessage(), r9);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // e89.c
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        return Intrinsics.areEqual(v(r2).getValue(), Boolean.TRUE);
    }

    @Override // e89.c
    public final MutableLiveData d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        return v(r2);
    }

    @Override // e89.c
    public final boolean g(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "taskIds");
        com.bytedance.ee.bear.drive.sdk.service.g r0 = t.b;
        if (r0 != null) goto L6;
        FLogger.a.i("DriveFileServiceDelegate", "[cancelDownloadDriveFile] Download sdk is null");
        return false;
    L6:
        r0.n((String[]) r4.toArray(new String[0]));
        return true;
    }

    @Override // e89.c
    public final void l(u79.a r1) {
        this.e = r1;
    }

    public final MutableLiveData<Boolean> v(String r4) {
        HashMap<String, MutableLiveData<Boolean>> r0 = this.a;
        MutableLiveData<Boolean> r1 = r0.get(r4);
        if (r1 != null) goto L6;
        r1 = new MutableLiveData(Boolean.FALSE);
        r0.put(r4, r1);
    L6:
        return r1;
    }

    public static PolarisFileWrapper s(PolarisFileWrapper r8, String r9) {
        if ((!StringsKt.isBlank(r9)) == true) goto L6;
        r9 = null;
    L6:
        if (r9 != null) goto L8;
        r9 = "drive_" + System.currentTimeMillis();
    L8:
        int r0 = StringsKt.lastIndexOf$default(r9, '.', 0, false, 6, null);
        if (r0 <= 0) goto L11;
        String r2 = r9.substring(0, r0);
    L12:
        if (r0 <= 0) goto L14;
        String r1 = r9.substring(r0);
    L15:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r8, r9);
        int r10 = 1;
    L17:
        if (r3.exists() == false) goto L19;
        r3 = new PolarisFileWrapper(r8, r2 + '(' + r10 + ')' + r1);
        r10 = r10 + 1;
        goto L17
    L19:
        return r3;
    L14:
        r1 = "";
        goto L15
    L11:
        r2 = r9;
        goto L12
    }

    @Override // e89.c
    public final nc5.b e(List r4, DriveSdkServiceImpl.k r5) {
        Intrinsics.checkNotNullParameter(r4, "fileList");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.list.delete.f r1 = r0.R();
    L6:
        if (r1 != null) goto L9;
        FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFilesAndFolder] Docs sdk not init");
        r5.a(MapsKt.emptyMap());
        return null;
    L9:
        List r6 = r4;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L14;
        r2.add(((DriveFileItem) r7.next()).c);
        goto L11
    L14:
        return r1.c(r2, new com.larus.drive.sdk.impl.service.h(r5));
    L5:
        r1 = null;
        goto L6
    }

    @Override // e89.c
    public final void f(DriveFileItem r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "context");
        u79.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.startMoveDriveFileTask(r3, r4, true);
        return;
    }

    @Override // e89.c
    public final void k(DriveFileItem r37, kw9.d r38) {
        Intrinsics.checkNotNullParameter(r37, "file");
        Intrinsics.checkNotNullParameter(r38, "params");
        FragmentActivity r3 = AppHost.a.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r4 = r3;
    L7:
        if (r4 != null) goto L11;
        FLogger.a.i("DriveFileServiceDelegate", "[shareDriveFile] currentActivity is null");
        return;
    L11:
        if (Intrinsics.areEqual(this.b, Boolean.FALSE) == false) goto L13;
        FLogger.a.i("DriveFileServiceDelegate", "modify to public when first share");
        h(r38.a, r38.b, true, null);
    L13:
        ShareServiceDelegate r5 = ShareServiceDelegate.b;
        String r8 = r37.b;
        DriveFileType r11 = r37.j;
        int r12 = r37.d;
        int r13 = b.a[r11.ordinal()];
        if (r13 != 1) goto L16;
        String r7 = "slides";
    L26:
        StringBuilder r14 = new StringBuilder("https://feishu.doubao.com");
        String r15 = File.separator;
        r14.append(r15);
        r14.append(r7);
        r14.append(r15);
        r14.append(r8);
        r14.append("?type=");
        r14.append(r12);
        r5.a(new kw9.b(r4, r38, new com.larus.bmhome.share.panel.b(null, null, r14.toString(), null, null, null, null, r37.a, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108731)));
        return;
    L16:
        if (r13 != 2) goto L18;
        r7 = "docx";
        goto L26
    L18:
        if (r13 != 3) goto L20;
        r7 = "sheets";
        goto L26
    L20:
        if (r13 == 4) goto L22;
        r7 = "drive/file";
        goto L26
    L22:
        r7 = "drive/shr";
        goto L26
    L5:
        r4 = null;
        goto L7
    }

    @Override // e89.c
    public final nc5.b m(List<DriveFileItem> r7, v79.a r8) {
        Intrinsics.checkNotNullParameter(r7, "fileList");
        Intrinsics.checkNotNullParameter(r8, "callback");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.list.delete.f r1 = r0.R();
    L6:
        if (r1 != null) goto L9;
        FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFiles] Docs sdk not init");
        r8.a(MapsKt.emptyMap());
        return null;
    L9:
        List<DriveFileItem> r9 = r7;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L14;
        DriveFileItem r3 = (DriveFileItem) r10.next();
        r2.add(new com.bytedance.ee.bear.list.delete.d(r3.b, r3.d, r3.g()));
        goto L11
    L14:
        return r1.b(r2, new c(r8));
    L5:
        r1 = null;
        goto L6
    }

    @Override // e89.c
    public final void q(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        ik5.a r0 = t.c;
        if (r0 == null) goto L9;
        rd5.a r1 = r0.t2();
        if (r1 == null) goto L10;
        r1.a(r2, r3);
        return;
    L10:
        return;
    }

    public static final void r(DriveFileServiceDelegate r1, String r2, boolean r3) {
        MutableLiveData<Boolean> r4 = r1.v(r2);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r4.setValue(Boolean.valueOf(r3));
        return;
    L5:
        r4.postValue(Boolean.valueOf(r3));
    }

    public static Uri t(ContentResolver r18, Uri r110, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r110, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r110, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // e89.c
    public final nc5.b j(DriveFileItem r5, String r6, com.larus.drive.sdk.impl.utils.t.a r7) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r6, "newFileName");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        qd5.a r1 = r0.A4();
    L6:
        if (r1 != null) goto L10;
        FLogger.a.i("DriveFileServiceDelegate", "[renameDriveFile] Docs sdk not init");
        r7.onFailure("Docs sdk not init");
        return null;
    L10:
        return r1.f(r5.d, r5.b, r6, new com.larus.drive.sdk.impl.service.i(r5, this, r7, r6));
    L5:
        r1 = null;
        goto L6
    }

    @Override // e89.c
    public final Object n(String r5, int r6, Continuation<? super Boolean> r7) {
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        nd5.a r1 = r0.T2();
    L7:
        if (r1 != null) goto L10;
        FLogger.a.i("DriveFileServiceDelegate", "[requestFileInShareControl] Docs sdk not init");
        return Boxing.boxBoolean(true);
    L10:
        kotlinx.coroutines.j r2 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r2.C();
        r1.a(r5, r6, new h(r2));
        Object r8 = r2.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L13:
        return r8;
    L5:
        r1 = null;
        goto L7
    }

    @Override // e89.c
    public final void o(final String r11, int r12, Dialog r13) {
        Intrinsics.checkNotNullParameter(r13, "dialog");
        IOfficeSdkServiceV2 r2 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r2 != null) goto L7;
        FLogger.a.i("DriveFileServiceDelegate", "[addWatermarkForDriveMedia] Office sdk service not found; token=" + r11);
        return;
    L7:
        if (r2.f0() == false) goto L10;
        ((zo5.b) CCMWatermarkManager.a.getValue()).j(r11, r12, r13);
        return;
    L10:
        FLogger.a.i("DriveFileServiceDelegate", "[addWatermarkForDriveMedia] Office sdk not ready, await init; token=" + r11);
        IOfficeSdkServiceV2.a.b(r2, false, null, 7);
        final CoroutineScope r0 = CoroutineScopeKt.MainScope();
        r13.setOnDismissListener(new com.larus.drive.sdk.impl.service.f(r0, r11));
        BuildersKt.launch$default(r0, null, null, new DriveFileServiceDelegate$addWatermarkForDriveMedia$2(r2, r11, r13, r12, null), 3, null);
    }

    @Override // e89.c
    public final nc5.b p(String r3, int r4, v79.b<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        nd5.a r1 = r0.T2();
    L6:
        if (r1 != null) goto L12;
        FLogger.a.i("DriveFileServiceDelegate", "[refreshDriveFilePermission] Docs sdk not init");
        if (r5 == null) goto L10;
        r5.onFailure("Docs sdk not init");
    L10:
        return null;
    L12:
        return r1.a(r3, r4, new g(this, r3, r5));
    L5:
        r1 = null;
        goto L6
    }

    @Override // e89.c
    public final String a(DriveFileItem r18, Context r110, DriveDownloadPriority r20, t79.a r21) {
        Intrinsics.checkNotNullParameter(r18, "file");
        Intrinsics.checkNotNullParameter(r20, "priority");
        if (this.c == false) goto L8;
        FLogger.a.i("DriveFileServiceDelegate", "[downloadDriveFile] Busy, ignore new request. file=" + r18.b);
        if (r21 == null) goto L7;
        r21.onFailed(null, -1111);
    L7:
        return null;
    L8:
        com.bytedance.ee.bear.drive.sdk.service.g r3 = t.b;
        if (r3 != null) goto L13;
        if (r21 == null) goto L12;
        r21.onFailed(null, -1113);
    L12:
        return null;
    L13:
        if (r110 != null) goto L15;
        Context r1 = AppHost.a.getApplication();
    L17:
        if (Build.VERSION.SDK_INT <= 28) goto L19;
    L36:
        this.c = true;
        return w(r3, r18, r20, r21);
    L19:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L36;
        if ((r110 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r0 = (FragmentActivity) r110;
    L24:
        if (r0 != null) goto L29;
        Activity r2 = AppHost.a.a().getCurrentActivity();
        if ((r2 instanceof FragmentActivity) == false) goto L28;
        r0 = (FragmentActivity) r2;
        goto L29
    L28:
        FragmentActivity r11 = null;
    L30:
        if (r11 != null) goto L34;
        if (r21 == null) goto L33;
        r21.onFailed(null, -1112);
    L33:
        return null;
    L34:
        this.c = true;
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        i2 r5 = i2.b;
        g1.a.b(r11, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new d(r4, this, r3, r18, r20, r21, r11), null, null, 32);
        return null;
    L29:
        r11 = r0;
        goto L30
    L23:
        r0 = null;
        goto L24
    L15:
        r1 = r110;
        goto L17
    }

    @Override // e89.c
    public final Object b(String r6, int r7, boolean r8, Continuation<? super DriveFileItem> r9) {
        com.bytedance.ee.drive.preview.d r0 = t.a;
        com.bytedance.ee.drive.preview.d r1 = t.a;
        String r2 = null;
        if (r1 == null) goto L5;
        a85.a r3 = r1.u8();
    L6:
        if (r3 != null) goto L9;
        FLogger.a.i("DriveFileServiceDelegate", "[fetchDriveFileInfo] loader is null, token=" + r6);
        return null;
    L9:
        kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r9), 1);
        r4.C();
        if (r8 == false) goto L12;
        r2 = "explorer";
    L12:
        r4.i(new e(r3.fetchFileInfo(r6, r2, new f(r4, this, r6, r7))));
        Object r10 = r4.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L15:
        return r10;
    L5:
        r3 = null;
        goto L6
    }

    @Override // e89.c
    public final nc5.b h(String r4, int r5, boolean r6, v79.b<Boolean> r7) {
        Intrinsics.checkNotNullParameter(r4, "fileToken");
        ik5.a r0 = t.c;
        if (r0 == null) goto L5;
        nd5.a r1 = r0.T2();
    L6:
        if (r1 != null) goto L11;
        FLogger.a.i("DriveFileServiceDelegate", "[setDriveFilePermission] Docs sdk not init");
        if (r7 == null) goto L10;
        r7.onFailure("Docs sdk not init");
    L10:
        return null;
    L11:
        if (r6 == false) goto L13;
        int r2 = 4;
    L15:
        return r1.b(r4, r5, r2, new i(this, r4, r6, r7));
    L13:
        r2 = 1;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Override // e89.c
    public final Object i(String r4, int r5, String r6, Continuation<? super Integer> r7) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        com.bytedance.ee.permission.b r1 = t.d;
        if (r1 == null) goto L5;
        r1.b(r4, r5, r6, new j(r0));
    L5:
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L8:
        return r8;
    }

    public final String w(com.bytedance.ee.bear.drive.sdk.service.g r36, DriveFileItem r37, DriveDownloadPriority r38, final t79.a r310) {
        String r0 = r37.c();
        if (r0.length() <= 200) goto L5;
        r0 = r0.substring(0, BaiduNaviStatus.WRONG_AK_PARAM);
    L5:
        StringBuilder r2 = new StringBuilder();
        r2.append(r0);
        boolean r12 = true;
        r2.append(r37.d(true));
        String r3 = r2.toString();
        Intrinsics.checkNotNullParameter(r3, "fileName");
        AppHost.Companion r1 = AppHost.a;
        File r4 = r1.getApplication().getExternalFilesDir(null);
        if (r4 != null) goto L8;
        r4 = r1.getApplication().getFilesDir();
    L8:
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4, "drive");
        if (r5.exists() == true) goto L76;
        r5.mkdirs();
    L76:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(com.larksuite.framework.utils.i.g(r5.getAbsolutePath(), r3));     // Catch: Throwable -> L13
    L16:
        if (Result.exceptionOrNull-impl(r7) == null) goto L37;
        String r8 = StringsKt.trim(r3).toString();
        String r9 = "";
        String r10 = StringsKt.substringAfterLast(r8, '.', "");
        if (r10.length() <= 0) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == true) goto L24;
    L28:
        boolean r13 = false;
    L29:
        if (r13 == true) goto L32;
        r10 = null;
    L32:
        if (r10 == null) goto L36;
        String r14 = ".".concat(r10);
        if (r14 == null) goto L36;
        r9 = r14;
    L36:
        r7 = "unknow".concat(r9);
        goto L37
    L24:
        if (r10.length() > 20) goto L28;
        if (Intrinsics.areEqual(r10, r8) == true) goto L28;
        r13 = true;
        goto L29
    L21:
        r11 = false;
    L37:
        final String r15 = new PolarisFileWrapper(r5, (String) r7).getAbsolutePath();
        final String r16 = new PolarisFileWrapper(r15).getName();
        DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r21 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r17 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r18 = r37.b;
        int r110 = r38.getValue();
        DriveBizScene r33 = DriveBizScene.DriveBizScene_CCM;
        DriveWatermarkScene r34 = DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD;
        Intrinsics.checkNotNull(r16);
        final DriveFileType r20 = r37.j;
        final String r111 = r37.d(true).toLowerCase(Locale.ROOT);
        String r22 = r37.b;
        Long r23 = Long.valueOf(r37.e());
        if (r23.longValue() <= 0) goto L40;
        boolean r24 = true;
    L41:
        if (r24 == false) goto L43;
        Long r25 = r23;
    L45:
        if (r111.length() <= 0) goto L47;
        boolean r26 = true;
    L48:
        if (r26 == false) goto L50;
        String r27 = r111;
    L51:
        final com.larus.platform.audit.b r112 = new com.larus.platform.audit.b(r22, r16, r25, null, r27, 8);
        Object r28 = Result.constructor-impl(r36.g(new DownloadRequestInfo(r15, r18, "", "explorer", r110, "", r21, "", 0, false, "", 2, new DriveFileServiceDelegate$createDownloadCallback$1(this, r15, r310, r20, r111, r16, r112), null, false, null, null, r33, r34)));     // Catch: Throwable -> L54
    L57:
        if (Result.exceptionOrNull-impl(r28) == null) goto L62;
        this.c = false;
        u(r15);
        if (r310 == null) goto L62;
        r310.onFailed(null, -1114);
    L62:
        if (Result.isFailure-impl(r28) == false) goto L64;
        r28 = null;
    L64:
        String r30 = (String) r28;
        if (r30 != null) goto L67;
    L70:
        if (r12 == false) goto L75;
        this.c = false;
        u(r15);
        if (r310 == null) goto L74;
        r310.onFailed(null, -1114);
    L74:
        return null;
    L75:
        return r30;
    L67:
        if (r30.length() == 0) goto L70;
        r12 = false;
    L54:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L50:
        r27 = null;
        goto L51
    L47:
        r26 = false;
        goto L48
    L43:
        r25 = null;
        goto L45
    L40:
        r24 = false;
    L13:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
