package com.larus.dora.impl.noti_v3.social_message.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraDialogNotiV3MessageModeSheetBinding;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u59.c;
import u59.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/dialog/NotificationBroadcastV3MessageModeBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogNotiV3MessageModeSheetBinding;", "currentSelectedMode", "", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "setupBottomSheetBehavior", "bindSheetContent", "()Lkotlin/Unit;", "bindClicks", "resolveSource", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "updateSelectionState", "options", "", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeOption;", "(Ljava/util/List;)Lkotlin/Unit;", "handleModeSelected", "selectedMode", "emitSelectionResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3MessageModeBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public LarusDoraDialogNotiV3MessageModeSheetBinding d;
    public String e;

    public static final class a {
        public static NotificationBroadcastV3MessageModeBottomSheetDialogFragment a(MessageModeSheetSource r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "source");
            NotificationBroadcastV3MessageModeBottomSheetDialogFragment r0 = new NotificationBroadcastV3MessageModeBottomSheetDialogFragment();
            Bundle r1 = new Bundle();
            r1.putString("arg_source", r3.name());
            r1.putString("arg_selected_mode", r4);
            r0.setArguments(r1);
            return r0;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageModeSheetSource.values().length];
            r0[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MessageModeSheetSource.CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MessageModeSheetSource.RHYTHM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public final MessageModeSheetSource T90() {
        MessageModeSheetSource.a r0 = MessageModeSheetSource.Companion;
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("arg_source");
    L6:
        r0.getClass();
        return MessageModeSheetSource.a.a(r2);
    L5:
        r2 = null;
        goto L6
    }

    public NotificationBroadcastV3MessageModeBottomSheetDialogFragment() {
        this.e = "";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void S90(String r5) {
        if (Intrinsics.areEqual(this.e, r5) == false) goto L5;
        return;
    L5:
        this.e = r5;
        U90(T90().toOptions());
        FragmentManager r0 = getParentFragmentManager();
        Bundle r1 = new Bundle();
        r1.putString("bundle_key_source", T90().name());
        r1.putString("bundle_key_selected_mode", r5);
        Unit r6 = Unit.INSTANCE;
        r0.setFragmentResult("request_key_message_mode_result", r1);
    }

    public final Unit U90(List<v59.a> r8) {
        LarusDoraDialogNotiV3MessageModeSheetBinding r0 = this.d;
        if (r0 == null) goto L25;
        int r3 = 8;
        if ((!r8.isEmpty()) == false) goto L12;
        AppCompatImageView r1 = r0.e;
        if (Intrinsics.areEqual(((v59.a) ListProtector.get(r8, 0)).c, this.e) == false) goto L9;
        int r5 = 0;
    L10:
        r1.setVisibility(r5);
        goto L12
    L9:
        r5 = 8;
    L12:
        if (r8.size() <= 1) goto L19;
        AppCompatImageView r2 = r0.i;
        if (Intrinsics.areEqual(((v59.a) ListProtector.get(r8, 1)).c, this.e) == false) goto L16;
        int r4 = 0;
    L17:
        r2.setVisibility(r4);
        goto L19
    L16:
        r4 = 8;
    L19:
        if (r8.size() <= 2) goto L27;
        AppCompatImageView r6 = r0.m;
        if (Intrinsics.areEqual(((v59.a) ListProtector.get(r8, 2)).c, this.e) == false) goto L23;
        r3 = 0;
    L23:
        r6.setVisibility(r3);
    L27:
        return Unit.INSTANCE;
    L25:
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        BottomSheetDialog r10 = getDialog();
        String r0 = null;
        if ((r10 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r11 = r10;
    L6:
        if (r11 == null) goto L8;
        View r12 = r11.findViewById(2131368870);
    L10:
        if (r12 == null) goto L12;
        BottomSheetBehavior r13 = BottomSheetBehavior.from(r12);
        r13.setState(3);
        r13.setSkipCollapsed(true);
    L12:
        LarusDoraDialogNotiV3MessageModeSheetBinding r14 = this.d;
        if (r14 == null) goto L59;
        MessageModeSheetSource r3 = T90();
        Bundle r4 = getArguments();
        if (r4 == null) goto L18;
        r0 = r4.getString("arg_selected_mode");
    L18:
        if (r0 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == false) goto L35;
        int r6 = b.a[r3.ordinal()];
        if (r6 == 1) goto L34;
        if (r6 == 2) goto L34;
        if (r6 == 3) goto L34;
        if (r6 == 4) goto L33;
        if (r0 == null) goto L36;
    L37:
        this.e = r0;
        List<v59.a> r15 = r3.toOptions();
        r14.q.setText(r3.getTitleResId());
        if ((!r15.isEmpty()) == false) goto L43;
        r14.d.setVisibility(0);
        r14.g.setText(((v59.a) ListProtector.get(r15, 0)).a);
        Integer r1 = ((v59.a) ListProtector.get(r15, 0)).b;
        if (r1 == null) goto L42;
        r14.f.setText(r1.intValue());
        r14.f.setVisibility(0);
    L45:
        if (r15.size() <= 1) goto L50;
        r14.b.setVisibility(0);
        r14.h.setVisibility(0);
        r14.k.setText(((v59.a) ListProtector.get(r15, 1)).a);
        Integer r2 = ((v59.a) ListProtector.get(r15, 1)).b;
        if (r2 == null) goto L49;
        r14.j.setText(r2.intValue());
        r14.j.setVisibility(0);
    L52:
        if (r15.size() <= 2) goto L57;
        r14.c.setVisibility(0);
        r14.l.setVisibility(0);
        r14.o.setText(((v59.a) ListProtector.get(r15, 2)).a);
        Integer r7 = ((v59.a) ListProtector.get(r15, 2)).b;
        if (r7 == null) goto L56;
        r14.n.setText(r7.intValue());
        r14.n.setVisibility(0);
    L58:
        U90(r15);
        goto L59
    L56:
        r14.n.setVisibility(8);
        goto L58
    L57:
        r14.c.setVisibility(8);
        r14.l.setVisibility(8);
        goto L58
    L49:
        r14.j.setVisibility(8);
        goto L52
    L50:
        r14.b.setVisibility(8);
        r14.h.setVisibility(8);
        goto L52
    L42:
        r14.f.setVisibility(8);
        goto L45
    L43:
        r14.d.setVisibility(8);
    L36:
        r0 = "";
        goto L37
    L33:
        r0 = "10";
    L34:
        r0 = "1";
        goto L37
    L35:
        if (r0 != null) goto L37;
    L20:
        if (StringsKt.isBlank(r0) == true) goto L23;
        r5 = false;
    L59:
        LarusDoraDialogNotiV3MessageModeSheetBinding r16 = this.d;
        if (r16 == null) goto L72;
        final List<v59.a> r17 = T90().toOptions();
        e1.d(r16.p, new u59.a(this));
        if ((!r17.isEmpty()) == false) goto L65;
        e1.d(r16.d, new u59.b(this, r17));
    L65:
        if (r17.size() <= 1) goto L68;
        e1.d(r16.h, new c(this, r17));
    L68:
        if (r17.size() <= 2) goto L70;
        e1.d(r16.l, new d(this, r17));
    L70:
        Unit r18 = Unit.INSTANCE;
        return;
    L72:
        return;
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "inflater");
        ConstraintLayout r0 = r21.inflate(2131562166, r22, false);
        int r1 = 2131369722;
        View r4 = ViewBindings.findChildViewById(r0, 2131369722);
        if (r4 == null) goto L39;
        r1 = 2131369723;
        View r5 = ViewBindings.findChildViewById(r0, 2131369723);
        if (r5 == null) goto L39;
        r1 = 2131369724;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r0, 2131369724);
        if (r6 == null) goto L39;
        r1 = 2131369725;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r0, 2131369725);
        if (r7 == null) goto L39;
        r1 = 2131369726;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369726);
        if (r8 == null) goto L39;
        r1 = 2131369727;
        DoraTextView r9 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369727);
        if (r9 == null) goto L39;
        r1 = 2131369728;
        ConstraintLayout r10 = ViewBindings.findChildViewById(r0, 2131369728);
        if (r10 == null) goto L39;
        r1 = 2131369729;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r0, 2131369729);
        if (r11 == null) goto L39;
        r1 = 2131369730;
        DoraTextView r12 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369730);
        if (r12 == null) goto L39;
        r1 = 2131369731;
        DoraTextView r13 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369731);
        if (r13 == null) goto L39;
        r1 = 2131369732;
        ConstraintLayout r14 = ViewBindings.findChildViewById(r0, 2131369732);
        if (r14 == null) goto L39;
        r1 = 2131369733;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r0, 2131369733);
        if (r15 == null) goto L39;
        r1 = 2131369734;
        DoraTextView r16 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369734);
        if (r16 == null) goto L39;
        r1 = 2131369735;
        DoraTextView r17 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369735);
        if (r17 == null) goto L39;
        r1 = 2131369736;
        AppCompatImageView r18 = ViewBindings.findChildViewById(r0, 2131369736);
        if (r18 == null) goto L39;
        r1 = 2131369737;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131369737)) == null) goto L39;
        r1 = 2131369738;
        DoraTextView r110 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369738);
        if (r110 == null) goto L39;
        ConstraintLayout r2 = r0;
        this.d = new LarusDoraDialogNotiV3MessageModeSheetBinding(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110);
        return r2;
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
