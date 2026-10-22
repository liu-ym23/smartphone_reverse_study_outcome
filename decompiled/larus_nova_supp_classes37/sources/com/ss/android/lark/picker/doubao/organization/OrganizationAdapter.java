package com.ss.android.lark.picker.doubao.organization;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mtb.c;
import mtb.i;
import mtb.j;
import uz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+BC\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u001c\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemState", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "onSelect", "", "onNextLevel", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "nextLevelTitle", "", "getNextLevelTitle", "()Ljava/lang/String;", "setNextLevelTitle", "(Ljava/lang/String;)V", "isDepartmentSelectable", "", "()Z", "setDepartmentSelectable", "(Z)V", "isMultipleSelect", "setMultipleSelect", "items", "", "submit", "data", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "Companion", "DepartmentHolder", "UserHolder", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OrganizationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final int TYPE_DEPARTMENT = 1;
    private static final int TYPE_USER = 2;
    private boolean isDepartmentSelectable;
    private boolean isMultipleSelect;
    private final Function1<c, DoubaoOrganizationItemState> itemState;
    private final List<c> items;
    private String nextLevelTitle;
    private final Function1<i, Unit> onNextLevel;
    private final Function1<c, Unit> onSelect;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$Companion;", "", "<init>", "()V", "TYPE_DEPARTMENT", "", "TYPE_USER", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JV\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$DepartmentHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "checkboxContainer", "checkbox", "Landroid/widget/ImageView;", "subtitle", "bind", "", "item", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "state", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "nextLevelTitle", "", "isDepartmentSelectable", "", "isMultipleSelect", "onSelect", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "onNextLevel", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DepartmentHolder extends RecyclerView.ViewHolder {
        private final ImageView checkbox;
        private final View checkboxContainer;
        private final TextView subtitle;
        private final TextView title;

        public DepartmentHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.title = (TextView) r2.findViewById(2131381662);
            this.checkboxContainer = r2.findViewById(2131381656);
            this.checkbox = (ImageView) r2.findViewById(2131376185);
            this.subtitle = (TextView) r2.findViewById(2131381661);
        }

        public final void bind(final i r8, final DoubaoOrganizationItemState r9, String r10, boolean r11, boolean r12, final Function1<? super c, Unit> r13, final Function1<? super i, Unit> r14) {
            Intrinsics.checkNotNullParameter(r8, "item");
            Intrinsics.checkNotNullParameter(r9, "state");
            Intrinsics.checkNotNullParameter(r10, "nextLevelTitle");
            Intrinsics.checkNotNullParameter(r13, "onSelect");
            Intrinsics.checkNotNullParameter(r14, "onNextLevel");
            int r0 = 0;
            if (r12 == false) goto L6;
            if (r11 == false) goto L6;
            boolean r15 = true;
        L7:
            this.title.setText(r8.a);
            this.subtitle.setText(r10);
            View r16 = this.checkboxContainer;
            if (r15 == true) goto L11;
            r0 = 8;
        L11:
            r16.setVisibility(r0);
            ImageView r17 = this.checkbox;
            if (r9.isSelected() == false) goto L14;
            int r18 = 2131235900;
        L15:
            r17.setImageResource(r18);
            this.checkbox.setEnabled(r9.isEnabled());
            ImageView r19 = this.checkbox;
            float r1 = 1.0f;
            if (r9.isEnabled() == false) goto L18;
            float r110 = 1.0f;
        L19:
            r19.setAlpha(r110);
            TextView r111 = this.subtitle;
            if (r15 == true) goto L22;
        L24:
            r111.setAlpha(r1);
            final boolean r2 = r15;
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new OrganizationAdapter$DepartmentHolder$bind$1(r2, r9, r13, r8, r14));
            this.subtitle.setOnClickListener(new OrganizationAdapter$DepartmentHolder$bind$2(r2, r9, this, r14, r8));
            return;
        L22:
            if (r9.isSelected() == false) goto L24;
            r1 = 0.4f;
            goto L24
        L18:
            r110 = 0.4f;
            goto L19
        L14:
            r18 = 2131235901;
        L6:
            r15 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$UserHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "checkboxContainer", "checkbox", "Landroid/widget/ImageView;", "avatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "bind", "", "item", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuUserItem;", "state", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "isMultipleSelect", "", "onSelect", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class UserHolder extends RecyclerView.ViewHolder {
        private final LarkAvatarView avatar;
        private final ImageView checkbox;
        private final View checkboxContainer;
        private final TextView title;

        public UserHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.title = (TextView) r2.findViewById(2131381662);
            this.checkboxContainer = r2.findViewById(2131381656);
            this.checkbox = (ImageView) r2.findViewById(2131376185);
            this.avatar = r2.findViewById(2131381668);
        }

        public final void bind(final j r3, DoubaoOrganizationItemState r4, boolean r5, final Function1<? super c, Unit> r6) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "state");
            Intrinsics.checkNotNullParameter(r6, "onSelect");
            this.title.setText(r3.a);
            View r0 = this.checkboxContainer;
            if (r5 == false) goto L5;
            int r7 = 0;
        L6:
            r0.setVisibility(r7);
            ImageView r8 = this.checkbox;
            if (r4.isSelected() == false) goto L9;
            int r1 = 2131235900;
        L10:
            r8.setImageResource(r1);
            this.checkbox.setEnabled(r4.isEnabled());
            View r9 = ((RecyclerView.ViewHolder) this).itemView;
            if (r4.isEnabled() == false) goto L13;
            float r10 = 1.0f;
        L14:
            r9.setAlpha(r10);
            LarkAvatarView r11 = this.avatar;
            a.a r12 = new a.a();
            r12.b(r3.c);
            r12.f(r3.b);
            r11.j(new a(r12));
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new OrganizationAdapter$UserHolder$bind$1(r6, r3));
            return;
        L13:
            r10 = 0.4f;
            goto L14
        L9:
            r1 = 2131235901;
            goto L10
        L5:
            r7 = 8;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public final String getNextLevelTitle() {
        return this.nextLevelTitle;
    }

    public final boolean isDepartmentSelectable() {
        return this.isDepartmentSelectable;
    }

    public final boolean isMultipleSelect() {
        return this.isMultipleSelect;
    }

    public int getItemViewType(int r2) {
        c r3 = (c) ListProtector.get(this.items, r2);
        if ((r3 instanceof i) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof j) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void setDepartmentSelectable(boolean r1) {
        this.isDepartmentSelectable = r1;
    }

    public final void setMultipleSelect(boolean r1) {
        this.isMultipleSelect = r1;
    }

    public final void setNextLevelTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.nextLevelTitle = r2;
    }

    public final void submit(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        c r12 = (c) ListProtector.get(this.items, r11);
        if ((r10 instanceof DepartmentHolder) == false) goto L8;
        if ((r12 instanceof i) == false) goto L8;
        ((DepartmentHolder) r10).bind((i) r12, (DoubaoOrganizationItemState) this.itemState.invoke(r12), this.nextLevelTitle, this.isDepartmentSelectable, this.isMultipleSelect, this.onSelect, this.onNextLevel);
        return;
    L8:
        if ((r10 instanceof UserHolder) == true) goto L10;
        return;
    L10:
        if ((r12 instanceof j) == false) goto L15;
        ((UserHolder) r10).bind((j) r12, (DoubaoOrganizationItemState) this.itemState.invoke(r12), this.isMultipleSelect, this.onSelect);
        return;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 1) goto L6;
        return new DepartmentHolder(r0.inflate(2131561589, r4, false));
    L6:
        return new UserHolder(r0.inflate(2131561590, r4, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrganizationAdapter(Function1<? super c, DoubaoOrganizationItemState> r2, Function1<? super c, Unit> r3, Function1<? super i, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "itemState");
        Intrinsics.checkNotNullParameter(r3, "onSelect");
        Intrinsics.checkNotNullParameter(r4, "onNextLevel");
        this.itemState = r2;
        this.onSelect = r3;
        this.onNextLevel = r4;
        this.nextLevelTitle = "";
        this.items = new ArrayList();
    }
}
