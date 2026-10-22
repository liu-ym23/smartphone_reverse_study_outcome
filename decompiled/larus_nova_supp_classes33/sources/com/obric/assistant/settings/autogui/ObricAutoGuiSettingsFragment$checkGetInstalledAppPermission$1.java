package com.obric.assistant.settings.autogui;

import android.app.Application;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentAutoGuiSettingsBinding;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1", f = "ObricAutoGuiSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromViewCreated;
    final /* synthetic */ boolean $shouldRequestPermission;
    final /* synthetic */ boolean $shouldSetupAvailableAppList;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsFragment this$0;

    public ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1(boolean r1, boolean r2, ObricAutoGuiSettingsFragment r3, boolean r4, Continuation<? super ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1> r5) {
        this.$isFromViewCreated = r1;
        this.$shouldRequestPermission = r2;
        this.this$0 = r3;
        this.$shouldSetupAvailableAppList = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1(this.$isFromViewCreated, this.$shouldRequestPermission, this.this$0, this.$shouldSetupAvailableAppList, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L92;
        ResultKt.throwOnFailure(r25);
        if (Build.VERSION.SDK_INT < 23) goto L90;
        IObricPermissionService r1 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r1 == null) goto L9;
        boolean r2 = r1.o();
    L10:
        Application r3 = AppHost.a.getApplication();
        ArrayList r12 = new ArrayList();
        Object[] r14 = {"com.android.permission.GET_INSTALLED_APPS"};
        f06.b r11 = new f06.b("auto_cert_com_obric_assistant_settings_autogui_ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1_android_app_Application_checkSelfPermission");
        g06.a r4 = (g06.a) ApiHookConfig.b.get(102608);
        if (r4 == null) goto L13;
        f06.a[] r5 = r4.i;
    L14:
        f06.a[] r10 = r5;
        int r9 = r10.length;
        int r8 = 0;
    L16:
        if (r8 >= r9) goto L23;
        f06.a r6 = r10[r8];
        int r20 = r8;
        int r21 = r9;
        f06.a[] r22 = r10;
        f06.b r23 = r11;
        f06.d r7 = r6.preInvoke(102608, "android/app/Application", "checkSelfPermission", r3, r14, "int", r11);     // Catch: Exception -> L94
        if (r7.a == true) goto L20;
        r12.add(r6);     // Catch: Exception -> L94
        goto L22
    L20:
        FragmentActivity r13 = null;
    L25:
        if (r7.a == false) goto L27;
        int r15 = ((Integer) r7.b).intValue();
    L28:
        FLogger.a.i("ObricAutoGuiSettingsFragment", "getLauncherApps, checkSelfPermission, isSupportAppListPermission: " + r2 + ", GET_INSTALLED_APPS, ret: " + r15);
        if (r15 == 0) goto L85;
        if (r2 == false) goto L85;
        if (this.$isFromViewCreated == true) goto L36;
        return Unit.INSTANCE;
    L36:
        if (t1.a.getAutoGuiEnabledScene() != 2) goto L38;
        boolean r16 = true;
    L39:
        if (r16 == true) goto L43;
        return Unit.INSTANCE;
    L43:
        if (this.$shouldRequestPermission == true) goto L46;
        ObricAutoGuiSettingsFragment.U90(this.this$0);
        return Unit.INSTANCE;
    L46:
        List r17 = CollectionsKt.mutableListOf(new String[]{"com.android.permission.GET_INSTALLED_APPS"});
        FragmentActivity r18 = this.this$0.getActivity();
        if (r18 == null) goto L73;
        ArrayList r19 = new ArrayList();
        Object[] r24 = {"com.android.permission.GET_INSTALLED_APPS"};
        f06.b r26 = new f06.b("auto_cert_com_obric_assistant_settings_autogui_ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale");
        g06.a r110 = (g06.a) ApiHookConfig.b.get(102609);
        if (r110 == null) goto L51;
        f06.a[] r111 = r110.i;
    L52:
        int r112 = r111.length;
        int r113 = 0;
    L54:
        if (r113 >= r112) goto L65;
        f06.a r27 = r111[r113];
        f06.d r28 = r27.preInvoke(102609, "androidx/fragment/app/FragmentActivity", "shouldShowRequestPermissionRationale", r18, r24, "boolean", r26);     // Catch: Exception -> L63
        f06.b r114 = r26;
        if (r28.a == true) goto L60;
        r19.add(r27);     // Catch: Exception -> L93
        goto L64
    L60:
        FragmentActivity r29 = null;
        boolean r30 = false;
    L67:
        if (r28.a == false) goto L69;
        boolean r31 = ((Boolean) r28.b).booleanValue();
    L71:
        if (r31 != true) goto L74;
        r30 = true;
    L74:
        FLogger.a.i("ObricAutoGuiSettingsFragment", "getLauncherApps, shouldShowRationale: " + r30);
        if (r30 == false) goto L81;
        i2 r32 = i2.b;
        FragmentActivity r33 = AppHost.a.a().getCurrentActivity();
        if ((r33 instanceof FragmentActivity) == false) goto L79;
        FragmentActivity r34 = r33;
    L80:
        final ObricAutoGuiSettingsFragment r35 = this.this$0;
        r32.a(r34, r17, new h0(r35));
    L83:
        return Unit.INSTANCE;
    L79:
        r34 = r29;
        goto L80
    L81:
        ObricAutoGuiSettingsFragment.U90(this.this$0);
        goto L83
    L69:
        r31 = r18.shouldShowRequestPermissionRationale("com.android.permission.GET_INSTALLED_APPS");
    L64:
        r113 = r113 + 1;
        r26 = r114;
    L63:
        r114 = r26;
        goto L64
    L65:
        r29 = null;
        r30 = false;
        r28 = new f06.d(false, null);
        goto L67
    L51:
        r111 = ApiHookConfig.d;
        goto L52
    L73:
        r29 = r13;
        r30 = false;
        goto L74
    L38:
        r16 = false;
    L85:
        if (this.$shouldSetupAvailableAppList == false) goto L90;
        ObricAutoGuiSettingsFragment r36 = this.this$0;
        ObricFragmentAutoGuiSettingsBinding r37 = r36.e;
        if (r37 == null) goto L90;
        r37.b.setVisibility(8);
        r36.V90(c7.b(96));
        ((ObricAutoGuiViewModel) r36.f.getValue()).fetchAutoGuiUIModelList();
        Unit r38 = Unit.INSTANCE;
        goto L90
    L27:
        r15 = r3.checkSelfPermission("com.android.permission.GET_INSTALLED_APPS");
    L22:
        r8 = r20 + 1;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        goto L16
    L23:
        r13 = null;
        r7 = new f06.d(false, null);
        goto L25
    L13:
        r5 = ApiHookConfig.d;
        goto L14
    L9:
        r2 = false;
    L90:
        return Unit.INSTANCE;
    L92:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
