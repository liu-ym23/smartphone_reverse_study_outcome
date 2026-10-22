package com.larus.bmhome.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0085\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0019H\u0096\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J<\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0019H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001¨\u0006 "}, d2 = {"Lcom/larus/bmhome/setting/FragmentProvider;", "Lcom/larus/bmhome/setting/IFragmentProvider;", "<init>", "()V", "createChatFragment", "Landroidx/fragment/app/Fragment;", "chatBundle", "Landroid/os/Bundle;", "hasBottomTab", "", "enableChatWithTab", "getBottomTabHeight", "", "addBotListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "chatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "chatTabInterceptor", "Lkotlin/Function1;", "", "overrideLayout", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "initContainerData", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;ZZILcom/larus/bmhome/chat/event/OnAddBotChangedListener;Lcom/larus/bmhome/chat/event/OnChatChangedListener;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lcom/larus/ui/arch/modulizer/di/ContainerFilter;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "createChatImmersFragment", "createConversationFragment", "createFlowSdkChatFragment", "createOWindowChatFragment", "createTemplateFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragmentProvider implements IFragmentProvider {
    public static final FragmentProvider b = null;
    public final /* synthetic */ IFragmentProvider a;

    static {
        b = new FragmentProvider();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment a(Bundle r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        Intrinsics.checkNotNullParameter(r3, "initContainerData");
        return this.a.a(r2, r3);
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment b() {
        return this.a.b();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment c() {
        return this.a.c();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment d(Bundle r9, boolean r10, int r11, Integer r12, ContainerFilter r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r9, "chatBundle");
        Intrinsics.checkNotNullParameter(r14, "initContainerData");
        return this.a.d(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment e(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        return this.a.e(r2);
    }

    private FragmentProvider() {
        IFragmentProvider r0 = (IFragmentProvider) ServiceManager.get().getService(IFragmentProvider.class);
        if (r0 != null) goto L5;
        r0 = new FragmentProviderNoop();
    L5:
        this.a = r0;
    }
}
