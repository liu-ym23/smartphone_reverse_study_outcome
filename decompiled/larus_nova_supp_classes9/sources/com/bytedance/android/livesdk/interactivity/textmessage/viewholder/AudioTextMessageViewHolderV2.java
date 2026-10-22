package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import g52.e;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textmessage/viewholder/AudioTextMessageViewHolderV2;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "Lg52/b;", "a", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudioTextMessageViewHolderV2 extends MessageViewHolder implements g52.b {
    public final Lazy b;
    public final Function0<AudioChatTextMessage> c;
    public final View.OnClickListener d;
    public final Lazy e;
    public final Lazy f;
    public f<?> g;
    public final View h;
    public final NoMoreSpaceTextView i;
    public final ImageView j;
    public final ImageView k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final k<f<?>> o;
    public final boolean p;
    public final e52.a q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ AudioTextMessageViewHolderV2 b;

        public b(ImageView r1, AudioTextMessageViewHolderV2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.startAnimation((RotateAnimation) this.b.b.getValue());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements k.a<f<?>> {
        public final /* synthetic */ AudioTextMessageViewHolderV2 a;

        public c(AudioTextMessageViewHolderV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
        public final void a(f<?> r3, j r4) {
            f<?> r5 = r3;
            Intrinsics.checkNotNullParameter(r5, "message");
            Intrinsics.checkNotNullParameter(r4, "rendResult");
            if (Intrinsics.areEqual(this.a.h.getTag(2131389787), r5) == false) goto L6;
            this.a.i.setText(r4.a);
            this.a.X3();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void T3() {
        this.l = true;
        X3();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void V3() {
        this.l = false;
        X3();
    }

    public final void X3() {
        CharSequence r0 = this.i.getText();
        f<?> r2 = null;
        if ((r0 instanceof Spanned) == true) goto L5;
        r0 = null;
    L5:
        Spanned r1 = (Spanned) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        f<?> r3 = this.g;
        if ((r3 instanceof AudioChatTextMessage) == false) goto L12;
        r2 = r3;
    L12:
        AudioChatTextMessage r4 = (AudioChatTextMessage) r2;
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.b.getReadStatus() != 2) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
    L26:
        LottieDrawable r6 = qb2.a.a(r1);
        if (r6 == null) goto L29;
        int r7 = r0.c.a;
        r6.e.clear();
        r6.c.g(true);
    L29:
        this.m = false;
    L31:
        if (this.m == false) goto L33;
    L36:
        this.i.setAlwaysInvalidate(true);
        return;
    L33:
        if (this.n == true) goto L36;
        this.i.setAlwaysInvalidate(false);
        return;
    L21:
        if (this.l == false) goto L26;
        LottieDrawable r8 = qb2.a.a(r1);
        if (r8 == null) goto L25;
        r8.k();
    L25:
        this.m = true;
        goto L31
    L18:
        r5 = false;
        goto L19
    }

    @Override // g52.b
    public final void c(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        AudioChatTextMessage r0 = (AudioChatTextMessage) this.c.invoke();
        if (r0 == null) goto L13;
        int r4 = r3.getAction();
        if (r4 == 0) goto L11;
        if (r4 != 1) goto L8;
    L10:
        W3(r0, false);
        return;
    L8:
        if (r4 == 3) goto L10;
        return;
    L11:
        W3(r0, true);
        return;
    }

    public final void W3(AudioChatTextMessage r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        View r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        l.e(r0, l.a(r4, r3, this.q));
    }

    public AudioTextMessageViewHolderV2(View r2, k r3, q92.a r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "processor");
        super(r2);
        this.o = r3;
        this.p = true;
        this.q = r4;
        this.b = LazyKt.lazy(AudioTextMessageViewHolderV2$rotateAnimation$2.INSTANCE);
        this.c = new AudioTextMessageViewHolderV2$getMessage$1(this);
        this.d = r3.c(new com.bytedance.android.livesdk.interactivity.textmessage.viewholder.a(this));
        Lazy r5 = LazyKt.lazy(new AudioTextMessageViewHolderV2$onFailureClickListener$2(this));
        this.e = r5;
        this.f = LazyKt.lazy(new AudioTextMessageViewHolderV2$onLongClickListener$2(this));
        this.h = r2.findViewById(2131363382);
        NoMoreSpaceTextView r6 = r2.findViewById(2131367794);
        this.i = r6;
        this.j = (ImageView) r2.findViewById(2131363400);
        ImageView r7 = (ImageView) r2.findViewById(2131363385);
        r7.setOnClickListener((View.OnClickListener) r5.getValue());
        Unit r8 = Unit.INSTANCE;
        this.k = r7;
        r6.setMovementMethod(u.a());
        r6.setHighlightColor(0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(f<?> r8, int r9, e r10) {
        Intrinsics.checkNotNullParameter(r8, "message");
        this.g = r8;
        this.h.setTag(2131389787, r8);
        this.i.setOnClickListener(this.d);
        this.h.setOnLongClickListener((View.OnLongClickListener) this.f.getValue());
        KeyEvent.Callback r11 = this.h;
        i r1 = null;
        if ((r11 instanceof g52.a) == true) goto L5;
        r11 = null;
    L5:
        g52.a r13 = (g52.a) r11;
        if (r13 == null) goto L8;
        r13.setDispatchCallback(this);
    L8:
        AudioChatTextMessage r14 = (AudioChatTextMessage) r8;
        int r0 = r14.b.getSendStatus();
        boolean r4 = true;
        if (r0 == 0) goto L16;
        if (r0 != 1) goto L12;
        UIUtils.setViewVisibility(this.k, 0);
        UIUtils.setViewVisibility(this.j, 8);
    L17:
        j r2 = this.o.b(r8, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(true), new c(this));
        i r3 = r2.b;
        if (r3 == null) goto L20;
        boolean r5 = r3.a;
    L21:
        this.n = r5;
        NoMoreSpaceTextView r6 = this.i;
        CharSequence r7 = r2.a;
        if (r7 != null) goto L25;
        r7 = BuildConfig.FLAVOR;
    L25:
        r6.setText(r7);
        X3();
        i r15 = r2.b;
        if (r15 == null) goto L28;
        String r16 = r15.d;
    L29:
        if (r16 != null) goto L31;
    L33:
        PublicScreenAccessibilityUtil r17 = PublicScreenAccessibilityUtil.a;
        Spannable r18 = r2.a;
        NoMoreSpaceTextView r19 = this.i;
        r17.getClass();
        PublicScreenAccessibilityUtil.a(r18, r19, null);
    L34:
        if (r10 == null) goto L36;
        NoMoreSpaceTextView r20 = this.i;
        int r21 = e.j;
        r10.a(r20, true);
        e.b(r10, this.j);
        e.b(r10, this.k);
    L36:
        W3(r14, false);
        if (this.p == true) goto L40;
    L61:
        this.o.a(r8);
        return;
    L40:
        if (((HashMap) r8.n).containsKey("show_tag_for_anchor_fans_icon_show_logger") == true) goto L61;
        ((HashMap) r8.n).put("show_tag_for_anchor_fans_icon_show_logger", "null");
        i r23 = r2.b;
        if (r23 == null) goto L61;
        if (r23.b == false) goto L46;
    L49:
        if (r4 == false) goto L51;
        r1 = r23;
    L51:
        if (r1 == null) goto L61;
        j0 r24 = j0.l();
        HashMap r110 = new HashMap();
        IBaseUser r25 = r8.x();
        String r26 = "0";
        if (r25 == null) goto L56;
        String r27 = r25.getIdString();
        if (r27 == null) goto L56;
    L57:
        r110.put("user_id", r27);
        r110.put("show_type", "comment");
        if (r1.b == false) goto L60;
        r26 = "1";
    L60:
        r110.put("is_mutual", r26);
        Unit r28 = Unit.INSTANCE;
        r24.sendLog("livesdk_fans_tag_show", r110, new Object[0]);
    L56:
        r27 = "0";
        goto L57
    L46:
        if (r23.c == true) goto L49;
        r4 = false;
        goto L49
    L31:
        if (TextUtils.isEmpty(r16) == true) goto L33;
        r3.c(this.i, r16, false);
        goto L34
    L28:
        r16 = null;
        goto L29
    L20:
        r5 = false;
        goto L21
    L12:
        if (r0 != 2) goto L17;
        ImageView r29 = this.j;
        UIUtils.setViewVisibility(r29, 0);
        r29.post(new b(r29, this));
        UIUtils.setViewVisibility(this.k, 8);
        goto L17
    L16:
        UIUtils.setViewVisibility(this.k, 8);
        ImageView r30 = this.j;
        UIUtils.setViewVisibility(r30, 8);
        r30.clearAnimation();
        goto L17
    }
}
