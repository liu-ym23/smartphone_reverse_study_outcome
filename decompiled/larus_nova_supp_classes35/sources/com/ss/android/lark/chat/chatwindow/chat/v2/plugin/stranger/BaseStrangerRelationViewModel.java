package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.ss.android.lark.replyinthread.pages.base.SubViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/BaseStrangerRelationViewModel;", "Lcom/ss/android/lark/replyinthread/pages/base/SubViewModel;", "<init>", "()V", "chatReadableFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "getChatReadableFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "chatChangeToReadable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getChatChangeToReadable", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "bannerFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", "getBannerFlow", "tagFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "getTagFlow", "closeBannerActionFlow", BuildConfig.FLAVOR, "getCloseBannerActionFlow", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseStrangerRelationViewModel extends SubViewModel {
    public abstract z0<StrangerBannerType> getBannerFlow();

    public abstract MutableSharedFlow<Integer> getChatChangeToReadable();

    public abstract z0<Integer> getChatReadableFlow();

    public abstract MutableSharedFlow<Boolean> getCloseBannerActionFlow();

    public abstract z0<StrangerTagType> getTagFlow();

    public BaseStrangerRelationViewModel() {
    }
}
