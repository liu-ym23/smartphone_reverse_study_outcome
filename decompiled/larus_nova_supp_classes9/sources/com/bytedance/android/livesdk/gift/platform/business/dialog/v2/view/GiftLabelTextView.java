package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftLabelTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftLabelTextView extends AppCompatTextView {
    public static final /* synthetic */ int c = 0;
    public Disposable a;
    public Function0<Unit> b;

    public GiftLabelTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftLabelTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(long r8) {
        u0 r0 = u0.f;
        long r1 = u0.j.a;
        if (r8 <= r1) goto L5;
        setText(s1.C(2131917149, new Object[]{Integer.valueOf((int) (r8 / r1))}));
        return;
    L5:
        long r4 = u0.i.a;
        if (r4 <= r8) goto L9;
    L11:
        long r2 = u0.h.a;
        if (r2 <= r8) goto L15;
    L17:
        long r5 = u0.g.a;
        if (r5 <= r8) goto L21;
    L23:
        setText(s1.C(2131917148, new Object[]{0}));
        return;
    L21:
        if (r2 < r8) goto L23;
        setText(s1.C(2131917153, new Object[]{Integer.valueOf((int) (r8 / r5))}));
        return;
    L15:
        if (r4 < r8) goto L17;
        setText(s1.C(2131917151, new Object[]{Integer.valueOf((int) (r8 / r2))}));
        return;
    L9:
        if (r1 < r8) goto L11;
        setText(s1.C(2131917150, new Object[]{Integer.valueOf((int) (r8 / r4))}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean z(long r7, long r9) {
        long r10 = r7 - (System.currentTimeMillis() - r9);
        if (((Boolean) nz1.a.t.getValue(null, nz1.a.a[18])).booleanValue() == false) goto L5;
        setText(s1.C(2131914413, new Object[]{new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Date(r7))}));
    L7:
        if (r10 > 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        x(r10);
        goto L7
    }

    public GiftLabelTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A(long r8, long r10, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r13, "onStopAction");
        this.b = r13;
        long r11 = r8 - (System.currentTimeMillis() - r10);
        if (((Boolean) nz1.a.t.getValue(null, nz1.a.a[18])).booleanValue() == false) goto L5;
        setText(s1.C(2131914413, new Object[]{new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Date(r8))}));
    L14:
        if (r11 > 0) goto L18;
        return false;
    L18:
        return true;
    L5:
        x(r11);
        if (r11 <= 0) goto L14;
        Ref.LongRef r9 = new Ref.LongRef();
        r9.element = r11;
        if (r11 <= 0) goto L14;
        Disposable r14 = this.a;
        if (r14 == null) goto L12;
        r14.dispose();
    L12:
        j.a r15 = j.a;
        this.a = RxUtilKt.h(j.c(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io())).subscribe(new qz1.a(this, r9));
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(long r7, String r9, String r10) {
        if (r7 > 0) goto L8;
        setText(r9);
        if (StringUtils.isEmpty(r9) == false) goto L18;
        UtilityKotlinExtentionsKt.u(this);
        return;
    L18:
        return;
    L8:
        u0 r11 = u0.f;
        long r0 = u0.h.a;
        long r2 = r7 / r0;
        long r8 = r7 / u0.g.a;
        long r1 = r0 / u0.b;
        Long.signum(r2);
        long r13 = r8 - (r1 * r2);
        long r3 = 10;
        if (r2 >= r3) goto L11;
        String r4 = "0" + r2;
    L13:
        if (r13 >= r3) goto L15;
        String r14 = "0" + r13;
    L16:
        setText(s1.C(2131917152, new Object[]{r4, r14, r10}));
        return;
    L15:
        r14 = String.valueOf(r13);
        goto L16
    L11:
        r4 = String.valueOf(r2);
        goto L13
    }

    public /* synthetic */ GiftLabelTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
