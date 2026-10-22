package whb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.bottomsheet.BottomSheetContainerActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.flow.bottomsheet.BottomSheetLauncher;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r4, l1 r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "bundle");
        Bundle r6 = r5.a();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "params");
        String r1 = r6.getString("key_params_thread_id");
        if (r1 == null) goto L29;
        RxScheduledExecutor.justInIO(new com.ss.android.lark.flow.forward.a(r1, ForwardTools.RecentVisitTargetType.MSG_THREAD));
        Object r2 = com.ss.android.lark.appcontext.applifecycle.c.a.a.a();
        if ((r2 instanceof FlowReplyInThreadActivity) == false) goto L11;
        if (TextUtils.equals(((FlowReplyInThreadActivity) r2).getIntent().getStringExtra("key_params_thread_id"), r1) == false) goto L11;
        return;
    L11:
        if (BottomSheetLauncher.a(r4, r6) == true) goto L31;
        Activity r0 = ContextsKt.findActivity(r4);
        if (r0 != null) goto L16;
    L18:
        Intent r3 = new Intent(r4, FlowReplyInThreadActivity.class);
        r3.putExtras(r6);
        if ((r4 instanceof Activity) == true) goto L21;
        r3.addFlags(268435456);
    L21:
        PassportcConvention.e(r3, LarkContext.getApplication());
        if (r6.getBoolean("is_embedded", false) == false) goto L26;
        gza.b r7 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r7 == null) goto L26;
        FlowReplyInThreadContainerFragment r8 = new FlowReplyInThreadContainerFragment();
        r8.setArguments(r3.getExtras());
        r7.O1(r1, r8);
        return;
    L26:
        r4.startActivity(r3);
        return;
    L16:
        if (ChatCoreModule.a().getVcDependency().a(r0.getTaskId()) == false) goto L18;
        r4 = r0;
        goto L18
    L31:
        return;
    }

    @JvmStatic
    public static final void b(Context r5, Fragment r6, l1 r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        Bundle r0 = r7.a();
        sua.a r1 = (sua.a) ApiUtils.getApi(sua.a.class);
        String r2 = null;
        if (r6 == null) goto L5;
        FragmentActivity r8 = r6.getActivity();
    L6:
        tua.b r9 = r1.tryGetChainManager(r8);
        if (r9 == null) goto L11;
        yua.d r10 = r9.q();
        if (r10 == null) goto L11;
        Fragment r11 = r10.o2();
    L12:
        BottomSheetContainerActivity r3 = com.ss.android.lark.appcontext.applifecycle.c.a.a.a();
        if ((r11 instanceof FlowReplyInThreadContainerFragment) == false) goto L18;
        Bundle r12 = ((FlowReplyInThreadContainerFragment) r11).getArguments();
        if (r12 == null) goto L22;
        r2 = r12.getString("key_params_thread_id");
    L22:
        if (TextUtils.equals(r2, r0.getString("key_params_thread_id")) == false) goto L24;
        return;
    L24:
        Intrinsics.checkNotNull(r0);
        if (BottomSheetLauncher.a(r5, r0) == false) goto L27;
        return;
    L27:
        PassportcConvention.f(r0, LarkContext.getApplication());
        if (r0.getBoolean("is_embedded", false) == false) goto L36;
        String r13 = r0.getString("key_params_thread_id");
        if (r13 != null) goto L32;
        return;
    L32:
        gza.b r4 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r4 == null) goto L36;
        FlowReplyInThreadContainerFragment r14 = new FlowReplyInThreadContainerFragment();
        r14.setArguments(r0);
        r4.O1(r13, r14);
        return;
    L36:
        a(r5, r7);
        return;
    L18:
        if ((r3 instanceof BottomSheetContainerActivity) == false) goto L20;
        r2 = r3.getIntent().getStringExtra("key_params_thread_id");
        goto L22
    L20:
        r2 = "";
    L11:
        r11 = null;
        goto L12
    L5:
        r8 = null;
        goto L6
    }
}
