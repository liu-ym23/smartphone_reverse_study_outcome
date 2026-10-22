package com.larus.avlink.env.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005#$%&'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;", "<init>", "(Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;)V", "currentPopupHolder", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "getCurrentPopupHolder", "()Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "setCurrentPopupHolder", "(Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;)V", "hideCurrentPopup", "", "hasPopupShowing", "", "placeholders", "", "", "internalList", "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "setList", "list", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "OnItemClickListener", "Companion", "AddViewHolder", "RealItemViewHolder", "PlaceholderViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObservePersonalMemoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final b a;
    public RealItemViewHolder b;
    public final List<String> c;
    public List<n98.e> d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "vDivider", "setDividerVisible", "", "visible", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class AddViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public AddViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131392112);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$PlaceholderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvContent", "Landroid/widget/TextView;", "ivAddPlaceholder", "Landroid/widget/ImageView;", "vDivider", "bind", "", ChatDraftItem.TYPE_TEXT, "", "isLastItem", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class PlaceholderViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final View c;

        public PlaceholderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390392);
            this.b = (ImageView) r2.findViewById(2131375973);
            this.c = r2.findViewById(2131392112);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;", "adapter", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;)V", "tvContent", "Landroid/widget/TextView;", "ivAddPlaceholder", "Landroid/widget/ImageView;", "vDivider", "popup", "Lcom/larus/avlink/env/event/PersonalMemoryActionPopupWindow;", "bind", "", "item", "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "isLastItem", "", "isFullyVisible", "view", "dismissPopup", "isPopupShowing", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class RealItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final b a;
        public final DoraEnvObservePersonalMemoryListAdapter b;
        public final TextView c;
        public final ImageView d;
        public final View e;
        public j0 f;

        public RealItemViewHolder(View r2, b r3, DoraEnvObservePersonalMemoryListAdapter r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "listener");
            Intrinsics.checkNotNullParameter(r4, "adapter");
            super(r2);
            this.a = r3;
            this.b = r4;
            this.c = (TextView) r2.findViewById(2131390392);
            this.d = (ImageView) r2.findViewById(2131375973);
            this.e = r2.findViewById(2131392112);
        }
    }

    public static final class a {
    }

    public interface b {
        void L50(n98.e r1);

        void Lx(n98.e r1);

        void r2();
    }

    static {
    }

    public final int getItemCount() {
        int r0 = this.d.size();
        if (r0 > 0) goto L7;
        r0 = this.c.size();
    L7:
        return r0 + 1;
    }

    public final boolean y2() {
        RealItemViewHolder r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.f == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public DoraEnvObservePersonalMemoryListAdapter(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r3;
        int r0 = com.larus.utils.j0.a;
        this.c = CollectionsKt.listOf(new String[]{com.larus.utils.j0.d(2131902523), com.larus.utils.j0.d(2131902524), com.larus.utils.j0.d(2131902525), com.larus.utils.j0.d(2131902526)});
        this.d = CollectionsKt.emptyList();
    }

    public final int getItemViewType(int r2) {
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if ((!this.d.isEmpty()) == false) goto L7;
        return 1;
    L7:
        return 2;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewRecycled(r4);
        if ((r4 instanceof RealItemViewHolder) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, this.b) == false) goto L15;
        RealItemViewHolder r5 = (RealItemViewHolder) r4;
        j0 r0 = r5.f;
        if (r0 == null) goto L12;
        PopupWindow r2 = r0.f;
        if (r2 == null) goto L11;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L11:
        r0.f = null;
    L12:
        r5.f = null;
        this.b = null;
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        if (Intrinsics.areEqual(r9, this.b) == false) goto L5;
        this.b = null;
    L5:
        int r3 = 0;
        if (r10 != (getItemCount() - 1)) goto L8;
        boolean r0 = true;
    L9:
        int r5 = 8;
        if ((r9 instanceof AddViewHolder) == false) goto L17;
        r9.itemView.setOnClickListener(new a0(this));
        boolean r11 = !r0;
        View r12 = ((AddViewHolder) r9).a;
        if (r11 == true) goto L15;
        r3 = 8;
    L15:
        r12.setVisibility(r3);
        return;
    L17:
        if ((r9 instanceof RealItemViewHolder) == false) goto L36;
        int r13 = r10 - 1;
        if (r13 >= 0) goto L21;
        return;
    L21:
        if (r13 >= this.d.size()) goto L49;
        final n98.e r14 = (n98.e) ListProtector.get(this.d, r13);
        final RealItemViewHolder r15 = (RealItemViewHolder) r9;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "item");
        j0 r4 = r15.f;
        if (r4 == null) goto L28;
        PopupWindow r6 = r4.f;
        if (r6 == null) goto L27;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
    L27:
        r4.f = null;
    L28:
        r15.f = null;
        String r1 = r14.a();
        if (r1 != null) goto L31;
        r1 = "";
    L31:
        r15.c.setText(r1);
        r15.c.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r15).itemView.getContext(), v19.c.b(2131103136, ((RecyclerView.ViewHolder) r15).itemView.getContext(), 2131103136)));
        r15.d.setVisibility(8);
        View r2 = r15.e;
        if (r0 == false) goto L34;
        r3 = 8;
    L34:
        r2.setVisibility(r3);
        ((RecyclerView.ViewHolder) r15).itemView.setClickable(true);
        ((RecyclerView.ViewHolder) r15).itemView.setLongClickable(true);
        ((RecyclerView.ViewHolder) r15).itemView.setOnClickListener(new b0(r15, r14));
        ((RecyclerView.ViewHolder) r15).itemView.setOnLongClickListener(new c0(r15, r14));
        return;
    L49:
        return;
    L36:
        if ((r9 instanceof PlaceholderViewHolder) == false) goto L51;
        int r16 = r10 - 1;
        if (r16 >= 0) goto L40;
        return;
    L40:
        if (r16 >= this.c.size()) goto L53;
        String r17 = (String) ListProtector.get(this.c, r16);
        PlaceholderViewHolder r18 = (PlaceholderViewHolder) r9;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, ChatDraftItem.TYPE_TEXT);
        r18.a.setText(r17);
        r18.a.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r18).itemView.getContext(), v19.c.b(2131103143, ((RecyclerView.ViewHolder) r18).itemView.getContext(), 2131103143)));
        r18.b.setVisibility(0);
        View r19 = r18.c;
        if (r0 == true) goto L45;
        r5 = 0;
    L45:
        r19.setVisibility(r5);
        ((RecyclerView.ViewHolder) r18).itemView.setClickable(false);
        ((RecyclerView.ViewHolder) r18).itemView.setLongClickable(false);
        return;
    L53:
        return;
    L51:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131562607, r4, false);
        Intrinsics.checkNotNull(r6);
        return new AddViewHolder(r6);
    L5:
        if (r5 != 1) goto L7;
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131562608, r4, false);
        Intrinsics.checkNotNull(r7);
        return new RealItemViewHolder(r7, this.a, this);
    L7:
        if (r5 != 2) goto L10;
        View r8 = LayoutInflater.from(r4.getContext()).inflate(2131562608, r4, false);
        Intrinsics.checkNotNull(r8);
        return new PlaceholderViewHolder(r8);
    L10:
        throw new IllegalArgumentException("Unknown view type");
    }
}
