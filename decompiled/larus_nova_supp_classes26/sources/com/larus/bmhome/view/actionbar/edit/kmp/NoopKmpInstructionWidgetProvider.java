package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider;
import com.larus.bmhome.instruction.kmp.NoopKmpInstructionWidget;
import cq8.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/NoopKmpInstructionWidgetProvider;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionWidgetProvider;", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "<init>", "()V", "match", "", "descriptor", "provide", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NoopKmpInstructionWidgetProvider implements IKmpInstructionWidgetProvider<a0> {
    public NoopKmpInstructionWidgetProvider() {
    }

    @Override // com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider
    public final boolean a(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return false;
    }

    @Override // com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider
    public final AbsKmpInstructionWidget b(Context r2, a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        return new NoopKmpInstructionWidget(r2);
    }
}
