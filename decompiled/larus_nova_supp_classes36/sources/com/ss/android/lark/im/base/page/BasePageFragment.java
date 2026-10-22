package com.ss.android.lark.im.base.page;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.platform.dispatcher.d;
import com.ss.android.lark.platform.dispatcher.i;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l3c.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\f\u0010-\u001a\u00020\u001a*\u00020.H$J\f\u0010/\u001a\u00020\u001a*\u00020.H\u0014J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0014J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020401H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00065"}, d2 = {"Lcom/ss/android/lark/im/base/page/BasePageFragment;", "Lcom/ss/android/lark/base/frame/FrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "pluginFactory", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "getPluginFactory", "()Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "setPluginFactory", "(Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;)V", "configuratorFactory", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "getConfiguratorFactory", "()Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "setConfiguratorFactory", "(Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;)V", "dispatcher", "Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "getDispatcher", "()Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "dispatcher$delegate", "Lkotlin/Lazy;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleBack", "", "onNewIntent", "intent", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "im-biz-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class BasePageFragment extends Hilt_BasePageFragment implements c {

    @Inject
    public qya.a f;

    @Inject
    public pya.a g;
    public final Lazy h;

    public abstract void V90(j r1);

    public void W90(j r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final com.ss.android.lark.platform.dispatcher.b U90() {
        return (com.ss.android.lark.platform.dispatcher.b) this.h.getValue();
    }

    public BasePageFragment() {
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, BasePageFragment$dispatcher$2.INSTANCE);
    }

    public List<ConfiguratorType> T90() {
        return CollectionsKt.emptyList();
    }

    public List<PluginType> X90() {
        return CollectionsKt.emptyList();
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final boolean l1() {
        return U90().f();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m709provideComponent() {
        return provideComponent();
    }

    public void A0(Intent r5) {
        Iterator r0 = U90().c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((com.ss.android.lark.platform.dispatcher.h) r2).A0(r5);
        r1 = r3;
        goto L4
    }

    public final void aP(AssistContent r4) {
        Iterator r5 = U90().d.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((i) r1).a();
        r0 = r2;
        goto L4
    }

    public void onCreate(Bundle r7) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onCreate(r7);
        final OnBackPressedDispatcher r0 = requireActivity().getOnBackPressedDispatcher();
        OnBackPressedDispatcherKt.addCallback$default(r0, this, false, new AnonymousClass1(this, r0), 2, null);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r2, r3);
        l3c.i.a(this, r2, new C03851(this));
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        CopyOnWriteArrayList r0 = U90().a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        if (((d) r1.next()).onActivityResult(r3, r4, r5) == false) goto L9;
        return;
    L16:
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
    }
}
