package com.larksuite.component.blockit.hashtag.list;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.larksuite.component.blockit.hashtag.widget.RecyclerSwipeAdapter;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00152\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter;", "Lcom/larksuite/component/blockit/hashtag/widget/RecyclerSwipeAdapter;", "Lcom/larksuite/component/blockit/hashtag/list/HashTagViewHolder;", "mContext", "Landroid/content/Context;", "itemClickListener", "Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter$ItemClickListener;", "isSwipeEnable", "", "isDistinguishAuthorized", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter$ItemClickListener;ZZ)V", "items", "Ljava/util/ArrayList;", "Lcom/larksuite/component/blockit/hashtag/HashTagViewData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItem", "getItemCount", "getSwipeLayoutResourceId", "resetAll", "collection", "", "ItemClickListener", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HashTagSwipeAdapter extends RecyclerSwipeAdapter<HashTagViewHolder> {
    public final Context b;
    public final a c;
    public final boolean d;
    public final boolean e;
    public final ArrayList<oy7.e> f;

    public interface a {
        void a(oy7.e r1);

        void b(oy7.e r1);
    }

    @Override // py7.a
    public final int B0() {
        return 2131387810;
    }

    public final int getItemCount() {
        return this.f.size();
    }

    public final void A2(List<oy7.e> r2) {
        this.f.clear();
        if (r2 == null) goto L5;
        this.f.addAll(r2);
    L5:
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        HashTagViewHolder r12 = (HashTagViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        oy7.e r0 = (oy7.e) ListProtector.get(this.f, r11);
        r12.c.setSwipeEnabled(this.d);
        r12.c.setShowMode(SwipeLayout.ShowMode.LayDown);
        r12.d.setOnClickListener(new h(this, r11, r0));
        if (r0.g == false) goto L5;
        r12.d.setBackgroundColor(this.b.getResources().getColor(2131103493));
    L6:
        this.a.a(((RecyclerView.ViewHolder) r12).itemView, r11);
        int r1 = LarkNameTag.d;
        Context r2 = this.b;
        Intrinsics.checkNotNullParameter(r2, "context");
        LarkNameTag.c r3 = new LarkNameTag.c(r2);
        if (r0.l == false) goto L9;
        String r4 = y9c.d.i(this.b, 2131892482);
        SpannableStringBuilder r6 = new SpannableStringBuilder(r4 + " #" + r0.c);
        r6.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(2131103456)), 0, r4.length(), 33);
        r12.a.setText(r6);
        r12.a.setTextColor(UIUtils.getColor(this.b, 2131103463));
        r12.e.setVisibility(8);
    L31:
        r3.f().c(r12.a);
        r12.b.setOnClickListener(new i(this, r11, r0));
        return;
    L9:
        r12.a.setText("#" + r0.c);
        if (r0.j != TagPermissionType.Public.value()) goto L13;
        int r5 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r7 = new com.larksuite.component.ui.tag.f.a();
        r7.b = 0;
        r7.c = 2131892498;
        r7.e = 2131103405;
        r7.g = 2131103399;
        r3.d(new com.larksuite.component.ui.tag.f(r7), true);
    L13:
        if (r0.k.length() <= 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L19;
        r12.e.setVisibility(0);
        r12.e.setText(r0.k);
    L19:
        if (this.e == true) goto L21;
        r12.a.setTextColor(UIUtils.getColor(this.b, 2131103463));
    L29:
        if (r0.d == false) goto L31;
        int r9 = com.larksuite.component.ui.tag.b.e;
        com.larksuite.component.ui.tag.b.a r13 = new com.larksuite.component.ui.tag.b.a();
        r13.b = 100;
        r13.c = 2131237545;
        r3.b(new com.larksuite.component.ui.tag.b(r13), true);
        goto L31
    L21:
        if (r0.e == false) goto L24;
        r12.a.setTextColor(UIUtils.getColor(this.b, 2131103456));
        int r14 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r15 = new com.larksuite.component.ui.tag.f.a();
        r15.b = 50;
        r15.c = 2131892485;
        r15.e = 2131103457;
        r15.g = 2131103452;
        r3.d(new com.larksuite.component.ui.tag.f(r15), true);
        goto L29
    L24:
        if (r0.f == false) goto L26;
        r12.a.setTextColor(UIUtils.getColor(this.b, 2131103463));
        goto L29
    L26:
        r12.a.setTextColor(UIUtils.getColor(this.b, 2131103456));
        int r16 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r17 = new com.larksuite.component.ui.tag.f.a();
        r17.b = 50;
        r17.c = 2131892489;
        r17.e = 2131103457;
        r17.g = 2131103452;
        r3.d(new com.larksuite.component.ui.tag.f(r17), true);
        goto L29
    L15:
        r8 = false;
        goto L16
    L5:
        r12.d.setBackgroundColor(this.b.getResources().getColor(2131103454));
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new HashTagViewHolder(LayoutInflater.from(this.b).inflate(2131561606, r4, false));
    }

    public HashTagSwipeAdapter(Context r2, a r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "itemClickListener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = new ArrayList();
    }
}
