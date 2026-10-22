package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.chat.map.Data;
import com.larus.bmhome.chat.map.Extra;
import com.larus.bmhome.chat.map.PoiData;
import com.larus.bmhome.chat.map.PoiItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z1 extends xc8.h {
    public double A;
    public String B;
    public Message C;
    public BotModel D;
    public final s0 E;
    public int F;
    public final AtomicBoolean p;
    public final View q;
    public final ConstraintLayout r;
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final LinearLayout w;
    public final ConstraintLayout x;
    public com.larus.bmhome.chat.map.o y;
    public double z;

    public static final class a {
    }

    static {
    }

    public final void o() {
        View r0 = this.q;
        if (r0 == null) goto L14;
        if (Intrinsics.areEqual(r0.getParent(), this) == true) goto L14;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
    L10:
        if (r2 == null) goto L12;
        r2.removeAllViews();
    L12:
        addView(r0);
        goto L14
    L9:
        r2 = null;
    L14:
        if (this.p.get() == true) goto L20;
        ConstraintLayout r3 = this.r;
        if (r3 == null) goto L18;
        this.y = new com.larus.bmhome.chat.map.o(getContext(), r3);
    L18:
        this.p.set(true);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.F;
    }

    public z1(final Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        this.p = new AtomicBoolean(false);
        this.B = "";
        this.E = new s0(r12);
        this.F = super.getBoxType();
        TextView r2 = null;
        View r0 = LayoutInflater.from(r12).inflate(2131562961, null);
        this.q = r0;
        addView(r0);
        if (r0 == null) goto L5;
        ConstraintLayout r1 = (ConstraintLayout) r0.findViewById(2131366874);
    L6:
        this.r = r1;
        if (r0 == null) goto L9;
        ConstraintLayout r3 = r0.findViewById(2131366883);
    L9:
        if (r0 == null) goto L11;
        SimpleDraweeView r4 = (SimpleDraweeView) r0.findViewById(2131385277);
    L12:
        this.s = r4;
        if (r0 == null) goto L15;
        TextView r5 = (TextView) r0.findViewById(2131391127);
    L16:
        this.t = r5;
        if (r0 == null) goto L19;
        TextView r6 = (TextView) r0.findViewById(2131390119);
    L20:
        this.u = r6;
        if (r0 == null) goto L23;
        ConstraintLayout r7 = (ConstraintLayout) r0.findViewById(2131366893);
    L24:
        this.x = r7;
        if (r0 == null) goto L29;
        LinearLayout r8 = (LinearLayout) r0.findViewById(2131378802);
        if (r8 == null) goto L29;
        GradientDrawable r9 = new GradientDrawable();
        r9.setSize(1, (int) r12.getResources().getDimension(v19.c.b(2130972031, r12, 2131167551)));
        r8.setShowDividers(2);
        r8.setDividerDrawable(r9);
    L29:
        if (r0 == null) goto L33;
        LinearLayout r10 = (LinearLayout) r0.findViewById(2131378841);
        if (r10 == null) goto L33;
        GradientDrawable r11 = new GradientDrawable();
        r11.setSize((int) r12.getResources().getDimension(v19.c.b(2130972031, r12, 2131167551)), 1);
        r10.setDividerDrawable(r11);
        r10.setShowDividers(2);
    L34:
        this.w = r10;
        if (r0 == null) goto L37;
        r2 = (TextView) r0.findViewById(2131391346);
    L37:
        this.v = r2;
        if (r1 == null) goto L41;
        r1.setOnClickListener(new x1(this, r12));
        return;
    L41:
        return;
    L33:
        r10 = null;
        goto L34
    L23:
        r7 = null;
        goto L24
    L19:
        r6 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void n(int r9) {
        LinearLayout r0 = this.w;
        if (r0 == null) goto L6;
        ImageView r1 = new ImageView(getContext());
        r1.setLayoutParams(new LinearLayout.LayoutParams(r1.getContext().getResources().getDimensionPixelSize(v19.c.b(2130972112, r1.getContext(), 2131167586)), r1.getContext().getResources().getDimensionPixelSize(v19.c.b(2130972112, r1.getContext(), 2131167586))));
        r1.setImageResource(r9);
        r0.addView(r1);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r4) {
        super.setBoxType(r4);
        this.F = r4;
        this.E.setBoxType(r4);
        if (getImmerseBgColor() == null) goto L7;
        Integer r5 = getImmerseBgColor();
        if (r5 == null) goto L8;
        setBackground(com.larus.utils.e1.f(getWidth(), getHeight(), i5.q(), r5.intValue()));
    L8:
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L17;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        if (com.larus.platform.service.e2.a.isPad() == false) goto L13;
        int r0 = 0;
    L14:
        r7.setMarginStart(r0);
        r7.setMarginEnd(0);
        setLayoutParams(r7);
        return;
    L13:
        r0 = getResources().getDimensionPixelSize(2131167568);
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L7:
        setBackground(getInboxBackground());
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00fd -> B:57:0x0103). Please report as a decompilation issue!!! */
    public final void q(PoiData r17, Message r18, BotModel r19) {
        Intrinsics.checkNotNullParameter(r17, "poiData");
        Intrinsics.checkNotNullParameter(r18, "chatMessage");
        this.C = r18;
        this.D = r19;
        com.larus.bmhome.chat.map.o r2 = this.y;
        if (r2 == null) goto L5;
        r2.b = r18.getMessageId();
    L5:
        Data r3 = r17.getData();
        if (r3 == null) goto L14;
        List<PoiItem> r4 = r3.getPoiList();
        if (r4 == null) goto L14;
        List r5 = CollectionsKt.filterNotNull(r4);
        if (r5 == null) goto L14;
        if ((!r5.isEmpty()) != true) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L114;
        PoiItem r7 = (PoiItem) CollectionsKt.first(CollectionsKt.filterNotNull(r17.getData().getPoiList()));
        com.larus.bmhome.chat.map.o r8 = this.y;
        if (r8 == null) goto L19;
        r8.c = r7;
    L19:
        SimpleDraweeView r9 = this.s;
        if (r9 == null) goto L22;
        ImageLoaderKt.u(r9, r7.getIcon(), "poi_map_img");
    L22:
        TextView r10 = this.t;
        if (r10 == null) goto L25;
        r10.setText(r7.getPoiName());
    L25:
        String r11 = r7.getAddress();
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        this.B = r11;
        String r12 = r7.getDistance() + " · " + r7.getAddress();
        TextView r13 = this.u;
        if (r13 == null) goto L31;
        r13.setText(r12);
    L31:
        Float r14 = r7.getScore();
        if (r14 == null) goto L65;
        float r15 = r14.floatValue();
        if (r15 <= 0.0f) goto L62;
        ConstraintLayout r16 = this.x;
        if (r16 == null) goto L38;
        r16.setVisibility(0);
    L38:
        LinearLayout r20 = this.w;
        if (r20 == null) goto L41;
        r20.removeAllViews();
    L41:
        float r21 = r15 % 1;
        int r22 = (int) r15;
        int r23 = 0;
        int r110 = 0;
    L42:
        if (r23 >= r22) goto L44;
        n(2131243277);
        r110 = r110 + 1;
        r23 = r23 + 1;
        goto L42
    L44:
        double r24 = r21;
        if (0.3d <= r24) goto L47;
    L49:
        boolean r25 = false;
    L51:
        if (r25 == false) goto L54;
        if (r110 >= 5) goto L54;
        n(2131243276);
        z1 r26 = this;
        z1 r27 = r26;
        z1 r111 = r27;
    L57:
        r110 = r110 + 1;
    L55:
        if (r110 >= 5) goto L58;
        r27.n(2131243275);
        goto L57
    L58:
        TextView r28 = r26.v;
        if (r28 == null) goto L61;
        r28.setText(String.valueOf(r15));
    L61:
        z1 r29 = r111;
    L67:
        if (r7.getLat() != null) goto L69;
        return;
    L69:
        if (r7.getLon() == null) goto L116;
        int r30 = wq9.d.a;
        wq9.a r31 = wq9.d.e(CastDoubleProtector.parseDouble(r7.getLat()), CastDoubleProtector.parseDouble(r7.getLon()));
        if (r31 != null) goto L73;
        return;
    L73:
        r26.z = r31.a;
        r26.A = r31.b;
        Extra r32 = r17.getData().getExtra();
        kk9.b r33 = null;
        if (r32 == null) goto L76;
        String r34 = r32.getUserLat();
    L77:
        if (r34 != null) goto L79;
    L103:
        z1 r0 = r26;
        com.larus.bmhome.chat.map.o r1 = r0.y;
        if (r1 == null) goto L119;
        wq9.a r35 = new wq9.a(r0.z, r0.A);
        Intrinsics.checkNotNullParameter(r35, "centerLatLon");
        wq9.e r36 = r1.i;
        if (r36 == null) goto L108;
        r36.j(r35);
    L108:
        wq9.e r37 = r1.i;
        if (r37 == null) goto L111;
        r37.h();
    L111:
        r1.d(CollectionsKt.listOf(r35));
        r1.a(r35);
        return;
    L119:
        return;
    L79:
        if (r17.getData().getExtra().getUserLon() == null) goto L103;
        double r112 = CastDoubleProtector.parseDouble(r17.getData().getExtra().getUserLat());
        double r38 = CastDoubleProtector.parseDouble(r17.getData().getExtra().getUserLon());
        com.larus.bmhome.chat.map.o r39 = r26.y;
        if (r39 == null) goto L91;
        wq9.a r113 = new wq9.a(r112, r38);
        wq9.a r114 = new wq9.a(r26.z, r26.A);
        Intrinsics.checkNotNullParameter(r113, "from");
        Intrinsics.checkNotNullParameter(r114, "to");
        wq9.f r40 = r39.d;
        if (r40 == null) goto L86;
        r40.destroy();
    L86:
        View r41 = new View(r39.a);
        r41.setLayoutParams(new ViewGroup.LayoutParams((int) r41.getResources().getDimension(v19.c.b(2130972309, null, 2131167677)), (int) r41.getResources().getDimension(v19.c.b(2130972309, null, 2131167677))));
        r41.setBackground(AppCompatResources.getDrawable(r41.getContext(), 2131243154));
        wq9.e r42 = r39.i;
        if (r42 == null) goto L89;
        r33 = r42.d(new wq9.b(r113, r41));
    L89:
        r39.d = r33;
        r39.a(r114);
    L91:
        String r43 = r18.getMessageId();
        if (r43 == null) goto L99;
        Gson r44 = com.larus.bmhome.chat.map.s.a;
        Intrinsics.checkNotNullParameter(r43, "messageId");
        if (com.larus.bmhome.chat.map.s.c.b(r43) == false) goto L96;
        com.larus.bmhome.chat.map.s.a(r43, new w1(r29, r112, r38));
        goto L99
    L96:
        z1 r45 = r26;
        com.larus.bmhome.chat.map.o r46 = r45.y;
        if (r46 == null) goto L100;
        r46.c(new wq9.a(r112, r38), new wq9.a(r45.z, r45.A));
    L100:
        com.larus.bmhome.chat.map.o r47 = r45.y;
        if (r47 == null) goto L117;
        r47.d(CollectionsKt.listOf(new wq9.a[]{new wq9.a(Math.min(r45.z, r112), Math.min(r45.A, r38)), new wq9.a(Math.max(r45.z, r112), Math.max(r45.A, r38))}));
        return;
    L117:
        return;
    L99:
        r45 = r26;
        goto L100
    L76:
        r34 = null;
        goto L77
    L116:
        return;
    L54:
        r26 = this;
        r27 = r26;
        r111 = r27;
        goto L55
    L47:
        if (r24 > 0.7d) goto L49;
        r25 = true;
        goto L51
    L62:
        ConstraintLayout r48 = this.x;
        if (r48 == null) goto L65;
        r48.setVisibility(8);
    L65:
        r26 = this;
        r29 = r26;
        goto L67
    L114:
        return;
    L14:
        r6 = false;
        goto L15
    }
}
