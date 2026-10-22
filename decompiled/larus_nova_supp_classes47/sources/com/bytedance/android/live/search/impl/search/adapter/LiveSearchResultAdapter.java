package com.bytedance.android.live.search.impl.search.adapter;

import am2.t;
import am2.x;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.search.impl.search.b;
import com.bytedance.android.live.search.impl.search.g;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import j40.b4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ju2.f;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pa1.d;
import qa1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqa1/e;", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "activity", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements e {
    public final List<ra1.a> a;
    public String b;
    public final Activity c;
    public final b d;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final Activity getActivity() {
        return this.c;
    }

    public final void D0(int r8) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        if (r8 >= ((ArrayList) this.a).size()) goto L13;
        String r0 = ((ra1.a) ListProtector.get(this.a, r8)).a();
        Room r1 = ((ra1.a) ListProtector.get(this.a, r8)).b();
        if (r1 == null) goto L14;
        int r2 = g.a;
        String r3 = this.b;
        String r4 = String.valueOf(r1.id);
        String r5 = r1.getRequestId();
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        JsonObject r6 = ((ra1.a) ListProtector.get(this.a, r8)).b;
        Intrinsics.checkNotNullParameter(r3, "keyword");
        Intrinsics.checkNotNullParameter(r0, "groupId");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "imprId");
        Intrinsics.checkNotNullParameter(r6, "logPb");
        HashMap r7 = new HashMap();
        r7.put("log_pb", r6.toString());
        r7.put("impr_id", r5);
        r7.put("search_keyword", r3);
        r7.put("rank", String.valueOf(r8));
        r7.put("is_aladdin", DataType.FALSE);
        r7.put("token_type", "live_ing");
        r7.put("enter_from", "live_square");
        r7.put("search_result_id", r0);
        r7.put("live_id", r4);
        u.l().e("search_result_click", r7, new Object[]{t.class});
        return;
    L14:
        return;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r13) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        super.onViewAttachedToWindow(r13);
        int r14 = r13.getAdapterPosition();
        if (r14 >= 0) goto L5;
        return;
    L5:
        if (r14 >= ((ArrayList) this.a).size()) goto L64;
        String r0 = ((ra1.a) ListProtector.get(this.a, r14)).a();
        Room r1 = ((ra1.a) ListProtector.get(this.a, r14)).b();
        if (r1 == null) goto L65;
        User r2 = r1.getOwner();
        if (r2 == null) goto L12;
        String r3 = r2.getIdStr();
        if (r3 == null) goto L12;
    L13:
        HashMap r4 = new HashMap();
        r4.put("enter_from_merge", "general_search");
        r4.put("enter_method", "drawer_cover");
        r4.put("anchor_id", r3);
        r4.put("room_id", String.valueOf(r1.id));
        String r5 = r1.getRequestId();
        String r6 = "";
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r4.put("request_id", r5);
        r4.put("action_type", "click");
        b r7 = this.d;
        if (r7 == null) goto L20;
        String r8 = r7.f;
        if (r8 == null) goto L20;
    L21:
        r4.put("previous_page", r8);
        r4.put("search_result_id", r0);
        String r9 = r1.getRequestId();
        if (r9 != null) goto L24;
        r9 = "";
    L24:
        r4.put("search_id", r9);
        if (r1.isReplay == false) goto L27;
        String r10 = DataType.TRUE;
    L28:
        r4.put("is_live_recall", r10);
        LiveMode r12 = r1.getStreamType();
        int r15 = h1.a;
        r4.put("live_type", i1.a(r12));
        r4.put("vr_type", String.valueOf(r1.getVRType()));
        r4.putAll(h1.a(r1));
        if (r1.isMergeVSRoom() == false) goto L38;
        LiveVSLog.r.getClass();
        r4.putAll(LiveVSLog.b.a(r1).a());
        if (this.c.getRequestedOrientation() != 0) goto L33;
    L36:
        String r16 = "landscape";
    L37:
        r4.put("vs_screen_type", r16);
        goto L38
    L33:
        if (this.c.getRequestedOrientation() == 6) goto L36;
        r16 = "portrait";
    L38:
        JSONObject r17 = new JSONObject();
        String r18 = r1.getRequestId();     // Catch: Exception -> L44
        if (r18 != null) goto L42;
        r18 = "";
    L42:
        r17.put("search_id", r18);     // Catch: Exception -> L44
        r17.put("search_result_id", r0);     // Catch: Exception -> L44
    L45:
        String r19 = r17.toString();
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        r4.put("search_params", r19);
        int r20 = ArgumentsBuilder.getRoomType(r1);
        if (r20 != VSConstants.VS_LIVE) goto L51;
    L54:
        int r22 = f.M;
        f r23 = f.a.a(r1);
        com.bytedance.android.livesdk.vs.f.c.c("live_show", r4, new Object[]{r23});
    L55:
        int r24 = g.a;
        String r25 = this.b;
        String r26 = String.valueOf(r1.id);
        String r27 = r1.getRequestId();
        if (r27 == null) goto L59;
        r6 = r27;
    L59:
        JsonObject r28 = ((ra1.a) ListProtector.get(this.a, r14)).b;
        Intrinsics.checkNotNullParameter(r25, "keyword");
        Intrinsics.checkNotNullParameter(r0, "groupId");
        Intrinsics.checkNotNullParameter(r26, "roomId");
        Intrinsics.checkNotNullParameter(r6, "imprId");
        Intrinsics.checkNotNullParameter(r28, "logPb");
        HashMap r29 = new HashMap();
        r29.put("log_pb", r28.toString());
        r29.put("impr_id", r6);
        r29.put("search_keyword", r25);
        r29.put("enter_from", "live_square");
        r29.put("rank", String.valueOf(r14));
        r29.put("is_aladdin", DataType.FALSE);
        r29.put("token_type", "live_ing");
        r29.put("search_result_id", r0);
        r29.put("live_id", r26);
        u.l().e("search_result_show", r29, new Object[]{t.class});
        return;
    L51:
        if (r20 == VSConstants.VS_FIRST_SHOW) goto L54;
        u.l().sendLog("livesdk_live_show", r4, new Object[]{t.class, x.class, PadLoggerData.class});
        goto L55
    L27:
        r10 = DataType.FALSE;
    L20:
        r8 = "live_merge";
    L12:
        r3 = DataType.FALSE;
        goto L13
    L65:
        return;
    }

    public LiveSearchResultAdapter(FragmentActivity r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.c = r2;
        this.d = r3;
        this.a = new ArrayList();
        this.b = "";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 >= ((ArrayList) this.a).size()) goto L11;
        ra1.a r0 = (ra1.a) ListProtector.get(this.a, r4);
        if ((r3 instanceof LiveSearchViewHolder) == false) goto L12;
        LiveSearchViewHolder r5 = (LiveSearchViewHolder) r3;
        r5.T3(r0.b(), r4);
        String r6 = r0.a();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "groupId");
        return;
    L12:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r0 = LiveSearchViewHolder.t;
        Intrinsics.checkNotNullParameter(r4, "parent");
        boolean r1 = false;
        if (b4.a() == false) goto L5;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131567423, r4, false);
    L6:
        LiveSearchViewHolder r2 = new LiveSearchViewHolder(r6, r4);
        b r7 = this.d;
        r2.m = r7;
        r2.l = this;
        if (r7 == null) goto L20;
        d r8 = r7.a;
        if (r8 == null) goto L20;
        if (r8.getContainerWidth() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L20;
        r2.n = (r8.getContainerWidth() / 2) - 9;
        goto L20
    L13:
        r3 = false;
    L20:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == false) goto L23;
        r1 = e5.n();
    L23:
        if (r1 == false) goto L25;
        r2.p.a();
        r2.n = s1.f(126.0f);
        r2.q = true;
    L25:
        return r2;
    L5:
        r6 = LayoutInflater.from(r4.getContext()).inflate(2131567422, r4, false);
        goto L6
    }

    public final void y2(List r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "rooms");
        Intrinsics.checkNotNullParameter(r7, "searchKeyWord");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r6);
        this.b = r7;
        notifyDataSetChanged();
        b r8 = this.d;
        if (r8 == null) goto L14;
        List<ra1.a> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Room r3 = ((ra1.a) r2.next()).b();
        if (r3 == null) goto L10;
        Long r4 = Long.valueOf(r3.id);
    L11:
        if (r4 == null) goto L6;
        r1.add(r4);
        goto L6
    L10:
        r4 = null;
        goto L11
    L13:
        r8.b = CollectionsKt.toLongArray(r1);
    L14:
        b r9 = this.d;
        if (r9 == null) goto L21;
        List<ra1.a> r5 = this.a;
        ArrayList r10 = new ArrayList();
        Iterator r12 = ((ArrayList) r5).iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        r10.add(Integer.valueOf(ArgumentsBuilder.getRoomType(((ra1.a) r12.next()).b())));
        goto L18
    L20:
        r9.c = CollectionsKt.toIntArray(r10);
    L21:
        b r13 = this.d;
        if (r13 == null) goto L37;
        List<ra1.a> r14 = this.a;
        ArrayList r15 = new ArrayList();
        Iterator r16 = ((ArrayList) r14).iterator();
    L25:
        if (r16.hasNext() == false) goto L32;
        Room r17 = ((ra1.a) r16.next()).b();
        if (r17 == null) goto L29;
        String r18 = r17.getRequestId();
    L30:
        if (r18 == null) goto L25;
        r15.add(r18);
        goto L25
    L29:
        r18 = null;
        goto L30
    L32:
        Object[] r19 = r15.toArray(new String[0]);
        if (r19 == null) goto L36;
        r13.d = (String[]) r19;
        goto L37
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L37:
        b r20 = this.d;
        if (r20 == null) goto L48;
        List<ra1.a> r22 = this.a;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = ((ArrayList) r22).iterator();
    L41:
        if (r24.hasNext() == false) goto L43;
        r23.add(((ra1.a) r24.next()).a());
        goto L41
    L43:
        Object[] r25 = r23.toArray(new String[0]);
        if (r25 == null) goto L47;
        r20.e = (String[]) r25;
        return;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
