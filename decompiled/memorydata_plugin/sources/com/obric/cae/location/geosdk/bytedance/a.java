package com.obric.cae.location.geosdk.bytedance;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationClient;
import com.bytedance.bdlocation.client.BDLocationClientOption;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.init.BDLocationAgent;
import com.bytedance.bdlocation.init.LocationInitConfig;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.rpc.internal.RpcUtils;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.Level;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7092b = 0;
    public static final long c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final ExecutorService f = null;
    public static final Gson g = null;
    public static final Gson h = null;
    public static final Object i = null;
    public volatile Context j;
    public volatile Bundle k;
    public volatile String l;
    public volatile boolean m;

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.bytedance.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0355a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("origin")
        public final String f7093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("destination")
        public final String f7094b;

        @SerializedName("origin_uid")
        public String c;

        @SerializedName("destination_uid")
        public String d;

        @SerializedName("coord_type")
        public String e;

        @SerializedName("ret_coordtype")
        public String f;

        @SerializedName("output")
        public String g;

        @SerializedName("sn")
        public String h;

        @SerializedName("timestamp")
        public long i;

        @SerializedName("callback")
        public String j;
        public String k;

        public AbstractC0355a(String r2, String r3) {
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.j = "";
            this.k = "";
            this.f7093a = r2;
            this.f7094b = r3;
        }
    }

    public static class aa extends AbstractC0355a {
        public final int l;

        public aa(String r1, String r2, int r3) {
            super(r1, r2);
            this.l = r3;
        }
    }

    public static class ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("area_id")
        public Integer f7095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("cname")
        public String f7096b;

        @SerializedName("uid")
        public String c;

        @SerializedName("wd")
        public String d;

        @SerializedName(alternate = {"destinationPt", "location"}, value = "originPt")
        public s e;
    }

    public static class ac extends AbstractC0355a {
        public ac(String r1, String r2) {
            super(r1, r2);
        }
    }

    public static class ad extends b {

        @SerializedName("result")
        public ae d;

        public ad() {
        }
    }

    public static class ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("origin")
        public ab f7097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("destination")
        public ab f7098b;

        @SerializedName("routes")
        public List<af> c;

        public ae() {
        }
    }

    public static class af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("distance")
        public Integer f7099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("duration")
        public Integer f7100b;

        @SerializedName("steps")
        public List<ag> c;

        @SerializedName(alternate = {"origin_location"}, value = "originLocation")
        public s d;

        @SerializedName(alternate = {"destination_location"}, value = "destinationLocation")
        public s e;

        public af() {
        }
    }

    public static class ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("leg_index")
        public Integer f7101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("area")
        public Integer f7102b;

        @SerializedName("direction")
        public Integer c;

        @SerializedName("distance")
        public Integer d;

        @SerializedName("duration")
        public Integer e;

        @SerializedName(alternate = {"instruction"}, value = "instructions")
        public String f;

        @SerializedName(ActivityLifecycle.NAME)
        public String g;

        @SerializedName("path")
        public String h;

        @SerializedName("pois")
        public JsonElement i;

        @SerializedName("type")
        public Integer j;

        @SerializedName("turn_type_id")
        public Integer k;

        @SerializedName(alternate = {"start_location"}, value = "stepOriginLocation")
        public s l;

        @SerializedName(alternate = {"end_location"}, value = "stepDestinationLocation")
        public s m;

        @SerializedName("stepOriginInstruction")
        public String n;

        @SerializedName("stepDestinationInstruction")
        public String o;

        public ag() {
        }
    }

    public static class ah {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("poi_list")
        public List<ai> f7103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(LBSLightLocationTraceLogger.TOTAL)
        public Long f7104b;

        public ah() {
        }
    }

    public static class ai {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("lbs_province")
        public String f7105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("lbs_city")
        public String f7106b;

        @SerializedName("lbs_district")
        public String c;

        @SerializedName("lbs_town")
        public String d;

        @SerializedName(MemoryKeyInfoEntity.KEY_ADDRESS)
        public String e;

        @SerializedName("location_id")
        public String f;

        @SerializedName(ActivityLifecycle.NAME)
        public String g;

        @SerializedName("country_code")
        public String h;

        @SerializedName("longitude")
        public String i;

        @SerializedName("latitude")
        public String j;

        @SerializedName(alternate = {"aoiBorder"}, value = "aoi_border")
        public String k;

        @SerializedName("extra_infos")
        public Map<String, String> l;

        public ai() {
        }
    }

    public static class aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("code")
        public Integer f7107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("data")
        public ah f7108b;

        @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
        public String c;

        @SerializedName("encrypt_data")
        public String d;

        @SerializedName("log_id")
        public String e;

        public aj() {
        }

        public String toString() {
            return a.h.toJson(this);
        }
    }

    public static class ak {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7110b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final double j;
        public final double k;

        public ak(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, double r10, double r12) {
            this.f7109a = r1;
            this.f7110b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r12;
        }
    }

    public static class al {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ak> f7112b;
        public final Integer c;
        public final String d;

        public al(boolean r1, ArrayList r2, Integer r3, String r4) {
            this.f7111a = r1;
            this.f7112b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static class am {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<ai>> f7113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f7114b;
        public final String c;

        public am(HashMap r1, Integer r2, String r3) {
            this.f7113a = r1;
            this.f7114b = r2;
            this.c = r3;
        }
    }

    public class an implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f7116b;
        public final /* synthetic */ AtomicReference c;

        public an(AtomicReference r1, CountDownLatch r2, AtomicReference r3) {
            this.f7115a = r1;
            this.f7116b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onError(BDLocationException r2) {
            this.c.set(r2);
            this.f7116b.countDown();
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onLocationChanged(BDLocation r5) {
            com.obric.cae.log.a.d("StarLocation-BdLM", "onLocationChanged location=" + r5);
            if (r5 != null) goto L6;
            com.obric.cae.log.a.h("StarLocation-BdLM", "ignore null callback and keep waiting");
            return;
        L6:
            com.obric.cae.location.a.a().b(5, com.obric.cae.location.util.d.a().a(r5), 0);
            this.f7115a.set(r5);
            this.f7116b.countDown();
        }
    }

    public final class ao {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7118b;
        public final ArrayList c;

        public ao(AoiBoard r2, String r3) {
            this.c = new ArrayList();
            this.f7117a = r2;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            this.f7118b = r3;
        }
    }

    public static final class ap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.obric.cae.location.database.a.C0353a> f7119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.cae.location.database.c.a> f7120b;
        public final List<com.obric.cae.location.cell.c.b> c;

        public ap(ArrayList r1, ArrayList r2, ArrayList r3) {
            this.f7119a = r1;
            this.f7120b = r2;
            this.c = r3;
        }
    }

    public static final class aq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7122b;
        public final String c;
        public final int d;

        public aq(String r1, String r2, int r3) {
            this.f7121a = r1;
            this.f7122b = r1;
            this.c = r2;
            this.d = r3;
        }

        public aq(String r1, String r2, int r3, int r4) {
            this.f7121a = null;
            this.f7122b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("status")
        public Integer f7123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("message")
        public String f7124b;

        @SerializedName("type")
        public Integer c;

        public b() {
        }

        public boolean a() {
            Integer r0 = this.f7123a;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.intValue() != 0) goto L7;
            return true;
        }
    }

    public static class c extends AbstractC0355a {

        @SerializedName("tactics")
        public int l;

        @SerializedName("alternatives")
        public int m;

        @SerializedName("road_traffic")
        public int n;

        @SerializedName("waypoints")
        public String o;

        @SerializedName("avoidroad")
        public String p;

        @SerializedName("avoidpolygons")
        public String q;

        @SerializedName("plate_number")
        public String r;

        @SerializedName("restriction")
        public String s;

        public c(String r1, String r2) {
            super(r1, r2);
            this.o = "";
            this.p = "";
            this.q = "";
            this.r = "";
            this.s = "";
        }
    }

    public static class d extends b {

        @SerializedName("result")
        public e d;

        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("restriction")
        public String f7125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(LBSLightLocationTraceLogger.TOTAL)
        public Integer f7126b;

        @SerializedName("session_id")
        public String c;

        @SerializedName("routes")
        public List<f> d;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("origin")
        public s f7127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("destination")
        public s f7128b;

        @SerializedName(LocationMonitorConst.TAG)
        public String c;

        @SerializedName("mrsl")
        public String d;

        @SerializedName("route_md5")
        public String e;

        @SerializedName("traffic_light")
        public Integer f;

        @SerializedName("distance")
        public Integer g;

        @SerializedName("duration")
        public Integer h;

        @SerializedName("taxi_fee")
        public Double i;

        @SerializedName("steps")
        public List<g> j;

        public f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("leg_index")
        public Integer f7129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("link_num")
        public Integer f7130b;

        @SerializedName("road_name")
        public String c;

        @SerializedName("direction")
        public Integer d;

        @SerializedName("distance")
        public Integer e;

        @SerializedName("duration")
        public Integer f;

        @SerializedName("road_type")
        public Integer g;

        @SerializedName("toll")
        public Double h;

        @SerializedName("toll_distance")
        public Integer i;

        @SerializedName("adcodes")
        public String j;

        @SerializedName("traffic_condition")
        public JsonElement k;

        @SerializedName("path")
        public String l;

        @SerializedName("start_location")
        public s m;

        @SerializedName("end_location")
        public s n;

        public g() {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("area_id")
        public Integer f7131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("cname")
        public String f7132b;

        @SerializedName("uid")
        public String c;

        @SerializedName("wd")
        public String d;

        @SerializedName(alternate = {"destinationPt", "location"}, value = "originPt")
        public s e;
    }

    public static class i extends AbstractC0355a {

        @SerializedName("riding_type")
        public String l;

        @SerializedName("road_prefer")
        public int m;

        public i(String r1, String r2) {
            super(r1, r2);
            this.l = "";
        }
    }

    public static class j extends b {

        @SerializedName("result")
        public k d;

        public j() {
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("origin")
        public h f7133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("destination")
        public h f7134b;

        @SerializedName("routes")
        public List<m> c;

        public k() {
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(XSDatatype.FACET_LENGTH)
        public Integer f7135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("attr")
        public Integer f7136b;

        public l() {
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("restrictions_status")
        public Integer f7137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("restrictions_info")
        public String f7138b;

        @SerializedName("distance")
        public Integer c;

        @SerializedName("duration")
        public Integer d;

        @SerializedName("steps")
        public List<n> e;

        @SerializedName(alternate = {"origin_location"}, value = "originLocation")
        public s f;

        @SerializedName(alternate = {"destination_location"}, value = "destinationLocation")
        public s g;

        public m() {
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("leg_index")
        public Integer f7139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("area")
        public Integer f7140b;

        @SerializedName("direction")
        public Integer c;

        @SerializedName("distance")
        public Integer d;

        @SerializedName("duration")
        public Integer e;

        @SerializedName(alternate = {"instruction"}, value = "instructions")
        public String f;

        @SerializedName(ActivityLifecycle.NAME)
        public String g;

        @SerializedName("path")
        public String h;

        @SerializedName("pois")
        public JsonElement i;

        @SerializedName("type")
        public Integer j;

        @SerializedName("turn_type")
        public String k;

        @SerializedName("restrictions_info")
        public String l;

        @SerializedName(alternate = {"start_location"}, value = "stepOriginLocation")
        public s m;

        @SerializedName(alternate = {"end_location"}, value = "stepDestinationLocation")
        public s n;

        @SerializedName("stepOriginInstruction")
        public String o;

        @SerializedName("stepDestinationInstruction")
        public String p;

        @SerializedName("restrictions_status")
        public Integer q;

        @SerializedName("links")
        public List<l> r;

        public n() {
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("city_id")
        public String f7141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("city_name")
        public String f7142b;

        @SerializedName("location")
        public s c;
    }

    public static class p extends AbstractC0355a {

        @SerializedName("departure_date")
        public String l;

        @SerializedName("departure_time")
        public String m;

        @SerializedName("tactics_incity")
        public int n;

        @SerializedName("tactics_intercity")
        public int o;

        @SerializedName("trans_type_intercity")
        public int p;

        @SerializedName("page_size")
        public int q;

        @SerializedName("page_index")
        public int r;

        public p(String r1, String r2) {
            super(r1, r2);
            this.l = "";
            this.m = "";
        }
    }

    public static class q extends b {

        @SerializedName("transit_type")
        public Integer d;

        @SerializedName("result")
        public r e;

        public q() {
        }
    }

    public static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("origin")
        public o f7143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("destination")
        public o f7144b;

        @SerializedName("taxi")
        public y c;

        @SerializedName(LBSLightLocationTraceLogger.TOTAL)
        public Integer d;

        @SerializedName("routes")
        public List<u> e;

        public r() {
        }
    }

    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("lat")
        public double f7145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("lng")
        public double f7146b;
    }

    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("ticket_type")
        public Integer f7147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("ticket_price")
        public Double f7148b;

        public t() {
        }
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("distance")
        public Integer f7149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("duration")
        public Integer f7150b;

        @SerializedName("price")
        public Double c;

        @SerializedName("arrive_time")
        public String d;

        @SerializedName("price_detail")
        public List<t> e;

        @SerializedName("steps")
        public List<List<w>> f;

        public u() {
        }
    }

    public static class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("distance")
        public Integer f7151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("duration")
        public Integer f7152b;

        @SerializedName("instructions")
        public String c;

        @SerializedName("path")
        public String d;

        @SerializedName("start_location")
        public s e;

        @SerializedName("end_location")
        public s f;

        @SerializedName("vehicle_info")
        public z g;

        public v() {
        }
    }

    public static class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("distance")
        public Integer f7153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("duration")
        public Integer f7154b;

        @SerializedName(alternate = {"instruction"}, value = "instructions")
        public String c;

        @SerializedName("path")
        public String d;

        @SerializedName("traffic_condition")
        public JsonElement e;

        @SerializedName("start_location")
        public s f;

        @SerializedName("end_location")
        public s g;

        @SerializedName("vehicle_info")
        public z h;

        @SerializedName("schemes")
        public List<v> i;

        public w() {
        }
    }

    public static class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("desc")
        public String f7155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("km_price")
        public Double f7156b;

        @SerializedName("start_price")
        public Double c;

        @SerializedName("total_price")
        public Double d;

        public x() {
        }
    }

    public static class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(MemoryListActivity.JUMP_FROM_DETAIL)
        public List<x> f7157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("distance")
        public Integer f7158b;

        @SerializedName("duration")
        public Integer c;

        @SerializedName("remark")
        public String d;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        public Integer f7159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(MemoryListActivity.JUMP_FROM_DETAIL)
        public JsonElement f7160b;
    }

    static {
        f7091a = new a();
        TimeUnit r0 = TimeUnit.SECONDS;
        f7092b = r0.toMillis(15);
        c = TimeUnit.MINUTES.toMillis(10);
        d = (int) r0.toMillis(5);
        e = (int) r0.toMillis(15);
        f = Executors.newFixedThreadPool(8);
        g = new GsonBuilder().setLenient().create();
        h = new GsonBuilder().setPrettyPrinting().create();
        i = new Object();
    }

    public a() {
        this.m = false;
    }

    public static int a(b r3) {
        if (ZeusTransformUtils.instanceOf(r3, q.class) == false) goto L11;
        r r4 = ((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.memorydata.plugin")).e;
        if (r4 == null) goto L34;
        List<u> r5 = r4.e;
        if (r5 != null) goto L9;
        return 0;
    L9:
        return r5.size();
    L34:
        return 0;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L19;
        e r6 = ((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin")).d;
        if (r6 == null) goto L36;
        List<f> r7 = r6.d;
        if (r7 != null) goto L17;
        return 0;
    L17:
        return r7.size();
    L36:
        return 0;
    L19:
        if (ZeusTransformUtils.instanceOf(r3, ad.class) == false) goto L27;
        ae r8 = ((ad) ZeusTransformUtils.preCheckCast(r3, ad.class, "com.obric.memorydata.plugin")).d;
        if (r8 == null) goto L38;
        List<af> r9 = r8.c;
        if (r9 != null) goto L25;
        return 0;
    L25:
        return r9.size();
    L38:
        return 0;
    L27:
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L40;
        k r10 = ((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin")).d;
        if (r10 == null) goto L41;
        List<m> r11 = r10.c;
        if (r11 != null) goto L33;
        return 0;
    L33:
        return r11.size();
    L41:
        return 0;
    L40:
        return 0;
    }

    public static int a(HashMap r3, String r4) {
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.get(r4), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return 0;
    L9:
        return Integer.parseInt(r5);
    L7:
        com.obric.cae.log.a.h("StarLocation-BdLM", "invalid int extra " + r4 + "=" + r5);
        return 0;
    }

    public static Bundle a(s r4) {
        Bundle r0 = new Bundle();
        r0.putDouble("lat", r4.f7145a);
        r0.putDouble("lng", r4.f7146b);
        return r0;
    }

    public static SsResponse a(a r20, String r21, Map r22, Map r23, ArrayList r24) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        r20.getClass();
        HttpURLConnection r6 = null;
        StringBuilder r7 = new StringBuilder(r21);     // Catch: Throwable -> L87
        boolean r12 = true;
        if (r3.isEmpty() == false) goto L7;
    L21:
        URL r2 = new URL(r7.toString());     // Catch: Throwable -> L87
        HttpURLConnection r4 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r2.openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L87
        r4.setConnectTimeout(d);     // Catch: Throwable -> L85
        r4.setReadTimeout(e);     // Catch: Throwable -> L85
        r4.setRequestMethod("POST");     // Catch: Throwable -> L85
        r4.setDoInput(true);     // Catch: Throwable -> L85
        r4.setDoOutput(true);     // Catch: Throwable -> L85
        Iterator r8 = r24.iterator();     // Catch: Throwable -> L85
    L24:
        if (r8.hasNext() == false) goto L27;
        Header r9 = (Header) ZeusTransformUtils.preCheckCast(r8.next(), Header.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        r4.setRequestProperty(r9.getName(), r9.getValue());     // Catch: Throwable -> L85
        goto L24
    L27:
        if (r4.getRequestProperty(NetConst.KEY_CONTENT_TYPE) != null) goto L29;
        r4.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");     // Catch: Throwable -> L85
    L29:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L85
        if (r5 != null) goto L32;
    L40:
        byte[] r10 = r1.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L85
        r4.setFixedLengthStreamingMode(r10.length);     // Catch: Throwable -> L85
        OutputStream r11 = r4.getOutputStream();     // Catch: Throwable -> L85
        r11.write(r10);     // Catch: Throwable -> L76
        r11.close();     // Catch: Throwable -> L85
        int r13 = r4.getResponseCode();     // Catch: Throwable -> L85
        if (r13 < 200) goto L46;
        if (r13 >= 300) goto L46;
        InputStream r14 = r4.getInputStream();     // Catch: Throwable -> L85
    L47:
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14, RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L85
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L85
    L48:
        String r17 = r15.readLine();     // Catch: Throwable -> L85
        if (r17 == null) goto L51;
        r16.append(r17);     // Catch: Throwable -> L85
        goto L48
    L51:
        r15.close();     // Catch: Throwable -> L85
        String r18 = r16.toString();     // Catch: Throwable -> L85
        Map<String, List<String>> r19 = r4.getHeaderFields();     // Catch: Throwable -> L85
        r20.a(r21, r19);     // Catch: Throwable -> L85
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L85
        if (r19 == null) goto L63;
        Iterator<Map.Entry<String, List<String>>> r25 = r19.entrySet().iterator();     // Catch: Throwable -> L85
    L55:
        if (r25.hasNext() == false) goto L63;
        Map.Entry r26 = (Map.Entry) ZeusTransformUtils.preCheckCast(r25.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        if (r26.getKey() == null) goto L55;
        if (r26.getValue() == null) goto L55;
        if (((List) ZeusTransformUtils.preCheckCast(r26.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L55;
        r0.add(new Header((String) ZeusTransformUtils.preCheckCast(r26.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r26.getValue(), List.class, "com.obric.memorydata.plugin")).get(0), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L85
    L63:
        String r110 = r2.toString();     // Catch: Throwable -> L85
        if (r4.getResponseMessage() == null) goto L67;
        String r27 = r4.getResponseMessage();     // Catch: Throwable -> L85
    L68:
        Response r28 = new Response(r110, r13, r27, r0, null);     // Catch: Throwable -> L85
        if (r13 < 200) goto L73;
        if (r13 >= 300) goto L73;
        com.obric.cae.log.a.d("StarLocation-BdLM", "response code=" + r13);     // Catch: Throwable -> L85
        SsResponse r29 = SsResponse.success(r18, r28);     // Catch: Throwable -> L85
    L74:
        r4.disconnect();
        return r29;
    L73:
        com.obric.cae.log.a.j("StarLocation-BdLM", "response code=" + r13 + ", body=" + r18);     // Catch: Throwable -> L85
        r29 = SsResponse.error(new TypedByteArray("application/json; charset=utf-8", r18.getBytes(RpcUtils.CHARSET_UTF8), new String[0]), r28);     // Catch: Throwable -> L85
        goto L74
    L67:
        r27 = "";
    L46:
        r14 = r4.getErrorStream();     // Catch: Throwable -> L85
        goto L47
    L76:
        th = move-exception;
        if (r11 == null) goto L115;
        r11.close();     // Catch: Throwable -> L81
    L116:
        throw th;     // Catch: Throwable -> L85
    L81:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L85
        throw th;     // Catch: Throwable -> L85
    L115:
        throw th;     // Catch: Throwable -> L85
    L32:
        if (r5.isEmpty() == true) goto L40;
        Iterator r30 = r5.entrySet().iterator();     // Catch: Throwable -> L85
    L35:
        if (r30.hasNext() == false) goto L40;
        Map.Entry r31 = (Map.Entry) ZeusTransformUtils.preCheckCast(r30.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        if (r12 == true) goto L39;
        r1.append("&");     // Catch: Throwable -> L85
    L39:
        r1.append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r31.getKey(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8)).append("=").append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r31.getValue(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L85
        r12 = false;
    L85:
        th = th;
        r6 = r4;
    L88:
        if (r6 == null) goto L90;
        r6.disconnect();
    L90:
        throw th;
    L7:
        if (r21.contains("?") == true) goto L10;
        r7.append("?");     // Catch: Throwable -> L87
    L14:
        Iterator r32 = r3.entrySet().iterator();     // Catch: Throwable -> L87
        boolean r33 = true;
    L16:
        if (r32.hasNext() == false) goto L21;
        Map.Entry r34 = (Map.Entry) ZeusTransformUtils.preCheckCast(r32.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L87
        if (r33 == true) goto L20;
        r7.append("&");     // Catch: Throwable -> L87
    L20:
        r7.append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r34.getKey(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8)).append("=").append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r34.getValue(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L87
        r33 = false;
        goto L16
    L10:
        if (r21.endsWith("?") == true) goto L14;
        if (r21.endsWith("&") == true) goto L14;
        r7.append("&");     // Catch: Throwable -> L87
    L87:
        th = th;
        goto L88
    }

    public static JsonArray a(JsonElement r8) {
        if (r8 != null) goto L5;
    L40:
        return null;
    L5:
        if (r8.isJsonArray() == false) goto L40;
        JsonArray r9 = r8.getAsJsonArray();
        if (r9.isEmpty() == false) goto L10;
        return null;
    L10:
        boolean r3 = true;
        if (r9.isEmpty() == true) goto L31;
        Iterator<JsonElement> r1 = r9.iterator();
    L15:
        if (r1.hasNext() == false) goto L32;
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r1.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L19;
    L29:
        boolean r6 = false;
    L30:
        if (r6 == true) goto L15;
    L19:
        if (r5.isJsonArray() == false) goto L29;
        JsonArray r7 = r5.getAsJsonArray();
        if (r7.size() < 2) goto L29;
        if (r7.get(0).isJsonPrimitive() == false) goto L29;
        if (r7.get(1).isJsonPrimitive() == false) goto L29;
        r6 = true;
    L32:
        if (r3 == false) goto L34;
        return r9;
    L34:
        Iterator<JsonElement> r10 = r9.iterator();
    L36:
        if (r10.hasNext() == false) goto L40;
        JsonArray r2 = a((JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L36;
        return r2;
    L31:
        r3 = false;
        goto L32
    }

    public static JsonElement a(JsonElement r9, int r10) {
        if (r9 != null) goto L5;
    L49:
        return null;
    L5:
        if (r9.isJsonNull() == true) goto L49;
        if (r10 > 8) goto L49;
        if (r9.isJsonPrimitive() == false) goto L18;
        if (r9.getAsJsonPrimitive().isString() == false) goto L18;
        JsonElement r1 = h(r9.getAsString());
        if (r1 == null) goto L18;
        r9 = r1;
    L18:
        if (r9.isJsonNull() == false) goto L21;
        return null;
    L21:
        if (r9.isJsonArray() == false) goto L24;
        return r9;
    L24:
        if (r9.isJsonObject() == true) goto L26;
        return null;
    L26:
        JsonObject r11 = r9.getAsJsonObject();
        JsonElement r2 = a(r11, "cells");
        if (r2 != null) goto L29;
    L43:
        String[] r3 = {"data", "result", "results", Constants.KEY_LIST, "items", "poi_list", "poiList"};
        int r4 = 0;
    L44:
        if (r4 >= 7) goto L49;
        JsonElement r5 = a(a(r11, r3[r4]), r10 + 1);
        if (r5 != null) goto L47;
        r4 = r4 + 1;
        goto L44
    L47:
        return r5;
    L29:
        if (r2.isJsonNull() == true) goto L43;
        if (r2.isJsonPrimitive() == false) goto L39;
        if (r2.getAsJsonPrimitive().isString() == false) goto L39;
        JsonElement r6 = h(r2.getAsString());
        if (r6 == null) goto L39;
        r2 = r6;
    L39:
        if (r2.isJsonArray() == false) goto L41;
    L42:
        return r2;
    L41:
        if (r2.isJsonNull() == false) goto L43;
        goto L42
    }

    public static JsonElement a(JsonElement r4, String r5) {
        if (r4.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r6 = c(r4.getAsJsonObject(), r5);
        Integer r0 = b(r6, new String[]{"code"});
        if (r0 != null) goto L8;
    L11:
        JsonElement r1 = r6.get("data");
        if (r1 != null) goto L14;
    L25:
        com.obric.cae.log.a.j("StarLocation-BdLM", r5 + ": response data is missing, keys=" + c(r6));
        return null;
    L14:
        if (r1.isJsonNull() == true) goto L25;
        if (r1.isJsonPrimitive() == true) goto L19;
        return r1;
    L19:
        if (r1.getAsJsonPrimitive().isString() == false) goto L28;
        JsonElement r7 = h(r1.getAsString());
        if (r7 != null) goto L24;
        return r1;
    L24:
        return r7;
    L28:
        return r1;
    L8:
        if (r0.intValue() == 0) goto L11;
        com.obric.cae.log.a.h("StarLocation-BdLM", r5 + ": response code=" + r0 + ", msg=" + f(a(r6, new String[]{NotificationCompat.CATEGORY_MESSAGE, "message"})));
        return null;
    }

    public static JsonElement a(JsonObject r7, String r8) {
        JsonElement r0 = r7.get(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r9 = r8.replace("_", "").replace("-", "").toLowerCase(Locale.US);
        Iterator<Map.Entry<String, JsonElement>> r10 = r7.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3.getKey() == null) goto L7;
        if (r9.equals(((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")).replace("_", "").replace("-", "").toLowerCase(Locale.US)) == false) goto L7;
        return (JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
    L14:
        return null;
    }

    public static JsonObject a(AbstractC0355a r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("origin", r5.f7093a);
        r0.addProperty("destination", r5.f7094b);
        r0.addProperty("origin_uid", f(r5.c));
        r0.addProperty("destination_uid", f(r5.d));
        r0.addProperty("coord_type", f(r5.e));
        r0.addProperty("ret_coordtype", f(r5.f));
        r0.addProperty("output", f(r5.g));
        r0.addProperty("sn", f(r5.h));
        r0.addProperty("timestamp", Long.valueOf(Math.max(r5.i, 0)));
        r0.addProperty("callback", f(r5.j));
        return r0;
    }

    public static JsonObject a(c r4) {
        JsonObject r0 = a(r4);
        r0.addProperty("tactics", Integer.valueOf(Math.max(r4.l, 0)));
        r0.addProperty("alternatives", Integer.valueOf(Math.max(r4.m, 1)));
        r0.addProperty("road_traffic", Integer.valueOf(Math.max(r4.n, 0)));
        r0.addProperty("waypoints", f(r4.o));
        r0.addProperty("avoidroad", f(r4.p));
        r0.addProperty("avoidpolygons", f(r4.q));
        r0.addProperty("plate_number", f(r4.r));
        r0.addProperty("restriction", f(r4.s));
        return r0;
    }

    public static JsonObject a(i r3) {
        JsonObject r0 = a(r3);
        r0.addProperty("riding_type", f(r3.l));
        r0.addProperty("road_prefer", Integer.valueOf(Math.max(r3.m, 0)));
        return r0;
    }

    public static JsonObject a(p r4) {
        JsonObject r0 = a(r4);
        r0.addProperty("departure_date", f(r4.l));
        r0.addProperty("departure_time", f(r4.m));
        r0.addProperty("tactics_incity", Integer.valueOf(Math.max(r4.n, 0)));
        r0.addProperty("tactics_intercity", Integer.valueOf(Math.max(r4.o, 0)));
        r0.addProperty("trans_type_intercity", Integer.valueOf(Math.max(r4.p, 0)));
        r0.addProperty("page_size", Integer.valueOf(Math.max(r4.q, 0)));
        r0.addProperty("page_index", Integer.valueOf(Math.max(r4.r, 0)));
        return r0;
    }

    public static JsonObject a(String r3, int r4, int r5, String r6, String r7) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("index", "map_poi");
        r0.addProperty("keyword", f(r3));
        JsonObject r8 = new JsonObject();
        if (r4 > 0) goto L6;
        r4 = 1;
    L6:
        r8.addProperty("num", Integer.valueOf(r4));
        if (r5 > 0) goto L10;
        r5 = 20;
    L10:
        r8.addProperty("size", Integer.valueOf(r5));
        r0.add("page", r8);
        JsonObject r9 = new JsonObject();
        r9.addProperty("show_fields", "geometry");
        r9.addProperty("region_limit", "true");
        String r10 = f(r6).trim();
        if (r10.length() <= 1) goto L16;
        if (r10.endsWith("市") == false) goto L16;
        r10 = r10.substring(0, r10.length() - 1);
    L16:
        if (TextUtils.isEmpty(r10) == true) goto L18;
        r9.addProperty(Api.KEY_REGION, r10);
    L18:
        r0.add(WsConstants.KEY_EXTRA, r9);
        if (TextUtils.isEmpty(r7) == true) goto L21;
        r0.addProperty("dsl", r7);
    L21:
        JsonObject r11 = new JsonObject();
        r11.addProperty("env", "prod");
        JsonObject r12 = new JsonObject();
        r12.add("Extra", r11);
        r0.add("Base", r12);
        return r0;
    }

    public static al a(String r28) {
        JsonElement r0 = h(r28);
        if (r0 != null) goto L5;
    L130:
        com.obric.cae.log.a.j("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: response is not a valid json");
        return new al(false, new ArrayList(), null, "invalid json");
    L5:
        if (r0.isJsonObject() == false) goto L130;
        JsonObject r1 = c(r0.getAsJsonObject(), "TEXT_SEARCH_MAP_POI");
        Integer r4 = b(r1, new String[]{"code"});
        String r5 = f(a(r1, new String[]{NotificationCompat.CATEGORY_MESSAGE, "message"}));
        JsonElement r6 = a(r1, 0);
        if (r6 != null) goto L10;
    L116:
        if (r4 != null) goto L118;
    L119:
        if (r4 == null) goto L121;
    L123:
        boolean r3 = false;
    L125:
        if (r3 == false) goto L128;
        com.obric.cae.log.a.d("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: cells is missing, treat as empty page, keys=" + c(r1));
        return new al(true, new ArrayList(), r4, r5);
    L128:
        com.obric.cae.log.a.j("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: response cells is missing, keys=" + c(r1));
        return new al(false, new ArrayList(), r4, r5);
    L121:
        if ("success".equalsIgnoreCase(r5) == false) goto L123;
    L122:
        r3 = true;
        goto L125
    L118:
        if (r4.intValue() == 0) goto L122;
    L10:
        if (r6.isJsonNull() == true) goto L116;
        if (r6.isJsonArray() == true) goto L16;
        com.obric.cae.log.a.j("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: cells is not json array");
        return new al(false, new ArrayList(), r4, r5);
    L16:
        ArrayList r2 = new ArrayList();
        Iterator<JsonElement> r7 = r6.getAsJsonArray().iterator();
        int r8 = 0;
    L18:
        if (r7.hasNext() == false) goto L114;
        JsonElement r9 = (JsonElement) ZeusTransformUtils.preCheckCast(r7.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L22;
    L108:
        Iterator<JsonElement> r27 = r7;
        ak r10 = null;
    L109:
        if (r10 == null) goto L113;
        r2.add(r10);
        if (TextUtils.isEmpty(r10.i) == true) goto L113;
        r8 = r8 + 1;
    L113:
        r7 = r27;
        goto L18
    L22:
        if (r9.isJsonObject() == false) goto L108;
        JsonObject r11 = r9.getAsJsonObject();
        JsonElement r12 = a(r11, "map_val");
        if (r12 != null) goto L27;
    L29:
        JsonObject r13 = null;
    L30:
        if (r13 != null) goto L32;
        r13 = r11;
    L32:
        String r14 = f(a(r13, new String[]{OaidModel.KEY_ID}));
        if (TextUtils.isEmpty(r14) == true) goto L108;
        JsonElement r15 = a(r11, "geo_json");
        if (r15 != null) goto L38;
    L40:
        JsonObject r16 = null;
    L41:
        if (r16 != null) goto L49;
        if (r13 == r11) goto L49;
        JsonElement r17 = a(r13, "geo_json");
        if (r17 != null) goto L46;
    L48:
        r16 = null;
        goto L49
    L46:
        if (r17.isJsonObject() == false) goto L48;
        r16 = r17.getAsJsonObject();
    L49:
        int r18 = 2;
        if (r16 != null) goto L52;
    L51:
        r27 = r7;
        JsonObject r19 = r13;
        String r22 = "";
    L97:
        Double r20 = c(r19, new String[]{"latitude"});
        Double r21 = c(r19, new String[]{"longitude"});
        if (r20 == null) goto L105;
        if (r21 == null) goto L105;
        double r23 = r20.doubleValue();
        double r24 = r21.doubleValue();
        Location r25 = new Location("");
        r25.setLatitude(r23);
        r25.setLongitude(r24);
        Location r26 = CoordinateTransformUtils.a(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r25);
        int r29 = 2;
        if (r26 == null) goto L106;
        double[] r30 = {r26.getLatitude(), r26.getLongitude()};
    L107:
        r10 = new ak(r14, f(a(r19, new String[]{ActivityLifecycle.NAME})), f(a(r19, new String[]{"province"})), f(a(r19, new String[]{"city"})), f(a(r19, new String[]{"district"})), f(a(r19, new String[]{MemoryKeyInfoEntity.KEY_ADDRESS})), f(a(r19, new String[]{"type_code"})), f(a(r19, new String[]{"type_name"})), r22, r30[0], r30[1]);
    L106:
        r30 = new double[r29];
        r30 = {x0342: FILL_ARRAY_DATA , data: [9221120237041090560, 9221120237041090560} // fill-array;
    L105:
        r29 = 2;
        goto L106
    L52:
        JsonArray r110 = a(a(r16, "polygon_coord"));
        if (r110 == null) goto L51;
        StringBuilder r111 = new StringBuilder();
        Iterator<JsonElement> r112 = r110.iterator();
    L57:
        if (r112.hasNext() == false) goto L91;
        JsonElement r31 = (JsonElement) ZeusTransformUtils.preCheckCast(r112.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r31 != null) goto L61;
    L71:
        boolean r32 = false;
    L72:
        if (r32 == true) goto L75;
    L73:
        Iterator<JsonElement> r210 = r7;
        JsonObject r33 = r13;
    L74:
        String r34 = "";
    L87:
        if (TextUtils.isEmpty(r34) == true) goto L90;
        r111.append(r34).append(';');
    L90:
        r13 = r33;
        r7 = r210;
        r18 = 2;
        goto L57
    L75:
        JsonArray r35 = r31.getAsJsonArray();
        r33 = r13;
        double r36 = r35.get(0).getAsDouble();     // Catch: Exception -> L85
        r210 = r7;
        double r37 = r35.get(1).getAsDouble();     // Catch: Exception -> L133
        Location r38 = new Location("");     // Catch: Exception -> L133
        r38.setLatitude(r37);     // Catch: Exception -> L133
        r38.setLongitude(r36);     // Catch: Exception -> L133
        Location r39 = CoordinateTransformUtils.a(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r38);     // Catch: Exception -> L133
        if (r39 == null) goto L74;
        r34 = r39.getLongitude() + "," + r39.getLatitude();     // Catch: Exception -> L133
    L85:
        r210 = r7;
        goto L74
    L61:
        if (r31.isJsonArray() == false) goto L71;
        JsonArray r40 = r31.getAsJsonArray();
        if (r40.size() < r18) goto L71;
        if (r40.get(0).isJsonPrimitive() == false) goto L71;
        if (r40.get(1).isJsonPrimitive() == false) goto L71;
        r32 = true;
        goto L72
    L91:
        r27 = r7;
        r19 = r13;
        if (r111.length() > 0) goto L94;
    L96:
        r22 = r111.toString();
        goto L97
    L94:
        if (r111.charAt(r111.length() - 1) != ';') goto L96;
        r111.deleteCharAt(r111.length() - 1);
        goto L96
    L38:
        if (r15.isJsonObject() == false) goto L40;
        r16 = r15.getAsJsonObject();
        goto L41
    L27:
        if (r12.isJsonObject() == false) goto L29;
        r13 = r12.getAsJsonObject();
        goto L30
    L114:
        com.obric.cae.log.a.f("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: parsed count=" + r2.size() + ", aoiBoardCount=" + r8);
        return new al(true, r2, r4, r5);
    }

    public static ap a(String r34, List r35) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        LinkedHashMap r4 = new LinkedHashMap();
        JsonElement r5 = h(r34);
        if (r5 != null) goto L5;
    L167:
        com.obric.cae.log.a.j("StarLocation-BdLM", "response is not a valid json");
        return new ap(r2, a(r4), r3);
    L5:
        if (r5.isJsonObject() == false) goto L167;
        JsonElement r6 = a(r5, "CELL_GEO_PROFILE");
        if (r6 != null) goto L10;
    L165:
        com.obric.cae.log.a.j("StarLocation-BdLM", "response payload is not json object");
        return new ap(r2, a(r4), r3);
    L10:
        if (r6.isJsonObject() == false) goto L165;
        JsonObject r7 = r6.getAsJsonObject();
        JsonElement r8 = r7.get("profiles_map");
        if (r8 != null) goto L15;
    L163:
        com.obric.cae.log.a.j("StarLocation-BdLM", "profiles_map is missing, payload keys=" + c(r7));
        return new ap(r2, a(r4), r3);
    L15:
        if (r8.isJsonObject() == false) goto L163;
        HashMap r9 = new HashMap();
        Iterator r1 = r0.iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        com.obric.cae.location.cell.c.b r10 = (com.obric.cae.location.cell.c.b) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.cae.location.cell.c.b.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        r9.put(r10.e(), r10);
        goto L19
    L23:
        Iterator<Map.Entry<String, JsonElement>> r11 = r8.getAsJsonObject().entrySet().iterator();
    L24:
        String r12 = "";
        if (r11.hasNext() == false) goto L157;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        com.obric.cae.location.cell.c.b r15 = (com.obric.cae.location.cell.c.b) ZeusTransformUtils.preCheckCast(r9.remove(r14), com.obric.cae.location.cell.c.b.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L28;
        JsonElement r16 = (JsonElement) ZeusTransformUtils.preCheckCast(r13.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L32;
    L155:
        Iterator<Map.Entry<String, JsonElement>> r20 = r11;
        HashMap r21 = r9;
        ArrayList r33 = r3;
        ArrayList r17 = r2;
        ArrayList r18 = r33;
        com.obric.cae.location.database.a.C0353a r19 = new com.obric.cae.location.database.a.C0353a(r15.getType(), r15.a(), r15.b(), r15.c(), r15.d());
        r19.c(-1.0d);
        r19.a("");
        r19.b("");
        r17.add(r19);
        r18.add(r15);
    L156:
        r11 = r20;
        r9 = r21;
        ArrayList r36 = r17;
        r3 = r18;
        r2 = r36;
        goto L24
    L32:
        if (r16.isJsonArray() == false) goto L155;
        Iterator<JsonElement> r22 = r16.getAsJsonArray().iterator();
    L36:
        if (r22.hasNext() == false) goto L151;
        JsonElement r110 = (JsonElement) ZeusTransformUtils.preCheckCast(r22.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L36;
        if (r110.isJsonObject() == false) goto L36;
        JsonObject r111 = r110.getAsJsonObject();
        String r112 = a(r111, new String[]{"Name", ActivityLifecycle.NAME});
        if (TextUtils.isEmpty(r112) == true) goto L47;
        if ("base_station_profile".equals(r112) == false) goto L36;
    L47:
        JsonElement r113 = a(r111, "Attributes");
        if (r113 == null) goto L36;
        if (r113.isJsonObject() == false) goto L36;
        JsonObject r114 = r113.getAsJsonObject();
        JsonElement r115 = a(r114, "aoi_list");
        String r116 = r15.e();
        JsonArray r117 = b(r115);
        if (r117 != null) goto L55;
    L79:
        r20 = r11;
        Iterator<JsonElement> r118 = r22;
        StringBuilder r23 = new StringBuilder("CELL_GEO_PROFILE aoi filter, cell=").append(r116).append(", rawCount=0, matchedCount=0");
    L80:
        com.obric.cae.log.a.f("StarLocation-BdLM", r23.toString());
        String r24 = r15.e();
        JsonArray r25 = b(r115);
        String r26 = "poiId";
        if (r25 != null) goto L83;
    L115:
        ArrayList r27 = r2;
        ArrayList r28 = r3;
        r21 = r9;
        String r119 = r26;
        String r29 = r12;
        Double r30 = c(r114, new String[]{"latitude"});
        Double r31 = c(r114, new String[]{"longitude"});
        Double r32 = c(r114, new String[]{"radius"});
        if (r30 == null) goto L149;
        if (r31 == null) goto L149;
        if (r32 == null) goto L149;
        com.obric.cae.location.database.a.C0353a r37 = new com.obric.cae.location.database.a.C0353a(r15.getType(), r15.a(), r15.b(), r15.c(), r15.d());
        String r120 = "aoiId";
        String r121 = "aoi_id";
        if (com.obric.cae.location.util.d.a().a(r30.doubleValue(), r31.doubleValue()) == true) goto L123;
        com.obric.cae.log.a.d("StarLocation-BdLM", "skip profile with invalid location, cell=" + r15.e());
        r22 = r118;
        r11 = r20;
        r9 = r21;
        r2 = r27;
        r12 = r29;
        r3 = r28;
        goto L36
    L123:
        r37.a(r30.doubleValue());
        r37.b(r31.doubleValue());
        r37.c(r32.doubleValue());
        r37.a(a(r114, new String[]{"poi_list"}));
        JsonArray r38 = b(r115);
        if (r38 != null) goto L126;
    L147:
        String r39 = r29;
    L148:
        r37.b(r39);
        com.obric.cae.location.cell.c.b r40 = r15.a(r30.doubleValue(), r31.doubleValue(), r32.doubleValue());
        r18 = r28;
        r18.add(r40);
    L152:
        if (r37 != null) goto L154;
        r37 = new com.obric.cae.location.database.a.C0353a(r15.getType(), r15.a(), r15.b(), r15.c(), r15.d());
        r37.c(-1.0d);
        String r41 = r29;
        r37.a(r41);
        r37.b(r41);
        r18.add(r15);
    L154:
        r17 = r27;
        r17.add(r37);
        goto L156
    L126:
        if (r38.isEmpty() == true) goto L147;
        StringBuilder r42 = new StringBuilder();
        Iterator<JsonElement> r43 = r38.iterator();
    L130:
        if (r43.hasNext() == false) goto L146;
        JsonElement r44 = (JsonElement) ZeusTransformUtils.preCheckCast(r43.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r44 == null) goto L130;
        if (r44.isJsonObject() == false) goto L130;
        JsonObject r45 = r44.getAsJsonObject();
        if (com.obric.cae.location.cell.c.a(a(r45)) == false) goto L130;
        String r122 = r120;
        String r123 = r119;
        String r124 = r121;
        String r46 = a(r45, new String[]{r124, r122, "poi_id", r123});
        if (TextUtils.isEmpty(r46) == false) goto L143;
    L141:
        r119 = r123;
        r120 = r122;
        r121 = r124;
        goto L130
    L143:
        if (r42.length() <= 0) goto L145;
        r42.append(';');
    L145:
        r42.append(r46);
        goto L141
    L146:
        r39 = r42.toString();
    L149:
        com.obric.cae.log.a.d("StarLocation-BdLM", "skip profile without location attrs, cell=" + r15.e());
        r3 = r28;
        r22 = r118;
        r11 = r20;
        r9 = r21;
        r2 = r27;
        r12 = r29;
        goto L36
    L83:
        if (r25.isEmpty() == true) goto L115;
        Iterator<JsonElement> r47 = r25.iterator();
    L87:
        if (r47.hasNext() == false) goto L115;
        r9 = r9;
        r47 = r47;
        JsonElement r48 = (JsonElement) ZeusTransformUtils.preCheckCast(r47.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r48 == null) goto L87;
        if (r48.isJsonObject() == false) goto L87;
        JsonObject r49 = r48.getAsJsonObject();
        String r50 = a(r49);
        if (com.obric.cae.location.cell.c.a(r50) == false) goto L87;
        ArrayList r210 = r2;
        String r51 = a(r49, new String[]{"aoi_id", "aoiId", "poi_id", r26});
        if (TextUtils.isEmpty(r51) == true) goto L98;
        String r211 = r12;
        ArrayList r212 = r3;
        ao r52 = (ao) ZeusTransformUtils.preCheckCast(r4.get(r51), ao.class, "com.obric.memorydata.plugin");
        if (r52 != null) goto L111;
        AoiBoard r125 = new AoiBoard();
        r125.setPoiId(r51);
        String r53 = f(a(r49, new String[]{ActivityLifecycle.NAME, "Name", "poi_name", "poiName", "aoi_name", "aoiName"}));
        if (TextUtils.isEmpty(r53) == false) goto L104;
        r53 = r51;
    L104:
        r125.setPoiName(r53);
        r125.setAoiBoard(com.obric.cae.location.util.c.a(a(r49, "geometry")));
        if (com.obric.cae.location.cell.c.b(r50) == false) goto L107;
        AoiBoard.Type r54 = AoiBoard.Type.MALL;
    L108:
        r125.setType(r54);
        r52 = new ao(r125, r50);
        r4.put(r51, r52);
        goto L111
    L107:
        r54 = AoiBoard.Type.UNKNOWN;
    L111:
        if (r52.c.contains(r24) == true) goto L113;
        r52.c.add(r24);
    L113:
        r26 = r26;
        r2 = r210;
        r12 = r211;
        r3 = r212;
        goto L87
    L98:
        r2 = r210;
        goto L87
    L55:
        if (r117.isEmpty() == true) goto L79;
        int r55 = 0;
        Iterator<JsonElement> r126 = r117.iterator();
        String r127 = r12;
    L58:
        r20 = r11;
        if (r126.hasNext() == false) goto L78;
        r22 = r22;
        JsonElement r56 = (JsonElement) ZeusTransformUtils.preCheckCast(r126.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r56 != null) goto L63;
    L76:
        r127 = r127;
    L77:
        r11 = r20;
        goto L58
    L63:
        if (r56.isJsonObject() == false) goto L76;
        String r57 = a(r56.getAsJsonObject());
        if (com.obric.cae.location.cell.c.a(r57) == false) goto L76;
        int r58 = r55 + 1;
        if (r127.length() >= 128) goto L75;
        if (r127.isEmpty() == true) goto L73;
        r127 = r127.concat(",");
    L73:
        r127 = new StringBuilder().append(r127).append(r57).toString();
    L75:
        r55 = r58;
        goto L77
    L78:
        r118 = r22;
        r23 = com.obric.cae.location.city.f.a("CELL_GEO_PROFILE aoi filter, cell=", r116, ", rawCount=").append(r117.size()).append(", matchedCount=").append(r55).append(", matchedTypes=").append(r127);
        goto L80
    L151:
        r20 = r11;
        r27 = r2;
        r18 = r3;
        r21 = r9;
        r29 = r12;
        r37 = null;
        goto L152
    L28:
        com.obric.cae.log.a.d("StarLocation-BdLM", "ignore unexpected cell id=" + r14);
        goto L24
    L157:
        ArrayList r310 = r3;
        ArrayList r59 = r2;
        Iterator r60 = r9.values().iterator();
    L159:
        if (r60.hasNext() == false) goto L162;
        com.obric.cae.location.cell.c.b r61 = (com.obric.cae.location.cell.c.b) ZeusTransformUtils.preCheckCast(r60.next(), com.obric.cae.location.cell.c.b.class, "com.obric.memorydata.plugin");
        com.obric.cae.location.database.a.C0353a r128 = new com.obric.cae.location.database.a.C0353a(r61.getType(), r61.a(), r61.b(), r61.c(), r61.d());
        r128.c(-1.0d);
        r128.a("");
        r128.b("");
        r59.add(r128);
        r310.add(r61);
        goto L159
    L162:
        return new ap(r59, a(r4), r310);
    }

    public static b a(AbstractC0355a r7, String r8, Callable r9) {
        Callable r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r9, Callable.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        if (r7 != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-BdLM", r8.concat(": request is null"));
        return null;
    L7:
        if (TextUtils.isEmpty(r7.f7093a) == false) goto L9;
    L33:
        com.obric.cae.log.a.j("StarLocation-BdLM", r8.concat(": origin or destination is empty"));
        return null;
    L9:
        if (TextUtils.isEmpty(r7.f7094b) == true) goto L33;
        if (com.obric.cae.location.util.d.a().e() == true) goto L16;
        com.obric.cae.log.a.h("StarLocation-BdLM", r8.concat(": network disconnected"));
        return null;
    L16:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L35;
        com.obric.cae.log.a.h("StarLocation-BdLM", r8.concat(": cannot execute synchronously on main thread"));
        return null;
    L35:
        b r11 = (b) ZeusTransformUtils.preCheckCast(f.submit(r10).get(e, TimeUnit.MILLISECONDS), b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        StringBuilder r12 = new StringBuilder().append(r8).append(": search cost ").append(System.currentTimeMillis() - r2).append("ms, status=");     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        if (r11 == null) goto L22;
        Integer r1 = r11.f7123a;     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
    L23:
        com.obric.cae.log.a.f("StarLocation-BdLM", r12.append(r1).append(", routeCount=").append(a(r11)).toString());     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        return r11;
    L22:
        r1 = null;
    L27:
        e = e;
        String r13 = ": runtime error";
    L31:
        com.obric.cae.log.a.b("StarLocation-BdLM", r8.concat(r13), e);
        return null;
    L29:
        e = e;
        r13 = ": request timeout";
    L25:
        e = e;
        r13 = ": unexpected error";
        goto L31
    }

    public static a a() {
        return f7091a;
    }

    public static String a(Bundle r6) {
        StringBuilder r0 = new StringBuilder("{");
        Iterator<String> r1 = r6.keySet().iterator();
        boolean r2 = true;
    L4:
        if (r1.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L8;
        r0.append(", ");
    L8:
        r2 = false;
        r0.append(r3).append("=").append(r6.get(r3));
        goto L4
    L9:
        r0.append("}");
        return r0.toString();
    }

    public static String a(JsonObject r6) {
        String r0 = f(a(r6, new String[]{"type", "Type", "type_code", "typeCode", "aoi_type", "aoiType"}));
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        JsonElement r7 = a(r6, "type");
        if (r7 != null) goto L8;
        return "";
    L8:
        if (r7.isJsonNull() == false) goto L11;
        return "";
    L11:
        if (r7.isJsonObject() == false) goto L15;
        return f(a(r7.getAsJsonObject(), new String[]{"code", com.tom_roush.pdfbox.pdmodel.a.d.i.K, "type_code", "typeCode", OaidModel.KEY_ID, "Id"}));
    L15:
        if (r7.isJsonNull() == false) goto L18;
        return "";
    L18:
        if (r7.isJsonPrimitive() == false) goto L21;
        return r7.getAsString();
    L21:
        return r7.toString();
    }

    public static String a(JsonObject r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        JsonElement r2 = a(r4, r5[r1]);
        if (r2 == null) goto L13;
        if (r2.isJsonNull() == true) goto L13;
        if (r2.isJsonPrimitive() == false) goto L13;
        return r2.getAsString();
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return null;
    }

    public static ArrayList a(com.obric.cae.location.geosdk.poi.a r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r2 = r10.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L27;
        com.obric.cae.location.database.c.a r5 = (com.obric.cae.location.database.c.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.cae.location.database.c.a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        if (r5.a() == null) goto L4;
        if (com.obric.cae.location.cell.c.b(r5.c()) == false) goto L23;
        AoiBoard r6 = r5.a();
        if (r6 == null) goto L23;
        if (TextUtils.isEmpty(r6.getPoiId()) == true) goto L23;
        AoiBoard r7 = r8.e(r6.getPoiId());
        if (r7 == null) goto L23;
        if (TextUtils.isEmpty(r7.getAoiBoard()) == true) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == true) goto L25;
        r0.add(r5.a());
        goto L4
    L25:
        r4 = r4 + 1;
    L23:
        r11 = false;
        goto L24
    L27:
        if (r4 <= 0) goto L29;
        com.obric.cae.log.a.d("StarLocation-BdLM", com.obric.cae.libs.statemachine.d.a("CELL_GEO_PROFILE skip existing mall aoi boards, count=", r4, ", input count=").append(r10.size()).toString());
    L29:
        return r0;
    }

    public static ArrayList a(LinkedHashMap r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        ao r1 = (ao) ZeusTransformUtils.preCheckCast(r7.next(), ao.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        AoiBoard r2 = r1.f7117a;
        if (r2 == null) goto L4;
        r0.add(new com.obric.cae.location.database.c.a(r2, TextUtils.join(";", r1.c), r1.f7118b));
        goto L4
    L11:
        return r0;
    }

    public static HashMap a(Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r5.isEmpty() == true) goto L14;
        Iterator r1 = r5.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        Object r3 = r5.get(r2);
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        r0.put(String.valueOf(r2), String.valueOf(r3));
        goto L9
    }

    public static void a(Bundle r7, String r8, JsonElement r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.isJsonNull() == false) goto L7;
        return;
    L7:
        if (r9.isJsonObject() == false) goto L15;
        JsonObject r10 = r9.getAsJsonObject();
        Bundle r0 = new Bundle();
        Iterator<Map.Entry<String, JsonElement>> r11 = r10.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(r0, (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r2.getValue(), JsonElement.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        r7.putBundle(r8, r0);
        return;
    L15:
        if (r9.isJsonArray() == false) goto L35;
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        Iterator<JsonElement> r12 = r9.getAsJsonArray().iterator();
    L18:
        if (r12.hasNext() == false) goto L32;
        JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r12.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L22;
    L27:
        if (r3 == null) goto L18;
        if (r3.isJsonNull() == true) goto L18;
        Bundle r4 = new Bundle();
        a(r4, EventBody.KEY_VALUE, r3);
    L31:
        r1.add(r4);
        goto L18
    L22:
        if (r3.isJsonObject() == false) goto L27;
        JsonObject r5 = r3.getAsJsonObject();
        r4 = new Bundle();
        Iterator<Map.Entry<String, JsonElement>> r6 = r5.entrySet().iterator();
    L25:
        if (r6.hasNext() == false) goto L31;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(r4, (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r13.getValue(), JsonElement.class, "com.obric.memorydata.plugin"));
        goto L25
    L32:
        r7.putParcelableArrayList(r8, r1);
        return;
    L35:
        if (r9.getAsJsonPrimitive().isBoolean() == false) goto L39;
        r7.putBoolean(r8, r9.getAsBoolean());
        return;
    L39:
        if (r9.getAsJsonPrimitive().isNumber() == false) goto L42;
        r7.putDouble(r8, r9.getAsNumber().doubleValue());
        return;
    L42:
        r7.putString(r8, r9.getAsString());
    }

    public static void a(Bundle r2, String r3, Double r4) {
        if (r4 == null) goto L5;
        r2.putDouble(r3, r4.doubleValue());
        return;
    }

    public static void a(Bundle r0, String r1, Integer r2) {
        if (r2 == null) goto L5;
        r0.putInt(r1, r2.intValue());
        return;
    }

    public static void a(JsonElement r23, String[] r24, String[] r25, LinkedHashMap r26, int r27) {
        if (r23 != null) goto L5;
        return;
    L5:
        if (r23.isJsonNull() == false) goto L7;
        return;
    L7:
        if (r27 <= 10) goto L10;
        return;
    L10:
        if (r23.isJsonArray() == false) goto L17;
        Iterator<JsonElement> r4 = r23.getAsJsonArray().iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        a((JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.memorydata.plugin"), r24, r25, r26, r27 + 1);
        goto L13
    L15:
        return;
    L17:
        if (r23.isJsonObject() == true) goto L19;
        return;
    L19:
        JsonObject r5 = r23.getAsJsonObject();
        com.obric.cae.location.database.d.a r7 = new com.obric.cae.location.database.d.a(a(r5, new String[]{"new_type_name_l1", "NewTypeNameL1", "newTypeNameL1"}), a(r5, new String[]{"new_type_name_l2", "NewTypeNameL2", "newTypeNameL2"}), a(r5, new String[]{"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"}), a(r5, new String[]{"new_type_code_l1", "NewTypeCodeL1", "newTypeCodeL1"}), a(r5, new String[]{"new_type_code_l2", "NewTypeCodeL2", "newTypeCodeL2"}), a(r5, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3"}));
        if (r7.a() == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        a(r26, r7);
    L25:
        String r8 = a(r5, new String[]{"type_name", "TypeName", "typeName", ActivityLifecycle.NAME, "Name", "new_type_name", "NewTypeName"});
        String r9 = a(r5, new String[]{"type_code", "TypeCode", "typeCode", com.tom_roush.pdfbox.pdmodel.a.d.i.K, "new_type_code", "NewTypeCode"});
        String[] r10 = (String[]) ZeusTransformUtils.preCheckCast(r24.clone(), String[].class, "com.obric.memorydata.plugin");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r25.clone(), String[].class, "com.obric.memorydata.plugin");
        Integer r12 = b(r5, new String[]{"level", Level.CATEGORY, "type_level", "TypeLevel"});
        if (r12 != null) goto L28;
    L32:
        int r13 = 0;
    L33:
        if (r13 >= 3) goto L40;
        if (TextUtils.isEmpty(r10[r13]) == false) goto L39;
        if (TextUtils.isEmpty(r11[r13]) == false) goto L39;
    L42:
        if (TextUtils.isEmpty(r8) == true) goto L44;
    L45:
        if (r13 >= 3) goto L47;
        r10[r13] = f(r8);
        r11[r13] = f(r9);
    L47:
        Iterator<Map.Entry<String, JsonElement>> r14 = r5.entrySet().iterator();
        boolean r15 = false;
    L49:
        if (r14.hasNext() == false) goto L59;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (c((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L49;
        if (r16.getValue() == null) goto L49;
        if (((JsonElement) ZeusTransformUtils.preCheckCast(r16.getValue(), JsonElement.class, "com.obric.memorydata.plugin")).isJsonArray() == false) goto L49;
        a((JsonElement) ZeusTransformUtils.preCheckCast(r16.getValue(), JsonElement.class, "com.obric.memorydata.plugin"), r10, r11, r26, r27 + 1);
        r15 = true;
        goto L49
    L59:
        if (r15 == false) goto L61;
    L65:
        Iterator<Map.Entry<String, JsonElement>> r6 = r5.entrySet().iterator();
    L67:
        if (r6.hasNext() == false) goto L106;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (c((String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.memorydata.plugin")) == true) goto L67;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.memorydata.plugin");
        if ("data".equalsIgnoreCase(r18) == true) goto L79;
        if ("result".equalsIgnoreCase(r18) == true) goto L79;
        if (Constants.KEY_LIST.equalsIgnoreCase(r18) == true) goto L79;
        if ("items".equalsIgnoreCase(r18) == false) goto L67;
    L79:
        a((JsonElement) ZeusTransformUtils.preCheckCast(r17.getValue(), JsonElement.class, "com.obric.memorydata.plugin"), r24, r25, r26, r27 + 1);
        goto L67
    L106:
        return;
    L61:
        if (TextUtils.isEmpty(r8) == true) goto L63;
    L64:
        a(r26, new com.obric.cae.location.database.d.a(r10[0], r10[1], r10[2], r11[0], r11[1], r11[2]));
        goto L65
    L63:
        if (TextUtils.isEmpty(r9) == true) goto L65;
    L44:
        if (TextUtils.isEmpty(r9) == true) goto L47;
    L39:
        r13 = r13 + 1;
        goto L33
    L40:
        r13 = 2;
        goto L42
    L28:
        if (r12.intValue() < 1) goto L32;
        if (r12.intValue() > 3) goto L32;
        r13 = r12.intValue() - 1;
        goto L42
    }

    public static void a(AbstractC0355a r4, HashMap r5) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.get("origin_uid"), String.class, "com.obric.memorydata.plugin");
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        r4.c = r0;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.get("destination_uid"), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r4.d = r2;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5.get("output"), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        r4.g = r3;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("sn"), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r4.h = r6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get("callback"), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r1 = r7;
    L21:
        r4.j = r1;
        long r8 = 0;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.get("timestamp"), String.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L29;
    L27:
        r4.i = r8;
        return;
    L29:
        r8 = Long.parseLong(r9);     // Catch: NumberFormatException -> L26
    L26:
        com.obric.cae.log.a.h("StarLocation-BdLM", "invalid long extra timestamp=".concat(r9));
        goto L27
    }

    public static void a(LinkedHashMap r3, com.obric.cae.location.database.d.a r4) {
        if (r4.a() == true) goto L5;
        return;
    L5:
        r3.put(r4.d + "|" + r4.e + "|" + r4.f + "|" + r4.f7089a + "|" + r4.f7090b + "|" + r4.c, r4);
    }

    public static void a(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        com.obric.cae.location.database.c.a r5 = (com.obric.cae.location.database.c.a) ZeusTransformUtils.preCheckCast(r4.get(0), com.obric.cae.location.database.c.a.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.f("StarLocation-BdLM", "CELL_GEO_PROFILE first aoi board, poiId=" + r5.a().getPoiId() + ", typeCode=" + r5.c() + ", cells=" + r5.b());
    }

    public static JsonArray b(JsonElement r2) {
        if (r2 != null) goto L5;
    L19:
        return null;
    L5:
        if (r2.isJsonNull() == true) goto L19;
        if (r2.isJsonArray() == false) goto L12;
        return r2.getAsJsonArray();
    L12:
        if (r2.isJsonPrimitive() == false) goto L19;
        JsonElement r3 = h(r2.getAsString());
        if (r3 == null) goto L19;
        if (r3.isJsonArray() == false) goto L19;
        return r3.getAsJsonArray();
    }

    public static JsonObject b(JsonObject r11) {
        JsonObject r2 = null;
        if (r11.has("encrypt_data") == false) goto L9;
        if (r11.get("encrypt_data").isJsonPrimitive() == false) goto L9;
        JsonElement r0 = r11.get("encrypt_data");
    L7:
        String r1 = r0.getAsString();
    L27:
        if (TextUtils.isEmpty(r1) == false) goto L29;
    L101:
        return r11;
    L29:
        if (TextUtils.isEmpty(r1) == false) goto L107;
        r1 = null;
    L41:
        if (TextUtils.isEmpty(r1) == true) goto L101;
        JsonElement r3 = JsonParser.parseString(r1);     // Catch: Exception -> L99
        aj r4 = (aj) ZeusTransformUtils.preCheckCast(g.fromJson(r1, aj.class), aj.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
    L47:
        if (r4 == null) goto L54;
        Number r7 = r4.f7107a;     // Catch: Exception -> L99
        if (r7 == null) goto L51;
        r11.addProperty("code", r7);     // Catch: Exception -> L99
    L51:
        String r8 = r4.c;     // Catch: Exception -> L99
        if (r8 == null) goto L54;
        r11.addProperty(NotificationCompat.CATEGORY_MESSAGE, r8);     // Catch: Exception -> L99
    L54:
        boolean r9 = true;
        if (r4 == null) goto L66;
        ah r10 = r4.f7108b;     // Catch: Exception -> L99
        if (r10 == null) goto L66;
        List<ai> r12 = r10.f7103a;     // Catch: Exception -> L99
        if (r12 == null) goto L66;
        if (r12.isEmpty() == true) goto L66;
        r11.add("data", g.toJsonTree(r4.f7108b));     // Catch: Exception -> L99
        if (r11.has("code") == true) goto L65;
        r11.addProperty("code", 0);     // Catch: Exception -> L99
    L65:
        boolean r5 = true;
    L68:
        if (r5 == true) goto L82;
        if (r3 == null) goto L82;
        JsonElement r6 = c(r3);     // Catch: Exception -> L99
        if (r6 != null) goto L73;
    L76:
        JsonObject r13 = null;
    L77:
        if (r13 == null) goto L82;
        r11.add("data", r13);     // Catch: Exception -> L99
        if (r11.has("code") == true) goto L81;
        r11.addProperty("code", 0);     // Catch: Exception -> L99
    L81:
        r5 = true;
        goto L82
    L73:
        if (r6.isJsonArray() == false) goto L76;
        r13 = new JsonObject();     // Catch: Exception -> L99
        r13.add("poi_list", r6);     // Catch: Exception -> L99
        r13.add("poiList", r6);     // Catch: Exception -> L99
    L82:
        if (r5 == false) goto L84;
    L95:
        r9 = r5;
    L96:
        if (r9 == true) goto L101;
        com.obric.cae.log.a.h("StarLocation-BdLM", "POI_SEARCH: unsupported poi payload shape after normalization");     // Catch: Exception -> L99
        goto L101
    L84:
        if (r11.has("data") == true) goto L95;
        JsonElement r14 = c(r11);     // Catch: Exception -> L99
        if (r14 != null) goto L88;
    L91:
        if (r2 == null) goto L95;
        r11.add("data", r2);     // Catch: Exception -> L99
        if (r11.has("code") == true) goto L96;
        r11.addProperty("code", 0);     // Catch: Exception -> L99
        goto L96
    L88:
        if (r14.isJsonArray() == false) goto L91;
        r2 = new JsonObject();     // Catch: Exception -> L99
        r2.add("poi_list", r14);     // Catch: Exception -> L99
        r2.add("poiList", r14);     // Catch: Exception -> L99
    L66:
        r5 = false;
    L45:
        r4 = null;
    L99:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Failed to parse decrypted data", e);
        goto L101
    L107:
        byte[] r15 = Base64.decode(r1, 0);     // Catch: Throwable -> L38
        if (com.obric.cae.location.util.d.a().h() == true) goto L34;
        com.obric.cae.log.a.h("StarLocation-BdLM", "POI_SEARCH: Crypto SDK not ready");     // Catch: Throwable -> L38
    L106:
        goto L41
    L34:
        byte[] r16 = CloudTransCryptoManager.getInstance().dataDecrypt(r15);     // Catch: Throwable -> L38
        if (r16 == null) goto L106;
        r1 = new String(r16, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Decrypt failed", th);
    L9:
        if (r11.has("data") == false) goto L25;
        JsonElement r17 = r11.get("data");
        if (r17 != null) goto L13;
    L19:
        if (r17 == null) goto L25;
        if (r17.isJsonPrimitive() == false) goto L25;
        if (r17.getAsJsonPrimitive().isString() == false) goto L25;
        r1 = r17.getAsString();
        goto L27
    L13:
        if (r17.isJsonObject() == false) goto L19;
        JsonObject r18 = r17.getAsJsonObject();
        if (r18.has("encrypt_data") == false) goto L25;
        if (r18.get("encrypt_data").isJsonPrimitive() == false) goto L25;
        r0 = r18.get("encrypt_data");
    L25:
        r1 = null;
        goto L27
    }

    public static JsonObject b(JsonObject r6, String r7) {
        JsonObject r3 = new JsonObject();
        String r8 = r6.toString();
        byte[] r4 = r8.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L11
        if (com.obric.cae.location.util.d.a().h() == true) goto L7;
        com.obric.cae.log.a.h("StarLocation-BdLM", r7.concat(": Crypto SDK not ready"));     // Catch: Throwable -> L11
        r3.addProperty("encrypt_data", r8);     // Catch: Throwable -> L11
        return r3;
    L7:
        byte[] r2 = CloudTransCryptoManager.getInstance().dataEncrypt(r4);     // Catch: Throwable -> L11
        if (r2 == null) goto L13;
        r3.addProperty("encrypt_data", Base64.encodeToString(r2, 2));     // Catch: Throwable -> L11
        return r3;
    L13:
        r3.addProperty("encrypt_data", r8);
        return r3;
    L11:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", r7.concat(": Encrypt failed"), th);
        goto L13
    }

    public static JsonObject b(String r2, int r3, int r4, String r5, String r6) {
        JsonObject r0 = new JsonObject();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r0.addProperty("keyword", r2);
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r0.addProperty("index", r5);
    L9:
        if (r3 > 0) goto L11;
        if (r4 > 0) goto L11;
    L21:
        if (TextUtils.isEmpty(r6) == true) goto L23;
        r0.addProperty("dsl", r6);
    L23:
        return r0;
    L11:
        JsonObject r7 = new JsonObject();
        if (r3 > 0) goto L15;
        r3 = 1;
    L15:
        r7.addProperty("num", Integer.valueOf(r3));
        if (r4 > 0) goto L19;
        r4 = 15;
    L19:
        r7.addProperty("size", Integer.valueOf(r4));
        r0.add("page", r7);
        goto L21
    }

    public static JsonObject b(List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JsonObject r0 = new JsonObject();
        JsonArray r2 = new JsonArray();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        com.obric.cae.location.cell.c.b r3 = (com.obric.cae.location.cell.c.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.cae.location.cell.c.b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        r2.add(r3.e());
        goto L4
    L8:
        JsonArray r8 = new JsonArray();
        JsonObject r1 = new JsonObject();
        r1.addProperty(ActivityLifecycle.NAME, "base_station_profile");
        r1.addProperty("version", LocationInfoConst.LIBRA_PARAM_V1);
        r1.addProperty("privacy", 0);
        r8.add(r1);
        r0.add("ids", r2);
        r0.addProperty("id_type", 7);
        r0.add("profiles", r8);
        return r0;
    }

    private ad b(ac r8) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "");
        HashMap r4 = e();     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r4 == null) goto L33;
        aq r7 = a(e("/poi_server/api/v1/bmap/walking"), b(a(r8), "WALKING_SEARCH").toString(), r4);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        r8.k = r7.c;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        String r9 = r7.f7121a;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r9 != null) goto L10;
        String r10 = "response is null";
    L9:
        com.obric.cae.log.a.j("StarLocation-BdLM", r10);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        return null;
    L10:
        JsonElement r11 = g(r9);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r11 != null) goto L13;
    L22:
        r10 = "response is not a valid json object";
        goto L9
    L13:
        if (r11.isJsonObject() == false) goto L22;
        ad r12 = f(c(r11.getAsJsonObject(), "WALKING_SEARCH"));     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r12 != null) goto L19;
        r10 = "parsed response is null";
        goto L9
    L19:
        if (r12.a() == true) goto L35;
        com.obric.cae.log.a.j("StarLocation-BdLM", "status=" + r12.f7123a + ", message=" + r12.f7124b);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
    L35:
        return r12;
    L33:
        return null;
    L26:
        e = e;
        String r13 = "catch RuntimeException";
    L30:
        com.obric.cae.log.a.b("StarLocation-BdLM", r13, e);
        return null;
    L28:
        e = e;
        r13 = "catch SocketTimeoutException";
    L24:
        e = e;
        r13 = "catch Exception";
        goto L30
    }

    public static Integer b(JsonObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        JsonElement r3 = a(r5, r6[r1]);
        if (r3 == null) goto L13;
        if (r3.isJsonNull() == true) goto L13;
        return Integer.valueOf(r3.getAsInt());
    L12:
        return null;
    L13:
        r1 = r1 + 1;
        goto L4
    L14:
        return null;
    }

    public static ArrayList b(String r4) {
        JsonElement r5 = h(r4);
        if (r5 != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "response is not a valid json");
        return new ArrayList();
    L6:
        JsonElement r6 = a(r5, "POI_TYPE_DATA");
        LinkedHashMap r0 = new LinkedHashMap();
        a(r6, new String[3], new String[3], r0, 0);
        return new ArrayList(r0.values());
    }

    public static JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put(LocationSettingUtil.LOCATION_SDK_SETTINGS_KEY, new JSONObject("{\n    \"locationsdk_config_android\":{\n        \"collect_extra_gps\":false,\n        \"base_station_info_type\":0,\n        \"scan_ble_interval\":1000,\n        \"enable_collect_gnss_measurements\":false,\n        \"enable_tail_locate_optimize\":true,\n        \"cold_boot_collect_gps\":true,\n        \"async_scan_wifi\":false,\n        \"stationary_scene_max_interval\":1800000,\n        \"scan_wifi_interval\":0,\n        \"enable_collect_ble_in_battery_saving_mode\":false,\n        \"cold_boot_collect_gps_strategy\":1,\n        \"max_wait_gps_time_millis\":0,\n        \"enable_check_wifi_cache\":false,\n        \"stationary_scene_wifi_white_list\":\"Airport,Public,ChinaUnicom,China Unicom,UNICOM,ChinaMobile,China Mobile,CMCC,ChinaTelecom,China Telecom,Car,Auto\",\n        \"locate_type\":1,\n        \"check_wifi_cache_duration\":10000,\n        \"report_har\":true,\n        \"collect_gps_type\":1,\n        \"enable_location_opt_bpea_list\":\"\",\n        \"collect_continuous_gps_interval\":5000,\n        \"enable_collect_network_location_in_battery_saving_mode\":true,\n        \"stationary_scene_max_distance\":50,\n        \"upload_ble_num\":30,\n        \"use_new_reverse_geolocation_api\":true,\n        \"enable_destroy_amap_single_client\":true,\n        \"enable_dim_location_check\":true,\n        \"report_at_start\":true,\n        \"collect_config\":true,\n        \"monitor_strategy\":0,\n        \"use_new_cache_strategy\":true,\n        \"max_light_duration\":5000,\n        \"overseas_get_location_failed_cache_validity_time\":28800000,\n        \"check_location_bpea\":false,\n        \"report_wifi_max\":120,\n        \"new_network_change_register\":true,\n        \"enable_check_upload_compliance\":false,\n        \"enable_scan_wifi\":true,\n        \"report_bss_max\":10,\n        \"report_location_at_start\":false,\n        \"enable_traceroute\":false,\n        \"search_location_cache_time\":-1,\n        \"monitor_strategy_interval\":10000,\n        \"enable_check_last_log_id\":false,\n        \"enable_light_location_new_policy\":true,\n        \"enable_destroy_amap_continuous_client\":true,\n        \"allow_light_Location\":true,\n        \"report_gps\":true,\n        \"report_bss\":true,\n        \"enable_monitor\":true,\n        \"scan_gnss\":false,\n        \"enable_gps_scan\":true,\n        \"report_interval_seconds\":300,\n        \"check_connect_wifi_rssi\":-60,\n        \"need_downgrade_location_in_overseas\":true,\n        \"polling_upload\":false,\n        \"report_wifi\":true,\n        \"enable_collect_amap_location_in_battery_saving_mode\":false,\n        \"enable_use_coarse_location\":true,\n        \"enable_byte_continuous_location\":\"true\",\n        \"fresh_base_station_timeout\":0,\n        \"tail_accuracy_threshold\":100,\n        \"enable_stationary_scene_policy\":false,\n        \"enable_info_request_opt\":true,\n        \"byte_location_libra_param\":\"v2\",\n        \"enable_collect_gps_location_in_battery_saving_mode\":true,\n        \"collect_continuous_gps_duration\":5000,\n        \"tail_wifi_time_threshold\":60000,\n        \"hot_boot_cache_time\":180,\n        \"red_geo_name_ids\":\"1814991,1819730,1821275\",\n        \"upload_fresh_base_station\":true,\n        \"collect_continuous_gps_only_last\":true,\n        \"light_info_interval\":0,\n        \"use_cache_condition\":true,\n        \"collect_light_info\":true,\n        \"cold_boot_ab_test\":false,\n        \"default_gps_scan_interval\":15000,\n        \"report_har_range\":15,\n        \"collect_continuous_gps_enable\":true,\n        \"info_request_key_params_max_cache_time\":86400000,\n        \"stationary_scene_max_gps_accuracy\":50,\n        \"scan_ble\":true,\n        \"pre_location_callback\":false,\n        \"enable_check_connect_wifi\":false,\n        \"enable_background_upload_location\":false,\n        \"max_light_count\":30,\n        \"collect_extra_gps_timeout\":5000,\n        \"use_gps_check_region\":true\n    }\n}"));     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "failed: " + e.getMessage(), e);
        goto L7
    }

    public static boolean b(JsonElement r3, int r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isJsonNull() == false) goto L7;
        return false;
    L7:
        if (r4 <= 3) goto L10;
        return false;
    L10:
        if (r3.isJsonPrimitive() == false) goto L18;
        if (r3.getAsJsonPrimitive().isString() == false) goto L18;
        JsonElement r1 = h(r3.getAsString());
        if (r1 == null) goto L18;
        r3 = r1;
    L18:
        if (r3.isJsonObject() == true) goto L20;
        return false;
    L20:
        JsonObject r5 = r3.getAsJsonObject();
        Boolean r2 = k(r5);
        if (r2 != null) goto L23;
        JsonObject r6 = c(r5, "POI_CERT_EXPIRED");
        Boolean r7 = k(r6);
        if (r7 != null) goto L27;
        int r8 = r4 + 1;
        if (b(r6.get("data"), r8) == true) goto L35;
        if (b(r6.get("result"), r8) == true) goto L35;
        if (b(r6.get("error"), r8) == true) goto L35;
        return false;
    L35:
        return true;
    L27:
        return r7.booleanValue();
    L23:
        return r2.booleanValue();
    }

    public static JsonElement c(JsonElement r3) {
        if (r3 != null) goto L5;
    L36:
        return null;
    L5:
        if (r3.isJsonNull() == true) goto L36;
        if (r3.isJsonArray() == false) goto L11;
        return r3;
    L11:
        if (r3.isJsonPrimitive() == false) goto L18;
        if (r3.getAsJsonPrimitive().isString() == false) goto L18;
        return c(h(r3.getAsString()));
    L16:
        return null;
    L18:
        if (r3.isJsonObject() == true) goto L20;
        return null;
    L20:
        JsonObject r4 = r3.getAsJsonObject();
        String r1 = "poiList";
        if (r4.has("poiList") == true) goto L24;
        r1 = "poi_list";
    L24:
        JsonElement r2 = r4.get(r1);
        if (r2 != null) goto L27;
    L30:
        JsonElement r5 = r4.get("data");
        if (r5 == null) goto L36;
        if (r5.isJsonNull() == true) goto L36;
        return c(r5);
    L27:
        if (r2.isJsonNull() == true) goto L30;
        return c(r2);
    }

    public static JsonObject c(JsonObject r7, String r8) {
        String r4 = null;
        if (r7.has("encrypt_data") == false) goto L9;
        if (r7.get("encrypt_data").isJsonPrimitive() == false) goto L9;
        JsonElement r3 = r7.get("encrypt_data");
    L7:
        String r5 = r3.getAsString();
    L27:
        if (TextUtils.isEmpty(r5) == false) goto L59;
        return r7;
    L59:
        byte[] r6 = Base64.decode(r5, 0);     // Catch: Throwable -> L38
        if (com.obric.cae.location.util.d.a().h() == true) goto L34;
        com.obric.cae.log.a.h("StarLocation-BdLM", r8.concat(": Crypto SDK not ready"));     // Catch: Throwable -> L38
        return r7;
    L34:
        byte[] r1 = CloudTransCryptoManager.getInstance().dataDecrypt(r6);     // Catch: Throwable -> L38
        if (r1 == null) goto L41;
        r4 = new String(r1, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L38
    L41:
        if (TextUtils.isEmpty(r4) == false) goto L43;
        return r7;
    L43:
        JsonElement r2 = g(r4);
        if (r2 != null) goto L48;
        com.obric.cae.log.a.j("StarLocation-BdLM", r8.concat(": failed to parse decrypted response"));
        return r7;
    L48:
        if (r7.has("data") == false) goto L51;
    L49:
        r7.add("data", r2);
    L58:
        return r7;
    L51:
        if (r7.has("encrypt_data") == false) goto L58;
        if (r2.isJsonObject() == false) goto L49;
        Iterator<Map.Entry<String, JsonElement>> r9 = r2.getAsJsonObject().entrySet().iterator();
    L56:
        if (r9.hasNext() == false) goto L58;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r7.add((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.memorydata.plugin"));
    L38:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", r8.concat(": Decrypt failed"), th);
    L9:
        if (r7.has("data") == false) goto L25;
        r3 = r7.get("data");
        if (r3 != null) goto L13;
    L17:
        if (r3 == null) goto L25;
        if (r3.isJsonObject() == false) goto L25;
        if (r3.getAsJsonObject().has("encrypt_data") == false) goto L25;
        if (r3.getAsJsonObject().get("encrypt_data").isJsonPrimitive() == false) goto L25;
        r3 = r3.getAsJsonObject().get("encrypt_data");
        goto L7
    L13:
        if (r3.isJsonPrimitive() == false) goto L17;
        if (r3.getAsJsonPrimitive().isString() == false) goto L17;
    L25:
        r5 = null;
        goto L27
    }

    private d c(c r8) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "");
        HashMap r4 = e();     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r4 == null) goto L33;
        aq r7 = a(e("/poi_server/api/v1/bmap/driving"), b(a(r8), "DRIVING_SEARCH").toString(), r4);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        r8.k = r7.c;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        String r9 = r7.f7121a;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r9 != null) goto L10;
        String r10 = "response is null";
    L9:
        com.obric.cae.log.a.j("StarLocation-BdLM", r10);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        return null;
    L10:
        JsonElement r11 = g(r9);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r11 != null) goto L13;
    L22:
        r10 = "response is not a valid json object";
        goto L9
    L13:
        if (r11.isJsonObject() == false) goto L22;
        d r12 = e(c(r11.getAsJsonObject(), "DRIVING_SEARCH"));     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r12 != null) goto L19;
        r10 = "parsed response is null";
        goto L9
    L19:
        if (r12.a() == true) goto L35;
        com.obric.cae.log.a.j("StarLocation-BdLM", "status=" + r12.f7123a + ", message=" + r12.f7124b);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
    L35:
        return r12;
    L33:
        return null;
    L26:
        e = e;
        String r13 = "catch RuntimeException";
    L30:
        com.obric.cae.log.a.b("StarLocation-BdLM", r13, e);
        return null;
    L28:
        e = e;
        r13 = "catch SocketTimeoutException";
    L24:
        e = e;
        r13 = "catch Exception";
        goto L30
    }

    private j c(i r8) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "executeRidingDirectionSearch");
        HashMap r4 = e();     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r4 == null) goto L33;
        aq r7 = a(e("/poi_server/api/v1/bmap/riding"), b(a(r8), "RIDING_SEARCH").toString(), r4);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        r8.k = r7.c;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        String r9 = r7.f7121a;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r9 != null) goto L10;
        String r10 = "response is null";
    L9:
        com.obric.cae.log.a.j("StarLocation-BdLM", r10);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        return null;
    L10:
        JsonElement r11 = g(r9);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r11 != null) goto L13;
    L22:
        r10 = "response is not a valid json object";
        goto L9
    L13:
        if (r11.isJsonObject() == false) goto L22;
        j r12 = g(c(r11.getAsJsonObject(), "RIDING_SEARCH"));     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r12 != null) goto L19;
        r10 = "parsed response is null";
        goto L9
    L19:
        if (r12.a() == true) goto L35;
        com.obric.cae.log.a.j("StarLocation-BdLM", "status=" + r12.f7123a + ", message=" + r12.f7124b);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
    L35:
        return r12;
    L33:
        return null;
    L26:
        e = e;
        String r13 = "catch RuntimeException";
    L30:
        com.obric.cae.log.a.b("StarLocation-BdLM", r13, e);
        return null;
    L28:
        e = e;
        r13 = "catch SocketTimeoutException";
    L24:
        e = e;
        r13 = "catch Exception";
        goto L30
    }

    private q c(p r8) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "");
        HashMap r4 = e();     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r4 == null) goto L33;
        aq r7 = a(e("/poi_server/api/v1/bmap/transit"), b(a(r8), "TRANSIT_SEARCH").toString(), r4);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        r8.k = r7.c;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        String r9 = r7.f7121a;     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r9 != null) goto L10;
        String r10 = "response is null";
    L9:
        com.obric.cae.log.a.j("StarLocation-BdLM", r10);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        return null;
    L10:
        JsonElement r11 = g(r9);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r11 != null) goto L13;
    L22:
        r10 = "response is not a valid json object";
        goto L9
    L13:
        if (r11.isJsonObject() == false) goto L22;
        q r12 = d(c(r11.getAsJsonObject(), "TRANSIT_SEARCH"));     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
        if (r12 != null) goto L19;
        r10 = "parsed response is null";
        goto L9
    L19:
        if (r12.a() == true) goto L35;
        com.obric.cae.log.a.j("StarLocation-BdLM", "status=" + r12.f7123a + ", message=" + r12.f7124b);     // Catch: Exception -> L24 RuntimeException -> L26 SocketTimeoutException -> L28
    L35:
        return r12;
    L33:
        return null;
    L26:
        e = e;
        String r13 = "catch RuntimeException";
    L30:
        com.obric.cae.log.a.b("StarLocation-BdLM", r13, e);
        return null;
    L28:
        e = e;
        r13 = "catch SocketTimeoutException";
    L24:
        e = e;
        r13 = "catch Exception";
        goto L30
    }

    private /* synthetic */ Boolean c(int r1) {
        return Boolean.valueOf(b(r1));
    }

    public static Double c(JsonObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        JsonElement r3 = a(r5, r6[r1]);
        if (r3 == null) goto L13;
        if (r3.isJsonNull() == true) goto L13;
        return Double.valueOf(r3.getAsDouble());
    L12:
        return null;
    L13:
        r1 = r1 + 1;
        goto L4
    L14:
        return null;
    }

    public static String c(JsonObject r7) {
        StringBuilder r0 = new StringBuilder("[");
        Iterator<Map.Entry<String, JsonElement>> r8 = r7.entrySet().iterator();
        boolean r2 = true;
        int r3 = 0;
    L4:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3 >= 12) goto L7;
        if (r2 == true) goto L10;
        r0.append(", ");
    L10:
        r0.append((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        r2 = false;
        goto L4
    L7:
        r0.append(", ...");
    L11:
        r0.append("]");
        return r0.toString();
    }

    public static boolean c(String r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if ("children".equalsIgnoreCase(r2) == false) goto L8;
    L39:
        return true;
    L8:
        if ("child".equalsIgnoreCase(r2) == true) goto L39;
        if ("sub_types".equalsIgnoreCase(r2) == true) goto L39;
        if ("subTypes".equalsIgnoreCase(r2) == true) goto L39;
        if ("sub_type_list".equalsIgnoreCase(r2) == true) goto L39;
        if ("subTypeList".equalsIgnoreCase(r2) == true) goto L39;
        if ("type_list".equalsIgnoreCase(r2) == true) goto L39;
        if ("typeList".equalsIgnoreCase(r2) == true) goto L39;
        if ("types".equalsIgnoreCase(r2) == true) goto L39;
        if ("backend_type_list".equalsIgnoreCase(r2) == true) goto L39;
        if ("backendTypeList".equalsIgnoreCase(r2) == true) goto L39;
        if ("backend_type_datas".equalsIgnoreCase(r2) == true) goto L39;
        if ("backendTypeDatas".equalsIgnoreCase(r2) == true) goto L39;
        if ("backend_types".equalsIgnoreCase(r2) == true) goto L39;
        if ("backendTypes".equalsIgnoreCase(r2) == true) goto L39;
        if ("type_datas".equalsIgnoreCase(r2) == true) goto L39;
        if ("typeDatas".equalsIgnoreCase(r2) == true) goto L39;
        return false;
    }

    public static aj d(String r10) {
        Gson r2 = g;
        monitor-enter(r2);
        ah r3 = null;
        JsonElement r4 = g(r10);     // Catch: Throwable -> L93 Exception -> L95
        if (r4 != null) goto L8;
    L11:
        if (r4 == null) goto L14;
        Object r5 = ZeusTransformUtils.preCheckCast(r2.fromJson(r4, aj.class), aj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93 Exception -> L95
    L10:
        aj r6 = (aj) r5;     // Catch: Throwable -> L93 Exception -> L95
    L15:
        if (r6 != null) goto L17;
    L103:
        JsonElement r11 = h(r10);     // Catch: Exception -> L89 Throwable -> L93
        if (r11 != null) goto L21;
    L91:
        monitor-exit(r2);     // Catch: Throwable -> L93
        return r6;
    L21:
        if (r11.isJsonObject() == false) goto L91;
        JsonObject r12 = b(r11.getAsJsonObject());     // Catch: Exception -> L89 Throwable -> L93
        if (r12.has("code") == false) goto L29;
        if (r12.get("code").isJsonNull() == true) goto L29;
        int r0 = r12.get("code").getAsInt();     // Catch: Exception -> L89 Throwable -> L93
    L27:
        Integer r1 = Integer.valueOf(r0);     // Catch: Exception -> L89 Throwable -> L93
    L50:
        if (r12.has(NotificationCompat.CATEGORY_MESSAGE) == false) goto L56;
        if (r12.get(NotificationCompat.CATEGORY_MESSAGE).isJsonNull() == true) goto L56;
        JsonElement r7 = r12.get(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Exception -> L89 Throwable -> L93
    L54:
        String r8 = r7.getAsString();     // Catch: Exception -> L89 Throwable -> L93
    L67:
        if (r12.has("data") == true) goto L69;
    L87:
        aj r13 = new aj();     // Catch: Exception -> L89 Throwable -> L93
        r13.f7107a = r1;     // Catch: Exception -> L89 Throwable -> L93
        r13.c = r8;     // Catch: Exception -> L89 Throwable -> L93
        r13.f7108b = r3;     // Catch: Exception -> L89 Throwable -> L93
        r6 = r13;
        goto L91
    L69:
        if (r12.get("data").isJsonNull() == true) goto L87;
        JsonElement r14 = r12.get("data");     // Catch: Exception -> L89 Throwable -> L93
        r3 = (ah) ZeusTransformUtils.preCheckCast(r2.fromJson(r14, ah.class), ah.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L89 Throwable -> L93
        if (r3 == null) goto L75;
        if (r3.f7103a != null) goto L87;
    L75:
        if (r14.isJsonObject() == false) goto L87;
        JsonObject r15 = r14.getAsJsonObject();     // Catch: Exception -> L89 Throwable -> L93
        if (r15.has("poiList") == false) goto L87;
        if (r15.get("poiList").isJsonArray() == false) goto L87;
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L89 Throwable -> L93
        Iterator<JsonElement> r16 = r15.get("poiList").getAsJsonArray().iterator();     // Catch: Exception -> L89 Throwable -> L93
    L82:
        if (r16.hasNext() == false) goto L84;
        r9.add((ai) ZeusTransformUtils.preCheckCast(g.fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r16.next(), JsonElement.class, "com.obric.memorydata.plugin"), ai.class), ai.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L89 Throwable -> L93
        goto L82
    L84:
        if (r3 != null) goto L86;
        r3 = new ah();     // Catch: Exception -> L89 Throwable -> L93
    L86:
        r3.f7103a = r9;     // Catch: Exception -> L89 Throwable -> L93
    L56:
        if (r12.has("message") == false) goto L61;
        if (r12.get("message").isJsonNull() == true) goto L61;
        r7 = r12.get("message");     // Catch: Exception -> L89 Throwable -> L93
    L61:
        if (r12.has("error_msg") == true) goto L63;
    L65:
        r8 = null;
        goto L67
    L63:
        if (r12.get("error_msg").isJsonNull() == true) goto L65;
        r7 = r12.get("error_msg");     // Catch: Exception -> L89 Throwable -> L93
    L29:
        if (r12.has("errno") == false) goto L34;
        if (r12.get("errno").isJsonNull() == true) goto L34;
        r0 = r12.get("errno").getAsInt();     // Catch: Exception -> L89 Throwable -> L93
    L34:
        if (r12.has("status") == false) goto L39;
        if (r12.get("status").isJsonNull() == true) goto L39;
        r0 = r12.get("status").getAsInt();     // Catch: Exception -> L89 Throwable -> L93
    L39:
        if (r12.has("ret") == false) goto L44;
        if (r12.get("ret").isJsonNull() == true) goto L44;
        r0 = r12.get("ret").getAsInt();     // Catch: Exception -> L89 Throwable -> L93
    L44:
        if (r12.has("error_code") == true) goto L46;
    L48:
        r1 = null;
        goto L50
    L46:
        if (r12.get("error_code").isJsonNull() == true) goto L48;
        r0 = r12.get("error_code").getAsInt();     // Catch: Exception -> L89 Throwable -> L93
    L89:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Fallback parse failed", e);     // Catch: Throwable -> L93
        goto L91
    L17:
        if (r6.f7107a != null) goto L91;
    L14:
        r6 = null;
        goto L15
    L8:
        if (r4.isJsonObject() == false) goto L11;
        r5 = ZeusTransformUtils.preCheckCast(r2.fromJson(b(r4.getAsJsonObject()), aj.class), aj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93 Exception -> L95
    L95:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Failed to parse json, response is: ".concat(r10), e);     // Catch: Throwable -> L93
        return null;
    L93:
        th = move-exception;
        throw th;
    }

    public static q d(JsonObject r8) {
        JsonObject r0 = h(r8);
        if (r0 != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-BdLM", "failed to find transit payload, root keys=" + r8.keySet());
        return null;
    L7:
        if (r0.has("result") == true) goto L9;
    L11:
        JsonObject r2 = null;
    L12:
        boolean r3 = false;
        if (r2 != null) goto L15;
    L50:
        Gson r4 = g;
        monitor-enter(r4);
        q r5 = (q) ZeusTransformUtils.preCheckCast(r4.fromJson(r0, q.class), q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        monitor-exit(r4);     // Catch: Throwable -> L88
        if (r5 != null) goto L57;
        return null;
    L57:
        if (r5.f7123a != null) goto L66;
        Integer r1 = i(r0);
        r5.f7123a = r1;
        if (r1 != null) goto L61;
    L62:
        Integer r6 = i(r8);
        if (r6 == null) goto L66;
        r5.f7123a = r6;
        goto L66
    L61:
        if (r1.intValue() == 0) goto L62;
    L66:
        if (TextUtils.isEmpty(r5.f7124b) == false) goto L71;
        String r7 = j(r0);
        r5.f7124b = r7;
        if (TextUtils.isEmpty(r7) == false) goto L71;
        r5.f7124b = j(r8);
    L71:
        if (r5.e == null) goto L73;
    L83:
        StringBuilder r9 = new StringBuilder(" normalized payload keys=").append(r0.keySet()).append(", status=").append(r5.f7123a).append(", message=").append(r5.f7124b).append(", hasResult=");
        if (r5.e == null) goto L86;
        r3 = true;
    L86:
        com.obric.cae.log.a.f("StarLocation-BdLM", r9.append(r3).toString());
        return r5;
    L73:
        if (r0.has("result") == false) goto L83;
        if (r0.get("result").isJsonObject() == false) goto L83;
        monitor-enter(r4);
        r5.e = (r) ZeusTransformUtils.preCheckCast(r4.fromJson(r0.getAsJsonObject("result"), r.class), r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L80
        monitor-exit(r4);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    L88:
        th = move-exception;
        throw th;
    L15:
        if (r2.has("routes") == false) goto L50;
        if (r2.get("routes").isJsonArray() == false) goto L50;
        JsonArray r10 = r2.getAsJsonArray("routes");
        int r11 = 0;
    L21:
        if (r11 >= r10.size()) goto L50;
        JsonElement r12 = r10.get(r11);
        if (r12 == null) goto L49;
        if (r12.isJsonObject() == false) goto L49;
        JsonObject r13 = r12.getAsJsonObject();
        if (r13.has("steps") == false) goto L49;
        JsonElement r14 = r13.get("steps");
        if (r14 == null) goto L49;
        if (r14.isJsonNull() == true) goto L49;
        if (r14.isJsonObject() == false) goto L39;
        JsonArray r15 = new JsonArray();
        r15.add(r14);
        JsonArray r16 = new JsonArray();
        r16.add(r15);
        r13.add("steps", r16);
        goto L49
    L39:
        if (r14.isJsonArray() == false) goto L49;
        JsonArray r17 = r14.getAsJsonArray();
        if (r17.size() == 0) goto L49;
        JsonElement r18 = r17.get(0);
        if (r18 == null) goto L49;
        if (r18.isJsonObject() == false) goto L49;
        JsonArray r19 = new JsonArray();
        r19.add(r17.deepCopy());
        r13.add("steps", r19);
    L49:
        r11 = r11 + 1;
        goto L21
    L9:
        if (r0.get("result").isJsonObject() == false) goto L11;
        r2 = r0.getAsJsonObject("result");
        goto L12
    }

    private /* synthetic */ Boolean d(int r1) {
        return Boolean.valueOf(b(r1));
    }

    public static void d(JsonElement r8) {
        if (r8.isJsonArray() == false) goto L14;
        Iterator<JsonElement> r9 = r8.getAsJsonArray().iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        if (r0.isJsonNull() == true) goto L6;
        d(r0);
        goto L6
    L12:
        return;
    L14:
        if (r8.isJsonObject() == true) goto L16;
        return;
    L16:
        JsonObject r10 = r8.getAsJsonObject();
        Iterator r1 = new ArrayList(r10.keySet()).iterator();
    L18:
        if (r1.hasNext() == false) goto L93;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JsonElement r3 = r10.get(r2);
        if (r3 == null) goto L18;
        if (r3.isJsonNull() == true) goto L18;
        boolean r4 = true;
        if (r2 == null) goto L83;
        r2.hashCode();
        byte r6 = -1;
        switch(r2.hashCode()) {
            case -1992012396: goto L79;
            case -962590849: goto L75;
            case -865190663: goto L71;
            case -268520987: goto L67;
            case 106911: goto L63;
            case 107301: goto L59;
            case 3565883: goto L55;
            case 110549828: goto L51;
            case 206407764: goto L47;
            case 288459765: goto L43;
            case 1194524097: goto L39;
            case 1601406585: goto L35;
            case 2037312353: goto L31;
            default: goto L82;
        };
    L82:
        switch(r6) {
            case 0: goto L84;
            case 1: goto L84;
            case 2: goto L84;
            case 3: goto L84;
            case 4: goto L84;
            case 5: goto L84;
            case 6: goto L84;
            case 7: goto L84;
            case 8: goto L84;
            case 9: goto L84;
            case 10: goto L84;
            case 11: goto L84;
            case 12: goto L84;
            default: goto L83;
        };
    L84:
        if (r4 == false) goto L92;
        if (r3.isJsonPrimitive() == false) goto L92;
        if (r3.getAsJsonPrimitive().isString() == false) goto L92;
        if (TextUtils.isEmpty(r3.getAsString()) == false) goto L92;
        r10.add(r2, JsonNull.INSTANCE);
    L92:
        d(r3);
        goto L18
    L31:
        if (r2.equals("leg_index") == false) goto L82;
        r6 = 12;
        goto L82
    L35:
        if (r2.equals("toll_distance") == false) goto L82;
        r6 = 11;
        goto L82
    L39:
        if (r2.equals("link_num") == false) goto L82;
        r6 = 10;
        goto L82
    L43:
        if (r2.equals("distance") == false) goto L82;
        r6 = 9;
        goto L82
    L47:
        if (r2.equals("traffic_light") == false) goto L82;
        r6 = 8;
        goto L82
    L51:
        if (r2.equals(LBSLightLocationTraceLogger.TOTAL) == false) goto L82;
        r6 = 7;
        goto L82
    L55:
        if (r2.equals("toll") == false) goto L82;
        r6 = 6;
        goto L82
    L59:
        if (r2.equals("lng") == false) goto L82;
        r6 = 5;
        goto L82
    L63:
        if (r2.equals("lat") == false) goto L82;
        r6 = 4;
        goto L82
    L67:
        if (r2.equals("taxi_fee") == false) goto L82;
        r6 = 3;
        goto L82
    L71:
        if (r2.equals("road_type") == false) goto L82;
        r6 = 2;
        goto L82
    L75:
        if (r2.equals("direction") == false) goto L82;
        r6 = 1;
        goto L82
    L79:
        if (r2.equals("duration") == false) goto L82;
        r6 = 0;
    L83:
        r4 = false;
        goto L84
    }

    public static d e(JsonObject r6) {
        JsonObject r0 = h(r6);
        if (r0 != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "failed to find driving payload, root keys=" + r6.keySet());
        return null;
    L6:
        d(r0);
        Gson r2 = g;
        monitor-enter(r2);
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.fromJson(r0, d.class), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        monitor-exit(r2);     // Catch: Throwable -> L45
        if (r3 != null) goto L13;
        return null;
    L13:
        if (r3.f7123a != null) goto L22;
        Integer r1 = i(r0);
        r3.f7123a = r1;
        if (r1 != null) goto L17;
    L18:
        Integer r4 = i(r6);
        if (r4 == null) goto L22;
        r3.f7123a = r4;
        goto L22
    L17:
        if (r1.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r3.f7124b) == false) goto L27;
        String r5 = j(r0);
        r3.f7124b = r5;
        if (TextUtils.isEmpty(r5) == false) goto L27;
        r3.f7124b = j(r6);
    L27:
        if (r3.d == null) goto L29;
    L39:
        StringBuilder r7 = new StringBuilder("normalized payload keys=").append(r0.keySet()).append(", status=").append(r3.f7123a).append(", message=").append(r3.f7124b).append(", hasResult=");
        if (r3.d == null) goto L42;
        boolean r8 = true;
    L43:
        com.obric.cae.log.a.f("StarLocation-BdLM", r7.append(r8).toString());
        return r3;
    L42:
        r8 = false;
        goto L43
    L29:
        if (r0.has("result") == false) goto L39;
        if (r0.get("result").isJsonObject() == false) goto L39;
        monitor-enter(r2);
        r3.d = (e) ZeusTransformUtils.preCheckCast(r2.fromJson(r0.getAsJsonObject("result"), e.class), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Boolean e(List r3) {
        return Boolean.valueOf(d((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")));
    }

    public static String e(String r1) {
        if (r1.startsWith("/") == true) goto L7;
        String r0 = "https://os.obriccloud.com/";
    L6:
        return r0.concat(r1);
    L7:
        r0 = "https://os.obriccloud.com";
        goto L6
    }

    public static void e(JsonElement r8) {
        if (r8.isJsonArray() == false) goto L14;
        Iterator<JsonElement> r9 = r8.getAsJsonArray().iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        if (r0.isJsonNull() == true) goto L6;
        e(r0);
        goto L6
    L12:
        return;
    L14:
        if (r8.isJsonObject() == true) goto L16;
        return;
    L16:
        JsonObject r10 = r8.getAsJsonObject();
        Iterator r1 = new ArrayList(r10.keySet()).iterator();
    L18:
        if (r1.hasNext() == false) goto L81;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JsonElement r3 = r10.get(r2);
        if (r3 == null) goto L18;
        if (r3.isJsonNull() == true) goto L18;
        boolean r4 = true;
        if (r2 == null) goto L71;
        r2.hashCode();
        byte r6 = -1;
        switch(r2.hashCode()) {
            case -1992012396: goto L67;
            case -962590849: goto L63;
            case -746472947: goto L59;
            case 106911: goto L55;
            case 107301: goto L51;
            case 3002509: goto L47;
            case 3575610: goto L43;
            case 288459765: goto L39;
            case 1624717950: goto L35;
            case 2037312353: goto L31;
            default: goto L70;
        };
    L70:
        switch(r6) {
            case 0: goto L72;
            case 1: goto L72;
            case 2: goto L72;
            case 3: goto L72;
            case 4: goto L72;
            case 5: goto L72;
            case 6: goto L72;
            case 7: goto L72;
            case 8: goto L72;
            case 9: goto L72;
            default: goto L71;
        };
    L72:
        if (r4 == false) goto L80;
        if (r3.isJsonPrimitive() == false) goto L80;
        if (r3.getAsJsonPrimitive().isString() == false) goto L80;
        if (TextUtils.isEmpty(r3.getAsString()) == false) goto L80;
        r10.add(r2, JsonNull.INSTANCE);
    L80:
        e(r3);
        goto L18
    L31:
        if (r2.equals("leg_index") == false) goto L70;
        r6 = 9;
        goto L70
    L35:
        if (r2.equals("turn_type_id") == false) goto L70;
        r6 = 8;
        goto L70
    L39:
        if (r2.equals("distance") == false) goto L70;
        r6 = 7;
        goto L70
    L43:
        if (r2.equals("type") == false) goto L70;
        r6 = 6;
        goto L70
    L47:
        if (r2.equals("area") == false) goto L70;
        r6 = 5;
        goto L70
    L51:
        if (r2.equals("lng") == false) goto L70;
        r6 = 4;
        goto L70
    L55:
        if (r2.equals("lat") == false) goto L70;
        r6 = 3;
        goto L70
    L59:
        if (r2.equals("area_id") == false) goto L70;
        r6 = 2;
        goto L70
    L63:
        if (r2.equals("direction") == false) goto L70;
        r6 = 1;
        goto L70
    L67:
        if (r2.equals("duration") == false) goto L70;
        r6 = 0;
    L71:
        r4 = false;
        goto L72
    }

    public static ad f(JsonObject r6) {
        JsonObject r0 = h(r6);
        if (r0 != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "failed to find walking payload, root keys=" + r6.keySet());
        return null;
    L6:
        e(r0);
        Gson r2 = g;
        monitor-enter(r2);
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(r2.fromJson(r0, ad.class), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        monitor-exit(r2);     // Catch: Throwable -> L45
        if (r3 != null) goto L13;
        return null;
    L13:
        if (r3.f7123a != null) goto L22;
        Integer r1 = i(r0);
        r3.f7123a = r1;
        if (r1 != null) goto L17;
    L18:
        Integer r4 = i(r6);
        if (r4 == null) goto L22;
        r3.f7123a = r4;
        goto L22
    L17:
        if (r1.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r3.f7124b) == false) goto L27;
        String r5 = j(r0);
        r3.f7124b = r5;
        if (TextUtils.isEmpty(r5) == false) goto L27;
        r3.f7124b = j(r6);
    L27:
        if (r3.d == null) goto L29;
    L39:
        StringBuilder r7 = new StringBuilder("normalized payload keys=").append(r0.keySet()).append(", status=").append(r3.f7123a).append(", message=").append(r3.f7124b).append(", hasResult=");
        if (r3.d == null) goto L42;
        boolean r8 = true;
    L43:
        com.obric.cae.log.a.f("StarLocation-BdLM", r7.append(r8).toString());
        return r3;
    L42:
        r8 = false;
        goto L43
    L29:
        if (r0.has("result") == false) goto L39;
        if (r0.get("result").isJsonObject() == false) goto L39;
        monitor-enter(r2);
        r3.d = (ae) ZeusTransformUtils.preCheckCast(r2.fromJson(r0.getAsJsonObject("result"), ae.class), ae.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Boolean f(List r3) {
        return Boolean.valueOf(d((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")));
    }

    public static String f(String r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public static void f(JsonElement r8) {
        if (r8.isJsonArray() == false) goto L14;
        Iterator<JsonElement> r9 = r8.getAsJsonArray().iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        if (r0.isJsonNull() == true) goto L6;
        f(r0);
        goto L6
    L12:
        return;
    L14:
        if (r8.isJsonObject() == true) goto L16;
        return;
    L16:
        JsonObject r10 = r8.getAsJsonObject();
        Iterator r1 = new ArrayList(r10.keySet()).iterator();
    L18:
        if (r1.hasNext() == false) goto L89;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JsonElement r3 = r10.get(r2);
        if (r3 == null) goto L18;
        if (r3.isJsonNull() == true) goto L18;
        boolean r4 = true;
        if (r2 == null) goto L79;
        r2.hashCode();
        byte r6 = -1;
        switch(r2.hashCode()) {
            case -1992012396: goto L75;
            case -1106363674: goto L71;
            case -1071743734: goto L67;
            case -962590849: goto L63;
            case -746472947: goto L59;
            case 106911: goto L55;
            case 107301: goto L51;
            case 3002509: goto L47;
            case 3004913: goto L43;
            case 3575610: goto L39;
            case 288459765: goto L35;
            case 2037312353: goto L31;
            default: goto L78;
        };
    L78:
        switch(r6) {
            case 0: goto L80;
            case 1: goto L80;
            case 2: goto L80;
            case 3: goto L80;
            case 4: goto L80;
            case 5: goto L80;
            case 6: goto L80;
            case 7: goto L80;
            case 8: goto L80;
            case 9: goto L80;
            case 10: goto L80;
            case 11: goto L80;
            default: goto L79;
        };
    L80:
        if (r4 == false) goto L88;
        if (r3.isJsonPrimitive() == false) goto L88;
        if (r3.getAsJsonPrimitive().isString() == false) goto L88;
        if (TextUtils.isEmpty(r3.getAsString()) == false) goto L88;
        r10.add(r2, JsonNull.INSTANCE);
    L88:
        f(r3);
        goto L18
    L31:
        if (r2.equals("leg_index") == false) goto L78;
        r6 = 11;
        goto L78
    L35:
        if (r2.equals("distance") == false) goto L78;
        r6 = 10;
        goto L78
    L39:
        if (r2.equals("type") == false) goto L78;
        r6 = 9;
        goto L78
    L43:
        if (r2.equals("attr") == false) goto L78;
        r6 = 8;
        goto L78
    L47:
        if (r2.equals("area") == false) goto L78;
        r6 = 7;
        goto L78
    L51:
        if (r2.equals("lng") == false) goto L78;
        r6 = 6;
        goto L78
    L55:
        if (r2.equals("lat") == false) goto L78;
        r6 = 5;
        goto L78
    L59:
        if (r2.equals("area_id") == false) goto L78;
        r6 = 4;
        goto L78
    L63:
        if (r2.equals("direction") == false) goto L78;
        r6 = 3;
        goto L78
    L67:
        if (r2.equals("restrictions_status") == false) goto L78;
        r6 = 2;
        goto L78
    L71:
        if (r2.equals(XSDatatype.FACET_LENGTH) == false) goto L78;
        r6 = 1;
        goto L78
    L75:
        if (r2.equals("duration") == false) goto L78;
        r6 = 0;
    L79:
        r4 = false;
        goto L80
    }

    public static JsonElement g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L14;
        return null;
    L14:
        return JsonParser.parseString(r3);
    L7:
        int r0 = r3.indexOf("}{");
        if (r0 != (-1)) goto L16;
        return null;
    L16:
        return JsonParser.parseString(r3.substring(r0 + 1));
    L13:
        return null;
    }

    private /* synthetic */ am g(String r1, int r2, int r3, String r4, String r5) {
        return f(r1, r2, r3, r4, r5);
    }

    public static j g(JsonObject r6) {
        JsonObject r0 = h(r6);
        if (r0 != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "failed to find riding payload, root keys=" + r6.keySet());
        return null;
    L6:
        f(r0);
        Gson r2 = g;
        monitor-enter(r2);
        j r3 = (j) ZeusTransformUtils.preCheckCast(r2.fromJson(r0, j.class), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        monitor-exit(r2);     // Catch: Throwable -> L45
        if (r3 != null) goto L13;
        return null;
    L13:
        if (r3.f7123a != null) goto L22;
        Integer r1 = i(r0);
        r3.f7123a = r1;
        if (r1 != null) goto L17;
    L18:
        Integer r4 = i(r6);
        if (r4 == null) goto L22;
        r3.f7123a = r4;
        goto L22
    L17:
        if (r1.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r3.f7124b) == false) goto L27;
        String r5 = j(r0);
        r3.f7124b = r5;
        if (TextUtils.isEmpty(r5) == false) goto L27;
        r3.f7124b = j(r6);
    L27:
        if (r3.d == null) goto L29;
    L39:
        StringBuilder r7 = new StringBuilder("normalized payload keys=").append(r0.keySet()).append(", status=").append(r3.f7123a).append(", message=").append(r3.f7124b).append(", hasResult=");
        if (r3.d == null) goto L42;
        boolean r8 = true;
    L43:
        com.obric.cae.log.a.f("StarLocation-BdLM", r7.append(r8).toString());
        return r3;
    L42:
        r8 = false;
        goto L43
    L29:
        if (r0.has("result") == false) goto L39;
        if (r0.get("result").isJsonObject() == false) goto L39;
        monitor-enter(r2);
        r3.d = (k) ZeusTransformUtils.preCheckCast(r2.fromJson(r0.getAsJsonObject("result"), k.class), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    public static JsonElement h(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        JsonElement r0 = g(r5);
        if (r0 == null) goto L30;
        return r0;
    L30:
        JsonReader r2 = new JsonReader(new StringReader(r5));     // Catch: Exception -> L11
        r2.setLenient(true);     // Catch: Exception -> L11
        return JsonParser.parseReader(r2);
    L11:
        int r3 = r5.indexOf(123);
        int r4 = r5.lastIndexOf(125);
        if (r3 < 0) goto L17;
        if (r4 <= r3) goto L17;
        JsonReader r6 = new JsonReader(new StringReader(r5.substring(r3, r4 + 1)));     // Catch: Exception -> L24
        r6.setLenient(true);     // Catch: Exception -> L24
        return JsonParser.parseReader(r6);
    L17:
        int r7 = r5.indexOf(91);
        int r8 = r5.lastIndexOf(93);
        if (r7 < 0) goto L23;
        if (r8 <= r7) goto L23;
        JsonReader r9 = new JsonReader(new StringReader(r5.substring(r7, r8 + 1)));     // Catch: Exception -> L25
        r9.setLenient(true);     // Catch: Exception -> L25
        return JsonParser.parseReader(r9);
    L23:
        return null;
    }

    public static JsonObject h(JsonObject r9) {
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L25;
        if (r9 != null) goto L8;
    L16:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L19;
        if (r9.has("data") == false) goto L25;
        if (r9.get("data").isJsonObject() == false) goto L25;
        r9 = r9.getAsJsonObject("data");
        r1 = r1 + 1;
        goto L4
    L19:
        return r9;
    L8:
        if (r9.has("status") == false) goto L10;
    L17:
        r2 = true;
        goto L18
    L10:
        if (r9.has("result") == true) goto L17;
        if (r9.has("routes") == true) goto L17;
        if (r9.has("message") == false) goto L16;
    L25:
        if (r9 != null) goto L28;
    L36:
        if (r0 == true) goto L44;
        return null;
    L44:
        return r9;
    L28:
        if (r9.has("status") == false) goto L30;
    L35:
        r0 = true;
        goto L36
    L30:
        if (r9.has("result") == true) goto L35;
        if (r9.has("routes") == true) goto L35;
        if (r9.has("message") == false) goto L36;
        goto L35
    }

    private /* synthetic */ am h(String r1, int r2, int r3, String r4, String r5) {
        return f(r1, r2, r3, r4, r5);
    }

    private al i(String r9, int r10, int r11, String r12, String r13) {
        HashMap r5 = e();     // Catch: Exception -> L11
        if (r5 != null) goto L6;
        al r8 = new al(false, new ArrayList(), null, "headers is null");     // Catch: Exception -> L11
    L14:
        return r8;
    L6:
        JsonObject r14 = b(a(r9, r10, r11, r12, r13), "TEXT_SEARCH_MAP_POI");     // Catch: Exception -> L11
        String r6 = e("/poi_server/api/v1/location/textsearch_index_map_poi");     // Catch: Exception -> L11
        com.obric.cae.log.a.f("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: execute request, keyword=" + f(r9) + ", city=" + f(r12) + ", pageNum=" + r10 + ", pageSize=" + r11);     // Catch: Exception -> L11
        aq r15 = a(r6, r14.toString(), r5);     // Catch: Exception -> L11
        String r16 = r15.f7121a;     // Catch: Exception -> L11
        String r17 = r15.c;     // Catch: Exception -> L11
        int r18 = r15.d;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r16) == false) goto L9;
        com.obric.cae.log.a.j("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: response is empty, status=" + r18 + ", X-Tt-Logid=" + f(r17));     // Catch: Exception -> L11
        r8 = new al(false, new ArrayList(), null, "empty response");     // Catch: Exception -> L11
        goto L14
    L9:
        r8 = a(r16);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: failed", e);
        return new al(false, new ArrayList(), null, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
    }

    public static Integer i(JsonObject r2) {
        String r0 = "status";
        if (r2.has("status") == true) goto L5;
    L8:
        r0 = "code";
        if (r2.has("code") == true) goto L11;
    L13:
        r0 = "errno";
        if (r2.has("errno") == true) goto L16;
        return null;
    L16:
        if (r2.get("errno").isJsonNull() == false) goto L7;
        return null;
    L7:
        return Integer.valueOf(r2.get(r0).getAsInt());
    L11:
        if (r2.get("code").isJsonNull() == true) goto L13;
    L5:
        if (r2.get("status").isJsonNull() == true) goto L8;
        goto L8
    }

    public static String j(JsonObject r2) {
        String r0 = "message";
        if (r2.has("message") == true) goto L5;
    L8:
        r0 = NotificationCompat.CATEGORY_MESSAGE;
        if (r2.has(NotificationCompat.CATEGORY_MESSAGE) == true) goto L11;
    L13:
        r0 = "error_msg";
        if (r2.has("error_msg") == true) goto L16;
        return null;
    L16:
        if (r2.get("error_msg").isJsonNull() == false) goto L7;
        return null;
    L7:
        return r2.get(r0).getAsString();
    L11:
        if (r2.get(NotificationCompat.CATEGORY_MESSAGE).isJsonNull() == true) goto L13;
    L5:
        if (r2.get("message").isJsonNull() == true) goto L8;
        goto L8
    }

    public static Boolean k(JsonObject r5) {
        Integer r6 = b(r5, new String[]{"code", "errno", "status", "ret", "error_code"});
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.intValue() != 102000002) goto L8;
        boolean r7 = true;
    L10:
        return Boolean.valueOf(r7);
    L8:
        r7 = false;
        goto L10
    }

    public static /* synthetic */ j lambda$6zTs6GuUDTuPQ_JMyJ469X87T9w(a r0, i r1) {
        return r0.c(r1);
    }

    public static /* synthetic */ ad lambda$FtXMLDyT9Hu4MXr882bsVNHuFVk(a r0, ac r1) {
        return r0.b(r1);
    }

    public static /* synthetic */ Boolean lambda$GZCLEmypI7BUfurG5yfJENt0p8U(a r0, List r1) {
        return r0.e(r1);
    }

    /* JADX INFO: renamed from: lambda$I-lZo4o6BTT2OCL-IBcVzpJYNIg, reason: not valid java name */
    public static /* synthetic */ q m380lambda$IlZo4o6BTT2OCLIBcVzpJYNIg(a r0, p r1) {
        return r0.c(r1);
    }

    public static /* synthetic */ d lambda$JTY8U82jimqqcyNTNJEotvymqTo(a r0, c r1) {
        return r0.c(r1);
    }

    public static /* synthetic */ al lambda$MIDDHbiV7OdFw9Wcfc32jFHt99c(a r0, String r1, int r2, int r3, String r4, String r5) {
        return r0.i(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ am lambda$T41IYTEeSPJfkheBKvWtlFRiQtk(a r0, String r1, int r2, int r3, String r4, String r5) {
        return r0.g(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$XL--DYhwuECPCT_GzCiyFOIrA-w, reason: not valid java name */
    public static /* synthetic */ Boolean m381lambda$XLDYhwuECPCT_GzCiyFOIrAw(a r0, int r1) {
        return r0.c(r1);
    }

    public static /* synthetic */ am lambda$eOSN73hwZFaL86d1I6jlIWVBDig(a r0, String r1, int r2, int r3, String r4, String r5) {
        return r0.h(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$jIgJ984Usni-X7VFE3rxAlJ2fRU, reason: not valid java name */
    public static /* synthetic */ Boolean m382lambda$jIgJ984UsniX7VFE3rxAlJ2fRU(a r0, List r1) {
        return r0.f(r1);
    }

    public static /* synthetic */ Boolean lambda$pBrIe_XZpjJX9Axm3d7rHUcFu7k(a r0, int r1) {
        return r0.d(r1);
    }

    public Bundle a(int r1, String r2, int r3) {
        Bundle r0 = new Bundle();
        r0.putInt("status", r1);
        r0.putString("message", r2);
        return r0;
    }

    public Bundle a(int r1, String r2, AbstractC0355a r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putInt("status", r1);
        r0.putString("message", r2);
        return r0;
    }

    public Bundle a(AbstractC0355a r3, int r4) {
        Bundle r0 = b(r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a(-1, "direction result is null", r3, r4);
    }

    public BDLocation a(boolean r12, String r13, long r14) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "ignoreCache=" + r12 + ", triggerType=" + r13 + ", timeoutMs=" + r14);
        Context r15 = this.j;
        if (r15 != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-BdLM", "called before init");
        return null;
    L7:
        if (this.m == true) goto L11;
        com.obric.cae.log.a.h("StarLocation-BdLM", "skipped: sdk not inited");
        return null;
    L11:
        if (com.obric.cae.location.util.d.a().o() == true) goto L15;
        com.obric.cae.log.a.h("StarLocation-BdLM", "skipped: location is disabled");
        return null;
    L15:
        if (com.obric.cae.location.util.d.a().e() == true) goto L18;
        com.obric.cae.log.a.h("StarLocation-BdLM", "skipped: network disconnected");
        return null;
    L18:
        AtomicReference r11 = new AtomicReference();
        AtomicReference r3 = new AtomicReference();
        CountDownLatch r4 = new CountDownLatch(1);
        an r6 = new an(r11, r4, r3);
        BDLocationClient r7 = new BDLocationClient(r15);
        BDLocationClientOption r16 = new BDLocationClientOption();
        BDLocationClientOption r8 = r16.setCert(true).setUploadSource("CommSense").setLocationTimeOut(f7092b);
        if (r12 == false) goto L21;
        long r9 = 0;
    L22:
        r8.setMaxCacheTime(r9).setLocateType(1).setAccuracyLevel(4).setTriggerType(0).setLocationMode(2).setLatestAdminVersion(true).setUpload(true);
        r7.setClientOption(r16);
        r7.getLocation(new com.obric.cae.location.geosdk.bytedance.e(System.currentTimeMillis(), r6));
    L33:
        e = move-exception;
        Thread.currentThread().interrupt();
        com.obric.cae.log.a.b("StarLocation-BdLM", "interrupted", e);
        return null;
    L24:
        if (r4.await(r14, TimeUnit.MILLISECONDS) == true) goto L27;
        com.obric.cae.log.a.h("StarLocation-BdLM", "timeoutMs=" + r14);     // Catch: InterruptedException -> L33
        return null;
    L27:
        BDLocationException r17 = (BDLocationException) ZeusTransformUtils.preCheckCast(r3.get(), BDLocationException.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L32;
        com.obric.cae.log.a.b("StarLocation-BdLM", "error", r17);
        return null;
    L32:
        return (BDLocation) ZeusTransformUtils.preCheckCast(r11.get(), BDLocation.class, "com.obric.memorydata.plugin");
    L21:
        r9 = c;
        goto L22
    }

    public AbstractC0355a a(double r2, double r4, double r6, double r8, byte r10, byte r11, Map r12, int r13) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        String r3 = com.obric.cae.location.util.d.a().b(r2, r4);
        String r5 = com.obric.cae.location.util.d.a().b(r6, r8);
        String r7 = "";
        if (r13 == 1) goto L36;
        if (r13 != 2) goto L6;
        c r9 = new c(r3, r5);
        HashMap r14 = a(r1);
        a(r9, r14);
        r9.l = a(r14, "tactics");
        r9.m = a(r14, "alternatives");
        r9.n = a(r14, "road_traffic");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.get("waypoints"), String.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L20;
        r15 = "";
    L20:
        r9.o = r15;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.get("avoidroad"), String.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        r9.p = r16;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r14.get("avoidpolygons"), String.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        r9.q = r17;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r14.get("plate_number"), String.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L32;
        r18 = "";
    L32:
        r9.r = r18;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r14.get("restriction"), String.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L35;
        r7 = r19;
    L35:
        r9.s = r7;
        AbstractC0355a r20 = r9;
    L14:
        AbstractC0355a r21 = r20;
    L44:
        String r22 = "bd09ll";
        if (r10 != 0) goto L47;
        String r23 = LocationInfoConst.WGS_84;
    L52:
        r21.e = r23;
        if (r11 == 1) goto L58;
        if (r11 == 0) goto L58;
        if (r11 == 2) goto L59;
        com.obric.cae.log.a.h("StarLocation-BdLM", "unknown outCoordType=" + r11 + ", fallback ret_coordtype to bd09ll");
    L59:
        r21.f = r22;
        return r21;
    L58:
        r22 = LocationInfoConst.GCJ_O2;
        goto L59
    L47:
        if (r10 != 1) goto L49;
        r23 = LocationInfoConst.GCJ_O2;
        goto L52
    L49:
        if (r10 == 2) goto L51;
        com.obric.cae.log.a.h("StarLocation-BdLM", "unknown coordType=" + r10 + ", fallback to bd09ll");
    L51:
        r23 = "bd09ll";
        goto L52
    L6:
        if (r13 != 3) goto L8;
        ac r24 = new ac(r3, r5);
        a(r24, a(r1));
        r21 = r24;
        goto L44
    L8:
        if (r13 == 4) goto L10;
        com.obric.cae.log.a.h("StarLocation-BdLM", "unsupported directionType=" + r13 + ", build unsupported request");
        r21 = new aa(r3, r5, r13);
        goto L44
    L10:
        i r25 = new i(r3, r5);
        HashMap r26 = a(r1);
        a(r25, r26);
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.get("riding_type"), String.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L13;
        r7 = r27;
    L13:
        r25.l = r7;
        r25.m = a(r26, "road_prefer");
        r20 = r25;
        goto L14
    L36:
        p r28 = new p(r3, r5);
        HashMap r29 = a(r1);
        a(r28, r29);
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.get("departure_date"), String.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L40;
        r30 = "";
    L40:
        r28.l = r30;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r29.get("departure_time"), String.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L43;
        r7 = r31;
    L43:
        r28.m = r7;
        r28.n = a(r29, "tactics_incity");
        r28.o = a(r29, "tactics_intercity");
        r28.p = a(r29, "trans_type_intercity");
        r28.q = a(r29, "page_size");
        r28.r = a(r29, "page_index");
        r20 = r28;
        goto L14
    }

    public ad a(final ac r2) {
        return (ad) ZeusTransformUtils.preCheckCast(a(r2, "WALKING_SEARCH", new $$Lambda$a$FtXMLDyT9Hu4MXr882bsVNHuFVk(this, r2)), ad.class, "com.obric.memorydata.plugin");
    }

    public final am a(Context r15, final String r16, final int r17, final int r18, final String r19, final String r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        long r8 = System.currentTimeMillis();
        HashMap r10 = new HashMap();
        if (r1 != null) goto L5;
    L7:
        if (r1 == null) goto L9;
    L11:
        Integer r11 = null;
        Map<String, List<ai>> r12 = null;
        r11 = null;
        r11 = null;
        if (r1 != null) goto L16;
        com.obric.cae.log.a.j("StarLocation-BdLM", "finalContext is null");
        return new am(r10, null, null);
    L16:
        if (com.obric.cae.location.util.d.a().e() == true) goto L20;
        com.obric.cae.log.a.d("StarLocation-BdLM", "Network invalid.");
        return new am(r10, null, null);
    L20:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L90;
        com.obric.cae.log.a.h("StarLocation-BdLM", "Cannot execute network request synchronously on main thread, executing asynchronously");
        f.submit(new $$Lambda$a$eOSN73hwZFaL86d1I6jlIWVBDig(this, r16, r17, r18, r19, r20));
        return new am(r10, null, null);
    L90:
        am r0 = (am) ZeusTransformUtils.preCheckCast(f.submit(new $$Lambda$a$T41IYTEeSPJfkheBKvWtlFRiQtk(this, r16, r17, r18, r19, r20)).get(e, TimeUnit.MILLISECONDS), am.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L59 RuntimeException -> L62 TimeoutException -> L65
        if (r0 == null) goto L34;
        Integer r2 = r0.f7114b;     // Catch: Exception -> L59 RuntimeException -> L62 TimeoutException -> L65
        String r3 = r0.c;     // Catch: Exception -> L28 RuntimeException -> L30 TimeoutException -> L32
    L35:
        if (r0 != null) goto L88;
    L38:
        if (r12 == null) goto L69;
        Object r4 = i;     // Catch: Exception -> L53 RuntimeException -> L55 TimeoutException -> L57
        monitor-enter(r4);     // Catch: Exception -> L53 RuntimeException -> L55 TimeoutException -> L57
        Iterator<Map.Entry<String, List<ai>>> r5 = r12.entrySet().iterator();     // Catch: Throwable -> L50
    L43:
        if (r5.hasNext() == false) goto L48;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (r10.containsKey(r6.getKey()) == true) goto L47;
        r10.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), new ArrayList());     // Catch: Throwable -> L50
    L47:
        ((List) ZeusTransformUtils.preCheckCast(r10.get(r6.getKey()), List.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r6.getValue(), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L50
        goto L43
    L48:
        monitor-exit(r4);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Exception -> L53 RuntimeException -> L55 TimeoutException -> L57
    L55:
        e = e;
    L56:
        r11 = r2;
    L64:
        String r7 = "StarLocation-BdLM";
        String r9 = "catch RuntimeException";
    L68:
        com.obric.cae.log.a.b(r7, r9, e);
        r2 = r11;
    L57:
        e = e;
    L58:
        r11 = r2;
    L67:
        r7 = "StarLocation-BdLM";
        r9 = "catch TimeoutException";
    L53:
        e = e;
    L54:
        r11 = r2;
    L61:
        r7 = "StarLocation-BdLM";
        r9 = "catch exception";
    L69:
        long r13 = System.currentTimeMillis() - r8;
        int r14 = 0;
        Iterator r21 = r10.values().iterator();
    L71:
        if (r21.hasNext() == false) goto L73;
        r14 = r14 + ((List) ZeusTransformUtils.preCheckCast(r21.next(), List.class, "com.obric.memorydata.plugin")).size();
        goto L71
    L73:
        com.obric.cae.log.a.f("StarLocation-BdLM", "cost " + r13 + "ms, result size=" + r14);
        if (r10.isEmpty() == true) goto L83;
        Iterator r22 = r10.entrySet().iterator();
    L77:
        if (r22.hasNext() == false) goto L83;
        Map.Entry r23 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r24 = ((List) ZeusTransformUtils.preCheckCast(r23.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L80:
        if (r24.hasNext() == false) goto L77;
        com.obric.cae.log.a.d("StarLocation-BdLM", "result detail line=" + ((String) ZeusTransformUtils.preCheckCast(r23.getKey(), String.class, "com.obric.memorydata.plugin")) + " " + ((ai) ZeusTransformUtils.preCheckCast(r24.next(), ai.class, "com.obric.memorydata.plugin")).g);
    L83:
        return new am(r10, r2, r3);
    L88:
        r12 = r0.f7113a;     // Catch: Exception -> L53 RuntimeException -> L55 TimeoutException -> L57
        goto L38
    L30:
        e = e;
        r3 = null;
    L32:
        e = e;
        r3 = null;
    L28:
        e = e;
        r3 = null;
        goto L54
    L34:
        r2 = null;
        r3 = null;
    L62:
        e = e;
        r3 = null;
    L65:
        e = e;
        r3 = null;
    L59:
        e = e;
        r3 = null;
        goto L61
    L9:
        if (this.j == null) goto L11;
        r1 = this.j;
        goto L11
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L7;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L7
    }

    public final aq a(String r5, String r6, HashMap r7) {
        aq r0 = b(r5, r6, r7);
        if (b(h(r0.f7122b), 0) == true) goto L5;
        return r0;
    L5:
        com.obric.cae.log.a.h("StarLocation-BdLM", "attestation cert expired, refresh and retry, url=" + r5);
        com.obric.cae.location.util.d.a().k();
        String r1 = com.obric.cae.location.util.d.a().i();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        com.obric.cae.log.a.j("StarLocation-BdLM", "attestation certChain is empty after refresh");
        HashMap r8 = null;
    L9:
        if (r8 != null) goto L13;
        com.obric.cae.log.a.j("StarLocation-BdLM", "skip retry because refreshed headers is null");
        return r0;
    L13:
        return b(r5, r6, r8);
    L8:
        HashMap r3 = new HashMap(r7);
        r3.put("x-att-certchain", r1);
        r8 = r3;
        goto L9
    }

    public final String a(String r6, Map r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L21:
        String r9 = null;
    L23:
        if (TextUtils.isEmpty(r9) == false) goto L26;
        String r5 = "POI response X-Tt-Logid is empty, url=" + r6;
        com.obric.cae.log.a.f("StarLocation-BdLM", r5);
        StarPoiManager.a().g(r5);
        return null;
    L26:
        String r0 = "POI response X-Tt-Logid=" + r9 + ", url=" + r6;
        com.obric.cae.log.a.f("StarLocation-BdLM", r0);
        StarPoiManager.a().g(r0);
        if (r6.contains("/location/submit-v2") == false) goto L29;
        this.l = r9;
    L29:
        return r9;
    L5:
        if (r8.isEmpty() == true) goto L21;
        Iterator r10 = r8.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L21;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        if (r2.getKey() == null) goto L8;
        if ("X-Tt-Logid".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L8;
        List r11 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        if (r11.isEmpty() == true) goto L21;
        r9 = (String) ZeusTransformUtils.preCheckCast(r11.get(0), String.class, "com.obric.memorydata.plugin");
        goto L23
    }

    public synchronized void a(Context r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (this.m == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.obric.cae.log.a.f("StarLocation-BdLM", "");     // Catch: Throwable -> L23
        if (this.j != null) goto L10;
        this.j = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
    L10:
        Context r9 = this.j;     // Catch: Throwable -> L23
        if (r9 != null) goto L14;
        String r10 = "StarLocation-BdLM";
        String r0 = "skipped: context is null";
    L13:
        com.obric.cae.log.a.j(r10, r0);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        String r1 = MatrixDidUtils.getDid(r9);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L18;
        com.obric.cae.log.a.h("StarLocation-BdLM", "skipped: did is empty");     // Catch: Throwable -> L23
        goto L21
    L18:
        if (ZeusTransformUtils.instanceOf(r9, Application.class) == true) goto L20;
        r10 = "StarLocation-BdLM";
        r0 = "skipped: application context is not an Application";
        goto L13
    L20:
        BackgroundProvider r2 = new BackgroundProvider();     // Catch: Throwable -> L23
        r2.onAppBackgroundSwitch(false);     // Catch: Throwable -> L23
        BDLocationAgent.updateSettings(this.j, b());     // Catch: Throwable -> L23
        BDLocationAgent.init(new LocationInitConfig.Builder((Application) ZeusTransformUtils.preCheckCast(r9, Application.class, "com.obric.memorydata.plugin")).setBaseUrl("https://os.obriccloud.com").setRestrictedMode(new com.obric.cae.location.geosdk.bytedance.d()).setLocateType(3).setBackgroundProvider(r2).setALogPrinter(new com.obric.cae.location.geosdk.bytedance.c()).isPrivacyConfirmed(true).setWorldView("CN").setLocal(Locale.CHINA).setAppId(r9.getPackageName()).setDid(r1).setBpeaCerts(null).setDebug(false).setCustomNetworkApi(new com.obric.cae.location.geosdk.bytedance.b(this)).build());     // Catch: Throwable -> L23
        this.m = BDLocationAgent.isInit();     // Catch: Throwable -> L23
        com.obric.cae.log.a.f("StarLocation-BdLM", "finished, isInit=" + this.m);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public boolean a(final int r6) {
        if (this.j != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-BdLM", "appContext is null");
        return false;
    L7:
        if (com.obric.cae.location.util.d.a().e() == true) goto L11;
        com.obric.cae.log.a.h("StarLocation-BdLM", "Network invalid.");
        return false;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L14;
        com.obric.cae.log.a.h("StarLocation-BdLM", "execute asynchronously on main thread");
        f.submit(new $$Lambda$a$pBrIe_XZpjJX9Axm3d7rHUcFu7k(this, r6));
        return false;
    L14:
        Future r5 = f.submit(new $$Lambda$a$XLDYhwuECPCT_GzCiyFOIrAw(this, r6));
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5.get(e, TimeUnit.MILLISECONDS), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L19:
        e = e;
        String r7 = "catch RuntimeException";
    L21:
        com.obric.cae.log.a.b("StarLocation-BdLM", r7, e);
    L24:
        return false;
    L22:
        e = move-exception;
        r5.cancel(true);
        com.obric.cae.log.a.b("StarLocation-BdLM", "catch TimeoutException", e);
    L17:
        e = e;
        r7 = "catch exception";
        goto L21
    }

    public final Bundle b(JsonElement r26, String r27) {
        if (r26.isJsonObject() == true) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "near poi response is not json object");
        return null;
    L6:
        JsonElement r1 = a(r26, "NEAR_POI_DATA");
        if (r1 != null) goto L9;
    L192:
        com.obric.cae.log.a.j("StarLocation-BdLM", "near poi data is missing");
        return null;
    L9:
        if (r1.isJsonObject() == false) goto L192;
        JsonObject r2 = r1.getAsJsonObject();
        JsonElement r4 = a(r2, "pois");
        if (r4 != null) goto L14;
    L22:
        JsonObject r5 = null;
    L23:
        JsonElement r6 = a(r2, "aois");
        if (r6 != null) goto L26;
    L34:
        JsonObject r7 = null;
    L35:
        String r8 = "";
        if (r5 != null) goto L38;
        String r9 = "";
    L40:
        if (r5 != null) goto L42;
        String r12 = "";
    L44:
        if (r5 != null) goto L46;
        Double r14 = null;
    L48:
        if (r5 != null) goto L50;
        Integer r10 = null;
    L51:
        if (r7 != null) goto L53;
        String r11 = "";
    L54:
        if (r7 != null) goto L56;
        String r13 = "";
    L57:
        if (r7 != null) goto L59;
        Double r15 = null;
    L61:
        if (TextUtils.isEmpty(r9) == true) goto L63;
    L66:
        Bundle r16 = new Bundle();
        JsonElement r3 = a(r2, "timestamp");
        if (r3 != null) goto L69;
    L73:
        Long r17 = null;
    L74:
        if (r17 != null) goto L76;
    L79:
        long r18 = System.currentTimeMillis();
    L80:
        r16.putLong("timestamp", r18);
        if (r10 != null) goto L83;
        int r19 = 1;
    L84:
        r16.putInt("is_acc_qualified_poi", r19);
        if (r5 == null) goto L87;
        boolean r20 = true;
    L88:
        r16.putString("near_the_poi", String.valueOf(r20));
        if (r7 == null) goto L91;
        boolean r21 = true;
    L92:
        r16.putString("near_the_aoi", String.valueOf(r21));
        String r22 = this.l;
        if (TextUtils.isEmpty(r22) == true) goto L99;
        if (TextUtils.isEmpty(r27) == true) goto L99;
        r16.putString("sdk_logid", r22);
        r16.putString("scene_logid", r27);
    L99:
        if (TextUtils.isEmpty(r9) == true) goto L102;
        r16.putString("poi_name", r9);
    L102:
        if (TextUtils.isEmpty(r12) == true) goto L107;
        if (r14 == null) goto L107;
        r16.putString("poi_id", r12);
        r16.putDouble("poi_confidence", r14.doubleValue());
    L107:
        if (TextUtils.isEmpty(r11) == true) goto L110;
        r16.putString("aoi_name", r11);
    L110:
        if (TextUtils.isEmpty(r13) == true) goto L114;
        if (r15 == null) goto L114;
        r16.putString("aoi_id", r13);
        r16.putDouble("aoi_confidence", r15.doubleValue());
    L114:
        if (r5 != null) goto L117;
        r5 = r7;
    L117:
        if (r5 != null) goto L119;
        String r23 = "";
    L121:
        if (TextUtils.isEmpty(r23) == false) goto L124;
        String r24 = "StarLocation-BdLM";
    L123:
        com.obric.cae.location.database.d.a r25 = null;
    L128:
        if (r25 != null) goto L130;
        String r0 = "";
    L131:
        String[] r28 = {"new_type_name_l1", "NewTypeNameL1", "newTypeNameL1"};
        if (r5 != null) goto L134;
        String r29 = "";
    L136:
        if (TextUtils.isEmpty(r29) == false) goto L138;
        r29 = f(r0);
    L138:
        r16.putString("new_type_name_l1", r29);
        if (r25 != null) goto L141;
        String r30 = "";
    L142:
        String[] r31 = {"new_type_name_l2", "NewTypeNameL2", "newTypeNameL2"};
        if (r5 != null) goto L145;
        String r32 = "";
    L147:
        if (TextUtils.isEmpty(r32) == false) goto L149;
        r32 = f(r30);
    L149:
        r16.putString("new_type_name_l2", r32);
        if (r25 != null) goto L152;
        String r33 = "";
    L153:
        String[] r110 = {"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"};
        if (r5 != null) goto L156;
        String r111 = "";
    L158:
        if (TextUtils.isEmpty(r111) == false) goto L160;
        r111 = f(r33);
    L160:
        r16.putString("new_type_name_l3", r111);
        if (r25 != null) goto L163;
        String r34 = "";
    L164:
        String[] r112 = {"new_type_code_l1", "NewTypeCodeL1", "newTypeCodeL1"};
        if (r5 != null) goto L167;
        String r113 = "";
    L169:
        if (TextUtils.isEmpty(r113) == false) goto L171;
        r113 = f(r34);
    L171:
        r16.putString("new_type_code_l1", r113);
        if (r25 != null) goto L174;
        String r35 = "";
    L175:
        String[] r114 = {"new_type_code_l2", "NewTypeCodeL2", "newTypeCodeL2"};
        if (r5 != null) goto L178;
        String r36 = "";
    L180:
        if (TextUtils.isEmpty(r36) == false) goto L182;
        r36 = f(r35);
    L182:
        r16.putString("new_type_code_l2", r36);
        if (TextUtils.isEmpty(r23) == false) goto L187;
        if (r25 == null) goto L188;
        r8 = r25.f;
    L188:
        r16.putString("new_type_code_l3", r8);
        com.obric.cae.log.a.d(r24, "typeCode=" + r23 + ", category=" + r16.getString("new_type_name_l1") + ";" + r16.getString("new_type_name_l2") + ";" + r16.getString("new_type_name_l3"));
        if (r7 == null) goto L191;
        r16.putString("aoi_new_type_code_l3", f(a(r7, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3"})));
        r16.putString("aoi_new_type_name_l3", f(a(r7, new String[]{"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"})));
    L191:
        return r16;
    L187:
        r8 = r23;
        goto L188
    L178:
        r36 = f(a(r5, r114));
        goto L180
    L174:
        r35 = r25.e;
        goto L175
    L167:
        r113 = f(a(r5, r112));
        goto L169
    L163:
        r34 = r25.d;
        goto L164
    L156:
        r111 = f(a(r5, r110));
        goto L158
    L152:
        r33 = r25.c;
        goto L153
    L145:
        r32 = f(a(r5, r31));
        goto L147
    L141:
        r30 = r25.f7090b;
        goto L142
    L134:
        r29 = f(a(r5, r28));
        goto L136
    L130:
        r0 = r25.f7089a;
        goto L131
    L124:
        Context r37 = this.j;
        if (r37 != null) goto L127;
        r24 = "StarLocation-BdLM";
        com.obric.cae.log.a.h(r24, "skip poi type lookup without context, typeCode=".concat(r23));
        goto L123
    L127:
        r24 = "StarLocation-BdLM";
        r25 = com.obric.cae.location.database.d.a(r37).a(r23);
        goto L128
    L119:
        r23 = f(a(r5, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3", "aweme_type_code", "AwemeTypeCode", "awemeTypeCode"}));
        goto L121
    L91:
        r21 = false;
        goto L92
    L87:
        r20 = false;
        goto L88
    L83:
        r19 = r10.intValue();
        goto L84
    L76:
        if (r17.longValue() <= 0) goto L79;
        r18 = r17.longValue();
        goto L80
    L69:
        if (r3.isJsonNull() == true) goto L73;
        r17 = Long.valueOf(r3.getAsLong());     // Catch: Exception -> L194
    L63:
        if (TextUtils.isEmpty(r11) == false) goto L66;
        com.obric.cae.log.a.f("StarLocation-BdLM", "near poi data has no valid poi or aoi");
        return null;
    L59:
        r15 = c(r7, new String[]{"confidence"});
        goto L61
    L56:
        r13 = f(a(r7, new String[]{"aweme_id", "awemeId"}));
        goto L57
    L53:
        r11 = f(a(r7, new String[]{ActivityLifecycle.NAME}));
        goto L54
    L50:
        r10 = b(r5, new String[]{"is_acc_qualified_poi"});
        goto L51
    L46:
        r14 = c(r5, new String[]{"confidence"});
        goto L48
    L42:
        r12 = f(a(r5, new String[]{"aweme_id", "awemeId"}));
        goto L44
    L38:
        r9 = f(a(r5, new String[]{ActivityLifecycle.NAME}));
        goto L40
    L26:
        if (r6.isJsonArray() == false) goto L34;
        JsonArray r38 = r6.getAsJsonArray();
        if (r38.size() <= 0) goto L34;
        JsonElement r39 = r38.get(0);
        if (r39 == null) goto L34;
        if (r39.isJsonObject() == false) goto L34;
        r7 = r39.getAsJsonObject();
        goto L35
    L14:
        if (r4.isJsonArray() == false) goto L22;
        JsonArray r40 = r4.getAsJsonArray();
        if (r40.size() <= 0) goto L22;
        JsonElement r41 = r40.get(0);
        if (r41 == null) goto L22;
        if (r41.isJsonObject() == false) goto L22;
        r5 = r41.getAsJsonObject();
        goto L23
    }

    public Bundle b(AbstractC0355a r34, int r35) {
        AbstractC0355a r1 = r34;
        int r2 = r35;
        long r3 = System.currentTimeMillis();
        String r7 = "destination";
        String r8 = "origin";
        String r4 = "type";
        String r23 = "steps";
        String r6 = "com.obric.memorydata.plugin";
        String r24 = "end_location";
        if (r2 != 1) goto L5;
        String r5 = r23;
        if (ZeusTransformUtils.instanceOf(r1, p.class) == true) goto L205;
        String r9 = "invalid transit request";
    L203:
        Bundle r0 = a(-1, r9, r1, r35);
    L204:
        Bundle r10 = r0;
        String r11 = r9;
    L13:
        j r12 = null;
    L329:
        com.obric.cae.location.report.d.a(r35, r34, r12, r3, System.currentTimeMillis(), r11);     // Catch: Exception -> L326
    L328:
        return r10;
    L326:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "failed to report direction search tea", e);
        goto L328
    L205:
        String r13 = "com.obric.memorydata.plugin";
        q r14 = b((p) ZeusTransformUtils.preCheckCast(r1, p.class, r13));
        if (r14 != null) goto L208;
        r9 = "transit search failed";
        goto L203
    L208:
        Bundle r15 = new Bundle();
        a(r15, "status", r14.f7123a);
        r15.putString("message", r14.f7124b);
        a(r15, "type", r14.c);
        a(r15, "transit_type", r14.d);
        r r16 = r14.e;
        if (r16 == null) goto L321;
        Bundle r17 = new Bundle();
        o r18 = r16.f7143a;
        if (r18 == null) goto L217;
        Bundle r19 = new Bundle();
        r19.putString("city_id", r18.f7141a);
        r19.putString("city_name", r18.f7142b);
        s r20 = r18.c;
        if (r20 == null) goto L215;
        r19.putBundle("location", a(r20));
    L215:
        r17.putBundle("origin", r19);
    L217:
        o r21 = r16.f7144b;
        if (r21 == null) goto L223;
        Bundle r22 = new Bundle();
        r22.putString("city_id", r21.f7141a);
        r22.putString("city_name", r21.f7142b);
        s r25 = r21.c;
        if (r25 == null) goto L222;
        r22.putBundle("location", a(r25));
    L222:
        r17.putBundle("destination", r22);
    L223:
        y r26 = r16.c;
        if (r26 == null) goto L239;
        Bundle r27 = new Bundle();
        List<x> r28 = r26.f7157a;
        if (r28 != null) goto L228;
        String r29 = r5;
        String r210 = "type";
        ArrayList<? extends Parcelable> r30 = null;
    L236:
        if (r30 == null) goto L238;
        r27.putParcelableArrayList(MemoryListActivity.JUMP_FROM_DETAIL, r30);
    L238:
        a(r27, "distance", r26.f7158b);
        a(r27, "duration", r26.c);
        r27.putString("remark", r26.d);
        r17.putBundle("taxi", r27);
    L240:
        a(r17, LBSLightLocationTraceLogger.TOTAL, r16.d);
        List<u> r31 = r16.e;
        if (r31 != null) goto L243;
        Bundle r211 = r17;
        ArrayList<? extends Parcelable> r32 = null;
    L317:
        if (r32 == null) goto L319;
        Bundle r33 = r211;
        r33.putParcelableArrayList("routes", r32);
    L320:
        Bundle r36 = r15;
        r36.putBundle("result", r33);
        q r110 = r14;
    L322:
        Bundle r37 = r36;
        j r111 = r110;
    L323:
        r10 = r37;
        r12 = r111;
        r11 = null;
        goto L329
    L319:
        r33 = r211;
        goto L320
    L243:
        r32 = new ArrayList();
        Iterator<u> r38 = r31.iterator();
    L245:
        if (r38.hasNext() == false) goto L316;
        u r39 = (u) ZeusTransformUtils.preCheckCast(r38.next(), u.class, r13);
        if (r39 == null) goto L314;
        Bundle r40 = new Bundle();
        a(r40, "distance", r39.f7149a);
        a(r40, "duration", r39.f7150b);
        a(r40, "price", r39.c);
        r40.putString("arrive_time", r39.d);
        List<t> r41 = r39.e;
        if (r41 != null) goto L251;
        Iterator<u> r212 = r38;
        ArrayList<? extends Parcelable> r42 = null;
    L258:
        if (r42 == null) goto L260;
        r40.putParcelableArrayList("price_detail", r42);
    L260:
        List<List<w>> r43 = r39.f;
        if (r43 != null) goto L264;
        ArrayList<? extends Parcelable> r213 = r32;
        String r310 = r13;
        Bundle r214 = r40;
        Bundle r215 = r17;
        ArrayList<? extends Parcelable> r44 = null;
    L263:
        String r45 = r210;
        String r46 = r29;
        Bundle r47 = r214;
        if (r44 == null) goto L313;
        r47.putParcelableArrayList(r46, r44);
    L313:
        ArrayList<? extends Parcelable> r48 = r213;
        r48.add(r47);
        r29 = r46;
        r32 = r48;
        r210 = r45;
        r38 = r212;
        r17 = r215;
    L315:
        r13 = r310;
        goto L245
    L264:
        r44 = new ArrayList();
        int r49 = 0;
    L266:
        if (r49 >= r43.size()) goto L309;
        List r50 = (List) ZeusTransformUtils.preCheckCast(r43.get(r49), List.class, r13);
        Bundle r51 = new Bundle();
        r51.putInt("index", r49);
        ArrayList<? extends Parcelable> r112 = new ArrayList();
        if (r50 == null) goto L308;
        Iterator r52 = r50.iterator();
    L271:
        if (r52.hasNext() == false) goto L308;
        r43 = r43;
        r52 = r52;
        w r53 = (w) ZeusTransformUtils.preCheckCast(r52.next(), w.class, r13);
        if (r53 == null) goto L271;
        Bundle r54 = new Bundle();
        Bundle r216 = r17;
        a(r54, "distance", r53.f7153a);
        a(r54, "duration", r53.f7154b);
        r54.putString("instructions", r53.c);
        r54.putString("path", r53.d);
        ArrayList<? extends Parcelable> r217 = r32;
        a(r54, "traffic_condition", r53.e);
        s r55 = r53.f;
        if (r55 == null) goto L277;
        r54.putBundle("start_location", a(r55));
    L277:
        s r56 = r53.g;
        if (r56 == null) goto L280;
        r54.putBundle(r24, a(r56));
    L280:
        z r57 = r53.h;
        if (r57 == null) goto L283;
        Bundle r113 = new Bundle();
        String r58 = r210;
        a(r113, r58, r57.f7159a);
        a(r113, MemoryListActivity.JUMP_FROM_DETAIL, r57.f7160b);
        r54.putBundle("vehicle_info", r113);
    L284:
        List<v> r59 = r53.i;
        if (r59 != null) goto L287;
        String r311 = r13;
        ArrayList<? extends Parcelable> r60 = null;
    L304:
        if (r60 == null) goto L306;
        r54.putParcelableArrayList("schemes", r60);
    L306:
        r112.add(r54);
        r210 = r58;
        r17 = r216;
        r32 = r217;
        r40 = r40;
        r49 = r49;
        r13 = r311;
        goto L271
    L287:
        r60 = new ArrayList();
        Iterator<v> r61 = r59.iterator();
    L289:
        if (r61.hasNext() == false) goto L303;
        v r62 = (v) ZeusTransformUtils.preCheckCast(r61.next(), v.class, r13);
        if (r62 == null) goto L289;
        Bundle r114 = new Bundle();
        Iterator<v> r218 = r61;
        a(r114, "distance", r62.f7151a);
        a(r114, "duration", r62.f7152b);
        r114.putString("instructions", r62.c);
        r114.putString("path", r62.d);
        s r63 = r62.e;
        if (r63 == null) goto L295;
        r114.putBundle("start_location", a(r63));
    L295:
        s r64 = r62.f;
        if (r64 == null) goto L298;
        r114.putBundle(r24, a(r64));
    L298:
        z r65 = r62.g;
        if (r65 == null) goto L302;
        Bundle r66 = new Bundle();
        a(r66, r58, r65.f7159a);
        a(r66, MemoryListActivity.JUMP_FROM_DETAIL, r65.f7160b);
        r114.putBundle("vehicle_info", r66);
    L302:
        r60.add(r114);
        r61 = r218;
        r13 = r13;
        goto L289
    L303:
        r311 = r13;
        goto L304
    L283:
        r58 = r210;
    L308:
        r51.putParcelableArrayList("items", r112);
        r44.add(r51);
        r210 = r210;
        r17 = r17;
        r32 = r32;
        r40 = r40;
        r13 = r13;
        r49 = r49 + 1;
        r43 = r43;
        goto L266
    L309:
        r213 = r32;
        r310 = r13;
        r214 = r40;
        r215 = r17;
        goto L263
    L251:
        r42 = new ArrayList();
        Iterator<t> r67 = r41.iterator();
    L253:
        if (r67.hasNext() == false) goto L257;
        t r68 = (t) ZeusTransformUtils.preCheckCast(r67.next(), t.class, r13);
        if (r68 == null) goto L253;
        Bundle r115 = new Bundle();
        a(r115, "ticket_type", r68.f7147a);
        a(r115, "ticket_price", r68.f7148b);
        r42.add(r115);
        r38 = r38;
        r67 = r67;
        goto L253
    L257:
        r212 = r38;
        goto L258
    L314:
        r310 = r13;
        goto L315
    L316:
        r211 = r17;
        goto L317
    L228:
        r30 = new ArrayList();
        Iterator<x> r69 = r28.iterator();
    L230:
        if (r69.hasNext() == false) goto L235;
        r69 = r69;
        x r70 = (x) ZeusTransformUtils.preCheckCast(r69.next(), x.class, r13);
        if (r70 == null) goto L230;
        Bundle r116 = new Bundle();
        r116.putString("desc", r70.f7155a);
        a(r116, "km_price", r70.f7156b);
        a(r116, "start_price", r70.c);
        a(r116, "total_price", r70.d);
        r30.add(r116);
        r5 = r5;
        r4 = r4;
        goto L230
    L235:
        r29 = r5;
        r210 = r4;
        goto L236
    L239:
        r29 = r5;
        r210 = "type";
        goto L240
    L321:
        r36 = r15;
        r110 = r14;
        goto L322
    L5:
        if (r2 == 2) goto L151;
        String r219 = "start_location";
        String r220 = "path";
        String r221 = "instructions";
        String r222 = "duration";
        if (r2 != 3) goto L9;
        r1 = r34;
        if (ZeusTransformUtils.instanceOf(r1, ac.class) == true) goto L92;
        r10 = a(-1, "invalid walking request", r1, r35);
        r11 = "invalid walking request";
        goto L13
    L92:
        r2 = r35;
        String r223 = r221;
        ad r117 = a((ac) ZeusTransformUtils.preCheckCast(r1, ac.class, "com.obric.memorydata.plugin"));
        if (r117 != null) goto L96;
        String r71 = "walking search failed";
    L95:
        Bundle r72 = a(-1, r71, r1, r2);
    L12:
        r10 = r72;
        r11 = r71;
        goto L13
    L96:
        r37 = new Bundle();
        a(r37, "status", r117.f7123a);
        r37.putString("message", r117.f7124b);
        a(r37, "type", r117.c);
        ae r73 = r117.d;
        j r118 = r117;
        if (r73 != null) goto L98;
    L88:
        r111 = r118;
        goto L323
    L98:
        Bundle r119 = new Bundle();
        ab r120 = r73.f7097a;
        j r121 = r117;
        if (r120 == null) goto L104;
        Bundle r122 = new Bundle();
        a(r122, "area_id", r120.f7095a);
        r122.putString("cname", r120.f7096b);
        r122.putString("uid", r120.c);
        r122.putString("wd", r120.d);
        s r74 = r120.e;
        if (r74 == null) goto L103;
        r122.putBundle("location", a(r74));
    L103:
        r119.putBundle("origin", r122);
    L104:
        ab r75 = r73.f7098b;
        if (r75 == null) goto L110;
        Bundle r76 = new Bundle();
        a(r76, "area_id", r75.f7095a);
        r76.putString("cname", r75.f7096b);
        r76.putString("uid", r75.c);
        r76.putString("wd", r75.d);
        s r77 = r75.e;
        if (r77 == null) goto L109;
        r76.putBundle("location", a(r77));
    L109:
        r119.putBundle("destination", r76);
    L110:
        List<af> r78 = r73.c;
        if (r78 != null) goto L113;
        ArrayList<? extends Parcelable> r79 = null;
    L147:
        if (r79 == null) goto L87;
        r119.putParcelableArrayList("routes", r79);
    L87:
        r37.putBundle("result", r119);
        r111 = r121;
        goto L323
    L113:
        r79 = new ArrayList();
        Iterator<af> r80 = r78.iterator();
    L115:
        if (r80.hasNext() == false) goto L147;
        af r81 = (af) ZeusTransformUtils.preCheckCast(r80.next(), af.class, "com.obric.memorydata.plugin");
        if (r81 == null) goto L115;
        Bundle r82 = new Bundle();
        a(r82, "distance", r81.f7099a);
        String r123 = r222;
        a(r82, r123, r81.f7100b);
        s r83 = r81.d;
        if (r83 == null) goto L121;
        r82.putBundle("origin_location", a(r83));
    L121:
        s r84 = r81.e;
        if (r84 == null) goto L124;
        r82.putBundle("destination_location", a(r84));
    L124:
        List<ag> r85 = r81.c;
        if (r85 != null) goto L128;
        Iterator<af> r312 = r80;
        ArrayList<? extends Parcelable> r86 = null;
    L127:
        String r87 = r24;
        String r124 = r219;
        String r125 = r220;
        String r126 = r223;
        String r88 = r23;
        if (r86 == null) goto L146;
        r82.putParcelableArrayList(r88, r86);
    L146:
        r79.add(r82);
        r23 = r88;
        r24 = r87;
        r222 = r123;
        r219 = r124;
        r223 = r126;
        r220 = r125;
        r80 = r312;
        goto L115
    L128:
        r86 = new ArrayList();
        Iterator<ag> r89 = r85.iterator();
    L130:
        if (r89.hasNext() == false) goto L142;
        ag r90 = (ag) ZeusTransformUtils.preCheckCast(r89.next(), ag.class, "com.obric.memorydata.plugin");
        if (r90 == null) goto L130;
        Bundle r127 = new Bundle();
        a(r127, "leg_index", r90.f7101a);
        a(r127, "area", r90.f7102b);
        a(r127, "direction", r90.c);
        a(r127, "distance", r90.d);
        a(r127, r123, r90.e);
        String r128 = r223;
        r127.putString(r128, r90.f);
        r127.putString(ActivityLifecycle.NAME, r90.g);
        String r129 = r220;
        r127.putString(r129, r90.h);
        Iterator<af> r313 = r80;
        a(r127, "pois", r90.i);
        a(r127, "type", r90.j);
        a(r127, "turn_type_id", r90.k);
        r127.putString("step_origin_instruction", r90.n);
        r127.putString("step_destination_instruction", r90.o);
        s r91 = r90.l;
        if (r91 == null) goto L136;
        String r130 = r219;
        r127.putBundle(r130, a(r91));
    L137:
        s r92 = r90.m;
        if (r92 == null) goto L140;
        String r93 = r24;
        r127.putBundle(r93, a(r92));
    L141:
        r86.add(r127);
        r80 = r313;
        r24 = r93;
        r219 = r130;
        r223 = r128;
        r220 = r129;
        goto L130
    L140:
        r93 = r24;
        goto L141
    L136:
        r130 = r219;
        goto L137
    L142:
        r312 = r80;
        goto L127
    L9:
        if (r2 == 4) goto L15;
        r71 = "Unimplemented direction type: " + r2;
        com.obric.cae.log.a.d("StarLocation-BdLM", r71);
    L11:
        r72 = a(-1, r71, r1, r2);
        goto L12
    L15:
        if (ZeusTransformUtils.instanceOf(r1, i.class) == true) goto L17;
        r71 = "invalid riding request";
        goto L11
    L17:
        j r131 = b((i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.memorydata.plugin"));
        if (r131 != null) goto L20;
        r71 = "riding search failed";
        goto L95
    L20:
        r37 = new Bundle();
        a(r37, "status", r131.f7123a);
        r37.putString("message", r131.f7124b);
        a(r37, "type", r131.c);
        k r94 = r131.d;
        r118 = r131;
        if (r94 == null) goto L88;
        r119 = new Bundle();
        h r132 = r94.f7133a;
        r121 = r131;
        if (r132 == null) goto L28;
        Bundle r133 = new Bundle();
        a(r133, "area_id", r132.f7131a);
        r133.putString("cname", r132.f7132b);
        r133.putString("uid", r132.c);
        r133.putString("wd", r132.d);
        s r95 = r132.e;
        if (r95 == null) goto L27;
        r133.putBundle("location", a(r95));
    L27:
        r119.putBundle("origin", r133);
    L28:
        h r96 = r94.f7134b;
        if (r96 == null) goto L34;
        Bundle r97 = new Bundle();
        a(r97, "area_id", r96.f7131a);
        r97.putString("cname", r96.f7132b);
        r97.putString("uid", r96.c);
        r97.putString("wd", r96.d);
        s r98 = r96.e;
        if (r98 == null) goto L33;
        r97.putBundle("location", a(r98));
    L33:
        r119.putBundle("destination", r97);
    L34:
        List<m> r99 = r94.c;
        if (r99 != null) goto L37;
        ArrayList<? extends Parcelable> r100 = null;
    L84:
        if (r100 == null) goto L87;
        r119.putParcelableArrayList("routes", r100);
        goto L87
    L37:
        r100 = new ArrayList();
        Iterator<m> r101 = r99.iterator();
    L39:
        if (r101.hasNext() == false) goto L84;
        m r102 = (m) ZeusTransformUtils.preCheckCast(r101.next(), m.class, "com.obric.memorydata.plugin");
        if (r102 == null) goto L39;
        Bundle r103 = new Bundle();
        a(r103, "restrictions_status", r102.f7137a);
        r103.putString("restrictions_info", r102.f7138b);
        a(r103, "distance", r102.c);
        String r134 = r222;
        a(r103, r134, r102.d);
        s r104 = r102.f;
        if (r104 == null) goto L45;
        r103.putBundle("origin_location", a(r104));
    L45:
        s r105 = r102.g;
        if (r105 == null) goto L48;
        r103.putBundle("destination_location", a(r105));
    L48:
        List<n> r106 = r102.e;
        if (r106 != null) goto L52;
        Iterator<m> r314 = r101;
        r222 = r134;
        ArrayList<? extends Parcelable> r107 = null;
    L51:
        String r135 = r24;
        String r136 = r220;
        String r108 = r23;
        if (r107 == null) goto L83;
        r103.putParcelableArrayList(r108, r107);
    L83:
        r100.add(r103);
        r23 = r108;
        r24 = r135;
        r220 = r136;
        r101 = r314;
        goto L39
    L52:
        r107 = new ArrayList();
        Iterator<n> r109 = r106.iterator();
    L54:
        if (r109.hasNext() == false) goto L79;
        n r137 = (n) ZeusTransformUtils.preCheckCast(r109.next(), n.class, "com.obric.memorydata.plugin");
        if (r137 == null) goto L54;
        Bundle r138 = new Bundle();
        a(r138, "leg_index", r137.f7139a);
        a(r138, "area", r137.f7140b);
        a(r138, "direction", r137.c);
        a(r138, "distance", r137.d);
        a(r138, r134, r137.e);
        String r139 = r221;
        r138.putString(r139, r137.f);
        r138.putString(ActivityLifecycle.NAME, r137.g);
        String r140 = r220;
        r138.putString(r140, r137.h);
        Iterator<m> r315 = r101;
        a(r138, "pois", r137.i);
        a(r138, "type", r137.j);
        r138.putString("turn_type", r137.k);
        r138.putString("restrictions_info", r137.l);
        r138.putString("step_origin_instruction", r137.o);
        r138.putString("step_destination_instruction", r137.p);
        a(r138, "restrictions_status", r137.q);
        s r141 = r137.m;
        if (r141 == null) goto L60;
        String r142 = r219;
        r138.putBundle(r142, a(r141));
    L61:
        s r143 = r137.n;
        if (r143 == null) goto L64;
        String r144 = r24;
        r138.putBundle(r144, a(r143));
    L65:
        List<l> r145 = r137.r;
        if (r145 != null) goto L68;
        Iterator<n> r224 = r109;
        r219 = r142;
        r221 = r139;
        ArrayList<? extends Parcelable> r146 = null;
    L76:
        if (r146 == null) goto L78;
        r138.putParcelableArrayList("links", r146);
    L78:
        r107.add(r138);
        r101 = r315;
        r24 = r144;
        r220 = r140;
        r109 = r224;
        r134 = r134;
        goto L54
    L68:
        r146 = new ArrayList();
        Iterator<l> r147 = r145.iterator();
    L70:
        if (r147.hasNext() == false) goto L75;
        r109 = r109;
        r147 = r147;
        l r148 = (l) ZeusTransformUtils.preCheckCast(r147.next(), l.class, "com.obric.memorydata.plugin");
        if (r148 == null) goto L70;
        Bundle r149 = new Bundle();
        a(r149, XSDatatype.FACET_LENGTH, r148.f7135a);
        a(r149, "attr", r148.f7136b);
        r146.add(r149);
        r142 = r142;
        r139 = r139;
        goto L70
    L75:
        r224 = r109;
        r219 = r142;
        r221 = r139;
        goto L76
    L64:
        r144 = r24;
        goto L65
    L60:
        r142 = r219;
        goto L61
    L79:
        r314 = r101;
        r222 = r134;
        goto L51
    L151:
        if (ZeusTransformUtils.instanceOf(r34, c.class) == true) goto L154;
        r9 = "invalid driving request";
    L153:
        r0 = a(-1, r9, r34, r35);
        goto L204
    L154:
        String r225 = r23;
        d r150 = b((c) ZeusTransformUtils.preCheckCast(r34, c.class, "com.obric.memorydata.plugin"));
        if (r150 != null) goto L157;
        r9 = "driving search failed";
        goto L153
    L157:
        r37 = new Bundle();
        a(r37, "status", r150.f7123a);
        r37.putString("message", r150.f7124b);
        a(r37, "type", r150.c);
        e r151 = r150.d;
        if (r151 == null) goto L199;
        Bundle r152 = new Bundle();
        r152.putString("restriction", r151.f7125a);
        a(r152, LBSLightLocationTraceLogger.TOTAL, r151.f7126b);
        r152.putString("session_id", r151.c);
        List<f> r153 = r151.d;
        if (r153 != null) goto L162;
        d r154 = r150;
        ArrayList<? extends Parcelable> r155 = null;
    L196:
        if (r155 == null) goto L198;
        r152.putParcelableArrayList("routes", r155);
    L198:
        r37.putBundle("result", r152);
        r111 = r154;
        goto L323
    L162:
        r155 = new ArrayList();
        Iterator<f> r156 = r153.iterator();
    L164:
        if (r156.hasNext() == false) goto L195;
        r150 = r150;
        f r157 = (f) ZeusTransformUtils.preCheckCast(r156.next(), f.class, r6);
        if (r157 == null) goto L164;
        Bundle r158 = new Bundle();
        Iterator<f> r316 = r156;
        s r159 = r157.f7127a;
        if (r159 == null) goto L170;
        r158.putBundle(r8, a(r159));
    L170:
        s r160 = r157.f7128b;
        if (r160 == null) goto L173;
        r158.putBundle(r7, a(r160));
    L173:
        String r226 = r7;
        r158.putString(LocationMonitorConst.TAG, r157.c);
        r158.putString("mrsl", r157.d);
        r158.putString("route_md5", r157.e);
        a(r158, "traffic_light", r157.f);
        a(r158, "distance", r157.g);
        a(r158, "duration", r157.h);
        a(r158, "taxi_fee", r157.i);
        List<g> r161 = r157.j;
        if (r161 != null) goto L176;
        String r227 = r6;
        String r228 = r8;
        ArrayList<? extends Parcelable> r162 = null;
    L190:
        String r163 = r225;
        if (r162 == null) goto L193;
        r158.putParcelableArrayList(r163, r162);
    L193:
        r155.add(r158);
        r156 = r316;
        r225 = r163;
        r7 = r226;
        r8 = r228;
        r6 = r227;
        goto L164
    L176:
        r162 = new ArrayList();
        Iterator<g> r164 = r161.iterator();
    L178:
        if (r164.hasNext() == false) goto L189;
        r164 = r164;
        g r165 = (g) ZeusTransformUtils.preCheckCast(r164.next(), g.class, r6);
        if (r165 == null) goto L178;
        Bundle r166 = new Bundle();
        String r229 = r8;
        String r230 = r6;
        a(r166, "leg_index", r165.f7129a);
        a(r166, "link_num", r165.f7130b);
        r166.putString("road_name", r165.c);
        a(r166, "direction", r165.d);
        a(r166, "distance", r165.e);
        a(r166, "duration", r165.f);
        a(r166, "road_type", r165.g);
        a(r166, "toll", r165.h);
        a(r166, "toll_distance", r165.i);
        r166.putString("adcodes", r165.j);
        r166.putString("instructions", r165.c);
        r166.putString("path", r165.l);
        a(r166, "traffic_condition", r165.k);
        s r167 = r165.m;
        if (r167 == null) goto L184;
        r166.putBundle("start_location", a(r167));
    L184:
        s r168 = r165.n;
        if (r168 == null) goto L187;
        r166.putBundle(r24, a(r168));
    L187:
        r162.add(r166);
        r8 = r229;
        r6 = r230;
        goto L178
    L189:
        r227 = r6;
        r228 = r8;
        goto L190
    L195:
        r154 = r150;
        goto L196
    L199:
        r111 = r150;
        goto L323
    }

    public final aq b(String r9, String r10, HashMap r11) {
        HttpURLConnection r3 = null;
        HttpURLConnection r4 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r9).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r4.setConnectTimeout(d);     // Catch: Throwable -> L41
        r4.setReadTimeout(e);     // Catch: Throwable -> L41
        r4.setRequestMethod("POST");     // Catch: Throwable -> L41
        r4.setDoInput(true);     // Catch: Throwable -> L41
        r4.setDoOutput(true);     // Catch: Throwable -> L41
        Iterator r5 = r11.entrySet().iterator();     // Catch: Throwable -> L41
    L6:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        r4.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
        goto L6
    L9:
        if (r4.getRequestProperty(NetConst.KEY_CONTENT_TYPE) == null) goto L11;
    L13:
        byte[] r12 = r10.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L41
        r4.setFixedLengthStreamingMode(r12.length);     // Catch: Throwable -> L41
        OutputStream r13 = r4.getOutputStream();     // Catch: Throwable -> L41
        r13.write(r12);     // Catch: Throwable -> L34
        r13.close();     // Catch: Throwable -> L41
        int r14 = r4.getResponseCode();     // Catch: Throwable -> L41
        String r8 = a(r9, r4.getHeaderFields());     // Catch: Throwable -> L41
        if (r14 < 200) goto L19;
        if (r14 >= 300) goto L19;
        InputStream r7 = r4.getInputStream();     // Catch: Throwable -> L41
    L20:
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r7, RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L41
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L41
    L21:
        String r1 = r15.readLine();     // Catch: Throwable -> L41
        if (r1 == null) goto L24;
        r0.append(r1);     // Catch: Throwable -> L41
        goto L21
    L24:
        r15.close();     // Catch: Throwable -> L41
        String r16 = r0.toString();     // Catch: Throwable -> L41
        if (r14 < 200) goto L31;
        if (r14 >= 300) goto L31;
        com.obric.cae.log.a.d("StarLocation-BdLM", "response code=" + r14 + ", url=" + r9);     // Catch: Throwable -> L41
        aq r17 = new aq(r16, r8, r14);     // Catch: Throwable -> L41
        r4.disconnect();
        return r17;
    L31:
        com.obric.cae.log.a.j("StarLocation-BdLM", "response code=" + r14 + ", url=" + r9 + ", body=" + r16);     // Catch: Throwable -> L41
        aq r18 = new aq(r16, r8, r14, 0);     // Catch: Throwable -> L41
        r4.disconnect();
        return r18;
    L19:
        r7 = r4.getErrorStream();     // Catch: Throwable -> L41
        goto L20
    L34:
        th = move-exception;
        if (r13 != null) goto L52;
    L40:
        throw th;     // Catch: Throwable -> L41
    L52:
        r13.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L41
        goto L40
    L11:
        if (r11.containsKey("content-type") == true) goto L13;
        r4.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L41
    L41:
        th = th;
        r3 = r4;
    L44:
        if (r3 == null) goto L46;
        r3.disconnect();
    L46:
        throw th;
    L43:
        th = th;
        goto L44
    }

    public d b(final c r2) {
        return (d) ZeusTransformUtils.preCheckCast(a(r2, "DRIVING_SEARCH", new $$Lambda$a$JTY8U82jimqqcyNTNJEotvymqTo(this, r2)), d.class, "com.obric.memorydata.plugin");
    }

    public j b(final i r2) {
        return (j) ZeusTransformUtils.preCheckCast(a(r2, "RIDING_SEARCH", new $$Lambda$a$6zTs6GuUDTuPQ_JMyJ469X87T9w(this, r2)), j.class, "com.obric.memorydata.plugin");
    }

    public q b(final p r2) {
        return (q) ZeusTransformUtils.preCheckCast(a(r2, "TRANSIT_SEARCH", new $$Lambda$a$IlZo4o6BTT2OCLIBcVzpJYNIg(this, r2)), q.class, "com.obric.memorydata.plugin");
    }

    public final boolean b(int r9) {
        HashMap r4 = e();     // Catch: Exception -> L20
        if (r4 != null) goto L6;
        return false;
    L6:
        JsonObject r5 = new JsonObject();     // Catch: Exception -> L20
        r5.addProperty("aid", Integer.valueOf(Integer.parseInt("941134")));     // Catch: Exception -> L20
        r5.addProperty("index", "common_restrict");     // Catch: Exception -> L20
        aq r6 = a(e("/poi_server/api/v1/location/scene_recognize"), r5.toString(), r4);     // Catch: Exception -> L20
        String r7 = r6.f7121a;     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r7) == false) goto L10;
        com.obric.cae.log.a.j("StarLocation-BdLM", "response is empty");     // Catch: Exception -> L20
        return false;
    L10:
        JsonElement r8 = h(r7);     // Catch: Exception -> L20
        if (r8 != null) goto L14;
        com.obric.cae.log.a.j("StarLocation-BdLM", "response is not a valid json");     // Catch: Exception -> L20
        return false;
    L14:
        Bundle r10 = b(r8, r6.c);     // Catch: Exception -> L20
        if (r10 == null) goto L17;
        this.k = r10;     // Catch: Exception -> L20
        com.obric.cae.log.a.f("StarLocation-BdLM", "near poi data parsed, timestamp=" + r10.getLong("timestamp"));     // Catch: Exception -> L20
        StarPoiManager.a().g("Response Bundle: " + a(r10));     // Catch: Exception -> L20
        StarPoiManager.a().b(r10, r9);     // Catch: Exception -> L20
        return true;
    L17:
        StarPoiManager.a().g("Response Bundle: No useful data.");     // Catch: Exception -> L20
        return true;
    L20:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "failed", e);
        return false;
    }

    public Map<String, List<ai>> c(String r1, int r2, int r3, String r4, String r5) {
        Map<String, List<ai>> r0 = d(r1, r2, r3, r4, r5).f7113a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L9;
        return r0;
    L9:
        return null;
    }

    public boolean c() {
        Context r0 = this.j;
        if (r0 != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-BdLM", "appContext is null");
        return false;
    L7:
        if (com.obric.cae.location.database.d.a(r0).a() == false) goto L11;
        com.obric.cae.log.a.f("StarLocation-BdLM", "poi_datas already exists, skip network request");
        return true;
    L11:
        if (com.obric.cae.location.util.d.a().e() == true) goto L15;
        com.obric.cae.log.a.h("StarLocation-BdLM", "Network invalid.");
        return false;
    L15:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L28;
        com.obric.cae.log.a.h("StarLocation-BdLM", "execute asynchronously on main thread");
        f.submit(new $$Lambda$OC7IxKyQmIAVOtsjNuKuu4SUYKU(this));
        return false;
    L28:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f.submit(new $$Lambda$OC7IxKyQmIAVOtsjNuKuu4SUYKU(this)).get(e, TimeUnit.MILLISECONDS), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L22:
        e = e;
        String r1 = "catch RuntimeException";
    L26:
        com.obric.cae.log.a.b("StarLocation-BdLM", r1, e);
        return false;
    L24:
        e = e;
        r1 = "catch TimeoutException";
    L20:
        e = e;
        r1 = "catch exception";
        goto L26
    }

    public boolean c(List<com.obric.cae.location.cell.c.b> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L29:
        com.obric.cae.log.a.b("StarLocation-BdLM", "infos is null or empty");
        return false;
    L5:
        if (r7.isEmpty() == true) goto L29;
        if (this.j != null) goto L12;
        com.obric.cae.log.a.j("StarLocation-BdLM", "appContext is null");
        return false;
    L12:
        if (com.obric.cae.location.util.d.a().e() == true) goto L15;
        com.obric.cae.log.a.h("StarLocation-BdLM", "Network invalid.");
        return false;
    L15:
        final ArrayList r3 = new ArrayList(r7);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L31;
        com.obric.cae.log.a.h("StarLocation-BdLM", "execute asynchronously on main thread, count=" + r3.size());
        f.submit(new $$Lambda$a$jIgJ984UsniX7VFE3rxAlJ2fRU(this, r3));
        return false;
    L31:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f.submit(new $$Lambda$a$GZCLEmypI7BUfurG5yfJENt0p8U(this, r3)).get(e, TimeUnit.MILLISECONDS), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L23:
        e = e;
        String r8 = "catch RuntimeException";
    L27:
        com.obric.cae.log.a.b("StarLocation-BdLM", r8, e);
        return false;
    L25:
        e = e;
        r8 = "catch TimeoutException";
    L21:
        e = e;
        r8 = "catch exception";
        goto L27
    }

    public am d(String r8, int r9, int r10, String r11, String r12) {
        return a(this.j, r8, r9, r10, r11, r12);
    }

    public final boolean d() {
        Context r1 = this.j;
        if (r1 != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "appContext is null");
        return false;
    L6:
        com.obric.cae.location.database.d r2 = com.obric.cae.location.database.d.a(r1);
        if (r2.a() == false) goto L26;
        com.obric.cae.log.a.f("StarLocation-BdLM", "poi_datas already exists, skip network request");
        return true;
    L26:
        JsonObject r4 = new JsonObject();     // Catch: Exception -> L23
        r4.addProperty("need_offline_data", 0);     // Catch: Exception -> L23
        r4.addProperty("type_code_version", 1);     // Catch: Exception -> L23
        String r5 = e("/poi_server/api/v1/aweme/get_all_backend_type_data");     // Catch: Exception -> L23
        HashMap r6 = e();     // Catch: Exception -> L23
        if (r6 != null) goto L13;
        return false;
    L13:
        String r8 = a(r5, r4.toString(), r6).f7121a;     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r8) == false) goto L17;
        com.obric.cae.log.a.j("StarLocation-BdLM", "response is empty");     // Catch: Exception -> L23
        return false;
    L17:
        ArrayList r9 = b(r8);     // Catch: Exception -> L23
        if (r9.isEmpty() == false) goto L21;
        com.obric.cae.log.a.j("StarLocation-BdLM", "parsed poi type data is empty");     // Catch: Exception -> L23
        return false;
    L21:
        boolean r3 = r2.a(r9);     // Catch: Exception -> L23
        com.obric.cae.log.a.f("StarLocation-BdLM", "success=" + r3 + ", count=" + r9.size());     // Catch: Exception -> L23
        return r3;
    L23:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "failed", e);
        return false;
    }

    public final boolean d(List<com.obric.cae.location.cell.c.b> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L5;
        return false;
    L5:
        Context r3 = this.j;
        if (r3 != null) goto L52;
        com.obric.cae.log.a.j("StarLocation-BdLM", "appContext is null");
        return false;
    L52:
        HashMap r6 = e();     // Catch: Exception -> L49
        if (r6 != null) goto L12;
        return false;
    L12:
        aq r10 = a(e("/poi_server/api/v1/location/mget_geo_profile"), b(r12).toString(), r6);     // Catch: Exception -> L49
        String r7 = r10.f7121a;     // Catch: Exception -> L49
        String r8 = r10.c;     // Catch: Exception -> L49
        int r13 = r10.d;     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r7) == false) goto L16;
        com.obric.cae.log.a.j("StarLocation-BdLM", "CELL_GEO_PROFILE: response is empty, status=" + r13 + ", X-Tt-Logid=" + f(r8));     // Catch: Exception -> L49
        return false;
    L16:
        ap r14 = a(r7, r12);     // Catch: Exception -> L49
        List<com.obric.cae.location.cell.c.b> r15 = r14.c;     // Catch: Exception -> L49
        if (r15.isEmpty() == true) goto L26;
        com.obric.cae.location.geosdk.poi.a r1 = com.obric.cae.location.geosdk.poi.a.a(r3, 0);     // Catch: Exception -> L49
        Iterator<com.obric.cae.location.cell.c.b> r16 = r15.iterator();     // Catch: Exception -> L49
    L21:
        if (r16.hasNext() == false) goto L26;
        com.obric.cae.location.cell.c.b r9 = (com.obric.cae.location.cell.c.b) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.cae.location.cell.c.b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L49
        if (r9 == null) goto L21;
        r1.f("cell_info: " + r9.toString());     // Catch: Exception -> L49
    L26:
        List<com.obric.cae.location.database.a.C0353a> r17 = r14.f7119a;     // Catch: Exception -> L49
        if (r17.isEmpty() == false) goto L30;
        com.obric.cae.log.a.d("StarLocation-BdLM", "no cell profile parsed");     // Catch: Exception -> L49
        return false;
    L30:
        com.obric.cae.location.database.a r2 = com.obric.cae.location.database.a.a(r3);     // Catch: Exception -> L49
        Iterator<com.obric.cae.location.database.a.C0353a> r18 = r17.iterator();     // Catch: Exception -> L49
        int r19 = 0;
    L32:
        if (r18.hasNext() == false) goto L36;
        if (r2.a((com.obric.cae.location.database.a.C0353a) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.cae.location.database.a.C0353a.class, "com.obric.memorydata.plugin")) == false) goto L32;
        r19 = r19 + 1;     // Catch: Exception -> L49
        goto L32
    L36:
        com.obric.cae.log.a.f("StarLocation-BdLM", "CELL_GEO_PROFILE saved count=" + r19 + ", parsed count=" + r17.size());     // Catch: Exception -> L49
        a(r14.f7120b);     // Catch: Exception -> L49
        if (r14.f7120b.isEmpty() == true) goto L46;
        com.obric.cae.location.geosdk.poi.a r110 = com.obric.cae.location.geosdk.poi.a.a(r3, 0);     // Catch: Exception -> L49
        ArrayList r4 = a(r110, r14.f7120b);     // Catch: Exception -> L49
        if (r4.isEmpty() == false) goto L41;
    L44:
        boolean r111 = true;
    L45:
        com.obric.cae.log.a.f("StarLocation-BdLM", "CELL_GEO_PROFILE saved aoi board=" + r111 + ", updated cell fields=" + com.obric.cae.location.database.c.a(r3, 0).a(r14.f7120b) + ", save count=" + r4.size() + ", parsed count=" + r14.f7120b.size());     // Catch: Exception -> L49
        goto L46
    L41:
        if (r110.c(r4) == true) goto L44;
        r111 = false;
    L46:
        if (r19 > 0) goto L48;
        return false;
    L48:
        return true;
    L49:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "failed", e);
        return false;
    }

    public al e(final String r13, final int r14, final int r15, final String r16, final String r17) {
        if (com.obric.cae.location.util.d.a().e() == true) goto L7;
        com.obric.cae.log.a.h("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: Network invalid.");
        return new al(false, new ArrayList(), null, "network invalid");
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
        com.obric.cae.log.a.h("StarLocation-BdLM", "TEXT_SEARCH_MAP_POI: skip sync query on main thread, keyword=" + f(r13) + ", city=" + f(r16));
        return new al(false, new ArrayList(), null, "main thread");
    L20:
        return (al) ZeusTransformUtils.preCheckCast(f.submit(new $$Lambda$a$MIDDHbiV7OdFw9Wcfc32jFHt99c(this, r13, r14, r15, r16, r17)).get(e, TimeUnit.MILLISECONDS), al.class, "com.obric.memorydata.plugin");
    L14:
        e = e;
        String r4 = "TEXT_SEARCH_MAP_POI: catch RuntimeException";
    L18:
        com.obric.cae.log.a.b("StarLocation-BdLM", r4, e);
        return new al(false, new ArrayList(), null, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
    L16:
        e = e;
        r4 = "TEXT_SEARCH_MAP_POI: catch TimeoutException";
    L12:
        e = e;
        r4 = "TEXT_SEARCH_MAP_POI: catch exception";
        goto L18
    }

    public final HashMap e() {
        String r0 = com.obric.cae.location.util.d.a().i();
        String r3 = null;
        if (TextUtils.isEmpty(r0) == false) goto L6;
        com.obric.cae.log.a.j("StarLocation-BdLM", "attestation certChain is empty");
        return null;
    L6:
        HashMap r1 = new HashMap();
        if (TextUtils.isEmpty(null) == true) goto L9;
        r1.put("x-tt-env", null);
        r1.put("x-use-ppe", "1");
    L9:
        r1.put("x-att-certchain", r0);
        r1.put("x-att-app-id", "ocean_location");
        r1.put("x-encrypt-app-id", "ocean_location");
        if (this.j == null) goto L13;
        r3 = MatrixDidUtils.getDid(this.j);
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r1.put("x-encrypt-did", r3);
    L16:
        return r1;
    L15:
        com.obric.cae.log.a.h("StarLocation-BdLM", "skip x-encrypt-did header because did is empty");
        goto L16
    }

    public final am f(String r9, int r10, int r11, String r12, String r13) {
        com.obric.cae.log.a.f("StarLocation-BdLM", "POI_SEARCH: execute search");
        HashMap r6 = e();     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        String r7 = null;
        if (r6 == null) goto L60;
        String r8 = a(e("/poi_server/api/v1/commsense/poi/textsearch"), b(b(r9, r10, r11, r12, r13), "POI_SEARCH").toString(), r6).f7121a;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r8 == null) goto L73;
        com.obric.cae.log.a.f("StarLocation-BdLM", "POI_SEARCH: Raw Response length: " + r8.length());     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        aj r14 = d(r8);     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r14 == null) goto L43;
        Integer r15 = r14.f7107a;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r15 != null) goto L14;
    L17:
        ah r16 = r14.f7108b;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r16 == null) goto L43;
        if (r16.f7103a == null) goto L43;
    L21:
        com.obric.cae.log.a.f("StarLocation-BdLM", "POI_SEARCH: status:200");     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        ah r17 = r14.f7108b;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r17 != null) goto L24;
    L41:
        am r18 = new am(new HashMap(), r14.f7107a, r14.c);     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
    L75:
        return r18;
    L24:
        if (r17.f7103a == null) goto L41;
        HashMap r19 = new HashMap();     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        Iterator<ai> r110 = r14.f7108b.f7103a.iterator();     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
    L27:
        if (r110.hasNext() == false) goto L74;
        ai r111 = (ai) ZeusTransformUtils.preCheckCast(r110.next(), ai.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        String r112 = r111.f7105a;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        String r113 = "";
        if (r112 != null) goto L33;
        r112 = "";
    L33:
        String r1 = r111.f7106b;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r1 == null) goto L36;
        r113 = r1;
    L36:
        String r114 = r112 + r113;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r19.containsKey(r114) == true) goto L39;
        r19.put(r114, new ArrayList());     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
    L39:
        ((List) ZeusTransformUtils.preCheckCast(r19.get(r114), List.class, "com.obric.memorydata.plugin")).add(r111);     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        goto L27
    L74:
        return new am(r19, r14.f7107a, r14.c);
    L14:
        if (r15.intValue() == 0) goto L21;
        if (r14.f7107a.intValue() == 102000001) goto L21;
    L43:
        int r20 = -99999;
        String r115 = "null";
        if (r14 == null) goto L51;
        Integer r116 = r14.f7107a;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r116 == null) goto L48;
        r20 = r116.intValue();     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
    L48:
        String r117 = r14.c;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r117 == null) goto L51;
        r115 = r117;
    L51:
        com.obric.cae.log.a.j("StarLocation-BdLM", "POI_SEARCH: Error code=" + r20 + ", msg=" + r115);     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        HashMap r118 = new HashMap();     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        if (r14 != null) goto L54;
        Integer r119 = null;
    L55:
        if (r14 == null) goto L58;
        r7 = r14.c;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
    L58:
        r18 = new am(r118, r119, r7);     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        goto L75
    L54:
        r119 = r14.f7107a;     // Catch: Exception -> L61 RuntimeException -> L64 SocketTimeoutException -> L66
        goto L55
    L73:
        return new am(new HashMap(), null, null);
    L60:
        return new am(new HashMap(), null, "headers is null");
    L64:
        e = move-exception;
        throw e;
    L66:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Network timeout in execute search", e);
        throw new RuntimeException("Network timeout", e);
    L61:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-BdLM", "POI_SEARCH: Exception in execute search", e);
        throw new RuntimeException("Execution failed", e);
    }
}
