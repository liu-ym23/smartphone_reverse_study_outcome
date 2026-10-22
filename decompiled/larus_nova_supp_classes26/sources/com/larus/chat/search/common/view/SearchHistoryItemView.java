package com.larus.chat.search.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.search.common.databinding.LarusItemSearchHistoryBinding;
import jz8.a;
import jz8.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/chat/search/common/view/SearchHistoryItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/chat/search/common/databinding/LarusItemSearchHistoryBinding;", "removeClickListener", "Landroid/view/View$OnClickListener;", "itemClickListener", "initAction", "", "initView", "bindText", ShareType.TEXT, "", "setOnRemoveClickListener", "listener", "setOnItemClickListener", "common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchHistoryItemView extends LinearLayout {
    public LarusItemSearchHistoryBinding a;
    public View.OnClickListener b;
    public View.OnClickListener c;

    public SearchHistoryItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        LarusItemSearchHistoryBinding r0 = this.a;
        if (r0 == null) goto L8;
        TextView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    L9:
        return;
    }

    public final void setOnItemClickListener(View.OnClickListener r1) {
        this.c = r1;
    }

    public final void setOnRemoveClickListener(View.OnClickListener r1) {
        this.b = r1;
    }

    public SearchHistoryItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LinearLayout.inflate(getContext(), 2131562648, this);
        int r4 = 2131374746;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131374746);
        if (r5 == null) goto L13;
        r4 = 2131388367;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131388367);
        if (r0 == null) goto L13;
        this.a = new LarusItemSearchHistoryBinding(this, r5, r0);
        setOnClickListener(new a(this));
        LarusItemSearchHistoryBinding r6 = this.a;
        if (r6 == null) goto L14;
        AppCompatImageView r7 = r6.b;
        if (r7 == null) goto L15;
        r7.setOnClickListener(new b(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r4)));
    }
}
