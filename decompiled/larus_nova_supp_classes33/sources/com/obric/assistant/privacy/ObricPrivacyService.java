package com.obric.assistant.privacy;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import androidx.fragment.app.DialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.privacy.ICustomPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.privacy.activity.ObricPrivacyAgreeActivity;
import com.obric.assistant.privacy.dialog.GRPrivacyDialog;
import com.obric.assistant.privacy.dialog.ObricPrivacyDialog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/privacy/ObricPrivacyService;", "Lcom/larus/home/api/privacy/ICustomPrivacyService;", "Lcom/obric/assistant/privacy/IObricPrivacyService;", "<init>", "()V", "hasNotifyOnPrivacyAgree", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCustomPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", "context", "Landroid/content/Context;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "getCustomPrivacyActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getObricPrivacyIntent", "Landroid/content/Intent;", "getObricPrivacyDialog", "stopAssistantService", "", "notifyPrivacyAgree", "killInteractorProcess", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyService implements ICustomPrivacyService, IObricPrivacyService {
    public final AtomicBoolean b;

    public static final class a {
    }

    public static final class b implements u {
        public final /* synthetic */ Context a;

        public final void cancel() {
            HomeService.a.Y(this.a, false);
            ((Activity) this.a).finishAndRemoveTask();
        }

        public b(Context r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final Class<? extends Activity> b() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L6;
        return null;
    L6:
        return ObricPrivacyAgreeActivity.class;
    }

    @Override // com.obric.assistant.privacy.IObricPrivacyService
    public final void c() {
        if (this.b.compareAndSet(false, true) == false) goto L18;
        FLogger.a.i("ObricPrivacyService", "notifyPrivacyAgree");
        Object r0 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningAppProcessInfo> r1 = ((ActivityManager) r0).getRunningAppProcesses().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ActivityManager.RunningAppProcessInfo r2 = r1.next();
        if (Intrinsics.areEqual(r2.processName, AppHost.a.getApplication().getPackageName() + ":interactor") == false) goto L6;
        FLogger.a.i("ObricPrivacyService", "killInteractorProcess: " + r2.pid);
        Process.killProcess(r2.pid);
    L10:
        IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r3 == null) goto L13;
        r3.notifyUserAgreePrivacy();
    L13:
        Uri r4 = ObricPrivacyProvider.a;
        ObricPrivacyProvider.a.a(AppHost.a.getApplication());
        return;
    }

    public ObricPrivacyService() {
        this.b = new AtomicBoolean(false);
    }

    @Override // com.obric.assistant.privacy.IObricPrivacyService
    public final Intent a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new Intent(r3, ObricPrivacyAgreeActivity.class);
    }

    public final DialogFragment d(Context r6, p0 r7, u r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "agree");
        Intrinsics.checkNotNullParameter(r8, "disagree");
        ObricFeatureServiceDelegate r0 = ObricFeatureServiceDelegate.b;
        if (r0.c() == true) goto L6;
        return null;
    L6:
        boolean r2 = false;
        if ((r6 instanceof Activity) == false) goto L15;
        IObricUserGuide r1 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r1 == null) goto L11;
        r2 = r1.d(r6);
    L11:
        FLogger.a.i("ObricPrivacyService", "Context is Activity with isFromSetUpWizard= " + r2);
        if (r2 == false) goto L15;
        r8 = new b(r6);
    L15:
        if (r0.b() == false) goto L17;
        Intrinsics.checkNotNullParameter(r7, "listener");
        Intrinsics.checkNotNullParameter(r8, "listener");
        ObricPrivacyDialog r3 = new ObricPrivacyDialog();
        r3.d = r7;
        r3.e = r8;
        r3.f = r6;
        r3.i = r2;
        r3.j = !r2;
        return r3;
    L17:
        Intrinsics.checkNotNullParameter(r7, "listener");
        Intrinsics.checkNotNullParameter(r8, "listener");
        GRPrivacyDialog r4 = new GRPrivacyDialog();
        r4.f = r7;
        r4.g = r8;
        return r4;
    }
}
