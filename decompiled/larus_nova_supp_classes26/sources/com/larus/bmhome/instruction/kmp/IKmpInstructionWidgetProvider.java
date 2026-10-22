package com.larus.bmhome.instruction.kmp;

import android.content.Context;
import cq8.a0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H&J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/instruction/kmp/IKmpInstructionWidgetProvider;", "D", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "", "match", "", "descriptor", "provide", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;)Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpInstructionWidgetProvider<D extends a0> {
    boolean a(a0 r1);

    AbsKmpInstructionWidget b(Context r1, D r2);
}
