package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileSettingDialog;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/FansClubSettingWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubSettingWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public LiveProfileSettingDialog a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FansClubSettingWidget a;

        public a(FansClubSettingWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            zg1.c0 r3 = (zg1.c0) r2;
            if (r3 == null) goto L6;
            this.a.wq(r3);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        a r1 = new a(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.c0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r1);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.observe("cmd_show_fans_club_setting", this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        LiveProfileSettingDialog r0 = this.a;
        if (r0 == null) goto L14;
        if (r0 == null) goto L14;
        if (r0.isShowing() != true) goto L14;
        LiveProfileSettingDialog r1 = this.a;
        Intrinsics.checkNotNull(r1);
        r1.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L20;
        r3.removeObserver(this);
        return;
    }

    public FansClubSettingWidget() {
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Intrinsics.checkNotNullParameter(r5, "kvData");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getKey()) == false) goto L7;
        return;
    L7:
        if (r5.getData() == null) goto L22;
        String r0 = r5.getKey();
        if (r0.hashCode() == (-424351287)) goto L13;
        return;
    L13:
        if (r0.equals("cmd_show_fans_club_setting") == false) goto L20;
        zg1.c0 r6 = (zg1.c0) r5.getData();
        if (r6 == null) goto L21;
        wq(r6);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void wq(zg1.c0 r6) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        boolean r1 = true;
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        LiveProfileSettingDialog r2 = this.a;
        if (r2 != null) goto L14;
        IUserService r3 = jc1.k.f(IUserService.class);
        Intrinsics.checkNotNull(r3);
        IUser r4 = r3.user().b();
        DataCenter r5 = ((Widget) this).dataCenter;
        r6.getClass();
        LiveProfileSettingDialog r7 = new LiveProfileSettingDialog();
        r7.f = r4;
        r7.n = r1;
        r7.h = null;
        r7.i = null;
        r7.g = r5;
        this.a = r7;
    L15:
        if (r0 == null) goto L29;
        FragmentManager r8 = r0.getChildFragmentManager();
        if (r8 == null) goto L30;
        LiveProfileSettingDialog r9 = this.a;
        if (r9 == null) goto L31;
        int r10 = LiveProfileSettingDialog.o;
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "LiveProfileSettingDialog", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r9, r11) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L24:
        r9.show(r8, "LiveProfileSettingDialog");
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r6.getClass();
        r2.h = null;
        r2.i = null;
        goto L15
    L8:
        if (r0.V9() != true) goto L10;
    L5:
        if (r0.dg() == true) goto L11;
        goto L6
    }
}
