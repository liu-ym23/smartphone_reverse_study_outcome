package com.obric.aikernel.model.device.encrypt;

import androidx.annotation.Keep;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class ScriptModelInfo {
    private final boolean aikernel_sync_now;
    private final String hyper_param;
    private final String model_key;
    private final String name;
    private final int runtime;
    private final ScriptModelFile tokenizer_file;
    private final int type;
    private final int version;
    private final List<ScriptModelFile> weight_files;

    public ScriptModelInfo(String r10, int r11, int r12, int r13, String r14, List<ScriptModelFile> r15, ScriptModelFile r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r14, "model_key");
        Intrinsics.checkNotNullParameter(r15, "weight_files");
        Intrinsics.checkNotNullParameter(r17, "hyper_param");
        this.name = r10;
        this.version = r11;
        this.type = r12;
        this.runtime = r13;
        this.model_key = r14;
        this.weight_files = r15;
        this.tokenizer_file = r16;
        this.hyper_param = r17;
        this.aikernel_sync_now = r18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScriptModelInfo copy$default(ScriptModelInfo r10, String r11, int r12, int r13, int r14, String r15, List r16, ScriptModelFile r17, String r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r22 = r10.name;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r23 = r10.version;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r24 = r10.type;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r25 = r10.runtime;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r26 = r10.model_key;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r27 = r10.weight_files;
    L27:
        if ((r20 & 64) == 0) goto L29;
        ScriptModelFile r28 = r10.tokenizer_file;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r29 = r10.hyper_param;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r30 = r10.aikernel_sync_now;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L37:
        r30 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.version;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.runtime;
    }

    public final String component5() {
        return this.model_key;
    }

    public final List<ScriptModelFile> component6() {
        return this.weight_files;
    }

    public final ScriptModelFile component7() {
        return this.tokenizer_file;
    }

    public final String component8() {
        return this.hyper_param;
    }

    public final boolean component9() {
        return this.aikernel_sync_now;
    }

    public final ScriptModelInfo copy(String r12, int r13, int r14, int r15, String r16, List<ScriptModelFile> r17, ScriptModelFile r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r16, "model_key");
        Intrinsics.checkNotNullParameter(r17, "weight_files");
        Intrinsics.checkNotNullParameter(r19, "hyper_param");
        return new ScriptModelInfo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ScriptModelInfo) == true) goto L8;
        return false;
    L8:
        ScriptModelInfo r11 = (ScriptModelInfo) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (this.version == r11.version) goto L15;
        return false;
    L15:
        if (this.type == r11.type) goto L18;
        return false;
    L18:
        if (this.runtime == r11.runtime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.model_key, r11.model_key) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.weight_files, r11.weight_files) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tokenizer_file, r11.tokenizer_file) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.hyper_param, r11.hyper_param) == true) goto L33;
        return false;
    L33:
        if (this.aikernel_sync_now == r11.aikernel_sync_now) goto L35;
        return false;
    L35:
        return true;
    }

    public final boolean getAikernel_sync_now() {
        return this.aikernel_sync_now;
    }

    public final String getHyper_param() {
        return this.hyper_param;
    }

    public final String getModel_key() {
        return this.model_key;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRuntime() {
        return this.runtime;
    }

    public final ScriptModelFile getTokenizer_file() {
        return this.tokenizer_file;
    }

    public final int getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    public final List<ScriptModelFile> getWeight_files() {
        return this.weight_files;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r10 = ((((((((((this.name.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.runtime)) * 31) + this.model_key.hashCode()) * 31) + this.weight_files.hashCode()) * 31;
        ScriptModelFile r11 = this.tokenizer_file;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (((r10 + r12) * 31) + this.hyper_param.hashCode()) * 31;
        boolean r14 = this.aikernel_sync_now;
        ?? r15 = r14;
        if (r14 == false) goto L10;
        r15 = 1;
    L10:
        return r13 + r15;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "ScriptModelInfo(name=" + this.name + ", version=" + this.version + ", type=" + this.type + ", runtime=" + this.runtime + ", model_key=" + this.model_key + ", weight_files=" + this.weight_files + ", tokenizer_file=" + this.tokenizer_file + ", hyper_param=" + this.hyper_param + ", aikernel_sync_now=" + this.aikernel_sync_now + ')';
    }
}
