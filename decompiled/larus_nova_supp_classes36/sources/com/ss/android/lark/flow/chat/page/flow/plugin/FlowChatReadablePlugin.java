package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.flow.chat.component.banner.IFlowBottomBannerComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatReadablePlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int k = 0;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public BaseStrangerRelationViewModel h;
    public IFlowBottomBannerComponent i;
    public final Lazy j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StrangerBannerType.values().length];
            r0[StrangerBannerType.STRANGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StrangerBannerType.TOTAL_BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final void D() {
        BaseStrangerRelationViewModel r0 = this.h;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.h = null;
        IFlowBottomBannerComponent r1 = this.i;
        if (r1 == null) goto L8;
        r1.VH();
    L8:
        this.i = null;
        this.g = null;
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
    }

    public FlowChatReadablePlugin() {
        this.j = LazyKt.lazy(FlowChatReadablePlugin$relationshipBanner$2.INSTANCE);
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r10, i7b.a r11) {
        Intrinsics.checkNotNullParameter(r10, "chatApp");
        Intrinsics.checkNotNullParameter(r11, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r10, r11);
        this.g = r10;
        jdb.g r4 = w.a(r10).C();
        int r0 = l4b.a.a;
        Intrinsics.checkNotNullParameter(r4, "fgService");
        if (r4.isEnable("im.message.stranger") == true) goto L8;
        IMessageListComponent r12 = r10.a(IMessageListComponent.class);
        if (r12 == null) goto L25;
        r12.z6(true);
        return;
    L25:
        return;
    L8:
        IFlowBottomBannerComponent r2 = (IFlowBottomBannerComponent) r10.a(IFlowBottomBannerComponent.class);
        if (r2 == null) goto L11;
        r2.AI((wya.b) this.j.getValue());
    L12:
        this.i = r2;
        Chat r3 = r11.f;
        ChatChatter r5 = r11.g;
        a2b.l r6 = w.a(r10).J();
        b38.b r7 = w.a(r10).y();
        Intrinsics.checkNotNullParameter(r3, "initChat");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        Intrinsics.checkNotNullParameter(r6, "strangerActionUploader");
        Intrinsics.checkNotNullParameter(r7, "rucket");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        if (r4.isEnable("im.message.stranger") == false) goto L15;
        boolean r8 = false;
    L16:
        if (r8 == false) goto L18;
        BaseStrangerRelationViewModel r1 = new ChatP2PReadableViewModel.P2PStrangerViewModelFactory(r3, r5, r4, r7).create(ChatP2PReadableViewModel.class);
    L21:
        r1.create();
        LifecycleOwnerKt.getLifecycleScope(r10.getFragment()).launchWhenStarted(new FlowChatReadablePlugin$onCreate$2$1(r1, r10, null));
        LifecycleOwnerKt.getLifecycleScope(r10.getFragment()).launchWhenResumed(new FlowChatReadablePlugin$onCreate$2$2(r1, this, r11, null));
        LifecycleOwnerKt.getLifecycleScope(r10.getFragment()).launchWhenResumed(new FlowChatReadablePlugin$onCreate$2$3(r1, r10, null));
        LifecycleOwnerKt.getLifecycleScope(r10.getFragment()).launchWhenResumed(new FlowChatReadablePlugin$onCreate$2$4(r1, r10, r11, null));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10.getFragment()), null, null, new FlowChatReadablePlugin$onCreate$2$5(r1, this, r10, null), 3, null);
        this.h = r1;
        return;
    L18:
        Intrinsics.checkNotNullParameter(r4, "fgService");
        if (r4.isEnable("im.message.stranger") == false) goto L24;
        r1 = new ChatStrangerRelationViewModel.ChatStrangerRelationViewModelFactory(r3, r5, r4, r6, r7).create(ChatStrangerRelationViewModel.class);
        goto L21
    L24:
        throw new RuntimeException("no expect stranger feature!");
    L15:
        r8 = r4.isEnable("im.message.strangerchat");
        goto L16
    L11:
        r2 = null;
        goto L12
    }
}
