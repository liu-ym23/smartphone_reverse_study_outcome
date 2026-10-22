package com.ss.android.lark.inline.ai.creationai;

import android.R;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContentInfo;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.design.edittext.SCUDEditText;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/CreationAIEditText;", "Lcom/suite/lark/emm/design/edittext/SCUDEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "callback", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;", "setCallback", "", "onTextContextMenuItem", "", "cid", "getScene", "Lcom/suite/lark/emm/impl/clipboard/SCClipboardScene;", "encryptId", "", "paste", "min", "max", "withFormatting", "clipData", "Landroid/content/ClipData;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CreationAIEditText extends SCUDEditText {
    public vlb.b H0;

    public static final class a {
    }

    static {
    }

    public CreationAIEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public CreationAIEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public CreationAIEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTextContextMenuItem(int r12) {
        Editable r0 = getText();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length();
    L7:
        if (isFocused() == false) goto L9;
        int r3 = getSelectionStart();
        int r4 = getSelectionEnd();
        int r5 = Math.max(0, Math.min(r3, r4));
        r2 = Math.max(0, Math.max(r3, r4));
    L10:
        String r7 = "";
        if (r12 == 16908337) goto L26;
        switch(r12) {
            case 16908320: goto L15;
            case 16908321: goto L15;
            case 16908322: goto L26;
            default: goto L14;
        };
    L15:
        Editable r6 = getText();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        CharSequence r8 = ((SpannableStringBuilder) r6).subSequence(r5, r2);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r9 = (SpannableStringBuilder) r8;
        int r10 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        boc.b r11 = SCClipboardProvider.a();
        vlb.b r13 = this.H0;
        if (r13 == null) goto L19;
        String r14 = r13.g();
        if (r14 == null) goto L19;
    L20:
        Log.i("CreationAIEditText", "onActionItemClicked encryptId: ".concat(r14));
        if (TextUtils.isEmpty(r14) == false) goto L23;
        SCClipboardScene r15 = SCClipboardScene.SCENE_DEFAULT;
    L24:
        r11.Q0(r15);
        r11.O0(SCClipboardScene.SCENE_DISABLE_COPY);
        super.onTextContextMenuItem(r12);
        ClipData r16 = ClipData.newPlainText("", r9);
        Intrinsics.checkNotNull(r16);
        r11.M0(r16, new Token("LARK-PSDA-ccm_android_space_edit_text_base_set_clipboard"));
        return true;
    L23:
        SCClipboardScene r17 = SCClipboardScene.SCENE_ENCRYPT;
        r17.setParam(r14);
        r15 = r17;
    L19:
        r14 = "";
        goto L20
    L14:
        return super.onTextContextMenuItem(r12);
    L26:
        int r18 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        boc.b r19 = SCClipboardProvider.a();
        vlb.b r20 = this.H0;
        if (r20 == null) goto L32;
        String r21 = r20.g();
        if (r21 == null) goto L32;
        r7 = r21;
    L32:
        Log.i("CreationAIEditText", "onActionItemClicked encryptId: ".concat(r7));
        if (TextUtils.isEmpty(r7) == false) goto L35;
        SCClipboardScene r22 = SCClipboardScene.SCENE_DEFAULT;
    L36:
        r19.Q0(r22);
        ClipData r23 = r19.T0(new Token("LARK-PSDA-ccm_android_space_edit_text_base_get_clipboard"));     // Catch: SensitiveAPIException -> L39
    L42:
        if (r12 == 16908322) goto L44;
    L46:
        if (r12 != 16908322) goto L48;
        int r110 = 1;
    L49:
        if (r23 != null) goto L52;
    L74:
        return true;
    L52:
        if (Build.VERSION.SDK_INT < 31) goto L54;
        performReceiveContent(new ContentInfo.Builder(r23, 1).setFlags(r110 ^ 1).build());
        goto L74
    L54:
        int r24 = r23.getItemCount();
        boolean r25 = false;
    L55:
        if (r1 >= r24) goto L74;
        if (r110 == 0) goto L58;
        CharSequence r26 = r23.getItemAt(r1).coerceToStyledText(getContext());
    L61:
        if (r26 == null) goto L73;
        if (r25 == true) goto L67;
        Selection.setSelection(getText(), r2);
        Editable r27 = getText();
        if (r27 == null) goto L66;
        r27.replace(r5, r2, r26);
    L66:
        r25 = true;
        goto L73
    L67:
        Editable r28 = getText();
        if (r28 == null) goto L70;
        r28.insert(getSelectionEnd(), "\n");
    L70:
        Editable r29 = getText();
        if (r29 == null) goto L73;
        r29.insert(getSelectionEnd(), r26);
    L73:
        r1 = r1 + 1;
        goto L55
    L58:
        r26 = r23.getItemAt(r1).coerceToText(getContext());
        if ((r26 instanceof Spanned) == false) goto L61;
        r26 = r26.toString();
        goto L61
    L48:
        r110 = 0;
        goto L49
    L44:
        if (Build.VERSION.SDK_INT < 23) goto L46;
        r12 = R.id.pasteAsPlainText;
    L39:
        e = move-exception;
        Log.e("CreationAIEditText", "getPrimaryClipUnsafe error. " + e.getMessage());
        r23 = null;
        goto L42
    L35:
        r22 = SCClipboardScene.SCENE_ENCRYPT;
        r22.setParam(r7);
        goto L36
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L7
    }

    public final void setCallback(vlb.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.H0 = r2;
    }

    public CreationAIEditText(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
    }
}
