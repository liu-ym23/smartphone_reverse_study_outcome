package com.ss.ugc.effectplatform.model.algorithm;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.f;
import com.ss.ugc.effectplatform.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00038VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\f\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "", "_name", "", "name_sec", EffectConfiguration.KEY_VERSION, "file_url", "Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "totalSize", "", EffectConfiguration.KEY_TYPE, "", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;JII)V", "getFile_url", "()Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "setFile_url", "(Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;)V", DBDefinition.NAME, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName_sec", "setName_sec", "getStatus", "()I", "setStatus", "(I)V", "getTotalSize", "()J", "setTotalSize", "(J)V", "getType", "setType", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ModelInfo {
    private String _name;
    private ExtendedUrlModel file_url;
    private String name;
    private String name_sec;
    private int status;
    private long totalSize;
    private int type;
    private String version;

    public ModelInfo() {
        this(null, null, null, null, 0, 0, 0, 127, null);
    }

    public String getName() {
        if (StringsKt.isBlank(this._name) == false) goto L14;
        if ((!StringsKt.isBlank(getName_sec())) == false) goto L14;
        j r0 = f.a;
        j r1 = f.a;
        if (r1 == null) goto L11;
        String r2 = r1.decrypt(getName_sec());
        if (r2 == null) goto L11;
    L12:
        this._name = r2;
    L11:
        r2 = "";
    L14:
        if (StringsKt.isBlank(this._name) == false) goto L17;
        return this.name;
    L17:
        return this._name;
    }

    public ExtendedUrlModel getFile_url() {
        return this.file_url;
    }

    public String getName_sec() {
        return this.name_sec;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setFile_url(ExtendedUrlModel r1) {
        this.file_url = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setName_sec(String r1) {
        this.name_sec = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setTotalSize(long r1) {
        this.totalSize = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    public ModelInfo(String r1, String r2, String r3, ExtendedUrlModel r4, long r5, int r7, int r8) {
        this._name = r1;
        this.name_sec = r2;
        this.version = r3;
        this.file_url = r4;
        this.totalSize = r5;
        this.type = r7;
        this.status = r8;
        this.name = "";
    }

    public /* synthetic */ ModelInfo(String r9, String r10, String r11, ExtendedUrlModel r12, long r13, int r15, int r16, int r17, DefaultConstructorMarker r18) {
        String r1 = "";
        if ((r17 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r17 & 4) != 0) goto L15;
        r1 = r11;
    L15:
        if ((r17 & 8) == 0) goto L17;
        ExtendedUrlModel r3 = null;
    L19:
        if ((r17 & 16) == 0) goto L21;
        long r4 = 0;
    L23:
        if ((r17 & 32) == 0) goto L25;
        int r6 = 0;
    L27:
        if ((r17 & 64) == 0) goto L29;
        int r7 = 1;
    L30:
        this(r0, r2, r1, r3, r4, r6, r7);
        return;
    L29:
        r7 = r16;
        goto L30
    L25:
        r6 = r15;
        goto L27
    L21:
        r4 = r13;
        goto L23
    L17:
        r3 = r12;
        goto L19
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L7
    }
}
