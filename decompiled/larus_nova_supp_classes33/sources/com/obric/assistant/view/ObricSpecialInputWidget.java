package com.obric.assistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.LayoutObricSpecialInputWidgetV2Binding;
import com.obric.assistant.task.ObricTaskStatusManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/view/ObricSpecialInputWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/obric/assistant/impl/databinding/LayoutObricSpecialInputWidgetV2Binding;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "bindStartPanelView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSpecialInputWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int g = 0;
    public LayoutObricSpecialInputWidgetV2Binding f;

    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.assistant.view.v, java.lang.Object] */
    public final void Y5() {
        ObricTaskStatusManager.a.getClass();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("isStartPanelOpen: ");
        AtomicBoolean r2 = ObricTaskStatusManager.d;
        r1.append(r2.get());
        r0.i("ObricTaskStatusManager", r1.toString());
        if (r2.get() == false) goto L22;
        boolean r3 = false;
        ObricTaskStatusManager.g(false);
        LayoutObricSpecialInputWidgetV2Binding r4 = this.f;
        LayoutObricSpecialInputWidgetV2Binding r5 = null;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L7:
        e1.x(r4.f);
        LayoutObricSpecialInputWidgetV2Binding r6 = this.f;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L10:
        final LinearLayout r7 = r6.d;
        int r8 = com.obric.assistant.chat.p.a;
        Fragment r9 = getFragment();
        ?? r10 = new v(r7);
        Intrinsics.checkNotNullParameter(r10, "action");
        if (r9 != null) goto L13;
        r0.i("ObricChatPageCompat", "bind input chat context: fragment not bound");
    L14:
        if (r3 == false) goto L23;
        LayoutObricSpecialInputWidgetV2Binding r11 = this.f;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        e1.x(r5.e);
        return;
    L19:
        r5 = r11;
        goto L20
    L23:
        return;
    L13:
        r10.invoke(s1a.a.g(r9));
        r3 = true;
        goto L14
    }

    public ObricSpecialInputWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LayoutObricSpecialInputWidgetV2Binding.a(LayoutInflater.from(r1), this);
    }
}
