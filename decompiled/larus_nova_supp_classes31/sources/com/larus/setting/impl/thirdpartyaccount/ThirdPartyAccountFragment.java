package com.larus.setting.impl.thirdpartyaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.setting.impl.databinding.LarusThirdPartyAccountManagePageBinding;
import com.larus.setting.impl.thirdpartyaccount.view.ThirdPartyAccountAdapter;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/ThirdPartyAccountFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusThirdPartyAccountManagePageBinding;", "viewModel", "Lcom/larus/setting/impl/thirdpartyaccount/ThirdPartyAccountViewModel;", "getViewModel", "()Lcom/larus/setting/impl/thirdpartyaccount/ThirdPartyAccountViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/setting/impl/thirdpartyaccount/view/ThirdPartyAccountAdapter;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "processSelectItem", "scene", "", "thirdPartyKey", "", "makeSelectItemLoading", "onDestroy", "autoLogEnterPage", "", "getCurrentPageName", "getPageName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ThirdPartyAccountFragment extends TraceFragment {
    public static final /* synthetic */ int h = 0;
    public LarusThirdPartyAccountManagePageBinding e;
    public final Lazy f;
    public ThirdPartyAccountAdapter g;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String getPageName() {
        return "third_party_account_management_page";
    }

    public final String k() {
        return "third_party_account_management_page";
    }

    public ThirdPartyAccountFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ThirdPartyAccountViewModel.class), new ThirdPartyAccountFragment$special$$inlined$activityViewModels$default$1(this), new ThirdPartyAccountFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ThirdPartyAccountAdapter r0 = this.g;
        if (r0 == null) goto L28;
        List<ct9.a> r1 = r0.a;
        if (r1 == null) goto L28;
        ct9.a r2 = (ct9.a) CollectionsKt.first(r1);
        if (r2 == null) goto L28;
        List<ct9.b> r3 = r2.c;
        if (r3 == null) goto L28;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((ct9.b) r6).c, Boolean.TRUE) == false) goto L12;
        r4.add(r6);
        goto L12
    L16:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r8 = r4.iterator();
    L18:
        if (r8.hasNext() == false) goto L27;
        ct9.b r9 = (ct9.b) r8.next();
        String r10 = r9.a;
        if (Intrinsics.areEqual(r10, "qqmusic") == false) goto L23;
        String r11 = "qq";
    L26:
        r7.add(r11);
        goto L18
    L23:
        if (Intrinsics.areEqual(r10, "luna") == false) goto L25;
        r11 = "soda";
        goto L26
    L25:
        r11 = r9.a;
        goto L26
    L27:
        String r12 = CollectionsKt.joinToString$default(r7, ",", null, null, 0, null, null, 62, null);
    L29:
        JSONObject r13 = new JSONObject();
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r12 != null) goto L37;
    L35:
        TrackParams r14 = new TrackParams().merge(r13);
        by7.a r15 = new by7.a("third_party_account_management_settings");
        r15.a.merge(r14);
        r15.b();
        return;
    L37:
        r13.put("authorize_scopes", r12);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        FLogger.a.e("FirstPartyEventHelper", "error in FirstPartyEventHelper mobThirdPartyAccountManagementSettings " + e.getLocalizedMessage());
    L28:
        r12 = null;
        goto L29
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        ((ThirdPartyAccountViewModel) this.f.getValue()).fetchThirdPartyAccountInfo();
        LarusThirdPartyAccountManagePageBinding r10 = this.e;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.c;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, r0.getContext().getString(2131908012), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.setting.impl.thirdpartyaccount.a(this), 14);
    L7:
        LarusThirdPartyAccountManagePageBinding r11 = this.e;
        if (r11 == null) goto L12;
        RecyclerView r12 = r11.b;
        if (r12 == null) goto L12;
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext()));
    L12:
        ThirdPartyAccountAdapter r13 = new ThirdPartyAccountAdapter();
        this.g = r13;
        LarusThirdPartyAccountManagePageBinding r14 = this.e;
        if (r14 == null) goto L17;
        RecyclerView r15 = r14.b;
        if (r15 == null) goto L17;
        r15.setAdapter(r13);
    L17:
        r13.b = new b(this);
        ((ThirdPartyAccountViewModel) this.f.getValue()).getPageData().observe(getViewLifecycleOwner(), new a(new c(this)));
        ((ThirdPartyAccountViewModel) this.f.getValue()).getEditResult().observe(getViewLifecycleOwner(), new a(new d(this)));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131563161, r4, false);
        LinearLayout r7 = (LinearLayout) r6;
        int r8 = 2131384070;
        RecyclerView r0 = ViewBindings.findChildViewById(r6, 2131384070);
        if (r0 == null) goto L9;
        r8 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L9;
        this.e = new LarusThirdPartyAccountManagePageBinding(r7, r0, r1);
        return r7;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r8)));
    }
}
