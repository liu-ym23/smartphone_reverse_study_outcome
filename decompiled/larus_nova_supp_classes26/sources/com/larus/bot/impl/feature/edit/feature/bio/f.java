package com.larus.bot.impl.feature.edit.feature.bio;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextWatcher;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.n;
import com.larus.bot.impl.databinding.LarusLayoutBotBioEditBinding;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final LarusLayoutBotBioEditBinding a;
    public final i b;
    public final Context c;
    public final LifecycleCoroutineScope d;
    public ObjectAnimator e;
    public int f;
    public int g;

    public static final class a implements TextWatcher {
        public final /* synthetic */ f a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            i r5 = this.a.b;
            if (r1 == null) goto L5;
            String r6 = r1.toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r5.dispatchUIAction(new com.larus.bot.impl.feature.edit.feature.bio.a.b(r6));
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public final void a() {
        this.b.dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a.C0065a.a);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        int r0 = com.larus.utils.i.d(this.c) - c7.b(64);
        String r1 = this.c.getResources().getString(2131901106);
        StaticLayout r2 = com.larus.bot.impl.common.util.j.b(this.a.b, r1 + '\n' + r1, r0);
        StaticLayout r3 = com.larus.bot.impl.common.util.j.b(this.a.b, r1 + '\n' + r1 + '\n' + r1 + '\n' + r1, r0);
        this.f = r2.getHeight();
        this.g = r3.getHeight();
        this.a.b.setMinHeight(this.f);
        this.a.b.setMaxHeight(this.g);
    L6:
        com.larus.bot.impl.common.util.j.a(this.a.b);
        this.a.b.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(this.c.getResources().getInteger(2131427364), new e(this))});
        this.a.b.addTextChangedListener(new a(this));
        this.a.c.a.setOnTouchListener(new n());
        BuildersKt.launch$default(this.d, null, null, new BotBioEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.b.getUiEvent(), new BotBioEditView$bindObservers$2(this, null)), this.d);
        this.b.dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a.c.a);
    }

    public f(TraceFragment r2, LarusLayoutBotBioEditBinding r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r3;
        this.b = r4;
        this.c = r3.a.getContext();
        this.d = LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner());
        this.f = c7.b(52);
        this.g = c7.b(100);
    }
}
