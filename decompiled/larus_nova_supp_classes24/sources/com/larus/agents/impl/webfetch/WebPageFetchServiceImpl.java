package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.api.IWebPageFetchService;
import k48.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/agents/impl/webfetch/WebPageFetchServiceImpl;", "Lcom/larus/agents/api/IWebPageFetchService;", "<init>", "()V", "fetcher", "Lcom/larus/agents/impl/webfetch/WebPageFetcher;", "fetchWebPageHtml", "Lcom/larus/agents/api/WebPageFetchResult;", "url", "", "commandId", "sendCookie", "", "maxRedirect", "", "maxBytes", "(Ljava/lang/String;Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WebPageFetchServiceImpl implements IWebPageFetchService {
    public final WebPageFetcher a;

    public WebPageFetchServiceImpl() {
        this.a = new WebPageFetcher(0);
    }

    @Override // com.larus.agents.api.IWebPageFetchService
    public final Object a(String r8, String r9, boolean r10, int r11, int r12, Continuation<? super a> r13) {
        return this.a.b(r8, r9, r10, r11, r12, r13);
    }
}
