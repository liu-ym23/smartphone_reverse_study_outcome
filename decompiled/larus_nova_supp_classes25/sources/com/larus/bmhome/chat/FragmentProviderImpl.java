package com.larus.bmhome.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.bmhome.setting.IFragmentProvider;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J;\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0016J\u0084\u0001\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/FragmentProviderImpl;", "Lcom/larus/bmhome/setting/IFragmentProvider;", "<init>", "()V", "createChatImmersFragment", "Lcom/larus/bmhome/chat/immerse/ChatImmersFragment;", "createConversationFragment", "Lcom/larus/bmhome/chat/ConversationFragment;", "createFlowSdkChatFragment", "Landroidx/fragment/app/Fragment;", "chatBundle", "Landroid/os/Bundle;", "getBottomTabHeight", "", "chatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "initContainerData", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "", "Lkotlin/ExtensionFunctionType;", "createChatFragment", "hasBottomTab", "", "enableChatWithTab", "addBotListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "chatTabInterceptor", "overrideLayout", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "(Landroid/os/Bundle;ZZILcom/larus/bmhome/chat/event/OnAddBotChangedListener;Lcom/larus/bmhome/chat/event/OnChatChangedListener;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lcom/larus/ui/arch/modulizer/di/ContainerFilter;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "createTemplateFragment", "createOWindowChatFragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FragmentProviderImpl implements IFragmentProvider {
    public FragmentProviderImpl() {
    }

    public final Fragment b() {
        return new ChatImmersFragment();
    }

    public final Fragment c() {
        return new ConversationFragment();
    }

    public final Fragment e(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "chatBundle");
        return d(r9, false, 0, 2131563008, ContainerFilter.O_WINDOW_CHAT, new com.larus.bmhome.setting.e());
    }

    public final Fragment a(Bundle r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r8, "chatBundle");
        Intrinsics.checkNotNullParameter(r9, "initContainerData");
        return d(r8, false, 0, 2131563008, ContainerFilter.DEFAULT, r9);
    }

    public final Fragment d(Bundle r5, boolean r6, final int r7, Integer r8, ContainerFilter r9, final Function1 r10) {
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        Intrinsics.checkNotNullParameter(r10, "initContainerData");
        FLogger r0 = FLogger.a;
        r0.i("FragmentProviderImpl", "createChatFragment");
        ChatFragment r2 = new ChatFragment();
        r0.i("FragmentProviderImpl", "createChatFragment apply start");
        if (r8 == null) goto L5;
        int r11 = r8.intValue();
    L6:
        r5.putInt("layout_as", r11);
        if (r9 != null) goto L9;
        r9 = ContainerFilter.DEFAULT;
    L9:
        r5.putString("as_container", r9.name());
        if (r6 == false) goto L12;
        r2.g = new y2(r7);
    L12:
        r2.setArguments(r5);
        r2.xC(null);
        LifecycleOwnerKt.getLifecycleScope(r2).launchWhenCreated(new ChatFragment$setChatListener$1(r2, null, null));
        r2.f = null;
        Function1<? super Container, Unit> r12 = new z2(r10);
        Intrinsics.checkNotNullParameter(r12, "init");
        r2.j = r12;
        r0.i("FragmentProviderImpl", "createChatFragment apply finish");
        return r2;
    L5:
        r11 = 2131563015;
        goto L6
    }
}
