package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.drive.sdk.api.IDriveSdkServiceV2$Companion;
import com.larus.drive.sdk.impl.databinding.LarusFragmentDriveOfficePreviewBinding;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\u0016\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010,R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/DriveOfficePreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusFragmentDriveOfficePreviewBinding;", "previewOpenRequest", "Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;", "extraHostAbility", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "launchRequestId", "", "aiPreviewSession", "Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;", "sourceConversationId", "sourceBotId", "bindExtraHostAbility", "ability", "bindReloadInterceptor", "interceptor", "bindSourceConversation", "conversationId", "botId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onDestroy", "initConfig", "attachPreviewIfNeeded", "markContentReadyOrClose", "failBeforeContentReady", "resolvePreviewFragment", "request", "(Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficePreviewFragment extends Fragment {
    public static final /* synthetic */ int l = 0;
    public LarusFragmentDriveOfficePreviewBinding d;
    public DrivePreviewOpenRequest e;
    public com.bytedance.ee.bear.browser.plugin.i f;
    public com.bytedance.ee.bear.container.f g;
    public String h;
    public com.larus.drive.sdk.impl.store.a i;
    public String j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        this.d = null;
        super.onDestroyView();
    }

    public final void T90() {
        String r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.w("DriveOfficePreview", "preview failed before content ready");
        DrivePreviewRequestStore.a.d(r0);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    public final void U90() {
        String r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        DrivePreviewRequestStore r1 = DrivePreviewRequestStore.a;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r0, "requestId");     // Catch: Throwable -> L36
        DrivePreviewRequestStore.h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L36
        LinkedHashMap<String, DrivePreviewRequestStore.a> r4 = DrivePreviewRequestStore.b;     // Catch: Throwable -> L36
        DrivePreviewRequestStore.a r5 = r4.get(r0);     // Catch: Throwable -> L36
        boolean r6 = false;
        if (r5 != null) goto L13;
        monitor-exit(r1);
    L30:
        if (r6 == true) goto L34;
        FLogger.a.w("DriveOfficePreview", "close stale AI file preview container");
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L40;
        r2.finish();
        return;
    L40:
        return;
    L34:
        FLogger.a.i("DriveOfficePreview", "preview content ready");
        return;
    L13:
        if (r5.d != null) goto L16;
        monitor-exit(r1);
        goto L30
    L16:
        Function0<Boolean> r7 = r5.f;     // Catch: Throwable -> L36
        if (r7 != null) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L27;
        r4.remove(r0);     // Catch: Throwable -> L36
        FLogger.a.i("DrivePreviewRequestStore", "cancel inactive launch on ready, pendingCount=" + DrivePreviewRequestStore.e() + ", activeCount=" + DrivePreviewRequestStore.b());     // Catch: Throwable -> L36
        monitor-exit(r1);
        goto L30
    L27:
        r5.e = null;     // Catch: Throwable -> L36
        r5.f = null;     // Catch: Throwable -> L36
        FLogger.a.i("DrivePreviewRequestStore", "mark content ready, pendingCount=" + DrivePreviewRequestStore.e() + ", activeCount=" + DrivePreviewRequestStore.b());     // Catch: Throwable -> L36
        monitor-exit(r1);
        r6 = true;
        goto L30
    L19:
        if (((Boolean) r7.invoke()).booleanValue() == true) goto L21;
        r8 = true;
    L36:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        String r0 = this.h;
        if (r0 == null) goto L15;
        FragmentActivity r1 = getActivity();
        boolean r2 = false;
        if (r1 == null) goto L10;
        if (r1.isChangingConfigurations() != true) goto L10;
        r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        DrivePreviewRequestStore r3 = DrivePreviewRequestStore.a;
        r3.c(r0);
        r3.g(r0);
    L15:
        super.onDestroy();
    }

    public DriveOfficePreviewFragment() {
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        String r11 = r10.getString("ai_file_preview_launch_request_id");
    L6:
        this.h = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L9;
        String r13 = r12.getString("drive_preview_source_conversation_id");
    L10:
        this.j = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L13;
        String r15 = r14.getString("drive_preview_source_bot_id");
    L14:
        this.k = r15;
        String r16 = this.h;
        if (r16 == null) goto L28;
        DrivePreviewRequestStore r0 = DrivePreviewRequestStore.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r16, "requestId");     // Catch: Throwable -> L25
        DrivePreviewRequestStore.a r17 = DrivePreviewRequestStore.a(r16, true);     // Catch: Throwable -> L25
        if (r17 != null) goto L22;
        monitor-exit(r0);
        goto L28
    L22:
        com.larus.drive.sdk.impl.store.a r18 = r17.d;     // Catch: Throwable -> L25
        monitor-exit(r0);
    L29:
        this.i = r18;
        if (r18 == null) goto L33;
        DrivePreviewOpenRequest r20 = r18.a;
        if (r20 == null) goto L33;
    L41:
        this.e = r20;
        FLogger r21 = FLogger.a;
        if (this.h != null) goto L44;
        String r1 = "legacy";
    L45:
        r21.i("DriveOfficePreview", "init preview request, source=".concat(r1));
        if (getChildFragmentManager().findFragmentByTag("drive_office_preview_content") == null) goto L48;
        U90();
        return;
    L48:
        DrivePreviewOpenRequest r2 = this.e;
        if (r2 != null) goto L51;
        r21.e("DriveOfficePreview", "preview request is empty");
        T90();
        return;
    L51:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DriveOfficePreviewFragment$attachPreviewIfNeeded$1(this, r2, null), 3, null);
        return;
    L44:
        r1 = "ai";
    L33:
        Bundle r22 = getArguments();
        if (r22 == null) goto L36;
        Serializable r23 = r22.getSerializable("drive_preview_open_request");
    L38:
        if ((r23 instanceof DrivePreviewOpenRequest) == false) goto L40;
        r20 = (DrivePreviewOpenRequest) r23;
        goto L41
    L40:
        r20 = null;
        goto L41
    L36:
        r23 = null;
    L25:
        th = move-exception;
        throw th;
    L28:
        r18 = null;
        goto L29
    L13:
        r15 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final Object S90(DriveOfficePreviewFragment r7, DrivePreviewOpenRequest r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof DriveOfficePreviewFragment$resolvePreviewFragment$1) == false) goto L7;
        DriveOfficePreviewFragment$resolvePreviewFragment$1 r0 = (DriveOfficePreviewFragment$resolvePreviewFragment$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        IOfficeSdkServiceV2 r11 = (IOfficeSdkServiceV2) r0.L$1;
        DrivePreviewOpenRequest r4 = (DrivePreviewOpenRequest) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L20:
        ik5.a r12 = (ik5.a) r10;
        JobKt.ensureActive(r0.getContext());
        if (r12 == null) goto L74;
        gk5.e r13 = r11.q0();
        if (r13 == null) goto L72;
        com.bytedance.ee.drive.preview.d r14 = r13.Y2();
        if (r14 == null) goto L72;
        List r15 = CollectionsKt.createListBuilder();
        IDriveSdkServiceV2$Companion r5 = IDriveSdkServiceV2.a;
        com.larus.drive.sdk.impl.store.a r6 = r7.i;
        if (r6 == null) goto L30;
        String r16 = r6.g;
        if (r16 == null) goto L30;
    L31:
        if (r6 == null) goto L34;
        String r17 = r6.h;
        if (r17 == null) goto L34;
    L35:
        r15.addAll(r5.f(r7, r16, r17));
        com.bytedance.ee.bear.browser.plugin.i r18 = r7.f;
        if (r18 == null) goto L38;
        Boxing.boxBoolean(r15.add(r18));
    L38:
        String r20 = r7.h;
        if (r20 != null) goto L41;
    L58:
        List r21 = CollectionsKt.build(r15);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L61
        Object r23 = Result.constructor-impl(r14.Ae(r4, r21, null, r7.g));     // Catch: Throwable -> L61
    L63:
        r2 = r23;
        if (Result.isSuccess-impl(r2) == false) goto L66;
        Fragment r24 = (Fragment) r2;
        FLogger.a.i("DriveOfficePreview", "open drive preview");
    L66:
        Throwable r25 = Result.exceptionOrNull-impl(r2);
        if (r25 == null) goto L69;
        FLogger.a.e("DriveOfficePreview", "open drive preview failed", r25);
    L69:
        ResultKt.throwOnFailure(r2);
    L70:
        return r2;
    L61:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L41:
        if (Intrinsics.areEqual(r4.getCurrent().getAppId(), "doubao_ai_msg") == true) goto L44;
        r20 = null;
    L44:
        if (r20 == null) goto L58;
        com.larus.drive.sdk.impl.store.a r27 = r7.i;
        if (r27 == null) goto L52;
        DrivePreviewOpenRequest r28 = r27.a;
        if (r28 == null) goto L52;
        DrivePreviewOpenItem r30 = r28.getCurrent();
        if (r30 == null) goto L52;
        String r31 = r30.getFileExt();
    L53:
        com.larus.drive.sdk.impl.store.a r32 = r7.i;
        if (r32 == null) goto L56;
        String r33 = r32.i;
    L57:
        r15.add(new i89.d(r7, r20, r31, r33));
        goto L58
    L56:
        r33 = null;
    L52:
        r31 = null;
    L34:
        r17 = r7.k;
    L30:
        r16 = r7.j;
    L72:
        throw new IllegalStateException("drive preview sdk unavailable".toString());
    L74:
        throw new IllegalStateException("office sdk init timeout".toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        IOfficeSdkServiceV2 r34 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r34 == null) goto L76;
        IOfficeSdkServiceV2.a.b(r34, false, "DriveOfficePreview", 5);
        r0.L$0 = r8;
        r0.L$1 = r34;
        r0.label = 1;
        Object r35 = r34.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, r0);
        if (r35 == r2) goto L70;
        r4 = r8;
        r11 = r34;
        r10 = r35;
        goto L20
    L76:
        throw new IllegalStateException("office sdk service unavailable".toString());
    L7:
        r0 = new DriveOfficePreviewFragment$resolvePreviewFragment$1(r7, r9);
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562384, r3, false);
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131370286);
        if (r6 == null) goto L7;
        FrameLayout r7 = (FrameLayout) r5;
        this.d = new LarusFragmentDriveOfficePreviewBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131370286)));
    }
}
