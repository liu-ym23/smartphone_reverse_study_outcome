package com.ss.android.lark.flow.bottomsheet.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowStatusBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public final int h;
    public final int i;
    public ITitlebarComponent j;
    public IKeyboardComponent k;
    public boolean l;
    public int m;
    public BottomSheetViewModel n;
    public final Lazy o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleTheme.ThemeType.values().length];
            r0[TitleTheme.ThemeType.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TitleTheme.ThemeType.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {
        public final /* synthetic */ FlowStatusBarPlugin a;

        public final void d() {
        }

        public final void f() {
        }

        public final void a() {
            FlowStatusBarPlugin r0 = this.a;
            if (r0.l == true) goto L5;
        L7:
            ITitlebarComponent r1 = r0.j;
            if (r1 == null) goto L10;
            TitleTheme r2 = r1.getTheme();
        L11:
            if (r2 == null) goto L17;
            FlowStatusBarPlugin r3 = this.a;
            Integer r4 = r2.b;
            if (r4 == null) goto L15;
            r3.F(r2.getType(), r4);
            return;
        L15:
            r3.F(r2.getType(), null);
            return;
        L17:
            return;
        L10:
            r2 = null;
            goto L11
        L5:
            if (r0.m == 2) goto L7;
        }

        public c(FlowStatusBarPlugin r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboard");
        }
    }

    static {
    }

    public final void D() {
        ITitlebarComponent r0 = this.j;
        if (r0 == null) goto L5;
        r0.Yr((ITitlebarComponent.c) this.o.getValue());
    L5:
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
    }

    public FlowStatusBarPlugin() {
        this.h = 2131102022;
        this.i = 2131100572;
        this.m = 2;
        this.o = LazyKt.lazy(new FlowStatusBarPlugin$themeChangeListener$2(this));
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r3, r4);
        this.g = r3;
        Chat r5 = r4.f;
        this.l = r3.getFragment().getActivity() instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b;
        final BaseFragment r6 = B();
        this.n = (BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r6, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowStatusBarPlugin$onCreate$$inlined$activityViewModels$default$1(r6), new FlowStatusBarPlugin$onCreate$$inlined$activityViewModels$default$2(r6)).getValue();
        com.ss.android.lark.biz.im.api.extension.chat_window.c r7 = this.g;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = null;
        if (r7 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r7 = null;
    L6:
        if (r7.u().D() == true) goto L8;
        F(TitleTheme.ThemeType.LIGHT, null);
    L9:
        com.ss.android.lark.biz.im.api.extension.chat_window.c r8 = this.g;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r8 = null;
    L12:
        this.j = r8.a(ITitlebarComponent.class);
        com.ss.android.lark.biz.im.api.extension.chat_window.c r9 = this.g;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r9 = null;
    L15:
        this.k = r9.a(IKeyboardComponent.class);
        ITitlebarComponent r10 = this.j;
        if (r10 == null) goto L18;
        r10.PA((ITitlebarComponent.c) this.o.getValue());
    L18:
        IKeyboardComponent r11 = this.k;
        if (r11 == null) goto L21;
        r11.m7(new c(this));
    L21:
        ChatBaseComponent.a r12 = this.g;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r12 = null;
    L24:
        Fragment r13 = r12.getFragment();
        if (r13 == null) goto L32;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1 = this.g;
        if (r1 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L30:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r0.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData(), r13.getViewLifecycleOwner(), new e(r13, this));
        return;
    L29:
        r0 = r1;
        goto L30
    L32:
        return;
    L8:
        this.m = 1;
        goto L9
    }

    public final void F(TitleTheme.ThemeType r3, Integer r4) {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L14:
        ChatBaseComponent.a r6 = this.g;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r6 = null;
    L17:
        Fragment r7 = r6.getFragment();
        if (this.l == true) goto L20;
        f r8 = WindowInsetsUtils.b(r7);
        r8.k(true);
        r8.b(r5);
        return;
    L20:
        BottomSheetViewModel r9 = this.n;
        if (r9 == null) goto L26;
        r9.triggerStatusColorChange(new BottomSheetViewModel.b(r5));
        return;
    L26:
        return;
    L7:
        int r10 = b.a[r3.ordinal()];
        if (r10 != 1) goto L10;
        r5 = UIUtils.getColor(r0, this.i);
        goto L14
    L10:
        if (r10 == 2) goto L12;
        r5 = UIUtils.getColor(r0, this.h);
        goto L14
    L12:
        r5 = UIUtils.getColor(r0, this.h);
        goto L14
    }
}
