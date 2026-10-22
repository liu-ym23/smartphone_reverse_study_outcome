package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AdvanceVoiceInputComponent$loadingRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ b this$0;

    public static final class a implements Runnable {
        public a(b r1) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AdvanceVoiceInputComponent$loadingRunnable$2(b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Runnable m1153invoke() {
        return new a(this.this$0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1153invoke();
    }
}
