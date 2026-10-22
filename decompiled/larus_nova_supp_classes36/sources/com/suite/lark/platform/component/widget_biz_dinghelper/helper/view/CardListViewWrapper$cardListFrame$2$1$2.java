package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CardListViewWrapper$cardListFrame$2$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<a> $interactFeature;

    public CardListViewWrapper$cardListFrame$2$1$2(Ref.ObjectRef<a> r1) {
        this.$interactFeature = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1790invoke() {
        a r0 = (a) this.$interactFeature.element;
        if (r0 == null) goto L5;
        r0.getClass();
        r0.getClass();
    L5:
        this.$interactFeature.element = null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1790invoke();
        return Unit.INSTANCE;
    }
}
