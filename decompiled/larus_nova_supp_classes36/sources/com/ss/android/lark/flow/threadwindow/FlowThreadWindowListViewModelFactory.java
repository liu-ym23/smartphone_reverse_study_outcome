package com.ss.android.lark.flow.threadwindow;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "enableMessageFolding", "", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;Z)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowThreadWindowListViewModelFactory implements ViewModelProvider.Factory {
    public final fxa.b a;
    public final v b;
    public final i7b.a c;
    public final boolean d;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "modelClass");
        if (Intrinsics.areEqual(r4, FlowThreadWindowListViewModel.class) == false) goto L7;
        FlowThreadWindowListViewModel r5 = new FlowThreadWindowListViewModel(this.a, this.b, this.d);
        r5.bindInitData(this.c);
        return r5;
    L7:
        throw new IllegalArgumentException(("unsupported ViewModel class: " + r4).toString());
    }

    public FlowThreadWindowListViewModelFactory(ChatBundle r2, v r3, i7b.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r4, "initData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
