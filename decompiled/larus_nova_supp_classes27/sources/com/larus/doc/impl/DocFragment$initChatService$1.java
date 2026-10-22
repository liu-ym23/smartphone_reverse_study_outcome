package com.larus.doc.impl;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.doc.api.IDocService;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.viewmodel.DocDetailViewModel;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.office.base.view.TextLoadingView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocFragment$initChatService$1 implements n39.c {
    public boolean a;
    public final /* synthetic */ DocFragment b;

    @Override // n39.c
    public final boolean isEnableVoiceInput() {
        return true;
    }

    @Override // n39.c
    public final void setToAiEdit() {
        boolean r0 = true;
        this.a = true;
        Fragment r1 = this.b.h;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L28;
        Fragment r3 = this.b.h;
        if (r3 == null) goto L29;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L30;
        va8.o r5 = r4.getAbility(va8.o.class);
        va8.g0 r6 = r4.getAbility(va8.g0.class);
        if (r5 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L31;
        if (r6 != null) goto L22;
    L24:
        r0 = false;
    L25:
        if (r0 == false) goto L32;
        r5.Yv();
        return;
    L32:
        return;
    L22:
        if (r6.YC() == true) goto L24;
    L31:
        return;
    L16:
        if (r5.hh() != true) goto L18;
        r7 = true;
        goto L19
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (r1.isAdded() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // n39.c
    public final boolean consumeToAiEdit() {
        boolean r0 = this.a;
        this.a = false;
        return r0;
    }

    @Override // n39.c
    public final int getChatInputHeight() {
        return this.b.aa0();
    }

    public final Function0<String> getIdGetter() {
        return new DocFragment$initChatService$1$getIdGetter$1(this.b);
    }

    @Override // n39.c
    public final kotlinx.coroutines.flow.i1<Boolean> getVoiceInputStatus() {
        f39.g r0 = s1a.a.g(this.b).getAbility(f39.g.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVoiceInputStatus();
    }

    @Override // n39.c
    public final boolean isChatInputVisible() {
        Fragment r0 = this.b.h;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isAdded() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // n39.c
    public final void onDocDeleted() {
        DocFragment r0 = this.b;
        if (r0.v1 == true) goto L30;
        r0.v1 = true;
        if (r0.isAdded() == false) goto L26;
        n39.c.a.a(this, "DocFragment", false, false, 12);
        DocFragment r1 = this.b;
        LarusLayoutDocDetailFragmentBinding r2 = r1.g;
        if (r2 == null) goto L11;
        ShimmerTextView r3 = r2.r;
        if (r3 == null) goto L11;
        r3.setTextColor(r1.getResources().getColor(2131103143));
    L11:
        LarusLayoutDocDetailFragmentBinding r4 = this.b.g;
        if (r4 == null) goto L16;
        ShimmerTextView r5 = r4.r;
        if (r5 == null) goto L16;
        r5.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    L16:
        LarusLayoutDocDetailFragmentBinding r6 = this.b.g;
        if (r6 == null) goto L21;
        ShimmerTextView r7 = r6.r;
        if (r7 == null) goto L21;
        r7.setText("");
    L21:
        LarusLayoutDocDetailFragmentBinding r8 = this.b.g;
        if (r8 == null) goto L26;
        ImageView r9 = r8.n;
        if (r9 == null) goto L26;
        com.larus.utils.e1.o(r9);
    L26:
        IDocSdkBaseService r10 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r10 == null) goto L31;
        r10.reportDocPageExit("delete");
        return;
    L31:
        return;
    }

    @Override // n39.c
    public final void onDocNeedUpdate() {
        if (this.b.isAdded() == false) goto L20;
        FLogger.a.i("DocFragment", "The doc has been migrate to fusion doc");
        String r0 = this.b.H;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        this.b.I = true;
    L13:
        DocActivity r2 = this.b.getActivity();
        if ((r2 instanceof DocActivity) == false) goto L16;
        DocActivity r3 = r2;
    L17:
        if (r3 == null) goto L21;
        r3.y1(this.b.f, 10);
        return;
    L21:
        return;
    L16:
        r3 = null;
        goto L17
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    }

    @Override // n39.c
    public final void onLoadFinishEventReported() {
        if (this.b.isAdded() == true) goto L5;
        return;
    L5:
        if ((this.b.getActivity() instanceof DocActivity) == false) goto L11;
        DocActivity r0 = this.b.getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.doc.impl.DocActivity");
        DocDetailViewModel r1 = r0.b;
        if (r1 == null) goto L12;
        r1.setHasReportLoadEvent(true);
        return;
    L12:
        return;
    }

    @Override // n39.c
    public final void requestChatInputFocus() {
        ViewGroup r0 = this.b.t;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L29;
        Fragment r3 = this.b.h;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L30;
        Fragment r5 = this.b.h;
        if (r5 == null) goto L21;
        t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L21;
        va8.o r7 = (va8.o) r6.getAbility(va8.o.class);
    L22:
        if (r7 != null) goto L24;
    L26:
        if (r1 == false) goto L31;
        va8.o.a.a(r7, true);
        r7.i00();
        return;
    L31:
        return;
    L24:
        if (r7.hh() == true) goto L26;
        r1 = true;
    L21:
        r7 = null;
        goto L22
    L30:
        return;
    L12:
        if (r3.isAdded() != true) goto L14;
        r4 = true;
        goto L15
    L29:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        r2 = true;
        goto L8
    }

    @Override // n39.c
    public final void selectCurrentSentenceOrParagraph() {
        if (this.b.isAdded() == false) goto L12;
        Fragment r0 = this.b.h;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isAdded() == false) goto L14;
        va8.l0 r1 = s1a.a.g(r0).getAbility(va8.l0.class);
        if (r1 == null) goto L15;
        r1.A90();
        return;
    L15:
        return;
    L14:
        return;
    }

    public DocFragment$initChatService$1(DocFragment r1) {
        this.b = r1;
    }

    @Override // n39.c
    public final Object getAppIconUrl(Continuation<? super String> r5) {
        if ((r5 instanceof DocFragment$initChatService$1$getAppIconUrl$1) == false) goto L7;
        DocFragment$initChatService$1$getAppIconUrl$1 r0 = (DocFragment$initChatService$1$getAppIconUrl$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        String r7 = (String) r6;
        if (r7 == null) goto L25;
        return r7;
    L25:
        return "";
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IDocService r8 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r8 == null) goto L23;
        r0.label = 1;
        r6 = r8.getAppIconUrl(r0);
        if (r6 != r2) goto L19;
        return r2;
    L23:
        return "";
    L7:
        r0 = new DocFragment$initChatService$1$getAppIconUrl$1(this, r5);
        goto L8
    }

    @Override // n39.c
    public final void getLatestMessageId(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        String r0 = this.b.ea0();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r2.invoke(r0);
    }

    @Override // n39.c
    public final void onDocStateChanged(boolean r4) {
        FLogger.a.i("DocFragment", "[onDocStateChanged] isEmpty:" + r4);
        if (this.b.isAdded() == false) goto L6;
        DocFragment r0 = this.b;
        r0.M = r4;
        r0.va0(false);
        return;
    }

    @Override // n39.c
    public final void setChatInputVisibility(boolean r4) {
        FLogger.a.i("DocFragment", "setChatInputVisibility, isHidden = " + r4);
        DocFragment r0 = this.b;
        r0.J2 = r4;
        if (r4 == false) goto L8;
        TextLoadingView r1 = r0.u;
        if (r1 == null) goto L12;
        com.larus.utils.e1.o(r1);
    L12:
        boolean r5 = !r4;
        this.b.Ba0(r5);
        DocFragment.za0(this.b, r5, 2);
        this.b.ka0(r5);
        this.b.la0();
        return;
    L8:
        if (r0.J == 0) goto L12;
        TextLoadingView r2 = r0.u;
        if (r2 == null) goto L12;
        com.larus.utils.e1.x(r2);
        goto L12
    }

    @Override // n39.c
    public final void notifyInitChatInput(ViewGroup r8, FragmentManager r9) {
        int r0 = m39.b.a;
        m39.b.a("文档渲染完毕, onLoadSuccess");
        FLogger r1 = FLogger.a;
        r1.i("[doc_input_focus]", "notifyInitChatInput called container=" + r8 + " prev=" + this.b.s);
        if (r8 == null) goto L5;
        this.b.s = r8;
    L5:
        this.b.ra0();
        DocFragment r10 = this.b;
        r10.getClass();
        r1.i("[DocTracer]", "DocFragment, integrateFloatChatFragment");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Result.constructor-impl(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new DocFragment$integrateFloatChatFragment$1$1(r10, r9, null), 3, null));     // Catch: Throwable -> L8
    L10:
        DocFragment.za0(this.b, false, 3);
        return;
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // n39.c
    public final void setEnableVoiceInput(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        if (this.b.isAdded() == false) goto L8;
        f39.g r0 = s1a.a.g(this.b).getAbility(f39.g.class);
        if (r0 == null) goto L9;
        r0.Qe(r3, r4);
        return;
    L9:
        return;
    }

    @Override // n39.c
    public final void setChatInputVisible(String r4, final boolean r5, final boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "from");
        FLogger.a.i("DocFragment", "setChatInputVisible, from = " + r4 + ", visible = " + r5 + ", aiEditMode = " + r6 + ", normalMode = " + r7);
        if (r5 == false) goto L10;
        DocFragment r8 = this.b;
        if (r8.B == false) goto L10;
        if (r8.J2 == false) goto L10;
        return;
    L10:
        if (this.b.isAdded() == false) goto L13;
        Handler r9 = com.larus.utils.t0.a;
        final DocFragment r10 = this.b;
        r9.post(new w0(r5, r10, r6));
        return;
    }
}
