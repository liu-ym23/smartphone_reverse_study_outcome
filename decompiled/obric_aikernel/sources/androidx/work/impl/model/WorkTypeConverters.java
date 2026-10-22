package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import androidx.room.TypeConverter;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkTypeConverters {
    public static final WorkTypeConverters INSTANCE = null;

    private static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final BackoffPolicyIds INSTANCE = null;
        public static final int LINEAR = 1;

        static {
            INSTANCE = new BackoffPolicyIds();
        }

        private BackoffPolicyIds() {
        }
    }

    private static final class NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final NetworkTypeIds INSTANCE = null;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;

        static {
            INSTANCE = new NetworkTypeIds();
        }

        private NetworkTypeIds() {
        }
    }

    private static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final OutOfPolicyIds INSTANCE = null;
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        static {
            INSTANCE = new OutOfPolicyIds();
        }

        private OutOfPolicyIds() {
        }
    }

    public static final class StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final StateIds INSTANCE = null;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;

        static {
            INSTANCE = new StateIds();
        }

        private StateIds() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            int[] r10 = new int[WorkInfo.State.values().length];
            r10[WorkInfo.State.ENQUEUED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L62:
            r10[WorkInfo.State.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L70:
            r10[WorkInfo.State.SUCCEEDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L46:
            r10[WorkInfo.State.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L48:
            r10[WorkInfo.State.BLOCKED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L56:
            r10[WorkInfo.State.CANCELLED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L13:
            $EnumSwitchMapping$0 = r10;
            int[] r11 = new int[BackoffPolicy.values().length];
            r11[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L50:
            r11[BackoffPolicy.LINEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L16:
            $EnumSwitchMapping$1 = r11;
            int[] r12 = new int[NetworkType.values().length];
            r12[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L44:
            r12[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L52:
            r12[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L58:
            r12[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L64:
            r12[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L22:
            $EnumSwitchMapping$2 = r12;
            int[] r13 = new int[OutOfQuotaPolicy.values().length];
            r13[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L68:
            r13[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L25:
            $EnumSwitchMapping$3 = r13;
        }
    }

    static {
        INSTANCE = new WorkTypeConverters();
    }

    private WorkTypeConverters() {
    }

    @JvmStatic
    @TypeConverter
    public static final int backoffPolicyToInt(BackoffPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "backoffPolicy");
        int r11 = WhenMappings.$EnumSwitchMapping$1[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    @TypeConverter
    public static final Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = 0;
        if (r10.length != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        return r11;
    L8:
        ByteArrayInputStream r14 = new ByteArrayInputStream(r10);
        ObjectInputStream r15 = new ObjectInputStream(r14);     // Catch: Throwable -> L21 IOException -> L23
        int r16 = r15.readInt();     // Catch: Throwable -> L16
    L11:
        if (r12 >= r16) goto L13;
        Uri r17 = Uri.parse(r15.readUTF());     // Catch: Throwable -> L16
        boolean r18 = r15.readBoolean();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r17, "uri");     // Catch: Throwable -> L16
        r11.add(new Constraints.ContentUriTrigger(r17, r18));     // Catch: Throwable -> L16
        r12 = r12 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L21 IOException -> L23
    L25:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r14, null);
        return r11;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L21 IOException -> L23
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L5:
        r13 = false;
        goto L6
    }

    @JvmStatic
    @TypeConverter
    public static final BackoffPolicy intToBackoffPolicy(int r10) {
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L7;
        return BackoffPolicy.LINEAR;
    L7:
        throw new IllegalArgumentException("Could not convert " + r10 + " to BackoffPolicy");
    L9:
        return BackoffPolicy.EXPONENTIAL;
    }

    @JvmStatic
    @TypeConverter
    public static final NetworkType intToNetworkType(int r10) {
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L27;
        if (r10 == 3) goto L26;
        if (r10 == 4) goto L25;
        if (Build.VERSION.SDK_INT < 30) goto L18;
        if (r10 != 5) goto L18;
        return NetworkType.TEMPORARILY_UNMETERED;
    L18:
        throw new IllegalArgumentException("Could not convert " + r10 + " to NetworkType");
    L25:
        return NetworkType.METERED;
    L26:
        return NetworkType.NOT_ROAMING;
    L27:
        return NetworkType.UNMETERED;
    L28:
        return NetworkType.CONNECTED;
    L24:
        return NetworkType.NOT_REQUIRED;
    }

    @JvmStatic
    @TypeConverter
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int r10) {
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L7;
        return OutOfQuotaPolicy.DROP_WORK_REQUEST;
    L7:
        throw new IllegalArgumentException("Could not convert " + r10 + " to OutOfQuotaPolicy");
    L9:
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    @JvmStatic
    @TypeConverter
    public static final WorkInfo.State intToState(int r10) {
        if (r10 == 0) goto L21;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L23;
        if (r10 != 5) goto L15;
        return WorkInfo.State.CANCELLED;
    L15:
        throw new IllegalArgumentException("Could not convert " + r10 + " to State");
    L23:
        return WorkInfo.State.BLOCKED;
    L24:
        return WorkInfo.State.FAILED;
    L25:
        return WorkInfo.State.SUCCEEDED;
    L26:
        return WorkInfo.State.RUNNING;
    L21:
        return WorkInfo.State.ENQUEUED;
    }

    @JvmStatic
    @TypeConverter
    public static final int networkTypeToInt(NetworkType r10) {
        Intrinsics.checkNotNullParameter(r10, "networkType");
        int r11 = WhenMappings.$EnumSwitchMapping$2[r10.ordinal()];
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L23;
        if (r11 == 4) goto L22;
        if (r11 == 5) goto L21;
        if (Build.VERSION.SDK_INT < 30) goto L14;
        if (r10 != NetworkType.TEMPORARILY_UNMETERED) goto L14;
        return 5;
    L14:
        throw new IllegalArgumentException("Could not convert " + r10 + " to int");
    L21:
        return 4;
    L22:
        return 3;
    L23:
        return 2;
    L24:
        return 1;
    L19:
        return 0;
    }

    @JvmStatic
    @TypeConverter
    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "policy");
        int r11 = WhenMappings.$EnumSwitchMapping$3[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    @TypeConverter
    public static final byte[] setOfTriggersToByteArray(Set<Constraints.ContentUriTrigger> r10) {
        Intrinsics.checkNotNullParameter(r10, "triggers");
        if (r10.isEmpty() == true) goto L5;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = new ObjectOutputStream(r11);     // Catch: Throwable -> L22
        r12.writeInt(r10.size());     // Catch: Throwable -> L17
        Iterator<Constraints.ContentUriTrigger> r13 = r10.iterator();     // Catch: Throwable -> L17
    L10:
        if (r13.hasNext() == false) goto L12;
        Constraints.ContentUriTrigger r14 = r13.next();     // Catch: Throwable -> L17
        r12.writeUTF(r14.getUri().toString());     // Catch: Throwable -> L17
        r12.writeBoolean(r14.isTriggeredForDescendants());     // Catch: Throwable -> L17
        goto L10
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L14:
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r11, null);
        byte[] r16 = r11.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r16, "outputStream.toByteArray()");
        return r16;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L5:
        return new byte[0];
    }

    @JvmStatic
    @TypeConverter
    public static final int stateToInt(WorkInfo.State r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 2;
    L10:
        return 1;
    L11:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
