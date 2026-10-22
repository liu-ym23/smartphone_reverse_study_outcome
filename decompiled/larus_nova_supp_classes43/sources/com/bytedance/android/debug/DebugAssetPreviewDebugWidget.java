package com.bytedance.android.debug;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/debug/DebugAssetPreviewDebugWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugAssetPreviewDebugWidget extends LiveRecyclableWidget {
    public EditText a;
    public TextView b;
    public TextView c;
    public RecyclerView d;
    public DebugLocalResourceListAdapter e;
    public Context f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DebugAssetPreviewDebugWidget a;

        public a(DebugAssetPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            EditText r11 = this.a.a;
            if (r11 == null) goto L6;
            r11.setText("");
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DebugAssetPreviewDebugWidget a;

        public b(DebugAssetPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            DebugAssetPreviewDebugWidget r11 = this.a;
            DebugLocalResourceListAdapter r0 = r11.e;
            if (r0 == null) goto L9;
            ArrayList<DebugLocalResourceListAdapter.a> r12 = r11.wq();
            Intrinsics.checkNotNullParameter(r12, "assetsList");
            if (r12.isEmpty() == true) goto L10;
            ((ArrayList) r0.a).clear();
            ((ArrayList) r0.b).clear();
            ((ArrayList) r0.a).addAll(r12);
            ((ArrayList) r0.b).addAll(r12);
            r0.notifyDataSetChanged();
            return;
        L10:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DebugAssetPreviewDebugWidget a;

        public c(DebugAssetPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ((Widget) this.a).containerView.setVisibility(8);
            ay1.b.J.setValue(null, ay1.b.a[41], Boolean.FALSE);
        }
    }

    public static final class d implements DebugLocalResourceListAdapter.b {
        public final /* synthetic */ DebugAssetPreviewDebugWidget a;

        public d(DebugAssetPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.debug.DebugLocalResourceListAdapter.b
        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "resourceName");
            EditText r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.setText(r10);
            return;
        }
    }

    public static final class e implements TextWatcher {
        public final /* synthetic */ DebugAssetPreviewDebugWidget a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r10, int r11, int r12) {
        }

        public e(DebugAssetPreviewDebugWidget r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r10, int r11, int r12) {
            DebugLocalResourceListAdapter r13 = this.a.e;
            if (r13 == null) goto L6;
            new DebugLocalResourceListAdapter.c(r13).filter(String.valueOf(r1));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565162;
    }

    public final void onUnload() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v15, types: [java.util.ArrayList] */
    public final ArrayList<DebugLocalResourceListAdapter.a> wq() {
        PolarisFileWrapper r10 = new PolarisFileWrapper(((Widget) this).context.getDir("assets", 0).getAbsolutePath() + "/");
        ArrayList<DebugLocalResourceListAdapter.a> r0 = new ArrayList();
        if (r10.exists() == false) goto L52;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L52;
        File r14 = r11[r13];
        String r15 = r14.getName();
        i12.e r16 = i12.o.b();
        if (r16 == null) goto L9;
        Object r17 = com.bytedance.android.scope.m.e.d(r16, AssetsService.class);
    L10:
        AssetsService r18 = (AssetsService) r17;
        long r19 = 0;
        if (r18 != null) goto L13;
    L50:
        String r110 = "";
        long r20 = 0;
    L51:
        r0.add(new DebugLocalResourceListAdapter.a(r20, r110, String.valueOf(c0.a(r14) / ((long) 1024)), r15));
        r13 = r13 + 1;
        goto L5
    L13:
        if (r18.n == true) goto L16;
        r18.o = a0.a();
    L16:
        if (r18.o == false) goto L20;
        int r111 = r18.c.size();
        ?? r112 = new ArrayList(r111);
        int r113 = 0;
    L18:
        if (r113 >= r111) goto L21;
        r112.add((com.bytedance.android.live.core.resources.e) r18.c.valueAt(r113));
        r113 = r113 + 1;
    L21:
        if (r112 == 0) goto L50;
        Iterator r21 = ((Iterable) r112).iterator();
        String r22 = "";
    L24:
        if (r21.hasNext() == false) goto L49;
        com.bytedance.android.live.core.resources.e r114 = (com.bytedance.android.live.core.resources.e) r21.next();
        com.bytedance.android.live.core.resources.j r115 = r114.getH265ResourceModel();
        if (r115 == null) goto L28;
        String r116 = r115.getMd5();
    L30:
        if (TextUtils.equals(r116, r15) == true) goto L39;
        com.bytedance.android.live.core.resources.j r117 = r114.getH265ResourceModel();
        if (r117 == null) goto L34;
        String r118 = r117.getTtmd5();
    L36:
        if (TextUtils.equals(r118, r15) == true) goto L39;
        if (TextUtils.equals(r114.getMD5(), r15) == false) goto L24;
    L34:
        r118 = null;
    L39:
        com.bytedance.android.live.core.resources.b r119 = r114.getCleanStrategy();
        if (r119 != null) goto L42;
    L48:
        r19 = r114.getId();
        goto L24
    L42:
        if (r119.getCleanType() != 1) goto L48;
        com.bytedance.android.live.core.resources.b r23 = r114.getCleanStrategy();
        if (r23 == null) goto L47;
        r22 = r23.getAssetType();
        if (r22 != null) goto L48;
    L47:
        r22 = "";
        goto L48
    L28:
        r116 = null;
        goto L30
    L49:
        r20 = r19;
        r110 = r22;
        goto L51
    L20:
        r112 = r18.b;
        goto L21
    L9:
        r17 = null;
    L52:
        return r0;
    }

    public DebugAssetPreviewDebugWidget() {
    }

    public final void onInit(Object[] r10) {
        ((Widget) this).containerView.setVisibility(0);
        this.f = getContext();
        this.a = (EditText) findViewById(2131363261);
        this.b = (TextView) findViewById(2131368574);
        this.c = (TextView) findViewById(2131391893);
        this.d = findViewById(2131363264);
        this.e = new DebugLocalResourceListAdapter();
        LinearLayoutManager r11 = new LinearLayoutManager(getContext());
        RecyclerView r1 = this.d;
        if (r1 == null) goto L5;
        r1.setLayoutManager(r11);
    L5:
        RecyclerView r12 = this.d;
        if (r12 == null) goto L8;
        r12.setAdapter(this.e);
    L8:
        DividerItemDecoration r13 = new DividerItemDecoration(getContext(), 1);
        Context r14 = this.f;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L11:
        r13.setDrawable(new ColorDrawable(ContextCompat.getColor(r14, 2131109391)));
        RecyclerView r15 = this.d;
        if (r15 == null) goto L14;
        r15.addItemDecoration(r13);
    L14:
        TextView r16 = this.b;
        if (r16 == null) goto L17;
        r16.setOnClickListener(new a(this));
    L17:
        EditText r17 = this.a;
        if (r17 == null) goto L20;
        Intrinsics.checkNotNullParameter(r17, "editText");
        SpannableString r18 = new SpannableString("请输入资源id");
        r18.setSpan(new AbsoluteSizeSpan(10, true), 0, r18.length(), 33);
        r17.setHint(new SpannableString(r18));
    L20:
        TextView r19 = this.c;
        if (r19 == null) goto L23;
        r19.setOnClickListener(new b(this));
    L23:
        ((TextView) findViewById(2131366996)).setOnClickListener(new c(this));
        DebugLocalResourceListAdapter r20 = this.e;
        if (r20 == null) goto L26;
        d r0 = new d(this);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r20.c = r0;
    L26:
        EditText r21 = this.a;
        if (r21 == null) goto L30;
        r21.addTextChangedListener(new e(this));
        return;
    }

    public final void onLoad(Object[] r1) {
        wq();
    }
}
