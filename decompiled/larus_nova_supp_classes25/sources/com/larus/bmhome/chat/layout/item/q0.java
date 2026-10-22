package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.bmhome.databinding.LarusItemFormMsgHolderBinding;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 extends xc8.h {
    public final LarusItemFormMsgHolderBinding p;
    public FormMsgData q;
    public Function1<? super Boolean, Unit> r;

    public static final class a {
    }

    static {
    }

    public q0(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9);
        ConstraintLayout r10 = LayoutInflater.from(r9).inflate(2131562572, this, false);
        addView(r10);
        int r0 = 2131373180;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131373180);
        if (r4 == null) goto L13;
        r0 = 2131373181;
        View r5 = ViewBindings.findChildViewById(r10, 2131373181);
        if (r5 == null) goto L13;
        r0 = 2131373182;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131373182);
        if (r6 == null) goto L13;
        r0 = 2131373183;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131373183);
        if (r7 == null) goto L13;
        this.p = new LarusItemFormMsgHolderBinding(r10, r4, r5, r6, r7);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    private final void setupFormItems(final Message r8) {
        FormMsgData r0 = this.q;
        if (r0 == null) goto L5;
        List<FormShowItem> r1 = r0.getShowItems();
    L6:
        List<FormShowItem> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return;
    L15:
        final Context r4 = getContext();
        if (r4 == null) goto L19;
        FrameLayout r5 = this.p.b;
        r5.removeAllViews();
        final Button r6 = new Button(r4);
        r6.setGravity(17);
        r6.setTextSize(16.0f);
        r6.setPadding(i5.A(), i5.g(), i5.A(), i5.g());
        n(r4, r6);
        com.larus.utils.e1.d(r6, new o0(this, r4, r8, r6));
        r5.addView(r6, new FrameLayout.LayoutParams(-1, -2));
        return;
    L19:
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final void setupViews(Message r6) {
        FormMsgData r0 = this.q;
        boolean r1 = false;
        if (r0 == null) goto L9;
        String r2 = r0.getTitle();
        if (r2 == null) goto L9;
        if (com.larus.utils.o0.d(r2) != true) goto L9;
        boolean r3 = true;
    L10:
        String r4 = null;
        if (r3 == false) goto L17;
        TextView r5 = this.p.e;
        FormMsgData r7 = this.q;
        if (r7 == null) goto L15;
        String r8 = r7.getTitle();
    L16:
        r5.setText(r8);
        goto L17
    L15:
        r8 = null;
    L17:
        FormMsgData r9 = this.q;
        if (r9 == null) goto L24;
        String r10 = r9.getSubTitle();
        if (r10 == null) goto L24;
        if (com.larus.utils.o0.d(r10) != true) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L29;
        TextView r11 = this.p.d;
        FormMsgData r12 = this.q;
        if (r12 == null) goto L28;
        r4 = r12.getSubTitle();
    L28:
        r11.setText(r4);
    L29:
        setupFormItems(r6);
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final void g(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        FormMsgData.a r0 = FormMsgData.Companion;
        String r1 = r7.getContent();
        r0.getClass();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        FormMsgData r3 = null;
        if (r2 == false) goto L18;
    L16:
        FLogger.a.d("FormMsgBox", "bindData: formMsgData = " + r3);
        this.q = r3;
        setupViews(r7);
        return;
    L18:
        r3 = (FormMsgData) new Gson().fromJson(r1, FormMsgData.class);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("FormMsgData", "convert from content = " + r1 + ", but exception ", e);
        goto L16
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void o(ActiveStatus r9) {
        FormMsgData r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        List<FormShowItem> r1 = r0.getShowItems();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return;
    L15:
        if (((FormShowItem) ListProtector.get(r0.getShowItems(), 0)).getActiveStatus() != r9.getStatus()) goto L17;
        return;
    L17:
        this.q = FormMsgData.copy$default(r0, null, null, CollectionsKt.listOf(FormShowItem.copy$default((FormShowItem) ListProtector.get(r0.getShowItems(), 0), null, null, r9.getStatus(), 3, null)), null, 11, null);
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final void setClickListener(Function1<? super Boolean, Unit> r1) {
        this.r = r1;
    }

    public final void n(Context r6, Button r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L6;
        return;
    L6:
        FormMsgData r0 = this.q;
        if (r0 == null) goto L9;
        List<FormShowItem> r1 = r0.getShowItems();
    L10:
        List<FormShowItem> r2 = r1;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        return;
    L19:
        FormMsgData r4 = this.q;
        if (r4 == null) goto L39;
        List<FormShowItem> r5 = r4.getShowItems();
        if (r5 == null) goto L40;
        FormShowItem r8 = (FormShowItem) ListProtector.get(r5, 0);
        if (r8 == null) goto L43;
        FLogger.a.d("FormMsgBox", "dispatchButtonStatus: formShowItem = " + r8);
        int r9 = r8.getActiveStatus();
        if (r9 != ActiveStatus.ACTIVE.getStatus()) goto L33;
        if (com.larus.utils.o0.d(r8.getButtonActiveValue()) == false) goto L31;
        r7.setText(r8.getButtonActiveValue());
    L31:
        r7.setTextColor(ContextCompat.getColor(r6, v19.c.b(2130972082, r6, 2131103146)));
        com.larus.utils.e1.t(r7, i5.r0(), v19.c.b(2130970529, null, 2131102529));
        com.larus.utils.e1.t(this.p.b, i5.r0(), v19.c.b(2130970529, null, 2131102529));
        this.p.b.setAlpha(0.4f);
        return;
    L33:
        if (r9 == ActiveStatus.INACTIVE.getStatus()) goto L35;
        return;
    L35:
        if (com.larus.utils.o0.d(r8.getButtonInactiveValue()) == false) goto L37;
        r7.setText(r8.getButtonInactiveValue());
    L37:
        r7.setTextColor(ContextCompat.getColor(r6, 2131103298));
        com.larus.utils.e1.t(r7, i5.r0(), v19.c.b(2130972123, null, 2131103203));
        com.larus.utils.e1.t(this.p.b, i5.r0(), v19.c.b(2130972123, null, 2131103203));
        this.p.b.setAlpha(1.0f);
        return;
    L43:
        return;
    L40:
        return;
    L39:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    L9:
        r1 = null;
        goto L10
    }
}
