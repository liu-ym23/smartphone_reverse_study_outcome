package com.obric.memorydata.memory.ui;

import com.obric.oui.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/OuiViewPagerInputController;", "Lcom/obric/memorydata/memory/ui/ViewPagerInputController;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "<init>", "(Lcom/obric/oui/viewpager2/widget/ViewPager2;)V", "setUserInputEnabled", "", "enabled", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class j implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPager2 f10969a;

    public j(ViewPager2 r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        this.f10969a = r2;
    }

    @Override // com.obric.memorydata.memory.ui.n
    public void a(boolean r1) {
        this.f10969a.setUserInputEnabled(r1);
    }
}
