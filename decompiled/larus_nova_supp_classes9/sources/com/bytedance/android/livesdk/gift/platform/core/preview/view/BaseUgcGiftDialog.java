package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUgcGiftDialog extends LiveDialogFragment {
    public static final /* synthetic */ int o = 0;
    public int d;
    public String e;
    public Function0<Unit> f;
    public RecyclerView g;
    public TextView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> m;
    public DialogInterface.OnDismissListener n;

    public static final class a implements LiveBottomSheetDialog.m {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public abstract BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90();

    public BaseUgcGiftDialog() {
        this.e = BuildConfig.FLAVOR;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        ViewGroup.LayoutParams r1 = null;
        if ((r6 instanceof LiveBottomSheetDialog) == true) goto L5;
        r6 = null;
    L5:
        LiveBottomSheetDialog r7 = (LiveBottomSheetDialog) r6;
        if (r7 == null) goto L8;
        View r8 = r7.getBottomSheetView();
    L9:
        if (r8 == null) goto L12;
        r1 = r8.getLayoutParams();
    L12:
        if (r1 == null) goto L14;
        r1.height = -1;
    L14:
        if (r8 == null) goto L16;
        r8.setLayoutParams(r1);
    L16:
        Dialog r9 = getDialog();
        if (r9 == null) goto L23;
        Window r2 = r9.getWindow();
        if (r2 == null) goto L21;
        r2.setLayout(-1, -2);
        WindowManager.LayoutParams r0 = r2.getAttributes();
        r0.width = s1.y();
        r0.height = s1.w() - s1.A();
        r2.setAttributes(r0);
        r2.setGravity(80);
    L21:
        r9.setCanceledOnTouchOutside(true);
        return;
    L23:
        return;
    L8:
        r8 = null;
        goto L9
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954694);
        super.setBottomSheetSlideProcessor(a.a);
    }

    public void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        RecyclerView r8 = r6.findViewById(2131373737);
        r8.setItemViewCacheSize(12);
        View r0 = null;
        r8.setItemAnimator(null);
        r8.setLayoutManager(new SSGridLayoutManager(r8.getContext(), 4, 1));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.addItemDecoration(new BaseUgcGiftDialog$create$1$1());
        this.g = r8;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r9 = S90();
        this.m = r9;
        RecyclerView r2 = this.g;
        if (r2 == null) goto L5;
        r2.setAdapter(r9);
    L5:
        View r10 = r6.findViewById(2131365096);
        if (r10 != null) goto L8;
    L11:
        this.k = r0;
        this.l = r6.findViewById(2131365107);
        View r11 = this.k;
        if (r11 == null) goto L15;
        r11.setOnClickListener(new com.bytedance.android.livesdk.gift.platform.core.preview.view.a(this));
        return;
    L15:
        return;
    L8:
        if (this.f == null) goto L10;
        r10.setVisibility(0);
    L10:
        Unit r1 = Unit.INSTANCE;
        r0 = r10;
        goto L11
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L8;
        r6.setSoftInputMode(48);
    L8:
        return r2.inflate(2131566204, r3, false);
    }
}
