package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.chatroom.ui.FastScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001*\u0018\u00002\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J+\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002J\u001c\u0010\u000e\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ)\u0010\u0012\u001a\u00020\u00072!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\u0002R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u001bR\u001b\u0010$\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010-¨\u00068"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView;", "Lcom/bytedance/android/livesdk/chatroom/ui/FastScrollRecyclerView;", "Lkotlin/Function1;", "Lme/drakeet/multitype/MultiTypeAdapter;", "Lkotlin/ParameterName;", "name", "ktvCommonSongListAdapter", "", "customItemViewBinderAction", "setCustomItemViewBinderAction", "Lme/drakeet/multitype/b;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "commonSongListViewBinder", "setCommonSongListItemViewBinder", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/t;", "loadState", "handleLoadMoreAction", "setHandleLoadMoreAction", "b", "Lkotlin/Lazy;", "getLoadMoreState", "()Lcom/bytedance/android/live/ktv/common/karaokestation/model/t;", "loadMoreState", "", "c", "getMusicList", "()Ljava/util/List;", "musicList", "", "d", "getData", "data", "g", "getCommonSongListAdapter", "()Lme/drakeet/multitype/MultiTypeAdapter;", "commonSongListAdapter", "Lcom/bytedance/android/livesdk/chatroom/ui/SSLinearLayoutManager;", "h", "getCommonSongListLayoutManager", "()Lcom/bytedance/android/livesdk/chatroom/ui/SSLinearLayoutManager;", "commonSongListLayoutManager", "com/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView$commonSongListScrollListener$2$1", "i", "getCommonSongListScrollListener", "()Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView$commonSongListScrollListener$2$1;", "commonSongListScrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DiffCallback", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSongListView extends FastScrollRecyclerView {
    public me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public Function1<? super MultiTypeAdapter, Unit> e;
    public Function1<? super t, Unit> f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListView$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<Object> a;
        public final List<Object> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<? extends Object> r2, List<? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldList");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r5, int r6) {
            if (r5 != r6) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L8;
            return false;
        L8:
            Object r7 = ListProtector.get(this.a, r5);
            Object r8 = ListProtector.get(this.b, r6);
            if (Intrinsics.areEqual(r7.getClass(), r8.getClass()) == true) goto L12;
            return false;
        L12:
            if ((r7 instanceof MusicPanel) == false) goto L25;
            if ((r8 instanceof MusicPanel) == false) goto L25;
            MusicPanel r9 = (MusicPanel) r7;
            MusicPanel r11 = (MusicPanel) r8;
            if (r9.a.isSameForDiffUpdate(r11.a) == true) goto L18;
        L22:
            return false;
        L18:
            if (r9.b != r11.b) goto L22;
            if (r9.k != r11.k) goto L22;
            return true;
        L25:
            if ((r7 instanceof LabelBannerUrl) == false) goto L31;
            if ((r8 instanceof LabelBannerUrl) == false) goto L31;
            return Intrinsics.areEqual(r7, r8);
        L31:
            if ((r7 instanceof z0) == false) goto L44;
            if ((r8 instanceof z0) == false) goto L44;
            z0 r12 = (z0) r7;
            KtvMusic r3 = r12.b();
            if (r3 == null) goto L41;
            z0 r13 = (z0) r8;
            if (r3.isSameKtvMusic(r13.b()) != true) goto L41;
            if (Intrinsics.areEqual(r12.a(), r13.a()) == false) goto L41;
            return true;
        L41:
            return false;
        L44:
            if ((r7 instanceof com.bytedance.android.live.ktv.common.model.bean.d) == false) goto L50;
            if ((r8 instanceof com.bytedance.android.live.ktv.common.model.bean.d) == false) goto L50;
            return Intrinsics.areEqual(r7, r8);
        L50:
            return Intrinsics.areEqual(r7.getClass(), r8.getClass());
        L5:
            r2 = false;
            goto L6
        }

        public final boolean areItemsTheSame(int r4, int r5) {
            if (r4 != r5) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L8;
            return false;
        L8:
            Object r6 = ListProtector.get(this.a, r4);
            Object r7 = ListProtector.get(this.b, r5);
            if (Intrinsics.areEqual(r6.getClass(), r7.getClass()) == true) goto L11;
            return false;
        L11:
            return true;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ CommonSongListView a;
        public final /* synthetic */ List b;

        public a(CommonSongListView r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(SingleEmitter<DiffUtil.DiffResult> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            r4.onSuccess(DiffUtil.calculateDiff(new DiffCallback(CommonSongListView.t(this.a), this.b)));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CommonSongListView a;
        public final /* synthetic */ List b;

        public b(CommonSongListView r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            DiffUtil.DiffResult r4 = (DiffUtil.DiffResult) r3;
            Intrinsics.checkNotNullParameter(r4, "diffResult");
            CommonSongListView.t(this.a).clear();
            CommonSongListView.t(this.a).addAll(this.b);
            r4.dispatchUpdatesTo(CommonSongListView.r(this.a));
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public CommonSongListView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonSongListView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final MultiTypeAdapter getCommonSongListAdapter() {
        return (MultiTypeAdapter) this.g.getValue();
    }

    private final SSLinearLayoutManager getCommonSongListLayoutManager() {
        return (SSLinearLayoutManager) this.h.getValue();
    }

    private final CommonSongListView$commonSongListScrollListener$2.AnonymousClass1 getCommonSongListScrollListener() {
        return (CommonSongListView$commonSongListScrollListener$2.AnonymousClass1) this.i.getValue();
    }

    private final List<Object> getData() {
        return (List) this.d.getValue();
    }

    private final t getLoadMoreState() {
        return (t) this.b.getValue();
    }

    private final List<MusicPanel> getMusicList() {
        return (List) this.c.getValue();
    }

    public final void v() {
        me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> r0 = this.a;
        if (r0 == null) goto L5;
        getCommonSongListAdapter().z2(MusicPanel.class, r0);
    L5:
        Function1<? super MultiTypeAdapter, Unit> r1 = this.e;
        if (r1 == null) goto L8;
        Unit r2 = (Unit) r1.invoke(getCommonSongListAdapter());
    L8:
        setAdapter(getCommonSongListAdapter());
        setLayoutManager(getCommonSongListLayoutManager());
        addOnScrollListener(getCommonSongListScrollListener());
    }

    public static final /* synthetic */ MultiTypeAdapter r(CommonSongListView r0) {
        return r0.getCommonSongListAdapter();
    }

    public static final /* synthetic */ List t(CommonSongListView r0) {
        return r0.getData();
    }

    public final void setCommonSongListItemViewBinder(me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> r1) {
        this.a = r1;
    }

    public final void setCustomItemViewBinderAction(Function1<? super MultiTypeAdapter, Unit> r1) {
        this.e = r1;
    }

    public final void setHandleLoadMoreAction(Function1<? super t, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handleLoadMoreAction");
        this.f = r2;
    }

    public static final void u(CommonSongListView r2, RecyclerView r3) {
        r2.getClass();
        if (r3.canScrollVertically(1) == false) goto L5;
        return;
    L5:
        if (r2.getLoadMoreState().a == false) goto L7;
        return;
    L7:
        if ((r3.getLayoutManager() instanceof LinearLayoutManager) == false) goto L19;
        LinearLayoutManager r4 = r3.getLayoutManager();
        if (r4 == null) goto L16;
        LinearLayoutManager r5 = r4;
        if (r5.findLastVisibleItemPosition() < (r5.getItemCount() - 1)) goto L20;
        r2.getLoadMoreState().a = true;
        Function1<? super t, Unit> r6 = r2.f;
        if (r6 == null) goto L21;
        Unit r7 = (Unit) r6.invoke(r2.getLoadMoreState());
        return;
    L21:
        return;
    L20:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void w(y r4, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "songListData");
        Intrinsics.checkNotNullParameter(r5, "fillAdapterData");
        getMusicList().clear();
        List<MusicPanel> r0 = r4.h;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(MusicPanel.a((MusicPanel) r2.next()));
        goto L4
    L6:
        getMusicList().addAll(r1);
        if (((Boolean) KtvSettingHelper.w0.getValue()).booleanValue() == false) goto L9;
        ArrayList r3 = new ArrayList();
        r5.invoke(getMusicList(), r3, r4);
        Single.create(new a(this, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r3), c.a);
        return;
    L9:
        getData().clear();
        r5.invoke(getMusicList(), getData(), r4);
        getCommonSongListAdapter().A2(getData());
        getCommonSongListAdapter().notifyDataSetChanged();
    }

    public CommonSongListView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(CommonSongListView$loadMoreState$2.INSTANCE);
        this.c = LazyKt.lazy(CommonSongListView$musicList$2.INSTANCE);
        this.d = LazyKt.lazy(CommonSongListView$data$2.INSTANCE);
        this.g = LazyKt.lazy(new CommonSongListView$commonSongListAdapter$2(this));
        this.h = LazyKt.lazy(new CommonSongListView$commonSongListLayoutManager$2(r2));
        this.i = LazyKt.lazy(new CommonSongListView$commonSongListScrollListener$2(this));
    }

    public /* synthetic */ CommonSongListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
