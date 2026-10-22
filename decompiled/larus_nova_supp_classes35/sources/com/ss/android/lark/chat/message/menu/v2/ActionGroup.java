package com.ss.android.lark.chat.message.menu.v2;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/ActionGroup;", BuildConfig.FLAVOR, "actionList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "childActionMap", BuildConfig.FLAVOR, "arrangement", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getActionList", "()Ljava/util/List;", "getChildActionMap", "()Ljava/util/Map;", "getArrangement", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionGroup {

    @SerializedName("action_list")
    private final List<String> actionList;

    @SerializedName("arrangement")
    private final String arrangement;

    @SerializedName("child_action_map")
    private final Map<String, List<String>> childActionMap;

    public ActionGroup() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionGroup copy$default(ActionGroup r0, List r1, Map r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.actionList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.childActionMap;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.arrangement;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<String> component1() {
        return this.actionList;
    }

    public final Map<String, List<String>> component2() {
        return this.childActionMap;
    }

    public final String component3() {
        return this.arrangement;
    }

    public final ActionGroup copy(List<String> r2, Map<String, ? extends List<String>> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "actionList");
        Intrinsics.checkNotNullParameter(r3, "childActionMap");
        Intrinsics.checkNotNullParameter(r4, "arrangement");
        return new ActionGroup(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionGroup) == true) goto L8;
        return false;
    L8:
        ActionGroup r6 = (ActionGroup) r5;
        if (Intrinsics.areEqual(this.actionList, r6.actionList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.childActionMap, r6.childActionMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.arrangement, r6.arrangement) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.actionList.hashCode() * 31) + this.childActionMap.hashCode()) * 31) + this.arrangement.hashCode();
    }

    public String toString() {
        return "ActionGroup(actionList=" + this.actionList + ", childActionMap=" + this.childActionMap + ", arrangement=" + this.arrangement + ')';
    }

    public final List<String> getActionList() {
        return this.actionList;
    }

    public final String getArrangement() {
        return this.arrangement;
    }

    public final Map<String, List<String>> getChildActionMap() {
        return this.childActionMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionGroup(List<String> r2, Map<String, ? extends List<String>> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "actionList");
        Intrinsics.checkNotNullParameter(r3, "childActionMap");
        Intrinsics.checkNotNullParameter(r4, "arrangement");
        this.actionList = r2;
        this.childActionMap = r3;
        this.arrangement = r4;
    }

    public /* synthetic */ ActionGroup(List r1, Map r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = MapsKt.emptyMap();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "grid";
    L11:
        this(r1, r2, r3);
    }
}
