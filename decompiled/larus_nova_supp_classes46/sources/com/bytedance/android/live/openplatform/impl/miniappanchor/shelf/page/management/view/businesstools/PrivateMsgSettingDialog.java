package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformBottomDialog;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.AnchorPrivateMsgApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.privatemsg.AnchorPrivateMsgContextService;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/PrivateMsgSettingDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformBottomDialog;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivateMsgSettingDialog extends OpenPlatformBottomDialog {
    public static final /* synthetic */ int g = 0;
    public Map<Integer, View> d;
    public so0.a e;
    public String f;

    public static final class a {
        public static void a(FragmentActivity r3, String r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "appId");
            Intrinsics.checkNotNullParameter(r5, "settingDesc");
            PrivateMsgSettingDialog r0 = new PrivateMsgSettingDialog();
            Bundle r1 = new Bundle();
            r1.putString("param_app_id", r4);
            r1.putString("param_setting_desc", r5);
            r1.putBoolean("param_is_enable", r6);
            Unit r7 = Unit.INSTANCE;
            r0.setArguments(r1);
            FragmentManager r8 = r3.getSupportFragmentManager();
            LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "PrivateMsgSettingDialog", r9);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r0, r9) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r0.show(r8, "PrivateMsgSettingDialog");
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PrivateMsgSettingDialog a;

        public b(PrivateMsgSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements OpenPlatformSwitchButton.a {
        public final /* synthetic */ PrivateMsgSettingDialog a;

        @Override // com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton.a
        public final void b() {
        }

        public c(PrivateMsgSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton.a
        public final void a(OpenPlatformSwitchButton r7, final boolean r8, final ap0.b.a r9) {
            Intrinsics.checkNotNullParameter(r7, "view");
            Intrinsics.checkNotNullParameter(r9, "callback");
            so0.a r10 = this.a.e;
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L5:
            OpenPlatformContext r11 = r10.a();
            if (r11 == null) goto L18;
            AnchorPrivateMsgContextService r12 = (AnchorPrivateMsgContextService) r11.getService(AnchorPrivateMsgContextService.class);
            if (r12 == null) goto L19;
            String r0 = this.a.f;
            if (r0 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("appId");
        L12:
            Function0<Unit> r2 = new PrivateMsgSettingDialog$onViewCreated$2$onCheckedChanged$1(r8, r9);
            Function0<Unit> r3 = new PrivateMsgSettingDialog$onViewCreated$2$onCheckedChanged$2(r9);
            Intrinsics.checkNotNullParameter(r0, "appId");
            Intrinsics.checkNotNullParameter(r2, "onSuccess");
            Intrinsics.checkNotNullParameter(r3, "onFail");
            Lazy r13 = LiveOpenPlatformClient.c;
            AnchorPrivateMsgApi r14 = (AnchorPrivateMsgApi) LiveOpenPlatformClient.a.a().a(AnchorPrivateMsgApi.class);
            if (r8 == false) goto L15;
            int r1 = 1;
        L16:
            r12.autoDispose(r14.updatePrivateMsgTabStatus(r0, r1, r12.getOpenPlatformContext().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new vp0.c(r8, r2, r3), new vp0.d(r3)));
            return;
        L15:
            r1 = 2;
            goto L16
        L19:
            return;
        }
    }

    static {
    }

    public PrivateMsgSettingDialog() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r6 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.e = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L6;
        String r8 = r7.getString("param_app_id");
        if (r8 == null) goto L6;
    L7:
        this.f = r8;
        boolean r2 = false;
        S90(2131383057).J(UtilityKotlinExtentionsKt.i(20), 0, UtilityKotlinExtentionsKt.i(20), 0);
        String r9 = i2.a;
        i2.h(S90(2131383057), "/openplatform/ttlive_mini_app_private_msg_setting_banner.jpeg");
        ((ImageView) S90(2131383058)).setOnClickListener(new b(this));
        TextView r10 = (TextView) S90(2131383059);
        Bundle r11 = getArguments();
        if (r11 == null) goto L10;
        String r12 = r11.getString("param_setting_desc");
    L11:
        r10.setText(r12);
        OpenPlatformSwitchButton r13 = (OpenPlatformSwitchButton) S90(2131383060);
        Bundle r0 = getArguments();
        if (r0 == null) goto L14;
        r2 = r0.getBoolean("param_is_enable");
    L14:
        r13.setChecked(r2);
        ((OpenPlatformSwitchButton) S90(2131383060)).setOnCheckedChangeListener(new c(this));
        return;
    L10:
        r12 = null;
    L6:
        r8 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565709, r3, false);
    }
}
