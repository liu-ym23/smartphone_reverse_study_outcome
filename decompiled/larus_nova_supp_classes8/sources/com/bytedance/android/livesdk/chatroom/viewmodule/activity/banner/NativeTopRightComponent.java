package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NativeTopRightComponent {
    public final Handler a;
    public Runnable b;
    public NativeTopRightComponent$buildAdapter$2 c;
    public boolean d;
    public a.d e;
    public final View f;
    public final Context g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/NativeTopRightComponent$NativeActivityTopRightAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/NativeTopRightComponent$NativeActivityTopRightAdapter$ViewHolder;", "ViewHolder", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NativeActivityTopRightAdapter extends RecyclerView.Adapter<ViewHolder> {
        public final List<b1> a;
        public final NativeTopRightComponent b;
        public final String c;
        public final List<b1> d;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/NativeTopRightComponent$NativeActivityTopRightAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
        public final class ViewHolder extends RecyclerView.ViewHolder {
            public final /* synthetic */ NativeActivityTopRightAdapter a;

            public ViewHolder(NativeActivityTopRightAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.a = r2;
                super(r3);
            }
        }

        public final int getItemCount() {
            return this.d.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            ViewHolder r7 = (ViewHolder) r5;
            Intrinsics.checkNotNullParameter(r7, "holder");
            b1 r0 = (b1) ListProtector.get(this.d, r6);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, "item");
            HSImageView r1 = ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131389204);
            ImageUtil.loadImage(r1, r0.getImage(), 0);
            r1.setOnClickListener(new e(r7, r0, r6));
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566223, r3, false);
            ALogger.i("tag_banner_TOP", "native onCreateViewHolder");
            return new ViewHolder(this, r5);
        }

        public NativeActivityTopRightAdapter(List<b1> r2, NativeTopRightComponent r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.d = r2;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final Context getContext() {
        return this.g;
    }

    public NativeTopRightComponent(View r1, Context r2) {
        this.f = r1;
        this.g = r2;
        Looper r3 = Looper.myLooper();
        if (r3 == null) goto L5;
        Handler r4 = new Handler(r3);
    L6:
        this.a = r4;
        this.d = true;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
