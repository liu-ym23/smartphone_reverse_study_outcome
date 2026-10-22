package com.ss.android.lark.chat.chatwindow.chat;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.blueprint.d;
import com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chat.chatwindow.chat.scroll.b;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.y0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u000f\u0018\u0000 72\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0012\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J*\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00162\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\rH\u0016J\u0014\u0010,\u001a\u00020!2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0016J\u0012\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0016H\u0016J\u0016\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\u001fH\u0016J0\u00102\u001a\u00020!2\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002042\u0006\u0010\u001e\u001a\u00020\u001f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d06H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00162\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00068"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/ChatAdapterV2;", "Lcom/ss/android/lark/blueprint/recyclerview/BlueprintAdapter;", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter;", "<init>", "()V", "blueprint", "Lcom/ss/android/lark/blueprint/Blueprint;", "getBlueprint", "()Lcom/ss/android/lark/blueprint/Blueprint;", "setBlueprint", "(Lcom/ss/android/lark/blueprint/Blueprint;)V", "isDebug", BuildConfig.FLAVOR, "itemCallback", "com/ss/android/lark/chat/chatwindow/chat/ChatAdapterV2$itemCallback$1", "Lcom/ss/android/lark/chat/chatwindow/chat/ChatAdapterV2$itemCallback$1;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "changePayloadHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter$IChangePayloadHandler;", "value", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getItemData", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "setDebug", BuildConfig.FLAVOR, GeckoConst.DEBUG, "handleItemChangePayload", "handler", "doOnDiffFinish", Keys.API_PARAM_KEY_ACTION, "Ljava/lang/Runnable;", "getIntervalMessages", "startIndex", "endIndex", "includeEnd", "notifyLayoutRefreshed", "messageVO", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "getAllItems", "getItem", "getItemCount", "onBindViewHolder", "holder", "Lcom/ss/android/lark/blueprint/recyclerview/BlueprintCellViewHolder;", "payloads", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAdapterV2 extends BlueprintAdapter<c<?>> implements com.ss.android.lark.chat.chatwindow.chat.a {
    public d b;
    public final AsyncListDiffer<c<?>> c;
    public com.ss.android.lark.chat.chatwindow.chat.a.InterfaceC0036a d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final void s1(boolean r1) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final RecyclerView.Adapter e() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
        return this;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final List<c<?>> getData() {
        return this.c.getCurrentList();
    }

    public final int getItemCount() {
        return this.c.getCurrentList().size();
    }

    @Override // s2b.f
    public final List<c<?>> h() {
        return this.c.getCurrentList();
    }

    public final d y2() {
        d r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("blueprint");
        return null;
    }

    public ChatAdapterV2() {
        this.c = new AsyncListDiffer(this, new ChatAdapterV2$itemCallback$1(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.a
    public final void Y(b r1) {
        this.d = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final void Y0(y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "messageVO");
        List r0 = this.c.getCurrentList();
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        if (y0.a(((c) r1.next()).c, r6.getId()) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 < 0) goto L12;
        c r3 = (c) ListProtector.get(r0, r2);
    L14:
        if (Intrinsics.areEqual(r3, r6) == false) goto L16;
        c r7 = (c) r6;
        r7.T2 = true;
        notifyItemChanged(r2);
        Log.i("AsyncParseLog", "notify item changed for position: " + r2 + ", message id: " + r7.c);
        return;
    L16:
        Log.i("AsyncParseLog", "MessageVO changed, drop it for message " + r6.getId());
        return;
    L12:
        r3 = null;
        goto L14
    L9:
        r2 = -1;
        goto L10
    }

    public final Object getItem(int r2) {
        return (c) ListProtector.get(this.c.getCurrentList(), r2);
    L4:
        Log.w("ChatAdapterV2", "getItem: occur io exception");
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final void q0(final k r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        this.c.addListListener(new ChatAdapterV2$doOnDiffFinish$1(this, r3));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final void setData(List<? extends c<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Log.i("ChatAdapterV2", "submitList, oldSize: " + this.c.getCurrentList().size() + ", newSize: " + r3.size() + ", adapter: " + hashCode());
        this.c.submitList(r3);
    }

    public final Object z2(int r2) {
        c r3 = (c) ListProtector.get(this.c.getCurrentList(), r2);     // Catch: IndexOutOfBoundsException -> L4
    L5:
        if (r3 == null) goto L7;
        return r3;
    L7:
        return new Object();
    L4:
        Log.w("ChatAdapterV2", "getItem: occur io exception");
        r3 = null;
        goto L5
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a
    public final List o1(int r4, int r5) {
        ArrayList r0 = new ArrayList();
        if (r4 < 0) goto L15;
        if (r5 < 0) goto L15;
        ArrayList r1 = new ArrayList(this.c.getCurrentList());
        if (r5 < r1.size()) goto L9;
        r5 = r1.size() - 1;
    L9:
        if (r4 <= r5) goto L12;
        Log.e("ChatAdapterV2", "error in putMessageReadState, startIndex = [" + r4 + "], endIndex = [" + r5 + ']');
        return r0;
    L12:
        int r6 = r5 + 1;
    L13:
        if (r4 >= r6) goto L15;
        r0.add(ListProtector.get(r1, r4));
        r4 = r4 + 1;
    L15:
        return r0;
    }

    public final void A2(BlueprintCellViewHolder<? super c<?>> r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Object r6 = z2(r4);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type Data of com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter");
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        r3.a.update(r6);
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        A2((BlueprintCellViewHolder) r1, r2, r3);
    }
}
