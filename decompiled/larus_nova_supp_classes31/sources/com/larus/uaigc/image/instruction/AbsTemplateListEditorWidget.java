package com.larus.uaigc.image.instruction;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/image/instruction/AbsTemplateListEditorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "defaultSelectionIndexForScroll", "", "Ljava/lang/Integer;", "templateListView", "Landroidx/recyclerview/widget/RecyclerView;", "getTemplateListView", "()Landroidx/recyclerview/widget/RecyclerView;", "onViewShow", "", "updateDefaultSelectionIndex", "index", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class AbsTemplateListEditorWidget extends AbsInstructionWidget {
    public Integer f;
    public final b g;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ AbsTemplateListEditorWidget a;

        public b(AbsTemplateListEditorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            Integer r10 = this.a.f;
            if (r10 == null) goto L21;
            int r11 = r10.intValue();
            RecyclerView r12 = this.a.getTemplateListView();
            if (r12 == null) goto L9;
            RecyclerView.LayoutManager r13 = r12.getLayoutManager();
            if (r13 == null) goto L9;
            int r14 = r13.getChildCount();
        L10:
            if (r14 <= 0) goto L22;
            if (r11 <= 0) goto L23;
            FLogger.a.i("AbsTemplateListEditorComponent", "onLayoutChange smoothScrollToPosition " + this.a.f);
            RecyclerView r15 = this.a.getTemplateListView();
            if (r15 == null) goto L17;
            RecyclerView.LayoutManager r16 = r15.getLayoutManager();
            if (r16 == null) goto L17;
            r16.scrollToPosition(r11);
        L17:
            AbsTemplateListEditorWidget r17 = this.a;
            r17.f = null;
            RecyclerView r18 = r17.getTemplateListView();
            if (r18 == null) goto L24;
            r18.removeOnLayoutChangeListener(this);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L9:
            r14 = 0;
            goto L10
        }
    }

    static {
    }

    public abstract RecyclerView getTemplateListView();

    public final void Z5() {
        RecyclerView r0 = getTemplateListView();
        if (r0 == null) goto L6;
        r0.addOnLayoutChangeListener(this.g);
        return;
    }

    public AbsTemplateListEditorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.g = new b(this);
    }
}
