package com.ss.android.lark.keyboard.slot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/InjectableInputView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "root", "Landroidx/constraintlayout/widget/ConstraintLayout;", "etInput", "Landroid/widget/EditText;", "slotInnerStart", "slotInnerTop", "slotInnerEnd", "slotInnerBottom", "slotTop", "slotTopExtend", "basePaddingPx", "slotSpacingPx", "setSlotView", "", "slot", "Lcom/ss/android/lark/keyboard/slot/InjectableInputView$Slot;", "view", "Landroid/view/View;", "clearSlot", "updateEditTextPadding", "Slot", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InjectableInputView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public final EditText a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final int h;
    public final int i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/InjectableInputView$Slot;", "", "<init>", "(Ljava/lang/String;I)V", "InnerStart", "InnerTop", "InnerEnd", "InnerBottom", "Top", "TopExtend", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Slot extends Enum<Slot> {
        public static final Slot InnerBottom = null;
        public static final Slot InnerEnd = null;
        public static final Slot InnerStart = null;
        public static final Slot InnerTop = null;
        public static final Slot Top = null;
        public static final Slot TopExtend = null;
        public static final /* synthetic */ Slot[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Slot> getEntries() {
            return b;
        }

        static {
            Slot r0 = new Slot("InnerStart", 0);
            InnerStart = r0;
            Slot r1 = new Slot("InnerTop", 1);
            InnerTop = r1;
            Slot r3 = new Slot("InnerEnd", 2);
            InnerEnd = r3;
            Slot r5 = new Slot("InnerBottom", 3);
            InnerBottom = r5;
            Slot r7 = new Slot("Top", 4);
            Top = r7;
            Slot r9 = new Slot("TopExtend", 5);
            TopExtend = r9;
            Slot[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static Slot[] values() {
            return (Slot[]) a.clone();
        }

        public static Slot valueOf(String r1) {
            return (Slot) r27.a.a(Slot.class, r1);
        }

        public Slot(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ InjectableInputView a;

        public a(InjectableInputView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            InjectableInputView r0 = this.a;
            int r1 = InjectableInputView.j;
            r0.getClass();
            r0.post(new wob.a(r0));
        }
    }

    public InjectableInputView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InjectableInputView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public InjectableInputView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = UIUtils.dp2px(r2, 12.0f);
        this.i = UIUtils.dp2px(r2, 4.0f);
        LayoutInflater.from(r2).inflate(2131561541, this, true);
        ConstraintLayout r5 = findViewById(2131375300);
        this.a = (EditText) findViewById(2131371785);
        this.b = (FrameLayout) findViewById(2131386930);
        this.c = (FrameLayout) findViewById(2131386931);
        this.d = (FrameLayout) findViewById(2131386929);
        this.e = (FrameLayout) findViewById(2131386927);
        this.f = (FrameLayout) findViewById(2131386932);
        this.g = (FrameLayout) findViewById(2131386933);
        r5.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public /* synthetic */ InjectableInputView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
