package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.s3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0016\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001b\u0010\u001c\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/chatroom/model/r3;", "liveInfo", "", "setLiveInfo", "Landroid/view/View;", "getView", "getLiveInfo", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getLeftTextView", "()Landroid/widget/TextView;", "leftTextView", "b", "getLeftTagView", "leftTagView", "c", "getMidDividerView", "()Landroid/view/View;", "midDividerView", "d", "getRightTextView", "rightTextView", "e", "getRightTagView", "rightTagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameLiveView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public r3 f;

    public T01GameLiveView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public T01GameLiveView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getLeftTagView() {
        return (TextView) this.b.getValue();
    }

    private final TextView getLeftTextView() {
        return (TextView) this.a.getValue();
    }

    private final View getMidDividerView() {
        return (View) this.c.getValue();
    }

    private final TextView getRightTagView() {
        return (TextView) this.e.getValue();
    }

    private final TextView getRightTextView() {
        return (TextView) this.d.getValue();
    }

    public View getView() {
        return this;
    }

    public final r3 getLiveInfo() {
        return this.f;
    }

    public final void setLiveInfo(r3 r9) {
        this.f = r9;
        if (r9 == null) goto L5;
        List r0 = r9.c();
    L6:
        List r1 = r0;
        int r2 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L23;
        if (r9 == null) goto L19;
        List r4 = r9.c();
        if (r4 == null) goto L19;
        int r5 = r4.size();
    L21:
        if (r5 <= 0) goto L23;
        boolean r6 = true;
    L25:
        if (r6 == true) goto L29;
        setVisibility(8);
        return;
    L29:
        if (r9 == null) goto L52;
        List r7 = r9.c();
        if (r7 == null) goto L52;
        if (r7.size() != 1) goto L36;
        a(getRightTextView(), ((s3) ListProtector.get(r7, 0)).c());
        a(getRightTagView(), ((s3) ListProtector.get(r7, 0)).b());
        a(getLeftTextView(), "");
        a(getLeftTagView(), "");
        goto L52
    L36:
        if (r7.size() != 2) goto L52;
        Iterator r8 = r7.iterator();
    L39:
        if (r8.hasNext() == false) goto L52;
        s3 r10 = (s3) r8.next();
        Integer r11 = r10.a();
        if (r11 == null) goto L46;
        if (r11.intValue() != 1) goto L46;
        a(getRightTextView(), r10.c());
        a(getRightTagView(), r10.b());
    L46:
        Integer r12 = r10.a();
        if (r12 == null) goto L39;
        if (r12.intValue() != 2) goto L39;
        a(getLeftTextView(), r10.c());
        a(getLeftTagView(), r10.b());
    L52:
        setVisibility(0);
        View r13 = getMidDividerView();
        if (r9 == null) goto L57;
        List r14 = r9.c();
        if (r14 == null) goto L57;
        int r15 = r14.size();
    L58:
        if (r15 >= 2) goto L61;
        r2 = 8;
    L61:
        r13.setVisibility(r2);
        return;
    L57:
        r15 = 0;
    L19:
        r5 = 0;
    L23:
        r6 = false;
        goto L25
    L9:
        if (r1.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public static void a(TextView r2, String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r2.setVisibility(8);
        r2.setText("");
        return;
    L11:
        r2.setVisibility(0);
        r2.setText(r3);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public T01GameLiveView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new T01GameLiveView$leftTextView$2(this));
        this.b = LazyKt.lazy(new T01GameLiveView$leftTagView$2(this));
        this.c = LazyKt.lazy(new T01GameLiveView$midDividerView$2(this));
        this.d = LazyKt.lazy(new T01GameLiveView$rightTextView$2(this));
        this.e = LazyKt.lazy(new T01GameLiveView$rightTagView$2(this));
        LayoutInflater.from(r2).inflate(2131566109, this);
    }

    public /* synthetic */ T01GameLiveView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
