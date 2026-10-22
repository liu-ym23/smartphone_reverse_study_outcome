package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.SoundWaveView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u3 extends i {
    public final AppCompatImageView A;
    public final TextView B;
    public final CustomMarkdownTextView C;
    public final Lazy D;
    public RecordStatus E;
    public int F;
    public int G;
    public View H;
    public LinearLayout p;
    public final TextView q;
    public final LinearLayout r;
    public final SoundWaveView s;
    public final TextView t;
    public LinearLayout u;
    public final AppCompatImageView v;
    public final TextView w;
    public LinearLayout x;
    public final TextView y;
    public final TextView z;

    public static final class a {
    }

    static {
    }

    private final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat) this.D.getValue();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public Drawable getInboxBackground() {
        float r0 = c7.c(Float.valueOf(8.0f));
        AppCompatImageView r1 = this.A;
        if (r1 == null) goto L6;
        Context r2 = r1.getContext();
        if (r2 == null) goto L6;
    L8:
        return com.larus.utils.e1.j(this, r0, v19.c.b(2130970533, r2, 2131102542));
    L6:
        r2 = getContext();
        goto L8
    }

    public final void o() {
        if (this.E == RecordStatus.UNAUTHORIZED_ERROR) goto L6;
        return;
    L6:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.RECORD_AUDIO") != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        AppCompatImageView r1 = this.v;
        if (r1 == null) goto L16;
        com.larus.utils.e1.o(r1);
    L16:
        TextView r2 = this.w;
        if (r2 == null) goto L22;
        if (r0 == false) goto L20;
        int r3 = com.larus.utils.j0.a;
        String r4 = com.larus.utils.j0.d(2131907307);
    L21:
        r2.setText(r4);
        goto L22
    L20:
        int r5 = com.larus.utils.j0.a;
        r4 = com.larus.utils.j0.d(2131907323);
    L22:
        TextView r6 = this.B;
        if (r6 == null) goto L33;
        if (r0 == false) goto L26;
        int r7 = com.larus.utils.j0.a;
        String r8 = com.larus.utils.j0.d(2131907317);
    L27:
        r6.setText(r8);
        r6.setAlpha(1.0f);
        r6.setTextColor(ve8.d.a(2131103681, r6.getContext()));
        AppCompatImageView r9 = this.A;
        if (r9 == null) goto L30;
        Context r10 = r9.getContext();
    L31:
        r6.setBackgroundResource(v19.c.b(2130970771, r10, 2131239485));
        return;
    L30:
        r10 = null;
        goto L31
    L26:
        int r11 = com.larus.utils.j0.a;
        r8 = com.larus.utils.j0.d(2131907306);
        goto L27
    L33:
        return;
    L13:
        AppCompatImageView r12 = this.v;
        if (r12 == null) goto L16;
        com.larus.utils.e1.x(r12);
        goto L16
    L8:
        r0 = false;
        goto L9
    }

    public final int getDuration() {
        return this.F;
    }

    public final CustomMarkdownTextView getMarkdownTextView() {
        return this.C;
    }

    public final LinearLayout getMarkdownWrapper() {
        return this.x;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getMaxWidth() {
        return this.G;
    }

    public final RecordStatus getRecordStatus() {
        return this.E;
    }

    public final LinearLayout getTitleWrapper() {
        return this.p;
    }

    public final View getView() {
        return this.H;
    }

    public final LinearLayout getWarningWrapper() {
        return this.u;
    }

    public u3(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        View r0 = new CustomMarkdownTextView(r7, null, 6, 0);
        this.C = r0;
        this.D = LazyKt.lazy(new t3());
        this.E = RecordStatus.Connecting;
        Lazy r2 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(0, null) == false) goto L5;
        int r3 = com.larus.bmhome.utils.z1.h(0, null, false, false, 28);
    L6:
        this.G = r3;
        ViewGroup.LayoutParams r4 = new ViewGroup.LayoutParams(getMaxWidth(), -2);
        View r8 = LayoutInflater.from(r7).inflate(2131563097, null);
        this.H = r8;
        addView(r8, r4);
        LinearLayout r9 = (LinearLayout) this.H.findViewById(2131379585);
        this.x = r9;
        if (r9 == null) goto L9;
        r0.setTextSize(0, we8.a.a(i5.t(), false));
        r9.addView(r0, 2);
    L9:
        this.u = (LinearLayout) this.H.findViewById(2131393004);
        this.v = this.H.findViewById(2131393002);
        this.w = (TextView) this.H.findViewById(2131393003);
        this.t = (TextView) this.H.findViewById(2131367794);
        this.A = this.H.findViewById(2131363393);
        this.s = this.H.findViewById(2131361913);
        this.q = (TextView) this.H.findViewById(2131388772);
        this.r = (LinearLayout) this.H.findViewById(2131383979);
        this.B = (TextView) this.H.findViewById(2131364987);
        this.p = (LinearLayout) this.H.findViewById(2131388796);
        this.y = (TextView) this.H.findViewById(2131379584);
        this.z = (TextView) this.H.findViewById(2131379582);
        return;
    L5:
        r3 = super.getMaxWidth();
        goto L6
    }

    public static String n(Long r6) {
        Calendar r0 = Calendar.getInstance();
        if (r6 == null) goto L5;
        long r1 = r6.longValue();
    L6:
        r0.setTimeInMillis(r1);
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        int r8 = com.larus.utils.j0.a;
        return String.format(com.larus.utils.j0.d(2131907322), Arrays.copyOf(new Object[]{String.valueOf(r0.get(2) + 1), Integer.valueOf(r0.get(5))}, 2));
    L5:
        r1 = System.currentTimeMillis();
        goto L6
    }

    public final void m(ic8.p0 r44) {
        Intrinsics.checkNotNullParameter(r44, "recordCardData");
        Integer r1 = r44.b();
        int r3 = 0;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        this.F = r2;
        Integer r4 = r44.d();
        int r5 = RecordStatus.AVAILABLE.getType();
        Context r6 = null;
        if (r4 != null) goto L10;
    L11:
        int r7 = RecordStatus.Connecting.getType();
        if (r4 != null) goto L15;
    L17:
        RecordStatus r8 = RecordStatus.RECORDING;
        int r11 = r8.getType();
        if (r4 != null) goto L21;
    L58:
        RecordStatus r9 = RecordStatus.RECORD_FINISHED;
        int r10 = r9.getType();
        if (r4 != null) goto L62;
    L63:
        int r12 = RecordStatus.SUMMARY_GENERATING.getType();
        if (r4 != null) goto L67;
    L68:
        int r13 = RecordStatus.RecordInterruptedFinish.getType();
        if (r4 != null) goto L72;
    L73:
        int r14 = RecordStatus.OFFLINE_ASR_ING.getType();
        if (r4 != null) goto L77;
    L79:
        RecordStatus r15 = RecordStatus.SUMMARY_READY;
        int r16 = r15.getType();
        if (r4 != null) goto L83;
    L160:
        RecordStatus r17 = RecordStatus.SUMMARY_GENERATE_ERROR;
        int r18 = r17.getType();
        if (r4 != null) goto L164;
    L165:
        int r19 = RecordStatus.OfflineASRError.getType();
        if (r4 != null) goto L169;
    L170:
        int r20 = RecordStatus.SecurityRiskControlError.getType();
        if (r4 != null) goto L174;
    L176:
        RecordStatus r21 = RecordStatus.RECORD_ERROR;
        int r22 = r21.getType();
        if (r4 != null) goto L180;
    L214:
        RecordStatus r23 = RecordStatus.UNAUTHORIZED_ERROR;
        int r24 = r23.getType();
        if (r4 != null) goto L218;
    L244:
        RecordStatus r25 = RecordStatus.EarlyEndError;
        int r26 = r25.getType();
        if (r4 != null) goto L248;
        return;
    L248:
        if (r4.intValue() != r26) goto L395;
        this.E = r25;
        LinearLayout r27 = this.p;
        if (r27 == null) goto L252;
        com.larus.utils.e1.x(r27);
        Unit r28 = Unit.INSTANCE;
    L252:
        LinearLayout r29 = this.r;
        if (r29 == null) goto L255;
        com.larus.utils.e1.o(r29);
    L255:
        SoundWaveView r30 = this.s;
        if (r30 == null) goto L258;
        com.larus.utils.e1.o(r30);
    L258:
        TextView r31 = this.t;
        if (r31 == null) goto L261;
        com.larus.utils.e1.x(r31);
    L261:
        LinearLayout r32 = this.u;
        if (r32 == null) goto L264;
        com.larus.utils.e1.o(r32);
    L264:
        LinearLayout r33 = this.x;
        if (r33 == null) goto L267;
        com.larus.utils.e1.o(r33);
    L267:
        TextView r34 = this.q;
        if (r34 == null) goto L270;
        r34.setText(n(r44.f()));
    L270:
        TextView r35 = this.t;
        if (r35 == null) goto L273;
        int r36 = com.larus.utils.j0.a;
        r35.setText(com.larus.utils.j0.d(2131907314));
    L273:
        TextView r37 = this.B;
        if (r37 == null) goto L396;
        int r38 = com.larus.utils.j0.a;
        r37.setText(com.larus.utils.j0.d(2131907317));
        r37.setAlpha(1.0f);
        r37.setTextColor(ve8.d.a(2131103681, r37.getContext()));
        AppCompatImageView r39 = this.A;
        if (r39 == null) goto L278;
        r6 = r39.getContext();
    L278:
        r37.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L396:
        return;
    L395:
        return;
    L218:
        if (r4.intValue() != r24) goto L244;
        this.E = r23;
        LinearLayout r40 = this.p;
        if (r40 == null) goto L222;
        com.larus.utils.e1.x(r40);
        Unit r41 = Unit.INSTANCE;
    L222:
        LinearLayout r42 = this.r;
        if (r42 == null) goto L225;
        com.larus.utils.e1.o(r42);
    L225:
        SoundWaveView r43 = this.s;
        if (r43 == null) goto L228;
        com.larus.utils.e1.o(r43);
    L228:
        TextView r45 = this.t;
        if (r45 == null) goto L231;
        com.larus.utils.e1.o(r45);
    L231:
        LinearLayout r46 = this.u;
        if (r46 == null) goto L234;
        com.larus.utils.e1.x(r46);
        Unit r47 = Unit.INSTANCE;
    L234:
        TextView r48 = this.w;
        if (r48 == null) goto L237;
        com.larus.utils.e1.x(r48);
    L237:
        LinearLayout r49 = this.x;
        if (r49 == null) goto L240;
        com.larus.utils.e1.o(r49);
    L240:
        TextView r50 = this.q;
        if (r50 == null) goto L243;
        r50.setText(n(r44.f()));
    L243:
        o();
        return;
    L180:
        if (r4.intValue() != r22) goto L214;
        this.E = r21;
        LinearLayout r51 = this.p;
        if (r51 == null) goto L184;
        com.larus.utils.e1.x(r51);
        Unit r52 = Unit.INSTANCE;
    L184:
        LinearLayout r53 = this.r;
        if (r53 == null) goto L187;
        com.larus.utils.e1.o(r53);
    L187:
        SoundWaveView r54 = this.s;
        if (r54 == null) goto L190;
        com.larus.utils.e1.o(r54);
    L190:
        TextView r55 = this.t;
        if (r55 == null) goto L193;
        com.larus.utils.e1.o(r55);
    L193:
        LinearLayout r56 = this.u;
        if (r56 == null) goto L196;
        com.larus.utils.e1.x(r56);
        Unit r57 = Unit.INSTANCE;
    L196:
        TextView r58 = this.w;
        if (r58 == null) goto L199;
        com.larus.utils.e1.x(r58);
    L199:
        LinearLayout r59 = this.x;
        if (r59 == null) goto L202;
        com.larus.utils.e1.o(r59);
    L202:
        TextView r60 = this.q;
        if (r60 == null) goto L205;
        r60.setText(n(r44.f()));
    L205:
        TextView r61 = this.w;
        if (r61 == null) goto L208;
        int r62 = com.larus.utils.j0.a;
        r61.setText(com.larus.utils.j0.d(2131907334));
    L208:
        TextView r63 = this.B;
        if (r63 == null) goto L392;
        int r64 = com.larus.utils.j0.a;
        r63.setText(com.larus.utils.j0.d(2131907317));
        r63.setAlpha(1.0f);
        r63.setTextColor(ve8.d.a(2131103681, r63.getContext()));
        AppCompatImageView r65 = this.A;
        if (r65 == null) goto L213;
        r6 = r65.getContext();
    L213:
        r63.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L392:
        return;
    L174:
        if (r4.intValue() != r20) goto L176;
    L279:
        RecordStatus.a r66 = RecordStatus.Companion;
        Integer r67 = r44.d();
        r66.getClass();
        RecordStatus r68 = RecordStatus.a.a(r67);
        if (r68 == null) goto L283;
        r17 = r68;
    L283:
        this.E = r17;
        LinearLayout r69 = this.p;
        if (r69 == null) goto L286;
        com.larus.utils.e1.x(r69);
        Unit r70 = Unit.INSTANCE;
    L286:
        LinearLayout r71 = this.r;
        if (r71 == null) goto L289;
        com.larus.utils.e1.o(r71);
    L289:
        SoundWaveView r72 = this.s;
        if (r72 == null) goto L292;
        com.larus.utils.e1.o(r72);
    L292:
        TextView r73 = this.t;
        if (r73 == null) goto L295;
        com.larus.utils.e1.o(r73);
    L295:
        LinearLayout r74 = this.u;
        if (r74 == null) goto L298;
        com.larus.utils.e1.x(r74);
        Unit r75 = Unit.INSTANCE;
    L298:
        TextView r76 = this.w;
        if (r76 == null) goto L301;
        com.larus.utils.e1.x(r76);
    L301:
        LinearLayout r77 = this.x;
        if (r77 == null) goto L304;
        com.larus.utils.e1.o(r77);
    L304:
        TextView r78 = this.q;
        if (r78 == null) goto L307;
        r78.setText(n(r44.f()));
    L307:
        TextView r79 = this.w;
        if (r79 != null) goto L310;
    L314:
        TextView r80 = this.B;
        if (r80 == null) goto L398;
        int r81 = com.larus.utils.j0.a;
        r80.setText(com.larus.utils.j0.d(2131907308));
        r80.setAlpha(1.0f);
        r80.setTextColor(ve8.d.a(2131103681, r80.getContext()));
        AppCompatImageView r82 = this.A;
        if (r82 == null) goto L319;
        r6 = r82.getContext();
    L319:
        r80.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L398:
        return;
    L310:
        if (this.E != RecordStatus.SecurityRiskControlError) goto L312;
        int r83 = com.larus.utils.j0.a;
        int r84 = 2131907338;
    L313:
        r79.setText(com.larus.utils.j0.d(r84));
        goto L314
    L312:
        int r85 = com.larus.utils.j0.a;
        r84 = 2131907337;
        goto L313
    L169:
        if (r4.intValue() == r19) goto L279;
    L164:
        if (r4.intValue() == r18) goto L279;
    L83:
        if (r4.intValue() != r16) goto L160;
        this.E = r15;
        LinearLayout r86 = this.p;
        if (r86 == null) goto L87;
        com.larus.utils.e1.o(r86);
    L87:
        TextView r87 = this.t;
        if (r87 == null) goto L90;
        com.larus.utils.e1.o(r87);
    L90:
        LinearLayout r88 = this.u;
        if (r88 == null) goto L93;
        com.larus.utils.e1.o(r88);
    L93:
        LinearLayout r89 = this.x;
        if (r89 == null) goto L96;
        com.larus.utils.e1.x(r89);
    L96:
        TextView r90 = this.y;
        if (r90 == null) goto L111;
        ic8.p0.a r91 = r44.e();
        if (r91 == null) goto L101;
        String r92 = r91.e();
    L103:
        if (com.larus.utils.o0.d(r92) == true) goto L110;
        ic8.p0.a r93 = r44.e();
        if (r93 == null) goto L108;
        Long r94 = r93.d();
    L109:
        r92 = n(r94);
        goto L110
    L108:
        r94 = null;
    L110:
        r90.setText(r92);
        goto L111
    L101:
        r92 = null;
    L111:
        TextView r95 = this.z;
        if (r95 == null) goto L126;
        StringCompanionObject r96 = StringCompanionObject.INSTANCE;
        Object[] r110 = new Object[2];
        SimpleDateFormat r111 = getDateFormat();
        ic8.p0.a r112 = r44.e();
        if (r112 == null) goto L118;
        Long r113 = r112.d();
        if (r113 == null) goto L118;
        long r114 = r113.longValue();
    L119:
        r110[0] = r111.format(Long.valueOf(r114));
        ic8.p0.a r115 = r44.e();
        if (r115 == null) goto L124;
        Integer r116 = r115.b();
        if (r116 == null) goto L124;
        int r117 = r116.intValue();
    L125:
        int r118 = r117 / 1000;
        r110[1] = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r118 / 3600), Integer.valueOf((r118 % 3600) / 60), Integer.valueOf(r118 % 60)}, 3));
        r95.setText(String.format("%s %s", Arrays.copyOf(r110, 2)));
    L124:
        r117 = 0;
    L118:
        r114 = System.currentTimeMillis();
    L126:
        CustomMarkdownTextView r97 = this.C;
        if (r97 == null) goto L154;
        gw8.c.a.getClass();
        gw8.c r99 = gw8.c.a.b();
        if (r99 == null) goto L152;
        ic8.p0.a r100 = r44.e();
        if (r100 == null) goto L133;
        Integer r101 = r100.c();
    L134:
        int r102 = SummaryGenerateType.EmptyAudio.getType();
        if (r101 != null) goto L138;
    L140:
        int r103 = SummaryGenerateType.NotCompleteSentence.getType();
        if (r101 != null) goto L144;
    L146:
        ic8.p0.a r104 = r44.e();
        if (r104 == null) goto L150;
        String r105 = r104.a();
        if (r105 == null) goto L150;
    L151:
        lw8.l r106 = gw8.c.b.b(r99, r97, r105, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
    L153:
        r97.C(r106, IntRange.Companion.getEMPTY(), null, null);
    L150:
        r105 = "";
        goto L151
    L144:
        if (r101.intValue() != r103) goto L146;
        int r107 = com.larus.utils.j0.a;
        r105 = com.larus.utils.j0.d(2131907352);
        goto L151
    L138:
        if (r101.intValue() != r102) goto L140;
        int r108 = com.larus.utils.j0.a;
        r105 = com.larus.utils.j0.d(2131907349);
        goto L151
    L133:
        r101 = null;
        goto L134
    L152:
        r106 = null;
    L154:
        TextView r109 = this.B;
        if (r109 == null) goto L390;
        int r119 = com.larus.utils.j0.a;
        r109.setText(com.larus.utils.j0.d(2131907308));
        r109.setAlpha(1.0f);
        r109.setTextColor(ve8.d.a(2131103681, r109.getContext()));
        AppCompatImageView r120 = this.A;
        if (r120 == null) goto L159;
        r6 = r120.getContext();
    L159:
        r109.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L390:
        return;
    L77:
        if (r4.intValue() != r14) goto L79;
    L320:
        RecordStatus.a r121 = RecordStatus.Companion;
        Integer r122 = r44.d();
        r121.getClass();
        RecordStatus r123 = RecordStatus.a.a(r122);
        if (r123 == null) goto L324;
        r9 = r123;
    L324:
        this.E = r9;
        LinearLayout r124 = this.p;
        if (r124 == null) goto L327;
        com.larus.utils.e1.x(r124);
        Unit r125 = Unit.INSTANCE;
    L327:
        LinearLayout r126 = this.r;
        if (r126 == null) goto L330;
        com.larus.utils.e1.x(r126);
    L330:
        SoundWaveView r127 = this.s;
        if (r127 == null) goto L333;
        com.larus.utils.e1.o(r127);
    L333:
        TextView r128 = this.t;
        if (r128 == null) goto L336;
        com.larus.utils.e1.x(r128);
    L336:
        LinearLayout r129 = this.u;
        if (r129 == null) goto L339;
        com.larus.utils.e1.o(r129);
    L339:
        LinearLayout r130 = this.x;
        if (r130 == null) goto L342;
        com.larus.utils.e1.o(r130);
    L342:
        TextView r131 = this.q;
        if (r131 == null) goto L345;
        r131.setText(n(r44.f()));
    L345:
        TextView r132 = this.t;
        if (r132 == null) goto L348;
        int r133 = com.larus.utils.j0.a;
        r132.setText(com.larus.utils.j0.d(2131907324));
    L348:
        Integer r134 = r44.b();
        if (r134 == null) goto L351;
        r3 = r134.intValue();
    L351:
        setDuration(r3);
        TextView r135 = this.B;
        if (r135 == null) goto L400;
        int r136 = com.larus.utils.j0.a;
        r135.setText(com.larus.utils.j0.d(2131907320));
        r135.setAlpha(0.3f);
        r135.setTextColor(ve8.d.a(2131103681, r135.getContext()));
        AppCompatImageView r137 = this.A;
        if (r137 == null) goto L356;
        r6 = r137.getContext();
    L356:
        r135.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L400:
        return;
    L72:
        if (r4.intValue() == r13) goto L320;
    L67:
        if (r4.intValue() == r12) goto L320;
    L62:
        if (r4.intValue() == r10) goto L320;
    L21:
        if (r4.intValue() != r11) goto L58;
        this.E = r8;
        LinearLayout r138 = this.p;
        if (r138 == null) goto L25;
        com.larus.utils.e1.x(r138);
        Unit r139 = Unit.INSTANCE;
    L25:
        LinearLayout r140 = this.r;
        if (r140 == null) goto L28;
        com.larus.utils.e1.x(r140);
    L28:
        SoundWaveView r141 = this.s;
        if (r141 == null) goto L31;
        com.larus.utils.e1.x(r141);
    L31:
        TextView r142 = this.t;
        if (r142 == null) goto L34;
        com.larus.utils.e1.x(r142);
    L34:
        LinearLayout r143 = this.u;
        if (r143 == null) goto L37;
        com.larus.utils.e1.o(r143);
    L37:
        LinearLayout r144 = this.x;
        if (r144 == null) goto L40;
        com.larus.utils.e1.o(r144);
    L40:
        TextView r145 = this.q;
        if (r145 == null) goto L43;
        r145.setText(n(r44.f()));
    L43:
        TextView r146 = this.t;
        if (r146 != null) goto L46;
    L52:
        TextView r147 = this.B;
        if (r147 == null) goto L388;
        int r148 = com.larus.utils.j0.a;
        r147.setText(com.larus.utils.j0.d(2131907309));
        r147.setAlpha(1.0f);
        r147.setTextColor(ve8.d.a(2131101300, r147.getContext()));
        AppCompatImageView r149 = this.A;
        if (r149 == null) goto L57;
        r6 = r149.getContext();
    L57:
        r147.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L388:
        return;
    L46:
        if (AudioServiceDelegate.a.P().isRecording() == true) goto L48;
    L50:
        int r150 = com.larus.utils.j0.a;
        String r151 = com.larus.utils.j0.d(2131907315);
    L51:
        r146.setText(r151);
        goto L52
    L48:
        if (com.larus.utils.o0.d(r44.a()) == false) goto L50;
        String r152 = r44.a();
        r151 = StringsKt.takeLast(r152, (r152.length() % 10000) + 1000);
        goto L51
    L15:
        if (r4.intValue() != r7) goto L17;
    L357:
        this.E = RecordStatus.Connecting;
        LinearLayout r153 = this.p;
        if (r153 == null) goto L360;
        com.larus.utils.e1.x(r153);
        Unit r154 = Unit.INSTANCE;
    L360:
        LinearLayout r155 = this.r;
        if (r155 == null) goto L363;
        com.larus.utils.e1.o(r155);
    L363:
        SoundWaveView r156 = this.s;
        if (r156 == null) goto L366;
        com.larus.utils.e1.o(r156);
    L366:
        TextView r157 = this.t;
        if (r157 == null) goto L369;
        com.larus.utils.e1.x(r157);
    L369:
        LinearLayout r158 = this.u;
        if (r158 == null) goto L372;
        com.larus.utils.e1.o(r158);
    L372:
        LinearLayout r159 = this.x;
        if (r159 == null) goto L375;
        com.larus.utils.e1.o(r159);
    L375:
        TextView r160 = this.q;
        if (r160 == null) goto L378;
        r160.setText(n(r44.f()));
    L378:
        TextView r161 = this.t;
        if (r161 == null) goto L381;
        int r162 = com.larus.utils.j0.a;
        r161.setText(com.larus.utils.j0.d(2131907313));
    L381:
        TextView r163 = this.B;
        if (r163 == null) goto L402;
        int r164 = com.larus.utils.j0.a;
        r163.setText(com.larus.utils.j0.d(2131907309));
        r163.setAlpha(1.0f);
        r163.setTextColor(ve8.d.a(2131101300, r163.getContext()));
        AppCompatImageView r165 = this.A;
        if (r165 == null) goto L386;
        r6 = r165.getContext();
    L386:
        r163.setBackgroundResource(v19.c.b(2130970771, r6, 2131239485));
        return;
    L402:
        return;
    L10:
        if (r4.intValue() == r5) goto L357;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        TextView r5 = this.t;
        if (r5 == null) goto L18;
        Layout r6 = r5.getLayout();
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getLineCount() <= 3) goto L19;
        TextView r0 = this.t;
        if (r0 == null) goto L13;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L13;
    L14:
        int r7 = r6.getLineStart(r6.getLineCount() - 3);
        TextView r2 = this.t;
        if (r2 == null) goto L20;
        r2.setText(r1.subSequence(r7, r1.length()));
        return;
    L20:
        return;
    L13:
        r1 = "";
        goto L14
    L19:
        return;
    }

    public final void setAudioPlayButtonClick(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        AppCompatImageView r0 = this.A;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setButtonClick(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        TextView r0 = this.B;
        if (r0 == null) goto L6;
        com.larus.utils.e1.c(r0, r2);
        return;
    }

    public final void setDuration(int r10) {
        this.F = r10;
        LinearLayout r0 = this.r;
        if (r0 == null) goto L29;
        int r1 = r0.getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L38;
        View r4 = r0.getChildAt(r3);
        TextView r6 = null;
        if (r3 == 0) goto L24;
        if (r3 == 2) goto L19;
        if (r3 != 4) goto L28;
        if ((r4 instanceof TextView) == false) goto L16;
        r6 = (TextView) r4;
    L16:
        if (r6 == null) goto L28;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10 % 60)}, 1)));
    L28:
        r3 = r3 + 1;
        goto L5
    L19:
        if ((r4 instanceof TextView) == false) goto L21;
        r6 = (TextView) r4;
    L21:
        if (r6 == null) goto L28;
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf((r10 % 3600) / 60)}, 1)));
        goto L28
    L24:
        if ((r4 instanceof TextView) == false) goto L26;
        r6 = (TextView) r4;
    L26:
        if (r6 == null) goto L28;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10 / 3600)}, 1)));
        goto L28
    L38:
        return;
    }

    public final void setMarkdownWrapper(LinearLayout r1) {
        this.x = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setMaxWidth(int r1) {
        this.G = r1;
    }

    public final void setRootClick(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        CustomMarkdownTextView r0 = this.C;
        if (r0 == null) goto L5;
        com.larus.utils.e1.c(r0, r2);
    L5:
        LinearLayout r1 = this.p;
        if (r1 == null) goto L8;
        com.larus.utils.e1.c(r1, r2);
    L8:
        LinearLayout r3 = this.u;
        if (r3 == null) goto L11;
        com.larus.utils.e1.c(r3, r2);
    L11:
        TextView r4 = this.t;
        if (r4 == null) goto L14;
        com.larus.utils.e1.c(r4, r2);
    L14:
        com.larus.utils.e1.c(this, r2);
    }

    public final void setRootLongClick(View.OnLongClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        CustomMarkdownTextView r0 = this.C;
        if (r0 == null) goto L5;
        r0.setOnLongClickListener(r2);
    L5:
        LinearLayout r1 = this.p;
        if (r1 == null) goto L8;
        r1.setOnLongClickListener(r2);
    L8:
        LinearLayout r3 = this.u;
        if (r3 == null) goto L11;
        r3.setOnLongClickListener(r2);
    L11:
        TextView r4 = this.t;
        if (r4 == null) goto L14;
        r4.setOnLongClickListener(r2);
    L14:
        TextView r5 = this.B;
        if (r5 == null) goto L17;
        r5.setOnLongClickListener(r2);
    L17:
        setOnLongClickListener(r2);
    }

    public final void setTitleWrapper(LinearLayout r1) {
        this.p = r1;
    }

    public final void setView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.H = r2;
    }

    public final void setWarningWrapper(LinearLayout r1) {
        this.u = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r4, boolean r5) {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        int r6 = com.larus.bmhome.utils.z1.h(getBoxType(), getImmerseBgColor(), r4, r5, 16);
        if (this.H.getWidth() == r6) goto L9;
        setMaxWidth(r6);
        View r7 = this.H;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L8;
        r8.width = getMaxWidth();
        r7.setLayoutParams(r8);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
