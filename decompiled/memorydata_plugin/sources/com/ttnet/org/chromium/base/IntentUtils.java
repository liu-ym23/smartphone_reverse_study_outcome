package com.ttnet.org.chromium.base;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import androidx.core.app.BundleCompat;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForS;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IntentUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ANDROID_APP_REFERRER_SCHEME = "android-app";
    private static final Object COMPONENT_NAME_LOCK = null;
    public static final String EPHEMERAL_INSTALLER_CLASS = "com.google.android.gms.instantapps.routing.EphemeralInstallerActivity";
    private static final String TAG = "IntentUtils";
    public static final String TRUSTED_APPLICATION_CODE_EXTRA = "trusted_application_code_extra";
    private static ComponentName sFakeComponentName;
    private static boolean sForceTrustedIntentForTesting;

    static {
        COMPONENT_NAME_LOCK = new Object();
    }

    public IntentUtils() {
    }

    public static void addTrustedIntentExtras(Intent r3) {
        if (intentTargetsSelf((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3) == true) goto L5;
        return;
    L5:
        r3.putExtra(TRUSTED_APPLICATION_CODE_EXTRA, getAuthenticationToken());
    }

    private static PendingIntent getAuthenticationToken() {
        Intent r0 = new Intent();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r0.setComponent(getFakeComponentName(r1.getPackageName()));
        return PendingIntent.getActivity(r1, 0, r0, getPendingIntentMutabilityFlag(false));
    }

    private static ComponentName getFakeComponentName(String r3) {
        Object r0 = COMPONENT_NAME_LOCK;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sFakeComponentName != null) goto L7;
        sFakeComponentName = new ComponentName(r3, "FakeClass");     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return sFakeComponentName;
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent r1, String r2) {
        return r1.getParcelableArrayListExtra(r2);
    L4:
        Log.e(TAG, "getParcelableArrayListExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static int getParceledIntentSize(Intent r2) {
        Parcel r0 = Parcel.obtain();
        r2.writeToParcel(r0, 0);
        return r0.dataSize();
    }

    public static int getPendingIntentMutabilityFlag(boolean r2) {
        if (r2 == false) goto L4;
    L7:
        if (r2 == true) goto L9;
        return 0;
    L9:
        if (Build.VERSION.SDK_INT >= 31) goto L11;
        return 0;
    L11:
        return ApiHelperForS.getPendingIntentMutableFlag();
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.getPendingIntentImmutableFlag();
    }

    public static boolean intentTargetsSelf(Context r5, Intent r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = !TextUtils.isEmpty(r6.getPackage());
        if (r0 == true) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r6.getComponent() == null) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L21;
        if (r0 == false) goto L20;
        return r3;
    L20:
        return true;
    L21:
        if (r3 == true) goto L23;
        return false;
    L23:
        return !r4;
    L14:
        if (r7.getPackageName().equals(r6.getComponent().getPackageName()) == false) goto L16;
        r8 = true;
        goto L17
    L11:
        r4 = false;
        goto L12
    L5:
        if (r7.getPackageName().equals(r6.getPackage()) == false) goto L7;
        r3 = true;
        goto L9
    }

    public static boolean isInstantAppResolveInfo(ResolveInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        return r3.isInstantAppAvailable;
    L10:
        if (r3.activityInfo != null) goto L12;
        return false;
    L12:
        return EPHEMERAL_INSTALLER_CLASS.equals(r3.activityInfo.name);
    }

    public static boolean isIntentForNewTaskOrNewDocument(Intent r1) {
        if ((r1.getFlags() & 268959744) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainIntentFromLauncher(Intent r2) {
        if (r2 != null) goto L4;
    L10:
        return false;
    L4:
        if (TextUtils.equals(r2.getAction(), "android.intent.action.MAIN") == false) goto L10;
        if (r2.hasCategory("android.intent.category.LAUNCHER") == false) goto L10;
        if ((r2.getFlags() & 1048576) != 0) goto L10;
        return true;
    }

    public static boolean isTrustedIntentFromSelf(Intent r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (sForceTrustedIntentForTesting == false) goto L9;
        return true;
    L9:
        PendingIntent r4 = (PendingIntent) ZeusTransformUtils.preCheckCast(safeGetParcelableExtra(r3, TRUSTED_APPLICATION_CODE_EXTRA), PendingIntent.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        return false;
    L13:
        return getAuthenticationToken().equals(r4);
    }

    private static Intent logInvalidIntent(Intent r2, Exception r3) {
        Log.e(TAG, "Invalid incoming intent.", new Object[]{r3});
        return r2.replaceExtras((Bundle) ZeusTransformUtils.preCheckCast(null, Bundle.class, "com.obric.memorydata.plugin"));
    }

    public static void logTransactionTooLargeOrRethrow(RuntimeException r2, Intent r3) {
        if (ZeusTransformUtils.instanceOf(r2.getCause(), TransactionTooLargeException.class) == false) goto L6;
        Log.e(TAG, "Could not resolve Activity for intent " + r3.toString(), new Object[]{r2});
        return;
    L6:
        throw r2;
    }

    public static IBinder safeGetBinder(Bundle r2, String r3) {
        if (r2 != null) goto L9;
        return null;
    L9:
        return BundleCompat.getBinder(r2, r3);
    L7:
        Log.e(TAG, "getBinder failed on bundle " + r2, new Object[0]);
        return null;
    }

    public static IBinder safeGetBinderExtra(Intent r1, String r2) {
        if (r1.hasExtra(r2) == true) goto L7;
        return null;
    L7:
        return safeGetBinder(r1.getExtras(), r2);
    }

    public static boolean safeGetBoolean(Bundle r1, String r2, boolean r3) {
        return r1.getBoolean(r2, r3);
    L4:
        Log.e(TAG, "getBoolean failed on bundle " + r1, new Object[0]);
        return r3;
    }

    public static boolean safeGetBooleanExtra(Intent r1, String r2, boolean r3) {
        return r1.getBooleanExtra(r2, r3);
    L4:
        Log.e(TAG, "getBooleanExtra failed on intent " + r1, new Object[0]);
        return r3;
    }

    public static Bundle safeGetBundle(Bundle r1, String r2) {
        return r1.getBundle(r2);
    L4:
        Log.e(TAG, "getBundle failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static Bundle safeGetBundleExtra(Intent r1, String r2) {
        return r1.getBundleExtra(r2);
    L4:
        Log.e(TAG, "getBundleExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static byte[] safeGetByteArrayExtra(Intent r1, String r2) {
        return r1.getByteArrayExtra(r2);
    L4:
        Log.e(TAG, "getByteArrayExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static float[] safeGetFloatArray(Bundle r1, String r2) {
        return r1.getFloatArray(r2);
    L4:
        Log.e(TAG, "getFloatArray failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static int safeGetInt(Bundle r1, String r2, int r3) {
        return r1.getInt(r2, r3);
    L4:
        Log.e(TAG, "getInt failed on bundle " + r1, new Object[0]);
        return r3;
    }

    public static int[] safeGetIntArray(Bundle r1, String r2) {
        return r1.getIntArray(r2);
    L4:
        Log.e(TAG, "getIntArray failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static int[] safeGetIntArrayExtra(Intent r1, String r2) {
        return r1.getIntArrayExtra(r2);
    L4:
        Log.e(TAG, "getIntArrayExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static int safeGetIntExtra(Intent r1, String r2, int r3) {
        return r1.getIntExtra(r2, r3);
    L4:
        Log.e(TAG, "getIntExtra failed on intent " + r1, new Object[0]);
        return r3;
    }

    public static long safeGetLongExtra(Intent r1, String r2, long r3) {
        return r1.getLongExtra(r2, r3);
    L4:
        Log.e(TAG, "getLongExtra failed on intent " + r1, new Object[0]);
        return r3;
    }

    public static <T extends Parcelable> T safeGetParcelable(Bundle r1, String r2) {
        return (T) r1.getParcelable(r2);
    L4:
        Log.e(TAG, "getParcelable failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static Parcelable[] safeGetParcelableArrayExtra(Intent r1, String r2) {
        return r1.getParcelableArrayExtra(r2);
    L4:
        Log.e(TAG, "getParcelableArrayExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static <T extends Parcelable> ArrayList<T> safeGetParcelableArrayList(Bundle r1, String r2) {
        return r1.getParcelableArrayList(r2);
    L4:
        Log.e(TAG, "getParcelableArrayList failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent r1, String r2) {
        return (T) r1.getParcelableExtra(r2);
    L4:
        Log.e(TAG, "getParcelableExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static <T extends Serializable> T safeGetSerializableExtra(Intent r5, String r6) {
        return (T) r5.getSerializableExtra(r6);
    L7:
        e = move-exception;
        Log.e(TAG, "Invalide class for Serializable: " + r6, new Object[]{e});
        return null;
    L5:
        Log.e(TAG, "getSerializableExtra failed on intent " + r5, new Object[0]);
        return null;
    }

    public static String safeGetString(Bundle r1, String r2) {
        return r1.getString(r2);
    L4:
        Log.e(TAG, "getString failed on bundle " + r1, new Object[0]);
        return null;
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent r1, String r2) {
        return r1.getStringArrayListExtra(r2);
    L4:
        Log.e(TAG, "getStringArrayListExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static String safeGetStringExtra(Intent r1, String r2) {
        return r1.getStringExtra(r2);
    L4:
        Log.e(TAG, "getStringExtra failed on intent " + r1, new Object[0]);
        return null;
    }

    public static boolean safeHasExtra(Intent r2, String r3) {
        return r2.hasExtra(r3);
    L4:
        Log.e(TAG, "hasExtra failed on intent " + r2, new Object[0]);
        return false;
    }

    public static void safePutBinderExtra(Intent r2, String r3, IBinder r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        BundleCompat.putBinder(r0, r3, r5);     // Catch: Throwable -> L8
    L9:
        r2.putExtras(r0);
        return;
    L8:
        Log.e(TAG, "putBinder failed on bundle " + r0, new Object[0]);
        goto L9
    }

    public static void safeRemoveExtra(Intent r1, String r2) {
        r1.removeExtra(r2);     // Catch: Throwable -> L4
        return;
    L4:
        Log.e(TAG, "removeExtra failed on intent " + r1, new Object[0]);
    }

    public static boolean safeStartActivity(Context r2, Intent r3) {
        return safeStartActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, null);
    }

    public static boolean safeStartActivity(Context r2, Intent r3, Bundle r4) {
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static Intent sanitizeIntent(Intent r3) {
        if (r3 != null) goto L16;
        return null;
    L16:
        r3.getBooleanExtra("TriggerUnparcel", false);     // Catch: RuntimeException -> L7 BadParcelableException -> L13
        return r3;
    L13:
        e = move-exception;
        return logInvalidIntent(r3, e);
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), ClassNotFoundException.class) == true) goto L11;
        throw e;
    L11:
        return logInvalidIntent(r3, e);
    }

    public static void setForceIsTrustedIntentForTesting(boolean r0) {
        sForceTrustedIntentForTesting = r0;
    }
}
