package com.bytedance.android.live.openplatform.impl.miniappanchor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0011\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0011\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/view/ShowImportantCardView;", "Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/SettingItemView;", "", "getDescription", "Landroid/view/View;", "getRightView", "Lso0/a;", "<set-?>", "a", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "miniAppAnchorService", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowImportantCardView extends SettingItemView {
    public so0.a a;
    public LiveSwitchButton b;

    public static final class a implements LiveSwitchButton.e {
        public final /* synthetic */ ShowImportantCardView a;

        public a(ShowImportantCardView r1) {
            this.a = r1;
        }

        public final void d0(LiveSwitchButton r2, boolean r3) {
            if (r3 == false) goto L5;
            f2.b(2131921081, 0);
        L17:
            this.a.getMiniAppAnchorService().updateMemoryStatus(4, r3);
            return;
        L5:
            f2.b(2131921080, 0);
            OpenPlatformContext r4 = this.a.getMiniAppAnchorService().a();
            if (r4 == null) goto L17;
            AnchorMiniAppAppLogContextService r5 = (AnchorMiniAppAppLogContextService) r4.getService(AnchorMiniAppAppLogContextService.class);
            if (r5 == null) goto L17;
            MiniAppDataContext.Companion.getClass();
            ShelfInfo r0 = MiniAppDataContext.a.b();
            if (r0 == null) goto L15;
            ShelfMicroAppInfo r1 = r0.appInfo;
            if (r1 == null) goto L15;
            String r6 = r1.appId;
            if (r6 == null) goto L15;
        L16:
            r5.reportShowImportantCardClose(r6);
        L15:
            r6 = "";
            goto L16
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
        boolean r2 = false;
        LiveSwitchButton r0 = LayoutInflater.from(getContext()).inflate(2131567794, this, false);
        if (r0 == null) goto L16;
        LiveSwitchButton r1 = r0;
        this.b = r1;
        so0.a r3 = this.a;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        if (r3.getMemoryStatus().d != 1) goto L10;
        r2 = true;
    L10:
        r1.setChecked(r2);
        LiveSwitchButton r4 = this.b;
        if (r4 == null) goto L13;
        r4.setOnCheckedChangeListener(new a(this));
    L13:
        LiveSwitchButton r5 = this.b;
        Intrinsics.checkNotNull(r5);
        return r5;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton");
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public String getDescription() {
        return s1.B(2131921079);
    }

    public ShowImportantCardView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public ShowImportantCardView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public ShowImportantCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
