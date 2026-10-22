package com.bytedance.ies.argus.api.params;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Lkotlin/Pair;", "Lcom/bytedance/ies/argus/api/params/WebLoadRiskTag;", "Lcom/bytedance/ies/argus/api/params/WebLoadVerifySource;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class WebLoadUrlParams$toMonitorObject$1$2 extends Lambda implements Function1<Pair<? extends WebLoadRiskTag, ? extends WebLoadVerifySource>, CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebLoadUrlParams$toMonitorObject$1$2 f4979a = null;

    static {
        f4979a = new WebLoadUrlParams$toMonitorObject$1$2();
    }

    public WebLoadUrlParams$toMonitorObject$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Pair<? extends WebLoadRiskTag, ? extends WebLoadVerifySource> r5) {
        Pair<? extends WebLoadRiskTag, ? extends WebLoadVerifySource> r10 = r5;
        return r10.getFirst().f4974a + '#' + r10.getSecond().f4982a;
    }
}
