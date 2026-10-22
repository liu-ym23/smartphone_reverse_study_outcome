package com.obric.aikernel.res.installer.internal;

import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ApkDataScanner implements com.obric.aikernel.res.installer.a {

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends AbstractCoroutineContextElement implements h0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApkDataScanner f5006c;

        public a(h0.a r10, ApkDataScanner r11) {
            this.f5006c = r11;
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            d.f5417a.e(this.f5006c.tag(), "scan failed: " + r11);
        }
    }

    public ApkDataScanner() {
    }

    public static /* synthetic */ boolean d(File r10, String r11) {
        return f(r10, r11);
    }

    private final void e(PrmContext r22, com.obric.aikernel.res.metadata.data.b r23, Function3<? super String, ? super String, ? super String, ? extends com.obric.aikernel.res.metadata.data.b> r24) {
        File r10 = new File(r23.o());
        a8.a.C0003a r11 = a8.a.f122a.b(r22.getConfig().getContext());
        l0 r12 = m0.a(z0.b().plus(new k0(tag())).plus(new a(h0.f10523d, this)));
        String[] r13 = r10.list(com.obric.aikernel.res.installer.internal.a.f5007a);
        if (r13 == null) goto L10;
        ArrayList r14 = new ArrayList(r13.length);
        int r15 = r13.length;
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L7;
        String r17 = r13[r16];
        r14.add(h.b(r12, null, null, new ApkDataScanner$scan$2$1(new File(r10, r17), r22, r17, r11, r23, this, r24, null), 3, null));
        r16 = r16 + 1;
        goto L5
    L7:
        List r18 = (List) h.f(null, new ApkDataScanner$scan$3$1(r14, null), 1, null);
        return;
    }

    private static final boolean f(File r10, String r11) {
        return r10.isDirectory();
    }

    @Override // com.obric.aikernel.res.installer.a
    public void a(final PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        e(r10, new AIPackage("", "", r10.getConfig()), new ApkDataScanner$installAll$1(r10));
    }

    @Override // com.obric.aikernel.res.installer.a
    public List<com.obric.aikernel.res.installer.a.b> b(PrmContext r10) {
        return com.obric.aikernel.res.installer.a.C0113a.c(this, r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public boolean c(PrmContext r10, String r11, String r12, String r13) {
        return com.obric.aikernel.res.installer.a.C0113a.a(this, r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.res.installer.a
    public String tag() {
        return "ApkDataScanner";
    }
}
