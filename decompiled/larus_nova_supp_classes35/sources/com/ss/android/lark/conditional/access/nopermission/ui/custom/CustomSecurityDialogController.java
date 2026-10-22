package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.conditional.access.databinding.UdDialogSecurityCustomContentBinding;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.nopermission.manager.DialogButtonTypeFunction;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.DialogUserScopeView;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CustomSecurityDialogController extends UDDialogController {
    public static final /* synthetic */ int c = 0;
    public final Activity a;
    public final UdDialogSecurityCustomContentBinding b;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ UDDialog a;
        public final /* synthetic */ CustomSecurityDialogController b;

        public static final class a implements Runnable {
            public final /* synthetic */ CustomSecurityDialogController a;
            public final /* synthetic */ ViewGroup b;

            public a(CustomSecurityDialogController r1, ViewGroup r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                CustomSecurityDialogController r0 = this.a;
                if (Build.VERSION.SDK_INT < 30) goto L5;
                int r1 = r0.a.getWindowManager().getCurrentWindowMetrics().getBounds().height();
            L6:
                int r2 = (int) (r1 * 0.65f);
                ViewGroup.LayoutParams r3 = this.b.getChildAt(1).getLayoutParams();
                if (this.b.getHeight() <= r2) goto L10;
                r3.height = (r2 - this.b.findViewById(2131391799).getHeight()) - this.b.findViewById(2131391796).getHeight();
                this.b.getChildAt(1).setLayoutParams(r3);
                return;
            L10:
                return;
            L5:
                r1 = r0.a.getWindowManager().getDefaultDisplay().getHeight();
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(UDDialog r1, CustomSecurityDialogController r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r3) {
            Window r4 = this.a.getWindow();
            if (r4 == null) goto L5;
            ViewGroup r5 = (ViewGroup) r4.findViewById(2131391805);
        L6:
            if (r5 == null) goto L9;
            r5.post(new a(this.b, r5));
            return;
        L9:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ UDDialog a;
        public final /* synthetic */ CustomSecurityDialogController b;
        public final /* synthetic */ CustomDisplayHandler c;
        public final /* synthetic */ boolean d;

        public c(UDDialog r1, CustomSecurityDialogController r2, CustomDisplayHandler r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            UDDialog r0 = this.a;
            CustomSecurityDialogController r1 = this.b;
            CustomDisplayHandler r2 = this.c;
            r1.getClass();
            if (Intrinsics.areEqual(r2.style, "secondary") == false) goto L5;
            int r3 = 2131391778;
        L6:
            UDButton r4 = r0.findViewById(r3);
            if (r4 != null) goto L9;
            return;
        L9:
            String r5 = this.c.name;
            r4.setEnabled(!this.d);
            if (this.d == false) goto L12;
            com.larksuite.component.universe_design.button.d r6 = new com.larksuite.component.universe_design.button.d();
            ((com.larksuite.component.universe_design.button.a) r6).b = r5;
            r6.j = Integer.valueOf(r4.getCurrentTextColor());
            com.larksuite.component.universe_design.button.e.g(r4, r6);
            return;
        L12:
            com.larksuite.component.universe_design.button.e.a r7 = com.larksuite.component.universe_design.button.e.a;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            com.larksuite.component.universe_design.button.e.b(r4, r5);
            return;
        L5:
            r3 = 2131391777;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final View onCreateContent() {
        return this.b.a;
    }

    public final Activity getActivity() {
        return this.a;
    }

    public CustomSecurityDialogController(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        super(r4);
        this.a = r4;
        ConstraintLayout r5 = LayoutInflater.from(getContext()).inflate(2131568093, null, false);
        int r0 = 2131378644;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131378644);
        if (r1 == null) goto L9;
        r0 = 2131390944;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r5, 2131390944);
        if (r2 == null) goto L9;
        this.b = new UdDialogSecurityCustomContentBinding(r5, r1, r2);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r11, final UDDialog r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "dialog");
        if ((r11 instanceof com.ss.android.lark.conditional.access.nopermission.ui.q) == false) goto L5;
        com.ss.android.lark.conditional.access.nopermission.ui.q r0 = (com.ss.android.lark.conditional.access.nopermission.ui.q) r11;
        CustomDisplayTemplate r1 = r0.b();
        InternalSecurityAction r2 = r0.c();
    L6:
        super.apply(r11, r12);
        if (r1 == null) goto L62;
        if (r2 == null) goto L62;
        UserSession r3 = ((com.ss.android.lark.passportc.api.j) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.api.j.class)).b();
        setMAutoDismiss(false);
        if (r3 == null) goto L13;
        final DialogUserScopeView r4 = new DialogUserScopeView(r3, getContext());
        com.ss.android.lark.conditional.access.nopermission.ui.custom.a r5 = new CustomSecurityDialogController$apply$bthAction$1(r4, this, r12);
    L14:
        setMActionButtonsOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
        String r6 = r1.title;
        String r7 = BuildConfig.FLAVOR;
        if (r6 != null) goto L18;
        r6 = BuildConfig.FLAVOR;
    L18:
        setMTitle(r6);
        setMTitleGravity(17);
        setMTitleSize(17);
        setMTitleTextColor(2131106622);
        r12.setOnShowListener(new b(r12, this));
        if (r1.text == null) goto L25;
        this.b.c.setVisibility(0);
        StringBuilder r13 = new StringBuilder(r1.text);
        String r8 = r1.richText;
        if (r8 == null) goto L24;
        r7 = r8;
    L24:
        r13.append(r7);
        String r14 = r13.toString();
        TextView r9 = this.b.c;
        r9.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence r15 = DisplayUtilsKt.f(r14, r9.getContext(), CustomSecurityDialogController$handleRichText$cs$1.INSTANCE);
        bab.b.a(r9);
        r9.setText(r15);
        r9.setTextColor(r9.getResources().getColor(2131106607));
        r9.setTextSize(14.0f);
    L25:
        List r16 = r1.content_list;
        if (r16 == null) goto L28;
        int r17 = r16.size();
    L29:
        List r10 = r1.content_list;
        if (r10 == null) goto L42;
        Iterator r18 = r10.iterator();
        int r19 = 0;
    L33:
        if (r18.hasNext() == false) goto L42;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();
    L37:
        CustomDisplayContent r22 = (CustomDisplayContent) r20;
        this.b.b.setVisibility(0);
        if (r19 >= (r17 - 1)) goto L40;
        int r23 = 8;
    L41:
        LinearLayout r24 = this.b.b;
        u8b.a r25 = new u8b.a(getContext(), r23);
        Intrinsics.checkNotNull(r22);
        r25.b(r22, r2, r5, CustomDisplayPageUiMode.LARK);
        r24.addView(r25);
        r19 = r21;
        goto L33
    L40:
        r23 = 0;
    L42:
        List r110 = r1.handler_list;
        if (r110 == null) goto L76;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L46:
        if (r112.hasNext() == false) goto L50;
        Object r26 = r112.next();
        CustomDisplayHandler r27 = (CustomDisplayHandler) r26;
        Intrinsics.checkNotNull(r27);
        if (com.ss.android.lark.conditional.access.utils.b.a(r27) == false) goto L46;
        r111.add(r26);
        goto L46
    L50:
        Iterator r113 = r111.iterator();
    L52:
        if (r113.hasNext() == false) goto L78;
        CustomDisplayHandler r114 = (CustomDisplayHandler) r113.next();
        List r28 = getMActionButtons();
        Intrinsics.checkNotNull(r114);
        Context r29 = getContext();
        Intrinsics.checkNotNullParameter(r114, "<this>");
        Intrinsics.checkNotNullParameter(r5, "btnAction");
        Intrinsics.checkNotNullParameter(r2, "secAction");
        Intrinsics.checkNotNullParameter(r29, "context");
        UDBaseDialogBuilder.ActionBuilder r30 = new UDBaseDialogBuilder.ActionBuilder();
        r30.setText(r114.name);
        if (Intrinsics.areEqual(r114.style, "secondary") == false) goto L56;
        int r31 = 2131391778;
    L57:
        r30.setActionLayoutId(r31);
        if (Intrinsics.areEqual(r114.style, "primaryRed") == false) goto L60;
        r30.setTextColor(UDColorUtils.getColor(r29, 2131102096));
    L60:
        r30.onClickListener(new b0(r5, r114, r2, r29));
        r28.add(r30.build());
        goto L52
    L56:
        r31 = 2131391777;
        goto L57
    L78:
        return;
    L76:
        return;
    L28:
        r17 = 0;
        goto L29
    L13:
        r5 = DialogButtonTypeFunction.a;
    L62:
        if (getMMessage() == null) goto L77;
        this.b.c.setVisibility(0);
        this.b.c.setText(getMMessage());
        this.b.c.setGravity(8388611);
        return;
    L77:
        return;
    L5:
        r1 = null;
        r2 = null;
        goto L6
    }

    public final void b(UDDialog r5, CustomDisplayHandler r6, boolean r7) {
        Window r0 = r5.getWindow();
        if (r0 == null) goto L13;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        if (r1 == null) goto L14;
        r1.post(new c(r5, this, r6, r7));
        return;
    L14:
        return;
    }
}
