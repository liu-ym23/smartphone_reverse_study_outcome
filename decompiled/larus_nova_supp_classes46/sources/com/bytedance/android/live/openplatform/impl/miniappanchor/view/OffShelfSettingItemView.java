package com.bytedance.android.live.openplatform.impl.miniappanchor.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.livesdk.widget.x0;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/view/OffShelfSettingItemView;", "Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/SettingItemView;", "", "getDescription", "", "getDescriptionColor", "Landroid/view/View;", "getRightView", "Lso0/a;", "<set-?>", "a", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "miniAppAnchorService", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffShelfSettingItemView extends SettingItemView {
    public so0.a a;
    public final String b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OffShelfSettingItemView a;
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.view.OffShelfSettingItemView$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0153a implements DialogInterface.OnClickListener {
            public final /* synthetic */ a a;

            public DialogInterfaceOnClickListenerC0153a(a r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r4, int r5) {
                OpenPlatformContext r6 = this.a.a.getMiniAppAnchorService().a();
                if (r6 == null) goto L10;
                AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
                if (r7 == null) goto L10;
                String r1 = this.a.a.b;
                if (r1 != null) goto L9;
                r1 = "";
            L9:
                r7.reportExitBindPushClick(r1, "settings", "exit");
            L10:
                OpenPlatformContext r8 = this.a.a.getMiniAppAnchorService().a();
                Context r2 = null;
                if (r8 == null) goto L15;
                AnchorShelfContextService r9 = (AnchorShelfContextService) r8.getService(AnchorShelfContextService.class);
                if (r9 == null) goto L15;
                AnchorShelfContextService.offShelf$default(r9, "settings", null, 2, null);
            L15:
                r4.dismiss();
                Context r10 = this.a.b;
                if ((r10 instanceof Activity) == false) goto L19;
                r2 = r10;
            L19:
                Activity r3 = (Activity) r2;
                if (r3 == null) goto L23;
                r3.finish();
                return;
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r4, int r5) {
                OpenPlatformContext r6 = this.a.a.getMiniAppAnchorService().a();
                if (r6 == null) goto L10;
                AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
                if (r7 == null) goto L10;
                String r0 = this.a.a.b;
                if (r0 != null) goto L9;
                r0 = "";
            L9:
                r7.reportExitBindPushClick(r0, "settings", "cancel");
            L10:
                r4.dismiss();
            }
        }

        public a(OffShelfSettingItemView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            x0.b r6 = new x0.b(this.b, 7);
            r6.a.c = s1.B(2131921023);
            r6.a.d = s1.B(2131921022);
            r6.j(0, s1.B(2131920953), new DialogInterfaceOnClickListenerC0153a(this));
            r6.j(1, s1.B(2131920891), new b(this));
            r6.setCornerRadius(16.0f);
            r6.k(0, true);
            r6.n();
            OpenPlatformContext r7 = this.a.getMiniAppAnchorService().a();
            if (r7 == null) goto L11;
            AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
            if (r8 == null) goto L12;
            String r0 = this.a.b;
            if (r0 != null) goto L9;
            r0 = "";
        L9:
            r8.reportExitBindPushShow(r0, "settings");
            return;
        L12:
            return;
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
        ImageView r0 = new ImageView(getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(20), UtilityKotlinExtentionsKt.i(20)));
        r0.setImageResource(2131252530);
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public String getDescription() {
        return s1.B(2131921077);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView
    public int getDescriptionColor() {
        return s1.h(2131107121);
    }

    public OffShelfSettingItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public OffShelfSettingItemView(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2);
        this.b = r3;
    }

    public OffShelfSettingItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OffShelfSettingItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        setOnClickListener(new a(this, r2));
    }
}
