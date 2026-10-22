package com.larus.enterprise_biz.impl.share;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.router.SmartRouter;
import com.larus.drive.sdk.api.IDriveSdkGenericService;
import com.larus.share.service.IShareOfficeDocService;
import com.larus.share.service.ShareDocType;
import com.larus.share.service.i;
import com.larus.sheet.api.ISheetService;
import com.larus.slides.api.ISlidesService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016JC\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\"\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001d"}, d2 = {"Lcom/larus/enterprise_biz/impl/share/ShareOfficeDocServiceImpl;", "Lcom/larus/share/service/IShareOfficeDocService;", "<init>", "()V", "isAvailable", "", "isDocPublic", "docType", "Lcom/larus/share/service/ShareDocType;", "token", "", "observeDocPermission", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isPublic", "openPermissionSetting", "context", "Landroid/content/Context;", "params", "Lcom/larus/share/service/ShareDocPermissionParams;", "openSlidesPermissionSetting", "openSheetPermissionSetting", "openDrivePermissionSetting", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareOfficeDocServiceImpl implements IShareOfficeDocService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareDocType.values().length];
            r0[ShareDocType.SLIDES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ShareDocType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ShareDocType.DRIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public ShareOfficeDocServiceImpl() {
    }

    public final boolean a(ShareDocType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "docType");
        Intrinsics.checkNotNullParameter(r4, "token");
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        ISlidesService r6 = (ISlidesService) ServiceManager.get().getService(ISlidesService.class);
        if (r6 != null) goto L23;
    L25:
        return false;
    L23:
        if (r6.f(r4) != true) goto L25;
        return true;
    L5:
        if (r5 != 2) goto L7;
        ISheetService r7 = (ISheetService) ServiceManager.get().getService(ISheetService.class);
        if (r7 == null) goto L25;
        if (r7.h(r4) != true) goto L25;
        return true;
    L7:
        if (r5 != 3) goto L14;
        IDriveSdkGenericService r8 = (IDriveSdkGenericService) ServiceManager.get().getService(IDriveSdkGenericService.class);
        if (r8 == null) goto L25;
        if (r8.c(r4) != true) goto L25;
        return true;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void c(Context r11, ShareDocType r12, i r13) {
        Intrinsics.checkNotNullParameter(r12, "docType");
        Intrinsics.checkNotNullParameter(r13, "params");
        int r14 = b.a[r12.ordinal()];
        if (r14 != 1) goto L5;
        com.bytedance.router.i r15 = SmartRouter.buildRoute(r11, "//flow/slides_permission_settings");
        r15.d = 2130772401;
        r15.e = 2130772399;
        r15.k("slides_permission", r13.b);
        r15.j("slides_token", r13.a);
        r15.j("aippt_task_id", r13.d);
        r15.j("presentation_id", r13.e);
        r15.j("resource_id", r13.g);
        r15.i("resource_type", r13.h);
        r15.j("artifact_meta_id", r13.i);
        r15.i("artifact_type", r13.j);
        r15.k("set_default_landscape", r13.c);
        r15.d();
        return;
    L5:
        if (r14 != 2) goto L7;
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r11, "//flow/sheet_permission_settings");
        r16.d = 2130772401;
        r16.e = 2130772399;
        r16.k("slides_permission", r13.b);
        r16.j("sheets_token", r13.a);
        r16.j("aippt_task_id", r13.d);
        r16.j("spreadsheet_id", r13.f);
        r16.j("resource_id", r13.g);
        r16.i("resource_type", r13.h);
        r16.j("artifact_meta_id", r13.i);
        r16.i("artifact_type", r13.j);
        r16.k("set_default_landscape", r13.c);
        r16.d();
        return;
    L7:
        if (r14 != 3) goto L14;
        com.bytedance.router.i r17 = SmartRouter.buildRoute(r11, "//flow/drive_permission_settings");
        r17.d = 2130772401;
        r17.e = 2130772399;
        r17.k("privacy_status", r13.b);
        r17.j("drive_file_token", r13.a);
        Integer r18 = r13.k;
        if (r18 == null) goto L11;
        int r110 = r18.intValue();
    L12:
        r17.h("drive_file_type", r110);
        r17.d();
        return;
    L11:
        r110 = 12;
        goto L12
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(ShareDocType r2, String r3, LifecycleOwner r4, final Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "docType");
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "onChanged");
        int r6 = b.a[r2.ordinal()];
        if (r6 != 1) goto L5;
        return;
    L5:
        if (r6 != 2) goto L7;
        ISheetService r7 = (ISheetService) ServiceManager.get().getService(ISheetService.class);
        if (r7 == null) goto L25;
        MutableLiveData r8 = r7.g(r3);
        if (r8 == null) goto L26;
        r8.observe(r4, new c99.a(r5));
        return;
    L26:
        return;
    L25:
        return;
    L7:
        if (r6 != 3) goto L14;
        IDriveSdkGenericService r9 = (IDriveSdkGenericService) ServiceManager.get().getService(IDriveSdkGenericService.class);
        if (r9 == null) goto L22;
        LiveData<Boolean> r10 = r9.d(r3);
        if (r10 == null) goto L23;
        r10.observe(r4, new c99.b(r5));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
