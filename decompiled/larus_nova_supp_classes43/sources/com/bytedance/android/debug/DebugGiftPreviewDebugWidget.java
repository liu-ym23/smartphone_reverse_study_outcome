package com.bytedance.android.debug;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/debug/DebugGiftPreviewDebugWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugGiftPreviewDebugWidget extends LiveRecyclableWidget {
    public RadioGroup a;
    public EditText b;
    public TextView c;
    public TextView d;
    public RecyclerView e;
    public DebugAssetsListAdapter f;
    public HSImageView g;
    public LinearLayout h;
    public FrameLayout i;
    public l j;
    public Context k;
    public final a l;

    public static final class a implements IAssetsManager.b {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        public final void a() {
        }

        public a(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r10) {
            Intrinsics.checkNotNullParameter(r10, "assetsModels");
            DebugAssetsListAdapter r0 = this.a.f;
            if (r0 == null) goto L20;
            Intrinsics.checkNotNullParameter(r10, "assetsList");
            if (r10.isEmpty() == true) goto L21;
            ((ArrayList) r0.a).clear();
            ((ArrayList) r0.b).clear();
            Iterator<T> r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L13;
            com.bytedance.android.live.core.resources.e r1 = (com.bytedance.android.live.core.resources.e) r11.next();
            if (r1.getResourceType() != 4) goto L9;
            ((ArrayList) r0.a).add(r1);
            ((ArrayList) r0.b).add(r1);
            goto L9
        L13:
            r0.notifyDataSetChanged();
            return;
        L21:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        public b(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            EditText r11 = this.a.b;
            if (r11 == null) goto L6;
            r11.setText("");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        public c(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            EditText r11 = this.a.b;
            Object r0 = null;
            if (r11 == null) goto L7;
            Editable r12 = r11.getText();
            if (r12 == null) goto L7;
            String r13 = r12.toString();
        L9:
            if (r13 != null) goto L11;
        L14:
            boolean r14 = true;
        L16:
            if (r14 == false) goto L65;
            ToastUtil.b("请填写正确的资源ID", 0);
            return;
        L65:
            com.bytedance.android.live.core.resources.e r15 = com.bytedance.android.debug.e.a().G1(CastLongProtector.parseLong(r13));     // Catch: Exception -> L21
        L32:
            if (r15 != null) goto L35;
            ToastUtil.b("请填写正确的资源ID", 0);
            return;
        L35:
            DebugGiftPreviewDebugWidget r16 = this.a;
            EditText r17 = r16.b;
            if (r17 == null) goto L48;
            Context r18 = r16.k;
            if (r18 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L40:
            if (r18 == null) goto L48;
            Object r19 = r18.getSystemService("input_method");
            if ((r19 instanceof InputMethodManager) == false) goto L45;
            r0 = r19;
        L45:
            InputMethodManager r1 = (InputMethodManager) r0;
            if (r1 == null) goto L48;
            r1.hideSoftInputFromWindow(r17.getWindowToken(), 0);
        L48:
            RadioGroup r20 = this.a.a;
            if (r20 != null) goto L51;
        L53:
            RadioGroup r21 = this.a.a;
            if (r21 != null) goto L56;
        L58:
            RadioGroup r22 = this.a.a;
            if (r22 != null) goto L61;
        L63:
            ToastUtil.b("请选择编码格式", 0);
            return;
        L61:
            if (r22.getCheckedRadioButtonId() != 2131374173) goto L63;
            ia0.a r23 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r24 = this.a;
            r24.getClass();
            r23.Ne(r15, new com.bytedance.android.debug.f(r24), 30);
            return;
        L56:
            if (r21.getCheckedRadioButtonId() != 2131374172) goto L58;
            ia0.a r25 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r26 = this.a;
            r26.getClass();
            r25.Ne(r15, new com.bytedance.android.debug.f(r26), 20);
            return;
        L51:
            if (r20.getCheckedRadioButtonId() != 2131374171) goto L53;
            ia0.a r27 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r28 = this.a;
            r28.getClass();
            r27.Ne(r15, new com.bytedance.android.debug.f(r28), 10);
            return;
        L21:
            DebugAssetsListAdapter r29 = this.a.f;
            if (r29 != null) goto L24;
        L31:
            r15 = null;
            goto L32
        L24:
            if (r29.getItemCount() != 1) goto L31;
            DebugAssetsListAdapter r30 = this.a.f;
            if (r30 == null) goto L31;
            if (((ArrayList) r30.b).size() <= 0) goto L31;
            r15 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r30.b, 0);
            goto L32
        L11:
            if (r13.length() == 0) goto L14;
            r14 = false;
        L7:
            r13 = null;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        public d(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ((Widget) this.a).containerView.setVisibility(8);
            ay1.b.I.setValue(null, ay1.b.a[40], Boolean.FALSE);
        }
    }

    public static final class e implements DebugAssetsListAdapter.a {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        public e(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.debug.DebugAssetsListAdapter.a
        public final void a(com.bytedance.android.live.core.resources.e r10) {
            Intrinsics.checkNotNullParameter(r10, "assetsModel");
            EditText r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.setText(String.valueOf(r10.getId()));
            return;
        }
    }

    public static final class f implements TextWatcher {
        public final /* synthetic */ DebugGiftPreviewDebugWidget a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r10, int r11, int r12) {
        }

        public f(DebugGiftPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r10, int r11, int r12) {
            DebugAssetsListAdapter r13 = this.a.f;
            if (r13 == null) goto L6;
            new DebugAssetsListAdapter.b(r13).filter(String.valueOf(r1));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566135;
    }

    public final void onUnload() {
    }

    public DebugGiftPreviewDebugWidget() {
        this.l = new a(this);
    }

    public final void onInit(Object[] r10) {
        ((Widget) this).containerView.setVisibility(0);
        this.k = getContext();
        this.a = (RadioGroup) findViewById(2131383606);
        this.i = (FrameLayout) findViewById(2131368584);
        RadioButton r11 = (RadioButton) findViewById(2131374171);
        RadioButton r12 = (RadioButton) findViewById(2131374172);
        RadioButton r13 = (RadioButton) findViewById(2131374173);
        this.b = (EditText) findViewById(2131363261);
        this.c = (TextView) findViewById(2131373773);
        this.d = (TextView) findViewById(2131368574);
        this.e = findViewById(2131363264);
        this.g = findViewById(2131374167);
        this.h = (LinearLayout) findViewById(2131368613);
        this.f = new DebugAssetsListAdapter();
        LinearLayoutManager r14 = new LinearLayoutManager(getContext());
        RecyclerView r1 = this.e;
        if (r1 == null) goto L5;
        r1.setLayoutManager(r14);
    L5:
        RecyclerView r15 = this.e;
        if (r15 == null) goto L8;
        r15.setAdapter(this.f);
    L8:
        DividerItemDecoration r16 = new DividerItemDecoration(getContext(), 1);
        Context r17 = this.k;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L11:
        r16.setDrawable(new ColorDrawable(ContextCompat.getColor(r17, 2131109391)));
        RecyclerView r18 = this.e;
        if (r18 == null) goto L14;
        r18.addItemDecoration(r16);
    L14:
        TextView r19 = this.d;
        if (r19 == null) goto L17;
        r19.setOnClickListener(new b(this));
    L17:
        EditText r20 = this.b;
        if (r20 == null) goto L20;
        Intrinsics.checkNotNullParameter(r20, "editText");
        SpannableString r21 = new SpannableString("请输入资源id");
        r21.setSpan(new AbsoluteSizeSpan(10, true), 0, r21.length(), 33);
        r20.setHint(new SpannableString(r21));
    L20:
        TextView r22 = this.c;
        if (r22 == null) goto L23;
        r22.setOnClickListener(new c(this));
    L23:
        ((TextView) findViewById(2131366996)).setOnClickListener(new d(this));
        DebugAssetsListAdapter r23 = this.f;
        if (r23 == null) goto L26;
        e r0 = new e(this);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r23.c = r0;
    L26:
        EditText r24 = this.b;
        if (r24 == null) goto L30;
        r24.addTextChangedListener(new f(this));
        return;
    }

    public final void onLoad(Object[] r10) {
        boolean r11 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).registerGiftPreviewDebugWidgetInstance(this);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.J.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[34])).booleanValue() == true) goto L5;
        com.bytedance.android.debug.e.a().T2(3, "debug_onLoad");
        com.bytedance.android.debug.e.a().T(this.l);
    L5:
        this.j = new l();
    }

    public final void wq(final String r10, final Long r11, final String r12) {
        ALogger.i("GiftPreviewAutoTest", "autoPlayMP4 parameter received assetUrl " + r10 + " guidelineRes " + r12);
        UtilityKotlinExtentionsKt.s(0, false, false, new DebugGiftPreviewDebugWidget$autoPlayMP4$1(this, r10, r11, r12), 7);
    }
}
