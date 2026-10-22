package com.larksuite.component.card.plugin;

import android.content.DialogInterface;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowConfirmPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showConfirm", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowConfirmPlugin$ConfirmRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "Companion", "ConfirmRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowConfirmPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String TAG = "ShowConfirmPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowConfirmPlugin$ConfirmRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "text", "getText", "setText", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ConfirmRequest extends LKBaseRequestModel {

        @JSONField(name = "text")
        private String text;

        @JSONField(name = "title")
        private String title;

        public ConfirmRequest() {
        }

        public final String getText() {
            return this.text;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setText(String r1) {
            this.text = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ConfirmRequest a;
        public final /* synthetic */ LKEvent b;
        public final /* synthetic */ j18.f<CallbackProcessResponse> c;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ j18.f<CallbackProcessResponse> a;

            public a(j18.f<CallbackProcessResponse> r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                CallbackProcessResponse r3 = new CallbackProcessResponse();
                n18.b r4 = g.a;
                r3.setApiErrNo(g.a);
                this.a.callback(r3);
            }
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.plugin.ShowConfirmPlugin$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0023b implements DialogInterface.OnClickListener {
            public final /* synthetic */ j18.f<CallbackProcessResponse> a;

            public DialogInterfaceOnClickListenerC0023b(j18.f<CallbackProcessResponse> r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                CallbackProcessResponse r3 = new CallbackProcessResponse();
                this.a.callback(r3);
            }
        }

        public b(ConfirmRequest r1, LKEvent r2, j18.f<CallbackProcessResponse> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            String r0 = this.a.getTitle();
            String r1 = "";
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            String r2 = this.a.getText();
            if (r2 == null) goto L9;
            r1 = r2;
        L9:
            new UDDialogBuilder(this.b.getContext()).title(r0).message(r1).addActionButton(2131391778, this.b.getContext().getText(2131891541), new a(this.c)).addActionButton(2131391777, this.b.getContext().getText(2131891623), new DialogInterfaceOnClickListenerC0023b(this.c)).show();
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
        Companion = new a();
    }

    public ShowConfirmPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"msgCardShowConfirm"})
    public final void showConfirm(LKEvent r3, ConfirmRequest r4, j18.f<CallbackProcessResponse> r5) {
        Intrinsics.checkNotNullParameter(r3, "lkEvent");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "invokeCallback");
        Log.d(TAG, "showConfirm " + r4);
        mz7.b.a(new b(r4, r3, r5));
    }
}
