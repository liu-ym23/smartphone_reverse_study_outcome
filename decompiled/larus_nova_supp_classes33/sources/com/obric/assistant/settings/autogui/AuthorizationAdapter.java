package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.lisitem.OCardListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B)\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/settings/autogui/AuthorizationAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/autogui/AuthorizationRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "saveStoredValue", "Lkotlin/Function2;", "Lcom/obric/assistant/settings/autogui/AuthorizationItem;", "", "", "isObricOS", "<init>", "(Lkotlin/jvm/functions/Function2;Z)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorizationAdapter extends ListAdapter<c, RecyclerView.ViewHolder> {
    public static final AuthorizationAdapter$Companion$diffCallback$1 c = null;
    public final Function2<com.obric.assistant.settings.autogui.a, Boolean, Unit> a;
    public final boolean b;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.autogui.AuthorizationAdapter$Companion$diffCallback$1] */
    static {
        c = new AuthorizationAdapter$Companion$diffCallback$1();
    }

    public final int getItemViewType(int r2) {
        c r3 = (c) getItem(r2);
        if ((r3 instanceof c.a) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof c.b) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthorizationAdapter(Function2<? super com.obric.assistant.settings.autogui.a, ? super Boolean, Unit> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "saveStoredValue");
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        c r8 = (c) getItem(r7);
        final b1 r2 = null;
        x0 r3 = null;
        if ((r8 instanceof c.a) == false) goto L10;
        if ((r6 instanceof x0) == false) goto L7;
        r3 = (x0) r6;
    L7:
        if (r3 == null) goto L25;
        c.a r9 = (c.a) r8;
        Intrinsics.checkNotNullParameter(r9, "row");
        r3.a.setText(r9.a);
        return;
    L25:
        return;
    L10:
        if ((r8 instanceof c.b) == false) goto L24;
        if ((r6 instanceof b1) == false) goto L14;
        r2 = (b1) r6;
    L14:
        if (r2 == null) goto L27;
        c.b r10 = (c.b) r8;
        Intrinsics.checkNotNullParameter(r10, "row");
        com.obric.assistant.settings.autogui.a r11 = r10.a;
        int r1 = 0;
        r2.c.setCardType(0);
        r2.c.p(false);
        r2.c.setTitle(r11.b);
        r2.c.s(true);
        r2.c.setSubTitle("");
        r2.c.q(false);
        r2.c.setDefaultCustomEndView(1);
        r2.c.m(true);
        r2.c.r(false);
        OCardListItem.h(r2.c, r10.c);
        if (r2.b == true) goto L18;
        int r0 = rda.a.a;
        rda.a.a(r2.c, r10.c);
    L18:
        r2.d.setText(r11.c);
        TextView r4 = r2.d;
        if (StringsKt.isBlank(r11.c) == false) goto L21;
        r1 = 8;
    L21:
        r4.setVisibility(r1);
        r2.d.setMaxLines(5);
        r2.T3(r10);
        r2.c.setOnContentClickListener(new z0(r2));
        return;
    L27:
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        LayoutInflater r0 = LayoutInflater.from(r6.getContext());
        if (r7 != 1) goto L5;
        RecyclerView.ViewHolder r8 = new x0(r0.inflate(2131561638, r6, false));
    L10:
        return r8;
    L5:
        if (r7 == 2) goto L7;
        final View r9 = new View(r6.getContext());
        return new AnonymousClass1(r9);
    L7:
        Context r3 = r6.getContext();
        OCardListItem r10 = r0.inflate(2131561636, r6, false);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        r8 = new b1(new y0(r3, r10), this.a, this.b);
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.contains("payload_checked_changed") == false) goto L15;
        Object r0 = getItem(r5);
        b1 r2 = null;
        if ((r0 instanceof c.b) == false) goto L7;
        c.b r1 = (c.b) r0;
    L9:
        if ((r4 instanceof b1) == false) goto L11;
        r2 = (b1) r4;
    L11:
        if (r1 == null) goto L15;
        if (r2 == null) goto L15;
        r2.T3(r1);
        return;
    L7:
        r1 = null;
    L15:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r4, r5, r6);
    }
}
