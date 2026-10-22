package com.bytedance.android.live.ktv.common.ordersong.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001c\u000fB\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvTextSwitcher;", "Landroid/widget/TextSwitcher;", "", "", "list", "", "setItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "items", "Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvTextSwitcher$e;", "e", "Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvTextSwitcher$e;", "getTextSwitchClickListener", "()Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvTextSwitcher$e;", "setTextSwitchClickListener", "(Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvTextSwitcher$e;)V", "textSwitchClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvTextSwitcher extends TextSwitcher {
    public final Disposable a;
    public final ArrayList<String> b;
    public int c;
    public final ArrayList<TextView> d;
    public e e;

    public static final class a implements ViewSwitcher.ViewFactory {
        public final /* synthetic */ KtvTextSwitcher a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ float c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0217a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0217a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                KtvTextSwitcher r5 = this.a.a;
                String r1 = "";
                if ((r5.c % 2) != 0) goto L11;
                e r6 = r5.getTextSwitchClickListener();
                if (r6 == null) goto L19;
                String r0 = (String) CollectionsKt.getOrNull(this.a.a.getItems(), 0);
                if (r0 == null) goto L10;
                r1 = r0;
            L10:
                r6.b(r1);
                return;
            L19:
                return;
            L11:
                e r7 = r5.getTextSwitchClickListener();
                if (r7 == null) goto L21;
                String r2 = (String) CollectionsKt.getOrNull(this.a.a.getItems(), this.a.a.c);
                if (r2 == null) goto L17;
                r1 = r2;
            L17:
                r7.a(r1);
                return;
            }
        }

        public a(KtvTextSwitcher r1, Context r2, float r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r0 = new TextView(this.b);
            r0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            r0.setSingleLine(true);
            r0.setLines(1);
            r0.setTextSize(0, this.c);
            r0.setTextColor(this.d);
            r0.setGravity(8388627);
            r0.setOnClickListener(new ViewOnClickListenerC0217a(this));
            this.a.d.add(r0);
            return r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvTextSwitcher a;

        public b(KtvTextSwitcher r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            ArrayList<String> r0 = this.a.getItems();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L32;
            this.a.c = ((int) r7.longValue()) % this.a.getItems().size();
            KtvTextSwitcher r8 = this.a;
            String r3 = "";
            if ((r8.c % 2) != 0) goto L17;
            String r9 = (String) CollectionsKt.getOrNull(r8.getItems(), this.a.c);
            if (r9 == null) goto L25;
            r3 = r9;
        L25:
            View r11 = this.a.getNextView();
            int r2 = r3.a;
            if (r11 == null) goto L30;
            if (r3 == null) goto L30;
            r3.a r4 = new r3.a(r11);
            r4.a = r3;
            r4.d = "编辑框";
            ViewCompat.setAccessibilityDelegate(r11, r4);
        L30:
            this.a.setText(r3);
            return;
        L17:
            String r12 = (String) CollectionsKt.getOrNull(r8.getItems(), this.a.c);
            if (r12 == null) goto L22;
            r3 = r12;
        L22:
            if (r3.length() <= 7) goto L24;
            r3 = r3.substring(0, 7) + "...";
        L24:
            r3 = s1.C(2131918577, new Object[]{r3});
            goto L25
        L32:
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class d {
    }

    public interface e {
        void a(String r1);

        void b(String r1);
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        Animation r1 = getInAnimation();
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        Animation r2 = getOutAnimation();
        if (r2 == null) goto L16;
        r2.cancel();
    L16:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final ArrayList<String> getItems() {
        return this.b;
    }

    public final e getTextSwitchClickListener() {
        return this.e;
    }

    public KtvTextSwitcher(Context r2) {
        this(r2, null);
    }

    public final void a(int r3) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((TextView) r0.next()).setTextColor(r3);
        goto L4
    }

    public final void setItems(List<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "list");
        this.b.clear();
        if (r6.isEmpty() == false) goto L5;
        this.b.add(s1.B(2131918574));
        return;
    L5:
        CollectionsKt.shuffled(r6);
        if (r6.size() < 5) goto L8;
        int r0 = 4;
    L9:
        if (r0 < 0) goto L19;
        int r2 = 0;
    L11:
        this.b.add(s1.B(2131918574));
        ArrayList<String> r3 = this.b;
        String r4 = (String) CollectionsKt.getOrNull(r6, r2);
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r3.add(r4);
        if (r2 == r0) goto L20;
        r2 = r2 + 1;
        goto L11
    L20:
        return;
    L19:
        return;
    L8:
        r0 = r6.size();
        goto L9
    }

    public final void setTextSwitchClickListener(e r1) {
        this.e = r1;
    }

    public KtvTextSwitcher(Context r25, AttributeSet r26) {
        Intrinsics.checkNotNullParameter(r25, "context");
        super(r25, r26);
        this.b = new ArrayList();
        this.d = new ArrayList();
        AnimationSet r2 = new AnimationSet(true);
        r2.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        r2.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 1.4f, 1, 0.0f));
        r2.setFillAfter(true);
        r2.setDuration(375);
        r2.setInterpolator(PathInterpolatorCompat.create(0.5f, 0.0f, 0.5f, 1.0f));
        Unit r9 = Unit.INSTANCE;
        AnimationSet r11 = new AnimationSet(true);
        r11.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        r11.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 1, -1.4f));
        r11.setFillAfter(true);
        r11.setDuration(375);
        r11.setInterpolator(PathInterpolatorCompat.create(0.5f, 0.0f, 0.5f, 1.0f));
        TypedArray r4 = r25.obtainStyledAttributes(r26, new int[]{2130974355, 2130974356});
        int r5 = r4.getColor(0, s1.h(2131107725));
        float r3 = r4.getDimensionPixelSize(1, s1.f(15.0f));
        r4.recycle();
        setFactory(new a(this, r25, r3, r5));
        setInAnimation(r2);
        setOutAnimation(r11);
        this.a = du2.a.b(1, 5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a);
    }
}
