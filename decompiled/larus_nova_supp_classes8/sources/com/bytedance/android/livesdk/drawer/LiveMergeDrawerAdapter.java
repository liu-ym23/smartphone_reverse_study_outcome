package com.bytedance.android.livesdk.drawer;

import am2.x;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import df6.q;
import df6.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerViewHolder;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMergeDrawerAdapter extends RecyclerView.Adapter<LiveMergeDrawerViewHolder> {
    public static final /* synthetic */ int i = 0;
    public final List<Room> a;
    public int b;
    public int c;
    public final float d;
    public int e;
    public final RecyclerView f;
    public final CenterScrollLayoutManager g;
    public final MergeDrawerViewModel h;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r9) {
        LiveMergeDrawerViewHolder r10 = (LiveMergeDrawerViewHolder) r9;
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewAttachedToWindow(r10);
        r10.getClass();
        o r0 = u.l().c(x.class);
        String r2 = "";
        if (r0 == null) goto L8;
        Map r3 = r0.getMap();
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("enter_from_merge");
        if (r4 == null) goto L8;
    L10:
        if (r0 == null) goto L15;
        Map r1 = r0.getMap();
        if (r1 == null) goto L15;
        String r5 = (String) r1.get("enter_method");
        if (r5 == null) goto L15;
    L16:
        LinkedHashMap r6 = new LinkedHashMap();
        Room r7 = r10.f;
        if (r7 == null) goto L22;
        User r8 = r7.getOwner();
        if (r8 == null) goto L22;
        String r11 = r8.getIdString();
        if (r11 == null) goto L22;
    L23:
        r6.put("anchor_id", r11);
        Room r12 = r10.f;
        if (r12 == null) goto L27;
        String r13 = r12.getIdStr();
        if (r13 == null) goto L27;
    L28:
        r6.put("room_id", r13);
        r6.put("enter_from_merge", r4);
        r6.put("enter_method", r5);
        MergeDrawerViewModel r14 = r10.g;
        if (r14 != null) goto L31;
    L33:
        r6.put("action_type", "click");
        Room r15 = r10.f;
        if (r15 == null) goto L38;
        String r16 = r15.getRequestId();
        if (r16 == null) goto L38;
    L39:
        r6.put("request_id", r16);
        Room r17 = r10.f;
        if (r17 == null) goto L45;
        String r18 = r17.getLog_pb();
        if (r18 == null) goto L45;
        r2 = r18;
    L45:
        r6.put("log_pb", r2);
        u.l().sendLog("livesdk_live_show", r6, new Object[0]);
        u.l().sendLog("livesdk_live_cover_info", r6, new Object[0]);
        return;
    L38:
        r16 = "";
        goto L39
    L31:
        if (r14.isSimilarRoom() != true) goto L33;
        r6.put("is_similar", "1");
    L27:
        r13 = "";
    L22:
        r11 = "";
    L15:
        r5 = "";
    L8:
        r4 = "";
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        LiveMergeDrawerViewHolder r8 = (LiveMergeDrawerViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Room r0 = (Room) ListProtector.get(this.a, r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "room");
        r8.f = r0;
        q.b(new r(new r.a(s1.getContext())));
        r8.d.setText(r0.getTitle());
        TextView r1 = r8.e;
        StringBuilder r2 = new StringBuilder("@");
        User r3 = r0.getOwner();
        List r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getRemarkNameOrRealNickName();
    L6:
        r2.append(r5);
        r1.setText(r2.toString());
        r8.b.setVisibility(8);
        k r9 = r0.getCover();
        if (r9 == null) goto L9;
        r4 = r9.getUrls();
    L9:
        df6.u r10 = q.c(new ef6.a(r4));
        r10.t = r8.a;
        r10.c();
        UtilityKotlinExtentionsKt.t(r8.c);
        UtilityKotlinExtentionsKt.t(r8.b);
        r8.c.pauseAnimation();
        r8.g = this.h;
        if (r7 != this.b) goto L13;
        r8.T3();
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r0 = LiveMergeDrawerViewHolder.h;
        Intrinsics.checkNotNullParameter(r4, "parent");
        LiveMergeDrawerViewHolder r6 = new LiveMergeDrawerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131565641, r4, false));
        r6.a.setOnClickListener(new ut1.o(r6, this));
        return r6;
    }

    public LiveMergeDrawerAdapter(FadingEdgeRecyclerview r2, CenterScrollLayoutManager r3, MergeDrawerViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = -1;
        this.c = -1;
        this.d = 135.0f;
    }
}
