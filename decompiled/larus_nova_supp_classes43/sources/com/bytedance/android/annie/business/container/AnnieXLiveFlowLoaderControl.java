package com.bytedance.android.annie.business.container;

import android.os.Bundle;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveFlowLoaderControl {
    public static final AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 a = null;

    public static final class a {
        public final String a;
        public final String b;
        public Map<String, Object> c;
        public Map<String, ? extends Object> d;
        public IAnnieBusinessLatchService.b e;
        public final DataProviderService f;

        public final Map<String, Object> a(String r10, String r11) {
            Map<String, ? extends Object> r0 = this.d;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r0);
            return r0;
        L6:
            boolean r1 = false;
            if (r10 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            Map<String, ? extends Object> r13 = MapsKt.emptyMap();
        L73:
            this.d = r13;
            Intrinsics.checkNotNull(r13);
            return r13;
        L15:
            Boolean r14 = HybridSecureUtil.b(r10);
            if (r14 == null) goto L18;
            boolean r15 = r14.booleanValue();
        L19:
            if (r15 == true) goto L77;
            r13 = MapsKt.emptyMap();
            goto L73
        L77:
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L67
            if (r11 != null) goto L25;
        L28:
            boolean r17 = true;
        L30:
            if ((!r17) == true) goto L34;
            r11 = null;
        L34:
            if (r11 == null) goto L54;
            String r18 = UriProtector.getQueryParameter(UriProtector.parse(r11), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
            if (r18 == null) goto L54;
            Object r19 = Result.constructor-impl(new JSONArray(r18));     // Catch: Throwable -> L39
        L42:
            if (Result.isFailure-impl(r19) == false) goto L44;
            r19 = null;
        L44:
            JSONArray r20 = (JSONArray) r19;     // Catch: Throwable -> L67
            if (r20 == null) goto L54;
            if (r20.length() <= 0) goto L49;
            r1 = true;
        L49:
            if (r1 == true) goto L52;
            r20 = null;
        L52:
            if (r20 == null) goto L54;
        L65:
            Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L67
        L70:
            if (Result.isFailure-impl(r21) == false) goto L72;
            r21 = null;
        L72:
            this.f.c(r10, (JSONArray) r21, null, AnnieXLiveFlowLoaderControl$LiveFlowLoadContext$observeWith$1.INSTANCE);
            r13 = this.f.b();
        L39:
            th = move-exception;
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L67
            r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        L54:
            String r23 = UriProtector.getQueryParameter(UriProtector.parse(r10), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
            if (r23 != null) goto L79;
            r20 = null;
            goto L65
        L79:
            Object r24 = Result.constructor-impl(new JSONArray(r23));     // Catch: Throwable -> L58
        L61:
            if (Result.isFailure-impl(r24) == false) goto L63;
            r24 = null;
        L63:
            r20 = (JSONArray) r24;     // Catch: Throwable -> L67
        L58:
            th = move-exception;
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L67
            r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
            goto L61
        L25:
            if (StringsKt.isBlank(r11) == true) goto L28;
            r17 = false;
        L67:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r21 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L70
        L18:
            r15 = o7.l.g(r10);
            goto L19
        L9:
            if (r10.length() == 0) goto L12;
            r12 = false;
            goto L13
        }

        public a(String r10, String r11, Bundle r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r11, "originSchema");
            this.a = r10;
            this.b = r11;
            String r13 = r12.getString("biz_key");     // Catch: Throwable -> L8
            if (r13 == null) goto L5;
        L6:
            this.f = new DataProviderService(r13);
            return;
        L5:
            r13 = "host";
            goto L6
        }
    }

    static {
        a = new AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1(3);
    }

    public static IAnnieBusinessLatchService.b a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        a r10 = (a) a.get(r1);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.e;
    }
}
