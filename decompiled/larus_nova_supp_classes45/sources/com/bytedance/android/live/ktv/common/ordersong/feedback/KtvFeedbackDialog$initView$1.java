package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.widget.Button;
import android.widget.LinearLayout;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u00110\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "select", "p2", "", "issue", "p3", "", "index", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvFeedbackDialog$initView$1 extends FunctionReferenceImpl implements Function3<Boolean, String, Integer, Unit> {
    public KtvFeedbackDialog$initView$1(KtvFeedbackDialog r8) {
        super(3, r8, KtvFeedbackDialog.class, "onItemSelected", "onItemSelected(ZLjava/lang/String;I)V", 0);
    }

    public final void invoke(boolean r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "p2");
        KtvFeedbackDialog r0 = (KtvFeedbackDialog) ((CallableReference) this).receiver;
        boolean r1 = true;
        if (r7 == true) goto L5;
        r0.l = null;
    L10:
        if (r7 == false) goto L28;
        p r4 = r0.i;
        if (r4 == null) goto L30;
        NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r5 = r4.b;
        if (r5 == null) goto L30;
        List r6 = (List) r5.getValue();
        if (r6 == null) goto L30;
        com.bytedance.android.livesdk.rank.model.b r11 = (com.bytedance.android.livesdk.rank.model.b) CollectionsKt.getOrNull(r6, r9);
        if (r11 == null) goto L30;
        List r12 = r11.getIssues();
        if (r12 != null) goto L22;
    L25:
        if (r1 == false) goto L27;
        ((KtvFeedbackComponentView) r0.X90(2131372289)).setVisibility(8);
        ((LinearLayout) r0.X90(2131375668)).setVisibility(0);
        goto L30
    L27:
        ((KtvFeedbackComponentView) r0.X90(2131372289)).setVisibility(0);
        ((LinearLayout) r0.X90(2131375668)).setVisibility(8);
        KtvFeedbackComponentView r13 = (KtvFeedbackComponentView) r0.X90(2131372289);
        List<String> r14 = r11.getIssues();
        Intrinsics.checkNotNull(r14);
        r13.setData(r14);
        goto L30
    L22:
        if (r12.isEmpty() == true) goto L25;
        r1 = false;
    L30:
        if (r0.s == false) goto L37;
        Button r15 = (Button) r0.X90(2131389780);
        if (r15 == null) goto L37;
        if (r7 == false) goto L35;
        float r16 = 1.0f;
    L36:
        r15.setAlpha(r16);
        goto L37
    L35:
        r16 = 0.34f;
    L37:
        r0.Z90();
        return;
    L28:
        ((KtvFeedbackComponentView) r0.X90(2131372289)).setVisibility(8);
        ((LinearLayout) r0.X90(2131375668)).setVisibility(8);
        goto L30
    L5:
        if ((!Intrinsics.areEqual(r8, r0.l)) == false) goto L7;
        r0.m = null;
        r0.n = "";
    L7:
        r0.l = r8;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), (String) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
