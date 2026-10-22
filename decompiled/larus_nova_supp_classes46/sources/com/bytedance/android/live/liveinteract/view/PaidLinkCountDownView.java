package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import je0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/PaidLinkCountDownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/live/liveinteract/voicechat/util/b;", "", "time", "", "setOriginTime", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "d", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkCountDownView extends AppCompatTextView implements com.bytedance.android.live.liveinteract.voicechat.util.b {
    public final Context a;
    public final b b;
    public int c;
    public DataCenter d;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            IVoiceLiveTheme r2 = (IVoiceLiveTheme) r1;
        }
    }

    static {
    }

    public PaidLinkCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaidLinkCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (d.u() == true) goto L5;
        return;
    L5:
        if ((this.a instanceof AppCompatActivity) == false) goto L18;
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L9;
        boolean r1 = r0.booleanValue();
    L10:
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L13;
        x00.a r3 = r2.getThemeManager(r1, this.d);
    L14:
        if (r3 == null) goto L19;
        r3.j(this.a, this.b, 2);
        return;
    L19:
        return;
    L13:
        r3 = null;
        goto L14
    L9:
        r1 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        if (d.u() == false) goto L18;
        x00.a r2 = null;
        if (((Boolean) vm2.d.c7.getValue(null, vm2.d.a[415(0x19f, float:5.82E-43)])).booleanValue() == true) goto L7;
        return;
    L7:
        if ((this.a instanceof AppCompatActivity) == false) goto L20;
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L11;
        boolean r1 = r0.booleanValue();
    L12:
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        if (r3 == null) goto L15;
        r2 = r3.getThemeManager(r1, this.d);
    L15:
        if (r2 == null) goto L21;
        r2.f(this.b, 2);
        return;
    L21:
        return;
    L11:
        r1 = false;
        goto L12
    L20:
        return;
    }

    public final DataCenter getDataCenter() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.util.b
    public final void c(int r3) {
        int r4 = this.c - 1;
        this.c = r4;
        if (r4 <= 0) goto L5;
        String r5 = p6.a(r4);
    L6:
        setText(r5);
        return;
    L5:
        r5 = "--:--";
        goto L6
    }

    public final void setDataCenter(DataCenter r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOriginTime(int r3) {
        setText(p6.a(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaidLinkCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r2;
        this.b = b.a;
        setPadding(s1.f(2.0f), s1.f(1.0f), s1.f(2.0f), s1.f(1.0f));
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(ColorProtector.parseColor("#80000000"));
        r5.setCornerRadius(UtilityKotlinExtentionsKt.i(10));
        setBackground(r5);
        setTextSize(9.0f);
    }

    public /* synthetic */ PaidLinkCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
