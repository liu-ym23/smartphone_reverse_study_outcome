package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class NetworkRequestMethod extends BaseOpenMethod<v0> {
    public static final /* synthetic */ int i = 0;
    public final u10.b h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.NetworkRequestMethod$call$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $domain;
        final /* synthetic */ String $host;
        final /* synthetic */ v0 $params;
        final /* synthetic */ String $relativePath;
        final /* synthetic */ String $schema;
        final /* synthetic */ NetworkRequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.NetworkRequestMethod$call$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
        public static final class C00651 extends Lambda implements Function0<Unit> {
            final /* synthetic */ AnonymousClass1 this$0;

            public C00651(AnonymousClass1 r1) {
                this.this$0 = r1;
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m243invoke() {
                AnonymousClass1 r0 = this.this$0;
                NetworkRequestMethod r1 = r0.this$0;
                String r2 = r0.$domain;
                String r3 = r0.$schema;
                String r4 = r0.$host;
                Function0<Unit> r5 = new C00661(this);
                int r6 = NetworkRequestMethod.i;
                r1.getClass();
                boolean r7 = true;
                if (InteractGameContext.Companion.c() == false) goto L13;
                String r8 = r1.d.m.n;
                Intrinsics.checkNotNullParameter(r8, "$this$isOfficialVersion");
                LruCache r9 = LiveSchemaInfo.r;
                LiveSchemaInfo r11 = LiveSchemaInfo.c.a(r8);
                if (r11 == null) goto L7;
                String r12 = (String) r11.d.getValue();
            L9:
                if ((!Intrinsics.areEqual(r12, "current")) == false) goto L13;
                if (f0.a(r4) == false) goto L13;
                r5.invoke();
                return;
            L7:
                r12 = null;
            L13:
                BootInfoService r13 = (BootInfoService) r1.d.o(BootInfoService.class);
                Intrinsics.checkNotNullParameter(r2, "domain");
                Intrinsics.checkNotNullParameter(r3, "schema");
                com.bytedance.android.live.broadcastgame.opengame.runtime.g r14 = r13.c();
                if (r14 == null) goto L29;
                com.bytedance.android.live.broadcastgame.opengame.runtime.j r15 = r14.b;
                if (r15 == null) goto L29;
                List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r16 = r15.b;
                if (r16 == null) goto L29;
                Iterator<T> r17 = r16.iterator();
            L21:
                if (r17.hasNext() == false) goto L29;
                com.bytedance.android.live.broadcastgame.opengame.network.a.c r18 = (com.bytedance.android.live.broadcastgame.opengame.network.a.c) r17.next();
                if (Intrinsics.areEqual(r18.b(), r2) == false) goto L21;
                if (Intrinsics.areEqual(r3, "https") == false) goto L21;
                if (r18.a() != 1) goto L21;
            L30:
                if (r7 == false) goto L32;
                r5.invoke();
                return;
            L32:
                r1.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL, null);
                return;
            L29:
                r7 = false;
                goto L30
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m243invoke();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(NetworkRequestMethod r1, String r2, String r3, String r4, v0 r5, String r6) {
            this.this$0 = r1;
            this.$schema = r2;
            this.$host = r3;
            this.$domain = r4;
            this.$params = r5;
            this.$relativePath = r6;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m242invoke() {
            NetworkRequestMethod r0 = this.this$0;
            String r1 = this.$schema;
            String r2 = this.$host;
            C00651 r3 = new C00651(this);
            int r4 = NetworkRequestMethod.i;
            r0.getClass();
            if (InteractGameContext.Companion.c() == false) goto L14;
            String r5 = r0.d.m.n;
            Intrinsics.checkNotNullParameter(r5, "$this$isOfficialVersion");
            LruCache r6 = LiveSchemaInfo.r;
            LiveSchemaInfo r7 = LiveSchemaInfo.c.a(r5);
            if (r7 == null) goto L7;
            String r8 = (String) r7.d.getValue();
        L9:
            if ((!Intrinsics.areEqual(r8, "current")) == false) goto L14;
            if (f0.a(r2) == false) goto L14;
            r3.invoke();
            return;
        L7:
            r8 = null;
        L14:
            if (Intrinsics.areEqual("https", r1) == false) goto L16;
            r3.invoke();
            return;
        L16:
            r0.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_NOT_HTTPS, null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m242invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "request";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(v0 r11, CallContext r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        Uri r13 = UriProtector.parse(r11.e());
        String r2 = r13.getScheme();
        String r7 = r13.getHost();
        int r14 = r13.getPort();
        if (r2 == null) goto L72;
        if (r7 == null) goto L72;
        if (r14 <= 0) goto L9;
        String r15 = r2 + "://" + r7 + ':' + r14;
    L10:
        String r4 = r15;
        String r16 = r11.e();
        if (r16.length() <= r4.length()) goto L13;
        String r17 = r16.substring(r4.length());
    L14:
        AnonymousClass1 r18 = new AnonymousClass1(this, r2, r7, r4, r11, r17);
        if (InteractGameContext.Companion.c() == false) goto L70;
        String r19 = this.d.m.n;
        Intrinsics.checkNotNullParameter(r19, "$this$isOfficialVersion");
        LruCache r0 = LiveSchemaInfo.r;
        LiveSchemaInfo r110 = LiveSchemaInfo.c.a(r19);
        if (r110 == null) goto L19;
        String r111 = (String) r110.d.getValue();
    L20:
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r111, "current")) == false) goto L70;
        if (f0.a(r7) == false) goto L70;
        Intrinsics.checkNotNullParameter(r7, "$this$isLanIp");
        List r112 = StringsKt.split$default(r7, new String[]{"."}, false, 0, 6, null);
        if (r112.size() == 4) goto L74;
    L66:
        r1 = false;
    L67:
        if (r1 == false) goto L69;
        r18.invoke();
        return;
    L69:
        n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_NON_LAN_IP, null);
        return;
    L74:
        int r3 = CastIntegerProtector.parseInt((String) ListProtector.get(r112, 0));     // Catch: NumberFormatException -> L65
        int r5 = CastIntegerProtector.parseInt((String) ListProtector.get(r112, 1));     // Catch: NumberFormatException -> L65
        int r6 = CastIntegerProtector.parseInt((String) ListProtector.get(r112, 2));     // Catch: NumberFormatException -> L65
        int r113 = CastIntegerProtector.parseInt((String) ListProtector.get(r112, 3));     // Catch: NumberFormatException -> L65
        if (r3 != 10) goto L41;
        if (r5 < 0) goto L66;
        if (255 < r5) goto L66;
        if (r6 < 0) goto L66;
        if (255 < r6) goto L66;
        if (r113 < 0) goto L66;
        if (255 < r113) goto L66;
    L41:
        if (r3 != 172) goto L55;
        if (16 > r5) goto L66;
        if (31 < r5) goto L66;
        if (r6 < 0) goto L66;
        if (255 < r6) goto L66;
        if (r113 < 0) goto L66;
        if (255 < r113) goto L66;
    L55:
        if (r3 != 192) goto L66;
        if (r5 != 168) goto L66;
        if (r6 < 0) goto L66;
        if (255 < r6) goto L66;
        if (r113 < 0) goto L66;
        if (255 < r113) goto L66;
    L19:
        r111 = null;
    L70:
        r18.invoke();
        return;
    L13:
        r17 = "";
        goto L14
    L9:
        r15 = r2 + "://" + r7;
    L72:
        n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_URL_ILLEGAL, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(v0 r1, CallContext r2) {
        call2(r1, r2);
    }

    public NetworkRequestMethod(PluginContext r2, u10.b r3, LaunchMode r4, Queue<Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openNetworkExecutor");
        Intrinsics.checkNotNullParameter(r4, "launchMode");
        super(r2, r5);
        this.h = r3;
    }
}
