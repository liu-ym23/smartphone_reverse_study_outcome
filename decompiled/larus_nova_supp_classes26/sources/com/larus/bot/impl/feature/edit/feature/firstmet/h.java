package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextWatcher;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.IAudioService;
import com.larus.bot.impl.databinding.LarusLayoutBotFirstMetEditBinding;
import com.larus.bot.impl.feature.edit.feature.firstmet.sugget.BotSuggestsEditPanel;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotFirstMetEditTtsPlayer;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotFirstMetEditTtsPlayer$init$1;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final TraceFragment a;
    public final LarusLayoutBotFirstMetEditBinding b;
    public final p c;
    public final dv8.b d;
    public final Function0<Unit> e;
    public final Context f;
    public final LifecycleCoroutineScope g;
    public final BotFirstMetEditTtsPlayer h;
    public final g i;
    public BotSuggestsEditPanel j;
    public ObjectAnimator k;
    public int l;
    public int m;

    public static final class a implements TextWatcher {
        public final /* synthetic */ h a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            p r5 = this.a.c;
            if (r1 == null) goto L5;
            String r6 = r1.toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r5.dispatchUIAction(new l.e(r6));
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public final void a() {
        this.c.dispatchUIAction(new l.b(this.a.getArguments()));
        p r0 = this.c;
        final BotFirstMetEditTtsPlayer r2 = this.h;
        LifecycleOwner r3 = this.a.getViewLifecycleOwner();
        g r4 = this.i;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r2.a = r4;
        IAudioService r5 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r5 == null) goto L5;
        r5.s0(r4);
    L5:
        r2.d = new WeakReference(r3);
        r3.getLifecycle().addObserver(new BotFirstMetEditTtsPlayer$init$1(r2));
        r0.dispatchUIAction(new l.g());
        if (Build.VERSION.SDK_INT < 28) goto L9;
        int r1 = com.larus.utils.i.d(this.f) - c7.b(64);
        String r6 = this.f.getResources().getString(2131901106);
        StaticLayout r7 = com.larus.bot.impl.common.util.j.b(this.b.b, r6 + '\n' + r6, r1);
        StaticLayout r8 = com.larus.bot.impl.common.util.j.b(this.b.b, r6 + '\n' + r6 + '\n' + r6 + '\n' + r6, r1);
        this.l = r7.getHeight();
        this.m = r8.getHeight();
        this.b.b.setMinHeight(this.l);
        this.b.b.setMaxHeight(this.m);
    L9:
        com.larus.bot.impl.common.util.j.a(this.b.b);
        this.b.b.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(this.f.getResources().getInteger(2131427366), new b(this))});
        this.b.b.addTextChangedListener(new a(this));
        final dv8.b r9 = this.d;
        if (r9 == null) goto L12;
        this.b.b.setOnFocusChangeListener(new c(r9, this));
    L12:
        this.b.g.setOnClickListener(new d(this));
        e1.d(this.b.f, new e(this));
        this.a.getLifecycle().addObserver(new f(this));
        this.b.c.a.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.n());
        BuildersKt.launch$default(this.g, null, null, new BotFirstMetEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.c.getUiEvent(), new BotFirstMetEditView$bindObservers$2(this, null)), this.g);
        this.c.dispatchUIAction(l.h.a);
    }

    public h(TraceFragment r2, LarusLayoutBotFirstMetEditBinding r3, p r4, dv8.b r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "showVoiceChoosePage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r3.a.getContext();
        this.g = LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner());
        this.h = new BotFirstMetEditTtsPlayer();
        this.i = new g(this);
        this.l = c7.b(52);
        this.m = c7.b(100);
    }
}
