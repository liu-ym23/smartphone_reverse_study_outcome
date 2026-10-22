package com.bytedance.ai.bridge.filesystem.filemethods;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$GetSavedFileListResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetSavedFileListResultModel", "FsSavedFileItem", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetSavedFileListMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$FsSavedFileItem;", "", "filePath", "", "size", "", "createTime", "<init>", "(Ljava/lang/String;JJ)V", "getFilePath", "()Ljava/lang/String;", "getSize", "()J", "getCreateTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FsSavedFileItem {

        @SerializedName("createTime")
        private final long createTime;

        @SerializedName("filePath")
        private final String filePath;

        @SerializedName("size")
        private final long size;

        public static /* synthetic */ FsSavedFileItem copy$default(FsSavedFileItem r10, String r11, long r12, long r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r11 = r10.filePath;
        L6:
            if ((r14 & 2) == 0) goto L8;
            r12 = r10.size;
        L8:
            long r0 = r12;
            if ((r14 & 4) == 0) goto L11;
            r13 = r10.createTime;
        L11:
            String r16 = r11;
            return r10.copy(r16, r0, r13);
        }

        public final String component1() {
            return this.filePath;
        }

        public final long component2() {
            return this.size;
        }

        public final long component3() {
            return this.createTime;
        }

        public final FsSavedFileItem copy(String r10, long r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "filePath");
            return new FsSavedFileItem(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof FsSavedFileItem) == true) goto L8;
            return false;
        L8:
            FsSavedFileItem r11 = (FsSavedFileItem) r10;
            if (Intrinsics.areEqual(this.filePath, r11.filePath) == true) goto L12;
            return false;
        L12:
            if (this.size == r11.size) goto L15;
            return false;
        L15:
            if (this.createTime == r11.createTime) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.filePath.hashCode() * 31;
            long r1 = this.size;
            int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r11 = this.createTime;
            return r10 + ((int) (r11 ^ (r11 >>> 32)));
        }

        public String toString() {
            return "FsSavedFileItem(filePath=" + this.filePath + ", size=" + this.size + ", createTime=" + this.createTime + ')';
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final long getSize() {
            return this.size;
        }

        public FsSavedFileItem(String r10, long r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "filePath");
            this.filePath = r10;
            this.size = r11;
            this.createTime = r12;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "fileList", required = true)
        void setFileList(List<FsSavedFileItem> r1);
    }

    public AbsGetSavedFileListMethodIDL() {
        this.a = "doubao.getSavedFileList";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
