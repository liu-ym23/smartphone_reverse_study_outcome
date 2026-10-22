package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.comment.highlight.MarkHighlightApi;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<MarkHighlightController, Object> {
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;
    public MarkHighlightController b;
    public View c;

    public static final class a implements js0.b {
        public final /* synthetic */ a1 a;

        public a(a1 r1) {
            this.a = r1;
        }

        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            a1 r3 = this.a;
            View r0 = r3.c;
            if (r0 == null) goto L15;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = r3.a;
            if (r4 != null) goto L7;
        L9:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.a;
            if (r5 == null) goto L12;
            int r6 = r5.W();
        L13:
            com.bytedance.android.live.core.utils.a1.k(r0, r6);
            return;
        L12:
            r6 = 0;
            goto L13
        L7:
            if (r4.W() != 0) goto L9;
            int r7 = InputPanelSectionContainer.m;
            r6 = InputPanelSectionContainer.m;
            goto L13
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        MarkHighlightController r0 = this.b;
        if (r0 == null) goto L19;
        HighlightPreviewDialog r1 = r0.q;
        if (r1 != null) goto L17;
    L12:
        r0.q = null;
        Disposable r2 = r0.o;
        if (r2 == null) goto L15;
        r2.dispose();
    L15:
        int r3 = e72.c.a;
        e72.c.a(r0.t);
        r0.j(false);
        return;
    L17:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        MarkHighlightController r0 = this.b;
        if (r0 == null) goto L22;
        HighlightPreviewDialog r1 = r0.q;
        if (r1 != null) goto L20;
    L12:
        r0.q = null;
        r0.j(false);
        int r2 = e72.c.a;
        e72.c.a(r0.t);
        Disposable r3 = r0.n;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        r0.n = null;
        Disposable r4 = r0.o;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        r0.o = null;
        r0.p.dispose();
        r0.i.clearAnimation();
        return;
    L20:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a(this)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("MarkHighlightSectionProvider");
    }

    public a1() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return InputSectionType.MARK_HIGHLIGHT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10) {
        Intrinsics.checkNotNullParameter(r10, "panelBridge");
        Activity r0 = r10.getActivity();
        Disposable r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.a = r10;
        View r2 = LayoutInflater.from(r0).inflate(2131567713, null);
        this.c = r2;
        MarkHighlightController r3 = new MarkHighlightController(r2, r10);
        r3.e.setAdapter(r3.m);
        r3.e.addItemDecoration(new MarkHighlightController.SpaceItemDecoration(UtilityKotlinExtentionsKt.i(8)));
        RecyclerView r11 = r3.e;
        r11.setLayoutManager(new LinearLayoutManager(r11.getContext(), 0, false));
        r3.k(r3.c);
        long r4 = r3.w.Z();
        long r5 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        MarkHighlightApi.a.getClass();
        MarkHighlightApi r13 = (MarkHighlightApi) com.bytedance.android.live.network.c.b().e(MarkHighlightApi.class);
        if (r13 == null) goto L14;
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.highlight.a>> r14 = r13.getHighlightData(r4, r5);
        if (r14 == null) goto L14;
        Observable r15 = r14.subscribeOn(Schedulers.io());
        if (r15 == null) goto L14;
        Observable r16 = r15.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L14;
        r1 = r16.subscribe(new y0(r3), new z0(r3));
    L14:
        r3.n = r1;
        r3.l.setOnClickListener(new t0(r3));
        View r17 = r3.j;
        if (r17 == null) goto L17;
        r17.setOnClickListener(new u0(r3));
    L17:
        Unit r18 = Unit.INSTANCE;
        this.b = r3;
        return this.c;
    }
}
