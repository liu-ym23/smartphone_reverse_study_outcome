package com.larus.chat.search.impl;

import com.larus.chat.search.api.ISdkSearchService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kz8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JZ\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e28\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010H\u0016JR\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"Lcom/larus/chat/search/impl/NewSearchServiceImpl;", "Lcom/larus/chat/search/api/ISdkSearchService;", "<init>", "()V", "openChatSearchActivity", "", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "activityOptions", "createChatSearchFragment", "Landroidx/fragment/app/Fragment;", "closeAction", "Lkotlin/Function0;", "navigateAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "route", "bundle", "", "searchMessage", "Lcom/larus/im/internal/core/conversation/FtsSearchResult;", "Lcom/larus/im/bean/message/Message;", "keyword", "cursor", "", "searchInCvs", "searchInCvsIdList", "", "scene", "limit", "", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewSearchServiceImpl implements ISdkSearchService {
    public NewSearchServiceImpl() {
    }

    @Override // com.larus.chat.search.api.ISdkSearchService
    public final Object a(String r8, long r9, int r11, Continuation r12) {
        return b.a(r8, r9, null, null, "combined_search", r12);
    }
}
