package com.larus.sheet.operation;

import android.app.Application;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.card.sheet.download.OfficeCardSheetDownloadServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final HashMap<String, MutableLiveData<Boolean>> a = null;
    public static Boolean b;
    public static final String c = null;

    public static final class a implements ut5.a<GetPublicPermissionApi.Result> {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void onResult(Object r6) {
            GetPublicPermissionApi.Result r7 = (GetPublicPermissionApi.Result) r6;
            FLogger.a.i("SheetOpManager", "[refreshSheetPermissionV2] success");
            HashMap<String, MutableLiveData<Boolean>> r0 = f.a;
            String r1 = this.a;
            boolean r2 = true;
            if (r7 == null) goto L9;
            GetPublicPermissionApi.Result.PermPublic r3 = r7.getPublicPerm();
            if (r3 == null) goto L9;
            if (r3.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_READ.getTypeValue().intValue()) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L21;
            if (r7 == null) goto L17;
            GetPublicPermissionApi.Result.PermPublic r5 = r7.getPublicPerm();
            if (r5 == null) goto L17;
            if (r5.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_EDIT.getTypeValue().intValue()) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == true) goto L21;
            r2 = false;
        L17:
            r8 = false;
        L21:
            f.a(r1, r2);
            if (r7 == null) goto L26;
            GetPublicPermissionApi.Result.PermPublic r9 = r7.getPublicPerm();
            if (r9 == null) goto L26;
            Boolean r10 = Boolean.valueOf(r9.getHasModifiedLinkShare());
        L27:
            f.b = r10;
            return;
        L26:
            r10 = null;
        L9:
            r4 = false;
            goto L10
        }

        public final void onError(int r4, Throwable r5) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[refreshSheetPermissionV2] failed, code:");
            r1.append(r4);
            r1.append(", msg:");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.e("SheetOpManager", r1.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class b implements xt5.a<com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result> {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final void a(xt5.c r6) {
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result r7 = (com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result) r6;
            FLogger.a.i("SheetOpManager", "[refreshSheetPermission] success");
            HashMap<String, MutableLiveData<Boolean>> r0 = f.a;
            String r1 = this.a;
            boolean r2 = true;
            if (r7 == null) goto L9;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result.PermPublic r3 = r7.getPublicPerm();
            if (r3 == null) goto L9;
            if (r3.getLinkShareEntityV2() != com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_READ.getTypeValue().intValue()) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L21;
            if (r7 == null) goto L17;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result.PermPublic r5 = r7.getPublicPerm();
            if (r5 == null) goto L17;
            if (r5.getLinkShareEntityV2() != com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_EDIT.getTypeValue().intValue()) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == true) goto L21;
            r2 = false;
        L17:
            r8 = false;
        L21:
            f.a(r1, r2);
            if (r7 == null) goto L26;
            com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result.PermPublic r9 = r7.getPublicPerm();
            if (r9 == null) goto L26;
            Boolean r10 = Boolean.valueOf(r9.getHasModifiedLinkShare());
        L27:
            f.b = r10;
            return;
        L26:
            r10 = null;
        L9:
            r4 = false;
            goto L10
        }

        public final void onError(int r4, Throwable r5) {
            FLogger.a.e("SheetOpManager", "[refreshSheetPermission] failed, code:" + r4 + ", msg:" + r5.getMessage());
        }
    }

    public static final class c implements ut5.a<UpdatePublicPermissionApi.Result> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Function1<Boolean, Unit> e;

        public final void onResult(Object r3) {
            UpdatePublicPermissionApi.Result r4 = (UpdatePublicPermissionApi.Result) r3;
            FLogger.a.i("SheetOpManager", "[updatePublicPermissionV2] success");
            HashMap<String, MutableLiveData<Boolean>> r5 = f.a;
            f.a(this.a, this.b);
            f.b = Boolean.TRUE;
            this.c.invoke();
        }

        public final void onError(int r4, Throwable r5) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[updatePublicPermissionV2] failed, code:");
            r1.append(r4);
            r1.append(", msg:");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.e("SheetOpManager", r1.toString());
            HashMap<String, MutableLiveData<Boolean>> r7 = f.a;
            f.a(this.a, this.d);
            this.e.invoke(Boolean.valueOf(this.d));
            return;
        L5:
            r6 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String r1, boolean r2, Function0<Unit> r3, boolean r4, Function1<? super Boolean, Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d implements xt5.a<com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi.Result> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function1<Boolean, Unit> c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Function0<Unit> e;

        public final void a(xt5.c r3) {
            com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi.Result r4 = (com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi.Result) r3;
            FLogger.a.i("SheetOpManager", "[updatePublicPermission] success");
            HashMap<String, MutableLiveData<Boolean>> r5 = f.a;
            f.a(this.a, this.d);
            f.b = Boolean.TRUE;
            this.e.invoke();
        }

        public final void onError(int r4, Throwable r5) {
            FLogger.a.e("SheetOpManager", "[updatePublicPermission] failed, code:" + r4 + ", msg:" + r5.getMessage());
            HashMap<String, MutableLiveData<Boolean>> r6 = f.a;
            f.a(this.a, this.b);
            this.c.invoke(Boolean.valueOf(this.b));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(String r1, boolean r2, Function1<? super Boolean, Unit> r3, boolean r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public f() {
    }

    static {
        a = new HashMap();
        c = "https://feishu.doubao.com/sheets/";
    }

    public static com.bytedance.ee.permission.a c() {
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L7;
        gk5.e r1 = r0.q0();
        if (r1 == null) goto L7;
        return r1.i0();
    L7:
        return null;
    }

    public static MutableLiveData b(String r3) {
        HashMap<String, MutableLiveData<Boolean>> r0 = a;
        MutableLiveData<Boolean> r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = new MutableLiveData(Boolean.FALSE);
        r0.put(r3, r1);
    L6:
        return r1;
    }

    public static void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        PermissionSdk r0 = c();
        if (r0 == null) goto L6;
        vt5.a r1 = new vt5.a(r3, 3);
        r0.a().d(r1, new a(r3));
        return;
    L6:
        wt5.c r2 = wt5.c.a;
        wt5.a r4 = wt5.c.c;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("apiAll");
        r4 = null;
    L9:
        yt5.a r5 = new yt5.a(r3);
        b r6 = new b(r3);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "request");
        new yt5.b(r5, com.bytedance.ee.permission.sdk.doc.GetPublicPermissionApi.Result.class, r6).b();
    }

    public static final void a(String r2, boolean r3) {
        MutableLiveData r4 = b(r2);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r4.setValue(Boolean.valueOf(r3));
        return;
    L5:
        r4.postValue(Boolean.valueOf(r3));
    }

    public static void f(Fragment r21, kw9.e r22) {
        Intrinsics.checkNotNullParameter(r21, "fragment");
        Intrinsics.checkNotNullParameter(r22, "downloadParams");
        FLogger.a.i("SheetOpManager", "[showDownloadFragment] token:" + r22.a);
        String r4 = r22.a;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        s.s(r1, 2131909776);
        return;
    L12:
        int r6 = com.larus.office.card.sheet.download.a.a;
        String r7 = r22.a;
        if (r7 != null) goto L15;
        String r8 = "";
    L16:
        if (r7 != null) goto L18;
        String r9 = "";
    L19:
        com.larus.office.card.sheet.a r3 = new com.larus.office.card.sheet.a(r9, r8, r22.h, r22.d, r22.e, r22.k, r22.l, r22.m, r22.n, r22.o, r22.q, r22.r, r22.i);
        Intrinsics.checkNotNullParameter(r21, "fragment");
        Intrinsics.checkNotNullParameter(r3, "downloadParams");
        OfficeCardSheetDownloadServiceDelegate.b.a(r21, r3);
        return;
    L18:
        r9 = r7;
        goto L19
    L15:
        r8 = r7;
        goto L16
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public static void e(String r10, boolean r11, Function0 r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "sheetToken");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onError");
        Intrinsics.checkNotNullParameter(r10, "sheetToken");
        Intrinsics.checkNotNullParameter(r10, "sheetToken");
        boolean r0 = Intrinsics.areEqual(b(r10).getValue(), Boolean.TRUE);
        PermissionSdk r1 = c();
        if (r1 == null) goto L14;
        vt5.c r8 = new vt5.c(r10, 3);
        if (r11 == false) goto L7;
        TypeExternalAccess r3 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L8:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r8.d = r3;
        if (r11 == false) goto L11;
        TypeLinkShare r4 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L12:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.e = r4;
        r1.a().f(r8, new c(r10, r11, r12, r0, r13));
        return;
    L11:
        r4 = TypeLinkShare.LINK_SHARE_CLOSE;
        goto L12
    L7:
        r3 = TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L8
    L14:
        yt5.c r2 = new yt5.c(r10);
        if (r11 == false) goto L17;
        com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess r5 = com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L18:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.d = r5;
        if (r11 == false) goto L21;
        com.bytedance.ee.permission.sdk.define.value.TypeLinkShare r6 = com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L22:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.e = r6;
        wt5.c r7 = wt5.c.a;
        wt5.a r9 = wt5.c.c;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("apiAll");
        r9 = null;
    L25:
        d r14 = new d(r10, r0, r13, r11, r12);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "request");
        new wt5.b(r2, com.bytedance.ee.permission.sdk.doc.UpdatePublicPermissionApi.Result.class, r14).b();
        return;
    L21:
        r6 = com.bytedance.ee.permission.sdk.define.value.TypeLinkShare.LINK_SHARE_CLOSE;
        goto L22
    L17:
        r5 = com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L18
    }
}
