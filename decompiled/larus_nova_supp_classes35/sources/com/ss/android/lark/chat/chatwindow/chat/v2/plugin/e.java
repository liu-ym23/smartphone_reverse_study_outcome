package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public final boolean g;
    public IMessageListComponent h;
    public ITitlebarComponent i;
    public IKeyboardComponent j;

    public e() {
        this.g = false;
    }

    public static final boolean F(e r3) {
        IMessageListComponent r0 = r3.h;
        if (r0 == null) goto L7;
        List<y6b.c<?>> r1 = r0.h20();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L9:
        if (r2 <= 15) goto L17;
        IMessageListComponent r4 = r3.h;
        if (r4 == null) goto L13;
        boolean r5 = r4.SP();
    L14:
        if (r5 == true) goto L18;
        return true;
    L18:
        return false;
    L13:
        r5 = false;
        goto L14
    L17:
        return false;
    L7:
        r2 = 0;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super.C(r3, r4);
        this.h = (IMessageListComponent) r3.a(IMessageListComponent.class);
        this.i = (ITitlebarComponent) r3.a(ITitlebarComponent.class);
        this.j = (IKeyboardComponent) r3.a(IKeyboardComponent.class);
        if (r3.u().D() == true) goto L7;
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        IMessageListComponent r6 = this.h;
        if (r6 == null) goto L11;
        r6.addOnScrollListener(new TitleStatusPlugin$setup$1(this, r5));
        return;
    L11:
        return;
    L7:
        final BaseFragment r7 = B();
        final MutableLiveData<Integer> r8 = ((BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r7, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new TitleStatusPlugin$setupBottomSheet$$inlined$activityViewModels$default$1(r7), new TitleStatusPlugin$setupBottomSheet$$inlined$activityViewModels$default$2(r7)).getValue()).getState();
        final Ref.BooleanRef r9 = new Ref.BooleanRef();
        IMessageListComponent r0 = this.h;
        if (r0 == null) goto L13;
        r0.addOnScrollListener(new TitleStatusPlugin$setupBottomSheet$1(this, r9, r8));
        return;
    }
}
