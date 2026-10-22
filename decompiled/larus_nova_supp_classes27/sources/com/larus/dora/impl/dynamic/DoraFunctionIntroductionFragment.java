package com.larus.dora.impl.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraFunctionIntroductionFragmentBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.view.DoraQueryTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraFunctionIntroductionFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraFunctionIntroductionFragmentBinding;", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDoraConnectStateChanged", "isConnected", "", "setupButton", "buttonInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "logEnterPage", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraFunctionIntroductionFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraFunctionIntroductionFragmentBinding f;
    public c59.q g;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraFunctionIntroductionFragment$Companion$DslOwenActionData;", "", "dialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "toastText", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslDialog;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;)V", "getDialog", "()Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "getToastText", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0059a {

            @SerializedName("dialog")
            private final c59.o dialog;

            @SerializedName("toast_text")
            private final c59.t toastText;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0059a) == true) goto L8;
                return false;
            L8:
                C0059a r6 = (C0059a) r5;
                if (Intrinsics.areEqual(this.dialog, r6.dialog) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.toastText, r6.toastText) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.o r0 = this.dialog;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.t r4 = this.toastText;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslOwenActionData(dialog=" + this.dialog + ", toastText=" + this.toastText + ')';
            }

            public C0059a() {
                this.dialog = null;
                this.toastText = null;
            }

            public final c59.o a() {
                return this.dialog;
            }

            public final c59.t b() {
                return this.toastText;
            }
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslActionType.values().length];
            r0[DslActionType.WAKEUP_AND_PLAY_TTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DslActionType.INTERNAL_JUMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DslActionType.JUMP_OWEN_AND_CHECK_SHOW_DIALOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "dora_feature_introduction_detail";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void T90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
        if (r1 == null) goto L6;
    L7:
        Bundle r2 = getArguments();
        if (r2 == null) goto L11;
        String r3 = r2.getString("current_page");
        if (r3 == null) goto L11;
    L12:
        DoraBuryPointManager.a.L("enter_page", MapsKt.mapOf(new Pair[]{TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1), TuplesKt.to("current_page", r3)}));
        return;
    L11:
        r3 = "dora_feature_introduction_detail";
    L6:
        r1 = "";
        goto L7
    }

    public DoraFunctionIntroductionFragment() {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r4) {
        super.V90(r4);
        c59.q r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a() != null) goto L8;
    L16:
        LarusDoraFunctionIntroductionFragmentBinding r5 = this.f;
        if (r5 == null) goto L25;
        AppCompatTextView r6 = r5.f;
        if (r6 == null) goto L26;
        com.larus.utils.e1.o(r6);
        return;
    L26:
        return;
    L25:
        return;
    L8:
        if (Intrinsics.areEqual(r0.a().c(), Boolean.TRUE) == true) goto L16;
        if (r4 == false) goto L16;
        W90(r0.a());
        LarusDoraFunctionIntroductionFragmentBinding r7 = this.f;
        if (r7 == null) goto L22;
        AppCompatTextView r8 = r7.f;
        if (r8 == null) goto L23;
        com.larus.utils.e1.x(r8);
        return;
    L23:
        return;
    }

    public final void W90(final c59.h r3) {
        LarusDoraFunctionIntroductionFragmentBinding r0 = this.f;
        if (r0 == null) goto L13;
        AppCompatTextView r1 = r0.f;
        if (r1 == null) goto L13;
        c59.t r2 = r3.b();
        if (r2 == null) goto L11;
        CharSequence r4 = c59.p.b(r2);
        if (r4 == null) goto L11;
    L12:
        r1.setText(r4);
    L11:
        r4 = "";
    L13:
        LarusDoraFunctionIntroductionFragmentBinding r5 = this.f;
        if (r5 == null) goto L19;
        AppCompatTextView r6 = r5.f;
        if (r6 == null) goto L20;
        com.larus.utils.e1.d(r6, new b1(r3, this));
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.widget.LinearLayout] */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        Bundle r16 = getArguments();
        if (r16 == null) goto L7;
        String r17 = r16.getString("arg_page_info");
        if (r17 == null) goto L7;
        Lazy r0 = c59.s.a;
        c59.q r18 = (c59.q) c59.s.b(r17, c59.q.class);
    L8:
        LarusDoraFunctionIntroductionFragmentBinding r1 = this.f;
        if (r1 == null) goto L13;
        ImageView r2 = r1.d;
        if (r2 == null) goto L13;
        r2.setOnClickListener(new c1(this));
    L13:
        c59.d0.a();
        DoraDevice r3 = DoraAdapterExtKt.h(kj4.a.g());
        Bundle r4 = getArguments();
        boolean r5 = true;
        if (r4 == null) goto L23;
        Integer r6 = Integer.valueOf(r4.getInt("product_id"));
        if (r6.intValue() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L23;
    L26:
        if (r18 == null) goto L117;
        this.g = r18;
        LarusDoraFunctionIntroductionFragmentBinding r8 = this.f;
        if (r8 == null) goto L32;
        SimpleDraweeView r9 = r8.b;
        if (r9 == null) goto L32;
        c59.p.d(r9, r18.c(), MapsKt.mapOf(TuplesKt.to("product", l59.a.d(r3))), r6);
    L32:
        LarusDoraFunctionIntroductionFragmentBinding r10 = this.f;
        if (r10 == null) goto L41;
        AppCompatTextView r11 = r10.e;
        if (r11 == null) goto L41;
        c59.t r12 = r18.e();
        if (r12 == null) goto L39;
        CharSequence r13 = c59.p.b(r12);
    L40:
        r11.setText(r13);
        goto L41
    L39:
        r13 = null;
    L41:
        List<c59.t> r20 = r18.b();
        if (r20 == null) goto L54;
        ?? r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L45:
        if (r22.hasNext() == false) goto L55;
        Object r23 = r22.next();
        String r24 = c59.p.b((c59.t) r23);
        if (r24 != null) goto L49;
    L51:
        boolean r25 = false;
    L52:
        if (r25 == false) goto L45;
        r21.add(r23);
        goto L45
    L49:
        if (com.larus.utils.o0.d(r24) != true) goto L51;
        r25 = true;
    L55:
        String r26 = CollectionsKt.joinToString$default((Iterable) r21, "\n", null, null, 0, null, new d1(), 30, null);
        Context r27 = getContext();
        if (r27 != null) goto L59;
        r27 = AppHost.a.getApplication();
    L59:
        if (com.larus.utils.o0.d(r26) == false) goto L65;
        LarusDoraFunctionIntroductionFragmentBinding r28 = this.f;
        if (r28 == null) goto L65;
        ?? r30 = r28.c;
        if (r30 == 0) goto L65;
        DoraQueryTextView r31 = new DoraQueryTextView(r27, null, 6, 0);
        r31.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.setMargins(0, 0, 0, c7.b(8));
        r31.setLayoutParams(r110);
        r31.setText(r26);
        int r32 = com.larus.utils.j0.a;
        r31.setTextColor(com.larus.utils.j0.a(2131103043));
        r31.setTextSize(17);
        r31.setImageVisible(false);
        r30.addView(r31);
    L65:
        List<c59.t> r33 = r18.d();
        if (r33 != null) goto L68;
        r33 = CollectionsKt.emptyList();
    L68:
        Iterator<c59.t> r34 = r33.iterator();
    L70:
        if (r34.hasNext() == false) goto L80;
        c59.t r35 = r34.next();
        LarusDoraFunctionIntroductionFragmentBinding r36 = this.f;
        if (r36 == null) goto L70;
        ?? r37 = r36.c;
        if (r37 == 0) goto L70;
        DoraQueryTextView r111 = new DoraQueryTextView(r27, null, 6, 0);
        r111.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.setMargins(0, 0, 0, c7.b(8));
        r111.setLayoutParams(r112);
        String r38 = c59.p.b(r35);
        if (r38 != null) goto L78;
        r38 = "";
    L78:
        r111.setText(r38);
        int r40 = com.larus.utils.j0.a;
        r111.setTextColor(com.larus.utils.j0.a(2131103046));
        r111.setTextSize(17);
        r111.setStartImage(2131240467);
        r111.b(c7.b(16), c7.b(16));
        r111.setImageVisible(true);
        r37.addView(r111);
        goto L70
    L80:
        if (r18.a() != null) goto L82;
    L99:
        LarusDoraFunctionIntroductionFragmentBinding r113 = this.f;
        if (r113 == null) goto L124;
        AppCompatTextView r114 = r113.f;
        if (r114 == null) goto L125;
        com.larus.utils.e1.q(r114);
        return;
    L125:
        return;
    L124:
        return;
    L82:
        if (Intrinsics.areEqual(r18.a().c(), Boolean.TRUE) == true) goto L99;
        W90(r18.a());
        if (kj4.a.g().getDoraLinkState(DoraAdapterExtKt.h(kj4.a.g())) == 2) goto L88;
        r5 = false;
    L88:
        if (r5 == false) goto L94;
        LarusDoraFunctionIntroductionFragmentBinding r115 = this.f;
        if (r115 == null) goto L118;
        AppCompatTextView r116 = r115.f;
        if (r116 == null) goto L119;
        com.larus.utils.e1.x(r116);
        return;
    L119:
        return;
    L118:
        return;
    L94:
        LarusDoraFunctionIntroductionFragmentBinding r117 = this.f;
        if (r117 == null) goto L121;
        AppCompatTextView r118 = r117.f;
        if (r118 == null) goto L122;
        com.larus.utils.e1.q(r118);
        return;
    L122:
        return;
    L121:
        return;
    L54:
        r21 = CollectionsKt.emptyList();
        goto L55
    L117:
        return;
    L18:
        r7 = false;
    L23:
        if (r3 == null) goto L25;
        r6 = Integer.valueOf(n1.c(r3));
        goto L26
    L25:
        r6 = null;
    L7:
        r18 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562184, r9, false);
        int r12 = 2131373372;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r11, 2131373372);
        if (r2 == null) goto L28;
        r12 = 2131373375;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131373375);
        if (r3 == null) goto L28;
        r12 = 2131373376;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131373376);
        if (r4 == null) goto L28;
        r12 = 2131373379;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r11, 2131373379);
        if (r5 == null) goto L28;
        r12 = 2131373389;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r11, 2131373389);
        if (r6 == null) goto L28;
        this.f = new LarusDoraFunctionIntroductionFragmentBinding(r11, r2, r3, r4, r5, r6);
        com.larus.utils.i0.a.getClass();
        int r13 = com.larus.utils.i0.g();
        int r14 = com.larus.utils.i0.e();
        LarusDoraFunctionIntroductionFragmentBinding r15 = this.f;
        if (r15 == null) goto L17;
        ImageView r16 = r15.d;
        if (r16 == null) goto L17;
        ViewGroup.LayoutParams r1 = r16.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r1;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r13 + i5.q();
        r16.setLayoutParams(r7);
    L17:
        LarusDoraFunctionIntroductionFragmentBinding r17 = this.f;
        if (r17 == null) goto L22;
        AppCompatTextView r18 = r17.f;
        if (r18 == null) goto L22;
        ViewGroup.LayoutParams r110 = r18.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        ((ViewGroup.MarginLayoutParams) r111).bottomMargin = r14 + i5.A();
        r18.setLayoutParams(r111);
    L22:
        LarusDoraFunctionIntroductionFragmentBinding r20 = this.f;
        if (r20 != null) goto L29;
        return null;
    L29:
        return r20.a;
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
