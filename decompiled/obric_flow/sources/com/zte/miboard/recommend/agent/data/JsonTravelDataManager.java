package com.zte.miboard.recommend.agent.data;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JsonTravelDataManager {
    public static final String FLIGHT_FILE_NAME = "flightDataList.json";
    public static final String HOTEL_FILE_NAME = "hotelDataList.json";
    public static final String MATCH_FILE_NAME = "matchDataList.json";
    private static final String TAG = "Mi_R_JsonTravelDataManager";
    public static final String TRAIN_FILE_NAME = "trainDataList.json";

    public JsonTravelDataManager() {
    }

    public static void ensureFileExists(Context r5, String r10) {
        File r11 = new File(r5.getFilesDir(), r10);
        if (r11.exists() == false) goto L16;
        Log.d(TAG, "the file already exists: " + r11.getAbsolutePath());
        return;
    L16:
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r11.createNewFile() == false) goto L10;
        Log.d(TAG, "file has been created: " + r11.getAbsolutePath());     // Catch: IOException -> L8
        return;
    L10:
        Log.d(TAG, "file creation failed: " + r11.getAbsolutePath());     // Catch: IOException -> L8
    }

    private static Type getChildTypeToken(TravelData r5) {
        if ((r5 instanceof FlightData) == false) goto L7;
        return new AnonymousClass1().getType();
    L7:
        if ((r5 instanceof TrainData) == false) goto L11;
        return new AnonymousClass2().getType();
    L11:
        if ((r5 instanceof HotelData) == false) goto L15;
        return new AnonymousClass3().getType();
    L15:
        if ((r5 instanceof MatchData) == false) goto L19;
        return new AnonymousClass4().getType();
    L19:
        return new AnonymousClass5().getType();
    }

    private static String getFileName(TravelData r5) {
        if ((r5 instanceof FlightData) == false) goto L7;
        return FLIGHT_FILE_NAME;
    L7:
        if ((r5 instanceof TrainData) == false) goto L11;
        return TRAIN_FILE_NAME;
    L11:
        if ((r5 instanceof HotelData) == false) goto L15;
        return HOTEL_FILE_NAME;
    L15:
        if ((r5 instanceof MatchData) == false) goto L18;
        return MATCH_FILE_NAME;
    L18:
        return null;
    }

    public static List<TravelData> readJsonFile(Context r5, String r10) {
        ensureFileExists(r5, r10);
        List<TravelData> r11 = new ArrayList();
        FileReader r12 = new FileReader(new File(r5.getFilesDir(), r10));     // Catch: IOException -> L10 FileNotFoundException -> L12
        Type r13 = getChildTypeToken(r10);     // Catch: Throwable -> L14
        if (r13 != null) goto L16;
        Log.e(TAG, "listType is null, check data type");     // Catch: Throwable -> L14
        r12.close();     // Catch: IOException -> L10 FileNotFoundException -> L12
        return null;
    L16:
        List<TravelData> r14 = (List) new Gson().fromJson(r12, r13);     // Catch: Throwable -> L14
        r12.close();     // Catch: IOException -> L19 FileNotFoundException -> L21
        return r14;
    L21:
        e = e;
        r11 = r14;
    L29:
        e.printStackTrace();
    L30:
        return r11;
    L19:
        e = e;
        r11 = r14;
    L28:
        e.printStackTrace();
    L14:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: IOException -> L10 FileNotFoundException -> L12
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L10 FileNotFoundException -> L12
    L12:
        e = e;
    L10:
        e = e;
        goto L28
    }

    public static void removeDuplicateIfExists(Context r5, TravelData r10) {
        String r11 = getFileName(r10);
        ensureFileExists(r5, r11);
        List r12 = readJsonFile(r5, r11);
        if (r12 != null) goto L5;
        r12 = new ArrayList();
    L5:
        Iterator r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L15;
        TravelData r14 = (TravelData) r13.next();
        if (Objects.equals(r14.travelNumber, r10.travelNumber) == false) goto L7;
        if (Objects.equals(r14.travelDate, r10.travelDate) == false) goto L7;
        if (Objects.equals(r14.personName, r10.personName) == false) goto L7;
        r13.remove();
    L15:
        writeJsonFile(r5, r12);
    }

    public static TravelData searchTravelData(Context r5, TravelData r10) {
        String r11 = getFileName(r10);
        ensureFileExists(r5, r11);
        List r12 = readJsonFile(r5, r11);
        if (r12 != null) goto L5;
        r12 = new ArrayList();
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r12.size()) goto L23;
        TravelData r14 = (TravelData) r12.get(r13);
        if (Objects.equals(r14.travelNumber, r10.travelNumber) == false) goto L17;
        if (Objects.equals(r14.travelDate, r10.travelDate) == false) goto L17;
        if (Objects.equals(r14.personName, r10.personName) == false) goto L17;
        return (TravelData) r12.get(r13);
    L17:
        if (Objects.equals(r14.fromStation, r10.fromStation) == false) goto L22;
        if (Objects.equals(r14.toStation, r10.toStation) == false) goto L22;
        return (TravelData) r12.get(r13);
    L22:
        r13 = r13 + 1;
        goto L7
    L23:
        return null;
    }

    public static void updateJsonFile(Context r5, TravelData r10) {
        String r11 = getFileName(r10);
        ensureFileExists(r5, r11);
        List r12 = readJsonFile(r5, r11);
        if (r12 != null) goto L5;
        r12 = new ArrayList();
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r12.size()) goto L16;
        TravelData r14 = (TravelData) r12.get(r13);
        if (Objects.equals(r14.travelNumber, r10.travelNumber) == false) goto L15;
        if (Objects.equals(r14.travelDate, r10.travelDate) == false) goto L15;
        if (Objects.equals(r14.personName, r10.personName) == false) goto L15;
        r12.set(r13, r10);
    L17:
        writeJsonFile(r5, r12);
        return;
    L15:
        r13 = r13 + 1;
        goto L7
    L16:
        r12.add(r10);
        goto L17
    }

    public static void writeJsonFile(Context r5, List<TravelData> r10) {
        if (r10.isEmpty() == true) goto L5;
        String r11 = getFileName(r10.get(0));
    L7:
        if (Objects.equals(r11, "") == false) goto L10;
        Log.e(TAG, "write file failed, because filename is empty");
        return;
    L10:
        File r12 = new File(r5.getFilesDir(), r11);
        String r13 = new Gson().toJson(r10);
        FileWriter r14 = new FileWriter(r12);     // Catch: IOException -> L15
        r14.write(r13);     // Catch: Throwable -> L17
        r14.close();     // Catch: IOException -> L15
        return;
    L17:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L15
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r11 = "";
        goto L7
    }

    private static Type getChildTypeToken(String r5) {
        if (r5.equals(FLIGHT_FILE_NAME) == false) goto L7;
        return new AnonymousClass6().getType();
    L7:
        if (r5.equals(TRAIN_FILE_NAME) == false) goto L11;
        return new AnonymousClass7().getType();
    L11:
        if (r5.equals(HOTEL_FILE_NAME) == false) goto L15;
        return new AnonymousClass8().getType();
    L15:
        if (r5.equals(MATCH_FILE_NAME) == false) goto L19;
        return new AnonymousClass9().getType();
    L19:
        return new AnonymousClass10().getType();
    }
}
