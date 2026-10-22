package com.larus.bmhome.view.chatinput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.input.ChatInputPlaceholderMode;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import et8.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;
import ye8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/chatinput/ChatInputPlaceholderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "updateConfig", "", "config", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderConfig;", "applyFloatInputStyle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputPlaceholderView extends ConstraintLayout {
    public ChatInputPlaceholderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatInputPlaceholderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(a r13) {
        Intrinsics.checkNotNullParameter(r13, "config");
        TextView r0 = (TextView) findViewById(2131377185);
        ChatInputInnerView r2 = findViewById(2131377184);
        boolean r8 = true;
        int r9 = 0;
        if (r13.d != ChatInputPlaceholderMode.VOICE) goto L5;
        boolean r1 = true;
    L6:
        String r3 = r13.a;
        if (r3 != null) goto L9;
    L14:
        r3 = getContext().getString(2131909200);
    L15:
        r0.setHint(r3);
        Intrinsics.checkNotNull(r0);
        if ((!r1) == false) goto L18;
        int r4 = 0;
    L19:
        r0.setVisibility(r4);
        Intrinsics.checkNotNull(r2);
        if (r1 == false) goto L22;
        int r5 = 0;
    L23:
        r2.setVisibility(r5);
        if (r1 == false) goto L32;
        String r7 = r13.e;
        if (r7 != null) goto L28;
    L30:
        r7 = null;
    L31:
        r2.R5(false, true, false, false, r7);
        goto L32
    L28:
        if ((!StringsKt.isBlank(r7)) == false) goto L30;
    L32:
        View r6 = findViewById(2131377183);
        if (r1 == true) goto L42;
        int r10 = d.a;
        if (z2.a.m3() == true) goto L37;
    L39:
        boolean r11 = false;
    L40:
        if (r11 == false) goto L42;
    L43:
        if (r8 == false) goto L45;
        int r12 = 0;
    L46:
        r6.setVisibility(r12);
        View r14 = findViewById(2131377181);
        if (r1 == false) goto L49;
        int r15 = 0;
    L50:
        r14.setVisibility(r15);
        View r16 = findViewById(2131377177);
        if (r13.b == false) goto L53;
        int r17 = 0;
    L54:
        r16.setVisibility(r17);
        View r18 = findViewById(2131377182);
        if (r13.c == true) goto L58;
        r9 = 8;
    L58:
        r18.setVisibility(r9);
        return;
    L53:
        r17 = 8;
        goto L54
    L49:
        r15 = 8;
        goto L50
    L45:
        r12 = 8;
        goto L46
    L37:
        if (IAIChatService.a.n8() == true) goto L39;
        r11 = true;
    L42:
        r8 = false;
        goto L43
    L22:
        r5 = 8;
        goto L23
    L18:
        r4 = 8;
        goto L19
    L9:
        if ((!StringsKt.isBlank(r3)) == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatInputPlaceholderView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131563241, this);
        View r10 = findViewById(2131377180);
        r10.setPadding(r10.getPaddingLeft(), i5.r0(), r10.getPaddingRight(), r10.getPaddingBottom());
        Drawable r11 = ContextCompat.getDrawable(getContext(), 2131240018);
        if (r11 == null) goto L6;
        LayerDrawable r12 = new LayerDrawable(new Drawable[]{r11});
        r12.setLayerInset(0, 0, -i5.Y(), 0, 0);
        r10.setBackground(r12);
    L6:
        setImportantForAccessibility(4);
    }

    public /* synthetic */ ChatInputPlaceholderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
