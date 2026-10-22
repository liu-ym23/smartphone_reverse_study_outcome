package com.obric.flow.cardlistpage.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/flow/cardlistpage/data/HeaderWidgetCardModel;", "Lcom/obric/flow/cardlistpage/data/WidgetCardModel;", "spanX", "", "height", "(II)V", "getHeight", "()I", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeaderWidgetCardModel extends WidgetCardModel {
    private final int height;

    public /* synthetic */ HeaderWidgetCardModel(int r5, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = -1;
    L5:
        this(r5, r10);
    }

    public final int getHeight() {
        return this.height;
    }

    public HeaderWidgetCardModel(int r14, int r15) {
        super("header_widget_fixed_id", "-100", r14, 1, "", "", true, null, Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
        this.height = r15;
    }
}
