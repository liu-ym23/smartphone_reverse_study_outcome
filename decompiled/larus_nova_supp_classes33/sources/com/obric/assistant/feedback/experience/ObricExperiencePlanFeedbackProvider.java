package com.obric.assistant.feedback.experience;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.utils.i;
import com.obric.assistant.impl.databinding.ObricFeedbackExperiencePlanEntryBinding;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.text.OTextView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricExperiencePlanFeedbackProvider implements nga.a {
    public final CoroutineScope a;
    public ObricFeedbackExperiencePlanEntryBinding b;
    public WeakReference<Activity> c;
    public boolean d;
    public boolean e;
    public boolean f;

    @Override // nga.a
    public final void b() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.d == false) goto L24;
        this.f = true;
        ObricFeedbackExperiencePlanEntryBinding r1 = this.b;
        boolean r2 = false;
        if (r1 == null) goto L14;
        OCheckBoxLayout r3 = r1.b;
        if (r3 == null) goto L14;
        if (r3.isChecked() != true) goto L14;
        r2 = true;
    L14:
        if (r2 == false) goto L20;
        WeakReference<Activity> r4 = this.c;
        if (r4 == null) goto L18;
        Activity r5 = r4.get();
    L19:
        BuildersKt.launch$default(this.a, null, null, new ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1(true, r5, this, null), 3, null);
        return;
    L18:
        r5 = null;
        goto L19
    L20:
        this.e = true;
        return;
    }

    public ObricExperiencePlanFeedbackProvider() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static final void c(ObricExperiencePlanFeedbackProvider r1, final Activity r2) {
        r1.getClass();
        if (r2.isFinishing() == false) goto L5;
        return;
    L5:
        if (r2.isDestroyed() == true) goto L10;
        new Handler(Looper.getMainLooper()).post(new c(r2));
        return;
    }

    @Override // nga.a
    public final void a(ViewGroup r9, LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r9, "container");
        Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
        View r0 = LayoutInflater.from(r9.getContext()).inflate(2131563992, r9, false);
        int r1 = 2131365644;
        OCheckBoxLayout r3 = (OCheckBoxLayout) ViewBindings.findChildViewById(r0, 2131365644);
        if (r3 == null) goto L15;
        r1 = 2131371926;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131371926);
        if (r4 == null) goto L15;
        r1 = 2131371928;
        OTextView r5 = ViewBindings.findChildViewById(r0, 2131371928);
        if (r5 == null) goto L15;
        LinearLayout r2 = (LinearLayout) r0;
        final ObricFeedbackExperiencePlanEntryBinding r6 = new ObricFeedbackExperiencePlanEntryBinding(r2, r3, r4, r5);
        r9.removeAllViews();
        r9.addView(r2);
        ObricUserExperiencePlanManager r7 = ObricUserExperiencePlanManager.a;
        boolean r8 = !ObricUserExperiencePlanManager.b().b();
        this.d = r8;
        if (r8 == false) goto L11;
        int r11 = 0;
    L12:
        r2.setVisibility(r11);
        r3.setChecked(false);
        this.e = false;
        this.f = false;
        r4.setOnClickListener(new a(r6));
        r5.setText(com.obric.assistant.settings.experience.a.a(r5.getContext(), 2131912682, 2131104819));
        r5.setMovementMethod(LinkMovementMethod.getInstance());
        r5.setHighlightColor(0);
        this.b = r6;
        this.c = new WeakReference(i.getActivity(r9.getContext()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new ObricExperiencePlanFeedbackProvider$attach$3(this, r6, r10, null), 3, null);
        r10.getLifecycle().addObserver(new b(this));
        return;
    L11:
        r11 = 8;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
