package ug8;

import com.larus.bmhome.chat.list.cell.text.components.middle.h0;
import com.larus.bmhome.chat.list.cell.text.interceptor.InterceptedMessageException;
import com.larus.bmhome.chat.list.cell.text.interceptor.MarkdownRenderException;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {
    h0 a(h0 r1) throws InterceptedMessageException, MarkdownRenderException;

    Message b(Message r1) throws InterceptedMessageException, MarkdownRenderException;
}
