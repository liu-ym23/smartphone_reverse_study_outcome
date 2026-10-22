package com.obric.cae.location.geosdk.bytedance;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
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
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.location.poi.IStarPoiCallback;
import com.obric.cae.location.cell.StarCellManager;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.database.StarPoiDbManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.AoiBoardUtil;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ha.j;
import ha.k;
import ha.m;
import ha.p;
import ha.r;
import ha.s;
import ha.u;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import ka.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BdLocationManager {
    public static final int ACCURACY_LEVEL = 4;
    private static final String BMAP_DRIVING_PATH = "/poi_server/api/v1/bmap/driving";
    private static final String BMAP_RIDING_PATH = "/poi_server/api/v1/bmap/riding";
    private static final String BMAP_SEARCH_PATH = "/poi_server/api/v1/bmap/search";
    private static final String BMAP_TRANSIT_PATH = "/poi_server/api/v1/bmap/transit";
    private static final String BMAP_WALKING_PATH = "/poi_server/api/v1/bmap/walking";
    private static final int CELL_GEO_PROFILE_ID_TYPE = 7;
    private static final String CELL_GEO_PROFILE_NAME = "base_station_profile";
    private static final String CELL_GEO_PROFILE_PATH = "/poi_server/api/v1/location/mget_geo_profile";
    private static final int CELL_GEO_PROFILE_PRIVACY = 0;
    private static final String CELL_GEO_PROFILE_VERSION = "v1";
    private static final String CONTENT_TYPE_FORM_UTF8 = "application/x-www-form-urlencoded; charset=utf-8";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_LOWERCASE = "content-type";
    private static final String CONTENT_TYPE_JSON_UTF8 = "application/json; charset=utf-8";
    public static final String DEFAULT_BASE_URL = "https://os.obriccloud.com";
    public static final String DEFAULT_WORLD_VIEW = "CN";
    private static final int GET_FENCES_MAX_BATCH_SIZE = 10;
    private static final String GET_FENCES_PATH = "/poi_server/api/v1/location/get_fences";
    private static final String HEADER_VALUE_ENABLE = "1";
    private static final String KEY_NEAR_POI_ACC_QUALIFIED = "is_acc_qualified_poi";
    private static final String KEY_NEAR_POI_AWEME_TYPE_CODE = "aweme_type_code";
    private static final String KEY_NEAR_POI_CONFIDENCE = "confidence";
    private static final String KEY_NEAR_POI_NAME = "name";
    public static final long LOCATION_CACHE_VALID_WINDOW_MS = 0;
    public static final int LOCATION_MODE = 2;
    private static final String LOCATION_SUBMIT_PATH = "/location/submit-v2";
    public static final long LOCATION_TIMEOUT = 0;
    public static final int LOCATION_TYPE = 1;
    private static final String NEAR_POI_DATA_INDEX = "common_restrict";
    private static final String NEAR_POI_DATA_PATH = "/poi_server/api/v1/location/scene_recognize";
    private static final String POI_API_BASE_URL = "https://os.obriccloud.com";
    private static final int POI_CERT_EXPIRED_PARSE_MAX_DEPTH = 3;
    private static final String POI_ENCRYPT_APP_ID = "ocean_location";
    private static final int POI_HTTP_CONNECT_TIMEOUT_MS = 0;
    private static final int POI_HTTP_TIMEOUT_MS = 0;
    private static final int POI_RESPONSE_CODE_CERT_EXPIRED = 102000002;
    private static final int POI_RESPONSE_CODE_PARTIAL_SUCCESS = 102000001;
    private static final int POI_RESPONSE_CODE_SUCCESS = 0;
    private static final String POI_TEXT_SEARCH_PATH = "/poi_server/api/v1/commsense/poi/textsearch";
    private static final String POI_TYPE_DATA_PATH = "/poi_server/api/v1/aweme/get_all_backend_type_data";
    private static final BdLocationManager SINGLETON = null;
    private static final String TAG = "StarLocation-BdLM";
    private static final String TEXT_SEARCH_MAP_POI_INDEX = "map_poi";
    private static final String TEXT_SEARCH_MAP_POI_PATH = "/poi_server/api/v1/location/textsearch_index_map_poi";
    private static final String X_ATT_APP_ID_HEADER = "x-att-app-id";
    private static final String X_ATT_CERT_CHAIN_HEADER = "x-att-certchain";
    private static final String X_ENCRYPT_APP_ID_HEADER = "x-encrypt-app-id";
    private static final String X_ENCRYPT_DID_HEADER = "x-encrypt-did";
    private static final String X_TT_ENV_HEADER = "x-tt-env";
    private static final String X_TT_LOGID_HEADER = "X-Tt-Logid";
    private static final String X_USE_PPE_HEADER = "x-use-ppe";
    private static final j sGson = null;
    private static final j sGsonPretty = null;
    private static final ExecutorService sPoiExecutor = null;
    private static final Object sSyncLock = null;
    private volatile Context appContext;
    private volatile boolean inited;
    private volatile Bundle mLastNearPoiDataBundle;
    private volatile String mLastSdkLogId;

    public static abstract class BmapBaseDirectionRequest {

        @ia.b(QesdkUtils.TAGS.JSON_TAG_CALLBACK)
        public String callback;

        @ia.b("coord_type")
        public String coordType;

        @ia.b("destination")
        public final String destination;

        @ia.b("destination_uid")
        public String destinationUid;

        @ia.b("origin")
        public final String origin;

        @ia.b("origin_uid")
        public String originUid;

        @ia.b(QesdkUtils.TAGS.TAG_OUTPUT)
        public String output;

        @ia.b("ret_coordtype")
        public String retCoordtype;

        @ia.b("sn")
        public String sn;

        @ia.b("timestamp")
        public long timestamp;
        public String xTtLogId;

        public BmapBaseDirectionRequest(String r8, String r10) {
            this.originUid = "";
            this.destinationUid = "";
            this.coordType = "";
            this.retCoordtype = "";
            this.output = "";
            this.sn = "";
            this.callback = "";
            this.xTtLogId = "";
            this.origin = r8;
            this.destination = r10;
        }
    }

    public static class BmapDirectionBaseResponse {

        @ia.b("message")
        public String message;

        @ia.b("status")
        public Integer status;

        @ia.b("type")
        public Integer type;

        public BmapDirectionBaseResponse() {
        }

        public boolean isSuccess() {
            Integer r8 = this.status;
            if (r8 != null) goto L5;
        L7:
            return false;
        L5:
            if (r8.intValue() != 0) goto L7;
            return true;
        }
    }

    public static class BmapDrivingDirectionRequest extends BmapBaseDirectionRequest {

        @ia.b("alternatives")
        public int alternatives;

        @ia.b("avoidpolygons")
        public String avoidPolygons;

        @ia.b("avoidroad")
        public String avoidRoad;

        @ia.b("plate_number")
        public String plateNumber;

        @ia.b("restriction")
        public String restriction;

        @ia.b("road_traffic")
        public int roadTraffic;

        @ia.b("tactics")
        public int tactics;

        @ia.b("waypoints")
        public String waypoints;

        public BmapDrivingDirectionRequest(String r8, String r10) {
            super(r8, r10);
            this.waypoints = "";
            this.avoidRoad = "";
            this.avoidPolygons = "";
            this.plateNumber = "";
            this.restriction = "";
        }
    }

    public static class BmapDrivingDirectionResponse extends BmapDirectionBaseResponse {

        @ia.b("result")
        public BmapDrivingDirectionResult result;

        public BmapDrivingDirectionResponse() {
        }
    }

    public static class BmapDrivingDirectionResult {

        @ia.b("restriction")
        public String restriction;

        @ia.b("routes")
        public List<BmapDrivingRoute> routes;

        @ia.b(QesdkUtils.TAGS.JSON_TAG_SESSION_ID)
        public String sessionId;

        @ia.b(LBSLightLocationTraceLogger.TOTAL)
        public Integer total;

        public BmapDrivingDirectionResult() {
        }
    }

    public static class BmapDrivingRoute {

        @ia.b("destination")
        public BmapTransitLocation destination;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("mrsl")
        public String mrsl;

        @ia.b("origin")
        public BmapTransitLocation origin;

        @ia.b("route_md5")
        public String routeMd5;

        @ia.b("steps")
        public List<BmapDrivingStep> steps;

        @ia.b(LocationMonitorConst.TAG)
        public String tag;

        @ia.b("taxi_fee")
        public Double taxiFee;

        @ia.b("traffic_light")
        public Integer trafficLight;

        public BmapDrivingRoute() {
        }
    }

    public static class BmapDrivingStep {

        @ia.b("adcodes")
        public String adcodes;

        @ia.b("direction")
        public Integer direction;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("end_location")
        public BmapTransitLocation endLocation;

        @ia.b("leg_index")
        public Integer legIndex;

        @ia.b("link_num")
        public Integer linkNum;

        @ia.b("path")
        public String path;

        @ia.b("road_name")
        public String roadName;

        @ia.b("road_type")
        public Integer roadType;

        @ia.b("start_location")
        public BmapTransitLocation startLocation;

        @ia.b("toll")
        public Double toll;

        @ia.b("toll_distance")
        public Integer tollDistance;

        @ia.b("traffic_condition")
        public p trafficCondition;

        public BmapDrivingStep() {
        }
    }

    public static class BmapRidingDirectionNode {

        @ia.b("area_id")
        public Integer areaId;

        @ia.b("cname")
        public String cityName;

        @ia.b(alternate = {"destinationPt", LocationMonitorConst.LOCATION}, value = "originPt")
        public BmapTransitLocation location;

        @ia.b("uid")
        public String uid;

        /* JADX INFO: renamed from: wd, reason: collision with root package name */
        @ia.b("wd")
        public String f5656wd;

        public BmapRidingDirectionNode() {
        }
    }

    public static class BmapRidingDirectionRequest extends BmapBaseDirectionRequest {

        @ia.b("riding_type")
        public String ridingType;

        @ia.b("road_prefer")
        public int roadPrefer;

        public BmapRidingDirectionRequest(String r8, String r10) {
            super(r8, r10);
            this.ridingType = "";
        }
    }

    public static class BmapRidingDirectionResponse extends BmapDirectionBaseResponse {

        @ia.b("result")
        public BmapRidingDirectionResult result;

        public BmapRidingDirectionResponse() {
        }
    }

    public static class BmapRidingDirectionResult {

        @ia.b("destination")
        public BmapRidingDirectionNode destination;

        @ia.b("origin")
        public BmapRidingDirectionNode origin;

        @ia.b("routes")
        public List<BmapRidingRoute> routes;

        public BmapRidingDirectionResult() {
        }
    }

    public static class BmapRidingLink {

        @ia.b("attr")
        public Integer attr;

        @ia.b("length")
        public Integer length;

        public BmapRidingLink() {
        }
    }

    public static class BmapRidingRoute {

        @ia.b(alternate = {"destination_location"}, value = "destinationLocation")
        public BmapTransitLocation destinationLocation;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b(alternate = {"origin_location"}, value = "originLocation")
        public BmapTransitLocation originLocation;

        @ia.b("restrictions_info")
        public String restrictionsInfo;

        @ia.b("restrictions_status")
        public Integer restrictionsStatus;

        @ia.b("steps")
        public List<BmapRidingStep> steps;

        public BmapRidingRoute() {
        }
    }

    public static class BmapRidingStep {

        @ia.b("area")
        public Integer area;

        @ia.b("direction")
        public Integer direction;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b(alternate = {"end_location"}, value = "stepDestinationLocation")
        public BmapTransitLocation endLocation;

        @ia.b(alternate = {"instruction"}, value = "instructions")
        public String instructions;

        @ia.b("leg_index")
        public Integer legIndex;

        @ia.b("links")
        public List<BmapRidingLink> links;

        @ia.b("name")
        public String name;

        @ia.b("path")
        public String path;

        @ia.b(StarCellDbManager.CellInfoEntry.POIS)
        public p pois;

        @ia.b("restrictions_info")
        public String restrictionsInfo;

        @ia.b("restrictions_status")
        public Integer restrictionsStatus;

        @ia.b(alternate = {"start_location"}, value = "stepOriginLocation")
        public BmapTransitLocation startLocation;

        @ia.b("stepDestinationInstruction")
        public String stepDestinationInstruction;

        @ia.b("stepOriginInstruction")
        public String stepOriginInstruction;

        @ia.b("turn_type")
        public String turnType;

        @ia.b("type")
        public Integer type;

        public BmapRidingStep() {
        }
    }

    public static class BmapTransitDirectionNode {

        @ia.b("city_id")
        public String cityId;

        @ia.b("city_name")
        public String cityName;

        @ia.b(LocationMonitorConst.LOCATION)
        public BmapTransitLocation location;

        public BmapTransitDirectionNode() {
        }
    }

    public static class BmapTransitDirectionRequest extends BmapBaseDirectionRequest {

        @ia.b("departure_date")
        public String departureDate;

        @ia.b("departure_time")
        public String departureTime;

        @ia.b("page_index")
        public int pageIndex;

        @ia.b("page_size")
        public int pageSize;

        @ia.b("tactics_incity")
        public int tacticsIncity;

        @ia.b("tactics_intercity")
        public int tacticsIntercity;

        @ia.b("trans_type_intercity")
        public int transTypeIntercity;

        public BmapTransitDirectionRequest(String r8, String r10) {
            super(r8, r10);
            this.departureDate = "";
            this.departureTime = "";
        }
    }

    public static class BmapTransitDirectionResponse extends BmapDirectionBaseResponse {

        @ia.b("result")
        public BmapTransitDirectionResult result;

        @ia.b("transit_type")
        public Integer transitType;

        public BmapTransitDirectionResponse() {
        }
    }

    public static class BmapTransitDirectionResult {

        @ia.b("destination")
        public BmapTransitDirectionNode destination;

        @ia.b("origin")
        public BmapTransitDirectionNode origin;

        @ia.b("routes")
        public List<BmapTransitRoute> routes;

        @ia.b("taxi")
        public BmapTransitTaxiInfo taxi;

        @ia.b(LBSLightLocationTraceLogger.TOTAL)
        public Integer total;

        public BmapTransitDirectionResult() {
        }
    }

    public static class BmapTransitLocation {

        @ia.b("lat")
        public double lat;

        @ia.b("lng")
        public double lng;

        public BmapTransitLocation() {
        }
    }

    public static class BmapTransitPriceDetail {

        @ia.b("ticket_price")
        public Double ticketPrice;

        @ia.b("ticket_type")
        public Integer ticketType;

        public BmapTransitPriceDetail() {
        }
    }

    public static class BmapTransitRoute {

        @ia.b("arrive_time")
        public String arriveTime;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("price")
        public Double price;

        @ia.b("price_detail")
        public List<BmapTransitPriceDetail> priceDetail;

        @ia.b("steps")
        public List<List<BmapTransitStep>> steps;

        public BmapTransitRoute() {
        }
    }

    public static class BmapTransitScheme {

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("end_location")
        public BmapTransitLocation endLocation;

        @ia.b("instructions")
        public String instructions;

        @ia.b("path")
        public String path;

        @ia.b("start_location")
        public BmapTransitLocation startLocation;

        @ia.b("vehicle_info")
        public BmapTransitVehicleInfo vehicleInfo;

        public BmapTransitScheme() {
        }
    }

    public static class BmapTransitStep {

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("end_location")
        public BmapTransitLocation endLocation;

        @ia.b(alternate = {"instruction"}, value = "instructions")
        public String instructions;

        @ia.b("path")
        public String path;

        @ia.b("schemes")
        public List<BmapTransitScheme> schemes;

        @ia.b("start_location")
        public BmapTransitLocation startLocation;

        @ia.b("traffic_condition")
        public p trafficCondition;

        @ia.b("vehicle_info")
        public BmapTransitVehicleInfo vehicleInfo;

        public BmapTransitStep() {
        }
    }

    public static class BmapTransitTaxiDetail {

        @ia.b("desc")
        public String desc;

        @ia.b("km_price")
        public Double kmPrice;

        @ia.b("start_price")
        public Double startPrice;

        @ia.b("total_price")
        public Double totalPrice;

        public BmapTransitTaxiDetail() {
        }
    }

    public static class BmapTransitTaxiInfo {

        @ia.b("detail")
        public List<BmapTransitTaxiDetail> detail;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b("remark")
        public String remark;

        public BmapTransitTaxiInfo() {
        }
    }

    public static class BmapTransitVehicleInfo {

        @ia.b("detail")
        public p detail;

        @ia.b("type")
        public Integer type;

        public BmapTransitVehicleInfo() {
        }
    }

    public static class BmapUnsupportedDirectionRequest extends BmapBaseDirectionRequest {
        public final int directionType;

        public BmapUnsupportedDirectionRequest(String r8, String r10, int r11) {
            super(r8, r10);
            this.directionType = r11;
        }
    }

    public static class BmapWalkingDirectionNode {

        @ia.b("area_id")
        public Integer areaId;

        @ia.b("cname")
        public String cityName;

        @ia.b(alternate = {"destinationPt", LocationMonitorConst.LOCATION}, value = "originPt")
        public BmapTransitLocation location;

        @ia.b("uid")
        public String uid;

        /* JADX INFO: renamed from: wd, reason: collision with root package name */
        @ia.b("wd")
        public String f5657wd;

        public BmapWalkingDirectionNode() {
        }
    }

    public static class BmapWalkingDirectionRequest extends BmapBaseDirectionRequest {
        public BmapWalkingDirectionRequest(String r8, String r10) {
            super(r8, r10);
        }
    }

    public static class BmapWalkingDirectionResponse extends BmapDirectionBaseResponse {

        @ia.b("result")
        public BmapWalkingDirectionResult result;

        public BmapWalkingDirectionResponse() {
        }
    }

    public static class BmapWalkingDirectionResult {

        @ia.b("destination")
        public BmapWalkingDirectionNode destination;

        @ia.b("origin")
        public BmapWalkingDirectionNode origin;

        @ia.b("routes")
        public List<BmapWalkingRoute> routes;

        public BmapWalkingDirectionResult() {
        }
    }

    public static class BmapWalkingRoute {

        @ia.b(alternate = {"destination_location"}, value = "destinationLocation")
        public BmapTransitLocation destinationLocation;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b(alternate = {"origin_location"}, value = "originLocation")
        public BmapTransitLocation originLocation;

        @ia.b("steps")
        public List<BmapWalkingStep> steps;

        public BmapWalkingRoute() {
        }
    }

    public static class BmapWalkingStep {

        @ia.b("area")
        public Integer area;

        @ia.b("direction")
        public Integer direction;

        @ia.b("distance")
        public Integer distance;

        @ia.b("duration")
        public Integer duration;

        @ia.b(alternate = {"end_location"}, value = "stepDestinationLocation")
        public BmapTransitLocation endLocation;

        @ia.b(alternate = {"instruction"}, value = "instructions")
        public String instructions;

        @ia.b("leg_index")
        public Integer legIndex;

        @ia.b("name")
        public String name;

        @ia.b("path")
        public String path;

        @ia.b(StarCellDbManager.CellInfoEntry.POIS)
        public p pois;

        @ia.b(alternate = {"start_location"}, value = "stepOriginLocation")
        public BmapTransitLocation startLocation;

        @ia.b("stepDestinationInstruction")
        public String stepDestinationInstruction;

        @ia.b("stepOriginInstruction")
        public String stepOriginInstruction;

        @ia.b("turn_type_id")
        public Integer turnTypeId;

        @ia.b("type")
        public Integer type;

        public BmapWalkingStep() {
        }
    }

    public final class CellAoiBoardAccumulator {
        private final AoiBoard aoiBoard;
        private final List<String> cells;
        final /* synthetic */ BdLocationManager this$0;
        private final String typeCode;

        private CellAoiBoardAccumulator(BdLocationManager r8, AoiBoard r10, String r11) {
            this.this$0 = r8;
            this.cells = new ArrayList();
            this.aoiBoard = r10;
            if (r11 != null) goto L5;
            r11 = "";
        L5:
            this.typeCode = r11;
        }

        public static /* synthetic */ void access$1000(CellAoiBoardAccumulator r8, String r10) {
            r8.addCell(r10);
        }

        public static /* synthetic */ AoiBoard access$1100(CellAoiBoardAccumulator r8) {
            return r8.aoiBoard;
        }

        public static /* synthetic */ String access$1200(CellAoiBoardAccumulator r8) {
            return r8.getCells();
        }

        public static /* synthetic */ String access$1300(CellAoiBoardAccumulator r8) {
            return r8.typeCode;
        }

        private void addCell(String r8) {
            if (this.cells.contains(r8) == true) goto L6;
            this.cells.add(r8);
            return;
        }

        private String getCells() {
            return TextUtils.join(";", this.cells);
        }

        public /* synthetic */ CellAoiBoardAccumulator(BdLocationManager r8, AoiBoard r10, String r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }
    }

    public static final class CellsAreaParseResult {
        private final List<StarLocationDbManager.CellAoiBoardEntry> aoiBoardEntries;
        private final List<StarCellDbManager.InnerCellInfoEntry> cellEntries;
        private final List<StarCellManager.StarCellInfo> profileCellInfos;

        private CellsAreaParseResult(List<StarCellDbManager.InnerCellInfoEntry> r8, List<StarLocationDbManager.CellAoiBoardEntry> r10, List<StarCellManager.StarCellInfo> r11) {
            this.cellEntries = r8;
            this.aoiBoardEntries = r10;
            this.profileCellInfos = r11;
        }

        public static /* synthetic */ List access$500(CellsAreaParseResult r8) {
            return r8.profileCellInfos;
        }

        public static /* synthetic */ List access$600(CellsAreaParseResult r8) {
            return r8.cellEntries;
        }

        public static /* synthetic */ List access$700(CellsAreaParseResult r8) {
            return r8.aoiBoardEntries;
        }

        public /* synthetic */ CellsAreaParseResult(List r8, List r10, List r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }
    }

    public static class CommonLocationTextSearchResponseData {

        @ia.b("poi_list")
        public List<CommonPOIInfo> poiList;

        @ia.b(LBSLightLocationTraceLogger.TOTAL)
        public Long total;

        public CommonLocationTextSearchResponseData() {
        }
    }

    public static class CommonPOIInfo {

        @ia.b(StarLocationDbManager.GeofenceEntry.ADDRESS)
        public String address;

        @ia.b(alternate = {"aoiBorder"}, value = "aoi_border")
        public String aoiBorder;

        @ia.b("country_code")
        public String countryCode;

        @ia.b("extra_infos")
        public Map<String, String> extraInfos;

        @ia.b("latitude")
        public String latitude;

        @ia.b("lbs_city")
        public String lbsCity;

        @ia.b("lbs_district")
        public String lbsDistrict;

        @ia.b("lbs_province")
        public String lbsProvince;

        @ia.b("lbs_town")
        public String lbsTown;

        @ia.b("location_id")
        public String locationId;

        @ia.b(StarCellDbManager.CellInfoEntry.LONGITUDE)
        public String longitude;

        @ia.b("name")
        public String name;

        public CommonPOIInfo() {
        }
    }

    public static class CommsenseTextSearchResponse {

        @ia.b("code")
        public Integer code;

        @ia.b("data")
        public CommonLocationTextSearchResponseData data;

        @ia.b("encrypt_data")
        public String encryptData;

        @ia.b("log_id")
        public String logId;

        @ia.b("msg")
        public String msg;

        public CommsenseTextSearchResponse() {
        }

        public String toString() {
            return BdLocationManager.access$100().j(this);
        }
    }

    public static class LatLng {
        public double latitude;
        public double longitude;

        public LatLng(double r8, double r10) {
            this.latitude = r8;
            this.longitude = r10;
        }
    }

    public static class MapPoiInfo {
        public final String address;
        public final String aoiBoard;
        public final String city;
        public final String district;
        public final String name;
        public final String poiId;
        public final String province;
        public final String typeCode;
        public final String typeName;
        public final double wgs84Latitude;
        public final double wgs84Longitude;

        public MapPoiInfo(String r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, double r18, double r19) {
            this.poiId = r8;
            this.name = r10;
            this.province = r11;
            this.city = r12;
            this.district = r13;
            this.address = r14;
            this.typeCode = r15;
            this.typeName = r16;
            this.aoiBoard = r17;
            this.wgs84Latitude = r18;
            this.wgs84Longitude = r19;
        }
    }

    public static class MapPoiTextSearchResult {
        public final Integer code;
        public final List<MapPoiInfo> items;
        public final String msg;
        public final boolean success;

        public MapPoiTextSearchResult(boolean r8, List<MapPoiInfo> r10, Integer r11, String r12) {
            this.success = r8;
            this.items = r10;
            this.code = r11;
            this.msg = r12;
        }
    }

    public static class PoiFenceInfo {
        public final String aoiBoard;
        public final String fenceId;
        public final String poiId;
        public final String poiName;

        public PoiFenceInfo(String r8, String r10, String r11, String r12) {
            this.poiId = r8;
            this.poiName = r10;
            this.fenceId = r11;
            this.aoiBoard = r12;
        }
    }

    public static final class PoiHttpPostResult {
        private final String rawResponseBody;
        private final String responseBody;
        private final int statusCode;
        private final String xTtLogId;

        private PoiHttpPostResult(String r8, String r10, int r11) {
            this.responseBody = r8;
            this.rawResponseBody = r8;
            this.xTtLogId = r10;
            this.statusCode = r11;
        }

        public static /* synthetic */ String access$1400(PoiHttpPostResult r8) {
            return r8.rawResponseBody;
        }

        public static /* synthetic */ String access$200(PoiHttpPostResult r8) {
            return r8.responseBody;
        }

        public static /* synthetic */ String access$300(PoiHttpPostResult r8) {
            return r8.xTtLogId;
        }

        public static /* synthetic */ int access$400(PoiHttpPostResult r8) {
            return r8.statusCode;
        }

        public /* synthetic */ PoiHttpPostResult(String r8, String r10, int r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }

        private PoiHttpPostResult(String r8, String r10, String r11, int r12) {
            this.responseBody = r8;
            this.rawResponseBody = r10;
            this.xTtLogId = r11;
            this.statusCode = r12;
        }

        public /* synthetic */ PoiHttpPostResult(String r8, String r10, String r11, int r12, AnonymousClass1 r13) {
            this(r8, r10, r11, r12);
        }
    }

    public static class PoiTextSearchResult {
        public final Integer code;
        public final Map<String, List<CommonPOIInfo>> items;
        public final String msg;

        public PoiTextSearchResult(Map<String, List<CommonPOIInfo>> r8, Integer r10, String r11) {
            this.items = r8;
            this.code = r10;
            this.msg = r11;
        }
    }

    static {
        SINGLETON = new BdLocationManager();
        TimeUnit r8 = TimeUnit.SECONDS;
        LOCATION_TIMEOUT = r8.toMillis(15);
        LOCATION_CACHE_VALID_WINDOW_MS = TimeUnit.MINUTES.toMillis(10);
        POI_HTTP_CONNECT_TIMEOUT_MS = (int) r8.toMillis(5);
        POI_HTTP_TIMEOUT_MS = (int) r8.toMillis(15);
        sPoiExecutor = Executors.newFixedThreadPool(8);
        k r10 = new k();
        r10.f7996k = true;
        sGson = r10.a();
        k r11 = new k();
        r11.f7995j = true;
        sGsonPretty = r11.a();
        sSyncLock = new Object();
    }

    private BdLocationManager() {
        this.inited = false;
    }

    public static /* synthetic */ BmapTransitDirectionResponse a(BdLocationManager r8, BmapTransitDirectionRequest r10) {
        return r8.lambda$searchTransitDirectionFromBmap$0(r10);
    }

    public static /* synthetic */ SsResponse access$000(BdLocationManager r8, String r10, Map r11, Map r12, List r13) {
        return r8.doHttpPostForm(r10, r11, r12, r13);
    }

    public static /* synthetic */ j access$100() {
        return sGsonPretty;
    }

    private void applyCommonDirectionExtraInfos(BmapBaseDirectionRequest r8, Map<String, String> r10) {
        r8.originUid = getExtraValue(r10, "origin_uid");
        r8.destinationUid = getExtraValue(r10, "destination_uid");
        r8.output = getExtraValue(r10, QesdkUtils.TAGS.TAG_OUTPUT);
        r8.sn = getExtraValue(r10, "sn");
        r8.callback = getExtraValue(r10, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        r8.timestamp = parseLongExtra(r10, "timestamp", 0);
    }

    private void applyDrivingDirectionExtraInfos(BmapDrivingDirectionRequest r8, Map r10) {
        Map<String, String> r11 = toStringMap(r10);
        applyCommonDirectionExtraInfos(r8, r11);
        r8.tactics = parseIntExtra(r11, "tactics", 0);
        r8.alternatives = parseIntExtra(r11, "alternatives", 0);
        r8.roadTraffic = parseIntExtra(r11, "road_traffic", 0);
        r8.waypoints = getExtraValue(r11, "waypoints");
        r8.avoidRoad = getExtraValue(r11, "avoidroad");
        r8.avoidPolygons = getExtraValue(r11, "avoidpolygons");
        r8.plateNumber = getExtraValue(r11, "plate_number");
        r8.restriction = getExtraValue(r11, "restriction");
    }

    private void applyRidingDirectionExtraInfos(BmapRidingDirectionRequest r8, Map r10) {
        Map<String, String> r11 = toStringMap(r10);
        applyCommonDirectionExtraInfos(r8, r11);
        r8.ridingType = getExtraValue(r11, "riding_type");
        r8.roadPrefer = parseIntExtra(r11, "road_prefer", 0);
    }

    private void applyTransitDirectionExtraInfos(BmapTransitDirectionRequest r8, Map r10) {
        Map<String, String> r11 = toStringMap(r10);
        applyCommonDirectionExtraInfos(r8, r11);
        r8.departureDate = getExtraValue(r11, "departure_date");
        r8.departureTime = getExtraValue(r11, "departure_time");
        r8.tacticsIncity = parseIntExtra(r11, "tactics_incity", 0);
        r8.tacticsIntercity = parseIntExtra(r11, "tactics_intercity", 0);
        r8.transTypeIntercity = parseIntExtra(r11, "trans_type_intercity", 0);
        r8.pageSize = parseIntExtra(r11, "page_size", 0);
        r8.pageIndex = parseIntExtra(r11, "page_index", 0);
    }

    private void applyWalkingDirectionExtraInfos(BmapWalkingDirectionRequest r8, Map r10) {
        applyCommonDirectionExtraInfos(r8, toStringMap(r10));
    }

    public static /* synthetic */ PoiTextSearchResult b(BdLocationManager r8, String r10, int r11, int r12, String r13, String r14) {
        return r8.lambda$performBdPoiTextSearch$9(r10, r11, r12, r13, r14);
    }

    private String buildAoiBoardFromFence(s r8) {
        String r10 = buildAoiBoardFromNestedCoordinateArray(getValueByKeyCompat(r8, "multi_polygon"));
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        String r11 = buildAoiBoardFromNestedCoordinateArray(getValueByKeyCompat(r8, "polygons"));
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return buildAoiBoardFromPointArray(getValueByKeyCompat(r8, "vertices"));
    }

    private String buildAoiBoardFromLngLatCoordinateArray(p r8) {
        m r10 = findFirstLngLatPointArray(r8);
        if (r10 != null) goto L6;
        return "";
    L6:
        StringBuilder r11 = new StringBuilder();
        Iterator<p> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        String r13 = buildConvertedLngLatAoiPoint(r12.next());
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r11.append(r13);
        r11.append(';');
        goto L8
    L14:
        if (r11.length() <= 0) goto L19;
        if (r11.charAt(r11.length() - 1) != ';') goto L19;
        r11.deleteCharAt(r11.length() - 1);
    L19:
        return r11.toString();
    }

    private String buildAoiBoardFromMapPoiGeoJson(s r8) {
        return buildAoiBoardFromLngLatCoordinateArray(getValueByKeyCompat(r8, "polygon_coord"));
    }

    private String buildAoiBoardFromNestedCoordinateArray(p r8) {
        return buildAoiBoardFromPointArray(findFirstPointArray(r8));
    }

    private String buildAoiBoardFromPointArray(p r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if ((r8 instanceof m) == false) goto L27;
        StringBuilder r10 = new StringBuilder();
        Iterator<p> r11 = r8.e().iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        String r12 = buildConvertedAoiPoint(r11.next());
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r10.append(r12);
        r10.append(';');
        goto L8
    L14:
        if (r10.length() <= 0) goto L19;
        if (r10.charAt(r10.length() - 1) != ';') goto L19;
        r10.deleteCharAt(r10.length() - 1);
    L19:
        return r10.toString();
    L27:
        return "";
    }

    private List<AoiBoard> buildAoiBoardsForCellProfile(StarAoiBoardManager r8, List<StarLocationDbManager.CellAoiBoardEntry> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<StarLocationDbManager.CellAoiBoardEntry> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L14;
        StarLocationDbManager.CellAoiBoardEntry r14 = r12.next();
        if (r14 == null) goto L4;
        if (r14.getAoiBoard() == null) goto L4;
        if (shouldSkipExistingMallAoiBoard(r8, r14) == true) goto L12;
        r11.add(r14.getAoiBoard());
        goto L4
    L12:
        r13 = r13 + 1;
        goto L4
    L14:
        if (r13 <= 0) goto L16;
        StringBuilder r15 = defpackage.b.f("CELL_GEO_PROFILE skip existing mall aoi boards, count=", r13, ", input count=");
        r15.append(r10.size());
        CommSenseLog.dWithMethodName(TAG, r15.toString());
    L16:
        return r11;
    }

    private String buildAoiIdListString(p r8) {
        m r10 = resolveJsonArray(r8);
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.isEmpty() == true) goto L40;
        StringBuilder r11 = new StringBuilder();
        Iterator<p> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L26;
        p r13 = r12.next();
        if (r13 == null) goto L9;
        if ((r13 instanceof s) == false) goto L9;
        s r14 = r13.f();
        if (StarCellManager.isInterestedNewTypeCode(getAoiTypeCode(r14)) == false) goto L9;
        String r15 = getStringByKeys(r14, new String[]{IStarPoiCallback.AOI_ID, "aoiId", "poi_id", "poiId"});
        if (TextUtils.isEmpty(r15) == true) goto L9;
        if (r11.length() <= 0) goto L24;
        r11.append(';');
    L24:
        r11.append(r15);
        goto L9
    L26:
        return r11.toString();
    L40:
        return "";
    }

    private s buildBaseDirectionRequestBody(BmapBaseDirectionRequest r8) {
        s r10 = new s();
        r10.n("origin", r8.origin);
        r10.n("destination", r8.destination);
        r10.n("origin_uid", safeString(r8.originUid));
        r10.n("destination_uid", safeString(r8.destinationUid));
        r10.n("coord_type", safeString(r8.coordType));
        r10.n("ret_coordtype", safeString(r8.retCoordtype));
        r10.n(QesdkUtils.TAGS.TAG_OUTPUT, safeString(r8.output));
        r10.n("sn", safeString(r8.sn));
        r10.m("timestamp", Long.valueOf(Math.max(r8.timestamp, 0)));
        r10.n(QesdkUtils.TAGS.JSON_TAG_CALLBACK, safeString(r8.callback));
        return r10;
    }

    private AoiBoard buildCellAoiBoard(String r8, s r10, String r11) {
        AoiBoard r12 = new AoiBoard();
        r12.setPoiId(r8);
        String r13 = safeString(getStringByKeys(r10, new String[]{"name", "Name", "poi_name", "poiName", "aoi_name", "aoiName"}));
        if (TextUtils.isEmpty(r13) == true) goto L6;
        r8 = r13;
    L6:
        r12.setPoiName(r8);
        r12.setAoiBoard(parseAndConvertAoiBoardGeometry(getValueByKeyCompat(r10, "geometry")));
        if (StarCellManager.isMallNewTypeCodeL3(r11) == false) goto L9;
        AoiBoard.Type r14 = AoiBoard.Type.MALL;
    L10:
        r12.setType(r14);
        return r12;
    L9:
        r14 = AoiBoard.Type.UNKNOWN;
        goto L10
    }

    private List<StarLocationDbManager.CellAoiBoardEntry> buildCellAoiBoardEntries(Map<String, CellAoiBoardAccumulator> r8) {
        ArrayList r10 = new ArrayList();
        Iterator<CellAoiBoardAccumulator> r11 = r8.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        CellAoiBoardAccumulator r12 = r11.next();
        if (r12 == null) goto L4;
        if (CellAoiBoardAccumulator.access$1100(r12) == null) goto L4;
        r10.add(new StarLocationDbManager.CellAoiBoardEntry(CellAoiBoardAccumulator.access$1100(r12), CellAoiBoardAccumulator.access$1200(r12), CellAoiBoardAccumulator.access$1300(r12)));
        goto L4
    L11:
        return r10;
    }

    private s buildCellsAreaRequestBody(List<StarCellManager.StarCellInfo> r8) {
        s r10 = new s();
        m r11 = new m();
        Iterator<StarCellManager.StarCellInfo> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        StarCellManager.StarCellInfo r13 = r12.next();
        if (r13 == null) goto L4;
        r11.m(r13.toCellString());
        goto L4
    L8:
        m r14 = new m();
        s r15 = new s();
        r15.n("name", CELL_GEO_PROFILE_NAME);
        r15.n("version", "v1");
        r15.m("privacy", 0);
        r14.k(r15);
        r10.k("ids", r11);
        r10.m("id_type", 7);
        r10.k("profiles", r14);
        return r10;
    }

    private String buildConvertedAoiPoint(p r8) {
        if (r8 != null) goto L5;
    L19:
        return "";
    L5:
        if ((r8 instanceof r) == true) goto L19;
        if ((r8 instanceof s) == true) goto L10;
        return "";
    L10:
        s r10 = r8.f();
        Double r11 = getFencePointLongitude(r10);
        Double r12 = getFencePointLatitude(r10);
        if (r11 == null) goto L19;
        if (r12 == null) goto L19;
        Location r13 = convertGcj02ToWgs84(r12.doubleValue(), r11.doubleValue());
        if (r13 != null) goto L18;
        return "";
    L18:
        return r13.getLongitude() + "," + r13.getLatitude();
    }

    private String buildConvertedLngLatAoiPoint(p r8) {
        if (isLngLatPoint(r8) == true) goto L5;
        return "";
    L5:
        m r10 = r8.e();
        Location r11 = convertGcj02ToWgs84(r10.o(1).c(), r10.o(0).c());     // Catch: Exception -> L11
        if (r11 != null) goto L9;
        return "";
    L9:
        return r11.getLongitude() + "," + r11.getLatitude();
    L11:
        return "";
    }

    private StarPoiDbManager.PoiData buildDirectPoiData(s r10) {
        StarPoiDbManager.PoiData r8 = new StarPoiDbManager.PoiData(getStringByKeys(r10, new String[]{"new_type_name_l1", "NewTypeNameL1", "newTypeNameL1"}), getStringByKeys(r10, new String[]{"new_type_name_l2", "NewTypeNameL2", "newTypeNameL2"}), getStringByKeys(r10, new String[]{"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"}), getStringByKeys(r10, new String[]{"new_type_code_l1", "NewTypeCodeL1", "newTypeCodeL1"}), getStringByKeys(r10, new String[]{"new_type_code_l2", "NewTypeCodeL2", "newTypeCodeL2"}), getStringByKeys(r10, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3"}));
        if (r8.isValid() == true) goto L7;
        return null;
    L7:
        return r8;
    }

    private BmapBaseDirectionRequest buildDirectionRequestByType(String r8, String r10, Map r11, int r12) {
        if (r12 != 1) goto L5;
        BmapTransitDirectionRequest r13 = new BmapTransitDirectionRequest(r8, r10);
        applyTransitDirectionExtraInfos(r13, r11);
        return r13;
    L5:
        if (r12 != 2) goto L7;
        BmapDrivingDirectionRequest r14 = new BmapDrivingDirectionRequest(r8, r10);
        applyDrivingDirectionExtraInfos(r14, r11);
        return r14;
    L7:
        if (r12 != 3) goto L9;
        BmapWalkingDirectionRequest r15 = new BmapWalkingDirectionRequest(r8, r10);
        applyWalkingDirectionExtraInfos(r15, r11);
        return r15;
    L9:
        if (r12 == 4) goto L12;
        CommSenseLog.wWithMethodName(TAG, "unsupported directionType=" + r12 + ", build unsupported request");
        return new BmapUnsupportedDirectionRequest(r8, r10, r12);
    L12:
        BmapRidingDirectionRequest r16 = new BmapRidingDirectionRequest(r8, r10);
        applyRidingDirectionExtraInfos(r16, r11);
        return r16;
    }

    private s buildDrivingDirectionRequestBody(BmapDrivingDirectionRequest r8) {
        s r10 = buildBaseDirectionRequestBody(r8);
        r10.m("tactics", Integer.valueOf(Math.max(r8.tactics, 0)));
        r10.m("alternatives", Integer.valueOf(Math.max(r8.alternatives, 1)));
        r10.m("road_traffic", Integer.valueOf(Math.max(r8.roadTraffic, 0)));
        r10.n("waypoints", safeString(r8.waypoints));
        r10.n("avoidroad", safeString(r8.avoidRoad));
        r10.n("avoidpolygons", safeString(r8.avoidPolygons));
        r10.n("plate_number", safeString(r8.plateNumber));
        r10.n("restriction", safeString(r8.restriction));
        return r10;
    }

    private s buildEncryptedRequestBody(s r8, String r10) {
        s r11 = new s();
        String r12 = r8.toString();
        byte[] r13 = r12.getBytes("UTF-8");     // Catch: Throwable -> L9
        if (LocationUtil.getInstance().ensureCloudTransCryptoManagerReady() == true) goto L7;
        CommSenseLog.wWithMethodName(TAG, r10 + ": Crypto SDK not ready");     // Catch: Throwable -> L9
        r11.n("encrypt_data", r12);     // Catch: Throwable -> L9
        return r11;
    L7:
        r11.n("encrypt_data", Base64.encodeToString(n6.b.e().b(r13), 2));     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, r10 + ": Encrypt failed", th);
        r11.n("encrypt_data", r12);
        return r11;
    }

    private s buildGetFencesRequestBody(List<String> r8) {
        s r10 = new s();
        m r11 = new m();
        Iterator<String> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.m(r12.next());
        goto L4
    L6:
        r10.k("fence_id_list", r11);
        Boolean r13 = Boolean.TRUE;
        r10.l("with_border_info", r13);
        r10.l("secondary_preferred", r13);
        r10.n("order_by", "");
        Boolean r14 = Boolean.FALSE;
        r10.l("is_desc", r14);
        r10.m("page_num", 0);
        r10.m("page_size", Integer.valueOf(Math.max(r8.size(), 1)));
        r10.l("with_total", r14);
        r10.l("secondary_preferred", r14);
        return r10;
    }

    private s buildMapPoiTextSearchRequestBody(String r8, int r10, int r11, String r12, String r13) {
        s r14 = new s();
        r14.n("index", TEXT_SEARCH_MAP_POI_INDEX);
        r14.n("keyword", safeString(r8));
        s r15 = new s();
        if (r10 > 0) goto L6;
        r10 = 1;
    L6:
        r15.m("num", Integer.valueOf(r10));
        if (r11 > 0) goto L10;
        r11 = 20;
    L10:
        r15.m(BwdlDropConstant.FILE_SIZE, Integer.valueOf(r11));
        r14.k("page", r15);
        s r16 = new s();
        r16.n("show_fields", "geometry");
        r16.n("region_limit", "true");
        String r17 = normalizeMapPoiRegion(r12);
        if (TextUtils.isEmpty(r17) == true) goto L13;
        r16.n("region", r17);
    L13:
        r14.k(WsConstants.KEY_EXTRA, r16);
        if (TextUtils.isEmpty(r13) == true) goto L16;
        r14.n("dsl", r13);
    L16:
        s r18 = new s();
        r18.n("env", "prod");
        s r19 = new s();
        r19.k("Extra", r18);
        r14.k("Base", r19);
        return r14;
    }

    private s buildNormalizedPoiSearchData(p r8) {
        p r10 = extractPoiListElement(r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof m) == false) goto L11;
        s r11 = new s();
        r11.k("poi_list", r10);
        r11.k("poiList", r10);
        return r11;
    L11:
        return null;
    }

    private String buildPoiApiUrl(String r8) {
        if (r8.startsWith("/") == true) goto L7;
        return "https://os.obriccloud.com/".concat(r8);
    L7:
        return defpackage.b.c("https://os.obriccloud.com", r8);
    }

    private Map<String, String> buildPoiRequestHeaders(String r8) {
        String r10 = getPrivacyIdAttestationCertSafely();
        String r11 = null;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        CommSenseLog.eWithMethodName(TAG, "attestation certChain is empty");
        return null;
    L6:
        HashMap r12 = new HashMap();
        if (TextUtils.isEmpty(r8) == true) goto L9;
        r12.put(X_TT_ENV_HEADER, r8);
        r12.put(X_USE_PPE_HEADER, "1");
    L9:
        r12.put(X_ATT_CERT_CHAIN_HEADER, r10);
        r12.put(X_ATT_APP_ID_HEADER, POI_ENCRYPT_APP_ID);
        r12.put(X_ENCRYPT_APP_ID_HEADER, POI_ENCRYPT_APP_ID);
        if (this.appContext == null) goto L13;
        r11 = MatrixDidUtils.getDid(this.appContext);
    L13:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        r12.put(X_ENCRYPT_DID_HEADER, r11);
    L16:
        return r12;
    L15:
        CommSenseLog.wWithMethodName(TAG, "skip x-encrypt-did header because did is empty");
        goto L16
    }

    private s buildPoiSearchPayload(String r8, int r10, int r11, String r12, String r13) {
        s r14 = new s();
        if (r8 != null) goto L6;
        r8 = "";
    L6:
        r14.n("keyword", r8);
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r14.n("index", r12);
    L9:
        if (r10 > 0) goto L11;
        if (r11 > 0) goto L11;
    L21:
        if (TextUtils.isEmpty(r13) == true) goto L23;
        r14.n("dsl", r13);
    L23:
        return r14;
    L11:
        s r15 = new s();
        if (r10 > 0) goto L15;
        r10 = 1;
    L15:
        r15.m("num", Integer.valueOf(r10));
        if (r11 > 0) goto L19;
        r11 = 15;
    L19:
        r15.m(BwdlDropConstant.FILE_SIZE, Integer.valueOf(r11));
        r14.k("page", r15);
        goto L21
    }

    private s buildRidingDirectionRequestBody(BmapRidingDirectionRequest r8) {
        s r10 = buildBaseDirectionRequestBody(r8);
        r10.n("riding_type", safeString(r8.ridingType));
        r10.m("road_prefer", Integer.valueOf(Math.max(r8.roadPrefer, 0)));
        return r10;
    }

    private s buildTransitDirectionRequestBody(BmapTransitDirectionRequest r8) {
        s r10 = buildBaseDirectionRequestBody(r8);
        r10.n("departure_date", safeString(r8.departureDate));
        r10.n("departure_time", safeString(r8.departureTime));
        r10.m("tactics_incity", Integer.valueOf(Math.max(r8.tacticsIncity, 0)));
        r10.m("tactics_intercity", Integer.valueOf(Math.max(r8.tacticsIntercity, 0)));
        r10.m("trans_type_intercity", Integer.valueOf(Math.max(r8.transTypeIntercity, 0)));
        r10.m("page_size", Integer.valueOf(Math.max(r8.pageSize, 0)));
        r10.m("page_index", Integer.valueOf(Math.max(r8.pageIndex, 0)));
        return r10;
    }

    private s buildWalkingDirectionRequestBody(BmapWalkingDirectionRequest r8) {
        return buildBaseDirectionRequestBody(r8);
    }

    public static /* synthetic */ Boolean c(BdLocationManager r8, List r10) {
        return r8.lambda$queryCellsArea$4(r10);
    }

    private void collectCellAoiBoards(Map<String, CellAoiBoardAccumulator> r8, String r10, p r11) {
        m r12 = resolveJsonArray(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isEmpty() == true) goto L37;
        Iterator<p> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L38;
        p r14 = r13.next();
        if (r14 == null) goto L9;
        if ((r14 instanceof s) == false) goto L9;
        s r15 = r14.f();
        String r16 = getAoiTypeCode(r15);
        if (StarCellManager.isInterestedNewTypeCode(r16) == false) goto L9;
        String r17 = getStringByKeys(r15, new String[]{IStarPoiCallback.AOI_ID, "aoiId", "poi_id", "poiId"});
        if (TextUtils.isEmpty(r17) == true) goto L9;
        CellAoiBoardAccumulator r18 = r8.get(r17);
        if (r18 != null) goto L24;
        r18 = new CellAoiBoardAccumulator(this, buildCellAoiBoard(r17, r15, r16), r16, null);
        r8.put(r17, r18);
    L24:
        CellAoiBoardAccumulator.access$1000(r18, r10);
        goto L9
    L38:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void collectPoiTypeDatas(p r25, String[] r26, String[] r27, LinkedHashMap<String, StarPoiDbManager.PoiData> r28, int r29) {
        if (r25 != null) goto L5;
        return;
    L5:
        if ((r25 instanceof r) == false) goto L7;
        return;
    L7:
        if (r29 <= 10) goto L10;
        return;
    L10:
        if ((r25 instanceof m) == false) goto L17;
        Iterator<p> r10 = r25.e().iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        collectPoiTypeDatas(r10.next(), r26, r27, r28, r29 + 1);
        goto L13
    L15:
        return;
    L17:
        if ((r25 instanceof s) == true) goto L19;
        return;
    L19:
        s r11 = r25.f();
        StarPoiDbManager.PoiData r8 = buildDirectPoiData(r11);
        if (r8 == null) goto L22;
        putPoiData(r28, r8);
    L22:
        String r12 = getStringByKeys(r11, new String[]{"type_name", "TypeName", "typeName", "name", "Name", "new_type_name", "NewTypeName"});
        String r13 = getStringByKeys(r11, new String[]{"type_code", "TypeCode", "typeCode", "Code", "new_type_code", "NewTypeCode"});
        String[] r14 = (String[]) r26.clone();
        String[] r15 = (String[]) r27.clone();
        int r16 = resolveNextLevel(r14, r15, r11);
        if (TextUtils.isEmpty(r12) == false) goto L27;
        if (TextUtils.isEmpty(r13) == false) goto L27;
    L29:
        ja.s.b.a r17 = new ja.s.b.a(r11.o());
        boolean r18 = false;
    L31:
        if (r17.hasNext() == false) goto L40;
        ja.s.e<K, V> r19 = r17.a();
        if (isPoiTypeChildKey((String) r19.f8804p) == false) goto L31;
        V r20 = r19.f8806r;
        if (r20 == 0) goto L31;
        p r21 = (p) r20;
        r21.getClass();
        if ((r21 instanceof m) == false) goto L31;
        collectPoiTypeDatas((p) r19.f8806r, r14, r15, r28, r29 + 1);
        r18 = true;
        goto L31
    L40:
        if (r18 == false) goto L42;
    L46:
        ja.s.b.a r110 = new ja.s.b.a(r11.o());
    L48:
        if (r110.hasNext() == false) goto L84;
        ja.s.e<K, V> r22 = r110.a();
        K r23 = r22.f8804p;
        if (isPoiTypeChildKey((String) r23) == true) goto L48;
        String r24 = (String) r23;
        if ("data".equalsIgnoreCase(r24) == true) goto L60;
        if ("result".equalsIgnoreCase(r24) == true) goto L60;
        if ("list".equalsIgnoreCase(r24) == true) goto L60;
        if ("items".equalsIgnoreCase(r24) == false) goto L48;
    L60:
        collectPoiTypeDatas((p) r22.f8806r, r26, r27, r28, r29 + 1);
        goto L48
    L84:
        return;
    L42:
        if (TextUtils.isEmpty(r12) == true) goto L44;
    L45:
        putPoiData(r28, new StarPoiDbManager.PoiData(r14[0], r14[1], r14[2], r15[0], r15[1], r15[2]));
        goto L46
    L44:
        if (TextUtils.isEmpty(r13) == true) goto L46;
    L27:
        if (r16 >= 3) goto L29;
        r14[r16] = safeString(r12);
        r15[r16] = safeString(r13);
        goto L29
    }

    private Location convertGcj02ToWgs84(double r8, double r10) {
        Location r11 = new Location("");
        r11.setLatitude(r8);
        r11.setLongitude(r10);
        return CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r11);
    }

    private BDLocationClient createClient(Context r8, boolean r10) {
        BDLocationClient r11 = new BDLocationClient(r8);
        BDLocationClientOption r12 = new BDLocationClientOption();
        BDLocationClientOption r13 = r12.setCert(true).setUploadSource("CommSense").setLocationTimeOut(LOCATION_TIMEOUT);
        if (r10 == false) goto L5;
        long r14 = 0;
    L6:
        r13.setMaxCacheTime(r14).setLocateType(1).setAccuracyLevel(4).setTriggerType(0).setLocationMode(2).setLatestAdminVersion(true).setUpload(true);
        r11.setClientOption(r12);
        return r11;
    L5:
        r14 = LOCATION_CACHE_VALID_WINDOW_MS;
        goto L6
    }

    private StarCellDbManager.InnerCellInfoEntry createEmptyCellInfoEntry(StarCellManager.StarCellInfo r10) {
        return new StarCellDbManager.InnerCellInfoEntry(r10.getType(), r10.getMcc(), r10.getMnc(), r10.getLac(), r10.getCid());
    }

    public static /* synthetic */ BmapRidingDirectionResponse d(BdLocationManager r8, BmapRidingDirectionRequest r10) {
        return r8.lambda$searchRidingDirectionFromBmap$3(r10);
    }

    private String decryptEncryptedString(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == false) goto L18;
        return null;
    L18:
        byte[] r11 = Base64.decode(r8, 0);     // Catch: Throwable -> L15
        if (LocationUtil.getInstance().ensureCloudTransCryptoManagerReady() == true) goto L11;
        CommSenseLog.wWithMethodName(TAG, r10 + ": Crypto SDK not ready");     // Catch: Throwable -> L15
        return r8;
    L11:
        byte[] r12 = n6.b.e().a(r11);     // Catch: Throwable -> L15
        if (r12 != null) goto L14;
    L17:
        return r8;
    L14:
        return new String(r12, "UTF-8");
    L15:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, r10 + ": Decrypt failed", th);
        goto L17
    }

    private String describeBundle(Bundle r8) {
        StringBuilder r10 = new StringBuilder("{");
        Iterator<String> r11 = r8.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L9;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append("=");
        r10.append(r8.get(r13));
        r12 = false;
        goto L4
    L9:
        r10.append("}");
        return r10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String describeJsonObjectKeys(s r8) {
        StringBuilder r10 = new StringBuilder("[");
        ja.s.b.a r11 = new ja.s.b.a(r8.o());
        boolean r12 = true;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L11;
        ja.s.e<K, V> r14 = r11.a();
        if (r13 >= 12) goto L7;
        if (r12 == true) goto L10;
        r10.append(", ");
    L10:
        r10.append((String) r14.f8804p);
        r13 = r13 + 1;
        r12 = false;
        goto L4
    L7:
        r10.append(", ...");
    L11:
        r10.append("]");
        return r10.toString();
    }

    private PoiHttpPostResult doHttpPost(String r8, String r10, Map<String, String> r11) {
        PoiHttpPostResult r12 = doHttpPostOnce(r8, r10, r11);
        if (r12 != null) goto L5;
    L13:
        return r12;
    L5:
        if (isPrivacyIdAttestationCertExpired(PoiHttpPostResult.access$1400(r12)) == false) goto L13;
        CommSenseLog.wWithMethodName(TAG, "attestation cert expired, refresh and retry, url=" + r8);
        LocationUtil.getInstance().invalidatePrivacyIdAttestationCert();
        Map<String, String> r13 = refreshPoiRequestHeaders(r11);
        if (r13 != null) goto L12;
        CommSenseLog.eWithMethodName(TAG, "skip retry because refreshed headers is null");
        return r12;
    L12:
        return doHttpPostOnce(r8, r10, r13);
    }

    private SsResponse<String> doHttpPostForm(String r17, Map<String, String> r18, Map<String, String> r19, List<Header> r20) {
        HttpURLConnection r8 = null;
        StringBuilder r10 = new StringBuilder(r17);     // Catch: Throwable -> L92
        boolean r11 = true;
        if (r18 != null) goto L7;
    L23:
        URL r12 = new URL(r10.toString());     // Catch: Throwable -> L92
        HttpURLConnection r13 = (HttpURLConnection) r12.openConnection();     // Catch: Throwable -> L92
        r13.setConnectTimeout(POI_HTTP_CONNECT_TIMEOUT_MS);     // Catch: Throwable -> L90
        r13.setReadTimeout(POI_HTTP_TIMEOUT_MS);     // Catch: Throwable -> L90
        r13.setRequestMethod(HttpMethodContrants.POST);     // Catch: Throwable -> L90
        r13.setDoInput(true);     // Catch: Throwable -> L90
        r13.setDoOutput(true);     // Catch: Throwable -> L90
        if (r20 == null) goto L31;
        Iterator<Header> r14 = r20.iterator();     // Catch: Throwable -> L90
    L28:
        if (r14.hasNext() == false) goto L31;
        Header r15 = r14.next();     // Catch: Throwable -> L90
        r13.setRequestProperty(r15.getName(), r15.getValue());     // Catch: Throwable -> L90
    L31:
        if (r13.getRequestProperty(CONTENT_TYPE_HEADER) != null) goto L33;
        r13.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_FORM_UTF8);     // Catch: Throwable -> L90
    L33:
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L90
        if (r19 != null) goto L36;
    L44:
        byte[] r21 = r16.toString().getBytes("UTF-8");     // Catch: Throwable -> L90
        r13.setFixedLengthStreamingMode(r21.length);     // Catch: Throwable -> L90
        OutputStream r22 = r13.getOutputStream();     // Catch: Throwable -> L90
        r22.write(r21);     // Catch: Throwable -> L81
        r22.close();     // Catch: Throwable -> L90
        int r23 = r13.getResponseCode();     // Catch: Throwable -> L90
        if (r23 < 200) goto L50;
        if (r23 >= 300) goto L50;
        InputStream r110 = r13.getInputStream();     // Catch: Throwable -> L90
    L51:
        BufferedReader r24 = new BufferedReader(new InputStreamReader(r110, "UTF-8"));     // Catch: Throwable -> L90
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L90
    L52:
        String r111 = r24.readLine();     // Catch: Throwable -> L90
        if (r111 == null) goto L55;
        r25.append(r111);     // Catch: Throwable -> L90
        goto L52
    L55:
        r24.close();     // Catch: Throwable -> L90
        String r26 = r25.toString();     // Catch: Throwable -> L90
        Map<String, List<String>> r27 = r13.getHeaderFields();     // Catch: Throwable -> L90
        logPoiResponseLogId(r27, r17);     // Catch: Throwable -> L90
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L90
        if (r27 == null) goto L67;
        Iterator<Map.Entry<String, List<String>>> r28 = r27.entrySet().iterator();     // Catch: Throwable -> L90
    L59:
        if (r28.hasNext() == false) goto L67;
        Map.Entry<String, List<String>> r29 = r28.next();     // Catch: Throwable -> L90
        if (r29.getKey() == null) goto L59;
        if (r29.getValue() == null) goto L59;
        if (r29.getValue().isEmpty() == true) goto L59;
        r112.add(new Header(r29.getKey(), r29.getValue().get(0)));     // Catch: Throwable -> L90
    L67:
        String r113 = r12.toString();     // Catch: Throwable -> L90
        if (r13.getResponseMessage() == null) goto L70;
        String r30 = r13.getResponseMessage();     // Catch: Throwable -> L90
    L71:
        Response r31 = new Response(r113, r23, r30, r112, null);     // Catch: Throwable -> L90
        if (r23 < 200) goto L78;
        if (r23 >= 300) goto L78;
        CommSenseLog.dWithMethodName(TAG, "response code=" + r23);     // Catch: Throwable -> L90
        SsResponse<String> r32 = SsResponse.success(r26, r31);     // Catch: Throwable -> L90
        r13.disconnect();
        return r32;
    L78:
        CommSenseLog.eWithMethodName(TAG, "response code=" + r23 + ", body=" + r26);     // Catch: Throwable -> L90
        SsResponse<String> r33 = SsResponse.error(new TypedByteArray(CONTENT_TYPE_JSON_UTF8, r26.getBytes("UTF-8"), new String[0]), r31);     // Catch: Throwable -> L90
        r13.disconnect();
        return r33;
    L70:
        r30 = "";
    L50:
        r110 = r13.getErrorStream();     // Catch: Throwable -> L90
        goto L51
    L81:
        th = move-exception;
        if (r22 == null) goto L120;
        r22.close();     // Catch: Throwable -> L86
    L121:
        throw th;     // Catch: Throwable -> L90
    L86:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L90
        throw th;     // Catch: Throwable -> L90
    L120:
        throw th;     // Catch: Throwable -> L90
    L36:
        if (r19.isEmpty() == true) goto L44;
        Iterator<Map.Entry<String, String>> r34 = r19.entrySet().iterator();     // Catch: Throwable -> L90
    L39:
        if (r34.hasNext() == false) goto L44;
        Map.Entry<String, String> r114 = r34.next();     // Catch: Throwable -> L90
        if (r11 == true) goto L43;
        r16.append("&");     // Catch: Throwable -> L90
    L43:
        r16.append(URLEncoder.encode(r114.getKey(), "UTF-8"));     // Catch: Throwable -> L90
        r16.append("=");     // Catch: Throwable -> L90
        r16.append(URLEncoder.encode(r114.getValue(), "UTF-8"));     // Catch: Throwable -> L90
        r11 = false;
    L90:
        th = th;
        r8 = r13;
    L93:
        if (r8 == null) goto L95;
        r8.disconnect();
    L95:
        throw th;
    L7:
        if (r18.isEmpty() == true) goto L23;
        if (r17.contains("?") == true) goto L12;
        r10.append("?");     // Catch: Throwable -> L92
    L16:
        Iterator<Map.Entry<String, String>> r35 = r18.entrySet().iterator();     // Catch: Throwable -> L92
        boolean r115 = true;
    L18:
        if (r35.hasNext() == false) goto L23;
        Map.Entry<String, String> r116 = r35.next();     // Catch: Throwable -> L92
        if (r115 == true) goto L22;
        r10.append("&");     // Catch: Throwable -> L92
    L22:
        r10.append(URLEncoder.encode(r116.getKey(), "UTF-8"));     // Catch: Throwable -> L92
        r10.append("=");     // Catch: Throwable -> L92
        r10.append(URLEncoder.encode(r116.getValue(), "UTF-8"));     // Catch: Throwable -> L92
        r115 = false;
        goto L18
    L12:
        if (r17.endsWith("?") == true) goto L16;
        if (r17.endsWith("&") == true) goto L16;
        r10.append("&");     // Catch: Throwable -> L92
    L92:
        th = th;
        goto L93
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PoiHttpPostResult doHttpPostOnce(String r11, String r12, Map<String, String> r13) {
        HttpURLConnection r8 = null;
        Object[] r10 = 0;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L46
        r14.setConnectTimeout(POI_HTTP_CONNECT_TIMEOUT_MS);     // Catch: Throwable -> L44
        r14.setReadTimeout(POI_HTTP_TIMEOUT_MS);     // Catch: Throwable -> L44
        r14.setRequestMethod(HttpMethodContrants.POST);     // Catch: Throwable -> L44
        r14.setDoInput(true);     // Catch: Throwable -> L44
        r14.setDoOutput(true);     // Catch: Throwable -> L44
        if (r13 == null) goto L11;
        Iterator<Map.Entry<String, String>> r15 = r13.entrySet().iterator();     // Catch: Throwable -> L44
    L8:
        if (r15.hasNext() == false) goto L11;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L44
        r14.setRequestProperty(r16.getKey(), r16.getValue());     // Catch: Throwable -> L44
    L11:
        if (r14.getRequestProperty(CONTENT_TYPE_HEADER) != null) goto L16;
        if (r13 != null) goto L14;
    L15:
        r14.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON_UTF8);     // Catch: Throwable -> L44
        goto L16
    L14:
        if (r13.containsKey(CONTENT_TYPE_HEADER_LOWERCASE) == false) goto L15;
    L16:
        byte[] r17 = r12.getBytes("UTF-8");     // Catch: Throwable -> L44
        r14.setFixedLengthStreamingMode(r17.length);     // Catch: Throwable -> L44
        OutputStream r18 = r14.getOutputStream();     // Catch: Throwable -> L44
        r18.write(r17);     // Catch: Throwable -> L37
        r18.close();     // Catch: Throwable -> L44
        int r19 = r14.getResponseCode();     // Catch: Throwable -> L44
        String r20 = logPoiResponseLogId(r14.getHeaderFields(), r11);     // Catch: Throwable -> L44
        if (r19 < 200) goto L22;
        if (r19 >= 300) goto L22;
        InputStream r21 = r14.getInputStream();     // Catch: Throwable -> L44
    L23:
        BufferedReader r110 = new BufferedReader(new InputStreamReader(r21, "UTF-8"));     // Catch: Throwable -> L44
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L44
    L24:
        String r22 = r110.readLine();     // Catch: Throwable -> L44
        if (r22 == null) goto L27;
        r111.append(r22);     // Catch: Throwable -> L44
        goto L24
    L27:
        r110.close();     // Catch: Throwable -> L44
        String r23 = r111.toString();     // Catch: Throwable -> L44
        if (r19 < 200) goto L34;
        if (r19 >= 300) goto L34;
        CommSenseLog.dWithMethodName(TAG, "response code=" + r19 + ", url=" + r11);     // Catch: Throwable -> L44
        PoiHttpPostResult r112 = new PoiHttpPostResult(r23, r20, r19, r10 == true ? 1 : 0);     // Catch: Throwable -> L44
        r14.disconnect();
        return r112;
    L34:
        CommSenseLog.eWithMethodName(TAG, "response code=" + r19 + ", url=" + r11 + ", body=" + r23);     // Catch: Throwable -> L44
        PoiHttpPostResult r113 = new PoiHttpPostResult(null, r23, r20, r19, null);     // Catch: Throwable -> L44
        r14.disconnect();
        return r113;
    L22:
        r21 = r14.getErrorStream();     // Catch: Throwable -> L44
        goto L23
    L37:
        th = move-exception;
        if (r18 != null) goto L55;
    L43:
        throw th;     // Catch: Throwable -> L44
    L55:
        r18.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L44
    L44:
        th = th;
        r8 = r14;
    L47:
        if (r8 == null) goto L49;
        r8.disconnect();
    L49:
        throw th;
    L46:
        th = th;
        goto L47
    }

    public static /* synthetic */ List e(BdLocationManager r8, List r10) {
        return r8.lambda$queryFencesByPoiId$7(r10);
    }

    private PoiTextSearchResult executeBdPoiSearch(String r10, int r11, int r12, String r13, String r14) {
        return executeEncryptedPoiSearch(POI_TEXT_SEARCH_PATH, r10, r11, r12, r13, r14, "POI_SEARCH");
    }

    private PoiTextSearchResult executeBmapPoiSearch(String r10, int r11, int r12, String r13, String r14) {
        return executeEncryptedPoiSearch(BMAP_SEARCH_PATH, r10, r11, r12, r13, r14, "BMAP_POI_SEARCH");
    }

    private BmapDrivingDirectionResponse executeDrivingDirectionSearch(BmapDrivingDirectionRequest r10) {
        String r8 = "";
        CommSenseLog.iWithMethodName(TAG, "");
        Map<String, String> r11 = buildPoiRequestHeaders(null);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r11 != null) goto L6;
        return null;
    L6:
        PoiHttpPostResult r12 = doHttpPost(buildPoiApiUrl(BMAP_DRIVING_PATH), buildEncryptedRequestBody(buildDrivingDirectionRequestBody(r10), "DRIVING_SEARCH").toString(), r11);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L9;
        r8 = PoiHttpPostResult.access$300(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L9:
        r10.xTtLogId = r8;     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L12;
        String r13 = PoiHttpPostResult.access$200(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L13:
        if (r13 != null) goto L16;
        CommSenseLog.eWithMethodName(TAG, "response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L16:
        p r14 = parseJsonElement(r13);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r14 != null) goto L19;
    L29:
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json object");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L19:
        if ((r14 instanceof s) == false) goto L29;
        BmapDrivingDirectionResponse r15 = parseDrivingDirectionResponse(normalizeEncryptedResponseEnvelope(r14.f(), "DRIVING_SEARCH"));     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r15 != null) goto L26;
        CommSenseLog.eWithMethodName(TAG, "parsed response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L26:
        if (r15.isSuccess() == true) goto L28;
        CommSenseLog.eWithMethodName(TAG, "status=" + r15.status + ", message=" + r15.message);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L28:
        return r15;
    L12:
        r13 = null;
    L35:
        e = e;
        String r16 = "catch RuntimeException";
    L33:
        CommSenseLog.eWithMethodName(TAG, r16, e);
        return null;
    L37:
        e = e;
        r16 = "catch SocketTimeoutException";
    L31:
        e = e;
        r16 = "catch Exception";
        goto L33
    }

    private PoiTextSearchResult executeEncryptedPoiSearch(String r12, String r13, int r14, int r15, String r16, String r17, String r18) {
        CommSenseLog.iWithMethodName(TAG, r18 + ": execute search");
        String r10 = null;
        Map<String, String> r11 = buildPoiRequestHeaders(null);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r11 == null) goto L6;
        PoiHttpPostResult r8 = doHttpPost(buildPoiApiUrl(r12), buildEncryptedRequestBody(buildPoiSearchPayload(r13, r14, r15, r16, r17), r18).toString(), r11);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r8 == null) goto L10;
        String r19 = PoiHttpPostResult.access$200(r8);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
    L11:
        if (r19 == null) goto L13;
        CommSenseLog.iWithMethodName(TAG, r18 + ": Raw Response length: " + r19.length());     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        CommsenseTextSearchResponse r20 = parsePoiTextSearchResponse(r19, r18);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r20 == null) goto L49;
        Integer r21 = r20.code;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r21 != null) goto L19;
    L22:
        CommonLocationTextSearchResponseData r22 = r20.data;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r22 == null) goto L49;
        if (r22.poiList == null) goto L49;
    L26:
        CommSenseLog.iWithMethodName(TAG, r18 + ": status:200");     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        CommonLocationTextSearchResponseData r23 = r20.data;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r23 == null) goto L48;
        if (r23.poiList == null) goto L48;
        HashMap r24 = new HashMap();     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        Iterator<CommonPOIInfo> r25 = r20.data.poiList.iterator();     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
    L32:
        if (r25.hasNext() == false) goto L46;
        CommonPOIInfo r26 = r25.next();     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        String r27 = r26.lbsProvince;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        String r28 = "";
        if (r27 != null) goto L38;
        r27 = "";
    L38:
        String r29 = r26.lbsCity;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r29 == null) goto L41;
        r28 = r29;
    L41:
        String r30 = r27 + r28;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r24.containsKey(r30) == true) goto L44;
        r24.put(r30, new ArrayList());     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
    L44:
        ((List) r24.get(r30)).add(r26);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        goto L32
    L46:
        return new PoiTextSearchResult(r24, r20.code, r20.msg);
    L48:
        return new PoiTextSearchResult(new HashMap(), r20.code, r20.msg);
    L19:
        if (r21.intValue() == 0) goto L26;
        if (r20.code.intValue() == POI_RESPONSE_CODE_PARTIAL_SUCCESS) goto L26;
    L49:
        String r31 = "null";
        int r32 = -99999;
        if (r20 == null) goto L57;
        Integer r33 = r20.code;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r33 == null) goto L54;
        r32 = r33.intValue();     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
    L54:
        String r34 = r20.msg;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r34 == null) goto L57;
        r31 = r34;
    L57:
        CommSenseLog.eWithMethodName(TAG, r18 + ": Error code=" + r32 + ", msg=" + r31);     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        HashMap r35 = new HashMap();     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        if (r20 != null) goto L60;
        Integer r36 = null;
    L61:
        if (r20 == null) goto L65;
        r10 = r20.msg;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
    L65:
        return new PoiTextSearchResult(r35, r36, r10);
    L60:
        r36 = r20.code;     // Catch: Exception -> L66 RuntimeException -> L69 SocketTimeoutException -> L71
        goto L61
    L13:
        return new PoiTextSearchResult(new HashMap(), null, null);
    L10:
        r19 = null;
        goto L11
    L6:
        return new PoiTextSearchResult(new HashMap(), null, "headers is null");
    L69:
        e = move-exception;
        throw e;
    L71:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, r18 + ": Network timeout in execute search", e);
        throw new RuntimeException("Network timeout", e);
    L66:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, r18 + ": Exception in execute search", e);
        throw new RuntimeException("Execution failed", e);
    }

    private boolean executeQueryCellsArea(List<StarCellManager.StarCellInfo> r10) {
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        Context r8 = this.appContext;
        if (r8 != null) goto L9;
        CommSenseLog.eWithMethodName(TAG, "appContext is null");
        return false;
    L9:
        String r11 = null;
        Map<String, String> r12 = buildPoiRequestHeaders(null);     // Catch: Exception -> L49
        if (r12 != null) goto L13;
        return false;
    L13:
        PoiHttpPostResult r13 = doHttpPost(buildPoiApiUrl(CELL_GEO_PROFILE_PATH), buildCellsAreaRequestBody(r10).toString(), r12);     // Catch: Exception -> L49
        if (r13 == null) goto L16;
        r11 = PoiHttpPostResult.access$200(r13);     // Catch: Exception -> L49
    L16:
        if (r13 == null) goto L18;
        String r14 = PoiHttpPostResult.access$300(r13);     // Catch: Exception -> L49
    L19:
        if (r13 == null) goto L21;
        int r15 = PoiHttpPostResult.access$400(r13);     // Catch: Exception -> L49
    L23:
        if (TextUtils.isEmpty(r11) == false) goto L26;
        CommSenseLog.eWithMethodName(TAG, "CELL_GEO_PROFILE: response is empty, status=" + r15 + ", X-Tt-Logid=" + safeString(r14));     // Catch: Exception -> L49
        return false;
    L26:
        CellsAreaParseResult r16 = parseCellsAreaResponse(r11, r10);     // Catch: Exception -> L49
        logCellProfileInfos(r8, CellsAreaParseResult.access$500(r16));     // Catch: Exception -> L49
        List r17 = CellsAreaParseResult.access$600(r16);     // Catch: Exception -> L49
        if (r17.isEmpty() == false) goto L30;
        CommSenseLog.dWithMethodName(TAG, "no cell profile parsed");     // Catch: Exception -> L49
        return false;
    L30:
        StarCellDbManager r18 = StarCellDbManager.getInstance(r8);     // Catch: Exception -> L49
        Iterator r19 = r17.iterator();     // Catch: Exception -> L49
        int r20 = 0;
    L32:
        if (r19.hasNext() == false) goto L36;
        if (r18.insertOrReplaceCellInfo((StarCellDbManager.InnerCellInfoEntry) r19.next()) == false) goto L32;
        r20 = r20 + 1;     // Catch: Exception -> L49
        goto L32
    L36:
        CommSenseLog.iWithMethodName(TAG, "CELL_GEO_PROFILE saved count=" + r20 + ", parsed count=" + r17.size());     // Catch: Exception -> L49
        logFirstCellAoiBoardEntry(CellsAreaParseResult.access$700(r16));     // Catch: Exception -> L49
        if (CellsAreaParseResult.access$700(r16).isEmpty() == true) goto L46;
        StarAoiBoardManager r21 = StarAoiBoardManager.getInstance(r8, 0);     // Catch: Exception -> L49
        List<AoiBoard> r22 = buildAoiBoardsForCellProfile(r21, CellsAreaParseResult.access$700(r16));     // Catch: Exception -> L49
        if (r22.isEmpty() == false) goto L41;
    L44:
        boolean r23 = true;
    L45:
        CommSenseLog.iWithMethodName(TAG, "CELL_GEO_PROFILE saved aoi board=" + r23 + ", updated cell fields=" + StarLocationDbManager.getInstance(r8, 0).updateCellAoiBoardFields(CellsAreaParseResult.access$700(r16)) + ", save count=" + r22.size() + ", parsed count=" + CellsAreaParseResult.access$700(r16).size());     // Catch: Exception -> L49
        goto L46
    L41:
        if (r21.addAoiBoards(r22) == true) goto L44;
        r23 = false;
    L46:
        if (r20 > 0) goto L48;
        return false;
    L48:
        return true;
    L21:
        r15 = -1;
        goto L23
    L18:
        r14 = "";
    L49:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
        return false;
    }

    private List<PoiFenceInfo> executeQueryFencesByPoiId(List<String> r8) {
        String r10 = null;
        Map<String, String> r11 = buildPoiRequestHeaders(null);     // Catch: Exception -> L16
        if (r11 == null) goto L6;
        s r12 = buildGetFencesRequestBody(r8);     // Catch: Exception -> L16
        PoiHttpPostResult r13 = doHttpPost(buildPoiApiUrl(GET_FENCES_PATH), r12.toString(), r11);     // Catch: Exception -> L16
        if (r13 == null) goto L11;
        r10 = PoiHttpPostResult.access$200(r13);     // Catch: Exception -> L16
    L11:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        CommSenseLog.eWithMethodName(TAG, "GET_FENCES: response is empty");     // Catch: Exception -> L16
        return new ArrayList();
    L15:
        return parseGetFencesResponse(r10);
    L6:
        return new ArrayList();
    L16:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "GET_FENCES: failed", e);
        return new ArrayList();
    }

    private List<PoiFenceInfo> executeQueryFencesByPoiIdInBatches(List<String> r11) {
        if (r11.size() <= 10) goto L5;
        int r8 = getGetFencesBatchCount(r11.size());
        CommSenseLog.iWithMethodName(TAG, "GET_FENCES: split request, totalCount=" + r11.size() + ", batchSize=10, batchCount=" + r8);
        ArrayList r10 = new ArrayList();
        int r12 = 0;
        int r13 = 1;
    L8:
        if (r12 >= r11.size()) goto L10;
        int r14 = r12 + 10;
        List<String> r15 = r11.subList(r12, Math.min(r14, r11.size()));
        StringBuilder r16 = defpackage.a.g("GET_FENCES: execute batch ", r13, "/", r8, ", count=");
        r16.append(r15.size());
        CommSenseLog.dWithMethodName(TAG, r16.toString());
        r10.addAll(executeQueryFencesByPoiId(r15));
        r13 = r13 + 1;
        r12 = r14;
        goto L8
    L10:
        CommSenseLog.iWithMethodName(TAG, "GET_FENCES: batch request finished, totalCount=" + r11.size() + ", resultCount=" + r10.size());
        return r10;
    L5:
        return executeQueryFencesByPoiId(r11);
    }

    private boolean executeQueryNearPoiData() {
        String r8 = null;
        Map<String, String> r10 = buildPoiRequestHeaders(null);     // Catch: Exception -> L23
        if (r10 != null) goto L6;
        return false;
    L6:
        s r11 = new s();     // Catch: Exception -> L23
        r11.m(WsConstants.KEY_APP_ID, Integer.valueOf(Integer.parseInt(ByteIOUtils.APP_ID)));     // Catch: Exception -> L23
        r11.n("index", NEAR_POI_DATA_INDEX);     // Catch: Exception -> L23
        PoiHttpPostResult r12 = doHttpPost(buildPoiApiUrl(NEAR_POI_DATA_PATH), r11.toString(), r10);     // Catch: Exception -> L23
        if (r12 == null) goto L10;
        r8 = PoiHttpPostResult.access$200(r12);     // Catch: Exception -> L23
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L13;
        CommSenseLog.eWithMethodName(TAG, "response is empty");     // Catch: Exception -> L23
        return false;
    L13:
        p r13 = parseJsonElementLenient(r8);     // Catch: Exception -> L23
        if (r13 != null) goto L17;
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json");     // Catch: Exception -> L23
        return false;
    L17:
        Bundle r14 = parseNearPoiDataBundle(r13, PoiHttpPostResult.access$300(r12));     // Catch: Exception -> L23
        if (r14 == null) goto L20;
        this.mLastNearPoiDataBundle = r14;     // Catch: Exception -> L23
        CommSenseLog.iWithMethodName(TAG, "near poi data parsed, timestamp=" + r14.getLong("timestamp"));     // Catch: Exception -> L23
        StarPoiManager.getInstance().dumpPoiLog("Response Bundle: " + describeBundle(r14));     // Catch: Exception -> L23
        StarPoiManager.getInstance().notifyNearPoiReport(r14);     // Catch: Exception -> L23
        return true;
    L20:
        StarPoiManager.getInstance().dumpPoiLog("Response Bundle: No useful data.");     // Catch: Exception -> L23
        return true;
    L23:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
        return false;
    }

    private boolean executeQueryPoiTypeDatas() {
        Context r8 = this.appContext;
        if (r8 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "appContext is null");
        return false;
    L6:
        StarPoiDbManager r10 = StarPoiDbManager.getInstance(r8);
        if (r10.hasPoiDatas() == false) goto L29;
        CommSenseLog.iWithMethodName(TAG, "poi_datas already exists, skip network request");
        return true;
    L29:
        s r11 = new s();     // Catch: Exception -> L26
        r11.m("need_offline_data", 0);     // Catch: Exception -> L26
        r11.m("type_code_version", 1);     // Catch: Exception -> L26
        String r12 = buildPoiApiUrl(POI_TYPE_DATA_PATH);     // Catch: Exception -> L26
        String r13 = null;
        Map<String, String> r14 = buildPoiRequestHeaders(null);     // Catch: Exception -> L26
        if (r14 != null) goto L13;
        return false;
    L13:
        PoiHttpPostResult r15 = doHttpPost(r12, r11.toString(), r14);     // Catch: Exception -> L26
        if (r15 == null) goto L17;
        r13 = PoiHttpPostResult.access$200(r15);     // Catch: Exception -> L26
    L17:
        if (TextUtils.isEmpty(r13) == false) goto L20;
        CommSenseLog.eWithMethodName(TAG, "response is empty");     // Catch: Exception -> L26
        return false;
    L20:
        List<StarPoiDbManager.PoiData> r16 = parsePoiTypeDataResponse(r13);     // Catch: Exception -> L26
        if (r16.isEmpty() == false) goto L24;
        CommSenseLog.eWithMethodName(TAG, "parsed poi type data is empty");     // Catch: Exception -> L26
        return false;
    L24:
        boolean r17 = r10.replacePoiDatas(r16);     // Catch: Exception -> L26
        CommSenseLog.iWithMethodName(TAG, "success=" + r17 + ", count=" + r16.size());     // Catch: Exception -> L26
        return r17;
    L26:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
        return false;
    }

    private BmapRidingDirectionResponse executeRidingDirectionSearch(BmapRidingDirectionRequest r8) {
        CommSenseLog.iWithMethodName(TAG, "executeRidingDirectionSearch");
        Map<String, String> r10 = buildPoiRequestHeaders(null);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        if (r10 != null) goto L6;
        return null;
    L6:
        PoiHttpPostResult r11 = doHttpPost(buildPoiApiUrl(BMAP_RIDING_PATH), buildEncryptedRequestBody(buildRidingDirectionRequestBody(r8), "RIDING_SEARCH").toString(), r10);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        if (r11 == null) goto L9;
        String r12 = PoiHttpPostResult.access$300(r11);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
    L10:
        r8.xTtLogId = r12;     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        if (r11 == null) goto L13;
        String r13 = PoiHttpPostResult.access$200(r11);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
    L14:
        if (r13 != null) goto L17;
        CommSenseLog.eWithMethodName(TAG, "response is null");     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        return null;
    L17:
        p r14 = parseJsonElement(r13);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        if (r14 != null) goto L20;
    L30:
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json object");     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        return null;
    L20:
        if ((r14 instanceof s) == false) goto L30;
        BmapRidingDirectionResponse r15 = parseRidingDirectionResponse(normalizeEncryptedResponseEnvelope(r14.f(), "RIDING_SEARCH"));     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        if (r15 != null) goto L27;
        CommSenseLog.eWithMethodName(TAG, "parsed response is null");     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
        return null;
    L27:
        if (r15.isSuccess() == true) goto L29;
        CommSenseLog.eWithMethodName(TAG, "status=" + r15.status + ", message=" + r15.message);     // Catch: Exception -> L32 RuntimeException -> L36 SocketTimeoutException -> L38
    L29:
        return r15;
    L13:
        r13 = null;
        goto L14
    L9:
        r12 = "";
    L36:
        e = e;
        String r16 = "catch RuntimeException";
    L34:
        CommSenseLog.eWithMethodName(TAG, r16, e);
        return null;
    L38:
        e = e;
        r16 = "catch SocketTimeoutException";
    L32:
        e = e;
        r16 = "catch Exception";
        goto L34
    }

    private MapPoiTextSearchResult executeSearchMapPoiText(String r10, int r11, int r12, String r13, String r14) {
        Map<String, String> r8 = buildPoiRequestHeaders(null);     // Catch: Exception -> L23
        if (r8 == null) goto L6;
        s r15 = buildEncryptedRequestBody(buildMapPoiTextSearchRequestBody(r10, r11, r12, r13, r14), "TEXT_SEARCH_MAP_POI");     // Catch: Exception -> L23
        String r16 = buildPoiApiUrl(TEXT_SEARCH_MAP_POI_PATH);     // Catch: Exception -> L23
        CommSenseLog.iWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: execute request, keyword=" + safeString(r10) + ", city=" + safeString(r13) + ", pageNum=" + r11 + ", pageSize=" + r12);     // Catch: Exception -> L23
        PoiHttpPostResult r17 = doHttpPost(r16, r15.toString(), r8);     // Catch: Exception -> L23
        if (r17 == null) goto L10;
        String r18 = PoiHttpPostResult.access$200(r17);     // Catch: Exception -> L23
    L11:
        if (r17 == null) goto L13;
        String r19 = PoiHttpPostResult.access$300(r17);     // Catch: Exception -> L23
    L14:
        if (r17 == null) goto L16;
        int r20 = PoiHttpPostResult.access$400(r17);     // Catch: Exception -> L23
    L18:
        if (TextUtils.isEmpty(r18) == false) goto L22;
        CommSenseLog.eWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: response is empty, status=" + r20 + ", X-Tt-Logid=" + safeString(r19));     // Catch: Exception -> L23
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "empty response");
    L22:
        return parseMapPoiTextSearchResponse(r18);
    L16:
        r20 = -1;
        goto L18
    L13:
        r19 = "";
        goto L14
    L10:
        r18 = null;
        goto L11
    L6:
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "headers is null");
    L23:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: failed", e);
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "exception");
    }

    private BmapTransitDirectionResponse executeTransitDirectionSearch(BmapTransitDirectionRequest r10) {
        String r8 = "";
        CommSenseLog.iWithMethodName(TAG, "");
        Map<String, String> r11 = buildPoiRequestHeaders(null);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r11 != null) goto L6;
        return null;
    L6:
        PoiHttpPostResult r12 = doHttpPost(buildPoiApiUrl(BMAP_TRANSIT_PATH), buildEncryptedRequestBody(buildTransitDirectionRequestBody(r10), "TRANSIT_SEARCH").toString(), r11);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L9;
        r8 = PoiHttpPostResult.access$300(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L9:
        r10.xTtLogId = r8;     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L12;
        String r13 = PoiHttpPostResult.access$200(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L13:
        if (r13 != null) goto L16;
        CommSenseLog.eWithMethodName(TAG, "response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L16:
        p r14 = parseJsonElement(r13);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r14 != null) goto L19;
    L29:
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json object");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L19:
        if ((r14 instanceof s) == false) goto L29;
        BmapTransitDirectionResponse r15 = parseTransitDirectionResponse(normalizeEncryptedResponseEnvelope(r14.f(), "TRANSIT_SEARCH"));     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r15 != null) goto L26;
        CommSenseLog.eWithMethodName(TAG, "parsed response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L26:
        if (r15.isSuccess() == true) goto L28;
        CommSenseLog.eWithMethodName(TAG, "status=" + r15.status + ", message=" + r15.message);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L28:
        return r15;
    L12:
        r13 = null;
    L35:
        e = e;
        String r16 = "catch RuntimeException";
    L33:
        CommSenseLog.eWithMethodName(TAG, r16, e);
        return null;
    L37:
        e = e;
        r16 = "catch SocketTimeoutException";
    L31:
        e = e;
        r16 = "catch Exception";
        goto L33
    }

    private BmapWalkingDirectionResponse executeWalkingDirectionSearch(BmapWalkingDirectionRequest r10) {
        String r8 = "";
        CommSenseLog.iWithMethodName(TAG, "");
        Map<String, String> r11 = buildPoiRequestHeaders(null);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r11 != null) goto L6;
        return null;
    L6:
        PoiHttpPostResult r12 = doHttpPost(buildPoiApiUrl(BMAP_WALKING_PATH), buildEncryptedRequestBody(buildWalkingDirectionRequestBody(r10), "WALKING_SEARCH").toString(), r11);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L9;
        r8 = PoiHttpPostResult.access$300(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L9:
        r10.xTtLogId = r8;     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r12 == null) goto L12;
        String r13 = PoiHttpPostResult.access$200(r12);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L13:
        if (r13 != null) goto L16;
        CommSenseLog.eWithMethodName(TAG, "response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L16:
        p r14 = parseJsonElement(r13);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r14 != null) goto L19;
    L29:
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json object");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L19:
        if ((r14 instanceof s) == false) goto L29;
        BmapWalkingDirectionResponse r15 = parseWalkingDirectionResponse(normalizeEncryptedResponseEnvelope(r14.f(), "WALKING_SEARCH"));     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        if (r15 != null) goto L26;
        CommSenseLog.eWithMethodName(TAG, "parsed response is null");     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
        return null;
    L26:
        if (r15.isSuccess() == true) goto L28;
        CommSenseLog.eWithMethodName(TAG, "status=" + r15.status + ", message=" + r15.message);     // Catch: Exception -> L31 RuntimeException -> L35 SocketTimeoutException -> L37
    L28:
        return r15;
    L12:
        r13 = null;
    L35:
        e = e;
        String r16 = "catch RuntimeException";
    L33:
        CommSenseLog.eWithMethodName(TAG, r16, e);
        return null;
    L37:
        e = e;
        r16 = "catch SocketTimeoutException";
    L31:
        e = e;
        r16 = "catch Exception";
        goto L33
    }

    private String extractMessage(s r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = "message";
        if (r8.t("message") == false) goto L11;
        p r11 = r8.p("message");
        r11.getClass();
        if ((r11 instanceof r) == true) goto L11;
    L10:
        return r8.p(r10).j();
    L11:
        r10 = "msg";
        if (r8.t("msg") == false) goto L16;
        p r12 = r8.p("msg");
        r12.getClass();
        if ((r12 instanceof r) == false) goto L10;
    L16:
        r10 = "error_msg";
        if (r8.t("error_msg") == false) goto L21;
        p r13 = r8.p("error_msg");
        r13.getClass();
        if ((r13 instanceof r) == false) goto L10;
    L21:
        return null;
    }

    private p extractPoiListElement(p r8) {
        if (r8 != null) goto L5;
    L36:
        return null;
    L5:
        if ((r8 instanceof r) == true) goto L36;
        if ((r8 instanceof m) == false) goto L11;
        return r8;
    L11:
        if ((r8 instanceof u) == false) goto L18;
        if ((r8.g().f8004a instanceof String) == false) goto L18;
        return extractPoiListElement(parseJsonElementLenient(r8.j()));
    L16:
        return null;
    L18:
        if ((r8 instanceof s) == true) goto L20;
        return null;
    L20:
        s r10 = r8.f();
        String r11 = "poiList";
        if (r10.t("poiList") == true) goto L24;
        r11 = "poi_list";
    L24:
        p r12 = r10.p(r11);
        if (r12 != null) goto L27;
    L30:
        p r13 = r10.p("data");
        if (r13 == null) goto L36;
        if ((r13 instanceof r) == true) goto L36;
        return extractPoiListElement(r13);
    L27:
        if ((r12 instanceof r) == true) goto L30;
        return extractPoiListElement(r12);
    }

    private Integer extractStatusCode(s r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = "status";
        if (r8.t("status") == false) goto L11;
        p r11 = r8.p("status");
        r11.getClass();
        if ((r11 instanceof r) == true) goto L11;
    L10:
        return Integer.valueOf(r8.p(r10).d());
    L11:
        r10 = "code";
        if (r8.t("code") == false) goto L16;
        p r12 = r8.p("code");
        r12.getClass();
        if ((r12 instanceof r) == false) goto L10;
    L16:
        r10 = "errno";
        if (r8.t("errno") == false) goto L21;
        p r13 = r8.p("errno");
        r13.getClass();
        if ((r13 instanceof r) == false) goto L10;
    L21:
        return null;
    }

    public static /* synthetic */ boolean f(BdLocationManager r8) {
        return r8.executeQueryNearPoiData();
    }

    private void fillNearPoiTypeData(Bundle r13, s r14, s r15) {
        if (r14 != null) goto L5;
        r14 = r15;
    L5:
        String r8 = "";
        if (r14 != null) goto L8;
        String r10 = "";
    L9:
        StarPoiDbManager.PoiData r11 = findPoiTypeDataByCodeL3(r10);
        if (r11 != null) goto L12;
        String r12 = "";
    L13:
        r13.putString("new_type_name_l1", resolveNearPoiTypeField(r14, r12, new String[]{"new_type_name_l1", "NewTypeNameL1", "newTypeNameL1"}));
        if (r11 != null) goto L16;
        String r16 = "";
    L17:
        r13.putString("new_type_name_l2", resolveNearPoiTypeField(r14, r16, new String[]{"new_type_name_l2", "NewTypeNameL2", "newTypeNameL2"}));
        if (r11 != null) goto L20;
        String r17 = "";
    L21:
        r13.putString("new_type_name_l3", resolveNearPoiTypeField(r14, r17, new String[]{"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"}));
        if (r11 != null) goto L24;
        String r18 = "";
    L25:
        r13.putString("new_type_code_l1", resolveNearPoiTypeField(r14, r18, new String[]{"new_type_code_l1", "NewTypeCodeL1", "newTypeCodeL1"}));
        if (r11 != null) goto L28;
        String r19 = "";
    L29:
        r13.putString("new_type_code_l2", resolveNearPoiTypeField(r14, r19, new String[]{"new_type_code_l2", "NewTypeCodeL2", "newTypeCodeL2"}));
        if (TextUtils.isEmpty(r10) == false) goto L34;
        if (r11 == null) goto L35;
        r8 = r11.newTypeCodeL3;
    L35:
        r13.putString("new_type_code_l3", r8);
        CommSenseLog.dWithMethodName(TAG, "typeCode=" + r10 + ", category=" + r13.getString("new_type_name_l1") + ";" + r13.getString("new_type_name_l2") + ";" + r13.getString("new_type_name_l3"));
        if (r15 == null) goto L39;
        r13.putString(StarPoiManager.EXTRA_AOI_NEW_TYPE_CODE_L3, safeString(getStringByKeys(r15, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3"})));
        r13.putString(StarPoiManager.EXTRA_AOI_NEW_TYPE_NAME_L3, safeString(getStringByKeys(r15, new String[]{"new_type_name_l3", "NewTypeNameL3", "newTypeNameL3"})));
        return;
    L39:
        return;
    L34:
        r8 = r10;
        goto L35
    L28:
        r19 = r11.newTypeCodeL2;
        goto L29
    L24:
        r18 = r11.newTypeCodeL1;
        goto L25
    L20:
        r17 = r11.newTypeNameL3;
        goto L21
    L16:
        r16 = r11.newTypeNameL2;
        goto L17
    L12:
        r12 = r11.newTypeNameL1;
        goto L13
    L8:
        r10 = safeString(getStringByKeys(r14, new String[]{"new_type_code_l3", "NewTypeCodeL3", "newTypeCodeL3", KEY_NEAR_POI_AWEME_TYPE_CODE, "AwemeTypeCode", "awemeTypeCode"}));
        goto L9
    }

    private s findDirectionPayload(s r8) {
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L14;
        if (looksLikeDirectionPayload(r8) == true) goto L7;
        if (r8.t("data") == false) goto L14;
        p r11 = r8.p("data");
        r11.getClass();
        if ((r11 instanceof s) == false) goto L14;
        r8 = r8.r("data");
        r10 = r10 + 1;
        goto L4
    L7:
        return r8;
    L14:
        if (looksLikeDirectionPayload(r8) == true) goto L22;
        return null;
    L22:
        return r8;
    }

    private m findFirstLngLatPointArray(p r8) {
        if (r8 != null) goto L5;
    L19:
        return null;
    L5:
        if ((r8 instanceof m) == false) goto L19;
        m r10 = r8.e();
        if (r10.isEmpty() == false) goto L11;
        return null;
    L11:
        if (isLngLatPointArray(r10) == false) goto L13;
        return r10;
    L13:
        Iterator<p> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        m r12 = findFirstLngLatPointArray(r11.next());
        if (r12 == null) goto L15;
        return r12;
    }

    private m findFirstPointArray(p r8) {
        if (r8 != null) goto L5;
    L22:
        return null;
    L5:
        if ((r8 instanceof r) == true) goto L22;
        if ((r8 instanceof m) == true) goto L10;
        return null;
    L10:
        m r10 = r8.e();
        if (r10.isEmpty() == false) goto L14;
        return null;
    L14:
        if (isPointObjectArray(r10) == false) goto L16;
        return r10;
    L16:
        Iterator<p> r11 = r10.iterator();
    L18:
        if (r11.hasNext() == false) goto L22;
        m r12 = findFirstPointArray(r11.next());
        if (r12 == null) goto L18;
        return r12;
    }

    private p findMapPoiCellsElement(p r8) {
        return findMapPoiCellsElement(r8, 0);
    }

    private StarPoiDbManager.PoiData findPoiTypeDataByCodeL3(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        Context r10 = this.appContext;
        if (r10 != null) goto L10;
        CommSenseLog.wWithMethodName(TAG, "skip poi type lookup without context, typeCode=" + r8);
        return null;
    L10:
        return StarPoiDbManager.getInstance(r10).findPoiDataByNewTypeCodeL3(r8);
    }

    public static /* synthetic */ Boolean g(BdLocationManager r8, List r10) {
        return r8.lambda$queryCellsArea$5(r10);
    }

    private String getAoiTypeCode(s r8) {
        String r10 = safeString(getStringByKeys(r8, new String[]{"type", "Type", "type_code", "typeCode", "aoi_type", "aoiType"}));
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        p r11 = getValueByKeyCompat(r8, "type");
        if (r11 != null) goto L8;
        return "";
    L8:
        if ((r11 instanceof r) == false) goto L11;
        return "";
    L11:
        if ((r11 instanceof s) == false) goto L15;
        return safeString(getStringByKeys(r11.f(), new String[]{"code", "Code", "type_code", "typeCode", "id", "Id"}));
    L15:
        return jsonElementToDbString(r11);
    }

    private int getDirectionRouteCount(BmapDirectionBaseResponse r8) {
        if ((r8 instanceof BmapTransitDirectionResponse) == false) goto L11;
        BmapTransitDirectionResult r10 = ((BmapTransitDirectionResponse) r8).result;
        if (r10 == null) goto L34;
        List<BmapTransitRoute> r11 = r10.routes;
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.size();
    L34:
        return 0;
    L11:
        if ((r8 instanceof BmapDrivingDirectionResponse) == false) goto L19;
        BmapDrivingDirectionResult r12 = ((BmapDrivingDirectionResponse) r8).result;
        if (r12 == null) goto L36;
        List<BmapDrivingRoute> r13 = r12.routes;
        if (r13 != null) goto L17;
        return 0;
    L17:
        return r13.size();
    L36:
        return 0;
    L19:
        if ((r8 instanceof BmapWalkingDirectionResponse) == false) goto L27;
        BmapWalkingDirectionResult r14 = ((BmapWalkingDirectionResponse) r8).result;
        if (r14 == null) goto L38;
        List<BmapWalkingRoute> r15 = r14.routes;
        if (r15 != null) goto L25;
        return 0;
    L25:
        return r15.size();
    L38:
        return 0;
    L27:
        if ((r8 instanceof BmapRidingDirectionResponse) == false) goto L40;
        BmapRidingDirectionResult r16 = ((BmapRidingDirectionResponse) r8).result;
        if (r16 == null) goto L41;
        List<BmapRidingRoute> r17 = r16.routes;
        if (r17 != null) goto L33;
        return 0;
    L33:
        return r17.size();
    L41:
        return 0;
    L40:
        return 0;
    }

    private Double getDoubleByKeys(s r8, String... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L14;
        p r13 = getValueByKeyCompat(r8, r10[r12]);
        if (r13 == null) goto L13;
        if ((r13 instanceof r) == true) goto L13;
        return Double.valueOf(r13.c());
    L12:
        return null;
    L13:
        r12 = r12 + 1;
        goto L4
    L14:
        return null;
    }

    private String getExtraValue(Map<String, String> r8, String r10) {
        String r11 = r8.get(r10);
        if (r11 != null) goto L7;
        return "";
    L7:
        return r11;
    }

    private Double getFencePointLatitude(s r8) {
        return getDoubleByKeys(r8, new String[]{"latitude"});
    }

    private Double getFencePointLongitude(s r8) {
        return getDoubleByKeys(r8, new String[]{StarCellDbManager.CellInfoEntry.LONGITUDE});
    }

    private int getGetFencesBatchCount(int r8) {
        return Math.max(1, ((r8 + 10) - 1) / 10);
    }

    private long getGetFencesTimeoutMs(int r8) {
        return ((long) POI_HTTP_TIMEOUT_MS) * ((long) getGetFencesBatchCount(r8));
    }

    public static BdLocationManager getInstance() {
        return SINGLETON;
    }

    private Integer getIntByKeys(s r8, String... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L14;
        p r13 = getValueByKeyCompat(r8, r10[r12]);
        if (r13 == null) goto L13;
        if ((r13 instanceof r) == true) goto L13;
        return Integer.valueOf(r13.d());
    L12:
        return null;
    L13:
        r12 = r12 + 1;
        goto L4
    L14:
        return null;
    }

    private s getJsonObjectByKey(s r8, String r10) {
        p r11 = getValueByKeyCompat(r8, r10);
        if (r11 != null) goto L5;
    L7:
        return null;
    L5:
        if ((r11 instanceof s) == false) goto L7;
        return r11.f();
    }

    private Long getLongByKeys(s r8, String... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L14;
        p r13 = getValueByKeyCompat(r8, r10[r12]);
        if (r13 == null) goto L13;
        if ((r13 instanceof r) == true) goto L13;
        return Long.valueOf(r13.h());
    L12:
        return null;
    L13:
        r12 = r12 + 1;
        goto L4
    L14:
        return null;
    }

    private Integer getNearPoiAccQualified(s r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return getIntByKeys(r8, new String[]{"is_acc_qualified_poi"});
    }

    private String getNearPoiAwemeId(s r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return safeString(getStringByKeys(r8, new String[]{"aweme_id", "awemeId"}));
    }

    private Double getNearPoiConfidence(s r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return getDoubleByKeys(r8, new String[]{"confidence"});
    }

    private String getNearPoiName(s r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return safeString(getStringByKeys(r8, new String[]{"name"}));
    }

    private Boolean getPrivacyIdAttestationCertExpiredResult(s r8) {
        Integer r10 = getIntByKeys(r8, new String[]{"code", "errno", "status", "ret", "error_code"});
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.intValue() != POI_RESPONSE_CODE_CERT_EXPIRED) goto L8;
        boolean r11 = true;
    L10:
        return Boolean.valueOf(r11);
    L8:
        r11 = false;
        goto L10
    }

    private String getPrivacyIdAttestationCertSafely() {
        return LocationUtil.getInstance().getPrivacyIdAttestationCert();
    }

    private String getStringByKeys(s r8, String... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        p r13 = getValueByKeyCompat(r8, r10[r12]);
        if (r13 == null) goto L13;
        if ((r13 instanceof r) == true) goto L13;
        if ((r13 instanceof u) == false) goto L13;
        return r13.j();
    L13:
        r12 = r12 + 1;
        goto L3
    L14:
        return null;
    }

    public static JSONObject getTestSettings() {
        JSONObject r8 = new JSONObject();
        r8.put(LocationSettingUtil.LOCATION_SDK_SETTINGS_KEY, new JSONObject("{\n    \"locationsdk_config_android\":{\n        \"collect_extra_gps\":false,\n        \"base_station_info_type\":0,\n        \"scan_ble_interval\":1000,\n        \"enable_collect_gnss_measurements\":false,\n        \"enable_tail_locate_optimize\":true,\n        \"cold_boot_collect_gps\":true,\n        \"async_scan_wifi\":false,\n        \"stationary_scene_max_interval\":1800000,\n        \"scan_wifi_interval\":0,\n        \"enable_collect_ble_in_battery_saving_mode\":false,\n        \"cold_boot_collect_gps_strategy\":1,\n        \"max_wait_gps_time_millis\":0,\n        \"enable_check_wifi_cache\":false,\n        \"stationary_scene_wifi_white_list\":\"Airport,Public,ChinaUnicom,China Unicom,UNICOM,ChinaMobile,China Mobile,CMCC,ChinaTelecom,China Telecom,Car,Auto\",\n        \"locate_type\":1,\n        \"check_wifi_cache_duration\":10000,\n        \"report_har\":true,\n        \"collect_gps_type\":1,\n        \"enable_location_opt_bpea_list\":\"\",\n        \"collect_continuous_gps_interval\":5000,\n        \"enable_collect_network_location_in_battery_saving_mode\":true,\n        \"stationary_scene_max_distance\":50,\n        \"upload_ble_num\":30,\n        \"use_new_reverse_geolocation_api\":true,\n        \"enable_destroy_amap_single_client\":true,\n        \"enable_dim_location_check\":true,\n        \"report_at_start\":true,\n        \"collect_config\":true,\n        \"monitor_strategy\":0,\n        \"use_new_cache_strategy\":true,\n        \"max_light_duration\":5000,\n        \"overseas_get_location_failed_cache_validity_time\":28800000,\n        \"check_location_bpea\":false,\n        \"report_wifi_max\":120,\n        \"new_network_change_register\":true,\n        \"enable_check_upload_compliance\":false,\n        \"enable_scan_wifi\":true,\n        \"report_bss_max\":10,\n        \"report_location_at_start\":false,\n        \"enable_traceroute\":false,\n        \"search_location_cache_time\":-1,\n        \"monitor_strategy_interval\":10000,\n        \"enable_check_last_log_id\":false,\n        \"enable_light_location_new_policy\":true,\n        \"enable_destroy_amap_continuous_client\":true,\n        \"allow_light_Location\":true,\n        \"report_gps\":true,\n        \"report_bss\":true,\n        \"enable_monitor\":true,\n        \"scan_gnss\":false,\n        \"enable_gps_scan\":true,\n        \"report_interval_seconds\":300,\n        \"check_connect_wifi_rssi\":-60,\n        \"need_downgrade_location_in_overseas\":true,\n        \"polling_upload\":false,\n        \"report_wifi\":true,\n        \"enable_collect_amap_location_in_battery_saving_mode\":false,\n        \"enable_use_coarse_location\":true,\n        \"enable_byte_continuous_location\":\"true\",\n        \"fresh_base_station_timeout\":0,\n        \"tail_accuracy_threshold\":100,\n        \"enable_stationary_scene_policy\":false,\n        \"enable_info_request_opt\":true,\n        \"byte_location_libra_param\":\"v2\",\n        \"enable_collect_gps_location_in_battery_saving_mode\":true,\n        \"collect_continuous_gps_duration\":5000,\n        \"tail_wifi_time_threshold\":60000,\n        \"hot_boot_cache_time\":180,\n        \"red_geo_name_ids\":\"1814991,1819730,1821275\",\n        \"upload_fresh_base_station\":true,\n        \"collect_continuous_gps_only_last\":true,\n        \"light_info_interval\":0,\n        \"use_cache_condition\":true,\n        \"collect_light_info\":true,\n        \"cold_boot_ab_test\":false,\n        \"default_gps_scan_interval\":15000,\n        \"report_har_range\":15,\n        \"collect_continuous_gps_enable\":true,\n        \"info_request_key_params_max_cache_time\":86400000,\n        \"stationary_scene_max_gps_accuracy\":50,\n        \"scan_ble\":true,\n        \"pre_location_callback\":false,\n        \"enable_check_connect_wifi\":false,\n        \"enable_background_upload_location\":false,\n        \"max_light_count\":30,\n        \"collect_extra_gps_timeout\":5000,\n        \"use_gps_check_region\":true\n    }\n}"));     // Catch: JSONException -> L5
    L7:
        return r8;
    L5:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed: " + e.getMessage(), e);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private p getValueByKeyCompat(s r8, String r10) {
        p r11 = r8.p(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        String r12 = normalizeJsonKey(r10);
        ja.s.b.a r13 = new ja.s.b.a(r8.o());
    L7:
        if (r13.hasNext() == false) goto L14;
        ja.s.e<K, V> r14 = r13.a();
        K r15 = r14.f8804p;
        if (r15 == 0) goto L7;
        if (r12.equals(normalizeJsonKey((String) r15)) == false) goto L7;
        return (p) r14.f8806r;
    L14:
        return null;
    }

    public static /* synthetic */ MapPoiTextSearchResult h(BdLocationManager r8, String r10, int r11, int r12, String r13, String r14) {
        return r8.lambda$searchMapPoiTextResult$6(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ PoiTextSearchResult i(BdLocationManager r8, String r10, int r11, int r12, String r13, String r14) {
        return r8.lambda$performBdPoiTextSearch$8(r10, r11, r12, r13, r14);
    }

    private void initLocationInternal() {
        Context r8 = this.appContext;
        if (r8 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "skipped: context is null");
        return;
    L6:
        String r10 = MatrixDidUtils.getDid(r8);
        if (TextUtils.isEmpty(r10) == false) goto L11;
        CommSenseLog.wWithMethodName(TAG, "skipped: did is empty");
        return;
    L11:
        if ((r8 instanceof Application) == true) goto L14;
        CommSenseLog.eWithMethodName(TAG, "skipped: application context is not an Application");
        return;
    L14:
        BackgroundProvider r11 = new BackgroundProvider();
        r11.onAppBackgroundSwitch(false);
        BDLocationAgent.updateSettings(this.appContext, getTestSettings());
        BDLocationAgent.init(new LocationInitConfig.Builder((Application) r8).setBaseUrl("https://os.obriccloud.com").setRestrictedMode(new AnonymousClass3(this)).setLocateType(3).setBackgroundProvider(r11).setALogPrinter(new AnonymousClass2(this)).isPrivacyConfirmed(true).setWorldView(DEFAULT_WORLD_VIEW).setLocal(Locale.CHINA).setAppId(r8.getPackageName()).setDid(r10).setBpeaCerts(null).setDebug(false).setCustomNetworkApi(new AnonymousClass1(this)).build());
        this.inited = BDLocationAgent.isInit();
        CommSenseLog.iWithMethodName(TAG, "finished, isInit=" + this.inited);
    }

    private boolean isLngLatPoint(p r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if ((r8 instanceof m) == false) goto L19;
        m r10 = r8.e();
        if (r10.size() >= 2) goto L10;
        return false;
    L10:
        p r11 = r10.o(0);
        r11.getClass();
        if ((r11 instanceof u) == false) goto L17;
        p r12 = r10.o(1);
        r12.getClass();
        if ((r12 instanceof u) == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    private boolean isLngLatPointArray(m r8) {
        if (r8.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<p> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (isLngLatPoint(r10.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    private boolean isPoiApiSuccess(Integer r8, String r10) {
        if (r8 != null) goto L4;
    L5:
        if (r8 == null) goto L7;
    L9:
        return false;
    L7:
        if ("success".equalsIgnoreCase(safeString(r10)) == false) goto L9;
    L8:
        return true;
    L4:
        if (r8.intValue() == 0) goto L8;
        goto L5
    }

    private boolean isPoiTypeChildKey(String r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ("children".equalsIgnoreCase(r8) == false) goto L8;
    L39:
        return true;
    L8:
        if ("child".equalsIgnoreCase(r8) == true) goto L39;
        if ("sub_types".equalsIgnoreCase(r8) == true) goto L39;
        if ("subTypes".equalsIgnoreCase(r8) == true) goto L39;
        if ("sub_type_list".equalsIgnoreCase(r8) == true) goto L39;
        if ("subTypeList".equalsIgnoreCase(r8) == true) goto L39;
        if ("type_list".equalsIgnoreCase(r8) == true) goto L39;
        if ("typeList".equalsIgnoreCase(r8) == true) goto L39;
        if ("types".equalsIgnoreCase(r8) == true) goto L39;
        if ("backend_type_list".equalsIgnoreCase(r8) == true) goto L39;
        if ("backendTypeList".equalsIgnoreCase(r8) == true) goto L39;
        if ("backend_type_datas".equalsIgnoreCase(r8) == true) goto L39;
        if ("backendTypeDatas".equalsIgnoreCase(r8) == true) goto L39;
        if ("backend_types".equalsIgnoreCase(r8) == true) goto L39;
        if ("backendTypes".equalsIgnoreCase(r8) == true) goto L39;
        if ("type_datas".equalsIgnoreCase(r8) == true) goto L39;
        if ("typeDatas".equalsIgnoreCase(r8) == true) goto L39;
        return false;
    }

    private boolean isPointObjectArray(m r8) {
        if (r8.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<p> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        p r11 = r10.next();
        if (r11 == null) goto L17;
        if ((r11 instanceof s) == false) goto L17;
        s r12 = r11.f();
        if (getFencePointLongitude(r12) == null) goto L17;
        if (getFencePointLatitude(r12) != null) goto L7;
    L17:
        return false;
    L18:
        return true;
    }

    private boolean isPrivacyIdAttestationCertExpired(p r8, int r10) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if ((r8 instanceof r) == false) goto L7;
        return false;
    L7:
        if (r10 > 3) goto L34;
        p r11 = parseJsonPayloadIfNeeded(r8);
        if (r11 != null) goto L12;
        return false;
    L12:
        if ((r11 instanceof s) == false) goto L35;
        s r12 = r11.f();
        Boolean r13 = getPrivacyIdAttestationCertExpiredResult(r12);
        if (r13 != null) goto L17;
        s r14 = normalizeEncryptedResponseEnvelope(r12, "POI_CERT_EXPIRED");
        Boolean r15 = getPrivacyIdAttestationCertExpiredResult(r14);
        if (r15 != null) goto L21;
        int r16 = r10 + 1;
        if (isPrivacyIdAttestationCertExpired(r14.p("data"), r16) == true) goto L29;
        if (isPrivacyIdAttestationCertExpired(r14.p("result"), r16) == true) goto L29;
        if (isPrivacyIdAttestationCertExpired(r14.p(WsConstants.KEY_CONNECTION_ERROR), r16) == true) goto L29;
        return false;
    L29:
        return true;
    L21:
        return r15.booleanValue();
    L17:
        return r13.booleanValue();
    L35:
        return false;
    L34:
        return false;
    }

    public static /* synthetic */ boolean j(BdLocationManager r8) {
        return r8.executeQueryPoiTypeDatas();
    }

    private String jsonElementToDbString(p r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if ((r8 instanceof r) == false) goto L7;
        return "";
    L7:
        if ((r8 instanceof u) == false) goto L11;
        return r8.j();
    L11:
        return r8.toString();
    }

    public static /* synthetic */ BmapDrivingDirectionResponse k(BdLocationManager r8, BmapDrivingDirectionRequest r10) {
        return r8.lambda$searchDrivingDirectionFromBmap$1(r10);
    }

    public static /* synthetic */ BmapWalkingDirectionResponse l(BdLocationManager r8, BmapWalkingDirectionRequest r10) {
        return r8.lambda$searchWalkingDirectionFromBmap$2(r10);
    }

    private /* synthetic */ PoiTextSearchResult lambda$performBdPoiTextSearch$8(String r8, int r10, int r11, String r12, String r13) {
        return executeBdPoiSearch(r8, r10, r11, r12, r13);
    }

    private /* synthetic */ PoiTextSearchResult lambda$performBdPoiTextSearch$9(String r8, int r10, int r11, String r12, String r13) {
        return executeBdPoiSearch(r8, r10, r11, r12, r13);
    }

    private /* synthetic */ Boolean lambda$queryCellsArea$4(List r8) {
        return Boolean.valueOf(executeQueryCellsArea(r8));
    }

    private /* synthetic */ Boolean lambda$queryCellsArea$5(List r8) {
        return Boolean.valueOf(executeQueryCellsArea(r8));
    }

    private /* synthetic */ List lambda$queryFencesByPoiId$7(List r8) {
        return executeQueryFencesByPoiIdInBatches(r8);
    }

    private /* synthetic */ BmapDrivingDirectionResponse lambda$searchDrivingDirectionFromBmap$1(BmapDrivingDirectionRequest r8) {
        return executeDrivingDirectionSearch(r8);
    }

    private /* synthetic */ MapPoiTextSearchResult lambda$searchMapPoiTextResult$6(String r8, int r10, int r11, String r12, String r13) {
        return executeSearchMapPoiText(r8, r10, r11, r12, r13);
    }

    private /* synthetic */ BmapRidingDirectionResponse lambda$searchRidingDirectionFromBmap$3(BmapRidingDirectionRequest r8) {
        return executeRidingDirectionSearch(r8);
    }

    private /* synthetic */ BmapTransitDirectionResponse lambda$searchTransitDirectionFromBmap$0(BmapTransitDirectionRequest r8) {
        return executeTransitDirectionSearch(r8);
    }

    private /* synthetic */ BmapWalkingDirectionResponse lambda$searchWalkingDirectionFromBmap$2(BmapWalkingDirectionRequest r8) {
        return executeWalkingDirectionSearch(r8);
    }

    private void logCellAoiTypeFilterResult(String r10, p r11) {
        m r12 = resolveJsonArray(r11);
        if (r12 != null) goto L5;
    L25:
        StringBuilder r8 = defpackage.b.h("CELL_GEO_PROFILE aoi filter, cell=", r10, ", rawCount=0, matchedCount=0");
    L26:
        CommSenseLog.iWithMethodName(TAG, r8.toString());
        return;
    L5:
        if (r12.isEmpty() == true) goto L25;
        Iterator<p> r13 = r12.iterator();
        int r14 = 0;
        String r15 = "";
    L9:
        if (r13.hasNext() == false) goto L24;
        p r16 = r13.next();
        if (r16 == null) goto L9;
        if ((r16 instanceof s) == false) goto L9;
        String r17 = getAoiTypeCode(r16.f());
        if (StarCellManager.isInterestedNewTypeCode(r17) == false) goto L9;
        r14 = r14 + 1;
        if (r15.length() >= 128) goto L9;
        if (r15.isEmpty() == true) goto L23;
        r15 = r15.concat(",");
    L23:
        r15 = defpackage.a.e(r15, r17);
        goto L9
    L24:
        r8 = defpackage.b.h("CELL_GEO_PROFILE aoi filter, cell=", r10, ", rawCount=");
        r8.append(r12.size());
        r8.append(", matchedCount=");
        r8.append(r14);
        r8.append(", matchedTypes=");
        r8.append(r15);
        goto L26
    }

    private void logCellProfileInfos(Context r8, List<StarCellManager.StarCellInfo> r10) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        StarAoiBoardManager r11 = StarAoiBoardManager.getInstance(r8, 0);
        Iterator<StarCellManager.StarCellInfo> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        StarCellManager.StarCellInfo r13 = r12.next();
        if (r13 == null) goto L7;
        r11.dumpPoiLog("cell_info: " + r13.toString());
        goto L7
    }

    private void logFirstCellAoiBoardEntry(List<StarLocationDbManager.CellAoiBoardEntry> r8) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        StarLocationDbManager.CellAoiBoardEntry r10 = r8.get(0);
        CommSenseLog.iWithMethodName(TAG, "CELL_GEO_PROFILE first aoi board, poiId=" + r10.getAoiBoard().getPoiId() + ", typeCode=" + r10.getTypeCode() + ", cells=" + r10.getCells());
    }

    private void logJsonPayload(String r8, String r10, p r11) {
        if (r11 != null) goto L5;
    L14:
        CommSenseLog.dWithMethodName(TAG, r8 + ": " + r10 + "=<empty>");
        return;
    L5:
        if ((r11 instanceof r) == true) goto L14;
        String[] r12 = sGsonPretty.i(r11).split("\n");     // Catch: Exception -> L11
        int r13 = r12.length;     // Catch: Exception -> L11
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L19;
        CommSenseLog.dWithMethodName(TAG, r8 + ": " + r10 + " " + r12[r14]);     // Catch: Exception -> L11
        r14 = r14 + 1;
        goto L8
    L19:
        return;
    L11:
        e = move-exception;
        CommSenseLog.dWithMethodName(TAG, r8 + ": " + r10 + " catch exception=" + e.getMessage());
    }

    private String logPoiResponseLogId(Map<String, List<String>> r8, String r10) {
        if (r8 != null) goto L5;
    L21:
        String r11 = null;
    L23:
        if (TextUtils.isEmpty(r11) == false) goto L26;
        String r12 = "POI response X-Tt-Logid is empty, url=" + r10;
        CommSenseLog.iWithMethodName(TAG, r12);
        StarPoiManager.getInstance().dumpPoiLog(r12);
        return null;
    L26:
        String r13 = "POI response X-Tt-Logid=" + r11 + ", url=" + r10;
        CommSenseLog.iWithMethodName(TAG, r13);
        StarPoiManager.getInstance().dumpPoiLog(r13);
        if (r10.contains(LOCATION_SUBMIT_PATH) == false) goto L29;
        this.mLastSdkLogId = r11;
    L29:
        return r11;
    L5:
        if (r8.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, List<String>>> r14 = r8.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L21;
        Map.Entry<String, List<String>> r15 = r14.next();
        if (r15 == null) goto L8;
        if (r15.getKey() == null) goto L8;
        if (X_TT_LOGID_HEADER.equalsIgnoreCase(r15.getKey()) == false) goto L8;
        List<String> r16 = r15.getValue();
        if (r16 == null) goto L21;
        if (r16.isEmpty() == true) goto L21;
        r11 = r16.get(0);
        goto L23
    }

    private boolean looksLikeDirectionPayload(s r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.t("status") == false) goto L8;
    L13:
        return true;
    L8:
        if (r8.t("result") == true) goto L13;
        if (r8.t("routes") == true) goto L13;
        if (r8.t("message") == true) goto L13;
        return false;
    }

    private void normalizeDirectionSteps(s r8) {
        if (r8.t("result") == false) goto L7;
        p r10 = r8.p("result");
        r10.getClass();
        if ((r10 instanceof s) == false) goto L7;
        s r11 = r8.r("result");
    L8:
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.t("routes") == false) goto L29;
        p r12 = r11.p("routes");
        r12.getClass();
        if ((r12 instanceof m) == false) goto L30;
        m r13 = r11.q("routes");
        int r14 = 0;
    L16:
        if (r14 >= r13.size()) goto L31;
        p r15 = r13.o(r14);
        if (r15 == null) goto L23;
        if ((r15 instanceof s) == false) goto L23;
        normalizeRouteSteps(r15.f());
    L23:
        r14 = r14 + 1;
        goto L16
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L7:
        r11 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private s normalizeEncryptedResponseEnvelope(s r8, String r10) {
        String r11 = null;
        if (r8.t("encrypt_data") == false) goto L8;
        p r12 = r8.p("encrypt_data");
        r12.getClass();
        if ((r12 instanceof u) == false) goto L8;
        p r13 = r8.p("encrypt_data");
    L24:
        String r14 = r13.j();
    L27:
        if (TextUtils.isEmpty(r14) == false) goto L60;
        return r8;
    L60:
        byte[] r15 = Base64.decode(r14, 0);     // Catch: Throwable -> L38
        if (LocationUtil.getInstance().ensureCloudTransCryptoManagerReady() == true) goto L34;
        CommSenseLog.wWithMethodName(TAG, r10 + ": Crypto SDK not ready");     // Catch: Throwable -> L38
        return r8;
    L34:
        byte[] r16 = n6.b.e().a(r15);     // Catch: Throwable -> L38
        if (r16 == null) goto L41;
        r11 = new String(r16, "UTF-8");     // Catch: Throwable -> L38
    L41:
        if (TextUtils.isEmpty(r11) == false) goto L43;
        return r8;
    L43:
        p r17 = parseJsonElement(r11);
        if (r17 != null) goto L48;
        CommSenseLog.eWithMethodName(TAG, r10 + ": failed to parse decrypted response");
        return r8;
    L48:
        if (r8.t("data") == false) goto L51;
    L58:
        r8.k("data", r17);
    L59:
        return r8;
    L51:
        if (r8.t("encrypt_data") == false) goto L59;
        if ((r17 instanceof s) == false) goto L58;
        ja.s.b.a r18 = new ja.s.b.a(r17.f().o());
    L56:
        if (r18.hasNext() == false) goto L59;
        ja.s.e<K, V> r19 = r18.a();
        r8.k((String) r19.f8804p, (p) r19.f8806r);
    L38:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, r10 + ": Decrypt failed", th);
    L8:
        if (r8.t("data") == false) goto L25;
        r13 = r8.p("data");
        if (r13 != null) goto L12;
    L16:
        if (r13 == null) goto L25;
        if ((r13 instanceof s) == false) goto L25;
        if (r13.f().t("encrypt_data") == false) goto L25;
        p r20 = r13.f().p("encrypt_data");
        r20.getClass();
        if ((r20 instanceof u) == false) goto L25;
        r13 = r13.f().p("encrypt_data");
        goto L24
    L12:
        if ((r13 instanceof u) == false) goto L16;
        if ((r13.g().f8004a instanceof String) == false) goto L16;
    L25:
        r14 = null;
        goto L27
    }

    private String normalizeJsonKey(String r8) {
        return r8.replace("_", "").replace("-", "").toLowerCase(Locale.US);
    }

    private String normalizeMapPoiRegion(String r8) {
        String r10 = safeString(r8).trim();
        if (r10.length() > 1) goto L5;
        return r10;
    L5:
        if (r10.endsWith("市") == true) goto L7;
        return r10;
    L7:
        return r10.substring(0, r10.length() - 1);
    }

    private p normalizePoiApiResponsePayload(p r8, String r10) {
        if (r8 != null) goto L5;
    L21:
        return null;
    L5:
        if ((r8 instanceof s) == false) goto L21;
        s r11 = normalizeEncryptedResponseEnvelope(r8.f(), r10);
        Integer r12 = getIntByKeys(r11, new String[]{"code"});
        if (r12 != null) goto L10;
    L13:
        p r13 = r11.p("data");
        if (r13 != null) goto L16;
    L20:
        StringBuilder r14 = android.aimedia.a.k(r10, ": response data is missing, keys=");
        r14.append(describeJsonObjectKeys(r11));
        CommSenseLog.eWithMethodName(TAG, r14.toString());
        goto L21
    L16:
        if ((r13 instanceof r) == true) goto L20;
        return parseJsonPayloadIfNeeded(r13);
    L10:
        if (r12.intValue() == 0) goto L13;
        CommSenseLog.wWithMethodName(TAG, r10 + ": response code=" + r12 + ", msg=" + safeString(getStringByKeys(r11, new String[]{"msg", "message"})));
        return null;
    }

    private List<String> normalizePoiIdList(List<String> r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L18:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L18;
        Iterator<String> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L9;
        String r13 = r12.trim();
        if (r13.isEmpty() == true) goto L9;
        if (r10.contains(r13) == true) goto L9;
        r10.add(r13);
        goto L9
    }

    private s normalizePoiSearchResponseEnvelope(s r11, String r12) {
        CommsenseTextSearchResponse r8 = null;
        if (r11.t("encrypt_data") == false) goto L8;
        p r10 = r11.p("encrypt_data");
        r10.getClass();
        if ((r10 instanceof u) == false) goto L8;
        p r13 = r11.p("encrypt_data");
    L18:
        String r14 = r13.j();
    L27:
        if (TextUtils.isEmpty(r14) == true) goto L79;
        String r15 = decryptEncryptedString(r14, r12);
        if (TextUtils.isEmpty(r15) == true) goto L79;
        p r16 = l6.a.z0(r15);     // Catch: Exception -> L77
        r8 = (CommsenseTextSearchResponse) sGson.c(CommsenseTextSearchResponse.class, r15);     // Catch: Exception -> L80
    L34:
        if (r8 == null) goto L41;
        Integer r17 = r8.code;     // Catch: Exception -> L77
        if (r17 == null) goto L38;
        r11.m("code", r17);     // Catch: Exception -> L77
    L38:
        String r18 = r8.msg;     // Catch: Exception -> L77
        if (r18 == null) goto L41;
        r11.n("msg", r18);     // Catch: Exception -> L77
    L41:
        boolean r19 = true;
        if (r8 == null) goto L57;
        CommonLocationTextSearchResponseData r20 = r8.data;     // Catch: Exception -> L77
        if (r20 == null) goto L57;
        List<CommonPOIInfo> r21 = r20.poiList;     // Catch: Exception -> L77
        if (r21 == null) goto L57;
        if (r21.isEmpty() == true) goto L57;
        j r22 = sGson;     // Catch: Exception -> L77
        CommonLocationTextSearchResponseData r23 = r8.data;     // Catch: Exception -> L77
        r22.getClass();     // Catch: Exception -> L77
        if (r23 != null) goto L52;
        p r24 = r.f8002a;     // Catch: Exception -> L77
    L53:
        r11.k("data", r24);     // Catch: Exception -> L77
        if (r11.t("code") == true) goto L56;
        r11.m("code", 0);     // Catch: Exception -> L77
    L56:
        boolean r25 = true;
    L58:
        if (r25 == true) goto L65;
        s r26 = buildNormalizedPoiSearchData(r16);     // Catch: Exception -> L77
        if (r26 == null) goto L65;
        r11.k("data", r26);     // Catch: Exception -> L77
        if (r11.t("code") == true) goto L64;
        r11.m("code", 0);     // Catch: Exception -> L77
    L64:
        r25 = true;
    L65:
        if (r25 == false) goto L67;
    L73:
        r19 = r25;
    L74:
        if (r19 == true) goto L79;
        CommSenseLog.wWithMethodName(TAG, r12 + ": unsupported poi payload shape after normalization");     // Catch: Exception -> L77
        goto L79
    L67:
        if (r11.t("data") == true) goto L73;
        s r110 = buildNormalizedPoiSearchData(r11);     // Catch: Exception -> L77
        if (r110 == null) goto L73;
        r11.k("data", r110);     // Catch: Exception -> L77
        if (r11.t("code") == true) goto L74;
        r11.m("code", 0);     // Catch: Exception -> L77
        goto L74
    L52:
        Class<?> r27 = r23.getClass();     // Catch: Exception -> L77
        g r28 = new g();     // Catch: Exception -> L77
        r22.l(r23, r27, r28);     // Catch: Exception -> L77
        r24 = r28.K();     // Catch: Exception -> L77
    L57:
        r25 = false;
    L77:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, r12 + ": Failed to parse decrypted data", e);
    L79:
        return r11;
    L8:
        if (r11.t("data") == false) goto L25;
        p r29 = r11.p("data");
        if (r29 != null) goto L12;
    L19:
        if (r29 == null) goto L25;
        if ((r29 instanceof u) == false) goto L25;
        if ((r29.g().f8004a instanceof String) == false) goto L25;
        r14 = r29.j();
        goto L27
    L12:
        if ((r29 instanceof s) == false) goto L19;
        s r30 = r29.f();
        if (r30.t("encrypt_data") == false) goto L25;
        p r31 = r30.p("encrypt_data");
        r31.getClass();
        if ((r31 instanceof u) == false) goto L25;
        r13 = r30.p("encrypt_data");
    L25:
        r14 = null;
        goto L27
    }

    private void normalizeRouteSteps(s r8) {
        if (r8.t("steps") == true) goto L5;
        return;
    L5:
        p r10 = r8.p("steps");
        if (r10 != null) goto L8;
        return;
    L8:
        if ((r10 instanceof r) == false) goto L11;
        return;
    L11:
        if ((r10 instanceof s) == false) goto L15;
        m r11 = new m();
        r11.k(r10);
        m r12 = new m();
        r12.k(r11);
        r8.k("steps", r12);
        return;
    L15:
        if ((r10 instanceof m) == true) goto L17;
        return;
    L17:
        m r13 = r10.e();
        if (r13.size() != 0) goto L20;
        return;
    L20:
        p r14 = r13.o(0);
        if (r14 != null) goto L23;
        return;
    L23:
        if ((r14 instanceof s) == false) goto L28;
        m r15 = new m();
        r15.k(r13.n());
        r8.k("steps", r15);
        return;
    }

    private String parseAndConvertAoiBoardGeometry(p r8) {
        return AoiBoardUtil.parseAndConvertGeoJsonAoiBoard(r8);
    }

    private StarCellDbManager.InnerCellInfoEntry parseCellProfile(StarCellManager.StarCellInfo r19, m r20, Map<String, CellAoiBoardAccumulator> r21, List<StarCellManager.StarCellInfo> r22) {
        Iterator<p> r8 = r20.iterator();
    L4:
        if (r8.hasNext() == false) goto L33;
        p r10 = r8.next();
        if (r10 == null) goto L4;
        if ((r10 instanceof s) == false) goto L4;
        s r11 = r10.f();
        String r12 = getStringByKeys(r11, new String[]{"Name", "name"});
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (CELL_GEO_PROFILE_NAME.equals(r12) == false) goto L4;
    L15:
        p r13 = getValueByKeyCompat(r11, "Attributes");
        if (r13 == null) goto L4;
        if ((r13 instanceof s) == false) goto L4;
        s r14 = r13.f();
        p r15 = getValueByKeyCompat(r14, "aoi_list");
        logCellAoiTypeFilterResult(r19.toCellString(), r15);
        collectCellAoiBoards(r21, r19.toCellString(), r15);
        Double r16 = getDoubleByKeys(r14, new String[]{"latitude"});
        Double r17 = getDoubleByKeys(r14, new String[]{StarCellDbManager.CellInfoEntry.LONGITUDE});
        Double r18 = getDoubleByKeys(r14, new String[]{"radius"});
        if (r16 == null) goto L30;
        if (r17 == null) goto L30;
        if (r18 == null) goto L30;
        StarCellDbManager.InnerCellInfoEntry r110 = new StarCellDbManager.InnerCellInfoEntry(r19.getType(), r19.getMcc(), r19.getMnc(), r19.getLac(), r19.getCid());
        if (LocationUtil.getInstance().isValidCoordinate(r16.doubleValue(), r17.doubleValue()) == true) goto L28;
        StringBuilder r23 = new StringBuilder("skip profile with invalid location, cell=");
        r23.append(r19.toCellString());
    L31:
        CommSenseLog.dWithMethodName(TAG, r23.toString());
        r8 = r8;
        goto L4
    L28:
        r110.setLatitude(r16.doubleValue());
        r110.setLongitude(r17.doubleValue());
        r110.setRadius(r18.doubleValue());
        r110.setPois(getStringByKeys(r14, new String[]{"poi_list"}));
        r110.setAois(buildAoiIdListString(r15));
        r22.add(r19.withLocation(r16.doubleValue(), r17.doubleValue(), r18.doubleValue()));
        return r110;
    L30:
        r23 = new StringBuilder("skip profile without location attrs, cell=");
        r23.append(r19.toCellString());
        goto L31
    L33:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CellsAreaParseResult parseCellsAreaResponse(String r10, List<StarCellManager.StarCellInfo> r11) {
        ArrayList r8 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Map<String, CellAoiBoardAccumulator> r13 = new LinkedHashMap();
        p r14 = parseJsonElementLenient(r10);
        AnonymousClass1 r15 = null;
        if (r14 != null) goto L5;
    L45:
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json");
        return new CellsAreaParseResult(r8, buildCellAoiBoardEntries(r13), r12, r15);
    L5:
        if ((r14 instanceof s) == false) goto L45;
        p r16 = normalizePoiApiResponsePayload(r14, "CELL_GEO_PROFILE");
        if (r16 != null) goto L10;
    L43:
        CommSenseLog.eWithMethodName(TAG, "response payload is not json object");
        return new CellsAreaParseResult(r8, buildCellAoiBoardEntries(r13), r12, r15);
    L10:
        if ((r16 instanceof s) == false) goto L43;
        s r17 = r16.f();
        p r18 = r17.p("profiles_map");
        if (r18 != null) goto L15;
    L41:
        CommSenseLog.eWithMethodName(TAG, "profiles_map is missing, payload keys=" + describeJsonObjectKeys(r17));
        return new CellsAreaParseResult(r8, buildCellAoiBoardEntries(r13), r12, r15);
    L15:
        if ((r18 instanceof s) == false) goto L41;
        HashMap r19 = new HashMap();
        Iterator<StarCellManager.StarCellInfo> r110 = r11.iterator();
    L19:
        if (r110.hasNext() == false) goto L23;
        StarCellManager.StarCellInfo r20 = r110.next();
        if (r20 == null) goto L19;
        r19.put(r20.toCellString(), r20);
        goto L19
    L23:
        ja.s.b.a r21 = new ja.s.b.a(r18.f().o());
    L25:
        if (r21.hasNext() == false) goto L40;
        ja.s.e<K, V> r111 = r21.a();
        String r22 = (String) r111.f8804p;
        StarCellManager.StarCellInfo r23 = (StarCellManager.StarCellInfo) r19.get(r22);
        if (r23 == null) goto L28;
        p r112 = (p) r111.f8806r;
        if (r112 == null) goto L38;
        if ((r112 instanceof m) == false) goto L38;
        StarCellDbManager.InnerCellInfoEntry r113 = parseCellProfile(r23, r112.e(), r13, r12);
        if (r113 != null) goto L37;
        r113 = createEmptyCellInfoEntry(r23);
        r12.add(r23);
    L37:
        r8.add(r113);
    L38:
        r8.add(createEmptyCellInfoEntry(r23));
        r12.add(r23);
        goto L25
    L28:
        CommSenseLog.dWithMethodName(TAG, "ignore unexpected cell id=" + r22);
        goto L25
    L40:
        return new CellsAreaParseResult(r8, buildCellAoiBoardEntries(r13), r12, r15);
    }

    private BmapDrivingDirectionResponse parseDrivingDirectionResponse(s r8) {
        s r10 = findDirectionPayload(r8);
        if (r10 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "failed to find driving payload, root keys=" + r8.u());
        return null;
    L6:
        sanitizeDrivingNumericFields(r10);
        j r11 = sGson;
        monitor-enter(r11);
        BmapDrivingDirectionResponse r12 = (BmapDrivingDirectionResponse) r11.b(r10, BmapDrivingDirectionResponse.class);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        if (r12 != null) goto L13;
        return null;
    L13:
        if (r12.status != null) goto L22;
        Integer r13 = extractStatusCode(r10);
        r12.status = r13;
        if (r13 != null) goto L17;
    L18:
        Integer r14 = extractStatusCode(r8);
        if (r14 == null) goto L22;
        r12.status = r14;
        goto L22
    L17:
        if (r13.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r12.message) == false) goto L27;
        String r15 = extractMessage(r10);
        r12.message = r15;
        if (TextUtils.isEmpty(r15) == false) goto L27;
        r12.message = extractMessage(r8);
    L27:
        if (r12.result == null) goto L29;
    L39:
        StringBuilder r16 = new StringBuilder("normalized payload keys=");
        r16.append(r10.u());
        r16.append(", status=");
        r16.append(r12.status);
        r16.append(", message=");
        r16.append(r12.message);
        r16.append(", hasResult=");
        if (r12.result == null) goto L42;
        boolean r17 = true;
    L43:
        r16.append(r17);
        CommSenseLog.iWithMethodName(TAG, r16.toString());
        return r12;
    L42:
        r17 = false;
        goto L43
    L29:
        if (r10.t("result") == false) goto L39;
        p r18 = r10.p("result");
        r18.getClass();
        if ((r18 instanceof s) == false) goto L39;
        monitor-enter(r11);
        r12.result = (BmapDrivingDirectionResult) r11.b(r10.r("result"), BmapDrivingDirectionResult.class);     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private List<PoiFenceInfo> parseGetFencesResponse(String r8) {
        p r10 = parseJsonElementLenient(r8);
        if (r10 != null) goto L5;
    L35:
        CommSenseLog.eWithMethodName(TAG, "GET_FENCES: response is not a valid json");
        return new ArrayList();
    L5:
        if ((r10 instanceof s) == false) goto L35;
        p r11 = normalizePoiApiResponsePayload(r10, "GET_FENCES");
        if (r11 != null) goto L10;
    L33:
        CommSenseLog.eWithMethodName(TAG, "GET_FENCES: response payload is not json object");
        return new ArrayList();
    L10:
        if ((r11 instanceof s) == false) goto L33;
        s r12 = r11.f();
        p r13 = r12.p("fences");
        if (r13 != null) goto L15;
    L25:
        Integer r14 = getIntByKeys(r12, new String[]{LBSLightLocationTraceLogger.TOTAL});
        if (r14 != null) goto L28;
    L31:
        CommSenseLog.eWithMethodName(TAG, "GET_FENCES: fences is missing");
        return new ArrayList();
    L28:
        if (r14.intValue() != 0) goto L31;
        CommSenseLog.dWithMethodName(TAG, "GET_FENCES: empty result");
        return new ArrayList();
    L15:
        if ((r13 instanceof m) == false) goto L25;
        ArrayList r15 = new ArrayList();
        Iterator<p> r16 = r13.e().iterator();
    L19:
        if (r16.hasNext() == false) goto L23;
        PoiFenceInfo r17 = parsePoiFenceInfo(r16.next());
        if (r17 == null) goto L19;
        r15.add(r17);
        goto L19
    L23:
        CommSenseLog.iWithMethodName(TAG, "GET_FENCES: parsed count=" + r15.size());
        return r15;
    }

    private int parseIntExtra(Map<String, String> r8, String r10, int r11) {
        String r12 = r8.get(r10);
        if (r12 != null) goto L9;
        return r11;
    L9:
        return Integer.parseInt(r12);
    L7:
        CommSenseLog.wWithMethodName(TAG, "invalid int extra " + r10 + "=" + r12);
        return r11;
    }

    private p parseJsonElement(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L14;
        return null;
    L14:
        return l6.a.z0(r8);
    L7:
        int r10 = r8.indexOf("}{");
        if (r10 != (-1)) goto L16;
        return null;
    L16:
        return l6.a.z0(r8.substring(r10 + 1));
    L13:
        return null;
    }

    private p parseJsonElementLenient(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        p r10 = parseJsonElement(r8);
        if (r10 == null) goto L30;
        return r10;
    L30:
        pa.a r11 = new pa.a(new StringReader(r8));     // Catch: Exception -> L11
        r11.f9952b = true;     // Catch: Exception -> L11
        return l6.a.y0(r11);
    L11:
        int r12 = r8.indexOf(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID);
        int r13 = r8.lastIndexOf(125);
        if (r12 < 0) goto L17;
        if (r13 <= r12) goto L17;
        pa.a r14 = new pa.a(new StringReader(r8.substring(r12, r13 + 1)));     // Catch: Exception -> L24
        r14.f9952b = true;     // Catch: Exception -> L24
        return l6.a.y0(r14);
    L17:
        int r15 = r8.indexOf(91);
        int r16 = r8.lastIndexOf(93);
        if (r15 < 0) goto L23;
        if (r16 <= r15) goto L23;
        pa.a r17 = new pa.a(new StringReader(r8.substring(r15, r16 + 1)));     // Catch: Exception -> L25
        r17.f9952b = true;     // Catch: Exception -> L25
        return l6.a.y0(r17);
    L23:
        return null;
    }

    private p parseJsonPayloadIfNeeded(p r8) {
        if (r8 != null) goto L4;
        return r8;
    L4:
        if ((r8 instanceof u) == true) goto L6;
        return r8;
    L6:
        if ((r8.g().f8004a instanceof String) == false) goto L14;
        p r10 = parseJsonElementLenient(r8.j());
        if (r10 != null) goto L11;
        return r8;
    L11:
        return r10;
    L14:
        return r8;
    }

    private long parseLongExtra(Map<String, String> r8, String r10, long r11) {
        String r12 = r8.get(r10);
        if (r12 != null) goto L9;
        return r11;
    L9:
        return Long.parseLong(r12);
    L7:
        CommSenseLog.wWithMethodName(TAG, "invalid long extra " + r10 + "=" + r12);
        return r11;
    }

    private MapPoiInfo parseMapPoiInfo(p r20) {
        if (r20 != null) goto L5;
        return null;
    L5:
        if ((r20 instanceof s) == false) goto L23;
        s r8 = r20.f();
        s r10 = getJsonObjectByKey(r8, "map_val");
        if (r10 != null) goto L10;
        r10 = r8;
    L10:
        String r11 = safeString(getStringByKeys(r10, new String[]{"id"}));
        if (TextUtils.isEmpty(r11) == false) goto L13;
        return null;
    L13:
        s r12 = getJsonObjectByKey(r8, "geo_json");
        if (r12 != null) goto L17;
        if (r10 == r8) goto L17;
        r12 = getJsonObjectByKey(r10, "geo_json");
    L17:
        if (r12 != null) goto L19;
        String r13 = "";
    L20:
        String r14 = r13;
        double[] r15 = parseMapPoiWgs84Location(r10);
        return new MapPoiInfo(r11, safeString(getStringByKeys(r10, new String[]{"name"})), safeString(getStringByKeys(r10, new String[]{"province"})), safeString(getStringByKeys(r10, new String[]{"city"})), safeString(getStringByKeys(r10, new String[]{"district"})), safeString(getStringByKeys(r10, new String[]{StarLocationDbManager.GeofenceEntry.ADDRESS})), safeString(getStringByKeys(r10, new String[]{"type_code"})), safeString(getStringByKeys(r10, new String[]{"type_name"})), r14, r15[0], r15[1]);
    L19:
        r13 = buildAoiBoardFromMapPoiGeoJson(r12);
        goto L20
    L23:
        return null;
    }

    private MapPoiTextSearchResult parseMapPoiTextSearchResponse(String r8) {
        p r10 = parseJsonElementLenient(r8);
        int r11 = 0;
        if (r10 != null) goto L5;
    L32:
        CommSenseLog.eWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: response is not a valid json");
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "invalid json");
    L5:
        if ((r10 instanceof s) == false) goto L32;
        s r12 = normalizeEncryptedResponseEnvelope(r10.f(), "TEXT_SEARCH_MAP_POI");
        Integer r13 = getIntByKeys(r12, new String[]{"code"});
        String r14 = safeString(getStringByKeys(r12, new String[]{"msg", "message"}));
        p r15 = findMapPoiCellsElement(r12);
        if (r15 == null) goto L27;
        if ((r15 instanceof r) == true) goto L27;
        if ((r15 instanceof m) == true) goto L16;
        CommSenseLog.eWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: cells is not json array");
        return new MapPoiTextSearchResult(false, new ArrayList(), r13, r14);
    L16:
        ArrayList r16 = new ArrayList();
        Iterator<p> r17 = r15.e().iterator();
    L18:
        if (r17.hasNext() == false) goto L24;
        MapPoiInfo r18 = parseMapPoiInfo(r17.next());
        if (r18 == null) goto L18;
        r16.add(r18);
        if (TextUtils.isEmpty(r18.aoiBoard) == true) goto L18;
        r11 = r11 + 1;
        goto L18
    L24:
        CommSenseLog.iWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: parsed count=" + r16.size() + ", aoiBoardCount=" + r11);
        return new MapPoiTextSearchResult(true, r16, r13, r14);
    L27:
        if (isPoiApiSuccess(r13, r14) == false) goto L30;
        CommSenseLog.dWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: cells is missing, treat as empty page, keys=" + describeJsonObjectKeys(r12));
        return new MapPoiTextSearchResult(true, new ArrayList(), r13, r14);
    L30:
        CommSenseLog.eWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: response cells is missing, keys=" + describeJsonObjectKeys(r12));
        return new MapPoiTextSearchResult(false, new ArrayList(), r13, r14);
    }

    private double[] parseMapPoiWgs84Location(s r8) {
        Double r10 = getDoubleByKeys(r8, new String[]{"latitude"});
        Double r11 = getDoubleByKeys(r8, new String[]{StarCellDbManager.CellInfoEntry.LONGITUDE});
        if (r10 == null) goto L9;
        if (r11 == null) goto L9;
        Location r12 = convertGcj02ToWgs84(r10.doubleValue(), r11.doubleValue());
        if (r12 == null) goto L9;
        return new double[]{r12.getLatitude(), r12.getLongitude()};
    L9:
        return new double[]{Double.NaN, Double.NaN};
    }

    private Bundle parseNearPoiDataBundle(p r20, String r21) {
        r20.getClass();
        if ((r20 instanceof s) == true) goto L6;
        CommSenseLog.eWithMethodName(TAG, "near poi response is not json object");
        return null;
    L6:
        p r8 = normalizePoiApiResponsePayload(r20, "NEAR_POI_DATA");
        if (r8 != null) goto L9;
    L62:
        CommSenseLog.eWithMethodName(TAG, "near poi data is missing");
        return null;
    L9:
        if ((r8 instanceof s) == false) goto L62;
        s r10 = r8.f();
        p r11 = getValueByKeyCompat(r10, StarCellDbManager.CellInfoEntry.POIS);
        if (r11 != null) goto L14;
    L22:
        s r12 = null;
    L23:
        p r13 = getValueByKeyCompat(r10, StarCellDbManager.CellInfoEntry.AOIS);
        if (r13 != null) goto L26;
    L34:
        s r14 = null;
    L35:
        String r15 = getNearPoiName(r12);
        String r16 = getNearPoiAwemeId(r12);
        Double r17 = getNearPoiConfidence(r12);
        Integer r18 = getNearPoiAccQualified(r12);
        String r19 = getNearPoiName(r14);
        String r110 = getNearPoiAwemeId(r14);
        Double r111 = getNearPoiConfidence(r14);
        if (TextUtils.isEmpty(r15) == true) goto L38;
    L41:
        Bundle r112 = new Bundle();
        Long r22 = getLongByKeys(r10, new String[]{"timestamp"});
        if (r22 != null) goto L44;
    L47:
        long r113 = System.currentTimeMillis();
    L48:
        r112.putLong("timestamp", r113);
        if (r18 != null) goto L51;
        int r23 = 1;
    L52:
        r112.putInt("is_acc_qualified_poi", r23);
        if (r12 == null) goto L55;
        boolean r24 = true;
    L56:
        r112.putString(IStarPoiCallback.NEAR_THE_POI, String.valueOf(r24));
        if (r14 == null) goto L59;
        boolean r25 = true;
    L60:
        r112.putString(IStarPoiCallback.NEAR_THE_AOI, String.valueOf(r25));
        putNearPoiLogIdsIfComplete(r112, this.mLastSdkLogId, r21);
        putStringIfNotEmpty(r112, "poi_name", r15);
        putNearPoiIdentityIfComplete(r112, "poi_id", IStarPoiCallback.POI_CONFIDENCE, r16, r17);
        putStringIfNotEmpty(r112, "aoi_name", r19);
        putNearPoiIdentityIfComplete(r112, IStarPoiCallback.AOI_ID, IStarPoiCallback.AOI_CONFIDENCE, r110, r111);
        fillNearPoiTypeData(r112, r12, r14);
        return r112;
    L59:
        r25 = false;
        goto L60
    L55:
        r24 = false;
        goto L56
    L51:
        r23 = r18.intValue();
        goto L52
    L44:
        if (r22.longValue() <= 0) goto L47;
        r113 = r22.longValue();
        goto L48
    L38:
        if (TextUtils.isEmpty(r19) == false) goto L41;
        CommSenseLog.iWithMethodName(TAG, "near poi data has no valid poi or aoi");
        return null;
    L26:
        if ((r13 instanceof m) == false) goto L34;
        m r26 = r13.e();
        if (r26.size() <= 0) goto L34;
        p r27 = r26.o(0);
        if (r27 == null) goto L34;
        if ((r27 instanceof s) == false) goto L34;
        r14 = r27.f();
        goto L35
    L14:
        if ((r11 instanceof m) == false) goto L22;
        m r28 = r11.e();
        if (r28.size() <= 0) goto L22;
        p r29 = r28.o(0);
        if (r29 == null) goto L22;
        if ((r29 instanceof s) == false) goto L22;
        r12 = r29.f();
        goto L23
    }

    private PoiFenceInfo parsePoiFenceInfo(p r8) {
        if (r8 != null) goto L5;
    L23:
        return null;
    L5:
        if ((r8 instanceof s) == false) goto L23;
        s r10 = r8.f();
        s r11 = getJsonObjectByKey(r10, "properties");
        String r12 = "";
        if (r11 != null) goto L10;
        String r13 = "";
    L12:
        if (TextUtils.isEmpty(r13) == false) goto L14;
        return null;
    L14:
        if (r11 == null) goto L17;
        r12 = safeString(getStringByKeys(r11, new String[]{"name"}));
    L17:
        String r14 = safeString(getStringByKeys(r10, new String[]{"fenceid"}));
        String r15 = buildAoiBoardFromFence(r10);
        if (TextUtils.isEmpty(r15) == false) goto L22;
        CommSenseLog.dWithMethodName(TAG, "GET_FENCES: skip fence without valid aoi board, poiId=" + r13);
        return null;
    L22:
        return new PoiFenceInfo(r13, r12, r14, r15);
    L10:
        r13 = safeString(getStringByKeys(r11, new String[]{"aweme_id"}));
        goto L12
    }

    private CommsenseTextSearchResponse parsePoiTextSearchResponse(String r10, String r11) {
        CommonLocationTextSearchResponseData r8 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        j r12 = sGson;
        monitor-enter(r12);
        p r13 = parseJsonElement(r10);     // Catch: Throwable -> L95 Exception -> L97
        if (r13 != null) goto L10;
    L13:
        if (r13 == null) goto L16;
        Object r14 = r12.b(r13, CommsenseTextSearchResponse.class);     // Catch: Throwable -> L95 Exception -> L97
    L12:
        CommsenseTextSearchResponse r15 = (CommsenseTextSearchResponse) r14;     // Catch: Throwable -> L95 Exception -> L97
    L17:
        if (r15 != null) goto L19;
    L105:
        p r16 = parseJsonElementLenient(r10);     // Catch: Exception -> L91 Throwable -> L95
        if (r16 != null) goto L23;
    L93:
        monitor-exit(r12);     // Catch: Throwable -> L95
        return r15;
    L23:
        if ((r16 instanceof s) == false) goto L93;
        s r17 = normalizePoiSearchResponseEnvelope(r16.f(), r11);     // Catch: Exception -> L91 Throwable -> L95
        if (r17.t("code") == false) goto L31;
        p r18 = r17.p("code");     // Catch: Exception -> L91 Throwable -> L95
        r18.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r18 instanceof r) == true) goto L31;
        int r19 = r17.p("code").d();     // Catch: Exception -> L91 Throwable -> L95
    L29:
        Integer r20 = Integer.valueOf(r19);     // Catch: Exception -> L91 Throwable -> L95
    L52:
        if (r17.t("msg") == false) goto L58;
        p r21 = r17.p("msg");     // Catch: Exception -> L91 Throwable -> L95
        r21.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r21 instanceof r) == true) goto L58;
        p r22 = r17.p("msg");     // Catch: Exception -> L91 Throwable -> L95
    L56:
        String r23 = r22.j();     // Catch: Exception -> L91 Throwable -> L95
    L69:
        if (r17.t("data") == false) goto L89;
        p r24 = r17.p("data");     // Catch: Exception -> L91 Throwable -> L95
        r24.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r24 instanceof r) == true) goto L89;
        p r25 = r17.p("data");     // Catch: Exception -> L91 Throwable -> L95
        r8 = (CommonLocationTextSearchResponseData) r12.b(r25, CommonLocationTextSearchResponseData.class);     // Catch: Exception -> L91 Throwable -> L95
        if (r8 != null) goto L75;
    L76:
        r25.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r25 instanceof s) == false) goto L89;
        s r26 = r25.f();     // Catch: Exception -> L91 Throwable -> L95
        if (r26.t("poiList") == false) goto L89;
        p r27 = r26.p("poiList");     // Catch: Exception -> L91 Throwable -> L95
        r27.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r27 instanceof m) == false) goto L89;
        ArrayList r28 = new ArrayList();     // Catch: Exception -> L91 Throwable -> L95
        Iterator<p> r29 = r26.p("poiList").e().iterator();     // Catch: Exception -> L91 Throwable -> L95
    L84:
        if (r29.hasNext() == false) goto L86;
        r28.add((CommonPOIInfo) sGson.b(r29.next(), CommonPOIInfo.class));     // Catch: Exception -> L91 Throwable -> L95
        goto L84
    L86:
        if (r8 != null) goto L88;
        r8 = new CommonLocationTextSearchResponseData();     // Catch: Exception -> L91 Throwable -> L95
    L88:
        r8.poiList = r28;     // Catch: Exception -> L91 Throwable -> L95
        goto L89
    L75:
        if (r8.poiList == null) goto L76;
    L89:
        CommsenseTextSearchResponse r30 = new CommsenseTextSearchResponse();     // Catch: Exception -> L91 Throwable -> L95
        r30.code = r20;     // Catch: Exception -> L91 Throwable -> L95
        r30.msg = r23;     // Catch: Exception -> L91 Throwable -> L95
        r30.data = r8;     // Catch: Exception -> L91 Throwable -> L95
        r15 = r30;
        goto L93
    L58:
        if (r17.t("message") == false) goto L63;
        p r31 = r17.p("message");     // Catch: Exception -> L91 Throwable -> L95
        r31.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r31 instanceof r) == true) goto L63;
        r22 = r17.p("message");     // Catch: Exception -> L91 Throwable -> L95
    L63:
        if (r17.t("error_msg") == false) goto L67;
        p r32 = r17.p("error_msg");     // Catch: Exception -> L91 Throwable -> L95
        r32.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r32 instanceof r) == true) goto L67;
        r22 = r17.p("error_msg");     // Catch: Exception -> L91 Throwable -> L95
    L67:
        r23 = null;
    L31:
        if (r17.t("errno") == false) goto L36;
        p r33 = r17.p("errno");     // Catch: Exception -> L91 Throwable -> L95
        r33.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r33 instanceof r) == true) goto L36;
        r19 = r17.p("errno").d();     // Catch: Exception -> L91 Throwable -> L95
    L36:
        if (r17.t("status") == false) goto L41;
        p r34 = r17.p("status");     // Catch: Exception -> L91 Throwable -> L95
        r34.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r34 instanceof r) == true) goto L41;
        r19 = r17.p("status").d();     // Catch: Exception -> L91 Throwable -> L95
    L41:
        if (r17.t("ret") == false) goto L46;
        p r35 = r17.p("ret");     // Catch: Exception -> L91 Throwable -> L95
        r35.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r35 instanceof r) == true) goto L46;
        r19 = r17.p("ret").d();     // Catch: Exception -> L91 Throwable -> L95
    L46:
        if (r17.t("error_code") == false) goto L50;
        p r36 = r17.p("error_code");     // Catch: Exception -> L91 Throwable -> L95
        r36.getClass();     // Catch: Exception -> L91 Throwable -> L95
        if ((r36 instanceof r) == true) goto L50;
        r19 = r17.p("error_code").d();     // Catch: Exception -> L91 Throwable -> L95
    L50:
        r20 = null;
    L91:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, r11 + ": Fallback parse failed", e);     // Catch: Throwable -> L95
        goto L93
    L19:
        if (r15.code != null) goto L93;
    L16:
        r15 = null;
        goto L17
    L10:
        if ((r13 instanceof s) == false) goto L13;
        r14 = r12.b(normalizePoiSearchResponseEnvelope(r13.f(), r11), CommsenseTextSearchResponse.class);     // Catch: Throwable -> L95 Exception -> L97
    L97:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, r11 + ": Failed to parse json, response is: " + r10, e);     // Catch: Throwable -> L95
        return null;
    L95:
        th = move-exception;
        throw th;
    }

    private List<StarPoiDbManager.PoiData> parsePoiTypeDataResponse(String r8) {
        p r10 = parseJsonElementLenient(r8);
        if (r10 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "response is not a valid json");
        return new ArrayList();
    L6:
        p r11 = normalizePoiApiResponsePayload(r10, "POI_TYPE_DATA");
        LinkedHashMap<String, StarPoiDbManager.PoiData> r12 = new LinkedHashMap();
        collectPoiTypeDatas(r11, new String[3], new String[3], r12, 0);
        return new ArrayList(r12.values());
    }

    private BmapRidingDirectionResponse parseRidingDirectionResponse(s r8) {
        s r10 = findDirectionPayload(r8);
        if (r10 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "failed to find riding payload, root keys=" + r8.u());
        return null;
    L6:
        sanitizeRidingNumericFields(r10);
        j r11 = sGson;
        monitor-enter(r11);
        BmapRidingDirectionResponse r12 = (BmapRidingDirectionResponse) r11.b(r10, BmapRidingDirectionResponse.class);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        if (r12 != null) goto L13;
        return null;
    L13:
        if (r12.status != null) goto L22;
        Integer r13 = extractStatusCode(r10);
        r12.status = r13;
        if (r13 != null) goto L17;
    L18:
        Integer r14 = extractStatusCode(r8);
        if (r14 == null) goto L22;
        r12.status = r14;
        goto L22
    L17:
        if (r13.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r12.message) == false) goto L27;
        String r15 = extractMessage(r10);
        r12.message = r15;
        if (TextUtils.isEmpty(r15) == false) goto L27;
        r12.message = extractMessage(r8);
    L27:
        if (r12.result == null) goto L29;
    L39:
        StringBuilder r16 = new StringBuilder("normalized payload keys=");
        r16.append(r10.u());
        r16.append(", status=");
        r16.append(r12.status);
        r16.append(", message=");
        r16.append(r12.message);
        r16.append(", hasResult=");
        if (r12.result == null) goto L42;
        boolean r17 = true;
    L43:
        r16.append(r17);
        CommSenseLog.iWithMethodName(TAG, r16.toString());
        return r12;
    L42:
        r17 = false;
        goto L43
    L29:
        if (r10.t("result") == false) goto L39;
        p r18 = r10.p("result");
        r18.getClass();
        if ((r18 instanceof s) == false) goto L39;
        monitor-enter(r11);
        r12.result = (BmapRidingDirectionResult) r11.b(r10.r("result"), BmapRidingDirectionResult.class);     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private BmapTransitDirectionResponse parseTransitDirectionResponse(s r8) {
        s r10 = findDirectionPayload(r8);
        if (r10 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "failed to find transit payload, root keys=" + r8.u());
        return null;
    L6:
        normalizeDirectionSteps(r10);
        j r11 = sGson;
        monitor-enter(r11);
        BmapTransitDirectionResponse r12 = (BmapTransitDirectionResponse) r11.b(r10, BmapTransitDirectionResponse.class);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        if (r12 != null) goto L13;
        return null;
    L13:
        if (r12.status != null) goto L22;
        Integer r13 = extractStatusCode(r10);
        r12.status = r13;
        if (r13 != null) goto L17;
    L18:
        Integer r14 = extractStatusCode(r8);
        if (r14 == null) goto L22;
        r12.status = r14;
        goto L22
    L17:
        if (r13.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r12.message) == false) goto L27;
        String r15 = extractMessage(r10);
        r12.message = r15;
        if (TextUtils.isEmpty(r15) == false) goto L27;
        r12.message = extractMessage(r8);
    L27:
        if (r12.result == null) goto L29;
    L39:
        StringBuilder r16 = new StringBuilder(" normalized payload keys=");
        r16.append(r10.u());
        r16.append(", status=");
        r16.append(r12.status);
        r16.append(", message=");
        r16.append(r12.message);
        r16.append(", hasResult=");
        if (r12.result == null) goto L42;
        boolean r17 = true;
    L43:
        r16.append(r17);
        CommSenseLog.iWithMethodName(TAG, r16.toString());
        return r12;
    L42:
        r17 = false;
        goto L43
    L29:
        if (r10.t("result") == false) goto L39;
        p r18 = r10.p("result");
        r18.getClass();
        if ((r18 instanceof s) == false) goto L39;
        monitor-enter(r11);
        r12.result = (BmapTransitDirectionResult) r11.b(r10.r("result"), BmapTransitDirectionResult.class);     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private BmapWalkingDirectionResponse parseWalkingDirectionResponse(s r8) {
        s r10 = findDirectionPayload(r8);
        if (r10 != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "failed to find walking payload, root keys=" + r8.u());
        return null;
    L6:
        sanitizeWalkingNumericFields(r10);
        j r11 = sGson;
        monitor-enter(r11);
        BmapWalkingDirectionResponse r12 = (BmapWalkingDirectionResponse) r11.b(r10, BmapWalkingDirectionResponse.class);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        if (r12 != null) goto L13;
        return null;
    L13:
        if (r12.status != null) goto L22;
        Integer r13 = extractStatusCode(r10);
        r12.status = r13;
        if (r13 != null) goto L17;
    L18:
        Integer r14 = extractStatusCode(r8);
        if (r14 == null) goto L22;
        r12.status = r14;
        goto L22
    L17:
        if (r13.intValue() == 0) goto L18;
    L22:
        if (TextUtils.isEmpty(r12.message) == false) goto L27;
        String r15 = extractMessage(r10);
        r12.message = r15;
        if (TextUtils.isEmpty(r15) == false) goto L27;
        r12.message = extractMessage(r8);
    L27:
        if (r12.result == null) goto L29;
    L39:
        StringBuilder r16 = new StringBuilder("normalized payload keys=");
        r16.append(r10.u());
        r16.append(", status=");
        r16.append(r12.status);
        r16.append(", message=");
        r16.append(r12.message);
        r16.append(", hasResult=");
        if (r12.result == null) goto L42;
        boolean r17 = true;
    L43:
        r16.append(r17);
        CommSenseLog.iWithMethodName(TAG, r16.toString());
        return r12;
    L42:
        r17 = false;
        goto L43
    L29:
        if (r10.t("result") == false) goto L39;
        p r18 = r10.p("result");
        r18.getClass();
        if ((r18 instanceof s) == false) goto L39;
        monitor-enter(r11);
        r12.result = (BmapWalkingDirectionResult) r11.b(r10.r("result"), BmapWalkingDirectionResult.class);     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    }

    private PoiTextSearchResult performBdPoiTextSearch(Context r16, final String r17, final int r18, final int r19, final String r20, final String r21) {
        long r10 = System.currentTimeMillis();
        HashMap r11 = new HashMap();
        if (r16 != null) goto L5;
    L7:
        Context r8 = r16;
    L8:
        if (r8 == null) goto L10;
    L12:
        Integer r12 = null;
        Map<String, List<CommonPOIInfo>> r13 = null;
        r12 = null;
        r12 = null;
        if (r8 != null) goto L17;
        CommSenseLog.eWithMethodName(TAG, "finalContext is null");
        return new PoiTextSearchResult(r11, null, null);
    L17:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L21;
        CommSenseLog.dWithMethodName(TAG, "Network invalid.");
        return new PoiTextSearchResult(r11, null, null);
    L21:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L91;
        CommSenseLog.wWithMethodName(TAG, "Cannot execute network request synchronously on main thread, executing asynchronously");
        sPoiExecutor.submit(new e(this, r17, r18, r19, r20, r21));
        return new PoiTextSearchResult(r11, null, null);
    L91:
        PoiTextSearchResult r14 = (PoiTextSearchResult) sPoiExecutor.submit(new f(this, r17, r18, r19, r20, r21, 0)).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS);     // Catch: Exception -> L60 RuntimeException -> L63 TimeoutException -> L66
        if (r14 == null) goto L35;
        Integer r15 = r14.code;     // Catch: Exception -> L60 RuntimeException -> L63 TimeoutException -> L66
        String r22 = r14.msg;     // Catch: Exception -> L29 RuntimeException -> L31 TimeoutException -> L33
    L36:
        if (r14 != null) goto L89;
    L39:
        if (r13 == null) goto L70;
        Object r23 = sSyncLock;     // Catch: Exception -> L54 RuntimeException -> L56 TimeoutException -> L58
        monitor-enter(r23);     // Catch: Exception -> L54 RuntimeException -> L56 TimeoutException -> L58
        Iterator<Map.Entry<String, List<CommonPOIInfo>>> r24 = r13.entrySet().iterator();     // Catch: Throwable -> L51
    L44:
        if (r24.hasNext() == false) goto L49;
        Map.Entry<String, List<CommonPOIInfo>> r25 = r24.next();     // Catch: Throwable -> L51
        if (r11.containsKey(r25.getKey()) == true) goto L48;
        r11.put(r25.getKey(), new ArrayList());     // Catch: Throwable -> L51
    L48:
        ((List) r11.get(r25.getKey())).addAll(r25.getValue());     // Catch: Throwable -> L51
        goto L44
    L49:
        monitor-exit(r23);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;     // Catch: Exception -> L54 RuntimeException -> L56 TimeoutException -> L58
    L56:
        e = e;
    L57:
        r12 = r15;
    L65:
        String r26 = TAG;
        String r27 = "catch RuntimeException";
    L69:
        CommSenseLog.eWithMethodName(r26, r27, e);
        r15 = r12;
    L58:
        e = e;
    L59:
        r12 = r15;
    L68:
        r26 = TAG;
        r27 = "catch TimeoutException";
    L54:
        e = e;
    L55:
        r12 = r15;
    L62:
        r26 = TAG;
        r27 = "catch exception";
    L70:
        long r28 = System.currentTimeMillis() - r10;
        Iterator r29 = r11.values().iterator();
        int r30 = 0;
    L72:
        if (r29.hasNext() == false) goto L74;
        r30 = r30 + ((List) r29.next()).size();
        goto L72
    L74:
        CommSenseLog.iWithMethodName(TAG, "cost " + r28 + "ms, result size=" + r30);
        if (r11.isEmpty() == true) goto L84;
        Iterator r31 = r11.entrySet().iterator();
    L78:
        if (r31.hasNext() == false) goto L84;
        Map.Entry r32 = (Map.Entry) r31.next();
        Iterator r33 = ((List) r32.getValue()).iterator();
    L81:
        if (r33.hasNext() == false) goto L78;
        CommSenseLog.dWithMethodName(TAG, "result detail line=" + ((String) r32.getKey()) + " " + ((CommonPOIInfo) r33.next()).name);
    L84:
        return new PoiTextSearchResult(r11, r15, r22);
    L89:
        r13 = r14.items;     // Catch: Exception -> L54 RuntimeException -> L56 TimeoutException -> L58
        goto L39
    L31:
        e = e;
        r22 = null;
    L33:
        e = e;
        r22 = null;
    L29:
        e = e;
        r22 = null;
        goto L55
    L35:
        r15 = null;
        r22 = null;
    L63:
        e = e;
        r22 = null;
    L66:
        e = e;
        r22 = null;
    L60:
        e = e;
        r22 = null;
        goto L62
    L10:
        if (this.appContext == null) goto L12;
        r8 = this.appContext;
        goto L12
    L5:
        if (r16.getApplicationContext() == null) goto L7;
        r8 = r16.getApplicationContext();
        goto L8
    }

    private void putBundleList(Bundle r8, String r10, ArrayList<Bundle> r11) {
        if (r11 == null) goto L5;
        r8.putParcelableArrayList(r10, r11);
        return;
    }

    private void putDouble(Bundle r8, String r10, Double r11) {
        if (r11 == null) goto L5;
        r8.putDouble(r10, r11.doubleValue());
        return;
    }

    private void putInteger(Bundle r8, String r10, Integer r11) {
        if (r11 == null) goto L5;
        r8.putInt(r10, r11.intValue());
        return;
    }

    private void putJsonElement(Bundle r8, String r10, p r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if ((r11 instanceof r) == false) goto L7;
        return;
    L7:
        if ((r11 instanceof s) == false) goto L11;
        r8.putBundle(r10, toBundle(r11.f()));
        return;
    L11:
        if ((r11 instanceof m) == false) goto L15;
        r8.putParcelableArrayList(r10, toBundleList(r11));
        return;
    L15:
        if ((r11.g().f8004a instanceof Boolean) == false) goto L19;
        r8.putBoolean(r10, r11.b());
        return;
    L19:
        if ((r11.g().f8004a instanceof Number) == false) goto L22;
        r8.putDouble(r10, r11.i().doubleValue());
        return;
    L22:
        r8.putString(r10, r11.j());
    }

    private void putNearPoiIdentityIfComplete(Bundle r8, String r10, String r11, String r12, Double r13) {
        if (TextUtils.isEmpty(r12) == true) goto L8;
        if (r13 == null) goto L9;
        r8.putString(r10, r12);
        r8.putDouble(r11, r13.doubleValue());
        return;
    L9:
        return;
    }

    private void putNearPoiLogIdsIfComplete(Bundle r8, String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L10;
        r8.putString(IStarPoiCallback.SDK_LOGID, r10);
        r8.putString(IStarPoiCallback.SCENE_LOGID, r11);
        return;
    }

    private void putPoiData(LinkedHashMap<String, StarPoiDbManager.PoiData> r8, StarPoiDbManager.PoiData r10) {
        if (r10.isValid() == true) goto L5;
        return;
    L5:
        r8.put(r10.newTypeCodeL1 + "|" + r10.newTypeCodeL2 + "|" + r10.newTypeCodeL3 + "|" + r10.newTypeNameL1 + "|" + r10.newTypeNameL2 + "|" + r10.newTypeNameL3, r10);
    }

    private void putStringIfNotEmpty(Bundle r8, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == true) goto L6;
        r8.putString(r10, r11);
        return;
    }

    private Map<String, String> refreshPoiRequestHeaders(Map<String, String> r8) {
        String r10 = getPrivacyIdAttestationCertSafely();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        CommSenseLog.eWithMethodName(TAG, "attestation certChain is empty after refresh");
        return null;
    L6:
        if (r8 != null) goto L8;
        HashMap r11 = new HashMap();
    L9:
        r11.put(X_ATT_CERT_CHAIN_HEADER, r10);
        return r11;
    L8:
        r11 = new HashMap(r8);
        goto L9
    }

    private void reportDirectionSearchTea(int r10, BmapBaseDirectionRequest r11, BmapDirectionBaseResponse r12, long r13, String r14) {
        StarLocationTeaReporter.reportDirectionSearch(r10, r11, r12, r13, System.currentTimeMillis(), r14);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed to report direction search tea", e);
    }

    private m resolveJsonArray(p r8) {
        if (r8 != null) goto L5;
    L19:
        return null;
    L5:
        if ((r8 instanceof r) == true) goto L19;
        if ((r8 instanceof m) == false) goto L12;
        return r8.e();
    L12:
        if ((r8 instanceof u) == false) goto L19;
        p r10 = parseJsonElementLenient(r8.j());
        if (r10 == null) goto L19;
        if ((r10 instanceof m) == false) goto L19;
        return r10.e();
    }

    private String resolveNearPoiTypeField(s r8, String r10, String... r11) {
        if (r8 != null) goto L4;
        String r12 = "";
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        return r12;
    L8:
        return safeString(r10);
    L4:
        r12 = safeString(getStringByKeys(r8, r11));
        goto L6
    }

    private int resolveNextLevel(String[] r8, String[] r10, s r11) {
        Integer r12 = getIntByKeys(r11, new String[]{"level", "Level", "type_level", "TypeLevel"});
        if (r12 != null) goto L5;
    L10:
        int r13 = 0;
    L11:
        if (r13 >= 3) goto L18;
        if (TextUtils.isEmpty(r8[r13]) == false) goto L17;
        if (TextUtils.isEmpty(r10[r13]) == false) goto L17;
        return r13;
    L17:
        r13 = r13 + 1;
        goto L11
    L18:
        return 2;
    L5:
        if (r12.intValue() < 1) goto L10;
        if (r12.intValue() > 3) goto L10;
        return r12.intValue() - 1;
    }

    private String resolveRetCoordType(byte r8) {
        if (r8 == 1) goto L11;
        if (r8 != 0) goto L7;
        return LocationInfoConst.GCJ_O2;
    L7:
        if (r8 == 2) goto L13;
        CommSenseLog.wWithMethodName(TAG, "unknown outCoordType=" + r8 + ", fallback ret_coordtype to bd09ll");
        return "bd09ll";
    L13:
        return "bd09ll";
    L11:
        return LocationInfoConst.GCJ_O2;
    }

    private String safeString(String r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8;
    }

    private void sanitizeDrivingNumericFields(p r8) {
        r8.getClass();
        if ((r8 instanceof m) == false) goto L14;
        Iterator<p> r10 = r8.e().iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        p r11 = r10.next();
        if (r11 == null) goto L6;
        if ((r11 instanceof r) == true) goto L6;
        sanitizeDrivingNumericFields(r11);
        goto L6
    L12:
        return;
    L14:
        if ((r8 instanceof s) == true) goto L16;
        return;
    L16:
        s r12 = r8.f();
        Iterator r13 = new ArrayList(r12.u()).iterator();
    L18:
        if (r13.hasNext() == false) goto L34;
        String r14 = (String) r13.next();
        p r15 = r12.p(r14);
        if (r15 == null) goto L18;
        if ((r15 instanceof r) == true) goto L18;
        if (shouldSanitizeDrivingNumericField(r14) == false) goto L33;
        if ((r15 instanceof u) == false) goto L33;
        if ((r15.g().f8004a instanceof String) == false) goto L33;
        if (TextUtils.isEmpty(r15.j()) == false) goto L33;
        r12.k(r14, r.f8002a);
    L33:
        sanitizeDrivingNumericFields(r15);
        goto L18
    }

    private void sanitizeRidingNumericFields(p r8) {
        r8.getClass();
        if ((r8 instanceof m) == false) goto L14;
        Iterator<p> r10 = r8.e().iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        p r11 = r10.next();
        if (r11 == null) goto L6;
        if ((r11 instanceof r) == true) goto L6;
        sanitizeRidingNumericFields(r11);
        goto L6
    L12:
        return;
    L14:
        if ((r8 instanceof s) == true) goto L16;
        return;
    L16:
        s r12 = r8.f();
        Iterator r13 = new ArrayList(r12.u()).iterator();
    L18:
        if (r13.hasNext() == false) goto L34;
        String r14 = (String) r13.next();
        p r15 = r12.p(r14);
        if (r15 == null) goto L18;
        if ((r15 instanceof r) == true) goto L18;
        if (shouldSanitizeRidingNumericField(r14) == false) goto L33;
        if ((r15 instanceof u) == false) goto L33;
        if ((r15.g().f8004a instanceof String) == false) goto L33;
        if (TextUtils.isEmpty(r15.j()) == false) goto L33;
        r12.k(r14, r.f8002a);
    L33:
        sanitizeRidingNumericFields(r15);
        goto L18
    }

    private void sanitizeWalkingNumericFields(p r8) {
        r8.getClass();
        if ((r8 instanceof m) == false) goto L14;
        Iterator<p> r10 = r8.e().iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        p r11 = r10.next();
        if (r11 == null) goto L6;
        if ((r11 instanceof r) == true) goto L6;
        sanitizeWalkingNumericFields(r11);
        goto L6
    L12:
        return;
    L14:
        if ((r8 instanceof s) == true) goto L16;
        return;
    L16:
        s r12 = r8.f();
        Iterator r13 = new ArrayList(r12.u()).iterator();
    L18:
        if (r13.hasNext() == false) goto L34;
        String r14 = (String) r13.next();
        p r15 = r12.p(r14);
        if (r15 == null) goto L18;
        if ((r15 instanceof r) == true) goto L18;
        if (shouldSanitizeWalkingNumericField(r14) == false) goto L33;
        if ((r15 instanceof u) == false) goto L33;
        if ((r15.g().f8004a instanceof String) == false) goto L33;
        if (TextUtils.isEmpty(r15.j()) == false) goto L33;
        r12.k(r14, r.f8002a);
    L33:
        sanitizeWalkingNumericFields(r15);
        goto L18
    }

    private <T extends BmapDirectionBaseResponse> T searchDirectionFromBmapInternal(BmapBaseDirectionRequest r8, String r10, Callable<T> r11) {
        long r12 = System.currentTimeMillis();
        if (r8 != null) goto L7;
        CommSenseLog.eWithMethodName(TAG, r10 + ": request is null");
        return null;
    L7:
        if (TextUtils.isEmpty(r8.origin) == false) goto L9;
    L33:
        CommSenseLog.eWithMethodName(TAG, r10 + ": origin or destination is empty");
        return null;
    L9:
        if (TextUtils.isEmpty(r8.destination) == true) goto L33;
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L16;
        CommSenseLog.wWithMethodName(TAG, r10 + ": network disconnected");
        return null;
    L16:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L35;
        CommSenseLog.wWithMethodName(TAG, r10 + ": cannot execute synchronously on main thread");
        return null;
    L35:
        T r13 = (T) sPoiExecutor.submit(r11).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS);     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        long r14 = System.currentTimeMillis() - r12;     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append(r10);     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append(": search cost ");     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append(r14);     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append("ms, status=");     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        if (r13 == null) goto L22;
        Integer r16 = r13.status;     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
    L23:
        r15.append(r16);     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append(", routeCount=");     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        r15.append(getDirectionRouteCount(r13));     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        CommSenseLog.iWithMethodName(TAG, r15.toString());     // Catch: Exception -> L25 RuntimeException -> L27 TimeoutException -> L29
        return r13;
    L22:
        r16 = null;
    L27:
        e = e;
        StringBuilder r17 = new StringBuilder();
        r17.append(r10);
        String r18 = ": runtime error";
    L31:
        r17.append(r18);
        CommSenseLog.eWithMethodName(TAG, r17.toString(), e);
        return null;
    L29:
        e = e;
        r17 = new StringBuilder();
        r17.append(r10);
        r18 = ": request timeout";
    L25:
        e = e;
        r17 = new StringBuilder();
        r17.append(r10);
        r18 = ": unexpected error";
        goto L31
    }

    private boolean shouldSanitizeDrivingNumericField(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -1992012396: goto L57;
            case -962590849: goto L53;
            case -865190663: goto L49;
            case -268520987: goto L45;
            case 106911: goto L41;
            case 107301: goto L37;
            case 3565883: goto L33;
            case 110549828: goto L29;
            case 206407764: goto L25;
            case 288459765: goto L21;
            case 1194524097: goto L17;
            case 1601406585: goto L13;
            case 2037312353: goto L9;
            default: goto L60;
        };
    L60:
        switch(r10) {
            case 0: goto L62;
            case 1: goto L62;
            case 2: goto L62;
            case 3: goto L62;
            case 4: goto L62;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L62;
            case 8: goto L62;
            case 9: goto L62;
            case 10: goto L62;
            case 11: goto L62;
            case 12: goto L62;
            default: goto L61;
        };
    L61:
        return false;
    L62:
        return true;
    L9:
        if (r8.equals("leg_index") == false) goto L60;
        r10 = 12;
        goto L60
    L13:
        if (r8.equals("toll_distance") == false) goto L60;
        r10 = 11;
        goto L60
    L17:
        if (r8.equals("link_num") == false) goto L60;
        r10 = 10;
        goto L60
    L21:
        if (r8.equals("distance") == false) goto L60;
        r10 = 9;
        goto L60
    L25:
        if (r8.equals("traffic_light") == false) goto L60;
        r10 = 8;
        goto L60
    L29:
        if (r8.equals(LBSLightLocationTraceLogger.TOTAL) == false) goto L60;
        r10 = 7;
        goto L60
    L33:
        if (r8.equals("toll") == false) goto L60;
        r10 = 6;
        goto L60
    L37:
        if (r8.equals("lng") == false) goto L60;
        r10 = 5;
        goto L60
    L41:
        if (r8.equals("lat") == false) goto L60;
        r10 = 4;
        goto L60
    L45:
        if (r8.equals("taxi_fee") == false) goto L60;
        r10 = 3;
        goto L60
    L49:
        if (r8.equals("road_type") == false) goto L60;
        r10 = 2;
        goto L60
    L53:
        if (r8.equals("direction") == false) goto L60;
        r10 = 1;
        goto L60
    L57:
        if (r8.equals("duration") == false) goto L60;
        r10 = 0;
        goto L60
    }

    private boolean shouldSanitizeRidingNumericField(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -1992012396: goto L53;
            case -1106363674: goto L49;
            case -1071743734: goto L45;
            case -962590849: goto L41;
            case -746472947: goto L37;
            case 106911: goto L33;
            case 107301: goto L29;
            case 3002509: goto L25;
            case 3004913: goto L21;
            case 3575610: goto L17;
            case 288459765: goto L13;
            case 2037312353: goto L9;
            default: goto L56;
        };
    L56:
        switch(r10) {
            case 0: goto L58;
            case 1: goto L58;
            case 2: goto L58;
            case 3: goto L58;
            case 4: goto L58;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L58;
            case 8: goto L58;
            case 9: goto L58;
            case 10: goto L58;
            case 11: goto L58;
            default: goto L57;
        };
    L57:
        return false;
    L58:
        return true;
    L9:
        if (r8.equals("leg_index") == false) goto L56;
        r10 = 11;
        goto L56
    L13:
        if (r8.equals("distance") == false) goto L56;
        r10 = 10;
        goto L56
    L17:
        if (r8.equals("type") == false) goto L56;
        r10 = 9;
        goto L56
    L21:
        if (r8.equals("attr") == false) goto L56;
        r10 = 8;
        goto L56
    L25:
        if (r8.equals("area") == false) goto L56;
        r10 = 7;
        goto L56
    L29:
        if (r8.equals("lng") == false) goto L56;
        r10 = 6;
        goto L56
    L33:
        if (r8.equals("lat") == false) goto L56;
        r10 = 5;
        goto L56
    L37:
        if (r8.equals("area_id") == false) goto L56;
        r10 = 4;
        goto L56
    L41:
        if (r8.equals("direction") == false) goto L56;
        r10 = 3;
        goto L56
    L45:
        if (r8.equals("restrictions_status") == false) goto L56;
        r10 = 2;
        goto L56
    L49:
        if (r8.equals("length") == false) goto L56;
        r10 = 1;
        goto L56
    L53:
        if (r8.equals("duration") == false) goto L56;
        r10 = 0;
        goto L56
    }

    private boolean shouldSanitizeWalkingNumericField(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -1992012396: goto L45;
            case -962590849: goto L41;
            case -746472947: goto L37;
            case 106911: goto L33;
            case 107301: goto L29;
            case 3002509: goto L25;
            case 3575610: goto L21;
            case 288459765: goto L17;
            case 1624717950: goto L13;
            case 2037312353: goto L9;
            default: goto L48;
        };
    L48:
        switch(r10) {
            case 0: goto L50;
            case 1: goto L50;
            case 2: goto L50;
            case 3: goto L50;
            case 4: goto L50;
            case 5: goto L50;
            case 6: goto L50;
            case 7: goto L50;
            case 8: goto L50;
            case 9: goto L50;
            default: goto L49;
        };
    L49:
        return false;
    L50:
        return true;
    L9:
        if (r8.equals("leg_index") == false) goto L48;
        r10 = 9;
        goto L48
    L13:
        if (r8.equals("turn_type_id") == false) goto L48;
        r10 = 8;
        goto L48
    L17:
        if (r8.equals("distance") == false) goto L48;
        r10 = 7;
        goto L48
    L21:
        if (r8.equals("type") == false) goto L48;
        r10 = 6;
        goto L48
    L25:
        if (r8.equals("area") == false) goto L48;
        r10 = 5;
        goto L48
    L29:
        if (r8.equals("lng") == false) goto L48;
        r10 = 4;
        goto L48
    L33:
        if (r8.equals("lat") == false) goto L48;
        r10 = 3;
        goto L48
    L37:
        if (r8.equals("area_id") == false) goto L48;
        r10 = 2;
        goto L48
    L41:
        if (r8.equals("direction") == false) goto L48;
        r10 = 1;
        goto L48
    L45:
        if (r8.equals("duration") == false) goto L48;
        r10 = 0;
        goto L48
    }

    private boolean shouldSkipExistingMallAoiBoard(StarAoiBoardManager r8, StarLocationDbManager.CellAoiBoardEntry r10) {
        if (StarCellManager.isMallNewTypeCodeL3(r10.getTypeCode()) == true) goto L5;
        return false;
    L5:
        AoiBoard r11 = r10.getAoiBoard();
        if (r11 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r11.getPoiId()) == true) goto L19;
        AoiBoard r12 = r8.queryAoiBoardByPoiId(r11.getPoiId());
        if (r12 != null) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r12.getAoiBoard()) == true) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    private void startLocation(Context r8, boolean r10, final BDLocationCallback r11) {
        BDLocationClient r12 = createClient(r8, r10);
        final long r13 = System.currentTimeMillis();
        r12.getLocation(new AnonymousClass5(this, r13, r11));
    }

    private String toBmapCoordType(byte r8) {
        if (r8 != 0) goto L6;
        return LocationInfoConst.WGS_84;
    L6:
        if (r8 != 1) goto L10;
        return LocationInfoConst.GCJ_O2;
    L10:
        if (r8 == 2) goto L14;
        CommSenseLog.wWithMethodName(TAG, "unknown coordType=" + r8 + ", fallback to bd09ll");
        return "bd09ll";
    L14:
        return "bd09ll";
    }

    private Bundle toBundle(BmapDrivingDirectionResponse r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "status", r8.status);
        r10.putString("message", r8.message);
        putInteger(r10, "type", r8.type);
        BmapDrivingDirectionResult r11 = r8.result;
        if (r11 == null) goto L5;
        r10.putBundle("result", toBundle(r11));
    L5:
        return r10;
    }

    private ArrayList<Bundle> toBundleList(p r8) {
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<p> r11 = r8.e().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        p r12 = r11.next();
        if (r12 == null) goto L10;
        if ((r12 instanceof s) == false) goto L10;
        r10.add(toBundle(r12.f()));
    L10:
        if (r12 == null) goto L4;
        if ((r12 instanceof r) == true) goto L4;
        Bundle r13 = new Bundle();
        putJsonElement(r13, "value", r12);
        r10.add(r13);
        goto L4
    L14:
        return r10;
    }

    private ArrayList<Bundle> toDrivingRouteBundleList(List<BmapDrivingRoute> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapDrivingRoute> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapDrivingRoute r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toDrivingStepBundleList(List<BmapDrivingStep> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapDrivingStep> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapDrivingStep r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toPriceDetailBundleList(List<BmapTransitPriceDetail> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapTransitPriceDetail> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapTransitPriceDetail r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toRidingLinkBundleList(List<BmapRidingLink> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapRidingLink> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapRidingLink r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toRidingRouteBundleList(List<BmapRidingRoute> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapRidingRoute> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapRidingRoute r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toRidingStepBundleList(List<BmapRidingStep> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapRidingStep> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapRidingStep r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toRouteBundleList(List<BmapTransitRoute> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapTransitRoute> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapTransitRoute r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toSchemeBundleList(List<BmapTransitScheme> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapTransitScheme> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapTransitScheme r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toStepGroupBundleList(List<List<BmapTransitStep>> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        int r11 = 0;
    L7:
        if (r11 >= r8.size()) goto L17;
        List<BmapTransitStep> r12 = r8.get(r11);
        Bundle r13 = new Bundle();
        r13.putInt("index", r11);
        ArrayList<? extends Parcelable> r14 = new ArrayList();
        if (r12 == null) goto L16;
        Iterator<BmapTransitStep> r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L16;
        BmapTransitStep r16 = r15.next();
        if (r16 == null) goto L12;
        r14.add(toBundle(r16));
    L16:
        r13.putParcelableArrayList("items", r14);
        r10.add(r13);
        r11 = r11 + 1;
        goto L7
    L17:
        return r10;
    }

    private Map<String, String> toStringMap(Map r8) {
        HashMap r10 = new HashMap();
        if (r8 != null) goto L5;
    L14:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L14;
        Iterator r11 = r8.keySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        Object r12 = r11.next();
        Object r13 = r8.get(r12);
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        r10.put(String.valueOf(r12), String.valueOf(r13));
        goto L9
    }

    private ArrayList<Bundle> toTaxiDetailBundleList(List<BmapTransitTaxiDetail> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapTransitTaxiDetail> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapTransitTaxiDetail r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toWalkingRouteBundleList(List<BmapWalkingRoute> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapWalkingRoute> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapWalkingRoute r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    private ArrayList<Bundle> toWalkingStepBundleList(List<BmapWalkingStep> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList<Bundle> r10 = new ArrayList();
        Iterator<BmapWalkingStep> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        BmapWalkingStep r12 = r11.next();
        if (r12 == null) goto L7;
        r10.add(toBundle(r12));
        goto L7
    L11:
        return r10;
    }

    public BmapBaseDirectionRequest buildDirectionRequest(double r8, double r10, double r11, double r12, byte r13, byte r14, Map r15, int r16) {
        BmapBaseDirectionRequest r17 = buildDirectionRequestByType(LocationUtil.getInstance().formatCoordinate6(r8, r10), LocationUtil.getInstance().formatCoordinate6(r11, r12), r15, r16);
        r17.coordType = toBmapCoordType(r13);
        r17.retCoordtype = resolveRetCoordType(r14);
        return r17;
    }

    public Bundle createDirectionErrorBundle(int r8, String r10, int r11) {
        Bundle r12 = new Bundle();
        r12.putInt("status", r8);
        r12.putString("message", r10);
        return r12;
    }

    public Bundle executeDirectionRequest(BmapBaseDirectionRequest r8, int r10) {
        Bundle r11 = searchDirectionFromBmap(r8, r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return createDirectionErrorBundle(-1, "direction result is null", r8, r10);
    }

    public Bundle getLastNearPoiDataBundle() {
        Bundle r8 = this.mLastNearPoiDataBundle;
        if (r8 != null) goto L6;
        return null;
    L6:
        return new Bundle(r8);
    }

    public BDLocation getLocationSync(boolean r8, String r10, long r11) {
        CommSenseLog.iWithMethodName(TAG, "ignoreCache=" + r8 + ", triggerType=" + r10 + ", timeoutMs=" + r11);
        Context r12 = this.appContext;
        if (r12 != null) goto L7;
        CommSenseLog.eWithMethodName(TAG, "called before init");
        return null;
    L7:
        if (this.inited == true) goto L11;
        CommSenseLog.wWithMethodName(TAG, "skipped: sdk not inited");
        return null;
    L11:
        if (LocationUtil.getInstance().isLocationUiEnabled() == true) goto L15;
        CommSenseLog.wWithMethodName(TAG, "skipped: location is disabled");
        return null;
    L15:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L18;
        CommSenseLog.wWithMethodName(TAG, "skipped: network disconnected");
        return null;
    L18:
        final AtomicReference r13 = new AtomicReference();
        final AtomicReference r14 = new AtomicReference();
        final CountDownLatch r15 = new CountDownLatch(1);
        startLocation(r12, r8, new AnonymousClass4(this, r13, r15, r14));
    L29:
        e = move-exception;
        Thread.currentThread().interrupt();
        CommSenseLog.eWithMethodName(TAG, "interrupted", e);
        return null;
    L20:
        if (r15.await(r11, TimeUnit.MILLISECONDS) == true) goto L23;
        CommSenseLog.wWithMethodName(TAG, "timeoutMs=" + r11);     // Catch: InterruptedException -> L29
        return null;
    L23:
        BDLocationException r16 = (BDLocationException) r14.get();
        if (r16 == null) goto L28;
        CommSenseLog.eWithMethodName(TAG, WsConstants.KEY_CONNECTION_ERROR, r16);
        return null;
    L28:
        return (BDLocation) r13.get();
    }

    public synchronized void init(Context r8) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        CommSenseLog.iWithMethodName(TAG, "");     // Catch: Throwable -> L13
        if (this.appContext != null) goto L10;
        this.appContext = r8.getApplicationContext();     // Catch: Throwable -> L13
    L10:
        initLocationInternal();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public boolean isInited() {
        return this.inited;
    }

    public boolean queryCellsArea(List<StarCellManager.StarCellInfo> r8) {
        if (r8 != null) goto L5;
    L29:
        CommSenseLog.vWithMethodName(TAG, "infos is null or empty");
        return false;
    L5:
        if (r8.isEmpty() == true) goto L29;
        if (this.appContext != null) goto L12;
        CommSenseLog.eWithMethodName(TAG, "appContext is null");
        return false;
    L12:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L15;
        CommSenseLog.wWithMethodName(TAG, "Network invalid.");
        return false;
    L15:
        ArrayList r10 = new ArrayList(r8);
        int r11 = 1;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L31;
        CommSenseLog.wWithMethodName(TAG, "execute asynchronously on main thread, count=" + r10.size());
        sPoiExecutor.submit(new a(r11, this, r10));
        return false;
    L31:
        return ((Boolean) sPoiExecutor.submit(new b(r11, this, r10)).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)).booleanValue();
    L23:
        e = e;
        String r12 = "catch RuntimeException";
    L27:
        CommSenseLog.eWithMethodName(TAG, r12, e);
        return false;
    L25:
        e = e;
        r12 = "catch TimeoutException";
    L21:
        e = e;
        r12 = "catch exception";
        goto L27
    }

    public List<PoiFenceInfo> queryFencesByPoiId(List<String> r8) {
        List<String> r10 = normalizePoiIdList(r8);
        if (r10.isEmpty() == false) goto L7;
        CommSenseLog.dWithMethodName(TAG, "poiIds is null or empty");
        return new ArrayList();
    L7:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L11;
        CommSenseLog.wWithMethodName(TAG, "Network invalid.");
        return new ArrayList();
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L24;
        CommSenseLog.wWithMethodName(TAG, "skip sync query on main thread, count=" + r10.size());
        return new ArrayList();
    L24:
        return (List) sPoiExecutor.submit(new com.obric.cae.cldReport.b(3, this, r10)).get(getGetFencesTimeoutMs(r10.size()), TimeUnit.MILLISECONDS);
    L18:
        e = e;
        String r11 = "catch RuntimeException";
    L22:
        CommSenseLog.eWithMethodName(TAG, r11, e);
        return new ArrayList();
    L20:
        e = e;
        r11 = "catch TimeoutException";
    L16:
        e = e;
        r11 = "catch exception";
        goto L22
    }

    public boolean queryNearPoiData() {
        if (this.appContext != null) goto L7;
        CommSenseLog.eWithMethodName(TAG, "appContext is null");
        return false;
    L7:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L11;
        CommSenseLog.wWithMethodName(TAG, "Network invalid.");
        return false;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L24;
        CommSenseLog.wWithMethodName(TAG, "execute asynchronously on main thread");
        sPoiExecutor.submit(new d(this, 1));
        return false;
    L24:
        return ((Boolean) sPoiExecutor.submit(new s1.g(this, 2)).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)).booleanValue();
    L18:
        e = e;
        String r8 = "catch RuntimeException";
    L22:
        CommSenseLog.eWithMethodName(TAG, r8, e);
        return false;
    L20:
        e = e;
        r8 = "catch TimeoutException";
    L16:
        e = e;
        r8 = "catch exception";
        goto L22
    }

    public boolean queryPoiTypeDatas() {
        Context r8 = this.appContext;
        int r10 = 0;
        if (r8 != null) goto L7;
        CommSenseLog.eWithMethodName(TAG, "appContext is null");
        return false;
    L7:
        if (StarPoiDbManager.getInstance(r8).hasPoiDatas() == false) goto L11;
        CommSenseLog.iWithMethodName(TAG, "poi_datas already exists, skip network request");
        return true;
    L11:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L15;
        CommSenseLog.wWithMethodName(TAG, "Network invalid.");
        return false;
    L15:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L28;
        CommSenseLog.wWithMethodName(TAG, "execute asynchronously on main thread");
        sPoiExecutor.submit(new c(this));
        return false;
    L28:
        return ((Boolean) sPoiExecutor.submit(new d(this, r10)).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)).booleanValue();
    L22:
        e = e;
        String r11 = "catch RuntimeException";
    L26:
        CommSenseLog.eWithMethodName(TAG, r11, e);
        return false;
    L24:
        e = e;
        r11 = "catch TimeoutException";
    L20:
        e = e;
        r11 = "catch exception";
        goto L26
    }

    public Bundle searchDirectionFromBmap(BmapBaseDirectionRequest r10, int r11) {
        long r8 = System.currentTimeMillis();
        if (r11 == 1) goto L34;
        if (r11 == 2) goto L27;
        if (r11 == 3) goto L20;
        if (r11 == 4) goto L13;
        String r12 = "Unimplemented direction type: " + r11;
        CommSenseLog.dWithMethodName(TAG, r12);
    L11:
        String r13 = r12;
        Bundle r14 = createDirectionErrorBundle(-1, r12, r10, r11);
        BmapRidingDirectionResponse r15 = null;
    L41:
        reportDirectionSearchTea(r11, r10, r15, r8, r13);
        return r14;
    L13:
        if ((r10 instanceof BmapRidingDirectionRequest) == true) goto L15;
        r12 = "invalid riding request";
        goto L11
    L15:
        BmapRidingDirectionResponse r16 = searchRidingDirectionFromBmap((BmapRidingDirectionRequest) r10);
        if (r16 != null) goto L18;
        r12 = "riding search failed";
        goto L11
    L18:
        Bundle r17 = toBundle(r16);
        BmapRidingDirectionResponse r18 = r16;
    L40:
        r15 = r18;
        r14 = r17;
        r13 = null;
        goto L41
    L20:
        if ((r10 instanceof BmapWalkingDirectionRequest) == true) goto L22;
        r12 = "invalid walking request";
        goto L11
    L22:
        BmapWalkingDirectionResponse r19 = searchWalkingDirectionFromBmap((BmapWalkingDirectionRequest) r10);
        if (r19 != null) goto L25;
        r12 = "walking search failed";
        goto L11
    L25:
        r17 = toBundle(r19);
        r18 = r19;
        goto L40
    L27:
        if ((r10 instanceof BmapDrivingDirectionRequest) == true) goto L29;
        r12 = "invalid driving request";
        goto L11
    L29:
        BmapDrivingDirectionResponse r20 = searchDrivingDirectionFromBmap((BmapDrivingDirectionRequest) r10);
        if (r20 != null) goto L32;
        r12 = "driving search failed";
        goto L11
    L32:
        r17 = toBundle(r20);
        r18 = r20;
        goto L40
    L34:
        if ((r10 instanceof BmapTransitDirectionRequest) == true) goto L36;
        r12 = "invalid transit request";
        goto L11
    L36:
        BmapTransitDirectionResponse r21 = searchTransitDirectionFromBmap((BmapTransitDirectionRequest) r10);
        if (r21 != null) goto L39;
        r12 = "transit search failed";
        goto L11
    L39:
        r17 = toBundle(r21);
        r18 = r21;
        goto L40
    }

    public BmapDrivingDirectionResponse searchDrivingDirectionFromBmap(BmapDrivingDirectionRequest r8) {
        return (BmapDrivingDirectionResponse) searchDirectionFromBmapInternal(r8, "DRIVING_SEARCH", new b(0, this, r8));
    }

    public MapPoiTextSearchResult searchMapPoiTextResult(String r15, int r16, int r17, String r18, String r19) {
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L7;
        CommSenseLog.wWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: Network invalid.");
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "network invalid");
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L21;
        CommSenseLog.wWithMethodName(TAG, "TEXT_SEARCH_MAP_POI: skip sync query on main thread, keyword=" + safeString(r15) + ", city=" + safeString(r18));
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "main thread");
    L21:
        return (MapPoiTextSearchResult) sPoiExecutor.submit(new f(this, r15, r16, r17, r18, r19, 1)).get(POI_HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    L15:
        e = e;
        String r8 = "TEXT_SEARCH_MAP_POI: catch RuntimeException";
    L19:
        CommSenseLog.eWithMethodName(TAG, r8, e);
        return new MapPoiTextSearchResult(false, new ArrayList(), null, "exception");
    L17:
        e = e;
        r8 = "TEXT_SEARCH_MAP_POI: catch TimeoutException";
    L13:
        e = e;
        r8 = "TEXT_SEARCH_MAP_POI: catch exception";
        goto L19
    }

    public Map<String, List<CommonPOIInfo>> searchPoiTextFromBd(String r8, int r10, int r11, String r12, String r13) {
        Map<String, List<CommonPOIInfo>> r14 = searchPoiTextResultFromBd(r8, r10, r11, r12, r13).items;
        if (r14 != null) goto L5;
        return null;
    L5:
        if (r14.isEmpty() == true) goto L9;
        return r14;
    L9:
        return null;
    }

    public PoiTextSearchResult searchPoiTextResultFromBd(String r8, int r10, int r11, String r12, String r13) {
        return performBdPoiTextSearch(this.appContext, r8, r10, r11, r12, r13);
    }

    public BmapRidingDirectionResponse searchRidingDirectionFromBmap(BmapRidingDirectionRequest r8) {
        return (BmapRidingDirectionResponse) searchDirectionFromBmapInternal(r8, "RIDING_SEARCH", new com.obric.cae.cldReport.b(2, this, r8));
    }

    public BmapTransitDirectionResponse searchTransitDirectionFromBmap(BmapTransitDirectionRequest r8) {
        return (BmapTransitDirectionResponse) searchDirectionFromBmapInternal(r8, "TRANSIT_SEARCH", new com.obric.cae.cldReport.b(1, this, r8));
    }

    public BmapWalkingDirectionResponse searchWalkingDirectionFromBmap(BmapWalkingDirectionRequest r8) {
        return (BmapWalkingDirectionResponse) searchDirectionFromBmapInternal(r8, "WALKING_SEARCH", new a(0, this, r8));
    }

    private p findMapPoiCellsElement(p r11, int r12) {
        if (r11 != null) goto L5;
    L38:
        return null;
    L5:
        if ((r11 instanceof r) == true) goto L38;
        if (r12 > 8) goto L38;
        p r13 = parseJsonPayloadIfNeeded(r11);
        if (r13 == null) goto L38;
        if ((r13 instanceof r) == true) goto L38;
        if ((r13 instanceof m) == false) goto L18;
        return r13;
    L18:
        if ((r13 instanceof s) == true) goto L20;
        return null;
    L20:
        s r14 = r13.f();
        p r8 = getValueByKeyCompat(r14, StarLocationDbManager.AoiBoardEntry.CELLS);
        if (r8 != null) goto L23;
    L31:
        String[] r10 = {"data", "result", "results", "list", "items", "poi_list", "poiList"};
        int r15 = 0;
    L33:
        if (r15 >= 7) goto L38;
        p r16 = findMapPoiCellsElement(getValueByKeyCompat(r14, r10[r15]), r12 + 1);
        if (r16 != null) goto L36;
        r15 = r15 + 1;
        goto L33
    L36:
        return r16;
    L23:
        if ((r8 instanceof r) == true) goto L31;
        p r17 = parseJsonPayloadIfNeeded(r8);
        if (r17 == null) goto L31;
        if ((r17 instanceof m) == false) goto L29;
    L30:
        return r17;
    L29:
        if ((r17 instanceof r) == false) goto L31;
        goto L30
    }

    private Bundle toBundle(BmapDrivingDirectionResult r8) {
        Bundle r10 = new Bundle();
        r10.putString("restriction", r8.restriction);
        putInteger(r10, LBSLightLocationTraceLogger.TOTAL, r8.total);
        r10.putString(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, r8.sessionId);
        putBundleList(r10, "routes", toDrivingRouteBundleList(r8.routes));
        return r10;
    }

    public Bundle createDirectionErrorBundle(int r8, String r10, BmapBaseDirectionRequest r11, int r12) {
        Bundle r13 = new Bundle();
        r13.putInt("status", r8);
        r13.putString("message", r10);
        return r13;
    }

    private void logJsonPayload(String r8, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L10;
        CommSenseLog.dWithMethodName(TAG, r8 + ": " + r10 + "=<empty>");
        return;
    L10:
        logJsonPayload(r8, r10, l6.a.z0(r11));     // Catch: Exception -> L8
        return;
    L8:
        CommSenseLog.dWithMethodName(TAG, r8 + ": " + r10 + "=" + r11);
    }

    private Bundle toBundle(BmapDrivingRoute r8) {
        Bundle r10 = new Bundle();
        BmapTransitLocation r11 = r8.origin;
        if (r11 == null) goto L5;
        r10.putBundle("origin", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.destination;
        if (r12 == null) goto L8;
        r10.putBundle("destination", toBundle(r12));
    L8:
        r10.putString(LocationMonitorConst.TAG, r8.tag);
        r10.putString("mrsl", r8.mrsl);
        r10.putString("route_md5", r8.routeMd5);
        putInteger(r10, "traffic_light", r8.trafficLight);
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        putDouble(r10, "taxi_fee", r8.taxiFee);
        putBundleList(r10, "steps", toDrivingStepBundleList(r8.steps));
        return r10;
    }

    private Bundle toBundle(BmapDrivingStep r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "leg_index", r8.legIndex);
        putInteger(r10, "link_num", r8.linkNum);
        r10.putString("road_name", r8.roadName);
        putInteger(r10, "direction", r8.direction);
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        putInteger(r10, "road_type", r8.roadType);
        putDouble(r10, "toll", r8.toll);
        putInteger(r10, "toll_distance", r8.tollDistance);
        r10.putString("adcodes", r8.adcodes);
        r10.putString("instructions", r8.roadName);
        r10.putString("path", r8.path);
        putJsonElement(r10, "traffic_condition", r8.trafficCondition);
        BmapTransitLocation r11 = r8.startLocation;
        if (r11 == null) goto L5;
        r10.putBundle("start_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.endLocation;
        if (r12 == null) goto L8;
        r10.putBundle("end_location", toBundle(r12));
    L8:
        return r10;
    }

    private boolean isPrivacyIdAttestationCertExpired(String r8) {
        return isPrivacyIdAttestationCertExpired(parseJsonElementLenient(r8), 0);
    }

    private Bundle toBundle(BmapRidingDirectionNode r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "area_id", r8.areaId);
        r10.putString("cname", r8.cityName);
        r10.putString("uid", r8.uid);
        r10.putString("wd", r8.f5656wd);
        BmapTransitLocation r11 = r8.location;
        if (r11 == null) goto L5;
        r10.putBundle(LocationMonitorConst.LOCATION, toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapRidingDirectionResponse r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "status", r8.status);
        r10.putString("message", r8.message);
        putInteger(r10, "type", r8.type);
        BmapRidingDirectionResult r11 = r8.result;
        if (r11 == null) goto L5;
        r10.putBundle("result", toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapRidingDirectionResult r8) {
        Bundle r10 = new Bundle();
        BmapRidingDirectionNode r11 = r8.origin;
        if (r11 == null) goto L5;
        r10.putBundle("origin", toBundle(r11));
    L5:
        BmapRidingDirectionNode r12 = r8.destination;
        if (r12 == null) goto L8;
        r10.putBundle("destination", toBundle(r12));
    L8:
        putBundleList(r10, "routes", toRidingRouteBundleList(r8.routes));
        return r10;
    }

    private Bundle toBundle(BmapRidingLink r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "length", r8.length);
        putInteger(r10, "attr", r8.attr);
        return r10;
    }

    private Bundle toBundle(BmapRidingRoute r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "restrictions_status", r8.restrictionsStatus);
        r10.putString("restrictions_info", r8.restrictionsInfo);
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        BmapTransitLocation r11 = r8.originLocation;
        if (r11 == null) goto L5;
        r10.putBundle("origin_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.destinationLocation;
        if (r12 == null) goto L8;
        r10.putBundle("destination_location", toBundle(r12));
    L8:
        putBundleList(r10, "steps", toRidingStepBundleList(r8.steps));
        return r10;
    }

    private Bundle toBundle(BmapRidingStep r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "leg_index", r8.legIndex);
        putInteger(r10, "area", r8.area);
        putInteger(r10, "direction", r8.direction);
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        r10.putString("instructions", r8.instructions);
        r10.putString("name", r8.name);
        r10.putString("path", r8.path);
        putJsonElement(r10, StarCellDbManager.CellInfoEntry.POIS, r8.pois);
        putInteger(r10, "type", r8.type);
        r10.putString("turn_type", r8.turnType);
        r10.putString("restrictions_info", r8.restrictionsInfo);
        r10.putString("step_origin_instruction", r8.stepOriginInstruction);
        r10.putString("step_destination_instruction", r8.stepDestinationInstruction);
        putInteger(r10, "restrictions_status", r8.restrictionsStatus);
        BmapTransitLocation r11 = r8.startLocation;
        if (r11 == null) goto L5;
        r10.putBundle("start_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.endLocation;
        if (r12 == null) goto L8;
        r10.putBundle("end_location", toBundle(r12));
    L8:
        putBundleList(r10, "links", toRidingLinkBundleList(r8.links));
        return r10;
    }

    private Bundle toBundle(BmapTransitDirectionNode r8) {
        Bundle r10 = new Bundle();
        r10.putString("city_id", r8.cityId);
        r10.putString("city_name", r8.cityName);
        BmapTransitLocation r11 = r8.location;
        if (r11 == null) goto L5;
        r10.putBundle(LocationMonitorConst.LOCATION, toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapTransitDirectionResponse r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "status", r8.status);
        r10.putString("message", r8.message);
        putInteger(r10, "type", r8.type);
        putInteger(r10, "transit_type", r8.transitType);
        BmapTransitDirectionResult r11 = r8.result;
        if (r11 == null) goto L5;
        r10.putBundle("result", toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapTransitDirectionResult r8) {
        Bundle r10 = new Bundle();
        BmapTransitDirectionNode r11 = r8.origin;
        if (r11 == null) goto L5;
        r10.putBundle("origin", toBundle(r11));
    L5:
        BmapTransitDirectionNode r12 = r8.destination;
        if (r12 == null) goto L8;
        r10.putBundle("destination", toBundle(r12));
    L8:
        BmapTransitTaxiInfo r13 = r8.taxi;
        if (r13 == null) goto L11;
        r10.putBundle("taxi", toBundle(r13));
    L11:
        putInteger(r10, LBSLightLocationTraceLogger.TOTAL, r8.total);
        putBundleList(r10, "routes", toRouteBundleList(r8.routes));
        return r10;
    }

    private Bundle toBundle(BmapTransitLocation r8) {
        Bundle r10 = new Bundle();
        r10.putDouble("lat", r8.lat);
        r10.putDouble("lng", r8.lng);
        return r10;
    }

    private Bundle toBundle(BmapTransitPriceDetail r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "ticket_type", r8.ticketType);
        putDouble(r10, "ticket_price", r8.ticketPrice);
        return r10;
    }

    private Bundle toBundle(BmapTransitRoute r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        putDouble(r10, "price", r8.price);
        r10.putString("arrive_time", r8.arriveTime);
        putBundleList(r10, "price_detail", toPriceDetailBundleList(r8.priceDetail));
        putBundleList(r10, "steps", toStepGroupBundleList(r8.steps));
        return r10;
    }

    private Bundle toBundle(BmapTransitScheme r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        r10.putString("instructions", r8.instructions);
        r10.putString("path", r8.path);
        BmapTransitLocation r11 = r8.startLocation;
        if (r11 == null) goto L5;
        r10.putBundle("start_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.endLocation;
        if (r12 == null) goto L8;
        r10.putBundle("end_location", toBundle(r12));
    L8:
        BmapTransitVehicleInfo r13 = r8.vehicleInfo;
        if (r13 == null) goto L11;
        r10.putBundle("vehicle_info", toBundle(r13));
    L11:
        return r10;
    }

    private Bundle toBundle(BmapTransitStep r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        r10.putString("instructions", r8.instructions);
        r10.putString("path", r8.path);
        putJsonElement(r10, "traffic_condition", r8.trafficCondition);
        BmapTransitLocation r11 = r8.startLocation;
        if (r11 == null) goto L5;
        r10.putBundle("start_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.endLocation;
        if (r12 == null) goto L8;
        r10.putBundle("end_location", toBundle(r12));
    L8:
        BmapTransitVehicleInfo r13 = r8.vehicleInfo;
        if (r13 == null) goto L11;
        r10.putBundle("vehicle_info", toBundle(r13));
    L11:
        putBundleList(r10, "schemes", toSchemeBundleList(r8.schemes));
        return r10;
    }

    private Bundle toBundle(BmapTransitTaxiDetail r8) {
        Bundle r10 = new Bundle();
        r10.putString("desc", r8.desc);
        putDouble(r10, "km_price", r8.kmPrice);
        putDouble(r10, "start_price", r8.startPrice);
        putDouble(r10, "total_price", r8.totalPrice);
        return r10;
    }

    private Bundle toBundle(BmapTransitTaxiInfo r8) {
        Bundle r10 = new Bundle();
        putBundleList(r10, "detail", toTaxiDetailBundleList(r8.detail));
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        r10.putString("remark", r8.remark);
        return r10;
    }

    private Bundle toBundle(BmapTransitVehicleInfo r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "type", r8.type);
        putJsonElement(r10, "detail", r8.detail);
        return r10;
    }

    private Bundle toBundle(BmapWalkingDirectionNode r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "area_id", r8.areaId);
        r10.putString("cname", r8.cityName);
        r10.putString("uid", r8.uid);
        r10.putString("wd", r8.f5657wd);
        BmapTransitLocation r11 = r8.location;
        if (r11 == null) goto L5;
        r10.putBundle(LocationMonitorConst.LOCATION, toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapWalkingDirectionResponse r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "status", r8.status);
        r10.putString("message", r8.message);
        putInteger(r10, "type", r8.type);
        BmapWalkingDirectionResult r11 = r8.result;
        if (r11 == null) goto L5;
        r10.putBundle("result", toBundle(r11));
    L5:
        return r10;
    }

    private Bundle toBundle(BmapWalkingDirectionResult r8) {
        Bundle r10 = new Bundle();
        BmapWalkingDirectionNode r11 = r8.origin;
        if (r11 == null) goto L5;
        r10.putBundle("origin", toBundle(r11));
    L5:
        BmapWalkingDirectionNode r12 = r8.destination;
        if (r12 == null) goto L8;
        r10.putBundle("destination", toBundle(r12));
    L8:
        putBundleList(r10, "routes", toWalkingRouteBundleList(r8.routes));
        return r10;
    }

    private Bundle toBundle(BmapWalkingRoute r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        BmapTransitLocation r11 = r8.originLocation;
        if (r11 == null) goto L5;
        r10.putBundle("origin_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.destinationLocation;
        if (r12 == null) goto L8;
        r10.putBundle("destination_location", toBundle(r12));
    L8:
        putBundleList(r10, "steps", toWalkingStepBundleList(r8.steps));
        return r10;
    }

    private Bundle toBundle(BmapWalkingStep r8) {
        Bundle r10 = new Bundle();
        putInteger(r10, "leg_index", r8.legIndex);
        putInteger(r10, "area", r8.area);
        putInteger(r10, "direction", r8.direction);
        putInteger(r10, "distance", r8.distance);
        putInteger(r10, "duration", r8.duration);
        r10.putString("instructions", r8.instructions);
        r10.putString("name", r8.name);
        r10.putString("path", r8.path);
        putJsonElement(r10, StarCellDbManager.CellInfoEntry.POIS, r8.pois);
        putInteger(r10, "type", r8.type);
        putInteger(r10, "turn_type_id", r8.turnTypeId);
        r10.putString("step_origin_instruction", r8.stepOriginInstruction);
        r10.putString("step_destination_instruction", r8.stepDestinationInstruction);
        BmapTransitLocation r11 = r8.startLocation;
        if (r11 == null) goto L5;
        r10.putBundle("start_location", toBundle(r11));
    L5:
        BmapTransitLocation r12 = r8.endLocation;
        if (r12 == null) goto L8;
        r10.putBundle("end_location", toBundle(r12));
    L8:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Bundle toBundle(s r8) {
        Bundle r10 = new Bundle();
        ja.s.b.a r11 = new ja.s.b.a(r8.o());
    L4:
        if (r11.hasNext() == false) goto L6;
        ja.s.e<K, V> r12 = r11.a();
        putJsonElement(r10, (String) r12.f8804p, (p) r12.f8806r);
        goto L4
    L6:
        return r10;
    }
}
