package com.larus.share.impl;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.share.panel.h;
import com.larus.share.service.IAppletSharePanelService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/share/impl/AppletSharePanelServiceImpl;", "Lcom/larus/share/service/IAppletSharePanelService;", "<init>", "()V", "showSharePanel", "Lcom/larus/share/service/AppletSharePanelResult;", "request", "Lcom/larus/share/service/AppletSharePanelRequest;", "handleReport", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "resourceId", "", "sharePanelDialog", "Landroidx/fragment/app/DialogFragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AppletSharePanelServiceImpl implements IAppletSharePanelService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ AppletSharePanelServiceImpl a;
        public final /* synthetic */ com.larus.share.service.a b;

        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        public final void f() {
        }

        public final void onDismiss() {
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public b(AppletSharePanelServiceImpl r1, com.larus.share.service.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean b(Context r8, DialogFragment r9, View r10, jr9.a r11) {
            Intrinsics.checkNotNullParameter(r11, "shareItemConfig");
            boolean r12 = false;
            if (Intrinsics.areEqual(r11.b(), "report") == false) goto L42;
            FLogger r13 = FLogger.a;
            r13.i("flow.showSharePanel", "onInterceptClick handle report");
            AppletSharePanelServiceImpl r0 = this.a;
            FragmentActivity r1 = this.b.getActivity();
            String r2 = this.b.g;
            int r3 = AppletSharePanelServiceImpl.a;
            r0.getClass();
            Boolean r4 = null;
            if (r1 != null) goto L7;
        L27:
            StringBuilder r14 = new StringBuilder("handleReport, activity is ");
            r14.append(r1);
            r14.append(" or finishing(");
            if (r1 == null) goto L30;
            Boolean r15 = Boolean.valueOf(r1.isFinishing());
        L31:
            r14.append(r15);
            r14.append(") or destroyed(");
            if (r1 == null) goto L34;
            Boolean r16 = Boolean.valueOf(r1.isDestroyed());
        L35:
            r14.append(r16);
            r14.append(") or supportFragmentManager isStateSaved");
            if (r1 == null) goto L40;
            FragmentManager r17 = r1.getSupportFragmentManager();
            if (r17 == null) goto L40;
            r4 = Boolean.valueOf(r17.isStateSaved());
        L40:
            r14.append(r4);
            r13.i("flow.showSharePanel", r14.toString());
        L41:
            return true;
        L34:
            r16 = null;
            goto L35
        L30:
            r15 = null;
            goto L31
        L7:
            if (r1.isFinishing() == true) goto L27;
            if (r1.isDestroyed() == true) goto L27;
            if (r1.getSupportFragmentManager().isStateSaved() == true) goto L27;
            if (r2 != null) goto L15;
        L16:
            r12 = true;
        L17:
            if (r12 == false) goto L19;
            r13.i("flow.showSharePanel", "handleReport, resourceId is null or empty");
        L20:
            if (r9 == null) goto L41;
            r9.dismiss();     // Catch: Exception -> L23
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r18 = DialogFragmentLancet.sLastShowStack;
            if (r18 == null) goto L41;
            com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L41
        L19:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new AppletSharePanelServiceImpl$handleReport$1(r1, r2, null), 3, null);
            goto L20
        L15:
            if (r2.length() != 0) goto L17;
        L42:
            return false;
        }
    }

    static {
    }

    public AppletSharePanelServiceImpl() {
    }

    @Override // com.larus.share.service.IAppletSharePanelService
    public final com.larus.share.service.b a(com.larus.share.service.a r82) {
        Intrinsics.checkNotNullParameter(r82, "request");
        ShareScene.a r1 = ShareScene.Companion;
        String r2 = r82.b;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();
        ShareScene r5 = ShareScene.a.a(r2);
        if (r5 == null) goto L8;
        com.larus.bmhome.share.panel.b r3 = new com.larus.bmhome.share.panel.b(null, null, r82.c, r82.f, null, null, null, r82.d, r82.e, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108467);
        FLogger.a.i("flow.showSharePanel", "real start AppletSharePanelServiceImpl showSharePanel, scene=" + r82.b + ", flowShareContent=" + r3);
        IShareService r4 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r4 == null) goto L12;
        IShareService.a.g(r4, r82.getActivity(), r5, r3, new h(null, null, null, null, null, null, null, r82.h, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -257, -1, 1023), new b(this, r82), null, false, 224);
        return new com.larus.share.service.b(true, null);
    L12:
        return new com.larus.share.service.b(false, "share service is null");
    L8:
        return new com.larus.share.service.b(false, "shareScene is invalid");
    }
}
