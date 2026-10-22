package com.larus.chat.search.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t28\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fH\u0096\u0001J#\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0096\u0001JR\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\"H\u0096A¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"Lcom/larus/chat/search/api/SdkSearchServiceDelegate;", "Lcom/larus/chat/search/api/ISdkSearchService;", "<init>", "()V", "createChatSearchFragment", "Landroidx/fragment/app/Fragment;", "extras", "Landroid/os/Bundle;", "closeAction", "Lkotlin/Function0;", "", "navigateAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "route", "bundle", "", "openChatSearchActivity", "context", "Landroid/content/Context;", "activityOptions", "searchMessage", "Lcom/larus/im/internal/core/conversation/FtsSearchResult;", "Lcom/larus/im/bean/message/Message;", "keyword", "cursor", "", "searchInCvs", "searchInCvsIdList", "", "scene", "limit", "", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkSearchServiceDelegate implements ISdkSearchService {
    public static final SdkSearchServiceDelegate b = null;
    public final /* synthetic */ ISdkSearchService a;

    static {
        b = new SdkSearchServiceDelegate();
    }

    @Override // com.larus.chat.search.api.ISdkSearchService
    public final Object a(String r7, long r8, int r10, Continuation r11) {
        return this.a.a(r7, r8, r10, r11);
    }

    private SdkSearchServiceDelegate() {
        ISdkSearchService r0 = (ISdkSearchService) ServiceManager.get().getService(ISdkSearchService.class);
        if (r0 != null) goto L5;
        r0 = new SdkSearchServiceNoop();
    L5:
        this.a = r0;
    }
}
