package com.obric.aiproactive.ui.feedback;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/IntegerAmountInputFilter;", "Landroid/text/InputFilter;", "<init>", "()V", "filter", "", AILabCheckPermissionTask.KEY_SOURCE, CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "destination", "Landroid/text/Spanned;", "destinationStart", "destinationEnd", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class a implements InputFilter {
    public a() {
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Spanned r9 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r6, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r9, "destination");
        StringBuilder r10 = new StringBuilder();
        boolean r1 = false;
        r10.append(r9.subSequence(0, r7));
        r10.append(r2.subSequence(r4, r5));
        r10.append(r9.subSequence(r8, r9.length()));
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        r1 = true;
    L5:
        if (r1 == false) goto L7;
        return null;
    L7:
        if (m.a().matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return null;
    L10:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }
}
