package com.larus.bmhome.chat.larkforward;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H&J&\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\t0\u0013H&J\u001e\u0010\u0015\u001a\u00020\t2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0\u0013H&¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/larkforward/IFlowLarkToDoubaoService;", "", "getDoubaoForwardTarget", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoTarget;", "fallbackName", "", "fallbackIcon", "Landroid/graphics/drawable/Drawable;", "forwardToDoubao", "", "request", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoRequest;", "callback", "Lcom/larus/bmhome/chat/larkforward/FlowLarkToDoubaoCallback;", "enabled", "", "failureMessage", "resolveMainBotBundle", "fallbackTitle", "Lkotlin/Function1;", "Landroid/os/Bundle;", "resolveMainBotConversationId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IFlowLarkToDoubaoService {
    void a(String r1, Function1<? super Bundle, Unit> r2);

    void b(p r1, o r2, boolean r3, String r4);

    d0 c(String r1, Drawable r2);
}
