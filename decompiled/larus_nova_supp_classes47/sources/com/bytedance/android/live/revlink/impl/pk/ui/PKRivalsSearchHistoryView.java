package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchHistoryView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchHistoryView$a;", "cb", "", "setCallBack", "", "", "words", "setData", "", "b", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchHistoryView extends FrameLayout {
    public Map<Integer, View> a;
    public int b;
    public a c;

    public interface a {
        void Sn();

        void v8(String r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PKRivalsSearchHistoryView a;

        public b(PKRivalsSearchHistoryView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ((ImageView) this.a.a(2131376102)).setVisibility(8);
            ((TextView) this.a.a(2131390312)).setVisibility(0);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PKRivalsSearchHistoryView a;

        public c(PKRivalsSearchHistoryView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.setVisibility(8);
            a r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.Sn();
            return;
        }
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(2131567807, this);
        setVisibility(8);
    }

    public final int getMaxHeight() {
        return this.b;
    }

    public PKRivalsSearchHistoryView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.b = -1;
        b();
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setCallBack(a r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.c = r2;
    }

    public final void setData(List<String> r9) {
        List<String> r0 = r9;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        setVisibility(8);
        ((TextView) a(2131391606)).setVisibility(8);
        ((ImageView) a(2131376102)).setVisibility(8);
    L23:
        ((ImageView) a(2131376102)).setOnClickListener(new b(this));
        ((TextView) a(2131390312)).setOnClickListener(new c(this));
        return;
    L12:
        setVisibility(0);
        ((TextView) a(2131391606)).setVisibility(0);
        ((ImageView) a(2131376102)).setVisibility(0);
        ((TextView) a(2131390312)).setVisibility(8);
        a(2131372833).removeAllViews();
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L23;
        String r3 = (String) r10.next();
        View r5 = LayoutInflater.from(getContext()).inflate(2131566368, (ViewGroup) a(2131372833), false);
        TextView r6 = (TextView) r5.findViewById(2131390748);
        if (r6 == null) goto L18;
        r6.setTag(r3);
    L18:
        if (r6 == null) goto L20;
        r6.setText(r3);
    L20:
        if (r6 == null) goto L22;
        r6.setOnClickListener(new m(this));
    L22:
        a(2131372833).addView(r5);
        goto L14
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final void setMaxHeight(int r1) {
        this.b = r1;
    }

    public PKRivalsSearchHistoryView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.a = new LinkedHashMap();
        this.b = -1;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130972696});
        if (r7 != null) goto L13;
    L9:
        if (r7 == null) goto L11;
        r7.recycle();
    L11:
        b();
        return;
    L13:
        this.b = r7.getDimensionPixelSize(0, -1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        int r0 = this.b;
        if (r0 < 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r2, r3);
    }

    public PKRivalsSearchHistoryView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new LinkedHashMap();
        this.b = -1;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972696});
        if (r7 != null) goto L13;
    L9:
        if (r7 == null) goto L11;
        r7.recycle();
    L11:
        b();
        return;
    L13:
        this.b = r7.getDimensionPixelSize(0, -1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }
}
