package com.larus.dora.impl.noti_v3.service_notification.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraDialogServiceNotificationSheetBinding;
import com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel;
import com.larus.dora.impl.view.DoraTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t59.b;
import t59.c;
import t59.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/noti_v3/service_notification/ui/NotificationBroadcastV3ServiceNotificationBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogServiceNotificationSheetBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraDialogServiceNotificationSheetBinding;", "viewModel", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter;", "getAdapter", "()Lcom/larus/dora/impl/noti_v3/service_notification/ui/DoraServiceNotificationAdapter;", "adapter$delegate", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "observeData", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3ServiceNotificationBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraDialogServiceNotificationSheetBinding d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public NotificationBroadcastV3ServiceNotificationBottomSheetDialogFragment() {
        this.e = LazyKt.lazy(new c(this));
        this.f = LazyKt.lazy(new d(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        LarusDoraDialogServiceNotificationSheetBinding r7 = this.d;
        if (r7 == null) goto L7;
        AppCompatImageView r8 = r7.c;
        if (r8 == null) goto L7;
        r8.setOnClickListener(new b(this));
    L7:
        LarusDoraDialogServiceNotificationSheetBinding r9 = this.d;
        if (r9 == null) goto L12;
        RecyclerView r10 = r9.b;
        if (r10 == null) goto L12;
        r10.setLayoutManager(new LinearLayoutManager(getContext()));
    L12:
        LarusDoraDialogServiceNotificationSheetBinding r11 = this.d;
        if (r11 == null) goto L17;
        RecyclerView r12 = r11.b;
        if (r12 == null) goto L17;
        r12.setAdapter((DoraServiceNotificationAdapter) this.f.getValue());
    L17:
        q59.a r13 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.b) ((NotificationBroadcastV3ViewModel) this.e.getValue()).getUiState$impl_mainlandRelease().getValue()).h;
        if (r13 != null) goto L20;
    L22:
        List<s59.a> r14 = CollectionsKt.listOf(new s59.a[]{new s59.a("finance_security", 2131902287, 2131902288, 2131240535), new s59.a("schedule", 2131902294, 2131902295, 2131240538), new s59.a("life_service", 2131902289, 2131902290, 2131240537), new s59.a("news_info", 2131902291, 2131902292, 2131240536), new s59.a("entertainment_recommendation", 2131902285, 2131902286, 2131240534)});
        List<String> r15 = ((NotificationBroadcastV3ViewModel) this.e.getValue()).getEnabledServiceIds();
        Iterator<T> r0 = r14.iterator();
    L24:
        if (r0.hasNext() == false) goto L26;
        s59.a r1 = (s59.a) r0.next();
        r1.e = r15.contains(r1.a);
        goto L24
    L26:
        DoraServiceNotificationAdapter r16 = (DoraServiceNotificationAdapter) this.f.getValue();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r14, "newItems");
        r16.b = r14;
        r16.notifyDataSetChanged();
        return;
    L20:
        if (r13.g == null) goto L22;
        Unit r17 = Unit.INSTANCE;
        goto L22
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562170, r4, false);
        int r7 = 2131369751;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131369751);
        if (r8 == null) goto L11;
        r7 = 2131369753;
        AppCompatImageView r0 = ViewBindings.findChildViewById(r6, 2131369753);
        if (r0 == null) goto L11;
        r7 = 2131369754;
        if (((DoraTextView) ViewBindings.findChildViewById(r6, 2131369754)) == null) goto L11;
        ConstraintLayout r9 = r6;
        this.d = new LarusDoraDialogServiceNotificationSheetBinding(r9, r8, r0);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
