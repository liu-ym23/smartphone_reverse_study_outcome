package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MultiPkTextView;", "Lcom/bytedance/android/livesdk/chatroom/view/NoPaddingTextView;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "setContent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiPkTextView extends NoPaddingTextView {
    public final Pattern a;
    public final Pattern b;
    public t c;
    public t d;

    public MultiPkTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = PatternProtector.compile("[^\\d]+");
        this.b = PatternProtector.compile("[\\d]+");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContent(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L60:
        setText(r8);
        return;
    L5:
        if (this.c == null) goto L60;
        if (this.d == null) goto L60;
        if (r8 != null) goto L11;
    L27:
        boolean r1 = false;
    L28:
        if (r1 == false) goto L60;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r8);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L33
        Object r4 = Result.constructor-impl(this.a.matcher(r8));     // Catch: Throwable -> L33
    L35:
        Object r5 = null;
        if (Result.isFailure-impl(r4) == false) goto L38;
        r4 = null;
    L38:
        Matcher r6 = (Matcher) r4;
        if (r6 != null) goto L64;
        return;
    L64:
        Object r9 = Result.constructor-impl(this.b.matcher(r8));     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r9) == true) goto L49;
        r5 = r9;
    L49:
        Matcher r7 = (Matcher) r5;
        if (r7 != null) goto L53;
        return;
    L53:
        if (r6.find() == false) goto L56;
        t r10 = this.c;
        Intrinsics.checkNotNull(r10);
        r2.setSpan(r10.a(), r6.start(0), r6.end(0), 17);
    L56:
        if (r7.find() == false) goto L58;
        t r11 = this.d;
        Intrinsics.checkNotNull(r11);
        r2.setSpan(r11.a(), r7.start(0), r7.end(0), 17);
        goto L56
    L58:
        setText(r2);
        return;
    L43:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L11:
        if (TextUtils.isEmpty(r8) == true) goto L27;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        if (this.a.matcher(r8).find() == true) goto L16;
    L18:
        boolean r16 = false;
    L19:
        Object r17 = Result.constructor-impl(Boolean.valueOf(r16));     // Catch: Throwable -> L21
    L23:
        Boolean r18 = Boolean.FALSE;
        if (Result.isFailure-impl(r17) == false) goto L26;
        r17 = r18;
    L26:
        r1 = ((Boolean) r17).booleanValue();
        goto L28
    L16:
        if (this.b.matcher(r8).find() == false) goto L18;
        r16 = true;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public MultiPkTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = PatternProtector.compile("[^\\d]+");
        this.b = PatternProtector.compile("[\\d]+");
    }
}
