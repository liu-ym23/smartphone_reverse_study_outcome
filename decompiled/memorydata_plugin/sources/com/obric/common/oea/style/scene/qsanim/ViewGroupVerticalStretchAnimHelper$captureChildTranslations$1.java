package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import com.obric.common.oea.foundation.animation.c.e;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "childId", "", "child", "Landroid/view/View;", "<anonymous parameter 2>", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$captureChildTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ a this$0;

    ViewGroupVerticalStretchAnimHelper$captureChildTranslations$1(a r1) {
        this.this$0 = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r4, View r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "childId");
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        float r7 = r5.getTranslationY();
        if (a.a(this.this$0).isEmpty() == false) goto L5;
        a.b(this.this$0).put(r4, Float.valueOf(r7));
    L5:
        e r0 = (e) ZeusTransformUtils.preCheckCast(a.c(this.this$0).get(r4), e.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.c() == false) goto L10;
        r0.b();
        r5.setTranslationY(r7);
        a.a(this.this$0).put(r4, Float.valueOf(r7));
        return;
    L10:
        a.a(this.this$0).remove(r4);
    }
}
