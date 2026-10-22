package com.larus.xbridge.custom.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.larus.xbridge.custom.Action;
import com.larus.xbridge.custom.CommonAlertData;
import com.larus.xbridge.impl.databinding.LarusDialogCommonAlertVerBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/xbridge/custom/ui/CommonAlertDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", LynxResourceModule.DATA_KEY, "Lcom/larus/xbridge/custom/CommonAlertData;", "callback", "Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethod$Callback;", "setIvyCallback", NameKeys.UnloadStrategy_No_Strategy, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupBtn", "btn", "Landroid/widget/TextView;", "action", "Lcom/larus/xbridge/custom/Action;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonAlertDialog extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public CommonAlertData d;
    public IvyBridgeMethod.a e;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setBackgroundDrawable(ContextCompat.getDrawable(r1.getContext(), 2131239539));
        r1.setDimAmount(0.3f);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = getResources();
        r2.width = (int) (((double) WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels) * 0.7d);
        r2.height = -2;
        r1.setAttributes(r2);
        return;
    L9:
        return;
    }

    public CommonAlertDialog() {
    }

    public final void onCancel(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super.onCancel(r4);
        IvyBridgeMethod.a r5 = this.e;
        if (r5 == null) goto L6;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(LynxResourceModule.CODE_KEY, -7);
        r5.invoke(r0);
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        CommonAlertData r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("key_data");
    L7:
        if ((r5 instanceof CommonAlertData) == false) goto L9;
        r0 = (CommonAlertData) r5;
    L9:
        this.d = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void S90(TextView r4, final Action r5) {
        r4.setText(r5.getTitle());
        Integer r0 = r5.getStyle();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        int r1 = ContextCompat.getColor(r4.getContext(), 2131103136);
    L14:
        r4.setTextColor(r1);
        e1.d(r4, new g4a.a(this, r5));
        return;
    L11:
        if (r0.intValue() != 2) goto L13;
        r1 = ContextCompat.getColor(r4.getContext(), 2131103203);
        goto L14
    L6:
        if (r0.intValue() != 1) goto L8;
        r1 = ContextCompat.getColor(r4.getContext(), 2131102650);
        goto L14
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        CommonAlertData r13 = this.d;
        String r0 = null;
        if (r13 == null) goto L7;
        List<Action> r14 = r13.getActions();
        if (r14 == null) goto L7;
        List r15 = CollectionsKt.filterNotNull(r14);
    L9:
        if (r15 == null) goto L11;
        int r2 = r15.size();
    L12:
        int r4 = 2131368982;
        if (r2 != 2) goto L53;
        View r16 = r10.inflate(2131562045, r11, false);
        TextView r3 = (TextView) ViewBindings.findChildViewById(r16, 2131364749);
        if (r3 == null) goto L50;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r16, 2131364818);
        if (r5 == null) goto L49;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r16, 2131368971);
        if (r17 == null) goto L48;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r16, 2131368982);
        if (r6 == null) goto L52;
        r4 = 2131369197;
        if (ViewBindings.findChildViewById(r16, 2131369197) == null) goto L52;
        LinearLayout r18 = (LinearLayout) r16;
        CommonAlertData r7 = this.d;
        if (r7 == null) goto L27;
        String r8 = r7.getTitle();
    L29:
        if (o0.d(r8) == false) goto L35;
        CommonAlertData r9 = this.d;
        if (r9 == null) goto L33;
        String r19 = r9.getTitle();
    L34:
        r6.setText(r19);
    L36:
        CommonAlertData r20 = this.d;
        if (r20 == null) goto L39;
        String r21 = r20.getDesc();
    L41:
        if (o0.d(r21) == false) goto L46;
        CommonAlertData r22 = this.d;
        if (r22 == null) goto L45;
        r0 = r22.getDesc();
    L45:
        r17.setText(r0);
    L47:
        Intrinsics.checkNotNull(r15);
        S90(r3, (Action) ListProtector.get(r15, 0));
        S90(r5, (Action) ListProtector.get(r15, 1));
        Intrinsics.checkNotNull(r18);
        return r18;
    L46:
        e1.o(r17);
        goto L47
    L39:
        r21 = null;
        goto L41
    L33:
        r19 = null;
        goto L34
    L35:
        e1.o(r6);
        goto L36
    L27:
        r8 = null;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r4)));
    L48:
        r4 = 2131368971;
        goto L52
    L49:
        r4 = 2131364818;
        goto L52
    L50:
        r4 = 2131364749;
        goto L52
    L53:
        View r110 = r10.inflate(2131562046, r11, false);
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r110, 2131364692);
        if (r23 == null) goto L100;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r110, 2131368971);
        if (r111 == null) goto L99;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r110, 2131368982);
        if (r24 == null) goto L102;
        LarusDialogCommonAlertVerBinding r25 = new LarusDialogCommonAlertVerBinding((LinearLayout) r110, r23, r111, r24);
        CommonAlertData r112 = this.d;
        if (r112 == null) goto L62;
        String r113 = r112.getTitle();
    L64:
        if (o0.d(r113) == false) goto L70;
        CommonAlertData r114 = this.d;
        if (r114 == null) goto L68;
        String r115 = r114.getTitle();
    L69:
        r24.setText(r115);
    L71:
        CommonAlertData r116 = this.d;
        if (r116 == null) goto L74;
        String r117 = r116.getDesc();
    L76:
        if (o0.d(r117) == false) goto L81;
        CommonAlertData r118 = this.d;
        if (r118 == null) goto L80;
        r0 = r118.getDesc();
    L80:
        r111.setText(r0);
    L82:
        if (r15 == null) goto L97;
        Iterator r119 = r15.iterator();
        int r120 = 0;
    L85:
        if (r119.hasNext() == false) goto L97;
        Object r121 = r119.next();
        int r1 = r120 + 1;
        if (r120 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        Action r122 = (Action) r121;
        TextView r26 = new TextView(getContext());
        r26.setLayoutParams(new ViewGroup.LayoutParams(-1, i5.f0()));
        r26.setGravity(17);
        r26.setTextSize(0, i5.q());
        r26.setTypeface(Typeface.create("sans-serif-medium", 0));
        int r27 = r2 - 1;
        if (r120 != r27) goto L92;
        int r28 = 2131239031;
    L93:
        r26.setBackgroundResource(r28);
        S90(r26, r122);
        r25.b.addView(r26);
        if (r120 == r27) goto L96;
        View r123 = new View(getContext());
        r123.setLayoutParams(new ViewGroup.LayoutParams(-1, i5.a()));
        r123.setBackgroundResource(2131242953);
        r25.b.addView(r123);
    L96:
        r120 = r1;
        goto L85
    L92:
        r28 = 2131239323;
    L97:
        LinearLayout r124 = r25.a;
        Intrinsics.checkNotNull(r124);
        return r124;
    L81:
        e1.o(r111);
        goto L82
    L74:
        r117 = null;
        goto L76
    L68:
        r115 = null;
        goto L69
    L70:
        e1.o(r24);
        goto L71
    L62:
        r113 = null;
    L102:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r4)));
    L99:
        r4 = 2131368971;
        goto L102
    L100:
        r4 = 2131364692;
        goto L102
    L11:
        r2 = 0;
    L7:
        r15 = null;
        goto L9
    }
}
