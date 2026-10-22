package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardMoreDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/OpenPlatformBottomSettingDialog;", "", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementCardMoreDialog extends OpenPlatformBottomSettingDialog {
    public static final /* synthetic */ int h = 0;
    public so0.a e;
    public ShelfCardInfo f;
    public int g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final String W90() {
        return "更多";
    }

    public ShelfManagementCardMoreDialog() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.g = -1;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r1 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.e = r1;
        Disposable r2 = m.f(xs2.b.a().b(zp0.a.class), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        r0.add(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final List<SettingItemView> V90() {
        Context r0 = getContext();
        if (r0 == null) goto L10;
        ArrayList r1 = new ArrayList();
        r1.add(new dq0.d(this, this.f, this.g, r0));
        ShelfCardInfo r2 = this.f;
        if (r2 != null) goto L7;
    L8:
        r1.add(new dq0.b(this, this.f, this.g, r0));
        return r1;
    L7:
        if (r2.v0() != true) goto L8;
        return r1;
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final void X90() {
        super.X90();
        so0.a r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L22;
        AnchorMiniAppAppLogContextService r2 = (AnchorMiniAppAppLogContextService) r1.getService(AnchorMiniAppAppLogContextService.class);
        if (r2 == null) goto L23;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        if (r3 == null) goto L19;
        n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L19;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L19;
        ShelfMicroAppInfo r6 = r5.appInfo;
        if (r6 == null) goto L19;
        String r7 = r6.appId;
        if (r7 == null) goto L19;
    L20:
        r2.reportCardMorePanelClick(r7, "click_close");
        return;
    L19:
        r7 = "";
        goto L20
    L23:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        ShelfCardInfo r5 = (ShelfCardInfo) r4.getParcelable("card_info");
    L6:
        this.f = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        int r7 = r6.getInt("card_position");
    L10:
        this.g = r7;
        so0.a r8 = this.e;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L13:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L36;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L37;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L27;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L27;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L27;
        ShelfMicroAppInfo r11 = r2.appInfo;
        if (r11 == null) goto L27;
        String r12 = r11.appId;
        if (r12 == null) goto L27;
    L28:
        ShelfCardInfo r13 = this.f;
        if (r13 != null) goto L31;
    L33:
        boolean r14 = false;
    L34:
        r10.reportCardMorePanelShow(r12, r14);
        return;
    L31:
        if (r13.v0() == true) goto L33;
        r14 = true;
    L27:
        r12 = "";
        goto L28
    L37:
        return;
    L36:
        return;
    L9:
        r7 = -1;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
