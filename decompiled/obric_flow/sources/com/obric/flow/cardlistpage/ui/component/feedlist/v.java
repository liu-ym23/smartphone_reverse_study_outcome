package com.obric.flow.cardlistpage.ui.component.feedlist;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.obric.flow.cardlistpage.mvi.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11622a;

    public v() {
        this.f11622a = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
    }

    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        int r5 = b().size();
        List r10 = b();
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if ((((BaseCardModel) r12.next()) instanceof FakeWidgetCardModel) == false) goto L9;
        r11 = true;
    L14:
        return "FeedListState(cardsSize=" + r5 + ", hasFakePlaceholder=" + r11 + ")";
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    public final List b() {
        return (List) this.f11622a.getValue();
    }
}
