package com.larus.voice_setting.voice.dialog.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusDialogAuthorizeUgcVoiceBinding;
import com.larus.voice_setting.impl.databinding.LarusItemAuthorizeUgcVoiceBinding;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceViewModel;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import tx9.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceAuthorizeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "getViewModel", "()Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bind", "Lcom/larus/voice_setting/impl/databinding/LarusDialogAuthorizeUgcVoiceBinding;", "enterFrom", NameKeys.UnloadStrategy_No_Strategy, "logTraceId", "enterMethod", "trackParams", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceAuthorizeFragment extends Fragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy d;
    public LarusDialogAuthorizeUgcVoiceBinding e;
    public String f;
    public String g;
    public String h;
    public JSONObject i;
    public Context j;

    public static final class a {
    }

    static {
    }

    public UgcVoiceAuthorizeFragment() {
        final Function0 r0 = new c(this);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(UgcVoiceViewModel.class), new UgcVoiceAuthorizeFragment$special$$inlined$viewModels$default$1(r0), new UgcVoiceAuthorizeFragment$special$$inlined$viewModels$default$2(r0, this));
        this.g = NameKeys.UnloadStrategy_No_Strategy;
        this.h = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 == null) goto L26;
        String r3 = r8.getString("authorize_enter_from");
        if (r3 != null) goto L7;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        this.f = r3;
        String r4 = r8.getString("key_log_trace_id", NameKeys.UnloadStrategy_No_Strategy);
        if (r4 != null) goto L10;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        this.g = r4;
        String r5 = r8.getString("key_enter_method", NameKeys.UnloadStrategy_No_Strategy);
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        this.h = r5;
        String r9 = r8.getString("track_params", NameKeys.UnloadStrategy_No_Strategy);
        if (r9 == null) goto L26;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        if (r9.length() <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        this.i = new JSONObject(r9);     // Catch: Throwable -> L23
    L21:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.box-impl(r11);
        goto L26
    L18:
        r10 = false;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        f2a.c r13 = com.larus.voice_setting.voice.utils.k.a.b("UgcVoiceAuthorizeFragment onCreate");
        r13.c.d = "UgcVoiceAuthorizeFragment.onCreate";
        LinkedHashMap r14 = new LinkedHashMap();
        f2a.f r15 = new f2a.f("enter_from");
        String r16 = this.f;
        if (r16 == null) goto L30;
        r2 = r16;
    L30:
        r14.put(r15, r2);
        r13.d(r14);
        List r0 = CollectionsKt.listOf(new String[]{this.g, "VoiceCreate"});
        f2a.g r1 = r13.c;
        r1.b = r0;
        r1.e = this.h;
        f2a.c.c(r13, null, 15);
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        Context r11 = requireContext();
        this.j = r11;
        LarusDialogAuthorizeUgcVoiceBinding r12 = this.e;
        if (r12 == null) goto L42;
        AppCompatImageView r0 = r12.f.b;
        Context r2 = null;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r11 = null;
    L7:
        Context r3 = this.j;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r3 = null;
    L10:
        r0.setColorFilter(ContextCompat.getColor(r11, v19.c.b(2130972079, r3, 2131103136)));
        LarusItemAuthorizeUgcVoiceBinding r13 = r12.d;
        TextView r1 = r13.d;
        Context r4 = this.j;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r4 = null;
    L13:
        r1.setText(r4.getText(2131911062));
        TextView r5 = r13.c;
        Context r6 = this.j;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r6 = null;
    L16:
        r5.setText(r6.getText(2131911063));
        AppCompatImageView r7 = r13.b;
        if (r7 == null) goto L19;
        r7.setImageResource(v19.c.b(2130971911, r7.getContext(), 2131242419));
    L19:
        AppCompatImageView r14 = r13.b;
        Context r8 = this.j;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r8 = null;
    L22:
        Context r15 = this.j;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r15 = null;
    L25:
        r14.setColorFilter(ContextCompat.getColor(r8, v19.c.b(2130972079, r15, 2131103136)));
        LarusItemAuthorizeUgcVoiceBinding r16 = r12.e;
        TextView r17 = r16.d;
        Context r18 = this.j;
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r18 = null;
    L28:
        r17.setText(r18.getText(2131911064));
        TextView r19 = r16.c;
        Context r20 = this.j;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r20 = null;
    L31:
        r19.setText(r20.getText(2131911065));
        AppCompatImageView r21 = r16.b;
        if (r21 == null) goto L34;
        r21.setImageResource(v19.c.b(2130971912, r21.getContext(), 2131242422));
    L34:
        AppCompatImageView r22 = r16.b;
        Context r23 = this.j;
        if (r23 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r23 = null;
    L37:
        Context r24 = this.j;
        if (r24 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L41:
        r22.setColorFilter(ContextCompat.getColor(r23, v19.c.b(2130972079, r2, 2131103136)));
        e1.d(r12.c, new com.larus.voice_setting.voice.dialog.v2.a(this));
        e1.d(r12.b, new b(this));
        goto L42
    L40:
        r2 = r24;
    L42:
        String r25 = this.f;
        String r110 = this.h;
        JSONObject r26 = this.i;
        if (r26 != null) goto L45;
        r26 = new JSONObject();
    L45:
        w2.c(r25, r110, r26, 8);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDialogAuthorizeUgcVoiceBinding r4 = LarusDialogAuthorizeUgcVoiceBinding.a(r1, r2);
        this.e = r4;
        return r4.a;
    }
}
