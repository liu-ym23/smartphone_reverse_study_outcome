package com.larus.uaigc.createpage.slides;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.s;
import ry9.j;
import ry9.k;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0014J\u001c\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0014R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/createpage/slides/SlidesCreationEditorComponent;", "Lcom/larus/uaigc/createpage/component/instruction/CreationEditorComponent;", "<init>", "()V", "shouldUseCreationSendMessageFlow", "", "onViewCreated", "", "view", "Landroid/view/View;", "resetInstructionEditorFactoryAndSetHint", "replaceEditorInstruction", "index", "", "multiTabViewCollector", "Lcom/larus/bmhome/instrution/MultiTabViewCollector;", "needSetHint", "curMediaSelectorStatusMap", "", "", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "updateSendStatus", "statusMap", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesCreationEditorComponent extends CreationEditorComponent {
    public Map<String, k> h2;

    @Override // com.larus.uaigc.createpage.component.instruction.CreationEditorComponent
    public final boolean V5() {
        return false;
    }

    @Override // com.larus.uaigc.createpage.component.instruction.CreationEditorComponent
    public final void y5() {
        B3();
        hq8.a r0 = this.p1;
        if (r0 == null) goto L7;
        TabLayout r1 = r0.b;
        if (r1 == null) goto L7;
        e1.q(r1);
    L7:
        s r2 = W3();
        if (r2 == null) goto L10;
        z0 r3 = r2.f();
    L11:
        hq8.a r4 = this.p1;
        if (r4 == null) goto L26;
        AppCompatTextView r5 = r4.c;
        if (r5 == null) goto L26;
        if (r3 == null) goto L19;
        String r6 = r3.h;
        if (r6 == null) goto L19;
    L25:
        r5.setText(r6);
    L19:
        if (r3 == null) goto L21;
        r6 = r3.e;
    L22:
        if (r6 != null) goto L25;
        r6 = "";
        goto L25
    L21:
        r6 = null;
    L26:
        Drawable r7 = ContextCompat.getDrawable(getContext(), 2131241397);
        if (r7 == null) goto L29;
        Drawable r8 = DrawableCompat.wrap(r7.mutate());
        DrawableCompat.setTint(r8, ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    L30:
        hq8.a r9 = this.p1;
        if (r9 == null) goto L35;
        AppCompatTextView r10 = r9.c;
        if (r10 == null) goto L35;
        r10.setCompoundDrawablesWithIntrinsicBounds(r8, null, null, null);
    L35:
        hq8.a r11 = this.p1;
        if (r11 == null) goto L41;
        AppCompatTextView r12 = r11.c;
        if (r12 == null) goto L42;
        r12.setCompoundDrawablePadding(i5.j0());
        return;
    L42:
        return;
    L41:
        return;
    L29:
        r8 = null;
        goto L30
    L10:
        r3 = null;
        goto L11
    }

    public SlidesCreationEditorComponent() {
    }

    @Override // com.larus.uaigc.createpage.component.instruction.CreationEditorComponent
    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2);
        ICoreInputAbility r3 = a4();
        if (r3 == null) goto L6;
        r3.pS(new a(this));
        return;
    }

    @Override // com.larus.uaigc.createpage.component.instruction.CreationEditorComponent
    public final void r6(Map<String, k> r3) {
        Intrinsics.checkNotNullParameter(r3, "statusMap");
        this.h2 = r3;
        Iterator<T> r4 = r3.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if ((((k) r0).b instanceof j.h) == false) goto L4;
    L9:
        if (r0 == null) goto L11;
        H3(false);
        return;
    L11:
        H3(true);
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.larus.uaigc.createpage.component.instruction.CreationEditorComponent
    public final void w5(int r1, hq8.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "multiTabViewCollector");
        r2.f.removeAllViews();
    }
}
