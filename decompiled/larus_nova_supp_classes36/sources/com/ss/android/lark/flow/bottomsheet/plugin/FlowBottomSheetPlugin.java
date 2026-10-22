package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v99.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowBottomSheetPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int t = 0;
    public ITitlebarComponent g;
    public IKeyboardComponent h;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c i;
    public FlowBottomSheetPluginViewModel j;
    public wxa.a k;
    public final Object l;
    public boolean m;
    public boolean n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    static {
    }

    public final boolean A() {
        return false;
    }

    public final void E() {
        Log.i("ChatBottomSheetPlugin", "onStop invoke");
        FlowBottomSheetPluginViewModel r0 = this.j;
        if (r0 == null) goto L6;
        r0.sendTimeDuration();
        return;
    }

    public final void onStart() {
        Log.i("ChatBottomSheetPlugin", "onStart invoke");
        FlowBottomSheetPluginViewModel r0 = this.j;
        if (r0 == null) goto L6;
        r0.recordStartTime();
        return;
    }

    public FlowBottomSheetPlugin() {
        this.l = new Object();
        this.o = LazyKt.lazy(FlowBottomSheetPlugin$halfScreenRightActionInterceptor$2.INSTANCE);
        this.p = LazyKt.lazy(FlowBottomSheetPlugin$halfScreenLeftActionInterceptor$2.INSTANCE);
        this.q = LazyKt.lazy(new FlowBottomSheetPlugin$backHitPointActionInterceptor$2(this));
        this.r = LazyKt.lazy(new FlowBottomSheetPlugin$expandAction$2(this));
        this.s = LazyKt.lazy(new FlowBottomSheetPlugin$closeAction$2(this));
    }

    public final void D() {
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
        FlowBottomSheetPluginViewModel r0 = this.j;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.j = null;
    }

    public static final Lazy F(FlowBottomSheetPlugin r3) {
        ChatBaseComponent.a r4 = r3.i;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r4 = null;
    L5:
        final Fragment r5 = r4.getFragment();
        return FragmentViewModelLazyKt.createViewModelLazy(r5, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowBottomSheetPlugin$special$$inlined$activityViewModels$default$1(r5), new FlowBottomSheetPlugin$special$$inlined$activityViewModels$default$2(r5));
    }

    public final void G(com.ss.android.lark.keyboard.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.m == true) goto L9;
        this.m = true;
        r3.e().of(this.l).c(k2b.a.class, new FlowBottomSheetPlugin$ensureObserveSuppressMarginChange$1(this));
        return;
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r8, i7b.a r9) {
        Intrinsics.checkNotNullParameter(r8, "chatApp");
        Intrinsics.checkNotNullParameter(r9, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r8, r9);
        this.i = r8;
        boolean r0 = r8.u().D();
        String r10 = r9.e;
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        FlowBottomSheetPluginViewModel r2 = new FlowBottomSheetPluginViewModel(r10);
        this.j = r2;
        r2.create();
    L12:
        if (r0 == true) goto L15;
        return;
    L15:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == true) goto L17;
        return;
    L17:
        this.g = r8.a(ITitlebarComponent.class);
        this.h = r8.a(IKeyboardComponent.class);
        Log.i("ChatBottomSheetPlugin", "start chat window by bottom sheet");
        ChatBaseComponent.a r11 = this.i;
        com.ss.android.lark.keyboard.b r3 = null;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r11 = null;
    L20:
        Fragment r12 = r11.getFragment();
        if (r12 == null) goto L26;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4 = this.i;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r4 = null;
    L25:
        r4.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData().observe(r12.getViewLifecycleOwner(), new c(this, r12));
    L26:
        ITitlebarComponent r13 = this.g;
        if (r13 == null) goto L31;
        FlowTitleBarComponent.LeftAreaImpl r14 = r13.x00();
        if (r14 == null) goto L31;
        r14.b((FlowBottomSheetPlugin$backHitPointActionInterceptor$2.a) this.q.getValue());
    L31:
        Map<ImExtensionType, List<Class<?>>> r15 = com.ss.android.lark.im.base.d.a;
        wxa.b r16 = (wxa.b) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.b(ImExtensionType.ATTACHMENT_ABILITY, wxa.b.class));
        if (r16 == null) goto L37;
        ChatBaseComponent.a r5 = this.i;
        if (r5 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r5 = null;
    L36:
        f r17 = r16.a(r5.getFragment());
    L38:
        this.k = r17;
        ChatBaseComponent.a r18 = this.i;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r18 = null;
    L41:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r18.getFragment()), null, null, new FlowBottomSheetPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        IKeyboardComponent r19 = this.h;
        if (r19 == null) goto L44;
        r3 = r19.n();
    L44:
        G(r3);
        IKeyboardComponent r20 = this.h;
        if (r20 == null) goto L48;
        r20.m7(new com.ss.android.lark.flow.bottomsheet.plugin.a(this));
        return;
    L48:
        return;
    L37:
        r17 = null;
        goto L38
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
