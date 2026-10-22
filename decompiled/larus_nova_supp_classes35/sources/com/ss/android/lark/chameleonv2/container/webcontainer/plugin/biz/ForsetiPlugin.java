package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "pageViewTypeListener", "com/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin$pageViewTypeListener$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin$pageViewTypeListener$1;", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiPlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "CML_TAG_ForsetiPlugin";
    private final b pageViewTypeListener;
    private final Fragment sourceFragment;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements g {
        public final /* synthetic */ ForsetiPlugin a;

        public b(ForsetiPlugin r1) {
            this.a = r1;
        }

        public final void a(ForsetiPageViewType r4) {
            Intrinsics.checkNotNullParameter(r4, "pageViewType");
            j.e(ForsetiPlugin.TAG, "pageViewType: " + r4);
            ChameleonPluginHost r0 = this.a.getHost();
            ChameleonConfig r1 = null;
            if (r0 == null) goto L7;
            k r2 = r0.getWeb();
            if (r2 == null) goto L7;
            Object r3 = r2.getWebView();
        L9:
            if ((r3 instanceof ChameleonWebView) == false) goto L11;
            ChameleonWebView r5 = (ChameleonWebView) r3;
        L12:
            if (r5 == null) goto L14;
            r1 = r5.getChameleonConfig();
        L14:
            if (r1 == null) goto L28;
            OpenConfig r6 = r1.getOpenConfig();
            if (r6 != null) goto L18;
            return;
        L18:
            if (r4 != ForsetiPageViewType.MODAL_R_VIEW) goto L20;
        L25:
            boolean r7 = true;
        L26:
            r6.setModelView(r7);
            return;
        L20:
            if (r4 == ForsetiPageViewType.MODAL_C_HALF_VIEW) goto L25;
            if (r4 == ForsetiPageViewType.POPOVER_R_VIEW) goto L25;
            r7 = false;
            goto L26
        L28:
            return;
        L11:
            r5 = null;
        L7:
            r3 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ForsetiPlugin(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceFragment");
        this.sourceFragment = r2;
        this.pageViewTypeListener = new b(this);
    }

    public void onAttachToHost(ChameleonPluginHost r5) {
        super.onAttachToHost(r5);
        sua.a r0 = (sua.a) swb.a.a(sua.a.class);
        ForsetiPageViewType r1 = null;
        if (r0 == null) goto L5;
        tua.b r2 = r0.tryGetChainManager(this.sourceFragment.getActivity());
    L6:
        if (r5 == null) goto L15;
        Fragment r6 = r5.getFragment();
        if (r6 == null) goto L16;
        if (r2 == null) goto L11;
        r1 = r2.w(r6);
    L11:
        j.e(TAG, "type: " + r1);
        if (r2 == null) goto L17;
        r2.z(r6, this.pageViewTypeListener);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void onDetachFromHost(ChameleonPluginHost r3) {
        super.onDetachFromHost(r3);
        if (r3 == null) goto L13;
        Fragment r4 = r3.getFragment();
        if (r4 == null) goto L14;
        sua.a r0 = (sua.a) swb.a.a(sua.a.class);
        if (r0 == null) goto L9;
        tua.b r1 = r0.tryGetChainManager(this.sourceFragment.getActivity());
    L10:
        if (r1 == null) goto L15;
        r1.i(r4, this.pageViewTypeListener);
        return;
    L15:
        return;
    L9:
        r1 = null;
        goto L10
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
