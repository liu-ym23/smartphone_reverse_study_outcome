package com.obric.livecard.api.entity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.island.IslandApi;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BË\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u000b\u0010O\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010W\u001a\u00020\u0006HÂ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010^\u001a\u00020\u0012HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0015HÆ\u0003JÔ\u0001\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020\u0006H\u0016J\u0013\u0010c\u001a\u00020\u00182\b\u0010d\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0013\u0010e\u001a\u0004\u0018\u00010\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u0006H\u0016J\u000e\u0010h\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010j\u001a\u00020iJ \u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001dJ \u0010p\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001aJ\"\u0010q\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010nH\u0002J\u000e\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020\u0012J\b\u0010t\u001a\u00020nH\u0016J\u000e\u0010u\u001a\u00020i2\u0006\u0010l\u001a\u00020\tJ\u0019\u0010v\u001a\u00020i2\u0006\u0010l\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020iJ\u0018\u0010y\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010-\"\u0004\b/\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0015\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b>\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010-\"\u0004\b@\u00100R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u00100R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00107\"\u0004\bL\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006{"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "version", "", "(ILandroid/os/Parcel;)V", "collapseWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "expandWidget", "nodeWidget", "notificationWidget", "intent", "Landroid/app/PendingIntent;", "callback", "Lcom/obric/livecard/api/IslandCardCallback;", "autoDismissDuration", "", "taskId", "type", "Lcom/obric/livecard/api/LiveCardType;", "currWidget", "canFrontShow", "", "ext", "Lcom/google/gson/JsonObject;", "flags", "sessionContext", "", "sceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "islandAutoDismissDuration", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)V", "getAutoDismissDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallback", "()Lcom/obric/livecard/api/IslandCardCallback;", "getCanFrontShow", "()Ljava/lang/Boolean;", "setCanFrontShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCollapseWidget", "()Lcom/obric/livecard/api/entity/IslandWidget;", "getCurrWidget", "setCurrWidget", "(Lcom/obric/livecard/api/entity/IslandWidget;)V", "getExpandWidget", "getExt", "()Lcom/google/gson/JsonObject;", "setExt", "(Lcom/google/gson/JsonObject;)V", "getFlags", "()J", "setFlags", "(J)V", "getIntent", "()Landroid/app/PendingIntent;", "setIntent", "(Landroid/app/PendingIntent;)V", "getIslandAutoDismissDuration", "getNodeWidget", "setNodeWidget", "getNotificationWidget", "setNotificationWidget", "getSceneEntity", "()Lcom/obric/livecard/api/entity/ISceneEntity;", "setSceneEntity", "(Lcom/obric/livecard/api/entity/ISceneEntity;)V", "getSessionContext", "()Ljava/lang/Object;", "setSessionContext", "(Ljava/lang/Object;)V", "getTaskId", "setTaskId", "getType", "()Lcom/obric/livecard/api/LiveCardType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)Lcom/obric/livecard/api/entity/IslandSession;", "describeContents", "equals", "other", "getPriority", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hashCode", "readFromParcel", "", "refreshScene", "sendAnyEvent", "targetWidget", "eventId", "", "data", "sendEvent", "sendEventInner", "setPriority", "priority", "toString", "update", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFlags", "writeToParcel", "CREATOR", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandSession implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final int MAGIC_CODE = 429261353;
    public static final int VERSION_CODE = 4;
    private final Long autoDismissDuration;
    private final IslandCardCallback callback;
    private Boolean canFrontShow;
    private final IslandWidget collapseWidget;
    private IslandWidget currWidget;
    private final IslandWidget expandWidget;
    private JsonObject ext;
    private long flags;
    private PendingIntent intent;
    private final Long islandAutoDismissDuration;
    private IslandWidget nodeWidget;
    private IslandWidget notificationWidget;
    private ISceneEntity sceneEntity;
    private Object sessionContext;
    private long taskId;
    private final LiveCardType type;
    private final int version;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/livecard/api/entity/IslandSession;", "()V", "MAGIC_CODE", "", "VERSION_CODE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/livecard/api/entity/IslandSession;", "parseSceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "json", "", "readVersion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<IslandSession> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        private final ISceneEntity parseSceneEntity(String r2) {
            return SceneEntityParser.INSTANCE.parse(r2);
        }

        private final int readVersion(Parcel r5) {
            int r0 = r5.dataPosition();
            int r1 = 0;
            r1 = 0;
        L8:
            r5.setDataPosition(r0);
        L9:
            return r1;
        L4:
            if (r5.readInt() != 429261353) goto L6;
            int r6 = r5.readInt();     // Catch: Exception -> L8
            r1 = r6;
            r5 = r6;
        L10:
            goto L9
        L6:
            r5.setDataPosition(r0);     // Catch: Exception -> L8
            r5 = r5;
            goto L10
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new IslandSession(r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession[] newArray(int r1) {
            return new IslandSession[r1];
        }

        public static final /* synthetic */ ISceneEntity access$parseSceneEntity(CREATOR r0, String r1) {
            return r0.parseSceneEntity(r1);
        }

        public static final /* synthetic */ int access$readVersion(CREATOR r0, Parcel r1) {
            return r0.readVersion(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public IslandSession() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, 131071, null);
    }

    private final int component17() {
        return this.version;
    }

    public static /* synthetic */ IslandSession copy$default(IslandSession r17, IslandWidget r18, IslandWidget r19, IslandWidget r20, IslandWidget r21, PendingIntent r22, IslandCardCallback r23, Long r24, long r25, LiveCardType r27, IslandWidget r28, Boolean r29, JsonObject r30, long r31, Object r33, ISceneEntity r34, Long r35, int r36, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        IslandWidget r2 = r17.collapseWidget;
    L7:
        if ((r37 & 2) == 0) goto L9;
        IslandWidget r3 = r17.expandWidget;
    L11:
        if ((r37 & 4) == 0) goto L13;
        IslandWidget r4 = r17.nodeWidget;
    L15:
        if ((r37 & 8) == 0) goto L17;
        IslandWidget r5 = r17.notificationWidget;
    L19:
        if ((r37 & 16) == 0) goto L21;
        PendingIntent r6 = r17.intent;
    L23:
        if ((r37 & 32) == 0) goto L25;
        IslandCardCallback r7 = r17.callback;
    L27:
        if ((r37 & 64) == 0) goto L29;
        Long r8 = r17.autoDismissDuration;
    L31:
        if ((r37 & 128) == 0) goto L33;
        long r9 = r17.taskId;
    L35:
        if ((r37 & ISmModel.VERSION_0100) == 0) goto L37;
        LiveCardType r11 = r17.type;
    L39:
        if ((r37 & ISmModel.VERSION_0200) == 0) goto L41;
        IslandWidget r12 = r17.currWidget;
    L43:
        if ((r37 & ISmModel.VERSION_0400) == 0) goto L45;
        Boolean r13 = r17.canFrontShow;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        JsonObject r14 = r17.ext;
    L50:
        JsonObject r32 = r14;
        if ((r37 & 4096) == 0) goto L53;
        long r15 = r17.flags;
    L54:
        long r39 = r15;
        if ((r37 & 8192) == 0) goto L57;
        Object r16 = r17.sessionContext;
    L59:
        if ((r37 & 16384) == 0) goto L61;
        ISceneEntity r110 = r17.sceneEntity;
    L62:
        ISceneEntity r310 = r110;
        if ((r37 & 32768) == 0) goto L65;
        Long r111 = r17.islandAutoDismissDuration;
    L67:
        if ((r37 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        int r1 = r17.version;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r32, r39, r16, r310, r111, r1);
    L69:
        r1 = r36;
        goto L71
    L65:
        r111 = r35;
        goto L67
    L61:
        r110 = r34;
        goto L62
    L57:
        r16 = r33;
        goto L59
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L50
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final IslandWidget component1() {
        return this.collapseWidget;
    }

    public final IslandWidget component10() {
        return this.currWidget;
    }

    public final Boolean component11() {
        return this.canFrontShow;
    }

    public final JsonObject component12() {
        return this.ext;
    }

    public final long component13() {
        return this.flags;
    }

    public final Object component14() {
        return this.sessionContext;
    }

    public final ISceneEntity component15() {
        return this.sceneEntity;
    }

    public final Long component16() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget component2() {
        return this.expandWidget;
    }

    public final IslandWidget component3() {
        return this.nodeWidget;
    }

    public final IslandWidget component4() {
        return this.notificationWidget;
    }

    public final PendingIntent component5() {
        return this.intent;
    }

    public final IslandCardCallback component6() {
        return this.callback;
    }

    public final Long component7() {
        return this.autoDismissDuration;
    }

    public final long component8() {
        return this.taskId;
    }

    public final LiveCardType component9() {
        return this.type;
    }

    public final IslandSession copy(IslandWidget r22, IslandWidget r23, IslandWidget r24, IslandWidget r25, PendingIntent r26, IslandCardCallback r27, Long r28, long r29, LiveCardType r31, IslandWidget r32, Boolean r33, JsonObject r34, long r35, Object r37, ISceneEntity r38, Long r39, int r40) {
        return new IslandSession(r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r37, r38, r39, r40);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        long r0 = this.taskId;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final void refreshScene() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        IslandApi r1 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.refreshScene(this);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public String toString() {
        return "IslandSession(collapseWidget=" + this.collapseWidget + ", expandWidget=" + this.expandWidget + ", nodeWidget=" + this.nodeWidget + ", notificationWidget=" + this.notificationWidget + ", intent=" + this.intent + ", autoDismissDuration=" + this.autoDismissDuration + ", islandAutoDismissDuration=" + this.islandAutoDismissDuration + ", taskId=" + this.taskId + ", type=" + this.type + ", currWidget=" + this.currWidget + ", canFontShow=" + this.canFrontShow + ", flags=" + this.flags + ", sceneEntity=" + this.sceneEntity + ')';
    }

    public final void updateFlags() {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateSessionFlags(this);
        return;
    }

    public final Long getAutoDismissDuration() {
        return this.autoDismissDuration;
    }

    public final IslandCardCallback getCallback() {
        return this.callback;
    }

    public final Boolean getCanFrontShow() {
        return this.canFrontShow;
    }

    public final IslandWidget getCollapseWidget() {
        return this.collapseWidget;
    }

    public final IslandWidget getCurrWidget() {
        return this.currWidget;
    }

    public final IslandWidget getExpandWidget() {
        return this.expandWidget;
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final long getFlags() {
        return this.flags;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final Long getIslandAutoDismissDuration() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget getNodeWidget() {
        return this.nodeWidget;
    }

    public final IslandWidget getNotificationWidget() {
        return this.notificationWidget;
    }

    public final ISceneEntity getSceneEntity() {
        return this.sceneEntity;
    }

    public final Object getSessionContext() {
        return this.sessionContext;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final LiveCardType getType() {
        return this.type;
    }

    public IslandSession(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this(CREATOR.access$readVersion(CREATOR, r2), r2);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(IslandSession.class, r2) == true) goto L13;
        return false;
    L13:
        if (this.taskId != 0) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.livecard.api.entity.IslandSession");
        if (this.taskId == ((IslandSession) r8).taskId) goto L20;
        return false;
    L20:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final Object getPriority(Continuation<? super Long> r2) throws IllegalStateException, IslandUnsupportedException {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPriority(this, r2);
    }

    public final void readFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        CREATOR r0 = CREATOR;
        int r1 = CREATOR.access$readVersion(r0, r7);
        r7.readParcelable(IslandWidget.class.getClassLoader());
        r7.readParcelable(IslandWidget.class.getClassLoader());
        r7.readParcelable(PendingIntent.class.getClassLoader());
        Class r2 = Long.TYPE;
        Object r3 = r7.readValue(r2.getClassLoader());
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L5:
        this.taskId = r7.readLong();
        r7.readString();
        r7.readBoolean();
        String r5 = r7.readString();
        if (r5 == null) goto L8;
        JsonObject r6 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r5, JsonObject.class);
    L9:
        this.ext = r6;
        if (r1 < 1) goto L13;
        r7.readLong();
    L13:
        if (r1 < 2) goto L16;
        r7.readParcelable(IslandWidget.class.getClassLoader());
        this.sceneEntity = CREATOR.access$parseSceneEntity(r0, r7.readString());
    L16:
        if (r1 < 3) goto L19;
        r7.readParcelable(IslandWidget.class.getClassLoader());
    L19:
        if (r1 < 4) goto L24;
        Object r8 = r7.readValue(r2.getClassLoader());
        if ((r8 instanceof Long) == false) goto L25;
        Long r9 = (Long) r8;
        return;
    L25:
        return;
    L24:
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void setCanFrontShow(Boolean r1) {
        this.canFrontShow = r1;
    }

    public final void setCurrWidget(IslandWidget r1) {
        this.currWidget = r1;
    }

    public final void setExt(JsonObject r1) {
        this.ext = r1;
    }

    public final void setFlags(long r1) {
        this.flags = r1;
    }

    public final void setIntent(PendingIntent r1) {
        this.intent = r1;
    }

    public final void setNodeWidget(IslandWidget r1) {
        this.nodeWidget = r1;
    }

    public final void setNotificationWidget(IslandWidget r1) {
        this.notificationWidget = r1;
    }

    public final void setPriority(long r2) throws IllegalArgumentException, IslandUnsupportedException {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.setPriority(this, r2);
        return;
    }

    public final void setSceneEntity(ISceneEntity r1) {
        this.sceneEntity = r1;
    }

    public final void setSessionContext(Object r1) {
        this.sessionContext = r1;
    }

    public final void setTaskId(long r1) {
        this.taskId = r1;
    }

    public final void update(IslandWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "targetWidget");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateWidget(this, r2);
        return;
    }

    private IslandSession(int r24, Parcel r25) {
        IslandWidget r1 = (IslandWidget) r25.readParcelable(IslandWidget.class.getClassLoader());
        IslandWidget r2 = (IslandWidget) r25.readParcelable(IslandWidget.class.getClassLoader());
        PendingIntent r5 = (PendingIntent) r25.readParcelable(PendingIntent.class.getClassLoader());
        Class r3 = Long.TYPE;
        Object r4 = r25.readValue(r3.getClassLoader());
        if ((r4 instanceof Long) == false) goto L5;
        Long r8 = (Long) r4;
    L6:
        long r9 = r25.readLong();
        LiveCardType.Companion r6 = LiveCardType.Companion;
        String r7 = r25.readString();
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        LiveCardType r13 = r6.fromString(r7);
        boolean r10 = r25.readBoolean();
        String r11 = r25.readString();
        if (r11 == null) goto L12;
        JsonObject r15 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r11, JsonObject.class);
    L14:
        if (r24 < 1) goto L16;
        long r12 = r25.readLong();
    L17:
        long r17 = r12;
        if (r24 < 2) goto L20;
        IslandWidget r19 = IslandSessionEntityKt.readWidgetFromParcel(r25);
    L21:
        if (r24 < 2) goto L23;
        ISceneEntity r20 = CREATOR.access$parseSceneEntity(CREATOR, r25.readString());
    L25:
        if (r24 < 3) goto L27;
        IslandWidget r21 = IslandSessionEntityKt.readWidgetFromParcel(r25);
    L29:
        if (r24 < 4) goto L33;
        Object r0 = r25.readValue(r3.getClassLoader());
        if ((r0 instanceof Long) == false) goto L33;
        Long r22 = (Long) r0;
    L34:
        this(r1, r2, r19, r21, r5, null, r8, r9, r13, null, Boolean.valueOf(r10), r15, r17, null, r20, r22, r24);
        return;
    L33:
        r22 = null;
        goto L34
    L27:
        r21 = null;
        goto L29
    L23:
        r20 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r15 = null;
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    public final Object updateAnimation(IslandWidget r2, Continuation<? super Unit> r3) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L10;
        Object r4 = r0.updateAnimation(this, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        boolean r0 = false;
        if (1 != r8) goto L5;
        int r2 = this.version;
    L10:
        if (r2 <= 0) goto L12;
        r7.writeInt(MAGIC_CODE);
        r7.writeInt(4);
    L12:
        r7.writeParcelable(this.collapseWidget, r8);
        r7.writeParcelable(this.expandWidget, r8);
        r7.writeParcelable(this.intent, r8);
        r7.writeValue(this.autoDismissDuration);
        r7.writeLong(this.taskId);
        LiveCardType r4 = this.type;
        String r5 = null;
        if (r4 == null) goto L15;
        String r6 = r4.name();
    L16:
        r7.writeString(r6);
        Boolean r9 = this.canFrontShow;
        if (r9 == null) goto L19;
        r0 = r9.booleanValue();
    L19:
        r7.writeBoolean(r0);
        JsonObject r1 = this.ext;
        if (r1 == null) goto L22;
        String r3 = GsonProtectorUtils.toJson(new Gson(), r1);
    L23:
        r7.writeString(r3);
        if (r2 < 1) goto L27;
        r7.writeLong(this.flags);
    L27:
        if (r2 < 2) goto L33;
        r7.writeParcelable(this.nodeWidget, r8);
        ISceneEntity r10 = this.sceneEntity;
        if (r10 == null) goto L31;
        r5 = GsonProtectorUtils.toJson(SceneEntityParser.INSTANCE.getGson(), r10);
    L31:
        r7.writeString(r5);
    L33:
        if (r2 < 3) goto L35;
        r7.writeParcelable(this.notificationWidget, r8);
    L35:
        if (r2 < 4) goto L38;
        r7.writeValue(this.islandAutoDismissDuration);
        return;
    L38:
        return;
    L22:
        r3 = null;
        goto L23
    L15:
        r6 = null;
        goto L16
    L5:
        IslandApi r11 = ILiveCard.Companion.getInst().getIslandService();
        if (r11 == null) goto L8;
        r2 = r11.getIslandVersion();
        goto L10
    L8:
        r2 = 0;
        goto L10
    }

    private final void sendEventInner(IslandWidget r2, String r3, String r4) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.sendEvent(this, r2, r3, r4);
        return;
    }

    public final void sendAnyEvent(IslandWidget r3, String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "targetWidget");
        Intrinsics.checkNotNullParameter(r4, "eventId");
        String r1 = null;
        if ((r5 instanceof JsonObject) == false) goto L5;
        JsonObject r0 = (JsonObject) r5;
    L6:
        if (r0 == null) goto L10;
        sendEvent(r3, r4, r0);
        return;
    L10:
        if ((r5 instanceof String) == false) goto L12;
        String r2 = (String) r5;
    L13:
        if (r2 == null) goto L16;
        sendEventInner(r3, r4, r2);
        return;
    L16:
        if (r5 == null) goto L18;
        r1 = GsonProtectorUtils.toJson(new Gson(), r5);
    L18:
        sendEventInner(r3, r4, r1);
        return;
    L12:
        r2 = null;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void sendEvent(IslandWidget r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "targetWidget");
        Intrinsics.checkNotNullParameter(r3, "eventId");
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        sendEventInner(r2, r3, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public IslandSession(IslandWidget r4, IslandWidget r5, IslandWidget r6, IslandWidget r7, PendingIntent r8, IslandCardCallback r9, Long r10, long r11, LiveCardType r13, IslandWidget r14, Boolean r15, JsonObject r16, long r17, Object r19, ISceneEntity r20, Long r21, int r22) {
        this.collapseWidget = r4;
        this.expandWidget = r5;
        this.nodeWidget = r6;
        this.notificationWidget = r7;
        this.intent = r8;
        this.callback = r9;
        this.autoDismissDuration = r10;
        this.taskId = r11;
        this.type = r13;
        this.currWidget = r14;
        this.canFrontShow = r15;
        this.ext = r16;
        this.flags = r17;
        this.sessionContext = r19;
        this.sceneEntity = r20;
        this.islandAutoDismissDuration = r21;
        this.version = r22;
    }

    public /* synthetic */ IslandSession(IslandWidget r21, IslandWidget r22, IslandWidget r23, IslandWidget r24, PendingIntent r25, IslandCardCallback r26, Long r27, long r28, LiveCardType r30, IslandWidget r31, Boolean r32, JsonObject r33, long r34, Object r36, ISceneEntity r37, Long r38, int r39, int r40, DefaultConstructorMarker r41) {
        if ((r40 & 1) == 0) goto L5;
        IslandWidget r1 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        IslandWidget r3 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        IslandWidget r4 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        IslandWidget r5 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        PendingIntent r6 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        IslandCardCallback r7 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        long r12 = 0;
    L35:
        if ((r40 & ISmModel.VERSION_0100) == 0) goto L37;
        LiveCardType r9 = null;
    L39:
        if ((r40 & ISmModel.VERSION_0200) == 0) goto L41;
        IslandWidget r14 = null;
    L43:
        if ((r40 & ISmModel.VERSION_0400) == 0) goto L45;
        Boolean r15 = Boolean.FALSE;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        JsonObject r2 = null;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        long r10 = 0;
    L54:
        long r16 = r10;
        if ((r40 & 8192) == 0) goto L57;
        Object r11 = null;
    L59:
        if ((r40 & 16384) == 0) goto L61;
        ISceneEntity r13 = null;
    L63:
        if ((r40 & 32768) == 0) goto L65;
        Long r18 = null;
    L67:
        if ((r40 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        int r0 = 4;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r12, r9, r14, r15, r2, r16, r11, r13, r18, r0);
        return;
    L69:
        r0 = r39;
        goto L70
    L65:
        r18 = r38;
        goto L67
    L61:
        r13 = r37;
        goto L63
    L57:
        r11 = r36;
        goto L59
    L53:
        r10 = r34;
        goto L54
    L49:
        r2 = r33;
        goto L51
    L45:
        r15 = r32;
        goto L47
    L41:
        r14 = r31;
        goto L43
    L37:
        r9 = r30;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r8 = r27;
        goto L31
    L25:
        r7 = r26;
        goto L27
    L21:
        r6 = r25;
        goto L23
    L17:
        r5 = r24;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }
}
