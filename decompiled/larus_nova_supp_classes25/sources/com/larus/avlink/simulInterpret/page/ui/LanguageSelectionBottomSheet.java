package com.larus.avlink.simulInterpret.page.ui;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.DialogLanguageSelectionBottomSheetBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectionBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/DialogLanguageSelectionBottomSheetBinding;", "leftLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "rightLanguage", "isEditingLeft", "", "languageList", "", "onLanguagesSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "tempSelectedLanguage", "adapter", "Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter;", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupBottomSheetBehavior", "updateCurrentLanguagesDisplay", "updateContainerSelection", "setupRecyclerView", "handleLanguageSelection", "selectedLanguage", "setupButtons", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LanguageSelectionBottomSheet extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public DialogLanguageSelectionBottomSheetBinding d;
    public com.larus.avlink.simulInterpret.page.model.a e;
    public com.larus.avlink.simulInterpret.page.model.a f;
    public boolean g;
    public List<com.larus.avlink.simulInterpret.page.model.a> h;
    public Function2<? super com.larus.avlink.simulInterpret.page.model.a, ? super com.larus.avlink.simulInterpret.page.model.a, Unit> i;
    public com.larus.avlink.simulInterpret.page.model.a j;
    public LanguageSelectBottomSheetAdapter k;
    public DoraDeviceType l;

    public static final class a {
        public static LanguageSelectionBottomSheet a(com.larus.avlink.simulInterpret.page.model.a r1, com.larus.avlink.simulInterpret.page.model.a r2, List r3, Function2 r4, boolean r5, DoraDeviceType r6) {
            Intrinsics.checkNotNullParameter(r1, "currentLanguage");
            Intrinsics.checkNotNullParameter(r2, "otherSideLanguage");
            Intrinsics.checkNotNullParameter(r3, "languages");
            Intrinsics.checkNotNullParameter(r4, "onSelected");
            Intrinsics.checkNotNullParameter(r6, "deviceType");
            LanguageSelectionBottomSheet r0 = new LanguageSelectionBottomSheet();
            if (r5 == false) goto L5;
            r0.e = r1;
            r0.f = r2;
        L6:
            r0.g = r5;
            r0.h = r3;
            r0.i = r4;
            r0.l = r6;
            return r0;
        L5:
            r0.e = r2;
            r0.f = r1;
            goto L6
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.simulInterpret.page.ui.n] */
    public final void S90() {
        if (this.g == false) goto L5;
        com.larus.avlink.simulInterpret.page.model.a r0 = this.e;
    L6:
        com.larus.avlink.simulInterpret.page.model.a r1 = this.j;
        if (r1 == null) goto L10;
        r0 = r1;
    L10:
        this.k = new LanguageSelectBottomSheetAdapter(r0, this.h, new n(this));
        DialogLanguageSelectionBottomSheetBinding r2 = this.d;
        if (r2 == null) goto L16;
        RecyclerView r3 = r2.d;
        if (r3 == null) goto L17;
        r3.setLayoutManager(new LinearLayoutManager(r3.getContext()));
        r3.setAdapter(this.k);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r0 = this.f;
        goto L6
    }

    public final void T90() {
        DialogLanguageSelectionBottomSheetBinding r0 = this.d;
        if (r0 == null) goto L13;
        Context r1 = getContext();
        if (r1 == null) goto L14;
        int r2 = r1.getColor(2131105539);
        Context r3 = getContext();
        if (r3 == null) goto L15;
        int r4 = r3.getColor(2131103681);
        if (this.g == false) goto L11;
        r0.e.setBackgroundResource(2131232012);
        r0.h.setBackgroundResource(2131232011);
        r0.g.setTextColor(r2);
        r0.f.setColorFilter(r2);
        r0.j.setTextColor(r4);
        r0.i.clearColorFilter();
        return;
    L11:
        r0.e.setBackgroundResource(2131232011);
        r0.h.setBackgroundResource(2131232012);
        r0.g.setTextColor(r4);
        r0.f.clearColorFilter();
        r0.j.setTextColor(r2);
        r0.i.setColorFilter(r2);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void U90() {
        DialogLanguageSelectionBottomSheetBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.l != DoraDeviceType.DEVICE_LITE) goto L7;
        r0.f.setImageResource(2131237998);
        r0.i.setImageResource(2131238052);
    L8:
        r0.g.setText(this.e.a);
        r0.j.setText(this.f.a);
        T90();
        r0.e.setOnClickListener(new k(this));
        r0.h.setOnClickListener(new l(this));
        r0.k.setOnClickListener(new m(this));
        return;
    L7:
        r0.f.setImageResource(2131238034);
        r0.i.setImageResource(2131237945);
        goto L8
    }

    public LanguageSelectionBottomSheet() {
        com.larus.avlink.simulInterpret.page.model.a r0 = com.larus.avlink.simulInterpret.page.model.a.e;
        com.larus.avlink.simulInterpret.page.model.a r1 = com.larus.avlink.simulInterpret.page.model.a.e;
        this.e = r1;
        com.larus.avlink.simulInterpret.page.model.a r2 = com.larus.avlink.simulInterpret.page.model.a.f;
        this.f = r2;
        this.h = CollectionsKt.listOf(new com.larus.avlink.simulInterpret.page.model.a[]{r1, r2});
        this.l = DoraDeviceType.DEVICE_LITE;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.k = null;
        this.d = null;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        BottomSheetDialog r4 = getDialog();
        View r0 = null;
        if ((r4 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r5 = r4;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.findViewById(2131368870);
    L8:
        if (r0 == null) goto L10;
        r0.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior.from(r0).setState(3);
    L10:
        U90();
        S90();
        DialogLanguageSelectionBottomSheetBinding r6 = this.d;
        if (r6 == null) goto L14;
        r6.b.setOnClickListener(new o(this));
        r6.c.setOnClickListener(new p(this));
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131560035, r14, false);
        int r17 = 2131364430;
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131364430)) == null) goto L33;
        r17 = 2131365125;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r16, 2131365125);
        if (r2 == null) goto L33;
        r17 = 2131367655;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r16, 2131367655);
        if (r3 == null) goto L33;
        r17 = 2131368339;
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131368339)) == null) goto L33;
        r17 = 2131377152;
        RecyclerView r4 = ViewBindings.findChildViewById(r16, 2131377152);
        if (r4 == null) goto L33;
        r17 = 2131377788;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131377788);
        if (r5 == null) goto L33;
        r17 = 2131377789;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r16, 2131377789);
        if (r6 == null) goto L33;
        r17 = 2131377790;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r16, 2131377790);
        if (r7 == null) goto L33;
        r17 = 2131384600;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131384600);
        if (r8 == null) goto L33;
        r17 = 2131384601;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r16, 2131384601);
        if (r9 == null) goto L33;
        r17 = 2131384602;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131384602);
        if (r10 == null) goto L33;
        r17 = 2131387670;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131387670)) == null) goto L33;
        r17 = 2131387805;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r16, 2131387805);
        if (r11 == null) goto L33;
        r17 = 2131388915;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131388915)) == null) goto L33;
        ConstraintLayout r18 = r16;
        this.d = new DialogLanguageSelectionBottomSheetBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
