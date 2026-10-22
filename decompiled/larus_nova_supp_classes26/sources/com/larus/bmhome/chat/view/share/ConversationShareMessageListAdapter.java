package com.larus.bmhome.chat.view.share;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.list.base.MessageCellAdapter;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListAdapter;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.list.arch.IFlowListCell;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ry8.d;
import xc8.b;
import xc8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fJ\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u001e\u0010\u001a\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J(\u0010#\u001a\u00020\n2\u001e\u0010$\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0%H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010'R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR+\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u0011*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/view/share/ConversationShareMessageListAdapter;", "Lcom/larus/bmhome/chat/list/base/MessageCellAdapter;", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/chat/api/ShareMessageListAdapterWrapper;", "immerseBgColor", "", "<init>", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "updateShareFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "needWaitingRenderMessage", "Landroidx/lifecycle/MutableLiveData;", "", "", "kotlin.jvm.PlatformType", "getNeedWaitingRenderMessage", "()Landroidx/lifecycle/MutableLiveData;", "setData", "messageList", "Lcom/larus/im/bean/message/Message;", "tryTransformToState", "msg", "updateRenderState", "onBindViewHolder", "holder", "Lcom/larus/list/arch/FlowListViewHolder;", "position", "cellAttachIfNeed", "cell", "Lcom/larus/list/arch/IFlowListCell;", "isLongPicShare", "", "transformWaitingRenderMessage", "action", "Lkotlin/Function1;", "notifyChange", "()Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationShareMessageListAdapter extends MessageCellAdapter<b> implements d {
    public final Integer g;
    public final MutableLiveData<List<String>> h;

    public ConversationShareMessageListAdapter() {
        this(null);
    }

    @Override // ry8.d
    public final void L0() {
        notifyItemRangeChanged(0, getItemCount());
    }

    @Override // ry8.d
    public final void l() {
    }

    @Override // ry8.d
    public final Fragment f() {
        return ((FlowListAdapter) this).d;
    }

    @Override // ry8.d
    public final Integer r2() {
        return this.g;
    }

    public ConversationShareMessageListAdapter(Integer r2) {
        this.g = r2;
        CopyOnWriteArraySet r3 = f.a;
        f.d(this);
        this.h = new MutableLiveData(CollectionsKt.emptyList());
    }

    @Override // ry8.d
    public final void l0(Function1<? super List<String>, ? extends List<String>> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        MutableLiveData<List<String>> r0 = this.h;
        if (r0 == null) goto L9;
        List r1 = (List) r0.getValue();
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        r0.setValue(r3.invoke(r1));
        return;
    }

    public final void y2(IFlowListCell<? super b> r3) {
        if ((r3 instanceof BaseCellComponentFeature) == false) goto L6;
        BaseCellComponentFeature r4 = (BaseCellComponentFeature) r3;
        EmptyComponent r0 = EmptyComponent.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        r4.a = r0;
        return;
    }

    public final void B2(FlowListViewHolder<b> r50, int r51) {
        Intrinsics.checkNotNullParameter(r50, "holder");
        if (r51 >= 0) goto L5;
        return;
    L5:
        if (r51 >= ((ArrayList) ((FlowListAdapter) this).c).size()) goto L13;
        b r2 = (b) ListProtector.get(((FlowListAdapter) this).c, r51);
        Message r4 = r2.getMessage();
        Map r5 = r4.getBusinessExt();
        if (r5 != null) goto L10;
        r5 = new LinkedHashMap();
    L10:
        HashMap r15 = new HashMap(r5);
        r15.put("share_pic_mode", "1");
        r2.h(Message.copy$default(r4, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, "long_screenshot_" + r4.getMessageId(), 0, 0, false, null, null, null, r15, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4227073, 31, null));
        super/*com.larus.list.arch.FlowListAdapter*/.B2(r50, r51);
        return;
    }
}
