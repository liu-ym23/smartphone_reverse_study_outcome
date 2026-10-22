package com.larus.video.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.video.impl.widget.VideoView;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2a.e;
import l2a.q;
import l2a.r;
import l2a.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J&\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020&H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/larus/video/impl/VideoDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/video/impl/TikTokVideoViewHolder;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "itemListener", "Lcom/larus/video/impl/ITikTokItemListener;", "context", "Landroid/content/Context;", "videoController", "Lcom/larus/platform/api/IVideoController;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/larus/flow/video/bean/CommonVideoModel;Lcom/larus/video/impl/ITikTokItemListener;Landroid/content/Context;Lcom/larus/platform/api/IVideoController;)V", "getItemListener", "()Lcom/larus/video/impl/ITikTokItemListener;", "getContext", "()Landroid/content/Context;", "mItems", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "afterClickCallBack", "Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;)V", "onAttachedToRecyclerView", NameKeys.UnloadStrategy_No_Strategy, "recyclerView", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "onBindViewHolder", "holder", "position", "payloads", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "onViewAttachedToWindow", "onViewDetachedFromWindow", "getItemCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDetailAdapter extends RecyclerView.Adapter<TikTokVideoViewHolder> {
    public final WeakReference<RecyclerView> a;
    public final CommonVideoModel b;
    public final e c;
    public final Context d;
    public final IVideoController e;
    public final ArrayList<MediaEntity> f;
    public VideoView.a g;

    public final int getItemCount() {
        ArrayList<MediaEntity> r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        ArrayList<MediaEntity> r2 = this.f;
        Intrinsics.checkNotNull(r2);
        return r2.size();
    L13:
        return 0;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final Context getContext() {
        return this.d;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        TikTokVideoViewHolder r3 = (TikTokVideoViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        r3.getClass();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        TikTokVideoViewHolder r3 = (TikTokVideoViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        r3.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [l2a.q] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        TikTokVideoViewHolder r6 = (TikTokVideoViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        ArrayList<MediaEntity> r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        ArrayList<MediaEntity> r2 = this.f;
        Intrinsics.checkNotNull(r2);
        r6.V3((MediaEntity) ListProtector.get(r2, r5), r5, this.c, new q(this));
        return;
    L13:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131563162, null, false);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        VideoView r6 = (VideoView) r5.findViewById(2131392404);
        if (r6 == null) goto L5;
        r6.setAfterClickCallBack(new t(this));
    L5:
        if (r6 == null) goto L7;
        r6.setDataChange(new r(this));
    L7:
        Intrinsics.checkNotNull(r5);
        return new TikTokVideoViewHolder(r5, this.b, this.e);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        TikTokVideoViewHolder r5 = (TikTokVideoViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        super.onBindViewHolder(r5, r3, r4);
        return;
    L5:
        Object r6 = ListProtector.get(r4, 0);
        if ((r6 instanceof MediaEntity) == false) goto L8;
        MediaEntity r7 = (MediaEntity) r6;
    L9:
        if (r7 == null) goto L13;
        r5.c = r7;
        return;
    L13:
        return;
    L8:
        r7 = null;
        goto L9
    }

    public VideoDetailAdapter(WeakReference<RecyclerView> r2, CommonVideoModel r3, e r4, Context r5, IVideoController r6) {
        Intrinsics.checkNotNullParameter(r2, "recyclerViewRef");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new ArrayList();
        if (r3 == null) goto L5;
        ArrayList<MediaEntity> r7 = r3.getItems();
    L6:
        this.f = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
