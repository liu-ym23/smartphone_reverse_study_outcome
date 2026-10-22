package com.bytedance.android.live.livepkaudience.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.rank.model.g;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/PkWithAudienceFeedbackView;", "Landroid/widget/ScrollView;", "", "content", "", "setTagTitleText", "getSelectedTag", "getSelectedSubTag", "Lcom/bytedance/android/live/livepkaudience/view/PkWithAudienceFeedbackView$a;", "listener", "setListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceFeedbackView extends ScrollView {
    public Map<Integer, View> a;
    public g b;
    public String c;
    public final List<String> d;
    public String e;
    public a f;
    public TextView g;
    public final e h;
    public final d i;

    public interface a {
        void a();
    }

    public static final class b extends d2 {
        public final /* synthetic */ PkWithAudienceFeedbackView a;

        public b(PkWithAudienceFeedbackView r1) {
            this.a = r1;
        }

        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (r1 == null) goto L7;
            String r5 = r1.toString();
            if (r5 == null) goto L8;
            this.a.e = r5;
            return;
        L8:
            return;
        }
    }

    public static final class c implements View.OnTouchListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            int r6 = r5.getAction();
            if (r6 == 0) goto L11;
            if (r6 != 1) goto L6;
        L10:
            r4.getParent().requestDisallowInterceptTouchEvent(false);
        L12:
            return false;
        L6:
            if (r6 == 2) goto L11;
            if (r6 == 3) goto L10;
        L11:
            r4.getParent().requestDisallowInterceptTouchEvent(true);
            goto L12
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PkWithAudienceFeedbackView a;

        public d(PkWithAudienceFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (r3 == null) goto L22;
            TextView r4 = (TextView) r3;
            if (r4.getTag() == null) goto L15;
            Object r0 = r4.getTag();
            Boolean r1 = Boolean.FALSE;
            if (Intrinsics.areEqual(r0, r1) == true) goto L15;
            r4.setBackgroundResource(2131249985);
            r4.setTextColor(s1.h(2131107996));
            r4.setTag(r1);
            CharSequence r5 = r4.getText();
            if (r5 == null) goto L23;
            String r6 = r5.toString();
            if (r6 != null) goto L13;
            return;
        L13:
            if (((ArrayList) this.a.d).contains(r6) == false) goto L25;
            ((ArrayList) this.a.d).remove(r6);
            return;
        L25:
            return;
        L23:
            return;
        L15:
            r4.setBackgroundResource(2131249984);
            r4.setTextColor(s1.h(2131107995));
            r4.setTag(Boolean.TRUE);
            CharSequence r7 = r4.getText();
            if (r7 == null) goto L27;
            String r8 = r7.toString();
            if (r8 == null) goto L28;
            ((ArrayList) this.a.d).add(r8);
            return;
        L28:
            return;
        L27:
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PkWithAudienceFeedbackView a;

        public e(PkWithAudienceFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (r10 == null) goto L45;
            TextView r11 = (TextView) r10;
            TextView r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.setTag(Boolean.FALSE);
            r0.setBackgroundResource(2131249985);
            r0.setTextColor(s1.h(2131107996));
        L6:
            ((ArrayList) this.a.d).clear();
            PkWithAudienceFeedbackView r1 = this.a;
            r1.e = "";
            List r4 = null;
            if (Intrinsics.areEqual(r1.g, r11) == false) goto L12;
            PkWithAudienceFeedbackView r12 = this.a;
            r12.c = null;
            ((LinearLayout) r12.a(2131387543)).setVisibility(8);
            this.a.a(2131387545).removeAllViews();
            PkWithAudienceFeedbackView r13 = this.a;
            r13.g = null;
            a r14 = r13.f;
            if (r14 == null) goto L55;
            r14.a();
            return;
        L55:
            return;
        L12:
            this.a.g = r11;
            if (r11.getTag() != null) goto L15;
        L16:
            r11.setBackgroundResource(2131249984);
            r11.setTextColor(s1.h(2131107995));
            r11.setTag(Boolean.TRUE);
            PkWithAudienceFeedbackView r2 = this.a;
            CharSequence r15 = r11.getText();
            if (r15 == null) goto L19;
            String r16 = r15.toString();
        L20:
            r2.c = r16;
            a r17 = this.a.f;
            if (r17 == null) goto L23;
            r17.a();
        L23:
            g r18 = this.a.b;
            if (r18 == null) goto L26;
            r4 = r18.getIssueCategories();
        L26:
            if (r4 == null) goto L56;
            Iterator r19 = r4.iterator();
        L29:
            if (r19.hasNext() == false) goto L57;
            com.bytedance.android.livesdk.rank.model.b r3 = (com.bytedance.android.livesdk.rank.model.b) r19.next();
            if (Intrinsics.areEqual(r3.getCategory(), this.a.c) == false) goto L29;
            PkWithAudienceFeedbackView r5 = this.a;
            ((LinearLayout) r5.a(2131387543)).setVisibility(0);
            List r6 = r3.getIssues();
            if (r6 != null) goto L36;
            r6 = CollectionsKt.emptyList();
        L36:
            if (Lists.isEmpty(r6) == true) goto L37;
            ((TextView) r5.a(2131387544)).setText(s1.B(2131922734));
            r5.a(2131387545).removeAllViews();
            Iterator r7 = r6.iterator();
        L40:
            if (r7.hasNext() == false) goto L42;
            TextView r8 = r5.b((String) r7.next());
            r5.a(2131387545).addView(r8);
            r8.setOnClickListener(r5.i);
            goto L40
        L42:
            r5.a(2131387545).setVisibility(0);
            ((EditText) r5.a(2131381725)).setVisibility(8);
            goto L29
        L37:
            ((TextView) r5.a(2131387544)).setText(s1.B(2131922735));
            ((EditText) r5.a(2131381725)).setVisibility(0);
            r5.a(2131387545).setVisibility(8);
            goto L29
        L57:
            return;
        L56:
            return;
        L19:
            r16 = null;
            goto L20
        L15:
            if (Intrinsics.areEqual(r11.getTag(), Boolean.FALSE) == true) goto L16;
            return;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final String getSelectedSubTag() {
        if (TextUtils.isEmpty(this.e) == false) goto L5;
        Iterator<String> r0 = this.d.iterator();
        String r1 = "";
    L8:
        if (r0.hasNext() == false) goto L11;
        r1 = r1 + r0.next() + ',';
        goto L8
    L11:
        if (StringsKt.endsWith$default(r1, ",", false, 2, null) == true) goto L13;
        return r1;
    L13:
        return r1.substring(0, r1.length() - 1);
    L5:
        return this.e;
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(2131567810, this, true);
        ((EditText) a(2131381725)).addTextChangedListener(new b(this));
        ((EditText) a(2131381725)).setOnTouchListener(c.a);
    }

    public final String getSelectedTag() {
        return this.c;
    }

    public PkWithAudienceFeedbackView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = "";
        this.h = new e(this);
        this.i = new d(this);
        c();
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

    public final TextView b(String r4) {
        TextView r0 = new TextView(getContext());
        r0.setBackgroundResource(2131249985);
        r0.setText(r4);
        r0.setTextColor(s1.h(2131107996));
        r0.setTextSize(1, 12.0f);
        int r5 = (int) UIUtils.dip2Px(getContext(), 18.0f);
        int r1 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        r0.setPadding(r5, r1, r5, r1);
        return r0;
    }

    public final void setListener(a r1) {
        this.f = r1;
    }

    public final void setTagTitleText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        ((TextView) a(2131388142)).setText(r2);
    }

    public PkWithAudienceFeedbackView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = "";
        this.h = new e(this);
        this.i = new d(this);
        c();
    }

    public PkWithAudienceFeedbackView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = "";
        this.h = new e(this);
        this.i = new d(this);
        c();
    }
}
