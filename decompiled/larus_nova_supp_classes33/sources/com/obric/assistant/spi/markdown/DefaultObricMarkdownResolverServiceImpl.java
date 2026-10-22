package com.obric.assistant.spi.markdown;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/markdown/DefaultObricMarkdownResolverServiceImpl;", "Lcom/obric/assistant/spi/markdown/IObricMarkdownResolverService;", "<init>", "()V", "resolve", "", "view", "Landroid/view/View;", "link", "", "enableLinkStyle", "chatMessage", "Lcom/larus/im/bean/message/Message;", "needUnderline", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricMarkdownResolverServiceImpl implements IObricMarkdownResolverService {
    public DefaultObricMarkdownResolverServiceImpl() {
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        return false;
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        return false;
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean c(View r1, String r2, boolean r3, Message r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "link");
        return false;
    }
}
