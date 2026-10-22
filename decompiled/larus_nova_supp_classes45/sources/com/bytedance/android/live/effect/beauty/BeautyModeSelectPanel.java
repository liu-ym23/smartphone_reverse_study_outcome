package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.sticker.presenter.BeautyModeInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectPanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "b", "getAdapter", "()Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautyModeSelectPanel extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;

    public BeautyModeSelectPanel(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BeautyModeSelectPanel(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final BeautyModeSelectorAdapter getAdapter() {
        return (BeautyModeSelectorAdapter) this.b.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.a.getValue();
    }

    public final void R5(Map<String, BeautyModeInfo> r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "modeMap");
        Intrinsics.checkNotNullParameter(r8, "currentModeKey");
        BeautyModeSelectorAdapter r1 = getAdapter();
        Collection<BeautyModeInfo> r9 = r7.values();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        BeautyModeInfo r3 = (BeautyModeInfo) r11.next();
        r2.add(new Pair(r3.b(), r3.c()));
        goto L4
    L6:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r8, "currentModeKey");
        ((ArrayList) r1.a).clear();
        ((ArrayList) r1.a).addAll(r2);
        r1.b = r8;
        r1.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeautyModeSelectPanel(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = LazyKt.lazy(new BeautyModeSelectPanel$recyclerView$2(this));
        this.b = LazyKt.lazy(BeautyModeSelectPanel$adapter$2.INSTANCE);
        ViewGroup.inflate(r3, 2131565846, this);
        RecyclerView r6 = getRecyclerView();
        if (r6 == null) goto L5;
        LinearLayoutManager r0 = new LinearLayoutManager(r3);
        r0.setOrientation(1);
        Unit r1 = Unit.INSTANCE;
        r6.setLayoutManager(r0);
    L5:
        RecyclerView r7 = getRecyclerView();
        if (r7 == null) goto L8;
        r7.setAdapter(getAdapter());
    L8:
        RecyclerView r8 = getRecyclerView();
        if (r8 == null) goto L12;
        DividerItemDecoration r2 = new DividerItemDecoration(r3, 1);
        r2.setDrawable(new ColorDrawable(ColorProtector.parseColor("#1F161823")));
        Unit r9 = Unit.INSTANCE;
        r8.addItemDecoration(r2);
        return;
    }

    public /* synthetic */ BeautyModeSelectPanel(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
