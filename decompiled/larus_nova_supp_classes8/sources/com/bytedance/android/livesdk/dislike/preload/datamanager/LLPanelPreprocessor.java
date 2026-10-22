package com.bytedance.android.livesdk.dislike.preload.datamanager;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveFeedbackManager;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.DislikeOptionsBottomDialog;
import com.bytedance.android.livesdk.dislike.m;
import com.bytedance.android.livesdk.dislike.preload.loader.LPPanelOriginDataLoader;
import com.bytedance.android.livesdk.dislike.preload.loader.b;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LLPanelPreprocessor {
    public final Lazy a;
    public final ActionsManager b;
    public final Lazy c;
    public final LPPanelOriginDataLoader d;
    public final b e;
    public final com.bytedance.android.livesdk.dislike.preload.loader.watchlater.a f;
    public final CompositeDisposable g;
    public final Lazy h;
    public final Context i;
    public final DataCenter j;
    public final Room k;
    public final String l;
    public final String m;
    public boolean n;
    public final Bundle o;
    public final Fragment p;

    public static final class a implements m {
        public final /* synthetic */ LLPanelPreprocessor a;

        @Override // com.bytedance.android.livesdk.dislike.m
        public final String a() {
            return this.a.a().V0;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void b() {
            this.a.a().ia0();
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final boolean c() {
            DislikeOptionsBottomDialog r0 = this.a.a();
            if (r0.ea0() == false) goto L9;
            ILiveFeedbackManager r1 = r0.R;
            if (r1 == null) goto L9;
            if (r1.enableOptionsStyle() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void dismiss() {
            this.a.a().dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public Context getContext() {
            return this.a.getContext();
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void refreshData() {
            LPPanelOriginDataLoader r0 = this.a.d;
            r0.e = true;
            r0.f();
        }

        public a(LLPanelPreprocessor r1) {
            this.a = r1;
        }
    }

    public final DislikeOptionsBottomDialog a() {
        return (DislikeOptionsBottomDialog) this.a.getValue();
    }

    public final Context getContext() {
        return this.i;
    }

    public LLPanelPreprocessor(Context r7, DataCenter r8, Room r9, String r10, String r11, boolean r12, Bundle r13, Fragment r14) {
        Intrinsics.checkNotNullParameter(r7, "context");
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.a = LazyKt.lazy(new LLPanelPreprocessor$dialog$2(this));
        a r1 = new a(this);
        if (r10 != null) goto L5;
        String r3 = "";
    L6:
        if (r11 != null) goto L8;
        String r4 = "";
    L9:
        this.b = new ActionsManager(r1, r9, r3, r4, r8);
        Lazy r15 = LazyKt.lazy(new LLPanelPreprocessor$session$2(this));
        this.c = r15;
        this.d = new LPPanelOriginDataLoader((com.bytedance.android.livesdk.dislike.preload.context.a) r15.getValue());
        this.e = new b((com.bytedance.android.livesdk.dislike.preload.context.a) r15.getValue());
        this.f = new com.bytedance.android.livesdk.dislike.preload.loader.watchlater.a((com.bytedance.android.livesdk.dislike.preload.context.a) r15.getValue());
        this.g = new CompositeDisposable();
        this.h = LazyKt.lazy(new LLPanelPreprocessor$loaders$2(this));
        return;
    L8:
        r4 = r11;
        goto L9
    L5:
        r3 = r10;
        goto L6
    }
}
