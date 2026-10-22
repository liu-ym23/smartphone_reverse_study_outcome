package com.larus.bmhome.chat.list.cell.text.cells.top.deepsearch;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.l;
import ei9.f;
import hg8.b;
import hg8.c;
import hg8.d;
import hg8.e;
import hg8.g;
import hg8.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0#H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010%J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001dH\u0016J\u001e\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001dH\u0016J \u0010/\u001a\u0002002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkContentCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkContentCellState;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/IDeepThinkCutCell;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "deepSearchContentComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/DeepSearchContentComponent;", "getDeepSearchContentComponent", "()Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/DeepSearchContentComponent;", "deepSearchContentComponent$delegate", "Lkotlin/Lazy;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "context", "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getColor", "()Ljava/lang/Integer;", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "getAllSlotCells", "updateVisible", "visibility", "shouldBindCell", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkContentCell extends BaseCompositeTextCell<g> implements z {
    public static final /* synthetic */ int m = 0;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
    }

    static {
    }

    @Override // hg8.z
    public final void j() {
    }

    public DeepThinkContentCell() {
        this.j = LazyKt.lazy(new hg8.a());
        this.k = LazyKt.lazy(new b(this));
        this.l = LazyKt.lazy(new c(this));
    }

    public final List<BaseMessageSlotCell<? extends f>> f(int r1) {
        return CollectionsKt.emptyList();
    }

    @Override // hg8.z
    public final void i(int r2) {
        ((l) this.j.getValue()).i(r2);
    }

    public final List<BaseMessageSlotCell<? extends f>> g(int r6, List<BaseMessageSlotCell<? extends f>> r7) {
        Intrinsics.checkNotNullParameter(r7, "default");
        if (r6 == 1) goto L19;
        ArrayList r8 = new ArrayList();
        Iterator<T> r1 = r7.iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (r2 == true) goto L9;
        if ((((BaseMessageSlotCell) r3) instanceof MessageInboxRightRetrySlotCell) == true) goto L6;
        r8.add(r3);
        r2 = true;
        goto L6
    L9:
        r8.add(r3);
        goto L6
    L13:
        CollectionsKt.removeAll(r7, new d());
        de8.c r9 = (de8.c) this.l.getValue();
        if (r9 == null) goto L16;
        Integer r10 = r9.m();
    L17:
        if (r10 != null) goto L19;
        CollectionsKt.removeAll(r7, new e());
        CollectionsKt.removeAll(r7, new hg8.f());
        goto L19
    L16:
        r10 = null;
    L19:
        return r7;
    }

    public final com.larus.bmhome.chat.layout.item.g t(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        o((l) this.j.getValue());
        de8.c r0 = (de8.c) this.l.getValue();
        if (r0 == null) goto L5;
        Integer r1 = r0.m();
    L6:
        t r2 = new t(r4);
        r2.setImmerseBgColor(r1);
        ChatParam r6 = (ChatParam) this.k.getValue();
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        r2.setUseSubscribedColor(r7);
        r2.setBoxType(r5);
        r2.setUpCompositeBoxType(CompositeBoxType.CompositeMiddleBox);
        r2.z = false;
        r2.y = false;
        r2.setNeedKeepWidthToMaxWidth(true);
        return r2;
    L9:
        if (r6.f != true) goto L11;
        r7 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void onBindView(View r2, f r3, int r4) {
        g r5 = (g) r3;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.u(r2, r5, r4);
    }

    public final boolean shouldBindCell(View r1, f r2, int r3) {
        g r4 = (g) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        ((l) this.j.getValue()).H(r4);
        return true;
    }

    public final void u(View r2, xc8.b r3, int r4) {
        g r5 = (g) r3;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.u(r2, r5, r4);
    }

    public final boolean w(View r1, xc8.b r2, int r3) {
        g r4 = (g) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        ((l) this.j.getValue()).H(r4);
        return true;
    }
}
