package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.utils.m;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ LynxContext b;
    public final /* synthetic */ FontFaceManager.f c;
    public final /* synthetic */ FontFaceManager d;

    public class a implements e8a.a<byte[]> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // e8a.a
        public final void onResponse(LynxResourceResponse<byte[]> r4) {
            if (r4.a != LynxResourceResponse.ResponseState.SUCCESS) goto L12;
            byte[] r5 = r4.b;
            if (r5 == null) goto L12;
            Typeface r6 = m.c(this.a.b, r5);
            if (r6 == null) goto L11;
            c r0 = this.a;
            r0.d.b(r0.a, r6);
            FontFaceManager.f r7 = this.a.c;
            if (r7 == null) goto L14;
            ((LynxResourceModule.c) ((LynxResourceModule.e) r7).a).a(0, NameKeys.UnloadStrategy_No_Strategy);
            return;
        L14:
            return;
        L11:
            c r8 = this.a;
            FontFaceManager.a(r8.d, r8.b, r8.a, r8.c);
            return;
        L12:
            c r9 = this.a;
            FontFaceManager.a(r9.d, r9.b, r9.a, r9.c);
        }
    }

    public final void a() {
        if (this.a.startsWith("data:") == false) goto L18;
        int r0 = 32101;
        FontFaceManager r1 = this.d;     // Catch: Exception -> L11
        LynxContext r2 = this.b;     // Catch: Exception -> L11
        FontFace.TYPE r3 = FontFace.TYPE.URL;     // Catch: Exception -> L11
        String r4 = this.a;     // Catch: Exception -> L11
        r1.getClass();     // Catch: Exception -> L11
        Typeface r5 = FontFaceManager.i(r2, r3, r4);     // Catch: Exception -> L11
        if (r5 == null) goto L9;
        this.d.b(this.a, r5);     // Catch: Exception -> L11
        r0 = 0;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        FontFaceManager.f r7 = this.c;
        if (r7 == null) goto L27;
        ((LynxResourceModule.c) ((LynxResourceModule.e) r7).a).a(r0, r6);
        return;
    L27:
        return;
    L9:
        r6 = "loadFromBase64 failed";
    L11:
        e = move-exception;
        r6 = "prefetchFont base64 failed: " + e.getMessage();
        LLog.e("FontFaceManager", r6);
        goto L13
    L18:
        if (this.a.startsWith("http") == false) goto L23;
        LynxResourceRequest r8 = new LynxResourceRequest(this.a, LynxResourceRequest.LynxResourceType.LynxResourceTypeFont);
        f8a.a r9 = this.b.getGenericResourceFetcher();
        if (r9 == null) goto L23;
        r9.a(r8, new a(this));
        return;
    L23:
        FontFaceManager.a(this.d, this.b, this.a, this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(FontFaceManager r1, String r2, LynxContext r3, LynxResourceModule.e r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
