package com.ss.android.lark.flow.feed.long_click;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.databinding.ItemFlowMenuItemBinding;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowFeedMenuUtil {
    public static final int a = 0;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00142\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListItemViewHolder;", "context", "Landroid/content/Context;", "dismiss", "Lkotlin/Function0;", "", "actionStatusListener", "Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;", "isSidebar", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;Z)V", "feedActionMap", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionFactory;", "Lkotlin/collections/LinkedHashMap;", "feedCardData", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "subject", "Lio/reactivex/Observable;", "", "updateData", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class FeedMenuListAdapter extends RecyclerView.Adapter<FeedMenuListItemViewHolder> {
        public final Context a;
        public final Function0<Unit> b;
        public final aeb.a c;
        public final boolean d;
        public LinkedHashMap<FeedActionType, aeb.c> e;
        public UIFeedCard f;

        public final int getItemCount() {
            LinkedHashMap<FeedActionType, aeb.c> r0 = this.e;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r0 = null;
        L6:
            return r0.keySet().size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            FeedMenuListItemViewHolder r10 = (FeedMenuListItemViewHolder) r8;
            Intrinsics.checkNotNullParameter(r10, "holder");
            if (r9 >= getItemCount()) goto L40;
            LinkedHashMap<FeedActionType, aeb.c> r0 = this.e;
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r0 = null;
        L8:
            FeedActionType r1 = (FeedActionType) ListProtector.get(CollectionsKt.toList(r0.keySet()), r9);
            LinkedHashMap<FeedActionType, aeb.c> r3 = this.e;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r3 = null;
        L11:
            aeb.c r4 = r3.get(r1);
            if (r4 == null) goto L14;
            aeb.e r5 = r4.i();
        L15:
            LinkedHashMap<FeedActionType, aeb.c> r6 = this.e;
            if (r6 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r6 = null;
        L18:
            aeb.c r2 = r6.get(r1);
            if (r2 == null) goto L21;
            aeb.d r7 = r2.m();
        L22:
            if (r5 == null) goto L39;
            if (r7 == null) goto L41;
            Context r11 = this.a;
            UIFeedCard r12 = this.f;
            if (r12 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
            r12 = null;
        L28:
            Drawable r13 = UIUtils.getDrawable(r11, r5.b(r12)).mutate();
            r13.setTint(UIUtils.getColor(this.a, r5.a()));
            r10.a.c.setImageDrawable(r13);
            int r14 = UIUtils.dp2px(this.a, 20.0f);
            AppCompatImageView r15 = r10.a.c;
            ViewGroup.LayoutParams r16 = r15.getLayoutParams();
            r16.width = r14;
            r16.height = r14;
            r15.setLayoutParams(r16);
            TextView r17 = r10.a.d;
            UIFeedCard r18 = this.f;
            if (r18 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
            r18 = null;
        L31:
            r17.setText(r5.d(r18));
            int r19 = 0;
            r10.a.d.setTextSize(0, zz7.b.h(this.a, 16));
            if (this.d == true) goto L34;
            r10.a.d.setTypeface(null, 1);
        L34:
            r10.a.d.setTextColor(UIUtils.getColor(this.a, r5.a()));
            LinearLayout r20 = r10.a.b;
            if (r9 != (getItemCount() - 1)) goto L37;
            r19 = 8;
        L37:
            r20.setVisibility(r19);
            r10.a.a.setOnClickListener(new f(this, r7));
            return;
        L41:
            return;
        L39:
            return;
        L21:
            r7 = null;
            goto L22
        L14:
            r5 = null;
            goto L15
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131561604, r4, false);
            int r7 = 2131379909;
            LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131379909);
            if (r0 == null) goto L11;
            r7 = 2131379912;
            AppCompatImageView r1 = ViewBindings.findChildViewById(r6, 2131379912);
            if (r1 == null) goto L11;
            r7 = 2131379921;
            TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131379921);
            if (r2 == null) goto L11;
            return new FeedMenuListItemViewHolder(new ItemFlowMenuItemBinding((RelativeLayout) r6, r0, r1, r2));
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
        }

        public FeedMenuListAdapter(Context r2, Function0<Unit> r3, aeb.a r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "dismiss");
            Intrinsics.checkNotNullParameter(r4, "actionStatusListener");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;", "<init>", "(Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class FeedMenuListItemViewHolder extends RecyclerView.ViewHolder {
        public final ItemFlowMenuItemBinding a;

        public FeedMenuListItemViewHolder(ItemFlowMenuItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    static {
        a = UIHelper.dp2px(7.0f);
    }
}
