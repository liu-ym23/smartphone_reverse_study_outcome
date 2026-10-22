package com.bytedance.android.anniex.container.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXFragment;", "Landroidx/fragment/app/Fragment;", "", "currentSchema", "Ljava/lang/String;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXFragment extends Fragment {
    private String currentSchema;
    public com.bytedance.android.anniex.base.builder.b d;
    public String e;
    public ia.d f;
    public ka.b g;
    public View h;
    public boolean i;
    public final Lazy j;
    public final b k;

    public static final class a {
    }

    public static final class b extends ia.d.a {
        public final /* synthetic */ AnnieXFragment a;

        @Override // ia.j
        public final void a() {
            this.a.requireActivity().finish();
        }

        @Override // ia.j
        public final View b() {
            ia.d r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.a(r0);
        }

        @Override // ia.j
        public final View c() {
            ia.d r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.b(r0);
        }

        public b(AnnieXFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public AnnieXFragment() {
        this.e = "default_bid";
        this.j = LazyKt.lazy(new AnnieXFragment$pageDelegate$2(this));
        this.k = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        ka.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        ia.d r1 = this.f;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    public final void onPause() {
        super.onPause();
        ia.d r0 = this.f;
        if (r0 == null) goto L5;
        r0.enterBackground();
    L5:
        ia.d r1 = this.f;
        if (r1 == null) goto L9;
        r1.onPause();
        return;
    }

    public final void onResume() {
        super.onResume();
        ia.d r0 = this.f;
        if (r0 == null) goto L5;
        r0.enterForeground();
    L5:
        ia.d r1 = this.f;
        if (r1 == null) goto L9;
        r1.onResume();
        return;
    }

    public final void onStart() {
        super.onStart();
        ia.d r0 = this.f;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public final void onStop() {
        super.onStop();
        ia.d r0 = this.f;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public final void onDetach() {
        super.onDetach();
    }

    public AnnieXFragment(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this();
        this.d = r10;
        this.e = r10.b;
        this.currentSchema = r10.c.getString("__x_inner_schema");
        this.i = r10.c.getBoolean("bundle_annie_x_flow");
        na.b r11 = (na.b) this.j.getValue();
        if (r11 == null) goto L6;
        r11.d();
        return;
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        ia.d r1 = this.f;
        if (r1 == null) goto L6;
        r1.onConfigurationChanged(r10);
    L6:
        if (this.g == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        return;
    }

    public final void onCreate(Bundle r10) {
        if (r10 == null) goto L6;
        int r0 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r10.getString("bid")) == false) goto L6;
        this.e = String.valueOf(r10.getString("bid"));
    L6:
        e.a r1 = e.c;
        FragmentActivity r11 = getActivity();
        String r12 = this.e;
        r1.getClass();
        if (e.a.a(r11, r12, "AnnieXFragment") == false) goto L9;
    L12:
        super.onCreate(r10);
        if (r10 == null) goto L22;
        this.currentSchema = r10.getString("__x_inner_schema");
        this.i = r10.getBoolean("bundle_annie_x_flow");
        com.bytedance.android.anniex.base.builder.b r13 = new com.bytedance.android.anniex.base.builder.b();
        String r14 = this.e;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.b = r14;
        r13.d(requireActivity());
        r13.b(r10);
        if (this.f == null) goto L17;
    L21:
        this.d = r13;
        goto L22
    L17:
        if (this.i == false) goto L19;
        ia.d r15 = new AnnieXFlowPageContainer(r13);
    L20:
        this.f = r15;
        goto L21
    L19:
        r15 = new com.bytedance.android.anniex.container.c(r13);
    L22:
        ia.d r16 = this.f;
        if (r16 == null) goto L25;
        r16.onCreate(r10);
    L25:
        ia.d r17 = this.f;
        if (r17 == null) goto L29;
        r17.l(this.k);
        return;
    L29:
        return;
    L9:
        if (com.bytedance.ies.bullet.service.base.h.p() == false) goto L12;
        HybridLogger r18 = HybridLogger.a;
        HybridLogger.m("AnnieXFragment", "tryInitAnnieXIfNeed failed, bid = " + this.e, null, null, 12);
        requireActivity().finish();
    }

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        super.onSaveInstanceState(r10);
        r10.putString("bid", this.e);
        r10.putString("__x_inner_schema", this.currentSchema);
        r10.putBoolean("bundle_on_reload", true);
        r10.putBoolean("bundle_annie_x_flow", this.i);
    }

    public final void setArguments(Bundle r1) {
        super.setArguments(r1);
    }

    public final void setUserVisibleHint(boolean r10) {
        super.setUserVisibleHint(r10);
        ia.d r0 = this.f;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r10);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        View r1 = this.h;
        if (r1 == null) goto L8;
        ia.d r12 = this.f;
        if (r12 == null) goto L8;
        r12.b(r1, r11);
    L8:
        if (this.g == null) goto L10;
        Intrinsics.checkNotNullParameter(r10, "view");
    L10:
        boolean r13 = false;
        if (r11 != null) goto L13;
    L15:
        if (r13 == false) goto L22;
        String r14 = this.currentSchema;
        if (r14 == null) goto L23;
        ia.d r15 = this.f;
        if (r15 == null) goto L24;
        r15.loadSchema(r14, null);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L13:
        if (r11.getBoolean("bundle_on_reload") != true) goto L15;
        r13 = true;
        goto L15
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        na.b r0 = (na.b) this.j.getValue();
        if (r0 == null) goto L6;
        r0.onActivityResult(r10, r11, r12);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        if (this.g == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "inflater");
    L5:
        View r13 = r10.inflate(2131558566, r11, false);
        this.h = r13;
        ia.d r14 = this.f;
        if (r14 == null) goto L9;
        r14.a(r13);
    L9:
        return this.h;
    }
}
