package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/messagemodel/PublicScreenAIAutoReplyViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "Lg52/b;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAIAutoReplyViewHolder extends PSMessageViewHolder implements g52.b {
    public final TextView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final g52.a e;
    public final NoMoreSpaceTextView f;
    public View.OnClickListener g;
    public final a h;
    public final c i;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> j;
    public final Function0<s> k;
    public final Function1<s, Unit> l;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ PublicScreenAIAutoReplyViewHolder a;

        public a(PublicScreenAIAutoReplyViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            s r0 = (s) this.a.k.invoke();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.m(r2);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PublicScreenAIAutoReplyViewHolder a;

        public b(PublicScreenAIAutoReplyViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            s r0 = (s) this.a.k.invoke();
            if (r0 == null) goto L6;
            int r1 = s.k;
            r0.l(r3, null, null);
            return;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l {
        public final /* synthetic */ PublicScreenAIAutoReplyViewHolder a;

        public c(PublicScreenAIAutoReplyViewHolder r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            s r0 = (s) this.a.k.invoke();
            if (r0 == null) goto L6;
            int r1 = s.k;
            r0.l(r3, null, null);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final boolean b(View r2, tb2.b r3, ClickableSpan r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "action");
            Intrinsics.checkNotNullParameter(r4, "span");
            s r5 = (s) this.a.k.invoke();
            if (r5 == null) goto L5;
            boolean r6 = r5.n(r2, r3);
        L6:
            if (r6 == false) goto L8;
            return r6;
        L8:
            if ((r3 instanceof tb2.e) == false) goto L12;
            int r7 = tb2.f.a;
            return tb2.f.a((tb2.e) r3);
        L12:
            return r6;
        L5:
            r6 = false;
            goto L6
        }
    }

    public PublicScreenAIAutoReplyViewHolder(View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        super(r7);
        TextView r0 = (TextView) r7.findViewById(2131384362);
        this.b = r0;
        LinearLayout r1 = (LinearLayout) r7.findViewById(2131363806);
        this.c = r1;
        this.d = (LinearLayout) r7.findViewById(2131384343);
        KeyEvent.Callback r3 = r7.findViewById(2131377403);
        if ((r3 instanceof g52.a) == true) goto L5;
        r3 = null;
    L5:
        this.e = (g52.a) r3;
        NoMoreSpaceTextView r4 = r7.findViewById(2131388367);
        this.f = r4;
        this.k = new PublicScreenAIAutoReplyViewHolder$getTagMessageModel$1(this);
        this.l = new PublicScreenAIAutoReplyViewHolder$setTagMessageModel$1(this);
        a r5 = new a(this);
        this.h = r5;
        this.g = new b(this);
        this.i = new c(this);
        r1.setOnLongClickListener(r5);
        r1.setOnClickListener(this.g);
        r1.setAlpha(1.0f);
        t.a(r4);
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131377403);
        if (r8 == null) goto L8;
        r8.setImportantForAccessibility(2);
    L8:
        r4.setFocusable(true);
        if (((Boolean) r52.c.a.getValue()).booleanValue() == false) goto L12;
        r0.setSingleLine();
        r0.setEllipsize(TextUtils.TruncateAt.END);
        return;
    }

    public final void X3(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r2) {
        Intrinsics.checkNotNullParameter(r2, "renderTextProcessor");
        this.j = r2;
        View.OnClickListener r3 = r2.c(this.i);
        this.g = r3;
        this.f.setOnClickListener(r3);
        this.f.setOnLongClickListener(this.h);
        this.f.setMovementMethod(new u());
        this.f.setHighlightColor(0);
    }

    @Override // g52.b
    public final void c(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        e52.a r0 = null;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r1 = m.a(null);
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r1.getValue();
        if (r2 == null) goto L7;
        r0 = r2.getTextConfig();
    L7:
        Object r3 = this.k.invoke();
        if (r0 == null) goto L19;
        if (r3 == null) goto L20;
        s r5 = (s) r3;
        int r6 = r4.getAction();
        if (r6 == 0) goto L17;
        if (r6 != 1) goto L14;
    L16:
        W3(r0, r5, false);
        return;
    L14:
        if (r6 == 3) goto L16;
        return;
    L17:
        W3(r0, r5, true);
        return;
    L20:
        return;
    }

    public final void W3(e52.a r2, s r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r3, "model");
        int r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r4, null, r2);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(this.c, r5);
    }
}
