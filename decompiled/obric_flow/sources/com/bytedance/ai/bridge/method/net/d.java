package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.common.wschannel.WsConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f1876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletRequestMethod f1877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n1.c f1878c;

    public d(AppletRequestMethod r5, n1.c r10, o1.f r11) {
        this.f1876a = r11;
        this.f1877b = r5;
        this.f1878c = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(c2.a r26) {
        n1.c r5 = this.f1878c;
        AppletRequestMethod r10 = this.f1877b;
        Intrinsics.checkNotNullParameter(r26, WsConstants.KEY_CONNECTION);
        String r11 = UUID.randomUUID().toString();
        AppletRequestMethod.Companion.getClass();
        AppletRequestMethod.access$getStreamRequestMap$cp().put(r11, r26);
        Ref.IntRef r14 = r26.f;
        Ref.ObjectRef r15 = r26.e;
        int r12 = r14.element;
        LinkedHashMap r13 = r26.f1105a;
        Ref.IntRef r16 = r26.f1106b;
        Ref.ObjectRef r17 = r26.d;
        o1.f r18 = this.f1876a;
        if (r12 != 0) goto L102;
        int r19 = r16.element;
        if (200 > r19) goto L102;
        if (r19 >= 300) goto L102;
        Intrinsics.checkNotNullParameter(AbsAppletRequestMethodIDL.AppletRequestResultModel.class, "<this>");
        BaseModel r20 = com.lynx.tasm.behavior.ui.utils.e.c(AbsAppletRequestMethodIDL.AppletRequestResultModel.class);
        AbsAppletRequestMethodIDL.AppletRequestResultModel r21 = (AbsAppletRequestMethodIDL.AppletRequestResultModel) r20;
        r21.setHttpCode(Integer.valueOf(r16.element));
        r21.setClientCode(Integer.valueOf(r14.element));
        r21.setHeader(r13);
        r21.setSessionId(r11);
        r18.b((ResultModel) r20, "");
        InputStream r22 = (InputStream) r26.f1107c.element;
        if (r22 == null) goto L127;
        BufferedReader r110 = new BufferedReader(new InputStreamReader(r22));
        long r23 = 0;
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L71 Exception -> L73
    L13:
        String r25 = r110.readLine();     // Catch: Throwable -> L71 Exception -> L73
    L15:
        if (r25 == null) goto L46;
    L36:
        e = e;
        BufferedReader r27 = r110;
    L77:
        long r111 = r23;
    L106:
        AbsAppletRequestMethodIDL.StreamResponseStatus r28 = AbsAppletRequestMethodIDL.StreamResponseStatus.f1862c;     // Catch: Throwable -> L94
        long r112 = r111 + 1;
        Ref.ObjectRef r29 = r17;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(r28, r11, Long.valueOf(r111), null, Integer.valueOf(r14.element), e.getMessage(), 8, null));     // Catch: Throwable -> L89
        if (((Throwable) r15.element) != null) goto L86;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1861b, r11, Long.valueOf(r112), null, null, null, 56, null));
    L87:
        r26.a();
        r27.close();
        AppletRequestMethod.Companion.getClass();
        AppletRequestMethod.access$getStreamRequestMap$cp().remove(r11);
        return;
    L86:
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(r28, r11, Long.valueOf(r112), null, Integer.valueOf(r14.element), (String) r29.element, 8, null));
    L89:
        th = th;
        Ref.ObjectRef r30 = r29;
    L91:
        r111 = r112;
    L97:
        if (((Throwable) r15.element) != null) goto L99;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1861b, r11, Long.valueOf(r111), null, null, null, 56, null));
    L100:
        r26.a();
        r27.close();
        AppletRequestMethod.Companion.getClass();
        AppletRequestMethod.access$getStreamRequestMap$cp().remove(r11);
        throw th;
    L99:
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1862c, r11, Long.valueOf(r111), null, Integer.valueOf(r14.element), (String) r30.element, 8, null));
    L92:
        th = th;
        r30 = r17;
    L94:
        th = th;
    L76:
        r30 = r17;
    L34:
        th = th;
        r27 = r110;
    L75:
        r111 = r23;
        goto L76
    L17:
        if (StringsKt.isBlank(r25) == true) goto L19;
        r27 = r110;
        Ref.ObjectRef r31 = r17;
        r24.append(r25);     // Catch: Throwable -> L41 Exception -> L43
        r24.append('\n');     // Catch: Throwable -> L41 Exception -> L43
    L40:
        r17 = r31;
        r110 = r27;
        goto L13
    L19:
        if (r24.length() <= 0) goto L38;
        r24.append('\n');     // Catch: Throwable -> L34 Exception -> L36
        r111 = r23 + 1;
        r27 = r110;
        r31 = r17;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1860a, r11, Long.valueOf(r23), CollectionsKt.listOf(r24.toString()), null, null, 48, null));     // Catch: Throwable -> L26 Exception -> L28
        StringsKt.d(r24);     // Catch: Throwable -> L26 Exception -> L28
        r23 = r111;
    L116:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L41 Exception -> L43
    L43:
        e = e;
        r17 = r31;
    L41:
        th = th;
        r17 = r31;
    L28:
        e = e;
    L29:
        Ref.ObjectRef r210 = r31;
    L59:
        r17 = r210;
    L26:
        th = th;
    L27:
        r210 = r31;
    L58:
        r30 = r210;
        goto L97
    L32:
        e = e;
        r27 = r110;
        r31 = r17;
    L30:
        th = th;
        r27 = r110;
        r31 = r17;
        goto L27
    L38:
        r27 = r110;
        r31 = r17;
        goto L116
    L46:
        r27 = r110;
        r31 = r17;
        if (r24.length() > 0) goto L120;
        r210 = r31;
    L66:
        if (((Throwable) r15.element) != null) goto L68;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1861b, r11, Long.valueOf(r23), null, null, null, 56, null));
    L69:
        r26.a();
        r27.close();
        AppletRequestMethod.Companion.getClass();
        AppletRequestMethod.access$getStreamRequestMap$cp().remove(r11);
        return;
    L68:
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1862c, r11, Long.valueOf(r23), null, Integer.valueOf(r14.element), (String) r210.element, 8, null));
        goto L69
    L120:
        r24.append('\n');     // Catch: Throwable -> L60 Exception -> L62
        r111 = r23 + 1;
        r210 = r31;
        AppletRequestMethod.access$sendStreamEvent(r10, r5, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.f1860a, r11, Long.valueOf(r23), CollectionsKt.listOf(r24.toString()), null, null, 48, null));     // Catch: Throwable -> L54 Exception -> L56
        StringsKt.d(r24);     // Catch: Throwable -> L54 Exception -> L56
        r23 = r111;
        goto L66
    L56:
        e = e;
    L54:
        th = th;
        goto L58
    L62:
        e = e;
        r17 = r31;
    L60:
        th = th;
        r17 = r31;
        goto L75
    L73:
        e = e;
        r27 = r110;
    L71:
        th = th;
        r27 = r110;
        goto L75
    L127:
        return;
    L102:
        String r33 = (String) r17.element;
        Intrinsics.checkNotNullParameter(AbsAppletRequestMethodIDL.AppletRequestResultModel.class, "<this>");
        BaseModel r34 = com.lynx.tasm.behavior.ui.utils.e.c(AbsAppletRequestMethodIDL.AppletRequestResultModel.class);
        AbsAppletRequestMethodIDL.AppletRequestResultModel r35 = (AbsAppletRequestMethodIDL.AppletRequestResultModel) r34;
        r35.setHttpCode(Integer.valueOf(r16.element));
        r35.setClientCode(Integer.valueOf(r14.element));
        r35.setHeader(r13);
        r35.setSessionId(r11);
        Unit r36 = Unit.INSTANCE;
        r18.c(r33, (ResultModel) r34);
    }
}
