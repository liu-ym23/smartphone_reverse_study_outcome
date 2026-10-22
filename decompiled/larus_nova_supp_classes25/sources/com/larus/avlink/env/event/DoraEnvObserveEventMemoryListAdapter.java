package com.larus.avlink.env.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.env.event.model.EnvObserveMemoryEvent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004&'()B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClickListener", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$OnItemClickListener;", "<init>", "(Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$OnItemClickListener;)V", "VIEW_TYPE_GROUP", "", "VIEW_TYPE_EVENT", "items", "", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryItem;", "currentPopupHolder", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$MemoryEventViewHolder;", "getCurrentPopupHolder", "()Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$MemoryEventViewHolder;", "setCurrentPopupHolder", "(Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$MemoryEventViewHolder;)V", "hideCurrentPopup", "", "hasPopupShowing", "", "submitList", "newItems", "", "onCommitted", "Lkotlin/Function0;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "getItemViewType", "OnItemClickListener", "MemoryEventGroupViewHolder", "MemoryEventViewHolder", "EmptyViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveEventMemoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final a a;
    public final int b;
    public final List<o98.c> c;
    public MemoryEventViewHolder d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$MemoryEventGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryEventGroup;", "position", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class MemoryEventGroupViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public MemoryEventGroupViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131379866);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$MemoryEventViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$OnItemClickListener;", "adapter", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$OnItemClickListener;Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter;)V", "type", "Landroid/widget/TextView;", "getType", "()Landroid/widget/TextView;", "title", "getTitle", "content", "getContent", "popup", "Lcom/skydoves/balloon/Balloon;", "bindData", "", "data", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "isFullyVisible", "", "view", "dismissPopup", "isPopupShowing", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class MemoryEventViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final a a;
        public final DoraEnvObserveEventMemoryListAdapter b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public Balloon f;

        public final TextView getType() {
            return this.c;
        }

        public MemoryEventViewHolder(View r2, a r3, DoraEnvObserveEventMemoryListAdapter r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "listener");
            Intrinsics.checkNotNullParameter(r4, "adapter");
            super(r2);
            this.a = r3;
            this.b = r4;
            this.c = (TextView) r2.findViewById(2131379872);
            this.d = (TextView) r2.findViewById(2131379871);
            this.e = (TextView) r2.findViewById(2131379864);
        }
    }

    public interface a {
        void fF(EnvObserveMemoryEvent r1);

        void onEventClick(EnvObserveMemoryEvent r1);
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final boolean y2() {
        MemoryEventViewHolder r0 = this.d;
        if (r0 == null) goto L13;
        Balloon r1 = r0.f;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r1.g != true) goto L9;
        r2 = true;
        goto L10
    L13:
        return false;
    }

    public DoraEnvObserveEventMemoryListAdapter(a r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClickListener");
        this.a = r2;
        this.b = 1;
        this.c = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        if ((ListProtector.get(this.c, r2) instanceof o98.b) == false) goto L6;
        return 0;
    L6:
        return this.b;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewRecycled(r2);
        if ((r2 instanceof MemoryEventViewHolder) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.d) == false) goto L12;
        MemoryEventViewHolder r3 = (MemoryEventViewHolder) r2;
        Balloon r0 = r3.f;
        if (r0 == null) goto L9;
        r0.h();
    L9:
        r3.f = null;
        this.d = null;
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        ViewGroup.MarginLayoutParams r1 = null;
        if (Intrinsics.areEqual(r5, this.d) == false) goto L5;
        this.d = null;
    L5:
        o98.c r0 = (o98.c) ListProtector.get(this.c, r6);
        if ((r5 instanceof MemoryEventGroupViewHolder) == false) goto L17;
        if ((r0 instanceof o98.b) == false) goto L17;
        MemoryEventGroupViewHolder r7 = (MemoryEventGroupViewHolder) r5;
        o98.b r2 = (o98.b) r0;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        r7.a.setText(r2.a);
        ViewGroup.LayoutParams r8 = r7.a.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r1 = (ViewGroup.MarginLayoutParams) r8;
    L12:
        if (r1 == null) goto L25;
        if (r6 != 0) goto L15;
        r1.topMargin = i5.Y();
        return;
    L15:
        r1.topMargin = i5.q();
        return;
    L25:
        return;
    L17:
        if ((r5 instanceof MemoryEventViewHolder) == true) goto L19;
        return;
    L19:
        if ((r0 instanceof EnvObserveMemoryEvent) == false) goto L29;
        final MemoryEventViewHolder r9 = (MemoryEventViewHolder) r5;
        final EnvObserveMemoryEvent r3 = (EnvObserveMemoryEvent) r0;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        Balloon r10 = r9.f;
        if (r10 == null) goto L23;
        r10.h();
    L23:
        r9.f = null;
        r9.d.setText(r3.getTitle());
        r9.c.setText(r3.getType());
        r9.e.setText(r3.getContent());
        ((RecyclerView.ViewHolder) r9).itemView.setClickable(true);
        ((RecyclerView.ViewHolder) r9).itemView.setLongClickable(true);
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new j(r9, r3));
        ((RecyclerView.ViewHolder) r9).itemView.setOnLongClickListener(new k(r9, r3));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131563347, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MemoryEventGroupViewHolder(r5);
    L7:
        if (r4 != this.b) goto L11;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131563346, r3, false);
        Intrinsics.checkNotNull(r6);
        return new MemoryEventViewHolder(r6, this.a, this);
    L11:
        return new EmptyViewHolder(new View(r3.getContext()));
    }
}
