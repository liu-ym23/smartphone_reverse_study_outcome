package com.obric.aiproactive.ui.progress;

import android.text.TextPaint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AgentRunStepAdapter$StepHolder$bindActivityChildren$markerColumnWidth$1 extends FunctionReferenceImpl implements Function1<String, Float> {
    AgentRunStepAdapter$StepHolder$bindActivityChildren$markerColumnWidth$1(Object r8) {
        super(1, r8, TextPaint.class, "measureText", "measureText(Ljava/lang/String;)F", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Float invoke2(String r3) {
        return Float.valueOf(((TextPaint) ZeusTransformUtils.preCheckCast(this.receiver, TextPaint.class, "com.obric.memorydata.plugin")).measureText(r3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Float invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
