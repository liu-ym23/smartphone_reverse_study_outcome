package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import j40.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/DisplayTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/m;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "b", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayTextView extends AppCompatTextView implements m {
    public com.bytedance.android.live.base.model.message.f a;
    public o b;
    public boolean c;
    public final int d;
    public n e;
    public int f;
    public final String g;
    public final c h;

    public static final class a {
        public float a;
        public Float b;
        public Integer c;
        public final Integer d;
        public final Integer e;
        public final Integer f;
        public String g;
        public final boolean h;
        public final boolean i;
        public boolean j;
        public Typeface k;

        public a(float r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 128) == 0) goto L6;
            r4 = false;
        L6:
            if ((r6 & 256) == 0) goto L8;
            r5 = false;
        L8:
            this.a = r3;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = r4;
            this.i = r5;
            this.j = false;
            this.k = null;
        }
    }

    public static final class b implements qb2.e {
        public final /* synthetic */ DisplayTextView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ n c;

        @Override // qb2.e
        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            SpannableString r3 = r2.a;
            DisplayTextView.x(this.a, r3);
            if (this.b == true) goto L5;
            Animator r4 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.a(this.a, new i(this));
        L6:
            r4.start();
            return;
        L5:
            int r5 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.a;
            r4 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.b(this.a, new j(this));
            goto L6
        }

        public b(DisplayTextView r1, boolean r2, n r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements n {
        public final /* synthetic */ DisplayTextView a;

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void b() {
            DisplayTextView r0 = this.a;
            r0.f++;
            r0.f(r0.a, r0.e);
        }

        public c(DisplayTextView r1) {
            this.a = r1;
        }
    }

    public DisplayTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DisplayTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final o getOnSchemaHandleListener() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super/*android.widget.TextView*/.onDraw(r3);
        if (this.c == true) goto L5;
        return;
    L5:
        if (((Boolean) q.a.getValue()).booleanValue() == false) goto L9;
        postInvalidateDelayed(this.d);
        return;
    }

    public final void setOnSchemaHandleListener(o r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void x(DisplayTextView r8, Spannable r9) {
        r8.getClass();
        if (r9.length() <= 0) goto L24;
        boolean r1 = true;
        StyleSpan[] r0 = (StyleSpan[]) r9.getSpans(r9.length() - 1, r9.length(), StyleSpan.class);
        if (r0 == null) goto L21;
        int r3 = r0.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L18;
        StyleSpan r5 = r0[r4];
        if (r5.getStyle() != 2) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L16;
        r4 = r4 + 1;
        goto L7
    L16:
        boolean r2 = true;
    L19:
        if (r2 != true) goto L21;
    L22:
        if (r1 == false) goto L24;
        r8.setText(new SpannableStringBuilder(r9).append(r8.g));
        return;
    L11:
        if (r5.getStyle() == 3) goto L14;
        r6 = false;
        goto L15
    L18:
        r2 = false;
    L21:
        r1 = false;
    L24:
        r8.setText(r9);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void f(com.bytedance.android.live.base.model.message.f r5, n r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L6;
        return;
    L6:
        this.e = r6;
        if (this.f >= 4) goto L28;
        o6 r0 = r5.g();
        if (r0 == null) goto L13;
        a5 r1 = r0.a();
        if (r1 == null) goto L13;
        List r2 = r1.getPieces();
    L15:
        if (r2 == null) goto L17;
        ((c5) ListProtector.get(r2, 0)).setStringValue(String.valueOf(CastIntegerProtector.parseInt(((c5) ListProtector.get(r2, 0)).getStringValue()) + 1));
    L17:
        this.a = r5;
        if (this.f != 3) goto L26;
        o6 r3 = r5.g();
        if (r3 == null) goto L30;
        a5 r4 = r3.a();
        if (r4 == null) goto L31;
        this.a = r5;
        qb2.c.a(r4, new l(this, r6));
        return;
    L31:
        return;
    L30:
        return;
    L26:
        n(r5, this.h, true);
        return;
    L13:
        r2 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DisplayTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = 50;
        this.g = " ";
        setGravity(17);
        this.h = new c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void n(com.bytedance.android.live.base.model.message.f r2, n r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "comboItem");
        Intrinsics.checkNotNullParameter(r3, "comboListener");
        o6 r0 = r2.g();
        if (r0 != null) goto L5;
        return;
    L5:
        a5 r1 = r0.a();
        if (r1 != null) goto L8;
        return;
    L8:
        this.a = r2;
        qb2.c.a(r1, new b(this, r4, r3));
    }

    public /* synthetic */ DisplayTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
