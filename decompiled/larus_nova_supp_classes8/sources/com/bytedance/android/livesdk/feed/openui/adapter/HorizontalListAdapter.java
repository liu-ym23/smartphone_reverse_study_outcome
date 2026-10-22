package com.bytedance.android.livesdk.feed.openui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ry.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/adapter/HorizontalListAdapter;", "Lcom/bytedance/android/live/core/paging/adapter/PagingAdapter;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class HorizontalListAdapter extends PagingAdapter<Room> {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final f d;
    public final Float e;
    public final Integer f;
    public final Function1<Room, Unit> g;
    public final String h;
    public final String i;

    public static final class a extends DiffUtil.ItemCallback<Room> {
        public a() {
        }

        public final boolean areContentsTheSame(Object r6, Object r7) {
            Room r8 = (Room) r6;
            Room r9 = (Room) r7;
            Intrinsics.checkNotNullParameter(r8, "p0");
            Intrinsics.checkNotNullParameter(r9, "p1");
            if (r8.id == r9.id) goto L5;
        L7:
            return false;
        L5:
            if (r8.getStatus() != r9.getStatus()) goto L7;
            return true;
        }

        public final boolean areItemsTheSame(Object r6, Object r7) {
            Room r8 = (Room) r6;
            Room r9 = (Room) r7;
            Intrinsics.checkNotNullParameter(r8, "p0");
            Intrinsics.checkNotNullParameter(r9, "p1");
            if (r8.id == r9.id) goto L5;
        L7:
            return false;
        L5:
            if (r8.getStatus() != r9.getStatus()) goto L7;
            return true;
        }
    }

    public final int getEmptyResId() {
        return 2131565983;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        if ((r3 instanceof FollowLiveSkyLightViewHolder) == false) goto L8;
        FollowLiveSkyLightViewHolder r4 = (FollowLiveSkyLightViewHolder) r3;
        f r0 = r4.e;
        if (r0 == null) goto L9;
        r0.startAnimation(r4.a, r4.d);
        return;
    L9:
        return;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        if ((r3 instanceof FollowLiveSkyLightViewHolder) == false) goto L8;
        FollowLiveSkyLightViewHolder r4 = (FollowLiveSkyLightViewHolder) r3;
        f r0 = r4.e;
        if (r0 == null) goto L9;
        r0.endAnimation(r4.a, r4.d);
        return;
    L9:
        return;
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        if (r3 == null) goto L4;
        Context r5 = r3.getContext();
    L6:
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r5).inflate(2131565983, r3, false));
    L4:
        r5 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ int getNormalViewType(int r1, Object r2) {
        Room r3 = (Room) r2;
        return 0;
    }

    public final RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r14, int r15) {
        if (r14 == null) goto L4;
        Context r16 = r14.getContext();
    L6:
        return new FollowLiveSkyLightViewHolder(LayoutInflater.from(r16).inflate(2131565986, r14, false), this.a, this.b, this.c, this.e, this.f, this.d, this.g, this.h, this.i);
    L4:
        r16 = null;
        goto L6
    }

    public HorizontalListAdapter(Integer r2, Integer r3, Integer r4, f r5, Float r6, Integer r7, Function1<? super Room, Unit> r8, String r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "onItemClick");
        Intrinsics.checkNotNullParameter(r9, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r10, "enterMethod");
        super(new a());
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        setSupportStatusView(r11);
    }
}
