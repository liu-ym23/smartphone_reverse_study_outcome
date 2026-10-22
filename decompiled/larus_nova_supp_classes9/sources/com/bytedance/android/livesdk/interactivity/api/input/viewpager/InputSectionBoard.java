package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionBoard;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "getLayoutId", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "c", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "getViewpager", "()Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "viewpager", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "getSelectionRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "selectionRecycleView", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/c;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getSelections", "()Ljava/util/ArrayList;", "selections", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InputSectionBoard extends FrameLayout {
    public SelectionListAdapter a;
    public final InputSectionPagerAdapter b;
    public final SSViewPager c;
    public final RecyclerView d;
    public final ArrayList<c> e;

    public InputSectionBoard(Context r7) {
        this(r7, null, 0, 14, 0);
    }

    public InputSectionBoard(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 12, 0);
    }

    public InputSectionBoard(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, 8, 0);
    }

    public int getLayoutId() {
        return 2131567048;
    }

    public SelectionListAdapter b() {
        return new SelectionListAdapter(this.d, this.e);
    }

    public final RecyclerView getSelectionRecycleView() {
        return this.d;
    }

    public final ArrayList<c> getSelections() {
        return this.e;
    }

    public final SSViewPager getViewpager() {
        return this.c;
    }

    public final void a(List<b> r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        r7.size();
        UtilityKotlinExtentionsKt.w(this.d);
        List<b> r0 = r7;
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        this.e.add(((b) r2.next()).b());
        goto L7
    L9:
        final GridLayoutManager r3 = new GridLayoutManager(getContext(), r7.size());
        this.a = b();
        this.d.setLayoutManager(r3);
        this.d.setAdapter(this.a);
        InputSectionPagerAdapter r4 = this.b;
        Function2<Integer, b, Unit> r5 = new InputSectionBoard$bindData$2(this, r3);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        r4.a.add(r5);
        SelectionListAdapter r6 = this.a;
        if (r6 == null) goto L12;
        r6.a = new InputSectionBoard$bindData$3(this);
    L12:
        InputSectionPagerAdapter r8 = this.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "value");
        ((ArrayList) r8.e).clear();
        ((ArrayList) r8.e).addAll(r7);
        r8.d = 0;
        Iterator<T> r1 = r0.iterator();
        int r9 = 0;
    L14:
        if (r1.hasNext() == false) goto L19;
        Object r10 = r1.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        b r13 = (b) r10;
        r8.d++;
        r9 = r11;
        goto L14
    L19:
        r8.c = 0;
        r8.notifyDataSetChanged();
        if ((!((ArrayList) r8.e).isEmpty()) == false) goto L22;
        r8.f(r8.c);
    L22:
        SelectionListAdapter r14 = this.a;
        if (r14 == null) goto L27;
        LinkedHashSet<Integer> r15 = r14.c;
        if (r15 == null) goto L27;
        r15.add(0);
    L27:
        this.b.g.setCurrentItem(0, false);
    }

    public InputSectionBoard(Context r1, AttributeSet r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3);
        this.e = new ArrayList();
        LayoutInflater.from(r1).inflate(getLayoutId(), this, true);
        SSViewPager r5 = findViewById(2131380994);
        this.c = r5;
        this.d = findViewById(2131380995);
        this.b = new InputSectionPagerAdapter(r1, r5);
    }

    public /* synthetic */ InputSectionBoard(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3, 0);
    }
}
