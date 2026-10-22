package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.livesdk.chatroom.ui.FastScrollRecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/BaseSecondLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/c;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseSecondLevelTabFragment extends BaseTabFragment implements c {
    public static final /* synthetic */ int m = 0;
    public final boolean e;
    public final long f;
    public CommonSongListView g;
    public KtvCommonEmptyView h;
    public Function0<Unit> i;
    public boolean j;
    public y k;
    public com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b l;

    public static final class a implements d {
        public a() {
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void a() {
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void b() {
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void c() {
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void d(MusicPanel r2, CommonSongListItemViewHolder.b r3) {
            Intrinsics.checkNotNullParameter(r2, "musicPanel");
            Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void e() {
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void f(MusicPanel r2, CommonSongListItemViewHolder.b r3) {
            Intrinsics.checkNotNullParameter(r2, "musicPanel");
            Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        }

        @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.d
        public final void g() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseSecondLevelTabFragment a;

        public b(BaseSecondLevelTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseSecondLevelTabFragment r0 = this.a;     // Catch: Throwable -> L7
            int r1 = BaseSecondLevelTabFragment.m;     // Catch: Throwable -> L7
            Function0<Unit> r2 = r0.i;     // Catch: Throwable -> L7
            if (r2 != null) goto L5;
            r0.ok(r0.k, r0.ms(null));     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            Unit r3 = (Unit) r2.invoke();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public void O0() {
    }

    public Function1<MultiTypeAdapter, Unit> U90() {
        return null;
    }

    public void W90() {
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public String Ms() {
        return this.k.c;
    }

    public me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> T90() {
        return new com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.a(new a());
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initData() {
        CommonSongListView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setHandleLoadMoreAction(V90());
    L5:
        CommonSongListView r1 = this.g;
        if (r1 == null) goto L8;
        r1.setCommonSongListItemViewBinder(T90());
    L8:
        CommonSongListView r2 = this.g;
        if (r2 == null) goto L11;
        r2.setCustomItemViewBinderAction(U90());
    L11:
        CommonSongListView r3 = this.g;
        if (r3 == null) goto L14;
        r3.v();
    L14:
        this.j = true;
        if (this.e == false) goto L17;
        i0.c().postDelayed(new b(this), this.f);
        return;
    L17:
        Function0<Unit> r4 = this.i;
        if (r4 != null) goto L20;
        ok(this.k, ms(null));
        return;
    L20:
        Unit r5 = (Unit) r4.invoke();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.j = false;
    }

    public Function1<t, Unit> V90() {
        return BaseSecondLevelTabFragment$getHandleLoadMoreAction$1.INSTANCE;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final boolean yf() {
        return this.j;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void W30(Function0<Unit> r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public Function3<List<MusicPanel>, List<Object>, y, Unit> ms(List<? extends Object> r1) {
        return IBaseSecondLevelTab$getFillAdapterDataAction$1.INSTANCE;
    }

    public BaseSecondLevelTabFragment(y r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        this.k = r2;
        this.l = r3;
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L5;
        boolean r4 = true;
    L6:
        this.e = !r4;
        this.f = ((Number) h.y1.getValue(null, h.a[127(0x7f, float:1.78E-43)])).longValue();
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public void ok(y r5, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r6, "fillAdapterDataAction");
        if (this.g != null) goto L6;
        return;
    L6:
        if (r5.h.isEmpty() == true) goto L8;
    L16:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.l;
        if (r0 == null) goto L23;
        Pair<Integer, UpdateTabType> r1 = r0.getSelectedFirstLevelTabValue();
        if (r1 == null) goto L23;
        Integer r2 = (Integer) r1.getFirst();
        if (r2 == null) goto L23;
        int r3 = r2.intValue();
    L24:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = this.l;
        if (r4 == null) goto L30;
        y r7 = r4.getSelectedSecondLevelTabData(r3);
        if (r7 == null) goto L30;
        String r8 = r7.c;
        if (r8 == null) goto L30;
    L32:
        if (r3 == r5.k) goto L34;
        boolean r9 = true;
    L35:
        boolean r11 = !Intrinsics.areEqual(r8, r5.c);
        if (this.e == false) goto L41;
        if (r9 == true) goto L39;
        if (r11 == false) goto L41;
        return;
    L39:
        return;
    L41:
        if ((!r5.h.isEmpty()) == false) goto L43;
    L44:
        KtvCommonEmptyView r12 = this.h;
        if (r12 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r12);
    L47:
        FastScrollRecyclerView r13 = this.g;
        if (r13 == null) goto L50;
        UtilityKotlinExtentionsKt.w(r13);
    L50:
        CommonSongListView r14 = this.g;
        if (r14 == null) goto L53;
        r14.w(r5, r6);
    L53:
        W90();
        return;
    L43:
        if (this.k.i.isEmpty() == false) goto L44;
        return;
    L34:
        r9 = false;
    L30:
        r8 = "";
    L23:
        r3 = FirstLevelTab.Unknown.getValue();
        goto L24
    L8:
        if (this.k.i.isEmpty() == false) goto L16;
        KtvCommonEmptyView r15 = this.h;
        if (r15 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r15);
    L12:
        FastScrollRecyclerView r16 = this.g;
        if (r16 == null) goto L55;
        UtilityKotlinExtentionsKt.t(r16);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public void rs(SecondLevelTabViewSelectedType r1, y r2) {
        Intrinsics.checkNotNullParameter(r1, "secondLevelTabViewSelectedType");
        Intrinsics.checkNotNullParameter(r1, "secondLevelTabViewSelectedType");
    }
}
