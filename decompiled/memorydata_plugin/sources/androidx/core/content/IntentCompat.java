package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    static class Api15Impl {
        private Api15Impl() {
        }

        static Intent makeMainSelectorActivity(String r0, String r1) {
            return Intent.makeMainSelectorActivity(r0, r1);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T[] getParcelableArrayExtra(Intent r0, String r1, Class<T> r2) {
            return (T[]) r0.getParcelableArrayExtra(r1, r2);
        }

        static <T> ArrayList<T> getParcelableArrayListExtra(Intent r0, String r1, Class<? extends T> r2) {
            return r0.getParcelableArrayListExtra(r1, r2);
        }

        static <T> T getParcelableExtra(Intent r0, String r1, Class<T> r2) {
            return (T) r0.getParcelableExtra(r1, r2);
        }
    }

    private IntentCompat() {
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r7.getPackageManager()) == false) goto L14;
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        Intent r8 = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", r6, null));
        if (Build.VERSION.SDK_INT < 30) goto L12;
        return r8;
    L12:
        return r8.setPackage((String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(r7.getPackageManager())), String.class, "com.obric.memorydata.plugin"));
    L7:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r6, null));
    L14:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static Parcelable[] getParcelableArrayExtra(Intent r2, String r3, Class<? extends Parcelable> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) ZeusTransformUtils.preCheckCast(Api33Impl.getParcelableArrayExtra(r2, r3, r4), Parcelable[].class, "com.obric.memorydata.plugin");
    L7:
        return r2.getParcelableArrayExtra(r3);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent r2, String r3, Class<? extends T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayListExtra(r2, r3, r4);
    L7:
        return r2.getParcelableArrayListExtra(r3);
    }

    public static <T> T getParcelableExtra(Intent r2, String r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r5 = (T) r2.getParcelableExtra(r3);
        if (ZeusTransformUtils.instanceOf(r4, r5) == true) goto L11;
        return null;
    L11:
        return r5;
    L5:
        return (T) Api33Impl.getParcelableExtra(r2, r3, r4);
    }

    public static Intent makeMainSelectorActivity(String r2, String r3) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        Intent r0 = new Intent(r2);
        r0.addCategory(r3);
        return r0;
    L5:
        return Api15Impl.makeMainSelectorActivity(r2, r3);
    }
}
