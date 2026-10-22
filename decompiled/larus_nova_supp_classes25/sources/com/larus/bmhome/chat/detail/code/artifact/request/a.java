package com.larus.bmhome.chat.detail.code.artifact.request;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final String a;

    public a() {
        this.a = "/samantha/code/get_artifact";
    }

    public static final Object a(a r9, long r10, Integer r12, Continuation r13) {
        r9.getClass();
        if ((r13 instanceof CodeArtifactRenderHelper$fetchArtifact$1) == false) goto L7;
        CodeArtifactRenderHelper$fetchArtifact$1 r0 = (CodeArtifactRenderHelper$fetchArtifact$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CodeArtifactRenderHelper$fetchArtifact$1 r5 = r0;
        Object r14 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L22:
        y r15 = (com.larus.network.http.a) r14;
        Object r11 = null;
        if ((r15 instanceof y) == false) goto L61;
        GetArtifactData r16 = (GetArtifactData) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L74;
        List<CodeNodeContent> r17 = r16.getNodes();
        if (r17 == null) goto L74;
        List<CodeNodeContent> r18 = r17;
        Iterator<T> r19 = r18.iterator();
    L30:
        if (r19.hasNext() == false) goto L42;
        Object r110 = r19.next();
        CodeNodeContent r4 = (CodeNodeContent) r110;
        if (r4 == null) goto L34;
        boolean r6 = Intrinsics.areEqual(r4.isEntry(), Boolean.TRUE);
    L35:
        if (r6 == true) goto L37;
    L39:
        boolean r7 = false;
    L40:
        if (r7 == false) goto L30;
    L43:
        CodeNodeContent r111 = (CodeNodeContent) r110;
        if (r111 != null) goto L58;
        Iterator<T> r112 = r18.iterator();
    L47:
        if (r112.hasNext() == false) goto L55;
        Object r113 = r112.next();
        CodeNodeContent r114 = (CodeNodeContent) r113;
        if (r114 == null) goto L51;
        String r115 = r114.getLanguage();
    L53:
        if (Intrinsics.areEqual(r115, "html") == false) goto L47;
        r11 = r113;
        goto L55
    L51:
        r115 = null;
    L55:
        r11 = (CodeNodeContent) r11;
        if (r11 != null) goto L74;
        r11 = (CodeNodeContent) CollectionsKt.firstOrNull(r17);
        goto L74
    L58:
        r11 = r111;
        goto L74
    L37:
        if (Intrinsics.areEqual(r4.getLanguage(), "html") == false) goto L39;
        r7 = true;
        goto L40
    L34:
        r6 = false;
        goto L35
    L42:
        r110 = null;
    L74:
        return new Pair(r11, Boxing.boxBoolean(true));
    L61:
        if ((r15 instanceof f) == false) goto L63;
        Pair r20 = new Pair(null, Boxing.boxBoolean(true));
    L65:
        return r20;
    L63:
        r20 = new Pair(null, Boxing.boxBoolean(false));
        goto L65
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        String r8 = r9.a;
        Pair[] r21 = new Pair[2];
        r21[0] = TuplesKt.to("code_id", String.valueOf(r10));
        if (r12 == null) goto L18;
        String r116 = r12.toString();
        if (r116 == null) goto L18;
    L19:
        r21[1] = TuplesKt.to("version", r116);
        Map r22 = MapsKt.mapOf(r21);
        r5.label = 1;
        r14 = HttpExtKt.h("Basic", GetArtifactData.class, r8, r22, r5, 240);
        if (r14 != r2) goto L22;
        return r2;
    L18:
        r116 = "";
    L7:
        r0 = new CodeArtifactRenderHelper$fetchArtifact$1(r9, r13);
        goto L8
    }

    public final void b(LifecycleCoroutineScope r12, long r13, Integer r15, CodeBlockDetailFragment.d r16) {
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r16, "listener");
        r16.b();
        BuildersKt.launch$default(r12, null, null, new CodeArtifactRenderHelper$requestArtifact$1(this, r13, r15, r16, null), 3, null);
    }
}
