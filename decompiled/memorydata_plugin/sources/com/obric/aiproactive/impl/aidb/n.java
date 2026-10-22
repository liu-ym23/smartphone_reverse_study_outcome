package com.obric.aiproactive.impl.aidb;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/DefaultAiProactiveFeedbackReporter;", "Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReporter;", "<init>", "()V", "appendEvent", "", "logId", "", "relatedType", "", "relatedInfo", "feedbackType", "feedbackReason", "feedbackText", "feedbackSource", "feedbackValue", "onResult", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f6367b = null;

    static {
        f6367b = new n();
    }

    private n() {
    }

    private static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r3) == false) goto L5;
        r3 = AppContext.INSTANCE.getUserId();
    L5:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        return g.f6361a.a(r4);
    }

    public static /* synthetic */ boolean lambda$jmO2X4mw7r9thT4F9MxdOIxAt8g(String r0) {
        return a(r0);
    }

    @Override // com.obric.aiproactive.impl.aidb.h
    public void a(String r13, int r14, String r15, Integer r16, String r17, String r18, String r19, Integer r20, Function1<? super Boolean, Unit> r21) {
        Function1<? super Boolean, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "logId");
        com.obric.aiproactive.api.q.f6270a.a(r13, r14, r15, r16, r17, r18, r19, r20, $$Lambda$n$jmO2X4mw7r9thT4F9MxdOIxAt8g.INSTANCE, r11);
    }
}
