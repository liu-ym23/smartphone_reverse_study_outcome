package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class StatusBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public ITitlebarComponent h;
    public IKeyboardComponent i;
    public boolean j;
    public int k;
    public BottomSheetViewModel l;

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

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        if (this.h != null) goto L7;
        super.D();
        return;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super.C(r3, r4);
        this.g = r3;
        Chat r5 = r4.f;
        this.j = r3.getFragment().getActivity() instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.b;
        final BaseFragment r6 = B();
        this.l = (BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r6, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new StatusBarPlugin$onCreate$$inlined$activityViewModels$default$1(r6), new StatusBarPlugin$onCreate$$inlined$activityViewModels$default$2(r6)).getValue();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r7 = this.g;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = null;
        if (r7 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r7 = null;
    L6:
        if (r7.u().D() == true) goto L8;
        F(TitleTheme.ThemeType.LIGHT, null);
    L9:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r8 = this.g;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r8 = null;
    L12:
        this.h = (ITitlebarComponent) r8.a(ITitlebarComponent.class);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r9 = this.g;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r9 = null;
    L15:
        final IKeyboardComponent r10 = (IKeyboardComponent) r9.a(IKeyboardComponent.class);
        this.i = r10;
        if (this.h != null) goto L30;
        if (r10 == null) goto L19;
        r10.m7(new StatusBarPlugin$onCreate$1$1(r10, this));
    L19:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r11 = this.g;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r11 = null;
    L22:
        Fragment r12 = r11.getFragment();
        if (r12 == null) goto L31;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1 = this.g;
        if (r1 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L28:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r0.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData(), r12.getViewLifecycleOwner(), new d(r12, this));
        return;
    L27:
        r0 = r1;
        goto L28
    L31:
        return;
    L30:
        throw null;
    L8:
        this.k = 1;
        goto L9
    }

    public final void F(TitleTheme.ThemeType r4, Integer r5) {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L14:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r7 = this.g;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r7 = null;
    L17:
        Fragment r8 = r7.getFragment();
        if (this.j == true) goto L20;
        f r9 = WindowInsetsUtils.b(r8);
        r9.k(true);
        r9.b(r6);
        return;
    L20:
        BottomSheetViewModel r10 = this.l;
        if (r10 == null) goto L26;
        r10.triggerStatusColorChange(new BottomSheetViewModel.b(r6));
        return;
    L26:
        return;
    L7:
        int r11 = b.a[r4.ordinal()];
        if (r11 != 1) goto L10;
        r6 = UIUtils.getColor(r0, 0);
        goto L14
    L10:
        if (r11 == 2) goto L12;
        r6 = UIUtils.getColor(r0, 0);
        goto L14
    L12:
        r6 = UIUtils.getColor(r0, 0);
        goto L14
    }
}
