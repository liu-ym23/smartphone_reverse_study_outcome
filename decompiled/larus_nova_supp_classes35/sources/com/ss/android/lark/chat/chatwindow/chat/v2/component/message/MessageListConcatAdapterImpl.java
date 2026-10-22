package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J+\u0010\u001a\u001a\u00020\r\"\u0014\b\u0000\u0010\u001b*\u0006\u0012\u0002\b\u00030\u001c*\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u0002H\u001bH\u0016¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\u00020\r\"\u0014\b\u0000\u0010\u001b*\u0006\u0012\u0002\b\u00030\u001c*\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u0002H\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0012\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\"H\u0016J\u0010\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListConcatAdapterImpl;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListConcatAdapter;", "concatAdapter", "Landroidx/recyclerview/widget/ConcatAdapter;", "<init>", "(Landroidx/recyclerview/widget/ConcatAdapter;)V", "allItemsInner", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "innerItemsIsDirty", BuildConfig.FLAVOR, "onChanged", BuildConfig.FLAVOR, "onItemRangeChanged", "positionStart", BuildConfig.FLAVOR, "itemCount", "payload", "onItemRangeInserted", "onItemRangeRemoved", "onItemRangeMoved", "fromPosition", "toPosition", "invalidateInnerItems", "resetAllItems", "addAdapter", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListAdapter;", "adapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "removeAdapter", "getAdapters", BuildConfig.FLAVOR, "getAllItems", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListConcatAdapterImpl extends RecyclerView.AdapterDataObserver implements s2b.g {
    public final ConcatAdapter a;
    public final List<Object> b;
    public boolean c;

    public final void b() {
        this.c = true;
        ((ArrayList) this.b).clear();
    }

    @Override // s2b.g
    public final List<Object> h() {
        if (this.c == false) goto L10;
        ((ArrayList) this.b).clear();
        Iterator r0 = this.a.getAdapters().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        s2b.f r1 = (RecyclerView.Adapter) r0.next();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.IMessageListAdapter<*>");
        List<Object> r2 = this.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r1.h());
        goto L6
    L8:
        this.c = false;
    L10:
        return this.b;
    }

    public final void onChanged() {
        b();
    }

    public MessageListConcatAdapterImpl(ConcatAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "concatAdapter");
        this.a = r2;
        this.b = new ArrayList();
        this.c = true;
        r2.registerAdapterDataObserver(this);
    }

    public final void onItemRangeChanged(int r1, int r2) {
        b();
    }

    public final void onItemRangeInserted(int r1, int r2) {
        b();
    }

    public final void onItemRangeRemoved(int r1, int r2) {
        b();
    }

    public final void onItemRangeChanged(int r1, int r2, Object r3) {
        b();
    }

    public final void onItemRangeMoved(int r1, int r2, int r3) {
        b();
    }
}
