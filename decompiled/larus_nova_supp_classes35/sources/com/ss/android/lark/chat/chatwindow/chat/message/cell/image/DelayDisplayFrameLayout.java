package com.ss.android.lark.chat.chatwindow.chat.message.cell.image;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/image/DelayDisplayFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "runnable", "Ljava/lang/Runnable;", "showDelay", BuildConfig.FLAVOR, "delayTime", "hide", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DelayDisplayFrameLayout extends FrameLayout {
    public final a a;

    public static final class a implements Runnable {
        public final /* synthetic */ DelayDisplayFrameLayout a;

        public a(DelayDisplayFrameLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r0 = this.a.getTag(2131368775);     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            return;
        L5:
            if ((r0 instanceof Boolean) == true) goto L7;
            return;
        L7:
            if (((Boolean) r0).booleanValue() == false) goto L18;
            this.a.setVisibility(0);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public DelayDisplayFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new a(this);
    }

    public DelayDisplayFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new a(this);
    }

    public DelayDisplayFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new a(this);
    }
}
