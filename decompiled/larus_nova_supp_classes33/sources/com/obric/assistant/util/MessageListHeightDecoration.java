package com.obric.assistant.util;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/util/MessageListHeightDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setMessageListHeight", "Lkotlin/Function1;", "", "", "debounceTime", "", "latestMessageExtraBottomInsetProvider", "<init>", "(Lkotlin/jvm/functions/Function1;JLkotlin/jvm/functions/Function1;)V", "lastUpdateTime", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListHeightDecoration extends RecyclerView.ItemDecoration {
    public final Function1<Integer, Unit> a;
    public final long b;
    public final Function1<Integer, Integer> c;
    public long d;

    public MessageListHeightDecoration() {
        throw null;
    }

    public MessageListHeightDecoration(Function1 r3, yha.g r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        long r0 = 100;
    L6:
        Function1<Integer, Integer> r6 = r4;
        if ((r5 & 4) == 0) goto L9;
        r6 = new m1();
    L9:
        Intrinsics.checkNotNullParameter(r3, "setMessageListHeight");
        Intrinsics.checkNotNullParameter(r6, "latestMessageExtraBottomInsetProvider");
        this.a = r3;
        this.b = r0;
        this.c = r6;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public final void onDraw(Canvas r23, RecyclerView r24, RecyclerView.State r25) {
        Intrinsics.checkNotNullParameter(r23, "c");
        Intrinsics.checkNotNullParameter(r24, "parent");
        Intrinsics.checkNotNullParameter(r25, "state");
        super.onDraw(r23, r24, r25);
        long r1 = System.currentTimeMillis();
        if ((r1 - this.d) >= this.b) goto L5;
        return;
    L5:
        wq8.b r4 = r24.getAdapter();
        if ((r4 instanceof wq8.b) == false) goto L8;
        wq8.b r5 = r4;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        RecyclerView.LayoutManager r3 = r24.getLayoutManager();
        if (r3 != null) goto L14;
        return;
    L14:
        Iterator r6 = r5.getCurrentList().iterator();
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L16:
        if (r6.hasNext() == false) goto L49;
        Object r10 = r6.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        Message r12 = (Message) r10;
        View r13 = r3.findViewByPosition(r9);
        if (r13 != null) goto L30;
        String r14 = r12.getLocalMessageId();
        if (r14 == null) goto L29;
        IObricChatUIService r15 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r15 == null) goto L27;
        Integer r16 = Integer.valueOf(r15.i(r14));
    L46:
        if (r16 == null) goto L48;
        r8 = r8 + r16.intValue();
    L48:
        r3 = r3;
        r9 = r11;
        r7 = 0;
        goto L16
    L27:
        r16 = null;
        goto L46
    L29:
        r16 = null;
        goto L46
    L30:
        int r17 = r3.getTopDecorationHeight(r13);
        int r18 = r3.getBottomDecorationHeight(r13);
        Function1<Integer, Integer> r19 = this.c;
        if (r9 != 0) goto L35;
        if (r18 <= 0) goto L35;
        int r110 = RangesKt.coerceIn(((Number) r19.invoke(Integer.valueOf(r18))).intValue(), r7, r18);
    L36:
        int r111 = ((r13.getHeight() + r17) + r18) - r110;
        FLogger.a.i("OrionPageStateTouchHelp", "MessageListHeightDecoration onDraw, card is not null, card is " + r13 + ", cardHeight is " + r13.getHeight() + ", topDecoration is " + r17 + ", bottomDecoration is " + r18 + ", latestExtraBottomInset is " + r110 + ", index = " + r9 + ", localMessageId = " + r12.getLocalMessageId() + ", messageId = " + r12.getMessageId() + ", createTime = " + r12.getCreateTime() + ", statusLocal = " + r12.getMessageStatusLocal());
        String r112 = r12.getLocalMessageId();
        if (r112 == null) goto L45;
        IObricChatUIService r113 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r113 == null) goto L45;
        long r114 = r12.getCreateTime();
        Map r20 = r12.getBusinessExt();
        if (r20 == null) goto L43;
        String r21 = (String) r20.get("o_keyguard_tips_message");
    L44:
        r113.C(r112, r114, r111, Intrinsics.areEqual(r21, "1"));
        goto L45
    L43:
        r21 = null;
    L45:
        r16 = Integer.valueOf(r111);
    L35:
        r110 = 0;
        goto L36
    L49:
        this.a.invoke(Integer.valueOf(r8));
        this.d = r1;
        return;
    L8:
        r5 = null;
        goto L9
    }
}
