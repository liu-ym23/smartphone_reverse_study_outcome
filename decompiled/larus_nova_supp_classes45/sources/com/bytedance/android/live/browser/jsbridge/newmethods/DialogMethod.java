package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "dialog")
public final class DialogMethod extends com.bytedance.ies.web.jsbridge2.f<a, b> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/DialogMethod$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "title", "g", "text", "f", "leftButtonText", "b", "leftButtonTextColor", "c", "rightButtonText", "d", "rightButtonTextColor", "e", "", "cornerRadius", "Ljava/lang/Float;", "a", "()Ljava/lang/Float;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("corner_radius")
        private final Float cornerRadius;

        @SerializedName("left_button_text")
        private final String leftButtonText;

        @SerializedName("left_button_text_color")
        private final String leftButtonTextColor;

        @SerializedName("right_button_text")
        private final String rightButtonText;

        @SerializedName("right_button_text_color")
        private final String rightButtonTextColor;

        @SerializedName("text")
        private final String text;

        @SerializedName("title")
        private final String title;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L22;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.text, r4.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.leftButtonText, r4.leftButtonText) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.leftButtonTextColor, r4.leftButtonTextColor) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.rightButtonText, r4.rightButtonText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.rightButtonTextColor, r4.rightButtonTextColor) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.cornerRadius, r4.cornerRadius) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.title;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.text;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.leftButtonText;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.leftButtonTextColor;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.rightButtonText;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            String r21 = this.rightButtonTextColor;
            if (r21 == null) goto L29;
            int r22 = r21.hashCode();
        L30:
            int r23 = (r19 + r22) * 31;
            Float r24 = this.cornerRadius;
            if (r24 == null) goto L34;
            r1 = r24.hashCode();
        L34:
            return r23 + r1;
        L29:
            r22 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", title=" + this.title + ", text=" + this.text + ", leftButtonText=" + this.leftButtonText + ", leftButtonTextColor=" + this.leftButtonTextColor + ", rightButtonText=" + this.rightButtonText + ", rightButtonTextColor=" + this.rightButtonTextColor + ", cornerRadius=" + this.cornerRadius + ")";
        }

        public final Float a() {
            return this.cornerRadius;
        }

        public final String b() {
            return this.leftButtonText;
        }

        public final String c() {
            return this.leftButtonTextColor;
        }

        public final String d() {
            return this.rightButtonText;
        }

        public final String e() {
            return this.rightButtonTextColor;
        }

        public final String f() {
            return this.text;
        }

        public final String g() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/DialogMethod$b;", "", "", "code", "I", "getCode", "()I", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("action")
        private final String action;

        @SerializedName("code")
        private final int code;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.code == r4.code) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.action, r4.action) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.code * 31;
            String r1 = this.action;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "Result(code=" + this.code + ", action=" + this.action + ")";
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.code = 1;
            this.action = r2;
        }
    }

    public final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function2 a;

        public c(Function2 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final /* synthetic */ void onClick(DialogInterface r2, int r3) {
            this.a.invoke(r2, Integer.valueOf(r3));
        }
    }

    public final void onTerminate() {
    }

    public DialogMethod() {
    }

    public final void invoke(Object r4, CallContext r5) {
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = r6.getType();     // Catch: Throwable -> L11
        if (r0.hashCode() == 951117504) goto L7;
    L9:
        finishWithFailure();     // Catch: Throwable -> L11
    L14:
        return;
    L7:
        if (r0.equals("confirm") == false) goto L9;
        k(r6, r5.getContext());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        finishWithFailure(th);
        com.bytedance.android.livesdk.log.b0 r7 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r8 = th.getStackTrace();
        r7.getClass();
        com.bytedance.android.live.core.log.g.m(5, r8);
    }

    public final void k(final a r6, Context r7) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = DialogMethod$showConfirmDialog$dismissFunc$1.INSTANCE;
        if (((Boolean) com.bytedance.android.livesdk.h5.a.getValue()).booleanValue() == true) goto L5;
    L7:
        com.bytedance.android.livesdk.widget.x0.b r1 = new com.bytedance.android.livesdk.widget.x0.b(r7, 4);
        String r8 = r6.g();
        if (r8 == null) goto L10;
        r1.a.c = r8;
    L10:
        String r9 = r6.f();
        if (r9 == null) goto L13;
        r1.a.d = r9;
    L13:
        Float r11 = r6.a();
        if (r11 == null) goto L16;
        r1.setCornerRadius(r11.floatValue());
    L16:
        r1.a.k = false;
        j(r1, 0, r6.d(), r6.e(), new DialogMethod$showConfirmDialog$$inlined$apply$lambda$1(this, r6, r0));
        j(r1, 1, r6.b(), r6.c(), new DialogMethod$showConfirmDialog$$inlined$apply$lambda$2(this, r6, r0));
        final com.bytedance.android.livesdk.widget.x0 r12 = r1.n();
        r0.element = new DialogMethod$showConfirmDialog$1(r12);
        return;
    L5:
        if ((r7 instanceof Activity) == true) goto L7;
        r7 = com.bytedance.android.live.core.utils.a.d();
        goto L7
    }

    public static void j(com.bytedance.android.livesdk.widget.x0.b r3, int r4, String r5, String r6, Function2 r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L14;
        SpannableString r1 = new SpannableString(r5);
        if (r6 == null) goto L11;
        r1.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(r6)), 0, r1.length(), 33);
    L11:
        r3.j(r4, r1, new c(r7));
        return;
    L14:
        return;
    L6:
        r0 = false;
        goto L7
    }
}
