package com.suite.lark.platform.component.milestone;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/platform/component/milestone/IMileStoneDependency;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class MileStoneModule$dependency$2 extends Lambda implements Function0<a> {
    public static final MileStoneModule$dependency$2 INSTANCE = null;

    static {
        INSTANCE = new MileStoneModule$dependency$2();
    }

    public MileStoneModule$dependency$2() {
        super(0);
    }

    public final a invoke() {
        return (a) ClaymoreServiceLoader.loadFirst(a.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1733invoke() {
        return invoke();
    }
}
