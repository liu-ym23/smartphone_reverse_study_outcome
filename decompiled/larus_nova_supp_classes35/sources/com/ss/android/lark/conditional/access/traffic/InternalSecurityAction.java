package com.ss.android.lark.conditional.access.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\t\u0010%\u001a\u00020&H\u0096\u0001J\t\u0010'\u001a\u00020&H\u0096\u0001J\t\u0010(\u001a\u00020&H\u0096\u0001J\u0016\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010-\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ISecurityAction;", "securityAction", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/SecurityAction;", "currentAction", "Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "actions", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/SecurityAction;Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;Ljava/util/List;)V", "getCurrentAction", "()Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "setCurrentAction", "(Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "internalParams", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getInternalParams", "()Ljava/util/Map;", "setInternalParams", "(Ljava/util/Map;)V", "handleContext", "Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "getHandleContext", "()Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "toString", "parseToPrint", "getTraceId", "getSource", BuildConfig.FLAVOR, "describeContents", "onDialogDismiss", BuildConfig.FLAVOR, "onPrimaryButtonClick", "onSecondButtonClick", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "rawActions", "getRawActions", "()Ljava/lang/String;", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InternalSecurityAction implements Parcelable, ISecurityAction {
    public static final Parcelable.Creator<InternalSecurityAction> CREATOR = null;
    private List<DecisionData.Action> actions;
    private DecisionData.Action currentAction;

    @SerializedName("internalParams")
    private Map<String, Object> internalParams;
    private final SecurityAction securityAction;

    public static final class a implements Parcelable.Creator<InternalSecurityAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InternalSecurityAction createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            SecurityAction r0 = r7.readParcelable(InternalSecurityAction.class.getClassLoader());
            DecisionData.Action r1 = (DecisionData.Action) r7.readSerializable();
            int r2 = r7.readInt();
            ArrayList r3 = new ArrayList(r2);
            int r4 = 0;
        L3:
            if (r4 == r2) goto L6;
            r3.add(r7.readSerializable());
            r4 = r4 + 1;
            goto L3
        L6:
            return new InternalSecurityAction(r0, r1, r3);
        }

        @Override // android.os.Parcelable.Creator
        public final InternalSecurityAction[] newArray(int r1) {
            return new InternalSecurityAction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getRawActions() {
        return this.securityAction.getRawActions();
    }

    public void onDialogDismiss() {
        this.securityAction.onDialogDismiss();
    }

    public void onPrimaryButtonClick() {
        this.securityAction.onPrimaryButtonClick();
    }

    public void onSecondButtonClick() {
        this.securityAction.onSecondButtonClick();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeParcelable(this.securityAction, r3);
        r2.writeSerializable(this.currentAction);
        List<DecisionData.Action> r4 = this.actions;
        r2.writeInt(r4.size());
        Iterator<DecisionData.Action> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r2.writeSerializable(r5.next());
        goto L4
    }

    public final SecurityActionHandleContext getHandleContext() {
        return this.securityAction.getHandleContext();
    }

    public final int getSource() {
        Object r0 = this.internalParams.get("SDK_ACTION_SOURCE");
        if ((r0 instanceof Integer) == false) goto L5;
        Integer r1 = (Integer) r0;
    L6:
        if (r1 == null) goto L9;
        return r1.intValue();
    L9:
        return this.securityAction.source;
    L5:
        r1 = null;
        goto L6
    }

    public final String getTraceId() {
        return this.securityAction.getTraceId();
    }

    public final String parseToPrint() {
        return toString();
    }

    public String toString() {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this);
    }

    public final List<DecisionData.Action> getActions() {
        return this.actions;
    }

    public final DecisionData.Action getCurrentAction() {
        return this.currentAction;
    }

    public final Map<String, Object> getInternalParams() {
        return this.internalParams;
    }

    public final void setActions(List<DecisionData.Action> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.actions = r2;
    }

    public final void setCurrentAction(DecisionData.Action r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentAction = r2;
    }

    public final void setInternalParams(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.internalParams = r2;
    }

    public InternalSecurityAction(SecurityAction r2, DecisionData.Action r3, List<DecisionData.Action> r4) {
        Intrinsics.checkNotNullParameter(r2, "securityAction");
        Intrinsics.checkNotNullParameter(r3, "currentAction");
        Intrinsics.checkNotNullParameter(r4, "actions");
        this.securityAction = r2;
        this.currentAction = r3;
        this.actions = r4;
        this.internalParams = new LinkedHashMap();
    }
}
