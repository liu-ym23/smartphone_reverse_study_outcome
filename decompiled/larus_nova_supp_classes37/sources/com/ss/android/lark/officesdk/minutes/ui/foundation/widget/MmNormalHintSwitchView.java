package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003QRSB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u00162\b\b\u0001\u0010/\u001a\u00020\nJ\u0010\u00100\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u0010\u00101\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u0016\u00102\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\n2\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\u0016J\u000e\u00105\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&J\b\u00106\u001a\u0004\u0018\u00010\u0018J\u0006\u00107\u001a\u00020\u0015J\u000e\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010;\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0015J\u0018\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00152\b\b\u0002\u0010>\u001a\u00020\u0015J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020\u0015J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010C\u001a\u00020\u0015J\u000e\u0010D\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u0010\u0010E\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010GJ\u000e\u0010H\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u0010\u0010I\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010GJ\u001c\u0010J\u001a\u00020\u00162\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014J\u000e\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u0004\u0018\u00010\u0012*\u00020\u0018H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmNormalHintSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mContentTv", "Landroid/widget/TextView;", "mContentDescTv", "mSwitch", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmNormalHintSwitchView$MmSwitchAdapter;", "mListener", "Lkotlin/Function1;", "", "", "mSwitchMask", "Landroid/view/View;", "mIconItemMask", "mIconDesc", "mIcon", "Landroid/widget/ImageView;", "mCheck", "mRootView", "defaultIconResId", "defaultIconTintResId", "init", "setStyle", "style", "setContent", "text", "", "setContentColor", "color", "setContentDesc", "", "setContentDescMovementMethod", "movement", "Landroid/text/method/MovementMethod;", "setContentDescHighlightTextColor", "resId", "setContentDescColor", "setIconDescColor", "setIconResource", "colorId", "setDefaultIcon", "setIconDesc", "getIcon", "isCheckIconChecked", "setIconVisibility", "visibility", "setIconDescVisibility", "setCheckVisibility", "setSwitchChecked", "isChecked", "notifyEvent", "setSwitchEnabled", "isEnabled", "isSwitchEnabled", "setSwitchClickable", "isSwitchChecked", "setSwitchMaskVisibility", "setSwitchMaskOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setIconMaskVisibility", "setIconMaskOnClickListener", "setOnCheckedChangeListener", "setSwitchLoading", "loading", "setIconDescTextSize", "size", "", "toMmSwitchAdapter", "MmSwitchAdapter", "FlowSwitchAdapter", "UDSwitchAdapter", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmNormalHintSwitchView extends ConstraintLayout {
    public TextView a;
    public TextView b;
    public b c;
    public Function1<? super Boolean, Unit> d;
    public View e;
    public View f;
    public TextView g;
    public ImageView h;
    public View i;
    public View j;
    public int k;
    public int l;

    public static final class a implements b {
        public final FlowSwitch a;
        public final FlowSwitch b;

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final boolean isChecked() {
            return this.a.isChecked();
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final View getView() {
            return this.b;
        }

        public a(FlowSwitch r2) {
            Intrinsics.checkNotNullParameter(r2, "switchView");
            this.a = r2;
            this.b = r2;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void a(Function1<? super Boolean, Unit> r2) {
            this.a.setOnCheckedChangeListener(r2);
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void c(boolean r2) {
            this.a.setLoading(r2);
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void b(boolean r1, Function1 r2) {
            this.a.setChecked(r1);
        }
    }

    public interface b {
        void a(Function1<? super Boolean, Unit> r1);

        void b(boolean r1, Function1 r2);

        void c(boolean r1);

        View getView();

        boolean isChecked();
    }

    public static final class c implements b {
        public final UDSwitch a;
        public final UDSwitch b;

        public static final class a implements CompoundButton.OnCheckedChangeListener {
            public final /* synthetic */ Function1<Boolean, Unit> a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super Boolean, Unit> r1) {
                this.a = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton r1, boolean r2) {
                Function1<Boolean, Unit> r3 = this.a;
                if (r3 == null) goto L6;
                r3.invoke(Boolean.valueOf(r2));
                return;
            }
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void c(boolean r1) {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final boolean isChecked() {
            return this.a.isChecked();
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final View getView() {
            return this.b;
        }

        public c(UDSwitch r2) {
            Intrinsics.checkNotNullParameter(r2, "switchView");
            this.a = r2;
            this.b = r2;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void a(Function1<? super Boolean, Unit> r3) {
            this.a.setOnCheckedChangeListener(new a(r3));
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void b(boolean r1, Function1 r2) {
            this.a.setCheckedIgnoreEvent(r1);
        }
    }

    public final View getIcon() {
        return this.h;
    }

    public MmNormalHintSwitchView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void S5(boolean r3) {
        b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isChecked() == r3) goto L9;
        r0.b(r3, this.d);
        return;
    }

    public final void setCheckVisibility(int r2) {
        View r0 = this.i;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentColor(int r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setTextColor(UDColorUtils.getColor(getContext(), r3));
        return;
    }

    public final void setContentDesc(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentDescColor(int r3) {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setTextColor(UDColorUtils.getColor(getContext(), r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentDescHighlightTextColor(int r3) {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setHighlightColor(UDColorUtils.getColor(getContext(), r3));
        return;
    }

    public final void setContentDescMovementMethod(MovementMethod r2) {
        Intrinsics.checkNotNullParameter(r2, "movement");
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setMovementMethod(r2);
        return;
    }

    public final void setIconDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIconDescColor(int r3) {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setTextColor(UDColorUtils.getColor(getContext(), r3));
        return;
    }

    public final void setIconDescTextSize(float r2) {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setTextSize(r2);
        return;
    }

    public final void setIconDescVisibility(int r2) {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void setIconMaskOnClickListener(final View.OnClickListener r3) {
        if (r3 != null) goto L6;
        View r4 = this.f;
        if (r4 == null) goto L10;
        r4.setOnClickListener(null);
        return;
    L10:
        return;
    L6:
        View r0 = this.f;
        if (r0 == null) goto L12;
        h.a(r0, new AnonymousClass1(r3));
        return;
    }

    public final void setIconMaskVisibility(int r2) {
        View r0 = this.f;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void setIconVisibility(int r2) {
        ImageView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void setOnCheckedChangeListener(Function1<? super Boolean, Unit> r2) {
        this.d = r2;
        b r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void setStyle(int r8) {
        if (r8 != MmSwitchViewStyle.SWITCH_ONLY.getValue()) goto L19;
        TextView r9 = this.g;
        if (r9 == null) goto L7;
        r9.setVisibility(8);
    L7:
        ImageView r10 = this.h;
        if (r10 == null) goto L10;
        r10.setVisibility(8);
    L10:
        TextView r11 = this.b;
        if (r11 == null) goto L13;
        r11.setVisibility(8);
    L13:
        b r12 = this.c;
        if (r12 == null) goto L130;
        View r13 = r12.getView();
        if (r13 == null) goto L131;
        r13.setVisibility(0);
        return;
    L131:
        return;
    L130:
        return;
    L19:
        if (r8 != MmSwitchViewStyle.SWITCH_HINT.getValue()) goto L35;
        TextView r14 = this.g;
        if (r14 == null) goto L23;
        r14.setVisibility(8);
    L23:
        ImageView r15 = this.h;
        if (r15 == null) goto L26;
        r15.setVisibility(8);
    L26:
        TextView r16 = this.b;
        if (r16 == null) goto L29;
        r16.setVisibility(0);
    L29:
        b r17 = this.c;
        if (r17 == null) goto L133;
        View r18 = r17.getView();
        if (r18 == null) goto L134;
        r18.setVisibility(0);
        return;
    L134:
        return;
    L133:
        return;
    L35:
        if (r8 != MmSwitchViewStyle.ICON_ONLY.getValue()) goto L51;
        TextView r19 = this.g;
        if (r19 == null) goto L39;
        r19.setVisibility(0);
    L39:
        ImageView r20 = this.h;
        if (r20 == null) goto L42;
        r20.setVisibility(0);
    L42:
        TextView r21 = this.b;
        if (r21 == null) goto L45;
        r21.setVisibility(8);
    L45:
        b r22 = this.c;
        if (r22 == null) goto L136;
        View r23 = r22.getView();
        if (r23 == null) goto L137;
        r23.setVisibility(8);
        return;
    L137:
        return;
    L136:
        return;
    L51:
        if (r8 != MmSwitchViewStyle.ICON_HINT.getValue()) goto L67;
        TextView r24 = this.g;
        if (r24 == null) goto L55;
        r24.setVisibility(0);
    L55:
        ImageView r25 = this.h;
        if (r25 == null) goto L58;
        r25.setVisibility(0);
    L58:
        TextView r26 = this.b;
        if (r26 == null) goto L61;
        r26.setVisibility(0);
    L61:
        b r27 = this.c;
        if (r27 == null) goto L139;
        View r28 = r27.getView();
        if (r28 == null) goto L140;
        r28.setVisibility(8);
        return;
    L140:
        return;
    L139:
        return;
    L67:
        if (r8 != MmSwitchViewStyle.CONTENT_ONLY.getValue()) goto L83;
        TextView r29 = this.g;
        if (r29 == null) goto L71;
        r29.setVisibility(8);
    L71:
        ImageView r30 = this.h;
        if (r30 == null) goto L74;
        r30.setVisibility(8);
    L74:
        TextView r31 = this.b;
        if (r31 == null) goto L77;
        r31.setVisibility(8);
    L77:
        b r32 = this.c;
        if (r32 == null) goto L142;
        View r33 = r32.getView();
        if (r33 == null) goto L143;
        r33.setVisibility(8);
        return;
    L143:
        return;
    L142:
        return;
    L83:
        if (r8 != MmSwitchViewStyle.CONTENT_HINT.getValue()) goto L99;
        TextView r34 = this.g;
        if (r34 == null) goto L87;
        r34.setVisibility(8);
    L87:
        ImageView r35 = this.h;
        if (r35 == null) goto L90;
        r35.setVisibility(8);
    L90:
        TextView r36 = this.b;
        if (r36 == null) goto L93;
        r36.setVisibility(0);
    L93:
        b r37 = this.c;
        if (r37 == null) goto L145;
        View r38 = r37.getView();
        if (r38 == null) goto L146;
        r38.setVisibility(8);
        return;
    L146:
        return;
    L145:
        return;
    L99:
        if (r8 != MmSwitchViewStyle.CHECK_ONLY.getValue()) goto L148;
        TextView r39 = this.a;
        ConstraintLayout.LayoutParams r4 = null;
        if (r39 == null) goto L108;
        ViewGroup.LayoutParams r5 = r39.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L105;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
    L106:
        if (r6 == null) goto L108;
        r6.endToStart = 2131385986;
        r6.setMarginEnd(UIUtils.dp2px(r39.getContext(), 12.0f));
        r39.setLayoutParams(r6);
        goto L108
    L105:
        r6 = null;
    L108:
        View r40 = this.i;
        if (r40 == null) goto L111;
        r40.setVisibility(4);
    L111:
        TextView r41 = this.g;
        if (r41 == null) goto L114;
        r41.setVisibility(8);
    L114:
        ImageView r42 = this.h;
        if (r42 == null) goto L117;
        r42.setVisibility(8);
    L117:
        TextView r43 = this.b;
        if (r43 == null) goto L124;
        ViewGroup.LayoutParams r7 = r43.getLayoutParams();
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L122;
        r4 = (ConstraintLayout.LayoutParams) r7;
    L122:
        if (r4 == null) goto L124;
        r4.endToStart = 2131385986;
        r4.setMarginEnd(UIUtils.dp2px(r43.getContext(), 12.0f));
        r43.setLayoutParams(r4);
        r43.setVisibility(0);
    L124:
        b r44 = this.c;
        if (r44 == null) goto L149;
        View r45 = r44.getView();
        if (r45 == null) goto L150;
        r45.setVisibility(8);
        return;
    L150:
        return;
    L149:
        return;
    }

    public final void setSwitchChecked(boolean r1) {
        S5(r1);
    }

    public final void setSwitchClickable(boolean r2) {
        b r0 = this.c;
        if (r0 == null) goto L8;
        View r1 = r0.getView();
        if (r1 == null) goto L9;
        r1.setClickable(r2);
        return;
    L9:
        return;
    }

    public final void setSwitchEnabled(boolean r2) {
        b r0 = this.c;
        if (r0 == null) goto L8;
        View r1 = r0.getView();
        if (r1 == null) goto L9;
        r1.setEnabled(r2);
        return;
    L9:
        return;
    }

    public final void setSwitchLoading(boolean r2) {
        b r0 = this.c;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void setSwitchMaskOnClickListener(final View.OnClickListener r3) {
        if (r3 != null) goto L6;
        View r4 = this.e;
        if (r4 == null) goto L10;
        r4.setOnClickListener(null);
        return;
    L10:
        return;
    L6:
        View r0 = this.e;
        if (r0 == null) goto L12;
        h.a(r0, new C02171(r3));
        return;
    }

    public final void setSwitchMaskVisibility(int r2) {
        View r0 = this.e;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public MmNormalHintSwitchView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r4, AttributeSet r5) {
        MmRecordingUILaunchMode r0 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r4);
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.h r1 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r0);
        this.k = r1.getDrawable().f();
        this.l = r1.getColor().q();
        View r2 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r0).getLayout().t(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r4, r0)), this);
        this.j = r2;
        View r3 = null;
        if (r2 == null) goto L5;
        TextView r6 = (TextView) r2.findViewById(2131385988);
    L6:
        this.a = r6;
        View r7 = this.j;
        if (r7 == null) goto L9;
        TextView r8 = (TextView) r7.findViewById(2131385989);
    L10:
        this.b = r8;
        View r9 = this.j;
        if (r9 == null) goto L20;
        FlowSwitch r10 = r9.findViewById(2131386000);
        if (r10 == null) goto L20;
        if ((r10 instanceof FlowSwitch) == false) goto L18;
        b r11 = new a(r10);
    L21:
        this.c = r11;
        View r12 = this.j;
        if (r12 == null) goto L24;
        View r13 = r12.findViewById(2131385995);
    L25:
        this.e = r13;
        View r14 = this.j;
        if (r14 == null) goto L28;
        ImageView r15 = (ImageView) r14.findViewById(2131385990);
    L29:
        this.h = r15;
        View r16 = this.j;
        if (r16 == null) goto L32;
        TextView r17 = (TextView) r16.findViewById(2131385991);
    L33:
        this.g = r17;
        View r18 = this.j;
        if (r18 == null) goto L36;
        View r19 = r18.findViewById(2131385982);
    L37:
        this.f = r19;
        View r20 = this.j;
        if (r20 == null) goto L40;
        r3 = r20.findViewById(2131385986);
    L40:
        this.i = r3;
        TypedArray r21 = r4.obtainStyledAttributes(r5, new int[]{2130972838, 2130972839, 2130972840, 2130972841, 2130972842, 2130972843});
        String r22 = r21.getString(1);
        if (r22 == null) goto L43;
        setContent(r22);
    L43:
        String r23 = r21.getString(0);
        if (r23 == null) goto L46;
        setContentDesc(r23);
    L46:
        String r24 = r21.getString(3);
        if (r24 == null) goto L49;
        setIconDesc(r24);
    L49:
        int r25 = r21.getResourceId(4, this.k);
        int r26 = this.l;
        int r27 = wvb.b.a;
        wvb.b.a(this.h, r25, r26);
        setStyle(r21.getInteger(5, MmSwitchViewStyle.SWITCH_ONLY.getValue()));
        boolean r28 = r21.getBoolean(2, true);
        TextView r29 = this.a;
        if (r29 == null) goto L54;
        TextPaint r30 = r29.getPaint();
        if (r30 == null) goto L54;
        r30.setFakeBoldText(r28);
    L54:
        r21.recycle();
        return;
    L36:
        r19 = null;
        goto L37
    L32:
        r17 = null;
        goto L33
    L28:
        r15 = null;
        goto L29
    L24:
        r13 = null;
        goto L25
    L18:
        if ((r10 instanceof UDSwitch) == false) goto L20;
        r11 = new c((UDSwitch) r10);
    L20:
        r11 = null;
        goto L21
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public MmNormalHintSwitchView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
