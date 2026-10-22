package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006."}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/DialogBuilder;", "", "context", "Landroid/content/Context;", Constant.TITLE, "", "message", "positiveBtnText", "positiveClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeBtnText", "negativeClickListener", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "cancelOnTouchOutside", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Z)V", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "getCancelOnTouchOutside", "()Z", "getContext", "()Landroid/content/Context;", "getMessage", "()Ljava/lang/String;", "getNegativeBtnText", "getNegativeClickListener", "()Landroid/content/DialogInterface$OnClickListener;", "getPositiveBtnText", "getPositiveClickListener", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DialogBuilder {
    private final DialogInterface.OnCancelListener cancelListener;
    private final boolean cancelOnTouchOutside;
    private final Context context;
    private final String message;
    private final String negativeBtnText;
    private final DialogInterface.OnClickListener negativeClickListener;
    private final String positiveBtnText;
    private final DialogInterface.OnClickListener positiveClickListener;
    private final String title;

    public DialogBuilder(Context r5, String r10, String r11, String r12, DialogInterface.OnClickListener r13, String r14, DialogInterface.OnClickListener r15, DialogInterface.OnCancelListener r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.title = r10;
        this.message = r11;
        this.positiveBtnText = r12;
        this.positiveClickListener = r13;
        this.negativeBtnText = r14;
        this.negativeClickListener = r15;
        this.cancelListener = r16;
        this.cancelOnTouchOutside = r17;
    }

    public static /* synthetic */ DialogBuilder copy$default(DialogBuilder r10, Context r11, String r12, String r13, String r14, DialogInterface.OnClickListener r15, String r16, DialogInterface.OnClickListener r17, DialogInterface.OnCancelListener r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Context r5 = r10.context;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r22 = r10.title;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r23 = r10.message;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r24 = r10.positiveBtnText;
    L19:
        if ((r20 & 16) == 0) goto L21;
        DialogInterface.OnClickListener r25 = r10.positiveClickListener;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r26 = r10.negativeBtnText;
    L27:
        if ((r20 & 64) == 0) goto L29;
        DialogInterface.OnClickListener r27 = r10.negativeClickListener;
    L31:
        if ((r20 & 128) == 0) goto L33;
        DialogInterface.OnCancelListener r28 = r10.cancelListener;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r29 = r10.cancelOnTouchOutside;
    L39:
        return r10.copy(r5, r22, r23, r24, r25, r26, r27, r28, r29);
    L37:
        r29 = r19;
        goto L39
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.positiveBtnText;
    }

    public final DialogInterface.OnClickListener component5() {
        return this.positiveClickListener;
    }

    public final String component6() {
        return this.negativeBtnText;
    }

    public final DialogInterface.OnClickListener component7() {
        return this.negativeClickListener;
    }

    public final DialogInterface.OnCancelListener component8() {
        return this.cancelListener;
    }

    public final boolean component9() {
        return this.cancelOnTouchOutside;
    }

    public final DialogBuilder copy(Context r12, String r13, String r14, String r15, DialogInterface.OnClickListener r16, String r17, DialogInterface.OnClickListener r18, DialogInterface.OnCancelListener r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "context");
        return new DialogBuilder(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DialogBuilder) == true) goto L8;
        return false;
    L8:
        DialogBuilder r10 = (DialogBuilder) r5;
        if (Intrinsics.areEqual(this.context, r10.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r10.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.positiveBtnText, r10.positiveBtnText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.positiveClickListener, r10.positiveClickListener) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.negativeBtnText, r10.negativeBtnText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.negativeClickListener, r10.negativeClickListener) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cancelListener, r10.cancelListener) == true) goto L33;
        return false;
    L33:
        if (this.cancelOnTouchOutside == r10.cancelOnTouchOutside) goto L35;
        return false;
    L35:
        return true;
    }

    public final DialogInterface.OnCancelListener getCancelListener() {
        return this.cancelListener;
    }

    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getNegativeBtnText() {
        return this.negativeBtnText;
    }

    public final DialogInterface.OnClickListener getNegativeClickListener() {
        return this.negativeClickListener;
    }

    public final String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    public final DialogInterface.OnClickListener getPositiveClickListener() {
        return this.positiveClickListener;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int r5 = this.context.hashCode() * 31;
        String r10 = this.title;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.message;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.positiveBtnText;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        DialogInterface.OnClickListener r20 = this.positiveClickListener;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.negativeBtnText;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        DialogInterface.OnClickListener r26 = this.negativeClickListener;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        DialogInterface.OnCancelListener r29 = this.cancelListener;
        if (r29 == null) goto L31;
        r11 = r29.hashCode();
    L31:
        return Boolean.hashCode(this.cancelOnTouchOutside) + ((r28 + r11) * 31);
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("DialogBuilder(context=");
        r5.append(this.context);
        r5.append(", title=");
        r5.append(this.title);
        r5.append(", message=");
        r5.append(this.message);
        r5.append(", positiveBtnText=");
        r5.append(this.positiveBtnText);
        r5.append(", positiveClickListener=");
        r5.append(this.positiveClickListener);
        r5.append(", negativeBtnText=");
        r5.append(this.negativeBtnText);
        r5.append(", negativeClickListener=");
        r5.append(this.negativeClickListener);
        r5.append(", cancelListener=");
        r5.append(this.cancelListener);
        r5.append(", cancelOnTouchOutside=");
        return a.w(r5, this.cancelOnTouchOutside, ')');
    }

    public /* synthetic */ DialogBuilder(Context r10, String r11, String r12, String r13, DialogInterface.OnClickListener r14, String r15, DialogInterface.OnClickListener r16, DialogInterface.OnCancelListener r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        DialogInterface.OnCancelListener r5 = null;
        if ((r19 & 2) == 0) goto L5;
        String r21 = null;
    L7:
        if ((r19 & 4) == 0) goto L9;
        String r22 = null;
    L11:
        if ((r19 & 8) == 0) goto L13;
        String r23 = null;
    L15:
        if ((r19 & 16) == 0) goto L17;
        DialogInterface.OnClickListener r24 = null;
    L19:
        if ((r19 & 32) == 0) goto L21;
        String r25 = null;
    L23:
        if ((r19 & 64) == 0) goto L25;
        DialogInterface.OnClickListener r26 = null;
    L27:
        if ((r19 & 128) != 0) goto L31;
        r5 = r17;
    L31:
        if ((r19 & 256) == 0) goto L33;
        boolean r27 = true;
    L34:
        this(r10, r21, r22, r23, r24, r25, r26, r5, r27);
        return;
    L33:
        r27 = r18;
        goto L34
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r21 = r11;
        goto L7
    }
}
