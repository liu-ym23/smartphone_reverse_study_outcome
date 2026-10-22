package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0014\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchRankTabColumn;", "Landroid/widget/LinearLayout;", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals$GroupType;", "Landroid/widget/TextView;", "pair", "", "setupOnClickListener", "", "tabTypes", "setupTabs", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchRankTabColumn$a;", "listener", "setOnPageSelectListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchRankTabColumn extends LinearLayout {
    public final List<Pair<IGroupRivals.GroupType, TextView>> a;
    public IGroupRivals.GroupType b;
    public a c;

    public interface a {
        void a(IGroupRivals.GroupType r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PKRivalsSearchRankTabColumn a;
        public final /* synthetic */ Pair b;

        public b(PKRivalsSearchRankTabColumn r1, Pair r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a((IGroupRivals.GroupType) this.b.getFirst());
        }
    }

    public PKRivalsSearchRankTabColumn(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new ArrayList();
        setBackgroundResource(2131108569);
    }

    private final void setupOnClickListener(Pair<? extends IGroupRivals.GroupType, ? extends TextView> r3) {
        ((TextView) r3.getSecond()).setOnClickListener(new b(this, r3));
    }

    public final void a(IGroupRivals.GroupType r8) {
        Intrinsics.checkNotNullParameter(r8, "type");
        List<Pair<IGroupRivals.GroupType, TextView>> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (((IGroupRivals.GroupType) ((Pair) r1.next()).getFirst()) != r8) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L19;
        return;
    L19:
        if (this.b != r8) goto L21;
        return;
    L21:
        this.b = r8;
        Iterator<T> r4 = this.a.iterator();
    L23:
        if (r4.hasNext() == false) goto L33;
        Pair r5 = (Pair) r4.next();
        if (((IGroupRivals.GroupType) r5.getFirst()) != r8) goto L27;
        boolean r6 = true;
    L28:
        Resources r7 = getResources();
        if (r6 == false) goto L31;
        int r9 = 2131108027;
    L32:
        int r10 = r7.getColor(r9);
        ((TextView) r5.getSecond()).setSelected(r6);
        ((TextView) r5.getSecond()).setTextColor(r10);
        goto L23
    L31:
        r9 = 2131108028;
        goto L32
    L27:
        r6 = false;
        goto L28
    L33:
        a r12 = this.c;
        if (r12 == null) goto L45;
        r12.a(r8);
        return;
    L45:
        return;
    L13:
        r2 = false;
    L6:
        r3 = false;
        goto L16
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    public final void setOnPageSelectListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void setupTabs(List<? extends IGroupRivals.GroupType> r8) {
        Intrinsics.checkNotNullParameter(r8, "tabTypes");
        ((ArrayList) this.a).clear();
        removeAllViews();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L29;
        IGroupRivals.GroupType r0 = (IGroupRivals.GroupType) r9.next();
        boolean r2 = true;
        int r3 = 0;
        if (getChildCount() != 0) goto L8;
        boolean r1 = true;
    L9:
        TextView r4 = new TextView(getContext());
        List<Pair<IGroupRivals.GroupType, TextView>> r5 = this.a;
        if ((r5 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L13;
        if (((IGroupRivals.GroupType) ((Pair) r6.next()).getFirst()) != r0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L16;
    L22:
        if (r2 == true) goto L23;
        addView(r4);
        Pair<? extends IGroupRivals.GroupType, ? extends TextView> r10 = TuplesKt.to(r0, r4);
        ((ArrayList) this.a).add(r10);
        if (r1 == true) goto L28;
        r3 = UtilityKotlinExtentionsKt.i(16);
    L28:
        a1.m(r4, r3);
        setupOnClickListener(r10);
        goto L4
    L23:
        return;
    L20:
        r7 = false;
    L13:
        r2 = false;
        goto L22
    L12:
        if (r5.isEmpty() == false) goto L14;
    L8:
        r1 = false;
        goto L9
    }

    public PKRivalsSearchRankTabColumn(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new ArrayList();
        setBackgroundResource(2131108569);
    }

    public final void b(IGroupRivals.GroupType r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "title");
        List<Pair<IGroupRivals.GroupType, TextView>> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L11;
        Object r4 = r2.next();
        if (r6 == ((IGroupRivals.GroupType) ((Pair) r4).getFirst())) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L11:
        Iterator r8 = CollectionsKt.take(r1, 1).iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        ((TextView) ((Pair) r8.next()).getSecond()).setText(r7);
        goto L13
    }

    public PKRivalsSearchRankTabColumn(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        setBackgroundResource(2131108569);
    }
}
