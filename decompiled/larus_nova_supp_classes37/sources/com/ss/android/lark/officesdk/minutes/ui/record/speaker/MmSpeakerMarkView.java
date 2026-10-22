package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.e;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSearchInputView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kwb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSpeakerMarkView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public final MmSpeakerMarkViewModel a;
    public final Function0<Unit> b;
    public final MmSearchInputView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final RecyclerView g;
    public final MmSpeakerMarkAdapter h;
    public ObjectAnimator i;
    public String j;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<e, Unit> {
        public AnonymousClass3(Object r8) {
            super(1, r8, MmSpeakerMarkView.class, "handleSpeakerClick", "handleSpeakerClick(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidate;)V", 0);
        }

        public final void invoke(e r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            MmSpeakerMarkView.a((MmSpeakerMarkView) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((e) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmSpeakerMarkView a;

        public a(MmSpeakerMarkView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ObjectAnimator r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d.setRotation(0.0f);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c(this.c.getText(), "attach", true);
    }

    public static final /* synthetic */ void b(MmSpeakerMarkView r1) {
        r1.setLoading(false);
    }

    private final void setLoading(boolean r6) {
        ImageView r0 = this.d;
        boolean r1 = false;
        if (r6 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        if (r6 == true) goto L9;
        ObjectAnimator r2 = this.i;
        if (r2 == null) goto L24;
        r2.cancel();
    L24:
        this.d.setRotation(0.0f);
    L25:
        if (r6 == false) goto L28;
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        return;
    L28:
        return;
    L9:
        if (this.i != null) goto L11;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.d, View.ROTATION, new float[]{0.0f, 360.0f});
        r4.setDuration(600);
        r4.setRepeatCount(-1);
        r4.setInterpolator(new LinearInterpolator());
        this.i = r4;
    L11:
        ObjectAnimator r5 = this.i;
        if (r5 != null) goto L14;
    L16:
        if (r1 == true) goto L25;
        ObjectAnimator r7 = this.i;
        if (r7 == null) goto L25;
        r7.start();
        goto L25
    L14:
        if (r5.isStarted() != true) goto L16;
        r1 = true;
        goto L16
    L5:
        r3 = 8;
        goto L6
    }

    public static final void a(final MmSpeakerMarkView r3, e r4) {
        r3.setLoading(true);
        r3.a.handleSpeakerClick(r4, new MmSpeakerMarkView$handleSpeakerClick$1(r3), new MmSpeakerMarkView$handleSpeakerClick$2(r3));
    }

    public final void c(String r8, String r9, boolean r10) {
        if (r10 == false) goto L4;
    L7:
        this.j = r8;
        setLoading(true);
        this.a.searchSpeakerCandidates(r8, r9, r10, new MmSpeakerMarkView$querySpeakerCandidates$1(this), new MmSpeakerMarkView$querySpeakerCandidates$2(this));
        return;
    L4:
        if (Intrinsics.areEqual(r8, this.j) == false) goto L7;
        int r11 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SPEAKER, "querySpeakerCandidates", "skip duplicate query, from=" + r9 + ", query=" + r8, null, 8);
    }

    public MmSpeakerMarkView(Context r18, MmSpeakerMarkViewModel r19, MmRecordingUILaunchMode r20, Function0<Unit> r21) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "viewModel");
        Intrinsics.checkNotNullParameter(r20, "uiLaunchMode");
        super(r18, null);
        this.a = r19;
        this.b = r21;
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        c r4 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r20).getLayout().C(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r18, r20)), this);
        MmTitleBarView r5 = r4.b;
        MmSearchInputView r6 = r4.c;
        this.c = r6;
        this.d = r4.d;
        this.e = r4.e;
        TextView r7 = r4.f;
        this.f = r7;
        RecyclerView r8 = r4.g;
        this.g = r8;
        r5.setTitle(2131894016);
        r5.setCloseClickListener(new a(this));
        String r9 = getContext().getString(2131894022);
        String r10 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.e.b(2131894018, "retry", r9);
        SpannableString r11 = new SpannableString(r10);
        int r15 = ContextCompat.getColor(getContext(), 2131102043);
        int r14 = ContextCompat.getColor(getContext(), 2131102049);
        int r12 = StringsKt.indexOf$default(r10, r9, 0, false, 6, null);
        if (r12 < 0) goto L5;
        r11.setSpan(new ForegroundColorSpan(r15), 0, r12, 33);
        r11.setSpan(new ForegroundColorSpan(r14), r12, r9.length() + r12, 33);
    L5:
        r7.setText(r11);
        h.a(r7, new AnonymousClass2(this));
        MmSpeakerMarkAdapter r2 = new MmSpeakerMarkAdapter(r19.getMmUccApi$officesdk_minutes_base_ui_release(), r19.getMeetingId$officesdk_minutes_base_ui_release(), r20, new AnonymousClass3(this));
        this.h = r2;
        r8.setLayoutManager(new LinearLayoutManager(r18));
        r8.setAdapter(r2);
        r6.setOnTextChangedWithDebounceListener(new AnonymousClass4(this));
    }
}
