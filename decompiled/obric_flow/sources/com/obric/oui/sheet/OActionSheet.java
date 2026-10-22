package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 OInsetSheet")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheet extends OBasicPanelFragment {
    public final ArrayList f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f14402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f14403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f14404j;

    public OActionSheet() {
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public final int b(String r5) {
        switch(r5.hashCode()) {
            case -1951390164: goto L26;
            case -1672427580: goto L22;
            case -1210163878: goto L18;
            case -1209866229: goto L14;
            case 1704015448: goto L10;
            case 1915336728: goto L6;
            default: goto L27;
        };
    L27:
        int r10 = 0;
    L30:
        return ContextCompat.getColor(requireContext(), r10);
    L6:
        if (r5.equals("extension_subtitle") == false) goto L27;
        r10 = R$color.TextReverse3;
        goto L30
    L10:
        if (r5.equals("extension_title") == false) goto L27;
        r10 = R$color.TextReverse3;
        goto L30
    L14:
        if (r5.equals("divider_view") == false) goto L27;
        r10 = R$color.BGInputReverse;
        goto L30
    L18:
        if (r5.equals("divider_line") == false) goto L27;
        r10 = R$color.LineReverse2;
        goto L30
    L22:
        if (r5.equals("item_subtitle") == false) goto L27;
        r10 = R$color.TextReverse3;
        goto L30
    L26:
        if (r5.equals("item_title") == false) goto L27;
        r10 = R$color.TextReverse;
        goto L30
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        OBasePanelDialog r10 = new OBasePanelDialog(requireContext(), R$style.OBasicPanel);
        r10.f13983m = true;
        return r10;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        return r5.inflate(R$layout.o_view_action_sheet, r10, false);
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
        Iterator r10 = this.g.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) r10.next()).onDismiss(r5);
        goto L4
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if ((getDialog() instanceof OBasePanelDialog) == false) goto L12;
        Dialog r5 = getDialog();
        if (r5 == null) goto L11;
        RadiusLayout r10 = ((OBasePanelDialog) r5).f13987q;
        if (r10 == null) goto L14;
        com.lynx.tasm.utils.d.s(r10);
        return;
    L14:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        LinearLayout r12 = (LinearLayout) r10.findViewById(R$id.action_sheet_layout);
        Drawable r5 = ContextCompat.getDrawable(requireContext(), R$drawable.o_action_sheet_const_bg);
        if (r12 == null) goto L6;
        r12.setBackground(r5);
    L6:
        r10.findViewById(R$id.divider_view).setBackgroundColor(b("divider_view"));
        LinearLayout r13 = (LinearLayout) r10.findViewById(R$id.title_container);
        TextView r14 = (TextView) r13.findViewById(R$id.action_title);
        this.f14402h = r14;
        if (r14 == null) goto L10;
        r14.setTextColor(b("extension_title"));
    L10:
        TextView r15 = (TextView) r13.findViewById(R$id.action_sub_title);
        this.f14403i = r15;
        if (r15 == null) goto L14;
        r15.setTextColor(b("extension_subtitle"));
    L14:
        View r16 = r13.findViewById(R$id.top_divider);
        r16.setBackgroundColor(b("divider_line"));
        r16.setVisibility(4);
        TextView r17 = this.f14402h;
        if (r17 == null) goto L18;
        r17.setVisibility(8);
    L18:
        TextView r18 = this.f14403i;
        if (r18 == null) goto L22;
        r18.setMaxLines(2);
    L22:
        TextView r19 = this.f14403i;
        if (r19 == null) goto L26;
        r19.setVisibility(8);
    L26:
        r13.setVisibility(8);
        TextView r20 = (TextView) r10.findViewById(R$id.cancel_action);
        if (r20 == null) goto L30;
        r20.setTextColor(b("item_title"));
    L30:
        r20.setAccessibilityDelegate(new b());
        final int r21 = 0;
        r20.setOnClickListener(new a(this, r21));
        this.f14404j = (LinearLayout) r10.findViewById(R$id.action_container);
        ArrayList r110 = this.f;
        Iterator r22 = r110.iterator();
        if (r22.hasNext() == true) goto L33;
        return;
    L33:
        if (r22.next() != null) goto L52;
        View r23 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_action_sheet, this.f14404j, false);
        final int r24 = 1;
        r23.setOnClickListener(new a(this, r24));
        TextView r25 = (TextView) r23.findViewById(R$id.action_title);
        TextView r26 = (TextView) r23.findViewById(R$id.action_sub_title);
        View r27 = r23.findViewById(R$id.top_divider);
        if (r25 == null) goto L38;
        r25.setTextColor(b("item_title"));
    L38:
        if (r26 == null) goto L41;
        r26.setTextColor(b("item_subtitle"));
    L41:
        if (r27 == null) goto L45;
        r27.setBackgroundColor(b("divider_line"));
    L45:
        if (r110.indexOf(null) == 0) goto L47;
    L49:
        r27.setVisibility(0);
        throw null;
    L47:
        if (r13.getVisibility() != 8) goto L49;
        r27.setVisibility(4);
        throw null;
    L52:
        throw new ClassCastException();
    }
}
