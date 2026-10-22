package com.obric.assistant.card.bean;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000fHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0003J\u0085\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R%\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/assistant/card/bean/HybridAppEntityMessage;", "Ljava/io/Serializable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", NameKeys.UnloadStrategy_No_Strategy, "needConfirm", "confirmNlg", NameKeys.UnloadStrategy_No_Strategy, "refuseNlg", "isPaused", "showRecentContact", LynxResourceModule.DATA_KEY, "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlin/collections/ArrayList;", "ext", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/util/ArrayList;Ljava/util/Map;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "()Z", "getNeedConfirm", "getConfirmNlg", "()Ljava/lang/String;", "getRefuseNlg", "getShowRecentContact", "getData", "()Ljava/util/ArrayList;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HybridAppEntityMessage implements Serializable {
    private final String confirmNlg;
    private final ArrayList<? extends AppEntity> data;
    private final DataSource dataSource;
    private final Map<String, String> ext;
    private final boolean isEnable;
    private final boolean isPaused;
    private final boolean needConfirm;
    private final String refuseNlg;
    private final boolean showRecentContact;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HybridAppEntityMessage copy$default(HybridAppEntityMessage r10, DataSource r11, boolean r12, boolean r13, String r14, String r15, boolean r16, boolean r17, ArrayList r18, Map r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        DataSource r2 = r10.dataSource;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.isEnable;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.needConfirm;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.confirmNlg;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.refuseNlg;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.isPaused;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.showRecentContact;
    L31:
        if ((r20 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        ArrayList r9 = r10.data;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Map r1 = r10.ext;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final String component4() {
        return this.confirmNlg;
    }

    public final String component5() {
        return this.refuseNlg;
    }

    public final boolean component6() {
        return this.isPaused;
    }

    public final boolean component7() {
        return this.showRecentContact;
    }

    public final ArrayList<? extends AppEntity> component8() {
        return this.data;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final HybridAppEntityMessage copy(DataSource r12, boolean r13, boolean r14, String r15, String r16, boolean r17, boolean r18, ArrayList<? extends AppEntity> r19, Map<String, String> r20) {
        Intrinsics.checkNotNullParameter(r12, "dataSource");
        Intrinsics.checkNotNullParameter(r15, "confirmNlg");
        Intrinsics.checkNotNullParameter(r16, "refuseNlg");
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.DATA_KEY);
        return new HybridAppEntityMessage(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HybridAppEntityMessage) == true) goto L8;
        return false;
    L8:
        HybridAppEntityMessage r6 = (HybridAppEntityMessage) r5;
        if (Intrinsics.areEqual(this.dataSource, r6.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r6.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r6.needConfirm) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmNlg, r6.confirmNlg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refuseNlg, r6.refuseNlg) == true) goto L24;
        return false;
    L24:
        if (this.isPaused == r6.isPaused) goto L27;
        return false;
    L27:
        if (this.showRecentContact == r6.showRecentContact) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.dataSource.hashCode() * 31;
        int r2 = 1231;
        if (this.isEnable == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.needConfirm == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((r3 + r4) * 31) + this.confirmNlg.hashCode()) * 31) + this.refuseNlg.hashCode()) * 31;
        if (this.isPaused == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.showRecentContact == true) goto L18;
        r2 = 1237;
    L18:
        int r8 = (((r7 + r2) * 31) + this.data.hashCode()) * 31;
        Map<String, String> r9 = this.ext;
        if (r9 != null) goto L21;
        int r10 = 0;
    L23:
        return r8 + r10;
    L21:
        r10 = r9.hashCode();
        goto L23
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "HybridAppEntityMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", confirmNlg=" + this.confirmNlg + ", refuseNlg=" + this.refuseNlg + ", isPaused=" + this.isPaused + ", showRecentContact=" + this.showRecentContact + ", data=" + this.data + ", ext=" + this.ext + ')';
    }

    public final String getConfirmNlg() {
        return this.confirmNlg;
    }

    public final ArrayList<? extends AppEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getRefuseNlg() {
        return this.refuseNlg;
    }

    public final boolean getShowRecentContact() {
        return this.showRecentContact;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public HybridAppEntityMessage(DataSource r2, boolean r3, boolean r4, String r5, String r6, boolean r7, boolean r8, ArrayList<? extends AppEntity> r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r5, "confirmNlg");
        Intrinsics.checkNotNullParameter(r6, "refuseNlg");
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.DATA_KEY);
        this.dataSource = r2;
        this.isEnable = r3;
        this.needConfirm = r4;
        this.confirmNlg = r5;
        this.refuseNlg = r6;
        this.isPaused = r7;
        this.showRecentContact = r8;
        this.data = r9;
        this.ext = r10;
    }

    public /* synthetic */ HybridAppEntityMessage(DataSource r9, boolean r10, boolean r11, String r12, String r13, boolean r14, boolean r15, ArrayList r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 2) == 0) goto L5;
        boolean r1 = true;
    L6:
        boolean r3 = false;
        if ((r18 & 4) == 0) goto L9;
        boolean r2 = false;
    L10:
        int r4 = r18 & 8;
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 == 0) goto L13;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        if ((r18 & 16) != 0) goto L19;
        r5 = r13;
    L19:
        if ((r18 & 32) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r18 & 64) != 0) goto L27;
        r3 = r15;
    L27:
        if ((r18 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L29;
        ArrayList r8 = new ArrayList();
    L31:
        if ((r18 & 256) == 0) goto L33;
        Map r0 = null;
    L34:
        this(r9, r1, r2, r6, r5, r7, r3, r8, r0);
        return;
    L33:
        r0 = r17;
        goto L34
    L29:
        r8 = r16;
        goto L31
    L21:
        r7 = r14;
        goto L23
    L13:
        r6 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L6
    }
}
