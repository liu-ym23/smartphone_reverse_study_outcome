package com.larus.bmhome.chat.standarduikit.searchmixedmedia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.searchmixedmedia.MixedMediaAdapter;
import com.larus.bmhome.searchmixedmedia.MixedMediaDecorationGridItemDecoration;
import com.larus.bmhome.utils.z1;
import com.larus.mainbot.impl.databinding.LarusMdSearchMixedMediaBinding;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nn8.a;
import nn8.b;
import nn8.c;
import nn8.d;
import on8.i;
import pr8.e;
import pr8.f;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/searchmixedmedia/view/SearchMixedMediaView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaViewInput;", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdSearchMixedMediaBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusMdSearchMixedMediaBinding;", "binding$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/bmhome/searchmixedmedia/MixedMediaAdapter;", "viewOutput", "viewInput", "bindData", "", "input", "output", "setupTitle", "setupRecycler", "updateExpandMode", "msgExpandMode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchMixedMediaView extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public MixedMediaAdapter b;
    public f c;

    private final LarusMdSearchMixedMediaBinding getBinding() {
        return (LarusMdSearchMixedMediaBinding) this.a.getValue();
    }

    public SearchMixedMediaView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupRecycler(final e r5) {
        if (this.b != null) goto L5;
        this.b = new MixedMediaAdapter(new a(this, r5), new b(this), new c(this, r5));
        RecyclerView r0 = getBinding().b;
        r0.setLayoutManager(new GridLayoutManager(r0.getContext(), r5.b));
        r0.setAdapter(this.b);
        r0.addItemDecoration(new MixedMediaDecorationGridItemDecoration());
        Intrinsics.checkNotNull(r0);
        return;
    L5:
        GridLayoutManager r1 = getBinding().b.getLayoutManager();
        if ((r1 instanceof GridLayoutManager) == false) goto L8;
        GridLayoutManager r2 = r1;
    L9:
        if (r2 == null) goto L13;
        r2.setSpanCount(r5.b);
        return;
    L13:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void setupTitle(e r7) {
        String r0 = r7.e;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        e1.o(getBinding().d);
        return;
    L11:
        e1.x(getBinding().d);
        getBinding().d.setText(r7.e);
        we8.a.b(getBinding().d, i5.h(), false, Float.valueOf(i5.c()), null, 8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void b(ExpandCardViewMode r5) {
        Intrinsics.checkNotNullParameter(r5, "msgExpandMode");
        int r0 = (i5.E() + i5.j0()) + i5.e0();
        Lazy r1 = z1.a;
        int r2 = z1.i(0);
        if (r5 != ExpandCardViewMode.EXPAND_SHARE) goto L5;
    L12:
        int r6 = i5.n0();
        r2 = r2 - r0;
    L13:
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r2, -2);
        r3.setMargins(r6, 0, 0, 0);
        getBinding().c.setLayoutParams(r3);
        return;
    L5:
        if (r5 == ExpandCardViewMode.EXPAND_PIC) goto L12;
        if (r5 == ExpandCardViewMode.NORMAL_SHARE) goto L12;
        if (r5 == ExpandCardViewMode.NORMAL_PIC) goto L12;
        r6 = 0;
        goto L13
    }

    public SearchMixedMediaView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new d(r2, this));
    }

    public final void a(e r4, i r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "output");
        this.c = r5;
        List<pr8.c> r6 = r4.c;
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L10;
        e1.o(this);
        return;
    L10:
        e1.x(this);
        setupTitle(r4);
        setupRecycler(r4);
        b(r4.d);
        MixedMediaAdapter r8 = this.b;
        if (r8 == null) goto L15;
        List<pr8.c> r1 = r4.c;
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r4, "input");
        r8.d = r4;
        r8.submitList(r1);
        return;
    L15:
        return;
    L5:
        if (r6.size() != 0) goto L7;
        r7 = true;
        goto L8
    }
}
