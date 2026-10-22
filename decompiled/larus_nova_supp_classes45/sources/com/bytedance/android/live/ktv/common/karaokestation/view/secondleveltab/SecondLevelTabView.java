package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J-\u0010\f\u001a\u00020\u00052%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J+\u0010\u0011\u001a\u00020\u00052#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/SecondLevelTabView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;", "secondLevelTabDataList", "", "setDataAndNotify", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "secondLevelTabData", "tabSelectedAction", "setTabSelectedAction", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/ktv/common/commonui/CustomViewTab;", "createCustomViewTabAction", "setCreateCustomViewTabAction", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "setSecondLevelTabItemDecoration", "", "a", "Lkotlin/Lazy;", "getSecondLevelTabList", "()Ljava/util/List;", "secondLevelTabList", "Lme/drakeet/multitype/MultiTypeAdapter;", "d", "getSecondLevelTabAdapter", "()Lme/drakeet/multitype/MultiTypeAdapter;", "secondLevelTabAdapter", "Lcom/bytedance/android/livesdk/chatroom/ui/SSLinearLayoutManager;", "e", "getSecondLevelTabLayoutManager", "()Lcom/bytedance/android/livesdk/chatroom/ui/SSLinearLayoutManager;", "secondLevelTabLayoutManager", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SecondLevelTabView extends RecyclerView {
    public final Lazy a;
    public Function1<? super y, Unit> b;
    public Function1<? super Context, CustomViewTab> c;
    public final Lazy d;
    public final Lazy e;
    public RecyclerView.ItemDecoration f;

    public static final class a implements Runnable {
        public final /* synthetic */ SecondLevelTabView a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.SecondLevelTabView$a$a, reason: collision with other inner class name */
        public static final class RunnableC0207a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0207a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a;     // Catch: Throwable -> L8
                RecyclerView.ViewHolder r1 = r0.a.findViewHolderForAdapterPosition(r0.b);     // Catch: Throwable -> L8
                if (r1 == null) goto L11;
                View r2 = r1.itemView;     // Catch: Throwable -> L8
                if (r2 == null) goto L15;
                r2.requestFocus();     // Catch: Throwable -> L8
                r2.setFocusable(true);     // Catch: Throwable -> L8
                r2.setFocusableInTouchMode(true);     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public a(SecondLevelTabView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.smoothScrollToPosition(this.b);     // Catch: Throwable -> L4
            this.a.postDelayed(new RunnableC0207a(this), 100);     // Catch: Throwable -> L4
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
        public final /* synthetic */ SecondLevelTabView a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView.ViewHolder r0 = this.a.a.findViewHolderForAdapterPosition(0);     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                View r1 = r0.itemView;     // Catch: Throwable -> L8
                if (r1 == null) goto L15;
                r1.requestFocus();     // Catch: Throwable -> L8
                r1.setFocusable(true);     // Catch: Throwable -> L8
                r1.setFocusableInTouchMode(true);     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public b(SecondLevelTabView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.smoothScrollToPosition(0);     // Catch: Throwable -> L4
            this.a.postDelayed(new a(this), 100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SecondLevelTabView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SecondLevelTabView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final MultiTypeAdapter getSecondLevelTabAdapter() {
        return (MultiTypeAdapter) this.d.getValue();
    }

    private final SSLinearLayoutManager getSecondLevelTabLayoutManager() {
        return (SSLinearLayoutManager) this.e.getValue();
    }

    private final List<y> getSecondLevelTabList() {
        return (List) this.a.getValue();
    }

    public final void r() {
        Function1<? super Context, CustomViewTab> r0 = this.c;
        if (r0 == null) goto L5;
        getSecondLevelTabAdapter().z2(y.class, new e(r0, this.b));
    L5:
        setLayoutManager(getSecondLevelTabLayoutManager());
        addItemDecoration(this.f);
        setNestedScrollingEnabled(false);
        setAdapter(getSecondLevelTabAdapter());
    }

    public final void setCreateCustomViewTabAction(Function1<? super Context, CustomViewTab> r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDataAndNotify(List<y> r8) {
        Intrinsics.checkNotNullParameter(r8, "secondLevelTabDataList");
        Iterator<T> r0 = getSecondLevelTabList().iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((y) r1).j == false) goto L3;
    L9:
        y r3 = (y) r1;
        getSecondLevelTabList().clear();
        List<y> r4 = r8;
        getSecondLevelTabList().addAll(r4);
        getSecondLevelTabAdapter().A2(getSecondLevelTabList());
        if (r3 == null) goto L18;
        Iterator<T> r5 = r8.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        y r7 = (y) r6;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "compareData");
        if (Intrinsics.areEqual(r7.c, r3.c) == false) goto L13;
        r2 = r6;
    L17:
        y r9 = (y) r2;
    L25:
        if (r9 == null) goto L27;
        int r11 = r8.indexOf(r9);
    L28:
        getSecondLevelTabAdapter().notifyDataSetChanged();
        if (((Boolean) KtvSettingHelper.x1.getValue()).booleanValue() == true) goto L31;
        return;
    L31:
        if (r11 < 0) goto L36;
        postDelayed(new a(this, r11), 100);
        Function1<? super y, Unit> r12 = this.b;
        if (r12 == null) goto L51;
        Unit r13 = (Unit) r12.invoke(ListProtector.get(r8, r11));
        return;
    L51:
        return;
    L36:
        if ((!r4.isEmpty()) == false) goto L53;
        postDelayed(new b(this), 100);
        Function1<? super y, Unit> r14 = this.b;
        if (r14 == null) goto L54;
        Unit r15 = (Unit) r14.invoke(ListProtector.get(r8, 0));
        return;
    L54:
        return;
    L53:
        return;
    L27:
        r11 = -1;
        goto L28
    L18:
        Iterator<T> r16 = r8.iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        Object r17 = r16.next();
        if (((y) r17).j == false) goto L20;
        r2 = r17;
    L24:
        r9 = (y) r2;
        goto L25
    L8:
        r1 = null;
        goto L9
    }

    public final void setSecondLevelTabItemDecoration(RecyclerView.ItemDecoration r2) {
        Intrinsics.checkNotNullParameter(r2, "itemDecoration");
        this.f = r2;
    }

    public final void setTabSelectedAction(Function1<? super y, Unit> r1) {
        this.b = r1;
    }

    public SecondLevelTabView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(SecondLevelTabView$secondLevelTabList$2.INSTANCE);
        this.d = LazyKt.lazy(SecondLevelTabView$secondLevelTabAdapter$2.INSTANCE);
        this.e = LazyKt.lazy(new SecondLevelTabView$secondLevelTabLayoutManager$2(r2));
        this.f = new SecondLevelTabView$secondLevelTabItemDecoration$1();
    }

    public /* synthetic */ SecondLevelTabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
