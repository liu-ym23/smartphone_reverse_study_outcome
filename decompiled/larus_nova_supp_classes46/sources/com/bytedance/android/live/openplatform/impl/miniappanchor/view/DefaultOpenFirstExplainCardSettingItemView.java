package com.bytedance.android.live.openplatform.impl.miniappanchor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.LiveAnchorShelfContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.live.datacontext.n;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0011\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0011\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/view/DefaultOpenFirstExplainCardSettingItemView;", "Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/SettingItemView;", "", "getDescription", "Landroid/view/View;", "getRightView", "Lso0/a;", "<set-?>", "a", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "miniAppAnchorService", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultOpenFirstExplainCardSettingItemView extends SettingItemView {
    public so0.a a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Object[] r0 = new Object[1];
            if (this.a != 1) goto L5;
            String r4 = s1.B(2131920395);
        L6:
            r0[0] = r4;
            f2.c(s1.C(2131920397, r0), 0);
            return;
        L5:
            r4 = "";
            goto L6
        }
    }

    public static final class b implements LiveSwitchButton.e {
        public final /* synthetic */ DefaultOpenFirstExplainCardSettingItemView a;

        public b(DefaultOpenFirstExplainCardSettingItemView r1) {
            this.a = r1;
        }

        public final void d0(LiveSwitchButton r3, boolean r4) {
            if (r4 == false) goto L29;
            f2.b(2131921073, 0);
            xs2.b.a().post(new d());
            OpenPlatformContext r5 = this.a.getMiniAppAnchorService().a();
            if (r5 != null) goto L7;
        L13:
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r6 = AnchorMiniAppDataContext.a.a();
            if (r6 == null) goto L23;
            n<ShelfInfo> r7 = r6.m618getShelfInfo();
            if (r7 == null) goto L23;
            ShelfInfo r8 = (ShelfInfo) r7.getValue();
            if (r8 == null) goto L23;
            ShelfMicroAppInfo r9 = r8.appInfo;
            if (r9 == null) goto L23;
            String r10 = r9.appId;
            if (r10 == null) goto L23;
        L24:
            OpenPlatformContext r0 = this.a.getMiniAppAnchorService().a();
            if (r0 == null) goto L30;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L30;
            r1.reportDefaultOpenFirstExplainCardOn(r10, "shelf_page_setting");
        L30:
            this.a.getMiniAppAnchorService().updateMemoryStatus(2, r4);
            return;
        L23:
            r10 = "";
            goto L24
        L7:
            if (r5.isInLive() != true) goto L13;
            OpenPlatformContext r11 = this.a.getMiniAppAnchorService().a();
            if (r11 == null) goto L13;
            LiveAnchorShelfContextService r12 = (LiveAnchorShelfContextService) r11.getService(LiveAnchorShelfContextService.class);
            if (r12 == null) goto L13;
            r12.startFirstCardExplain();
            goto L13
        L29:
            f2.b(2131921072, 0);
            goto L30
        }
    }

    public final so0.a getMiniAppAnchorService() {
        so0.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public View getRightView() {
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        LiveSwitchButton r0 = LayoutInflater.from(getContext()).inflate(2131567794, this, false);
        if (r0 == null) goto L16;
        LiveSwitchButton r1 = r0;
        so0.a r2 = this.a;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        r1.setChecked(r2.getMemoryStatus().b());
        so0.a r3 = this.a;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L10:
        int r4 = r3.getCoexistComponent();
        if (r4 == 0) goto L13;
        setAlpha(0.4f);
        setOnClickListener(new a(r4));
        r1.setEnabled(false);
    L13:
        r1.setOnCheckedChangeListener(new b(this));
        return r1;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton");
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public String getDescription() {
        return s1.B(2131921070);
    }

    public DefaultOpenFirstExplainCardSettingItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public DefaultOpenFirstExplainCardSettingItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public DefaultOpenFirstExplainCardSettingItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
