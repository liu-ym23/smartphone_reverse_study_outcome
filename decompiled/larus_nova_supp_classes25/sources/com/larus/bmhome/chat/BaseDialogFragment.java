package com.larus.bmhome.chat;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J,\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0001\u0010\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u0013¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010#\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/BaseDialogFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "initViewBinding", "()Landroidx/viewbinding/ViewBinding;", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "withBinding", "T", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onCreate", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initLayoutParams", "lp", "Landroid/widget/FrameLayout$LayoutParams;", "onViewCreated", "view", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class BaseDialogFragment<VB extends ViewBinding> extends AppCompatDialogFragment {
    public static final /* synthetic */ int e = 0;
    public VB d;

    public abstract void S90(Bundle r1);

    public abstract VB T90();

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.larus.utils.v.a(this, new d(this));
    }

    public BaseDialogFragment() {
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        setStyle(2, 2131952393);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        S90(r3);
        FlowCommonAppCompatActivity r4 = getActivity();
        if ((r4 instanceof FlowCommonAppCompatActivity) == false) goto L5;
        FlowCommonAppCompatActivity r5 = r4;
    L6:
        if (r5 == null) goto L9;
        r5.L1();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        FrameLayout r8 = new FrameLayout(requireContext());
        Bundle r9 = getArguments();
        WindowManager.LayoutParams r10 = null;
        if (r9 == null) goto L5;
        Integer r11 = Integer.valueOf(r9.getInt("param_background", -1));
    L6:
        if (r11 != null) goto L9;
    L10:
        r8.setBackgroundColor(ColorProtector.parseColor("#FF161616"));
    L12:
        r8.getBackground().setAlpha(230);
        com.larus.utils.e1.d(r8, new e(this));
        Dialog r12 = getDialog();
        if (r12 == null) goto L15;
        r12.setCanceledOnTouchOutside(true);
    L15:
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        VB r13 = (VB) T90();
        this.d = r13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.gravity = 17;
        Intrinsics.checkNotNullParameter(r1, "lp");
        r1.height = -2;
        int r0 = c7.b(Float.valueOf(12.0f));
        r1.setMarginStart(r0);
        r1.setMarginEnd(r0);
        r8.addView(r13.getRoot(), r1);
        Dialog r14 = getDialog();
        if (r14 == null) goto L20;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L20;
        r15.setBackgroundDrawable(new ColorDrawable(0));
    L20:
        Dialog r16 = getDialog();
        if (r16 == null) goto L25;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L25;
        r10 = r17.getAttributes();
    L25:
        if (r10 == null) goto L27;
        r10.gravity = 7;
    L27:
        return r8;
    L9:
        if (r11.intValue() != (-1)) goto L10;
        r8.setBackgroundColor(ContextCompat.getColor(r8.getContext(), v19.c.b(2130970531, r8.getContext(), 2131102535)));
        goto L12
    L5:
        r11 = null;
        goto L6
    }
}
