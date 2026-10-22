package com.bytedance.android.live.liveinteract.voicechat.fight.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import ck0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.GradientTextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/fight/view/FightTitleTextView;", "Lcom/bytedance/android/livesdk/widget/GradientTextView;", "", "text", "", "setPkTitle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FightTitleTextView extends GradientTextView {
    public final Pattern d;
    public final Pattern e;
    public b f;
    public b g;

    public static final class a {
    }

    static {
    }

    public FightTitleTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = PatternProtector.compile("[^\\d]+");
        this.e = PatternProtector.compile("[\\d]+");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPkTitle(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L39:
        setText(r8);
        return;
    L5:
        if (this.f == null) goto L39;
        if (this.g == null) goto L39;
        if (r8 != null) goto L11;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L39;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r8);
        Matcher r3 = this.d.matcher(r8);     // Catch: Exception -> L36
        if (r3 != null) goto L25;
        return;
    L25:
        Matcher r9 = this.e.matcher(r8);     // Catch: Exception -> L36
        if (r9 != null) goto L29;
        return;
    L29:
        if (r3.find() == false) goto L32;
        b r4 = this.f;     // Catch: Exception -> L36
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L36
        r2.setSpan(r4.a(), r3.start(0), r3.end(0), 17);     // Catch: Exception -> L36
    L32:
        if (r9.find() == false) goto L34;
        b r5 = this.g;     // Catch: Exception -> L36
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L36
        r2.setSpan(r5.a(), r9.start(0), r9.end(0), 17);     // Catch: Exception -> L36
        goto L32
    L34:
        setText(r2);     // Catch: Exception -> L36
        return;
    L36:
        e = move-exception;
        ALogger.e("FightTitleTextView", "setPkTitle make exception: " + e.getMessage());
        return;
    L11:
        if (TextUtils.isEmpty(r8) == true) goto L18;
        if (this.d.matcher(r8).find() == false) goto L18;
        if (this.e.matcher(r8).find() == false) goto L18;
        r1 = true;
        goto L19
    }

    public FightTitleTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.d = PatternProtector.compile("[^\\d]+");
        this.e = PatternProtector.compile("[\\d]+");
    }
}
