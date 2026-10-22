package cn.nubia.neopush.protocol.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    public CommonUtils() {
    }

    public static String Encrypt(String r5, String r10) {
        byte[] r11 = r5.getBytes();
        if (r10 != null) goto L11;
    L6:
        r10 = "MD5";
    L7:
        MessageDigest r12 = MessageDigest.getInstance(r10);     // Catch: NoSuchAlgorithmException -> L9
        r12.update(r11);     // Catch: NoSuchAlgorithmException -> L9
        return bytes2Hex(r12.digest());
    L9:
        System.out.println("Invalid algorithm.");
        return null;
    L11:
        if (r10.equals("") == false) goto L7;
        goto L6
    }

    public static String bytes2Hex(byte[] r5) {
        String r10 = "";
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L5;
        String r12 = Integer.toHexString(r5[r11] & UByte.MAX_VALUE);
        if (r12.length() != 1) goto L9;
        r10 = String.valueOf(r10).concat("0");
    L9:
        r10 = String.valueOf(r10).concat(r12);
        r11 = r11 + 1;
        goto L4
    L5:
        return r10;
    }

    public static String getHmacSHA1(String r5, String r10) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, IllegalArgumentException {
        Mac r11 = Mac.getInstance("HmacSHA1");
        r11.init(new SecretKeySpec(r10.getBytes("UTF-8"), r11.getAlgorithm()));
        return bytes2Hex(r11.doFinal(r5.getBytes()));
    }

    public static String getLauncherActivityNameByPackageName(Context r5, String r10) {
        Intent r11 = new Intent("android.intent.action.MAIN", null);
        r11.addCategory("android.intent.category.LAUNCHER");
        r11.setPackage(r10);
        ResolveInfo r12 = r5.getPackageManager().queryIntentActivities(r11, 0).iterator().next();
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.activityInfo.name;
    }

    public static File getOwnCacheDirectory(Context r5, String r10) {
        File r11 = null;
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L6;
    L8:
        if (r11 != null) goto L10;
    L13:
        return r5.getCacheDir();
    L10:
        if (r11.exists() == false) goto L12;
        return r11;
    L12:
        if (r11.mkdirs() == false) goto L13;
        return r11;
    L6:
        if (hasExternalStorageStatePermission(r5) == false) goto L8;
        r11 = new File(Environment.getExternalStorageDirectory(), r10);     // Catch: Exception -> L15
    L20:
        return null;
    }

    private static boolean hasExternalStorageStatePermission(Context r5) {
        if (r5.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
