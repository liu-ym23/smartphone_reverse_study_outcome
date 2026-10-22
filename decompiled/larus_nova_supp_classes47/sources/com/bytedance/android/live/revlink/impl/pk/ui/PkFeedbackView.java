package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.state.SubCategoryInputType;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.link.model.o4;
import com.bytedance.android.livesdk.link.model.w7;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0004¢\u0006\u0004\b!\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002R2\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkFeedbackView;", "Landroid/widget/ScrollView;", "", "getSelectTag", "", "getSelectTagType", "()Ljava/lang/Integer;", "getSelectReportTag", "getSelectReportSerialId", "getSelectReportOther", "getSelectSubTag", "getPkSelectTag", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PkFeedbackView$a;", "listener", "", "setListener", "", "selected", "setTagSelected", "", "s", "setEditText", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "getSelectRandomTags", "()Ljava/util/ArrayList;", "setSelectRandomTags", "(Ljava/util/ArrayList;)V", "selectRandomTags", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkFeedbackView extends ScrollView {
    public Map<Integer, View> a;
    public String b;
    public final ArrayList<String> c;
    public ArrayList<String> d;
    public int e;
    public String f;
    public int g;
    public final ArrayList<o4> h;
    public final ArrayList<o4> i;
    public String j;
    public w7 k;
    public View l;
    public View m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public a r;
    public final String s;
    public final b t;
    public final e u;

    public interface a {
        void a(CharSequence r1);

        void b(boolean r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackView a;

        public b(PkFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            View r0 = this.a.l;
            if (r0 == null) goto L5;
            r0.setTag(Boolean.FALSE);
            r0.setBackgroundResource(2131249987);
            ((TextView) r0).setTextColor(s1.h(2131108001));
        L5:
            List r8 = null;
            if (Intrinsics.areEqual(this.a.l, r13) == false) goto L33;
            PkFeedbackView r14 = this.a;
            r14.f = null;
            r14.g = 0;
            r14.c.clear();
            EditText r15 = (EditText) this.a.a(2131371783);
            if (r15 == null) goto L10;
            r15.setText(null);
        L10:
            EditText r16 = (EditText) this.a.a(2131384372);
            if (r16 == null) goto L13;
            r16.setText(null);
        L13:
            PkFeedbackView r17 = this.a;
            r17.b = null;
            r17.e = 0;
            r17.n = false;
            r17.o = false;
            TextView r18 = (TextView) r17.a(2131391531);
            if (r18 == null) goto L16;
            r18.setVisibility(8);
        L16:
            TextView r19 = (TextView) this.a.a(2131391293);
            if (r19 == null) goto L19;
            r19.setVisibility(8);
        L19:
            WrapLineFlowLayout r110 = this.a.a(2131387515);
            if (r110 == null) goto L22;
            r110.removeAllViews();
        L22:
            WrapLineFlowLayout r111 = this.a.a(2131387515);
            if (r111 == null) goto L25;
            r111.setVisibility(8);
        L25:
            EditText r112 = (EditText) this.a.a(2131371783);
            if (r112 == null) goto L28;
            r112.setVisibility(8);
        L28:
            EditText r113 = (EditText) this.a.a(2131384372);
            if (r113 == null) goto L31;
            r113.setVisibility(8);
        L31:
            PkFeedbackView r114 = this.a;
            r114.l = null;
            PkFeedbackView.c(r114, false);
            return;
        L33:
            PkFeedbackView r1 = this.a;
            r1.f = null;
            r1.g = 0;
            r1.c.clear();
            EditText r2 = (EditText) this.a.a(2131371783);
            if (r2 == null) goto L36;
            r2.setText(null);
        L36:
            EditText r3 = (EditText) this.a.a(2131384372);
            if (r3 == null) goto L39;
            r3.setText(null);
        L39:
            TextView r4 = (TextView) this.a.a(2131391531);
            if (r4 == null) goto L42;
            r4.setVisibility(8);
        L42:
            TextView r5 = (TextView) this.a.a(2131391293);
            if (r5 == null) goto L45;
            r5.setVisibility(8);
        L45:
            EditText r6 = (EditText) this.a.a(2131371783);
            if (r6 == null) goto L48;
            r6.setVisibility(8);
        L48:
            EditText r7 = (EditText) this.a.a(2131384372);
            if (r7 == null) goto L51;
            r7.setVisibility(8);
        L51:
            this.a.l = r13;
            if (r13.getTag() == null) goto L75;
            Object r9 = r13.getTag();
            Boolean r12 = Boolean.FALSE;
            if (Intrinsics.areEqual(r9, r12) == true) goto L75;
            r13.setBackgroundResource(2131249987);
            TextView r115 = (TextView) r13;
            r115.setTextColor(s1.h(2131108001));
            r115.setTag(r12);
            TextView r116 = (TextView) this.a.a(2131391531);
            if (r116 == null) goto L59;
            r116.setVisibility(8);
        L59:
            TextView r117 = (TextView) this.a.a(2131391293);
            if (r117 == null) goto L62;
            r117.setVisibility(8);
        L62:
            PkFeedbackView r118 = this.a;
            r118.b = null;
            r118.e = 0;
            WrapLineFlowLayout r119 = r118.a(2131387515);
            if (r119 == null) goto L65;
            r119.removeAllViews();
        L65:
            WrapLineFlowLayout r120 = this.a.a(2131387515);
            if (r120 == null) goto L68;
            r120.setVisibility(8);
        L68:
            EditText r121 = (EditText) this.a.a(2131371783);
            if (r121 == null) goto L71;
            r121.setVisibility(8);
        L71:
            EditText r122 = (EditText) this.a.a(2131384372);
            if (r122 == null) goto L74;
            r122.setVisibility(8);
        L74:
            PkFeedbackView.c(this.a, false);
            return;
        L75:
            r13.setBackgroundResource(2131249986);
            TextView r123 = (TextView) r13;
            r123.setTextColor(s1.h(2131108000));
            r123.setTag(Boolean.TRUE);
            TextView r10 = (TextView) this.a.a(2131391531);
            if (r10 == null) goto L78;
            r10.setVisibility(0);
        L78:
            PkFeedbackView r20 = this.a;
            CharSequence r124 = r123.getText();
            if (r124 == null) goto L81;
            String r125 = r124.toString();
        L82:
            r20.b = r125;
            ArrayList<o4> r126 = this.a.i;
            if (r126 == null) goto L90;
            Iterator<o4> r127 = r126.iterator();
        L86:
            if (r127.hasNext() == false) goto L90;
            o4 r22 = r127.next();
            if (Intrinsics.areEqual(r22.getIssueContent(), this.a.b) == false) goto L86;
            this.a.e = r22.getFeedBackType();
        L90:
            w7 r128 = this.a.k;
            if (r128 == null) goto L94;
            r8 = r128.getIssuesList();
        L94:
            if (r8 == null) goto L157;
            Iterator r23 = r8.iterator();
        L97:
            if (r23.hasNext() == false) goto L157;
            o4 r24 = (o4) r23.next();
            if (Intrinsics.areEqual(r24.getIssueContent(), this.a.b) == false) goto L97;
            if (Lists.isEmpty(r24.getSubCategories()) == true) goto L103;
            if (r24.getSubCategoryInputType() != SubCategoryInputType.InputRadio.ordinal()) goto L133;
            this.a.h.clear();
            List r25 = r24.getSubCategories();
            if (r25 == null) goto L129;
            this.a.h.addAll(r25);
        L129:
            PkFeedbackView r26 = this.a;
            r26.n = true;
            TextView r27 = (TextView) r26.a(2131391531);
            if (r27 == null) goto L140;
            r27.setText(s1.B(2131921409));
        L140:
            WrapLineFlowLayout r28 = this.a.a(2131387515);
            if (r28 == null) goto L143;
            r28.removeAllViews();
        L143:
            List r29 = r24.getSubCategories();
            Intrinsics.checkNotNull(r29);
            Iterator r30 = r29.iterator();
        L145:
            if (r30.hasNext() == false) goto L150;
            TextView r32 = this.a.d(((o4) r30.next()).getIssueContent());
            WrapLineFlowLayout r33 = this.a.a(2131387515);
            if (r33 == null) goto L149;
            r33.addView(r32);
        L149:
            r32.setOnClickListener(this.a.u);
            goto L145
        L150:
            WrapLineFlowLayout r34 = this.a.a(2131387515);
            if (r34 == null) goto L153;
            r34.setVisibility(0);
        L153:
            EditText r35 = (EditText) this.a.a(2131371783);
            if (r35 == null) goto L156;
            r35.setVisibility(8);
        L156:
            this.a.o = false;
            goto L97
        L133:
            if (r24.getSubCategoryInputType() != SubCategoryInputType.InputCheckBox.ordinal()) goto L137;
            PkFeedbackView r36 = this.a;
            r36.n = false;
            TextView r37 = (TextView) r36.a(2131391531);
            if (r37 == null) goto L140;
            r37.setText(s1.B(2131921425));
            goto L140
        L137:
            TextView r38 = (TextView) this.a.a(2131391531);
            if (r38 == null) goto L140;
            r38.setVisibility(8);
            goto L140
        L103:
            if (r24.getSubCategoryInputType() == SubCategoryInputType.InputText.ordinal()) goto L104;
            TextView r39 = (TextView) this.a.a(2131391531);
            if (r39 == null) goto L117;
            r39.setVisibility(8);
        L117:
            EditText r40 = (EditText) this.a.a(2131371783);
            if (r40 == null) goto L120;
            r40.setVisibility(8);
        L120:
            WrapLineFlowLayout r42 = this.a.a(2131387515);
            if (r42 == null) goto L123;
            r42.setVisibility(8);
        L123:
            PkFeedbackView r43 = this.a;
            r43.n = false;
            r43.o = false;
            goto L97
        L104:
            EditText r44 = (EditText) this.a.a(2131371783);
            if (r44 == null) goto L107;
            r44.setVisibility(0);
        L107:
            WrapLineFlowLayout r45 = this.a.a(2131387515);
            if (r45 == null) goto L110;
            r45.setVisibility(8);
        L110:
            TextView r46 = (TextView) this.a.a(2131391531);
            if (r46 == null) goto L113;
            r46.setText(s1.B(2131921427));
        L113:
            this.a.o = true;
        L157:
            PkFeedbackView.c(this.a, true);
            return;
        L81:
            r125 = null;
            goto L82
        }
    }

    public static final class c extends com.bytedance.android.live.revlink.impl.pk.utils.v {
        public final /* synthetic */ PkFeedbackView a;

        public c(PkFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            PkFeedbackView.b(this.a, r1);
            if (r1 == null) goto L10;
            String r5 = r1.toString();
            if (r5 == null) goto L11;
            this.a.c.clear();
            if (TextUtils.isEmpty(r5) == true) goto L12;
            this.a.c.add(r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d extends com.bytedance.android.live.revlink.impl.pk.utils.v {
        public final /* synthetic */ PkFeedbackView a;

        public d(PkFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            PkFeedbackView.b(this.a, r1);
            if (r1 == null) goto L8;
            String r5 = r1.toString();
            if (r5 == null) goto L9;
            this.a.j = r5;
            return;
        L9:
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackView a;

        public e(PkFeedbackView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            PkFeedbackView r0 = this.a;
            if (r0.n == false) goto L34;
            View r1 = r0.m;
            if (r1 == null) goto L8;
            r1.setTag(Boolean.FALSE);
            r1.setBackgroundResource(2131249987);
            ((TextView) r1).setTextColor(s1.h(2131108001));
        L8:
            if (Intrinsics.areEqual(this.a.m, r12) == false) goto L26;
            PkFeedbackView r13 = this.a;
            r13.f = null;
            r13.g = 0;
            r13.c.clear();
            EditText r14 = (EditText) this.a.a(2131371783);
            if (r14 == null) goto L12;
            r14.setText(null);
        L12:
            EditText r15 = (EditText) this.a.a(2131384372);
            if (r15 == null) goto L15;
            r15.setText(null);
        L15:
            EditText r16 = (EditText) this.a.a(2131371783);
            if (r16 == null) goto L18;
            r16.setVisibility(8);
        L18:
            TextView r17 = (TextView) this.a.a(2131391293);
            if (r17 == null) goto L21;
            r17.setVisibility(8);
        L21:
            EditText r18 = (EditText) this.a.a(2131384372);
            if (r18 == null) goto L24;
            r18.setVisibility(8);
        L24:
            PkFeedbackView r19 = this.a;
            r19.m = null;
            r19.o = false;
            PkFeedbackView.c(r19, true);
            return;
        L26:
            this.a.c.clear();
            EditText r2 = (EditText) this.a.a(2131371783);
            if (r2 == null) goto L29;
            r2.setText(null);
        L29:
            EditText r3 = (EditText) this.a.a(2131384372);
            if (r3 == null) goto L32;
            r3.setText(null);
        L32:
            this.a.m = r12;
        L34:
            if (r12.getTag() == null) goto L49;
            Object r4 = r12.getTag();
            Boolean r5 = Boolean.FALSE;
            if (Intrinsics.areEqual(r4, r5) == true) goto L49;
            r12.setBackgroundResource(2131249987);
            TextView r110 = (TextView) r12;
            r110.setTextColor(s1.h(2131108001));
            r110.setTag(r5);
            CharSequence r111 = r110.getText();
            if (r111 == null) goto L48;
            String r112 = r111.toString();
            if (r112 == null) goto L48;
            PkFeedbackView r6 = this.a;
            if (r6.n == false) goto L46;
            r6.f = null;
            r6.g = 0;
            goto L48
        L46:
            if (r6.c.contains(r112) == false) goto L48;
            this.a.c.remove(r112);
        L48:
            PkFeedbackView.c(this.a, false);
            return;
        L49:
            r12.setBackgroundResource(2131249986);
            TextView r113 = (TextView) r12;
            r113.setTextColor(s1.h(2131108000));
            r113.setTag(Boolean.TRUE);
            CharSequence r114 = r113.getText();
            if (r114 == null) goto L83;
            String r115 = r114.toString();
            if (r115 == null) goto L83;
            PkFeedbackView r7 = this.a;
            if (r7.n == false) goto L81;
            r7.f = r115;
            ArrayList<o4> r116 = r7.h;
            if (r116 == null) goto L83;
            Iterator<T> r117 = r116.iterator();
        L59:
            if (r117.hasNext() == false) goto L83;
            o4 r8 = (o4) r117.next();
            if (Intrinsics.areEqual(r8.getIssueContent(), this.a.f) == false) goto L59;
            PkFeedbackView r9 = this.a;
            r9.g = (int) r8.getReportSerialId();
            if (Lists.isEmpty(r8.getSubCategories()) == false) goto L59;
            if (r8.getSubCategoryInputType() == SubCategoryInputType.InputText.ordinal()) goto L66;
            TextView r10 = (TextView) this.a.a(2131391293);
            if (r10 == null) goto L76;
            r10.setVisibility(8);
        L76:
            EditText r20 = (EditText) this.a.a(2131384372);
            if (r20 == null) goto L79;
            r20.setVisibility(8);
        L79:
            this.a.o = false;
            goto L59
        L66:
            TextView r22 = (TextView) this.a.a(2131391293);
            if (r22 == null) goto L69;
            r22.setVisibility(0);
        L69:
            EditText r23 = (EditText) this.a.a(2131384372);
            if (r23 == null) goto L72;
            r23.setVisibility(0);
        L72:
            this.a.o = true;
            goto L59
        L81:
            if (TextUtils.isEmpty(r115) == true) goto L83;
            this.a.c.add(r115);
        L83:
            PkFeedbackView.c(this.a, true);
        }
    }

    public final boolean f() {
        if (this.o == false) goto L8;
        boolean r0 = TextUtils.isEmpty(((EditText) a(2131371783)).getText());
    L6:
        return !r0;
    L8:
        if (((TextView) a(2131391531)).getVisibility() == 0) goto L10;
        return true;
    L10:
        if (this.n == false) goto L12;
        r0 = TextUtils.isEmpty(this.f);
        goto L6
    L12:
        r0 = this.c.isEmpty();
        goto L6
    }

    public final String getPkSelectTag() {
        Iterator<String> r0 = this.d.iterator();
        String r1 = "";
    L4:
        if (r0.hasNext() == false) goto L7;
        r1 = r1 + r0.next() + ',';
        goto L4
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return r1;
    L12:
        return r1.subSequence(0, r1.length() - 2).toString();
    L9:
        r2 = false;
        goto L10
    }

    public final String getSelectSubTag() {
        Iterator<String> r0 = this.c.iterator();
        String r1 = "";
    L3:
        boolean r3 = true;
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next();
        if (r2.length() > 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r1 = r1 + r2 + ',';
        goto L3
    L12:
        if (StringsKt.endsWith$default(r1, ",", false, 2, null) == true) goto L14;
        return r1;
    L14:
        return r1.substring(0, r1.length() - 1);
    }

    public final Integer getSelectTagType() {
        return Integer.valueOf(this.e);
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(2131567802, this, true);
        TextView r0 = (TextView) a(2131391237);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        WrapLineFlowLayout r1 = a(2131388163);
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        TextView r2 = (TextView) a(2131391531);
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        TextView r3 = (TextView) a(2131391293);
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        WrapLineFlowLayout r4 = a(2131387515);
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        EditText r5 = (EditText) a(2131371783);
        if (r5 == null) goto L20;
        r5.setVisibility(8);
    L20:
        EditText r6 = (EditText) a(2131371783);
        if (r6 == null) goto L23;
        r6.addTextChangedListener(new c(this));
    L23:
        EditText r7 = (EditText) a(2131384372);
        if (r7 == null) goto L26;
        r7.setVisibility(8);
    L26:
        EditText r8 = (EditText) a(2131384372);
        if (r8 == null) goto L30;
        r8.addTextChangedListener(new d(this));
    L30:
        if (this.p == false) goto L38;
        LinkCrossRoomDataHolder r9 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r9 == null) goto L38;
        if (r9.i() != 1) goto L38;
        if (this.q == false) goto L38;
        boolean r10 = true;
    L40:
        if (r10 == false) goto L42;
        ((TextView) a(2131391606)).setText(s1.C(2131921422, new Object[]{this.s}));
        return;
    L42:
        ((TextView) a(2131391606)).setText(s1.C(2131921429, new Object[]{this.s}));
        return;
    L38:
        r10 = false;
        goto L40
    }

    public final ArrayList<String> getSelectRandomTags() {
        return this.d;
    }

    public final String getSelectReportOther() {
        return this.j;
    }

    public final int getSelectReportSerialId() {
        return this.g;
    }

    public final String getSelectReportTag() {
        return this.f;
    }

    public final String getSelectTag() {
        return this.b;
    }

    public PkFeedbackView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        if (b51.b.c0.k() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        String r4 = "连线";
    L11:
        this.s = r4;
        this.t = new b(this);
        this.u = new e(this);
        e();
        return;
    L10:
        r4 = "PK";
        goto L11
    L5:
        if (y.c() == false) goto L7;
        r3 = true;
        goto L8
    }

    private final void setEditText(CharSequence r2) {
        a r0 = this.r;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    private final void setTagSelected(boolean r2) {
        a r0 = this.r;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
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

    public final TextView d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        TextView r0 = new TextView(getContext());
        r0.setBackgroundResource(2131249987);
        r0.setText(r4);
        r0.setTextColor(s1.h(2131108001));
        r0.setTextSize(1, 12.0f);
        int r5 = (int) UIUtils.dip2Px(getContext(), 18.0f);
        int r1 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        r0.setPadding(r5, r1, r5, r1);
        return r0;
    }

    public final void setListener(a r1) {
        this.r = r1;
    }

    public final void setSelectRandomTags(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public PkFeedbackView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        if (b51.b.c0.k() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        String r5 = "连线";
    L11:
        this.s = r5;
        this.t = new b(this);
        this.u = new e(this);
        e();
        return;
    L10:
        r5 = "PK";
        goto L11
    L5:
        if (y.c() == false) goto L7;
        r4 = true;
        goto L8
    }

    public static final /* synthetic */ void b(PkFeedbackView r0, CharSequence r1) {
        r0.setEditText(r1);
    }

    public static final /* synthetic */ void c(PkFeedbackView r0, boolean r1) {
        r0.setTagSelected(r1);
    }

    public PkFeedbackView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        if (b51.b.c0.k() == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        String r6 = "连线";
    L11:
        this.s = r6;
        this.t = new b(this);
        this.u = new e(this);
        e();
        return;
    L10:
        r6 = "PK";
        goto L11
    L5:
        if (y.c() == false) goto L7;
        r5 = true;
        goto L8
    }

    public final void g(w7 r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "issues");
        this.k = r3;
        this.p = r4;
        this.q = r5;
        TextView r6 = (TextView) a(2131391606);
        if (r6 == null) goto L5;
        r6.setVisibility(8);
    L5:
        WrapLineFlowLayout r7 = a(2131388158);
        if (r7 == null) goto L8;
        r7.setVisibility(0);
    L8:
        this.i.clear();
        List r8 = r3.getIssuesList();
        if (r8 == null) goto L16;
        this.i.addAll(r8);
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        TextView r10 = d(((o4) r9.next()).getIssueContent());
        r10.setOnClickListener(this.t);
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-2, -2);
        WrapLineFlowLayout r1 = a(2131388158);
        if (r1 == null) goto L12;
        r1.addView(r10, r0);
        goto L12
    L22:
        return;
    }
}
