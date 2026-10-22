package com.ss.android.lark.emoji_office;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;
import com.larksuite.framework.callback.IGetDataCallback;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.emoji_office.databinding.OfficeReactionDetailPopupBinding;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0016J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\bH\u0002J\u0018\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\nH\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u0002022\u0006\u00103\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionDetailPopup;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/emoji_office/databinding/OfficeReactionDetailPopupBinding;", "dataList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/reaction/widget/detailwindow/bean/ReactionDetailViewModel;", "selectedReactionKey", BuildConfig.FLAVOR, "tabLayoutMediator", "Lcom/ss/android/lark/reaction/widget/tablayout/TabLayoutMediator;", "requestBitmapCallbacks", BuildConfig.FLAVOR, "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "getRequestBitmapCallbacks", "()Ljava/util/Map;", "requestBitmapCallbacks$delegate", "Lkotlin/Lazy;", "reactionDetailListener", "Lcom/ss/android/lark/emoji_office/IReactionDetailListener;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", BuildConfig.FLAVOR, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "setReactionDetailListener", "listener", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "createTabView", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "model", "bindTabIcon", "iconView", "Landroid/widget/ImageView;", "reactionKey", "setReactionIconWidth", "imageView", "Companion", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionDetailPopup extends BottomSheetDialogFragment {
    public static final /* synthetic */ int j = 0;
    public OfficeReactionDetailPopupBinding d;
    public List<? extends ReactionDetailViewModel> e;
    public String f;
    public u2c.a g;
    public final Lazy h;
    public com.ss.android.lark.emoji_office.a i;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ OfficeReactionDetailPopup a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(OfficeReactionDetailPopup r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 == 5) goto L12;
            return;
        L12:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OfficeReactionDetailPopup a;

        public c(OfficeReactionDetailPopup r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements u2c.a.b {
        public final /* synthetic */ OfficeReactionDetailPopup a;

        public d(OfficeReactionDetailPopup r1) {
            this.a = r1;
        }

        public final void a(TabLayout.Tab r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "tab");
            final OfficeReactionDetailPopup r0 = this.a;
            OfficeReactionDetailPopupBinding r1 = r0.d;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r1 = null;
        L5:
            TabLayout r2 = r1.c;
            ReactionDetailViewModel r11 = (ReactionDetailViewModel) ListProtector.get(this.a.e, r10);
            View r3 = LayoutInflater.from(r2.getContext()).inflate(2131561656, r2, false);
            int r4 = 2131387988;
            TextView r5 = (TextView) ViewBindings.findChildViewById(r3, 2131387988);
            if (r5 == null) goto L18;
            r4 = 2131387990;
            final ImageView r6 = (ImageView) ViewBindings.findChildViewById(r3, 2131387990);
            if (r6 == null) goto L18;
            r4 = 2131387995;
            if (((LinearLayout) ViewBindings.findChildViewById(r3, 2131387995)) == null) goto L18;
            FrameLayout r7 = (FrameLayout) r3;
            r5.setText(String.valueOf(r11.getTotalCount()));
            final String r12 = r11.getReactionKey();
            r0.S90().remove(r12);
            Bitmap r8 = qsb.b.a().v1(r12);
            if (r8 == null) goto L14;
            OfficeReactionDetailPopup.T90(r6, r12);
            r6.setImageBitmap(r8);
        L15:
            r9.setCustomView(r7);
            return;
        L14:
            r6.setImageDrawable(null);
            IGetDataCallback<Boolean> r13 = new OfficeReactionDetailPopup$bindTabIcon$callback$1(r0, r12, r6);
            r0.S90().put(r12, r13);
            qsb.b.a().ge(r12, false, null, r13);
        L18:
            throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r4)));
        }
    }

    static {
    }

    public final Map<String, IGetDataCallback<Boolean>> S90() {
        return (Map) this.h.getValue();
    }

    public final void onDestroyView() {
        u2c.a r0 = this.g;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.g = null;
        S90().clear();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public OfficeReactionDetailPopup() {
        this.e = CollectionsKt.emptyList();
        this.f = BuildConfig.FLAVOR;
        this.h = LazyKt.lazy(OfficeReactionDetailPopup$requestBitmapCallbacks$2.INSTANCE);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        View r1 = r0.findViewById(2131368870);
        if (r1 == null) goto L14;
        r1.setBackgroundColor(0);
        int r2 = UIHelper.dp2px(422.0f);
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L10;
        r3.height = r2;
    L11:
        r1.setLayoutParams(r3);
        BottomSheetBehavior r4 = BottomSheetBehavior.from(r1);
        r4.setHideable(true);
        r4.setSkipCollapsed(false);
        r4.setPeekHeight(r2);
        r4.setState(4);
        r4.setBottomSheetCallback(new b(this));
        return;
    L10:
        r3 = null;
        goto L11
    L14:
        return;
    }

    public final void onCreate(Bundle r5) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r5);
        Bundle r6 = getArguments();
        String r0 = null;
        if (r6 == null) goto L5;
        Serializable r7 = r6.getSerializable("key_data_list");
    L7:
        if ((r7 instanceof ArrayList) == false) goto L9;
        ArrayList r8 = (ArrayList) r7;
    L10:
        if (r8 == null) goto L17;
        List<? extends ReactionDetailViewModel> r1 = new ArrayList();
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L18;
        Object r2 = r9.next();
        if ((r2 instanceof ReactionDetailViewModel) == false) goto L13;
        r1.add(r2);
    L18:
        if (r1 != null) goto L20;
        r1 = CollectionsKt.emptyList();
    L20:
        this.e = r1;
        Bundle r10 = getArguments();
        if (r10 == null) goto L23;
        r0 = r10.getString("key_selected_reaction_key");
    L23:
        if (r0 != null) goto L25;
        r0 = BuildConfig.FLAVOR;
    L25:
        this.f = r0;
        return;
    L17:
        r1 = null;
        goto L18
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L7
    }

    public final Dialog onCreateDialog(Bundle r3) {
        BottomSheetDialog r4 = new BottomSheetDialog(requireContext(), getTheme());
        r4.setCanceledOnTouchOutside(true);
        return r4;
    }

    public static void T90(ImageView r2, String r3) {
        qsb.a r4 = qsb.b.a().Yd(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = r2.getResources().getDimensionPixelSize(2131167869);
        if (r4.a() <= 0) goto L8;
        r0 = (int) ((r0 * r4.c()) / r4.a());
    L8:
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        if (r5 == null) goto L13;
        r5.width = r0;
        r2.setLayoutParams(r5);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        OfficeReactionDetailPopupBinding r8 = this.d;
        OfficeReactionDetailPopupBinding r0 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L5:
        r8.b.setOnClickListener(new c(this));
        OfficeReactionDetailAdapter r9 = new OfficeReactionDetailAdapter(this, this.e, new OfficeReactionDetailPopup$onViewCreated$adapter$1(this));
        OfficeReactionDetailPopupBinding r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L8:
        r1.d.setAdapter(r9);
        Iterator<? extends ReactionDetailViewModel> r10 = this.e.iterator();
        int r2 = 0;
    L10:
        if (r10.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r10.next().getReactionKey(), this.f) == true) goto L16;
        r2 = r2 + 1;
    L16:
        Integer r11 = Integer.valueOf(r2);
        boolean r3 = true;
        if (r11.intValue() < 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L23;
        r11 = null;
    L23:
        if (r11 == null) goto L25;
        int r12 = r11.intValue();
    L26:
        if (r12 >= 0) goto L28;
    L30:
        r3 = false;
    L31:
        if (r3 == false) goto L36;
        OfficeReactionDetailPopupBinding r5 = this.d;
        if (r5 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L35:
        r5.d.setCurrentItem(r12, false);
    L36:
        u2c.a r13 = this.g;
        if (r13 == null) goto L39;
        r13.b();
    L39:
        OfficeReactionDetailPopupBinding r14 = this.d;
        if (r14 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L42:
        TabLayout r15 = r14.c;
        OfficeReactionDetailPopupBinding r16 = this.d;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L46:
        u2c.a r17 = new u2c.a(r15, r0.d, new d(this));
        r17.a();
        this.g = r17;
        return;
    L45:
        r0 = r16;
        goto L46
    L28:
        if (r12 >= this.e.size()) goto L30;
    L25:
        r12 = 0;
        goto L26
    L19:
        r4 = false;
        goto L20
    L15:
        r2 = -1;
        goto L16
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131564065, r4, false);
        int r7 = 2131366976;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r6, 2131366976);
        if (r8 == null) goto L11;
        r7 = 2131387992;
        TabLayout r0 = ViewBindings.findChildViewById(r6, 2131387992);
        if (r0 == null) goto L11;
        r7 = 2131392444;
        ViewPager2 r1 = ViewBindings.findChildViewById(r6, 2131392444);
        if (r1 == null) goto L11;
        OfficeReactionDetailPopupBinding r9 = new OfficeReactionDetailPopupBinding((LinearLayout) r6, r8, r0, r1);
        this.d = r9;
        return r9.a;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
