package com.larus.dora.impl.rebind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.databinding.LarusDoraGRebindBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n69.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/rebind/DoraRebindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGRebindBinding;", "mDescResIds", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraRebindFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraGRebindBinding f;
    public final List<Integer> g;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_rebind";
    }

    public DoraRebindFragment() {
        this.g = CollectionsKt.listOf(new Integer[]{2131902931, 2131902932, 2131902933, 2131902934});
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraGRebindBinding r10 = this.f;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.d;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131902935), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new d(this), 14);
    L7:
        LarusDoraGRebindBinding r11 = this.f;
        if (r11 == null) goto L13;
        RecyclerView r12 = r11.b;
        if (r12 == null) goto L14;
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext()));
        r12.setAdapter(new DoraRebindOpAdapter(this.g));
        return;
    L14:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562202, r4, false);
        int r7 = 2131369599;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131369599);
        if (r8 == null) goto L11;
        r7 = 2131369962;
        View r0 = ViewBindings.findChildViewById(r6, 2131369962);
        if (r0 == null) goto L11;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L11;
        ConstraintLayout r9 = r6;
        this.f = new LarusDoraGRebindBinding(r9, r8, r0, r1);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
