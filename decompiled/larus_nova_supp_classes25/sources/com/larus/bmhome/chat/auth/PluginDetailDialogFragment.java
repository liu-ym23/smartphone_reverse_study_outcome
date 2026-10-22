package com.larus.bmhome.chat.auth;

import android.R;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusFragmentPluginDetailDialogBinding;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginDetailDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentPluginDetailDialogBinding;", "initInvoker", "Lkotlin/Function1;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginDetailDialogFragment extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentPluginDetailDialogBinding d;
    public Function1<? super LarusFragmentPluginDetailDialogBinding, Unit> e;

    public static final class a {
        public Boolean a;
        public PluginItem b;
        public Function1<? super PluginAuthType, Unit> c;
        public Function1<? super String, Unit> d;
        public Function0<Unit> e;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.auth.PluginDetailDialogFragment$a$a, reason: collision with other inner class name */
        public static final class C0040a {
        }

        static {
        }

        public a() {
        }

        public static List a(TextView r11, String r12) {
            int r1 = 0;
            if (r12.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            TextPaint r7 = r11.getPaint();
            float r13 = r11.getWidth();
            if (r7.measureText(r12) < r13) goto L12;
            ArrayList r8 = new ArrayList();
            int r9 = 0;
        L15:
            if (r1 >= r12.length()) goto L18;
            int r10 = r1 + r9;
            int r2 = r9 + r7.breakText(r12, r9, r12.length(), true, r13, null);
            r8.add(r12.substring(r9, r2));
            r9 = r2;
            r1 = r10;
            goto L15
        L18:
            if (r9 == r12.length()) goto L20;
            r8.add(r12.substring(r9, r12.length()));
        L20:
            return r8;
        L12:
            return CollectionsKt.listOf(r12);
        L8:
            return CollectionsKt.emptyList();
        L5:
            r0 = false;
            goto L6
        }

        public static void b(LarusFragmentPluginDetailDialogBinding r0, boolean r1, int r2) {
            if (r1 == false) goto L5;
            return;
        L5:
            if (r2 != PluginAuthType.Always.value) goto L7;
            e1.x(r0.l);
            e1.o(r0.n);
            return;
        L7:
            e1.o(r0.l);
            e1.x(r0.n);
        }
    }

    public PluginDetailDialogFragment() {
        this.e = new c();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 2131953744);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        LarusFragmentPluginDetailDialogBinding r4 = this.d;
        if (r4 == null) goto L6;
        this.e.invoke(r4);
        return;
    }

    public final View onCreateView(LayoutInflater r25, ViewGroup r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r25, "inflater");
        View r0 = r25.inflate(2131562424, r26, false);
        int r1 = 2131366997;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r0, 2131366997);
        if (r5 == null) goto L63;
        FrameLayout r2 = (FrameLayout) r0;
        RoundConstraintLayout r7 = ViewBindings.findChildViewById(r0, 2131368955);
        if (r7 == null) goto L60;
        View r8 = ViewBindings.findChildViewById(r0, 2131369198);
        if (r8 == null) goto L59;
        View r9 = ViewBindings.findChildViewById(r0, 2131369199);
        if (r9 == null) goto L58;
        View r10 = ViewBindings.findChildViewById(r0, 2131369201);
        if (r10 == null) goto L57;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131373325);
        if (r11 == null) goto L56;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131373326);
        if (r12 == null) goto L55;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131373327);
        if (r13 == null) goto L54;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131381939);
        if (r14 == null) goto L53;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r0, 2131381940);
        if (r15 == null) goto L52;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131381941);
        if (r16 == null) goto L51;
        AppCompatImageView r17 = ViewBindings.findChildViewById(r0, 2131381942);
        if (r17 == null) goto L50;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r0, 2131382482);
        if (r18 == null) goto L49;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131382484);
        if (r19 == null) goto L48;
        RoundConstraintLayout r20 = ViewBindings.findChildViewById(r0, 2131382485);
        if (r20 == null) goto L47;
        SimpleDraweeView r21 = ViewBindings.findChildViewById(r0, 2131382486);
        if (r21 == null) goto L46;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r0, 2131382490);
        if (r22 == null) goto L45;
        RoundConstraintLayout r23 = ViewBindings.findChildViewById(r0, 2131382492);
        if (r23 == null) goto L44;
        this.d = new LarusFragmentPluginDetailDialogBinding(r2, r5, r2, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        Dialog r3 = getDialog();
        if (r3 == null) goto L43;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L43;
        r4.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L43:
        return r2;
    L44:
        r1 = 2131382492;
        goto L63
    L45:
        r1 = 2131382490;
        goto L63
    L46:
        r1 = 2131382486;
        goto L63
    L47:
        r1 = 2131382485;
        goto L63
    L48:
        r1 = 2131382484;
        goto L63
    L49:
        r1 = 2131382482;
        goto L63
    L50:
        r1 = 2131381942;
        goto L63
    L51:
        r1 = 2131381941;
        goto L63
    L52:
        r1 = 2131381940;
        goto L63
    L53:
        r1 = 2131381939;
        goto L63
    L54:
        r1 = 2131373327;
        goto L63
    L55:
        r1 = 2131373326;
        goto L63
    L56:
        r1 = 2131373325;
        goto L63
    L57:
        r1 = 2131369201;
        goto L63
    L58:
        r1 = 2131369199;
        goto L63
    L59:
        r1 = 2131369198;
        goto L63
    L60:
        r1 = 2131368955;
    L63:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
