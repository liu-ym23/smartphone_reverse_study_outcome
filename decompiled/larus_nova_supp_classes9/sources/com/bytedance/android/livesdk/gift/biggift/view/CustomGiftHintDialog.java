package com.bytedance.android.livesdk.gift.biggift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import i12.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gift/model/q3;", "info", BuildConfig.FLAVOR, "setData", "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "g", "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "getOnCustomGiftDialogListener", "()Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "setOnCustomGiftDialogListener", "(Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;)V", "onCustomGiftDialogListener", "Lyz0/k;", "getRoomDataService", "()Lyz0/k;", "roomDataService", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomGiftHintDialog extends FrameLayout {
    public TextView a;
    public TextView b;
    public View c;
    public TextView d;
    public View e;
    public long f;
    public a g;

    public interface a {
        void a();

        void b();
    }

    private final k getRoomDataService() {
        return com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
    }

    public final a getOnCustomGiftDialogListener() {
        return this.g;
    }

    public CustomGiftHintDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        b(r2);
    }

    public final void b(Context r2) {
        LayoutInflater.from(r2).inflate(2131565347, this);
        this.a = (TextView) findViewById(2131368397);
        this.b = (TextView) findViewById(2131368392);
        this.c = findViewById(2131368395);
        this.d = (TextView) findViewById(2131368396);
        this.e = findViewById(2131368393);
    }

    public final void setData(q3 r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        i12.e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 == null) goto L11;
        Long r3 = r2.s(r9.getRelatedGiftId());
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        long r5 = r9.getRelatedGiftId();
        h2 r6 = GiftManagerKt.l(r4);
        h2 r7 = GiftManagerKt.l(r5);
        if (r6 == null) goto L36;
        if (r7 == null) goto L36;
        ViewUtilsKt.f(this);
        this.f = r7.getId();
        String r8 = getContext().getString(2131916114);
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        String r11 = String.format(r8, Arrays.copyOf(new Object[]{r7.getName(), r6.getName()}, 2));
        TextView r13 = this.a;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogHint");
    L19:
        r13.setText(r11);
        String r14 = String.format(getContext().getString(2131916113), Arrays.copyOf(new Object[]{r7.getName()}, 1));
        TextView r15 = this.b;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogBuy");
    L22:
        r15.setText(r14);
        String r16 = String.format(getContext().getString(2131916115, new Object[]{r3.b()}), Arrays.copyOf(new Object[]{Integer.valueOf(r6.getDiamondCount())}, 1));
        TextView r17 = this.d;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogSendPrice");
    L25:
        r17.setText(r16);
        TextView r18 = this.b;
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogBuy");
    L28:
        r18.setOnClickListener(new e(this, r9));
        View r19 = this.c;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogSendLayout");
    L31:
        r19.setOnClickListener(new f(this));
        View r20 = this.e;
        if (r20 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogClose");
    L34:
        r20.setOnClickListener(new g(this));
        return;
    L36:
        ViewUtilsKt.e(this);
        return;
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void setOnCustomGiftDialogListener(a r1) {
        this.g = r1;
    }

    public CustomGiftHintDialog(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        b(r2);
    }

    public static final void a(CustomGiftHintDialog r3, String r4) {
        r3.getClass();
        HashMap r0 = new HashMap();
        r0.put("special_effect_id", String.valueOf(r3.f));
        r0.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        k r5 = r3.getRoomDataService();
        if (r5 == null) goto L5;
        r0.put("room_id", String.valueOf(r5.getRoom().getId()));
        r0.put("anchor_id", String.valueOf(r5.getRoom().getAnchorId()));
    L5:
        r0.put("button_type", r4);
        n r6 = new n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_nabob_special_runout_popup", r6.a, r6.b);
    }
}
