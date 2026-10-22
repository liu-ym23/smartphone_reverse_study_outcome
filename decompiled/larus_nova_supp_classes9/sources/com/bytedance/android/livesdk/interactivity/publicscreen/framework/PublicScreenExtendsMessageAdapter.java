package com.bytedance.android.livesdk.interactivity.publicscreen.framework;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.Store;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.PublicScreenAIAutoReplyViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.PublicScreenCombinedTextViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g52.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/framework/PublicScreenExtendsMessageAdapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/adapter/MessageListAdapter;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PublicScreenExtendsMessageAdapter extends MessageListAdapter {
    public final Map<PublicScreenConfig$ViewBinderType, j<? extends i, ? extends PSMessageViewHolder>> k;
    public final k<s> l;
    public final PublicScreenContext m;
    public final c n;

    public final j<? extends i, ? extends PSMessageViewHolder> B2(int r8) {
        PublicScreenConfig$ViewBinderType.Companion.getClass();
        PublicScreenConfig$ViewBinderType[] r0 = PublicScreenConfig$ViewBinderType.access$getVALUES$cp();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L12;
        PublicScreenConfig$ViewBinderType r5 = r0[r3];
        if (r5.getViewType() != r8) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r5 != null) goto L15;
        return null;
    L15:
        return this.k.get(r5);
    L8:
        r6 = false;
        goto L9
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter
    public final int getItemViewType(int r2) {
        if ((ListProtector.get(this.b, r2) instanceof z) == false) goto L5;
        Object r3 = ListProtector.get(this.b, r2);
        if (r3 == null) goto L11;
        return ((z) r3).H.b().a().getViewType();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.textmessage.model.PublicScreenCompatTextMessage");
    L5:
        return super.getItemViewType(r2);
    }

    public PublicScreenExtendsMessageAdapter(PublicScreenContext r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "messageView");
        super(r3);
        this.m = r2;
        this.n = r3;
        this.k = ((Store) r2.getViewBinderStore().getValue()).map();
        e52.a r4 = r2.getTextConfig();
        if (r4 == null) goto L5;
        k<s> r5 = r4.e();
    L6:
        this.l = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter
    public final MessageViewHolder A2(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        u r0 = u.b;     // Catch: Throwable -> L25
        r0.c();     // Catch: Throwable -> L25
        j<? extends i, ? extends PSMessageViewHolder> r1 = B2(r5);     // Catch: Throwable -> L25
        if (r1 == null) goto L22;
        PSMessageViewHolder r6 = r1.c(this.a, r4, this.n);     // Catch: Throwable -> L25
        if ((r6 instanceof PSTextMessageViewHolder) == false) goto L11;
        k<s> r7 = this.l;     // Catch: Throwable -> L25
        if (r7 == null) goto L11;
        ((PSTextMessageViewHolder) r6).Y3(r7);     // Catch: Throwable -> L25
    L11:
        if ((r6 instanceof PublicScreenAIAutoReplyViewHolder) == false) goto L16;
        k<s> r8 = this.l;     // Catch: Throwable -> L25
        if (r8 == null) goto L16;
        ((PublicScreenAIAutoReplyViewHolder) r6).X3(r8);     // Catch: Throwable -> L25
    L16:
        if ((r6 instanceof PublicScreenCombinedTextViewHolder) == false) goto L20;
        k<s> r9 = this.l;     // Catch: Throwable -> L25
        if (r9 == null) goto L20;
        ((PublicScreenCombinedTextViewHolder) r6).Y3(r9);     // Catch: Throwable -> L25
    L20:
        r0.i();
        return r6;
    L22:
        MessageViewHolder r10 = super.A2(r4, r5);     // Catch: Throwable -> L25
        r0.i();
        return r10;
    L25:
        th = move-exception;
        u.b.i();
        throw th;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter
    public final void y2(MessageViewHolder r4, f<?> r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Iterator r0 = ((Iterable) this.m.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((s42.b) r0.next()).m(r5);
        goto L4
    L7:
        if ((r4 instanceof PSMessageViewHolder) == true) goto L9;
    L17:
        super.y2(r4, r5, r6);
        return;
    L9:
        if ((r5 instanceof z) == false) goto L17;
        PSMessageViewHolder r1 = (PSMessageViewHolder) r4;
        if (B2(r1.getItemViewType()) == null) goto L17;
        j<? extends i, ? extends PSMessageViewHolder> r7 = B2(r1.getItemViewType());
        if (r7 == null) goto L20;
        r7.d(r1, ((z) r5).H, r6, this.e.m);
        Unit r8 = Unit.INSTANCE;
        r1.a = r5;
        return;
    }
}
