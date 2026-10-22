package com.obric.assistant.spi.markdown;

import android.view.View;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J+\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/markdown/ObricMarkdownResolverServiceDelegate;", "Lcom/obric/assistant/spi/markdown/IObricMarkdownResolverService;", "<init>", "()V", "enableLinkStyle", "", "link", "", "needUnderline", "resolve", "view", "Landroid/view/View;", "chatMessage", "Lcom/larus/im/bean/message/Message;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMarkdownResolverServiceDelegate implements IObricMarkdownResolverService {
    public static final ObricMarkdownResolverServiceDelegate b = null;
    public final /* synthetic */ IObricMarkdownResolverService a;

    static {
        b = new ObricMarkdownResolverServiceDelegate();
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean c(View r2, String r3, boolean r4, Message r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "link");
        return this.a.c(r2, r3, r4, r5);
    }

    private ObricMarkdownResolverServiceDelegate() {
        IObricMarkdownResolverService r0 = (IObricMarkdownResolverService) ServiceManager.get().getService(IObricMarkdownResolverService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricMarkdownResolverServiceImpl();
    L5:
        this.a = r0;
    }
}
