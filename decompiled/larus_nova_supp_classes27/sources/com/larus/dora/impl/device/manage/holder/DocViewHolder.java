package com.larus.dora.impl.device.manage.holder;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementDocBinding;
import com.larus.dora.impl.device.manage.p0;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/DocViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDocBinding;", "onQuickNoteClick", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDocBinding;Lkotlin/jvm/functions/Function1;)V", "currentUrl", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocViewHolder extends BaseViewHolder<p0> {
    public static final /* synthetic */ int d = 0;
    public final LarusItemDoraGDeviceManagementDocBinding a;
    public final Function1<String, Unit> b;
    public String c;

    public static final class a {
    }

    static {
    }

    public DocViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r6) {
        p0 r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        final com.larus.dora.impl.device.manage.e r8 = (com.larus.dora.impl.device.manage.e) r7;
        g49.d.d("DocViewHolder", "onBind: title=" + r8.b + " isLoading=" + r8.j + " isEmpty=" + r8.i + " subtitle=" + r8.c + " thumbnail=" + r8.h);
        this.c = r8.g;
        this.a.i.setText(r8.b);
        if (r8.j == false) goto L6;
        this.a.f.setVisibility(0);
        this.a.d.setVisibility(8);
        this.a.e.setVisibility(8);
    L32:
        this.a.a.setOnClickListener(new h(r8, this));
        this.a.b.setOnClickListener(new i(this));
        return;
    L6:
        if (r8.i == false) goto L8;
        this.a.f.setVisibility(8);
        this.a.d.setVisibility(8);
        this.a.e.setVisibility(0);
        this.a.b.setVisibility(8);
        goto L32
    L8:
        this.a.f.setVisibility(8);
        this.a.d.setVisibility(0);
        this.a.e.setVisibility(8);
        this.a.b.setVisibility(0);
        String r0 = r8.c;
        boolean r3 = true;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        this.a.g.setVisibility(8);
    L18:
        AppCompatTextView r2 = this.a.c;
        CharSequence r4 = r8.d;
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        r2.setText(r4);
        ViewGroup.LayoutParams r5 = this.a.c.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r5;
        String r10 = r8.h;
        if (r10 != null) goto L25;
    L28:
        if (r3 == true) goto L30;
        this.a.h.setVisibility(0);
        this.a.h.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(i5.r0()));
        ImageLoaderKt.u(this.a.h, r8.h, "dora_doc_thumbnail");
        r9.setMarginEnd(i5.q());
    L31:
        this.a.c.setLayoutParams(r9);
        goto L32
    L30:
        this.a.h.setVisibility(8);
        r9.setMarginEnd(0);
        goto L31
    L25:
        if (r10.length() == 0) goto L28;
        r3 = false;
        goto L28
    L17:
        this.a.g.setVisibility(0);
        this.a.g.setText(r8.c);
        goto L18
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    }

    public DocViewHolder(LarusItemDoraGDeviceManagementDocBinding r2, Function1 r3) {
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
