package com.larus.extension.chat_extension.impl.ltm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmListBinding;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmTitleBinding;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmEmptyHolder;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmNormalHolder;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmTitleHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "callback", "Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;", "<init>", "(Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "isPlaceHolder", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmListAdapter extends ListAdapter<r, ChatLtmBaseHolder> {
    public final j99.j a;

    public final int getItemCount() {
        return super.getItemCount();
    }

    public ChatLtmListAdapter(j99.j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(new ChatLtmItemCallback());
        this.a = r2;
    }

    public final int getItemViewType(int r1) {
        return ((r) getItem(r1)).e;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        ChatLtmBaseHolder r4 = (ChatLtmBaseHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((r) getItem(r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        if (r13 != ChatLtmBaseHolder.Companion.ChatItemViewType.NORMAL.getValue()) goto L20;
        RadiusCardView r14 = LayoutInflater.from(r12.getContext()).inflate(2131562583, r12, false);
        int r0 = 2131368782;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131368782);
        if (r5 == null) goto L18;
        r0 = 2131369197;
        View r6 = ViewBindings.findChildViewById(r14, 2131369197);
        if (r6 == null) goto L18;
        r0 = 2131379858;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131379858);
        if (r7 == null) goto L18;
        r0 = 2131379873;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r14, 2131379873);
        if (r8 == null) goto L18;
        r0 = 2131379874;
        View r9 = ViewBindings.findChildViewById(r14, 2131379874);
        if (r9 == null) goto L18;
        r0 = 2131388525;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r14, 2131388525);
        if (r10 == null) goto L18;
        return new ChatLtmNormalHolder(new LarusItemLtmListBinding(r14, r5, r6, r7, r8, r9, r10), this.a);
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    L20:
        if (r13 != ChatLtmBaseHolder.Companion.ChatItemViewType.TITLE.getValue()) goto L31;
        View r15 = LayoutInflater.from(r12.getContext()).inflate(2131562584, r12, false);
        int r1 = 2131379227;
        if (ViewBindings.findChildViewById(r15, 2131379227) == null) goto L29;
        r1 = 2131379228;
        ItemTextToggle r2 = ViewBindings.findChildViewById(r15, 2131379228);
        if (r2 == null) goto L29;
        r1 = 2131379231;
        UrlSpanTextView r3 = ViewBindings.findChildViewById(r15, 2131379231);
        if (r3 == null) goto L29;
        return new ChatLtmTitleHolder(new LarusItemLtmTitleBinding((LinearLayout) r15, r2, r3), this.a);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r1)));
    L31:
        return new ChatLtmEmptyHolder(r12);
    }
}
