package com.bytedance.security.dbcipher.utils;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteDatabaseHook;

/* JADX INFO: loaded from: classes2.dex */
public class DBCipherUtils {
    private static final int MAX_KEY_LEN = 64;
    private static final int MIN_KEY_LEN = 32;
    private static final String TAG = "DBCipherUtils";

    static {
    }

    public DBCipherUtils() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    private static String bytesToHex(byte[] r6) {
        if (r6 != null) goto L4;
    L15:
        Log.e(TAG, "input bytes is null");
        return null;
    L4:
        if (r6.length == 0) goto L15;
        StringBuffer r0 = new StringBuffer();
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L14;
        String r3 = Integer.toHexString(r6[r2] & 255);
        if (r3.length() >= 2) goto L12;
        r0.append(0);
    L12:
        r0.append(r3);
        r2 = r2 + 1;
        goto L8
    L14:
        return r0.toString();
    }

    public static String generateRandomPassPhrase(int r1) {
        if (r1 >= 32) goto L5;
        return null;
    L5:
        if (r1 > 64) goto L11;
        byte[] r2 = new byte[r1];
        new SecureRandom().nextBytes(r2);
        return bytesToHex(r2);
    L11:
        return null;
    }

    public static SQLiteDatabaseHook getHookByCipherConfig(final CipherConfig r1) {
        return new AnonymousClass1(r1);
    }

    private static byte[] hexToBytes(String r7) {
        if (r7 != null) goto L4;
    L12:
        Log.e(TAG, "hexString is not a valid hex string");
        return null;
    L4:
        if ((r7.length() % 2) != 0) goto L12;
        if (r7.matches("[0-9A-Fa-f]+") == false) goto L12;
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        r1[r2 / 2] = (byte) ((Character.digit(r7.charAt(r2), 16) << 4) + Character.digit(r7.charAt(r2 + 1), 16));
        r2 = r2 + 2;
        goto L9
    L11:
        return r1;
    }

    public static int passPhraseCheck(String r2) {
        byte[] r3 = hexToBytes(r2);
        if (r3 != null) goto L7;
        Log.e(TAG, "Invalid passPhrase");
        return -1;
    L7:
        if (r3.length >= 32) goto L11;
        Log.e(TAG, "passPhrase is too short");
        return -2;
    L11:
        if (r3.length <= 64) goto L14;
        Log.e(TAG, "passPhrase is too long");
        return -3;
    L14:
        return 0;
    }

    public static int updatePassPhrase(Context r3, String r4, CipherConfig r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L37;
        if (r4 == null) goto L37;
        if (r4.isEmpty() == true) goto L37;
        if (r5 == null) goto L37;
        if (r6 == null) goto L37;
        if (r7 == null) goto L37;
        int r0 = passPhraseCheck(r7);
        if (r0 == 0) goto L15;
        return r0;
    L15:
        if (r8.getDatabasePath(r4).exists() == true) goto L18;
        Log.e(TAG, "db: " + r4 + "not exist");
        return -5;
    L18:
        SQLiteDatabase r1 = null;
        r1 = SQLiteDatabase.openOrCreateDatabase(r8.getDatabasePath(r4).getPath(), r6.getBytes(StandardCharsets.UTF_8), null, null, getHookByCipherConfig(r5));     // Catch: Throwable -> L22 Exception -> L24 SQLException -> L28
        r1.query("PRAGMA rekey = '" + r7 + "'");     // Catch: Throwable -> L22 Exception -> L24 SQLException -> L28
        if (r1 == null) goto L41;
        r1.close();
        return r0;
    L41:
        return r0;
    L22:
        th = move-exception;
        if (r1 == null) goto L36;
        r1.close();
    L36:
        throw th;
    L28:
        e = move-exception;
        Log.e(TAG, "SQLException: " + e.getMessage());     // Catch: Throwable -> L22
        if (r1 == null) goto L33;
    L31:
        r1.close();
    L33:
        return -4;
    L24:
        e = move-exception;
        Log.e(TAG, "other Exception: " + e.getMessage());     // Catch: Throwable -> L22
        if (r1 == null) goto L33;
    L37:
        Log.e(TAG, "Invalid params.");
        return -1;
    }
}
