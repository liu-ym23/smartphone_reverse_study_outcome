package com.bytedance.android.ec.common.impl.order;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.buynow.OrderSchemaNotSupportException;
import com.bytedance.android.ec.core.buynow.OrderSchemaRuntimeException;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nl.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u00012\u00020\u0002:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/common/impl/order/OrderSchema;", "Lcom/bytedance/android/ec/model/order/IOrderSchema;", "Landroid/os/Parcelable;", "CREATOR", "a", "b", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSchema implements IOrderSchema, Parcelable {
    public static final a CREATOR = null;
    public final String a;
    public f b;
    public boolean c;
    public final Set<String> d;
    public final Set<String> e;
    public JSONObject f;
    public b g;
    public b h;
    public JSONObject i;
    public JSONObject j;
    public final Lazy k;
    public nl.b l;
    public JSONArray m;
    public final Map<String, Object> n;
    public String o;
    public final UrlBuilderV2 p;
    public final EntranceInfoScene q;

    public static final class a implements Parcelable.Creator<OrderSchema> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OrderSchema createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            Intrinsics.checkNotNullParameter(r10, "parcel");
            OrderSchema r1 = new OrderSchema(new UrlBuilderV2(r10.readString()), new EntranceInfoScene("PARCELABLE", "PARCELABLE"));
            String r0 = r10.readString();
            if (r0 != null) goto L10;
            JSONObject r11 = null;
        L8:
            r1.f = r11;
            r1.o = r10.readString();
            return r1;
        L10:
            r11 = new JSONObject(r0);     // Catch: Exception -> L7
        L7:
            r11 = new JSONObject();
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final OrderSchema[] newArray(int r1) {
            return new OrderSchema[r1];
        }
    }

    public final class b implements gl.a {
        public final gl.a a;
        public final /* synthetic */ OrderSchema b;

        public final Integer a() {
            Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS, "key");
            return this.a.a();
        }

        public final void b(Pair<String, ? extends Object>[] r10, Function2<Object, Object, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "condition");
            this.a.b(r10, r11);
        }

        public final void c(gl.a r10) {
            this.a.c(r10);
        }

        public final void d(String[] r10) {
            Intrinsics.checkNotNullParameter(r10, "keys");
            this.a.d(r10);
        }

        public void delete(String... r10) {
            Intrinsics.checkNotNullParameter(r10, "keys");
            this.a.delete(r10);
        }

        public final JSONObject e() {
            return this.a.e();
        }

        public final void f(Map<String, ? extends Object> r10, Function2<Object, Object, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "condition");
            this.a.f(r10, r11);
        }

        public final void g(Pair<String, ? extends Object>... r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            this.a.g(r10);
        }

        public final Object get(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            return this.a.get(r10);
        }

        public final String getString(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            return this.a.getString(r10);
        }

        public final void i(JSONObject r10) {
            this.a.i(r10);
        }

        public final void j(Pair<String, ? extends Object>[] r10, Function1<Object, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "filter");
            this.a.j(r10, r11);
        }

        public final Iterator<String> keys() {
            return this.a.keys();
        }

        public final void putAll(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            this.a.putAll(r10);
        }

        public final String h() {
            if (this.b.c == true) goto L8;
            if (ECAppInfoService.e.i() == false) goto L8;
            ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支序列化"));
        L8:
            return this.a.h();
        }

        public b(OrderSchema r10, com.bytedance.android.ec.common.impl.entranceinfo.b r11) {
            Intrinsics.checkNotNullParameter(r11, "entranceInfo");
            this.b = r10;
            this.a = r11;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void z0() {
        this.c = true;
    }

    public final JSONObject A0() {
        JSONObject r0 = new JSONObject();
        HashMap<String, JSONObject> r1 = j.a;
        String[] r10 = j.b;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = r10[r12];
        String r14 = this.p.getMMap().get(r13);
        if (r14 == null) goto L7;
        r0.put(r13, r14);
    L7:
        this.p.removeParam(r13);
        r12 = r12 + 1;
        goto L3
    L8:
        return r0;
    }

    public final boolean C() {
        String r0 = this.p.getMMap().get("ultimate_buy_ab");
        String r1 = "0";
        if (r0 != null) goto L5;
        r0 = "0";
    L5:
        int r10 = k.r(r0, 0);
        String r11 = this.p.getMMap().get("ultimate_buy_version");
        if (r11 == null) goto L9;
        r1 = r11;
    L9:
        int r12 = k.r(r1, 0);
        if (r10 <= 0) goto L14;
        if (r12 <= 0) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final b P() {
        if (this.g != null) goto L6;
        int r1 = com.bytedance.android.ec.common.impl.entranceinfo.b.h;
        this.g = new b(this, com.bytedance.android.ec.common.impl.entranceinfo.b.a.a(this.q, this.p.getQuery(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)));
    L6:
        return this.g;
    }

    public final b P0() {
        if (this.h != null) goto L10;
        int r1 = com.bytedance.android.ec.common.impl.entranceinfo.b.h;
        EntranceInfoScene r10 = this.q;
        JSONObject r11 = g();
        if (r11 == null) goto L7;
        String r12 = r11.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L8:
        this.h = new b(this, com.bytedance.android.ec.common.impl.entranceinfo.b.a.a(r10, r12));
        goto L10
    L7:
        r12 = null;
    L10:
        return this.h;
    }

    public final Object Q() {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, "key");
        if (this.d.contains(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO) == true) goto L5;
    L7:
        JSONObject r0 = g();
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.opt(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO);
    L5:
        if (ECAppInfoService.e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接获取 cj_info"));
        goto L7
    }

    public final boolean Q0() {
        String r0 = this.p.getMMap().get(com.bytedance.android.ec.core.event.a.KEY_URL);
        Boolean r1 = null;
        if (r0 == null) goto L6;
        r1 = Boolean.valueOf(StringsKt.contains$default(r0, "ecommerce_buynow_yata/html/index.html", false, 2, null));
    L6:
        return k.i(r1);
    }

    public final Map<String, String> b() {
        if (this.c == false) goto L5;
    L7:
        d();
        return this.p.getMMap();
    L5:
        if (ECAppInfoService.e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支序列化"));
        goto L7
    }

    public final void e() {
        b r0 = this.h;
        if (r0 == null) goto L7;
        JSONObject r1 = g();
        if (r1 == null) goto L7;
        r1.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r0.h());
    L7:
        JSONObject r10 = i();
        if (r10 == null) goto L13;
        JSONObject r11 = g();
        if (r11 == null) goto L14;
        r11.put("sku_log_data", r10.toString());
        return;
    L14:
        return;
    }

    public final JSONObject g() {
        if (this.f != null) goto L6;
        this.f = z1.g(this.p.getQuery("mega_object"));
    L6:
        return this.f;
    }

    public final String getFixEntranceInfoStr() {
        String r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return String.valueOf(this.i);
    }

    public final String getHost() {
        return this.p.getHost();
    }

    @Deprecated(message = "临时方案, 新架构使用")
    public final Map<String, String> getSimplifyQueryParams() {
        Map<String, String> r0 = MapsKt.toMutableMap(this.p.getMMap());
        r0.remove("mega_object");
        r0.remove("buynow_time");
        r0.remove(com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);
        r0.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        r0.remove("detail_url");
        r0.put("show_detail_entrance", String.valueOf(k.c(this.p.getMMap().get("detail_url"))));
        return r0;
    }

    public final JSONArray h() {
        if (this.m != null) goto L14;
        String r0 = this.p.getQuery(SkuSchemaCategory.KEY_PASS_THROUGH.getValue());
        if ((!Intrinsics.areEqual(r0, "null")) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        JSONArray r1 = k.t(r0);
        if (r1 == null) goto L11;
    L12:
        this.m = r1;
    L11:
        r1 = new JSONArray();
    L14:
        return this.m;
    }

    public final void h0() {
        Intrinsics.checkNotNullParameter("sku_log_data", "key");
        if (this.e.contains("sku_log_data") == false) goto L7;
        this.j = null;
        JSONObject r0 = g();
        if (r0 == null) goto L7;
        r0.remove("sku_log_data");
    L7:
        JSONObject r1 = g();
        if (r1 == null) goto L11;
        r1.remove("sku_log_data");
        return;
    }

    public final JSONObject i() {
        if (this.j != null) goto L13;
        JSONObject r0 = g();
        if (r0 == null) goto L10;
        String r1 = r0.optString("sku_log_data");
        if (r1 == null) goto L10;
        JSONObject r10 = z1.g(r1);
        if (r10 == null) goto L10;
    L11:
        this.j = r10;
    L10:
        r10 = new JSONObject();
    L13:
        return this.j;
    }

    public final String m0() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final JSONObject q1() {
        return (JSONObject) this.k.getValue();
    }

    public final Map<String, Object> recordInfo() {
        return k.b(this.n);
    }

    public final boolean u() {
        return Intrinsics.areEqual(this.p.getHost(), "buy_now");
    }

    public final String H() {
        Intrinsics.checkNotNullParameter("url.coupon.log_data", "to");
        JSONArray r10 = h();
        if (r10 == null) goto L22;
        int r11 = r10.length();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L22;
        JSONObject r13 = JSONArrayProtectorUtils.getJSONObject(r10, r12);
        JSONArray r14 = r13.optJSONArray("to");
        if (r14 == null) goto L21;
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L14
        int r16 = r14.length();     // Catch: Exception -> L14
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L16;
        Object r18 = r14.opt(r17);     // Catch: Exception -> L14
        if ((r18 instanceof String) == false) goto L13;
        r15.add(r18);     // Catch: Exception -> L14
    L13:
        r17 = r17 + 1;
    L16:
        if (r15 == null) goto L21;
        if (r15.contains("url.coupon.log_data") != true) goto L21;
        return a2.d(r13.optString("data"));
    L14:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
    L21:
        r12 = r12 + 1;
    L22:
        return null;
    }

    public final String a() {
        e();
        JSONObject r0 = g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final void d() {
        e();
        JSONObject r0 = g();
        if (r0 != null) goto L24;
    L9:
        JSONArray r1 = h();
        if (r1 != null) goto L12;
    L20:
        b r10 = this.g;
        if (r10 == null) goto L26;
        this.p.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r10.h());
        return;
    L26:
        return;
    L12:
        if (r1.length() <= 0) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == true) goto L18;
        r1 = null;
    L18:
        if (r1 == null) goto L20;
        this.p.addOrReplaceParam(SkuSchemaCategory.KEY_PASS_THROUGH.getValue(), r1.toString());
        goto L20
    L14:
        r11 = false;
        goto L15
    L24:
        String r12 = r0.toString();     // Catch: Exception -> L8
        if (r12 == null) goto L9;
        this.p.addOrReplaceParam("mega_object", r12);     // Catch: Exception -> L8
    L8:
        ECExceptionMonitor.e(new OrderSchemaRuntimeException("刷新 mega object 失败"));
        goto L9
    }

    public final String formatToUrl() {
        d();
        return this.p.toString();
    }

    @Deprecated(message = "临时方案，新架构使用", replaceWith = @ReplaceWith(expression = "getMegaObjectInStringWithFilter", imports = {}))
    public final Map<String, Object> getMegaObject() {
        e();
        JSONObject r0 = g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return z1.k(r0);
    }

    @Deprecated(message = "临时方案，新架构使用", replaceWith = @ReplaceWith(expression = "skuLogDataInMega()", imports = {}))
    public final Map<String, Object> getSkuLogData() {
        JSONObject r0 = i();
        if (r0 == null) goto L6;
        return z1.k(r0);
    L6:
        return MapsKt.emptyMap();
    }

    public final void j1() {
        JSONArray r0 = h();
        if (r0 != null) goto L5;
    L13:
        this.m = null;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        this.p.addOrReplaceParam(SkuSchemaCategory.KEY_PASS_THROUGH.getValue(), r0.toString());
        goto L13
    L7:
        r10 = false;
        goto L8
    }

    public final JSONObject u0() {
        return i();
    }

    public final boolean x1() {
        if (g() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final JSONObject B() {
        return this.i;
    }

    public final EntranceInfoScene W0() {
        return this.q;
    }

    public final nl.b getCacheKey() {
        return this.l;
    }

    public final gl.a getEntranceInfo() {
        return this.h;
    }

    public final f i1() {
        return this.b;
    }

    @Deprecated(message = "临时方案，新架构使用")
    public final Map<String, Object> skuBuyTimestamp() {
        return this.n;
    }

    public final void G(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "asyncCallback");
        oh.a.c("entrance_info_diff", new c(r10));
    }

    public final void T(JSONObject r1) {
        this.i = r1;
    }

    public final void X(com.bytedance.android.shopping.buynow.cache.a r10) {
        Intrinsics.checkNotNullParameter(r10, "cacheKey");
        this.l = r10;
    }

    public final void Y0(f r10) {
        Intrinsics.checkNotNullParameter(r10, "ultimateBuySingleSkuParams");
        this.b = r10;
    }

    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.d.contains(r10) == false) goto L21;
        int r0 = r10.hashCode();
        if (r0 == (-1613114217)) goto L18;
        if (r0 == 782567340) goto L15;
        if (r0 == 2013228997) goto L12;
    L20:
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("需要清空缓存 ".concat(r10)));
        goto L21
    L12:
        if (r10.equals(com.bytedance.android.ec.core.event.a.KEY_LOG_DATA) == false) goto L20;
    L15:
        if (r10.equals("mega_object") == false) goto L20;
        this.f = null;
        goto L21
    L18:
        if (r10.equals(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == false) goto L20;
        this.g = null;
    L21:
        this.p.removeParam(r10);
    }

    public final String getQueryParam(String r10) {
        Intrinsics.checkNotNullParameter(r10, "queryName");
        if (this.d.contains(r10) == false) goto L8;
        if (ECAppInfoService.e.i() == false) goto L8;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接获取 ".concat(r10)));
    L8:
        return this.p.getMMap().get(r10);
    }

    public final void m1(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "megaObject");
        this.f = r10;
    }

    public final String r0(Set<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "filterKeys");
        JSONObject r0 = g();
        if (r0 == null) goto L21;
        JSONObject r11 = new JSONObject();
        Iterator<String> r1 = r0.keys();
    L6:
        if (r1.hasNext() == false) goto L15;
        String r12 = r1.next();
        if (r10.contains(r12) == true) goto L6;
        JSONObject r13 = g();
        if (r13 == null) goto L12;
        Object r14 = r13.opt(r12);
    L13:
        r11.put(r12, r14);
        goto L6
    L12:
        r14 = null;
        goto L13
    L15:
        return r11.toString();
    L21:
        return null;
    }

    @Deprecated(message = "临时方案，新架构使用", replaceWith = @ReplaceWith(expression = "setFixedEntranceInfo()", imports = {}))
    public final void setFixEntranceInfoStr(String r10) {
        Intrinsics.checkNotNullParameter(r10, "entranceInfo");
        this.o = r10;
    }

    public OrderSchema(UrlBuilderV2 r10, EntranceInfoScene r11) {
        Intrinsics.checkNotNullParameter(r10, "urlBuilder");
        Intrinsics.checkNotNullParameter(r11, "entranceInfoScene");
        this.p = r10;
        this.q = r11;
        this.d = SetsKt.setOf(new String[]{"mega_object", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, "sku_log_data"});
        this.e = SetsKt.setOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, "adinfojson", "sku_log_data"});
        this.k = LazyKt.lazy(LazyThreadSafetyMode.NONE, new OrderSchema$adInfoInMega$2(this));
        JSONObject r12 = g();
        Object r13 = null;
        if (r12 == null) goto L5;
        Object r14 = r12.opt("buynow_time");
    L7:
        if ((r14 instanceof String) == false) goto L10;
        r13 = r14;
    L10:
        String r15 = (String) r13;
        if (r15 == null) goto L14;
        Map<String, Object> r16 = k.z(r15);
        if (r16 == null) goto L14;
    L15:
        this.n = r16;
        return;
    L14:
        r16 = new LinkedHashMap();
        goto L15
    L5:
        r14 = null;
        goto L7
    }

    public final void putValueInSkuLogData(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        JSONObject r12 = i();
        if (r12 == null) goto L6;
        KtSafeMethodExtensionKt.safePut(r12, com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, r11);
        return;
    }

    public final void replaceOrAppendParam(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (this.d.contains(r10) == true) goto L5;
    L7:
        this.p.addOrReplaceParam(r10, r11);
        return;
    L5:
        if (ECAppInfoService.e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接更新 " + r10));
        goto L7
    }

    public final void t0(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.e.contains(r10) == true) goto L5;
    L7:
        JSONObject r0 = g();
        if (r0 == null) goto L11;
        r0.put(r10, r11);
        return;
    L11:
        return;
    L5:
        if (ECAppInfoService.e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接往 MegaObject 塞 " + r10));
        goto L7
    }

    public final void v1(List<String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "to");
        Intrinsics.checkNotNullParameter(r11, "data");
        JSONArray r12 = h();
        if (r12 == null) goto L6;
        JSONObject r13 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r13, "to", k.s(r10));
        KtSafeMethodExtensionKt.safePut(r13, "data", r11);
        Unit r14 = Unit.INSTANCE;
        r12.put(r13);
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        JSONObject r11 = g();
        if (r11 == null) goto L5;
        r1.writeString(r11.toString());
    L5:
        r1.writeString(this.o);
    }

    public OrderSchema(String r10, EntranceInfoScene r11) {
        Intrinsics.checkNotNullParameter(r10, "originUrl");
        Intrinsics.checkNotNullParameter(r11, "entranceInfoScene");
        this(new UrlBuilderV2(r10), r11);
        this.a = r10;
    }

    public final void appendBtmToken(View r10, String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r11, "btmId");
        BcmParams.Companion.getClass();
        BcmParams r13 = BcmParams.a.c(r12);
        String r14 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r11, PageFinder.via(r10), r13));
        if (r14 == null) goto L6;
        replaceOrAppendParam("source_btm_token", r14);
        return;
    }

    public final void k0(String r17, String r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "to");
        Intrinsics.checkNotNullParameter(r18, "data");
        if (r19 != 1) goto L25;
        JSONArray r10 = h();
        if (r10 == null) goto L25;
        int r11 = r10.length();
        int r12 = 0;
        boolean r13 = false;
    L7:
        if (r12 >= r11) goto L24;
        JSONObject r14 = JSONArrayProtectorUtils.getJSONObject(r10, r12);
        JSONArray r0 = r14.optJSONArray("to");
        if (r0 == null) goto L23;
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L16
        int r16 = r0.length();     // Catch: Exception -> L16
        int r110 = 0;
    L11:
        if (r110 >= r16) goto L18;
        Object r111 = r0.opt(r110);     // Catch: Exception -> L16
        if ((r111 instanceof String) == false) goto L15;
        r15.add(r111);     // Catch: Exception -> L16
    L15:
        r110 = r110 + 1;
    L18:
        if (r15 == null) goto L23;
        if (r15.contains(r17) != true) goto L23;
        JSONObject r1 = z1.f(r14.optString("data"));
        x0.b(r1, z1.f(r18), false);
        KtSafeMethodExtensionKt.safePut(r14, "data", r1.toString());
        r13 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
    L23:
        r12 = r12 + 1;
        goto L7
    L24:
        boolean r20 = r13;
    L26:
        if (r20 == false) goto L28;
        return;
    L28:
        JSONArray r21 = h();
        if (r21 == null) goto L40;
        JSONObject r22 = new JSONObject();
        JSONArray r23 = new JSONArray();
        r23.put(r17);
        Unit r24 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r22, "to", r23);
        KtSafeMethodExtensionKt.safePut(r22, "data", r18);
        r21.put(r22);
        return;
    L40:
        return;
    L25:
        r20 = false;
        goto L26
    }
}
