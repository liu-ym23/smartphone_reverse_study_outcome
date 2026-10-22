package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/RadioTextBoardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "RadioTextBoardAdapter", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RadioTextBoardView extends ConstraintLayout {
    public TextView a;
    public RecyclerView b;
    public RadioTextBoardAdapter c;
    public c d;
    public com.bytedance.android.live.liveinteract.view.b e;
    public int f;
    public String g;

    public static final class RadioTextBoardAdapter extends RecyclerView.Adapter<TextViewHolder> {
        public List<String> a;
        public com.bytedance.android.live.liveinteract.view.b b;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/RadioTextBoardView$RadioTextBoardAdapter$TextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final class TextViewHolder extends RecyclerView.ViewHolder {
            public TextViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
            }
        }

        public final int getItemCount() {
            return this.a.size();
        }

        public RadioTextBoardAdapter(List<String> r2, com.bytedance.android.live.liveinteract.view.b r3) {
            Intrinsics.checkNotNullParameter(r2, "contentList");
            this.a = r2;
            this.b = r3;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            TextViewHolder r5 = (TextViewHolder) r3;
            Intrinsics.checkNotNullParameter(r5, "holder");
            String r6 = (String) ListProtector.get(this.a, r4);
            com.bytedance.android.live.liveinteract.view.b r0 = this.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "text");
            View r7 = ((RecyclerView.ViewHolder) r5).itemView;
            if ((r7 instanceof TextView) == true) goto L5;
            r7 = null;
        L5:
            TextView r8 = (TextView) r7;
            if (r8 == null) goto L8;
            r8.setText(r6);
        L8:
            if (r0 == null) goto L18;
            if (r8 == null) goto L11;
            r8.setGravity(r0.a);
        L11:
            if (r8 == null) goto L19;
            r8.setTextColor(Color.parseColor(r0.c));     // Catch: Throwable -> L14
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
            return;
        L14:
            ALogger.e("RadioTextBoardView", "set text color exception, color: " + r0.c);
            Unit r10 = Unit.INSTANCE;
            return;
        L19:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new TextViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567248, r4, false));
        }
    }

    public static final class a {
    }

    public static final class b extends LinearLayoutManager {
        public final Context a;

        public final boolean canScrollVertically() {
            return false;
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3, 1, false);
            this.a = r3;
        }
    }

    public static final class c extends LinearSmoothScroller {
        public final long a;

        public final float calculateSpeedPerPixel(DisplayMetrics r3) {
            if (r3 != null) goto L6;
            return super.calculateSpeedPerPixel(r3);
        L6:
            return this.a / UtilityKotlinExtentionsKt.i(17);
        }

        public final int calculateTimeForDeceleration(int r3) {
            return (int) Math.ceil(calculateTimeForScrolling(r3));
        }

        public c(long r2, Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
            this.a = r2;
        }

        public final void onTargetFound(View r3, RecyclerView.State r4, RecyclerView.SmoothScroller.Action r5) {
            Intrinsics.checkNotNullParameter(r3, "targetView");
            Intrinsics.checkNotNullParameter(r4, "state");
            Intrinsics.checkNotNullParameter(r5, "action");
            int r6 = calculateDxToMakeVisible(r3, getHorizontalSnapPreference());
            int r7 = calculateDyToMakeVisible(r3, getVerticalSnapPreference());
            int r0 = calculateTimeForDeceleration((int) Math.sqrt((r6 * r6) + (r7 * r7)));
            if (r0 <= 0) goto L6;
            r5.update(-r6, -r7, r0, ((LinearSmoothScroller) this).mLinearInterpolator);
            return;
        }
    }

    static {
    }

    public RadioTextBoardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RadioTextBoardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    public final void S5() {
        RecyclerView r0 = this.b;
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof LinearLayoutManager) == false) goto L10;
        r1 = r2;
    L10:
        LinearLayoutManager r3 = (LinearLayoutManager) r1;
        if (r3 == null) goto L13;
        r3.scrollToPositionWithOffset(0, 0);
    L13:
        RecyclerView r4 = this.b;
        if (r4 == null) goto L16;
        r4.scrollToPosition(0);
    L16:
        RecyclerView r5 = this.b;
        if (r5 == null) goto L19;
        r5.stopScroll();
    L19:
        this.f = -1;
        return;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "seiObj");
        JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(r6, "audio_live_text_data");
        if (r7 == null) goto L5;
        int r1 = r7.optInt("row");
    L6:
        if (r7 == null) goto L9;
        String r2 = r7.optString("type");
        if (r2 == null) goto L9;
    L10:
        if (r7 == null) goto L13;
        String r8 = r7.optString("show_id");
        if (r8 == null) goto L13;
    L15:
        if ((!Intrinsics.areEqual(r8, this.g)) == true) goto L85;
        String r9 = this.g;
        if (r9 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == true) goto L94;
        com.bytedance.android.live.liveinteract.view.b r11 = this.e;
        RecyclerView.LayoutManager r4 = null;
        if (r11 != null) goto L28;
    L73:
        RecyclerView r12 = this.b;
        if (r12 == null) goto L76;
        RecyclerView.LayoutManager r13 = r12.getLayoutManager();
    L78:
        if ((r13 instanceof LinearLayoutManager) == false) goto L81;
        r4 = r13;
    L81:
        LinearLayoutManager r5 = (LinearLayoutManager) r4;
        if (r5 == null) goto L93;
        r5.scrollToPositionWithOffset(r1, 0);
        return;
    L93:
        return;
    L76:
        r13 = null;
        goto L78
    L28:
        if (r11.d != true) goto L73;
        if (this.f < 0) goto L34;
        if (Intrinsics.areEqual(r2, "restart") == true) goto L34;
    L47:
        if (this.f < 0) goto L49;
        this.f = r1;
    L49:
        RecyclerView r14 = this.b;
        if (r14 != null) goto L52;
        return;
    L52:
        if (r14.getScrollState() != 0) goto L87;
        com.bytedance.android.live.liveinteract.view.b r15 = this.e;
        if (r15 != null) goto L56;
    L62:
        RecyclerView r16 = this.b;
        if (r16 == null) goto L65;
        RecyclerView.LayoutManager r17 = r16.getLayoutManager();
    L67:
        if ((r17 instanceof LinearLayoutManager) == false) goto L70;
        r4 = r17;
    L70:
        LinearLayoutManager r18 = (LinearLayoutManager) r4;
        if (r18 == null) goto L91;
        r18.scrollToPositionWithOffset(0, 0);
        return;
    L91:
        return;
    L65:
        r17 = null;
        goto L67
    L56:
        if (r15.d != true) goto L62;
        c r0 = new c(r15.e, getContext());
        this.d = r0;
        RadioTextBoardAdapter r19 = this.c;
        Intrinsics.checkNotNull(r19);
        r0.setTargetPosition(r19.getItemCount() - 1);
        RecyclerView r20 = this.b;
        if (r20 == null) goto L88;
        RecyclerView.LayoutManager r21 = r20.getLayoutManager();
        if (r21 == null) goto L89;
        r21.startSmoothScroll(this.d);
        return;
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L34:
        if (r1 == this.f) goto L45;
        ALogger.i("RadioTextBoardView", "scroll line: " + r1);
        RecyclerView r22 = this.b;
        if (r22 == null) goto L38;
        RecyclerView.LayoutManager r23 = r22.getLayoutManager();
    L40:
        if ((r23 instanceof LinearLayoutManager) == true) goto L42;
        r23 = null;
    L42:
        LinearLayoutManager r24 = (LinearLayoutManager) r23;
        if (r24 == null) goto L45;
        r24.scrollToPositionWithOffset(r1, 0);
        goto L45
    L38:
        r23 = null;
    L45:
        this.f = r1;
        goto L47
    L94:
        return;
    L19:
        if (r9.length() == 0) goto L22;
        r10 = false;
        goto L23
    L85:
        return;
    L13:
        r8 = "";
    L9:
        r2 = "normal";
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(com.bytedance.android.live.liveinteract.view.c r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        this.g = r4.e;
        String r0 = r4.a;
        com.bytedance.android.live.liveinteract.view.b r1 = r4.c;
        TextView r2 = this.a;
        if (r2 == null) goto L5;
        r2.setText(r0);
    L5:
        if (r1 == null) goto L14;
        TextView r3 = this.a;
        if (r3 == null) goto L27;
        r3.setGravity(r1.a);
    L27:
        TextView r5 = this.a;     // Catch: Throwable -> L13
        if (r5 == null) goto L14;
        r5.setTextColor(Color.parseColor(r1.c));     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L13:
        ALogger.e("RadioTextBoardView", "set title text color exception, color: " + r1.c);
        Unit r7 = Unit.INSTANCE;
    L14:
        com.bytedance.android.live.liveinteract.view.b r8 = r4.d;
        this.e = r8;
        RadioTextBoardAdapter r9 = this.c;
        if (r9 == null) goto L17;
        List<String> r10 = r4.b;
        Intrinsics.checkNotNullParameter(r10, "textContentList");
        r9.a = r10;
        r9.b = r8;
    L17:
        RadioTextBoardAdapter r11 = this.c;
        if (r11 == null) goto L20;
        r11.notifyDataSetChanged();
    L20:
        com.bytedance.android.live.liveinteract.view.b r12 = this.e;
        if (r12 != null) goto L23;
    L25:
        S5();
        return;
    L23:
        if (r12.d != true) goto L25;
        this.d = new c(r12.e, getContext());
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RadioTextBoardView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.e = new com.bytedance.android.live.liveinteract.view.b(0, 31);
        this.f = -1;
        LayoutInflater.from(r3).inflate(2131565114, this);
        this.a = (TextView) findViewById(2131383615);
        RecyclerView r6 = findViewById(2131383613);
        this.b = r6;
        if (r6 == null) goto L5;
        r6.setLayoutManager(new b(getContext()));
    L5:
        RecyclerView r7 = this.b;
        if (r7 == null) goto L8;
        r7.setHasFixedSize(true);
    L8:
        RadioTextBoardAdapter r8 = new RadioTextBoardAdapter(CollectionsKt.emptyList(), this.e);
        this.c = r8;
        RecyclerView r9 = this.b;
        if (r9 == null) goto L12;
        r9.setAdapter(r8);
        return;
    }

    public /* synthetic */ RadioTextBoardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
