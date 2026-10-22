package com.ss.android.lark.flow.threadwindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.bottomsheet.BottomSheetContainerActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.bottomsheet.BottomSheetLauncher;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Bundle r2) {
        if (r2 == null) goto L6;
        String r1 = r2.getString("chatID");
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getString("chatID");
    }

    @JvmStatic
    public static final void b(Context r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "params");
        String r2 = a(r9);
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        RxScheduledExecutor.justInIO(new com.ss.android.lark.flow.forward.a(r2, ForwardTools.RecentVisitTargetType.CHAT));
        BaseFragmentActivity r6 = com.ss.android.lark.appcontext.applifecycle.c.a.a.a();
        if ((r6 instanceof FlowThreadWindowActivity) == false) goto L14;
    L15:
        Intent r7 = r6.getIntent();
        if (r7 == null) goto L18;
        String r10 = a(r7.getExtras());
    L20:
        if (TextUtils.equals(r10, r2) == false) goto L22;
        return;
    L22:
        Lazy r11 = BottomSheetLauncher.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r9.getBoolean("key_bottom_sheet_container_start") == true) goto L26;
    L27:
        r3 = false;
    L29:
        if (r3 == false) goto L31;
        return;
    L31:
        Activity r0 = Contexts.findActivity(r8);
        if (r0 != null) goto L34;
    L36:
        Intent r1 = new Intent(r8, FlowThreadWindowActivity.class);
        r1.putExtras(r9);
        if ((r8 instanceof Activity) == true) goto L39;
        r1.addFlags(268435456);
    L39:
        PassportcConvention.e(r1, LarkContext.getApplication());
        if (r9.getBoolean("is_embedded", false) == false) goto L45;
        gza.b r12 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r12 == null) goto L45;
        FlowThreadWindowContainerFragment r13 = new FlowThreadWindowContainerFragment();
        r13.setArguments(r1.getExtras());
        r12.O1(r2, r13);
        return;
    L45:
        r8.startActivity(r1);
        return;
    L34:
        if (ChatCoreModule.a().getVcDependency().a(r0.getTaskId()) == false) goto L36;
        r8 = r0;
        goto L36
    L26:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == false) goto L27;
        BottomSheetLauncher.a r4 = new BottomSheetLauncher.a(r8);
        Intrinsics.checkNotNullParameter(FlowThreadWindowActivity.class, "targetClazz");
        r4.c = FlowThreadWindowActivity.class.getName();
        r4.d = null;
        r4.b = r9;
        r4.a();
        goto L29
    L18:
        r10 = null;
        goto L20
    L14:
        if ((r6 instanceof BottomSheetContainerActivity) == false) goto L22;
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    @JvmStatic
    public static final void c(Context r3, ChatBundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        Bundle r5 = r4.l();
        String r0 = a(r5);
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        Intrinsics.checkNotNull(r5);
        PassportcConvention.f(r5, LarkContext.getApplication());
        if (r5.getBoolean("is_embedded", false) == false) goto L17;
        gza.b r1 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r1 == null) goto L17;
        FlowThreadWindowContainerFragment r6 = new FlowThreadWindowContainerFragment();
        r6.setArguments(r5);
        r1.O1(r0, r6);
        return;
    L17:
        b(r3, r5);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
