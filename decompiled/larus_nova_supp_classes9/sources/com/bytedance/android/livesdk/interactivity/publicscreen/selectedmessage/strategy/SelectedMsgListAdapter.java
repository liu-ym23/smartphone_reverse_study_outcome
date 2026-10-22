package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.viewholder.SelectedTextMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdk.interactivity.utils.t;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g52.e;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/strategy/SelectedMsgListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedMsgListAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public final Lazy a;
    public List<? extends f<?>> b;
    public e52.a c;
    public e d;
    public final Function1<f<?>, Map<String, String>> e;
    public final Function2<Boolean, Map<String, String>, Boolean> f;
    public final k g;

    public SelectedMsgListAdapter() {
        this(null, null, null);
    }

    public final int getItemCount() {
        List<? extends f<?>> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        new WeakReference(r2);
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        super.unregisterAdapterDataObserver(r2);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        if (v.a() == true) goto L10;
        SafetyGuard.a(null, e, null);
        return;
    L10:
        throw e;
    }

    public final SelectedTextMessageViewHolder y2(ViewGroup r8) {
        NoMoreSpaceTextView r1 = new NoMoreSpaceTextView(r8.getContext());
        r1.setMinimumHeight((int) s1.e(24.0f));
        float r0 = r1.getLineSpacingMultiplier();
        if (PublicScreenStyleHelper.n == false) goto L5;
        float r2 = PublicScreenStyleHelper.g;
    L6:
        r1.setLineSpacing(r2, r0);
        r1.setPadding(s1.f(8.0f), s1.f(3.0f), s1.f(8.0f), s1.f(3.0f));
        r1.setTextIsSelectable(false);
        r1.setTextAlignment(5);
        r1.setGravity(16);
        r1.setTextSize(s1.e(15.0f));
        r1.setTypeface(Typeface.DEFAULT_BOLD);
        r1.setId(2131388367);
        RelativeLayout r3 = new RelativeLayout(r8.getContext());
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r3.setId(2131377403);
        r3.addView(r1);
        r3.setFocusable(false);
        r3.setImportantForAccessibility(2);
        if (InteractivityOpt.b == false) goto L10;
        r3.setLayerType(2, null);
    L10:
        if (r3.getLayoutParams() != null) goto L12;
        r3.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L12:
        TextMessageRenderViewHolder.f r9 = new TextMessageRenderViewHolder.f(r3, r1, r1, null);
        e52.a r4 = this.c;
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<f<?>> r5 = r4.g();
        if (r5 == null) goto L16;
    L18:
        return new SelectedTextMessageViewHolder(r9, r5, this.c, this.e, this.f);
    L16:
        r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k) this.a.getValue();
        goto L18
    L5:
        r2 = PublicScreenStyleHelper.f;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        MessageViewHolder r7 = (MessageViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        List<? extends f<?>> r1 = this.b;
        if (r1 == null) goto L33;
        f<?> r2 = (f) ListProtector.get(r1, r6);
        if (r2 == null) goto L38;
        r7.getClass();
        ga2.c.b.a(r2, this.g);
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r2, "message");
        e r3 = this.d;
        r7.a = r2;
        r7.U3(r2, r6, r3);
        SimpleDateFormat r8 = PublicScreenMessageMonitor.a;
        t r9 = (t) PublicScreenMessageMonitor.v.getValue();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "message");
        if (r9.d == false) goto L39;
        c4 r10 = r2.b;
        if (r10 != null) goto L14;
        return;
    L14:
        if ((r10 instanceof k0) == false) goto L17;
        r9.b++;
        return;
    L17:
        if ((r10 instanceof c4) == false) goto L22;
        if (r10.isGiftTypeMessage() == false) goto L22;
        r9.a++;
        return;
    L22:
        if ((r10 instanceof o7) == false) goto L24;
    L31:
        r9.a++;
        return;
    L24:
        if ((r10 instanceof kc2.b) == true) goto L31;
        if ((r10 instanceof h4) == false) goto L29;
    L30:
        r9.c++;
        return;
    L29:
        if ((r10 instanceof s3) == true) goto L30;
        return;
    L39:
        return;
    L38:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 0) goto L10;
        if (v.a() == true) goto L8;
        return y2(r3);
    L8:
        throw new RuntimeException("SelectedMsgListAdapter, unknown type: " + r4);
    L10:
        return y2(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectedMsgListAdapter(Function1<? super f<?>, ? extends Map<String, String>> r1, Function2<? super Boolean, ? super Map<String, String>, Boolean> r2, k r3) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.a = LazyKt.lazy(new SelectedMsgListAdapter$defaultProcessor$2(this));
    }
}
