package com.larus.ugc.feed.impl.quickmenu;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import x0a.j;
import x0a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0010\u0013\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006+"}, d2 = {"Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuPanelFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "titleTextView", "Landroid/widget/TextView;", "menuRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "menuConfig", "Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuConfig;", "adapter", "Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuAdapter;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/ugc/feed/impl/quickmenu/QuickMenuPanelFragment$behaviorCallback$1", "Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuPanelFragment$behaviorCallback$1;", "itemClickListener", "com/larus/ugc/feed/impl/quickmenu/QuickMenuPanelFragment$itemClickListener$1", "Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuPanelFragment$itemClickListener$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getTheme", "", "initViews", "setupBottomSheet", "bindData", "setupRecyclerView", "config", "tryDismiss", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/ugc/feed/impl/quickmenu/DismissReason;", "onDestroyView", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class QuickMenuPanelFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int i = 0;
    public RecyclerView d;
    public QuickMenuConfig e;
    public QuickMenuAdapter f;
    public final b g;
    public final c h;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ QuickMenuPanelFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(QuickMenuPanelFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 5) goto L7;
            QuickMenuPanelFragment.S90(this.a, DismissReason.OUTSIDE_TOUCH);
            return;
        }
    }

    public static final class c implements x0a.c {
        public final /* synthetic */ QuickMenuPanelFragment a;

        public c(QuickMenuPanelFragment r1) {
            this.a = r1;
        }

        @Override // x0a.c
        public final void a(j r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            QuickMenuConfig r0 = this.a.e;
            if (r0 == null) goto L7;
            x0a.c r1 = r0.getOnItemClickListener();
            if (r1 == null) goto L7;
            r1.a(r2, r3);
        L7:
            QuickMenuPanelFragment.S90(this.a, DismissReason.ITEM_CLICK);
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131953374;
    }

    public QuickMenuPanelFragment() {
        this.g = new b(this);
        this.h = new c(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
        this.f = null;
    }

    public static final void S90(QuickMenuPanelFragment r1, DismissReason r2) {
        r1.getClass();
        QuickMenuConfig r0 = r1.e;     // Catch: Exception -> L21
        if (r0 == null) goto L9;
        x0a.b r3 = r0.getOnDismissListener();     // Catch: Exception -> L21
        if (r3 == null) goto L9;
        r3.a(r2);     // Catch: Exception -> L21
    L9:
        if (r1.isAdded() == true) goto L11;
        return;
    L11:
        if (r1.isDetached() == false) goto L13;
        return;
    L13:
        if (r1.isRemoving() == true) goto L30;
        r1.dismiss();     // Catch: Exception -> L16
    L32:
        return;
    L16:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L21
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L21
        if (r4 == null) goto L31;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L21
        return;
    L31:
        return;
    L30:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        this.d = r4.findViewById(2131384976);
        if (this.e == null) goto L8;
        Dialog r6 = getDialog();
        if (r6 == null) goto L8;
        r6.setOnShowListener(new k(this));
    L8:
        QuickMenuConfig r7 = this.e;
        if (r7 == null) goto L22;
        String r8 = r7.getTitle();
        if (r8 == null) goto L14;
        r8.length();
    L14:
        RecyclerView r9 = this.d;
        if (r9 == null) goto L23;
        this.f = new QuickMenuAdapter(this.h);
        r9.setLayoutManager(new LinearLayoutManager(getContext()));
        int r0 = i5.h();
        r9.addItemDecoration(new QuickMenuItemDecoration(r0, r0, false));
        r9.setAdapter(this.f);
        QuickMenuAdapter r10 = this.f;
        if (r10 == null) goto L21;
        List<j> r11 = r7.getMenuItems();
        Intrinsics.checkNotNullParameter(r11, "items");
        r10.b = r11;
        r10.notifyDataSetChanged();
        return;
    L21:
        return;
    L23:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562099, r3, false);
    }
}
