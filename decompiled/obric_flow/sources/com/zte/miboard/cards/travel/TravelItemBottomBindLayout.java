package com.zte.miboard.cards.travel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.m;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.TravelData;

/* JADX INFO: loaded from: classes3.dex */
public class TravelItemBottomBindLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TravelFlightUtils.j f16382a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelItemBottomBindLayout f16383a;

        public a(TravelItemBottomBindLayout r5) {
            this.f16383a = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            m.i("TravelItemBottomBindLayout", "onClick");
            TravelFlightUtils.b(this.f16383a.getContext(), true);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelItemBottomBindLayout f16384a;

        public b(TravelItemBottomBindLayout r5) {
            this.f16384a = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            m.i("TravelItemBottomBindLayout", "onClick close");
            this.f16384a.setVisibility(8);
            if ((this.f16384a.getParent() instanceof TravelItemLayout) == true) goto L5;
        L7:
            TravelData r10 = null;
        L8:
            TravelItemBottomBindLayout.a(this.f16384a);
            if (r10 == null) goto L12;
            m.i("TravelItemBottomBindLayout", "onClick close save hideBind updateTravelData");
            com.zte.miboard.cards.travel.b.c(this.f16384a.getContext(), r10);
            return;
        L12:
            return;
        L5:
            if ((((TravelItemLayout) this.f16384a.getParent()).getTag() instanceof TravelData) == false) goto L7;
            r10 = (TravelData) ((TravelItemLayout) this.f16384a.getParent()).getTag();
            r10.setHideBind();
            goto L8
        }
    }

    public class c implements TravelFlightUtils.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelItemBottomBindLayout f16385a;

        public c(TravelItemBottomBindLayout r5) {
            this.f16385a = r5;
        }

        @Override // com.zte.miboard.cards.travel.TravelFlightUtils.j
        public void a(boolean r5) {
            TravelItemBottomBindLayout.a(this.f16385a);
        }
    }

    public TravelItemBottomBindLayout(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(TravelItemBottomBindLayout r5) {
        r5.b();
    }

    private void b() {
        if ((getParent() instanceof TravelItemLayout) == false) goto L5;
        TravelItemLayout r5 = (TravelItemLayout) getParent();
    L6:
        int r10 = 0;
        if (r5 != null) goto L9;
    L11:
        boolean r11 = false;
    L12:
        boolean r12 = true;
        if (r11 == false) goto L15;
    L17:
        boolean r13 = false;
    L18:
        StringBuilder r14 = new StringBuilder("onBindView needShow=");
        r14.append(r13);
        r14.append(" isHideBind=");
        r14.append(r11);
        r14.append(" travelItemLayout=");
        if (r5 != null) goto L22;
        r12 = false;
    L22:
        r14.append(r12);
        m.i("TravelItemBottomBindLayout", r14.toString());
        if (r13 == true) goto L26;
        r10 = 8;
    L26:
        setVisibility(r10);
        if (r5 == null) goto L30;
        r5.i();
        return;
    L30:
        return;
    L15:
        if (TravelFlightUtils.g(getContext()) == true) goto L17;
        r13 = true;
        goto L18
    L9:
        if ((r5.getTag() instanceof TravelData) == false) goto L11;
        r11 = ((TravelData) r5.getTag()).isHideBind();
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        findViewById(R.id.travel_card_item_bottom_bind_layout).setOnClickListener(new a(this));
        findViewById(R.id.travel_card_item_bottom_bind_close_layout).setOnClickListener(new b(this));
    }

    public void setDataKey(com.zte.miboard.cards.travel.b.f r5) {
        if (r5 == com.zte.miboard.cards.travel.b.f.d) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        if ((getParent() instanceof TravelItemLayout) == true) goto L9;
        return;
    L9:
        if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup r10 = (ViewGroup) getParent();
        r10.setClipToPadding(false);
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) getLayoutParams();
        r11.leftMargin = 0 - r10.getPaddingLeft();
        r11.rightMargin = 0 - r10.getPaddingRight();
        setLayoutParams(r11);
        return;
    }

    public TravelItemBottomBindLayout(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public void a(TravelData r5) {
        if (r5 == null) goto L14;
        boolean r10 = r5 instanceof FlightData;
        if (r10 == false) goto L14;
        if (r5.isHideBind() == true) goto L14;
        b();
        if (r10 == true) goto L11;
        return;
    L11:
        if (r5.isHideBind() == true) goto L17;
        m.i("TravelItemBottomBindLayout", "onBindView mRegisterCallback=" + this.f16382a);
        TravelFlightUtils.a(getContext(), this.f16382a, true);
        return;
    L17:
        return;
    L14:
        setVisibility(8);
    }

    public TravelItemBottomBindLayout(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16382a = new c(this);
    }

    public void a() {
        m.i("TravelItemBottomBindLayout", "onTravelItemLayoutRemoved mRegisterCallback=" + this.f16382a);
        TravelFlightUtils.a(getContext(), this.f16382a);
    }
}
