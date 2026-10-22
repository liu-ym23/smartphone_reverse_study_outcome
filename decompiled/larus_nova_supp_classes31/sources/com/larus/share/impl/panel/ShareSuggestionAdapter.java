package com.larus.share.impl.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.share.impl.databinding.LarusShareSuggestionItemBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J&\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0016\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0007J\"\u0010 \u001a\u00020\u00102\u001a\u0010\r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000fJ\"\u0010\"\u001a\u00020\u00102\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eJ \u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/share/impl/panel/ShareSuggestionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/share/impl/panel/ShareSuggestionViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "dataList", "", "Lcom/larus/platform/model/share/ShareSuggestionItem;", "listener", "Lkotlin/Function2;", "", "", "avatarLoader", "Landroid/widget/ImageView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "getItemCount", "setData", "itemList", "", "setClickListener", "notifySelectionChanged", "setAvatarLoader", "loader", "bindSelectedState", "selected", "", "animate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareSuggestionAdapter extends RecyclerView.Adapter<ShareSuggestionViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public List<jr9.e> b;
    public Function2<? super jr9.e, ? super Integer, Unit> c;
    public Function2<? super ImageView, ? super jr9.e, Unit> d;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final Context getContext() {
        return this.a;
    }

    public ShareSuggestionAdapter(Context r1) {
        this.a = r1;
        this.b = new ArrayList();
        this.c = new n();
    }

    public final void setData(List<jr9.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.b = CollectionsKt.toMutableList(r2);
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, final int r6) {
        ShareSuggestionViewHolder r7 = (ShareSuggestionViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        final jr9.e r0 = (jr9.e) CollectionsKt.getOrNull(this.b, r6);
        TextView r1 = r7.a.b;
        if (r0 == null) goto L7;
        String r2 = r0.b;
        if (r2 == null) goto L7;
    L8:
        r1.setText(r2);
        if (r0 == null) goto L14;
        Function2<? super ImageView, ? super jr9.e, Unit> r3 = this.d;
        if (r3 == null) goto L14;
        r3.invoke(r7.a.c, r0);
    L14:
        if (r0 == null) goto L18;
        boolean r4 = true;
        if (r0.d != true) goto L18;
    L19:
        y2(r7, r4, false);
        r7.a.a.setOnClickListener(new m(this, r0, r6));
        return;
    L18:
        r4 = false;
    L7:
        r2 = "";
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131563126, r4, false);
        int r7 = 2131375867;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131375867);
        if (r0 == null) goto L11;
        r7 = 2131383228;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r6, 2131383228);
        if (r1 == null) goto L11;
        r7 = 2131385851;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131385851);
        if (r2 == null) goto L11;
        ConstraintLayout r8 = r6;
        LarusShareSuggestionItemBinding r9 = new LarusShareSuggestionItemBinding(r8, r0, r1, r2);
        r8.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        return new ShareSuggestionViewHolder(r9);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public static void y2(ShareSuggestionViewHolder r2, boolean r3, boolean r4) {
        final FrameLayout r5 = r2.a.d;
        r5.animate().cancel();
        int r0 = 0;
        if (r4 == true) goto L11;
        r5.setAlpha(1.0f);
        if (r3 == true) goto L8;
        r0 = 8;
    L8:
        r5.setVisibility(r0);
        return;
    L11:
        if (r3 == false) goto L13;
        r5.setAlpha(0.0f);
        r5.setVisibility(0);
        r5.animate().alpha(1.0f).setDuration(120).start();
        return;
    L13:
        r5.animate().alpha(0.0f).setDuration(100).withEndAction(new l(r5)).start();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        ShareSuggestionViewHolder r5 = (ShareSuggestionViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.contains("selection_changed") == false) goto L11;
        jr9.e r6 = (jr9.e) CollectionsKt.getOrNull(this.b, r3);
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        y2(r5, r7, true);
        return;
    L7:
        if (r6.d != true) goto L9;
        r7 = true;
        goto L10
    L11:
        super.onBindViewHolder(r5, r3, r4);
    }
}
