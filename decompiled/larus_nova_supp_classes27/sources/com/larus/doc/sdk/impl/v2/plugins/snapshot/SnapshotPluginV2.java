package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.larus.doc.sdk.api.IDocPermissionService;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;
import n39.n;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J+\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/SnapshotPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/ISnapShotService;", "<init>", "()V", "mFragment", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotFragment;", "cancelSnapShotListener", "", "Lkotlin/Function0;", "", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onResume", "onDetachFromHost", "startDocSnapshot", "inputViewHeight", "", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;)V", "realStartDocSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SnapshotPluginV2 extends OfficeDocumentPlugin implements n {
    public static final Companion Companion = null;
    public static final String TAG = "SnapshotPlugin";
    private final List<Function0<Unit>> cancelSnapShotListener;
    private DocShotFragment mFragment;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/SnapshotPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.plugins.snapshot.SnapshotPluginV2$realStartDocSnapshot$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/larus/doc/sdk/impl/v2/plugins/snapshot/SnapshotPluginV2$realStartDocSnapshot$1", "Lcom/bytedance/ee/bear/document/ability/screenshot/SnapshotCallback;", "onSnapshotFailed", "", "errorInfo", "", "onSnapshotSuccess", "path", "scale", "", "onStartShot", "params", "Lcom/bytedance/ee/bear/document/ability/screenshot/SnapshotCallback$SnapShotOpenParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements wz4.c {
        final /* synthetic */ Drawable $drawable;
        final /* synthetic */ Integer $inputViewHeight;
        final /* synthetic */ h $listener;
        final /* synthetic */ SnapshotPluginV2 this$0;

        public static /* synthetic */ Unit a(h r0) {
            return onStartShot$lambda$4(r0);
        }

        public static /* synthetic */ void b(SnapshotPluginV2 r0, h r1) {
            onSnapshotSuccess$lambda$1$lambda$0(r0, r1);
        }

        public static /* synthetic */ Unit c(SnapshotPluginV2 r0) {
            return onStartShot$lambda$3(r0);
        }

        public static void INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DocShotFragment r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        private static final Unit onStartShot$lambda$3(SnapshotPluginV2 r1) {
            Iterator r2 = SnapshotPluginV2.access$getCancelSnapShotListener$p(r1).iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            Function0 r0 = (Function0) r2.next();
            if (r0 == null) goto L4;
            r0.invoke();
            goto L4
        L9:
            return Unit.INSTANCE;
        }

        private static final Unit onStartShot$lambda$4(h r1) {
            if (r1 == null) goto L5;
            r1.onSnapshotFail("user cancel");
        L5:
            return Unit.INSTANCE;
        }

        public void onSnapshotFailed(String r4) {
            FLogger.a.i(SnapshotPluginV2.TAG, "onSnapshotFailed , errorInfo = " + r4);
            DocShotFragment r0 = SnapshotPluginV2.access$getMFragment$p(this.this$0);
            if (r0 == null) goto L5;
            INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        L5:
            h r1 = this.$listener;
            if (r1 == null) goto L11;
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            r1.onSnapshotFail(r4);
            return;
        }

        public void onStartShot(wz4.c.a r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            FLogger.a.i(SnapshotPluginV2.TAG, "onStartShot");
            DocShotFragment r11 = SnapshotPluginV2.access$getMFragment$p(this.this$0);
            if (r11 == null) goto L5;
            INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r11);
        L5:
            SnapshotPluginV2.access$setMFragment$p(this.this$0, new DocShotFragment());
            DocShotParams r12 = new DocShotParams(this.this$0.getHost().getWeb().getWebView(), this.this$0.getHost().getChameleonConfig().getLoadUrl(), this.$inputViewHeight, this.$drawable, this.$listener, true);
            DocShotFragment r0 = SnapshotPluginV2.access$getMFragment$p(this.this$0);
            if (r0 == null) goto L8;
            r0.setArgs(SnapshotPluginV2.access$getActivity(this.this$0), r12);
        L8:
            DocShotFragment r13 = SnapshotPluginV2.access$getMFragment$p(this.this$0);
            if (r13 == null) goto L11;
            final SnapshotPluginV2 r1 = this.this$0;
            r13.setDismissListener(new c(r1));
        L11:
            DocShotFragment r14 = SnapshotPluginV2.access$getMFragment$p(this.this$0);
            if (r14 == null) goto L14;
            INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r14, SnapshotPluginV2.access$getActivity(this.this$0).getSupportFragmentManager(), SnapshotPluginV2.TAG);
        L14:
            List r15 = SnapshotPluginV2.access$getCancelSnapShotListener$p(this.this$0);
            final h r2 = this.$listener;
            r15.add(new d(r2));
        }

        private static final void onSnapshotSuccess$lambda$1$lambda$0(SnapshotPluginV2 r0, h r1) {
            DocShotFragment r2 = SnapshotPluginV2.access$getMFragment$p(r0);
            if (r2 == null) goto L5;
            INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r2);
        L5:
            if (r1 == null) goto L8;
            r1.onSnapshotFail("save doc bitmap failed. path is empty");
            return;
        }

        public void onSnapshotSuccess(String r4, float r5) {
            FLogger.a.i(SnapshotPluginV2.TAG, "onSnapshotSuccess, path = " + r4 + ", scale = " + r5);
            if (r4 != null) goto L6;
            final SnapshotPluginV2 r6 = this.this$0;
            final h r7 = this.$listener;
            y.c(new b(r6, r7));
            return;
        L6:
            Lazy r8 = CCMWatermarkManager.a;
            CCMWatermarkManager.a.a(r4, new SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2(this.this$0, this.$listener));
        }

        public static void INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DocShotFragment r2, FragmentManager r3, String r4) {
            if ((r2 instanceof Fragment) == false) goto L5;
            DocShotFragment r0 = r2;
        L6:
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
            return;
        L13:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r2.show(r3, r4);
            return;
        L5:
            r0 = null;
            goto L6
        }

        public AnonymousClass1(SnapshotPluginV2 r1, h r2, Integer r3, Drawable r4) {
            this.this$0 = r1;
            this.$listener = r2;
            this.$inputViewHeight = r3;
            this.$drawable = r4;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(SnapshotPluginV2 r0, Integer r1, Drawable r2, h r3, String r4, boolean r5) {
        return startDocSnapshot$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SnapshotPluginV2() {
        this.cancelSnapShotListener = new ArrayList();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SnapshotPluginV2 r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ List access$getCancelSnapShotListener$p(SnapshotPluginV2 r0) {
        return r0.cancelSnapShotListener;
    }

    public static final /* synthetic */ DocShotFragment access$getMFragment$p(SnapshotPluginV2 r0) {
        return r0.mFragment;
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        DocSnapshotManager r0 = DocSnapshotManager.INSTANCE;
        if (r2 == null) goto L6;
        String r3 = x.a(r2);
        if (r3 == null) goto L6;
    L7:
        r0.setSnapshotService(this, r3);
        return;
    L6:
        r3 = "";
        goto L7
    }

    public void onDetachFromHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r3);
        DocSnapshotManager r0 = DocSnapshotManager.INSTANCE;
        if (r3 == null) goto L6;
        String r4 = x.a(r3);
        if (r4 == null) goto L6;
    L7:
        r0.setSnapshotService(null, r4);
        return;
    L6:
        r4 = "";
        goto L7
    }

    public void onResume(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onResume(r2);
        DocSnapshotManager r0 = DocSnapshotManager.INSTANCE;
        if (r2 == null) goto L6;
        String r3 = x.a(r2);
        if (r3 == null) goto L6;
    L7:
        r0.setSnapshotService(this, r3);
        return;
    L6:
        r3 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$setMFragment$p(SnapshotPluginV2 r0, DocShotFragment r1) {
        r0.mFragment = r1;
    }

    private final void realStartDocSnapshot(Integer r3, Drawable r4, h r5) {
        getHost().getHostAbility(wz4.b.class).requestSnapshot("", new AnonymousClass1(this, r5, r3, r4), new AnonymousClass2(this));
    }

    @Override // n39.n
    public void startDocSnapshot(final Integer r11, final Drawable r12, final h r13) {
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L7;
        FLogger.a.w(TAG, "onRequestSnapshot, activity is not RESUMED");
        return;
    L7:
        if (getUIContainer() != null) goto L10;
        FLogger.a.w(TAG, "onRequestSnapshot After ui detach");
        return;
    L10:
        ChameleonPluginHost r0 = getHost();
        Integer r2 = null;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        w r1 = x.b(r0);
        if (r1 == null) goto L17;
        OfficeInputParam r3 = r1.a;
        if (r3 == null) goto L17;
        String r4 = r3.getResourceId();
    L18:
        final String r8 = r4;
    L20:
        ChameleonPluginHost r5 = getHost();
        if (r5 == null) goto L27;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        w r6 = x.b(r5);
        if (r6 == null) goto L27;
        OfficeInputParam r7 = r6.a;
        if (r7 == null) goto L27;
        r2 = r7.getObjType();
    L27:
        IDocSdkServiceV2 r9 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r9 == null) goto L39;
        IDocPermissionService r10 = r9.getPermissionService();
        if (r10 == null) goto L40;
        if (r8 != null) goto L33;
        String r14 = "";
    L34:
        if (r2 == null) goto L36;
        int r15 = r2.intValue();
    L37:
        r10.validatePermission(r14, r15, "EXPORT", new a(this, r11, r12, r13, r8));
        return;
    L36:
        r15 = 22;
        goto L37
    L33:
        r14 = r8;
        goto L34
    L40:
        return;
    L39:
        return;
    L17:
        r4 = null;
        goto L18
    L19:
        r8 = null;
        goto L20
    }

    private static final Unit startDocSnapshot$lambda$0(SnapshotPluginV2 r0, Integer r1, Drawable r2, h r3, String r4, boolean r5) {
        if (r5 == false) goto L4;
        r0.realStartDocSnapshot(r1, r2, r3);
    L8:
        return Unit.INSTANCE;
    L4:
        FLogger.a.i(TAG, "startDocSnapshot, no permission for " + r4);
        s r6 = s.a;
        Context r7 = r0.getContext();
        r6.getClass();
        s.s(r7, 2131901792);
        if (r3 == null) goto L8;
        r3.onSnapshotFail("no permission");
        goto L8
    }
}
