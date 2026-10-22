package com.obric.cae.location.city;

import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class PoiSearchCollector {
    private static final int POI_SEARCH_DID_NOT_READY_CODE = 102000011;
    private static final int POI_SEARCH_MAX_REQUEST_COUNT = 10;
    private static final int POI_SEARCH_PAGE_SIZE = 20;
    private static final int POI_SEARCH_SUCCESS_CODE = 0;
    private static final int POI_SEARCH_SUCCESS_EMPTY_CODE = 102000001;

    /* JADX INFO: renamed from: com.obric.cae.location.city.PoiSearchCollector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface CandidateKeyProvider {
        String getCandidateKey(BdLocationManager.CommonPOIInfo r8);
    }

    public static final class Result {
        final List<BdLocationManager.CommonPOIInfo> candidates;
        final boolean success;

        private Result(boolean r8, List<BdLocationManager.CommonPOIInfo> r10) {
            this.success = r8;
            this.candidates = r10;
        }

        public /* synthetic */ Result(boolean r8, List r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    private PoiSearchCollector() {
    }

    public static Result collect(String r18, String r19, List<String> r20, List<String> r21, String r22, String r23, int r24, boolean r25, CandidateKeyProvider r26) {
        boolean r8 = true;
        int r10 = Math.max(1, Math.min(r24, 10));
        if (r21.isEmpty() == false) goto L5;
        List<String> r11 = Collections.singletonList("");
    L6:
        LinkedHashMap r12 = new LinkedHashMap();
        boolean r13 = false;
        AnonymousClass1 r14 = null;
        Iterator<String> r15 = r11.iterator();     // Catch: Throwable -> L24
    L9:
        if (r15.hasNext() == false) goto L23;
        String r16 = r15.next();     // Catch: Throwable -> L24
        Iterator<String> r17 = r20.iterator();     // Catch: Throwable -> L24
    L12:
        if (r17.hasNext() == false) goto L9;
        String r27 = r17.next();     // Catch: Throwable -> L24
        if (r27 == null) goto L12;
        if (r27.isEmpty() == true) goto L12;
        if (collectPages(r18, r19, r27, r16, r22, r23, r10, r25, r26, r12) == true) goto L12;
        return new Result(r13, Collections.emptyList(), r14);
    L23:
        return new Result(r8, new ArrayList(r12.values()), r14);
    L24:
        th = move-exception;
        CommSenseLog.eWithMethodName(r18, r23 + " poi search exception, city=" + r19, th);
        return new Result(r13, Collections.emptyList(), r14);
    L5:
        r11 = r21;
        goto L6
    }

    private static int collectPageCandidates(Map<String, BdLocationManager.CommonPOIInfo> r8, Map<String, List<BdLocationManager.CommonPOIInfo>> r10, CandidateKeyProvider r11, boolean r12) {
        Iterator<List<BdLocationManager.CommonPOIInfo>> r13 = r10.values().iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L23;
        List<BdLocationManager.CommonPOIInfo> r15 = r13.next();
        if (r15 == null) goto L4;
        r14 = r14 + r15.size();
        Iterator<BdLocationManager.CommonPOIInfo> r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L4;
        BdLocationManager.CommonPOIInfo r17 = r16.next();
        if (r17 == null) goto L10;
        String r18 = r11.getCandidateKey(r17);
        if (r18 == null) goto L10;
        if (r18.isEmpty() == true) goto L10;
        if (r12 == true) goto L22;
        if (r8.containsKey(r18) == true) goto L10;
    L22:
        r8.put(r18, r17);
        goto L10
    L23:
        return r14;
    }

    private static boolean collectPages(String r16, String r17, String r18, String r19, String r20, String r21, int r22, boolean r23, CandidateKeyProvider r24, Map<String, BdLocationManager.CommonPOIInfo> r25) {
        int r12 = 1;
    L3:
        if (r12 > r22) goto L19;
        CommSenseLog.dWithMethodName(r16, r21 + " request: keyword=" + r18 + ", index=" + r20 + ", pageNum=" + r12 + ", pageSize=20, dsl=" + r19 + ", requestCount=" + r22);
        BdLocationManager.PoiTextSearchResult r8 = BdLocationManager.getInstance().searchPoiTextResultFromBd(r18, r12, 20, r20, r19);
        if (isPoiSearchSuccess(r8) == false) goto L6;
        Map<String, List<BdLocationManager.CommonPOIInfo>> r10 = r8.items;
        if (r10 == null) goto L17;
        if (r10.isEmpty() == true) goto L17;
        if (collectPageCandidates(r25, r10, r24, r23) <= 0) goto L15;
        r12 = r12 + 1;
        goto L3
    L15:
        StringBuilder r11 = new StringBuilder();
        r11.append(r21);
        String r13 = " result size=0 for city=";
    L18:
        r11.append(r13);
        r11.append(r17);
        r11.append(", keyword=");
        r11.append(r18);
        r11.append(", pageNum=");
        r11.append(r12);
        r11.append(", stop paging");
        CommSenseLog.dWithMethodName(r16, r11.toString());
    L17:
        r11 = new StringBuilder();
        r11.append(r21);
        r13 = " empty result for city=";
        goto L18
    L6:
        logSearchFailure(r16, r17, r18, r21, r8);
        return false;
    L19:
        return true;
    }

    private static boolean isPoiSearchSuccess(BdLocationManager.PoiTextSearchResult r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        Map<String, List<BdLocationManager.CommonPOIInfo>> r10 = r8.items;
        if (r10 != null) goto L8;
    L10:
        Integer r11 = r8.code;
        if (r11 != null) goto L13;
        return false;
    L13:
        if (r11.intValue() == 0) goto L17;
        if (r11.intValue() == POI_SEARCH_SUCCESS_EMPTY_CODE) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (r10.isEmpty() == true) goto L10;
        return true;
    }

    private static void logSearchFailure(String r8, String r10, String r11, String r12, BdLocationManager.PoiTextSearchResult r13) {
        String r14 = null;
        if (r13 != null) goto L5;
        Integer r15 = null;
    L6:
        if (r13 == null) goto L10;
        r14 = r13.msg;
    L10:
        if (r15 != null) goto L12;
    L16:
        StringBuilder r16 = new StringBuilder();
        r16.append(r12);
        String r17 = " poi search failed, city=";
    L14:
        r16.append(r17);
        r16.append(r10);
        r16.append(", keyword=");
        r16.append(r11);
        r16.append(", code=");
        r16.append(r15);
        r16.append(", msg=");
        r16.append(r14);
        CommSenseLog.wWithMethodName(r8, r16.toString());
        return;
    L12:
        if (r15.intValue() != POI_SEARCH_DID_NOT_READY_CODE) goto L16;
        r16 = new StringBuilder();
        r16.append(r12);
        r17 = " poi search did not ready, city=";
        goto L14
    L5:
        r15 = r13.code;
        goto L6
    }
}
