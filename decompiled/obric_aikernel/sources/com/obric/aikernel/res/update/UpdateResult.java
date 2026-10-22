package com.obric.aikernel.res.update;

import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class UpdateResult {
    public static final int CODE_DOWNLOAD = 200;
    public static final int CODE_GET_METADATA = 100;
    public static final int CODE_INIT = 1;
    public static final int CODE_INSTALL = 400;
    public static final int CODE_PROCESS_FILE = 300;
    public static final int CODE_SUCCESS = 500;
    public static final a Companion = null;
    public static final int LAST_STAGE = 500;
    private boolean background;
    private final String biz;
    private String caller;
    private UpdateTaskConfig cfg;
    private long finishTimestamp;
    private boolean finished;
    private String msg;
    private int prior;
    private int stage;
    private long startTimestamp;
    private boolean success;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public UpdateResult(String r10, boolean r11, int r12, String r13, boolean r14, long r15, long r16, String r17, int r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r10, "biz");
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r17, "caller");
        this.biz = r10;
        this.success = r11;
        this.stage = r12;
        this.msg = r13;
        this.finished = r14;
        this.startTimestamp = r15;
        this.finishTimestamp = r16;
        this.caller = r17;
        this.prior = r18;
        this.background = r19;
    }

    public /* synthetic */ UpdateResult(String r13, boolean r14, int r15, String r16, boolean r17, long r18, long r20, String r22, int r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        boolean r10 = true;
        if ((r25 & 2) == 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r25 & 4) == 0) goto L9;
        int r12 = 1;
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r19 = "no update task progressing";
    L15:
        if ((r25 & 16) == 0) goto L17;
        boolean r21 = true;
    L18:
        long r27 = 0;
        if ((r25 & 32) == 0) goto L21;
        long r28 = 0;
    L23:
        if ((r25 & 64) != 0) goto L27;
        r27 = r20;
    L27:
        if ((r25 & 128) == 0) goto L29;
        String r29 = "";
    L31:
        if ((r25 & 256) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r25 & 512) != 0) goto L38;
        r10 = r24;
    L38:
        this(r13, r11, r12, r19, r21, r28, r27, r29, r110, r10);
        return;
    L33:
        r110 = r23;
        goto L35
    L29:
        r29 = r22;
        goto L31
    L21:
        r28 = r18;
        goto L23
    L17:
        r21 = r17;
        goto L18
    L13:
        r19 = r16;
        goto L15
    L9:
        r12 = r15;
        goto L11
    L5:
        r11 = r14;
        goto L7
    }

    public static /* synthetic */ UpdateResult copy$default(UpdateResult r13, String r14, boolean r15, int r16, String r17, boolean r18, long r19, long r21, String r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r10 = r13.biz;
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r11 = r13.success;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r12 = r13.stage;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r20 = r13.msg;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r22 = r13.finished;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r28 = r13.startTimestamp;
    L27:
        if ((r26 & 64) == 0) goto L29;
        long r29 = r13.finishTimestamp;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r110 = r13.caller;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r111 = r13.prior;
    L39:
        if ((r26 & 512) == 0) goto L41;
        boolean r30 = r13.background;
    L43:
        return r13.copy(r10, r11, r12, r20, r22, r28, r29, r110, r111, r30);
    L41:
        r30 = r25;
        goto L43
    L37:
        r111 = r24;
        goto L39
    L33:
        r110 = r23;
        goto L35
    L29:
        r29 = r21;
        goto L31
    L25:
        r28 = r19;
        goto L27
    L21:
        r22 = r18;
        goto L23
    L17:
        r20 = r17;
        goto L19
    L13:
        r12 = r16;
        goto L15
    L9:
        r11 = r15;
        goto L11
    L5:
        r10 = r14;
        goto L7
    }

    public final String component1() {
        return this.biz;
    }

    public final boolean component10() {
        return this.background;
    }

    public final boolean component2() {
        return this.success;
    }

    public final int component3() {
        return this.stage;
    }

    public final String component4() {
        return this.msg;
    }

    public final boolean component5() {
        return this.finished;
    }

    public final long component6() {
        return this.startTimestamp;
    }

    public final long component7() {
        return this.finishTimestamp;
    }

    public final String component8() {
        return this.caller;
    }

    public final int component9() {
        return this.prior;
    }

    public final UpdateResult copy(String r15, boolean r16, int r17, String r18, boolean r19, long r20, long r22, String r24, int r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r15, "biz");
        Intrinsics.checkNotNullParameter(r18, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r24, "caller");
        return new UpdateResult(r15, r16, r17, r18, r19, r20, r22, r24, r25, r26);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UpdateResult) == true) goto L8;
        return false;
    L8:
        UpdateResult r11 = (UpdateResult) r10;
        if (Intrinsics.areEqual(this.biz, r11.biz) == true) goto L12;
        return false;
    L12:
        if (this.success == r11.success) goto L15;
        return false;
    L15:
        if (this.stage == r11.stage) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msg, r11.msg) == true) goto L21;
        return false;
    L21:
        if (this.finished == r11.finished) goto L24;
        return false;
    L24:
        if (this.startTimestamp == r11.startTimestamp) goto L27;
        return false;
    L27:
        if (this.finishTimestamp == r11.finishTimestamp) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.caller, r11.caller) == true) goto L33;
        return false;
    L33:
        if (this.prior == r11.prior) goto L36;
        return false;
    L36:
        if (this.background == r11.background) goto L38;
        return false;
    L38:
        return true;
    }

    public final void fail(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        this.success = false;
        StringBuilder r11 = new StringBuilder();
        UpdateTaskConfig r12 = this.cfg;
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.g();
    L6:
        r11.append(r14);
        r11.append('@');
        UpdateTaskConfig r15 = this.cfg;
        if (r15 == null) goto L9;
        String r16 = r15.i();
    L10:
        r11.append(r16);
        r11.append('_');
        UpdateTaskConfig r17 = this.cfg;
        if (r17 == null) goto L13;
        r13 = r17.k();
    L13:
        r11.append(r13);
        r11.append(' ');
        r11.append(r10);
        this.msg = r11.toString();
        finish();
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public final void finish() {
        this.finished = true;
        this.finishTimestamp = n.a();
    }

    public final boolean getBackground() {
        return this.background;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getCaller() {
        return this.caller;
    }

    public final UpdateTaskConfig getCfg() {
        return this.cfg;
    }

    public final long getFinishTimestamp() {
        return this.finishTimestamp;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getPrior() {
        return this.prior;
    }

    public final int getStage() {
        return this.stage;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r10 = this.biz.hashCode() * 31;
        boolean r11 = this.success;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L5;
        r13 = 1;
    L5:
        int r14 = (((((r10 + r13) * 31) + Integer.hashCode(this.stage)) * 31) + this.msg.hashCode()) * 31;
        boolean r15 = this.finished;
        ?? r16 = r15;
        if (r15 == false) goto L8;
        r16 = 1;
    L8:
        int r17 = (((((((((r14 + r16) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.finishTimestamp)) * 31) + this.caller.hashCode()) * 31) + Integer.hashCode(this.prior)) * 31;
        boolean r18 = this.background;
        if (r18 == true) goto L13;
        r12 = r18;
    L13:
        return r17 + r12;
    }

    public final void setBackground(boolean r10) {
        this.background = r10;
    }

    public final void setCaller(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.caller = r10;
    }

    public final void setCfg(UpdateTaskConfig r10) {
        this.cfg = r10;
    }

    public final void setFinishTimestamp(long r10) {
        this.finishTimestamp = r10;
    }

    public final void setFinished(boolean r10) {
        this.finished = r10;
    }

    public final void setMsg(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.msg = r10;
    }

    public final void setPrior(int r10) {
        this.prior = r10;
    }

    public final void setStage(int r10) {
        this.stage = r10;
    }

    public final void setStartTimestamp(long r10) {
        this.startTimestamp = r10;
    }

    public final void setSuccess(boolean r10) {
        this.success = r10;
    }

    public final void start(UpdateTaskConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.success = false;
        this.finished = false;
        this.msg = "";
        this.startTimestamp = SystemClock.elapsedRealtime();
        this.cfg = r10;
    }

    public final void success(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        this.success = true;
        StringBuilder r11 = new StringBuilder();
        UpdateTaskConfig r12 = this.cfg;
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.g();
    L6:
        r11.append(r14);
        r11.append('@');
        UpdateTaskConfig r15 = this.cfg;
        if (r15 == null) goto L9;
        String r16 = r15.i();
    L10:
        r11.append(r16);
        r11.append('_');
        UpdateTaskConfig r17 = this.cfg;
        if (r17 == null) goto L13;
        r13 = r17.k();
    L13:
        r11.append(r13);
        r11.append(' ');
        r11.append(r10);
        this.msg = r11.toString();
        finish();
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public String toString() {
        return "UpdateResult(biz=" + this.biz + ", success=" + this.success + ", stage=" + this.stage + ", msg=" + this.msg + ", finished=" + this.finished + ", startTimestamp=" + this.startTimestamp + ", finishTimestamp=" + this.finishTimestamp + ", caller=" + this.caller + ", prior=" + this.prior + ", background=" + this.background + ')';
    }
}
