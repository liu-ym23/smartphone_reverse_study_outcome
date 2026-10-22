package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import bt8.i;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetButtonRouterBinding;
import com.larus.utils.e1;
import cq8.a0;
import cq8.c;
import cq8.e;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00060\u0001j\u0002`\u0002:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0015H\u0002J\f\u0010\u0018\u001a\u00020\u0017*\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpButtonRouterWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetButtonRouterBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ButtonRouterDescriptor;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "render", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarButtonRouterTemplate;", "shouldHideArrow", "", "isTrueValue", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpButtonRouterWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int h = 0;
    public LarusLayoutActionBarEditorWidgetButtonRouterBinding f;
    public c g;

    public static final class a {
    }

    static {
    }

    public KmpButtonRouterWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpButtonRouterWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r8) {
        Intrinsics.checkNotNullParameter(r8, "descriptor");
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r1 = null;
        if ((r8 instanceof c) == true) goto L5;
        r8 = null;
    L5:
        c r9 = (c) r8;
        if (r9 == null) goto L70;
        this.g = r9;
        com.larus.bmhome.actionbar.model.a r0 = r9.f;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r2 = this.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        AppCompatTextView r3 = r2.d;
        if (r0 == null) goto L14;
        String r4 = r0.b;
    L15:
        r3.setText(r4);
        boolean r5 = false;
        if (r0 == null) goto L33;
        HashMap r6 = r0.d;
        if (r6 == null) goto L30;
        String r7 = (String) r6.get("hide_arrow");
        if (r7 == null) goto L30;
        if (StringsKt.equals(r7, "true", true) == false) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 != true) goto L30;
        boolean r11 = true;
    L31:
        if (r11 != true) goto L33;
        boolean r12 = true;
    L34:
        if (r12 == false) goto L39;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r13 = this.f;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L38:
        e1.o(r13.b);
    L43:
        if (r0 == null) goto L49;
        List r14 = r0.j;
        if (r14 == null) goto L49;
        w r15 = (w) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L49;
        String r16 = r15.b;
    L50:
        if (r16 != null) goto L52;
    L53:
        r5 = true;
    L54:
        if (r5 == false) goto L60;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r17 = this.f;
        if (r17 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L59:
        e1.o(r1.e);
    L68:
        r9.d.a(new e(r9.c));
        return;
    L58:
        r1 = r17;
        goto L59
    L60:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r18 = this.f;
        if (r18 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L63:
        r18.e.setText(r16);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r19 = this.f;
        if (r19 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L67:
        e1.x(r1.e);
        goto L68
    L66:
        r1 = r19;
        goto L67
    L52:
        if (r16.length() != 0) goto L54;
    L49:
        r16 = null;
        goto L50
    L39:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r20 = this.f;
        if (r20 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L42:
        e1.x(r20.b);
        goto L43
    L24:
        if (Intrinsics.areEqual(r7, "1") == true) goto L27;
        r10 = false;
    L30:
        r11 = false;
    L33:
        r12 = false;
        goto L34
    L14:
        r4 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r3 = LarusLayoutActionBarEditorWidgetButtonRouterBinding.a(LayoutInflater.from(r1), this);
        this.f = r3;
        e1.d(r3.c, new i(this));
    }

    public KmpButtonRouterWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KmpButtonRouterWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
