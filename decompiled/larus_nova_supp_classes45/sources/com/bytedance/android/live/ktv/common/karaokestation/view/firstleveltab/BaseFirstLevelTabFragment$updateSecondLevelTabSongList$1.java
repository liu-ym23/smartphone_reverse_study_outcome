package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c $secondLevelTab;
    final /* synthetic */ y $secondLevelTabData;

    public BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1(c r1, y r2) {
        this.$secondLevelTab = r1;
        this.$secondLevelTabData = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1036invoke() {
        c r0 = this.$secondLevelTab;
        r0.ok(this.$secondLevelTabData, r0.ms(null));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1036invoke();
        return Unit.INSTANCE;
    }
}
