package com.bytedance.crash.dumper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BuildId {

    static class AnrTraceFile extends SoListContainer {
        AnrTraceFile(File r10) {
            super(r10);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^  native: #\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String r10) {
            return r10.startsWith("  native: #");
        }
    }

    static class AsanFile extends SoListContainer {
        AsanFile(File r10) {
            super(r10);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^ {4}#\\d{1,3} 0x[0-9a-f]{1,16} {2}\\((/(?:[^/]+/)+.*\\.so)\\+0x[0-9a-f]{1,16}\\)$");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String r10) {
            return r10.startsWith("    #");
        }
    }

    static class NativeStackFile extends SoListContainer {
        NativeStackFile(File r10) {
            super(r10);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String r10) {
            return r10.startsWith("#");
        }
    }

    static class RoutinesFile extends SoListContainer {
        RoutinesFile(File r10) {
            super(r10);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^0x[0-9a-f]{1,16}:(/(?:[^/]+/)+[^.]+\\.so):.*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String r10) {
            return r10.startsWith("0x");
        }
    }

    static abstract class SoListContainer {
        private final File mFile;
        private final Pattern mPattern;

        SoListContainer(File r10) {
            this.mFile = r10;
            this.mPattern = getPattern();
        }

        abstract Pattern getPattern();

        abstract boolean isBackTraceLine(String r10);

        void loadSoList(List<String> r10) {
            if (this.mFile.exists() == true) goto L5;
            return;
        L5:
            BufferedReader r11 = null;
            BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(this.mFile)));     // Catch: Throwable -> L23
        L24:
            String r13 = r12.readLine();     // Catch: Throwable -> L19
            if (r13 == null) goto L21;
            if (isBackTraceLine(r13) == false) goto L24;
            Matcher r14 = this.mPattern.matcher(r13);     // Catch: Throwable -> L19
            if (r14.find() == false) goto L24;
            if (r14.groupCount() != 1) goto L24;
            String r15 = r14.group(1);     // Catch: Throwable -> L19
            if (r10.contains(r15) == true) goto L24;
            r10.add(r15);     // Catch: Throwable -> L19
        L21:
            FileSystemUtils.close(r12);
            return;
        L19:
            r11 = r12;
        L20:
            r12 = r11;
            goto L21
        }
    }

    static class TombstoneFile extends SoListContainer {
        TombstoneFile(File r10) {
            super(r10);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^ {4}#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String r10) {
            return r10.startsWith("    ");
        }
    }

    public BuildId() {
    }

    private static String buildIDToUUID(String r10) {
        StringBuilder r11 = new StringBuilder();
        if (r10.length() >= 16) goto L6;
        r11.append(r10);     // Catch: Throwable -> L11
    L12:
        goto L10
    L6:
        r11.append(r10.charAt(6));     // Catch: Throwable -> L11
        r11.append(r10.charAt(7));     // Catch: Throwable -> L11
        r11.append(r10.charAt(4));     // Catch: Throwable -> L11
        r11.append(r10.charAt(5));     // Catch: Throwable -> L11
        r11.append(r10.charAt(2));     // Catch: Throwable -> L11
        r11.append(r10.charAt(3));     // Catch: Throwable -> L11
        r11.append(r10.charAt(0));     // Catch: Throwable -> L11
        r11.append(r10.charAt(1));     // Catch: Throwable -> L11
        r11.append(r10.charAt(10));     // Catch: Throwable -> L11
        r11.append(r10.charAt(11));     // Catch: Throwable -> L11
        r11.append(r10.charAt(8));     // Catch: Throwable -> L11
        r11.append(r10.charAt(9));     // Catch: Throwable -> L11
        r11.append(r10.charAt(14));     // Catch: Throwable -> L11
        r11.append(r10.charAt(15));     // Catch: Throwable -> L11
        r11.append(r10.charAt(12));     // Catch: Throwable -> L11
        r11.append(r10.charAt(13));     // Catch: Throwable -> L11
        if (r10.length() < 32) goto L12;
        r11.append(r10, 16, 32);     // Catch: Throwable -> L11
        r11.append('0');     // Catch: Throwable -> L11
    L10:
        return r11.toString().toUpperCase();
    }

    private static boolean isSystemLibrary(String r10) {
        if (r10.startsWith("/system/lib") == false) goto L5;
    L10:
        return true;
    L5:
        if (r10.startsWith("/vendor/lib") == true) goto L10;
        if (r10.startsWith("/apex/") == true) goto L10;
        return false;
    }

    private static void loadBuildIdFromTombstone(Map<String, String> r10, File r11) {
        if (r11.exists() == true) goto L5;
        return;
    L5:
        Pattern r12 = Pattern.compile("^ {4}(/(?:[^/]+/)+[^.]+\\.so) \\(BuildId: ([0-9a-f]+)\\).*");
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new InputStreamReader(new FileInputStream(r11)));     // Catch: Throwable -> L32
    L33:
        String r15 = r14.readLine();     // Catch: Throwable -> L28
        if (r15 == null) goto L30;
        if (r15.startsWith("build id:") == false) goto L33;
    L11:
        String r16 = r14.readLine();     // Catch: Throwable -> L28
        if (r16 == null) goto L33;
        if (r16.startsWith("    /") == false) goto L33;
        Matcher r17 = r12.matcher(r16);     // Catch: Throwable -> L28
        if (r17.find() == false) goto L11;
        if (r17.groupCount() != 2) goto L11;
        String r18 = r17.group(1);     // Catch: Throwable -> L28
        String r19 = r17.group(2);     // Catch: Throwable -> L28
        if (r18 == null) goto L11;
        if (isSystemLibrary(r18) == true) goto L11;
        if (r10.containsKey(r18) == true) goto L11;
        r10.put(r18, r19);     // Catch: Throwable -> L28
    L30:
        FileSystemUtils.close(r14);
        return;
    L28:
        r13 = r14;
    L29:
        r14 = r13;
        goto L30
    }

    @Nullable
    private static String pathToName(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        int r11 = r10.lastIndexOf(47);
        if (r11 == (-1)) goto L13;
        String r12 = r10.substring(r11 + 1);
        int r13 = r12.indexOf(".apk!");
        if (r13 != (-1)) goto L9;
        return r12;
    L9:
        return r12.substring(r13 + 5);
    L13:
        return null;
    L10:
        return null;
    }

    public static void putAnrBuildIDToJson(@NonNull JSONObject r10, File r11) {
        HashMap r12 = new HashMap();
        ArrayList r13 = new ArrayList();
        new AnrTraceFile(r11).loadSoList(r13);
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        String r15 = (String) r14.next();
        if (isSystemLibrary(r15) == true) goto L4;
        if (r12.containsKey(r15) == true) goto L4;
        String r16 = NativeBridge.GetBuildID(r15);
        if (r16 == null) goto L4;
        r12.put(r15, r16);
        goto L4
    L12:
        putToJson(r10, r12);
    }

    public static void putAsanBuildIdToJson(@NonNull JSONObject r10, File r11) {
        HashMap r12 = new HashMap();
        ArrayList r13 = new ArrayList();
        new AsanFile(r11).loadSoList(r13);
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        String r15 = (String) r14.next();
        if (isSystemLibrary(r15) == true) goto L4;
        if (r12.containsKey(r15) == true) goto L4;
        String r16 = NativeBridge.GetBuildID(r15);
        if (r16 == null) goto L4;
        r12.put(r15, r16);
        goto L4
    L12:
        putToJson(r10, r12);
    }

    public static void putCrashBuildIdToJson(@NonNull JSONObject r10, File r11, boolean r12) {
        HashMap r13 = new HashMap();
        ArrayList r14 = new ArrayList();
        if (r12 == false) goto L5;
        loadBuildIdFromTombstone(r13, new File(r11, "tombstone.txt"));
        new NativeStackFile(new File(r11, "nstack.txt")).loadSoList(r14);
    L5:
        new RoutinesFile(new File(r11, "rountines.txt")).loadSoList(r14);
        Iterator r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L15;
        String r16 = (String) r15.next();
        if (isSystemLibrary(r16) == true) goto L7;
        if (r13.containsKey(r16) == true) goto L7;
        String r17 = NativeBridge.GetBuildID(r16);
        if (r17 == null) goto L7;
        r13.put(r16, r17);
        goto L7
    L15:
        putToJson(r10, r13);
    }

    private static void putToJson(JSONObject r10, Map<String, String> r11) {
        JSONArray r12 = new JSONArray();
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<String, String> r14 = r13.next();
        String r15 = pathToName(r14.getKey());     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r15) == true) goto L4;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L12
        JSONUtils.put(r16, CrashBody.LIB_NAME, r15);     // Catch: Throwable -> L12
        JSONUtils.put(r16, CrashBody.LIB_UUID, buildIDToUUID(r14.getValue()));     // Catch: Throwable -> L12
        r12.put(r16);     // Catch: Throwable -> L12
        goto L4
    L10:
        JSONUtils.put(r10, CrashBody.CRASH_LIB_UUID, r12);
    }
}
