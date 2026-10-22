package com.larksuite.component.card.utils;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.GetUuidRequest;
import com.bytedance.lark.pb.openplatform.v1.GetUuidResponse;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Runnable {
    public final /* synthetic */ GetUuidRequest.Builder a;
    public final /* synthetic */ Function1<String, Unit> b;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r3) {
            return "c-" + ((GetUuidResponse) GetUuidResponse.ADAPTER.decode(r3)).uuid;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.card.utils.b$b, reason: collision with other inner class name */
    public static final class RunnableC0030b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function1<String, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public RunnableC0030b(String r1, Function1<? super String, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.a;     // Catch: Throwable -> L4
            this.b.invoke(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(GetUuidRequest.Builder r1, Function1<? super String, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = SdkSender.syncSend(Command.GET_UUID, this.a, a.a);     // Catch: Throwable -> L4
        String r1 = (String) r0;     // Catch: Throwable -> L4
        UICallbackExecutor.execute(new RunnableC0030b(r1, this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
