package com.ss.android.lark.mira;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/mira/UIGetPluginCallback;", "Data", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "<init>", "()V", "onLoading", "", "onPluginLoading", "mira-off_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class UIGetPluginCallback<Data> extends UIGetDataCallback<Data> {

    public static final class a implements Runnable {
        public final /* synthetic */ UIGetPluginCallback<Data> a;

        public a(UIGetPluginCallback<Data> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onPluginLoading();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void onPluginLoading() {
    }

    public final void onLoading() {
        UICallbackExecutor.execute(new a(this));
    }

    public UIGetPluginCallback() {
    }
}
