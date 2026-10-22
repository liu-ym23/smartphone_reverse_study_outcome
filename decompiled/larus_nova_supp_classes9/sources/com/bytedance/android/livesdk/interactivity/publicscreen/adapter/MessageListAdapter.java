package com.bytedance.android.livesdk.interactivity.publicscreen.adapter;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.j;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.ActionMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomIntroViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomNoticeViewHolder;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.AudioTextMessageViewHolderV2;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import da2.b;
import g52.c;
import g52.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u42.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public LayoutInflater a;
    public List<f<?>> b;
    public v92.a c;
    public final c d;
    public q92.a e;
    public boolean f;
    public boolean g;
    public boolean h;
    public DataCenter i;
    public final a j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if ((r2.getTag() instanceof com.bytedance.android.livesdk.interactivity.api.entity.a) == true) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.interactivity.api.entity.a r0 = (com.bytedance.android.livesdk.interactivity.api.entity.a) r2.getTag();
            r2.getContext();
            r0.K();
        }
    }

    public final int getItemCount() {
        List<f<?>> r0 = this.b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public final k<f<?>> z2() {
        q92.a r0 = this.e;
        if (r0 == null) goto L7;
        k<f<?>> r1 = r0.s;
        if (r1 == null) goto L7;
        return r1;
    L7:
        int r2 = da2.a.a;
        return new b(new da2.c(this.f, this.g, null));
    }

    public MessageListAdapter(c r2) {
        this.h = true;
        this.j = new a();
        this.d = r2;
    }

    public int getItemViewType(int r2) {
        return ((f) ListProtector.get(this.b, r2)).getType();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        super.onAttachedToRecyclerView(r2);
        new WeakReference(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        ((MessageViewHolder) r1).T3();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        ((MessageViewHolder) r1).V3();
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r3) {
        boolean r0 = TextMessageTracer.a;
        TextMessageTracer.A("on unregister adapter data observer for adapter");
        super.unregisterAdapterDataObserver(r3);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("on error!  observer not resgisted " + e.getMessage());
        if (v.a() == true) goto L10;
        SafetyGuard.a(null, e, null);
        return;
    L10:
        throw e;
    }

    public MessageViewHolder A2(ViewGroup r7, int r8) {
        if (r8 != 0) goto L4;
        TextMessageRenderViewHolder.f r9 = j.a(r7.getContext());
        TextMessageRenderViewHolder r10 = new TextMessageRenderViewHolder(r9, z2(), true, this.e, this.d);
        g52.a r11 = r9.d;
        if (r11 == null) goto L36;
        r11.setDispatchCallback(r10);
    L36:
        return r10;
    L4:
        if (r8 == 1) goto L32;
        if (r8 != 6) goto L8;
        k<f<?>> r13 = z2();
        View r14 = this.a.inflate(2131566245, r7, false);
        if (r14.getLayoutParams() != null) goto L30;
        r14.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L30:
        return new AudioTextMessageViewHolderV2(r14, r13, this.e);
    L8:
        if (r8 != 7) goto L10;
        View r15 = this.a.inflate(2131567396, r7, false);
        RelativeLayout r0 = new RelativeLayout(r7.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.addView(r15);
        r0.setFocusable(true);
        r0.setFocusableInTouchMode(true);
        if (r0.getLayoutParams() != null) goto L25;
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L25:
        return new RoomIntroViewHolder(r0, this.g, this.e, this.i);
    L10:
        if (r8 == 8) goto L19;
        u.b.b(r8);
        if (v.a() == true) goto L18;
        TextMessageRenderViewHolder.f r16 = j.a(r7.getContext());
        TextMessageRenderViewHolder r17 = new TextMessageRenderViewHolder(r16, z2(), true, this.e, this.d);
        g52.a r18 = r16.d;
        if (r18 == null) goto L16;
        r18.setDispatchCallback(r17);
    L16:
        return r17;
    L18:
        throw new RuntimeException("MessageListAdapter, unknown type: " + r8);
    L19:
        int r19 = RoomNoticeViewHolder.d;
        return new RoomNoticeViewHolder(this.a.inflate(2131567397, r7, false), this.g, this.e);
    L32:
        return new ActionMessageViewHolder(this.a.inflate(2131567399, r7, false), this.j, this.e);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        MessageViewHolder r7 = (MessageViewHolder) r5;
        v92.a r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        f<?> r1 = (f) ListProtector.get(this.b, r6);
        u r2 = u.b;
        r2.m(r1);
        r7.getClass();
        y2(r7, r1, r6);
        View r8 = ((RecyclerView.ViewHolder) r7).itemView;
        int r9 = com.bytedance.android.livesdk.interactivity.publicscreen.pin.b.a;
        Intrinsics.checkNotNullParameter(r8, "itemView");
        Intrinsics.checkNotNullParameter(r1, "message");
        u42.b r3 = null;
        if ((r1 instanceof z) == false) goto L10;
        u42.b r10 = ((z) r1).H.d;
    L13:
        if (r10 != null) goto L15;
    L18:
        int r11 = g.a;
        Intrinsics.checkNotNullParameter(r8, "view");
        r8.setTag(2131389712, r3);
        r2.g(r1);
        if (this.h == false) goto L22;
        this.h = false;
        HashMap r13 = new HashMap();
        r13.put("event_name", "ON_FIRST_MSG_SHOW");
        r13.put("msg_id", Long.valueOf(r1.b.getMessageId()));
        r13.put("method", r1.b.getMessageMethod());
        b0.o().b("ttlive_msg", r13);
        return;
    L22:
        return;
    L15:
        if (r10.getShowTimestamp() != null) goto L17;
        r10.g(Long.valueOf(SystemClock.elapsedRealtime()));
    L17:
        r3 = r10;
        goto L18
    L10:
        if (r1 == null) goto L12;
        r10 = r1.C;
        goto L13
    L12:
        r10 = null;
        goto L13
    L5:
        if (r6 != 4) goto L7;
        r0.preload();
        goto L7
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    public void y2(MessageViewHolder r2, f r3, int r4) {
        e r0 = this.e.m;
        r2.a = r3;
        r2.U3(r3, r4, r0);
    }
}
