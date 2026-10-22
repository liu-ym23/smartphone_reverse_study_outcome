package com.bytedance.android.ec.core.hybrid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.hybrid.ECBridgeProvider;
import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.core.hybrid.bridges.ECGetCjInfoMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECOpenQRCodeScanner;
import com.bytedance.android.ec.core.hybrid.bridges.ECSafeDynamicEventMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatAllMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatNextMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatNowMethod;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J\"\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/utils/ECHostHybridUtil;", "", "Landroid/content/Context;", "context", "iesJsBridge", "", "", "Ln56/c;", "provideHostMethods", "provideHostMethodsWrapper", "Lcom/bytedance/android/ec/model/hybrid/IECBridgeMethod;", "bridgeMethod", "Ln56/a;", "hostBridgeMethodAdapter", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHostHybridUtil {
    public static final ECHostHybridUtil INSTANCE = null;

    public static final class a implements n56.c {
        public final /* synthetic */ IECBridgeMethod a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ n56.a c;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.utils.ECHostHybridUtil$a$a, reason: collision with other inner class name */
        public static final class C0136a implements IECBridgeMethod.b {
            public final /* synthetic */ a a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public final void onComplete(JSONObject r10) {
                Intrinsics.checkNotNullParameter(r10, "data");
                if (TextUtils.isEmpty(this.b) == true) goto L5;
                this.a.c.d(this.b, this.c, r10);
                return;
            L5:
                this.a.c.c(this.c, r10);
            }

            public final void onError(int r10, String r11) {
                Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
                JSONObject r0 = new JSONObject();
                r0.put("code", r10);     // Catch: JSONException -> L5
                r0.put(MessageIndication.MESSAGE_TYPE_MSG, r11);     // Catch: JSONException -> L5
            L8:
                if (TextUtils.isEmpty(this.b) == true) goto L10;
                this.a.c.d(this.b, this.c, r0);
                return;
            L10:
                this.a.c.c(this.c, r0);
                return;
            L5:
                e = move-exception;
                ye.a.b(e);
                goto L8
            }

            public C0136a(a r1, String r10, String r11) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
            }
        }

        public static final class b implements IECBridgeMethod.c {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final void a(JSONObject r10) {
                Intrinsics.checkNotNullParameter("skuConfirmed", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
                Intrinsics.checkNotNullParameter(r10, "params");
                this.a.c.f("skuConfirmed", r10);
            }
        }

        public a(IECBridgeMethod r1, Context r10, n56.a r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void call(n56.f r10, JSONObject r11) {
            JSONObject r12 = r10.d;     // Catch: Exception -> L7
            if (r12 != null) goto L5;
            return;
        L5:
            r12.put("func", r10.c);     // Catch: Exception -> L7
            r12.put("permissionGroup", r10.i);     // Catch: Exception -> L7
            String r0 = r10.b;     // Catch: Exception -> L7
            r10.j = false;     // Catch: Exception -> L7
            String r13 = r10.g;     // Catch: Exception -> L7
            IECBridgeMethod.a.a(this.a, this.b, r12, new C0136a(this, r13, r0), new b(this));     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            ye.a.b(e);
        }
    }

    private ECHostHybridUtil() {
    }

    static {
        INSTANCE = new ECHostHybridUtil();
    }

    @JvmStatic
    public static final Map<String, n56.c> provideHostMethods(Context r10, Object r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r11 instanceof n56.a) == true) goto L8;
        return null;
    L8:
        LinkedHashMap r0 = new LinkedHashMap();
        ((ECBridgeProvider) ECBridgeProvider.a.getValue()).getClass();
        ArrayList r1 = new ArrayList();
        Lazy r12 = ECBridgeProviderInjector.b;
        ECBridgeProviderInjector r13 = ECBridgeProviderInjector.a.a();
        r13.getClass();
        ArrayList r14 = new ArrayList();
        Iterator r15 = ((CopyOnWriteArrayList) r13.a).iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        r14.addAll((Collection) ((ti.i) r15.next()).b().invoke());
        goto L10
    L12:
        r1.addAll(r14);
        r1.add(new ECGetCjInfoMethod());
        r1.add(new StopShowFloatNowMethod());
        r1.add(new StopShowFloatNextMethod());
        r1.add(new StopShowFloatAllMethod());
        r1.add(new ECOpenQRCodeScanner());
        r1.add(new ECSafeDynamicEventMethod());
        Iterator r16 = r1.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        IECBridgeMethod r17 = (IECBridgeMethod) r16.next();
        r0.put(r17.getName(), hostBridgeMethodAdapter(r10, r17, (n56.a) r11));
        goto L14
    L16:
        return r0;
    }

    @JvmStatic
    public static final Map<String, Object> provideHostMethodsWrapper(Context r0, Object r1) {
        return provideHostMethods(r0, r1);
    }

    @JvmStatic
    public static final n56.c hostBridgeMethodAdapter(Context r1, IECBridgeMethod r10, n56.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeMethod");
        Intrinsics.checkNotNullParameter(r11, "iesJsBridge");
        return new a(r10, r1, r11);
    }
}
