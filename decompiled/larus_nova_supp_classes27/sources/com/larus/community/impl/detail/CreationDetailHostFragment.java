package com.larus.community.impl.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.community.host.databinding.LarusFragmentCreationDetailHostBinding;
import com.larus.platform.api.creation.UserCreation;
import com.larus.trace.tracknode.TraceFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailHostFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/api/spi/ICommunityDetailContainer;", "<init>", "()V", "binding", "Lcom/larus/community/host/databinding/LarusFragmentCreationDetailHostBinding;", "gson", "Lcom/google/gson/Gson;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCommunityDetailLoaded", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "handleCommunityActivityResult", "data", "Landroid/content/Intent;", "onCommunityBackPressed", "findCreationDetailResultHandler", "Lcom/larus/community/api/spi/ICommunityDetailActivityResultHandler;", "autoLogEnterPage", "getCurrentPageName", "", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailHostFragment extends TraceFragment implements e29.g {
    public static final /* synthetic */ int g = 0;
    public LarusFragmentCreationDetailHostBinding e;
    public final Gson f;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "CreationDetailHostFragment";
    }

    public final void onDestroyView() {
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // e29.g
    public final boolean K20() {
        LarusFragmentCreationDetailHostBinding r0 = this.e;
        if (r0 == null) goto L9;
        ViewPager2 r1 = r0.b;
        if (r1 == null) goto L9;
        if (r1.getCurrentItem() != 1) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L16;
        LarusFragmentCreationDetailHostBinding r3 = this.e;
        if (r3 == null) goto L18;
        ViewPager2 r4 = r3.b;
        if (r4 == null) goto L19;
        r4.setCurrentItem(0, true);
        return true;
    L19:
        return true;
    L18:
        return true;
    L16:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public CreationDetailHostFragment() {
        this.f = new Gson();
    }

    @Override // e29.g
    public final boolean g40(final UserCreation r5) {
        Intrinsics.checkNotNullParameter(r5, "userCreation");
        LarusFragmentCreationDetailHostBinding r0 = this.e;
        if (r0 == null) goto L12;
        final ViewPager2 r1 = r0.b;
        if (r1 == null) goto L14;
        final Bundle r2 = getArguments();
        if (r2 != null) goto L10;
        r2 = new Bundle();
        setArguments(r2);
    L10:
        r2.putString("creation", GsonProtectorUtils.toJson(this.f, r5));
        r1.post(new e0(this, r1, r2, r5));
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    @Override // e29.g
    public final void j6(Intent r5) {
        List r0 = getChildFragmentManager().getFragments();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof e29.f) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        e29.f r4 = (e29.f) CollectionsKt.firstOrNull(r1);
        if (r4 == null) goto L17;
        r4.j6(r5);
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        Bundle r8 = getArguments();
        if (r8 != null) goto L5;
        r8 = new Bundle();
    L5:
        String r9 = r8.getString("creation");
        boolean r0 = true;
        Object r1 = null;
        if (r9 != null) goto L8;
    L21:
        LarusFragmentCreationDetailHostBinding r10 = this.e;
        if (r10 == null) goto L37;
        ViewPager2 r11 = r10.b;
        if (r11 != null) goto L26;
        return;
    L26:
        if (r1 == null) goto L28;
        boolean r4 = true;
    L29:
        r11.setAdapter(new CreationDetailHostPagerAdapter(this, r8, r4));
        r11.setOffscreenPageLimit(1);
        if (r1 != null) goto L33;
        r0 = false;
    L33:
        r11.setUserInputEnabled(r0);
        r11.setCurrentItem(0, false);
        r11.setPageTransformer(new d0());
        return;
    L28:
        r4 = false;
        goto L29
    L37:
        return;
    L8:
        if ((!StringsKt.isBlank(r9)) == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L21;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl((UserCreation) xt7.d.b.c(UserCreation.Companion.serializer(), r9));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r12) == true) goto L20;
        r1 = r12;
    L20:
        r1 = (UserCreation) r1;
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562372, r3, false);
        ViewPager2 r6 = ViewBindings.findChildViewById(r5, 2131392572);
        if (r6 == null) goto L7;
        ConstraintLayout r7 = r5;
        this.e = new LarusFragmentCreationDetailHostBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131392572)));
    }
}
