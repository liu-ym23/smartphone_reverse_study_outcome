package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = null;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = null;

    static {
        sExtrasLock = new Object();
        sActionsLock = new Object();
    }

    private NotificationCompatJellybean() {
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> r10) {
        int r11 = r10.size();
        SparseArray<Bundle> r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        Bundle r14 = r10.get(r13);
        if (r14 == null) goto L9;
        if (r12 != null) goto L8;
        r12 = new SparseArray();
    L8:
        r12.put(r13, r14);
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        return r12;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed == false) goto L15;
        return false;
    L15:
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);
        sActionsAccessFailed = true;
    L14:
        return !sActionsAccessFailed;
    L8:
        if (sActionsField != null) goto L14;
        Class<?> r10 = Class.forName("android.app.Notification$Action");     // Catch: Throwable -> L11
        sActionIconField = r10.getDeclaredField(KEY_ICON);     // Catch: Throwable -> L11
        sActionTitleField = r10.getDeclaredField(KEY_TITLE);     // Catch: Throwable -> L11
        sActionIntentField = r10.getDeclaredField(KEY_ACTION_INTENT);     // Catch: Throwable -> L11
        Field r11 = Notification.class.getDeclaredField("actions");     // Catch: Throwable -> L11
        sActionsField = r11;     // Catch: Throwable -> L11
        r11.setAccessible(true);     // Catch: Throwable -> L11
        goto L14
    }

    private static RemoteInput fromBundle(Bundle r10) {
        ArrayList<String> r11 = r10.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet r12 = new HashSet();
        if (r11 == null) goto L9;
        Iterator<String> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        r12.add(r13.next());
    L9:
        return new RemoteInput(r10.getString(KEY_RESULT_KEY), r10.getCharSequence(KEY_LABEL), r10.getCharSequenceArray(KEY_CHOICES), r10.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, r10.getBundle(KEY_EXTRAS), r12);
    }

    private static RemoteInput[] fromBundleArray(Bundle[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        RemoteInput[] r11 = new RemoteInput[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = fromBundle(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public static NotificationCompat.Action getAction(Notification r10, int r11) {
        Object r12 = sActionsLock;
        monitor-enter(r12);
        Object[] r13 = getActionObjectsLocked(r10);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r13 == null) goto L20;
        Object r14 = r13[r11];     // Catch: Throwable -> L16 IllegalAccessException -> L18
        Bundle r15 = getExtras(r10);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r15 == null) goto L12;
        SparseArray r16 = r15.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r16 == null) goto L12;
        Bundle r17 = (Bundle) r16.get(r11);     // Catch: Throwable -> L16 IllegalAccessException -> L18
    L13:
        NotificationCompat.Action r18 = readAction(sActionIconField.getInt(r14), (CharSequence) sActionTitleField.get(r14), (PendingIntent) sActionIntentField.get(r14), r17);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        monitor-exit(r12);     // Catch: Throwable -> L16
        return r18;
    L12:
        r17 = null;
    L20:
        monitor-exit(r12);     // Catch: Throwable -> L16
        return null;
    L18:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L16
        sActionsAccessFailed = true;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static int getActionCount(Notification r10) {
        Object r11 = sActionsLock;
        monitor-enter(r11);
        Object[] r12 = getActionObjectsLocked(r10);     // Catch: Throwable -> L10
        if (r12 == null) goto L7;
        int r13 = r12.length;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r13;
    L7:
        r13 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    static NotificationCompat.Action getActionFromBundle(Bundle r15) {
        Bundle r10 = r15.getBundle(KEY_EXTRAS);
        boolean r11 = false;
        if (r10 == null) goto L5;
        r11 = r10.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
    L5:
        boolean r12 = r11;
        return new NotificationCompat.Action(r15.getInt(KEY_ICON), r15.getCharSequence(KEY_TITLE), (PendingIntent) r15.getParcelable(KEY_ACTION_INTENT), r15.getBundle(KEY_EXTRAS), fromBundleArray(getBundleArrayFromBundle(r15, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(r15, KEY_DATA_ONLY_REMOTE_INPUTS)), r12, r15.getInt(KEY_SEMANTIC_ACTION), r15.getBoolean(KEY_SHOWS_USER_INTERFACE), false, false);
    }

    private static Object[] getActionObjectsLocked(Notification r10) {
        Object r11 = sActionsLock;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (ensureActionReflectionReadyLocked() == true) goto L18;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return null;
    L18:
        Object[] r12 = (Object[]) sActionsField.get(r10);     // Catch: IllegalAccessException -> L11 Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        return r12;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L15
        sActionsAccessFailed = true;     // Catch: Throwable -> L15
        return null;
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle r10, String r11) {
        Parcelable[] r12 = r10.getParcelableArray(r11);
        if ((r12 instanceof Bundle[]) == true) goto L9;
        if (r12 == null) goto L9;
        Bundle[] r13 = (Bundle[]) Arrays.copyOf(r12, r12.length, Bundle[].class);
        r10.putParcelableArray(r11, r13);
        return r13;
    L9:
        return (Bundle[]) r12;
    }

    static Bundle getBundleForAction(NotificationCompat.Action r10) {
        Bundle r11 = new Bundle();
        IconCompat r12 = r10.getIconCompat();
        if (r12 == null) goto L5;
        int r13 = r12.getResId();
    L6:
        r11.putInt(KEY_ICON, r13);
        r11.putCharSequence(KEY_TITLE, r10.getTitle());
        r11.putParcelable(KEY_ACTION_INTENT, r10.getActionIntent());
        if (r10.getExtras() == null) goto L9;
        Bundle r14 = new Bundle(r10.getExtras());
    L10:
        r14.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r10.getAllowGeneratedReplies());
        r11.putBundle(KEY_EXTRAS, r14);
        r11.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(r10.getRemoteInputs()));
        r11.putBoolean(KEY_SHOWS_USER_INTERFACE, r10.getShowsUserInterface());
        r11.putInt(KEY_SEMANTIC_ACTION, r10.getSemanticAction());
        return r11;
    L9:
        r14 = new Bundle();
        goto L10
    L5:
        r13 = 0;
        goto L6
    }

    public static Bundle getExtras(Notification r10) {
        Object r11 = sExtrasLock;
        monitor-enter(r11);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (sExtrasFieldAccessFailed == false) goto L34;
        monitor-exit(r11);     // Catch: Throwable -> L30
        return null;
    L34:
    L25:
        e = e;
        String r12 = TAG;
        String r13 = "Unable to access notification extras";
    L24:
        Log.e(r12, r13, e);     // Catch: Throwable -> L30
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Throwable -> L30
        return null;
    L22:
        e = e;
        r12 = TAG;
        r13 = "Unable to access notification extras";
        goto L24
    L10:
        if (sExtrasField != null) goto L17;
        Field r14 = Notification.class.getDeclaredField(KEY_EXTRAS);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        if (Bundle.class.isAssignableFrom(r14.getType()) == true) goto L16;
        Log.e(TAG, "Notification.extras field is not of type Bundle");     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasFieldAccessFailed = true;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        monitor-exit(r11);     // Catch: Throwable -> L30
        return null;
    L16:
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasField = r14;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
    L17:
        Bundle r15 = (Bundle) sExtrasField.get(r10);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        if (r15 != null) goto L20;
        r15 = new Bundle();     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasField.set(r10, r15);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
    L20:
        monitor-exit(r11);     // Catch: Throwable -> L30
        return r15;
    }

    public static NotificationCompat.Action readAction(int r13, CharSequence r14, PendingIntent r15, Bundle r16) {
        if (r16 == null) goto L5;
        RemoteInput[] r10 = fromBundleArray(getBundleArrayFromBundle(r16, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
        RemoteInput[] r11 = r10;
        RemoteInput[] r12 = fromBundleArray(getBundleArrayFromBundle(r16, EXTRA_DATA_ONLY_REMOTE_INPUTS));
        boolean r17 = r16.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
    L7:
        return new NotificationCompat.Action(r13, r14, r15, r16, r11, r12, r17, 0, true, false, false);
    L5:
        r11 = null;
        r12 = null;
        r17 = false;
        goto L7
    }

    private static Bundle toBundle(RemoteInput r10) {
        Bundle r11 = new Bundle();
        r11.putString(KEY_RESULT_KEY, r10.getResultKey());
        r11.putCharSequence(KEY_LABEL, r10.getLabel());
        r11.putCharSequenceArray(KEY_CHOICES, r10.getChoices());
        r11.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, r10.getAllowFreeFormInput());
        r11.putBundle(KEY_EXTRAS, r10.getExtras());
        Set<String> r12 = r10.getAllowedDataTypes();
        if (r12 != null) goto L5;
    L11:
        return r11;
    L5:
        if (r12.isEmpty() == true) goto L11;
        ArrayList<String> r13 = new ArrayList(r12.size());
        Iterator<String> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(r14.next());
        goto L8
    L10:
        r11.putStringArrayList(KEY_ALLOWED_DATA_TYPES, r13);
        goto L11
    }

    private static Bundle[] toBundleArray(RemoteInput[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Bundle[] r11 = new Bundle[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = toBundle(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder r10, NotificationCompat.Action r11) {
        IconCompat r12 = r11.getIconCompat();
        if (r12 == null) goto L5;
        int r13 = r12.getResId();
    L6:
        r10.addAction(r13, r11.getTitle(), r11.getActionIntent());
        Bundle r14 = new Bundle(r11.getExtras());
        if (r11.getRemoteInputs() == null) goto L10;
        r14.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(r11.getRemoteInputs()));
    L10:
        if (r11.getDataOnlyRemoteInputs() == null) goto L12;
        r14.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(r11.getDataOnlyRemoteInputs()));
    L12:
        r14.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r11.getAllowGeneratedReplies());
        return r14;
    L5:
        r13 = 0;
        goto L6
    }
}
