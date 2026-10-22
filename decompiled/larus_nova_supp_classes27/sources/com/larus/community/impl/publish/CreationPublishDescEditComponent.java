package com.larus.community.impl.publish;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishDescEditLayoutBinding;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishDescEditComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/community/impl/publish/ability/ICreationPublishDescAbility;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishDescEditLayoutBinding;", "maxLength", "", "currentCount", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initView", "showOverLimitToast", "updateCounter", "count", "getCaption", "", "getCaptionCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishDescEditComponent extends BaseContentWidget implements n29.b {
    public static final /* synthetic */ int p = 0;
    public LarusCommunityCreationPublishDescEditLayoutBinding m;
    public final int n;
    public int o;

    @Override // n29.b
    public final String CY() {
        LarusCommunityCreationPublishDescEditLayoutBinding r0 = this.m;
        if (r0 == null) goto L12;
        AppCompatEditText r1 = r0.c;
        if (r1 == null) goto L12;
        Editable r2 = r1.getText();
        if (r2 == null) goto L12;
        String r3 = r2.toString();
        if (r3 == null) goto L12;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, n29.b.class);
    }

    public CreationPublishDescEditComponent() {
        this.n = 50;
    }

    @Override // n29.b
    public final int Uy() {
        return this.o;
    }

    public final void Y2(int r4) {
        this.o = r4;
        LarusCommunityCreationPublishDescEditLayoutBinding r0 = this.m;
        if (r0 == null) goto L6;
        TextView r1 = r0.b;
        StringBuilder r2 = new StringBuilder();
        r2.append(RangesKt.coerceAtMost(r4, this.n));
        r2.append('/');
        r2.append(this.n);
        r1.setText(r2.toString());
        return;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.community.impl.publish.a, java.lang.Object] */
    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        View r9 = F2();
        if ((r9 instanceof FrameLayout) == false) goto L5;
        FrameLayout r10 = (FrameLayout) r9;
    L6:
        if (r10 == null) goto L14;
        LayoutInflater.from(getContext()).inflate(2131561964, r10);
        int r0 = 2131368051;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r10, 2131368051);
        if (r1 == null) goto L13;
        r0 = 2131368828;
        AppCompatEditText r2 = ViewBindings.findChildViewById(r10, 2131368828);
        if (r2 == null) goto L13;
        this.m = new LarusCommunityCreationPublishDescEditLayoutBinding(r10, r1, r2);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    L14:
        LarusCommunityCreationPublishDescEditLayoutBinding r11 = this.m;
        if (r11 == null) goto L18;
        w0.e(r11.c, i5.q());
        Y2(0);
        AppCompatEditText r12 = r11.c;
        int r4 = this.n * 2;
        ?? r5 = new a(this);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r5, "afterTextChanged");
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "";
        r12.addTextChangedListener(new q29.g(r3, new Ref.IntRef(), r4, r5, r12));
        return;
    L18:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
