package com.larus.business.markdown.impl.widget;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MarkdownMultiWidgetHelper$generateMarkdownWidget$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $currentParentViewGroup;

    public MarkdownMultiWidgetHelper$generateMarkdownWidget$1(ViewGroup r1) {
        this.$currentParentViewGroup = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m104invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m104invoke() {
        this.$currentParentViewGroup.removeAllViews();
    }
}
