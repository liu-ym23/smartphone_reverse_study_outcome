package com.larus.bmhome.view.actionbar.edit.component;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidgetAdapterV2;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderV2;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "<init>", "(Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownSelectorWidgetAdapterV2 extends ListAdapter<com.larus.bmhome.actionbar.model.h, DropdownSelectorHolderV2> {
    public static final DropdownSelectorWidgetAdapterV2$Companion$DIFF_CALLBACK$1 d = null;
    public final b1 a;
    public final com.larus.bmhome.view.actionbar.edit.c b;
    public final com.larus.bmhome.actionbar.model.u c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidgetAdapterV2$Companion$DIFF_CALLBACK$1] */
    static {
        d = new DropdownSelectorWidgetAdapterV2$Companion$DIFF_CALLBACK$1();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        final DropdownSelectorHolderV2 r14 = (DropdownSelectorHolderV2) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        final int r0 = 0;
        r14.setIsRecyclable(false);
        final com.larus.bmhome.actionbar.model.h r15 = (com.larus.bmhome.actionbar.model.h) getItem(r13);
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNullParameter(r15, "data");
        r14.e.setText(r15.c);
        List r1 = r15.e;
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        Integer r4 = ((com.larus.bmhome.actionbar.model.w) r3).s;
        if (r4 == null) goto L13;
        boolean r5 = true;
        if (r4.intValue() != 1) goto L13;
    L14:
        if (r5 == false) goto L6;
    L17:
        com.larus.bmhome.actionbar.model.w r6 = (com.larus.bmhome.actionbar.model.w) r3;
    L19:
        if (r6 != null) goto L21;
        com.larus.utils.e1.o(r14.f);
    L31:
        final DropdownItemAdapter r7 = new DropdownItemAdapter(r15.b, r14.l, null);
        r14.h.setAdapter(r7);
        y6.d(r14.h, null, null, null, new c1(r7, r14, r15), 15);
        r7.submitList(r15.e);
        List r16 = r15.e;
        if (r16 == null) goto L34;
        r0 = r16.size();
    L34:
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r14).itemView, new d1(r14, r0));
        return;
    L21:
        Integer r8 = r15.b;
        if (r8 != null) goto L25;
    L30:
        r14.f.setText(r6.b());
        com.larus.utils.e1.x(r14.f);
        goto L31
    L25:
        if (r8.intValue() != 5) goto L30;
        LruCache<String, wc9.e> r9 = ko8.a.a;
        String r10 = r6.b;
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        Intrinsics.checkNotNullParameter(r10, "value");
        IAIChatControlTraceService.a.wb(r10);
    L13:
        r5 = false;
        goto L14
    L16:
        r3 = null;
        goto L17
    L18:
        r6 = null;
        goto L19
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new DropdownSelectorHolderV2(LarusItemActionbarDropdownListBinding.b(LayoutInflater.from(r4.getContext()), r4, false).a, this.a, this.b, this.c);
    }

    public DropdownSelectorWidgetAdapterV2(b1 r2, com.larus.bmhome.view.actionbar.edit.c r3, com.larus.bmhome.actionbar.model.u r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
