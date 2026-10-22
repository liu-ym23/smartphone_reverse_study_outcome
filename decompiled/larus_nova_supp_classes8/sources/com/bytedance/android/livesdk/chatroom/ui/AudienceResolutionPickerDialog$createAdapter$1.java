package com.bytedance.android.livesdk.chatroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.ke1;
import com.bytedance.android.livesdk.config.le1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/chatroom/ui/AudienceResolutionPickerDialog$createAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/ui/AudienceResolutionPickerDialog$a;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceResolutionPickerDialog$createAdapter$1 extends RecyclerView.Adapter<AudienceResolutionPickerDialog.a> {
    public final /* synthetic */ AudienceResolutionPickerDialog a;

    public final int getItemCount() {
        return this.a.Q.size();
    }

    public AudienceResolutionPickerDialog$createAdapter$1(AudienceResolutionPickerDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.chatroom.ui.ResolutionItemView, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        AudienceResolutionPickerDialog.a r0 = (AudienceResolutionPickerDialog.a) r17;
        Intrinsics.checkNotNullParameter(r0, "holder");
        l5 r2 = (l5) ListProtector.get(this.a.Q, r18);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "audienceResolutionItemInfo");
        ?? r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "resolutionInfo");
        r1.c = r1.findViewById(2131375835);
        r1.d = (TextView) r1.findViewById(2131383526);
        r1.e = (TextView) r1.findViewById(2131381784);
        r1.f = r1.findViewById(2131388416);
        r1.g = (TextView) r1.findViewById(2131364448);
        if (r2.k.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        String r4 = r2.k;
    L14:
        if (r4.length() != 0) goto L16;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L22;
        TextView r8 = r1.g;
        if (r8 == null) goto L28;
        r8.setVisibility(8);
    L28:
        c8 r9 = r2.i;
        if (r9.a == false) goto L32;
        Integer r10 = 2131250085;
    L41:
        if (r10 == null) goto L48;
        View r11 = r1.f;
        if (r11 == null) goto L45;
        r11.setVisibility(0);
    L45:
        View r12 = r1.f;
        if (r12 == null) goto L52;
        r12.setBackgroundResource(r10.intValue());
    L52:
        if (Intrinsics.areEqual(r2.b, "fhd") == false) goto L54;
    L81:
        TextView r13 = r1.d;
        if (r13 == null) goto L84;
        r13.setText("音画增强");
    L84:
        TextView r14 = r1.e;
        if (r14 == null) goto L87;
        r14.setText("");
    L87:
        TextView r15 = r1.d;
        if (r15 == null) goto L90;
        r15.setVisibility(0);
    L90:
        TextView r16 = r1.e;
        if (r16 == null) goto L94;
        r16.setVisibility(8);
    L94:
        if (r1.h.verticalDialogUseNewStyle() == false) goto L112;
        if (r4.length() != 0) goto L98;
        boolean r5 = true;
    L99:
        if (r5 == false) goto L112;
        ConstraintLayout r6 = r1.c;
        if (r6 == null) goto L105;
        ViewGroup.LayoutParams r19 = r6.getLayoutParams();
        if (r19 == null) goto L105;
        r19.height = UtilityKotlinExtentionsKt.i(48);
    L105:
        TextView r20 = r1.d;
        if (r20 == null) goto L108;
        UIUtils.updateLayoutMargin(r20, -3, UtilityKotlinExtentionsKt.i(14), -3, UtilityKotlinExtentionsKt.i(13));
    L108:
        TextView r21 = r1.e;
        if (r21 == null) goto L112;
        UIUtils.updateLayoutMargin(r21, -3, UtilityKotlinExtentionsKt.i(14), -3, UtilityKotlinExtentionsKt.i(13));
        goto L112
    L98:
        r5 = false;
    L112:
        if (r2.i.a == false) goto L114;
        int r22 = com.bytedance.android.live.core.utils.s1.h(2131107042);
    L115:
        String r23 = r2.e;
        int r110 = r23.hashCode();
        if (r110 == (-1577166796)) goto L183;
        if (r110 == 1191572123) goto L143;
        if (r110 != 1671308008) goto L219;
        if (r23.equals("disable") == false) goto L219;
        TextView r24 = r1.d;
        if (r24 == null) goto L127;
        r24.setTextColor(-1);
    L127:
        TextView r25 = r1.e;
        if (r25 == null) goto L130;
        r25.setTextColor(-1);
    L130:
        TextView r26 = r1.g;
        if (r26 == null) goto L133;
        r26.setTextColor(-1);
    L133:
        TextView r27 = r1.d;
        if (r27 == null) goto L136;
        r27.setAlpha(0.3f);
    L136:
        TextView r28 = r1.e;
        if (r28 == null) goto L139;
        r28.setAlpha(0.3f);
    L139:
        TextView r29 = r1.g;
        if (r29 == null) goto L219;
        r29.setAlpha(0.3f);
    L219:
        if (((ke1) j40.l.a.getValue()).a() == true) goto L224;
        if (((le1) j40.u3.a.getValue()).a() == true) goto L224;
    L272:
        r1.setOnClickListener(new t8(r1, r2));
        return;
    L224:
        if (r2.c.length() != 0) goto L226;
        boolean r30 = true;
    L227:
        String r31 = "（推荐）";
        if (r30 == false) goto L239;
        StringBuilder r32 = new StringBuilder();
        r32.append(r2.b);
        if (r2.a == true) goto L233;
        r31 = "";
    L233:
        r32.append(r31);
        String r33 = r32.toString();
        TextView r34 = r1.d;
        if (r34 == null) goto L236;
        r34.setText(r33);
    L236:
        TextView r35 = r1.e;
        if (r35 == null) goto L250;
        r35.setText(r2.c);
    L250:
        if (Intrinsics.areEqual(r2.b, "fhd") == false) goto L252;
    L260:
        TextView r36 = r1.d;
        if (r36 == null) goto L263;
        r36.setText("音画增强");
    L263:
        TextView r37 = r1.e;
        if (r37 == null) goto L266;
        r37.setText("");
    L266:
        TextView r38 = r1.d;
        if (r38 == null) goto L269;
        r38.setVisibility(0);
    L269:
        TextView r39 = r1.e;
        if (r39 == null) goto L272;
        r39.setVisibility(8);
        goto L272
    L252:
        if (Intrinsics.areEqual(r2.g, "fhd") == true) goto L260;
        TextView r40 = r1.d;
        if (r40 == null) goto L257;
        r40.setVisibility(0);
    L257:
        TextView r41 = r1.e;
        if (r41 == null) goto L272;
        r41.setVisibility(0);
        goto L272
    L239:
        StringBuilder r42 = new StringBuilder();
        r42.append(r2.c);
        if (r2.a == true) goto L243;
        r31 = "";
    L243:
        r42.append(r31);
        String r43 = r42.toString();
        TextView r44 = r1.d;
        if (r44 == null) goto L246;
        r44.setText(r2.b);
    L246:
        TextView r45 = r1.e;
        if (r45 == null) goto L250;
        r45.setText(r43);
        goto L250
    L226:
        r30 = false;
        goto L227
    L143:
        if (r23.equals("selected") == false) goto L219;
        boolean r46 = r2.i.a;
        TextView r47 = r1.d;
        if (r47 == null) goto L147;
        r47.setTextColor(r22);
    L147:
        TextView r48 = r1.e;
        if (r48 == null) goto L150;
        r48.setTextColor(r22);
    L150:
        TextView r49 = r1.g;
        if (r49 == null) goto L153;
        r49.setTextColor(r22);
    L153:
        TextView r50 = r1.d;
        if (r50 == null) goto L156;
        r50.setAlpha(1.0f);
    L156:
        TextView r51 = r1.e;
        if (r51 == null) goto L159;
        r51.setAlpha(1.0f);
    L159:
        TextView r52 = r1.g;
        if (r52 == null) goto L162;
        r52.setAlpha(0.5f);
    L162:
        StringBuilder r53 = new StringBuilder("已选中 ");
        TextView r54 = r1.d;
        if (r54 == null) goto L166;
        CharSequence r55 = r54.getText();
        if (r55 == null) goto L166;
    L167:
        r53.append(r55);
        TextView r56 = r1.e;
        if (r56 == null) goto L171;
        CharSequence r57 = r56.getText();
        if (r57 == null) goto L171;
    L172:
        r53.append(r57);
        TextView r58 = r1.g;
        if (r58 == null) goto L176;
        CharSequence r59 = r58.getText();
        if (r59 == null) goto L176;
    L177:
        r53.append(r59);
        r53.append("按钮");
        r1.setContentDescription(r53.toString());
        if (r46 == false) goto L180;
        int r60 = 2131249867;
    L181:
        r1.setBackgroundResource(r60);
        goto L219
    L180:
        r60 = 2131249866;
    L176:
        r59 = "";
    L171:
        r57 = "";
    L166:
        r55 = "";
        goto L167
    L183:
        if (r23.equals("unselected") == false) goto L219;
        TextView r61 = r1.d;
        if (r61 == null) goto L187;
        r61.setTextColor(-1);
    L187:
        TextView r62 = r1.e;
        if (r62 == null) goto L190;
        r62.setTextColor(-1);
    L190:
        TextView r63 = r1.g;
        if (r63 == null) goto L193;
        r63.setTextColor(-1);
    L193:
        TextView r64 = r1.d;
        if (r64 == null) goto L196;
        r64.setAlpha(1.0f);
    L196:
        TextView r65 = r1.e;
        if (r65 == null) goto L199;
        r65.setAlpha(1.0f);
    L199:
        TextView r66 = r1.g;
        if (r66 == null) goto L202;
        r66.setAlpha(0.5f);
    L202:
        StringBuilder r67 = new StringBuilder();
        TextView r68 = r1.d;
        if (r68 == null) goto L206;
        CharSequence r69 = r68.getText();
        if (r69 == null) goto L206;
    L207:
        r67.append(r69);
        TextView r70 = r1.e;
        if (r70 == null) goto L211;
        CharSequence r71 = r70.getText();
        if (r71 == null) goto L211;
    L212:
        r67.append(r71);
        TextView r72 = r1.g;
        if (r72 == null) goto L216;
        CharSequence r73 = r72.getText();
        if (r73 == null) goto L216;
    L217:
        r67.append(r73);
        r67.append("按钮");
        r1.setContentDescription(r67.toString());
        r1.setBackgroundResource(0);
    L216:
        r73 = "";
    L211:
        r71 = "";
    L206:
        r69 = "";
        goto L207
    L114:
        r22 = com.bytedance.android.live.core.utils.s1.h(2131108569);
        goto L115
    L54:
        if (Intrinsics.areEqual(r2.g, "fhd") == true) goto L81;
        TextView r75 = r1.d;
        if (r75 == null) goto L59;
        r75.setText(r2.b);
    L59:
        TextView r76 = r1.e;
        if (r76 == null) goto L62;
        r76.setText(r2.c);
    L62:
        TextView r77 = r1.d;
        if (r77 == null) goto L65;
        r77.setVisibility(0);
    L65:
        TextView r78 = r1.e;
        if (r78 == null) goto L69;
        r78.setVisibility(0);
    L69:
        if (r1.h.verticalDialogUseNewStyle() == false) goto L94;
        String r79 = r2.c;
        if (r79 != null) goto L73;
    L76:
        boolean r80 = true;
    L77:
        if (r80 == false) goto L94;
        TextView r81 = r1.e;
        if (r81 == null) goto L94;
        r81.setVisibility(8);
        goto L94
    L73:
        if (r79.length() == 0) goto L76;
        r80 = false;
        goto L77
    L48:
        View r82 = r1.f;
        if (r82 == null) goto L52;
        r82.setVisibility(8);
        goto L52
    L32:
        if (r2.f == true) goto L34;
    L40:
        r10 = null;
        goto L41
    L34:
        if (r9.b == true) goto L40;
        if (Intrinsics.areEqual(r2.b, "uhd") == false) goto L38;
    L39:
        r10 = 2131250086;
        goto L41
    L38:
        if (Intrinsics.areEqual(r2.g, "uhd") == false) goto L40;
    L22:
        TextView r83 = r1.g;
        if (r83 == null) goto L25;
        r83.setVisibility(0);
    L25:
        TextView r84 = r1.g;
        if (r84 == null) goto L28;
        r84.setText(r4);
        goto L28
    L16:
        r7 = false;
        goto L18
    L10:
        if (r2.d <= r1.getHighFramerateThresh()) goto L12;
        r4 = "高帧率";
        goto L14
    L12:
        r4 = "";
        goto L14
    L5:
        r3 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (this.a.M.verticalDialogUseNewStyle() == false) goto L5;
        int r0 = 2131566433;
    L6:
        Object r6 = LayoutInflater.from(this.a.getContext()).inflate(r0, r4, false);
        if (r6 == null) goto L11;
        ResolutionItemView r7 = (ResolutionItemView) r6;
        Intrinsics.areEqual(((l5) ListProtector.get(this.a.Q, r5)).e, "disable");
        r7.setSelectedCallback(new AudienceResolutionPickerDialog$createAdapter$1$onCreateViewHolder$1(this));
        r7.setToastAction(this.a.N);
        return new AudienceResolutionPickerDialog.a(r7);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.ui.ResolutionItemView");
    L5:
        r0 = 2131566432;
        goto L6
    }
}
