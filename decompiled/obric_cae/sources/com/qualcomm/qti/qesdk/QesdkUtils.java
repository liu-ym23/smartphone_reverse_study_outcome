package com.qualcomm.qti.qesdk;

import android.util.Log;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class QesdkUtils {
    public static final int GLOBAL_OPCODE = 0;
    public static final int GLOBAL_SUBSYSID = 0;

    public static final class ArrayUtils {
        private ArrayUtils() {
        }

        public static Integer[] toObjectArray(int[] r8) {
            Integer[] r10 = new Integer[r8.length];
            int r11 = 0;
        L4:
            if (r11 >= r8.length) goto L6;
            r10[r11] = new Integer(r8[r11]);
            r11 = r11 + 1;
            goto L4
        L6:
            return r10;
        }

        public static int[] toPrimitiveArray(Integer[] r8) {
            int[] r10 = new int[r8.length];
            int r11 = 0;
        L4:
            if (r11 >= r8.length) goto L6;
            r10[r11] = r8[r11].intValue();
            r11 = r11 + 1;
            goto L4
        L6:
            return r10;
        }
    }

    public final class LIMITS {
        public static final int INT_16_LOWER = -32768;
        public static final int INT_16_UPPER = 32767;
        public static final int INT_8_LOWER = -128;
        public static final int INT_8_UPPER = 127;
        public static final int UINT_16_UPPER = 65535;
        public static final long UINT_32_UPPER = 4294967295L;
        public static final int UINT_8_UPPER = 255;
        final /* synthetic */ QesdkUtils this$0;

        private LIMITS(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public static final class LOG {
        private static final boolean LOG_ENABLED = false;

        private LOG() {
        }

        public static void d(String r8, String r10) {
        }

        public static void e(String r8, String r10) {
            Log.e(r8, r10);
        }

        public static void i(String r8, String r10) {
        }

        public static void w(String r8, String r10) {
            Log.w(r8, r10);
        }
    }

    public final class MISC {
        public static final String BUILD_INFO = "16_321_484";
        public static final boolean DEBUG_STATS_ENABLED = false;
        public static final long KEEP_ALIVE_TIME = 0;
        public static final int LENGTH_OF_INT = 3;
        public static final int LENGTH_OF_UINT = 4;
        public static final int MAX_CORE_POOL_SIZE = 5;
        public static final int MAX_POOL_SIZE = 20;
        public static final int MAX_STRUCT_LVL = 10;
        public static final int NEG_ONE = -1;
        public static final int ONE = 1;
        public static final String RELEASE_VERSION = "Internal";
        public static final int WAIT_TIME = 10;
        public static final int ZERO = 0;
        final /* synthetic */ QesdkUtils this$0;

        private MISC(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public final class QesdkDeInitReturnCodes {
        public static final int SESSION_NOT_FOUND = -1;
        public static final int SESSION_NOT_INIT = -2;
        public static final int TRANSPORT_ERROR = -3;
        final /* synthetic */ QesdkUtils this$0;

        private QesdkDeInitReturnCodes(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public final class QesdkDeInitStatus {
        public static final int FAIL = 1;
        public static final int INVALID_SESSION_ID = 2;
        public static final int SUCCESS = 0;
        final /* synthetic */ QesdkUtils this$0;

        private QesdkDeInitStatus(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public final class QesdkInitReturnCodes {
        public static final int FEATURE_NOT_SUPPORTED = -3;
        public static final int INVALID_LICENSE = -2;
        public static final int LICENSE_NOT_FOUND = -1;
        public static final int TRANSPORT_ERROR = -4;
        final /* synthetic */ QesdkUtils this$0;

        private QesdkInitReturnCodes(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public final class QesdkTaskErrCodes {
        public static final int FAIL = -1;
        public static final int ILLEGAL_ACCESS = -8;
        public static final int INVALID_API = -5;
        public static final int INVALID_ARGS = -2;
        public static final int INVALID_SESSION_ID = -4;
        public static final int INVALID_STATE = -3;
        public static final int OEM_DISABLED_API = -7;
        public static final int SUCCESS = 0;
        public static final int TIMEOUT = -9;
        public static final int UNSUPPORTED_API = -6;
        final /* synthetic */ QesdkUtils this$0;

        public QesdkTaskErrCodes(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public static final class QesdkThreadPoolStats implements Runnable {
        private int delay;
        private ThreadPoolExecutor executor;
        private boolean isRunning;
        private Map taskMap;

        public QesdkThreadPoolStats(ThreadPoolExecutor r8, Map r10, int r11) {
            this.isRunning = true;
            this.executor = r8;
            this.taskMap = r10;
            this.delay = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
        L3:
            if (this.isRunning == false) goto L9;
            String r8 = String.format("[Qesdk_pool_stats] Core pool: %d, Pool: %d, Active: %d, Completed: %d, Task: %d, isShutDown: %s, isTerminated: %s, Queue Size: %d", new Object[]{Integer.valueOf(this.executor.getPoolSize()), Integer.valueOf(this.executor.getCorePoolSize()), Integer.valueOf(this.executor.getActiveCount()), Long.valueOf(this.executor.getCompletedTaskCount()), Long.valueOf(this.executor.getTaskCount()), Boolean.valueOf(this.executor.isShutdown()), Boolean.valueOf(this.executor.isTerminated()), Integer.valueOf(this.executor.getQueue().size())});
            String r10 = String.format("[Qesdk_map_stats] map size: %d", new Object[]{Integer.valueOf(this.taskMap.size())});
            LOG.i(QesdkThreadPoolStats.class.getName(), r8);
            LOG.i(QesdkThreadPoolStats.class.getName(), r10);
            Thread.sleep(this.delay * 1000);     // Catch: InterruptedException -> L7
        L7:
            e = move-exception;
            LOG.i(QesdkThreadPoolStats.class.getName(), e.getMessage());
            goto L3
        }

        public void terminate() {
            this.isRunning = false;
        }
    }

    public static final class QesdkTimer {
        private long mEndTime;
        private int mSessionId;
        private long mStartTime;
        private char mTimeUnit;
        private int mTransactionId;

        public QesdkTimer(int r8, int r10, String r11) {
            this.mStartTime = System.nanoTime();
            this.mSessionId = r8;
            this.mTransactionId = r10;
            String r12 = r11.toLowerCase();
            r12.getClass();
            byte r13 = -1;
            switch(r12.hashCode()) {
                case -2113083352: goto L38;
                case -1081074357: goto L34;
                case -906279820: goto L30;
                case -368353224: goto L26;
                case 115: goto L22;
                case 3525: goto L18;
                case 5726: goto L14;
                case 1465952059: goto L10;
                case 1970096767: goto L6;
                default: goto L41;
            };
        L41:
            switch(r13) {
                case 0: goto L46;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L44;
                case 5: goto L46;
                case 6: goto L43;
                case 7: goto L43;
                case 8: goto L44;
                default: goto L42;
            };
        L42:
            this.mTimeUnit = 'm';
            long r14 = this.mStartTime;
            long r15 = BwdlDropUtils.DROP_SHOW_MEGABYTES;
        L45:
            this.mStartTime = r14 / r15;
            return;
        L43:
            this.mTimeUnit = 181;
            r14 = this.mStartTime;
            r15 = 1000;
            goto L45
        L44:
            this.mTimeUnit = 's';
            r14 = this.mStartTime;
            r15 = BwdlDropUtils.DROP_SHOW_GIGABYTES;
            goto L45
        L46:
            this.mTimeUnit = 'n';
            return;
        L6:
            if (r12.equals("seconds") == false) goto L41;
            r13 = 8;
            goto L41
        L10:
            if (r12.equals("microseconds") == false) goto L41;
            r13 = 7;
            goto L41
        L14:
            if (r12.equals("µs") == false) goto L41;
            r13 = 6;
            goto L41
        L18:
            if (r12.equals("ns") == false) goto L41;
            r13 = 5;
            goto L41
        L22:
            if (r12.equals("s") == false) goto L41;
            r13 = 4;
            goto L41
        L26:
            if (r12.equals("microsecond") == false) goto L41;
            r13 = 3;
            goto L41
        L30:
            if (r12.equals("second") == false) goto L41;
            r13 = 2;
            goto L41
        L34:
            if (r12.equals("nanoseconds") == false) goto L41;
            r13 = 1;
            goto L41
        L38:
            if (r12.equals("nanosecond") == false) goto L41;
            r13 = 0;
            goto L41
        }

        public long getEndTime() {
            return this.mEndTime;
        }

        public int getSessionId() {
            return this.mSessionId;
        }

        public long getStartTime() {
            return this.mStartTime;
        }

        public int getTransactionId() {
            return this.mTransactionId;
        }

        public void start() {
            this.mEndTime = 0;
            long r8 = System.nanoTime();
            this.mStartTime = r8;
            char r10 = this.mTimeUnit;
            if (r10 != 'n') goto L5;
            return;
        L5:
            if (r10 != 's') goto L7;
            long r11 = BwdlDropUtils.DROP_SHOW_GIGABYTES;
        L11:
            this.mStartTime = r8 / r11;
            return;
        L7:
            if (r10 == 181) goto L9;
            r11 = BwdlDropUtils.DROP_SHOW_MEGABYTES;
            goto L11
        L9:
            r11 = 1000;
            goto L11
        }

        public void stop(String r8, String r10) {
            long r11 = System.nanoTime();
            this.mEndTime = r11;
            char r12 = this.mTimeUnit;
            if (r12 == 'n') goto L11;
            if (r12 != 's') goto L6;
            long r13 = BwdlDropUtils.DROP_SHOW_GIGABYTES;
        L10:
            this.mEndTime = r11 / r13;
            goto L11
        L6:
            if (r12 == 181) goto L8;
            r13 = BwdlDropUtils.DROP_SHOW_MEGABYTES;
            goto L10
        L8:
            r13 = 1000;
        L11:
            long r14 = this.mEndTime - this.mStartTime;
            int r15 = this.mSessionId;
            if (r15 != Integer.MAX_VALUE) goto L14;
        L16:
            if (r15 == Integer.MAX_VALUE) goto L19;
            StringBuilder r16 = android.aimedia.a.k(r10, " sessionId ");
            int r17 = this.mSessionId;
        L18:
            r16.append(r17);
            String r18 = r16.toString();
        L21:
            if (this.mTimeUnit != 's') goto L23;
            StringBuilder r19 = new StringBuilder();
            r19.append(r18);
            r19.append(" ");
            r19.append(r14);
            r19.append(" ");
            r19.append(this.mTimeUnit);
        L24:
            LOG.d(r8, r10 + r19.toString());
            return;
        L23:
            r19 = new StringBuilder();
            r19.append(r18);
            r19.append(" ");
            r19.append(r14);
            r19.append(" ");
            r19.append(this.mTimeUnit);
            r19.append("s");
            goto L24
        L19:
            r18 = r10;
            goto L21
        L14:
            if (this.mTransactionId == Integer.MAX_VALUE) goto L16;
            r16 = android.aimedia.a.k(r10, " sessionId ");
            r16.append(this.mSessionId);
            r16.append(" transactionId ");
            r17 = this.mTransactionId;
            goto L18
        }

        public QesdkTimer(int r8, String r10) {
            this.mStartTime = System.nanoTime();
            this.mSessionId = r8;
            this.mTransactionId = Integer.MAX_VALUE;
            String r11 = r10.toLowerCase();
            r11.getClass();
            byte r12 = -1;
            switch(r11.hashCode()) {
                case -2113083352: goto L38;
                case -1081074357: goto L34;
                case -906279820: goto L30;
                case -368353224: goto L26;
                case 115: goto L22;
                case 3525: goto L18;
                case 5726: goto L14;
                case 1465952059: goto L10;
                case 1970096767: goto L6;
                default: goto L41;
            };
        L41:
            switch(r12) {
                case 0: goto L46;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L44;
                case 5: goto L46;
                case 6: goto L43;
                case 7: goto L43;
                case 8: goto L44;
                default: goto L42;
            };
        L42:
            this.mTimeUnit = 'm';
            long r13 = this.mStartTime;
            long r14 = BwdlDropUtils.DROP_SHOW_MEGABYTES;
        L45:
            this.mStartTime = r13 / r14;
            return;
        L43:
            this.mTimeUnit = 181;
            r13 = this.mStartTime;
            r14 = 1000;
            goto L45
        L44:
            this.mTimeUnit = 's';
            r13 = this.mStartTime;
            r14 = BwdlDropUtils.DROP_SHOW_GIGABYTES;
            goto L45
        L46:
            this.mTimeUnit = 'n';
            return;
        L6:
            if (r11.equals("seconds") == false) goto L41;
            r12 = 8;
            goto L41
        L10:
            if (r11.equals("microseconds") == false) goto L41;
            r12 = 7;
            goto L41
        L14:
            if (r11.equals("µs") == false) goto L41;
            r12 = 6;
            goto L41
        L18:
            if (r11.equals("ns") == false) goto L41;
            r12 = 5;
            goto L41
        L22:
            if (r11.equals("s") == false) goto L41;
            r12 = 4;
            goto L41
        L26:
            if (r11.equals("microsecond") == false) goto L41;
            r12 = 3;
            goto L41
        L30:
            if (r11.equals("second") == false) goto L41;
            r12 = 2;
            goto L41
        L34:
            if (r11.equals("nanoseconds") == false) goto L41;
            r12 = 1;
            goto L41
        L38:
            if (r11.equals("nanosecond") == false) goto L41;
            r12 = 0;
            goto L41
        }

        public QesdkTimer(String r8) {
            this.mStartTime = System.nanoTime();
            this.mSessionId = Integer.MAX_VALUE;
            this.mTransactionId = Integer.MAX_VALUE;
            String r10 = r8.toLowerCase();
            r10.getClass();
            byte r11 = -1;
            switch(r10.hashCode()) {
                case -2113083352: goto L38;
                case -1081074357: goto L34;
                case -906279820: goto L30;
                case -368353224: goto L26;
                case 115: goto L22;
                case 3525: goto L18;
                case 5726: goto L14;
                case 1465952059: goto L10;
                case 1970096767: goto L6;
                default: goto L41;
            };
        L41:
            switch(r11) {
                case 0: goto L46;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L44;
                case 5: goto L46;
                case 6: goto L43;
                case 7: goto L43;
                case 8: goto L44;
                default: goto L42;
            };
        L42:
            this.mTimeUnit = 'm';
            long r12 = this.mStartTime;
            long r13 = BwdlDropUtils.DROP_SHOW_MEGABYTES;
        L45:
            this.mStartTime = r12 / r13;
            return;
        L43:
            this.mTimeUnit = 181;
            r12 = this.mStartTime;
            r13 = 1000;
            goto L45
        L44:
            this.mTimeUnit = 's';
            r12 = this.mStartTime;
            r13 = BwdlDropUtils.DROP_SHOW_GIGABYTES;
            goto L45
        L46:
            this.mTimeUnit = 'n';
            return;
        L6:
            if (r10.equals("seconds") == false) goto L41;
            r11 = 8;
            goto L41
        L10:
            if (r10.equals("microseconds") == false) goto L41;
            r11 = 7;
            goto L41
        L14:
            if (r10.equals("µs") == false) goto L41;
            r11 = 6;
            goto L41
        L18:
            if (r10.equals("ns") == false) goto L41;
            r11 = 5;
            goto L41
        L22:
            if (r10.equals("s") == false) goto L41;
            r11 = 4;
            goto L41
        L26:
            if (r10.equals("microsecond") == false) goto L41;
            r11 = 3;
            goto L41
        L30:
            if (r10.equals("second") == false) goto L41;
            r11 = 2;
            goto L41
        L34:
            if (r10.equals("nanoseconds") == false) goto L41;
            r11 = 1;
            goto L41
        L38:
            if (r10.equals("nanosecond") == false) goto L41;
            r11 = 0;
            goto L41
        }
    }

    public final class TAGS {
        public static final String JSON_TAG_ARGS = "args";
        public static final String JSON_TAG_ARG_TYPES = "arg_types";
        public static final String JSON_TAG_CALLBACK = "callback";
        public static final String JSON_TAG_CALLBACKS = "callbacks";
        public static final String JSON_TAG_CALL_TYPE = "call_type";
        public static final String JSON_TAG_CAPABILITY = "capability";
        public static final String JSON_TAG_CB_NAME = "cb_name";
        public static final String JSON_TAG_DEPRECATIONS = "deprecations";
        public static final String JSON_TAG_ENUMS = "enums";
        public static final String JSON_TAG_ENUM_NAME = "enum_name";
        public static final String JSON_TAG_FUNC = "func";
        public static final String JSON_TAG_FUNCS = "funcs";
        public static final String JSON_TAG_FUNCTION = "function";
        public static final String JSON_TAG_FUNCTIONAL_AREA = "functional_area";
        public static final String JSON_TAG_FUNCTIONS = "functions";
        public static final String JSON_TAG_GROUPS = "groups";
        public static final String JSON_TAG_ID = "id";
        public static final String JSON_TAG_MEMBERS = "members";
        public static final String JSON_TAG_NAME = "name";
        public static final String JSON_TAG_NUM_OF_ARGS = "num_of_args";
        public static final String JSON_TAG_NUM_OF_OUTPUTS = "num_of_outputs";
        public static final String JSON_TAG_OPCODE = "opcode";
        public static final String JSON_TAG_OPCODES = "opcodes";
        public static final String JSON_TAG_OUTPUTS = "outputs";
        public static final String JSON_TAG_RETURN = "return";
        public static final String JSON_TAG_RET_TYPE = "ret_type";
        public static final String JSON_TAG_SESSION_ID = "session_id";
        public static final String JSON_TAG_STRUCTS = "structs";
        public static final String JSON_TAG_STRUCT_NAME = "struct_name";
        public static final String JSON_TAG_SUBSYSTEMS = "subsystems";
        public static final String JSON_TAG_SUBSYSTEMS_VERSIONS = "versions";
        public static final String JSON_TAG_SUBSYSTEM_ID = "subsys_id";
        public static final String JSON_TAG_TRANSAC_ID = "transac_id";
        public static final String JSON_TAG_TYPE = "type";
        public static final String JSON_TAG_VALUE = "value";
        public static final String JSON_TAG_VECTORS = "vectors";
        public static final String JSON_TAG_VEC_NAME = "vec_name";
        public static final String JSON_TAG_VEC_TYPE = "vec_type";
        public static final String JSON_TAG_VERSION = "version";
        public static final String TAG_ASYNC = "async";
        public static final String TAG_EXEC_TASK = "exec_task";
        public static final String TAG_FAIL = "fail";
        public static final String TAG_INPUT = "input";
        public static final String TAG_JSON_ID = "id";
        public static final String TAG_JSON_VALUE = "value";
        public static final String TAG_OUTPUT = "output";
        public static final String TAG_REQ_TYPE = "req_type";
        public static final String TAG_STATUS = "status";
        public static final String TAG_SUCCESS = "success";
        public static final String TAG_SYNC = "sync";
        public static final String TAG_TASK_CB_HANDLER = "Qesdk-taskCB-handler";
        public static final String TAG_TASK_HANDLER = "Qesdk-task-handler";
        final /* synthetic */ QesdkUtils this$0;

        private TAGS(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    public final class TYPES {
        public static final String DATA_TYPE_BNRY_BLB = "bnry_blb";
        public static final String DATA_TYPE_BOOLEAN = "boolean";
        public static final String DATA_TYPE_CHAR = "char";
        public static final String DATA_TYPE_DOUBLE = "double";
        public static final String DATA_TYPE_ENUM = "enum";
        public static final String DATA_TYPE_FLOAT = "float";
        public static final String DATA_TYPE_INT = "int";
        public static final String DATA_TYPE_INT_16 = "int16";
        public static final String DATA_TYPE_INT_32 = "int32";
        public static final String DATA_TYPE_INT_64 = "int64";
        public static final String DATA_TYPE_INT_8 = "int8";
        public static final String DATA_TYPE_STRING = "string";
        public static final String DATA_TYPE_STRUCT = "struct";
        public static final String DATA_TYPE_UINT = "uint";
        public static final String DATA_TYPE_UINT_16 = "uint16";
        public static final String DATA_TYPE_UINT_32 = "uint32";
        public static final String DATA_TYPE_UINT_64 = "uint64";
        public static final String DATA_TYPE_UINT_8 = "uint8";
        public static final String DATA_TYPE_VECTOR = "vector";
        final /* synthetic */ QesdkUtils this$0;

        private TYPES(QesdkUtils r8) {
            this.this$0 = r8;
        }
    }

    private QesdkUtils() {
    }
}
