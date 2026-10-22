package com.larus.doc.sdk.impl.v2.plugins.state.media;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.keva.Keva;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaViewModel;
import com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment;
import com.larus.office.x;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J*\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaToolbarFactory;", "Lcom/bytedance/ee/bear/api/registry/ToolbarItemPanelFactory;", "<init>", "()V", "itemId", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemIdV2;", "getItemId", "()Lcom/bytedance/ee/bear/document/model/toolbar/ItemIdV2;", "iconRes", "", "getIconRes", "()Ljava/lang/Integer;", "toolbarIconDecoration", "Lcom/bytedance/ee/bear/api/registry/ToolbarIconDecoration;", "getToolbarIconDecoration", "()Lcom/bytedance/ee/bear/api/registry/ToolbarIconDecoration;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "showPanel", "Landroidx/fragment/app/Fragment;", "toolbarContext", "Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "itemV2", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "fragmentTag", "", "bundle", "Landroid/os/Bundle;", "realShowPanel", "instantiateFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "dismissPanel", "", "dismiss", "", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectMediaToolbarFactory extends an4.f {
    public static final Companion Companion = null;
    private static final String KEY_HAS_APPLY_PERMISSION = "apply_doc_album_permission";
    private static final String TAG = "SelectMediaToolbarFactory";
    private final Lazy keva$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaToolbarFactory$Companion;", "", "<init>", "()V", "TAG", "", "KEY_HAS_APPLY_PERMISSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Keva a() {
        return keva_delegate$lambda$0();
    }

    public static /* synthetic */ Unit b(Ref.ObjectRef r0, SelectMediaToolbarFactory r1, an4.b r2, ItemV2 r3, String r4, Bundle r5, boolean r6) {
        return showPanel$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit c(an4.b r0, SelectMediaToolbarFactory r1, String r2, SelectMediaViewModel r3, Boolean r4) {
        return realShowPanel$lambda$3(r0, r1, r2, r3, r4);
    }

    public Integer getIconRes() {
        return null;
    }

    public an4.d getToolbarIconDecoration() {
        return null;
    }

    private final Keva getKeva() {
        return (Keva) this.keva$delegate.getValue();
    }

    private static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo("doc", 0);
    }

    public SelectMediaToolbarFactory() {
        this.keva$delegate = LazyKt.lazy(new h());
    }

    public ItemIdV2 getItemId() {
        return ToolbarPrimaryItemId.insertImage;
    }

    private final boolean dismiss(FragmentManager r4, String r5) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "dismiss() called with: manager = " + r4);
        Fragment r6 = r4.findFragmentByTag(r5);
        if (r6 != null) goto L5;
    L8:
        StringBuilder r7 = new StringBuilder("dismiss fail: fragment:");
        r7.append(r6);
        r7.append(" isAdded:");
        if (r6 == null) goto L11;
        Boolean r8 = Boolean.valueOf(r6.isAdded());
    L12:
        r7.append(r8);
        r0.e(TAG, r7.toString());
        return false;
    L11:
        r8 = null;
        goto L12
    L5:
        if (r6.isAdded() == false) goto L8;
        r4.beginTransaction().remove(r6).commitAllowingStateLoss();
        return true;
    }

    private final Fragment instantiateFragment(FragmentActivity r2, Bundle r3) {
        return Fragment.instantiate(r2, FlowPhotoInsertFragment.class.getName(), r3);
    }

    public void dismissPanel(an4.b r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "toolbarContext");
        Intrinsics.checkNotNullParameter(r3, "fragmentTag");
        dismiss(r2.getActivity().getSupportFragmentManager(), r3);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_state_media_SelectMediaToolbarFactory_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }

    private final Fragment realShowPanel(final an4.b r4, ItemV2 r5, final String r6, Bundle r7) {
        FragmentActivity r8 = r4.getActivity();
        FragmentManager r0 = r8.getSupportFragmentManager();
        Fragment r9 = instantiateFragment(r8, r7);
        PluginHost.writePluginHostToBundle(r7, r4.getPluginHost());
        Bundle r1 = r9.getArguments();
        if (r1 == null) goto L5;
        r1.putAll(r7);
    L5:
        Bundle r10 = r9.getArguments();
        if (r10 == null) goto L8;
        r10.putSerializable(FlowPhotoInsertFragment.KEY_DOC_SDK_VERSION, DocSdkVersion.V2);
    L8:
        String r11 = x.a(r4.getPluginHost());
        Bundle r2 = r9.getArguments();
        if (r2 == null) goto L11;
        r2.putSerializable(FlowPhotoInsertFragment.KEY_DOC_LOGIC_KEY, r11);
    L11:
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_state_media_SelectMediaToolbarFactory_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r0.beginTransaction(), r4.e().getId(), r9, r6).commitAllowingStateLoss();
        final SelectMediaViewModel r12 = (SelectMediaViewModel) q.c(r4.getPluginHost(), SelectMediaViewModel.class, null);
        LiveData<Boolean> r3 = r12.getHideContainer();
        if (r3 == null) goto L14;
        r3.observe(r9, new SelectMediaToolbarFactory$sam$androidx_lifecycle_Observer$0(new f(r4, this, r6, r12)));
    L14:
        return r9;
    }

    public Fragment showPanel(final an4.b r15, final ItemV2 r16, final String r17, final Bundle r18) {
        Intrinsics.checkNotNullParameter(r15, "toolbarContext");
        Intrinsics.checkNotNullParameter(r16, "itemV2");
        Intrinsics.checkNotNullParameter(r17, "fragmentTag");
        Intrinsics.checkNotNullParameter(r18, "bundle");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        if (getKeva().getBoolean(KEY_HAS_APPLY_PERMISSION, false) == true) goto L5;
        getKeva().storeBoolean(KEY_HAS_APPLY_PERMISSION, true);
        k2 r1 = k2.a;
        g3.a.a(r15.getFragment(), null, false, null, false, new g(r0, this, r15, r16, r17, r18), 30);
    L7:
        return (Fragment) r0.element;
    L5:
        r0.element = realShowPanel(r15, r16, r17, r18);
        goto L7
    }

    private static final Unit realShowPanel$lambda$3(an4.b r0, SelectMediaToolbarFactory r1, String r2, SelectMediaViewModel r3, Boolean r4) {
        if (r4.booleanValue() == false) goto L8;
        r0.d();
        r1.dismissPanel(r0, r2);
        if (r3 == null) goto L8;
        r3.resetContainerVisible();
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit showPanel$lambda$1(Ref.ObjectRef r0, SelectMediaToolbarFactory r1, an4.b r2, ItemV2 r3, String r4, Bundle r5, boolean r6) {
        r0.element = r1.realShowPanel(r2, r3, r4, r5);
        return Unit.INSTANCE;
    }
}
