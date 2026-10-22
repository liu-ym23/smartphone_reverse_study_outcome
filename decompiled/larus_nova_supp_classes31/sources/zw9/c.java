package zw9;

import android.app.Application;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.slides.operation.download.view.SlidesExportChooseDialog;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gk5.e;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kw9.h;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final HashMap<String, Boolean> a = null;
    public static Boolean b;
    public static final String c = null;

    public static final class a implements ut5.a<GetPublicPermissionApi.Result> {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void onResult(Object r7) {
            GetPublicPermissionApi.Result r8 = (GetPublicPermissionApi.Result) r7;
            FLogger.a.i("SlidesOpManager", "[refreshSlidesPermissionV2] success");
            HashMap<String, Boolean> r0 = c.a;
            String r1 = this.a;
            boolean r2 = false;
            if (r8 == null) goto L9;
            GetPublicPermissionApi.Result.PermPublic r4 = r8.getPublicPerm();
            if (r4 == null) goto L9;
            if (r4.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_READ.getTypeValue().intValue()) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L19;
            if (r8 == null) goto L17;
            GetPublicPermissionApi.Result.PermPublic r6 = r8.getPublicPerm();
            if (r6 == null) goto L17;
            if (r6.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_EDIT.getTypeValue().intValue()) goto L17;
            boolean r9 = true;
        L18:
            if (r9 == true) goto L19;
        L20:
            r0.put(r1, Boolean.valueOf(r2));
            if (r8 == null) goto L25;
            GetPublicPermissionApi.Result.PermPublic r10 = r8.getPublicPerm();
            if (r10 == null) goto L25;
            Boolean r11 = Boolean.valueOf(r10.getHasModifiedLinkShare());
        L26:
            c.b = r11;
            return;
        L25:
            r11 = null;
        L17:
            r9 = false;
        L19:
            r2 = true;
        L9:
            r5 = false;
            goto L10
        }

        public final void onError(int r4, Throwable r5) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[refreshSlidesPermissionV2] failed, code:");
            r1.append(r4);
            r1.append(", msg:");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.e("SlidesOpManager", r1.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class b implements ut5.a<UpdatePublicPermissionApi.Result> {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1<Boolean, Unit> d;

        public final void onResult(Object r3) {
            UpdatePublicPermissionApi.Result r4 = (UpdatePublicPermissionApi.Result) r3;
            FLogger.a.i("SlidesOpManager", "[updatePublicPermissionV2] success");
            HashMap<String, Boolean> r5 = c.a;
            c.b = Boolean.TRUE;
            Function0<Unit> r6 = this.a;
            if (r6 == null) goto L6;
            r6.invoke();
            return;
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
            r0.e("SlidesOpManager", r1.toString());
            c.a.put(this.b, Boolean.valueOf(!this.c));
            Function1<Boolean, Unit> r7 = this.d;
            if (r7 == null) goto L10;
            r7.invoke(Boolean.valueOf(!this.c));
            return;
        L10:
            return;
        L5:
            r6 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<Unit> r1, String r2, boolean r3, Function1<? super Boolean, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        a = new HashMap();
        c = "https://feishu.doubao.com/slides/";
    }

    public static com.bytedance.ee.permission.a a() {
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L7;
        e r1 = r0.q0();
        if (r1 == null) goto L7;
        return r1.i0();
    L7:
        return null;
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        PermissionSdk r0 = a();
        if (r0 != null) goto L6;
        FLogger.a.e("SlidesOpManager", "[refreshSlidesPermissionV2] permission sdk is null");
        return;
    L6:
        vt5.a r1 = new vt5.a(r3, 30);
        r0.a().d(r1, new a(r3));
    }

    public static void d(Fragment r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "downloadParams");
        FLogger.a.i("SlidesOpManager", "[showDownloadFragment] token:" + r4.a);
        String r0 = r4.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        s r2 = s.a;
        Application r5 = AppHost.a.getApplication();
        r2.getClass();
        s.s(r5, 2131909776);
    L11:
        int r6 = SlidesExportChooseDialog.k;
        Intrinsics.checkNotNullParameter(r4, "params");
        SlidesExportChooseDialog r7 = new SlidesExportChooseDialog();
        r7.j = r4;
        String r8 = r4.a;
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        r7.f = r8;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L17
        SlidesExportChooseDialog.a.b(r7, r3.getChildFragmentManager());     // Catch: Throwable -> L17
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L25;
        FLogger.a.e("SlidesOpManager", "[showDownloadFragment] error:" + r11.getMessage());
        return;
    L25:
        return;
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void c(String r4, boolean r5, Function0 r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r4, "slidesToken");
        PermissionSdk r0 = a();
        if (r0 != null) goto L12;
        FLogger.a.e("SlidesOpManager", "[updatePublicPermissionV2] permission sdk is null");
        Boolean r8 = a.get(r4);
        if (r8 == null) goto L7;
        boolean r9 = r8.booleanValue();
    L10:
        r7.invoke(Boolean.valueOf(r9));
        return;
    L7:
        if (r5 == true) goto L9;
        r9 = true;
        goto L10
    L9:
        r9 = false;
        goto L10
    L12:
        vt5.c r1 = new vt5.c(r4, 30);
        if (r5 == false) goto L15;
        TypeExternalAccess r2 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
    L16:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.d = r2;
        if (r5 == false) goto L19;
        TypeLinkShare r3 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
    L20:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.e = r3;
        r0.a().f(r1, new b(r6, r4, r5, r7));
        Boolean r10 = Boolean.valueOf(r5);
        a.put(r4, r10);
        return;
    L19:
        r3 = TypeLinkShare.LINK_SHARE_CLOSE;
        goto L20
    L15:
        r2 = TypeExternalAccess.EXTERNAL_ACCESS_CLOSE;
        goto L16
    }
}
