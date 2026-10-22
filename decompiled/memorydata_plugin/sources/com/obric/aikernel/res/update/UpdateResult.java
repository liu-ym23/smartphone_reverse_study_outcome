package com.obric.aikernel.res.update;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.trace.TraceCons;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003Jm\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0003J\u0006\u0010B\u001a\u00020@J\t\u0010C\u001a\u00020\u0007HÖ\u0001J\u000e\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u001bJ\u000e\u0010\u0004\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0003J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0016\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014¨\u0006H"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateResult;", "", "biz", "", "success", "", "stage", "", NotificationCompat.CATEGORY_MESSAGE, "finished", "startTimestamp", "", "finishTimestamp", "caller", "prior", TraceCons.METRIC_BACKGROUND, "(Ljava/lang/String;ZILjava/lang/String;ZJJLjava/lang/String;IZ)V", "getBackground", "()Z", "setBackground", "(Z)V", "getBiz", "()Ljava/lang/String;", "getCaller", "setCaller", "(Ljava/lang/String;)V", "cfg", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "getCfg", "()Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "setCfg", "(Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;)V", "getFinishTimestamp", "()J", "setFinishTimestamp", "(J)V", "getFinished", "setFinished", "getMsg", "setMsg", "getPrior", "()I", "setPrior", "(I)V", "getStage", "setStage", "getStartTimestamp", "setStartTimestamp", "getSuccess", "setSuccess", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "fail", "", "message", "finish", "hashCode", CommonConsts.APM_INNER_EVENT_COST_START, "config", "toString", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    private com.obric.aikernel.res.metadata.config.k cfg;
    private long finishTimestamp;
    private boolean finished;
    private String msg;
    private int prior;
    private int stage;
    private long startTimestamp;
    private boolean success;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateResult$Companion;", "", "()V", "CODE_DOWNLOAD", "", "CODE_GET_METADATA", "CODE_INIT", "CODE_INSTALL", "CODE_PROCESS_FILE", "CODE_SUCCESS", "LAST_STAGE", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public UpdateResult(String r2, boolean r3, int r4, String r5, boolean r6, long r7, long r9, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r11, "caller");
        this.biz = r2;
        this.success = r3;
        this.stage = r4;
        this.msg = r5;
        this.finished = r6;
        this.startTimestamp = r7;
        this.finishTimestamp = r9;
        this.caller = r11;
        this.prior = r12;
        this.background = r13;
    }

    public /* synthetic */ UpdateResult(String r13, boolean r14, int r15, String r16, boolean r17, long r18, long r20, String r22, int r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        boolean r2 = true;
        if ((r25 & 2) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r25 & 4) == 0) goto L9;
        int r3 = 1;
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r4 = "no update task progressing";
    L15:
        if ((r25 & 16) == 0) goto L17;
        boolean r5 = true;
    L18:
        long r7 = 0;
        if ((r25 & 32) == 0) goto L21;
        long r9 = 0;
    L23:
        if ((r25 & 64) != 0) goto L27;
        r7 = r20;
    L27:
        if ((r25 & 128) == 0) goto L29;
        String r6 = "";
    L31:
        if ((r25 & 256) == 0) goto L33;
        int r11 = 0;
    L35:
        if ((r25 & 512) != 0) goto L38;
        r2 = r24;
    L38:
        this(r13, r1, r3, r4, r5, r9, r7, r6, r11, r2);
        return;
    L33:
        r11 = r23;
        goto L35
    L29:
        r6 = r22;
        goto L31
    L21:
        r9 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L18
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }

    public static /* synthetic */ UpdateResult copy$default(UpdateResult r13, String r14, boolean r15, int r16, String r17, boolean r18, long r19, long r21, String r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.biz;
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r3 = r13.success;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r4 = r13.stage;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.msg;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r6 = r13.finished;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r7 = r13.startTimestamp;
    L27:
        if ((r26 & 64) == 0) goto L29;
        long r9 = r13.finishTimestamp;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r11 = r13.caller;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r12 = r13.prior;
    L39:
        if ((r26 & 512) == 0) goto L41;
        boolean r1 = r13.background;
    L43:
        return r13.copy(r2, r3, r4, r5, r6, r7, r9, r11, r12, r1);
    L41:
        r1 = r25;
        goto L43
    L37:
        r12 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
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

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, UpdateResult.class) == true) goto L8;
        return false;
    L8:
        UpdateResult r10 = (UpdateResult) ZeusTransformUtils.preCheckCast(r9, UpdateResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.biz, r10.biz) == true) goto L12;
        return false;
    L12:
        if (this.success == r10.success) goto L15;
        return false;
    L15:
        if (this.stage == r10.stage) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msg, r10.msg) == true) goto L21;
        return false;
    L21:
        if (this.finished == r10.finished) goto L24;
        return false;
    L24:
        if (this.startTimestamp == r10.startTimestamp) goto L27;
        return false;
    L27:
        if (this.finishTimestamp == r10.finishTimestamp) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.caller, r10.caller) == true) goto L33;
        return false;
    L33:
        if (this.prior == r10.prior) goto L36;
        return false;
    L36:
        if (this.background == r10.background) goto L38;
        return false;
    L38:
        return true;
    }

    public final void fail(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.success = false;
        StringBuilder r0 = new StringBuilder();
        com.obric.aikernel.res.metadata.config.k r1 = this.cfg;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a();
    L6:
        StringBuilder r5 = r0.append(r3).append('@');
        com.obric.aikernel.res.metadata.config.k r6 = this.cfg;
        if (r6 == null) goto L9;
        String r7 = r6.c();
    L10:
        StringBuilder r8 = r5.append(r7).append('_');
        com.obric.aikernel.res.metadata.config.k r9 = this.cfg;
        if (r9 == null) goto L13;
        r2 = r9.l();
    L13:
        this.msg = r8.append(r2).append(' ').append(r4).toString();
        finish();
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void finish() {
        this.finished = true;
        this.finishTimestamp = r.a();
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

    public final com.obric.aikernel.res.metadata.config.k getCfg() {
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
        int r0 = this.biz.hashCode() * 31;
        boolean r1 = this.success;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (((((r0 + r3) * 31) + Integer.hashCode(this.stage)) * 31) + this.msg.hashCode()) * 31;
        boolean r5 = this.finished;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (((((((((r4 + r6) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.finishTimestamp)) * 31) + this.caller.hashCode()) * 31) + Integer.hashCode(this.prior)) * 31;
        boolean r8 = this.background;
        if (r8 == true) goto L13;
        r2 = r8;
    L13:
        return r7 + r2;
    }

    public final void setBackground(boolean r1) {
        this.background = r1;
    }

    public final void setCaller(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.caller = r2;
    }

    public final void setCfg(com.obric.aikernel.res.metadata.config.k r1) {
        this.cfg = r1;
    }

    public final void setFinishTimestamp(long r1) {
        this.finishTimestamp = r1;
    }

    public final void setFinished(boolean r1) {
        this.finished = r1;
    }

    public final void setMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.msg = r2;
    }

    public final void setPrior(int r1) {
        this.prior = r1;
    }

    public final void setStage(int r1) {
        this.stage = r1;
    }

    public final void setStartTimestamp(long r1) {
        this.startTimestamp = r1;
    }

    public final void setSuccess(boolean r1) {
        this.success = r1;
    }

    public final void start(com.obric.aikernel.res.metadata.config.k r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.success = false;
        this.finished = false;
        this.msg = "";
        this.startTimestamp = SystemClock.elapsedRealtime();
        this.cfg = r3;
    }

    public final void success(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.success = true;
        StringBuilder r0 = new StringBuilder();
        com.obric.aikernel.res.metadata.config.k r1 = this.cfg;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a();
    L6:
        StringBuilder r5 = r0.append(r3).append('@');
        com.obric.aikernel.res.metadata.config.k r6 = this.cfg;
        if (r6 == null) goto L9;
        String r7 = r6.c();
    L10:
        StringBuilder r8 = r5.append(r7).append('_');
        com.obric.aikernel.res.metadata.config.k r9 = this.cfg;
        if (r9 == null) goto L13;
        r2 = r9.l();
    L13:
        this.msg = r8.append(r2).append(' ').append(r4).toString();
        finish();
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public String toString() {
        return "UpdateResult(biz=" + this.biz + ", success=" + this.success + ", stage=" + this.stage + ", msg=" + this.msg + ", finished=" + this.finished + ", startTimestamp=" + this.startTimestamp + ", finishTimestamp=" + this.finishTimestamp + ", caller=" + this.caller + ", prior=" + this.prior + ", background=" + this.background + ')';
    }
}
