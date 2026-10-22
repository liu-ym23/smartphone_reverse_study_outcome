package com.larus.uaigc.chat.markdown;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import fz9.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import usc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJP\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0018\u00010 JR\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0018\u00010 H$J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "absBindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "message", "Lcom/larus/im/bean/message/Message;", "markDownData", "Lcom/larus/uaigc/chat/markdown/bean/CreationPlaceholderData;", "maxWidth", "", "payload", "", "", "", "bindData", "onRecycle", "", "ensureLifecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class AbsCustomCreationDataWidget extends FrameLayout implements LifecycleOwner {
    public boolean a;
    public LifecycleRegistry b;

    public abstract Size b(TextView r1, Spanned r2, e r3, Message r4, b r5, int r6, Map<String, ? extends Object> r7);

    public void c() {
        LifecycleRegistry r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r0 = null;
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.a = true;
    }

    public Lifecycle getLifecycle() {
        LifecycleRegistry r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r0;
    }

    public AbsCustomCreationDataWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public AbsCustomCreationDataWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
    }

    public final Size a(TextView r3, Spanned r4, e r5, Message r6, b r7, int r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "span");
        if (this.a == false) goto L9;
        this.a = false;
        LifecycleRegistry r0 = new LifecycleRegistry(this);
        this.b = r0;
        r0.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r1 = this.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r1 = null;
    L7:
        r1.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L9:
        return b(r3, r4, r5, r6, r7, r8, r9);
    }
}
