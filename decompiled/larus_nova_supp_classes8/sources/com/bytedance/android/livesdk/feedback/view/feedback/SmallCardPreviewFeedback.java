package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.view.preview.SmallCardReplaceViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SmallCardPreviewFeedback implements dx1.a {
    public SmallCardReplaceViewGroup a;
    public SimpleDraweeView b;
    public SimpleDraweeView c;
    public SimpleMediaView d;
    public ViewGroup e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public FeedbackCard k;
    public Question l;
    public final Lazy m;
    public final Lazy n;
    public Disposable o;
    public final Lazy p;
    public final a q;
    public final FeedbackContext r;
    public final Function0<Unit> s;

    public static final class a implements com.bytedance.android.livesdk.feedback.view.preview.h {
        public final /* synthetic */ SmallCardPreviewFeedback a;

        public a(SmallCardPreviewFeedback r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feedback.view.preview.h
        public final void a(RoomCardStruct r4) {
            Intrinsics.checkNotNullParameter(r4, "room");
            FeedbackCard r0 = this.a.k;
            if (r0 == null) goto L12;
            List r1 = r0.getLikedRooms();
            if (r1 == null) goto L12;
            if ((!r1.contains(r4)) == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            r4.setLike(true);
            r1.add(r4);
        L12:
            this.a.e();
        }

        @Override // com.bytedance.android.livesdk.feedback.view.preview.h
        public final void b(RoomCardStruct r3) {
            Intrinsics.checkNotNullParameter(r3, "room");
            FeedbackCard r0 = this.a.k;
            if (r0 == null) goto L12;
            List r1 = r0.getLikedRooms();
            if (r1 == null) goto L12;
            if (r1.contains(r3) == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            r3.setLike(false);
            r1.remove(r3);
        L12:
            this.a.e();
        }
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onSlide() {
    }

    public final void d() {
        View r0 = this.j;
        if (r0 == null) goto L22;
        SmallCardReplaceViewGroup r1 = this.a;
        boolean r2 = false;
        if (r1 == null) goto L17;
        List<RoomCardStruct> r3 = r1.e;
        if (r3 != null) goto L9;
    L14:
        r3 = null;
    L15:
        if (r3 == null) goto L17;
        r2 = true;
        goto L17
    L9:
        if (r3.size() <= 4) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
    L11:
        r4 = false;
    L17:
        if (r2 == false) goto L19;
        int r5 = 2131249127;
    L20:
        r0.setBackground(s1.m(r5));
        r0.setClickable(r2);
        return;
    L19:
        r5 = 2131249126;
        goto L20
    }

    public final void e() {
        TextView r0 = this.i;
        if (r0 == null) goto L22;
        FeedbackCard r1 = this.k;
        if (r1 == null) goto L23;
        List r2 = r1.getLikedRooms();
        if (r2 == null) goto L24;
        boolean r3 = true;
        if (r2.size() >= 1) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L15;
        int r4 = 2131249128;
    L16:
        r0.setBackground(s1.m(r4));
        if (r3 == false) goto L19;
        int r5 = -1;
    L20:
        r0.setTextColor(r5);
        r0.setClickable(r3);
        return;
    L19:
        r5 = ColorProtector.parseColor("#80FFFFFF");
        goto L20
    L15:
        r4 = 2131249129;
        goto L16
    L24:
        return;
    L23:
        return;
    }

    @Override // dx1.a
    public final void onDestroy() {
        Disposable r0 = this.o;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // dx1.a
    public final void startRoom() {
        SmallCardReplaceViewGroup r0 = this.a;
        if (r0 == null) goto L23;
        com.bytedance.android.livesdk.feedback.view.preview.d r1 = r0.b;
        if (r1 == null) goto L23;
        r1.startPreview();
    L23:
        SimpleMediaView r2 = this.d;     // Catch: Exception -> L21
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.h() == false) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L18;
        r2 = null;
    L18:
        if (r2 == null) goto L26;
        r2.setPlayEntity((tic.a) this.m.getValue());     // Catch: Exception -> L21
        r2.k();     // Catch: Exception -> L21
        r2.setLoop(true);     // Catch: Exception -> L21
        return;
    L26:
        return;
    L12:
        if (((tic.a) this.m.getValue()) == null) goto L14;
        r3 = true;
    L21:
        ALogger.d("FeedbackMediaPlayError", "SmallPreviewQuestion");
    }

    @Override // dx1.a
    public final void stopRoom() {
        SmallCardReplaceViewGroup r0 = this.a;
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.feedback.view.preview.d r1 = r0.b;
        if (r1 == null) goto L7;
        r1.stopPreview();
    L7:
        com.bytedance.android.livesdk.feedback.view.preview.d r2 = r0.c;
        if (r2 == null) goto L10;
        r2.stopPreview();
    L10:
        SimpleMediaView r3 = this.d;
        if (r3 == null) goto L14;
        r3.m();
        return;
    }

    @Override // dx1.a
    public final void c(FeedbackCard r4) {
        this.k = r4;
        List<RoomCardStruct> r0 = null;
        if (r4 == null) goto L7;
        List r1 = r4.question;
        if (r1 == null) goto L7;
        Question r2 = (Question) ListProtector.get(r1, 0);
    L8:
        this.l = r2;
        TextView r3 = this.g;
        if (r3 == null) goto L16;
        if (r2 == null) goto L14;
        String r5 = r2.questionText;
        if (r5 == null) goto L14;
    L15:
        r3.setText(r5);
    L14:
        r5 = "";
    L16:
        TextView r6 = this.f;
        if (r6 == null) goto L24;
        if (r4 == null) goto L22;
        String r7 = r4.title;
        if (r7 == null) goto L22;
    L23:
        r6.setText(r7);
    L22:
        r7 = s1.B(2131919102);
    L24:
        SmallCardReplaceViewGroup r8 = this.a;
        if (r8 == null) goto L30;
        Question r9 = this.l;
        if (r9 == null) goto L29;
        r0 = r9.rooms;
    L29:
        r8.b(r0, this.r);
    L30:
        SimpleDraweeView r10 = this.b;
        if (r10 == null) goto L33;
        r10.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L33:
        SimpleDraweeView r11 = this.c;
        if (r11 == null) goto L36;
        r11.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
    L36:
        d();
        e();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // dx1.a
    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.a = (SmallCardReplaceViewGroup) r5.findViewById(2131382908);
        this.b = r5.findViewById(2131364117);
        this.c = r5.findViewById(2131374136);
        this.d = r5.findViewById(2131379806);
        this.i = (TextView) r5.findViewById(2131387570);
        this.j = r5.findViewById(2131384301);
        this.f = (TextView) r5.findViewById(2131372318);
        this.g = (TextView) r5.findViewById(2131383539);
        this.h = (TextView) r5.findViewById(2131386885);
        this.e = (ViewGroup) r5.findViewById(2131383538);
        View r6 = this.j;
        if (r6 == null) goto L5;
        r6.setOnClickListener(new h(this));
    L5:
        TextView r7 = this.i;
        if (r7 == null) goto L8;
        r7.setOnClickListener(new i(this));
    L8:
        SmallCardReplaceViewGroup r8 = this.a;
        if (r8 == null) goto L11;
        r8.setLikeClickListener(this.q);
    L11:
        TextView r9 = this.h;
        int r0 = 0;
        Integer r2 = null;
        if (r9 == null) goto L24;
        j5 r3 = (j5) this.n.getValue();
        if (r3 == null) goto L16;
        Integer r4 = r3.guideVisible;
    L17:
        if (r4 != null) goto L20;
    L22:
        int r10 = 8;
    L23:
        r9.setVisibility(r10);
        goto L24
    L20:
        if (r4.intValue() != 1) goto L22;
        r10 = 0;
        goto L23
    L16:
        r4 = null;
    L24:
        ViewGroup r11 = this.e;
        if (r11 == null) goto L37;
        j5 r12 = (j5) this.n.getValue();
        if (r12 == null) goto L29;
        r2 = r12.titleVisible;
    L29:
        if (r2 != null) goto L32;
    L34:
        r0 = 4;
    L35:
        r11.setVisibility(r0);
        return;
    L32:
        if (r2.intValue() != 1) goto L34;
    }

    @Override // dx1.a
    public final View a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        return r3.inflate(2131566759, r4, false);
    }

    public SmallCardPreviewFeedback(Context r2, FeedbackContext r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedbackContext");
        Intrinsics.checkNotNullParameter(r4, "onSubmit");
        this.r = r3;
        this.s = r4;
        this.m = LazyKt.lazy(new SmallCardPreviewFeedback$musicEntity$2(this));
        this.n = LazyKt.lazy(SmallCardPreviewFeedback$mFeedbackConfig$2.INSTANCE);
        this.p = LazyKt.lazy(SmallCardPreviewFeedback$feedbackService$2.INSTANCE);
        this.q = new a(this);
    }
}
