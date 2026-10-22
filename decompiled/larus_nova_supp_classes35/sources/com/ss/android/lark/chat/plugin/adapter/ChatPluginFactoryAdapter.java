package com.ss.android.lark.chat.plugin.adapter;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.e;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.f;
import com.ss.android.lark.chat.component.ChatWindowAdapterComponent;
import com.ss.android.lark.scaffold.PagePlugin;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import hac.c;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u000eB\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/plugin/adapter/ChatPluginFactoryAdapter;", "Lcom/ss/android/lark/scaffold/PagePlugin;", "Lcom/ss/android/lark/scaffold/LifecyclePagePlugin;", "Landroidx/lifecycle/LifecycleOwner;", "provider", "Lkotlin/Function1;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/IChatPluginFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreate", BuildConfig.FLAVOR, "runtime", "Lcom/ss/android/lark/scaffold/PageRuntime;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatPluginFactoryAdapter extends PagePlugin {
    public final Function1<i7b.a, e> b;

    public static final class a {
    }

    public static final class b implements f, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.f
        public final /* synthetic */ e a(i7b.a r2) {
            return (e) this.a.invoke(r2);
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof f) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatPluginFactoryAdapter(Function1<? super i7b.a, ? extends e> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.b = r2;
    }

    public final void a(l3c.f r11) {
        Intrinsics.checkNotNullParameter(r11, "runtime");
        Intrinsics.checkNotNullParameter(r11, "runtime");
        ChatWindowOpenViewModel r2 = r11.b(ChatWindowOpenViewModel.class);
        if (r2 != null) goto L6;
        hac.b r12 = hac.b.a;
        c.a("PagePluginsAdapter", "chatViewModel == null");
        return;
    L6:
        ChatWindowAdapterComponent r5 = (ChatWindowAdapterComponent) r11.a(ChatWindowAdapterComponent.class);
        if (r5 != null) goto L10;
        hac.b r13 = hac.b.a;
        c.a("PagePluginsAdapter", "chatWindowComponent == null");
        return;
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatPluginFactoryAdapter$onCreate$1(r2, this, r11, r5, null), 3, null);
    }
}
