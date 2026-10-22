package com.larus.extension.chat_extension.impl.ltm.view;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmListBinding;
import com.larus.extension.chat_extension.impl.ltm.ChatLtmStatus;
import com.larus.extension.chat_extension.impl.ltm.r;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.e1;
import com.larus.utils.t0;
import j99.b;
import j99.c;
import j99.d;
import j99.e;
import j99.f;
import j99.g;
import j99.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0003J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmNormalHolder;", "Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "binding", "Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmListBinding;", "callback", "Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;", "<init>", "(Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmListBinding;Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;)V", "getBinding", "()Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmListBinding;", "downX", "", "downY", "translationStart", "isDragging", "", "isDeleteMode", "deleteWidth", "touchSlop", "", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "bindData", "", "data", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "bindBackground", "updateBackgroundColor", "bindStatus", "isOpenSwitch", "handleMemoryForegroundTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "isHorizontalDrag", "dx", "dy", "isVerticalScroll", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmNormalHolder extends ChatLtmBaseHolder {
    public static final /* synthetic */ int j = 0;
    public final LarusItemLtmListBinding a;
    public final j b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public final float h;
    public final Lazy i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatLtmStatus.values().length];
            r0[ChatLtmStatus.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ChatLtmStatus.PLACEHOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder
    public final void T3(final r r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        boolean r2 = false;
        if (r10.b.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r10.a.length() != 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r0 | r3) == false) goto L14;
        this.a.a.setVisibility(8);
        return;
    L14:
        this.a.a.setVisibility(0);
        this.a.e.setTranslationX(0.0f);
        this.g = false;
        LarusItemLtmListBinding r1 = this.a;
        r1.g.setText(r10.b);
        r1.d.setText(r10.d);
        if (r10.f == false) goto L17;
        r1.c.setVisibility(4);
    L18:
        float r4 = i5.q();
        boolean r5 = r10.f;
        if (r5 == true) goto L21;
    L23:
        if (r5 == false) goto L26;
        r1.a.a(0.0f, 0.0f, r4, r4);
    L29:
        U3(r10);
        BotModel r6 = this.b.B0();
        if (r6 == null) goto L34;
        BotMemoryConfig r7 = r6.getBotMemoryConfig();
        if (r7 == null) goto L34;
        r2 = Intrinsics.areEqual(r7.getSwitchStatus(), Boolean.TRUE);
    L34:
        final LarusItemLtmListBinding r8 = this.a;
        View.OnClickListener r9 = new c(this);
        View.OnClickListener r11 = new d(this, r10);
        r8.g.setAlpha(1.0f);
        int r12 = a.a[r10.c.ordinal()];
        if (r12 != 1) goto L37;
        if (r2 == false) goto L46;
        r8.g.setTextColor(ContextCompat.getColor(r8.a.getContext(), 2131103136));
        r8.d.setTextColor(ContextCompat.getColor(r8.a.getContext(), 2131103143));
        e1.c(r8.b, r11);
        r8.e.setOnTouchListener(new e(r10, this));
        r8.e.setFocusableInTouchMode(true);
        r8.e.setFocusable(true);
        r8.e.setOnFocusChangeListener(new f(this));
        r8.a.setOnClickListener(null);
        return;
    L46:
        r8.g.setTextColor(ContextCompat.getColor(r8.a.getContext(), 2131103143));
        r8.d.setTextColor(ContextCompat.getColor(r8.a.getContext(), 2131103143));
        r8.b.setOnClickListener(null);
        r8.e.setOnTouchListener(null);
        e1.d(r8.a, new g(r8));
        return;
    L37:
        if (r12 != 2) goto L50;
        e1.c(r8.a, r9);
        r8.g.setTextColor(ContextCompat.getColor(r8.a.getContext(), 2131103143));
        if (r2 == true) goto L42;
        r8.g.setAlpha(0.3f);
    L43:
        r8.e.setOnTouchListener(null);
        return;
    L42:
        r8.g.setAlpha(1.0f);
        goto L43
    L50:
        return;
    L26:
        if (r10.g == false) goto L28;
        r1.a.a(r4, r4, 0.0f, 0.0f);
        goto L29
    L28:
        r1.a.a(0.0f, 0.0f, 0.0f, 0.0f);
        goto L29
    L21:
        if (r10.g == false) goto L23;
        r1.a.a(r4, r4, r4, r4);
        goto L29
    L17:
        r1.c.setVisibility(0);
        goto L18
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public final void U3(final r r5) {
        final LarusItemLtmListBinding r0 = this.a;
        if (r5.h == false) goto L5;
        r0.f.setVisibility(0);
        t0.d(new j99.a(r5, r0), 5000);
        return;
    L5:
        r0.f.setVisibility(8);
    }

    public ChatLtmNormalHolder(LarusItemLtmListBinding r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.h = i5.s0();
        this.i = LazyKt.lazy(new b(this));
    }
}
