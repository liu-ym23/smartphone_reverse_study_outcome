package com.larksuite.component.card.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Layout;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.larksuite.component.card.action.a c;
    public final /* synthetic */ Function0<Unit> d;

    public static final class a implements UDBaseDialogBuilder.c {
        public final /* synthetic */ com.larksuite.component.card.action.a a;

        /* JADX INFO: renamed from: com.larksuite.component.card.action.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC0017a implements Runnable {
            public final /* synthetic */ com.larksuite.component.card.action.a a;
            public final /* synthetic */ TextView b;

            public RunnableC0017a(com.larksuite.component.card.action.a r1, TextView r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.larksuite.component.card.action.a r0 = this.a;     // Catch: Throwable -> L18
                TextView r1 = this.b;     // Catch: Throwable -> L18
                int r2 = com.larksuite.component.card.action.a.a;     // Catch: Throwable -> L18
                r0.getClass();     // Catch: Throwable -> L18
                Layout r3 = r1.getLayout();     // Catch: Throwable -> L18
                if (r3 == null) goto L5;
                int r4 = r3.getLineCount();     // Catch: Throwable -> L18
            L6:
                int r5 = 1;
                if (r4 < 3) goto L9;
                boolean r6 = true;
            L10:
                if (r6 == false) goto L12;
                r5 = 8388611;
            L12:
                r1.setGravity(r5);     // Catch: Throwable -> L18
                if (r6 == false) goto L15;
                int r7 = 5;
            L16:
                r1.setTextAlignment(r7);     // Catch: Throwable -> L18
                return;
            L15:
                r7 = 4;
                goto L16
            L9:
                r6 = false;
                goto L10
            L5:
                r4 = r1.getLineCount();     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L22;
                return;
            L22:
                throw th;
            }
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
        public final void beforeCreate(UDDialog r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
        }

        public a(com.larksuite.component.card.action.a r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
        public final void a(UDDialog r3) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            TextView r4 = (TextView) r3.findViewById(2131391794);
            if (r4 != null) goto L6;
            Log.i("CardToastInterceptor", "messageTextViewNotFound");
            return;
        L6:
            r4.post(new RunnableC0017a(this.a, r4));
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.card.action.b$b, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC0018b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public DialogInterfaceOnClickListenerC0018b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.invoke();
            Log.i("CardToastInterceptor", "universal card jump");
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Log.i("CardToastInterceptor", "universal card cancel");
        }
    }

    public b(Activity r1, String r2, com.larksuite.component.card.action.a r3, Function0<Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        new UDDialogBuilder(this.a).message(this.b).messageTextSize(17).lifecycleCallback(new a(this.c)).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL).addActionButton(2131391777, 2131890305, new DialogInterfaceOnClickListenerC0018b(this.d)).addActionButton(2131391778, 2131890304, c.a).cancelOnTouchOutside(false).show();
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
