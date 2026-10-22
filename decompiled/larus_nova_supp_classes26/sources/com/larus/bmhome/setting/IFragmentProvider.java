package com.larus.bmhome.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J=\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H&J\u008a\u0001\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H&¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/setting/IFragmentProvider;", "", "createChatImmersFragment", "Landroidx/fragment/app/Fragment;", "createConversationFragment", "createFlowSdkChatFragment", "chatBundle", "Landroid/os/Bundle;", "getBottomTabHeight", "", "chatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "initContainerData", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "", "Lkotlin/ExtensionFunctionType;", "createChatFragment", "hasBottomTab", "", "enableChatWithTab", "addBotListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "chatTabInterceptor", "overrideLayout", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "(Landroid/os/Bundle;ZZILcom/larus/bmhome/chat/event/OnAddBotChangedListener;Lcom/larus/bmhome/chat/event/OnChatChangedListener;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lcom/larus/ui/arch/modulizer/di/ContainerFilter;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "createTemplateFragment", "createOWindowChatFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFragmentProvider {
    Fragment a(Bundle r1, Function1 r2);

    Fragment b();

    Fragment c();

    Fragment d(Bundle r1, boolean r2, int r3, Integer r4, ContainerFilter r5, Function1 r6);

    Fragment e(Bundle r1);
}
