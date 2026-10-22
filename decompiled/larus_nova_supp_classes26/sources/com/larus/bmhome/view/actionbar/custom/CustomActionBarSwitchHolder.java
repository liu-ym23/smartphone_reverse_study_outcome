package com.larus.bmhome.view.actionbar.custom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*J\u0012\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0016\u00101\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u00020$03H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarSwitchHolder;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "Lcom/larus/bmhome/view/actionbar/custom/ICustomActionAnimation;", "itemView", "Landroid/view/View;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "", "isActionBarPanel", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/chat/ChatParam;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZZ)V", "getItemView", "()Landroid/view/View;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "getCallback", "()Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "()Z", "setActionBarPanel", "(Z)V", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "name", "Landroid/widget/TextView;", ItemStyle.ITEM_STYLE_SWITCH, "Landroidx/appcompat/widget/SwitchCompat;", "redDotIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "blueUpdateIcon", "actionBarRedDotVisibleHelper", "Lcom/larus/bmhome/view/actionbar/custom/ActionBarRedDotVisibleHelper;", "expertSwitchUpdateListener", "Lkotlin/Function1;", "", "bindData", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "customWidth", "", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Integer;)V", "setIconUrl", ShareType.URL, "", "tryShowNetworkErrorToast", "context", "Landroid/content/Context;", "startRedAnimation", "animationEnd", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarSwitchHolder extends BaseActionBarHolder {
    public static final /* synthetic */ int k = 0;
    public final View a;
    public final ChatParam b;
    public final t1 c;
    public final boolean d;
    public final boolean e;
    public final SimpleDraweeView f;
    public final TextView g;
    public final SwitchCompat h;
    public final j i;
    public final k2 j;

    public static final class a {
    }

    static {
    }

    public final void U3(final com.larus.bmhome.actionbar.model.z0 r9, Integer r10) {
        j r0 = this.i;
        ChatParam r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.b;
    L6:
        r0.a(r9, r2);
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("bindData, key=");
        if (r9 == null) goto L9;
        String r5 = r9.b;
    L10:
        r4.append(r5);
        r4.append(", switch=");
        if (r9 == null) goto L15;
        com.larus.bmhome.actionbar.model.h0 r6 = r9.n;
        if (r6 == null) goto L15;
        Boolean r7 = r6.a;
    L16:
        r4.append(r7);
        r3.d("CustomActionBarSwitchHolder", r4.toString());
        boolean r8 = true;
        if (r9 == null) goto L41;
        this.g.setText(r9.e);
        com.larus.bmhome.actionbar.model.p0 r11 = r9.o;
        if (r11 == null) goto L26;
        Integer r12 = r11.a;
        int r13 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r12 == null) goto L26;
        if (r12.intValue() != r13) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L31;
        SwitchCompat r15 = this.h;
        if (r15 == null) goto L41;
        r15.setChecked(Intrinsics.areEqual(this.c.g(r9).getModel(), wa8.t0.b));
        goto L41
    L31:
        SwitchCompat r16 = this.h;
        if (r16 == null) goto L41;
        com.larus.bmhome.actionbar.model.h0 r17 = r9.n;
        if (r17 == null) goto L38;
        Boolean r18 = r17.a;
        if (r18 == null) goto L38;
        boolean r19 = r18.booleanValue();
    L39:
        r16.setChecked(r19);
    L38:
        r19 = false;
    L26:
        r14 = false;
    L41:
        if (this.d == false) goto L51;
        RoundConstraintLayout r20 = this.a;
        if ((r20 instanceof RoundConstraintLayout) == false) goto L45;
        RoundConstraintLayout r21 = r20;
    L46:
        if (r21 == null) goto L50;
        c29.a r22 = r21.getDelegate();
        if (r22 == null) goto L50;
        int r23 = ContextCompat.getColor(this.a.getContext(), 2131106535);
        r22.a(r23);
        r22.b(r23);
        r22.g(ContextCompat.getColor(this.a.getContext(), 2131106536));
    L50:
        this.g.setTextColor(ContextCompat.getColor(this.a.getContext(), 2131103298));
    L67:
        if (r9 == null) goto L74;
        Integer r24 = r9.g;
        int r25 = ActionBarExecutionType.COMPLEX_SEARCH.getValue();
        if (r24 == null) goto L74;
        if (r24.intValue() != r25) goto L74;
        boolean r26 = true;
    L75:
        if (r26 == false) goto L95;
        SimpleDraweeView r27 = this.f;
        if (r27 == null) goto L79;
        r27.setImageResource(v19.c.b(2130971976, r27.getContext(), 2131242673));
    L79:
        CoroutineScope r28 = ExpertSwitchManager.a;
        boolean r29 = ExpertSwitchManager.b.f0();
        r3.d("CustomActionBarSwitchHolder", "bindData:" + r29);
        SwitchCompat r30 = this.h;
        if (r30 == null) goto L82;
        r30.setChecked(r29);
    L82:
        k2 r31 = this.j;
        Iterator r32 = ((List) ExpertSwitchManager.c.getValue()).iterator();
    L84:
        if (r32.hasNext() == false) goto L90;
        Function1 r33 = (Function1) ((WeakReference) r32.next()).get();
        if (r33 == null) goto L84;
        if (Intrinsics.areEqual(r33, r31) == false) goto L84;
    L91:
        if (r8 == true) goto L94;
        ((List) ExpertSwitchManager.c.getValue()).add(new WeakReference(r31));
    L94:
        com.larus.utils.e1.d(this.a, new i2(this, r9));
    L107:
        if (r10 != null) goto L109;
    L111:
        this.c.d(this.a, this.f, this.g, r9);
        return;
    L109:
        if (r10.intValue() <= 0) goto L111;
        ViewGroup.LayoutParams r34 = this.a.getLayoutParams();
        r34.width = r10.intValue();
        this.a.setLayoutParams(r34);
        ViewGroup.LayoutParams r35 = this.g.getLayoutParams();
        r35.width = r10.intValue() - j19.c.c(46);
        this.g.setLayoutParams(r35);
        goto L111
    L90:
        r8 = false;
        goto L91
    L95:
        boolean r36 = v19.h.a;
        if (v19.h.b(this.a.getContext()) == false) goto L101;
        if (r9 == null) goto L105;
        com.larus.bmhome.actionbar.model.g1 r37 = r9.d;
        if (r37 == null) goto L105;
    L104:
        String r38 = r37.b;
    L106:
        ImageLoaderKt.v(this.f, r38, "custom_actionbar_icon", null, new l2());
        com.larus.utils.e1.d(this.a, new j2(this, r9));
    L105:
        r38 = null;
        goto L106
    L101:
        if (r9 == null) goto L105;
        r37 = r9.c;
        if (r37 == null) goto L105;
    L74:
        r26 = false;
        goto L75
    L45:
        r21 = null;
        goto L46
    L51:
        RoundConstraintLayout r39 = this.a;
        if ((r39 instanceof RoundConstraintLayout) == false) goto L54;
        RoundConstraintLayout r40 = r39;
    L55:
        if (r40 == null) goto L59;
        c29.a r41 = r40.getDelegate();
        if (r41 == null) goto L59;
        r41.a(0);
    L59:
        RoundFrameLayout r42 = this.a;
        if ((r42 instanceof RoundFrameLayout) == false) goto L62;
        RoundFrameLayout r43 = r42;
    L63:
        if (r43 == null) goto L67;
        c29.a r44 = r43.getDelegate();
        if (r44 == null) goto L67;
        r44.a(0);
        goto L67
    L62:
        r43 = null;
        goto L63
    L54:
        r40 = null;
    L15:
        r7 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.bmhome.view.actionbar.custom.k2] */
    public CustomActionBarSwitchHolder(RoundConstraintLayout r3, ChatParam r4, t1 r5, boolean r6, boolean r7, int r8) {
        if ((r8 & 8) == 0) goto L6;
        r6 = false;
    L6:
        if ((r8 & 16) == 0) goto L8;
        r7 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r3);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r3.findViewById(2131374692);
        this.g = (TextView) r3.findViewById(2131390830);
        this.h = r3.findViewById(2131387153);
        this.i = new j(r3.findViewById(2131376335), (TextView) r3.findViewById(2131390835));
        this.j = new k2(this);
    }
}
