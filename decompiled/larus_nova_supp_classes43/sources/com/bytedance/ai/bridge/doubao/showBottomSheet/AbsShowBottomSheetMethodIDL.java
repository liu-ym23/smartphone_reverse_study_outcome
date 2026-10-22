package com.bytedance.ai.bridge.doubao.showBottomSheet;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$ShowBottomSheetParamModel;", "Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$ShowBottomSheetResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "ShowBottomSheetParamModel", "ShowBottomSheetResultModel", "BottomSheetButton", "BottomSheetBehavior", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsShowBottomSheetMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$BottomSheetBehavior;", "", "dismissOnMaskTap", "", "<init>", "(Ljava/lang/Boolean;)V", "getDismissOnMaskTap", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$BottomSheetBehavior;", "equals", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomSheetBehavior {

        @SerializedName("dismissOnMaskTap")
        private final Boolean dismissOnMaskTap;

        public BottomSheetBehavior() {
            Boolean r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ BottomSheetBehavior copy$default(BottomSheetBehavior r0, Boolean r1, int r10, Object r11) {
            if ((r10 & 1) == 0) goto L6;
            r1 = r0.dismissOnMaskTap;
        L6:
            return r0.copy(r1);
        }

        public final Boolean component1() {
            return this.dismissOnMaskTap;
        }

        public final BottomSheetBehavior copy(Boolean r10) {
            return new BottomSheetBehavior(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BottomSheetBehavior) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.dismissOnMaskTap, ((BottomSheetBehavior) r10).dismissOnMaskTap) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.dismissOnMaskTap;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "BottomSheetBehavior(dismissOnMaskTap=" + this.dismissOnMaskTap + ')';
        }

        public final Boolean getDismissOnMaskTap() {
            return this.dismissOnMaskTap;
        }

        public BottomSheetBehavior(Boolean r1) {
            this.dismissOnMaskTap = r1;
        }

        public /* synthetic */ BottomSheetBehavior(Boolean r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$BottomSheetButton;", "", "role", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomSheetButton {

        @SerializedName("role")
        private final String role;

        @SerializedName("text")
        private final String text;

        public static /* synthetic */ BottomSheetButton copy$default(BottomSheetButton r0, String r1, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.role;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.text;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.role;
        }

        public final String component2() {
            return this.text;
        }

        public final BottomSheetButton copy(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "role");
            Intrinsics.checkNotNullParameter(r11, "text");
            return new BottomSheetButton(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BottomSheetButton) == true) goto L8;
            return false;
        L8:
            BottomSheetButton r11 = (BottomSheetButton) r10;
            if (Intrinsics.areEqual(this.role, r11.role) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.text, r11.text) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.role.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "BottomSheetButton(role=" + this.role + ", text=" + this.text + ')';
        }

        public final String getRole() {
            return this.role;
        }

        public final String getText() {
            return this.text;
        }

        public BottomSheetButton(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "role");
            Intrinsics.checkNotNullParameter(r11, "text");
            this.role = r10;
            this.text = r11;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "behavior", required = false)
        BottomSheetBehavior getBehavior();

        @AIBridgeParamField(keyPath = "buttons", required = true)
        List<BottomSheetButton> getButtons();

        @AIBridgeParamField(keyPath = "content", required = true)
        String getContent();

        @AIBridgeParamField(keyPath = "title", required = true)
        String getTitle();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "action", required = true)
        void setAction(String r1);

        @AIBridgeParamField(keyPath = "role", required = false)
        void setRole(String r1);

        @AIBridgeParamField(keyPath = "source", required = false)
        void setSource(String r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsShowBottomSheetMethodIDL() {
        this.a = "doubao.showBottomSheet";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
