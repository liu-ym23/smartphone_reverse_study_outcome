package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import w08.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010$\u001a\u00020%2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0015\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200H\u0014J\u0012\u00101\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0003J\b\u00102\u001a\u00020\u0018H\u0002J\u0010\u00103\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000104H\u0003J\b\u00105\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDTextAvatar;", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "avatarTextColor", "textPaint", "Landroid/text/TextPaint;", "avatarText", "", "getAvatarText", "()Ljava/lang/String;", "setAvatarText", "(Ljava/lang/String;)V", "hasCustomTextSize", "", "value", "avatarTextSize", "getAvatarTextSize", "()I", "setAvatarTextSize", "(I)V", "avatarBgColor", "getAvatarBgColor", "setAvatarBgColor", "bgPaint", "Landroid/graphics/Paint;", "init", "", "ta", "Landroid/content/res/TypedArray;", "onAvatarSizeChanged", "setText", "text", "setTextColor", "color", "(Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawText", "shouldDrawText", "breakAvatarText", "", "countAvatarText", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDTextAvatar extends UDAvatar {
    public int a;
    public TextPaint b;
    public String c;
    public boolean d;
    public int e;
    public int f;
    public Paint g;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.image.UDAvatar
    public final void onAvatarSizeChanged() {
        super.onAvatarSizeChanged();
        if (this.d == true) goto L22;
        int r0 = getAvatarSize();
        if (r0 != (-5)) goto L7;
        int r1 = d.d(getContext(), 2131169337);
    L20:
        setAvatarTextSize(r1);
        return;
    L7:
        if (r0 != (-4)) goto L9;
        r1 = d.d(getContext(), 2131169340);
        goto L20
    L9:
        if (r0 != (-3)) goto L11;
        r1 = d.d(getContext(), 2131169341);
        goto L20
    L11:
        if (r0 != (-2)) goto L13;
        r1 = d.d(getContext(), 2131169339);
        goto L20
    L13:
        if (r0 == (-1)) goto L15;
        r1 = d.d(getContext(), 2131169338);
        goto L20
    L15:
        r1 = d.d(getContext(), 2131169338);
        goto L20
    }

    public final int getAvatarBgColor() {
        return this.f;
    }

    public final String getAvatarText() {
        return this.c;
    }

    public final int getAvatarTextSize() {
        return this.e;
    }

    public UDTextAvatar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void init(TypedArray r3) {
        CharSequence r1 = r3.getText(6);
        if (r1 == null) goto L6;
        String r2 = r1.toString();
        if (r2 == null) goto L6;
    L7:
        this.c = r2;
        this.a = r3.getColor(7, 0);
        this.f = r3.getColor(0, 0);
        int r4 = r3.getDimensionPixelSize(8, -1);
        if (r4 <= 0) goto L11;
        setAvatarTextSize(r4);
        return;
    L11:
        return;
    L6:
        r2 = r3.getString(6);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.image.UDAvatar
    public final void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        super.onDraw(r15);
        String r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((!r1) == true) goto L13;
        return;
    L13:
        if (getBackground() != null) goto L23;
        int r2 = this.f;
        if (r2 == 0) goto L23;
        Paint r3 = this.g;
        if (r3 == null) goto L19;
        r3.setColor(r2);
    L19:
        Paint r9 = this.g;
        if (r9 == null) goto L23;
        if (r15 == null) goto L23;
        r15.drawRect(0.0f, 0.0f, getWidth(), getHeight(), r9);
    L23:
        String r4 = this.c;
        if (r4 != null) goto L26;
    L29:
        boolean r5 = true;
    L31:
        if (r5 == false) goto L33;
        ArrayList r6 = null;
    L102:
        if (r6 == null) goto L127;
        TextPaint r7 = this.b;
        if (r7 == null) goto L106;
        r7.setColor(this.a);
    L106:
        Iterator r8 = r6.iterator();
        int r10 = 0;
    L108:
        if (r8.hasNext() == false) goto L138;
        int r11 = r10 + 1;
        String r12 = (String) r8.next();
        Rect r13 = new Rect();
        TextPaint r14 = this.b;
        if (r14 == null) goto L112;
        r14.getTextBounds(r12, 0, r12.length(), r13);
    L112:
        int r16 = getHeight() / r6.size();
        float r17 = getWidth();
        TextPaint r19 = this.b;
        if (r19 == null) goto L115;
        float r110 = r19.measureText(r12);
    L116:
        float r111 = ((r17 - r110) - r13.left) / 2;
        float r20 = (r10 * r16) + (r16 / 2.0f);
        TextPaint r21 = this.b;
        if (r21 == null) goto L126;
        float r22 = (r20 + ((r21.getFontMetricsInt().descent - r21.getFontMetricsInt().ascent) / 2.0f)) - r21.getFontMetricsInt().descent;
        if (r6.size() <= 1) goto L124;
        if (r10 != 0) goto L122;
        int r23 = r21.getFontMetricsInt().descent;
    L123:
        r22 = r22 + r23;
        goto L124
    L122:
        r23 = -r21.getFontMetricsInt().descent;
    L124:
        if (r15 == null) goto L126;
        r15.drawText(r12, r111, r22, r21);
    L126:
        r10 = r11;
        goto L108
    L115:
        r110 = 0.0f;
        goto L116
    L138:
        return;
    L127:
        return;
    L33:
        r6 = new ArrayList();
        int r24 = this.e;
        if (r24 <= 0) goto L41;
        TextPaint r25 = this.b;
        if (r25 == null) goto L38;
        r25.setTextSize(r24);
    L38:
        String r26 = this.c;
        if (r26 == null) goto L102;
        r6.add(r26);
        goto L102
    L41:
        String r27 = this.c;
        if (r27 != null) goto L44;
    L55:
        int r29 = 0;
    L56:
        TextPaint r30 = this.b;
        if (r30 == null) goto L69;
        if (r29 == 0) goto L67;
        if (r29 == 1) goto L67;
        if (r29 != 2) goto L62;
        float r31 = d.c(getContext(), 2131169359);
    L68:
        r30.setTextSize(r31);
        goto L69
    L62:
        if (r29 == 3) goto L65;
        if (r29 == 4) goto L65;
        r31 = d.c(getContext(), 2131169360);
    L65:
        r31 = d.c(getContext(), 2131169361);
    L67:
        r31 = d.c(getContext(), 2131169358);
    L69:
        String r32 = this.c;
        if (r32 == null) goto L102;
        if (r32.length() <= 0) goto L74;
        boolean r33 = true;
    L75:
        if (r33 == false) goto L102;
        int r34 = r32.length();
        int r35 = 0;
        int r36 = 0;
        int r37 = 0;
    L77:
        if (r35 >= r34) goto L100;
        int r112 = r35 + 1;
        if (r32.substring(r35, r112).getBytes(Charsets.UTF_8).length != 1) goto L81;
        int r113 = 1;
    L82:
        r36 = r36 + r113;
        if (r36 != 4) goto L85;
        r6.add(r32.substring(r37, r112));
        r37 = r112;
        r36 = 0;
    L96:
        if (r6.size() >= 2) goto L100;
        r35 = r112;
        goto L77
    L85:
        if (r36 <= 4) goto L93;
        r6.add(r32.substring(r37, r35));
        if (r6.size() < 2) goto L89;
    L91:
        r37 = r35;
        r36 = 2;
        goto L96
    L89:
        if (r35 < (r32.length() - 1)) goto L91;
        r6.add(r32.substring(r35, r32.length()));
        goto L91
    L93:
        if (r35 < (r32.length() - 1)) goto L96;
        r6.add(r32.substring(r37, r32.length()));
        goto L96
    L81:
        r113 = 2;
    L100:
        if (r6.size() != 0) goto L102;
        r6.add(r32);
        goto L102
    L74:
        r33 = false;
        goto L75
    L44:
        if (r27.length() <= 0) goto L46;
        boolean r38 = true;
    L47:
        if (r38 == false) goto L55;
        int r39 = r27.length();
        int r40 = 0;
        r29 = 0;
    L49:
        if (r40 >= r39) goto L56;
        int r41 = r40 + 1;
        if (r27.substring(r40, r41).getBytes(Charsets.UTF_8).length != 1) goto L53;
        r29 = r29 + 1;
    L54:
        r40 = r41;
        goto L49
    L53:
        r29 = r29 + 2;
        goto L54
    L46:
        r38 = false;
        goto L47
    L26:
        if (r4.length() == 0) goto L29;
        r5 = false;
        goto L31
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final void setAvatarBgColor(int r1) {
        this.f = r1;
    }

    public final void setAvatarText(String r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAvatarTextSize(int r2) {
        if (this.e == r2) goto L5;
        this.e = r2;
        invalidate();
    L5:
        this.d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(String r1) {
        if (r1 == null) goto L5;
        this.c = r1;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextColor(Integer r1) {
        if (r1 == null) goto L5;
        r1.intValue();
        this.a = r1.intValue();
        invalidate();
        return;
    }

    public UDTextAvatar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public UDTextAvatar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.image.UDAvatar
    public final void init(AttributeSet r4, int r5, int r6) {
        super.init(r4, r5, r6);
        Paint r0 = new Paint();
        this.g = r0;
        r0.setStyle(Paint.Style.FILL);
        TextPaint r1 = new TextPaint(1);
        this.b = r1;
        r1.setFakeBoldText(true);
        r1.setTextSize(d.d(getContext(), 2131169338));
        a.a(r1, getContext(), 0);
        TypedArray r7 = getContext().obtainStyledAttributes(r4, new int[]{2130974835, 2130974836, 2130974837, 2130974838, 2130974839, 2130974840, 2130974841, 2130974842, 2130974843}, r5, r6);
        init(r7);
        r7.recycle();
    }

    public UDTextAvatar(Context r1, AttributeSet r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3);
        init(r2, r3, 0);
    }
}
