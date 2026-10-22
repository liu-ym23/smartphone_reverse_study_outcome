package com.larus.bmhome.notification.viewholder;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NoticeButtonStyle;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import or8.r;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/RightJsonNotificationItemViewHolder;", "Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder;", "viewBinding", "Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;", "<init>", "(Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;)V", "screenWidth", "", "getRightButton", "Landroid/view/View;", "createRightTextView", "Landroid/widget/TextView;", "button", "Lcom/larus/bmhome/chat/resp/Button;", "createRightTextBgView", "Landroid/widget/FrameLayout;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RightJsonNotificationItemViewHolder extends AbstractNotificationItemViewHolder {
    public static final /* synthetic */ int m = 0;
    public final int l;

    @Override // com.larus.bmhome.notification.viewholder.AbstractNotificationItemViewHolder
    public final View V3() {
        Notice r0 = this.f;
        Integer r1 = null;
        if (r0 == null) goto L53;
        CommonNoticeData r2 = r0.getCommonNoticeData();
        if (r2 == null) goto L53;
        Button r3 = r2.getRightButton();
        if (r3 == null) goto L53;
        if (r3.getStyle() != NoticeButtonStyle.TEXT.getStyle()) goto L12;
    L13:
        String r4 = r3.getContent();
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
    L21:
        return null;
    L22:
        FrameLayout r6 = new FrameLayout(getContext());
        r6.setBackgroundResource(2131239361);
        e1.d(r6, new r(this));
        AppCompatTextView r7 = new AppCompatTextView(getContext());
        r7.setLayoutParams(new FrameLayout.LayoutParams(-2, i5.W()));
        r7.setGravity(17);
        r7.setTypeface(Typeface.DEFAULT_BOLD);
        r7.setPadding(i5.q(), 0, i5.q(), 0);
        Object r8 = r7.getContext().getString(2131906155);
        Notice r9 = this.f;
        if (r9 == null) goto L29;
        CommonNoticeData r10 = r9.getCommonNoticeData();
        if (r10 == null) goto L29;
        Button r11 = r10.getRightButton();
        if (r11 == null) goto L29;
        r1 = Integer.valueOf(r11.getStyle());
    L29:
        int r12 = NoticeButtonStyle.JSON.getStyle();
        if (r1 != null) goto L33;
    L45:
        String r13 = r3.getContent();
    L46:
        r7.setText(r13);
        r7.setMaxLines(1);
        r7.setEllipsize(TextUtils.TruncateAt.END);
        r7.setTextColor(r7.getContext().getResources().getColor(2131103136));
        r7.setMaxWidth((int) (((double) this.l) * 0.4d));
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(r7, i5.h(), i5.o(), i5.b(), 0);     // Catch: Exception -> L49
    L51:
        r6.addView(r7);
        return r6;
    L49:
        e = move-exception;
        r7.setTextSize(1, 15.0f);
        FLogger.a.e("RightTextNotificationItemViewHolder", "setAutoSizeTextTypeUniformWithConfiguration error:", e);
        goto L51
    L33:
        if (r1.intValue() != r12) goto L45;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L39
        Object r15 = new JSONObject(r3.getContent()).opt(ShareType.TEXT);     // Catch: Throwable -> L39
        if (r15 != null) goto L37;
        r15 = r8;
    L37:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L39
    L42:
        if (Result.exceptionOrNull-impl(r16) != null) goto L44;
        r8 = r16;
    L44:
        r13 = r8.toString();
    L39:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L16:
        if (r4.length() == 0) goto L19;
        r5 = false;
        goto L20
    L12:
        if (r3.getStyle() != NoticeButtonStyle.JSON.getStyle()) goto L21;
    L53:
        return null;
    }

    public RightJsonNotificationItemViewHolder(LarusItemNotificationDefaultBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.l = i.d(getContext());
    }
}
