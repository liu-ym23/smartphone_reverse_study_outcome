package com.obric.assistant.settings;

import android.app.Activity;
import android.os.SystemClock;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/GroupUiModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "isObricOS", "", "lastClickTime", "", "", "", "lastDisabledToastTime", "setData", "", "newItems", "", "getItemViewType", "", "position", "isFirstRV", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "GroupViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingAdapter extends ListAdapter<j, RecyclerView.ViewHolder> {
    public static final ObricSettingAdapter$Companion$diffCallback$1 f = null;
    public final Activity a;
    public final boolean b;
    public final Map<String, Long> c;
    public final Map<String, Long> d;
    public boolean e;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\"\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J2\u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J(\u0010'\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002J \u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002J\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingAdapter$GroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "itemGroup", "Landroid/widget/LinearLayout;", "getItem", "Lkotlin/Function1;", "", "Lcom/obric/assistant/settings/GroupUiModel;", "<init>", "(Lcom/obric/assistant/settings/ObricSettingAdapter;Landroid/app/Activity;Landroid/widget/LinearLayout;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "getItemGroup", "()Landroid/widget/LinearLayout;", "getGetItem", "()Lkotlin/jvm/functions/Function1;", "bind", "", "group", "createSwitchView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "model", "Lcom/obric/assistant/settings/SwitchUiModel;", "index", "applySwitchAlpha", "itemView", "Lcom/obric/oui/lisitem/OCardListItem;", "enabled", "", "bindSubtitle", "subtitle", "", "bindSwitchInteraction", "endSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "bindDisabledSwitch", "showDisabledToast", "Lkotlin/Function0;", "showDisabledToastIfNeeded", "id", "", "disabledToastText", "createActionView", "Lcom/obric/assistant/settings/ActionUiModel;", "applyActionAlpha", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GroupViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int e = 0;
        public final Activity a;
        public final LinearLayout b;
        public final Function1<Integer, j> c;
        public final /* synthetic */ ObricSettingAdapter d;

        public final Activity getActivity() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void U3(j r18) {
            Intrinsics.checkNotNullParameter(r18, "group");
            FLogger.a.d("ObricSettingAdapter", "Binding group " + r18.a + " with " + r18.b.size() + " items");
            this.b.removeAllViews();
            List<q0> r2 = r18.b;
            ObricSettingAdapter r3 = this.d;
            Iterator<T> r4 = r2.iterator();
            int r6 = 0;
        L4:
            if (r4.hasNext() == false) goto L274;
            Object r7 = r4.next();
            int r8 = r6 + 1;
            if (r6 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            q0 r9 = (q0) r7;
            if ((r9 instanceof g1) == false) goto L139;
            final LinearLayout r10 = this.b;
            final g1 r11 = (g1) r9;
            OCardListItem r12 = LayoutInflater.from(r10.getContext()).inflate(2131561647, r10, false);
            if ((r12 instanceof OCardListItem) == false) goto L13;
            OCardListItem r13 = r12;
        L14:
            if (r13 == null) goto L257;
            r13.setTag(r11.a);
            r13.setCardType(0);
            r13.p(false);
            if (r11.g == true) goto L37;
            String r15 = r11.i;
            if (r15 != null) goto L20;
        L23:
            boolean r16 = true;
        L24:
            if (r16 == false) goto L37;
            if (r11.f == true) goto L37;
            String r17 = r11.h;
            if (r17 != null) goto L30;
        L33:
            boolean r19 = true;
        L34:
            if (r19 == false) goto L37;
            r13.setTitle(r11.b);
            r13.s(true);
        L86:
            CharSequence r14 = r11.c;
            if (r14 == null) goto L89;
            String r110 = r14.toString();
        L90:
            r13.setSubTitle(r110);
            if (r14 != null) goto L93;
        L96:
            boolean r111 = true;
        L97:
            r13.q(!r111);
            OTextView r112 = r13.getSubTitleView();
            r112.setText(r14);
            r112.setMaxLines(5);
            if ((r14 instanceof Spanned) == false) goto L100;
            MovementMethod r113 = LinkMovementMethod.getInstance();
        L101:
            r112.setMovementMethod(r113);
            r112.setHighlightColor(0);
            if (r11.j == false) goto L104;
            boolean r114 = true;
            r13.setDefaultCustomEndView(1);
        L105:
            r13.m(r114);
            r13.r(false);
            FLogger.a.d("ObricSettingAdapter", "createSwitchView " + r11.b + ",isChecked" + r11.d + ",enabled" + r11.j);
            OSwitch r115 = r13.getEndSwitch();
            final String r116 = r11.k;
            if (r116 != null) goto L108;
        L116:
            final z r117 = 0;
        L118:
            if (r11.j == true) goto L131;
            View r20 = r13.getCustomEndView();
            if ((r20 instanceof ViewGroup) == false) goto L122;
            ViewGroup r21 = (ViewGroup) r20;
        L123:
            if (r21 == null) goto L130;
            OSwitch r118 = r21.findViewById(2131369124);
            if (r118 == null) goto L127;
            r118.setOnCheckedChangeListener(null);
            r118.setEnabled(false);
            r118.setChecked(r11.d);
        L127:
            View r22 = r21.findViewById(2131369125);
            if (r22 == null) goto L130;
            r22.setOnClickListener(new a0(this, r11, r117));
        L130:
            T3(r13, false);
            goto L257
        L122:
            r21 = null;
            goto L123
        L131:
            if (r115 == null) goto L133;
            r115.setOnCheckedChangeListener(null);
        L133:
            if (r115 == null) goto L135;
            r115.setChecked(r11.d);
        L135:
            T3(r13, true);
            b0 r23 = new b0(this.d, r11, this, r6);
            if (r115 == null) goto L257;
            r115.setOnCheckedChangeListener(r23);
            goto L257
        L108:
            if (r116.length() <= 0) goto L110;
            boolean r119 = true;
        L111:
            if (r119 == true) goto L114;
            r116 = null;
        L114:
            if (r116 == null) goto L116;
            r117 = new z(this, r10, r116);
            goto L118
        L110:
            r119 = false;
            goto L111
        L104:
            r114 = true;
            r13.setCustomEndView(2131561650);
            goto L105
        L100:
            r113 = null;
            goto L101
        L93:
            if (r14.length() == 0) goto L96;
            r111 = false;
            goto L97
        L89:
            r110 = null;
            goto L90
        L30:
            if (r17.length() == 0) goto L33;
            r19 = false;
            goto L34
        L20:
            if (r15.length() == 0) goto L23;
            r16 = false;
        L37:
            View r120 = r13.c();
            if ((r120 instanceof ViewGroup) == false) goto L40;
            ViewGroup r121 = (ViewGroup) r120;
        L41:
            if (r121 != null) goto L46;
            r13.i(2131561649, false);
            View r122 = r13.c();
            if ((r122 instanceof ViewGroup) == false) goto L45;
            r121 = (ViewGroup) r122;
            goto L46
        L45:
            r121 = null;
        L46:
            if (r121 == null) goto L85;
            r121.findViewById(2131368477).setText(r11.b);
            OTextTag r123 = r121.findViewById(2131368475);
            if (r123 == null) goto L59;
            String r124 = r11.h;
            if (r124 != null) goto L52;
        L55:
            boolean r125 = true;
        L56:
            if (r125 == true) goto L58;
            r123.setVisibility(0);
            r123.setText(r11.h);
            goto L59
        L58:
            r123.setVisibility(8);
            goto L59
        L52:
            if (r124.length() == 0) goto L55;
            r125 = false;
        L59:
            final ImageView r126 = (ImageView) r121.findViewById(2131368478);
            if (r126 == null) goto L71;
            String r127 = r11.i;
            if (r127 != null) goto L64;
        L67:
            boolean r128 = true;
        L68:
            if (r128 == true) goto L70;
            r126.setVisibility(0);
            com.larus.utils.e1.d(r126, new y(this, r11, r126));
            goto L71
        L70:
            r126.setVisibility(8);
            goto L71
        L64:
            if (r127.length() == 0) goto L67;
            r128 = false;
        L71:
            ImageView r129 = (ImageView) r121.findViewById(2131368471);
            if (r129 != null) goto L74;
        L78:
            OBadgeView r130 = r121.findViewById(2131368476);
            if (r130 == null) goto L85;
            if (r11.f == false) goto L83;
            int r131 = 0;
        L84:
            r130.setVisibility(r131);
            goto L85
        L83:
            r131 = 8;
            goto L84
        L74:
            if (r11.g == false) goto L76;
            int r132 = 0;
        L77:
            r129.setVisibility(r132);
            goto L78
        L76:
            r132 = 8;
        L85:
            r13.s(false);
            goto L86
        L40:
            r121 = null;
        L257:
            if (r13 == null) goto L271;
            if (r18.b.size() != 1) goto L261;
            int r133 = 0;
        L267:
            OCardListItem.h(r13, r133);
            if (r3.b == true) goto L270;
            rda.a.a(r13, r133);
        L270:
            this.b.addView(r13);
            goto L271
        L261:
            if (r6 != 0) goto L264;
            r133 = 1;
            goto L267
        L264:
            if (r6 != (r18.b.size() - 1)) goto L266;
            r133 = 3;
            goto L267
        L266:
            r133 = 2;
        L271:
            r6 = r8;
            goto L4
        L13:
            r13 = null;
            goto L14
        L139:
            if ((r9 instanceof com.obric.assistant.settings.a) == false) goto L273;
            final LinearLayout r134 = this.b;
            final com.obric.assistant.settings.a r24 = (com.obric.assistant.settings.a) r9;
            OCardListItem r135 = LayoutInflater.from(r134.getContext()).inflate(2131561647, r134, false);
            if ((r135 instanceof OCardListItem) == false) goto L143;
            OCardListItem r136 = r135;
        L144:
            if (r136 == null) goto L256;
            r136.setTag(r24.a);
            r136.setCardType(0);
            r136.p(false);
            r136.setEnabled(true);
            if (r24.g == false) goto L171;
            View r137 = r136.c();
            if ((r137 instanceof ViewGroup) == false) goto L150;
            ViewGroup r25 = (ViewGroup) r137;
        L151:
            if (r25 != null) goto L156;
            r136.i(2131561649, false);
            View r26 = r136.c();
            if ((r26 instanceof ViewGroup) == false) goto L155;
            r25 = (ViewGroup) r26;
            goto L156
        L155:
            r25 = null;
        L156:
            if (r25 == null) goto L170;
            r25.findViewById(2131368477).setText(r24.b);
            ImageView r138 = (ImageView) r25.findViewById(2131368478);
            if (r138 == null) goto L160;
            r138.setVisibility(8);
        L160:
            ImageView r139 = (ImageView) r25.findViewById(2131368471);
            if (r139 != null) goto L163;
        L167:
            OBadgeView r27 = r25.findViewById(2131368476);
            if (r27 == null) goto L170;
            r27.setVisibility(8);
            goto L170
        L163:
            if (r24.g == false) goto L165;
            int r140 = 0;
        L166:
            r139.setVisibility(r140);
            goto L167
        L165:
            r140 = 8;
        L170:
            r136.s(false);
            boolean r28 = true;
        L172:
            String r141 = r24.f;
            if (r141 != null) goto L175;
        L180:
            boolean r29 = false;
        L182:
            if (r29 == true) goto L184;
            boolean r30 = true;
            r136.m(false);
        L196:
            r136.setSubTitle(r24.c);
            r136.setDefaultTailIcon(0);
            r136.getSubTitleView().setMaxLines(5);
            r136.r(r30);
            String r142 = r24.c;
            if (r142 != null) goto L199;
        L204:
            boolean r31 = false;
        L205:
            r136.q(r31);
            if (r24.h == false) goto L208;
            float r32 = 1.0f;
        L209:
            r136.getTitleView().setAlpha(r32);
            r136.getSubTitleView().setAlpha(r32);
            View r143 = r136.c();
            if ((r143 instanceof ViewGroup) == false) goto L212;
            ViewGroup r144 = (ViewGroup) r143;
        L213:
            if (r144 == null) goto L229;
            OTextView r145 = r144.findViewById(2131368477);
            if (r145 == null) goto L217;
            r145.setAlpha(r32);
        L217:
            OTextTag r146 = r144.findViewById(2131368475);
            if (r146 == null) goto L220;
            r146.setAlpha(r32);
        L220:
            ImageView r147 = (ImageView) r144.findViewById(2131368478);
            if (r147 == null) goto L223;
            r147.setAlpha(r32);
        L223:
            ImageView r148 = (ImageView) r144.findViewById(2131368471);
            if (r148 == null) goto L226;
            r148.setAlpha(r32);
        L226:
            OBadgeView r149 = r144.findViewById(2131368476);
            if (r149 == null) goto L229;
            r149.setAlpha(r32);
        L229:
            ImageView r150 = (ImageView) r136.findViewById(2131388166);
            if (r150 == null) goto L232;
            r150.setAlpha(r32);
        L232:
            View r151 = r136.getCustomEndView();
            if ((r151 instanceof ViewGroup) == false) goto L235;
            ViewGroup r152 = (ViewGroup) r151;
        L236:
            if (r152 == null) goto L243;
            OTextView r153 = r152.findViewById(2131368382);
            if (r153 == null) goto L240;
            r153.setAlpha(r32);
        L240:
            OBadgeView r154 = r152.findViewById(2131368385);
            if (r154 == null) goto L243;
            r154.setAlpha(r32);
        L243:
            final String r155 = r24.i;
            if (r155 != null) goto L246;
        L254:
            final z r33 = 0;
        L255:
            r136.setOnContentClickListener(new x(r24, this, r33));
            goto L256
        L246:
            if (r155.length() <= 0) goto L248;
            boolean r34 = true;
        L249:
            if (r34 == true) goto L252;
            r155 = null;
        L252:
            if (r155 == null) goto L254;
            r33 = new z(this, r134, r155);
            goto L255
        L248:
            r34 = false;
            goto L249
        L235:
            r152 = null;
            goto L236
        L212:
            r144 = null;
            goto L213
        L208:
            r32 = 0.3f;
            goto L209
        L199:
            if (r142.length() <= 0) goto L201;
            boolean r156 = true;
        L202:
            if (r156 != r30) goto L204;
            r31 = true;
            goto L205
        L201:
            r156 = false;
            goto L202
        L184:
            if (r24.e == false) goto L194;
            r136.setCustomEndView(2131561648);
            View r35 = r136.getCustomEndView();
            if ((r35 instanceof ViewGroup) == false) goto L188;
            ViewGroup r36 = (ViewGroup) r35;
        L189:
            if (r36 == null) goto L193;
            r36.findViewById(2131368382).setText(r24.f);
            OBadgeView r37 = r36.findViewById(2131368385);
            if (r37 == null) goto L193;
            r37.setVisibility(0);
        L193:
            r30 = true;
            r136.m(true);
            goto L196
        L188:
            r36 = null;
            goto L189
        L194:
            r30 = true;
            r136.setDefaultCustomEndView(3);
            r136.k(r24.f, -1);
            r136.m(true);
            goto L196
        L175:
            if (r141.length() <= 0) goto L177;
            boolean r157 = true;
        L178:
            if (r157 != r28) goto L180;
            r29 = true;
            goto L182
        L177:
            r157 = false;
            goto L178
        L150:
            r25 = null;
            goto L151
        L171:
            r136.setTitle(r24.b);
            r28 = true;
            r136.s(true);
        L256:
            r13 = r136;
            goto L257
        L143:
            r136 = null;
            goto L144
        L273:
            throw new NoWhenBranchMatchedException();
        }

        public static void T3(OCardListItem r1, boolean r2) {
            if (r2 == false) goto L4;
            float r3 = 1.0f;
        L5:
            r1.getTitleView().setAlpha(r3);
            r1.getSubTitleView().setAlpha(r3);
            View r4 = r1.c();
            if ((r4 instanceof ViewGroup) == false) goto L8;
            ViewGroup r5 = (ViewGroup) r4;
        L9:
            if (r5 == null) goto L26;
            OTextView r0 = r5.findViewById(2131368477);
            if (r0 == null) goto L13;
            r0.setAlpha(r3);
        L13:
            OTextTag r6 = r5.findViewById(2131368475);
            if (r6 == null) goto L16;
            r6.setAlpha(r3);
        L16:
            ImageView r7 = (ImageView) r5.findViewById(2131368478);
            if (r7 == null) goto L19;
            r7.setAlpha(r3);
        L19:
            ImageView r8 = (ImageView) r5.findViewById(2131368471);
            if (r8 == null) goto L22;
            r8.setAlpha(r3);
        L22:
            OBadgeView r9 = r5.findViewById(2131368476);
            if (r9 == null) goto L27;
            r9.setAlpha(r3);
            return;
        L27:
            return;
        L26:
            return;
        L8:
            r5 = null;
            goto L9
        L4:
            r3 = 0.3f;
            goto L5
        }

        public final void V3(String r8, Function0<Unit> r9) {
            long r0 = SystemClock.elapsedRealtime();
            Long r2 = (Long) ((LinkedHashMap) this.d.d).get(r8);
            if (r2 == null) goto L5;
            long r3 = r2.longValue();
        L7:
            if ((r0 - r3) < 3000) goto L12;
            Long r1 = Long.valueOf(r0);
            this.d.d.put(r8, r1);
            if (r9 == null) goto L13;
            r9.invoke();
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r3 = 0;
            goto L7
        }

        public GroupViewHolder(ObricSettingAdapter r2, Activity r3, LinearLayout r4, w r5) {
            Intrinsics.checkNotNullParameter(r4, "itemGroup");
            Intrinsics.checkNotNullParameter(r5, "getItem");
            this.d = r2;
            super(r4);
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class a {
    }

    public final int getItemViewType(int r1) {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.ObricSettingAdapter$Companion$diffCallback$1] */
    static {
        f = new ObricSettingAdapter$Companion$diffCallback$1();
    }

    public final Activity getActivity() {
        return this.a;
    }

    public ObricSettingAdapter(FragmentActivity r2) {
        super(f);
        this.a = r2;
        this.b = t9a.b.a().b();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        j r0 = (j) getItem(r8);
        FLogger.a.d("ObricSettingAdapter", "onBindViewHolder position=" + r8 + ", group=" + r0.a);
        if ((r7 instanceof GroupViewHolder) == false) goto L14;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        ((GroupViewHolder) r7).U3(r0);     // Catch: Throwable -> L6
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L9:
        if (Result.exceptionOrNull-impl(r9) == null) goto L15;
        FLogger.a.d("ObricSettingAdapter", "onBindViewHolder position=" + r8 + ", group=" + r0.a);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.obric.assistant.settings.w] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        FLogger.a.d("ObricSettingAdapter", "onCreateViewHolder viewType=" + r5);
        LinearLayout r6 = new LinearLayout(r4.getContext());
        if (this.b == true) goto L5;
        int r7 = 2;
    L6:
        r6.setShowDividers(r7);
        RecyclerView.LayoutParams r8 = new RecyclerView.LayoutParams(-1, -2);
        if (this.e == true) goto L9;
    L11:
        int r1 = i5.q();
    L12:
        ((ViewGroup.MarginLayoutParams) r8).topMargin = r1;
        this.e = false;
        r6.setLayoutParams(r8);
        r6.setOrientation(1);
        return new GroupViewHolder(this, this.a, r6, new w(this));
    L9:
        if (this.b == true) goto L11;
        r1 = i5.A();
        goto L12
    L5:
        r7 = 0;
        goto L6
    }
}
