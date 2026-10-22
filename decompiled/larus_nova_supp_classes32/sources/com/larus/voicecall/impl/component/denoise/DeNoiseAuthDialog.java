package com.larus.voicecall.impl.component.denoise;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.home.impl.sdk.f1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.y0;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusDialogFragmentDenoiseAuthBinding;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B-\b\u0007\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/DeNoiseAuthDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "onAuth", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "onReject", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnAuth", "()Lkotlin/jvm/functions/Function0;", "getOnReject", "mobPayloadJson", "Lorg/json/JSONObject;", "getMobPayloadJson", "()Lorg/json/JSONObject;", "setMobPayloadJson", "(Lorg/json/JSONObject;)V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusDialogFragmentDenoiseAuthBinding;", "isAllowed", NameKeys.UnloadStrategy_No_Strategy, "getTheme", NameKeys.UnloadStrategy_No_Strategy, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "mobAuthKnownClicked", "openPrivacyLink", "mobDialogClick", "clickFrom", NameKeys.UnloadStrategy_No_Strategy, "mobDialogShow", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeNoiseAuthDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int i = 0;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public JSONObject f;
    public LarusDialogFragmentDenoiseAuthBinding g;
    public boolean h;

    public static final class a {
    }

    public static final class b implements UrlSpanTextView.a {
        public final /* synthetic */ DeNoiseAuthDialog a;

        public b(DeNoiseAuthDialog r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, LynxEventReporter.PROP_NAME_URL);
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            DeNoiseAuthDialog r6 = this.a;
            int r0 = DeNoiseAuthDialog.i;
            r6.T90("know_more");
            LarusDialogFragmentDenoiseAuthBinding r7 = this.a.g;
            if (r7 == null) goto L13;
            ConstraintLayout r8 = r7.a;
            if (r8 == null) goto L14;
            IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r1 == null) goto L15;
            r1.e0();
            f1.a.e(r8.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", y0.a.a())}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    static {
    }

    public DeNoiseAuthDialog() {
        this(null, null);
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.g = null;
    }

    public static void S90(DeNoiseAuthDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(String r4) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = this.f;
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        r1.put("click_from", r4);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("noise_free_setting_popup_click", r1);
    }

    public DeNoiseAuthDialog(Function0<Unit> r1, Function0<Unit> r2) {
        this.d = r1;
        this.e = r2;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        if (this.d != null) goto L6;
        FLogger.a.e("DeNoiseAuthDialog", "onAuth is null");
        S90(this);
        return;
    L6:
        LarusDialogFragmentDenoiseAuthBinding r7 = this.g;
        if (r7 == null) goto L11;
        AppCompatTextView r8 = r7.c;
        if (r8 == null) goto L11;
        e1.d(r8, new com.larus.voicecall.impl.component.denoise.a(this));
    L11:
        LarusDialogFragmentDenoiseAuthBinding r9 = this.g;
        if (r9 == null) goto L16;
        AppCompatButton r10 = r9.b;
        if (r10 == null) goto L16;
        e1.d(r10, new com.larus.voicecall.impl.component.denoise.b(this));
    L16:
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        Locale r12 = Locale.CHINA;
        String r13 = getString(2131911034);
        int r2 = j0.a;
        String r14 = String.format(r12, r13, Arrays.copyOf(new Object[]{j0.d(2131907351)}, 1));
        LarusDialogFragmentDenoiseAuthBinding r15 = this.g;
        if (r15 == null) goto L21;
        UrlSpanTextView r16 = r15.e;
        if (r16 == null) goto L21;
        r16.setUrlSpannedText(r14 + "<a href=\"pp\">" + getString(2131911035) + "</a>");
    L21:
        LarusDialogFragmentDenoiseAuthBinding r17 = this.g;
        if (r17 == null) goto L26;
        UrlSpanTextView r18 = r17.e;
        if (r18 == null) goto L26;
        r18.setOnClickListener(new b(this));
    L26:
        Dialog r19 = getDialog();
        if (r19 == null) goto L29;
        r19.setOnShowListener(new c(this));
    L29:
        Dialog r20 = getDialog();
        if (r20 == null) goto L32;
        r20.setOnDismissListener(new d(this));
    L32:
        LarusDialogFragmentDenoiseAuthBinding r21 = this.g;
        if (r21 == null) goto L38;
        AppCompatImageView r22 = r21.d;
        if (r22 == null) goto L39;
        r22.setOnClickListener(new e(this));
        return;
    L39:
        return;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562072, r8, false);
        int r11 = 2131364647;
        AppCompatButton r2 = ViewBindings.findChildViewById(r10, 2131364647);
        if (r2 == null) goto L17;
        r11 = 2131364648;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r10, 2131364648);
        if (r3 == null) goto L17;
        r11 = 2131374717;
        if (ViewBindings.findChildViewById(r10, 2131374717) == null) goto L17;
        r11 = 2131376171;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r10, 2131376171);
        if (r4 == null) goto L17;
        r11 = 2131391531;
        UrlSpanTextView r5 = ViewBindings.findChildViewById(r10, 2131391531);
        if (r5 == null) goto L17;
        r11 = 2131391739;
        if (ViewBindings.findChildViewById(r10, 2131391739) == null) goto L17;
        ConstraintLayout r12 = r10;
        this.g = new LarusDialogFragmentDenoiseAuthBinding(r12, r2, r3, r4, r5);
        return r12;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
