package com.bytedance.android.live.broadcastgame.opengame.panel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/broadcastgame/opengame/panel/ShowTipsHelper;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class FullScreenOpenPanel$showTipsHelper$2 extends Lambda implements Function0<ShowTipsHelper> {
    final /* synthetic */ FullScreenOpenPanel this$0;

    public FullScreenOpenPanel$showTipsHelper$2(FullScreenOpenPanel r1) {
        this.this$0 = r1;
        super(0);
    }

    public final ShowTipsHelper invoke() {
        return new ShowTipsHelper(this.this$0.w, new AnonymousClass1(this), new AnonymousClass2(this));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m267invoke() {
        return invoke();
    }
}
