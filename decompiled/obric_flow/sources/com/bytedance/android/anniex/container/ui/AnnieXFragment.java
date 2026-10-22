package com.bytedance.android.anniex.container.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.container.k;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.o;
import s3.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "currentSchema", "Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnieXFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnieXFragment.kt\ncom/bytedance/android/anniex/container/ui/AnnieXFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n1#2:196\n*E\n"})
public final class AnnieXFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r3.b f3183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f3185c;
    private String currentSchema;
    public com.bytedance.ies.bullet.service.base.c d;
    public View e;
    public boolean f;
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f3186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f3187i;

    public AnnieXFragment() {
        this.f3184b = "default_bid";
        this.g = LazyKt.lazy(new AnnieXFragment$defaultTitleBar$2(this));
        this.f3186h = LazyKt.lazy(new AnnieXFragment$pageDelegate$2(this));
        this.f3187i = new a(this, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r5, int r10, Intent r11) {
        super.onActivityResult(r5, r10, r11);
        qo.a.i(this.f3186h.getValue());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        d r10 = this.f3185c;
        if (r10 == null) goto L6;
        r10.onConfigurationChanged(r5);
    L6:
        if (this.d == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (r5 == null) goto L14;
        String r10 = r5.getString("bid");
        if (r10 != null) goto L7;
        r10 = "default_bid";
    L7:
        this.f3184b = r10;
        this.currentSchema = r5.getString("__x_inner_schema");
        this.f = r5.getBoolean("bundle_annie_x_flow");
        r3.b r11 = new r3.b();
        String r12 = this.f3184b;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.f21653b = r12;
        FragmentActivity r13 = requireActivity();
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r11.f21647i = r13;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r11.f21652a = r13;
        Intrinsics.checkNotNullParameter(r5, "bundle");
        r11.f21654c.putAll(r5);
        if (this.f3185c == null) goto L10;
    L13:
        this.f3183a = r11;
        goto L14
    L10:
        if (this.f == false) goto L12;
        this.f3185c = new com.bytedance.android.anniex.lite.container.a(r11);
        goto L13
    L12:
        this.f3185c = new k(r11);
    L14:
        d r14 = this.f3185c;
        if (r14 == null) goto L17;
        r14.onCreate(r5);
    L17:
        d r15 = this.f3185c;
        if (r15 == null) goto L21;
        r15.a(this.f3187i);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        if (this.d == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "inflater");
    L5:
        View r12 = r5.inflate(R$layout.annie_x_fragment, r10, false);
        this.e = r12;
        if (r12 == null) goto L8;
        FrameLayout r13 = (FrameLayout) r12.findViewById(R$id.anniex_title_bar_container);
    L9:
        o.g(r13, this.f3185c, this.f3184b, (View) this.g.getValue(), getContext());
        d r14 = this.f3185c;
        if (r14 == null) goto L13;
        r14.a(this.e);
    L13:
        return this.e;
    L8:
        r13 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        d r5 = this.f3185c;
        if (r5 == null) goto L6;
        r5.release();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        d r5 = this.f3185c;
        if (r5 == null) goto L6;
        r5.enterBackground();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        d r5 = this.f3185c;
        if (r5 == null) goto L5;
        r5.enterForeground();
    L5:
        d r10 = this.f3185c;
        if (r10 == null) goto L9;
        r10.a();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        super.onSaveInstanceState(r5);
        r5.putString("bid", this.f3184b);
        r5.putString("__x_inner_schema", this.currentSchema);
        r5.putBoolean("bundle_on_reload", true);
        r5.putBoolean("bundle_annie_x_flow", this.f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        d r5 = this.f3185c;
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r10);
        View r11 = this.e;
        if (r11 == null) goto L8;
        d r12 = this.f3185c;
        if (r12 == null) goto L8;
        r12.b(r11);
    L8:
        if (this.d == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "view");
    L10:
        if (r10 != null) goto L12;
        return;
    L12:
        if (r10.getBoolean("bundle_on_reload") != true) goto L20;
        String r13 = this.currentSchema;
        if (r13 == null) goto L21;
        d r14 = this.f3185c;
        if (r14 == null) goto L22;
        r14.loadSchema(r13, null);
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setArguments(Bundle r5) {
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        d r10 = this.f3185c;
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }

    public AnnieXFragment(r3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this();
        this.f3183a = r5;
        this.f3184b = r5.f21653b;
        Bundle r10 = r5.f21654c;
        this.currentSchema = r10.getString("__x_inner_schema");
        this.f = r10.getBoolean("bundle_annie_x_flow");
        if (this.f3186h.getValue() != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }
}
