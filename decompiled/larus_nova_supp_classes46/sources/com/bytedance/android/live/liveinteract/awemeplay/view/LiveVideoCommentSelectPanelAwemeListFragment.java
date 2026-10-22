package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectPanelVideoListViewModel;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectPanelVideoListViewModelFactory;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelAwemeListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/liveinteract/awemeplay/view/l;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelAwemeListFragment extends BaseFragment implements l, View.OnClickListener {
    public static final String r = null;
    public boolean d;
    public LiveVideoCommentSelectPanelVideoListViewModel e;
    public VideoTab f;
    public LiveVideoCommentSelectAwemePanelViewModel g;
    public View h;
    public HSImageView i;
    public View j;
    public LiveDoubleColorBallAnimationView k;
    public View l;
    public RecyclerView m;
    public MultiTypeAdapter n;
    public LoadMoreScrollListener o;
    public boolean p;
    public VideoTab q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Integer c;
        public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment d;

        public b(String r1, long r2, Integer r4, LiveVideoCommentSelectPanelAwemeListFragment r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void a() {
            RecyclerView r0 = this.d.m;
            List r1 = null;
            if (r0 == null) goto L5;
            RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        L7:
            if ((r2 instanceof GridLayoutManager) == true) goto L9;
            r2 = null;
        L9:
            GridLayoutManager r3 = (GridLayoutManager) r2;
            int r4 = 0;
            if (r3 == null) goto L12;
            int r5 = r3.findFirstVisibleItemPosition();
        L13:
            RecyclerView r6 = this.d.m;
            if (r6 == null) goto L16;
            RecyclerView.LayoutManager r7 = r6.getLayoutManager();
        L18:
            if ((r7 instanceof GridLayoutManager) == true) goto L20;
            r7 = null;
        L20:
            GridLayoutManager r8 = (GridLayoutManager) r7;
            if (r8 == null) goto L23;
            int r9 = r8.findLastVisibleItemPosition();
        L24:
            MultiTypeAdapter r10 = this.d.n;
            if (r10 == null) goto L38;
            List r11 = r10.a;
            if (r11 == null) goto L38;
            if ((!r11.isEmpty()) == false) goto L31;
            r1 = r11;
        L31:
            if (r1 == null) goto L38;
            if (r9 < 0) goto L38;
            if (r9 >= r1.size()) goto L38;
            if ((ListProtector.get(r1, r9) instanceof e) == false) goto L38;
            r9 = r9 - 1;
        L38:
            int r12 = (r9 - r5) + 1;
            if (r12 < 0) goto L41;
            r4 = r12;
        L41:
            Map<Integer, String> r13 = td0.b.a;
            td0.b.a(this.a, this.b, this.c.intValue(), r4);
            return;
        L23:
            r9 = 0;
            goto L24
        L16:
            r7 = null;
            goto L18
        L12:
            r5 = 0;
            goto L13
        L5:
            r2 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        r = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_comment_empty_list_image.png";
    }

    @Override // com.bytedance.android.live.liveinteract.awemeplay.view.l
    public final sd0.a J9() {
        LiveVideoCommentSelectAwemePanelViewModel r0 = this.g;
        if (r0 == null) goto L7;
        MutableLiveData<sd0.a> r1 = r0.getSelectedAwemeVideo();
        if (r1 == null) goto L7;
        return (sd0.a) r1.getValue();
    L7:
        return null;
    }

    public final void hideLoading() {
        View r0 = this.j;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        LiveDoubleColorBallAnimationView r1 = this.k;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    public LiveVideoCommentSelectPanelAwemeListFragment() {
    }

    public final void S90(boolean r4) {
        LoadMoreScrollListener r0 = this.o;
        if (r0 == null) goto L5;
        r0.b = 0;
    L5:
        MultiTypeAdapter r1 = this.n;
        if (r1 == null) goto L8;
        List r2 = r1.a;
    L9:
        if (r2 == null) goto L24;
        List r3 = TypeIntrinsics.asMutableList(r2);
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.size() <= 0) goto L25;
        int r5 = r3.size() - 1;
        if ((ListProtector.get(r3, r5) instanceof e) == false) goto L26;
        ListProtector.remove(r3, r5);
        if (r4 == false) goto L27;
        MultiTypeAdapter r6 = this.n;
        if (r6 == null) goto L28;
        r6.notifyItemRemoved(r5);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
    L8:
        r2 = null;
        goto L9
    }

    public final void T90(VideoTab r9) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        String r3 = r1.getOwnerUserIdString();
    L8:
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L13;
        IRoom r4 = (IRoom) r2.getValue();
        if (r4 == null) goto L13;
        Long r5 = Long.valueOf(r4.getRoomId());
    L14:
        if (r3 == null) goto L38;
        if (r5 == null) goto L38;
        if (r9 == null) goto L38;
        long r6 = r5.longValue();
        Integer r7 = r9.getType();
        if (r7 == null) goto L38;
        Integer r10 = r9.getType();
        VideoTab r8 = this.f;
        if (r8 == null) goto L22;
        Integer r11 = r8.getType();
    L24:
        if (Intrinsics.areEqual(r10, r11) == false) goto L38;
        View r12 = this.h;
        if (r12 != null) goto L28;
    L30:
        View r13 = this.l;
        if (r13 != null) goto L33;
    L35:
        RecyclerView r14 = this.m;
        if (r14 == null) goto L38;
        r14.post(new b(r3, r6, r7, this));
        goto L38
    L33:
        if (r13.getVisibility() != 0) goto L35;
        Map<Integer, String> r15 = td0.b.a;
        td0.b.a(r3, r6, r7.intValue(), 0);
        goto L38
    L28:
        if (r12.getVisibility() != 0) goto L30;
        Map<Integer, String> r16 = td0.b.a;
        td0.b.a(r3, r6, r7.intValue(), 0);
        goto L38
    L22:
        r11 = null;
    L38:
        this.q = null;
        return;
    L13:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.awemeplay.view.l
    public final void ZZ(sd0.a r2) {
        LiveVideoCommentSelectAwemePanelViewModel r0 = this.g;
        if (r0 == null) goto L8;
        MutableLiveData<sd0.a> r1 = r0.getSelectedAwemeVideo();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (r4 == null) goto L4;
        Integer r5 = Integer.valueOf(r4.getId());
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.intValue() != 2131389874) goto L13;
        LiveVideoCommentSelectPanelVideoListViewModel r6 = this.e;
        if (r6 == null) goto L14;
        r6.doAction(new ud0.a.C0275a(true, false));
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r5 = null;
        goto L5
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        Serializable r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("arg_video_tab");
    L7:
        if ((r5 instanceof VideoTab) == false) goto L10;
        r0 = r5;
    L10:
        this.f = (VideoTab) r0;
        LiveVideoCommentSelectAwemePanelViewModel r6 = this.g;
        if (r6 == null) goto L15;
        MutableLiveData<sd0.a> r7 = r6.getSelectedAwemeVideo();
        if (r7 == null) goto L15;
        r7.observe(this, new f(this));
    L15:
        LiveVideoCommentSelectAwemePanelViewModel r8 = this.g;
        if (r8 == null) goto L20;
        MutableLiveData<VideoTab> r9 = r8.getSelectPageTab();
        if (r9 == null) goto L20;
        r9.observe(this, new g(this));
    L20:
        VideoTab r10 = this.f;
        if (r10 == null) goto L25;
        Integer r11 = r10.getType();
        if (r11 == null) goto L25;
        int r12 = r11.intValue();
    L26:
        LiveVideoCommentSelectPanelVideoListViewModel r13 = (LiveVideoCommentSelectPanelVideoListViewModel) ViewModelProviders.of(this, new LiveVideoCommentSelectPanelVideoListViewModelFactory(r12)).get(LiveVideoCommentSelectPanelVideoListViewModel.class);
        this.e = r13;
        if (r13 == null) goto L32;
        MutableLiveData<ud0.b> r14 = r13.getViewEvent();
        if (r14 == null) goto L33;
        r14.observe(this, new h(this));
        return;
    L33:
        return;
    L32:
        return;
    L25:
        r12 = 0;
        goto L26
    L5:
        r5 = null;
        goto L7
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        this.h = r3.findViewById(2131389870);
        HSImageView r5 = r3.findViewById(2131389871);
        this.i = r5;
        ImageLoader.bindImage(r5, r);
        HSImageView r6 = this.i;
        if (r6 == null) goto L7;
        GenericDraweeHierarchy r7 = r6.getHierarchy();
        if (r7 == null) goto L7;
        r7.setPlaceholderImage(2131253232);
    L7:
        this.j = r3.findViewById(2131389873);
        this.k = r3.findViewById(2131389872);
        this.l = r3.findViewById(2131389875);
        Button r8 = (Button) r3.findViewById(2131389874);
        if (r8 == null) goto L10;
        r8.setOnClickListener(this);
    L10:
        this.m = r3.findViewById(2131392336);
        MultiTypeAdapter r9 = new MultiTypeAdapter();
        this.n = r9;
        r9.a = new ArrayList();
        MultiTypeAdapter r10 = this.n;
        if (r10 == null) goto L13;
        r10.z2(sd0.a.class, new j(this.d, this));
    L13:
        MultiTypeAdapter r11 = this.n;
        if (r11 == null) goto L16;
        r11.z2(e.class, new i());
    L16:
        GridLayoutManager r12 = new GridLayoutManager(getContext(), 3);
        r12.setSpanSizeLookup(new LiveVideoCommentSelectPanelAwemeListFragment$initView$1(this));
        RecyclerView r13 = this.m;
        if (r13 == null) goto L19;
        r13.setLayoutManager(r12);
    L19:
        RecyclerView r14 = this.m;
        if (r14 == null) goto L22;
        r14.addItemDecoration(new LiveVideoCommentSelectPanelAwemeListFragment$initView$2());
    L22:
        RecyclerView r15 = this.m;
        if (r15 == null) goto L25;
        r15.setAdapter(this.n);
    L25:
        LoadMoreScrollListener r16 = new LoadMoreScrollListener(r12, new LiveVideoCommentSelectPanelAwemeListFragment$initView$3(this));
        this.o = r16;
        RecyclerView r17 = this.m;
        if (r17 == null) goto L28;
        r17.addOnScrollListener(r16);
    L28:
        LiveVideoCommentSelectPanelVideoListViewModel r18 = this.e;
        if (r18 == null) goto L32;
        r18.doAction(new ud0.a.C0275a(true, true));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567581, r3, false);
    }
}
