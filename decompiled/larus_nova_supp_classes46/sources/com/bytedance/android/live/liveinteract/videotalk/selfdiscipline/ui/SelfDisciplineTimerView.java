package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.utils.x0;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/ui/SelfDisciplineTimerView;", "Landroid/widget/FrameLayout;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "getMDurationHolder", "()Ljava/util/concurrent/ConcurrentHashMap;", "mDurationHolder", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "c", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getMPlayerInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setMPlayerInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "mPlayerInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineTimerView extends FrameLayout {
    public Map<Integer, View> a;
    public final ConcurrentHashMap<String, Long> b;
    public ILinkPlayerInfoBridge c;
    public Disposable d;

    public static final class a {
    }

    static {
    }

    public SelfDisciplineTimerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelfDisciplineTimerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        TextView r1 = (TextView) a(2131391592);
        if (r1 == null) goto L8;
        r1.setText(d(0));
    L8:
        TextView r2 = (TextView) a(2131391592);
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        TextView r1 = (TextView) a(2131391592);
        if (r1 == null) goto L8;
        r1.setText(d(0));
    L8:
        TextView r2 = (TextView) a(2131391592);
        if (r2 == null) goto L12;
        r2.setVisibility(4);
        return;
    }

    public final ConcurrentHashMap<String, Long> getMDurationHolder() {
        return this.b;
    }

    public final ILinkPlayerInfoBridge getMPlayerInfo() {
        return this.c;
    }

    public static String c(long r5) {
        if (r5 != 0) goto L5;
        return "00";
    L5:
        long r0 = 9;
        if (1 > r5) goto L12;
        if (r0 < r5) goto L12;
        return "0" + r5;
    L12:
        return String.valueOf(r5);
    }

    public static String d(long r7) {
        long r0 = 60;
        long r2 = r7 % r0;
        TimeUnit r4 = TimeUnit.SECONDS;
        long r5 = r4.toMinutes(r7) % r0;
        return c(r4.toHours(r7)) + ':' + c(r5) + ':' + c(r2);
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

    public final void setMPlayerInfo(ILinkPlayerInfoBridge r1) {
        this.c = r1;
    }

    public SelfDisciplineTimerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        SelfDisciplineContext r5 = SelfDisciplineContext.Companion.getContext();
        if (r5 == null) goto L6;
        ConcurrentHashMap<String, Long> r6 = r5.getDurationHolder();
        if (r6 == null) goto L6;
    L7:
        this.b = r6;
        LayoutInflater.from(r2).inflate(2131567446, this);
        ((TextView) a(2131391592)).setVisibility(8);
        setOnClickListener(x0.a(new AnonymousClass1(this, r2)));
        return;
    L6:
        r6 = new ConcurrentHashMap();
        goto L7
    }

    public /* synthetic */ SelfDisciplineTimerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
