package com.larus.community.impl.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.share.ShareScene;
import com.larus.platform.service.z2;
import hq9.v1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/community/impl/share/CreationShareImagePagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "creationImageShareModel", "Lcom/larus/platform/model/creation/CreationImageShareModel;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Lcom/larus/platform/model/creation/CreationImageShareModel;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "activeHolders", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "destroy", "releaseHolder", "getItemViewType", "getItemCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareImagePagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final sq9.j a;
    public final LifecycleCoroutineScope b;
    public final Set<RecyclerView.ViewHolder> c;

    public final int getItemViewType(int r1) {
        if (r1 != 0) goto L4;
        return 1;
    L4:
        return 0;
    }

    public final int getItemCount() {
        String r0 = this.a.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L19;
        v1 r3 = z2.a.getCreationShareSettings().a();
        if (r3 != null) goto L13;
    L15:
        if (r1 == false) goto L20;
        return 2;
    L20:
        return 1;
    L13:
        if (r3.c() != true) goto L15;
        r1 = true;
        goto L15
    L19:
        return 1;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void y2() {
        Iterator r0 = CollectionsKt.toList(this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        RecyclerView.ViewHolder r1 = (RecyclerView.ViewHolder) r0.next();
        if ((r1 instanceof SharePuzzleImageItemViewHolder) == false) goto L9;
        ((SharePuzzleImageItemViewHolder) r1).U3();
    L9:
        if ((r1 instanceof ShareSingleImageItemViewHolder) == false) goto L4;
        ((ShareSingleImageItemViewHolder) r1).U3();
        goto L4
    L11:
        this.c.clear();
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        y2();
        super.onDetachedFromRecyclerView(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewRecycled(r2);
        this.c.remove(r2);
        if ((r2 instanceof SharePuzzleImageItemViewHolder) == false) goto L6;
        ((SharePuzzleImageItemViewHolder) r2).U3();
    L6:
        if ((r2 instanceof ShareSingleImageItemViewHolder) == false) goto L9;
        ((ShareSingleImageItemViewHolder) r2).U3();
        return;
    }

    public CreationShareImagePagerAdapter(sq9.j r2, LifecycleCoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r2, "creationImageShareModel");
        Intrinsics.checkNotNullParameter(r3, "lifecycleCoroutineScope");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashSet();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "holder");
        this.c.add(r20);
        boolean r3 = true;
        if ((r20 instanceof ShareSingleImageItemViewHolder) == false) goto L18;
        ShareSingleImageItemViewHolder r2 = (ShareSingleImageItemViewHolder) r20;
        sq9.j r5 = this.a;
        String r6 = r5.b;
        Long r7 = Long.valueOf(r5.i);
        Long r8 = Long.valueOf(this.a.j);
        if (getItemCount() != 2) goto L7;
        boolean r9 = true;
    L8:
        sq9.j r10 = this.a;
        if (r10.h != ShareScene.VIDEO_VIEWER) goto L11;
        boolean r11 = true;
    L12:
        r r12 = new r(r6, r7, r8, r9, r11, r10.m);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "shareImageSingleItem");
        r2.U3();
        m r13 = new m();
        r2.j = r13;
        if (r12.d == false) goto L15;
        int r14 = r2.h;
    L16:
        r2.k = BuildersKt.launch$default(r2.a, null, null, new ShareSingleImageItemViewHolder$bind$1(r12, r2, r14, r13, null), 3, null);
        goto L18
    L15:
        r14 = r2.i;
        goto L16
    L11:
        r11 = false;
        goto L12
    L7:
        r9 = false;
    L18:
        if ((r20 instanceof SharePuzzleImageItemViewHolder) == false) goto L40;
        SharePuzzleImageItemViewHolder r1 = (SharePuzzleImageItemViewHolder) r20;
        String r15 = this.a.d;
        if (r15 != null) goto L22;
    L25:
        boolean r16 = true;
    L26:
        if (r16 == false) goto L28;
        String r17 = this.a.b;
    L29:
        String r18 = this.a.e;
        if (r18 != null) goto L32;
    L35:
        if (r3 == false) goto L37;
        String r4 = this.a.b;
    L38:
        q r22 = new q(r17, r4, Long.valueOf(this.a.i), Long.valueOf(this.a.j));
        r1.getClass();
        Intrinsics.checkNotNullParameter(r22, "shareImagePuzzleItem");
        r1.U3();
        m r23 = new m();
        r1.d = r23;
        r1.f = BuildersKt.launch$default(r1.a, null, null, new SharePuzzleImageItemViewHolder$bind$1(r22, r1, r23, null), 3, null);
        return;
    L37:
        r4 = String.valueOf(this.a.e);
        goto L38
    L32:
        if (r18.length() == 0) goto L35;
        r3 = false;
        goto L35
    L28:
        r17 = String.valueOf(this.a.d);
        goto L29
    L22:
        if (r15.length() == 0) goto L25;
        r16 = false;
        goto L26
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L6;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561978, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ShareSingleImageItemViewHolder(r5, this.b);
    L6:
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131561979, r3, false);
        Intrinsics.checkNotNull(r6);
        return new SharePuzzleImageItemViewHolder(r6, this.b);
    }
}
