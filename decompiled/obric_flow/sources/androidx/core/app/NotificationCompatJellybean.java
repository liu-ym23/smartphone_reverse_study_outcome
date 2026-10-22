package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
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

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> r5) {
        int r10 = r5.size();
        SparseArray<Bundle> r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        Bundle r13 = r5.get(r12);
        if (r13 == null) goto L9;
        if (r11 != null) goto L8;
        r11 = new SparseArray();
    L8:
        r11.put(r12, r13);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r11;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "Unable to access notification actions"
            java.lang.String r1 = "NotificationCompat"
            boolean r2 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            if (r2 == 0) goto La
            r0 = 0
            return r0
        La:
            r2 = 1
            java.lang.reflect.Field r3 = androidx.core.app.NotificationCompatJellybean.sActionsField     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            if (r3 != 0) goto L4b
            java.lang.String r3 = "android.app.Notification$Action"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            java.lang.String r4 = "icon"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            androidx.core.app.NotificationCompatJellybean.sActionIconField = r4     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            java.lang.String r4 = "title"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            androidx.core.app.NotificationCompatJellybean.sActionTitleField = r4     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            java.lang.String r4 = "actionIntent"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            androidx.core.app.NotificationCompatJellybean.sActionIntentField = r3     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            java.lang.Class<android.app.Notification> r3 = android.app.Notification.class
            java.lang.String r4 = "actions"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            androidx.core.app.NotificationCompatJellybean.sActionsField = r3     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            r3.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L3e
            goto L4b
        L3c:
            r3 = move-exception
            goto L40
        L3e:
            r3 = move-exception
            goto L46
        L40:
            android.util.Log.e(r1, r0, r3)
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r2
            goto L4b
        L46:
            android.util.Log.e(r1, r0, r3)
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r2
        L4b:
            boolean r0 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            r0 = r0 ^ r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompatJellybean.ensureActionReflectionReadyLocked():boolean");
    }

    private static RemoteInput fromBundle(Bundle r10) {
        ArrayList<String> r5 = r10.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet r11 = new HashSet();
        if (r5 == null) goto L9;
        Iterator<String> r12 = r5.iterator();
    L6:
        if (r12.hasNext() == false) goto L9;
        r11.add(r12.next());
    L9:
        return new RemoteInput(r10.getString(KEY_RESULT_KEY), r10.getCharSequence(KEY_LABEL), r10.getCharSequenceArray(KEY_CHOICES), r10.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, r10.getBundle(KEY_EXTRAS), r11);
    }

    private static RemoteInput[] fromBundleArray(Bundle[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        RemoteInput[] r10 = new RemoteInput[r5.length];
        int r11 = 0;
    L7:
        if (r11 >= r5.length) goto L9;
        r10[r11] = fromBundle(r5[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public static NotificationCompat.Action getAction(Notification r5, int r10) {
        Object r11 = sActionsLock;
        monitor-enter(r11);
        Object[] r12 = getActionObjectsLocked(r5);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r12 == null) goto L21;
        Object r13 = r12[r10];     // Catch: Throwable -> L12 IllegalAccessException -> L14
        Bundle r14 = getExtras(r5);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r14 == null) goto L16;
        SparseArray r15 = r14.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r15 == null) goto L16;
        Bundle r16 = (Bundle) r15.get(r10);     // Catch: Throwable -> L12 IllegalAccessException -> L14
    L17:
        NotificationCompat.Action r17 = readAction(sActionIconField.getInt(r13), (CharSequence) sActionTitleField.get(r13), (PendingIntent) sActionIntentField.get(r13), r16);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r17;
    L16:
        r16 = null;
    L21:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return null;
    L14:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L12
        sActionsAccessFailed = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static int getActionCount(Notification r5) {
        Object r10 = sActionsLock;
        monitor-enter(r10);
        Object[] r11 = getActionObjectsLocked(r5);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        int r12 = r11.length;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r12;
    L9:
        r12 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public static NotificationCompat.Action getActionFromBundle(Bundle r15) {
        Bundle r5 = r15.getBundle(KEY_EXTRAS);
        boolean r10 = false;
        if (r5 == null) goto L5;
        r10 = r5.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
    L5:
        boolean r11 = r10;
        return new NotificationCompat.Action(r15.getInt(KEY_ICON), r15.getCharSequence("title"), (PendingIntent) r15.getParcelable(KEY_ACTION_INTENT), r15.getBundle(KEY_EXTRAS), fromBundleArray(getBundleArrayFromBundle(r15, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(r15, KEY_DATA_ONLY_REMOTE_INPUTS)), r11, r15.getInt(KEY_SEMANTIC_ACTION), r15.getBoolean(KEY_SHOWS_USER_INTERFACE), false, false);
    }

    private static Object[] getActionObjectsLocked(Notification r5) {
        Object r10 = sActionsLock;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (ensureActionReflectionReadyLocked() == true) goto L19;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return null;
    L19:
        Object[] r11 = (Object[]) sActionsField.get(r5);     // Catch: Throwable -> L8 IllegalAccessException -> L13
        monitor-exit(r10);     // Catch: Throwable -> L8
        return r11;
    L13:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L8
        sActionsAccessFailed = true;     // Catch: Throwable -> L8
        return null;
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle r5, String r10) {
        Parcelable[] r11 = r5.getParcelableArray(r10);
        if ((r11 instanceof Bundle[]) == true) goto L9;
        if (r11 == null) goto L9;
        Bundle[] r12 = (Bundle[]) Arrays.copyOf(r11, r11.length, Bundle[].class);
        r5.putParcelableArray(r10, r12);
        return r12;
    L9:
        return (Bundle[]) r11;
    }

    public static Bundle getBundleForAction(NotificationCompat.Action r5) {
        Bundle r10 = new Bundle();
        IconCompat r11 = r5.getIconCompat();
        if (r11 == null) goto L5;
        int r12 = r11.getResId();
    L6:
        r10.putInt(KEY_ICON, r12);
        r10.putCharSequence("title", r5.getTitle());
        r10.putParcelable(KEY_ACTION_INTENT, r5.getActionIntent());
        if (r5.getExtras() == null) goto L9;
        Bundle r13 = new Bundle(r5.getExtras());
    L10:
        r13.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r5.getAllowGeneratedReplies());
        r10.putBundle(KEY_EXTRAS, r13);
        r10.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(r5.getRemoteInputs()));
        r10.putBoolean(KEY_SHOWS_USER_INTERFACE, r5.getShowsUserInterface());
        r10.putInt(KEY_SEMANTIC_ACTION, r5.getSemanticAction());
        return r10;
    L9:
        r13 = new Bundle();
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public static Bundle getExtras(Notification r10) {
        Object r5 = sExtrasLock;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sExtrasFieldAccessFailed == false) goto L36;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return null;
    L36:
    L20:
        e = move-exception;
        Log.e(TAG, "Unable to access notification extras", e);     // Catch: Throwable -> L8
    L30:
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return null;
    L18:
        e = move-exception;
        Log.e(TAG, "Unable to access notification extras", e);     // Catch: Throwable -> L8
        goto L30
    L12:
        if (sExtrasField != null) goto L23;
        Field r11 = Notification.class.getDeclaredField(KEY_EXTRAS);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (Bundle.class.isAssignableFrom(r11.getType()) == true) goto L22;
        Log.e(TAG, "Notification.extras field is not of type Bundle");     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        monitor-exit(r5);     // Catch: Throwable -> L8
        return null;
    L22:
        r11.setAccessible(true);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasField = r11;     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
    L23:
        Bundle r12 = (Bundle) sExtrasField.get(r10);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (r12 != null) goto L26;
        r12 = new Bundle();     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasField.set(r10, r12);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return r12;
    }

    public static NotificationCompat.Action readAction(int r13, CharSequence r14, PendingIntent r15, Bundle r16) {
        if (r16 == null) goto L5;
        RemoteInput[] r5 = fromBundleArray(getBundleArrayFromBundle(r16, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
        RemoteInput[] r10 = r5;
        RemoteInput[] r11 = fromBundleArray(getBundleArrayFromBundle(r16, EXTRA_DATA_ONLY_REMOTE_INPUTS));
        boolean r12 = r16.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
    L7:
        return new NotificationCompat.Action(r13, r14, r15, r16, r10, r11, r12, 0, true, false, false);
    L5:
        r10 = null;
        r11 = null;
        r12 = false;
        goto L7
    }

    private static Bundle toBundle(RemoteInput r5) {
        Bundle r10 = new Bundle();
        r10.putString(KEY_RESULT_KEY, r5.getResultKey());
        r10.putCharSequence(KEY_LABEL, r5.getLabel());
        r10.putCharSequenceArray(KEY_CHOICES, r5.getChoices());
        r10.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, r5.getAllowFreeFormInput());
        r10.putBundle(KEY_EXTRAS, r5.getExtras());
        Set<String> r11 = r5.getAllowedDataTypes();
        if (r11 != null) goto L5;
    L11:
        return r10;
    L5:
        if (r11.isEmpty() == true) goto L11;
        ArrayList<String> r12 = new ArrayList(r11.size());
        Iterator<String> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.add(r13.next());
        goto L8
    L10:
        r10.putStringArrayList(KEY_ALLOWED_DATA_TYPES, r12);
        goto L11
    }

    private static Bundle[] toBundleArray(RemoteInput[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Bundle[] r10 = new Bundle[r5.length];
        int r11 = 0;
    L7:
        if (r11 >= r5.length) goto L9;
        r10[r11] = toBundle(r5[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder r5, NotificationCompat.Action r10) {
        IconCompat r11 = r10.getIconCompat();
        if (r11 == null) goto L5;
        int r12 = r11.getResId();
    L6:
        r5.addAction(r12, r10.getTitle(), r10.getActionIntent());
        Bundle r13 = new Bundle(r10.getExtras());
        if (r10.getRemoteInputs() == null) goto L10;
        r13.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(r10.getRemoteInputs()));
    L10:
        if (r10.getDataOnlyRemoteInputs() == null) goto L12;
        r13.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(r10.getDataOnlyRemoteInputs()));
    L12:
        r13.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r10.getAllowGeneratedReplies());
        return r13;
    L5:
        r12 = 0;
        goto L6
    }
}
