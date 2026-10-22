package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.model.x3;
import com.bytedance.android.livesdk.log.j0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements IMiddlewareHostBusiness.AwemeQueryCallBack {
    public final /* synthetic */ VideoCommentSearchFragment a;
    public final /* synthetic */ x3 b;

    public static final class a implements Runnable {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCommentSearchFragment r0 = this.a.a;     // Catch: Throwable -> L4
            String r1 = VideoCommentSearchFragment.O;     // Catch: Throwable -> L4
            r0.W90(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCommentSearchFragment r0 = this.a.a;     // Catch: Throwable -> L4
            r0.W90(r0.J);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onSuccess(Object r1, long r2) {
    }

    public final void onBatchSuccess(HashMap<Long, Object> r14) {
        VideoCommentSearchFragment r0 = this.a;
        x3 r1 = this.b;
        ArrayList r2 = null;
        if (r1 == null) goto L5;
        Boolean r3 = r1.b();
    L6:
        r0.x = Intrinsics.areEqual(r3, Boolean.TRUE);
        MultiTypeAdapter r4 = this.a.u;
        if (r4 == null) goto L9;
        List r5 = r4.a;
    L11:
        if (TypeIntrinsics.isMutableList(r5) == true) goto L13;
        r5 = null;
    L13:
        LoadMoreScrollListener r6 = this.a.v;
        if (r6 == null) goto L16;
        r6.b = 0;
    L16:
        x3 r7 = this.b;
        long r8 = 0;
        if (r7 == null) goto L46;
        List r9 = r7.c();
        if (r9 == null) goto L46;
        if ((!r9.isEmpty()) == true) goto L24;
        r9 = null;
    L24:
        if (r9 == null) goto L46;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L27:
        if (r11.hasNext() == false) goto L47;
        Object r13 = r11.next();
        com.bytedance.android.livesdk.chatroom.model.j r15 = (com.bytedance.android.livesdk.chatroom.model.j) r13;
        if (r15 == null) goto L43;
        Long r16 = r15.i();
        if (r16 == null) goto L33;
        long r17 = r16.longValue();
    L35:
        if (r17 <= 0) goto L43;
        Long r18 = r15.d();
        if (r18 == null) goto L39;
        long r19 = r18.longValue();
    L41:
        if (r19 <= 0) goto L43;
        boolean r20 = true;
    L44:
        if (r20 == false) goto L27;
        r10.add(r13);
        goto L27
    L39:
        r19 = 0;
        goto L41
    L33:
        r17 = 0;
    L43:
        r20 = false;
    L47:
        if (r10 == null) goto L65;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r23 = r10.iterator();
    L50:
        if (r23.hasNext() == false) goto L56;
        com.bytedance.android.livesdk.chatroom.model.j r24 = (com.bytedance.android.livesdk.chatroom.model.j) r23.next();
        com.bytedance.android.livesdk.chatroom.model.l r25 = new com.bytedance.android.livesdk.chatroom.model.l();
        r25.a = r24;
        r25.b = this.a.D;
        if (r14 == null) goto L54;
        Object r26 = r14.get(r24.e());
    L55:
        r25.c = r26;
        r21.add(r25);
        goto L50
    L54:
        r26 = null;
        goto L55
    L56:
        r2 = new ArrayList();
        Iterator r110 = r21.iterator();
    L58:
        if (r110.hasNext() == false) goto L65;
        Object r27 = r110.next();
        if (((com.bytedance.android.livesdk.chatroom.model.l) r27).c == null) goto L62;
        boolean r28 = true;
    L63:
        if (r28 == false) goto L58;
        r2.add(r27);
        goto L58
    L62:
        r28 = false;
    L65:
        if (r2 == null) goto L126;
        VideoCommentSearchFragment r111 = this.a;
        int r29 = r2.size();
        Map<String, String> r112 = r111.aa0();
        r112.put("video_num", String.valueOf(r29));
        j0.l().sendLog("livesdk_video_search_result_page_show", r112, new Object[0]);
        VideoCommentSearchFragment r113 = this.a;
        if (r113.x == false) goto L74;
        r113.ha0(false);
        if (r5 == null) goto L71;
        r5.addAll(r2);
    L71:
        MultiTypeAdapter r114 = this.a.u;
        if (r114 == null) goto L83;
        r114.notifyDataSetChanged();
    L83:
        this.a.ga0(false, false);
        if (r5 == null) goto L86;
        int r115 = r5.size();
    L87:
        VideoCommentSearchFragment r30 = this.a;
        if (r30.z != 0) goto L99;
        if (r115 > 0) goto L99;
        ViewGroup r31 = r30.o;
        if (r31 == null) goto L93;
        UtilityKotlinExtentionsKt.t(r31);
    L93:
        ViewGroup r33 = r30.m;
        if (r33 == null) goto L96;
        UtilityKotlinExtentionsKt.t(r33);
    L96:
        ViewGroup r34 = r30.r;
        if (r34 == null) goto L99;
        UtilityKotlinExtentionsKt.w(r34);
    L99:
        VideoCommentSearchFragment r35 = this.a;
        if (r35.z != 0) goto L106;
        if (r115 <= 0) goto L106;
        RecyclerView r36 = r35.t;
        if (r36 == null) goto L105;
        r36.scrollToPosition(0);
    L105:
        this.a.ba0(0);
    L106:
        VideoCommentSearchFragment r37 = this.a;
        if (r37.z != 0) goto L113;
        if (r115 <= 0) goto L113;
        RecyclerView r116 = r37.t;
        if (r116 == null) goto L118;
        r116.postDelayed(new a(this), 300);
    L118:
        VideoCommentSearchFragment r117 = this.a;
        x3 r38 = this.b;
        if (r38 == null) goto L123;
        Long r39 = r38.a();
        if (r39 == null) goto L123;
        r8 = r39.longValue();
    L123:
        r117.z = r8;
        this.a.A = false;
        return;
    L113:
        if (r37.J < 0) goto L118;
        if (r115 <= 0) goto L118;
        RecyclerView r118 = r37.t;
        if (r118 == null) goto L118;
        r118.postDelayed(new b(this), 300);
        goto L118
    L86:
        r115 = 0;
        goto L87
    L74:
        LoadMoreScrollListener r40 = r113.v;
        if (r40 == null) goto L77;
        r40.b = 2;
    L77:
        r113.ha0(false);
        if (r5 == null) goto L80;
        r5.addAll(r2);
    L80:
        this.a.ea0(false, false);
        MultiTypeAdapter r119 = this.a.u;
        if (r119 == null) goto L83;
        r119.notifyDataSetChanged();
        goto L83
    L126:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.android.livesdk.chatroom.model.AwemeVideoItemInfo>");
    L46:
        r10 = null;
        goto L47
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public o(VideoCommentSearchFragment r1, x3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r6, String r7, String r8) {
        f2.b(2131915224, 0);
        VideoCommentSearchFragment r9 = this.a;
        if (r9.z == 0) goto L5;
        boolean r0 = true;
    L6:
        r9.ha0(r0);
        VideoCommentSearchFragment r10 = this.a;
        if (r10.z != 0) goto L16;
        r10.ga0(false, true);
        MultiTypeAdapter r11 = this.a.u;
        if (r11 == null) goto L13;
        List r13 = r11.a;
        if (r13 == null) goto L13;
        r13.clear();
    L13:
        MultiTypeAdapter r14 = this.a.u;
        if (r14 == null) goto L16;
        r14.notifyDataSetChanged();
    L16:
        VideoCommentSearchFragment r15 = this.a;
        LoadMoreScrollListener r16 = r15.v;
        if (r16 == null) goto L19;
        r16.b = 0;
    L19:
        r15.A = false;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
