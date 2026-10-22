package com.obric.assistant.settings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.impl.databinding.ItemObricLocalDataSearchSelectBinding;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LocalDataSearchSelectFragment {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/LocalDataSearchSelectFragment$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/settings/LocalDataSearchSelectFragment$ViewHolder;", "data", "", "Lcom/obric/assistant/settings/SelectableToggleItem;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Adapter extends RecyclerView.Adapter<ViewHolder> {
        public final List<SelectableToggleItem> a;

        public final int getItemCount() {
            return this.a.size();
        }

        public Adapter(List<SelectableToggleItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            ViewHolder r6 = (ViewHolder) r4;
            Intrinsics.checkNotNullParameter(r6, "holder");
            OCardListItem r7 = r6.a.a;
            final SelectableToggleItem r8 = (SelectableToggleItem) ListProtector.get(this.a, r5);
            r7.setCardType(0);
            r7.p(false);
            r7.setTitle(r8.b);
            r7.s(true);
            String r2 = r8.c;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r7.setSubTitle(r2);
            String r3 = r8.c;
            if (r3 != null) goto L8;
        L13:
            boolean r9 = false;
        L14:
            r7.q(r9);
            r7.setDefaultCustomEndView(1);
            r7.m(true);
            r7.r(false);
            OCardListItem.h(r7, 0);
            r7.setOnContentClickListener(null);
            OSwitch r1 = r7.getEndSwitch();
            if (r1 == null) goto L17;
            r1.setOnCheckedChangeListener(null);
        L17:
            r7.setSelected(r8.d);
            if (r1 == null) goto L20;
            r1.setChecked(r8.d);
        L20:
            if (r1 == null) goto L23;
            r1.setOnCheckedChangeListener(new q(r8));
            return;
        L23:
            return;
        L8:
            if (r3.length() <= 0) goto L10;
            boolean r10 = true;
        L11:
            if (r10 != true) goto L13;
            r9 = true;
            goto L14
        L10:
            r10 = false;
            goto L11
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            return new ViewHolder(ItemObricLocalDataSearchSelectBinding.a(com.larus.utils.e1.m(r1), r1));
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/settings/LocalDataSearchSelectFragment$Decoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "dividerHeight", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Decoration extends RecyclerView.ItemDecoration {
        public final Paint a;
        public final int b;

        public Decoration(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Paint r0 = new Paint();
            this.a = r0;
            this.b = i5.a();
            r0.setColor(r3.getResources().getColor(2131103685));
        }

        public final void onDraw(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
            Intrinsics.checkNotNullParameter(r12, "c");
            Intrinsics.checkNotNullParameter(r13, "parent");
            Intrinsics.checkNotNullParameter(r14, "state");
            int r15 = r13.getPaddingLeft() + i5.h();
            int r0 = (r13.getWidth() - r13.getPaddingRight()) - i5.h();
            int r1 = r13.getChildCount() - 1;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            View r3 = r13.getChildAt(r2);
            RecyclerView.LayoutParams r4 = r3.getLayoutParams();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int r5 = r3.getBottom() + ((ViewGroup.MarginLayoutParams) r4).bottomMargin;
            r12.drawRect(r15, r5, r0, this.b + r5, this.a);
            r2 = r2 + 1;
            goto L3
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.set(0, 0, 0, this.b);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/settings/LocalDataSearchSelectFragment$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricLocalDataSearchSelectBinding;", "<init>", "(Lcom/obric/assistant/impl/databinding/ItemObricLocalDataSearchSelectBinding;)V", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricLocalDataSearchSelectBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ItemObricLocalDataSearchSelectBinding a;

        public ViewHolder(ItemObricLocalDataSearchSelectBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    static {
    }
}
