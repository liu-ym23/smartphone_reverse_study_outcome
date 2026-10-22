package com.bytedance.android.livesdk.gift.fastgift;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/PopupGiftDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupGiftDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int f = 0;
    public Map<Integer, View> d;
    public FastGiftViewModel e;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return false;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    static {
    }

    public PopupGiftDialogFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L9;
        r4.setGravity(80);
        r4.clearFlags(1024);
        r4.setAttributes(r4.getAttributes());
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954677);
        setBottomSheetSlideProcessor(b.a);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        return r3;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 0;
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r0 = GiftManagerKt.x();
        if (r0 != null) goto L5;
    L39:
        View r9 = S90(2131366972);
        if (r9 == null) goto L42;
        r9.setOnClickListener(new e0(this));
    L42:
        View r10 = S90(2131366980);
        if (r10 == null) goto L46;
        r10.setOnClickListener(new f0(this));
        return;
    L46:
        return;
    L5:
        if (r0.e() != null) goto L7;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L19;
        r0 = null;
    L19:
        if (r0 == null) goto L39;
        FastGiftViewModel r2 = this.e;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        if (r2.getRechargedState() != 1) goto L26;
        com.bytedance.android.livesdk.gift.platform.core.model.z r3 = (com.bytedance.android.livesdk.gift.platform.core.model.z) ListProtector.get(r0.b(), 0);
    L27:
        c0 r4 = new c0(this, r8);
        HSImageView r11 = S90(2131382758);
        if (r11 == null) goto L30;
        r11.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r3.b().getUrls(), 0)).setAutoPlayAnimations(false).setControllerListener(r4).build());
    L30:
        HSImageView r5 = S90(2131382757);
        if (r5 == null) goto L33;
        r5.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r3.a().getUrls(), 0)).setAutoPlayAnimations(false).setControllerListener(r4).build());
    L33:
        TextView r13 = (TextView) S90(2131369157);
        if (r13 == null) goto L36;
        r13.setText(vh6.c.b(ur2.a.class).Lf(r3.c(), BuildConfig.FLAVOR));
    L36:
        HSImageView r14 = S90(2131382757);
        if (r14 == null) goto L39;
        r14.setOnClickListener(new d0(r3, this));
        goto L39
    L26:
        r3 = (com.bytedance.android.livesdk.gift.platform.core.model.z) ListProtector.get(r0.b(), 1);
        goto L27
    L7:
        if (r0.c() == null) goto L15;
        if (r0.d() == null) goto L15;
        if (r0.b() == null) goto L15;
        if (r0.b().size() != 2) goto L15;
        r1 = true;
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565458, r3, false);
    }
}
