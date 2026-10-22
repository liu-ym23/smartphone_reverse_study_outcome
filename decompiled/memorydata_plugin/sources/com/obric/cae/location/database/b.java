package com.obric.cae.location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.userAware.datacollection.TrafficRecognitionInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.obric.cae.location.geosdk.poi.a.InterfaceC0356a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7072a;

    public b(Context r3, int r4) {
        this.f7072a = c.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public int a(Set<AoiBoard.Type> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        c r6 = this.f7072a;
        monitor-enter(r6);
        int r1 = 0;
        if (r8.isEmpty() == true) goto L19;
        StringBuilder r0 = new StringBuilder("type IN (");     // Catch: Throwable -> L25
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L25
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L25
    L9:
        if (r9.hasNext() == false) goto L18;
        AoiBoard.Type r3 = (AoiBoard.Type) ZeusTransformUtils.preCheckCast(r9.next(), AoiBoard.Type.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r3 == null) goto L9;
        if (r2.isEmpty() == true) goto L16;
        r0.append(',');     // Catch: Throwable -> L25
    L16:
        r0.append('?');     // Catch: Throwable -> L25
        r2.add(String.valueOf(r3.ordinal()));     // Catch: Throwable -> L25
        goto L9
    L18:
        if (r2.isEmpty() == true) goto L19;
        r0.append(')');     // Catch: Throwable -> L25
        r1 = r6.a(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r0.toString(), (String[]) ZeusTransformUtils.preCheckCast(r2.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
    L19:
        monitor-exit(r6);
        return r1;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public AoiBoard a(String r13) {
        c r12 = this.f7072a;
        monitor-enter(r12);
        AoiBoard r0 = null;
        if (r13 != null) goto L19;
    L17:
        monitor-exit(r12);
        return r0;
    L19:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r13.isEmpty() == true) goto L17;
        ArrayList r14 = c.b(r12.a(TrafficRecognitionInfo.SOURCE_AOI_BOARD, new String[]{"poi_id", "poi_name", TrafficRecognitionInfo.SOURCE_AOI_BOARD, "state", "transition_type", "confidence", "confidence_source", "event_time", "type", "geofenceId"}, "poi_id=?", new String[]{r13}));     // Catch: Throwable -> L14
        if (r14.isEmpty() == true) goto L17;
        r0 = (AoiBoard) ZeusTransformUtils.preCheckCast(r14.get(0), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public List<AoiBoard> a() {
        c r10 = this.f7072a;
        monitor-enter(r10);
        ArrayList r0 = c.b(r10.a(TrafficRecognitionInfo.SOURCE_AOI_BOARD, new String[]{"poi_id", "poi_name", TrafficRecognitionInfo.SOURCE_AOI_BOARD, "state", "transition_type", "confidence", "confidence_source", "event_time", "type", "geofenceId"}, null, null));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public boolean a(String r8, String r9) {
        c r7 = this.f7072a;
        monitor-enter(r7);
        boolean r0 = false;
        if (r8 != null) goto L24;
    L22:
        monitor-exit(r7);
        return r0;
    L24:
    L19:
        th = move-exception;
        throw th;
    L7:
        if (r8.isEmpty() == true) goto L22;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L19
        if (r9 != null) goto L12;
        String r3 = "";
    L13:
        r1.put("geofenceId", r3);     // Catch: Throwable -> L19
        int r2 = r7.f.getWritableDatabase().update(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r1, "poi_id=?", new String[]{r8});     // Catch: Throwable -> L19
        StringBuilder r10 = new StringBuilder("poiId=").append(r8).append(", geofenceId=");     // Catch: Throwable -> L19
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        com.obric.cae.log.a.d("StarLocation-db", r10.append(r9).append(", updated=").append(r2).toString());     // Catch: Throwable -> L19
        if (r2 <= 0) goto L22;
        r0 = true;
        goto L22
    L12:
        r3 = r9;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase, boolean] */
    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public boolean a(List<AoiBoard> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        c r10 = this.f7072a;
        monitor-enter(r10);
        ?? r0 = r12.isEmpty();     // Catch: Throwable -> L38
        if (r0 == 0) goto L43;
    L7:
        monitor-exit(r10);
        return true;
    L43:
        SQLiteDatabase r1 = r10.f.getWritableDatabase();     // Catch: Throwable -> L38
        r1.beginTransaction();     // Catch: Throwable -> L38
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L29 Exception -> L31
        int r3 = 0;
    L12:
        if (r13.hasNext() == false) goto L26;
        AoiBoard r4 = (AoiBoard) ZeusTransformUtils.preCheckCast(r13.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29 Exception -> L31
        if (r4 == null) goto L12;
        if (r4.getPoiId().isEmpty() == true) goto L12;
        ContentValues r5 = c.a(r4);     // Catch: Throwable -> L29 Exception -> L31
        if (r1.update(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r5, "poi_id=?", new String[]{r4.getPoiId()}) == 0) goto L21;
    L25:
        r3 = r3 + 1;     // Catch: Throwable -> L29 Exception -> L31
        goto L12
    L21:
        if (r1.insert(TrafficRecognitionInfo.SOURCE_AOI_BOARD, null, r5) != (-1)) goto L25;
        throw new IllegalStateException("upsert failed for poiId=" + r4.getPoiId());     // Catch: Throwable -> L29 Exception -> L31
    L26:
        r1.setTransactionSuccessful();     // Catch: Throwable -> L29 Exception -> L31
        com.obric.cae.log.a.b("StarLocation-db", "success count=" + r3);     // Catch: Throwable -> L29 Exception -> L31
        r1.endTransaction();     // Catch: Throwable -> L38
    L31:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-db", "failed", e);     // Catch: Throwable -> L29
        r1.endTransaction();     // Catch: Throwable -> L38
        return false;
    L29:
        th = move-exception;
        r0.endTransaction();     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.location.geosdk.poi.a.InterfaceC0356a
    public int b() {
        c r3 = this.f7072a;
        monitor-enter(r3);
        int r0 = r3.a(TrafficRecognitionInfo.SOURCE_AOI_BOARD, "(cells IS NULL OR cells='') AND (new_type_code_l3 IS NULL OR new_type_code_l3='')", null);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
