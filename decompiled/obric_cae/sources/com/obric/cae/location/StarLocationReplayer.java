package com.obric.cae.location;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r1.s;

/* JADX INFO: loaded from: classes.dex */
public final class StarLocationReplayer {
    private static final String LEGACY_BUNDLE_END = "}]";
    private static final String LEGACY_BUNDLE_START = "[{";
    private static final String LEGACY_EXTRA_MARKER = ", extra=";
    private static final String LEGACY_PREFIX = "LocationSource[";

    public interface ReplayCallback {
        boolean onReplay(StarLocationManager.LocationSource r8);
    }

    private StarLocationReplayer() {
    }

    public static /* synthetic */ boolean a(StarLocationManager.LocationSource r8) {
        return lambda$replay$0(r8);
    }

    private static String extractJsonObject(String r12) {
        int r8 = r12.indexOf(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID);
        if (r8 >= 0) goto L5;
        return null;
    L5:
        int r10 = r8;
        boolean r11 = false;
        boolean r13 = false;
        int r14 = 0;
    L7:
        if (r10 >= r12.length()) goto L30;
        char r15 = r12.charAt(r10);
        if (r11 == false) goto L17;
        if (r13 == false) goto L13;
        r13 = false;
    L29:
        r10 = r10 + 1;
        goto L7
    L13:
        if (r15 != '\\') goto L15;
        r13 = true;
        goto L29
    L15:
        if (r15 != '\"') goto L29;
        r11 = false;
        goto L29
    L17:
        if (r15 != '\"') goto L19;
        r11 = true;
        goto L29
    L19:
        if (r15 != '{') goto L22;
        r14 = r14 + 1;
        goto L29
    L22:
        if (r15 != '}') goto L29;
        r14 = r14 - 1;
        if (r14 == 0) goto L26;
        if (r14 >= 0) goto L29;
        return null;
    L26:
        return r12.substring(r8, r10 + 1);
    L30:
        return null;
    }

    private static Object inferLegacyValue(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.trim();
        if (r10.isEmpty() == false) goto L10;
        return "";
    L10:
        if ("true".equalsIgnoreCase(r10) == true) goto L27;
        if ("false".equalsIgnoreCase(r10) == true) goto L27;
        if (r10.contains(".") == true) goto L25;
        long r11 = Long.parseLong(r10);     // Catch: NumberFormatException -> L28
        if (r11 > 2147483647L) goto L23;
        if (r11 < (-2147483648L)) goto L23;
        return Integer.valueOf((int) r11);
    L23:
        return Long.valueOf(r11);
    L25:
        return Double.valueOf(Double.parseDouble(r10));
    L30:
        return r10;
    L27:
        return Boolean.valueOf(Boolean.parseBoolean(r10));
    }

    private static /* synthetic */ boolean lambda$replay$0(StarLocationManager.LocationSource r8) {
        return StarLocationManager.getInstance().replayLocationSource(r8);
    }

    private static boolean parseBoolean(String r8, boolean r10) {
        if (r8 != null) goto L5;
        return r10;
    L5:
        return Boolean.parseBoolean(r8);
    }

    private static CoordinateTransformUtils.CoordinateSystem parseCoordinateSystem(String r8) {
        if (r8 == null) goto L11;
        if (r8.isEmpty() == true) goto L11;
        return CoordinateTransformUtils.CoordinateSystem.valueOf(r8);
    L9:
        return CoordinateTransformUtils.CoordinateSystem.WGS84;
    L11:
        return CoordinateTransformUtils.CoordinateSystem.WGS84;
    }

    private static double parseDouble(String r8, double r10) {
        if (r8 == null) goto L9;
        return Double.parseDouble(r8);
    L10:
        return r10;
    L9:
        return r10;
    }

    public static List<StarLocationManager.LocationSource> parseFile(File r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L24:
        return r10;
    L5:
        if (r8.exists() == false) goto L24;
        if (r8.isFile() == false) goto L24;
        BufferedReader r11 = new BufferedReader(new FileReader(r8));
    L25:
        String r12 = r11.readLine();     // Catch: Throwable -> L18
        if (r12 == null) goto L16;
        StarLocationManager.LocationSource r13 = parseLine(r12);     // Catch: Throwable -> L18
        if (r13 == null) goto L25;
        r10.add(r13);     // Catch: Throwable -> L18
        goto L25
    L16:
        r11.close();
        return r10;
    L18:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L21
    L23:
        throw th;
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    }

    private static float parseFloat(String r8, float r10) {
        if (r8 == null) goto L9;
        return Float.parseFloat(r8);
    L10:
        return r10;
    L9:
        return r10;
    }

    private static int parseInt(String r8, int r10) {
        if (r8 == null) goto L9;
        return Integer.parseInt(r8);
    L10:
        return r10;
    L9:
        return r10;
    }

    private static StarLocationManager.LocationSource parseJsonFromLine(String r8) {
        String r10 = extractJsonObject(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        return parseJsonLine(r10);
    }

    private static StarLocationManager.LocationSource parseJsonLine(String r8) {
        return StarLocationManager.LocationSource.fromJsonString(r8);
    L4:
        return null;
    }

    private static Bundle parseLegacyBundle(String r8) {
        Bundle r10 = new Bundle();
        if (r8 != null) goto L5;
    L21:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L21;
        int r11 = r8.indexOf(LEGACY_BUNDLE_START);
        int r12 = r8.lastIndexOf(LEGACY_BUNDLE_END);
        if (r11 < 0) goto L21;
        if (r12 < r11) goto L21;
        String r13 = r8.substring(r11 + 2, r12);
        if (r13.isEmpty() == false) goto L14;
        return r10;
    L14:
        String[] r14 = r13.split(", ");
        int r15 = r14.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L21;
        String r17 = r14[r16];
        int r18 = r17.indexOf(61);
        if (r18 <= 0) goto L20;
        putLegacyBundleValue(r10, r17.substring(0, r18), inferLegacyValue(r17.substring(r18 + 1)));
    L20:
        r16 = r16 + 1;
        goto L15
    }

    private static Map<String, String> parseLegacyFields(String r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        int r11 = r8.indexOf(LEGACY_PREFIX);
        int r12 = r8.lastIndexOf(93);
        if (r11 < 0) goto L22;
        if (r12 <= r11) goto L22;
        String r13 = r8.substring(r11 + 15, r12);
        int r14 = r13.indexOf(LEGACY_EXTRA_MARKER);
        if (r14 < 0) goto L9;
        String r15 = r13.substring(0, r14);
    L10:
        if (r14 < 0) goto L12;
        String r16 = r13.substring(r14 + 8);
    L13:
        String[] r17 = r15.split(", ");
        int r18 = r17.length;
        int r19 = 0;
    L14:
        if (r19 >= r18) goto L20;
        String r20 = r17[r19];
        int r21 = r20.indexOf(61);
        if (r21 <= 0) goto L19;
        r10.put(r20.substring(0, r21), r20.substring(r21 + 1));
    L19:
        r19 = r19 + 1;
        goto L14
    L20:
        if (r16 == null) goto L22;
        r10.put(WsConstants.KEY_EXTRA, r16);
        goto L22
    L12:
        r16 = null;
        goto L13
    L9:
        r15 = r13;
    L22:
        return r10;
    }

    private static StarLocationManager.LocationSource parseLegacyLine(String r8) {
        Map<String, String> r10 = parseLegacyFields(r8);
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return new StarLocationManager.LocationSource().setSource(parseInt(r10.get("source"), 0)).setProvider(r10.get("provider")).setLatitude(parseDouble(r10.get("latitude"), 0.0d)).setLongitude(parseDouble(r10.get(StarCellDbManager.CellInfoEntry.LONGITUDE), 0.0d)).setRadius(parseFloat(r10.get("radius"), 0.0f)).setCoordSys(parseCoordinateSystem(r10.get("coordSys"))).setConfidence(parseInt(r10.get("confidence"), 0)).setUpdateTs(parseLong(r10.get("updateTs"), 0)).setElapsedRealtimeNanos(parseLong(r10.get("elapsedRealtimeNanos"), 0)).setLocationTime(parseLong(r10.get("locationTime"), 0)).setSimReady(parseBoolean(r10.get("simReady"), false)).setWifiConnected(parseBoolean(r10.get("wifiConnected"), false)).setMock(parseBoolean(r10.get("mock"), false)).setUserId(parseInt(r10.get(StarLocationDbManager.GeofenceEntry.USER_ID), 0)).setExtra(parseLegacyBundle(r10.get(WsConstants.KEY_EXTRA)));
    }

    public static StarLocationManager.LocationSource parseLine(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.trim();
        if (r10.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r10.startsWith("{") == false) goto L13;
        return parseJsonFromLine(r10);
    L13:
        if (r10.contains(LEGACY_PREFIX) == false) goto L17;
        return parseLegacyLine(r10);
    L17:
        return parseJsonFromLine(r10);
    }

    public static List<StarLocationManager.LocationSource> parseLines(List<String> r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
        return r10;
    L5:
        Iterator<String> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        StarLocationManager.LocationSource r12 = parseLine(r11.next());
        if (r12 == null) goto L7;
        r10.add(r12);
        goto L7
    L11:
        return r10;
    }

    private static long parseLong(String r8, long r10) {
        if (r8 == null) goto L9;
        return Long.parseLong(r8);
    L10:
        return r10;
    L9:
        return r10;
    }

    private static void putLegacyBundleValue(Bundle r8, String r10, Object r11) {
        if ((r11 instanceof Integer) == false) goto L6;
        r8.putInt(r10, ((Integer) r11).intValue());
        return;
    L6:
        if ((r11 instanceof Long) == false) goto L9;
        r8.putLong(r10, ((Long) r11).longValue());
        return;
    L9:
        if ((r11 instanceof Double) == false) goto L12;
        r8.putDouble(r10, ((Double) r11).doubleValue());
        return;
    L12:
        if ((r11 instanceof Boolean) == false) goto L14;
        r8.putBoolean(r10, ((Boolean) r11).booleanValue());
        return;
    L14:
        if (r11 == null) goto L21;
        r8.putString(r10, String.valueOf(r11));
        return;
    }

    public static int replay(List<StarLocationManager.LocationSource> r8) {
        return replay(r8, new s(2));
    }

    public static int replay(List<StarLocationManager.LocationSource> r8, ReplayCallback r10) {
        int r11 = 0;
        if (r8 != null) goto L5;
    L16:
        return r11;
    L5:
        if (r8.isEmpty() == true) goto L16;
        Iterator<StarLocationManager.LocationSource> r12 = r8.iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        StarLocationManager.LocationSource r13 = r12.next();
        if (r13 == null) goto L9;
        if (r10.onReplay(r13.copy()) == false) goto L9;
        r11 = r11 + 1;
        goto L9
    }
}
