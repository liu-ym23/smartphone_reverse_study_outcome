package dq0;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardMoreDialog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends SettingItemView {
    public so0.a a;
    public final ShelfCardInfo b;
    public final int c;

    public final so0.a getMiniAppAnchorService() {
        so0.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public View getRightView() {
        ImageView r0 = new ImageView(getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(16)));
        r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r0.setImageResource(2131252399);
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public String getDescription() {
        return s1.B(2131921071);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public b(ShelfManagementCardMoreDialog r2, ShelfCardInfo r3, int r4, Context r5) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.b = r3;
        this.c = r4;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        setOnClickListener(new a(this));
    }
}
