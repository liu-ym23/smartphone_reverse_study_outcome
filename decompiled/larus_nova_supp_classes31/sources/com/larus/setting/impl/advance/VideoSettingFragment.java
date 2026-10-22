package com.larus.setting.impl.advance;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.setting.impl.databinding.LarusVideoDataModelSettingBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.e7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/larus/setting/impl/advance/VideoSettingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusVideoDataModelSettingBinding;", "videoSettings", "Ljava/util/ArrayList;", "Lcom/larus/setting/impl/advance/VideoSettingFragment$VideoSearchType;", "Lkotlin/collections/ArrayList;", "model", "Lcom/larus/setting/impl/advance/VideoSettingViewModel;", "getModel", "()Lcom/larus/setting/impl/advance/VideoSettingViewModel;", "model$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initData", "type", "", "newAsrModelItem", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "data", "resetStatus", "resetSelected", "onDestroyView", "VideoSearchType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VideoSettingFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public LarusVideoDataModelSettingBinding d;
    public ArrayList<a> e;
    public final Lazy f;

    public static final class a {
        public final String a;
        public final int b;
        public boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "VideoSearchType(name=" + this.a + ", id=" + this.b + ", isSelected=" + this.c + ')';
        }

        public a() {
            this("", 0, false);
        }

        public a(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public VideoSettingFragment() {
        final Function0<Fragment> r0 = new VideoSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VideoSettingViewModel.class), new VideoSettingFragment$special$$inlined$viewModels$default$2(r0), new VideoSettingFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onAttach(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super.onAttach(r6);
        this.e = CollectionsKt.arrayListOf(new a[]{new a(getResources().getString(2131899949), 0, true), new a(getResources().getString(2131899952), 1, false), new a(getResources().getString(2131899951), 2, false)});
        int r7 = UserSettingDelegate.b.S();
        ArrayList<a> r0 = this.e;
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        a r2 = (a) r1.next();
        if (r2.b != r7) goto L10;
        boolean r4 = true;
    L11:
        r2.c = r4;
        goto L6
    L10:
        r4 = false;
        goto L11
    L16:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.setting.impl.advance.p, java.lang.Object, kotlin.jvm.functions.Function1] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        LarusVideoDataModelSettingBinding r13 = this.d;
        if (r13 == null) goto L23;
        final LinearLayout r14 = r13.a;
        Intrinsics.checkNotNull(r14);
        ?? r0 = new p(r14);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r0, "callback");
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(r14);
        if (r1 == null) goto L9;
        Insets r2 = r1.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r2 == null) goto L9;
        r0.invoke(r2);
    L9:
        ViewCompat.setOnApplyWindowInsetsListener(r14, new e7(r14, r0));
        NovaTitleBarEx.Y5(r13.b, getString(2131899947), null, null, 6);
        NovaTitleBarEx.b6(r13.b, 2131241477, false, null, null, new q(this), 14);
        ArrayList<a> r15 = this.e;
        if (r15 == null) goto L29;
        Iterator<T> r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L30;
        final a r3 = (a) r16.next();
        final ViewGroup r4 = new ItemTextSelector(requireContext());
        if (r3.a.length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r4 = null;
    L21:
        if (r4 == null) goto L13;
        r13.c.addView(r4);
        goto L13
    L20:
        r4.setText(r3.a);
        r4.setTag(Integer.valueOf(r3.b));
        r4.setSelected(r3.c);
        r4.setOnClickListener(new r(this, r3, r4));
        goto L21
    L17:
        r5 = false;
        goto L18
    L30:
        return;
    L29:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131563197, r4, false);
        LinearLayout r7 = (LinearLayout) r6;
        int r8 = 2131384827;
        if (((LinearLayout) ViewBindings.findChildViewById(r6, 2131384827)) == null) goto L13;
        r8 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r6, 2131385238)) == null) goto L13;
        r8 = 2131388772;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r0 == null) goto L13;
        r8 = 2131392366;
        ItemGroup r1 = ViewBindings.findChildViewById(r6, 2131392366);
        if (r1 == null) goto L13;
        this.d = new LarusVideoDataModelSettingBinding(r7, r0, r1);
        return r7;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r8)));
    }
}
