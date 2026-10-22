package com.larus.business.markdown.impl.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper$CutStrategy;", "", "DoubleCut", "LeftCut", "RightCut", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final enum MarkdownMultiWidgetHelper$CutStrategy extends Enum<MarkdownMultiWidgetHelper$CutStrategy> {
    public static final MarkdownMultiWidgetHelper$CutStrategy DoubleCut = null;
    public static final MarkdownMultiWidgetHelper$CutStrategy LeftCut = null;
    public static final MarkdownMultiWidgetHelper$CutStrategy RightCut = null;
    public static final /* synthetic */ MarkdownMultiWidgetHelper$CutStrategy[] a = null;

    public static MarkdownMultiWidgetHelper$CutStrategy valueOf(String r1) {
        return (MarkdownMultiWidgetHelper$CutStrategy) a.a(MarkdownMultiWidgetHelper$CutStrategy.class, r1);
    }

    public static MarkdownMultiWidgetHelper$CutStrategy[] values() {
        return (MarkdownMultiWidgetHelper$CutStrategy[]) a.clone();
    }

    static {
        MarkdownMultiWidgetHelper$CutStrategy r0 = new MarkdownMultiWidgetHelper$CutStrategy("DoubleCut", 0);
        DoubleCut = r0;
        MarkdownMultiWidgetHelper$CutStrategy r1 = new MarkdownMultiWidgetHelper$CutStrategy("LeftCut", 1);
        LeftCut = r1;
        MarkdownMultiWidgetHelper$CutStrategy r3 = new MarkdownMultiWidgetHelper$CutStrategy("RightCut", 2);
        RightCut = r3;
        a = new MarkdownMultiWidgetHelper$CutStrategy[]{r0, r1, r3};
    }

    public MarkdownMultiWidgetHelper$CutStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
